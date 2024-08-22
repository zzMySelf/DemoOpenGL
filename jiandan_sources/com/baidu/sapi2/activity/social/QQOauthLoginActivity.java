package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.google.android.gms.common.Scopes;
import com.tencent.connect.UnionInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

public class QQOauthLoginActivity extends BaseSSOLoginActivity implements com.baidu.sapi2.a.a.a {
    public static final String t = "QQOauthLoginActivity";
    public static final String u = "QQ未安装";
    public IUiListener r;
    public ThirdLoginCallback s;

    public class a implements IUiListener {
        public final /* synthetic */ Tencent a;
        public final /* synthetic */ com.baidu.sapi2.a.a.a b;

        public a(Tencent tencent, com.baidu.sapi2.a.a.a aVar) {
            this.a = tencent;
            this.b = aVar;
        }

        public void onCancel() {
            this.b.a();
        }

        public void onComplete(Object obj) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    String optString = jSONObject.optString("access_token");
                    String optString2 = jSONObject.optString("expires_in");
                    String optString3 = jSONObject.optString(Scopes.OPEN_ID);
                    if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                        this.b.a();
                        return;
                    }
                    this.a.setAccessToken(optString, optString2);
                    this.a.setOpenId(optString3);
                    QQOauthLoginActivity.this.a(this.a, this.b);
                }
            }
        }

        public void onError(UiError uiError) {
            this.b.a();
        }
    }

    public class b implements IUiListener {
        public final /* synthetic */ com.baidu.sapi2.a.a.a a;
        public final /* synthetic */ Tencent b;

        public b(com.baidu.sapi2.a.a.a aVar, Tencent tencent) {
            this.a = aVar;
            this.b = tencent;
        }

        public void onCancel() {
            this.a.a();
        }

        public void onComplete(Object obj) {
            if (obj != null) {
                this.a.a(this.b.getAccessToken(), this.b.getOpenId(), ((JSONObject) obj).optString("unionid"));
                return;
            }
            this.a.a();
        }

        public void onError(UiError uiError) {
            this.a.a();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Log.d(t, "requestCode = " + i2 + " resultCode = " + i3 + " data = " + intent);
        if (i2 == 11101 || i2 == 10102) {
            Tencent.onActivityResultData(i2, i3, intent, this.r);
        }
        super.onActivityResult(i2, i3, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        this.s = ThirdPartyService.getThirdLoginCallback();
        ThirdPartyService.releaseThirdLoginCallback();
        try {
            a(this);
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    private void a(com.baidu.sapi2.a.a.a aVar) {
        if (aVar != null) {
            Tencent createInstance = Tencent.createInstance(this.configuration.qqAppID, this);
            if (!SapiUtils.isAppInstalled(this, "com.tencent.mobileqq")) {
                Toast.makeText(this.configuration.context, u, 0).show();
                aVar.a();
                return;
            }
            a aVar2 = new a(createInstance, aVar);
            this.r = aVar2;
            createInstance.login(this, "all", aVar2);
        }
    }

    /* access modifiers changed from: private */
    public void a(Tencent tencent, com.baidu.sapi2.a.a.a aVar) {
        if (tencent == null || !tencent.isSessionValid()) {
            aVar.a();
        } else {
            new UnionInfo(this, tencent.getQQToken()).getUnionId(new b(aVar, tencent));
        }
    }

    public void a() {
        Log.d(t, "onAuthFailure");
        ThirdLoginCallback thirdLoginCallback = this.s;
        if (thirdLoginCallback != null) {
            thirdLoginCallback.onAuthFailure(-100, "QQ授权失败");
        }
        finish();
    }

    public void a(String str, String str2, String str3) {
        Log.d(t, "onAuthSuccess");
        String urlQQBind = ParamsUtil.getUrlQQBind(this.configuration, str, str2, str3);
        ThirdLoginCallback thirdLoginCallback = this.s;
        if (thirdLoginCallback != null) {
            thirdLoginCallback.onAuthSuccess();
        }
        a.a().a(urlQQBind, this.s);
        finish();
    }
}
