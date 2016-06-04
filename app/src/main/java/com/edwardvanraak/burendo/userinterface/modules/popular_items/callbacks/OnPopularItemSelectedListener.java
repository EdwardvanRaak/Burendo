package com.edwardvanraak.burendo.userinterface.modules.popular_items.callbacks;

import com.edwardvanraak.burendo.userinterface.modules.popular_items.adapters.PopularItemsAdapter;
import com.edwardvanraak.burendo.userinterface.modules.popular_items.models.PopularItemEntry;

public interface OnPopularItemSelectedListener {
    void onPopularItemSelected(PopularItemsAdapter.PopularItemEntryViewHolder popularItemEntryViewHolder, PopularItemEntry popularItemEntry);
}