
package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import javax.annotation.Generated;

import com.edwardvanraak.burendo.domain.pojo.hal.HALResource;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ItemResource implements HALResource {

    @SerializedName("manifest")
    @Expose
    private Manifest manifest;

    /**
     * 
     * @return
     *     The manifest
     */
    public Manifest getManifest() {
        return manifest;
    }

    /**
     * 
     * @param manifest
     *     The manifest
     */
    public void setManifest(Manifest manifest) {
        this.manifest = manifest;
    }

}
