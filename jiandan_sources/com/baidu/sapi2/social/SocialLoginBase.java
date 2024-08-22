package com.baidu.sapi2.social;

import android.os.Bundle;
import android.widget.RelativeLayout;
import com.baidu.aiscan.R;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.SapiUtils;

public class SocialLoginBase extends BaseActivity implements NoProguard {
    public static WXInvokeCallback w;
    public static DingDingInvokeCallback x;
    public RelativeLayout rootView;

    private void c() {
        boolean isDarkMode = DarkModeUtil.isDarkMode(this);
        if (this.mDarkMode != isDarkMode) {
            this.mDarkMode = isDarkMode;
            switchTitleAndBottomDarkMode(isDarkMode);
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null) {
                SapiUtils.syncCookies(this, sapiWebView.buildDarkModeCookie());
                this.sapiWebView.reload();
            }
        }
    }

    public static DingDingInvokeCallback getDingDingInvokeCallback() {
        return x;
    }

    public static WXInvokeCallback getWXinvokeCallback() {
        return w;
    }

    public static void setDingDingInvokeCallback(DingDingInvokeCallback dingDingInvokeCallback) {
        x = dingDingInvokeCallback;
    }

    public static void setWXLoginCallback(WXInvokeCallback wXInvokeCallback) {
        w = wXInvokeCallback;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCanChangeUiMode = false;
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
        } catch (Throwable unused) {
        }
        this.rootView = (RelativeLayout) findViewById(R.id.root_view);
    }

    public void onResume() {
        super.onResume();
        try {
            c();
        } catch (Exception unused) {
        }
    }
}
