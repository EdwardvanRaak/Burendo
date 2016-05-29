
package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import javax.annotation.Generated;

import com.edwardvanraak.burendo.domain.pojo.hal.HALLink;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class PopularItemLinks {

    @SerializedName("self")
    @Expose
    private HALLink self;
    @SerializedName("prev")
    @Expose
    private Prev prev;
    @SerializedName("next")
    @Expose
    private Next next;

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
     *     The prev
     */
    public Prev getPrev() {
        return prev;
    }

    /**
     * 
     * @param prev
     *     The prev
     */
    public void setPrev(Prev prev) {
        this.prev = prev;
    }

    /**
     * 
     * @return
     *     The next
     */
    public Next getNext() {
        return next;
    }

    /**
     * 
     * @param next
     *     The next
     */
    public void setNext(Next next) {
        this.next = next;
    }

}
