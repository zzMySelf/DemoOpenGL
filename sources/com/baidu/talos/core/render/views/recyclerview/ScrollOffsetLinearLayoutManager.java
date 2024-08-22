package com.baidu.talos.core.render.views.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.talos.core.render.views.scroll.OffsetSmoothScroller;

public class ScrollOffsetLinearLayoutManager extends LinearLayoutManager {
    private int mScrollOffset = 0;

    public ScrollOffsetLinearLayoutManager(Context context) {
        super(context);
    }

    public void setScrollOffset(int offset) {
        this.mScrollOffset = offset;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        RecyclerView.SmoothScroller smoothScroller = new OffsetSmoothScroller(recyclerView.getContext(), this.mScrollOffset);
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
        this.mScrollOffset = 0;
    }
}
