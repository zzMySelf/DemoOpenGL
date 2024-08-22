package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.yy.open.OnUIListener;
import com.yy.open.UIError;
import com.yy.open.YYOpenSDK;
import org.json.JSONObject;

public class YYSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String u = "YYSSOLoginActivity";
    public YYOpenSDK r;
    public String s;
    public OnUIListener t = new a();

    public class a implements OnUIListener {
        public a() {
        }

        public void onCancel() {
            Log.d(YYSSOLoginActivity.u, "YY授权登录 已取消");
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.a(yYSSOLoginActivity.g, -1000, AbstractThirdPartyService.RESULT_AUTH_CANCEL_MSG);
        }

        public void onComplete(JSONObject jSONObject) {
            Log.d(YYSSOLoginActivity.u, "onComplete " + jSONObject.toString());
            if (jSONObject != null) {
                if (jSONObject.has("access_code")) {
                    String unused = YYSSOLoginActivity.this.s = jSONObject.optString("access_code");
                } else if (jSONObject.has("token")) {
                    String unused2 = YYSSOLoginActivity.this.s = jSONObject.optString("token");
                }
            }
            if (!TextUtils.isEmpty(YYSSOLoginActivity.this.s)) {
                Log.d(YYSSOLoginActivity.u, "accessCode=" + YYSSOLoginActivity.this.s);
                YYSSOLoginActivity.this.d();
                return;
            }
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.a(yYSSOLoginActivity.g, -1, "未知错误");
        }

        public void onError(UIError uIError) {
            Log.d(YYSSOLoginActivity.u, "onError " + uIError.code + " " + uIError.desc);
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.a(yYSSOLoginActivity.g, uIError.code, uIError.desc);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        a(ParamsUtil.getUrlYYLogin(this.s, SapiAccountManager.getInstance().getConfignation()), "授权YY账号登录中");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        this.r.handleActivityResult(i2, i3, intent, this.t);
        super.onActivityResult(i2, i3, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation == null || TextUtils.isEmpty(confignation.yyAppId)) {
            a(this.g, -10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_MSG);
            return;
        }
        try {
            YYOpenSDK createInstance = YYOpenSDK.createInstance(getApplicationContext(), confignation.yyAppId);
            this.r = createInstance;
            createInstance.authorize(this, this.t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText("YY授权登录");
    }
}
