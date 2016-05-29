
package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Manifest {

    @SerializedName("format_version")
    @Expose
    private int formatVersion;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("provider")
    @Expose
    private Provider provider;
    @SerializedName("body")
    @Expose
    private List<Body> body = new ArrayList<Body>();
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("length")
    @Expose
    private Length length;
    @SerializedName("item_index")
    @Expose
    private int itemIndex;
    @SerializedName("issue")
    @Expose
    private Issue issue;
    @SerializedName("_links")
    @Expose
    private ManifestLinks links;

    /**
     * 
     * @return
     *     The formatVersion
     */
    public int getFormatVersion() {
        return formatVersion;
    }

    /**
     * 
     * @param formatVersion
     *     The format_version
     */
    public void setFormatVersion(int formatVersion) {
        this.formatVersion = formatVersion;
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
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The provider
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * 
     * @param provider
     *     The provider
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * 
     * @return
     *     The body
     */
    public List<Body> getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    public void setBody(List<Body> body) {
        this.body = body;
    }

    /**
     * 
     * @return
     *     The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The length
     */
    public Length getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The length
     */
    public void setLength(Length length) {
        this.length = length;
    }

    /**
     * 
     * @return
     *     The itemIndex
     */
    public int getItemIndex() {
        return itemIndex;
    }

    /**
     * 
     * @param itemIndex
     *     The item_index
     */
    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    /**
     * 
     * @return
     *     The issue
     */
    public Issue getIssue() {
        return issue;
    }

    /**
     * 
     * @param issue
     *     The issue
     */
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    /**
     * 
     * @return
     *     The links
     */
    public ManifestLinks getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The _links
     */
    public void setLinks(ManifestLinks links) {
        this.links = links;
    }

}
