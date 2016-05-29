package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import com.google.gson.annotations.SerializedName;

public class PopularItems {

    @SerializedName("_links")
    private PopularItemLinks links;
    @SerializedName("_embedded")
    private PopularItemResources resources;

    public PopularItemLinks getLinks() {
        return links;
    }

    public PopularItemResources getResources() {
        return resources;
    }
}
