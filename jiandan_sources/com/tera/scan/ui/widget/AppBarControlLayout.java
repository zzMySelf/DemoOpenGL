package com.tera.scan.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;

@CoordinatorLayout.DefaultBehavior(ControlBehavior.class)
public class AppBarControlLayout extends AppBarLayout {

    public static class ControlBehavior extends AppBarLayout.Behavior {
        public boolean qw = true;

        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        public void setScrollEnabled(boolean z) {
            this.qw = z;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr) {
            if (this.qw) {
                super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i2, i3, iArr);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5) {
            if (this.qw) {
                super.onNestedScroll(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2) {
            if (this.qw) {
                return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i2);
            }
            return false;
        }
    }

    public AppBarControlLayout(Context context) {
        super(context);
    }

    public AppBarControlLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
