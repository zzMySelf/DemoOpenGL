package com.baidu.sapi2.views.swipeback.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;

public class a {
    public static boolean a(View view, float f, float f2, boolean z) {
        return (view == null || !a(view, f, f2)) ? z : ViewCompat.canScrollVertically(view, 1);
    }

    public static boolean b(View view, float f, float f2, boolean z) {
        return (view == null || !a(view, f, f2)) ? z : ViewCompat.canScrollHorizontally(view, 1);
    }

    public static boolean c(View view, float f, float f2, boolean z) {
        return (view == null || !a(view, f, f2)) ? z : ViewCompat.canScrollHorizontally(view, -1);
    }

    public static boolean d(View view, float f, float f2, boolean z) {
        return (view == null || !a(view, f, f2)) ? z : ViewCompat.canScrollVertically(view, -1);
    }

    public static View a(ViewGroup viewGroup) {
        View a;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                if (a(childAt)) {
                    return childAt;
                }
                if ((childAt instanceof ViewGroup) && (a = a((ViewGroup) childAt)) != null) {
                    return a;
                }
            }
        }
        return null;
    }

    public static boolean a(View view) {
        return (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || (view instanceof NestedScrollView) || (view instanceof AbsListView) || (view instanceof ViewPager) || (view instanceof WebView);
    }

    public static boolean a(View view, float f, float f2) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.contains((int) f, (int) f2);
    }
}
