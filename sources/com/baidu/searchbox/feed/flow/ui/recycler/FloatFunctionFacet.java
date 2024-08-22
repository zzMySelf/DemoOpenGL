package com.baidu.searchbox.feed.flow.ui.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.feed.flow.impl.IFloatFunctionView;
import com.baidu.searchbox.feed.flow.ui.FloatFunctionAbility;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/feed/flow/ui/recycler/FloatFunctionFacet;", "Lcom/baidu/searchbox/feed/flow/ui/FloatFunctionAbility;", "pageRootView", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "floatFunctionView", "Lcom/baidu/searchbox/feed/flow/impl/IFloatFunctionView;", "attachToPage", "", "view", "onFontSizeChanged", "textSizeLevel", "", "onNightModeChanged", "isNightMode", "", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatFunctionFacet.kt */
public final class FloatFunctionFacet implements FloatFunctionAbility {
    private IFloatFunctionView floatFunctionView;
    private final ViewGroup pageRootView;

    public FloatFunctionFacet(ViewGroup pageRootView2) {
        this.pageRootView = pageRootView2;
    }

    public void attachToPage(IFloatFunctionView view2) {
        View newView;
        View oldView;
        ViewGroup viewGroup;
        if (view2 != null && (newView = view2.getView()) != null) {
            IFloatFunctionView iFloatFunctionView = this.floatFunctionView;
            if (!(iFloatFunctionView == null || (oldView = iFloatFunctionView.getView()) == null || (viewGroup = this.pageRootView) == null)) {
                viewGroup.removeView(oldView);
            }
            ViewGroup viewGroup2 = this.pageRootView;
            if (viewGroup2 != null) {
                viewGroup2.addView(newView);
            }
            this.floatFunctionView = view2;
        }
    }

    public void onFontSizeChanged(int textSizeLevel) {
        IFloatFunctionView iFloatFunctionView = this.floatFunctionView;
        if (iFloatFunctionView != null) {
            iFloatFunctionView.onFontSizeChanged();
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        IFloatFunctionView iFloatFunctionView = this.floatFunctionView;
        if (iFloatFunctionView != null) {
            iFloatFunctionView.onNightModeChanged(isNightMode);
        }
    }
}
