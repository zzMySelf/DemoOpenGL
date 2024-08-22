package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.lightapp.business.LightappBrowserWebView;

public class LangbridgeSlideLayout extends PullToRefreshBase<ViewGroup> {
    public LightappBrowserWebView a;
    public ViewGroup b;
    public boolean c = true;

    public LangbridgeSlideLayout(Context context) {
        super(context);
    }

    public LoadingLayout createFooterLoadingLayout(Context context, AttributeSet attributeSet) {
        return null;
    }

    public LoadingLayout createHeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        return new LoadingLayout(context) {
            public View createLoadingView(Context context, AttributeSet attributeSet) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, 55));
                return linearLayout;
            }

            public int getContentSize() {
                return (int) getResources().getDimension(ResUtils.dimen(getContext(), "wallet_base_header_max_padding"));
            }
        };
    }

    public boolean isReadyForPullDown() {
        LightappBrowserWebView lightappBrowserWebView = this.a;
        return lightappBrowserWebView != null && lightappBrowserWebView.isTop && this.c;
    }

    public boolean isReadyForPullUp() {
        return false;
    }

    public void setSupportPullDown(boolean z) {
        this.c = z;
        if (!z) {
            scrollTo(0, 0);
        }
    }

    public void setTarget(LightappBrowserWebView lightappBrowserWebView) {
        this.a = lightappBrowserWebView;
        ViewGroup viewGroup = this.b;
        if (viewGroup != null && lightappBrowserWebView != null) {
            viewGroup.addView(lightappBrowserWebView, -1, -1);
        }
    }

    public void startRefreshing() {
    }

    public ViewGroup createRefreshableView(Context context, AttributeSet attributeSet) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        return frameLayout;
    }

    public LangbridgeSlideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
