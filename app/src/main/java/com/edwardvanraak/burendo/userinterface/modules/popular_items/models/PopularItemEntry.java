package com.edwardvanraak.burendo.userinterface.modules.popular_items.models;

import com.edwardvanraak.burendo.userinterface.components.ItemComponent;

import static junit.framework.Assert.assertNotNull;

public class PopularItemEntry extends ItemComponent {

    private String id;

    private String title;
    private String author;
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

    public PopularItemEntry withAuthor(String author){
        this.author = author;
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

    public void validate(){
        assertNotNull(title);
        assertNotNull(author);
        assertNotNull(price);
        assertNotNull(contentImageURL);
        assertNotNull(publisherIconURL);
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

    public String getAuthor() {
        return author;
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
