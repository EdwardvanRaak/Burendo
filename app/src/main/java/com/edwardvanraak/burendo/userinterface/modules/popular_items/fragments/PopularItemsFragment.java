package com.edwardvanraak.burendo.userinterface.modules.popular_items.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edwardvanraak.burendo.R;
import com.edwardvanraak.burendo.userinterface.modules.advertising.models.AdvertisementsItemEntry;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.adapters.PopularItemsAdapter;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.callbacks.OnPopularItemSelectedListener;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.models.PopularItemEntry;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;

/**
 * Fragment containing popular items of Blendle.
 */
public class PopularItemsFragment extends Fragment implements OnPopularItemSelectedListener {

    private static final String TAG = PopularItemsFragment.class.getCanonicalName();

    private OnPopularItemSelectedListener onPopularItemSelectedListener;

    @BindView(R.id.popularItemsRecyclerView) RecyclerView recyclerView;
    @BindView(R.id.popularItemsSwipeRefreshLayout) SwipeRefreshLayout swipeRefreshLayout;

    private PopularItemsAdapter adapter;
    private LinearLayoutManager layoutManager;

    private CompositeSubscription compositeSubscription;

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
        // Inflate the layout for this fragment
        compositeSubscription = new CompositeSubscription();
        View rootView = inflater.inflate(R.layout.fragment_popular_items, container, false);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this, rootView);
        prepareRecyclerView();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updatePopularItems();
            }
        });
        updatePopularItems();
        return rootView;
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

    private void updatePopularItems() {
        /**
         * Just add some test data for now
         */
        for (int i = 0; i < 6; i++) {
            adapter.addComponent(new PopularItemEntry());
            adapter.addComponent(new PopularItemEntry());
            adapter.addComponent(new AdvertisementsItemEntry());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPopularItemSelectedListener) {
            onPopularItemSelectedListener = (OnPopularItemSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnPopularItemSelectedListener");
        }
    }

    @Override
    public void onDestroyView() {
        compositeSubscription.unsubscribe();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onPopularItemSelectedListener = null;
        adapter.clean();
    }

    @Override
    public void onPopularItemSelected(String identifier) {
        onPopularItemSelectedListener.onPopularItemSelected(identifier);
    }
}
