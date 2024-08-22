package com.baidu.searchbox.ng.errorview.view;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.network.netcheck.NetCheckManager;
import com.baidu.searchbox.ng.errorview.R;

public class BdWeakNetworkErrorView extends BdBaseErrorView implements IBdErrorView {
    public BdWeakNetworkErrorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BdWeakNetworkErrorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BdWeakNetworkErrorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void initView(Context context) {
        super.initView(context);
        setIcon(R.drawable.error_view_wifi_icon);
        setTitle(R.string.weak_network_load_txt);
        setLinkText(R.string.weak_network_link_txt);
    }

    /* access modifiers changed from: protected */
    public void onLinkTextClick() {
        super.onLinkTextClick();
        NetCheckManager.getInstance().startNetCheckActivity("search");
    }

    public void updateUIForNight(boolean isNightMode) {
        super.updateUIForNight(isNightMode);
        setIcon(R.drawable.error_view_wifi_icon);
    }

    public int getErrorPageType() {
        return 104;
    }
}
