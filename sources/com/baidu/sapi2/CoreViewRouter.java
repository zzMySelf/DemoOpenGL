package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.text.TextUtils;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.AccountRealNameActivity;
import com.baidu.sapi2.activity.AuthWidgetActivity;
import com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.activity.CertGuardianActivity;
import com.baidu.sapi2.activity.ChangeUserNameActivity;
import com.baidu.sapi2.activity.ChildVerifyActivity;
import com.baidu.sapi2.activity.CurrentProcessWebviewActivity;
import com.baidu.sapi2.activity.DoubleListActivity;
import com.baidu.sapi2.activity.HorizontalScreenLoginActivity;
import com.baidu.sapi2.activity.IdCardOcrCameraActivity;
import com.baidu.sapi2.activity.LoadExternalWebViewActivity;
import com.baidu.sapi2.activity.LoadQrUrlActivity;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.activity.NormalizeGuestAccountActivity;
import com.baidu.sapi2.activity.PersonalInfoActivity;
import com.baidu.sapi2.activity.QrLoginActivity;
import com.baidu.sapi2.activity.RegisterActivity;
import com.baidu.sapi2.activity.RemoteProcessWebviewActivity;
import com.baidu.sapi2.activity.ShareResultProxyActivity;
import com.baidu.sapi2.activity.SwitchAccountActivity;
import com.baidu.sapi2.activity.YouthStyleLoginActivity;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.callback.ActivityResultCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.CertGuardianCallback;
import com.baidu.sapi2.callback.ChangeUsernameCallback;
import com.baidu.sapi2.callback.DoubleListCallback;
import com.baidu.sapi2.callback.ExtendSysWebViewMethodCallback;
import com.baidu.sapi2.callback.FaceIDCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.IdCardOcrCallback;
import com.baidu.sapi2.callback.ImageCropCallback;
import com.baidu.sapi2.callback.LoadQrUrlCallback;
import com.baidu.sapi2.callback.NFCReadCardCallback;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.PersonalInfoCallback;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.RegisterUserFaceIDCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SmsViewLoginCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.AccountToolsDTO;
import com.baidu.sapi2.dto.CertGuardionDTO;
import com.baidu.sapi2.dto.ChangeUserNameDTO;
import com.baidu.sapi2.dto.DoubleListDTO;
import com.baidu.sapi2.dto.FaceIDRegDTO;
import com.baidu.sapi2.dto.FaceIDVerifyCertInfoDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.IdCardOcrDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.PersonalInfoDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.DarkModeUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SafeService;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatLoadLogin;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.ToastUtil;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindInfoAction;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.sofire.ac.FH;
import com.baidu.sofire.ac.ReadcardCallback;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CoreViewRouter implements NoProguard {
    private static final String J = CoreViewRouter.class.getSimpleName();
    private static final String K = "https://wappass.baidu.com/v6/securitySettings/deviceManage?adapter=3";
    private static CoreViewRouter L;
    private AccountToolsCallback A;
    private IdCardOcrCallback B;
    private CertGuardianCallback C;
    private ChangeUsernameCallback D;
    private DoubleListCallback E;
    private PersonalInfoCallback F;
    private LoadQrUrlCallback G;
    private String H;
    /* access modifiers changed from: private */
    public Context I;

    /* renamed from: a  reason: collision with root package name */
    private AbstractThirdPartyService f17606a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public WebAuthListener f17607b;

    /* renamed from: c  reason: collision with root package name */
    private WebLoginDTO f17608c;

    /* renamed from: d  reason: collision with root package name */
    private WebRegDTO f17609d;

    /* renamed from: e  reason: collision with root package name */
    private WebBindWidgetDTO f17610e;

    /* renamed from: f  reason: collision with root package name */
    private WebSocialLoginDTO f17611f;

    /* renamed from: g  reason: collision with root package name */
    private AccountCenterDTO f17612g;

    /* renamed from: h  reason: collision with root package name */
    private NormalizeGuestAccountDTO f17613h;

    /* renamed from: i  reason: collision with root package name */
    private RealNameDTO f17614i;

    /* renamed from: j  reason: collision with root package name */
    private SwitchAccountDTO f17615j;
    private IdCardOcrDTO k;
    private CertGuardionDTO l;
    private ChangeUserNameDTO m;
    private DoubleListDTO n;
    private PersonalInfoDTO o;
    private AccountCenterCallback p;
    private AccountRealNameCallback q;
    private WebBindWidgetCallback r;
    private ImageCropCallback s;
    private ActivityResultCallback t;
    private QrLoginCallback u;
    private SmsViewLoginCallback v;
    private NormalizeGuestAccountCallback w;
    private AuthWidgetCallback x;
    /* access modifiers changed from: private */
    public ExtendSysWebViewMethodCallback y;
    /* access modifiers changed from: private */
    public OneKeyLoginCallback z;

    class a extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ExtendSysWebViewMethodResult f17622a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ExtendSysWebViewMethodCallback f17623b;

        a(ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.f17622a = extendSysWebViewMethodResult;
            this.f17623b = extendSysWebViewMethodCallback;
        }

        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f17622a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.f17623b.onFinish(extendSysWebViewMethodResult);
        }

        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            ExtendSysWebViewMethodResult extendSysWebViewMethodResult = this.f17622a;
            extendSysWebViewMethodResult.recogResult = passFaceRecogResult;
            this.f17623b.onFinish(extendSysWebViewMethodResult);
        }
    }

    class b extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17625a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17626b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f17627c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17628d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ SapiAccount f17629e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ PassFaceRecogCallback f17630f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ExtendSysWebViewMethodResult f17631g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ExtendSysWebViewMethodCallback f17632h;

        b(Activity activity, String str, Map map, String str2, SapiAccount sapiAccount, PassFaceRecogCallback passFaceRecogCallback, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
            this.f17625a = activity;
            this.f17626b = str;
            this.f17627c = map;
            this.f17628d = str2;
            this.f17629e = sapiAccount;
            this.f17630f = passFaceRecogCallback;
            this.f17631g = extendSysWebViewMethodResult;
            this.f17632h = extendSysWebViewMethodCallback;
        }

        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            this.f17631g.params.put(BaiduRimConstants.RETCODE_KEY, Integer.valueOf(getTplStokenResult.getResultCode()));
            this.f17631g.params.put("retMsg", getTplStokenResult.getResultMsg());
            this.f17632h.onFinish(this.f17631g);
        }

        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            BiometricsManager.getInstance().recogWithBduss(this.f17625a, this.f17626b, this.f17627c, this.f17628d, this.f17629e.bduss, getTplStokenResult.tplStokenMap.get("pp"), this.f17630f);
        }

        public void onFinish() {
        }

        public void onStart() {
        }
    }

    class c implements LoadExternalWebViewActivityCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f17634a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OneKeyLoginCallback f17635b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17636c;

        c(boolean z, OneKeyLoginCallback oneKeyLoginCallback, Context context) {
            this.f17634a = z;
            this.f17635b = oneKeyLoginCallback;
            this.f17636c = context;
        }

        public void needLoadExternalWebView(String str, String str2) {
            if (this.f17634a) {
                OneKeyLoginCallback unused = CoreViewRouter.this.z = this.f17635b;
                Intent intent = new Intent(this.f17636c, LoadExternalWebViewActivity.class);
                intent.putExtra("extra_external_title", str);
                String str3 = (str2 + "&adapter=3") + "&lastLoginType=oneKeyLogin";
                if (SapiAccountManager.getInstance().getSapiConfiguration().supportFaceLogin) {
                    str3 = str3 + "&liveAbility=1";
                }
                intent.putExtra("extra_external_url", str3);
                intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_FROM, "business_from_one_key_login");
                Context context = this.f17636c;
                if (context instanceof Activity) {
                    context.startActivity(intent);
                    return;
                }
                intent.setFlags(268435456);
                CoreViewRouter.this.I.startActivity(intent);
                return;
            }
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.f17635b, -111, (String) null);
        }
    }

    class d implements ReadcardCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NFCReadCardCallback f17638a;

        d(NFCReadCardCallback nFCReadCardCallback) {
            this.f17638a = nFCReadCardCallback;
        }

        public void onBegin() {
            Log.e("NFC", "onBegin");
            NFCReadCardCallback nFCReadCardCallback = this.f17638a;
            if (nFCReadCardCallback != null) {
                nFCReadCardCallback.onBegin();
            }
        }

        public void onFailure(int i2, String str, String str2) {
            Log.e("NFC", "onFailure : i = " + i2 + ", s = " + str + ", s1 = " + str2);
            NFCReadCardCallback nFCReadCardCallback = this.f17638a;
            if (nFCReadCardCallback != null) {
                nFCReadCardCallback.onFailure(i2, str, str2);
            }
        }

        public void onSuccess(String str) {
            Log.e("NFC", "onSuccess :" + str);
            NFCReadCardCallback nFCReadCardCallback = this.f17638a;
            if (nFCReadCardCallback != null) {
                nFCReadCardCallback.onSuccess(str);
            }
        }
    }

    class e extends ShareCallPacking.ShareLoginCallBack {
        e() {
        }

        public void onFailed(int i2, String str) {
            super.onFailed(i2, str);
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(i2);
            webAuthResult.setResultMsg(str);
            WebAuthListener a2 = CoreViewRouter.this.f17607b;
            CoreViewRouter.getInstance().release();
            if (a2 != null) {
                a2.onFailure(webAuthResult);
            }
        }

        public void onSuccess() {
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.accountType = AccountType.NORMAL;
            webAuthResult.setResultCode(0);
            if (CoreViewRouter.this.f17607b != null) {
                CoreViewRouter.this.f17607b.onSuccess(webAuthResult);
            }
            CoreViewRouter.getInstance().release();
        }
    }

    class f extends WebAuthListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ QrLoginCallback f17641a;

        f(QrLoginCallback qrLoginCallback) {
            this.f17641a = qrLoginCallback;
        }

        public void onFailure(WebAuthResult webAuthResult) {
            QrLoginCallback qrLoginCallback = this.f17641a;
            if (qrLoginCallback != null) {
                qrLoginCallback.onLocalLogin(webAuthResult);
            }
        }

        public void onSuccess(WebAuthResult webAuthResult) {
            QrLoginCallback qrLoginCallback = this.f17641a;
            if (qrLoginCallback != null) {
                qrLoginCallback.onLocalLogin(webAuthResult);
            }
        }
    }

    class g extends QrLoginCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ QrLoginCallback f17643a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f17644b;

        g(QrLoginCallback qrLoginCallback, List list) {
            this.f17643a = qrLoginCallback;
            this.f17644b = list;
        }

        public void onFinish(QrLoginResult qrLoginResult) {
            this.f17643a.onFinish(qrLoginResult);
            if (this.f17644b.size() == 1) {
                ((WebAuthResult) this.f17644b.get(0)).finishActivity();
                this.f17643a.onLocalLogin((WebAuthResult) this.f17644b.get(0));
            }
        }

        public void onLocalLogin(WebAuthResult webAuthResult) {
        }
    }

    class h extends WebAuthListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f17646a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17647b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f17648c;

        h(List list, String str, boolean z) {
            this.f17646a = list;
            this.f17647b = str;
            this.f17648c = z;
        }

        public void onFailure(WebAuthResult webAuthResult) {
        }

        public void onSuccess(WebAuthResult webAuthResult) {
            this.f17646a.add(webAuthResult);
            String str = this.f17647b;
            String str2 = GameCenterUtils.SCHEME_SWAN_SUFFIX;
            if (str.indexOf(str2) > 0) {
                str2 = "&";
            }
            CoreViewRouter.this.a(this.f17647b + str2 + "login_action_type=" + SapiUtils.getLastLoginType() + "&clientfrom=android", this.f17648c);
        }
    }

    class i extends AuthWidgetCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17650a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RegisterUserFaceIDCallback f17651b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FaceIDRegDTO f17652c;

        i(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
            this.f17650a = activity;
            this.f17651b = registerUserFaceIDCallback;
            this.f17652c = faceIDRegDTO;
        }

        public void onFailure(SapiResult sapiResult) {
            this.f17651b.onFailure(sapiResult);
        }

        public void onSuccess(String str) {
            CoreViewRouter coreViewRouter = CoreViewRouter.this;
            Activity activity = this.f17650a;
            RegisterUserFaceIDCallback registerUserFaceIDCallback = this.f17651b;
            FaceIDRegDTO faceIDRegDTO = this.f17652c;
            coreViewRouter.b(activity, registerUserFaceIDCallback, "faceDetect", str, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence, faceIDRegDTO.isCurrentProcessShowAgreement);
        }
    }

    class j extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17654a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FaceIDVerifyDTO f17655b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ VerifyUserFaceIDCallback f17656c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ RealNameFaceIDResult f17657d;

        j(Activity activity, FaceIDVerifyDTO faceIDVerifyDTO, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult) {
            this.f17654a = activity;
            this.f17655b = faceIDVerifyDTO;
            this.f17656c = verifyUserFaceIDCallback;
            this.f17657d = realNameFaceIDResult;
        }

        /* renamed from: a */
        public void onFailure(GetTplStokenResult getTplStokenResult) {
            this.f17657d.setResultCode(getTplStokenResult.getResultCode());
            this.f17657d.setResultMsg(getTplStokenResult.getResultMsg());
            this.f17656c.onFailure(this.f17657d);
        }

        /* renamed from: b */
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            String str = getTplStokenResult.tplStokenMap.get("pp");
            if (!TextUtils.isEmpty(str)) {
                CoreViewRouter coreViewRouter = CoreViewRouter.this;
                Activity activity = this.f17654a;
                FaceIDVerifyDTO faceIDVerifyDTO = this.f17655b;
                coreViewRouter.a(activity, faceIDVerifyDTO.subpro, (Map<String, String>) null, "0", faceIDVerifyDTO.bduss, str, faceIDVerifyDTO.businessSence, this.f17656c, this.f17657d, faceIDVerifyDTO.isCurrentProcessShowAgreement);
                return;
            }
            this.f17657d.setResultCode(-402);
            this.f17657d.setResultMsg("服务异常，请稍后再试");
            this.f17656c.onFailure(this.f17657d);
        }

        public void onFinish() {
        }

        public void onStart() {
        }
    }

    class k extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RealNameFaceIDResult f17659a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VerifyUserFaceIDCallback f17660b;

        k(RealNameFaceIDResult realNameFaceIDResult, VerifyUserFaceIDCallback verifyUserFaceIDCallback) {
            this.f17659a = realNameFaceIDResult;
            this.f17660b = verifyUserFaceIDCallback;
        }

        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f17659a.setResultCode(passFaceRecogResult.getResultCode());
            this.f17659a.setResultMsg(passFaceRecogResult.getResultMsg());
            this.f17660b.onFailure(this.f17659a);
        }

        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            this.f17659a.setResultCode(passFaceRecogResult.getResultCode());
            this.f17659a.setResultMsg(passFaceRecogResult.getResultMsg());
            RealNameFaceIDResult realNameFaceIDResult = this.f17659a;
            realNameFaceIDResult.authSid = passFaceRecogResult.authSid;
            realNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
            realNameFaceIDResult.setResultCode(0);
            this.f17660b.onSuccess(this.f17659a);
        }
    }

    class l extends PassFaceRecogCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UnRealNameFaceIDResult f17662a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17663b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FaceIDCallback f17664c;

        l(UnRealNameFaceIDResult unRealNameFaceIDResult, String str, FaceIDCallback faceIDCallback) {
            this.f17662a = unRealNameFaceIDResult;
            this.f17663b = str;
            this.f17664c = faceIDCallback;
        }

        /* renamed from: a */
        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
            this.f17662a.setResultCode(passFaceRecogResult.getResultCode());
            this.f17664c.onFailure(this.f17662a);
        }

        /* renamed from: b */
        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
            JSONObject jSONObject;
            this.f17662a.setResultMsg(passFaceRecogResult.getResultMsg());
            if (this.f17663b.equals("faceDetect") && (jSONObject = passFaceRecogResult.extraJson) != null) {
                this.f17662a.registerResult = jSONObject.toString();
            }
            UnRealNameFaceIDResult unRealNameFaceIDResult = this.f17662a;
            unRealNameFaceIDResult.callBackKey = passFaceRecogResult.callbackkey;
            if (TextUtils.isEmpty(unRealNameFaceIDResult.callBackKey)) {
                this.f17662a.setResultCode(-205);
                this.f17664c.onFailure(this.f17662a);
                return;
            }
            this.f17662a.setResultCode(0);
            this.f17664c.onSuccess(this.f17662a);
        }
    }

    class m implements SapiCallback<SapiResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f17666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f17667b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ExtendSysWebViewMethodCallback f17668c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f17669d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ExtendSysWebViewMethodResult f17670e;

        m(int i2, Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
            this.f17666a = i2;
            this.f17667b = activity;
            this.f17668c = extendSysWebViewMethodCallback;
            this.f17669d = jSONObject;
            this.f17670e = extendSysWebViewMethodResult;
        }

        public void onFailure(SapiResult sapiResult) {
            this.f17670e.setResultCode(sapiResult.getResultCode());
            this.f17670e.setResultMsg(sapiResult.getResultMsg());
            this.f17668c.onFinish(this.f17670e);
        }

        public void onFinish() {
        }

        public void onStart() {
        }

        public void onSuccess(SapiResult sapiResult) {
            int i2 = this.f17666a;
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                    CoreViewRouter.this.a(this.f17667b, this.f17668c, this.f17669d, i2, this.f17670e);
                    return;
                case 5:
                    ExtendSysWebViewMethodCallback unused = CoreViewRouter.this.y = this.f17668c;
                    String optString = this.f17669d.optString("url");
                    String optString2 = this.f17669d.optString("title");
                    Intent intent = new Intent(CoreViewRouter.this.I, LoadExternalWebViewActivity.class);
                    intent.putExtra("extra_external_title", optString2);
                    intent.putExtra("extra_external_url", optString);
                    intent.setFlags(268435456);
                    CoreViewRouter.this.I.startActivity(intent);
                    return;
                case 6:
                    JSONArray optJSONArray = this.f17669d.optJSONArray("di_keys");
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        if (!TextUtils.isEmpty(optJSONArray.optString(i3))) {
                            arrayList.add(optJSONArray.optString(i3));
                        }
                    }
                    String diCookieInfo = SapiDeviceInfo.getDiCookieInfo(arrayList, false);
                    this.f17670e.params.put(BaiduRimConstants.RETCODE_KEY, "0");
                    this.f17670e.params.put("result", diCookieInfo);
                    this.f17668c.onFinish(this.f17670e);
                    return;
                default:
                    this.f17670e.params.put(BaiduRimConstants.RETCODE_KEY, "-301");
                    this.f17670e.params.put("retMsg", "action :" + this.f17666a + " is not support");
                    this.f17668c.onFinish(this.f17670e);
                    return;
            }
        }
    }

    private CoreViewRouter() {
        if (SapiAccountManager.getInstance().getSapiConfiguration() != null && SapiAccountManager.getInstance().getSapiConfiguration().context != null) {
            this.I = SapiAccountManager.getInstance().getSapiConfiguration().context;
        }
    }

    public static synchronized CoreViewRouter getInstance() {
        CoreViewRouter coreViewRouter;
        synchronized (CoreViewRouter.class) {
            if (L == null) {
                L = new CoreViewRouter();
            }
            coreViewRouter = L;
        }
        return coreViewRouter;
    }

    public void cancelRealName(Context context, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        this.y = extendSysWebViewMethodCallback;
        String cancelRealNameUrl = SapiAccountManager.getInstance().getAccountService().getCancelRealNameUrl();
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_url", cancelRealNameUrl);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void clearExtendSysWebViewMethodCallback() {
        this.y = null;
    }

    public void extendSysWebViewMethod(Activity activity, String str, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback) {
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            String optString = optJSONObject.optString("open_appid");
            String optString2 = optJSONObject.optString("open_apikey");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-310");
                extendSysWebViewMethodResult.params.put("retMsg", "因安全原因，操作失败");
                extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
                return;
            }
            SapiAccountManager.getInstance().getAccountService().extendSysWebViewMethodCheck(new m(optInt, activity, extendSysWebViewMethodCallback, optJSONObject, extendSysWebViewMethodResult), optString, optString2);
        } catch (JSONException e2) {
            Log.e(e2);
            extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, "-3");
            extendSysWebViewMethodResult.params.put("retMsg", "params is not json");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult);
        }
    }

    public AccountCenterCallback getAccountCenterCallback() {
        return this.p;
    }

    public AccountCenterDTO getAccountCenterDTO() {
        return this.f17612g;
    }

    public AccountRealNameCallback getAccountRealNameCallback() {
        return this.q;
    }

    public AccountToolsCallback getAccountToolsCallback() {
        return this.A;
    }

    public ActivityResultCallback getActivityResultCallback() {
        return this.t;
    }

    public AuthWidgetCallback getAuthWidgetCallback() {
        return this.x;
    }

    public CertGuardianCallback getCertGuardianCallback() {
        return this.C;
    }

    public CertGuardionDTO getCertGuardionDTO() {
        return this.l;
    }

    public ChangeUserNameDTO getChangeUserNameDTO() {
        return this.m;
    }

    public ChangeUsernameCallback getChangeUsernameCallback() {
        return this.D;
    }

    public DoubleListCallback getDoubleListCallback() {
        return this.E;
    }

    public DoubleListDTO getDoubleListDTO() {
        return this.n;
    }

    public ExtendSysWebViewMethodCallback getExtendSysWebViewMethodCallback() {
        return this.y;
    }

    public IdCardOcrDTO getIDCardOcrDTO() {
        return this.k;
    }

    public IdCardOcrCallback getIdCardOcrCallback() {
        return this.B;
    }

    public ImageCropCallback getImageCropCallback() {
        return this.s;
    }

    public LoadQrUrlCallback getLoadQrUrlCallback() {
        return this.G;
    }

    public NormalizeGuestAccountCallback getNormalizeGuestAccountCallback() {
        return this.w;
    }

    public NormalizeGuestAccountDTO getNormalizeGuestAccountDTO() {
        return this.f17613h;
    }

    public OneKeyLoginCallback getOneKeyLoginCallback() {
        return this.z;
    }

    public PersonalInfoCallback getPersonalInfoCallback() {
        return this.F;
    }

    public PersonalInfoDTO getPersonalInfoDTO() {
        return this.o;
    }

    public QrLoginCallback getQrLoginCallback() {
        return this.u;
    }

    public RealNameDTO getRealNameDTO() {
        return this.f17614i;
    }

    public String getSmsLoginStatExtra() {
        return this.H;
    }

    public SmsViewLoginCallback getSmsViewLoginCallback() {
        return this.v;
    }

    public WebSocialLoginDTO getSocialLoginDTO() {
        return this.f17611f;
    }

    public SwitchAccountDTO getSwitchAccountDTO() {
        return this.f17615j;
    }

    public AbstractThirdPartyService getThirdPartyService() {
        if (this.f17606a == null) {
            a();
        }
        return this.f17606a;
    }

    public WebAuthListener getWebAuthListener() {
        return this.f17607b;
    }

    public WebBindWidgetCallback getWebBindWidgetCallback() {
        return this.r;
    }

    public WebBindWidgetDTO getWebBindWidgetDTO() {
        return this.f17610e;
    }

    public WebLoginDTO getWebLoginDTO() {
        return this.f17608c;
    }

    public WebRegDTO getWebRegDTO() {
        return this.f17609d;
    }

    public void handleDingdingLoginResp(Activity activity, String str, String str2, String str3) {
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f17606a = thirdPartyService;
        if (thirdPartyService != null) {
            thirdPartyService.handleDingdingLoginResp(activity, str, str2, str3);
        }
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f17606a = thirdPartyService;
        if (thirdPartyService != null) {
            thirdPartyService.handleWXLoginResp(activity, str, str2, i2);
        }
    }

    public void invokeV2ShareLogin(Activity activity, ShareStorage.StorageModel storageModel, WebAuthListener webAuthListener, String str) {
        invokeV2ShareLogin((Context) activity, storageModel, webAuthListener, str);
    }

    public boolean isDeviceOpenNFC(Activity activity) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(activity);
        if (defaultAdapter == null) {
            return false;
        }
        return defaultAdapter.isEnabled();
    }

    public boolean isDeviceSupportNFC(Activity activity) {
        if (NfcAdapter.getDefaultAdapter(activity) == null) {
            return false;
        }
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        SafeService instance = SafeService.getInstance();
        Context context = confignation.context;
        String str = confignation.sofireAppKey;
        instance.init(context, str, str, confignation.sofireHostID, false);
        return SafeService.getInstance().isInitSuc(SafeService.SOFIRE_MODULE_ID_NFC);
    }

    public void loadAccountCenter(AccountCenterCallback accountCenterCallback, AccountCenterDTO accountCenterDTO) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            accountCenterDTO.bduss = currentAccount.bduss;
        }
        this.p = accountCenterCallback;
        this.f17612g = accountCenterDTO;
        Intent intent = new Intent(this.I, AccountCenterActivity.class);
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadAccountRealName(Context context, AccountRealNameCallback accountRealNameCallback, RealNameDTO realNameDTO) {
        this.q = accountRealNameCallback;
        this.f17614i = realNameDTO;
        Intent intent = new Intent(context, AccountRealNameActivity.class);
        if (realNameDTO != null) {
            intent.putExtra("EXTRA_BDUSS", realNameDTO.bduss);
            intent.putExtra("EXTRA_SCENE", realNameDTO.scene);
            intent.putExtra(AccountRealNameActivity.EXTRA_NEED_CB_KEY, realNameDTO.needCbKey);
            intent.putExtra(AccountRealNameActivity.EXTRA_CUSTOM_LINK, realNameDTO.customRealNameUrl);
            intent.putExtra(AccountRealNameActivity.EXTRA_REAL_NAME_LEVEL, realNameDTO.realNameLevel);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadAccountTools(AccountToolsDTO accountToolsDTO, AccountToolsCallback accountToolsCallback) {
        this.A = accountToolsCallback;
        Intent intent = new Intent(accountToolsDTO.context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_url", a(accountToolsDTO.toolsType));
        Context context = accountToolsDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        accountToolsDTO.context.startActivity(intent);
    }

    public void loadBindInfo(Context context, BindInfoAction bindInfoAction) {
        SapiAccountManager instance = SapiAccountManager.getInstance();
        if (instance == null) {
            Log.e("SapiAccountManager is null,did you init pass sdk already?", new Object[0]);
            return;
        }
        SapiConfiguration confignation = instance.getConfignation();
        if (confignation == null) {
            Log.e("SapiConfiguration is null,did you init pass sdk already?", new Object[0]);
            return;
        }
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_title", "绑定手机");
        intent.putExtra("extra_external_url", "https://wappass.baidu.com/v3/security/bindinfo?client=android&clientfrom=native&adapter=3" + "&wapsec=center&tpl=" + confignation.tpl + ParamsUtil.getBindInfoType(bindInfoAction) + ParamsUtil.buildH5CommonParams(confignation));
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public void loadBindWidget(WebBindWidgetCallback webBindWidgetCallback, WebBindWidgetDTO webBindWidgetDTO) {
        SapiAccount currentAccount;
        this.r = webBindWidgetCallback;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            webBindWidgetDTO.bduss = currentAccount.bduss;
        }
        this.f17610e = webBindWidgetDTO;
        Intent intent = new Intent(this.I, BindWidgetActivity.class);
        intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, webBindWidgetDTO.bindWidgetAction);
        intent.putExtra("EXTRA_BDUSS", webBindWidgetDTO.bduss);
        Context context = webBindWidgetDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            webBindWidgetDTO.context = this.I;
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadCertGuardian(Context context, CertGuardianCallback certGuardianCallback, CertGuardionDTO certGuardionDTO) {
        this.C = certGuardianCallback;
        this.l = certGuardionDTO;
        Intent intent = new Intent(context, CertGuardianActivity.class);
        CertGuardionDTO certGuardionDTO2 = this.l;
        if (certGuardionDTO2 != null) {
            intent.putExtra("EXTRA_SCENE", certGuardionDTO2.scene);
        }
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadChangeUsername(Context context, ChangeUsernameCallback changeUsernameCallback) {
        this.D = changeUsernameCallback;
        Intent intent = new Intent(context, ChangeUserNameActivity.class);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadChildActivity(Context context, AccountRealNameCallback accountRealNameCallback) {
        this.q = accountRealNameCallback;
        Intent intent = new Intent(context, ChildVerifyActivity.class);
        intent.putExtra("external_url", SapiAccountManager.getInstance().getAccountService().getChildVerifyUrl());
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadCurrentProcessWebviewActivity(Context context, String str, String str2) {
        SapiAccountManager instance = SapiAccountManager.getInstance();
        if (instance == null) {
            Log.e("pass sdk is not init", new Object[0]);
            return;
        }
        SapiConfiguration confignation = instance.getConfignation();
        if (confignation == null) {
            Log.e("pass sdk is not init", new Object[0]);
            return;
        }
        Intent intent = new Intent(context, CurrentProcessWebviewActivity.class);
        intent.putExtra("external_title", str);
        intent.putExtra("external_url", str2 + "&adapter=3");
        intent.putExtra("text_zoom", confignation.textZoom);
        intent.putExtra("is_dark_mode", DarkModeUtil.isDarkMode(context));
        intent.putExtra("show_bottom_back", confignation.showBottomBack);
        intent.putExtra("is_show_bottom_back_text", confignation.isShowBottomBackText);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadDoubleListActivity(Context context, DoubleListDTO doubleListDTO, DoubleListCallback doubleListCallback) {
        this.E = doubleListCallback;
        this.n = doubleListDTO;
        Intent intent = new Intent(context, DoubleListActivity.class);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadIdCardOcr(IdCardOcrDTO idCardOcrDTO, IdCardOcrCallback idCardOcrCallback) {
        this.B = idCardOcrCallback;
        Intent intent = new Intent(idCardOcrDTO.context, IdCardOcrCameraActivity.class);
        intent.putExtra(IdCardOcrCameraActivity.PARAM_KEY_ID_CARD_TYPE, idCardOcrDTO.type);
        Context context = idCardOcrDTO.context;
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        idCardOcrDTO.context.startActivity(intent);
    }

    public void loadOneKeyLogin(Context context, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, a(context, OneKeyLoginSdkCall.signFromAbilityApi), true, oneKeyLoginCallback);
    }

    public void loadOneKeyLoginWithToken(Context context, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        oneKeyLoginWithToken(context, str, a(context, str2), true, oneKeyLoginCallback);
    }

    public void loadPersonalInfoActivity(Context context, PersonalInfoDTO personalInfoDTO, PersonalInfoCallback personalInfoCallback) {
        this.F = personalInfoCallback;
        this.o = personalInfoDTO;
        Intent intent = new Intent(context, PersonalInfoActivity.class);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadQrCodePage(Context context, String str, String str2, LoadQrUrlCallback loadQrUrlCallback) {
        this.G = loadQrUrlCallback;
        Intent intent = new Intent(context, LoadQrUrlActivity.class);
        intent.putExtra("extra_external_title", str);
        intent.putExtra("extra_external_url", str2);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str) {
        loadQrLogin(qrLoginCallback, str, (String) null, true);
    }

    public void loadQrLoginWithEncuid(QrLoginCallback qrLoginCallback, String str) {
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.encryptedId = SapiUtils.urlParamsToMap(str).get(SapiUtils.KEY_QR_LOGIN_ENCUID);
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
        startLogin(new f(qrLoginCallback), webLoginDTO);
    }

    public void loadRemoteProcessWebViewActivity(Context context, String str, String str2) {
        SapiAccountManager instance = SapiAccountManager.getInstance();
        if (instance == null) {
            Log.e("pass sdk is not init", new Object[0]);
            return;
        }
        SapiConfiguration confignation = instance.getConfignation();
        if (confignation == null) {
            Log.e("pass sdk is not init", new Object[0]);
            return;
        }
        Intent intent = new Intent(context, RemoteProcessWebviewActivity.class);
        intent.putExtra("external_title", str);
        intent.putExtra("external_url", str2 + "&adapter=3");
        intent.putExtra("text_zoom", confignation.textZoom);
        intent.putExtra("is_dark_mode", DarkModeUtil.isDarkMode(context));
        intent.putExtra("show_bottom_back", confignation.showBottomBack);
        intent.putExtra("is_show_bottom_back_text", confignation.isShowBottomBackText);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void loadSwitchAccount(SwitchAccountDTO switchAccountDTO, WebAuthListener webAuthListener) {
        this.f17615j = switchAccountDTO;
        this.f17607b = webAuthListener;
        Intent intent = new Intent(this.I, SwitchAccountActivity.class);
        intent.setFlags(268435456);
        this.I.startActivity(intent);
        LinkedHashMap linkedHashMap = new LinkedHashMap(1);
        linkedHashMap.put("eventType", "switch_account_enter");
        StatService.onEventAutoStatistic(linkedHashMap);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, SocialType socialType) {
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        this.f17611f = webSocialLoginDTO;
        webSocialLoginDTO.socialType = socialType;
        loadThirdPartyLogin(webAuthListener, webSocialLoginDTO);
    }

    public void loadYYSSOLogin(Context context, String str, WebAuthListener webAuthListener) {
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f17606a = thirdPartyService;
        if (thirdPartyService != null) {
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.finishActivityAfterSuc = true;
            this.f17608c = webLoginDTO;
            WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
            webSocialLoginDTO.finishActivityAfterSuc = true;
            this.f17611f = webSocialLoginDTO;
            this.f17607b = webAuthListener;
            this.f17606a.loadYYSSOLogin(context, str);
        } else if (webAuthListener != null) {
            WebAuthResult webAuthResult = new WebAuthResult();
            webAuthResult.setResultCode(-100);
            webAuthResult.setResultMsg("thirdPartyService is null");
            webAuthListener.onFailure(webAuthResult);
        }
    }

    public void onShareLoginActivityResult(int i2, int i3, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new PassNameValuePair("extrajson", str));
        }
        new ShareCallPacking().onLoginActivityActivityResult(new e(), i2, i3, intent, arrayList, "product");
    }

    public void oneKeyLoginWithToken(Context context, String str, String str2, boolean z2, OneKeyLoginCallback oneKeyLoginCallback) {
        oneKeyLoginWithToken(context, str, str2, z2, true, oneKeyLoginCallback);
    }

    public void registerUserFaceID(Activity activity, RegisterUserFaceIDCallback registerUserFaceIDCallback, FaceIDRegDTO faceIDRegDTO) {
        if (TextUtils.isEmpty(faceIDRegDTO.authsid)) {
            startAuth(new i(activity, registerUserFaceIDCallback, faceIDRegDTO), faceIDRegDTO.authWidgetURL);
            return;
        }
        b(activity, registerUserFaceIDCallback, "faceDetect", faceIDRegDTO.authsid, faceIDRegDTO.livingUname, faceIDRegDTO.showGuidePage, faceIDRegDTO.subpro, faceIDRegDTO.businessSence, faceIDRegDTO.isCurrentProcessShowAgreement);
    }

    public synchronized void release() {
        this.f17607b = null;
        this.f17608c = null;
        this.f17610e = null;
        this.f17611f = null;
        this.f17613h = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.f17612g = null;
        this.u = null;
        this.p = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.f17615j = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.m = null;
        this.n = null;
        this.F = null;
        this.o = null;
        this.G = null;
        PassportViewManager.getInstance().release();
        L = null;
    }

    public void releaseAccountRealNameCallback() {
        this.q = null;
    }

    public void releaseCertGuardianCallback() {
        this.C = null;
    }

    public void releaseChangeUsernameCallback() {
        this.D = null;
    }

    public void releaseDoubleListCallback() {
        this.E = null;
    }

    public void releaseLoadQrUrlCallback() {
        this.G = null;
    }

    public void releaseOneKeyLoginCallback() {
        this.z = null;
    }

    public void releasePersonalInfoCallback() {
        this.F = null;
    }

    public void releaseSmsViewLoginCallback() {
        this.v = null;
    }

    public synchronized void releaseWithoutAccountCenter() {
        this.f17607b = null;
        this.f17608c = null;
        this.f17610e = null;
        this.f17611f = null;
        this.f17613h = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.f17612g = null;
        this.u = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.f17615j = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.n = null;
        this.F = null;
        this.o = null;
        this.G = null;
        PassportViewManager.getInstance().release();
        L = null;
    }

    public void setActivityResultCallback(ActivityResultCallback activityResultCallback) {
        this.t = activityResultCallback;
    }

    public void setImageCropCallback(ImageCropCallback imageCropCallback) {
        this.s = imageCropCallback;
    }

    public void setThirdPartyService(AbstractThirdPartyService abstractThirdPartyService) {
        this.f17606a = abstractThirdPartyService;
    }

    public void startAuth(AuthWidgetCallback authWidgetCallback, String str) {
        this.x = authWidgetCallback;
        Intent intent = new Intent(this.I, AuthWidgetActivity.class);
        intent.putExtra(AuthWidgetActivity.EXTRA_PARAM_AUTH_URL, str);
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void startHorizontalScreenLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        webLoginDTO.screenType = 1;
        a(context, HorizontalScreenLoginActivity.class, webAuthListener, webLoginDTO);
    }

    public void startLogin(WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        startLogin(this.I, webAuthListener, webLoginDTO);
    }

    public void startLoginDeviceManager(Context context) {
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_title", "设备管理");
        intent.putExtra("extra_external_url", K);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void startNFCReadCard(Activity activity, NFCReadCardCallback nFCReadCardCallback) {
        try {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            SafeService.getInstance().init(confignation.context, confignation.sofireAppKey, confignation.sofireAppKey, confignation.sofireHostID, false);
            Log.e("NFC", "开启NFC监听");
            FH.enableNfcCardReader(activity, new d(nFCReadCardCallback));
        } catch (Throwable th2) {
            Log.e("NFC", th2.getMessage());
            ToastUtil.show("功能不可用，安全模块不支持NFC");
        }
    }

    public void startNormalizeGuestAccount(Context context, NormalizeGuestAccountCallback normalizeGuestAccountCallback, NormalizeGuestAccountDTO normalizeGuestAccountDTO) {
        this.w = normalizeGuestAccountCallback;
        this.f17613h = normalizeGuestAccountDTO;
        Intent intent = new Intent(context, NormalizeGuestAccountActivity.class);
        intent.putExtra("EXTRA_BDUSS", normalizeGuestAccountDTO.bduss);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    @Deprecated
    public void startOnlyPhoneAuth(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        this.x = authWidgetCallback;
        Intent intent = new Intent(this.I, AuthWidgetOnlyPhoneActivity.class);
        intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_AUTH_ID, str);
        intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void startRegister(WebAuthListener webAuthListener, WebRegDTO webRegDTO) {
        this.f17607b = webAuthListener;
        this.f17609d = webRegDTO;
        Intent intent = new Intent(this.I, RegisterActivity.class);
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void startSchemeLoginForQA(Context context, String str) {
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_url", str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    @Deprecated
    public void startSmsViewLogin(SmsViewLoginCallback smsViewLoginCallback, String str) {
        this.v = smsViewLoginCallback;
        this.H = str;
        SmsLoginView.notifyStartLogin();
    }

    public void startSpeciallyAuthWidget(AuthWidgetCallback authWidgetCallback, String str, String str2) {
        this.x = authWidgetCallback;
        Intent intent = new Intent(this.I, AuthWidgetOnlyPhoneActivity.class);
        intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_AUTH_ID, str);
        intent.putExtra(AuthWidgetOnlyPhoneActivity.EXTRA_PARAM_SCENE, str2);
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public int stopNFCReadCard(Activity activity) {
        try {
            Log.e("NFC", "关闭NFC监听");
            return FH.disableNfcCardReader(activity);
        } catch (Throwable th2) {
            Log.e("NFC", th2.getMessage());
            ToastUtil.show("功能不可用，安全模块不支持NFC");
            return 0;
        }
    }

    public void verifyUserFaceIDWithCertInfo(Activity activity, PassFaceRecogCallback passFaceRecogCallback, FaceIDVerifyCertInfoDTO faceIDVerifyCertInfoDTO) {
        BiometricsManager.getInstance().recogWithCertInfo(activity, BiometricsManager.buildSubPro("", faceIDVerifyCertInfoDTO.subpro), faceIDVerifyCertInfoDTO.transParamsList, faceIDVerifyCertInfoDTO.imageFlag, faceIDVerifyCertInfoDTO.realName, faceIDVerifyCertInfoDTO.idCardNo, faceIDVerifyCertInfoDTO.verifyType, faceIDVerifyCertInfoDTO.nation, faceIDVerifyCertInfoDTO.needAuthorizeCertInfo, (String) null, passFaceRecogCallback);
    }

    public void verifyUserFaceId(Activity activity, VerifyUserFaceIDCallback verifyUserFaceIDCallback, FaceIDVerifyDTO faceIDVerifyDTO) {
        SapiAccount currentAccount;
        FaceIDVerifyDTO faceIDVerifyDTO2 = faceIDVerifyDTO;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            faceIDVerifyDTO2.bduss = currentAccount.bduss;
            faceIDVerifyDTO2.uid = currentAccount.uid;
        }
        if (TextUtils.isEmpty(faceIDVerifyDTO2.livingUname)) {
            RealNameFaceIDResult realNameFaceIDResult = new RealNameFaceIDResult();
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new j(activity, faceIDVerifyDTO, verifyUserFaceIDCallback, realNameFaceIDResult), faceIDVerifyDTO2.bduss, arrayList);
            return;
        }
        b(activity, verifyUserFaceIDCallback, "outer", "", faceIDVerifyDTO2.livingUname, faceIDVerifyDTO2.showGuidePage, faceIDVerifyDTO2.subpro, faceIDVerifyDTO2.businessSence, faceIDVerifyDTO2.isCurrentProcessShowAgreement);
    }

    /* access modifiers changed from: private */
    public void b(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z2, String str4, String str5, boolean z3) {
        a(activity, faceIDCallback, str, str2, str3, z2, str4, str5, z3);
    }

    public void invokeV2ShareLogin(Context context, ShareStorage.StorageModel storageModel, WebAuthListener webAuthListener, String str) {
        Log.d(J, "invokeV2ShareLogin: ");
        if (context == null) {
            throw new IllegalArgumentException("method invokeV2ShareLogin() invokeActivity param cat't be null !");
        } else if (storageModel == null) {
            throw new IllegalArgumentException("method invokeV2ShareLogin() param shareModel cat't be null !");
        } else if (webAuthListener != null) {
            if (!SapiUtils.isAppInstalled(context, storageModel.pkg)) {
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(ShareResult.ERROR_CODE_TARGET_APP_NOT_INSTALLED);
                webAuthResult.setResultMsg(ShareResult.ERROR_MSG_TARGET_APP_NOT_INSTALLED);
                webAuthListener.onFailure(webAuthResult);
            }
            this.f17607b = webAuthListener;
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            Intent intent = new Intent(context, ShareResultProxyActivity.class);
            intent.putExtra(ShareResultProxyActivity.KEY_PKG, storageModel.pkg);
            intent.putExtra("key_url", storageModel.url);
            intent.putExtra("key_version", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
            intent.putParcelableArrayListExtra(ShareResultProxyActivity.KEY_EXTRA_PARAMS, arrayList);
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.I.startActivity(intent);
        } else {
            throw new IllegalArgumentException("method invokeV2ShareLogin() param webAuthListener cat't be null !");
        }
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2) {
        loadQrLogin(qrLoginCallback, str, str2, true);
    }

    public void oneKeyLoginWithToken(Context context, String str, String str2, boolean z2, boolean z3, OneKeyLoginCallback oneKeyLoginCallback) {
        if (TextUtils.isEmpty(str2)) {
            Log.d(Log.TAG, "oneKeyLogin sign is empty!");
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -108, (String) null);
        } else if (!TextUtils.isEmpty(str)) {
            SapiAccountManager.getInstance().getAccountService().loadOneKeyLogin(oneKeyLoginCallback, str, str2, z3, new c(z2, oneKeyLoginCallback, context));
        } else {
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -102, (String) null);
        }
    }

    public void startLogin(Context context, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        Class cls;
        if (webLoginDTO == null || !webLoginDTO.isWithYouthStyle) {
            cls = LoginActivity.class;
        } else {
            cls = YouthStyleLoginActivity.class;
        }
        a(context, cls, webAuthListener, webLoginDTO);
    }

    public void loadOneKeyLogin(Context context, String str, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, str, true, oneKeyLoginCallback);
    }

    public void loadQrLogin(QrLoginCallback qrLoginCallback, String str, String str2, boolean z2) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList(1);
        this.u = new g(qrLoginCallback, arrayList);
        if (SapiAccountManager.getInstance().isLogin()) {
            a(str, z2);
            return;
        }
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.finishActivityAfterSuc = false;
        webLoginDTO.encryptedId = SapiUtils.parseQrLoginSchema(str).get("enuid");
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(URLDecoder.decode(str2));
            }
            jSONObject.put("scenario", "1");
            webLoginDTO.statExtra = URLEncoder.encode(jSONObject.toString());
        } catch (JSONException e2) {
        }
        startLogin(new h(arrayList, str, z2), webLoginDTO);
    }

    public void loadOneKeyLogin(Context context, String str, boolean z2, OneKeyLoginCallback oneKeyLoginCallback) {
        loadOneKeyLogin(context, str, z2, true, oneKeyLoginCallback);
    }

    public void loadThirdPartyLogin(WebAuthListener webAuthListener, WebSocialLoginDTO webSocialLoginDTO) {
        String str = J;
        Log.d(str, "loadThirdPartyLogin:");
        this.f17607b = webAuthListener;
        this.f17611f = webSocialLoginDTO;
        AbstractThirdPartyService thirdPartyService = getThirdPartyService();
        this.f17606a = thirdPartyService;
        if (thirdPartyService != null) {
            if (webAuthListener instanceof ThirdLoginCallback) {
                Log.d(str, "loadThirdPartyLogin: ThirdLoginCallback");
                ThirdLoginCallback thirdLoginCallback = (ThirdLoginCallback) webAuthListener;
                AbstractThirdPartyService abstractThirdPartyService = this.f17606a;
                Context context = webSocialLoginDTO.context;
                if (context == null) {
                    context = this.I;
                }
                abstractThirdPartyService.loadThirdPartyLogin(context, webSocialLoginDTO, 2002, thirdLoginCallback);
            } else {
                Context context2 = webSocialLoginDTO.context;
                if (context2 == null) {
                    context2 = this.I;
                }
                thirdPartyService.loadThirdPartyLogin(context2, webSocialLoginDTO.socialType, 2002);
            }
            webSocialLoginDTO.context = null;
        }
    }

    public void startSmsViewLogin(SmsLoginView smsLoginView, SmsViewLoginCallback smsViewLoginCallback, String str) {
        if (smsLoginView != null && smsViewLoginCallback != null) {
            smsLoginView.setSmsViewLoginCallback(smsViewLoginCallback);
            smsLoginView.setSmsLoginStatExtra(str);
            SmsLoginView.notifyStartLogin();
        }
    }

    public void loadOneKeyLogin(Context context, String str, boolean z2, boolean z3, OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback == null) {
            Log.e(Log.TAG, "When load oneKeyLogin, oneKeyLoginCallback can't be null!");
        } else if (TextUtils.isEmpty(str)) {
            Log.d(Log.TAG, "oneKeyLogin sign is empty!");
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -108, (String) null);
        } else {
            final Context context2 = context;
            final String str2 = str;
            final boolean z4 = z2;
            final boolean z5 = z3;
            final OneKeyLoginCallback oneKeyLoginCallback2 = oneKeyLoginCallback;
            new OneKeyLoginSdkCall().getToken(SapiAccountManager.getInstance().getSapiConfiguration(), new OneKeyLoginSdkCall.TokenListener() {
                public void onGetTokenComplete(JSONObject jSONObject) {
                    CoreViewRouter.this.oneKeyLoginWithToken(context2, jSONObject.optString("token"), str2, z4, z5, oneKeyLoginCallback2);
                }
            });
        }
    }

    private void a(Context context, Class<?> cls, WebAuthListener webAuthListener, WebLoginDTO webLoginDTO) {
        if (context != null) {
            SapiWebView.statLoadLogin = new StatLoadLogin();
            SapiWebView.statLoadLogin.tOpenLoginPage = System.currentTimeMillis();
            this.f17607b = webAuthListener;
            this.f17608c = webLoginDTO;
            Intent intent = new Intent(context, cls);
            intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, webLoginDTO.loginType);
            intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, webLoginDTO.finishActivityAfterSuc);
            if (!TextUtils.isEmpty(webLoginDTO.preSetUname)) {
                intent.putExtra("username", webLoginDTO.preSetUname);
            }
            int i2 = webLoginDTO.businessType;
            if (i2 != 0) {
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
            }
            if (!TextUtils.isEmpty(webLoginDTO.extraJson)) {
                intent.putExtra("extraJson", webLoginDTO.extraJson);
            }
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.I.startActivity(intent);
        }
    }

    public void loadChangeUsername(Context context, ChangeUserNameDTO changeUserNameDTO, ChangeUsernameCallback changeUsernameCallback) {
        this.D = changeUsernameCallback;
        this.m = changeUserNameDTO;
        Intent intent = new Intent(context, ChangeUserNameActivity.class);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    public void startSchemeLoginForQA(Context context, String str, WebAuthListener webAuthListener) {
        this.f17607b = webAuthListener;
        Intent intent = new Intent(context, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_url", str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2) {
        Intent intent = new Intent(this.I, QrLoginActivity.class);
        intent.putExtra(QrLoginActivity.EXTRA_STRING_QR_LOGIN_URL, str);
        intent.putExtra(QrLoginActivity.EXTRA_BOOLEAN_FINISH_PAGE, z2);
        intent.setFlags(268435456);
        this.I.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, String str, Map<String, String> map, String str2, String str3, String str4, String str5, VerifyUserFaceIDCallback verifyUserFaceIDCallback, RealNameFaceIDResult realNameFaceIDResult, boolean z2) {
        String str6 = str;
        BiometricsManager.getInstance().recogWithBduss(activity, BiometricsManager.buildSubPro(str, str5), map, str2, str3, str4, z2, new k(realNameFaceIDResult, verifyUserFaceIDCallback));
    }

    private void a(Activity activity, FaceIDCallback faceIDCallback, String str, String str2, String str3, boolean z2, String str4, String str5, boolean z3) {
        String str6 = str;
        if (!TextUtils.isEmpty(str5)) {
            BiometricsManager instance = BiometricsManager.getInstance();
            String buildSubPro = BiometricsManager.buildSubPro(str4, str5);
            HashMap hashMap = new HashMap();
            FaceIDCallback faceIDCallback2 = faceIDCallback;
            l lVar = new l(new UnRealNameFaceIDResult(), str, faceIDCallback);
            if (str.equals("faceDetect")) {
                instance.recogWithFaceDetect(activity, buildSubPro, hashMap, "0", str3, str2, z3, lVar);
            } else if (str.equals("outer")) {
                instance.recogWithFaceOuter(activity, buildSubPro, hashMap, "0", str3, z3, lVar);
            }
        } else {
            throw new IllegalArgumentException("scene can't be empty");
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, JSONObject jSONObject, int i2, ExtendSysWebViewMethodResult extendSysWebViewMethodResult) {
        String str;
        String str2;
        HashMap hashMap;
        BiometricsManager biometricsManager;
        String str3;
        int i3;
        int i4;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject;
        int i5 = i2;
        BiometricsManager instance = BiometricsManager.getInstance();
        a aVar = new a(extendSysWebViewMethodResult, extendSysWebViewMethodCallback);
        int optInt = jSONObject3.optInt("imageFlag", 0);
        if (TextUtils.isEmpty(jSONObject3.optString("subpro"))) {
            str = "pp";
        } else {
            str = jSONObject3.optString("subpro");
        }
        HashMap hashMap2 = new HashMap();
        JSONObject optJSONObject = jSONObject3.optJSONObject("transParams");
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = optJSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    hashMap2.put(next, optString);
                }
            }
        }
        if (i5 == 1) {
            Objects.requireNonNull(instance);
            str2 = "";
            a(activity, extendSysWebViewMethodCallback, new BiometricsManager.e(), extendSysWebViewMethodResult, aVar, str, hashMap2, optInt + "");
        } else {
            str2 = "";
        }
        if (i5 == 2) {
            biometricsManager = instance;
            str3 = str2;
            hashMap = hashMap2;
            i3 = optInt;
            instance.recogWithCertInfo(activity, str, hashMap2, optInt + str2, jSONObject3.optString("realname"), jSONObject3.optString("idcardnum"), jSONObject3.optString("verify_type"), jSONObject3.optString("nation"), false, jSONObject3.optString("bankmobile"), aVar);
        } else {
            hashMap = hashMap2;
            i3 = optInt;
            biometricsManager = instance;
            str3 = str2;
        }
        if (i5 == 3) {
            i4 = i3;
            jSONObject2 = jSONObject;
            biometricsManager.recogWithAuthToken(activity, str, hashMap, i3 + str3, jSONObject2.optString("authtoken"), aVar);
        } else {
            i4 = i3;
            jSONObject2 = jSONObject;
        }
        if (i5 != 4) {
            return;
        }
        if (jSONObject2.optInt("type") == 1) {
            biometricsManager.recogWithFaceDetect(activity, str, hashMap, i4 + str3, jSONObject2.optString("uid"), "", aVar);
            return;
        }
        biometricsManager.recogWithFaceOuter(activity, str, hashMap, i4 + str3, jSONObject2.optString("uid"), aVar);
    }

    private void a(Activity activity, ExtendSysWebViewMethodCallback extendSysWebViewMethodCallback, BiometricsManager.e eVar, ExtendSysWebViewMethodResult extendSysWebViewMethodResult, PassFaceRecogCallback passFaceRecogCallback, String str, Map<String, String> map, String str2) {
        BiometricsManager.e eVar2 = eVar;
        ExtendSysWebViewMethodResult extendSysWebViewMethodResult2 = extendSysWebViewMethodResult;
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            extendSysWebViewMethodResult2.params.put(BaiduRimConstants.RETCODE_KEY, "-302");
            extendSysWebViewMethodResult2.params.put("retMsg", "please login first");
            extendSysWebViewMethodCallback.onFinish(extendSysWebViewMethodResult2);
            return;
        }
        eVar2.f18202j = currentAccount.bduss;
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new b(activity, str, map, str2, currentAccount, passFaceRecogCallback, extendSysWebViewMethodResult, extendSysWebViewMethodCallback), eVar2.f18202j, arrayList);
    }

    private String a(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 7) {
            return null;
        }
        return str.substring(0, 8) + SecurityUtil.md5((str.substring(8, str.length()) + SecurityUtil.md5(SapiUtils.getClientId(context).toUpperCase().getBytes(), false)).getBytes(), false);
    }

    private void a() {
        try {
            Class.forName("com.baidu.sapi2.ThirdPartyService").getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    private String a(int i2) {
        String str;
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        HashMap hashMap = new HashMap();
        switch (i2) {
            case 1:
                str = "/v6/accountfreezeapply";
                break;
            case 2:
                str = "/wp/v3/ucenter/findaccback";
                break;
            case 3:
                str = "/wp/v3/ucenter/accountcancelpage";
                break;
            case 4:
                str = "/v4/appeal/";
                break;
            case 5:
                str = "/v6/setPassword";
                break;
            case 6:
                str = SapiEnv.LOGIN_PROJECT;
                break;
            case 7:
                str = "/v6/loginTypeManage";
                break;
            case 8:
                str = "/v6/securitySettings/deviceManage";
                break;
            case 9:
                str = "/v6/appAuthority";
                break;
            case 10:
                str = "/v6/linkAccount";
                break;
            case 11:
                str = "/v6/appeal_query/input_account";
                break;
            default:
                throw new RuntimeException("account tools type is not support");
        }
        String str2 = sapiConfiguration.environment.getWap() + str + GameCenterUtils.SCHEME_SWAN_SUFFIX + ParamsUtil.buildH5CommonParams(sapiConfiguration);
        hashMap.put("throughPage", "1");
        hashMap.put("slidePage", "1");
        if (sapiConfiguration.supportFaceLogin) {
            hashMap.put("supFaceLogin", "1");
        }
        if (sapiConfiguration.supportPhoto) {
            hashMap.put("support_photo", "1");
        }
        return !hashMap.isEmpty() ? ParamsUtil.addExtras(str2, hashMap) : str2;
    }
}
