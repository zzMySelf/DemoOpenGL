package com.baidu.talos.core.render.views.swiper;

import androidx.recyclerview.widget.DiffUtil;

class SwiperDiffCallback extends DiffUtil.Callback {
    long[] mNewSet;
    long[] mOldSet;

    public SwiperDiffCallback(long[] oldSet, long[] newSet) {
        this.mOldSet = oldSet;
        this.mNewSet = newSet;
    }

    public int getOldListSize() {
        long[] jArr = this.mOldSet;
        if (jArr == null) {
            return 0;
        }
        return jArr.length;
    }

    public int getNewListSize() {
        long[] jArr = this.mNewSet;
        if (jArr == null) {
            return 0;
        }
        return jArr.length;
    }

    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return isSame(oldItemPosition, newItemPosition);
    }

    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return isSame(oldItemPosition, newItemPosition);
    }

    private boolean isSame(int oldItemPosition, int newItemPosition) {
        long[] jArr;
        long[] jArr2 = this.mOldSet;
        if (jArr2 == null || (jArr = this.mNewSet) == null || jArr2[oldItemPosition] != jArr[newItemPosition]) {
            return false;
        }
        return true;
    }
}
