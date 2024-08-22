package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import com.baidu.passport.sapi2.thirdparty.R;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.ParamsUtil;

public class TwitterSSOLoginActivity extends BaseSSOLoginActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* access modifiers changed from: protected */
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_login_twitter);
        this.sapiWebView.loadUrl(ParamsUtil.getUrlTwitterLogin(SapiAccountManager.getInstance().getConfignation()));
    }
}
