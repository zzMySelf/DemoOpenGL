package com.baidu.swan.apps.impl.map.location;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class FlipperScrollLayout extends FrameLayout {
    private static final float DRAG_SPEED_MULTIPLIER = 1.2f;
    private static final int DRAG_SPEED_SLOP = 30;
    private static final int FLING_VELOCITY_SLOP = 80;
    private static final int MIN_SCROLL_DURATION = 100;
    private static final int MOTION_DISTANCE_SLOP = 10;
    private static final float SCROLL_TO_OPEN_OFFSET_FACTOR = 0.5f;
    private int contentHeight;
    private InnerStatus currentInnerStatus = InnerStatus.HALF;
    private GestureDetector gestureDetector;
    private boolean isCurrentPointerIntercepted;
    private boolean isDraggable = true;
    private float lastDownY;
    /* access modifiers changed from: private */
    public Status lastFlingStatus = Status.OPENED;
    private float lastY;
    /* access modifiers changed from: private */
    public int maxOffset;
    private OnScrollChangedListener onScrollChangedListener;
    public int openedOffset;
    private Scroller scroller;

    private enum InnerStatus {
        EXIT,
        HALF,
        OPENED,
        MOVING,
        SCROLLING
    }

    public interface OnScrollChangedListener {
        void onScrollProgressChanged(float f2, float f3);
    }

    public enum Status {
        EXIT,
        HALF,
        OPENED
    }

    public FlipperScrollLayout(Context context) {
        super(context);
        init();
    }

    public FlipperScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FlipperScrollLayout(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        init();
    }

    private void init() {
        GestureDetector.OnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener() {
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (velocityY <= 80.0f) {
                    float space = velocityY - 80.0f;
                    if (space < 0.0f && FlipperScrollLayout.this.getScrollY() <= (-FlipperScrollLayout.this.maxOffset)) {
                        FlipperScrollLayout.this.scrollToHalf();
                        Status unused = FlipperScrollLayout.this.lastFlingStatus = Status.HALF;
                        return true;
                    } else if (space >= 0.0f || FlipperScrollLayout.this.getScrollY() <= (-FlipperScrollLayout.this.maxOffset)) {
                        return false;
                    } else {
                        FlipperScrollLayout.this.scrollToOpened();
                        Status unused2 = FlipperScrollLayout.this.lastFlingStatus = Status.OPENED;
                        return true;
                    }
                } else {
                    if (!FlipperScrollLayout.this.lastFlingStatus.equals(Status.HALF) || (-FlipperScrollLayout.this.getScrollY()) <= FlipperScrollLayout.this.maxOffset) {
                        FlipperScrollLayout.this.scrollToHalf();
                        Status unused3 = FlipperScrollLayout.this.lastFlingStatus = Status.HALF;
                    } else {
                        Status unused4 = FlipperScrollLayout.this.lastFlingStatus = Status.EXIT;
                    }
                    return true;
                }
            }
        };
        this.scroller = new Scroller(getContext(), (Interpolator) null, true);
        this.gestureDetector = new GestureDetector(getContext(), gestureListener);
    }

    private void onScrollProgressChanged(float progress) {
        OnScrollChangedListener onScrollChangedListener2 = this.onScrollChangedListener;
        if (onScrollChangedListener2 != null) {
            onScrollChangedListener2.onScrollProgressChanged(progress, ((float) (this.maxOffset - this.openedOffset)) * progress);
        }
    }

    private boolean disposeEdgeValue(int deltaY) {
        if (deltaY <= 0 && getScrollY() >= (-this.openedOffset)) {
            return true;
        }
        if (deltaY < 0 || getScrollY() > (-this.maxOffset)) {
            return false;
        }
        return true;
    }

    private void completeMove() {
        if (((float) getScrollY()) > (-(((float) (this.maxOffset - this.openedOffset)) * 0.5f))) {
            scrollToOpened();
        } else {
            scrollToHalf();
        }
    }

    /* access modifiers changed from: private */
    public void updateRecyclerViewScrollState(RecyclerView recyclerView) {
        if (recyclerView.getChildCount() == 0) {
            this.isDraggable = true;
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int[] i2 = new int[1];
        if (layoutManager instanceof LinearLayoutManager) {
            i2[0] = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            i2 = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions((int[]) null);
        }
        if (i2[0] == 0 && recyclerView.getChildAt(0).getTop() == recyclerView.getPaddingTop()) {
            this.isDraggable = true;
        } else {
            this.isDraggable = false;
        }
    }

    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        int i2 = this.maxOffset;
        int x2 = i2;
        int i3 = this.openedOffset;
        if (i2 != i3) {
            if ((-y) <= x2) {
                onScrollProgressChanged(((float) ((-y) - i3)) / ((float) (x2 - i3)));
            } else {
                onScrollProgressChanged(((float) ((-y) - x2)) / ((float) (x2 - this.contentHeight)));
            }
            if (y == (-this.openedOffset)) {
                this.currentInnerStatus = InnerStatus.OPENED;
            } else if (y == (-this.maxOffset)) {
                this.currentInnerStatus = InnerStatus.HALF;
            }
        }
    }

    public void computeScroll() {
        if (!this.scroller.isFinished() && this.scroller.computeScrollOffset()) {
            int currY = this.scroller.getCurrY();
            scrollTo(0, currY);
            if (currY == (-this.openedOffset) || currY == (-this.maxOffset)) {
                this.scroller.abortAnimation();
            } else {
                invalidate();
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (!this.isDraggable && this.currentInnerStatus == InnerStatus.OPENED) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                float y = event.getY();
                this.lastY = y;
                this.lastDownY = y;
                this.isCurrentPointerIntercepted = false;
                if (!this.scroller.isFinished()) {
                    this.scroller.forceFinished(true);
                    this.currentInnerStatus = InnerStatus.MOVING;
                    this.isCurrentPointerIntercepted = true;
                    return true;
                }
                break;
            case 1:
            case 3:
                this.isCurrentPointerIntercepted = false;
                if (this.currentInnerStatus == InnerStatus.MOVING) {
                    return true;
                }
                break;
            case 2:
                if (this.isCurrentPointerIntercepted) {
                    return true;
                }
                int deltaY = (int) (event.getY() - this.lastDownY);
                if (Math.abs(deltaY) < 10) {
                    return false;
                }
                if (this.currentInnerStatus == InnerStatus.OPENED && deltaY < 0) {
                    return false;
                }
                if (this.currentInnerStatus == InnerStatus.HALF && deltaY > 0) {
                    return false;
                }
                this.isCurrentPointerIntercepted = true;
                return true;
            default:
                return false;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!this.isCurrentPointerIntercepted) {
            return false;
        }
        this.gestureDetector.onTouchEvent(event);
        switch (event.getAction()) {
            case 0:
                this.lastY = event.getY();
                return true;
            case 1:
            case 3:
                if (this.currentInnerStatus != InnerStatus.MOVING) {
                    return false;
                }
                completeMove();
                return true;
            case 2:
                int deltaY = (int) ((event.getY() - this.lastY) * 1.2f);
                int deltaY2 = ((int) Math.signum((float) deltaY)) * Math.min(Math.abs(deltaY), 30);
                if (disposeEdgeValue(deltaY2) != 0) {
                    return true;
                }
                this.currentInnerStatus = InnerStatus.MOVING;
                int toScrollY = getScrollY() - deltaY2;
                int i2 = this.openedOffset;
                if (toScrollY >= (-i2)) {
                    scrollTo(0, -i2);
                } else {
                    scrollTo(0, Math.max(toScrollY, -this.maxOffset));
                }
                this.lastY = event.getY();
                return true;
            default:
                return false;
        }
    }

    public void scrollToHalf() {
        int offsetY;
        if (this.currentInnerStatus != InnerStatus.HALF && this.maxOffset != this.openedOffset && (offsetY = (-getScrollY()) - this.maxOffset) != 0) {
            this.currentInnerStatus = InnerStatus.SCROLLING;
            this.scroller.startScroll(0, getScrollY(), 0, offsetY, Math.abs((offsetY * 300) / (this.maxOffset - this.openedOffset)) + 100);
            invalidate();
        }
    }

    public void scrollToOpened() {
        int offsetY;
        if (this.currentInnerStatus != InnerStatus.OPENED && this.maxOffset != this.openedOffset && (offsetY = (-getScrollY()) - this.openedOffset) != 0) {
            this.currentInnerStatus = InnerStatus.SCROLLING;
            this.scroller.startScroll(0, getScrollY(), 0, offsetY, Math.abs((offsetY * 300) / (this.maxOffset - this.openedOffset)) + 100);
            invalidate();
        }
    }

    public void setOpenedOffset(int offset) {
        this.openedOffset = offset;
    }

    public void setHalfOffset(int offset) {
        this.maxOffset = this.contentHeight - offset;
    }

    public void setOnScrollChangedListener(OnScrollChangedListener listener) {
        this.onScrollChangedListener = listener;
    }

    public void setAssociatedRecyclerView(RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                FlipperScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                FlipperScrollLayout.this.updateRecyclerViewScrollState(recyclerView);
            }
        });
        updateRecyclerViewScrollState(recyclerView);
    }

    public void setHalf() {
        scrollTo(0, -this.maxOffset);
        this.currentInnerStatus = InnerStatus.HALF;
        this.lastFlingStatus = Status.HALF;
    }

    public void setToOpen() {
        scrollTo(0, -this.openedOffset);
        this.currentInnerStatus = InnerStatus.OPENED;
        this.lastFlingStatus = Status.OPENED;
    }

    public void setContentHeight(int height) {
        this.contentHeight = height;
    }
}
