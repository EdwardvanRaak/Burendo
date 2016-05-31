package com.edwardvanraak.burendo.userinterface.components;

public abstract class ItemComponent {

    public static final int COMPONENT_TYPE_POPULAR_ENTRY = 1;
    public static final int COMPONENT_TYPE_ADVERTISEMENT = 2;

    protected int viewType = 0;

    public ItemComponent(int viewType) {
        this.viewType = viewType;
    }

    public int getViewType() {
        return viewType;
    }
}

