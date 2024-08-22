package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.aiscan.R;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import sdk.meizu.auth.MzAuthenticator;
import sdk.meizu.auth.OAuthError;
import sdk.meizu.auth.OAuthToken;
import sdk.meizu.auth.callback.ImplictCallback;

public class MeizuSSOLoginActivity extends BaseSSOLoginActivity {

    public class a extends ImplictCallback {
        public a() {
        }

        public void onError(OAuthError oAuthError) {
            MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
            meizuSSOLoginActivity.a(meizuSSOLoginActivity.g);
        }

        public void onGetToken(OAuthToken oAuthToken) {
            String accessToken = oAuthToken.getAccessToken();
            String openId = oAuthToken.getOpenId();
            if (TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId)) {
                MeizuSSOLoginActivity meizuSSOLoginActivity = MeizuSSOLoginActivity.this;
                meizuSSOLoginActivity.a(meizuSSOLoginActivity.g);
                return;
            }
            MeizuSSOLoginActivity.this.a(ParamsUtil.getUrlBind(MeizuSSOLoginActivity.this.configuration, SocialType.MEIZU, accessToken, openId, (String) null), "授权魅族账号登录中");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_mz);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        try {
            new MzAuthenticator(this.configuration.mzAppID, this.configuration.meizuRedirectUri).requestImplictAuth(this, "uc_basic_info", new a());
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }
}
