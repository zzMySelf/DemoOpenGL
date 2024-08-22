package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.support.hwid.HuaweiIdAuthManager;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParamsHelper;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;

public class HuaweiSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String t = HuaweiSSOLoginActivity.class.getSimpleName();
    public static final int u = 1002;
    public static final int v = 1003;
    public HuaweiIdAuthService r;
    public HuaweiIdAuthParams s;

    private void a(int i2, String str) {
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

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a(-204, getString(R.string.sapi_sdk_third_error_hw));
            return;
        }
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.loadHuaWeiSSOLogin(str, c());
        }
    }

    private void d() {
        HuaweiIdAuthParams createParams = new HuaweiIdAuthParamsHelper(HuaweiIdAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setIdToken().setAccessToken().createParams();
        this.s = createParams;
        HuaweiIdAuthService service = HuaweiIdAuthManager.getService(this, createParams);
        this.r = service;
        startActivityForResult(service.getSignInIntent(), 1002);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1002) {
            Task parseAuthResultFromIntent = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
            if (parseAuthResultFromIntent.isSuccessful()) {
                AuthHuaweiId authHuaweiId = (AuthHuaweiId) parseAuthResultFromIntent.getResult();
                String str = t;
                Log.i(str, authHuaweiId.getDisplayName() + " signIn success ");
                String str2 = t;
                Log.i(str2, "AccessToken: " + authHuaweiId.getAccessToken() + "OpenId: " + authHuaweiId.getOpenId());
                b(authHuaweiId.getAccessToken());
                return;
            }
            a(-202, getString(R.string.sapi_sdk_huawei_login_fail));
            String str3 = t;
            Log.i(str3, "signIn failed: " + parseAuthResultFromIntent.getException().getStatusCode());
        } else if (i2 == 1003) {
            Task parseAuthResultFromIntent2 = HuaweiIdAuthManager.parseAuthResultFromIntent(intent);
            if (parseAuthResultFromIntent2.isSuccessful()) {
                AuthHuaweiId authHuaweiId2 = (AuthHuaweiId) parseAuthResultFromIntent2.getResult();
                Log.i(t, "signIn get code success.");
                String str4 = t;
                Log.i(str4, "ServerAuthCode: " + authHuaweiId2.getAuthorizationCode() + "OpenId: " + authHuaweiId2.getOpenId());
                b(authHuaweiId2.getAuthorizationCode());
                return;
            }
            a(-202, getString(R.string.sapi_sdk_huawei_login_fail));
            String str5 = t;
            Log.i(str5, "signIn get code failed: " + parseAuthResultFromIntent2.getException().getStatusCode());
        } else {
            a(-202, getString(R.string.sapi_sdk_third_error_hw));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_hw);
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }
}
