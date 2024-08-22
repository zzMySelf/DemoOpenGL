package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import fe.mmm.qw.i.qw;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayoutBehavior extends AppBarLayout.Behavior {
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "CustomAppbarLayoutBehavior";
    public static final int TYPE_FLING = 1;
    public boolean isFlinging;
    public Method mFlingMethod;
    public Integer maxDragOffset = null;
    public int scrollState = 0;
    public final List<OnScrollStateChangedListener> scrollStateChangedListenerList = new ArrayList();
    @Nullable
    public OverScroller scroller;
    public boolean shouldBlockNestedScroll;

    public interface OnScrollStateChangedListener {
        void onScrollStateChanged(int i2);
    }

    public class OverScrollerImpl extends OverScroller {
        public OverScrollerImpl(Context context) {
            super(context);
        }

        public void abortAnimation() {
            super.abortAnimation();
            AppBarLayoutBehavior.this.dispatchScrollState(0);
        }

        public boolean computeScrollOffset() {
            boolean computeScrollOffset = super.computeScrollOffset();
            if (!computeScrollOffset) {
                AppBarLayoutBehavior.this.dispatchScrollState(0);
            }
            return computeScrollOffset;
        }
    }

    public AppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                return true;
            }
        });
        injectOverScroller(context);
    }

    /* access modifiers changed from: private */
    public void dispatchScrollState(int i2) {
        if (i2 != this.scrollState) {
            this.scrollState = i2;
            qw.ad(TAG, "dispatchScrollState: " + (i2 != 0 ? i2 != 1 ? i2 != 2 ? String.valueOf(i2) : "SCROLL_STATE_SETTLING" : "SCROLL_STATE_DRAGGING" : "SCROLL_STATE_IDLE"));
            for (int size = this.scrollStateChangedListenerList.size() - 1; size >= 0; size--) {
                OnScrollStateChangedListener onScrollStateChangedListener = this.scrollStateChangedListenerList.get(size);
                if (onScrollStateChangedListener != null) {
                    onScrollStateChangedListener.onScrollStateChanged(i2);
                }
            }
        }
    }

    private Method getFlingMethod() {
        if (this.mFlingMethod == null) {
            try {
                Method declaredMethod = Class.forName("com.google.android.material.appbar.HeaderBehavior", false, getClass().getClassLoader()).getDeclaredMethod("fling", new Class[]{CoordinatorLayout.class, View.class, Integer.TYPE, Integer.TYPE, Float.TYPE});
                this.mFlingMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception e) {
                qw.de(TAG, e.getMessage(), e);
            }
        }
        return this.mFlingMethod;
    }

    private Field getFlingRunnableField() throws NoSuchFieldException {
        try {
            return getClass().getSuperclass().getSuperclass().getDeclaredField("mFlingRunnable");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return AppBarLayoutBehavior.class.getSuperclass().getSuperclass().getSuperclass().getDeclaredField("flingRunnable");
        }
    }

    private Field getScrollerField() throws NoSuchFieldException {
        try {
            return getClass().getSuperclass().getSuperclass().getDeclaredField("mScroller");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return AppBarLayoutBehavior.class.getSuperclass().getSuperclass().getSuperclass().getDeclaredField("scroller");
        }
    }

    private void injectOverScroller(@NonNull Context context) {
        try {
            Field scrollerField = getScrollerField();
            scrollerField.setAccessible(true);
            Object obj = scrollerField.get(this);
            if (obj == null || obj.getClass() == OverScroller.class) {
                OverScrollerImpl overScrollerImpl = new OverScrollerImpl(context);
                this.scroller = overScrollerImpl;
                scrollerField.set(this, overScrollerImpl);
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e) {
            this.scroller = null;
            e.printStackTrace();
        }
    }

    private void stopAppbarLayoutFling(AppBarLayout appBarLayout) {
        try {
            Field flingRunnableField = getFlingRunnableField();
            Field scrollerField = getScrollerField();
            flingRunnableField.setAccessible(true);
            scrollerField.setAccessible(true);
            Runnable runnable = (Runnable) flingRunnableField.get(this);
            OverScroller overScroller = (OverScroller) scrollerField.get(this);
            if (runnable != null) {
                appBarLayout.removeCallbacks(runnable);
                flingRunnableField.set(this, (Object) null);
            }
            if (overScroller != null && !overScroller.isFinished()) {
                overScroller.abortAnimation();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        dispatchScrollState(0);
    }

    public void addOnScrollStateChangedListener(@NonNull OnScrollStateChangedListener onScrollStateChangedListener) {
        this.scrollStateChangedListenerList.add(onScrollStateChangedListener);
    }

    public void removeOnScrollStateChangedListener(@Nullable OnScrollStateChangedListener onScrollStateChangedListener) {
        this.scrollStateChangedListenerList.remove(onScrollStateChangedListener);
    }

    public void setMaxDragOffset(Integer num) {
        this.maxDragOffset = num;
    }

    public int getMaxDragOffset(@NonNull AppBarLayout appBarLayout) {
        if (this.maxDragOffset == null) {
            return -appBarLayout.getDownNestedScrollRange();
        }
        "frameEmpty getMaxDragOffset=" + this.maxDragOffset;
        return this.maxDragOffset.intValue();
    }

    public int getScrollRangeForDragFling(@NonNull AppBarLayout appBarLayout) {
        if (this.maxDragOffset == null) {
            return super.getScrollRangeForDragFling(appBarLayout);
        }
        "frameEmpty getScrollRangeForDragFling=-" + this.maxDragOffset;
        return -this.maxDragOffset.intValue();
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, MotionEvent motionEvent) {
        this.shouldBlockNestedScroll = false;
        if (this.isFlinging) {
            this.shouldBlockNestedScroll = true;
        }
        if (motionEvent.getActionMasked() == 0) {
            stopAppbarLayoutFling(appBarLayout);
        }
        return super.onInterceptTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
    }

    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, float f, float f2, boolean z) {
        Method flingMethod = getFlingMethod();
        if (!z && (view instanceof AbsListView) && flingMethod != null) {
            try {
                if (((Boolean) flingMethod.invoke(this, new Object[]{coordinatorLayout, appBarLayout, Integer.valueOf(-appBarLayout.getTotalScrollRange()), 0, Float.valueOf(-f2)})).booleanValue()) {
                    return true;
                }
            } catch (Exception e) {
                qw.th(TAG, e.getMessage(), e);
            }
        }
        return super.onNestedFling(coordinatorLayout, appBarLayout, view, f, f2, z);
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 1) {
            this.isFlinging = true;
        }
        if (!this.shouldBlockNestedScroll) {
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
        if (!this.shouldBlockNestedScroll) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6);
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
        stopAppbarLayoutFling(appBarLayout);
        return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i2, i3);
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
        super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i2);
        this.isFlinging = false;
        this.shouldBlockNestedScroll = false;
    }

    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull MotionEvent motionEvent) {
        OverScroller overScroller;
        boolean onTouchEvent = super.onTouchEvent(coordinatorLayout, appBarLayout, motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked == 3 && this.scroller != null) {
                    dispatchScrollState(0);
                }
            } else if (onTouchEvent && this.scroller != null) {
                dispatchScrollState(1);
            }
        } else if (onTouchEvent && (overScroller = this.scroller) != null) {
            if (overScroller.computeScrollOffset()) {
                dispatchScrollState(2);
            } else {
                dispatchScrollState(0);
            }
        }
        return onTouchEvent;
    }
}
