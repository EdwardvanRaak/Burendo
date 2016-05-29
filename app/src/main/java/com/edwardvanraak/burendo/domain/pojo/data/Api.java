
package com.edwardvanraak.burendo.domain.pojo.data;

import javax.annotation.Generated;

import com.edwardvanraak.burendo.domain.pojo.hal.HALResource;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Api{

    @SerializedName("_links")
    private RootLinks links;

    public RootLinks getLinks() {
        return links;
    }
}
