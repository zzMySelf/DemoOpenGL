package com.baidu.sapi2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.dingtalk.openauth.AuthLoginParam;
import com.android.dingtalk.openauth.DDAuthApiFactory;
import com.baidu.sapi2.activity.AccountCenterActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.social.BaseSSOLoginActivity;
import com.baidu.sapi2.activity.social.CFOSSOLoginActivity;
import com.baidu.sapi2.activity.social.DingDingLoginActivity;
import com.baidu.sapi2.activity.social.FacebookSSOLoginActivity;
import com.baidu.sapi2.activity.social.GoogleSSOLoginActivity;
import com.baidu.sapi2.activity.social.HonorSSOLoginActivity;
import com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity;
import com.baidu.sapi2.activity.social.MeizuSSOLoginActivity;
import com.baidu.sapi2.activity.social.OppoSSOLoginActivity;
import com.baidu.sapi2.activity.social.QQOauthLoginActivity;
import com.baidu.sapi2.activity.social.QQSSOLoginActivity;
import com.baidu.sapi2.activity.social.SinaSSOLoginActivity;
import com.baidu.sapi2.activity.social.TwitterSSOLoginActivity;
import com.baidu.sapi2.activity.social.VivoSSOLoginActivity;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.activity.social.YYSSOLoginActivity;
import com.baidu.sapi2.activity.social.a;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.enums.ThirdPartyLoginBindType;
import com.google.android.gms.common.Scopes;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class ThirdPartyService implements AbstractThirdPartyService {
    public static final String b = "ThirdPartyService";
    public static final long c = 500;
    public static ThirdLoginCallback d = null;
    public static boolean e = false;
    public static final int f = -404;
    public static boolean g = false;
    public static final int h = -405;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f947i = false;
    public long a = 0;

    public ThirdPartyService() {
        CoreViewRouter.getInstance().setThirdPartyService(this);
    }

    private void a(Context context, int i2) {
        Intent intent = new Intent(context, OppoSSOLoginActivity.class);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 2001);
            return;
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static ThirdLoginCallback getThirdLoginCallback() {
        return d;
    }

    public static void releaseThirdLoginCallback() {
        d = null;
    }

    public void handleDingdingLoginResp(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, DingDingLoginActivity.class);
        intent.putExtra(DingDingLoginActivity.s, str);
        intent.putExtra(DingDingLoginActivity.t, str2);
        intent.putExtra(DingDingLoginActivity.u, str3);
        intent.putExtra(BaseSSOLoginActivity.q, f947i);
        Integer num = ThirdPartyUtil.dingdingAuthMap.get("businessType");
        if (num != null) {
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, num.intValue());
        }
        activity.startActivity(intent);
    }

    public void handleWXLoginResp(Activity activity, String str, String str2, int i2) {
        String str3;
        if (e) {
            ThirdLoginCallback thirdLoginCallback = d;
            releaseThirdLoginCallback();
            if (i2 == 0) {
                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
                boolean z = socialLoginDTO != null && socialLoginDTO.needBpPush;
                if (socialLoginDTO == null) {
                    str3 = "";
                } else {
                    str3 = socialLoginDTO.pushBpFrom;
                }
                String urlWeixinBind = ParamsUtil.getUrlWeixinBind(confignation, str2, str, z, str3, false);
                thirdLoginCallback.onAuthSuccess();
                String str4 = b;
                Log.d(str4, "handleWXLoginResp: url:" + urlWeixinBind);
                a.a().a(urlWeixinBind, thirdLoginCallback);
            } else {
                thirdLoginCallback.onAuthFailure(i2, OAuthResult.ERROR_MSG_UNKNOWN);
            }
            e = false;
            return;
        }
        Intent intent = new Intent(activity, WXLoginActivity.class);
        intent.putExtra(WXLoginActivity.v, true);
        intent.putExtra(WXLoginActivity.y, i2);
        intent.putExtra(WXLoginActivity.w, str);
        intent.putExtra("code", str2);
        intent.putExtra(BaseSSOLoginActivity.q, f947i);
        activity.startActivity(intent);
    }

    public void loadCFOSSOLogin(Context context, int i2) {
        Intent intent = new Intent(context, CFOSSOLoginActivity.class);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void loadDingdingSSOLogin(Context context, int i2) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        AuthLoginParam.AuthLoginParamBuilder newBuilder = AuthLoginParam.AuthLoginParamBuilder.newBuilder();
        ThirdPartyUtil.dingdingAuthMap.put("businessType", Integer.valueOf(i2));
        newBuilder.appId(confignation.dingdingAppID);
        newBuilder.redirectUri(confignation.dingdingRedirectUri);
        newBuilder.scope(Scopes.OPEN_ID);
        newBuilder.responseType("code");
        newBuilder.prompt("consent");
        DDAuthApiFactory.createDDAuthApi(context, newBuilder.build()).authLogin();
    }

    public void loadQQLogin(Context context, int i2) {
        Intent intent = new Intent(context, QQOauthLoginActivity.class);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2) {
        Log.d(b, "loadThirdPartyLogin: 1");
        loadThirdPartyLogin(context, socialType, i2, (String) null, false);
    }

    public void loadWechatLogin(Context context, int i2) {
        if (d != null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            if (confignation == null) {
                d.onAuthFailure(-404, "pass没有初始化");
                releaseThirdLoginCallback();
            } else if (!WXAPIFactory.createWXAPI(confignation.context, confignation.wxAppID).isWXAppInstalled()) {
                d.onAuthFailure(-404, "微信未安装");
                releaseThirdLoginCallback();
            } else {
                e = true;
                Intent intent = new Intent(context, WXLoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            }
        }
    }

    public void loadYYSSOLogin(Context context, String str) {
        Intent intent = new Intent(context, YYInnerSSOLoginActivity.class);
        intent.putExtra(YYInnerSSOLoginActivity.s, str);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2002);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public SapiAccount sapiAccountResponseToAccount(Context context, SapiAccountResponse sapiAccountResponse) {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(context) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        SocialType socialType = SocialType.UNKNOWN;
        SocialType socialType2 = sapiAccountResponse.socialType;
        if (socialType != socialType2) {
            sapiAccount.addSocialInfo(socialType2, sapiAccountResponse.socialPortraitUrl, sapiAccountResponse.socialNickname, sapiAccountResponse.openid);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", sapiConfiguration.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(context, sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    public void socialBind(Activity activity, SocialType socialType, int i2, String str) {
        if (socialType == SocialType.WEIXIN) {
            e = false;
            Log.d(b, "socialBind: WEIXIN");
            Intent intent = new Intent(activity, WXLoginActivity.class);
            intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
            intent.putExtra(AccountCenterActivity.EXTRA_WEIIXIN_BIND_URL, str);
            intent.putExtra(BaseSSOLoginActivity.q, f947i);
            activity.startActivity(intent);
        }
    }

    public void loadThirdPartyLogin(Context context, WebSocialLoginDTO webSocialLoginDTO, int i2, ThirdLoginCallback thirdLoginCallback) {
        d = thirdLoginCallback;
        Log.d(b, "loadThirdPartyLogin: 2");
        loadThirdPartyLogin(context, webSocialLoginDTO.socialType, i2, (String) null, false, false, webSocialLoginDTO);
    }

    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str) {
        Log.d(b, "loadThirdPartyLogin: 3");
        loadThirdPartyLogin(context, socialType, i2, str, false);
    }

    private void a(Context context, int i2, WebSocialLoginDTO webSocialLoginDTO) {
        Intent intent = new Intent(context, VivoSSOLoginActivity.class);
        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
        if (webSocialLoginDTO != null) {
            intent.putExtra(VivoSSOLoginActivity.y, webSocialLoginDTO.loginBindType.getTypeNum());
            if (webSocialLoginDTO.loginBindType == ThirdPartyLoginBindType.TYPE_BIND_WITH_AUTH_CODE) {
                intent.putExtra(VivoSSOLoginActivity.x, TextUtils.isEmpty(webSocialLoginDTO.authCode) ? "" : webSocialLoginDTO.authCode);
            }
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 2001);
            return;
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str, boolean z) {
        Log.d(b, "loadThirdPartyLogin: 4");
        loadThirdPartyLogin(context, socialType, i2, str, z, false, (WebSocialLoginDTO) null);
    }

    public void loadThirdPartyLogin(Context context, SocialType socialType, int i2, String str, boolean z, boolean z2, WebSocialLoginDTO webSocialLoginDTO) {
        Intent intent;
        String str2 = b;
        Log.d(str2, "loadThirdPartyLogin: 5 name:" + socialType.getName() + ", type:" + socialType.getType());
        if (System.currentTimeMillis() - this.a >= 500) {
            this.a = System.currentTimeMillis();
            f947i = z2;
            SapiStatUtil.statThirdLoginEnter(socialType);
            try {
                if (SapiAccountManager.getInstance() == null) {
                    return;
                }
                if (SapiAccountManager.getInstance().getConfignation() != null) {
                    SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                    if (confignation.context != null) {
                        if (context.getPackageName() != null && !context.getPackageName().equals(confignation.context.getPackageName())) {
                            context = confignation.context;
                        }
                        boolean z3 = context instanceof Activity;
                        if (socialType == SocialType.SINA_WEIBO_SSO) {
                            intent = new Intent(context, SinaSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WEIBO;
                        } else if (socialType == SocialType.HUAWEI) {
                            intent = new Intent(context, HuaweiSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HUAWEI;
                        } else if (socialType == SocialType.WEIXIN) {
                            e = false;
                            intent = new Intent(context, WXLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
                        } else if (socialType == SocialType.QQ_SSO) {
                            intent = new Intent(context, QQSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
                        } else if (socialType == SocialType.MEIZU) {
                            intent = new Intent(context, MeizuSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.MEIZU;
                        } else if (socialType == SocialType.FACEBOOK) {
                            intent = new Intent(context, FacebookSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.OTHER;
                        } else if (socialType == SocialType.XIAOMI) {
                            intent = new Intent(context, XiaomiSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.XIAOMI;
                        } else if (socialType == SocialType.TWITTER) {
                            intent = new Intent(context, TwitterSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.OTHER;
                        } else if (socialType == SocialType.GOOGLE) {
                            intent = new Intent(context, GoogleSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.OTHER;
                        } else if (socialType == SocialType.HONOR) {
                            intent = new Intent(context, HonorSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.HONOR;
                        } else if (socialType == SocialType.YY) {
                            intent = new Intent(context, YYSSOLoginActivity.class);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.YY;
                        } else if (socialType == SocialType.QQ_SSO_BACKGROUND) {
                            loadQQLogin(context, i2);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.QQ;
                            return;
                        } else if (socialType == SocialType.WEIXIN_BACKGROUND) {
                            loadWechatLogin(context, i2);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.WECHAT;
                            return;
                        } else if (socialType == SocialType.CFO) {
                            loadCFOSSOLogin(context, i2);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.CFO;
                            return;
                        } else if (socialType == SocialType.DINGDING) {
                            loadDingdingSSOLogin(context, i2);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.DINGDING;
                            return;
                        } else if (socialType == SocialType.OPPO) {
                            a(context, i2);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.OPPO;
                            return;
                        } else if (socialType == SocialType.VIVO) {
                            a(context, i2, webSocialLoginDTO);
                            SapiContext.getInstance().mLastLoginType = Enums.LastLoginType.VIVO;
                            return;
                        } else {
                            throw new IllegalArgumentException(socialType.getName() + " type login not support");
                        }
                        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, i2);
                        intent.putExtra(BaseSSOLoginActivity.p, z);
                        intent.putExtra(BaseSSOLoginActivity.q, f947i);
                        if (!TextUtils.isEmpty(str)) {
                            intent.putExtra("extraJson", str);
                        }
                        if (!z3) {
                            Log.d(b, "loadThirdPartyLogin: startActivityForResult !isActivity");
                            intent.setFlags(268435456);
                            context.startActivity(intent);
                            return;
                        }
                        Log.d(b, "loadThirdPartyLogin: startActivityForResult");
                        ((Activity) context).startActivityForResult(intent, 2001);
                    }
                }
            } catch (Exception e2) {
                String str3 = b;
                Log.e(str3, "loadThirdPartyLogin: Exception" + e2.getMessage());
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(13);
                webAuthResult.setResultMsg(WebAuthResult.ERROR_MSG_CONTEXT_ERROR);
                CoreViewRouter instance = CoreViewRouter.getInstance();
                if (instance != null && instance.getWebAuthListener() != null) {
                    CoreViewRouter.getInstance().getWebAuthListener().onFailure(webAuthResult);
                    CoreViewRouter.getInstance().release();
                }
            }
        }
    }
}
