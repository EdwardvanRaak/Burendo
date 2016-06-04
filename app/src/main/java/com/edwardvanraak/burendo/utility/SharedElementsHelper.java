package com.edwardvanraak.burendo.utility;

import android.view.View;

public class SharedElementsHelper {

    public static void forceSharedElementLayout(View view) {
        int widthSpec = View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(view.getHeight(), View.MeasureSpec.EXACTLY);
        view.measure(widthSpec, heightSpec);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
}
