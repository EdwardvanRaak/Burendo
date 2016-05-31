
package com.edwardvanraak.burendo.domain.pojo.data.popular_items;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Length {

    @SerializedName("words")
    @Expose
    private int words;

    /**
     * 
     * @return
     *     The words
     */
    public int getWords() {
        return words;
    }

    /**
     * 
     * @param words
     *     The words
     */
    public void setWords(int words) {
        this.words = words;
    }

}
