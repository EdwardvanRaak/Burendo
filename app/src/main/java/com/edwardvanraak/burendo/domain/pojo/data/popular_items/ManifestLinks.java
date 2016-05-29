
package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import javax.annotation.Generated;

import com.edwardvanraak.burendo.domain.pojo.hal.HALLink;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ManifestLinks {

    @SerializedName("self")
    @Expose
    private HALLink self;

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

}
