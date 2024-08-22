package com.baidu.talos.core.render.views.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

public class NotAnimatedItemAnimator extends RecyclerView.ItemAnimator {
    public boolean animateDisappearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo1) {
        dispatchAnimationFinished(viewHolder);
        return false;
    }

    public boolean animateAppearance(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo1) {
        dispatchAnimationFinished(viewHolder);
        return false;
    }

    public boolean animatePersistence(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo1) {
        dispatchAnimationFinished(viewHolder);
        return false;
    }

    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo1) {
        dispatchAnimationFinished(viewHolder);
        return false;
    }

    public void runPendingAnimations() {
    }

    public void endAnimation(RecyclerView.ViewHolder item) {
    }

    public void endAnimations() {
    }

    public boolean isRunning() {
        return false;
    }
}
