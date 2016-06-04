package com.edwardvanraak.burendo.userinterface.modules.popular_items.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edwardvanraak.burendo.R;
import com.edwardvanraak.burendo.communication.ApiConstants;
import com.edwardvanraak.burendo.communication.BlendleAPI;
import com.edwardvanraak.burendo.domain.pojo.data.popular_items.Item;
import com.edwardvanraak.burendo.domain.pojo.data.popular_items.PopularItems;
import com.edwardvanraak.burendo.services.ApiLinkService;
import com.edwardvanraak.burendo.userinterface.modules.advertising.models.AdvertisementsItemEntry;
import com.edwardvanraak.burendo.userinterface.modules.item_content.ItemContentFragment;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.adapters.PopularItemsAdapter;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.callbacks.OnPopularItemSelectedListener;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.models.PopularItemEntry;
import com.edwardvanraak.burendo.utility.ContentTransition;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Fragment containing popular items of Blendle.
 */
public class PopularItemsFragment extends Fragment implements OnPopularItemSelectedListener {

    private static final String TAG = PopularItemsFragment.class.getCanonicalName();

    @BindView(R.id.popularItemsRecyclerView) RecyclerView recyclerView;
    @BindView(R.id.popularItemsSwipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;

    private PopularItemsAdapter adapter;
    private LinearLayoutManager layoutManager;

    private CompositeSubscription compositeSubscription;

    private ApiLinkService linkService = new ApiLinkService();

    public PopularItemsFragment() {
        // Required empty public constructor
    }

    public static PopularItemsFragment newInstance() {
        PopularItemsFragment fragment = new PopularItemsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        compositeSubscription = new CompositeSubscription();
        View rootView = inflater.inflate(R.layout.fragment_popular_items, container, false);
        ButterKnife.bind(this, rootView);
        prepareRecyclerView();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.clear();
                updatePopularItems();
            }
        });
        updatePopularItems();
        return rootView;
    }

    private void updatePopularItems() {
        compositeSubscription.add(linkService.fetchAPIUrl(ApiLinkService.LINK_POPULAR_ITEMS).observeOn(AndroidSchedulers.mainThread())
                .debounce(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {}
                    @Override
                    public void onError(Throwable error) {
                        handleError(error);
                    }
                    @Override
                    public void onNext(String url) {
                        fetchPopularItems(url);
                    }
                }));
    }

    public void fetchPopularItems(String url){
        Observable<PopularItems> call = BlendleAPI.Factory.getInstance().getPopularItems(url);
        compositeSubscription.add(call.observeOn(AndroidSchedulers.mainThread())
                .debounce(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<PopularItems>() {
                    @Override
                    public void onCompleted() {}
                    @Override
                    public void onError(Throwable error) {
                        handleError(error);
                    }
                    @Override
                    public void onNext(PopularItems popularItems) {
                        addPopularItemsWithRandomAdvertisements(popularItems);
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }));
    }

    private void addPopularItemsWithRandomAdvertisements(PopularItems popularItems) {
        for(Item item : popularItems.getResources().getItems()){
            String largeImageURL = item.getLargeImageHref();
            adapter.addComponent(new PopularItemEntry()
                    .withContentImageURL(largeImageURL)
                    .withContent(item.getUnformattedContent())
                    .withPriceTag("€ "+ item.getPrice().replace(".",",")) //Just ignore the fact that we can have different types of currency for now...
                    .withPublisherIconURL(ApiConstants.getPublisherIcon(item.getEmbedded().getManifest().getProvider().getId()))
                    .withTitle(item.findUniqueContentByType(ApiConstants.CONTENT_TYPE_MAIN_HEADLINE)));
            /**
             * 50/50 chance for a random advertisement after this article
             */
            if(Math.random() < 0.5){
                adapter.addComponent(new AdvertisementsItemEntry());
            }
        }
    }

    private void handleError(Throwable error) {
        swipeRefreshLayout.setRefreshing(false);
        if (error instanceof HttpException) {
            HttpException response = (HttpException) error;
            int code = response.code();
            Log.d(TAG, "Error retrieving popular items code: " + code);
        } else {
            error.printStackTrace();
        }
    }

    private void prepareRecyclerView() {
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new PopularItemsAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        recyclerView.setItemAnimator(defaultItemAnimator);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDestroyView() {
        compositeSubscription.unsubscribe();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        adapter.clean();
    }

    @Override
    public void onPopularItemSelected(PopularItemsAdapter.PopularItemEntryViewHolder popularItemEntryViewHolder, PopularItemEntry popularItemEntry) {
        ItemContentFragment contentFragment = ItemContentFragment.newInstance(popularItemEntry);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            contentFragment.setSharedElementEnterTransition(new ContentTransition());
            contentFragment.setEnterTransition(new Fade());
            setExitTransition(new Fade());
            contentFragment.setSharedElementReturnTransition(new ContentTransition());
        }
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addSharedElement(popularItemEntryViewHolder.itemView.findViewById(R.id.topicImage), getString(R.string.transition_image))
                .replace(R.id.content_main, contentFragment)
                .addToBackStack(null)
                .commit();
    }
}
