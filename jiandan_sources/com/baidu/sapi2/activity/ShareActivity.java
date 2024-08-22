package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.common.PassSdkModel;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.sapi2.share.ShareStatKey;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ShareActivity extends BaseActivity {
    public static final String E = "ShareActivity";
    public static final String F = "share_fail_code";
    public static final String G = "share_fail_reason";
    public static final String H = "share_account";
    public String A;
    public String B;
    public String C;
    public String D;
    public String w = "0";
    public ShareResult x = new ShareResult();
    public WebAuthListener y;
    public String z;

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        f();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            if (!PassSdkModel.getInstance().checkPassSdkInit()) {
                Log.e(E, "pass sdk没有初始化");
                this.x.setResultCode(ShareResult.ERROR_CODE_REASON_SDK_NOT_INIT);
                b(true);
                return;
            }
            String callingPackage = getCallingPackage();
            if (!PassSdkModel.getInstance().checkPkgSign(this, callingPackage)) {
                Log.d(E, callingPackage + "不是已经授权的百度系app");
                this.x.setResultCode(ShareResult.ERROR_CODE_REASON_SIGN_ERROR);
                b(false);
                return;
            }
            init();
            setupViews();
            Map<String, String> c = c();
            String str = "1";
            if (this.w.equals(str)) {
                str = "0";
            }
            c.put("is_login", str);
            StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_INVOKED, c);
        } catch (Throwable th2) {
            reportWebviewError(th2);
            this.x.setResultCode(ShareResult.ERROR_CODE_SYS_ERROR);
            b(false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.y = null;
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        f();
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                ShareActivity.this.f();
                return false;
            }
        });
        JSONObject jSONObject = new JSONObject();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        try {
            String stringExtra = getIntent().getStringExtra(ShareCallPacking.EXTRA_FROM_APP_TPL);
            this.B = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.B = "unknown";
            }
            jSONObject.put("errno", "0");
            String[] pkgIconAndName = SapiUtils.getPkgIconAndName(this, getPackageName());
            jSONObject.put("currentAPPLogo", pkgIconAndName[0]);
            String str = pkgIconAndName[1];
            this.z = str;
            jSONObject.put("currentAPPName", str);
            String[] pkgIconAndName2 = SapiUtils.getPkgIconAndName(this, getCallingPackage());
            jSONObject.put("originAPPLogo", pkgIconAndName2[0]);
            String str2 = pkgIconAndName2[1];
            this.A = str2;
            jSONObject.put("originAPPName", str2);
            if (currentAccount == null) {
                this.w = "1";
            } else {
                jSONObject.put("displayName", currentAccount.displayname);
            }
            jSONObject.put(SapiAccount.SAPI_ACCOUNT_PORTRAIT, getIntent().getStringExtra("android.intent.extra.TEXT"));
            jSONObject.put("session_id", getIntent().getStringExtra(ShareCallPacking.EXTRA_SESSION_ID));
            jSONObject.put("trace_id", getIntent().getStringExtra(ShareCallPacking.EXTRA_TRACE_ID));
            this.C = getIntent().getStringExtra(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE);
            this.D = getIntent().getStringExtra(ShareCallPacking.EXTRA_CALL_TYPE_SHARE);
            Log.d(E, "调用来源=" + this.D + ", 调起方=" + this.A + ", 被调起方=" + this.z + ", shareVer=" + this.C);
        } catch (Exception e) {
            Log.e(e);
        }
        AnonymousClass2 r1 = new SapiJsCallBacks.ShareV2LoginParams() {
            public void onError() {
                StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_EXPIRED, ShareActivity.this.c());
                if (!ShareActivity.this.w.equals("1")) {
                    String unused = ShareActivity.this.w = "2";
                }
                ShareActivity.this.e();
            }

            public void onSuccess() {
                ShareActivity.this.d();
            }
        };
        r1.pageParams = jSONObject;
        this.sapiWebView.setShareV2LoginParams(r1);
        this.sapiWebView.loadShareV2Login();
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        g();
        c(z2);
    }

    private void c(boolean z2) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("share_fail_code", "" + this.x.getResultCode());
        bundle.putString("share_fail_reason", this.x.getResultMsg());
        if (z2) {
            bundle.putString(ShareLoginModel.AUTH_APP_PKG_NAME, getPackageName());
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (currentAccount != null) {
                bundle.putString(ShareLoginModel.INVALIDATE_BDUSS, currentAccount.bduss);
            }
        }
        bundle.putString(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, this.C);
        intent.putExtras(bundle);
        setResult(-100, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void d() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            this.x.setResultCode(ShareResult.ERROR_CODE_RESULT_NULL);
            b(true);
            return;
        }
        currentAccount.app = SapiUtils.getAppName(this);
        Map<String, String> c = c();
        String str = "1";
        if (this.w.equals(str)) {
            str = "0";
        }
        c.put("is_login", str);
        StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_SUCCESS, c);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable("share_account", currentAccount);
        bundle.putInt("SDK_VERSION", 250);
        bundle.putString("PKG", getPackageName());
        bundle.putString(ShareCallPacking.EXTRA_LOGIN_TYPE_SHARE, this.C);
        if (SapiContext.getInstance().shareLivingunameEnable()) {
            bundle.putString("V2_FACE_LOGIN_UIDS_TIMES", SapiContext.getInstance().getV2FaceLivingUnames());
        }
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void e() {
        final boolean z2 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
        LoginActivity.supportShareLogin = false;
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        config.fastLoginFeatureList = new ArrayList();
        webLoginDTO.config = config;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount != null) {
            webLoginDTO.encryptedId = currentAccount.uid;
            webLoginDTO.preSetUname = currentAccount.displayname;
        }
        this.y = new WebAuthListener() {
            public void onFailure(WebAuthResult webAuthResult) {
                Map c = ShareActivity.this.c();
                c.put("code", "" + webAuthResult.getResultCode());
                StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_EXPIRED_LOGIN_FAIL, c);
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                ShareActivity.this.x.setResultCode(ShareResult.ERROR_CODE_EXPIRED_LOGIN_FAIL);
                ShareActivity.this.x.setResultMsg(String.format(ShareResult.ERROR_MSG_EXPIRED_LOGIN_FAIL, new Object[]{ShareActivity.this.z}));
                ShareActivity.this.b(true);
            }

            public void onSuccess(WebAuthResult webAuthResult) {
                StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_EXPIRED_LOGIN_SUCCESS, ShareActivity.this.c());
                LoginActivity.supportShareLogin = true;
                SapiAccountManager.getInstance().getConfignation().supportFaceLogin = z2;
                SapiWebView sapiWebView = ShareActivity.this.sapiWebView;
                if (sapiWebView != null) {
                    sapiWebView.reload();
                }
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
        };
        CoreViewRouter.getInstance().startLogin(this, this.y, webLoginDTO);
    }

    /* access modifiers changed from: private */
    public void f() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            this.x.setResultCode(ShareResult.ERROR_CODE_REASON_CANCLE);
            this.x.setResultMsg(String.format(ShareResult.ERROR_MSG_REASON_CANCLE, new Object[]{this.z}));
            b(false);
            return;
        }
        this.sapiWebView.goBack();
    }

    private void g() {
        Map<String, String> c = c();
        c.put(WXLoginActivity.y, "" + this.x.getResultCode());
        StatService.onEventAutoStat(ShareStatKey.SHARE_LOGIN_AUTH_FAIL, c);
    }

    /* access modifiers changed from: private */
    public Map<String, String> c() {
        HashMap hashMap = new HashMap();
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration != null) {
            hashMap.put("cur_tpl", sapiConfiguration.tpl);
        } else {
            hashMap.put("cur_tpl", "unknown");
        }
        hashMap.put("from_tpl", this.B);
        hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, this.D);
        hashMap.put("share_ver", this.C);
        return hashMap;
    }
}
