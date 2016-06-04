package com.edwardvanraak.burendo.userinterface.modules.advertising.models;

import com.edwardvanraak.burendo.userinterface.components.ItemComponent;

public class AdvertisementsItemEntry extends ItemComponent {

    private final String dummyText = "Dit is een hele saaie advertentie";

    public AdvertisementsItemEntry() {
        super(ItemComponent.COMPONENT_TYPE_ADVERTISEMENT);
    }

    public String getText() {
        return dummyText;
    }
}
