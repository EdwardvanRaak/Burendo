
package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Image {

    @SerializedName("_links")
    @Expose
    private ImageLinks links;
    @SerializedName("featured")
    @Expose
    private boolean featured;

    /**
     * 
     * @return
     *     The links
     */
    public ImageLinks getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The _links
     */
    public void setLinks(ImageLinks links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The featured
     */
    public boolean isFeatured() {
        return featured;
    }

    /**
     * 
     * @param featured
     *     The featured
     */
    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

}
