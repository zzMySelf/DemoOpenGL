package com.tera.scan.webview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/tera/scan/webview/YKTabWebView;", "Lcom/tera/scan/webview/TeraScanWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "findViewParent", "Landroid/view/ViewParent;", "tag", "Landroid/view/View;", "onOverScrolled", "", "scrollX", "", "scrollY", "clampedX", "", "clampedY", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "lib-webview_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class YKTabWebView extends TeraScanWebView {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YKTabWebView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final ViewParent findViewParent(View view) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            return null;
        }
        if ((parent instanceof ViewPager) || (parent instanceof AbsListView) || (parent instanceof ScrollView) || (parent instanceof HorizontalScrollView) || (parent instanceof RecyclerView)) {
            return parent;
        }
        if (parent instanceof View) {
            return findViewParent((View) parent);
        }
        return null;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        ViewParent findViewParent;
        if (z && (findViewParent = findViewParent(this)) != null) {
            findViewParent.requestDisallowInterceptTouchEvent(false);
        }
        super.onOverScrolled(i2, i3, z, z2);
    }

    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        ViewParent findViewParent;
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (motionEvent.getAction() == 0 && (findViewParent = findViewParent(this)) != null) {
            findViewParent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }
}
