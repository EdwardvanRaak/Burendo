package com.edwardvanraak.burendo.userinterface.modules.popular_items.models;

import com.edwardvanraak.burendo.userinterface.components.ItemComponent;

public class PopularItemEntry extends ItemComponent {

    private String id;

    private String title;
    private String content;
    private String price;

    private String contentImageURL;
    private String publisherIconURL;

    private boolean consumed = false;

    public PopularItemEntry() {
        super(ItemComponent.COMPONENT_TYPE_POPULAR_ENTRY);
    }

    public PopularItemEntry withId(String id){
        this.id = id;
        return this;
    }

    public PopularItemEntry withTitle(String title){
        this.title = title;
        return this;
    }

    public PopularItemEntry withContent(String content){
        this.content = content;
        return this;
    }

    public PopularItemEntry withPriceTag(String price){
        this.price = price;
        return this;
    }

    public PopularItemEntry withContentImageURL(String contentImageURL){
        this.contentImageURL = contentImageURL;
        return this;
    }

    public PopularItemEntry withPublisherIconURL(String publisherIconURL){
        this.publisherIconURL = publisherIconURL;
        return this;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPrice() {
        return price;
    }

    public String getContentImageURL() {
        return contentImageURL;
    }

    public String getPublisherIconURL() {
        return publisherIconURL;
    }
}
