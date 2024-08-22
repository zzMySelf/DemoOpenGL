package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.alipay.sdk.m.l.b;
import com.alipay.sdk.m.s.a;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.enums.BindInfoAction;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.dlife.ctaccountapi.t;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParamsUtil implements NoProguard {

    /* renamed from: com.baidu.sapi2.utils.ParamsUtil$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$sapi2$utils$enums$BindInfoAction;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.baidu.sapi2.utils.enums.BindInfoAction[] r0 = com.baidu.sapi2.utils.enums.BindInfoAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidu$sapi2$utils$enums$BindInfoAction = r0
                com.baidu.sapi2.utils.enums.BindInfoAction r1 = com.baidu.sapi2.utils.enums.BindInfoAction.BIND_EMAIL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$baidu$sapi2$utils$enums$BindInfoAction     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.sapi2.utils.enums.BindInfoAction r1 = com.baidu.sapi2.utils.enums.BindInfoAction.BIND_MOBILE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.ParamsUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public static String addExtras(String str, Map<String, String> map) {
        return str + SapiUtils.mapToUrlParams(map, str.contains("?"));
    }

    public static HttpCookie buidCookie(String str, String str2, String str3) {
        HttpCookie httpCookie = new HttpCookie(str, str2);
        httpCookie.setDomain(str3);
        httpCookie.setPath("/");
        return httpCookie;
    }

    public static String buildH5CommonParams(SapiConfiguration sapiConfiguration) {
        return buildH5CommonParams(sapiConfiguration, true);
    }

    public static List<HttpCookie> buildLoginStatusCookie(String str, SapiConfiguration sapiConfiguration) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (str.contains(sapiConfiguration.environment.getURL())) {
            str2 = sapiConfiguration.environment.getUrlDomain();
        } else if (str.contains(sapiConfiguration.environment.getWap())) {
            str2 = sapiConfiguration.environment.getWapDomain();
        } else {
            if (str.contains("mbd.baidu.com")) {
                str2 = "https://mbd.baidu.com";
            }
            return arrayList;
        }
        arrayList.add(buidCookie("BDUSS", SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "BDUSS"), str2));
        arrayList.add(buidCookie("PTOKEN", SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "PTOKEN"), str2));
        arrayList.add(buidCookie("STOKEN", SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "STOKEN"), str2));
        return arrayList;
    }

    public static List<HttpCookie> buildNaCookie(String str, SapiConfiguration sapiConfiguration) {
        String str2;
        ArrayList arrayList = new ArrayList();
        if (str.contains(sapiConfiguration.environment.getURL())) {
            str2 = sapiConfiguration.environment.getUrlDomain();
        } else if (str.contains(sapiConfiguration.environment.getWap())) {
            str2 = sapiConfiguration.environment.getWapDomain();
        } else {
            if (str.contains("mbd.baidu.com")) {
                str2 = "https://mbd.baidu.com";
            }
            return arrayList;
        }
        arrayList.add(buidCookie("cuid", SapiUtils.getClientId(sapiConfiguration.context), str2));
        String deviceInfo = SapiContext.getInstance().getDeviceInfo();
        if (deviceInfo == null) {
            deviceInfo = "";
        }
        arrayList.add(buidCookie("DVIF", deviceInfo, str2));
        arrayList.add(buidCookie("HISTORY", SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "HISTORY"), str2));
        arrayList.add(buidCookie("BAIDUID", SapiUtils.getCookie("https://baidu.com", "BAIDUID"), str2));
        return arrayList;
    }

    public static boolean checkDiUpload(JSONArray jSONArray, int i2) {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            String optString = jSONArray.optString(i3);
            if (!TextUtils.isEmpty(optString) && optString.equals(String.valueOf(i2))) {
                Log.e("privacy_parameter_control", "di is not upload , index = " + i2);
                return false;
            }
        }
        return true;
    }

    public static String getAdapterParamValue(boolean z, boolean z2) {
        return z ? "3" : z2 ? "8" : "";
    }

    public static String getBindInfoType(BindInfoAction bindInfoAction) {
        return (bindInfoAction != null && AnonymousClass1.$SwitchMap$com$baidu$sapi2$utils$enums$BindInfoAction[bindInfoAction.ordinal()] == 1) ? "&type=email" : "";
    }

    public static JSONArray getGrayControlParams() {
        JSONArray jSONArray = new JSONArray();
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        if (isAccountManager == null) {
            Log.e("privacy_parameter_control", "accountManager is null");
            return jSONArray;
        }
        SapiConfiguration confignation = isAccountManager.getConfignation();
        if (confignation == null) {
            Log.e("privacy_parameter_control", "confignation is null");
            return jSONArray;
        } else if (!confignation.mPrivacyParamesRegulation) {
            Log.e("privacy_parameter_control", "params is not be regulation");
            return jSONArray;
        } else {
            SapiOptions.Gray gray = SapiContext.getInstance().getSapiOptions().gray;
            if (gray == null) {
                Log.e("privacy_parameter_control", "gray is null");
                return jSONArray;
            }
            SapiOptions.Gray.GrayModule grayModuleByFunName = gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_MAPPING);
            if (grayModuleByFunName == null) {
                Log.e("privacy_parameter_control", "grayModule is null");
                return jSONArray;
            } else if (!grayModuleByFunName.isMeetGray()) {
                Log.e("privacy_parameter_control", "meetGray is false");
                return jSONArray;
            } else {
                String extraParams = grayModuleByFunName.getExtraParams();
                if (extraParams == null) {
                    Log.e("privacy_parameter_control", "extraParams is null");
                    return jSONArray;
                }
                Log.e("privacy_parameter_control", "extraParams : " + extraParams);
                try {
                    jSONArray = new JSONObject(extraParams).optJSONArray("dt_params");
                    Log.e("privacy_parameter_control", "paramsList : " + jSONArray);
                    return jSONArray;
                } catch (JSONException e) {
                    Log.e("privacy_parameter_control", "exception : " + e);
                    e.printStackTrace();
                    return jSONArray;
                }
            }
        }
    }

    public static String getUrlBind(SapiConfiguration sapiConfiguration, SocialType socialType, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("display", SapiAccountService.DISPLAY_TYPE_NATIVE);
        hashMap.put("type", socialType.getType() + "");
        hashMap.put("act", sapiConfiguration.socialBindType.getName());
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("appid", str3);
        }
        hashMap.put("access_token", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("osuid", str2);
        }
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlBindHonor(SapiConfiguration sapiConfiguration, SocialType socialType, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("display", SapiAccountService.DISPLAY_TYPE_NATIVE);
        hashMap.put("type", socialType.getType() + "");
        hashMap.put("act", sapiConfiguration.socialBindType.getName());
        hashMap.put(SapiUtils.KEY_QR_LOGIN_REDIRECT_URI, str3);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("appid", str2);
        }
        hashMap.put("code", str);
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlCFOLogin(SapiConfiguration sapiConfiguration, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", SocialType.CFO.getType() + "");
        hashMap.put("appid", sapiConfiguration.cfoAppKey);
        hashMap.put("code", str);
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlDingdingLogin(SapiConfiguration sapiConfiguration, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", SocialType.DINGDING.getType() + "");
        hashMap.put("appid", sapiConfiguration.dingdingAppID);
        hashMap.put("appSecret", sapiConfiguration.dingdingAppSecret);
        hashMap.put("redirectUri", sapiConfiguration.dingdingRedirectUri);
        hashMap.put("code", str);
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlOppoLogin(SapiConfiguration sapiConfiguration, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", SocialType.OPPO.getType() + "");
        hashMap.put("appid", sapiConfiguration.oppoAppId);
        hashMap.put(a.r, sapiConfiguration.oppoAppkey);
        hashMap.put("appSecret", sapiConfiguration.oppoAppSecret);
        hashMap.put("code", str);
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlQQBind(SapiConfiguration sapiConfiguration, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", SocialType.QQ_SSO.getType() + "");
        hashMap.put("appid", sapiConfiguration.qqAppID);
        hashMap.put("access_token", str);
        if (sapiConfiguration.supportGuestAccountLogin) {
            hashMap.put("supportGuestAccount", "1");
        }
        hashMap.put("osuid", str2);
        hashMap.put("unionid", str3);
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlTwitterLogin(SapiConfiguration sapiConfiguration) {
        String str = sapiConfiguration.environment.getURL() + SapiEnv.SOCIAL_START_URI;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(SocialType.TWITTER.getType()));
        hashMap.put("tpl", sapiConfiguration.tpl);
        hashMap.put("adapter", "3");
        if (sapiConfiguration.showBottomBack) {
            hashMap.put("adapter", "8");
        } else {
            hashMap.put("adapter", "3");
        }
        hashMap.put("display", SapiAccountService.DISPLAY_TYPE_NATIVE);
        hashMap.put("act", "optional");
        hashMap.put("supportGuestAccount", "1");
        hashMap.put(b.h, sapiConfiguration.twitterAppKey);
        hashMap.put("client", SapiDeviceInfo.OS_TYPE);
        hashMap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
        return str + SapiUtils.mapToUrlParams(hashMap, false);
    }

    public static String getUrlVivoLogin(SapiConfiguration sapiConfiguration, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", SocialType.VIVO.getType() + "");
        hashMap.put("appid", sapiConfiguration.vivoAppId);
        hashMap.put("reditUrl", sapiConfiguration.vivoReditUrl);
        hashMap.put("code", str);
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlWeixinBind(SapiConfiguration sapiConfiguration, String str, String str2, boolean z, String str3, boolean z2) {
        if (sapiConfiguration == null) {
            return "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", SocialType.WEIXIN.getType() + "");
        hashMap.put("mkey", str2);
        hashMap.put("code", str);
        String str4 = "1";
        if (sapiConfiguration.supportGuestAccountLogin) {
            hashMap.put("supportGuestAccount", str4);
        }
        if (z2) {
            hashMap.put("wapsec", "center");
            hashMap.put("adapter", "3");
        }
        hashMap.put("appid", sapiConfiguration.wxAppID);
        if (!z) {
            str4 = "0";
        }
        hashMap.put("needBpPush", str4);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("pushBpFrom", str3);
        }
        hashMap.put("display", SapiAccountService.DISPLAY_TYPE_NATIVE);
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlYYLogin(String str, SapiConfiguration sapiConfiguration) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", SocialType.YY.getType() + "");
        hashMap.put("appid", sapiConfiguration.yyAppId);
        hashMap.put("access_token", str);
        if (sapiConfiguration.supportGuestAccountLogin) {
            hashMap.put("supportGuestAccount", "1");
        }
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin" + "?" + buildH5CommonParams(sapiConfiguration) + a.n + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String buildH5CommonParams(SapiConfiguration sapiConfiguration, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientfrom", SapiAccountService.DISPLAY_TYPE_NATIVE);
        hashMap.put("tpl", sapiConfiguration.tpl);
        hashMap.put("login_share_strategy", sapiConfiguration.loginShareStrategy().getStrValue());
        hashMap.put("client", SapiDeviceInfo.OS_TYPE);
        if (z) {
            hashMap.put("adapter", sapiConfiguration.customActionBarEnabled ? "3" : "");
        } else if (sapiConfiguration.showBottomBack) {
            hashMap.put("adapter", "8");
        }
        hashMap.put(t.a, String.valueOf(System.currentTimeMillis()));
        hashMap.put("act", sapiConfiguration.socialBindType.getName());
        hashMap.put("hideExtraEntry", String.valueOf(sapiConfiguration.smsLoginConfig.flagHideExtraEntry.ordinal()));
        hashMap.put("loginLink", String.valueOf(sapiConfiguration.smsLoginConfig.flagShowLoginLink.ordinal()));
        hashMap.put("smsLoginLink", String.valueOf(sapiConfiguration.smsLoginConfig.flagShowSmsLoginLink.ordinal()));
        hashMap.put("lPFastRegLink", String.valueOf(sapiConfiguration.smsLoginConfig.flagShowFastRegLink.ordinal()));
        hashMap.put("lPlayout", String.valueOf(sapiConfiguration.configurableViewLayout.ordinal()));
        if (sapiConfiguration.uniteVerify) {
            hashMap.put("connect", "1");
        }
        if (sapiConfiguration.language == Language.ENGLISH) {
            hashMap.put("lang", "en");
        }
        hashMap.put("suppcheck", "1");
        if (sapiConfiguration.supportFaceLogin) {
            hashMap.put("scanface", "1");
            hashMap.put("liveAbility", "1");
        }
        if (sapiConfiguration.disableVoiceVerify) {
            hashMap.put("disable_voice_vcode", "1");
        }
        return SapiUtils.mapToUrlParams(hashMap, true);
    }
}
