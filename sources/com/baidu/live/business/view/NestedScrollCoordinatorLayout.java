package com.baidu.live.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NestedScrollCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild {
    public static final int PASS_MODE_BOTH = 0;
    public static final int PASS_MODE_PARENT_FIRST = 1;
    private DummyBehavior dummyBehavior;
    private NestedScrollingChildHelper helper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PassMode {
    }

    public NestedScrollCoordinatorLayout(Context context) {
        super(context);
        init();
    }

    public NestedScrollCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NestedScrollCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.helper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        View dummyView = new View(getContext());
        this.dummyBehavior = new DummyBehavior();
        ViewCompat.setElevation(dummyView, ViewCompat.getElevation(this));
        dummyView.setFitsSystemWindows(false);
        CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(-1, -1);
        params.setBehavior(this.dummyBehavior);
        addView(dummyView, params);
    }

    public void setNestedScrollingEnabled(boolean enabled) {
        this.helper.setNestedScrollingEnabled(enabled);
    }

    public boolean isNestedScrollingEnabled() {
        return this.helper.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int axes) {
        return this.helper.startNestedScroll(axes);
    }

    public void stopNestedScroll() {
        this.helper.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.helper.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return this.helper.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return this.helper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return this.helper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return this.helper.dispatchNestedPreFling(velocityX, velocityY);
    }

    private static class DummyBehavior<DummyView extends View> extends CoordinatorLayout.Behavior<DummyView> {
        private final int[] cache = new int[2];
        private int mode = 1;

        DummyBehavior() {
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, DummyView dummyview, View directTargetChild, View target, int axes, int type) {
            return ((NestedScrollCoordinatorLayout) coordinatorLayout).startNestedScroll(axes);
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, DummyView dummyview, View target, int type) {
            ((NestedScrollCoordinatorLayout) coordinatorLayout).stopNestedScroll();
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, DummyView dummyview, View target, int dx, int dy, int[] consumed, int type) {
            NestedScrollCoordinatorLayout sheet = (NestedScrollCoordinatorLayout) coordinatorLayout;
            int i2 = this.mode;
            if (i2 == 1) {
                sheet.dispatchNestedPreScroll(dx, dy, consumed, (int[]) null);
            } else if (i2 == 0) {
                int[] iArr = this.cache;
                iArr[0] = consumed[0];
                iArr[1] = consumed[1];
                sheet.dispatchNestedPreScroll(dx, dy, iArr, (int[]) null);
            }
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, DummyView dummyview, View target, float velocityX, float velocityY) {
            boolean s = ((NestedScrollCoordinatorLayout) coordinatorLayout).dispatchNestedPreFling(velocityX, velocityY);
            if (this.mode == 1) {
                return s;
            }
            return false;
        }
    }
}
