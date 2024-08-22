package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;

public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String s = SinaSSOLoginActivity.class.getSimpleName();
    public static final int t = -1;
    public IWBAPI r;

    public class a implements SdkListener {
        public a() {
        }

        public void onInitFailure(Exception exc) {
            SinaSSOLoginActivity.this.b(4001);
            ThirdPartyService.releaseThirdLoginCallback();
            SinaSSOLoginActivity.this.finish();
        }

        public void onInitSuccess() {
            ThirdPartyService.g = true;
            SinaSSOLoginActivity.this.d();
        }
    }

    public class b implements WbAuthListener {
        public b() {
        }

        public void onCancel() {
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (sinaSSOLoginActivity.e) {
                sinaSSOLoginActivity.b(4001);
                SinaSSOLoginActivity.this.finish();
                return;
            }
            sinaSSOLoginActivity.a(sinaSSOLoginActivity.g);
        }

        public void onComplete(Oauth2AccessToken oauth2AccessToken) {
            String accessToken = oauth2AccessToken.getAccessToken();
            String uid = oauth2AccessToken.getUid();
            String urlBind = ParamsUtil.getUrlBind(SinaSSOLoginActivity.this.configuration, SocialType.SINA_WEIBO_SSO, accessToken, uid, SinaSSOLoginActivity.this.configuration.sinaAppId);
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (sinaSSOLoginActivity.e) {
                Intent intent = new Intent();
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, accessToken);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_USER_ID, uid);
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.SINA_WEIBO_SSO.getType()));
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, "tsina");
                intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().sinaAppId);
                SinaSSOLoginActivity.this.a(4001, intent);
                ThirdPartyService.releaseThirdLoginCallback();
                SinaSSOLoginActivity.this.finish();
                return;
            }
            sinaSSOLoginActivity.a(urlBind, "授权微博账号登录中");
        }

        public void onError(UiError uiError) {
            Toast.makeText(SinaSSOLoginActivity.this, uiError.errorMessage, 0).show();
            SinaSSOLoginActivity sinaSSOLoginActivity = SinaSSOLoginActivity.this;
            if (sinaSSOLoginActivity.e) {
                sinaSSOLoginActivity.b(4001);
                ThirdPartyService.releaseThirdLoginCallback();
                SinaSSOLoginActivity.this.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        this.r.authorize(this, new b());
    }

    public void finish() {
        super.finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        String str = s;
        Log.d(str, "requestCode = " + i2 + " resultCode = " + i3 + " data = " + intent);
        super.onActivityResult(i2, i3, intent);
        IWBAPI iwbapi = this.r;
        if (iwbapi != null) {
            iwbapi.authorizeCallback(this, i2, i3, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setupViews();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_sina);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        SapiConfiguration sapiConfiguration = this.configuration;
        AuthInfo authInfo = new AuthInfo(this, sapiConfiguration.sinaAppId, sapiConfiguration.sinaRedirectUri, "email");
        IWBAPI createWBAPI = WBAPIFactory.createWBAPI(this);
        this.r = createWBAPI;
        if (ThirdPartyService.g) {
            d();
        } else {
            createWBAPI.registerApp(this, authInfo, new a());
        }
    }
}
