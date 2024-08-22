package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.lightapp.base.LightappWebView;
import com.baidu.wallet.lightapp.base.LightappWebViewCenter;

public class LangBrigdeSlideLayout extends PullToRefreshBase<LightappWebView> {
    public LightappBrowserWebView a;
    public boolean b = true;

    public LangBrigdeSlideLayout(Context context) {
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
        return this.a.isTop && this.b;
    }

    public boolean isReadyForPullUp() {
        return false;
    }

    public void setSupportPullDown(boolean z) {
        this.b = z;
        if (!z) {
            scrollTo(0, 0);
        }
    }

    public void startRefreshing() {
    }

    public LightappWebView createRefreshableView(Context context, AttributeSet attributeSet) {
        LightappBrowserWebView lightappWebView = LightappWebViewCenter.getInstance().getLightappWebView(context);
        this.a = lightappWebView;
        if (lightappWebView != null) {
            lightappWebView.setId(ResUtils.id(context, "cust_webview"));
        }
        return this.a;
    }

    public LangBrigdeSlideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
