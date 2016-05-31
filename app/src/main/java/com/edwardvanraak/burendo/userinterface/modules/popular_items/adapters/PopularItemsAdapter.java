package com.edwardvanraak.burendo.userinterface.modules.popular_items.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.edwardvanraak.burendo.R;
import com.edwardvanraak.burendo.userinterface.components.ItemComponent;
import com.edwardvanraak.burendo.userinterface.modules.advertising.models.AdvertisementsItemEntry;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.callbacks.OnPopularItemSelectedListener;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.models.PopularItemEntry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static junit.framework.Assert.assertNotNull;

public class PopularItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemComponent> components = new ArrayList<>();

    private OnPopularItemSelectedListener onPopularItemSelectedListener;

    public PopularItemsAdapter(OnPopularItemSelectedListener onPopularItemSelectedListener) {
        this.onPopularItemSelectedListener = onPopularItemSelectedListener;
    }

    public void addComponent(ItemComponent component){
        assertNotNull(component);
        components.add(component);
        notifyDataSetChanged();
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

    public static class AdvertisementEntryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.dummyText)TextView dummyText;

        public AdvertisementEntryViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public static class PopularItemEntryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.popularItemTitle)TextView title;

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
            bindPopularItemEntry(popularItemEntry, popularItemEntryViewHolder);
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

    private void bindPopularItemEntry(PopularItemEntry popularItemEntry, PopularItemEntryViewHolder popularItemEntryViewHolder) {
        //TODO:
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