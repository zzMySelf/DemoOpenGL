package com.baidu.sapi2.activity.social;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class BaseSSOLoginActivity extends SocialLoginBase {
    public static final String l = "BaseSSOLoginActivity";
    public static final int m = 2001;
    public static final String n = "extraJson";

    /* renamed from: o  reason: collision with root package name */
    public static final String f956o = "sceneFrom";
    public static final String p = "isVerification";
    public static final String q = "isFromLogin";
    public boolean a;
    public Handler b;
    public Dialog c;
    public String d;
    public boolean e;
    public boolean f;
    public int g;
    public String h;

    /* renamed from: i  reason: collision with root package name */
    public WebAuthResult f957i = new a();
    public com.baidu.sapi2.a.a.b j = new b();
    public AuthorizationListener k = new c();

    public class c extends AuthorizationListener {
        public c() {
        }

        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                CoreViewRouter.getInstance().getWebAuthListener().beforeSuccess(sapiAccount);
            }
        }

        public void onFailed(int i2, String str) {
            Log.d(BaseSSOLoginActivity.l, "authorizationListener onFailed: " + i2 + " " + str);
            if (BaseSSOLoginActivity.this.g == 2001) {
                Log.d(BaseSSOLoginActivity.l, "onFailed: EXTRA_PARAM_FROM_LOGIN");
                Intent intent = new Intent();
                intent.putExtra("result_code", i2);
                intent.putExtra("result_msg", str);
                String str2 = BaseSSOLoginActivity.this.h;
                if (str2 != null) {
                    intent.putExtra(AbstractThirdPartyService.EXTRA_RESULT_TEXT, str2);
                }
                BaseSSOLoginActivity.this.a(1002, intent);
            } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                BaseSSOLoginActivity.this.f957i.setResultCode(i2);
                BaseSSOLoginActivity.this.f957i.setResultMsg(str);
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(BaseSSOLoginActivity.this.f957i);
                CoreViewRouter.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }

        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("onSuccess: ");
            sb.append(accountType != null ? accountType.name() : StringUtil.NULL_STRING);
            objArr[0] = sb.toString();
            Log.d(BaseSSOLoginActivity.l, objArr);
            if (!BaseSSOLoginActivity.this.a) {
                if (SapiContext.getInstance().mLastLoginType != null) {
                    Log.e(BaseSSOLoginActivity.l, "setPreLoginType is " + SapiContext.getInstance().mLastLoginType.getName());
                    SapiContext.getInstance().setPreLoginType(SapiContext.getInstance().mLastLoginType.getName());
                } else {
                    Log.e(BaseSSOLoginActivity.l, "setPreLoginType mLastLoginType is null!");
                }
                WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                if (webAuthListener != null) {
                    Log.d(BaseSSOLoginActivity.l, "onSuccess: webAuthListener, openid:" + SapiAccountManager.getInstance().getSession().getSocialOpenId());
                    WebAuthResult webAuthResult = BaseSSOLoginActivity.this.f957i;
                    webAuthResult.accountType = accountType;
                    webAuthResult.setResultCode(0);
                    webAuthListener.onSuccess(BaseSSOLoginActivity.this.f957i);
                }
                int i2 = BaseSSOLoginActivity.this.g;
                if (i2 == 2001) {
                    WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
                    if (webRegDTO == null) {
                        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
                        if (webLoginDTO != null && webLoginDTO.finishActivityAfterSuc) {
                            BaseSSOLoginActivity.this.b(1001);
                            BaseSSOLoginActivity.this.finish();
                        }
                    } else if (webRegDTO.finishActivityAfterSuc) {
                        BaseSSOLoginActivity.this.b(1001);
                        BaseSSOLoginActivity.this.finish();
                    }
                } else if (i2 == 2003 || i2 == 2004 || i2 == 2006) {
                    BaseSSOLoginActivity.this.b(1001);
                    BaseSSOLoginActivity.this.finish();
                } else {
                    WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
                    if (socialLoginDTO != null && socialLoginDTO.finishActivityAfterSuc) {
                        if (socialLoginDTO.isReleaseAllCallback.booleanValue()) {
                            CoreViewRouter.getInstance().release();
                        }
                        BaseSSOLoginActivity.this.finish();
                    }
                }
            }
        }
    }

    public class d implements SapiWebView.OnBackCallback {
        public d() {
        }

        public void onBack() {
            if (BaseSSOLoginActivity.this.sapiWebView == null || !BaseSSOLoginActivity.this.sapiWebView.canGoBack()) {
                BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                baseSSOLoginActivity.a(baseSSOLoginActivity.g);
                return;
            }
            BaseSSOLoginActivity.this.sapiWebView.goBack();
        }
    }

    public class e implements SapiWebView.OnFinishCallback {
        public e() {
        }

        public void onFinish() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            baseSSOLoginActivity.a(baseSSOLoginActivity.g);
        }
    }

    public class f extends SapiWebView.SwitchAccountCallback {
        public f() {
        }

        public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
            Log.d(BaseSSOLoginActivity.l, "onAccountSwitch: " + BaseSSOLoginActivity.this.f);
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.f) {
                baseSSOLoginActivity.finish();
            } else if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_GRAY_THIRD_BACK).isMeetGray()) {
                BaseSSOLoginActivity.this.finish();
                Log.d(BaseSSOLoginActivity.l, "onAccountSwitch: isMeetGray ");
            } else {
                Intent intent = new Intent(BaseSSOLoginActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION);
                String str = BaseSSOLoginActivity.this.d;
                if (str != null) {
                    intent.putExtra("extraJson", str);
                }
                int i2 = result.switchAccountType;
                if (i2 == 1) {
                    intent.putExtra("username", result.userName);
                } else if (i2 == 2) {
                    if (result.loginType == 0) {
                        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME);
                    } else {
                        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                    }
                    intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, true);
                    if (!TextUtils.isEmpty(result.displayName)) {
                        intent.putExtra("username", result.displayName);
                    }
                    intent.putExtra(LoginActivity.EXTRA_PARAM_ENCRYPTED_UID, result.encryptedUid);
                }
                Log.d(BaseSSOLoginActivity.l, "onAccountSwitch: " + result.switchAccountType);
                BaseSSOLoginActivity.this.startActivityForResult(intent, 2001);
            }
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ SapiAccount a;

        public g(SapiAccount sapiAccount) {
            this.a = sapiAccount;
        }

        public void run() {
            try {
                if (BaseSSOLoginActivity.this.k != null) {
                    BaseSSOLoginActivity.this.k.beforeSuccess(this.a);
                }
            } catch (Throwable th2) {
                Log.e(th2);
            }
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append("run: + authorizeSuccess");
            sb.append(this.a);
            objArr[0] = sb.toString() != null ? this.a.displayname : "";
            Log.d(BaseSSOLoginActivity.l, objArr);
            SapiAccountManager.getInstance().validate(this.a);
            BaseSSOLoginActivity.this.a(AccountType.UNKNOWN);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ SocialResponse a;

        public h(SocialResponse socialResponse) {
            this.a = socialResponse;
        }

        public void run() {
            if (BaseSSOLoginActivity.this.k != null) {
                Log.d(BaseSSOLoginActivity.l, "run: onFailed:" + this.a.errorCode + " " + this.a.errorMsg + " " + this.a.message);
                BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
                SocialResponse socialResponse = this.a;
                baseSSOLoginActivity.h = socialResponse.message;
                baseSSOLoginActivity.k.onFailed(socialResponse.errorCode, socialResponse.errorMsg);
            }
        }
    }

    public class i extends HttpHandlerWrap {
        public final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(Looper looper, String str) {
            super(looper);
            this.a = str;
        }

        public void onFailure(Throwable th2, int i2, String str) {
            ThirdPartyUtil.wxAuthCodeMap.clear();
            ThirdPartyUtil.dingdingAuthMap.clear();
            AuthorizationListener authorizationListener = BaseSSOLoginActivity.this.k;
            if (authorizationListener != null) {
                authorizationListener.onFailed(-100, "登录失败");
            }
        }

        public void onFinish() {
            ThirdPartyUtil.wxAuthCodeMap.clear();
            ThirdPartyUtil.dingdingAuthMap.clear();
            super.onFinish();
            Log.d(BaseSSOLoginActivity.l, "onFinish: ");
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            ViewUtility.dismissDialog(baseSSOLoginActivity, baseSSOLoginActivity.c);
        }

        public void onStart() {
            super.onStart();
            BaseSSOLoginActivity.this.a(this.a);
        }

        public void onSuccess(int i2, String str, HashMap<String, String> hashMap) {
            ThirdPartyUtil.wxAuthCodeMap.clear();
            ThirdPartyUtil.dingdingAuthMap.clear();
            if (str != null) {
                try {
                    SocialResponse fromJSONObject = SocialResponse.fromJSONObject(new JSONObject(str));
                    Log.d(BaseSSOLoginActivity.l, "onSuccess-handleOpenApiAuthorizeResponse");
                    BaseSSOLoginActivity.this.a(fromJSONObject, hashMap);
                } catch (Throwable th2) {
                    Log.e(BaseSSOLoginActivity.l, th2.getMessage());
                    if (BaseSSOLoginActivity.this.k != null) {
                        Log.d(BaseSSOLoginActivity.l, "onSuccess-onFailed: SapiErrorCode.ERROR_JSON_EXCEPTION");
                        BaseSSOLoginActivity.this.k.onFailed(-501, "登录失败");
                    }
                }
            } else if (BaseSSOLoginActivity.this.k != null) {
                Log.d(BaseSSOLoginActivity.l, "onSuccess-onFailed: responseBody == null");
                BaseSSOLoginActivity.this.k.onFailed(SapiErrorCode.ERROR_RESPONSE_NULL, "登录失败");
            }
        }
    }

    public void finish() {
        ViewUtility.dismissDialog(this, this.c);
        super.finish();
    }

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getSocialLoginDTO();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Log.d(l, "onActivityResult: " + i2 + "  " + i3);
        if (i2 == 2001 && i3 == 1001) {
            Log.d(l, "onActivityResult: RESULT_CODE_SWITCH_ACCOUNT");
            this.loginStatusChange = true;
            setResult(-1, new Intent());
            finish();
        }
    }

    public void onBottomBackBtnClick() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.onKeyUp(4);
        }
    }

    public void onClose() {
        super.onClose();
        a(this.g);
    }

    public void onCreate(Bundle bundle) {
        lockScreenOrientation();
        if (Build.VERSION.SDK_INT == 26) {
            e();
        }
        super.onCreate(bundle);
        d();
    }

    public void onLeftBtnClick() {
        SapiWebView sapiWebView;
        super.onLeftBtnClick();
        if (this.executeSubClassMethod && (sapiWebView = this.sapiWebView) != null) {
            sapiWebView.onKeyUp(4);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    public void setupViews() {
        super.setupViews();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.setOnBackCallback(new d());
            this.sapiWebView.setOnFinishCallback(new e());
            this.sapiWebView.setAuthorizationListener(this.k);
            this.sapiWebView.setSwitchAccountCallback(new f());
        }
    }

    private void d() {
        super.init();
        this.g = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.d = getIntent().getStringExtra("extraJson");
        this.e = getIntent().getBooleanExtra(p, false);
        this.f = getIntent().getBooleanExtra(q, false);
        this.f957i.activity = this;
        this.b = new Handler();
    }

    private void e() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
        } catch (Throwable th2) {
            Log.e(th2);
        }
    }

    public void b(int i2) {
        setResult(i2);
    }

    public List<PassNameValuePair> c() {
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
        } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra)));
        }
        return arrayList;
    }

    public void a(int i2) {
        a(i2, -301, SapiResult.ERROR_MSG_PROCESSED_END);
    }

    public String b() {
        if (TextUtils.isEmpty(this.d)) {
            return "";
        }
        try {
            return new JSONObject(this.d).optString(f956o);
        } catch (Exception e2) {
            Log.e(e2);
            return "";
        }
    }

    public void a(int i2, int i3, String str) {
        Log.d(l, "handleBack: " + i3 + " " + str);
        if (i2 == 2001) {
            Log.d(l, "handleBack: EXTRA_PARAM_FROM_LOGIN");
            Intent intent = new Intent();
            intent.putExtra("result_code", i3);
            intent.putExtra("result_msg", str);
            a(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            Log.d(l, "handleBack: ");
            this.a = true;
            this.f957i.setResultCode(i3);
            this.f957i.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.f957i);
            CoreViewRouter.getInstance().release();
        }
        SapiUtils.hideSoftInput(this);
        finish();
    }

    public class a extends WebAuthResult {
        public a() {
        }

        public void finishActivity() {
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.g == 2001) {
                baseSSOLoginActivity.b(1001);
            } else {
                CoreViewRouter.getInstance().release();
                ThirdPartyService.releaseThirdLoginCallback();
            }
            BaseSSOLoginActivity.this.finish();
        }

        public void finishActivity(boolean z) {
            super.finishActivity(z);
            BaseSSOLoginActivity baseSSOLoginActivity = BaseSSOLoginActivity.this;
            if (baseSSOLoginActivity.g == 2001) {
                baseSSOLoginActivity.b(1001);
            } else if (z) {
                CoreViewRouter.getInstance().release();
                ThirdPartyService.releaseThirdLoginCallback();
            }
            BaseSSOLoginActivity.this.finish();
        }
    }

    public class b implements com.baidu.sapi2.a.a.b {
        public b() {
        }

        public void a(String str) {
            Log.d(BaseSSOLoginActivity.l, "onSuccess: " + str);
            Intent intent = new Intent();
            intent.putExtra(LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE, str);
            BaseSSOLoginActivity.this.a(4001, intent);
            BaseSSOLoginActivity.this.finish();
        }

        public void a() {
            Log.d(BaseSSOLoginActivity.l, "onFailure: ");
            BaseSSOLoginActivity.this.b(4001);
            BaseSSOLoginActivity.this.finish();
        }
    }

    public void a(int i2, Intent intent) {
        setResult(i2, intent);
    }

    public void a(SocialResponse socialResponse, HashMap<String, String> hashMap) {
        Log.d(l, "handleOpenApiAuthorizeResponse: " + socialResponse.errorCode);
        if (socialResponse.errorCode == 302) {
            RelativeLayout relativeLayout = this.rootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            String str = hashMap.get("mkey");
            String str2 = hashMap.get("BAIDUID");
            String str3 = hashMap.get("BDUSS");
            String str4 = hashMap.get("PTOKEN");
            String str5 = hashMap.get("STOKEN");
            String str6 = socialResponse.userInfoXmlContent;
            String str7 = socialResponse.nextUrl;
            if (this.sapiWebView != null) {
                Log.d(l, "handleOpenApiAuthorizeResponse: " + str7);
                this.sapiWebView.loadThirdPartySSOLogin(str7, str6, str, str2, str3, str4, str5);
                return;
            }
            return;
        }
        SapiAccount sapiAccountResponseToAccount = ((ThirdPartyService) CoreViewRouter.getInstance().getThirdPartyService()).sapiAccountResponseToAccount(this, socialResponse);
        if (SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
            socialResponse.errorCode = 0;
        }
        if (this.k != null) {
            int i2 = socialResponse.errorCode;
            if (i2 == 0 || i2 == 110000) {
                this.b.post(new g(sapiAccountResponseToAccount));
            } else {
                this.b.post(new h(socialResponse));
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(AccountType accountType) {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && !TextUtils.isEmpty(sapiWebView.touchidPortraitAndSign[0])) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String[] strArr = this.sapiWebView.touchidPortraitAndSign;
            currentAccount.phone = strArr[0];
            currentAccount.email = strArr[1];
            SapiContext.getInstance().addTouchidAccounts(currentAccount);
        }
        AuthorizationListener authorizationListener = this.k;
        if (authorizationListener != null) {
            try {
                if (!AuthorizationListener.class.equals(authorizationListener.getClass().getMethod("onSuccess", new Class[]{AccountType.class}).getDeclaringClass())) {
                    this.k.onSuccess(accountType);
                    return;
                }
            } catch (NoSuchMethodException e2) {
                Log.e(e2);
            }
            this.k.onSuccess();
        }
    }

    public void a(String str, String str2) {
        Log.d(l, "loadLoginInNA: " + str);
        if (this.sapiWebView == null) {
            if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
                this.f957i.setResultCode(-202);
                this.f957i.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.f957i);
            }
            CoreViewRouter.getInstance().release();
            finish();
            return;
        }
        HashMap hashMap = new HashMap();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra));
        } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
            hashMap.put("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra));
        }
        hashMap.put(f956o, b());
        hashMap.put("json", "1");
        String addExtras = ParamsUtil.addExtras(str, hashMap);
        new HttpClientWrap().get(addExtras, ReqPriority.IMMEDIATE, ParamsUtil.buildNaCookie(addExtras, this.configuration), new i(Looper.getMainLooper(), str2));
    }

    public void a(String str) {
        LoadingDialog createDialog = new LoadingDialog.Builder(this).setMessage(str).setCancelable(false).setCancelOutside(false).createDialog();
        this.c = createDialog;
        if (!createDialog.isShowing() && !isFinishing()) {
            this.c.show();
        }
    }
}
