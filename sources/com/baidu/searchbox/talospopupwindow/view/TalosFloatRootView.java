package com.baidu.searchbox.talospopupwindow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.talospopupwindow.R;
import com.baidu.searchbox.talospopupwindow.view.TalosFloatView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R \u0010\u000b\u001a\b\u0018\u00010\fR\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/talospopupwindow/view/TalosFloatRootView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interceptListener", "Lcom/baidu/searchbox/talospopupwindow/view/TalosFloatView$FloatingInterceptTouchListener;", "Lcom/baidu/searchbox/talospopupwindow/view/TalosFloatView;", "getInterceptListener", "()Lcom/baidu/searchbox/talospopupwindow/view/TalosFloatView$FloatingInterceptTouchListener;", "setInterceptListener", "(Lcom/baidu/searchbox/talospopupwindow/view/TalosFloatView$FloatingInterceptTouchListener;)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "talospopupwindow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosFloatRootView.kt */
public final class TalosFloatRootView extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private TalosFloatView.FloatingInterceptTouchListener interceptListener;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final TalosFloatView.FloatingInterceptTouchListener getInterceptListener() {
        return this.interceptListener;
    }

    public final void setInterceptListener(TalosFloatView.FloatingInterceptTouchListener floatingInterceptTouchListener) {
        this.interceptListener = floatingInterceptTouchListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TalosFloatRootView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TalosFloatRootView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalosFloatRootView(Context context, AttributeSet attrs, int style) {
        super(context, attrs, style);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.browser_common_popup_window_layout, this);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (AppConfig.isDebug()) {
            Log.d("TalosTouchView", "onInterceptTouchEvent action = " + (event != null ? Integer.valueOf(event.getAction()) : null));
        }
        TalosFloatView.FloatingInterceptTouchListener floatingInterceptTouchListener = this.interceptListener;
        boolean z = false;
        if (floatingInterceptTouchListener != null && floatingInterceptTouchListener.onInterceptTouchEvent(event)) {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (AppConfig.isDebug()) {
            Log.d("TalosTouchView", "onTouchEvent action = " + (event != null ? Integer.valueOf(event.getAction()) : null));
        }
        TalosFloatView.FloatingInterceptTouchListener floatingInterceptTouchListener = this.interceptListener;
        boolean z = false;
        if (floatingInterceptTouchListener != null && floatingInterceptTouchListener.onInterceptTouchEvent(event)) {
            z = true;
        }
        if (z) {
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }
}
