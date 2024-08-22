package com.baidu.searchbox.exclusion.suspension;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.baidu.searchbox.exclusion.R;
import com.baidu.searchbox.exclusion.util.DeviceUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;

public class BarrierPool {
    public static final boolean DEBUG = false;
    private static final int RECURRENT_COUNT = 5;
    private static final String TAG = "BarrierPool";
    private final ArrayList<View> mBarriers;
    private int mBottomPadding;
    private Barrier<View> mLeftAvailableBarriers;
    private int mLeftPadding;
    private Barrier<View> mRightAvailableBarriers;
    private int mRightPadding;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mSpacing;
    private View mTarget;
    private int mTopPadding;
    private Rect mValidRect;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BarrierType {
        public static final int MOTIONLESS = 0;
        public static final int MOVABLE = 1;
    }

    private BarrierPool() {
        this.mBarriers = new ArrayList<>();
    }

    private static class InstanceHolder {
        static final BarrierPool INSTANCE = new BarrierPool();

        private InstanceHolder() {
        }
    }

    public static BarrierPool getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void setTarget(View target) {
        this.mTarget = target;
    }

    public boolean add(View barrier) {
        return add(1, barrier);
    }

    public boolean add(int barrierType, View barrier) {
        return add(barrierType, barrier, (Rect) null);
    }

    public boolean add(int barrierType, View barrier, Rect barrierRect) {
        if (barrier == null) {
            return false;
        }
        barrier.setTag(R.id.tag_barrier_type, Integer.valueOf(barrierType));
        if (barrierRect != null) {
            barrier.setTag(R.id.tag_barrier_rect, barrierRect);
        }
        barrier.setTag(R.id.tag_barrier_available_rect_top, (Object) null);
        barrier.setTag(R.id.tag_barrier_available_rect_bottom, (Object) null);
        ArrayList<View> arrayList = this.mBarriers;
        if (arrayList == null || arrayList.contains(barrier) || !this.mBarriers.add(barrier)) {
            return false;
        }
        return true;
    }

    public boolean remove(View barrier) {
        if (barrier == null) {
            return false;
        }
        this.mLeftAvailableBarriers = dequeue(this.mLeftAvailableBarriers, barrier);
        this.mRightAvailableBarriers = dequeue(this.mRightAvailableBarriers, barrier);
        ArrayList<View> arrayList = this.mBarriers;
        if (arrayList == null || !arrayList.contains(barrier) || !this.mBarriers.remove(barrier)) {
            return false;
        }
        return true;
    }

    public void clear() {
        this.mLeftAvailableBarriers = null;
        this.mRightAvailableBarriers = null;
        ArrayList<View> arrayList = this.mBarriers;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public ArrayList<View> getBarriers() {
        return this.mBarriers;
    }

    public void setScreenSize(int screenWidth, int screenHeight) {
        this.mScreenWidth = screenWidth;
        this.mScreenHeight = screenHeight;
    }

    public void setSpacing(int spacing) {
        this.mSpacing = Math.max(spacing, 0);
    }

    public void setPadding(int left, int top, int right, int bottom) {
        this.mLeftPadding = Math.max(left, 0);
        this.mTopPadding = Math.max(top, 0);
        this.mRightPadding = Math.max(right, 0);
        this.mBottomPadding = Math.max(bottom, 0);
    }

    private void computeBarriersRect() {
        ArrayList<View> arrayList = this.mBarriers;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.mLeftAvailableBarriers = null;
            this.mRightAvailableBarriers = null;
            Iterator<View> it = this.mBarriers.iterator();
            while (it.hasNext()) {
                View barrier = it.next();
                int[] barrierLoc = new int[2];
                barrier.getLocationOnScreen(barrierLoc);
                int barrierWidth = barrier.getWidth();
                int barrierHeight = barrier.getHeight();
                int i2 = barrierLoc[0];
                int i3 = barrierLoc[1];
                int i4 = this.mSpacing;
                Rect barrierRect = new Rect(i2, i3 - i4, barrierLoc[0] + barrierWidth, barrierLoc[1] + barrierHeight + i4);
                if (Math.min(barrierRect.left - this.mValidRect.left, this.mValidRect.right - barrierRect.right) < this.mTarget.getWidth()) {
                    barrier.setTag(R.id.tag_barrier_rect, barrierRect);
                    if (barrierRect.centerX() < this.mScreenWidth / 2) {
                        this.mLeftAvailableBarriers = enqueue(this.mLeftAvailableBarriers, new Barrier(barrier));
                    } else if (barrierRect.centerX() > this.mScreenWidth / 2) {
                        this.mRightAvailableBarriers = enqueue(this.mRightAvailableBarriers, new Barrier(barrier));
                    } else {
                        this.mLeftAvailableBarriers = enqueue(this.mLeftAvailableBarriers, new Barrier(barrier));
                        this.mRightAvailableBarriers = enqueue(this.mRightAvailableBarriers, new Barrier(barrier));
                    }
                }
            }
        }
    }

    private TargetInfo computeAvailableRects(TargetInfo info, boolean isLeftPrefer) {
        TargetInfo targetInfo;
        int targetHeight;
        int targetWidth;
        boolean isTargetInLeftScreen;
        TargetInfo targetInfo2 = info;
        if (targetInfo2 == null) {
            View target = this.mTarget;
            int[] targetLoc = new int[2];
            target.getLocationOnScreen(targetLoc);
            targetWidth = target.getWidth();
            targetHeight = target.getHeight();
            boolean z = false;
            Rect targetRect = new Rect(targetLoc[0], targetLoc[1], targetLoc[0] + targetWidth, targetLoc[1] + targetHeight);
            int ox = targetRect.centerX();
            int oy = targetRect.centerY();
            int i2 = this.mScreenWidth / 2;
            if (!isLeftPrefer ? ox < i2 : ox <= i2) {
                z = true;
            }
            isTargetInLeftScreen = z;
            targetInfo = new TargetInfo();
            targetInfo.rect = targetRect;
            targetInfo.width = targetWidth;
            targetInfo.height = targetHeight;
            targetInfo.ox = ox;
            targetInfo.oy = oy;
            targetInfo.isInLeftScreen = isTargetInLeftScreen;
        } else {
            targetWidth = targetInfo2.width;
            targetHeight = targetInfo2.height;
            isTargetInLeftScreen = targetInfo2.isInLeftScreen;
            targetInfo = info;
        }
        Barrier barrier = isTargetInLeftScreen ? this.mLeftAvailableBarriers : this.mRightAvailableBarriers;
        if (barrier != null) {
            barrier.item.setTag(R.id.tag_barrier_available_rect_top, (Object) null);
            barrier.item.setTag(R.id.tag_barrier_available_rect_bottom, (Object) null);
            Rect FirstRect = (Rect) barrier.item.getTag(R.id.tag_barrier_rect);
            if (FirstRect.top - this.mValidRect.top >= targetHeight) {
                Rect availableRect = new Rect();
                Rect rect = this.mValidRect;
                availableRect.left = isTargetInLeftScreen ? rect.left : rect.right - targetWidth;
                availableRect.top = this.mValidRect.top;
                availableRect.right = availableRect.left + targetWidth;
                availableRect.bottom = FirstRect.top;
                barrier.item.setTag(R.id.tag_barrier_available_rect_top, availableRect);
                targetInfo.hasAvailableRect = true;
            }
        } else {
            targetInfo.hasAvailableRect = true;
        }
        while (barrier != null) {
            Rect curRect = (Rect) barrier.item.getTag(R.id.tag_barrier_rect);
            Barrier<V> barrier2 = barrier.next;
            if (barrier2 != null) {
                barrier2.item.setTag(R.id.tag_barrier_available_rect_top, (Object) null);
                barrier2.item.setTag(R.id.tag_barrier_available_rect_bottom, (Object) null);
                Rect nextRect = (Rect) barrier2.item.getTag(R.id.tag_barrier_rect);
                int gap = nextRect.top - curRect.bottom;
                if (gap > 0 && gap >= targetHeight) {
                    Rect availableRect2 = new Rect();
                    Rect rect2 = this.mValidRect;
                    availableRect2.left = isTargetInLeftScreen ? rect2.left : rect2.right - targetWidth;
                    availableRect2.top = curRect.bottom;
                    availableRect2.right = availableRect2.left + targetWidth;
                    availableRect2.bottom = nextRect.top;
                    barrier.item.setTag(R.id.tag_barrier_available_rect_bottom, availableRect2);
                    barrier2.item.setTag(R.id.tag_barrier_available_rect_top, availableRect2);
                    targetInfo.hasAvailableRect = true;
                }
            } else if (this.mValidRect.bottom - curRect.bottom >= targetHeight) {
                Rect availableRect3 = new Rect();
                Rect rect3 = this.mValidRect;
                availableRect3.left = isTargetInLeftScreen ? rect3.left : rect3.right - targetWidth;
                availableRect3.top = curRect.bottom;
                availableRect3.right = availableRect3.left + targetWidth;
                availableRect3.bottom = this.mValidRect.bottom;
                barrier.item.setTag(R.id.tag_barrier_available_rect_bottom, availableRect3);
                targetInfo.hasAvailableRect = true;
            }
            barrier = barrier.next;
        }
        return targetInfo;
    }

    private Rect computeDestinationRect(TargetInfo targetInfo, boolean isLeftPrefer, int recurrentCount) {
        int i2;
        TargetInfo targetInfo2 = targetInfo;
        boolean z = isLeftPrefer;
        int i3 = recurrentCount;
        if (i3 > 5) {
            return null;
        }
        Rect targetRect = targetInfo2.rect;
        int targetWidth = targetInfo2.width;
        int targetHeight = targetInfo2.height;
        int ox = targetInfo2.ox;
        int oy = targetInfo2.oy;
        boolean isTargetInLeftScreen = targetInfo2.isInLeftScreen;
        Rect prevTopAvailableRect = null;
        for (Barrier barrier = isTargetInLeftScreen ? this.mLeftAvailableBarriers : this.mRightAvailableBarriers; barrier != null; barrier = barrier.next) {
            Rect tempRect = (Rect) barrier.item.getTag(R.id.tag_barrier_available_rect_top);
            if (tempRect != null) {
                prevTopAvailableRect = tempRect;
            }
            Rect curRect = (Rect) barrier.item.getTag(R.id.tag_barrier_rect);
            int bx = curRect.centerX();
            Rect rect = tempRect;
            int by = curRect.centerY();
            int width = curRect.width();
            Rect rect2 = curRect;
            int i4 = bx;
            boolean isYCross = Math.abs(oy - by) < (targetHeight / 2) + (curRect.height() / 2);
            if (isYCross) {
                boolean isTargetCrossedBarrier = true;
                boolean isTopPriority = oy <= by;
                if (!isTopPriority || prevTopAvailableRect == null) {
                    int i5 = by;
                    boolean z2 = isTopPriority;
                    Barrier barrier2 = barrier;
                    while (barrier2 != null) {
                        Rect nextBottomAvailableRect = (Rect) barrier2.item.getTag(R.id.tag_barrier_available_rect_bottom);
                        if (nextBottomAvailableRect == null) {
                            barrier2 = barrier2.next;
                        } else if (prevTopAvailableRect == null || Math.abs(prevTopAvailableRect.bottom - oy) >= Math.abs(nextBottomAvailableRect.top - oy)) {
                            return nextBottomAvailableRect;
                        } else {
                            prevTopAvailableRect.top = prevTopAvailableRect.bottom - targetHeight;
                            return prevTopAvailableRect;
                        }
                    }
                    if (prevTopAvailableRect == null) {
                        return targetRect;
                    }
                    prevTopAvailableRect.top = prevTopAvailableRect.bottom - targetHeight;
                    return prevTopAvailableRect;
                }
                boolean z3 = isYCross;
                Barrier barrier3 = barrier;
                while (true) {
                    if (barrier3 == null) {
                        int i6 = by;
                        boolean z4 = isTopPriority;
                        break;
                    }
                    boolean isTargetCrossedBarrier2 = isTargetCrossedBarrier;
                    int by2 = by;
                    Rect nextBottomAvailableRect2 = (Rect) barrier3.item.getTag(R.id.tag_barrier_available_rect_bottom);
                    if (nextBottomAvailableRect2 != null) {
                        boolean z5 = isTopPriority;
                        if (Math.abs(nextBottomAvailableRect2.top - oy) < Math.abs(prevTopAvailableRect.bottom - oy)) {
                            return nextBottomAvailableRect2;
                        }
                    } else {
                        barrier3 = barrier3.next;
                        isTargetCrossedBarrier = isTargetCrossedBarrier2;
                        by = by2;
                    }
                }
                prevTopAvailableRect.top = prevTopAvailableRect.bottom - targetHeight;
                return prevTopAvailableRect;
            }
            int i7 = by;
        }
        if (0 != 0) {
            return null;
        }
        boolean isSkipBorder = targetRect.top < this.mValidRect.top || targetRect.bottom > this.mValidRect.bottom;
        Rect rect3 = this.mValidRect;
        targetRect.left = isTargetInLeftScreen ? rect3.left : rect3.right - targetWidth;
        if (targetRect.top < this.mValidRect.top) {
            i2 = this.mValidRect.top;
        } else {
            i2 = targetRect.bottom > this.mValidRect.bottom ? this.mValidRect.bottom - targetHeight : targetRect.top;
        }
        targetRect.top = i2;
        targetRect.right = targetRect.left + targetWidth;
        targetRect.bottom = targetRect.top + targetHeight;
        if (!isSkipBorder) {
            return targetRect;
        }
        targetInfo2.rect = targetRect;
        targetInfo2.ox = targetRect.centerX();
        targetInfo2.oy = targetRect.centerY();
        int i8 = this.mScreenWidth / 2;
        targetInfo2.isInLeftScreen = !z ? ox < i8 : ox <= i8;
        return computeDestinationRect(targetInfo2, z, i3 + 1);
    }

    public Rect getDestinationRect(View target) {
        return getDestinationRect(target, false);
    }

    public Rect getDestinationRect(View target, boolean isLeftPrefer) {
        if (target == null) {
            return null;
        }
        if (this.mScreenWidth == 0) {
            this.mScreenWidth = DeviceUtil.getScreenWidth(target.getContext().getApplicationContext());
        }
        if (this.mScreenHeight == 0) {
            this.mScreenHeight = DeviceUtil.getScreenHeight(target.getContext().getApplicationContext());
        }
        if (this.mValidRect == null) {
            this.mValidRect = new Rect();
        }
        this.mValidRect.left = this.mLeftPadding;
        this.mValidRect.top = this.mTopPadding;
        this.mValidRect.right = this.mScreenWidth - this.mRightPadding;
        this.mValidRect.bottom = this.mScreenHeight - this.mBottomPadding;
        setTarget(target);
        remove(target);
        computeBarriersRect();
        TargetInfo targetInfo = computeAvailableRects((TargetInfo) null, isLeftPrefer);
        if (!targetInfo.hasAvailableRect) {
            targetInfo.isInLeftScreen = !targetInfo.isInLeftScreen;
            targetInfo = computeAvailableRects(targetInfo, isLeftPrefer);
        }
        Rect rect = computeDestinationRect(targetInfo, isLeftPrefer, 0);
        Integer barrierType = (Integer) target.getTag(R.id.tag_barrier_type);
        if (barrierType != null) {
            add(barrierType.intValue(), target);
        } else {
            add(target);
        }
        setTarget((View) null);
        return convertScreenLoc2ViewIfNecessary(target, rect);
    }

    private Rect convertScreenLoc2ViewIfNecessary(View target, Rect inRect) {
        if (target == null || inRect == null) {
            return inRect;
        }
        ViewParent targetParent = target.getParent();
        if (targetParent instanceof ViewGroup) {
            int[] loc = new int[2];
            ((ViewGroup) targetParent).getLocationOnScreen(loc);
            inRect.top -= loc[1];
        }
        return inRect;
    }

    static class TargetInfo {
        boolean hasAvailableRect;
        int height;
        boolean isInLeftScreen;
        int ox;
        int oy;
        Rect rect;
        int width;

        TargetInfo() {
        }
    }

    private static class Barrier<V extends View> {
        V item;
        Barrier<V> next;

        Barrier(V element) {
            this.item = element;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public boolean equals(Object item2) {
            return this.item == item2;
        }
    }

    private Barrier<View> enqueue(Barrier<View> which, Barrier<View> element) {
        Barrier barrier;
        Barrier barrier2 = which;
        if (barrier2 == null || valueOf(element) < valueOf(barrier2)) {
            element.next = barrier2;
            return element;
        }
        do {
            barrier = barrier2;
            barrier2 = barrier2.next;
            if (barrier2 == null || valueOf(element) < valueOf(barrier2)) {
                barrier.next = element;
                element.next = barrier2;
            }
            barrier = barrier2;
            barrier2 = barrier2.next;
            break;
        } while (valueOf(element) < valueOf(barrier2));
        barrier.next = element;
        element.next = barrier2;
        return which;
    }

    private Barrier<View> dequeue(Barrier<View> which, View item) {
        Barrier barrier = which;
        Barrier barrier2 = null;
        while (true) {
            if (barrier == null) {
                break;
            } else if (!barrier.equals(item)) {
                barrier2 = barrier;
                barrier = barrier.next;
            } else if (barrier2 == null) {
                return null;
            } else {
                barrier2.next = barrier.next;
            }
        }
        return which;
    }

    private int valueOf(Barrier<View> element) {
        Rect rect = (Rect) element.item.getTag(R.id.tag_barrier_rect);
        return rect.top + rect.bottom;
    }
}
