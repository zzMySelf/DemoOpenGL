package com.tera.scan.widget.customrecyclerview;

import androidx.recyclerview.widget.RecyclerView;

public abstract class OnLoadMoreScrollListener extends RecyclerView.OnScrollListener {
    public boolean canTriggerLoadMore(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getItemCount() - 1 == recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1))) {
            return true;
        }
        return false;
    }

    public abstract void onLoadMore(RecyclerView recyclerView);

    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        if (recyclerView.getLayoutManager().getChildCount() > 0 && i2 == 0 && canTriggerLoadMore(recyclerView)) {
            onLoadMore(recyclerView);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
    }
}
