package com.baidu.wallet.lightapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshBase;
import com.baidu.wallet.lightapp.base.LightappWebView;

public class PullToRefreshWebview extends PullToRefreshBase<LightappWebView> {
    public LightappWebView a;

    public PullToRefreshWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isReadyForPullDown() {
        return this.a.getScrollY() == 0;
    }

    public boolean isReadyForPullUp() {
        return true;
    }

    public PullToRefreshWebview(Context context) {
        super(context);
    }

    public LightappWebView createRefreshableView(Context context, AttributeSet attributeSet) {
        LightappWebView lightappWebView = new LightappWebView(context);
        this.a = lightappWebView;
        lightappWebView.setVerticalScrollBarEnabled(false);
        return this.a;
    }
}
