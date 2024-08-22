package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.ThirdPartyLoginBindType;
import com.bbk.account.oauth.Oauth;
import com.bbk.account.oauth.OauthCallback;
import com.bbk.account.oauth.OauthResult;
import com.bbk.account.oauth.constant.Constant;

public class VivoSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String w = "VivoSSOLoginActivity";
    public static final String x = "params_auth_code";
    public static final String y = "params_login_bind_type_num";
    public boolean r;
    public boolean s = true;
    public Oauth t;
    public String u;
    public int v;

    public class a implements OauthCallback {
        public a() {
        }

        public void onEndLoading() {
            Log.e(VivoSSOLoginActivity.w, "getOppoAuthCode: onEndLoading");
        }

        public void onResult(OauthResult oauthResult) {
            Log.e(VivoSSOLoginActivity.w, "getOppoAuthCode: 获取结果 onResult");
            boolean unused = VivoSSOLoginActivity.this.r = false;
            if (oauthResult == null) {
                VivoSSOLoginActivity.this.a(-202, SapiResult.ERROR_MSG_UNKNOWN);
                VivoSSOLoginActivity.this.finish();
                return;
            }
            Log.e(VivoSSOLoginActivity.w, "statusCode=" + oauthResult.getStatusCode() + ", authCode=" + oauthResult.getCode() + "，msg=" + oauthResult.getStatusMsg());
            if (oauthResult.getStatusCode() != Constant.STATUS.STATUS_SUCCESS) {
                VivoSSOLoginActivity.this.a(oauthResult.getStatusCode(), oauthResult.getStatusMsg());
            } else if (VivoSSOLoginActivity.this.v == ThirdPartyLoginBindType.TYPE_ONLY_AUTH_LOGIN.getTypeNum()) {
                CoreViewRouter.getInstance().getWebAuthListener().onAuthSuccess(oauthResult.getCode());
                CoreViewRouter.getInstance().release();
                VivoSSOLoginActivity.this.finish();
            } else {
                VivoSSOLoginActivity.this.a(ParamsUtil.getUrlVivoLogin(VivoSSOLoginActivity.this.configuration, oauthResult.getCode()), "授权VIVO账号登录中");
            }
        }

        public void onStartLoading() {
            Log.e(VivoSSOLoginActivity.w, "getOppoAuthCode: onStartLoading");
        }
    }

    private void e() {
        this.u = getIntent().getStringExtra(x);
        this.v = getIntent().getIntExtra(y, 0);
    }

    public void d() {
        try {
            this.r = true;
            if (this.t == null) {
                boolean z = this.v == ThirdPartyLoginBindType.TYPE_SILENT_LOGIN_BIND.getTypeNum();
                this.t = new Oauth.Builder(this).setAppID(this.configuration.vivoAppId).setRedirectUrl(this.configuration.vivoReditUrl).setKeepCookie(true).setSilentAuth(z).build();
                Log.e(w, "getOppoAuthCode: 0.初始化 mOauth, silent=" + z);
            }
            Log.e(w, "getOppoAuthCode: 1.请求 requestCode");
            this.t.requestCode(new a(), "user_baseinfo");
        } catch (Exception e) {
            Log.e(w, "getOppoAuthCode: Exception");
            e.printStackTrace();
            this.r = false;
            a(-202, e.getMessage());
            finish();
            Log.d(w, "e===========>" + e.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e();
        setupViews();
    }

    public void onResume() {
        super.onResume();
        if (!this.s && this.r) {
            Log.e(w, "onResume: 退出");
            a(-301, SapiResult.ERROR_MSG_PROCESSED_END);
        }
        this.s = false;
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_vivo);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        Log.e(w, "setupViews: ");
        if (this.v != ThirdPartyLoginBindType.TYPE_BIND_WITH_AUTH_CODE.getTypeNum()) {
            Log.e(w, "setupViews: sso_login");
            d();
        } else if (TextUtils.isEmpty(this.u)) {
            a(-204, SapiResult.ERROR_MSG_PARAMS_ERROR);
        } else {
            Log.e(w, "setupViews: bind_with_auth_code" + this.u);
            a(ParamsUtil.getUrlVivoLogin(this.configuration, this.u), "授权VIVO账号登录中");
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
