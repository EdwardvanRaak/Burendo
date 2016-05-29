
package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import javax.annotation.Generated;

import com.edwardvanraak.burendo.domain.pojo.hal.HALLink;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ItemLinks {

    @SerializedName("self")
    @Expose
    private HALLink self;
    @SerializedName("item_content")
    @Expose
    private ItemContent itemContent;

    /**
     * 
     * @return
     *     The self
     */
    public HALLink getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(HALLink self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The itemContent
     */
    public ItemContent getItemContent() {
        return itemContent;
    }

    /**
     * 
     * @param itemContent
     *     The item_content
     */
    public void setItemContent(ItemContent itemContent) {
        this.itemContent = itemContent;
    }

}
