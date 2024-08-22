package com.baidu.searchbox.feed.widget.feedflow;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.FeedRuntime;
import java.lang.reflect.Field;

public class NestedPullToRefreshView extends LongPullToRefreshView implements NestedScrollingChild3, NestedScrollingParent3 {
    private static final String TAG = "NestedPRV";
    private final NestedScrollingChildHelper mChildHelper;
    private final NestedScrollingParentHelper mParentHelper;

    public NestedPullToRefreshView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NestedPullToRefreshView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedPullToRefreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return (getNestedScrollAxes() & 2) == 0 && super.onInterceptTouchEvent(ev);
    }

    public void setNestedScrollingEnabled(boolean enabled) {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "setNestedScrollingEnabled " + enabled);
        }
        this.mChildHelper.setNestedScrollingEnabled(enabled);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int axes) {
        return this.mChildHelper.startNestedScroll(axes);
    }

    public boolean startNestedScroll(int axes, int type) {
        return this.mChildHelper.startNestedScroll(axes, type);
    }

    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }

    public void stopNestedScroll(int type) {
        this.mChildHelper.stopNestedScroll(type);
    }

    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int type) {
        return this.mChildHelper.hasNestedScrollingParent(type);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    public void dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type, int[] consumed) {
        this.mChildHelper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type, consumed);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return this.mChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.mChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.mChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }

    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return onStartNestedScroll(child, target, nestedScrollAxes, 0);
    }

    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes, int type) {
        clearChildNestedOffsets(child);
        return isNestedScrollingEnabled() && (nestedScrollAxes & 2) != 0;
    }

    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {
        onNestedScrollAccepted(child, target, nestedScrollAxes, 0);
    }

    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes, int type) {
        this.mParentHelper.onNestedScrollAccepted(child, target, nestedScrollAxes);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View target) {
        onStopNestedScroll(target, 0);
    }

    public void onStopNestedScroll(View target, int type) {
        stopNestedScroll(type);
        if (getCurrentTargetTop() > 0) {
            onRelease();
        }
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        dispatchNestedScroll(0, dyConsumed, 0, dyUnconsumed, (int[]) null);
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        dispatchNestedScroll(0, dyConsumed, 0, dyUnconsumed, (int[]) null, type);
    }

    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, int[] consumed) {
        dispatchNestedScroll(0, dyConsumed, 0, dyUnconsumed, (int[]) null, type, consumed);
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        onNestedPreScroll(target, dx, dy, consumed, 0);
    }

    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
        if (isErrorViewVisibility()) {
            setTag(true);
        } else {
            setTag(Boolean.valueOf(!canChildScrollUp()));
        }
        if (dispatchNestedPreScroll(dx, dy, consumed, (int[]) null, type)) {
            dy -= consumed[1];
        }
        if (!canChildScrollUp() && !isErrorViewVisibility() && type == 0) {
            if (dy < 0 || getCurrentTargetTop() > 0) {
                consumeDeltaY((float) (-dy));
                consumed[1] = consumed[1] + dy;
            }
        }
    }

    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return dispatchNestedFling(velocityX, velocityY, consumed);
    }

    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return dispatchNestedPreFling(velocityX, velocityY) || getCurrentTargetTop() > 0;
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    private void clearChildNestedOffsets(View child) {
        if (child instanceof RecyclerView) {
            try {
                Field field = RecyclerView.class.getDeclaredField("mNestedOffsets");
                field.setAccessible(true);
                int[] nestedOffsets = (int[]) field.get(child);
                if (FeedRuntime.GLOBAL_DEBUG) {
                    Log.d(TAG, "clearChildNestedOffsets nestedOffset = " + nestedOffsets[1]);
                }
                nestedOffsets[1] = 0;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
