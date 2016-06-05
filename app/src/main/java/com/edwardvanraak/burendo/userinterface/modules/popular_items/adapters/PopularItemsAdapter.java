package com.edwardvanraak.burendo.userinterface.modules.popular_items.adapters;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.edwardvanraak.burendo.R;
import com.edwardvanraak.burendo.userinterface.components.ItemComponent;
import com.edwardvanraak.burendo.userinterface.modules.advertising.models.AdvertisementsItemEntry;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.callbacks.OnPopularItemSelectedListener;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.models.PopularItemEntry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopularItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemComponent> components = new ArrayList<>();

    private OnPopularItemSelectedListener onPopularItemSelectedListener;

    private Object lock = new Object();

    public PopularItemsAdapter(OnPopularItemSelectedListener onPopularItemSelectedListener) {
        this.onPopularItemSelectedListener = onPopularItemSelectedListener;
    }

    public void addComponent(ItemComponent component){
        synchronized (lock) {
            components.add(component);
        }
    }

    public void notifyRangeAdded(){
        notifyItemRangeInserted(0, getItemCount());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case ItemComponent.COMPONENT_TYPE_POPULAR_ENTRY:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item_entry, parent, false);
                return new PopularItemEntryViewHolder(view);
            case ItemComponent.COMPONENT_TYPE_ADVERTISEMENT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.advertisement_item_entry, parent, false);
                return new AdvertisementEntryViewHolder(view);
            default:
                return null;
        }
    }

    public void clear() {
        components.clear();
        notifyDataSetChanged();
    }

    public static class AdvertisementEntryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dummyText)TextView dummyText;

        public AdvertisementEntryViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static class PopularItemEntryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_view)CardView container;
        @BindView(R.id.popularItemTitle)TextView title;
        @BindView(R.id.popularItemContent)TextView content;
        @BindView(R.id.topicImage)ImageView image;
        @BindView(R.id.publisherIcon)ImageView publisherIcon;
        @BindView(R.id.priceTag)TextView priceTag;

        boolean hideImage = false;

        public PopularItemEntryViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemComponent itemComponent = getDataByPosition(position);
        if(holder instanceof PopularItemEntryViewHolder){
            PopularItemEntry popularItemEntry = (PopularItemEntry)itemComponent;
            PopularItemEntryViewHolder popularItemEntryViewHolder = (PopularItemEntryViewHolder)holder;
            bindPopularItemEntry(popularItemEntry, popularItemEntryViewHolder, position);
        }
        else if(itemComponent instanceof AdvertisementsItemEntry){
            AdvertisementsItemEntry advertisementsItemEntry = (AdvertisementsItemEntry)itemComponent;
            AdvertisementEntryViewHolder advertisementEntryViewHolder = (AdvertisementEntryViewHolder) holder;
            bindAdvertisementEntry(advertisementsItemEntry , advertisementEntryViewHolder);
        }
    }

    private void bindAdvertisementEntry(final AdvertisementsItemEntry advertisementsItemEntry, final AdvertisementEntryViewHolder advertisementEntryViewHolder) {
        advertisementEntryViewHolder.dummyText.setText(advertisementsItemEntry.getText());
    }

    private void bindPopularItemEntry(final PopularItemEntry popularItemEntry, final PopularItemEntryViewHolder holder, final int position) {
        holder.image.setVisibility(View.VISIBLE);
        holder.title.setText(Html.fromHtml(popularItemEntry.getTitle()));
        holder.content.setText(Html.fromHtml(popularItemEntry.getContent()));
        holder.priceTag.setText(popularItemEntry.getPrice());
        Glide.with(holder.publisherIcon.getContext()).load(popularItemEntry.getPublisherIconURL()).into(holder.publisherIcon);
        Glide.with(holder.image.getContext()).load(popularItemEntry.getContentImageURL()).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                holder.image.setVisibility(View.GONE);
                return false;
            }
            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).into(holder.image);
        ViewCompat.setTransitionName(holder.image, String.valueOf(position) + "_image"); //Unique identifier
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPopularItemSelectedListener.onPopularItemSelected(holder, popularItemEntry);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        ItemComponent component = getDataByPosition(position);
        return component.getViewType();
    }

    @Override
    public int getItemCount() {
        return components.size();
    }

    private ItemComponent getDataByPosition(int position) {
        return components.get(position);
    }

    public void clean(){
        onPopularItemSelectedListener = null;
    }
}
