package com.baidu.searchbox.personalcenter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceBottom;
    private int spaceLeft;
    private int spaceLeftRight;
    private int spaceRight;
    private int spaceTop;

    public SpaceItemDecoration(int leftRight, int bottom) {
        this.spaceLeftRight = leftRight;
        this.spaceLeft = leftRight;
        this.spaceRight = leftRight;
        this.spaceBottom = bottom;
    }

    public SpaceItemDecoration(int left, int top, int right, int bottom) {
        this.spaceLeft = left;
        this.spaceRight = right;
        this.spaceTop = top;
        this.spaceBottom = bottom;
    }

    public void getItemOffsets(Rect outRect, View view2, RecyclerView parent, RecyclerView.State state) {
        outRect.left = this.spaceLeft;
        outRect.right = this.spaceRight;
        outRect.top = this.spaceTop;
        outRect.bottom = this.spaceBottom;
    }
}
