package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Bucket mBucket = new Bucket();
    final Callback mCallback;
    final List<View> mHiddenViews = new ArrayList();

    interface Callback {
        void addView(View view2, int i2);

        void attachViewToParent(View view2, int i2, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i2);

        View getChildAt(int i2);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view2);

        int indexOfChild(View view2);

        void onEnteredHiddenState(View view2);

        void onLeftHiddenState(View view2);

        void removeAllViews();

        void removeViewAt(int i2);
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private void hideViewInternal(View child) {
        this.mHiddenViews.add(child);
        this.mCallback.onEnteredHiddenState(child);
    }

    private boolean unhideViewInternal(View child) {
        if (!this.mHiddenViews.remove(child)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(child);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void addView(View child, boolean hidden) {
        addView(child, -1, hidden);
    }

    /* access modifiers changed from: package-private */
    public void addView(View child, int index, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(index);
        }
        this.mBucket.insert(offset, hidden);
        if (hidden) {
            hideViewInternal(child);
        }
        this.mCallback.addView(child, offset);
    }

    private int getOffset(int index) {
        if (index < 0) {
            return -1;
        }
        int limit = this.mCallback.getChildCount();
        int offset = index;
        while (offset < limit) {
            int diff = index - (offset - this.mBucket.countOnesBefore(offset));
            if (diff == 0) {
                while (this.mBucket.get(offset)) {
                    offset++;
                }
                return offset;
            }
            offset += diff;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void removeView(View view2) {
        int index = this.mCallback.indexOfChild(view2);
        if (index >= 0) {
            if (this.mBucket.remove(index)) {
                unhideViewInternal(view2);
            }
            this.mCallback.removeViewAt(index);
        }
    }

    /* access modifiers changed from: package-private */
    public void removeViewAt(int index) {
        int offset = getOffset(index);
        View view2 = this.mCallback.getChildAt(offset);
        if (view2 != null) {
            if (this.mBucket.remove(offset)) {
                unhideViewInternal(view2);
            }
            this.mCallback.removeViewAt(offset);
        }
    }

    /* access modifiers changed from: package-private */
    public View getChildAt(int index) {
        return this.mCallback.getChildAt(getOffset(index));
    }

    /* access modifiers changed from: package-private */
    public void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int i2 = this.mHiddenViews.size() - 1; i2 >= 0; i2--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(i2));
            this.mHiddenViews.remove(i2);
        }
        this.mCallback.removeAllViews();
    }

    /* access modifiers changed from: package-private */
    public View findHiddenNonRemovedView(int position) {
        int count = this.mHiddenViews.size();
        for (int i2 = 0; i2 < count; i2++) {
            View view2 = this.mHiddenViews.get(i2);
            RecyclerView.ViewHolder holder = this.mCallback.getChildViewHolder(view2);
            if (holder.getLayoutPosition() == position && !holder.isInvalid() && !holder.isRemoved()) {
                return view2;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void attachViewToParent(View child, int index, ViewGroup.LayoutParams layoutParams, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = this.mCallback.getChildCount();
        } else {
            offset = getOffset(index);
        }
        this.mBucket.insert(offset, hidden);
        if (hidden) {
            hideViewInternal(child);
        }
        this.mCallback.attachViewToParent(child, offset, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    /* access modifiers changed from: package-private */
    public int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    /* access modifiers changed from: package-private */
    public View getUnfilteredChildAt(int index) {
        return this.mCallback.getChildAt(index);
    }

    /* access modifiers changed from: package-private */
    public void detachViewFromParent(int index) {
        int offset = getOffset(index);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    /* access modifiers changed from: package-private */
    public int indexOfChild(View child) {
        int index = this.mCallback.indexOfChild(child);
        if (index != -1 && !this.mBucket.get(index)) {
            return index - this.mBucket.countOnesBefore(index);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public boolean isHidden(View view2) {
        return this.mHiddenViews.contains(view2);
    }

    /* access modifiers changed from: package-private */
    public void hide(View view2) {
        int offset = this.mCallback.indexOfChild(view2);
        if (offset >= 0) {
            this.mBucket.set(offset);
            hideViewInternal(view2);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view2);
    }

    /* access modifiers changed from: package-private */
    public void unhide(View view2) {
        int offset = this.mCallback.indexOfChild(view2);
        if (offset < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view2);
        } else if (this.mBucket.get(offset)) {
            this.mBucket.clear(offset);
            unhideViewInternal(view2);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view2);
        }
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    /* access modifiers changed from: package-private */
    public boolean removeViewIfHidden(View view2) {
        int index = this.mCallback.indexOfChild(view2);
        if (index == -1) {
            unhideViewInternal(view2);
            return true;
        } else if (!this.mBucket.get(index)) {
            return false;
        } else {
            this.mBucket.remove(index);
            unhideViewInternal(view2);
            this.mCallback.removeViewAt(index);
            return true;
        }
    }

    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        /* access modifiers changed from: package-private */
        public void set(int index) {
            if (index >= 64) {
                ensureNext();
                this.mNext.set(index - 64);
                return;
            }
            this.mData |= 1 << index;
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        /* access modifiers changed from: package-private */
        public void clear(int index) {
            if (index >= 64) {
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.clear(index - 64);
                    return;
                }
                return;
            }
            this.mData &= ~(1 << index);
        }

        /* access modifiers changed from: package-private */
        public boolean get(int index) {
            if (index < 64) {
                return (this.mData & (1 << index)) != 0;
            }
            ensureNext();
            return this.mNext.get(index - 64);
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mData = 0;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        /* access modifiers changed from: package-private */
        public void insert(int index, boolean value) {
            if (index >= 64) {
                ensureNext();
                this.mNext.insert(index - 64, value);
                return;
            }
            long j2 = this.mData;
            boolean lastBit = (Long.MIN_VALUE & j2) != 0;
            long mask = (1 << index) - 1;
            this.mData = (j2 & mask) | ((j2 & (~mask)) << 1);
            if (value) {
                set(index);
            } else {
                clear(index);
            }
            if (lastBit || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, lastBit);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean remove(int index) {
            if (index >= 64) {
                ensureNext();
                return this.mNext.remove(index - 64);
            }
            long mask = 1 << index;
            long j2 = this.mData;
            boolean value = (j2 & mask) != 0;
            long j3 = j2 & (~mask);
            this.mData = j3;
            long mask2 = mask - 1;
            this.mData = (j3 & mask2) | Long.rotateRight(j3 & (~mask2), 1);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return value;
        }

        /* access modifiers changed from: package-private */
        public int countOnesBefore(int index) {
            Bucket bucket = this.mNext;
            if (bucket == null) {
                if (index >= 64) {
                    return Long.bitCount(this.mData);
                }
                return Long.bitCount(this.mData & ((1 << index) - 1));
            } else if (index < 64) {
                return Long.bitCount(this.mData & ((1 << index) - 1));
            } else {
                return bucket.countOnesBefore(index - 64) + Long.bitCount(this.mData);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }
}
