package com.tera.scan.ui.widget.banner.layoutmanager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BannerLayoutManager extends RecyclerView.LayoutManager {
    public static final int DETERMINE_BY_MAX_AND_MIN = -1;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_SIZE = Integer.MAX_VALUE;
    public static final int VERTICAL = 1;

    /* renamed from: ad  reason: collision with root package name */
    public int f7412ad;
    public float ddd;

    /* renamed from: de  reason: collision with root package name */
    public boolean f7413de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f7414fe;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public boolean f7415i;

    /* renamed from: if  reason: not valid java name */
    public int f317if;
    public int mDecoratedMeasurement;
    public int mDecoratedMeasurementInOther;
    public float mInterval;
    public float mOffset;
    public OrientationHelper mOrientationHelper;
    public int mSpaceInOther;
    public int mSpaceMain;
    public float nn;

    /* renamed from: o  reason: collision with root package name */
    public boolean f7416o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f7417pf;
    public Interpolator ppp;
    public final SparseArray<View> qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f7418rg;

    /* renamed from: switch  reason: not valid java name */
    public int f318switch;

    /* renamed from: th  reason: collision with root package name */
    public int f7419th;

    /* renamed from: uk  reason: collision with root package name */
    public OnPageChangeListener f7420uk;
    public View vvv;
    public int when;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public SavedState f7421yj;

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i2);

        void onPageSelected(int i2);
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new qw();
        public boolean isReverseLayout;
        public float offset;
        public int position;

        public class qw implements Parcelable.Creator<SavedState> {
            /* renamed from: ad */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* renamed from: qw */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.position);
            parcel.writeFloat(this.offset);
            parcel.writeInt(this.isReverseLayout ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.position = parcel.readInt();
            this.offset = parcel.readFloat();
            this.isReverseLayout = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.position = savedState.position;
            this.offset = savedState.offset;
            this.isReverseLayout = savedState.isReverseLayout;
        }
    }

    public BannerLayoutManager(Context context) {
        this(context, 0, false);
    }

    public final int ad() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.f7418rg) {
            return 1;
        }
        return (int) this.mInterval;
    }

    public int calItemLeft(View view, float f) {
        if (this.f7412ad == 1) {
            return 0;
        }
        return (int) f;
    }

    public int calItemTop(View view, float f) {
        if (this.f7412ad == 1) {
            return (int) f;
        }
        return 0;
    }

    public boolean canScrollHorizontally() {
        return this.f7412ad == 0;
    }

    public boolean canScrollVertically() {
        return this.f7412ad == 1;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return ad();
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return de();
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return fe();
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return ad();
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return de();
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return fe();
    }

    public final int de() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (this.f7418rg) {
            float i2 = i();
            if (!this.f7414fe) {
                return (int) i2;
            }
            return (int) ((((float) (getItemCount() - 1)) * this.mInterval) + i2);
        } else if (!this.f7414fe) {
            return getCurrentPosition();
        } else {
            return (getItemCount() - getCurrentPosition()) - 1;
        }
    }

    public void ensureLayoutState() {
        if (this.mOrientationHelper == null) {
            this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.f7412ad);
        }
    }

    public final int fe() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.f7418rg) {
            return getItemCount();
        }
        return (int) (((float) getItemCount()) * this.mInterval);
    }

    public View findViewByPosition(int i2) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return null;
        }
        for (int i3 = 0; i3 < this.qw.size(); i3++) {
            int keyAt = this.qw.keyAt(i3);
            if (keyAt < 0) {
                int i4 = keyAt % itemCount;
                if (i4 == 0) {
                    i4 = -itemCount;
                }
                if (i4 + itemCount == i2) {
                    return this.qw.valueAt(i3);
                }
            } else if (i2 == keyAt % itemCount) {
                return this.qw.valueAt(i3);
            }
        }
        return null;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getCurrentPosition() {
        int i2;
        if (getItemCount() == 0) {
            return 0;
        }
        int rg2 = rg();
        if (!this.f7416o) {
            return Math.abs(rg2);
        }
        if (!this.f7414fe) {
            if (rg2 >= 0) {
                i2 = rg2 % getItemCount();
            } else {
                i2 = (rg2 % getItemCount()) + getItemCount();
            }
        } else if (rg2 > 0) {
            i2 = getItemCount() - (rg2 % getItemCount());
        } else {
            i2 = (-rg2) % getItemCount();
        }
        if (i2 == getItemCount()) {
            return 0;
        }
        return i2;
    }

    public float getDistanceRatio() {
        float f = this.nn;
        if (f == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / f;
    }

    public int getDistanceToBottom() {
        int i2 = this.ggg;
        return i2 == Integer.MAX_VALUE ? (getTotalSpaceInOther() - this.mDecoratedMeasurementInOther) / 2 : i2;
    }

    public boolean getEnableBringCenterToFront() {
        return this.f7417pf;
    }

    public boolean getInfinite() {
        return this.f7416o;
    }

    public int getMaxVisibleItemCount() {
        return this.when;
    }

    public int getOffsetToCenter() {
        float currentPosition;
        float distanceRatio;
        if (this.f7416o) {
            currentPosition = (((float) rg()) * this.mInterval) - this.mOffset;
            distanceRatio = getDistanceRatio();
        } else {
            currentPosition = (((float) getCurrentPosition()) * (!this.f7414fe ? this.mInterval : -this.mInterval)) - this.mOffset;
            distanceRatio = getDistanceRatio();
        }
        return (int) (currentPosition * distanceRatio);
    }

    public int getOffsetToPosition(int i2) {
        float f;
        float distanceRatio;
        int i3;
        if (this.f7416o) {
            int rg2 = rg();
            if (!this.f7414fe) {
                i3 = i2 - getCurrentPosition();
            } else {
                i3 = getCurrentPosition() - i2;
            }
            f = (((float) (rg2 + i3)) * this.mInterval) - this.mOffset;
            distanceRatio = getDistanceRatio();
        } else {
            f = (((float) i2) * (!this.f7414fe ? this.mInterval : -this.mInterval)) - this.mOffset;
            distanceRatio = getDistanceRatio();
        }
        return (int) (f * distanceRatio);
    }

    public int getOrientation() {
        return this.f7412ad;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.f7415i;
    }

    public boolean getReverseLayout() {
        return this.f7413de;
    }

    public boolean getSmoothScrollbarEnabled() {
        return this.f7418rg;
    }

    public int getTotalSpaceInOther() {
        int width;
        int paddingRight;
        if (this.f7412ad == 0) {
            width = getHeight() - getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth() - getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        return width - paddingRight;
    }

    public final float i() {
        if (this.f7414fe) {
            if (!this.f7416o) {
                return this.mOffset;
            }
            float f = this.mOffset;
            if (f <= 0.0f) {
                return f % (this.mInterval * ((float) getItemCount()));
            }
            float f2 = this.mInterval;
            return (((float) getItemCount()) * (-f2)) + (this.mOffset % (f2 * ((float) getItemCount())));
        } else if (!this.f7416o) {
            return this.mOffset;
        } else {
            float f3 = this.mOffset;
            if (f3 >= 0.0f) {
                return f3 % (this.mInterval * ((float) getItemCount()));
            }
            float f4 = this.mInterval;
            return (((float) getItemCount()) * f4) + (this.mOffset % (f4 * ((float) getItemCount())));
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m932if(View view, float f) {
        int calItemLeft = calItemLeft(view, f);
        int calItemTop = calItemTop(view, f);
        if (this.f7412ad == 1) {
            int i2 = this.mSpaceInOther;
            int i3 = this.mSpaceMain;
            layoutDecorated(view, i2 + calItemLeft, i3 + calItemTop, i2 + calItemLeft + this.mDecoratedMeasurementInOther, i3 + calItemTop + this.mDecoratedMeasurement);
        } else {
            int i4 = this.mSpaceMain;
            int i5 = this.mSpaceInOther;
            layoutDecorated(view, i4 + calItemLeft, i5 + calItemTop, i4 + calItemLeft + this.mDecoratedMeasurement, i5 + calItemTop + this.mDecoratedMeasurementInOther);
        }
        setItemViewProperty(view, f);
    }

    public float maxRemoveOffset() {
        return (float) (this.mOrientationHelper.getTotalSpace() - this.mSpaceMain);
    }

    public float minRemoveOffset() {
        return (float) (((-this.mDecoratedMeasurement) - this.mOrientationHelper.getStartAfterPadding()) - this.mSpaceMain);
    }

    public final float o(int i2) {
        return ((float) i2) * (this.f7414fe ? -this.mInterval : this.mInterval);
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
        this.mOffset = 0.0f;
    }

    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
        int currentPosition = getCurrentPosition();
        View findViewByPosition = findViewByPosition(currentPosition);
        if (findViewByPosition == null) {
            return true;
        }
        if (recyclerView.hasFocus()) {
            int uk2 = uk(i2);
            if (uk2 != -1) {
                recyclerView.smoothScrollToPosition(uk2 == 1 ? currentPosition - 1 : currentPosition + 1);
            }
        } else {
            findViewByPosition.addFocusables(arrayList, i2, i3);
        }
        return true;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.f7415i) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    public View onFocusSearchFailed(View view, int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return null;
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f;
        float f2;
        if (state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            this.mOffset = 0.0f;
            return;
        }
        ensureLayoutState();
        resolveShouldLayoutReverse();
        View viewForPosition = recycler.getViewForPosition(0);
        measureChildWithMargins(viewForPosition, 0, 0);
        this.mDecoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(viewForPosition);
        this.mDecoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(viewForPosition);
        this.mSpaceMain = (this.mOrientationHelper.getTotalSpace() - this.mDecoratedMeasurement) / 2;
        if (this.ggg == Integer.MAX_VALUE) {
            this.mSpaceInOther = (getTotalSpaceInOther() - this.mDecoratedMeasurementInOther) / 2;
        } else {
            this.mSpaceInOther = (getTotalSpaceInOther() - this.mDecoratedMeasurementInOther) - this.ggg;
        }
        this.mInterval = setInterval();
        setUp();
        this.f317if = ((int) Math.abs(minRemoveOffset() / this.mInterval)) + 1;
        this.f318switch = ((int) Math.abs(maxRemoveOffset() / this.mInterval)) + 1;
        SavedState savedState = this.f7421yj;
        if (savedState != null) {
            this.f7414fe = savedState.isReverseLayout;
            this.f7419th = savedState.position;
            this.mOffset = savedState.offset;
        }
        int i2 = this.f7419th;
        if (i2 != -1) {
            if (this.f7414fe) {
                f = (float) i2;
                f2 = -this.mInterval;
            } else {
                f = (float) i2;
                f2 = this.mInterval;
            }
            this.mOffset = f * f2;
        }
        detachAndScrapAttachedViews(recycler);
        pf(recycler);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f7421yj = null;
        this.f7419th = -1;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f7421yj = new SavedState((SavedState) parcelable);
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.f7421yj != null) {
            return new SavedState(this.f7421yj);
        }
        SavedState savedState = new SavedState();
        savedState.position = this.f7419th;
        savedState.offset = this.mOffset;
        savedState.isReverseLayout = this.f7414fe;
        return savedState;
    }

    public final void pf(RecyclerView.Recycler recycler) {
        int i2;
        int i3;
        int i4;
        detachAndScrapAttachedViews(recycler);
        this.qw.clear();
        int itemCount = getItemCount();
        if (itemCount != 0) {
            int rg2 = this.f7414fe ? -rg() : rg();
            int i5 = rg2 - this.f317if;
            int i6 = this.f318switch + rg2;
            if (ppp()) {
                if (this.when % 2 == 0) {
                    i4 = this.when / 2;
                    i3 = (rg2 - i4) + 1;
                } else {
                    i4 = (this.when - 1) / 2;
                    i3 = rg2 - i4;
                }
                i6 = 1 + i4 + rg2;
                i5 = i3;
            }
            if (!this.f7416o) {
                if (i5 < 0) {
                    if (ppp()) {
                        i6 = this.when;
                    }
                    i5 = 0;
                }
                if (i6 > itemCount) {
                    i6 = itemCount;
                }
            }
            float f = Float.MIN_VALUE;
            while (i5 < i6) {
                if (ppp() || !m933switch(o(i5) - this.mOffset)) {
                    if (i5 >= itemCount) {
                        i2 = i5 % itemCount;
                    } else if (i5 < 0) {
                        int i7 = (-i5) % itemCount;
                        if (i7 == 0) {
                            i7 = itemCount;
                        }
                        i2 = itemCount - i7;
                    } else {
                        i2 = i5;
                    }
                    View viewForPosition = recycler.getViewForPosition(i2);
                    measureChildWithMargins(viewForPosition, 0, 0);
                    when(viewForPosition);
                    float o2 = o(i5) - this.mOffset;
                    m932if(viewForPosition, o2);
                    float viewElevation = this.f7417pf ? setViewElevation(viewForPosition, o2) : (float) i2;
                    if (viewElevation > f) {
                        addView(viewForPosition);
                    } else {
                        addView(viewForPosition, 0);
                    }
                    if (i5 == rg2) {
                        this.vvv = viewForPosition;
                    }
                    this.qw.put(i5, viewForPosition);
                    f = viewElevation;
                }
                i5++;
            }
            this.vvv.requestFocus();
        }
    }

    public final boolean ppp() {
        return this.when != -1;
    }

    public final float qw(float f) {
        float abs = Math.abs(f - (((float) (this.mOrientationHelper.getTotalSpace() - this.mDecoratedMeasurement)) / 2.0f));
        int i2 = this.mDecoratedMeasurement;
        float f2 = 0.0f;
        if (((float) i2) - abs > 0.0f) {
            f2 = ((float) i2) - abs;
        }
        return (((this.ddd - 1.0f) / ((float) this.mDecoratedMeasurement)) * f2) + 1.0f;
    }

    public final void resolveShouldLayoutReverse() {
        if (this.f7412ad == 0 && getLayoutDirection() == 1) {
            this.f7413de = !this.f7413de;
        }
    }

    public final int rg() {
        return Math.round(this.mOffset / this.mInterval);
    }

    public final int scrollBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        ensureLayoutState();
        float f = (float) i2;
        float distanceRatio = f / getDistanceRatio();
        if (Math.abs(distanceRatio) < 1.0E-8f) {
            return 0;
        }
        float f2 = this.mOffset + distanceRatio;
        if (!this.f7416o && f2 < yj()) {
            i2 = (int) (f - ((f2 - yj()) * getDistanceRatio()));
        } else if (!this.f7416o && f2 > th()) {
            i2 = (int) ((th() - this.mOffset) * getDistanceRatio());
        }
        this.mOffset += ((float) i2) / getDistanceRatio();
        pf(recycler);
        return i2;
    }

    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7412ad == 1) {
            return 0;
        }
        return scrollBy(i2, recycler, state);
    }

    public void scrollToPosition(int i2) {
        if (this.f7416o || (i2 >= 0 && i2 < getItemCount())) {
            this.f7419th = i2;
            this.mOffset = ((float) i2) * (this.f7414fe ? -this.mInterval : this.mInterval);
            requestLayout();
        }
    }

    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.f7412ad == 0) {
            return 0;
        }
        return scrollBy(i2, recycler, state);
    }

    public void setCenterScale(float f) {
        this.ddd = f;
    }

    public void setDistanceToBottom(int i2) {
        assertNotInLayoutOrScroll((String) null);
        if (this.ggg != i2) {
            this.ggg = i2;
            removeAllViews();
        }
    }

    public void setEnableBringCenterToFront(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (this.f7417pf != z) {
            this.f7417pf = z;
            requestLayout();
        }
    }

    public void setInfinite(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (z != this.f7416o) {
            this.f7416o = z;
            requestLayout();
        }
    }

    public float setInterval() {
        return (((float) this.mDecoratedMeasurement) * (((this.ddd - 1.0f) / 2.0f) + 1.0f)) + ((float) this.xxx);
    }

    public void setItemSpace(int i2) {
        this.xxx = i2;
    }

    public void setItemViewProperty(View view, float f) {
        float qw2 = qw(f + ((float) this.mSpaceMain));
        view.setScaleX(qw2);
        view.setScaleY(qw2);
    }

    public void setMaxVisibleItemCount(int i2) {
        assertNotInLayoutOrScroll((String) null);
        if (this.when != i2) {
            this.when = i2;
            removeAllViews();
        }
    }

    public void setMoveSpeed(float f) {
        assertNotInLayoutOrScroll((String) null);
        if (this.nn != f) {
            this.nn = f;
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f7420uk = onPageChangeListener;
    }

    public void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i2 != this.f7412ad) {
                this.f7412ad = i2;
                this.mOrientationHelper = null;
                this.ggg = Integer.MAX_VALUE;
                removeAllViews();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i2);
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.f7415i = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (z != this.f7413de) {
            this.f7413de = z;
            removeAllViews();
        }
    }

    public void setSmoothScrollInterpolator(Interpolator interpolator) {
        this.ppp = interpolator;
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.f7418rg = z;
    }

    public void setUp() {
    }

    public float setViewElevation(View view, float f) {
        return 0.0f;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        int offsetToPosition = getOffsetToPosition(i2);
        if (this.f7412ad == 1) {
            recyclerView.smoothScrollBy(0, offsetToPosition, this.ppp);
        } else {
            recyclerView.smoothScrollBy(offsetToPosition, 0, this.ppp);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m933switch(float f) {
        return f > maxRemoveOffset() || f < minRemoveOffset();
    }

    public float th() {
        if (!this.f7414fe) {
            return ((float) (getItemCount() - 1)) * this.mInterval;
        }
        return 0.0f;
    }

    public final int uk(int i2) {
        if (this.f7412ad == 1) {
            if (i2 == 33) {
                return this.f7414fe ^ true ? 1 : 0;
            }
            if (i2 == 130) {
                return this.f7414fe ? 1 : 0;
            }
            return -1;
        } else if (i2 == 17) {
            return this.f7414fe ^ true ? 1 : 0;
        } else {
            if (i2 == 66) {
                return this.f7414fe ? 1 : 0;
            }
            return -1;
        }
    }

    public final void when(View view) {
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    public float yj() {
        if (!this.f7414fe) {
            return 0.0f;
        }
        return ((float) (-(getItemCount() - 1))) * this.mInterval;
    }

    public BannerLayoutManager(Context context, int i2) {
        this(context, i2, false);
    }

    public BannerLayoutManager(Context context, int i2, boolean z) {
        this.qw = new SparseArray<>();
        this.f7413de = false;
        this.f7414fe = false;
        this.f7418rg = true;
        this.f7419th = -1;
        this.f7421yj = null;
        this.f7416o = true;
        this.when = -1;
        this.ggg = Integer.MAX_VALUE;
        this.xxx = 20;
        this.ddd = 1.2f;
        this.nn = 1.0f;
        setEnableBringCenterToFront(true);
        setMaxVisibleItemCount(3);
        setOrientation(i2);
        setReverseLayout(z);
        setAutoMeasureEnabled(true);
        setItemPrefetchEnabled(false);
    }
}
