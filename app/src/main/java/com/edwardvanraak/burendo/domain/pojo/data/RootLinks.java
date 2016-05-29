package com.edwardvanraak.burendo.domain.pojo.data;

import com.edwardvanraak.burendo.domain.pojo.hal.HALLink;
import com.google.gson.annotations.SerializedName;

public class RootLinks {

    @SerializedName("items_popular")
    private HALLink popularItems;

    public HALLink getPopularItems() {
        return popularItems;
    }
}
