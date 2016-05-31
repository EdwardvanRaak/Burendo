
package com.edwardvanraak.burendo.domain.pojo.data;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Api{

    @SerializedName("_links")
    private RootLinks links;

    public RootLinks getLinks() {
        return links;
    }
}
