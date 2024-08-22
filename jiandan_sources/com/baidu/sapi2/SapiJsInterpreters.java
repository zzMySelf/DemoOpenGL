package com.baidu.sapi2;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import androidx.biometric.BiometricPrompt;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.booster.SapiUtil;
import com.baidu.sapi2.callback.IdcardOcrImageCallback;
import com.baidu.sapi2.callback.LoadDuVipPayCallBack;
import com.baidu.sapi2.callback.NFCReadCardCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.CertGuardianResult;
import com.baidu.sapi2.result.IdcardOcrImageRusult;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.scheme.SapiScheme;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.touchid.FingerprintUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.Security;
import com.baidu.sapi2.utils.SyncAccountUtils;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.ubc.UBCManager;
import com.baidu.wallet.api.IWalletLoginListener;
import com.google.android.material.timepicker.TimeModel;
import com.google.common.net.MediaType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SapiJsInterpreters {
    public static final List<String> SUPPORT_LIST;
    public static final String TAG = "SapiJsInterpreters";
    public SapiConfiguration configuration;
    public Context context;
    public HashMap<String, AbstractInterpreter> interpreterHashMap = new HashMap<>();
    public SapiJsCallBacks.CallBacks jsCallBacks;
    public long preShareClickTime;
    public SapiWebView sapiWebView;

    public abstract class AbstractInterpreter {
        public AbstractInterpreter() {
        }

        public abstract String interpret(SapiWebView.Command command);
    }

    public class ActionBindWidgetPhoneNumberExist extends AbstractInterpreter {
        public ActionBindWidgetPhoneNumberExist() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.jsCallBacks.bindWidgetCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.bindWidgetCallback.onPhoneNumberExist(str);
            return null;
        }
    }

    public class ActionFaceLoginSwitch extends AbstractInterpreter {
        public ActionFaceLoginSwitch() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("livinguname");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                new FaceLoginService().syncFaceLoginUID(SapiJsInterpreters.this.context, optString);
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class ActionForgetPwd extends AbstractInterpreter {
        public ActionForgetPwd() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.jsCallBacks.authorizationListener != null ? SapiJsInterpreters.this.jsCallBacks.authorizationListener.onForgetPwd() : false ? "1" : "0";
        }
    }

    public class ActionGenerateSign extends AbstractInterpreter {
        public ActionGenerateSign() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return SapiUtils.calculateSig(hashMap, SapiJsInterpreters.this.configuration.appSignKey);
        }
    }

    public class ActionGetLoadtime extends AbstractInterpreter {
        public ActionGetLoadtime() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            SapiWebView unused = SapiJsInterpreters.this.sapiWebView;
            if (SapiWebView.statLoadLogin == null) {
                return null;
            }
            SapiWebView unused2 = SapiJsInterpreters.this.sapiWebView;
            return SapiWebView.statLoadLogin.toJSON().toString();
        }
    }

    public class ActionGetSmsCheckCodeFromClip extends AbstractInterpreter {
        public ActionGetSmsCheckCodeFromClip() {
            super();
        }

        @TargetApi(11)
        public String interpret(SapiWebView.Command command) {
            String str = "";
            try {
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.context.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    str = SapiUtils.getSmsCheckCode(clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th2) {
                Log.e(th2);
            }
            SapiStatUtil.statSmsCodeClip(SapiJsInterpreters.this.context, TextUtils.isEmpty(str) ? "0" : "1");
            return str;
        }
    }

    public class ActionGloryLogin extends AbstractInterpreter {
        public ActionGloryLogin() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler == null) {
                return null;
            }
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HONOR;
            Message message = new Message();
            message.what = SocialType.HONOR.getType();
            message.obj = SocialType.HONOR;
            SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
            return null;
        }
    }

    public class ActionHuaweiLogin extends AbstractInterpreter {
        public ActionHuaweiLogin() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler == null) {
                return null;
            }
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HUAWEI;
            Message message = new Message();
            message.what = SocialType.HUAWEI.getType();
            message.obj = SocialType.HUAWEI;
            SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
            return null;
        }
    }

    public class ActionJoinLogin extends AbstractInterpreter {
        public ActionJoinLogin() {
            super();
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0056 A[Catch:{ Exception -> 0x00e1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0057 A[Catch:{ Exception -> 0x00e1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00b6 A[Catch:{ Exception -> 0x00e1 }, LOOP:0: B:19:0x00b0->B:21:0x00b6, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r8) {
            /*
                r7 = this;
                java.lang.String r8 = "name"
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                android.content.Context r1 = r1.context     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                android.content.Context r2 = r2.context     // Catch:{ Exception -> 0x00e1 }
                java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x00e1 }
                java.lang.String[] r1 = com.baidu.sapi2.utils.SapiUtils.getPkgIconAndName(r1, r2)     // Catch:{ Exception -> 0x00e1 }
                java.lang.String r2 = "icon"
                r3 = 0
                r3 = r1[r3]     // Catch:{ Exception -> 0x00e1 }
                r0.put(r2, r3)     // Catch:{ Exception -> 0x00e1 }
                r2 = 1
                r1 = r1[r2]     // Catch:{ Exception -> 0x00e1 }
                r0.put(r8, r1)     // Catch:{ Exception -> 0x00e1 }
                java.util.List r1 = com.baidu.sapi2.share.ShareUtils.getShareStorageModel()     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r2 = r2.jsCallBacks     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiWebView$ShareAccountClickCallback r2 = r2.shareAccountClickCallback     // Catch:{ Exception -> 0x00e1 }
                java.lang.String r3 = "false"
                java.lang.String r4 = "openShareLogin"
                if (r2 == 0) goto L_0x0047
                int r1 = r1.size()     // Catch:{ Exception -> 0x00e1 }
                if (r1 <= 0) goto L_0x0047
                java.lang.String r1 = "true"
                r0.put(r4, r1)     // Catch:{ Exception -> 0x00e1 }
                goto L_0x004a
            L_0x0047:
                r0.put(r4, r3)     // Catch:{ Exception -> 0x00e1 }
            L_0x004a:
                java.lang.String r1 = "hasThirdAccount"
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r2 = r2.jsCallBacks     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r2 = r2.joinLoginParams     // Catch:{ Exception -> 0x00e1 }
                if (r2 != 0) goto L_0x0057
                goto L_0x0072
            L_0x0057:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1 }
                r2.<init>()     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsInterpreters r3 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r3 = r3.jsCallBacks     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r3 = r3.joinLoginParams     // Catch:{ Exception -> 0x00e1 }
                boolean r3 = r3.hasThirdAccount     // Catch:{ Exception -> 0x00e1 }
                r2.append(r3)     // Catch:{ Exception -> 0x00e1 }
                java.lang.String r3 = ""
                r2.append(r3)     // Catch:{ Exception -> 0x00e1 }
                java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x00e1 }
            L_0x0072:
                r0.put(r1, r3)     // Catch:{ Exception -> 0x00e1 }
                java.lang.String r1 = "supportFaceLogin"
                com.baidu.sapi2.share.face.FaceLoginService r2 = new com.baidu.sapi2.share.face.FaceLoginService     // Catch:{ Exception -> 0x00e1 }
                r2.<init>()     // Catch:{ Exception -> 0x00e1 }
                boolean r2 = r2.isSupFaceLogin()     // Catch:{ Exception -> 0x00e1 }
                r0.put(r1, r2)     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r1 = r1.jsCallBacks     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r1 = r1.joinLoginParams     // Catch:{ Exception -> 0x00e1 }
                if (r1 == 0) goto L_0x00e5
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r1 = r1.jsCallBacks     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r1 = r1.joinLoginParams     // Catch:{ Exception -> 0x00e1 }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r1 = r1.agreement     // Catch:{ Exception -> 0x00e1 }
                if (r1 == 0) goto L_0x00e5
                org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ Exception -> 0x00e1 }
                r1.<init>()     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r2 = r2.jsCallBacks     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r2 = r2.joinLoginParams     // Catch:{ Exception -> 0x00e1 }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r2 = r2.agreement     // Catch:{ Exception -> 0x00e1 }
                java.util.Set r2 = r2.keySet()     // Catch:{ Exception -> 0x00e1 }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00e1 }
            L_0x00b0:
                boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00e1 }
                if (r3 == 0) goto L_0x00db
                java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00e1 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x00e1 }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e1 }
                r4.<init>()     // Catch:{ Exception -> 0x00e1 }
                r4.put(r8, r3)     // Catch:{ Exception -> 0x00e1 }
                java.lang.String r5 = "url"
                com.baidu.sapi2.SapiJsInterpreters r6 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r6 = r6.jsCallBacks     // Catch:{ Exception -> 0x00e1 }
                com.baidu.sapi2.SapiJsCallBacks$JoinLoginParams r6 = r6.joinLoginParams     // Catch:{ Exception -> 0x00e1 }
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r6 = r6.agreement     // Catch:{ Exception -> 0x00e1 }
                java.lang.Object r3 = r6.get(r3)     // Catch:{ Exception -> 0x00e1 }
                r4.put(r5, r3)     // Catch:{ Exception -> 0x00e1 }
                r1.put(r4)     // Catch:{ Exception -> 0x00e1 }
                goto L_0x00b0
            L_0x00db:
                java.lang.String r8 = "agreement"
                r0.put(r8, r1)     // Catch:{ Exception -> 0x00e1 }
                goto L_0x00e5
            L_0x00e1:
                r8 = move-exception
                com.baidu.sapi2.utils.Log.e(r8)
            L_0x00e5:
                java.lang.String r8 = r0.toString()
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.ActionJoinLogin.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class ActionLoadExternalWebview extends AbstractInterpreter {
        public ActionLoadExternalWebview() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.loadExternalWebViewCallback == null) {
                return null;
            }
            SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult = new SapiWebView.LoadExternalWebViewResult();
            loadExternalWebViewResult.defaultTitle = command.getActionParams().get(0);
            loadExternalWebViewResult.externalUrl = command.getActionParams().get(1);
            SapiJsInterpreters.this.jsCallBacks.loadExternalWebViewCallback.loadExternalWebview(loadExternalWebViewResult);
            return null;
        }
    }

    public class ActionLoadSlideWebview extends AbstractInterpreter {
        public ActionLoadSlideWebview() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.loadSlideWebViewCallback == null) {
                return null;
            }
            SapiWebView.LoadSlideWebViewResult loadSlideWebViewResult = new SapiWebView.LoadSlideWebViewResult();
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                loadSlideWebViewResult.placeholderTitle = jSONObject.optString("placeholderTitle");
                loadSlideWebViewResult.url = jSONObject.optString("url");
                loadSlideWebViewResult.page = jSONObject.optString(UBCManager.CONTENT_KEY_PAGE);
                loadSlideWebViewResult.adapter = jSONObject.optString("adapter");
                SapiJsInterpreters.this.jsCallBacks.loadSlideWebViewCallback.loadSlideWebview(loadSlideWebViewResult);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("errno", "0");
                return jSONObject2.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class ActionRemoveShareAccount extends AbstractInterpreter {
        public ActionRemoveShareAccount() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            return null;
        }
    }

    public class ActionSetTitle extends AbstractInterpreter {
        public ActionSetTitle() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            if (SapiJsInterpreters.this.jsCallBacks.webViewTitleCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.webViewTitleCallback.onTitleChange(str);
            return null;
        }
    }

    public class ActionShareAccountsViewBtnClicked extends AbstractInterpreter {
        public ActionShareAccountsViewBtnClicked() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.quickLoginHandler == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.quickLoginHandler.handleOtherLogin();
            return null;
        }
    }

    public class ActionShareClickOther extends AbstractInterpreter {
        public ActionShareClickOther() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            SapiStatUtil.statShareClickOther(command.getActionParams().get(0), SapiJsInterpreters.this.sapiWebView.extras);
            return null;
        }
    }

    public class ActionShareV2Login extends AbstractInterpreter {
        public ActionShareV2Login() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.jsCallBacks.shareV2LoginParams.pageParams.toString();
        }
    }

    public class ActionShareV2LoginClick extends AbstractInterpreter {
        public ActionShareV2LoginClick() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.jsCallBacks.shareV2LoginParams.onSuccess();
            return null;
        }
    }

    public class ActionShareV2LoginFail extends AbstractInterpreter {
        public ActionShareV2LoginFail() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.jsCallBacks.shareV2LoginParams.onError();
            return null;
        }
    }

    public class ActionSocialMeizuSso extends AbstractInterpreter {
        public ActionSocialMeizuSso() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler == null) {
                return null;
            }
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.MEIZU;
            Message message = new Message();
            message.what = SocialType.MEIZU.getType();
            message.obj = SocialType.MEIZU;
            SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
            return null;
        }
    }

    public class ActionSocialQqSso extends AbstractInterpreter {
        public ActionSocialQqSso() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler == null) {
                return null;
            }
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
            Message message = new Message();
            message.what = SocialType.QQ_SSO.getType();
            message.obj = SocialType.QQ_SSO;
            SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
            return null;
        }
    }

    public class ActionSocialSinaSso extends AbstractInterpreter {
        public ActionSocialSinaSso() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler == null) {
                return null;
            }
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WEIBO;
            Message message = new Message();
            message.what = SocialType.SINA_WEIBO_SSO.getType();
            message.obj = SocialType.SINA_WEIBO_SSO;
            SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
            return null;
        }
    }

    public class ActionSocialSso extends AbstractInterpreter {
        public ActionSocialSso() {
            super();
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b7, code lost:
            if (r8.equals(com.baidu.sapi2.utils.enums.FastLoginFeature.SSOLoginType.WEIXIN) != false) goto L_0x00bb;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r8) {
            /*
                r7 = this;
                com.baidu.sapi2.SapiJsInterpreters r0 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r0 = r0.jsCallBacks
                android.os.Handler r0 = r0.socialLoginHandler
                r1 = 0
                if (r0 == 0) goto L_0x0154
                java.util.List r8 = r8.getActionParams()
                r0 = 0
                java.lang.Object r8 = r8.get(r0)
                java.lang.String r8 = (java.lang.String) r8
                java.lang.String r2 = com.baidu.sapi2.SapiJsInterpreters.TAG
                r3 = 1
                java.lang.Object[] r4 = new java.lang.Object[r3]
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "ActionSocialSso interpret: type"
                r5.append(r6)
                r5.append(r8)
                java.lang.String r5 = r5.toString()
                r4[r0] = r5
                com.baidu.sapi2.utils.Log.d(r2, r4)
                r2 = -1
                int r4 = r8.hashCode()
                switch(r4) {
                    case -1519161818: goto L_0x00b1;
                    case -1506464740: goto L_0x00a7;
                    case -1170572724: goto L_0x009c;
                    case -952571024: goto L_0x0092;
                    case -188463888: goto L_0x0087;
                    case -19158255: goto L_0x007d;
                    case 3872: goto L_0x0072;
                    case 110658813: goto L_0x0068;
                    case 738596251: goto L_0x005e;
                    case 1288743885: goto L_0x0054;
                    case 1587088523: goto L_0x0049;
                    case 1675490300: goto L_0x003d;
                    default: goto L_0x003b;
                }
            L_0x003b:
                goto L_0x00ba
            L_0x003d:
                java.lang.String r0 = "vivo_sso"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 11
                goto L_0x00bb
            L_0x0049:
                java.lang.String r0 = "xiaomi_sso"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 6
                goto L_0x00bb
            L_0x0054:
                java.lang.String r0 = "tsina_sso"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 1
                goto L_0x00bb
            L_0x005e:
                java.lang.String r0 = "glory_login"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 5
                goto L_0x00bb
            L_0x0068:
                java.lang.String r0 = "tsina"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 2
                goto L_0x00bb
            L_0x0072:
                java.lang.String r0 = "yy"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 8
                goto L_0x00bb
            L_0x007d:
                java.lang.String r0 = "huawei_login"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 4
                goto L_0x00bb
            L_0x0087:
                java.lang.String r0 = "oppo_sso"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 10
                goto L_0x00bb
            L_0x0092:
                java.lang.String r0 = "qq_sso"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 3
                goto L_0x00bb
            L_0x009c:
                java.lang.String r0 = "dingding_sso"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 9
                goto L_0x00bb
            L_0x00a7:
                java.lang.String r0 = "meizu_sso"
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00ba
                r0 = 7
                goto L_0x00bb
            L_0x00b1:
                java.lang.String r3 = "tweixin_sso"
                boolean r8 = r8.equals(r3)
                if (r8 == 0) goto L_0x00ba
                goto L_0x00bb
            L_0x00ba:
                r0 = -1
            L_0x00bb:
                switch(r0) {
                    case 0: goto L_0x0130;
                    case 1: goto L_0x0125;
                    case 2: goto L_0x0125;
                    case 3: goto L_0x011a;
                    case 4: goto L_0x010f;
                    case 5: goto L_0x0104;
                    case 6: goto L_0x00f9;
                    case 7: goto L_0x00ee;
                    case 8: goto L_0x00e3;
                    case 9: goto L_0x00d8;
                    case 10: goto L_0x00cd;
                    case 11: goto L_0x00c1;
                    default: goto L_0x00be;
                }
            L_0x00be:
                r8 = r1
                goto L_0x013a
            L_0x00c1:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.VIVO
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.VIVO
                goto L_0x013a
            L_0x00cd:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.OPPO
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.OPPO
                goto L_0x013a
            L_0x00d8:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.DINGDING
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.DINGDING
                goto L_0x013a
            L_0x00e3:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.YY
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.YY
                goto L_0x013a
            L_0x00ee:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.MEIZU
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.MEIZU
                goto L_0x013a
            L_0x00f9:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.XIAOMI
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.XIAOMI
                goto L_0x013a
            L_0x0104:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.HONOR
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.HONOR
                goto L_0x013a
            L_0x010f:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.HUAWEI
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.HUAWEI
                goto L_0x013a
            L_0x011a:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.QQ
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.QQ_SSO
                goto L_0x013a
            L_0x0125:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.WEIBO
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.SINA_WEIBO_SSO
                goto L_0x013a
            L_0x0130:
                com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.utils.enums.Enums$LastLoginType r0 = com.baidu.sapi2.utils.enums.Enums.LastLoginType.WECHAT
                r8.mLastLoginType = r0
                com.baidu.sapi2.utils.enums.SocialType r8 = com.baidu.sapi2.utils.enums.SocialType.WEIXIN
            L_0x013a:
                if (r8 == 0) goto L_0x0154
                android.os.Message r0 = new android.os.Message
                r0.<init>()
                int r2 = r8.getType()
                r0.what = r2
                r0.obj = r8
                com.baidu.sapi2.SapiJsInterpreters r8 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r8 = r8.jsCallBacks
                android.os.Handler r8 = r8.socialLoginHandler
                r8.sendMessage(r0)
            L_0x0154:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.ActionSocialSso.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class ActionSocialWeixinSso extends AbstractInterpreter {
        public ActionSocialWeixinSso() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler == null) {
                return null;
            }
            Log.d(SapiJsInterpreters.TAG, "ActionSocialWeixinSso interpret: ");
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
            Message message = new Message();
            message.what = SocialType.WEIXIN.getType();
            message.obj = SocialType.WEIXIN;
            SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
            return null;
        }
    }

    public class ActionStopSlideWebview extends AbstractInterpreter {
        public ActionStopSlideWebview() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.stopSlideWebviewCallback == null) {
                return null;
            }
            boolean z = false;
            try {
                z = new JSONObject(command.getActionParams().get(0)).optBoolean("isStop");
            } catch (Exception e) {
                Log.e(e);
            }
            SapiJsInterpreters.this.jsCallBacks.stopSlideWebviewCallback.onStopSlide(z);
            return null;
        }
    }

    public class ActionXiaoMiSso extends AbstractInterpreter {
        public ActionXiaoMiSso() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialLoginHandler == null) {
                return null;
            }
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.XIAOMI;
            Message message = new Message();
            message.what = SocialType.XIAOMI.getType();
            message.obj = SocialType.XIAOMI;
            SapiJsInterpreters.this.jsCallBacks.socialLoginHandler.sendMessage(message);
            return null;
        }
    }

    public class AddressManageGetPasteboard extends AbstractInterpreter {
        public AddressManageGetPasteboard() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                ClipboardManager clipboardManager = (ClipboardManager) SapiJsInterpreters.this.context.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    jSONObject.put("paste", clipboardManager.getPrimaryClip().getItemAt(0).getText().toString());
                }
            } catch (Throwable th2) {
                Log.e(th2);
            }
            return jSONObject.toString();
        }
    }

    public class AuthorizedResponse extends AbstractInterpreter {
        public AuthorizedResponse() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            String str = command.getActionParams().get(0);
            int parseInt = command.getActionParams().size() >= 2 ? Integer.parseInt(command.getActionParams().get(1)) : 0;
            String str2 = command.getActionParams().size() >= 3 ? command.getActionParams().get(2) : null;
            String access$400 = SapiJsInterpreters.TAG;
            Log.d(access$400, "AuthorizedResponse interpret: type " + parseInt);
            if (parseInt == 1) {
                SocialResponse parseOpenApiAuthorizedResult = SapiWebView.parseOpenApiAuthorizedResult(str, SapiJsInterpreters.this.context);
                if (parseOpenApiAuthorizedResult == null) {
                    if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                        SapiJsInterpreters.this.sapiWebView.post(new Runnable() {
                            public void run() {
                                if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                                    SapiJsInterpreters.this.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                                }
                            }
                        });
                    }
                } else if (parseOpenApiAuthorizedResult.offlineNotice || parseOpenApiAuthorizedResult.bindGuide || parseOpenApiAuthorizedResult.errorCode == 21 || parseOpenApiAuthorizedResult.bindConflict) {
                    SapiJsInterpreters.this.jsCallBacks.rrLoginResponse = parseOpenApiAuthorizedResult;
                } else {
                    Log.d(SapiJsInterpreters.TAG, "AuthorizedResponse interpret: AUTHORIZATION_TYPE_OPEN");
                    SapiJsInterpreters.this.sapiWebView.handleOpenApiAuthorizeResponse(parseOpenApiAuthorizedResult);
                }
            }
            if (parseInt == 0) {
                final SapiAccountResponse parseAuthorizedResult = SapiJsInterpreters.this.sapiWebView.parseAuthorizedResult(str, SapiJsInterpreters.this.context);
                if (parseAuthorizedResult != null) {
                    int i2 = parseAuthorizedResult.errorCode;
                    if (i2 == 0 || i2 == 110000) {
                        Log.d(SapiJsInterpreters.TAG, "AuthorizedResponse interpret: SUCCEED_WAPPAS");
                        SapiJsInterpreters.this.sapiWebView.handleAuthorizeResponse(parseAuthorizedResult);
                        if (SapiWebView.SWITCH_ACCOUNT_PAGE.equals(str2)) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", 0);
                            } catch (JSONException e) {
                                Log.e(e);
                            }
                            Log.d(SapiJsInterpreters.TAG, "interpret: authorized_response 0");
                            return jSONObject.toString();
                        }
                    } else if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                        SapiJsInterpreters.this.sapiWebView.post(new Runnable() {
                            public void run() {
                                if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                                    AuthorizationListener authorizationListener = SapiJsInterpreters.this.jsCallBacks.authorizationListener;
                                    SapiAccountResponse sapiAccountResponse = parseAuthorizedResult;
                                    authorizationListener.onFailed(sapiAccountResponse.errorCode, sapiAccountResponse.errorMsg);
                                }
                            }
                        });
                    }
                } else if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                    SapiJsInterpreters.this.sapiWebView.post(new Runnable() {
                        public void run() {
                            if (SapiJsInterpreters.this.jsCallBacks.authorizationListener != null) {
                                SapiJsInterpreters.this.jsCallBacks.authorizationListener.onFailed(-100, "登录失败");
                            }
                        }
                    });
                }
            }
            return null;
        }
    }

    public class Back extends AbstractInterpreter {
        public Back() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.sapiWebView.back();
            return null;
        }
    }

    public class ConfigFastloginFeatures extends AbstractInterpreter {
        public ConfigFastloginFeatures() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            List<FastLoginFeature> fastLoginFeatureList = SapiJsInterpreters.this.jsCallBacks.localConfigCallback != null ? SapiJsInterpreters.this.jsCallBacks.localConfigCallback.getFastLoginFeatureList() : null;
            if (fastLoginFeatureList == null) {
                fastLoginFeatureList = SapiJsInterpreters.this.configuration.fastLoginFeatureList;
            }
            if (fastLoginFeatureList == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            for (int i2 = 0; i2 < fastLoginFeatureList.size(); i2++) {
                FastLoginFeature fastLoginFeature = fastLoginFeatureList.get(i2);
                if (i2 == 0) {
                    sb.append(fastLoginFeature.getStrValue());
                } else {
                    sb.append(",");
                    sb.append(fastLoginFeature.getStrValue());
                }
            }
            return sb.toString();
        }
    }

    public class ConfigLoginShareStrategy extends AbstractInterpreter {
        public ConfigLoginShareStrategy() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.configuration.loginShareStrategy().getStrValue();
        }
    }

    public class CurrentAccountBdussExpired extends AbstractInterpreter {
        public CurrentAccountBdussExpired() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.currentAccountBdussExpiredCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.currentAccountBdussExpiredCallback.onBdussExpired();
            return null;
        }
    }

    public class CurrentPageName extends AbstractInterpreter {
        public CurrentPageName() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.getCurrentPageNameCallback == null) {
                return null;
            }
            try {
                SapiJsInterpreters.this.jsCallBacks.getCurrentPageNameCallback.getCurrentPageName(new JSONObject(command.getActionParams().get(0)).optString("name"));
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class Finish extends AbstractInterpreter {
        public Finish() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.sapiWebView.handleOpenApiAuthorizeResponse(SapiJsInterpreters.this.jsCallBacks.rrLoginResponse);
            if (command.getActionParams().size() > 0) {
                try {
                    SapiJsInterpreters.this.sapiWebView.finish(new JSONObject(command.getActionParams().get(0)).optString(UBCManager.CONTENT_KEY_PAGE));
                } catch (JSONException e) {
                    Log.e(e);
                }
            } else {
                SapiJsInterpreters.this.sapiWebView.finish();
            }
            if (SapiJsInterpreters.this.jsCallBacks.webviewPageFinishCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.webviewPageFinishCallback.onFinish(command.getActionParams().size() > 0 ? command.getActionParams().get(0) : "");
            return null;
        }
    }

    public class FocusEdittextCoordinateY extends AbstractInterpreter {
        public FocusEdittextCoordinateY() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.focusEdittextCoordinateYCallBack == null) {
                return null;
            }
            try {
                SapiJsInterpreters.this.jsCallBacks.focusEdittextCoordinateYCallBack.onCallback(new JSONObject(command.getActionParams().get(0)).optInt("coordinateY"));
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class GetAllClientAccounts extends AbstractInterpreter {
        public GetAllClientAccounts() {
            super();
        }

        private boolean isShareEnable() {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            if (sapiConfiguration != null && sapiConfiguration.loginShareStrategy() == LoginShareStrategy.CHOICE) {
                String packageName = sapiConfiguration.context.getPackageName();
                if (TextUtils.isEmpty(packageName)) {
                    return false;
                }
                for (String matches : SapiContext.getInstance().getAuthorizedPackages().keySet()) {
                    if (packageName.matches(matches)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public String interpret(final SapiWebView.Command command) {
            Log.d(ShareUtils.TAG, "GetAllClientAccounts ----- start --------");
            SapiContext instance = SapiContext.getInstance();
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException e) {
                Log.e(e);
            }
            List<SapiAccount> touchidAccounts = instance.getTouchidAccounts();
            try {
                JSONArray jSONArray = new JSONArray();
                boolean z = FingerprintUtil.getFingerPrintState(SapiJsInterpreters.this.configuration) == 0;
                for (SapiAccount next : touchidAccounts) {
                    JSONObject jSONObject2 = next.toJSONObject();
                    if (!TextUtils.isEmpty(next.phone) && next.phone.contains("http://")) {
                        next.phone = next.phone.replace("http://", "https://");
                    }
                    jSONObject2.put(SapiAccount.SAPI_ACCOUNT_PORTRAIT, next.phone);
                    String str = "1";
                    if (!z) {
                        jSONObject2.put("touchCode", str);
                    } else {
                        if (!TextUtils.isEmpty(next.email)) {
                            str = "0";
                        }
                        jSONObject2.put("touchCode", str);
                    }
                    jSONObject2.remove("phone");
                    jSONObject2.remove(SapiAccount.SAPI_ACCOUNT_EXTRA);
                    jSONObject2.remove("app");
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("fingerAccounts", jSONArray);
            } catch (Exception e2) {
                Log.e(e2);
            }
            try {
                jSONObject.put("onekeyAccounts", new OneKeyLoginSdkCall().getEncryptPhone());
            } catch (Exception e3) {
                Log.e(e3);
            }
            try {
                jSONObject.put("faceAccounts", instance.getV2FaceLoginCheckResults());
            } catch (Exception e4) {
                Log.e(e4);
            }
            try {
                JSONArray jSONArray2 = LoginHistoryItem.toJSONArray(LoginHistoryLoginModel.getAvailableLoginHistoryItems());
                if (jSONArray2 != null) {
                    jSONObject.put("history", jSONArray2);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            try {
                jSONObject.put("recentLoginUid", instance.getDecryptStr(SapiContext.KEY_LAST_LOGIN_UID));
                if (SapiJsInterpreters.this.sapiWebView != null) {
                    if (SapiJsInterpreters.this.sapiWebView.mExcludeTypesList != null) {
                        if (SapiJsInterpreters.this.sapiWebView.mExcludeTypesList.size() != 0) {
                            ArrayList<LoginTypes> arrayList = SapiJsInterpreters.this.sapiWebView.mExcludeTypesList;
                            StringBuilder sb = new StringBuilder();
                            int i2 = 0;
                            while (i2 < arrayList.size()) {
                                LoginTypes loginTypes = arrayList.get(i2);
                                if (loginTypes != null) {
                                    if (loginTypes == LoginTypes.FACE) {
                                        SapiAccountManager.getInstance().getConfignation().setSupportFaceLogin(false);
                                    }
                                    if (loginTypes == LoginTypes.FINGER) {
                                        SapiAccountManager.getInstance().getConfignation().setSupportTouchLogin(false);
                                    }
                                    String str2 = i2 == arrayList.size() - 1 ? "" : ",";
                                    sb.append(loginTypes.getName());
                                    sb.append(str2);
                                    jSONObject.put("excludeTypes", sb.toString());
                                }
                                i2++;
                            }
                        }
                    }
                    if (SapiJsInterpreters.this.sapiWebView.mExcludeTypes != null) {
                        jSONObject.put("excludeTypes", SapiJsInterpreters.this.sapiWebView.mExcludeTypes.getName());
                    }
                }
            } catch (JSONException e6) {
                Log.e(e6);
            }
            try {
                if (isShareEnable()) {
                    Log.d(ShareUtils.TAG, "GetAllClientAccounts share login is enable");
                    SapiAccountManager.getInstance().getShareModels((long) ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS, false, (ShareModelCallback) new ShareModelCallback() {
                        public void onReceiveShareModels(List<ShareStorage.StorageModel> list) {
                            command.setEndTime();
                            if (list == null || list.size() == 0) {
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            }
                            try {
                                JSONArray jSONArray = ShareStorage.StorageModel.toJSONArray(list);
                                jSONObject.put("from", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                                jSONObject.put("canshare2Accounts", jSONArray);
                                Log.d(ShareUtils.TAG, "shareV2 value=" + jSONObject.toString());
                                SapiStatUtil.statShareV2Open(list, (String) null, SapiJsInterpreters.this.sapiWebView.extras);
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (JSONException e) {
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                                e.printStackTrace();
                            }
                        }
                    });
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                Log.d(ShareUtils.TAG, "GetAllClientAccounts share login is disable");
                return null;
            } catch (Exception e7) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                Log.e(e7);
                return null;
            }
        }
    }

    public class GetCurrentAccountInfo extends AbstractInterpreter {
        public GetCurrentAccountInfo() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            JSONObject jSONObject = new JSONObject();
            if (currentAccount == null) {
                return null;
            }
            try {
                currentAccount.portrait = currentAccount.getCompletePortrait();
                jSONObject.put("currentAccount", currentAccount.toJSONObject());
                jSONObject.put("errno", 0);
                return jSONObject.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class GetPresetPhoneNumber extends AbstractInterpreter {
        public GetPresetPhoneNumber() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.configuration.forbidPresetPhoneNumber) {
                return "";
            }
            if (SapiUtils.isValidPhoneNumber(SapiJsInterpreters.this.configuration.presetPhoneNumber)) {
                return SapiJsInterpreters.this.configuration.presetPhoneNumber;
            }
            String localPhoneNumber = SapiJsInterpreters.this.sapiWebView.getLocalPhoneNumber();
            if (SapiUtils.isValidPhoneNumber(localPhoneNumber)) {
                return localPhoneNumber;
            }
            return "";
        }
    }

    public class GrantWebLogin extends AbstractInterpreter {
        public GrantWebLogin() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                int optInt = new JSONObject(command.getActionParams().get(0)).optInt("type");
                if (SapiJsInterpreters.this.jsCallBacks.grantWebCallback == null) {
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.grantWebCallback.onGrant(optInt);
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class InvoiceBuildSelectedInvoice extends AbstractInterpreter {
        public InvoiceBuildSelectedInvoice() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.invoiceBuildCallback != null && command.getActionParams().size() > 0) {
                SapiJsInterpreters.this.jsCallBacks.invoiceBuildCallback.onCallback(command.getActionParams().get(0));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    public class NormalizeGuestAccount extends AbstractInterpreter {
        public NormalizeGuestAccount() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                int optInt = jSONObject.optInt("errno");
                String optString = jSONObject.optString("msg");
                if (optInt == 0) {
                    boolean z = true;
                    if (jSONObject.optInt("merge") != 1) {
                        z = false;
                    }
                    String optString2 = jSONObject.optString("normalizeWay");
                    SapiAccountResponse parseAuthorizedResult = SapiJsInterpreters.this.sapiWebView.parseAuthorizedResult(jSONObject.optString(ResUtils.j), SapiJsInterpreters.this.context);
                    if (parseAuthorizedResult != null) {
                        SapiAccount sapiAccountResponseToAccount = SapiJsInterpreters.this.sapiWebView.sapiAccountResponseToAccount(parseAuthorizedResult);
                        if (!SapiAccount.isValidAccount(sapiAccountResponseToAccount)) {
                            SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(-202, SapiResult.ERROR_MSG_UNKNOWN);
                            return null;
                        }
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        if (currentAccount != null) {
                            sapiAccountResponseToAccount.addSocialInfo(currentAccount.getSocialType(), currentAccount.getSocialPortrait(), currentAccount.getSocialNickname(), currentAccount.getSocialOpenId());
                        }
                        SapiAccountManager.getInstance().removeLoginAccount(false, currentAccount);
                        SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount);
                        if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                            SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onSuccess(z, optString2);
                        }
                    } else if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                        SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(NormalizeGuestAccountResult.ERROR_CODE_PARSE_XML, NormalizeGuestAccountResult.ERROR_MSG_PARSE_XML);
                    }
                } else if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(optInt, optString);
                }
            } catch (JSONException e) {
                Log.e(e);
                if (SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountCallback.onFailure(-202, SapiResult.ERROR_MSG_UNKNOWN);
                }
            }
            return null;
        }
    }

    public class NormalizeGuestDescription extends AbstractInterpreter {
        public NormalizeGuestDescription() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", 0);
                if (!TextUtils.isEmpty(SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountDesc)) {
                    jSONObject.put(BiometricPrompt.KEY_DESCRIPTION, new JSONObject(SapiJsInterpreters.this.jsCallBacks.normalizeGuestAccountDesc));
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    public class OauthCallBaidu extends AbstractInterpreter {
        public OauthCallBaidu() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.bdOauthLoginParams == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.bdOauthLoginParams.callback.onCallback(command.getActionParams().get(0));
            return null;
        }
    }

    public class OauthSsoHash extends AbstractInterpreter {
        public OauthSsoHash() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback() {
                public void onSuccess(SsoHashResult ssoHashResult) {
                    command.setEndTime();
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(ssoHashResult.ssoHash);
                }
            }, SapiJsInterpreters.this.jsCallBacks.bdOauthLoginParams.callingPkg, SapiJsInterpreters.this.jsCallBacks.bdOauthLoginParams.callingAppId);
            return null;
        }
    }

    public class RealNameVerifySucceed extends AbstractInterpreter {
        public RealNameVerifySucceed() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.realnameAuthenticateCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.realnameAuthenticateCallback.onSuccess();
            return null;
        }
    }

    public class SapiActionAccountCenterFastloginFeatures extends AbstractInterpreter {
        public SapiActionAccountCenterFastloginFeatures() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            ArrayList arrayList = new ArrayList();
            if (SapiJsInterpreters.this.configuration.fastLoginFeatureList == null || SapiJsInterpreters.this.configuration.fastLoginFeatureList.isEmpty()) {
                return null;
            }
            arrayList.addAll(SapiJsInterpreters.this.configuration.fastLoginFeatureList);
            if (arrayList.isEmpty()) {
                return null;
            }
            arrayList.remove(FastLoginFeature.MEIZU_SSO);
            arrayList.remove(FastLoginFeature.SINA_WEIBO_SSO);
            arrayList.remove(FastLoginFeature.TX_QQ_SSO);
            arrayList.remove(FastLoginFeature.HUAWEI_LOGIN);
            arrayList.remove(FastLoginFeature.TX_WEIXIN_SSO);
            StringBuilder sb = new StringBuilder();
            if (SapiContext.getInstance().isHostsHijacked()) {
                return sb.toString();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                FastLoginFeature fastLoginFeature = (FastLoginFeature) arrayList.get(i2);
                if (i2 == 0) {
                    sb.append(fastLoginFeature.getStrValue());
                } else {
                    sb.append(",");
                    sb.append(fastLoginFeature.getStrValue());
                }
            }
            return sb.toString();
        }
    }

    public class SapiActionAccountDestroy extends AbstractInterpreter {
        public SapiActionAccountDestroy() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.accountDestoryCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.accountDestoryCallback.onAccountDestory(new SapiWebView.AccountDestoryCallback.AccountDestoryResult());
            }
            SapiJsInterpreters.this.sapiWebView.finish();
            return null;
        }
    }

    public class SapiActionAccountFreeze extends AbstractInterpreter {
        public SapiActionAccountFreeze() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.accountFreezeCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.accountFreezeCallback.onAccountFreeze(new SapiWebView.AccountFreezeCallback.AccountFreezeResult());
            return null;
        }
    }

    public class SapiActionBdussChanged extends AbstractInterpreter {
        public SapiActionBdussChanged() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.bdussChangeCallback != null) {
                SapiJsInterpreters.this.jsCallBacks.bdussChangeCallback.onBdussChange();
            } else {
                SapiAccountManager.getInstance().getAccountService().web2NativeLogin((Web2NativeLoginCallback) new Web2NativeLoginCallback() {
                    public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                    }

                    public void onFinish() {
                    }

                    public void onStart() {
                    }

                    public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                    }
                }, true);
            }
            new PtokenStat().onEvent(PtokenStat.SAPI_ACTION_BDUSS_CHANGED);
            return null;
        }
    }

    public class SapiActionCertGuardianResult extends AbstractInterpreter {
        public SapiActionCertGuardianResult() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                CertGuardianResult certGuardianResult = new CertGuardianResult();
                int optInt = jSONObject.optInt("errno");
                String optString = jSONObject.optString("errmsg");
                certGuardianResult.setResultCode(optInt);
                certGuardianResult.setResultMsg(optString);
                if (SapiJsInterpreters.this.jsCallBacks.certGuardianRusultCallback == null) {
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.certGuardianRusultCallback.onFinish(certGuardianResult);
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionCheckLoginStatus extends AbstractInterpreter {
        public SapiActionCheckLoginStatus() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (SapiJsInterpreters.this.jsCallBacks.loginStatusChangeCallback != null) {
                    jSONObject.put("sup", true);
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionCheckMethodSupport extends AbstractInterpreter {
        public SapiActionCheckMethodSupport() {
            super();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
            if (com.baidu.sapi2.SapiJsInterpreters.access$200(r7.this$0).supportFaceLogin != false) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ae, code lost:
            if (com.baidu.sapi2.SapiJsInterpreters.access$000(r7.this$0).invokeScAppCallback != null) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00cc, code lost:
            if (com.baidu.sapi2.SapiJsInterpreters.access$200(r7.this$0).supportFaceLogin != false) goto L_0x0083;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f8, code lost:
            if (r0 != false) goto L_0x00fc;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x00f8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r8) {
            /*
                r7 = this;
                java.lang.String r0 = ""
                r1 = 1
                r2 = 0
                java.lang.String r3 = r8.getKey()     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                if (r3 != 0) goto L_0x0024
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.util.List r4 = r8.getActionParams()     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.lang.Object r4 = r4.get(r2)     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.lang.String r4 = (java.lang.String) r4     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                r3.<init>(r4)     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.lang.String r4 = "method"
                java.lang.String r0 = r3.getString(r4)     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                goto L_0x002f
            L_0x0024:
                java.util.List r3 = r8.getActionParams()     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.lang.Object r3 = r3.get(r2)     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                r0 = r3
            L_0x002f:
                com.baidu.sapi2.SapiJsInterpreters r3 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.lang.String r3 = r3.interpreterNameToClassFullName(r0)     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | JSONException -> 0x0061 }
                java.util.List r3 = r8.getActionParams()     // Catch:{ ClassNotFoundException | JSONException -> 0x005f }
                int r3 = r3.size()     // Catch:{ ClassNotFoundException | JSONException -> 0x005f }
                if (r3 <= r1) goto L_0x005b
                java.util.List r3 = r8.getActionParams()     // Catch:{ ClassNotFoundException | JSONException -> 0x005f }
                java.lang.Object r3 = r3.get(r1)     // Catch:{ ClassNotFoundException | JSONException -> 0x005f }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ ClassNotFoundException | JSONException -> 0x005f }
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ ClassNotFoundException | JSONException -> 0x005f }
                r4.<init>(r3)     // Catch:{ ClassNotFoundException | JSONException -> 0x005f }
                java.lang.String r3 = "version"
                int r3 = r4.getInt(r3)     // Catch:{ ClassNotFoundException | JSONException -> 0x005f }
                if (r3 <= r1) goto L_0x005b
                r3 = 1
                goto L_0x005c
            L_0x005b:
                r3 = 0
            L_0x005c:
                r4 = r3
                r3 = 1
                goto L_0x0063
            L_0x005f:
                r3 = 1
                goto L_0x0062
            L_0x0061:
                r3 = 0
            L_0x0062:
                r4 = 0
            L_0x0063:
                java.lang.String r5 = "sapi_biometrics_identification_with_uid"
                boolean r5 = r0.equals(r5)
                java.lang.String r6 = "2"
                if (r5 == 0) goto L_0x0085
                com.baidu.sapi2.SapiJsInterpreters r3 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r3 = r3.jsCallBacks
                com.baidu.sapi2.SapiWebView$BioScanFaceCallback r3 = r3.bioScanFaceCallback
                if (r3 == 0) goto L_0x0082
                com.baidu.sapi2.SapiJsInterpreters r3 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiConfiguration r3 = r3.configuration
                boolean r3 = r3.supportFaceLogin
                if (r3 == 0) goto L_0x0082
                goto L_0x0083
            L_0x0082:
                r1 = 0
            L_0x0083:
                r3 = r1
                goto L_0x00cf
            L_0x0085:
                java.lang.String r5 = "sapi_biometrics_identification"
                boolean r5 = r0.equals(r5)
                if (r5 != 0) goto L_0x00ba
                java.lang.String r5 = "sapi_biometrics_identification_no_bduss"
                boolean r5 = r0.equals(r5)
                if (r5 != 0) goto L_0x00ba
                java.lang.String r5 = "sapi_biometrics_identification_with_authtoken"
                boolean r5 = r0.equals(r5)
                if (r5 == 0) goto L_0x009e
                goto L_0x00ba
            L_0x009e:
                java.lang.String r5 = "sapi_action_sc_app_check"
                boolean r5 = r0.equals(r5)
                if (r5 == 0) goto L_0x00b1
                com.baidu.sapi2.SapiJsInterpreters r3 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r3 = r3.jsCallBacks
                com.baidu.sapi2.SapiWebView$InvokeScAppCallback r3 = r3.invokeScAppCallback
                if (r3 == 0) goto L_0x0082
                goto L_0x0083
            L_0x00b1:
                java.lang.String r1 = "sapi_action_id_card_read"
                boolean r1 = r1.equals(r0)
                if (r1 == 0) goto L_0x00cf
                return r6
            L_0x00ba:
                com.baidu.sapi2.SapiJsInterpreters r3 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r3 = r3.jsCallBacks
                com.baidu.sapi2.SapiWebView$BiometricsIdentifyCallback r3 = r3.biometricsIdentifyCallback
                if (r3 == 0) goto L_0x0082
                com.baidu.sapi2.SapiJsInterpreters r3 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiConfiguration r3 = r3.configuration
                boolean r3 = r3.supportFaceLogin
                if (r3 == 0) goto L_0x0082
                goto L_0x0083
            L_0x00cf:
                if (r3 == 0) goto L_0x00d4
                java.lang.String r1 = "1"
                goto L_0x00d6
            L_0x00d4:
                java.lang.String r1 = "0"
            L_0x00d6:
                if (r3 == 0) goto L_0x00fb
                if (r4 == 0) goto L_0x00fb
                java.util.List r2 = com.baidu.sapi2.SapiJsInterpreters.SUPPORT_LIST
                boolean r0 = r2.contains(r0)
                com.baidu.sapi2.SapiContext r2 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.SapiOptions r2 = r2.getSapiOptions()
                com.baidu.sapi2.SapiOptions$Gray r2 = r2.gray
                java.lang.String r3 = "android_method_v2"
                com.baidu.sapi2.SapiOptions$Gray$GrayModule r2 = r2.getGrayModuleByFunName(r3)
                boolean r2 = r2.isMeetGray()
                if (r2 == 0) goto L_0x00fb
                if (r0 == 0) goto L_0x00fb
                goto L_0x00fc
            L_0x00fb:
                r6 = r1
            L_0x00fc:
                r8.errno = r6
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.SapiActionCheckMethodSupport.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class SapiActionCheckOpenNfc extends AbstractInterpreter {
        public SapiActionCheckOpenNfc() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_check_open_nfc jsCallBacks is null");
                return "";
            }
            try {
                if (SapiJsInterpreters.this.jsCallBacks.mIdCardNfcCallback == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_check_open_nfc jsCallBacks,mIdCardNfcCallback is null");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                }
                boolean checkOpenNFC = SapiJsInterpreters.this.jsCallBacks.mIdCardNfcCallback.checkOpenNFC();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errmsg", "");
                if (checkOpenNFC) {
                    jSONObject.put("errno", 0);
                    Log.e("NFC", "sapi_action_check_open_nfc：NFC设备打开");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                    return null;
                }
                jSONObject.put("errno", -1);
                Log.e("NFC", "sapi_action_check_open_nfc：NFC设备未打开");
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                return null;
            } catch (Exception e) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                String access$400 = SapiJsInterpreters.TAG;
                Log.e(access$400, "sapi_action_id_card_available error" + e.getMessage());
                return null;
            }
        }
    }

    public class SapiActionChinaMobileOauth extends AbstractInterpreter {
        public SapiActionChinaMobileOauth() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            new OneKeyLoginSdkCall().getToken(SapiJsInterpreters.this.configuration, new OneKeyLoginSdkCall.TokenListener() {
                public void onGetTokenComplete(JSONObject jSONObject) {
                    Log.d(OneKeyLoginSdkCall.TAG, "SapiActionChinaMobileOauth onGetTokenComplete result=" + jSONObject);
                    String operatorType = new OneKeyLoginSdkCall().getOperatorType();
                    if (OneKeyLoginSdkCall.OPERATOR_TYPE_CMCC.equals(operatorType)) {
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CM.getName());
                    } else if (OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC.equals(operatorType)) {
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CU.getName());
                    } else if (OneKeyLoginSdkCall.OPERATOR_TYPE_CTCC.equals(operatorType)) {
                        SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CT.getName());
                    }
                    command.setEndTime();
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    public class SapiActionClearFocus extends AbstractInterpreter {
        public SapiActionClearFocus() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                if (new JSONObject(command.getActionParams().get(0)).getInt("type") == 1) {
                    SapiJsInterpreters.this.sapiWebView.hideSoftInput();
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            if (SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", 0);
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                return null;
            } catch (JSONException e2) {
                Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
        }
    }

    public class SapiActionCoverWebBduss extends AbstractInterpreter {
        public SapiActionCoverWebBduss() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            String cookieBduss = SapiUtils.getCookieBduss();
            if (SapiJsInterpreters.this.jsCallBacks.coverWebBdussCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.coverWebBdussCallback.onCoverBduss(cookieBduss, new SapiWebView.CoverWebBdussResult() {
                public void setWebBduss(String str) {
                    SapiJsInterpreters.this.sapiWebView.webLogin(SapiJsInterpreters.this.context, str);
                    SapiJsInterpreters.this.sapiWebView.reload();
                }
            });
            return null;
        }
    }

    public class SapiActionCurrentLoginType extends AbstractInterpreter {
        public SapiActionCurrentLoginType() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (!(command == null || command.getActionParams() == null || command.getActionParams().isEmpty())) {
                String str = command.getActionParams().get(0);
                if ("password".equals(str)) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.PWD;
                } else if (IWalletLoginListener.LOGIN_TYPE_SMS.equals(str)) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.SMS;
                } else if ("face".equals(str)) {
                    SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.FACE;
                }
            }
            return null;
        }
    }

    public class SapiActionDeliverParams extends AbstractInterpreter {
        public SapiActionDeliverParams() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString("username");
                boolean equals = jSONObject.optString("close", "0").equals("1");
                SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult = new SapiWebView.PreFillUserNameCallback.PreFillUserNameResult();
                preFillUserNameResult.userName = optString;
                if (SapiJsInterpreters.this.jsCallBacks.prefillUserNameCallback != null) {
                    SapiJsInterpreters.this.jsCallBacks.prefillUserNameCallback.onPreFillUserName(preFillUserNameResult);
                }
                if (!equals) {
                    return null;
                }
                SapiJsInterpreters.this.sapiWebView.finish();
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionDirectedLogin extends AbstractInterpreter {
        public SapiActionDirectedLogin() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("encryptedId", SapiJsInterpreters.this.jsCallBacks.directedLoginParams.encryptedId);
                jSONObject.put("displayname", SapiJsInterpreters.this.jsCallBacks.directedLoginParams.displayname);
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionGetAppTpl extends AbstractInterpreter {
        public SapiActionGetAppTpl() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            return SapiJsInterpreters.this.configuration.getTpl();
        }
    }

    public class SapiActionGetNaUiConfig extends AbstractInterpreter {
        public SapiActionGetNaUiConfig() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                if (SapiJsInterpreters.this.configuration != null) {
                    jSONObject.put("textZoom", SapiJsInterpreters.this.configuration.getTextZoom());
                    jSONObject.put("browseModeState", SapiJsInterpreters.this.configuration.browseModeState);
                    if (SapiJsInterpreters.this.configuration.mCallbackProtocol != null) {
                        JSONArray jSONArray = new JSONArray(SapiJsInterpreters.this.configuration.mCallbackProtocol.callbackCustomProtocol());
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            ((JSONObject) jSONArray.get(i2)).put("id", i2);
                        }
                        jSONObject.put("tplAgrees", jSONArray);
                    } else {
                        jSONObject.put("tplAgrees", "");
                    }
                } else {
                    jSONObject.put("textZoom", 100);
                    jSONObject.put("browseModeState", 1);
                    jSONObject.put("tplAgrees", "");
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                Log.e(SapiJsInterpreters.TAG, "get na ui config error");
                return null;
            }
        }
    }

    public class SapiActionGetSecurityZid extends AbstractInterpreter {
        public SapiActionGetSecurityZid() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                int optInt = new JSONObject(command.getActionParams().get(0)).optInt("eventId");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                jSONObject.put("zid", Security.getZid(ServiceManager.getInstance().getIsAccountManager().getConfignation().context, optInt));
                return jSONObject.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionGotoOpenNfc extends AbstractInterpreter {
        public SapiActionGotoOpenNfc() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_goto_open_nfc jsCallBacks is null");
                return "";
            }
            try {
                if (SapiJsInterpreters.this.jsCallBacks.mIdCardNfcCallback == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_check_open_nfc jsCallBacks,SapiActionGotoOpenNfc is null");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                }
                Log.e("NFC", "sapi_action_check_open_nfc：NFC去打开");
                SapiJsInterpreters.this.jsCallBacks.mIdCardNfcCallback.gotoOpenNFC();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errmsg", "");
                jSONObject.put("errno", 0);
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                return null;
            } catch (Exception e) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                String access$400 = SapiJsInterpreters.TAG;
                Log.e(access$400, "sapi_action_id_card_available error" + e.getMessage());
                return null;
            }
        }
    }

    public class SapiActionHandleBackButton extends AbstractInterpreter {
        public SapiActionHandleBackButton() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            SapiJsInterpreters.this.jsCallBacks.leftBtnIsVisible = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.jsCallBacks.leftBtnVisibleCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.leftBtnVisibleCallback.onLeftBtnVisible(SapiJsInterpreters.this.jsCallBacks.leftBtnIsVisible);
            return null;
        }
    }

    public class SapiActionHideSuccessTip extends AbstractInterpreter {
        public SapiActionHideSuccessTip() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hideTip", SapiJsInterpreters.this.jsCallBacks.hideSuccessTip ? "1" : "0");
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionIdCardAvailable extends AbstractInterpreter {
        public SapiActionIdCardAvailable() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_id_card_available jsCallBacks is null");
                return "";
            }
            try {
                if (SapiJsInterpreters.this.jsCallBacks.mIdCardNfcCallback == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_id_card_available jsCallBacks,mIdCardNfcCallback is null");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                }
                String checkAvailable = SapiJsInterpreters.this.jsCallBacks.mIdCardNfcCallback.checkAvailable();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errmsg", "");
                if (!TextUtils.isEmpty(checkAvailable)) {
                    if (!Security.isDefaultZid(checkAvailable)) {
                        jSONObject.put("errno", 0);
                        jSONObject.put("zid", checkAvailable);
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        Log.e("NFC", "sapi_action_id_card_available 能力可用");
                        return null;
                    }
                }
                jSONObject.put("errno", -1);
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                Log.e("NFC", "sapi_action_id_card_available 能力不可用");
                return null;
            } catch (Exception e) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                String access$400 = SapiJsInterpreters.TAG;
                Log.e(access$400, "sapi_action_id_card_available error" + e.getMessage());
                return null;
            }
        }
    }

    public class SapiActionIdCardRead extends AbstractInterpreter {
        public SapiActionIdCardRead() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_id_card_read jsCallBacks is null");
                return "";
            }
            try {
                if (SapiJsInterpreters.this.jsCallBacks.mIdCardNfcCallback == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_id_card_read jsCallBacks,mIdCardNfcCallback is null");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                }
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                int optInt = jSONObject.optInt("reTryCounts", 5);
                int optInt2 = jSONObject.optInt("timeouts", 20000);
                Log.e("NFC", "sapi_action_id_card_read 开启读卡");
                SapiJsInterpreters.this.jsCallBacks.mIdCardNfcCallback.startIdCardRead(optInt, optInt2, new NFCReadCardCallback() {
                    public void onBegin() {
                    }

                    public void onFailure(int i2, String str, String str2) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", i2);
                            jSONObject.put("errmsg", str);
                            Log.e("NFC", "读卡失败：i=" + i2 + ",s=" + str);
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    public void onSuccess(String str) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", 0);
                            jSONObject.put("errmsg", "");
                            jSONObject.put("bizId", str);
                            Log.e("NFC", "读卡成功：" + str);
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                return null;
            } catch (Exception e) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                String access$400 = SapiJsInterpreters.TAG;
                Log.e(access$400, "sapi_action_id_card_available error" + e.getMessage());
                return null;
            }
        }
    }

    public class SapiActionJumpToUri extends AbstractInterpreter {
        public SapiActionJumpToUri() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                return null;
            }
            if (SapiJsInterpreters.this.jsCallBacks.jumpToUriCallBack != null) {
                try {
                    SapiJsInterpreters.this.jsCallBacks.jumpToUriCallBack.onJumpTo(new JSONObject(command.getActionParams().get(0)).optString("url"));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errno", 0);
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    }
                }
            } else {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
            }
            return null;
        }
    }

    public class SapiActionLastLoginType extends AbstractInterpreter {
        public SapiActionLastLoginType() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lastLoginType", SapiUtils.getLastLoginType());
                jSONObject.put("errno", 0);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    public class SapiActionListenIsForbidRecord extends AbstractInterpreter {
        public SapiActionListenIsForbidRecord() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                return null;
            }
            try {
                String str = command.getActionParams().get(0);
                if (SapiJsInterpreters.this.jsCallBacks.isForbidRecordCallBack != null) {
                    SapiJsInterpreters.this.jsCallBacks.isForbidRecordCallBack.onForbidRecord(Boolean.valueOf("1".equals(str)));
                }
            } catch (Exception e) {
                Log.e(e);
            }
            return null;
        }
    }

    public class SapiActionLoginStatusChange extends AbstractInterpreter {
        public SapiActionLoginStatusChange() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.loginStatusChangeCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.loginStatusChangeCallback.onChange();
            return null;
        }
    }

    public class SapiActionMakeVibrate extends AbstractInterpreter {
        public SapiActionMakeVibrate() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.makeVibrateCallBack != null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    JSONArray optJSONArray = jSONObject.optJSONArray("pattern");
                    int optInt = jSONObject.optInt("repeat", -1);
                    String optString = jSONObject.optString("broadcastText");
                    if (optJSONArray == null || optJSONArray.length() == 0) {
                        SapiJsInterpreters.this.jsCallBacks.makeVibrateCallBack.presetVibrate(optString);
                        return null;
                    }
                    long[] jArr = new long[optJSONArray.length()];
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        jArr[i2] = optJSONArray.getLong(i2);
                    }
                    SapiJsInterpreters.this.jsCallBacks.makeVibrateCallBack.vibrate(jArr, optInt, optString);
                    return null;
                } catch (JSONException e) {
                    Log.e(SapiJsInterpreters.TAG, e.getMessage());
                    if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                        return null;
                    }
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return null;
                }
            } else {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
        }
    }

    public class SapiActionMiniDi extends AbstractInterpreter {
        public SapiActionMiniDi() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONArray jSONArray;
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                if (!TextUtils.isEmpty(command.getKey())) {
                    jSONArray = new JSONArray(jSONObject.getString("di_keys").replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, ""));
                } else {
                    jSONArray = jSONObject.optJSONArray("di_keys");
                }
                if (jSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!TextUtils.isEmpty(jSONArray.optString(i2))) {
                        arrayList.add(jSONArray.optString(i2));
                    }
                }
                return SapiDeviceInfo.getDiCookieInfo(arrayList, false);
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionNaOpenCustomerService extends AbstractInterpreter {
        public SapiActionNaOpenCustomerService() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_na_open_customer_service jsCallBacks is null");
                return "";
            }
            try {
                if (SapiJsInterpreters.this.jsCallBacks.mOpenCustomerServiceCallBack == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_na_open_customer_service jsCallBacks,mOpenCustomerServiceCallBack is null");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                } else if (SapiContext.getInstance() == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_na_open_customer_service SapiContext.getInstance() is null, please check pass sdk has init");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                } else {
                    boolean onOpenCustomerService = SapiJsInterpreters.this.jsCallBacks.mOpenCustomerServiceCallBack.onOpenCustomerService();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", "0");
                        jSONObject.put("msg", "");
                        jSONObject.put("data", onOpenCustomerService);
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        return null;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        return null;
                    }
                }
            } catch (Exception e2) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                Log.e(e2);
                return "";
            }
        }
    }

    public class SapiActionOpenDuVip extends AbstractInterpreter {
        public SapiActionOpenDuVip() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_open_du_vip jsCallBacks is null");
                return "";
            }
            try {
                if (SapiJsInterpreters.this.jsCallBacks.mOpenDuVipPayCallback == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_open_du_vip jsCallBacks,mOpenDuVipPayCallback is null");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                } else if (SapiContext.getInstance() == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_open_du_vip SapiContext.getInstance() is null, please check pass sdk has init");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                } else {
                    SapiJsInterpreters.this.jsCallBacks.mOpenDuVipPayCallback.onOpenDuVipPay(new LoadDuVipPayCallBack() {
                        public void onFinish(String str) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("errno", "0");
                                jSONObject.put("msg", "");
                                jSONObject.put("data", str);
                                command.setEndTime();
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                            }
                        }
                    });
                    return null;
                }
            } catch (Exception e) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                Log.e(e);
                return "";
            }
        }
    }

    public class SapiActionOpenLogin extends AbstractInterpreter {
        public SapiActionOpenLogin() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.switchAccountCallback != null) {
                List<String> actionParams = command.getActionParams();
                SapiWebView.SwitchAccountCallback.Result result = new SapiWebView.SwitchAccountCallback.Result();
                if (actionParams != null && actionParams.size() > 0) {
                    if (actionParams.size() > 1) {
                        try {
                            Log.d(SapiJsInterpreters.TAG, "interpret: sapi_action_open_login");
                            JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                            result.extraJson = jSONObject.optString("extrajson");
                            result.displayName = jSONObject.optString("displayname");
                            result.encryptedUid = jSONObject.optString("uid");
                            result.loginType = jSONObject.optInt("type");
                            result.switchAccountType = 2;
                            SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                            return null;
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                    } else {
                        result.userName = actionParams.get(0);
                        result.switchAccountType = 1;
                        SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                        return null;
                    }
                }
                result.switchAccountType = 0;
                SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
            }
            return null;
        }
    }

    public class SapiActionOpenNaAgreeurl extends AbstractInterpreter {
        public SapiActionOpenNaAgreeurl() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_open_na_agreeurl jsCallBacks is null");
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errmsg", "");
                if (SapiJsInterpreters.this.configuration != null) {
                    if (SapiJsInterpreters.this.configuration.mCallbackProtocolListener != null) {
                        jSONObject.put("errno", 0);
                        SapiJsInterpreters.this.configuration.mCallbackProtocolListener.callbackProtocolListener(command.getActionParams().get(0));
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        return null;
                    }
                }
                jSONObject.put("errno", -1);
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                return null;
            } catch (Exception unused) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_open_na_agreeurl error");
                return null;
            }
        }
    }

    public class SapiActionPasteboardSet extends AbstractInterpreter {
        public SapiActionPasteboardSet() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                ((ClipboardManager) SapiJsInterpreters.this.context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("address", new JSONObject(command.getActionParams().get(0)).optString("content")));
                jSONObject.put("errno", 0);
                return jSONObject.toString();
            } catch (Exception e) {
                Log.e(e);
                return jSONObject.toString();
            }
        }
    }

    public class SapiActionPickDate extends AbstractInterpreter {
        public SapiActionPickDate() {
            super();
        }

        @TargetApi(11)
        public String interpret(SapiWebView.Command command) {
            final SapiWebView.Command command2 = command;
            String str = command.getActionParams().get(0);
            Calendar instance = Calendar.getInstance();
            Date time = instance.getTime();
            try {
                instance.setTime(new SimpleDateFormat("yyyyMMdd").parse(str));
            } catch (Exception e) {
                Log.e(e);
            }
            int i2 = instance.get(1);
            int i3 = instance.get(2);
            int i4 = instance.get(5);
            instance.setTime(time);
            int i5 = instance.get(1);
            int i6 = instance.get(2);
            int i7 = instance.get(5);
            DatePickerDialog datePickerDialog = new DatePickerDialog(SapiJsInterpreters.this.context, 3, new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                    command2.setEndTime();
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(i2 + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i3 + 1)}) + String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(i4)}) + "");
                }
            }, i2, i3, i4);
            datePickerDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    command2.setEndTime();
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm("");
                }
            });
            datePickerDialog.setTitle("");
            int i8 = i7;
            DatePickerDialog datePickerDialog2 = datePickerDialog;
            instance.set(i5, i6, i8, 23, 59, 59);
            datePickerDialog2.getDatePicker().setMaxDate(instance.getTimeInMillis());
            instance.set(i5 - 100, i6, i8, 0, 0, 0);
            datePickerDialog2.getDatePicker().setMinDate(instance.getTimeInMillis());
            datePickerDialog2.show();
            datePickerDialog2.setCustomTitle((View) null);
            return null;
        }
    }

    public class SapiActionPickImage extends AbstractInterpreter {
        public SapiActionPickImage() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            int i2 = 0;
            try {
                i2 = Integer.parseInt(command.getActionParams().get(0));
            } catch (Exception e) {
                Log.e(e);
            }
            int i3 = 512;
            int i4 = 1;
            if (command.getActionParams().size() > 1) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                    i4 = jSONObject.optInt("sence", 1);
                    i3 = jSONObject.optInt("size", 512);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            SapiJsInterpreters.this.jsCallBacks.pickPhotoCallback.onPickImage(i2, i4, i3, new SapiWebView.PickPhotoResult() {
                public void setImageData(String str) {
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        command.setEndTime();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
                    }
                }
            });
            return null;
        }
    }

    public class SapiActionQrLogin extends AbstractInterpreter {
        public SapiActionQrLogin() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            boolean z = false;
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                if (SapiJsInterpreters.this.jsCallBacks.qrLoginCallback != null) {
                    int optInt = jSONObject.optInt("relogin", -1);
                    if (optInt == 1) {
                        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                        String optString = jSONObject.optString("bduss");
                        String optString2 = jSONObject.optString("ptoken");
                        if (currentAccount != null && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            currentAccount.bduss = optString;
                            currentAccount.ptoken = optString2;
                            currentAccount.deleteStokens();
                            SapiAccountManager.getInstance().validate(currentAccount);
                        }
                    }
                    SapiWebView.QrLoginCallback qrLoginCallback = SapiJsInterpreters.this.jsCallBacks.qrLoginCallback;
                    if (optInt == 1) {
                        z = true;
                    }
                    qrLoginCallback.loginStatusChange(z);
                }
                if (!SapiJsInterpreters.this.jsCallBacks.finishPage) {
                    return null;
                }
                SapiJsInterpreters.this.sapiWebView.finish();
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionRealname extends AbstractInterpreter {
        public SapiActionRealname() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                int optInt = jSONObject.optInt("status");
                accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                if (SapiJsInterpreters.this.jsCallBacks.realNameStatusCallback == null) {
                    return null;
                }
                if (optInt == 1) {
                    accountRealNameResult.juniorRealNameSuc = true;
                } else if (optInt == 2) {
                    accountRealNameResult.seniorRealNameSuc = true;
                }
                SapiJsInterpreters.this.jsCallBacks.realNameStatusCallback.onFinish(accountRealNameResult);
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionRealnameSubError extends AbstractInterpreter {
        public SapiActionRealnameSubError() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                accountRealNameResult.errorStep = jSONObject.optInt("errorStep");
                accountRealNameResult.subResultCode = jSONObject.optInt("subResultCode");
                accountRealNameResult.subResultMsg = jSONObject.optString("subResultMsg");
                if (SapiJsInterpreters.this.jsCallBacks.realNameSubErrorCallback == null) {
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.realNameSubErrorCallback.onFinish(accountRealNameResult);
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionScAppCheck extends AbstractInterpreter {
        public SapiActionScAppCheck() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                jSONObject.optString("action");
                String optString = jSONObject.optString("minver");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(WXLoginActivity.w, new SapiScheme().getInvokeScState(SapiJsInterpreters.this.context, optString, SapiJsInterpreters.this.jsCallBacks.invokeScAppCallback));
                return jSONObject2.toString();
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionScAppInvoke extends AbstractInterpreter {
        public SapiActionScAppInvoke() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("minver");
                ArrayList arrayList = new ArrayList();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equals("action")) {
                        arrayList.add(new PassNameValuePair(next, jSONObject.optString(next)));
                    }
                }
                SapiJsInterpreters.this.jsCallBacks.invokeScAppCallback.onInvokeScApp(optString, optString2, arrayList, new SapiWebView.InvokeScAppCallback.InvokeScAppResult() {
                    public void setInvokeResult(String str) {
                        command.setEndTime();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
                    }
                });
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SapiActionShowLoading extends AbstractInterpreter {
        public SapiActionShowLoading() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                SapiJsInterpreters.this.sapiWebView.setWebViewShowLoading(new JSONObject(command.getActionParams().get(0)).getInt("status") == 1);
            } catch (JSONException e) {
                Log.e(e);
            }
            if (SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                return null;
            }
            command.setEndTime();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", 0);
                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                return null;
            } catch (JSONException e2) {
                Log.e(SapiJsInterpreters.TAG, e2.getMessage());
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
        }
    }

    public class SapiActionSwitchAccount extends AbstractInterpreter {
        public SapiActionSwitchAccount() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.switchAccountCallback != null) {
                List<String> actionParams = command.getActionParams();
                SapiWebView.SwitchAccountCallback.Result result = new SapiWebView.SwitchAccountCallback.Result();
                if (actionParams != null && actionParams.size() > 0) {
                    if (actionParams.size() > 1) {
                        try {
                            JSONObject jSONObject = new JSONObject(command.getActionParams().get(1));
                            result.extraJson = jSONObject.optString("extrajson");
                            result.displayName = jSONObject.optString("displayname");
                            result.encryptedUid = jSONObject.optString("uid");
                            result.loginType = jSONObject.optInt("type");
                            result.switchAccountType = 2;
                            SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                            return null;
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                    } else {
                        result.userName = actionParams.get(0);
                        result.switchAccountType = 1;
                        SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
                        return null;
                    }
                }
                result.switchAccountType = 0;
                SapiJsInterpreters.this.jsCallBacks.switchAccountCallback.onAccountSwitch(result);
            }
            return null;
        }
    }

    public class SapiActionSyncAccountInfo extends AbstractInterpreter {
        public SapiActionSyncAccountInfo() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.mSyncAccountCallBack == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_sync_account_info jsCallBacks is null");
                return "";
            }
            try {
                SapiContext instance = SapiContext.getInstance();
                if (instance == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_sync_account_info SapiContext.getInstance() is null, please check pass sdk has init");
                    return "";
                }
                SapiAccount currentAccount = instance.getCurrentAccount();
                if (currentAccount == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_sync_account_info currentAccount is null, please check current is login");
                    return "";
                }
                boolean syncAccount = SyncAccountUtils.syncAccount(command.getActionParams().get(0), currentAccount);
                JSONObject jSONObject = new JSONObject();
                if (syncAccount) {
                    SapiContext.getInstance().updateTouchidAccounts(currentAccount);
                    SapiContext.getInstance().addLoginAccount(currentAccount);
                    new ShareStorage().asyncSet(2);
                    jSONObject.put("errno", "0");
                    SapiJsInterpreters.this.jsCallBacks.mSyncAccountCallBack.onSyncAccount(currentAccount);
                } else {
                    jSONObject.put("errno", "1");
                }
                return jSONObject.toString();
            } catch (Exception e) {
                Log.e(e);
                return "";
            }
        }
    }

    public class SapiActionThirdInstalledInfo extends AbstractInterpreter {
        public SapiActionThirdInstalledInfo() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", "0");
                JSONArray jSONArray = new JSONArray();
                if (ThirdPartyUtil.isWeixinAvilible(SapiJsInterpreters.this.context)) {
                    jSONArray.put(ThirdPartyUtil.TYPE_WEIXIN);
                }
                if (ThirdPartyUtil.isQQClientAvailable(SapiJsInterpreters.this.context)) {
                    jSONArray.put(ThirdPartyUtil.TYPE_QQ);
                }
                if (ThirdPartyUtil.isSinaInstalled(SapiJsInterpreters.this.context)) {
                    jSONArray.put("tsina");
                }
                jSONObject.put("types", jSONArray);
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public class SapiActionThirdSafetyVerification extends AbstractInterpreter {
        public SapiActionThirdSafetyVerification() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.socialVerificationHandler != null) {
                try {
                    SapiJsInterpreters.this.jsCallBacks.socialVerificationHandler.sendMessage(ThirdPartyUtil.getVerificationMsg(new JSONObject(command.getActionParams().get(0)).optString("type")));
                    return null;
                } catch (JSONException e) {
                    e.printStackTrace();
                    if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                        return null;
                    }
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return null;
                }
            } else {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
        }
    }

    public class SapiActionUnbindThirdAccount extends AbstractInterpreter {
        public SapiActionUnbindThirdAccount() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks == null) {
                Log.e(SapiJsInterpreters.TAG, "sapi_action_unbind_third_account jsCallBacks is null");
                return "";
            }
            try {
                if (SapiJsInterpreters.this.jsCallBacks.mOnUnbindThirdAccountCallback == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_unbind_third_account jsCallBacks,mOnUnbindThirdAccountCallback is null");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                } else if (SapiContext.getInstance() == null) {
                    Log.e(SapiJsInterpreters.TAG, "sapi_action_unbind_third_account SapiContext.getInstance() is null, please check pass sdk has init");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return "";
                } else {
                    SapiJsInterpreters.this.jsCallBacks.mOnUnbindThirdAccountCallback.onUnbindThirdAccount(new JSONObject(command.getActionParams().get(0)).optString("thirdType"));
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", "0");
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        return null;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                        return null;
                    }
                }
            } catch (Exception e2) {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                Log.e(e2);
                return "";
            }
        }
    }

    public class SapiActionUpdateNavigator extends AbstractInterpreter {
        public SapiActionUpdateNavigator() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            int parseInt = Integer.parseInt(command.getActionParams().get(0));
            if (SapiJsInterpreters.this.jsCallBacks.pageStateCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.pageStateCallback.pageState(parseInt);
            return null;
        }
    }

    public class SapiActionUpsms extends AbstractInterpreter {
        public SapiActionUpsms() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(command.getActionParams().get(0));
            SapiUtils.sendSms(SapiJsInterpreters.this.context, command.getActionParams().get(1), arrayList);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errno", "0");
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    public class SapiBiometricsIdentification extends AbstractInterpreter {
        public SapiBiometricsIdentification() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            AnonymousClass1 r0 = new SapiWebView.BiometricsIdentifyResult() {
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        command.setEndTime();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
                    }
                }
            };
            r0.biometricType = Integer.parseInt(command.getActionParams().get(0));
            r0.livenessRecogType = "bduss";
            r0.recordVideo = 0;
            String str = "pp";
            r0.subPro = str;
            if (command.getActionParams().size() > 1) {
                r0.recordVideo = Integer.parseInt(command.getActionParams().get(1));
            }
            if (command.getActionParams().size() > 2) {
                r0.subPro = command.getActionParams().get(2).toString();
            }
            if (command.getActionParams().size() > 3) {
                try {
                    r0.showGuidePage = 1 - new JSONObject(command.getActionParams().get(3)).optInt("hideGuidePage", 0);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            if (command.getActionParams().size() > 4) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(4));
                    Iterator<String> keys = jSONObject.keys();
                    Bundle bundle = new Bundle();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bundle.putString(next, jSONObject.optString(next));
                    }
                    r0.extraParams = bundle;
                } catch (Exception e2) {
                    Log.e(e2);
                }
            }
            if (!TextUtils.isEmpty(r0.subPro)) {
                str = r0.subPro;
            }
            r0.subPro = str;
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(r0);
            return null;
        }
    }

    public class SapiBiometricsIdentificationLive extends AbstractInterpreter {
        public SapiBiometricsIdentificationLive() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentificationLiveCallBack != null) {
                try {
                    AnonymousClass1 r2 = new PassFaceRecogCallback() {
                        public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                            command.setEndTime();
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("errno", 0);
                                jSONObject.put("businessno", passFaceRecogResult.getResultCode());
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                            }
                        }

                        public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                            command.setEndTime();
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("errno", 0);
                                jSONObject.put("originalimage", passFaceRecogResult.originalImage);
                                jSONObject.put("credentialKey", passFaceRecogResult.callbackkey);
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (JSONException e) {
                                Log.e(SapiJsInterpreters.TAG, e.getMessage());
                                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                            }
                        }
                    };
                    SapiJsInterpreters.this.jsCallBacks.biometricsIdentificationLiveCallBack.getLiveImage((int) (Float.parseFloat(new JSONObject(command.getActionParams().get(0)).optString("scale")) * 100.0f), r2);
                    return null;
                } catch (JSONException e) {
                    Log.e(SapiJsInterpreters.TAG, e.getMessage());
                    if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                        return null;
                    }
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return null;
                }
            } else {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
        }
    }

    public class SapiBiometricsIdentificationNoBduss extends AbstractInterpreter {
        public SapiBiometricsIdentificationNoBduss() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            AnonymousClass1 r0 = new SapiWebView.BiometricsIdentifyResult() {
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        command.setEndTime();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
                    }
                }
            };
            r0.biometricType = Integer.parseInt(command.getActionParams().get(0));
            r0.livenessRecogType = "certinfo";
            r0.realName = command.getActionParams().get(1);
            r0.idCardNum = command.getActionParams().get(2);
            r0.recordVideo = 0;
            r0.phoneNum = "";
            if (command.getActionParams().size() > 3) {
                r0.recordVideo = Integer.parseInt(command.getActionParams().get(3));
            }
            if (command.getActionParams().size() > 4) {
                r0.phoneNum = command.getActionParams().get(4);
            }
            String str = "pp";
            r0.subPro = str;
            if (command.getActionParams().size() > 5) {
                r0.subPro = command.getActionParams().get(5);
            }
            if (command.getActionParams().size() > 6) {
                try {
                    r0.showGuidePage = 1 - new JSONObject(command.getActionParams().get(6)).optInt("hideGuidePage", 0);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            if (!TextUtils.isEmpty(r0.subPro)) {
                str = r0.subPro;
            }
            r0.subPro = str;
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(r0);
            return null;
        }
    }

    public class SapiBiometricsIdentificationWithAuthtoken extends AbstractInterpreter {
        public SapiBiometricsIdentificationWithAuthtoken() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            AnonymousClass1 r0 = new SapiWebView.BiometricsIdentifyResult() {
                public void setIdentifyToken(String str) {
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        command.setEndTime();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
                    }
                }
            };
            r0.biometricType = Integer.parseInt(command.getActionParams().get(0));
            r0.livenessRecogType = "authtoken";
            r0.authToken = command.getActionParams().get(1);
            r0.recordVideo = 0;
            String str = "pp";
            r0.subPro = str;
            if (command.getActionParams().size() > 2) {
                r0.recordVideo = Integer.parseInt(command.getActionParams().get(2));
            }
            if (command.getActionParams().size() > 3) {
                r0.subPro = command.getActionParams().get(3).toString();
            }
            if (command.getActionParams().size() > 4) {
                try {
                    r0.showGuidePage = 1 - new JSONObject(command.getActionParams().get(4)).optInt("hideGuidePage", 0);
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            if (!TextUtils.isEmpty(r0.subPro)) {
                str = r0.subPro;
            }
            r0.subPro = str;
            if (SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.biometricsIdentifyCallback.onBiometricsIdentify(r0);
            return null;
        }
    }

    public class SapiBiometricsIdentificationWithUid extends AbstractInterpreter {
        public SapiBiometricsIdentificationWithUid() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.bioScanFaceCallback == null) {
                return null;
            }
            AnonymousClass1 r0 = new SapiWebView.BioScanFaceCallback.BioScanFaceResult() {
                public void setScanFaceIdentifyResult(String str) {
                    command.setEndTime();
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(str);
                }
            };
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                r0.uid = jSONObject.optString("uid");
                r0.type = jSONObject.optInt("type");
                r0.subpro = jSONObject.optString("subpro");
                r0.showGuidePage = 1 - jSONObject.optInt("hideGuidePage", 0);
                if (TextUtils.isEmpty(r0.subpro)) {
                    r0.subpro = "pp";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("transParams");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        r0.transParamsMap.put(next, optJSONObject.optString(next));
                    }
                }
                SapiJsInterpreters.this.jsCallBacks.bioScanFaceCallback.onBioScanFace(r0);
            } catch (JSONException e) {
                Log.e(e);
            }
            return null;
        }
    }

    public class SapiClientHistoryLogin extends AbstractInterpreter {
        public SapiClientHistoryLogin() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(command.getActionParams().get(0));
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
            if (jSONObject != null) {
                LoginHistoryModel loginHistoryModel = new LoginHistoryModel();
                loginHistoryModel.bduss = jSONObject.optString("bduss");
                SapiAccountManager.getInstance().loadHistoryActionLoginFromWap(loginHistoryModel, new LoginHistoryCallback() {
                    public void onLoginFailure() {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", -1);
                            command.setEndTime();
                            command.errno = "-1";
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    public void onLoginSuccess(SapiAccount sapiAccount) {
                        if (SapiJsInterpreters.this.jsCallBacks.historyLoginCallback != null) {
                            Log.d(SapiJsInterpreters.TAG, "SapiClientHistoryLogin onLoginSuccess: ");
                            SapiJsInterpreters.this.sapiWebView.handleLoginHistoryLogin(sapiAccount);
                            SapiJsInterpreters.this.jsCallBacks.historyLoginCallback.onSuccess();
                        }
                    }
                });
            }
            return null;
        }
    }

    public class SapiGoBack extends AbstractInterpreter {
        public SapiGoBack() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.sapiWebView.canGoBack()) {
                SapiJsInterpreters.this.sapiWebView.goBack();
                return null;
            }
            SapiJsInterpreters.this.sapiWebView.finish();
            return null;
        }
    }

    public class SapiIdcardOcrImage extends AbstractInterpreter {
        public SapiIdcardOcrImage() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.idcardOcrImageCallBack != null) {
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    SapiJsInterpreters.this.jsCallBacks.idcardOcrImageCallBack.getIdcardImage(jSONObject.optString("way"), jSONObject.optString("type"), new IdcardOcrImageCallback() {
                        public void onFailure(IdcardOcrImageRusult idcardOcrImageRusult) {
                            command.setEndTime();
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("errno", idcardOcrImageRusult.getResultCode());
                                jSONObject.put("errmsg", idcardOcrImageRusult.getResultMsg());
                                command.errno = "-1";
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                            }
                        }

                        public void onSuccess(IdcardOcrImageRusult idcardOcrImageRusult) {
                            command.setEndTime();
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("errno", idcardOcrImageRusult.getResultCode());
                                jSONObject.put("errmsg", idcardOcrImageRusult.getResultMsg());
                                jSONObject.put("type", idcardOcrImageRusult.type);
                                jSONObject.put(MediaType.IMAGE_TYPE, idcardOcrImageRusult.image);
                                SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                            }
                        }
                    });
                    return null;
                } catch (JSONException e) {
                    Log.e(SapiJsInterpreters.TAG, e.getMessage());
                    if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.promptResult == null) {
                        return null;
                    }
                    SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                    return null;
                }
            } else {
                SapiJsInterpreters.this.jsCallBacks.promptResult.cancel();
                return null;
            }
        }
    }

    public class SapiOnekeyOauthToken extends AbstractInterpreter {
        public SapiOnekeyOauthToken() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            new OneKeyLoginSdkCall().getMobileOauthToken(SapiJsInterpreters.this.configuration, new OneKeyLoginSdkCall.TokenListener() {
                public void onGetTokenComplete(JSONObject jSONObject) {
                    Log.d(OneKeyLoginSdkCall.TAG, "SapiOnekeyOauthToken onGetTokenComplete result=" + jSONObject.toString());
                    command.setEndTime();
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                }
            });
            return null;
        }
    }

    public class SapiRemoveLoginHistory extends AbstractInterpreter {
        public SapiRemoveLoginHistory() {
            super();
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r6) {
            /*
                r5 = this;
                java.lang.String r0 = "."
                org.json.JSONObject r1 = new org.json.JSONObject
                r1.<init>()
                r2 = 0
                java.lang.String r3 = "errno"
                r4 = 0
                r1.put(r3, r4)     // Catch:{ Exception -> 0x0071 }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0071 }
                java.util.List r6 = r6.getActionParams()     // Catch:{ Exception -> 0x0071 }
                java.lang.Object r6 = r6.get(r4)     // Catch:{ Exception -> 0x0071 }
                java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0071 }
                r3.<init>(r6)     // Catch:{ Exception -> 0x0071 }
                java.lang.String r6 = "portraitSign"
                java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x006e }
                boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x006e }
                if (r2 != 0) goto L_0x0030
                com.baidu.sapi2.SapiContext r2 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x006e }
                r2.removeTouchidAccountByPortrait(r6)     // Catch:{ Exception -> 0x006e }
            L_0x0030:
                java.lang.String r6 = "livingunames"
                org.json.JSONArray r6 = r3.optJSONArray(r6)     // Catch:{ Exception -> 0x006e }
                if (r6 == 0) goto L_0x0045
                int r2 = r6.length()     // Catch:{ Exception -> 0x006e }
                if (r2 <= 0) goto L_0x0045
                com.baidu.sapi2.SapiContext r2 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x006e }
                r2.markAsDeleteFaceLogin(r6)     // Catch:{ Exception -> 0x006e }
            L_0x0045:
                java.lang.String r6 = "portrait"
                java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x006e }
                boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x006e }
                if (r2 != 0) goto L_0x0076
                java.lang.String r2 = "/"
                java.lang.String[] r6 = r6.split(r2)     // Catch:{ Exception -> 0x006e }
                int r2 = r6.length     // Catch:{ Exception -> 0x006e }
                int r2 = r2 + -1
                r6 = r6[r2]     // Catch:{ Exception -> 0x006e }
                boolean r2 = r6.contains(r0)     // Catch:{ Exception -> 0x006e }
                if (r2 == 0) goto L_0x006a
                int r0 = r6.lastIndexOf(r0)     // Catch:{ Exception -> 0x006e }
                java.lang.String r6 = r6.substring(r4, r0)     // Catch:{ Exception -> 0x006e }
            L_0x006a:
                com.baidu.sapi2.share.ShareUtils.markAsDeleteShareLogin(r6)     // Catch:{ Exception -> 0x006e }
                goto L_0x0076
            L_0x006e:
                r6 = move-exception
                r2 = r3
                goto L_0x0072
            L_0x0071:
                r6 = move-exception
            L_0x0072:
                com.baidu.sapi2.utils.Log.e(r6)
                r3 = r2
            L_0x0076:
                if (r3 == 0) goto L_0x0094
                java.lang.String r6 = "loginType"
                java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x0090 }
                java.lang.String r0 = "history"
                boolean r6 = android.text.TextUtils.equals(r6, r0)     // Catch:{ Exception -> 0x0090 }
                if (r6 == 0) goto L_0x0094
                java.lang.String r6 = "bduss"
                java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x0090 }
                com.baidu.sapi2.LoginHistoryLoginModel.delBdussLoginHistoryInfo(r6)     // Catch:{ Exception -> 0x0090 }
                goto L_0x0094
            L_0x0090:
                r6 = move-exception
                r6.printStackTrace()
            L_0x0094:
                java.lang.String r6 = r1.toString()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.SapiRemoveLoginHistory.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class SapiShareAccountClick extends AbstractInterpreter {
        public SapiShareAccountClick() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            String str;
            if (System.currentTimeMillis() - SapiJsInterpreters.this.preShareClickTime > 1000) {
                long unused = SapiJsInterpreters.this.preShareClickTime = System.currentTimeMillis();
                try {
                    JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                    String optString = jSONObject.optString(SapiAccount.ExtraProperty.EXTRA_PKG);
                    String optString2 = jSONObject.optString("from", ShareUtils.SHARE_ACCOUNT_NEW_VERSION);
                    if (ShareUtils.SHARE_ACCOUNT_CLOUND_VERSION.equals(optString2)) {
                        str = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
                    } else {
                        str = jSONObject.optString("url");
                    }
                    String optString3 = jSONObject.optString("trace_id");
                    String optString4 = jSONObject.optString("session_id");
                    SapiJsInterpreters.this.jsCallBacks.promptResult.confirm("finish");
                    SapiJsInterpreters.this.jsCallBacks.shareAccountClickCallback.onClick(optString, str, optString3, optString4, optString2);
                } catch (Exception e) {
                    Log.e(e);
                }
            }
            return null;
        }
    }

    public class SpeechRecognitionGetContent extends AbstractInterpreter {
        public SpeechRecognitionGetContent() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            SapiJsInterpreters.this.jsCallBacks.speechRecognitionCallback.onSpeechRecognition(new SapiJsCallBacks.SpeechRecognitionResult() {
                public void setSpeechData(int i2, String str) {
                    if (SapiJsInterpreters.this.jsCallBacks.promptResult != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("errno", i2);
                            jSONObject.put("text", str);
                            command.setEndTime();
                            SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                    }
                }
            });
            return null;
        }
    }

    public class SwitchAccountGetAccounts extends AbstractInterpreter {
        public SwitchAccountGetAccounts() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            List<SapiAccount> arrayList = new ArrayList<>();
            if (SapiJsInterpreters.this.configuration.supportMultipleAccounts) {
                arrayList = SapiContext.getInstance().getLoginAccounts();
            } else {
                arrayList.add(SapiContext.getInstance().getCurrentAccount());
            }
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.SWITCH;
            JSONArray jSONArray = new JSONArray();
            try {
                for (SapiAccount sapiAccount : arrayList) {
                    JSONObject jSONObject2 = sapiAccount.toJSONObject();
                    jSONObject2.put(SapiAccount.SAPI_ACCOUNT_PORTRAIT, sapiAccount.getCompletePortrait());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("errno", 0);
                jSONObject.put("accountList", jSONArray);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    public class SwitchAccountGetConfig extends AbstractInterpreter {
        public SwitchAccountGetConfig() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            int i2 = 0;
            try {
                jSONObject.put("errno", 0);
                jSONObject.put("showSwitchAccount", SapiJsInterpreters.this.sapiWebView.showSwitchAccount ? 1 : 0);
                if (SapiJsInterpreters.this.sapiWebView.showLinkAccount) {
                    i2 = 1;
                }
                jSONObject.put("showLinkAccount", i2);
            } catch (JSONException e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    public class SwitchAccountRemoveAccount extends AbstractInterpreter {
        public SwitchAccountRemoveAccount() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            JSONObject jSONObject = new JSONObject();
            try {
                String optString = new JSONObject(command.getActionParams().get(0)).optString("uid");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                for (SapiAccount next : SapiContext.getInstance().getLoginAccounts()) {
                    if (optString.equals(next.uid)) {
                        SapiAccountManager.getInstance().removeLoginAccount(true, next);
                        jSONObject.put("errno", 0);
                        return jSONObject.toString();
                    }
                }
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class SwitchStyleForCloseBtnAndStatusBar extends AbstractInterpreter {
        public SwitchStyleForCloseBtnAndStatusBar() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            if (SapiJsInterpreters.this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack == null) {
                return null;
            }
            try {
                SapiJsInterpreters.this.jsCallBacks.mSwitchStyleForCloseBtnAndStatusBarCallBack.switchStyle(new JSONObject(command.getActionParams().get(0)).optString("styleType"));
                return null;
            } catch (Exception e) {
                Log.e(e);
                return null;
            }
        }
    }

    public class TouchidChangeStatus extends AbstractInterpreter {
        public TouchidChangeStatus() {
            super();
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(final com.baidu.sapi2.SapiWebView.Command r7) {
            /*
                r6 = this;
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                r1 = 0
                java.lang.String r2 = "errno"
                r3 = 0
                r0.put(r2, r3)     // Catch:{ JSONException -> 0x0038 }
                java.lang.String r2 = "status"
                r0.put(r2, r3)     // Catch:{ JSONException -> 0x0038 }
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0038 }
                java.util.List r4 = r7.getActionParams()     // Catch:{ JSONException -> 0x0038 }
                java.lang.Object r3 = r4.get(r3)     // Catch:{ JSONException -> 0x0038 }
                java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x0038 }
                r2.<init>(r3)     // Catch:{ JSONException -> 0x0038 }
                java.lang.String r3 = "handle"
                java.lang.String r3 = r2.optString(r3)     // Catch:{ JSONException -> 0x0038 }
                java.lang.String r4 = "portrait"
                java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x0035 }
                java.lang.String r5 = "portraitSign"
                java.lang.String r2 = r2.optString(r5)     // Catch:{ JSONException -> 0x0033 }
                goto L_0x003f
            L_0x0033:
                r2 = move-exception
                goto L_0x003b
            L_0x0035:
                r2 = move-exception
                r4 = r1
                goto L_0x003b
            L_0x0038:
                r2 = move-exception
                r3 = r1
                r4 = r3
            L_0x003b:
                com.baidu.sapi2.utils.Log.e(r2)
                r2 = r1
            L_0x003f:
                com.baidu.sapi2.SapiContext r5 = com.baidu.sapi2.SapiContext.getInstance()
                com.baidu.sapi2.SapiAccount r5 = r5.getCurrentAccount()
                r5.phone = r4
                java.lang.String r4 = "open"
                boolean r3 = r4.equals(r3)
                if (r3 == 0) goto L_0x0076
                r5.email = r2
                com.baidu.sapi2.SapiJsInterpreters$TouchidChangeStatus$1 r2 = new com.baidu.sapi2.SapiJsInterpreters$TouchidChangeStatus$1
                r2.<init>(r0, r5, r7)
                com.baidu.sapi2.SapiJsInterpreters r7 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r7 = r7.jsCallBacks
                if (r7 == 0) goto L_0x0075
                com.baidu.sapi2.SapiJsInterpreters r7 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r7 = r7.jsCallBacks
                com.baidu.sapi2.SapiJsCallBacks$FingerprintCallback r7 = r7.fingerprintCallback
                if (r7 == 0) goto L_0x0075
                com.baidu.sapi2.SapiJsInterpreters r7 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r7 = r7.jsCallBacks
                com.baidu.sapi2.SapiJsCallBacks$FingerprintCallback r7 = r7.fingerprintCallback
                r7.onCallback(r2)
            L_0x0075:
                return r1
            L_0x0076:
                java.lang.String r7 = ""
                r5.email = r7
                com.baidu.sapi2.SapiContext r7 = com.baidu.sapi2.SapiContext.getInstance()
                r7.addTouchidAccounts(r5)
                com.baidu.sapi2.SapiJsInterpreters r7 = com.baidu.sapi2.SapiJsInterpreters.this
                com.baidu.sapi2.SapiJsCallBacks$CallBacks r7 = r7.jsCallBacks
                android.webkit.JsPromptResult r7 = r7.promptResult
                java.lang.String r0 = r0.toString()
                r7.confirm(r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.TouchidChangeStatus.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class TouchidCheckGuideStatus extends AbstractInterpreter {
        public TouchidCheckGuideStatus() {
            super();
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0074 A[Catch:{ Exception -> 0x00e3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0077 A[Catch:{ Exception -> 0x00e3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0088 A[Catch:{ Exception -> 0x00e3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00db A[Catch:{ Exception -> 0x00e3 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String interpret(com.baidu.sapi2.SapiWebView.Command r9) {
            /*
                r8 = this;
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e3 }
                java.util.List r9 = r9.getActionParams()     // Catch:{ Exception -> 0x00e3 }
                r2 = 0
                java.lang.Object r9 = r9.get(r2)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x00e3 }
                r1.<init>(r9)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r9 = "portraitSign"
                java.lang.String r9 = r1.optString(r9)     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiJsInterpreters r1 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiConfiguration r1 = r1.configuration     // Catch:{ Exception -> 0x00e3 }
                int r1 = com.baidu.sapi2.touchid.FingerprintUtil.getFingerPrintState(r1)     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiContext r3 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x00e3 }
                java.util.List r3 = r3.getTouchidLoginRecord()     // Catch:{ Exception -> 0x00e3 }
                boolean r3 = r3.contains(r9)     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiContext r4 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x00e3 }
                java.util.List r4 = r4.getTouchidAccounts()     // Catch:{ Exception -> 0x00e3 }
                r5 = 1
                if (r4 == 0) goto L_0x005c
                java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x00e3 }
            L_0x0040:
                boolean r6 = r4.hasNext()     // Catch:{ Exception -> 0x00e3 }
                if (r6 == 0) goto L_0x005c
                java.lang.Object r6 = r4.next()     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiAccount r6 = (com.baidu.sapi2.SapiAccount) r6     // Catch:{ Exception -> 0x00e3 }
                if (r6 == 0) goto L_0x0040
                java.lang.String r7 = r6.email     // Catch:{ Exception -> 0x00e3 }
                if (r7 == 0) goto L_0x0040
                java.lang.String r6 = r6.email     // Catch:{ Exception -> 0x00e3 }
                boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x00e3 }
                if (r6 == 0) goto L_0x0040
                r4 = 1
                goto L_0x005d
            L_0x005c:
                r4 = 0
            L_0x005d:
                if (r1 != 0) goto L_0x0069
                boolean r6 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00e3 }
                if (r6 != 0) goto L_0x0069
                if (r3 != 0) goto L_0x0069
                r6 = 1
                goto L_0x006a
            L_0x0069:
                r6 = 0
            L_0x006a:
                com.baidu.sapi2.SapiJsInterpreters r7 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiWebView r7 = r7.sapiWebView     // Catch:{ Exception -> 0x00e3 }
                boolean r7 = r7.supportTouchGuide     // Catch:{ Exception -> 0x00e3 }
                if (r7 != 0) goto L_0x0075
                r6 = 0
            L_0x0075:
                if (r4 == 0) goto L_0x0078
                r6 = 0
            L_0x0078:
                java.lang.String r7 = "errno"
                r0.put(r7, r2)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r2 = "guide"
                r0.put(r2, r6)     // Catch:{ Exception -> 0x00e3 }
                boolean r2 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x00e3 }
                if (r2 == 0) goto L_0x008b
                java.lang.String r1 = "100"
                goto L_0x00cc
            L_0x008b:
                r2 = 101(0x65, float:1.42E-43)
                java.lang.String r7 = ""
                if (r1 == r2) goto L_0x00bd
                r2 = 102(0x66, float:1.43E-43)
                if (r1 != r2) goto L_0x0096
                goto L_0x00bd
            L_0x0096:
                if (r3 == 0) goto L_0x009b
                java.lang.String r1 = "103"
                goto L_0x00cc
            L_0x009b:
                com.baidu.sapi2.SapiJsInterpreters r2 = com.baidu.sapi2.SapiJsInterpreters.this     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.SapiWebView r2 = r2.sapiWebView     // Catch:{ Exception -> 0x00e3 }
                boolean r2 = r2.supportTouchGuide     // Catch:{ Exception -> 0x00e3 }
                if (r2 != 0) goto L_0x00a8
                java.lang.String r1 = "106"
                goto L_0x00cc
            L_0x00a8:
                if (r4 == 0) goto L_0x00ad
                java.lang.String r1 = "107"
                goto L_0x00cc
            L_0x00ad:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
                r2.<init>()     // Catch:{ Exception -> 0x00e3 }
                r2.append(r1)     // Catch:{ Exception -> 0x00e3 }
                r2.append(r7)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00e3 }
                goto L_0x00cc
            L_0x00bd:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e3 }
                r2.<init>()     // Catch:{ Exception -> 0x00e3 }
                r2.append(r1)     // Catch:{ Exception -> 0x00e3 }
                r2.append(r7)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00e3 }
            L_0x00cc:
                java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x00e3 }
                r2.<init>(r5)     // Catch:{ Exception -> 0x00e3 }
                java.lang.String r3 = "native_guide_finger"
                r2.put(r3, r1)     // Catch:{ Exception -> 0x00e3 }
                com.baidu.sapi2.utils.StatService.onEventAutoStatistic(r2)     // Catch:{ Exception -> 0x00e3 }
                if (r6 != r5) goto L_0x00e7
                com.baidu.sapi2.SapiContext r1 = com.baidu.sapi2.SapiContext.getInstance()     // Catch:{ Exception -> 0x00e3 }
                r1.addTouchidLoginRecord(r9)     // Catch:{ Exception -> 0x00e3 }
                goto L_0x00e7
            L_0x00e3:
                r9 = move-exception
                com.baidu.sapi2.utils.Log.e(r9)
            L_0x00e7:
                java.lang.String r9 = r0.toString()
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiJsInterpreters.TouchidCheckGuideStatus.interpret(com.baidu.sapi2.SapiWebView$Command):java.lang.String");
        }
    }

    public class TouchidGetStatus extends AbstractInterpreter {
        public TouchidGetStatus() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            boolean z;
            JSONObject jSONObject = new JSONObject();
            try {
                int i2 = 1;
                if (FingerprintUtil.getFingerPrintState(SapiJsInterpreters.this.configuration) == 0) {
                    List<SapiAccount> touchidAccounts = SapiContext.getInstance().getTouchidAccounts();
                    SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                    Iterator<SapiAccount> it = touchidAccounts.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        SapiAccount next = it.next();
                        if (next.equals(currentAccount) && !TextUtils.isEmpty(next.email)) {
                            z = true;
                            break;
                        }
                    }
                    if (!z) {
                        i2 = 2;
                    }
                } else {
                    i2 = 0;
                }
                jSONObject.put("errno", 0);
                jSONObject.put("status", i2);
            } catch (Exception e) {
                Log.e(e);
            }
            return jSONObject.toString();
        }
    }

    public class TouchidLogin extends AbstractInterpreter {
        public TouchidLogin() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            AnonymousClass1 r0 = new SapiJsCallBacks.FingerprintResult() {
                public void setResult(int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i2);
                        command.setEndTime();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                    } catch (Exception e) {
                        Log.e(e);
                    }
                }
            };
            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.TOUCHID;
            r0.authType = 3;
            if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.fingerprintCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.fingerprintCallback.onCallback(r0);
            return null;
        }
    }

    public class TouchidOpenGuide extends AbstractInterpreter {
        public TouchidOpenGuide() {
            super();
        }

        public String interpret(final SapiWebView.Command command) {
            AnonymousClass1 r0 = new SapiJsCallBacks.FingerprintResult() {
                public void setResult(int i2) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("errno", 0);
                        jSONObject.put("status", i2);
                        command.setEndTime();
                        SapiJsInterpreters.this.jsCallBacks.promptResult.confirm(jSONObject.toString());
                        if (i2 == 0) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(command.getActionParams().get(0));
                                String optString = jSONObject2.optString(SapiAccount.SAPI_ACCOUNT_PORTRAIT);
                                String optString2 = jSONObject2.optString(SyncAccountUtils.KEY_PORTRAIT_SIGN);
                                if (TextUtils.isEmpty(optString)) {
                                    String[] strArr = SapiJsInterpreters.this.jsCallBacks.touchidPortraitAndSign;
                                    strArr[0] = SapiJsInterpreters.this.configuration.environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
                                    String[] strArr2 = SapiJsInterpreters.this.sapiWebView.touchidPortraitAndSign;
                                    strArr2[0] = SapiJsInterpreters.this.configuration.environment.getConfigHttpsUrl() + SapiEnv.DEFAULT_PORTRAIT;
                                } else {
                                    SapiJsInterpreters.this.jsCallBacks.touchidPortraitAndSign[0] = optString;
                                    SapiJsInterpreters.this.sapiWebView.touchidPortraitAndSign[0] = optString;
                                }
                                SapiJsInterpreters.this.jsCallBacks.touchidPortraitAndSign[1] = optString2;
                                SapiJsInterpreters.this.sapiWebView.touchidPortraitAndSign[1] = optString2;
                            } catch (Exception e) {
                                Log.e(e);
                            }
                        }
                    } catch (Exception e2) {
                        Log.e(e2);
                    }
                }
            };
            if (SapiJsInterpreters.this.jsCallBacks == null || SapiJsInterpreters.this.jsCallBacks.fingerprintCallback == null) {
                return null;
            }
            SapiJsInterpreters.this.jsCallBacks.fingerprintCallback.onCallback(r0);
            return null;
        }
    }

    public class UniteVerifyResult extends AbstractInterpreter {
        public UniteVerifyResult() {
            super();
        }

        public String interpret(SapiWebView.Command command) {
            try {
                JSONObject jSONObject = new JSONObject(command.getActionParams().get(0));
                String optString = jSONObject.optString("info");
                String optString2 = jSONObject.optString("u");
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = jSONObject.optString("passuid");
                sapiAccount.username = jSONObject.optString("username");
                sapiAccount.displayname = jSONObject.optString("displayname");
                sapiAccount.bduss = jSONObject.optString("bduss");
                sapiAccount.ptoken = jSONObject.optString("ptoken");
                sapiAccount.stoken = jSONObject.optString("stoken");
                if (TextUtils.isEmpty(optString) || !SapiAccount.isValidAccount(sapiAccount) || SapiJsInterpreters.this.jsCallBacks.uniteVerifyCallback == null) {
                    return null;
                }
                SapiJsInterpreters.this.jsCallBacks.uniteVerifyCallback.onSuccess(optString, optString2, sapiAccount);
                return null;
            } catch (JSONException e) {
                Log.e(e);
                return null;
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        SUPPORT_LIST = arrayList;
        arrayList.add(SapiUtil.CHECK_METHOD_SUPPOT);
        SUPPORT_LIST.add("sapi_action_get_security_zid");
        SUPPORT_LIST.add("sapi_action_get_na_ui_config");
        SUPPORT_LIST.add("action_get_loadtime");
        SUPPORT_LIST.add("switch_style_for_close_btn_and_status_bar");
        SUPPORT_LIST.add("sapi_action_mini_di");
        SUPPORT_LIST.add("sapi_action_update_navigator");
        SUPPORT_LIST.add("finish");
        SUPPORT_LIST.add("get_all_client_accounts");
        SUPPORT_LIST.add("sapi_action_last_login_type");
        SUPPORT_LIST.add("sapi_action_id_card_read");
    }

    public SapiJsInterpreters(SapiWebView sapiWebView2, SapiJsCallBacks.CallBacks callBacks) {
        this.sapiWebView = sapiWebView2;
        this.context = sapiWebView2.getContext();
        this.jsCallBacks = callBacks;
        this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    private AbstractInterpreter buidInterpreterByName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (AbstractInterpreter) Class.forName(interpreterNameToClassFullName(str)).getDeclaredConstructor(new Class[]{getClass()}).newInstance(new Object[]{this});
        } catch (Exception e) {
            Log.e(e);
            return null;
        }
    }

    public static List<String> getSupportList() {
        return SUPPORT_LIST;
    }

    /* access modifiers changed from: private */
    public String interpreterNameToClassFullName(String str) {
        String[] split = str.split("_");
        StringBuilder sb = new StringBuilder();
        sb.append("com.baidu.sapi2.SapiJsInterpreters$");
        for (String charArray : split) {
            char[] charArray2 = charArray.toCharArray();
            if (charArray2[0] >= 'a' && charArray2[0] <= 'z') {
                charArray2[0] = (char) (charArray2[0] - ' ');
            }
            sb.append(new String(charArray2));
        }
        return sb.toString();
    }

    public AbstractInterpreter getInterpreter(String str) {
        AbstractInterpreter abstractInterpreter = this.interpreterHashMap.get(str);
        if (abstractInterpreter == null && (abstractInterpreter = buidInterpreterByName(str)) != null) {
            this.interpreterHashMap.put(str, abstractInterpreter);
        }
        return abstractInterpreter;
    }
}
