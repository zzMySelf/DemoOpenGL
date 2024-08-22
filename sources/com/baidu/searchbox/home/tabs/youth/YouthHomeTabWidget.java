package com.baidu.searchbox.home.tabs.youth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TabWidget;
import com.baidu.searchbox.home.tabs.extend.ITabViewTouchListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0014J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0017H\u0017J\u001a\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010!\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/home/tabs/youth/YouthHomeTabWidget;", "Landroid/widget/TabWidget;", "Lcom/baidu/searchbox/home/tabs/youth/ClickShadowPosition;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnTabWidgetTouchListener", "", "Lcom/baidu/searchbox/home/tabs/extend/ITabViewTouchListener;", "addTabWidgetTouchListener", "", "listener", "listeners", "", "clearTabWidgetTouchListener", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onFontSizeChanged", "onInterceptTouchEvent", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "onTouchIndex", "index", "removeTabWidgetTouchListener", "lib-home-tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeTabWidget.kt */
public final class YouthHomeTabWidget extends TabWidget implements ClickShadowPosition {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final List<ITabViewTouchListener> mOnTabWidgetTouchListener;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YouthHomeTabWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOnTabWidgetTouchListener = new ArrayList();
        YouthHomeTabWidgetExt.INSTANCE.calculateSize();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YouthHomeTabWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOnTabWidgetTouchListener = new ArrayList();
        YouthHomeTabWidgetExt.INSTANCE.calculateSize();
    }

    public final void addTabWidgetTouchListener(ITabViewTouchListener listener) {
        if (listener != null && !this.mOnTabWidgetTouchListener.contains(listener)) {
            this.mOnTabWidgetTouchListener.add(listener);
        }
    }

    public final void addTabWidgetTouchListener(List<? extends ITabViewTouchListener> listeners) {
        if (listeners != null) {
            for (ITabViewTouchListener listener : listeners) {
                addTabWidgetTouchListener(listener);
            }
        }
    }

    public final void removeTabWidgetTouchListener(ITabViewTouchListener listener) {
        if (listener != null) {
            this.mOnTabWidgetTouchListener.remove(listener);
        }
    }

    public final void clearTabWidgetTouchListener() {
        this.mOnTabWidgetTouchListener.clear();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpec;
        View childAt;
        ViewGroup viewGroup;
        View childAt2;
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        ViewParent parent = getParent();
        ViewGroup it = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (it != null) {
            width += it.getPaddingLeft() + it.getPaddingRight();
        }
        int totalWidth = 0;
        int childCount = getChildCount();
        int halfTabInterval = (int) ((((float) width) * 0.09f) / ((float) 2));
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            if (child != null) {
                switch (i2) {
                    case 0:
                        int first = YouthHomeTabWidgetExt.INSTANCE.getIconWidth() + (halfTabInterval * 3);
                        totalWidth += first;
                        ShadowLayoutExtKt.setFirstX(totalWidth);
                        widthSpec = View.MeasureSpec.makeMeasureSpec(first, 1073741824);
                        child.setPadding(halfTabInterval, 0, 0, 0);
                        ViewGroup viewGroup2 = child instanceof ViewGroup ? (ViewGroup) child : null;
                        if (!(viewGroup2 == null || (childAt = viewGroup2.getChildAt(0)) == null)) {
                            childAt.setPadding(halfTabInterval, 0, halfTabInterval, 0);
                            break;
                        }
                    case 1:
                        int voice = YouthHomeTabWidgetExt.INSTANCE.getVoiceWidth() + (halfTabInterval * 2);
                        totalWidth += voice;
                        ShadowLayoutExtKt.setSecondX(totalWidth);
                        widthSpec = View.MeasureSpec.makeMeasureSpec(voice, 1073741824);
                        child.setPadding(halfTabInterval, 0, halfTabInterval, 0);
                        break;
                    default:
                        int third = YouthHomeTabWidgetExt.INSTANCE.getIconWidth() + (halfTabInterval * 3);
                        totalWidth += third;
                        ShadowLayoutExtKt.setThirdX(totalWidth);
                        widthSpec = View.MeasureSpec.makeMeasureSpec(third, 1073741824);
                        child.setPadding(0, 0, halfTabInterval, 0);
                        if (child instanceof ViewGroup) {
                            viewGroup = (ViewGroup) child;
                        } else {
                            viewGroup = null;
                        }
                        if (!(viewGroup == null || (childAt2 = viewGroup.getChildAt(0)) == null)) {
                            childAt2.setPadding(halfTabInterval, 0, halfTabInterval, 0);
                            break;
                        }
                }
                child.measure(widthSpec, View.MeasureSpec.makeMeasureSpec(YouthHomeTabWidgetExt.INSTANCE.getTabHeight(), 1073741824));
            }
        }
        setMeasuredDimension(TabWidget.resolveSize(totalWidth, widthMeasureSpec), YouthHomeTabWidgetExt.INSTANCE.getTabHeight());
    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        for (ITabViewTouchListener listener : this.mOnTabWidgetTouchListener) {
            if (listener.dispatchTouchEvent(ev)) {
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        for (ITabViewTouchListener listener : this.mOnTabWidgetTouchListener) {
            if (listener.onInterceptTouchEvent(ev)) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        for (ITabViewTouchListener listener : this.mOnTabWidgetTouchListener) {
            if (listener.onTouchEvent(event)) {
                return true;
            }
        }
        return super.onTouchEvent(event);
    }

    public final void onFontSizeChanged() {
        YouthHomeTabWidgetExt.INSTANCE.calculateSize();
        ViewGroup.LayoutParams $this$onFontSizeChanged_u24lambda_u2d1 = getLayoutParams();
        if ($this$onFontSizeChanged_u24lambda_u2d1 != null) {
            $this$onFontSizeChanged_u24lambda_u2d1.height = YouthHomeTabWidgetExt.INSTANCE.getTabHeight();
            setLayoutParams($this$onFontSizeChanged_u24lambda_u2d1);
        }
        requestLayout();
    }

    public void onTouchIndex(int index, MotionEvent event) {
        boolean z = false;
        if (index >= 0 && index < getChildCount()) {
            z = true;
        }
        if (z) {
            View childAt = getChildAt(index);
            ViewGroup viewGroup = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup != null) {
                viewGroup.dispatchTouchEvent(event);
            }
        }
    }
}
