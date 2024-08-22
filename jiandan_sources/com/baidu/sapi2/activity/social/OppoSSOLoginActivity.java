package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.heytap.msp.bean.BizResponse;
import com.heytap.msp.oauth.bean.OAuthCodeResponse;
import com.heytap.msp.oauth.bean.OAuthRequest;
import com.heytap.msp.sdk.OAuthSdk;
import com.heytap.msp.sdk.base.callback.Callback;

public class OppoSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String t = "OppoSSOLoginActivity";
    public boolean r;
    public boolean s = true;

    public class a implements Callback<BizResponse<OAuthCodeResponse>> {
        public a() {
        }

        public void callback(BizResponse<OAuthCodeResponse> bizResponse) {
            boolean unused = OppoSSOLoginActivity.this.r = false;
            if (bizResponse == null) {
                OppoSSOLoginActivity.this.a(-202, SapiResult.ERROR_MSG_UNKNOWN);
                OppoSSOLoginActivity.this.finish();
            } else if (bizResponse.getCode() == 0) {
                String code = ((OAuthCodeResponse) bizResponse.getResponse()).getCode();
                OppoSSOLoginActivity.this.a(ParamsUtil.getUrlOppoLogin(OppoSSOLoginActivity.this.configuration, code), "授权OPPO账号登录中");
                Log.e(OppoSSOLoginActivity.t, "authCode=" + code + "，msg=" + bizResponse.getMessage());
            } else if (bizResponse.getCode() == 80082 || bizResponse.getCode() == 80083) {
                Log.e(OppoSSOLoginActivity.t, "用户取消授权");
                OppoSSOLoginActivity.this.a(-301, SapiResult.ERROR_MSG_PROCESSED_END);
            } else {
                Log.e(OppoSSOLoginActivity.t, "authCode=" + bizResponse.getCode() + "，msg=" + bizResponse.getMessage());
                OppoSSOLoginActivity.this.a(bizResponse.getCode(), bizResponse.getMessage());
            }
        }
    }

    public void d() {
        try {
            this.r = true;
            OAuthRequest oAuthRequest = new OAuthRequest();
            oAuthRequest.setAppId(this.configuration.oppoAppId);
            oAuthRequest.setAppType("APP");
            oAuthRequest.setScope("profile openid");
            oAuthRequest.setDisplay("popup");
            oAuthRequest.setPrompt("none");
            OAuthSdk.requestOauthCode(oAuthRequest, new a());
        } catch (Exception e) {
            e.printStackTrace();
            this.r = false;
            a(-202, e.getMessage());
            finish();
            Log.d(t, "e===========>" + e.toString());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void onResume() {
        super.onResume();
        if (!this.s && this.r) {
            a(-301, SapiResult.ERROR_MSG_PROCESSED_END);
        }
        this.s = false;
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_oppo);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        d();
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
