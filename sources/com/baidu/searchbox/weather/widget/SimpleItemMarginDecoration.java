package com.baidu.searchbox.weather.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleItemMarginDecoration extends RecyclerView.ItemDecoration {
    private int mItemMargin;

    public SimpleItemMarginDecoration(int itemMargin) {
        this.mItemMargin = itemMargin;
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view2, parent, state);
        outRect.left = this.mItemMargin;
        outRect.right = this.mItemMargin;
    }
}
