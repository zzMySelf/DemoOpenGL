package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView> {
    public ScrollView b;

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isReadyForPullDown() {
        return this.b.getScrollY() == 0;
    }

    public boolean isReadyForPullUp() {
        return true;
    }

    public ScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        ScrollView scrollView = new ScrollView(context, attributeSet);
        this.b = scrollView;
        scrollView.setOverScrollMode(2);
        this.b.setVerticalScrollBarEnabled(false);
        return this.b;
    }
}
