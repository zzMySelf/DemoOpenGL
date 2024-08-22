package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.example.oauthsdk.CFOauth;
import com.example.oauthsdk.other.CFWebError;
import com.example.oauthsdk.widget.CFAuthCallback;
import java.util.HashMap;

public class CFOSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String r = "CFOSSOLoginActivity";

    public class a implements CFAuthCallback {
        public a() {
        }

        public void onCancel() {
            Log.e(CFOSSOLoginActivity.r, "用户取消授权");
            CFOSSOLoginActivity.this.a(-301, SapiResult.ERROR_MSG_PROCESSED_END);
        }

        public void onComplete(Bundle bundle) {
            try {
                String string = bundle.getString("code");
                if (CFOSSOLoginActivity.this.sapiWebView != null) {
                    CFOSSOLoginActivity.this.a(ParamsUtil.addExtras(ParamsUtil.getUrlCFOLogin(CFOSSOLoginActivity.this.configuration, string), new HashMap()), "春风授权登录中");
                    return;
                }
                CFOSSOLoginActivity.this.a(-202, CFOSSOLoginActivity.this.getString(R.string.sapi_sdk_cfo_login_fail));
            } catch (Exception unused) {
                CFOSSOLoginActivity.this.a(-205, SapiResult.ERROR_MSG_SERVER_DATA_ERROR);
            }
        }

        public void onError(CFWebError cFWebError) {
            Log.e(CFOSSOLoginActivity.r, String.format("onError: [%s] %s", new Object[]{cFWebError.getErrorCode(), cFWebError.getMessage()}));
            CFOSSOLoginActivity cFOSSOLoginActivity = CFOSSOLoginActivity.this;
            cFOSSOLoginActivity.a(-202, cFOSSOLoginActivity.getString(R.string.sapi_sdk_cfo_login_fail));
        }
    }

    private void d() {
        CFOauth.getInstance().initCFOauth(this.configuration.cfoAppKey);
        if (this.configuration.cfoOpenDebugMode) {
            CFOauth.getInstance().openDebugMode();
        }
        CFOauth.getInstance().getCFAuthCode(this, new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.mIsCFProess = true;
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_cfo);
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.g == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i2);
            intent.putExtra("result_msg", str);
            setResult(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            this.f957i.setResultCode(i2);
            this.f957i.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.f957i);
            CoreViewRouter.getInstance().release();
        }
        finish();
    }
}
