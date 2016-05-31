
package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Item {

    @SerializedName("_links")
    @Expose
    private ItemLinks links;
    @SerializedName("_embedded")
    @Expose
    private ItemResource embedded;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("posts")
    @Expose
    private int posts;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("price")
    @Expose
    private String price;

    /**
     * 
     * @return
     *     The links
     */
    public ItemLinks getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The _links
     */
    public void setLinks(ItemLinks links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The embedded
     */
    public ItemResource getEmbedded() {
        return embedded;
    }

    /**
     * 
     * @param embedded
     *     The _embedded
     */
    public void setEmbedded(ItemResource embedded) {
        this.embedded = embedded;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The posts
     */
    public int getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    public void setPosts(int posts) {
        this.posts = posts;
    }

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

}
