package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.hihonor.cloudservice.common.ApiException;
import com.hihonor.cloudservice.support.account.HonorIdSignInManager;
import com.hihonor.cloudservice.support.account.request.SignInOptionBuilder;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.account.service.HonorIDSignInService;
import com.hihonor.cloudservice.tasks.OnFailureListener;
import com.hihonor.cloudservice.tasks.OnSuccessListener;
import com.hihonor.cloudservice.tasks.Task;

public class HonorSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String s = HonorSSOLoginActivity.class.getSimpleName();
    public static final int t = 1002;
    public static final int u = 1003;
    public HonorIDSignInService r;

    public class a implements OnFailureListener {
        public a() {
        }

        public void onFailure(Exception exc) {
            if (exc instanceof ApiException) {
                String str = HonorSSOLoginActivity.s;
                Log.i(str, "silentSignIn failed : " + ((ApiException) exc).getStatusCode() + "," + exc.getMessage());
                HonorSSOLoginActivity.this.d();
                return;
            }
            String str2 = HonorSSOLoginActivity.s;
            Log.i(str2, "silentSignIn onFail :" + exc.getMessage());
            HonorSSOLoginActivity honorSSOLoginActivity = HonorSSOLoginActivity.this;
            honorSSOLoginActivity.a(-202, honorSSOLoginActivity.getString(R.string.sapi_sdk_glory_login_fail));
        }
    }

    public class b implements OnSuccessListener<SignInAccountInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onSuccess(SignInAccountInfo signInAccountInfo) {
            if (signInAccountInfo == null || TextUtils.isEmpty(signInAccountInfo.getAuthorizationCode())) {
                Log.i(HonorSSOLoginActivity.s, "doFrontLogin by accessToken is empty");
                HonorSSOLoginActivity.this.d();
                return;
            }
            String str = HonorSSOLoginActivity.s;
            Log.i(str, "getAuthorizationCode: " + signInAccountInfo.getAuthorizationCode());
            HonorSSOLoginActivity.this.b(signInAccountInfo.getAuthorizationCode());
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a(-204, getString(R.string.sapi_sdk_third_error_glory));
        } else if (this.sapiWebView != null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            this.sapiWebView.loadHonorSSOLogin(str, confignation.honorAppID, confignation.honorRedirectUri, c());
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            startActivityForResult(this.r.getSignInIntent(), 1002);
        } catch (Exception e) {
            String str = s;
            Log.i(str, "doFrontLogin Exception: " + e.getMessage());
            e.printStackTrace();
            a(-202, getString(R.string.sapi_sdk_glory_login_fail));
        }
    }

    private void e() {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null || TextUtils.isEmpty(confignation.honorAppID)) {
            a(-10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_HONOR_MSG);
        } else if (SapiDeviceInfo.getOsSdkInt() < 19) {
            a(-10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_HONOR_LOWER_THAN_19_MSG);
        } else {
            HonorIDSignInService service = HonorIdSignInManager.getService(this, new SignInOptionBuilder(SignInOptions.DEFAULT_AUTH_REQUEST_PARAM).setClientId(confignation.honorAppID).createParams());
            this.r = service;
            service.silentSignIn().addOnSuccessListener(new b()).addOnFailureListener(new a());
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1002) {
            Task parseAuthResultFromIntent = HonorIdSignInManager.parseAuthResultFromIntent(i3, intent);
            if (parseAuthResultFromIntent.isSuccessful()) {
                SignInAccountInfo signInAccountInfo = (SignInAccountInfo) parseAuthResultFromIntent.getResult();
                String str = s;
                Log.i(str, "getAuthorizationCode: " + signInAccountInfo.getAuthorizationCode());
                String str2 = s;
                Log.i(str2, "UnionId: " + signInAccountInfo.getUnionId());
                b(signInAccountInfo.getAuthorizationCode());
                return;
            }
            a(-202, getString(R.string.sapi_sdk_glory_login_fail));
            String str3 = s;
            Log.i(str3, "signIn failed: " + parseAuthResultFromIntent.getException().getStatusCode());
            return;
        }
        a(-202, getString(R.string.sapi_sdk_third_error_glory));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_glory);
        try {
            e();
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
