package com.edwardvanraak.burendo.domain.pojo.hal;

import com.google.gson.annotations.SerializedName;

/**
 * Representation of a HAL Link object
 * I omitted link objects that are outside the scope of this demo
 */
public class HALLink {
    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

}
