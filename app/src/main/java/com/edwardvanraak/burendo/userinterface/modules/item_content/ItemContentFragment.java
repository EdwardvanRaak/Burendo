package com.edwardvanraak.burendo.userinterface.modules.item_content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.edwardvanraak.burendo.R;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.models.PopularItemEntry;
import com.edwardvanraak.burendo.utility.ThreeTwoImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemContentFragment extends Fragment {

    @BindView(R.id.article_title) TextView title;
    @BindView(R.id.article_content) TextView content;
    @BindView(R.id.article_image)ThreeTwoImageView image;

    public static final String IMAGE_KEY = "image";
    public static final String TITLE_KEY = "title";
    public static final String CONTENT_KEY = "content";

    public static ItemContentFragment newInstance(PopularItemEntry popularItemEntry) {
        Bundle args = new Bundle();
        args.putString(IMAGE_KEY, popularItemEntry.getContentImageURL());
        args.putString(TITLE_KEY, popularItemEntry.getTitle());
        args.putString(CONTENT_KEY, popularItemEntry.getContent());
        ItemContentFragment fragment = new ItemContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_content, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title.setText(Html.fromHtml(getArguments().getString(TITLE_KEY)));
        content.setText(Html.fromHtml(getArguments().getString(CONTENT_KEY)));
        Glide.with(getActivity()).load(getArguments().getString(IMAGE_KEY, "")).into(image);
    }
}
