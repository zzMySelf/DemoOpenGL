package com.baidu.sapi2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.UbcUploadImplCallback;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PassCoreVHelper;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.sapi2.utils.enums.UIOrientation;
import com.baidu.sofire.ac.FH;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class SapiConfiguration implements NoProguard {
    public static final int BACKUP_LOGIN = 10;
    public static final int BROWSE_MODE_STATE_ONLY = 2;
    public static final int BROWSE_MODE_STATE_USER_AUTHORIZED = 1;
    public static final int BROWSE_MODE_STATE_USER_UNSELECTED = 0;
    public static final int JOIN_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CHINA_MOBILE_OAUTH = 5;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FACE_LOGIN = 4;
    @Deprecated
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_NAME_PHONE_EMAIL_LOGIN = 6;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_PRE_NAME_PHONE_LOGIN = 7;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;
    public final boolean accountCenterRealAutnen;
    public int activityExitAnimId;
    public int activityOpenAnimId;
    public boolean agreeDangerousProtocol;
    public final String appId;
    public final String appSignKey;
    public final String bdOauthAppId;
    public int browseModeState;
    public final String cfoAppKey;
    public final boolean cfoOpenDebugMode;
    public String clientId;
    public String clientIp;
    public final Switch configurableViewLayout;
    public final Context context;
    public boolean customActionBarEnabled;
    public final Context deApplicationContext;
    public final boolean debug;
    public String deviceName;
    public final String dingdingAppID;
    public final String dingdingAppSecret;
    public final String dingdingRedirectUri;
    public boolean disableVoiceVerify;
    public final boolean enableShare;
    public final Domain environment;
    public final String faceLincenseFile;
    public final String faceLincenseID;
    public Map<String, String> faceResPaths;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public boolean forbidPresetPhoneNumber;
    public final boolean forbidSslErrorDialog;
    public String googleClientId;
    public final String honorAppID;
    public final String honorRedirectUri;
    public final LoginShareStrategy initialShareStrategy;
    public boolean isDarkMode;
    public boolean isDebugForbidUploadContact;
    public boolean isHideLoginHelpEntrance;
    public final boolean isNewLogin;
    public boolean isNightMode;
    public boolean isShowBottomBackText;
    public boolean isSupportDebugShareLogin;
    public boolean isUIModeFollowSystem;
    public final Language language;
    public CallbackFaceOptionListerer mCallbackFaceOpt;
    public CallbackCustomProtocol mCallbackProtocol;
    public CallbackCustomProtocolClickListener mCallbackProtocolListener;
    public CallbackTextSizeListener mCallbackTextSizeListener;
    public UIOrientation mOrientation;
    public boolean mPrivacyParamesRegulation;
    public String mTPLAppName;
    public String mTPLCuid;
    public final String meizuRedirectUri;
    public final String mzAppID;
    public String oppoAppId;
    public String oppoAppSecret;
    public String oppoAppkey;
    public String presetPhoneNumber;
    public final String processName;
    public final String qqAppID;
    public final String realnameAuthenticateStoken;
    public boolean showBottomBack;
    public boolean showCloseBtn;
    public final String sinaAppId;
    public final String sinaRedirectUri;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public boolean supportBrowseMode;
    public boolean supportCheckFloatfLayer;
    public boolean supportFaceLogin;
    public boolean supportGestureSlide;
    public boolean supportGuestAccountLogin;
    public boolean supportMultipleAccounts;
    public boolean supportNetwork;
    public final boolean supportPhoto;
    public boolean supportTouchLogin;
    public boolean syncOneKeyLoginInfo;
    public int textZoom;
    public final String tpl;
    public String twitterAppKey;
    public UbcUploadImplCallback ubcUploadImplCallback;
    public final boolean uniteVerify;
    public final String userAgent;
    public String vivoAppId;
    public String vivoReditUrl;
    public final String wxAppID;
    public final Long xiaomiAppID;
    public final String xiaomiRedirectUri;
    public String yyAppId;

    public interface CallbackCustomProtocol extends NoProguard {
        String callbackCustomProtocol();
    }

    public interface CallbackCustomProtocolClickListener extends NoProguard {
        void callbackProtocolListener(String str);
    }

    public interface CallbackFaceOptionListerer extends NoProguard {
        int callbackFaceCompressValue();
    }

    public interface CallbackTextSizeListener extends NoProguard {
        int callbackTextSize();
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppSignKey() {
        return this.appSignKey;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public Switch getConfigurableViewLayout() {
        return this.configurableViewLayout;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean getCustomActionBarEnabled() {
        return this.customActionBarEnabled;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public Domain getEnvironment() {
        return this.environment;
    }

    public List<FastLoginFeature> getFastLoginFeatureList() {
        return this.fastLoginFeatureList;
    }

    public boolean getForbidSslErrorDialog() {
        return this.forbidSslErrorDialog;
    }

    public String getHonorAppID() {
        return this.honorAppID;
    }

    public Language getLanguage() {
        return this.language;
    }

    public String getMeizuRedirectUri() {
        return this.meizuRedirectUri;
    }

    public String getMzAppID() {
        return this.mzAppID;
    }

    public String getPresetPhoneNumber() {
        return this.presetPhoneNumber;
    }

    public String getQqAppID() {
        return this.qqAppID;
    }

    public String getRealnameAuthenticateStoken() {
        return this.realnameAuthenticateStoken;
    }

    public String getSkin() {
        return this.skin;
    }

    public BindType getSocialBindType() {
        return this.socialBindType;
    }

    public int getTextZoom() {
        CallbackTextSizeListener callbackTextSizeListener = this.mCallbackTextSizeListener;
        if (callbackTextSizeListener == null) {
            return this.textZoom;
        }
        return callbackTextSizeListener.callbackTextSize();
    }

    public String getTpl() {
        return this.tpl;
    }

    public UIOrientation getUIOrientation() {
        return this.mOrientation;
    }

    public boolean getUniteVerify() {
        return this.uniteVerify;
    }

    public String getWxAppID() {
        return this.wxAppID;
    }

    public boolean isAgreeDangerousProtocol() {
        return this.agreeDangerousProtocol;
    }

    public boolean isShowBottomBackText() {
        return this.isShowBottomBackText;
    }

    public boolean isSupportBrowseMode() {
        return this.supportBrowseMode && this.browseModeState != 0;
    }

    public boolean isSupportTouchLogin() {
        if (this.supportTouchLogin && SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName("finger").meetGray) {
            return true;
        }
        return false;
    }

    public boolean isValidateSpCommit() {
        return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_VALIDATE_SP_COMMIT).meetGray;
    }

    public LoginShareStrategy loginShareStrategy() {
        SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
        LoginShareStrategy loginShareStrategy = sapiOptions.getSpecificShareStrategy().get(this.tpl);
        if (loginShareStrategy != null) {
            Log.d(ShareUtils.TAG, "loginShareStrategy shareStrategy is " + loginShareStrategy.getStrValue());
            return loginShareStrategy;
        }
        LoginShareStrategy globalShareStrategy = sapiOptions.getGlobalShareStrategy();
        if (globalShareStrategy == null) {
            return this.initialShareStrategy;
        }
        Log.d(ShareUtils.TAG, "loginShareStrategy getGlobalShareStrategy is " + globalShareStrategy.getStrValue());
        return globalShareStrategy;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        this.agreeDangerousProtocol = z;
        try {
            FH.setAgreePolicy(this.context, z);
        } catch (Exception e) {
            Log.e(e);
        }
    }

    public void setSupportFaceLogin(boolean z) {
        this.supportFaceLogin = z;
    }

    public void setSupportTouchLogin(boolean z) {
        this.supportTouchLogin = z;
    }

    public static class Builder implements NoProguard {
        public boolean accountCenterRealNameAuthen = true;
        public int activityExitAnimId = 0;
        public int activityOpenAnimId = 0;
        public boolean agreeDangerousProtocol = true;
        public String appId;
        public String appSignKey;
        public String bdOauthAppId;
        public int browseModeState = 1;
        public String cfoAppKey;
        public boolean cfoOpenDebugMode;
        public Switch configurableViewLayout = Switch.OFF;
        public Context context;
        public boolean customActionBarEnabled = false;
        public Context deApplicationContext;
        public boolean debug = false;
        public String deviceName;
        public String dingdingAppID;
        public String dingdingAppSecret;
        public String dingdingRedirectUri;
        public boolean disableVoiceVerify = true;
        public boolean enableShare = true;
        public Domain environment;
        public String faceLincenseFile;
        public String faceLincenseID;
        public Map<String, String> faceResPaths;
        public List<FastLoginFeature> fastLoginFeatureList;
        public boolean forbidPresetPhoneNumber;
        public boolean forbidSslErrorDialog = false;
        public String googleClientId;
        public String honorAppID;
        public String honorRedirectUri;
        public LoginShareStrategy initialShareStrategy;
        public boolean isDarkMode = false;
        public boolean isDebugForbidUploadContact;
        public boolean isHideLoginHelpEntrance = false;
        public boolean isNewLogin = true;
        public boolean isNightMode = false;
        public boolean isShowBottomBackText = false;
        public boolean isSupportDebugShareLogin;
        public boolean isUIModeFollowSystem;
        public Language language;
        public CallbackFaceOptionListerer mCallbackFaceOpt;
        public CallbackCustomProtocol mCallbackProtocol;
        public CallbackCustomProtocolClickListener mCallbackProtocolListener;
        public CallbackTextSizeListener mCallbackTextSizeListener;
        public UIOrientation mOrientation = UIOrientation.SCREEN_ORIENTATION_PORTRAIT;
        public boolean mPrivacyParamesRegulation;
        public String mTPLAppName;
        public String mTPLCuid;
        public String meizuRedirectUri;
        public String mzAppID;
        public String oppoAppId;
        public String oppoAppSecret;
        public String oppoAppkey;
        public String presetPhoneNumber;
        public String processName;
        public String qqAppID;
        public String realnameAuthenticateStoken;
        public boolean showBottomBack = false;
        public boolean showCloseBtn = false;
        public boolean showRegLink = true;
        public String sinaAppID;
        public String sinaRedirectUri;
        public String skin;
        public SmsLoginConfig smsLoginConfig;
        public BindType socialBindType;
        public String sofireAppKey;
        public int sofireHostID = 1;
        public String sofireSecKey;
        public boolean supNewVerSapiLogin = false;
        public boolean supportBrowseMode;
        public boolean supportCheckFloatfLayer;
        public boolean supportFaceLogin = true;
        public boolean supportGestureSlide = true;
        public boolean supportMultipleAccounts = true;
        public boolean supportPhoto = true;
        public boolean supportTouchLogin = true;
        public boolean syncOneKeyLoginInfo = true;
        public int textZoom = 100;
        public String tpl;
        public String twitterAppKey;
        public UbcUploadImplCallback ubcUploadImplCallback;
        public boolean uniteVerify = false;
        public String userAgent;
        public String vivoAppId;
        public String vivoReditUrl;
        public String wxAppID;
        public Long xiaomiAppID;
        public String xiaomiRedirectUri;
        public String yyAppId;

        public Builder(Context context2) {
            this.context = context2.getApplicationContext();
        }

        public Builder bdOauthAppId(String str) {
            this.bdOauthAppId = str;
            return this;
        }

        public SapiConfiguration build() {
            if (TextUtils.isEmpty(this.tpl) || TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appSignKey)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            if (this.environment == null) {
                this.environment = Domain.DOMAIN_ONLINE;
            }
            if (this.language == null) {
                this.language = Language.CHINESE;
            }
            if (this.socialBindType == null) {
                this.socialBindType = BindType.BIND_MOBILE;
            }
            if (this.initialShareStrategy == null) {
                this.initialShareStrategy = LoginShareStrategy.getDefault();
            }
            if (this.fastLoginFeatureList == null) {
                this.fastLoginFeatureList = new ArrayList();
            }
            if (this.smsLoginConfig == null) {
                Switch switchR = Switch.OFF;
                this.smsLoginConfig = new SmsLoginConfig(switchR, switchR, switchR);
            }
            if (this.configurableViewLayout == null) {
                this.configurableViewLayout = Switch.OFF;
            }
            if (this.showBottomBack) {
                this.customActionBarEnabled = true;
            }
            if (TextUtils.isEmpty(this.sofireAppKey)) {
                try {
                    this.sofireAppKey = PassCoreVHelper.getSofireAppKey();
                } catch (Exception e) {
                    Log.e(e.getMessage(), new Object[0]);
                } catch (Throwable th2) {
                    Log.e(th2.getMessage(), new Object[0]);
                }
            }
            if (TextUtils.isEmpty(this.sofireSecKey)) {
                try {
                    this.sofireSecKey = PassCoreVHelper.getSofireSecKey();
                } catch (Exception e2) {
                    Log.e(e2.getMessage(), new Object[0]);
                } catch (Throwable th3) {
                    Log.e(th3.getMessage(), new Object[0]);
                }
            }
            Log.enable(this.debug);
            return new SapiConfiguration(this);
        }

        public Builder cfoAppID(String str, boolean z) {
            this.cfoAppKey = str;
            this.cfoOpenDebugMode = z;
            return this;
        }

        public Builder configurableViewLayout(Switch switchR) {
            this.configurableViewLayout = switchR;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.customActionBarEnabled = z;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.userAgent = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder dingdingAuthInfo(String str, String str2, String str3) {
            this.dingdingAppID = str;
            this.dingdingAppSecret = str3;
            this.dingdingRedirectUri = str3;
            return this;
        }

        public Builder enableShare(boolean z) {
            this.enableShare = z;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            ArrayList arrayList = new ArrayList();
            this.fastLoginFeatureList = arrayList;
            if (fastLoginFeatureArr == null) {
                return this;
            }
            Collections.addAll(arrayList, fastLoginFeatureArr);
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            this.forbidPresetPhoneNumber = z;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            this.forbidSslErrorDialog = z;
            return this;
        }

        public Builder googleOauthConfig(String str) {
            this.googleClientId = str;
            return this;
        }

        public Builder honorAppID(String str, String str2) {
            this.honorAppID = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "honorid://redirect_url";
            }
            this.honorRedirectUri = str2;
            return this;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.initialShareStrategy = loginShareStrategy;
            return this;
        }

        public Builder isHideLoginHelpEntrance(boolean z) {
            this.isHideLoginHelpEntrance = z;
            return this;
        }

        public Builder isNewLogin(boolean z) {
            this.isNewLogin = z;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.mzAppID = str;
            this.meizuRedirectUri = str2;
            return this;
        }

        public Builder oppoAuthInfo(String str, String str2, String str3) {
            this.oppoAppId = str;
            this.oppoAppkey = str2;
            this.oppoAppSecret = str3;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.presetPhoneNumber = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.qqAppID = str;
            return this;
        }

        public Builder realnameAuthenticateStoken(String str) {
            this.realnameAuthenticateStoken = str;
            return this;
        }

        public Builder setActivityAnim(int i2, int i3) {
            this.activityOpenAnimId = i2;
            this.activityExitAnimId = i3;
            return this;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            this.agreeDangerousProtocol = z;
            try {
                FH.setAgreePolicy(this.context, z);
            } catch (Exception e) {
                Log.e(e);
            }
            return this;
        }

        public Builder setBrowseModeState(int i2) {
            this.browseModeState = i2;
            return this;
        }

        public Builder setCustomProtocol(CallbackCustomProtocol callbackCustomProtocol) {
            this.mCallbackProtocol = callbackCustomProtocol;
            return this;
        }

        public Builder setCustomProtocolClickListener(CallbackCustomProtocolClickListener callbackCustomProtocolClickListener) {
            this.mCallbackProtocolListener = callbackCustomProtocolClickListener;
            return this;
        }

        public Builder setDarkMode(boolean z) {
            this.isDarkMode = z;
            return this;
        }

        public Builder setDebugForbidUploadContact(boolean z) {
            this.isDebugForbidUploadContact = z;
            return this;
        }

        public Builder setDebugSupportShareLogin(boolean z) {
            this.isSupportDebugShareLogin = z;
            return this;
        }

        public Builder setDeviceName(String str) {
            this.deviceName = str;
            return this;
        }

        public Builder setDisableVoiceVerify(boolean z) {
            this.disableVoiceVerify = z;
            return this;
        }

        public Builder setFaceLincense(String str, String str2) {
            this.faceLincenseID = str;
            this.faceLincenseFile = str2;
            return this;
        }

        public Builder setFaceOptionListerer(CallbackFaceOptionListerer callbackFaceOptionListerer) {
            this.mCallbackFaceOpt = callbackFaceOptionListerer;
            return this;
        }

        public Builder setFaceResPaths(Map<String, String> map) {
            this.faceResPaths = map;
            return this;
        }

        public Builder setLanguage(Language language2) {
            this.language = language2;
            return this;
        }

        public Builder setLowerUpdateFreq(boolean z) {
            return this;
        }

        public Builder setNightMode(boolean z) {
            this.isNightMode = z;
            return this;
        }

        public Builder setPrivacyParamesConfig(String str, boolean z) {
            if (!z || !TextUtils.isEmpty(str)) {
                this.mTPLAppName = str;
                this.mPrivacyParamesRegulation = z;
                return this;
            }
            throw new IllegalArgumentException("privacyParamesRegulation is true , so tAppname and tCuid can not be empty");
        }

        public Builder setProcessName(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            boolean z = false;
            Iterator<String> it = SapiOptions.getInitialProcessNameWhiteList().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.matches(it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                this.processName = str;
            }
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.tpl = str;
            this.appId = str2;
            this.appSignKey = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(Domain domain) {
            this.environment = domain;
            return this;
        }

        public Builder setShowBottomBackText(boolean z) {
            this.isShowBottomBackText = z;
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.showCloseBtn = z;
            return this;
        }

        public Builder setSocialBindType(BindType bindType) {
            this.socialBindType = bindType;
            return this;
        }

        public Builder setSupNewVerSapiLogin(boolean z) {
            this.supNewVerSapiLogin = z;
            return this;
        }

        public Builder setSupportBrowseMode(boolean z) {
            this.supportBrowseMode = z;
            return this;
        }

        public Builder setSupportCheckFloatfLayer(boolean z) {
            this.supportCheckFloatfLayer = z;
            return this;
        }

        public Builder setSupportFaceLogin(boolean z) {
            this.supportFaceLogin = z;
            return this;
        }

        public Builder setSupportGestureSlide(boolean z) {
            this.supportGestureSlide = z;
            return this;
        }

        public Builder setSupportMultipleAccounts(boolean z) {
            this.supportMultipleAccounts = z;
            return this;
        }

        public Builder setSupportPhoto(boolean z) {
            this.supportPhoto = z;
            return this;
        }

        public Builder setSupportTouchLogin(boolean z) {
            this.supportTouchLogin = z;
            return this;
        }

        public Builder setTextSizeZoomListener(CallbackTextSizeListener callbackTextSizeListener) {
            this.mCallbackTextSizeListener = callbackTextSizeListener;
            return this;
        }

        public Builder setTextZoom(int i2) {
            if (i2 > 0 && i2 < 200) {
                this.textZoom = i2;
            }
            return this;
        }

        public Builder setUIModeFollowSystem(boolean z) {
            this.isUIModeFollowSystem = z;
            return this;
        }

        public Builder setUIOrientation(UIOrientation uIOrientation) {
            this.mOrientation = uIOrientation;
            return this;
        }

        public Builder setUbcUploadImplCallback(UbcUploadImplCallback ubcUploadImplCallback2) {
            this.ubcUploadImplCallback = ubcUploadImplCallback2;
            return this;
        }

        public Builder showBottomBack(boolean z) {
            this.showBottomBack = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.showRegLink = z;
            return this;
        }

        public Builder sinaAppID(String str, String str2) {
            this.sinaAppID = str;
            this.sinaRedirectUri = str2;
            return this;
        }

        public Builder skin(String str) {
            this.skin = str;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig2) {
            this.smsLoginConfig = smsLoginConfig2;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i2) {
            this.sofireAppKey = str;
            this.sofireSecKey = str2;
            this.sofireHostID = i2;
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.accountCenterRealNameAuthen = z;
            return this;
        }

        public Builder syncOneKeyLoginInfo(boolean z) {
            this.syncOneKeyLoginInfo = z;
            return this;
        }

        public Builder twitterOauthConfig(String str) {
            this.twitterAppKey = str;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.uniteVerify = z;
            return this;
        }

        public Builder vivoAuthInfo(String str, String str2) {
            this.vivoAppId = str;
            this.vivoReditUrl = str2;
            return this;
        }

        public Builder wxAppID(String str) {
            this.wxAppID = str;
            return this;
        }

        public Builder xiaoAppID(Long l, String str) {
            this.xiaomiAppID = l;
            this.xiaomiRedirectUri = str;
            return this;
        }

        public Builder yyOauthConfig(String str) {
            this.yyAppId = str;
            return this;
        }

        public Builder sinaAppID(String str) {
            return sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true));
        }

        public Builder setPrivacyParamesConfig(String str, String str2, boolean z) {
            if (!z || !TextUtils.isEmpty(str)) {
                this.mTPLAppName = str;
                this.mTPLCuid = str2;
                this.mPrivacyParamesRegulation = z;
                return this;
            }
            throw new IllegalArgumentException("privacyParamesRegulation is true , so tAppname and tCuid can not be empty");
        }

        public Builder(Context context2, Boolean bool) {
            if (!bool.booleanValue() || Build.VERSION.SDK_INT < 24 || context2.isDeviceProtectedStorage()) {
                this.context = context2.getApplicationContext();
                return;
            }
            this.context = context2.createDeviceProtectedStorageContext();
            this.deApplicationContext = context2.getApplicationContext();
        }
    }

    public SapiConfiguration(Builder builder) {
        this.supportNetwork = true;
        this.context = builder.context;
        this.deApplicationContext = builder.deApplicationContext;
        this.tpl = builder.tpl;
        this.appId = builder.appId;
        this.appSignKey = builder.appSignKey;
        this.environment = builder.environment;
        this.faceLincenseID = builder.faceLincenseID;
        this.faceLincenseFile = builder.faceLincenseFile;
        this.language = builder.language;
        this.socialBindType = builder.socialBindType;
        this.initialShareStrategy = builder.initialShareStrategy;
        this.fastLoginFeatureList = builder.fastLoginFeatureList;
        this.wxAppID = builder.wxAppID;
        this.qqAppID = builder.qqAppID;
        this.mzAppID = builder.mzAppID;
        this.sinaAppId = builder.sinaAppID;
        this.bdOauthAppId = builder.bdOauthAppId;
        this.meizuRedirectUri = builder.meizuRedirectUri;
        this.sinaRedirectUri = builder.sinaRedirectUri;
        this.xiaomiAppID = builder.xiaomiAppID;
        this.honorAppID = builder.honorAppID;
        this.honorRedirectUri = builder.honorRedirectUri;
        this.xiaomiRedirectUri = builder.xiaomiRedirectUri;
        this.cfoAppKey = builder.cfoAppKey;
        this.cfoOpenDebugMode = builder.cfoOpenDebugMode;
        this.dingdingAppID = builder.dingdingAppID;
        this.dingdingAppSecret = builder.dingdingAppSecret;
        this.dingdingRedirectUri = builder.dingdingRedirectUri;
        this.oppoAppId = builder.oppoAppId;
        this.oppoAppkey = builder.oppoAppkey;
        this.oppoAppSecret = builder.oppoAppSecret;
        this.vivoAppId = builder.vivoAppId;
        this.vivoReditUrl = builder.vivoReditUrl;
        this.twitterAppKey = builder.twitterAppKey;
        this.googleClientId = builder.googleClientId;
        this.yyAppId = builder.yyAppId;
        this.agreeDangerousProtocol = builder.agreeDangerousProtocol;
        this.sofireAppKey = builder.sofireAppKey;
        this.sofireSecKey = builder.sofireSecKey;
        this.sofireHostID = builder.sofireHostID;
        this.realnameAuthenticateStoken = builder.realnameAuthenticateStoken;
        this.skin = builder.skin;
        this.presetPhoneNumber = builder.presetPhoneNumber;
        this.forbidPresetPhoneNumber = builder.forbidPresetPhoneNumber;
        this.customActionBarEnabled = builder.customActionBarEnabled;
        this.showBottomBack = builder.showBottomBack;
        this.configurableViewLayout = builder.configurableViewLayout;
        this.debug = builder.debug;
        this.smsLoginConfig = builder.smsLoginConfig;
        this.uniteVerify = builder.uniteVerify;
        this.accountCenterRealAutnen = builder.accountCenterRealNameAuthen;
        this.forbidSslErrorDialog = builder.forbidSslErrorDialog;
        this.enableShare = builder.enableShare;
        this.supportPhoto = builder.supportPhoto;
        this.processName = builder.processName;
        this.isNightMode = builder.isNightMode;
        this.isUIModeFollowSystem = builder.isUIModeFollowSystem;
        this.isDarkMode = builder.isDarkMode;
        this.isNewLogin = builder.isNewLogin;
        this.showCloseBtn = builder.showCloseBtn;
        this.userAgent = builder.userAgent;
        this.activityOpenAnimId = builder.activityOpenAnimId;
        this.activityExitAnimId = builder.activityExitAnimId;
        this.disableVoiceVerify = builder.disableVoiceVerify;
        this.supportFaceLogin = builder.supportFaceLogin;
        this.supportTouchLogin = builder.supportTouchLogin;
        this.supportGestureSlide = builder.supportGestureSlide;
        this.syncOneKeyLoginInfo = builder.syncOneKeyLoginInfo;
        this.supportMultipleAccounts = builder.supportMultipleAccounts;
        this.supportCheckFloatfLayer = builder.supportCheckFloatfLayer;
        this.textZoom = builder.textZoom;
        this.isShowBottomBackText = builder.isShowBottomBackText;
        this.deviceName = builder.deviceName;
        this.isHideLoginHelpEntrance = builder.isHideLoginHelpEntrance;
        this.browseModeState = builder.browseModeState;
        this.supportBrowseMode = builder.supportBrowseMode;
        this.isSupportDebugShareLogin = builder.isSupportDebugShareLogin;
        this.isDebugForbidUploadContact = builder.isDebugForbidUploadContact;
        this.ubcUploadImplCallback = builder.ubcUploadImplCallback;
        this.mPrivacyParamesRegulation = builder.mPrivacyParamesRegulation;
        this.mTPLAppName = builder.mTPLAppName;
        this.mTPLCuid = builder.mTPLCuid;
        this.faceResPaths = builder.faceResPaths;
        this.mCallbackTextSizeListener = builder.mCallbackTextSizeListener;
        this.mCallbackFaceOpt = builder.mCallbackFaceOpt;
        this.mOrientation = builder.mOrientation;
        this.mCallbackProtocol = builder.mCallbackProtocol;
        this.mCallbackProtocolListener = builder.mCallbackProtocolListener;
    }

    public static class SmsLoginConfig implements NoProguard {
        public Switch flagHideExtraEntry;
        public Switch flagLoginBtnType;
        public Switch flagShowFastRegLink;
        public Switch flagShowLoginLink;
        public Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch switchR, Switch switchR2, @Deprecated Switch switchR3) {
            switchR = switchR == null ? Switch.OFF : switchR;
            switchR2 = switchR2 == null ? Switch.OFF : switchR2;
            switchR3 = switchR3 == null ? Switch.OFF : switchR3;
            this.flagShowLoginLink = switchR;
            this.flagShowSmsLoginLink = switchR2;
            this.flagLoginBtnType = switchR3;
            Switch switchR4 = Switch.OFF;
            this.flagShowFastRegLink = switchR4;
            this.flagHideExtraEntry = switchR4;
        }

        public SmsLoginConfig(Switch switchR, Switch switchR2, Switch switchR3, @Deprecated Switch switchR4, Switch switchR5) {
            switchR = switchR == null ? Switch.OFF : switchR;
            switchR2 = switchR2 == null ? Switch.OFF : switchR2;
            switchR3 = switchR3 == null ? Switch.OFF : switchR3;
            switchR4 = switchR4 == null ? Switch.OFF : switchR4;
            switchR5 = switchR5 == null ? Switch.OFF : switchR5;
            this.flagHideExtraEntry = switchR;
            this.flagShowLoginLink = switchR2;
            this.flagShowSmsLoginLink = switchR3;
            this.flagLoginBtnType = switchR4;
            this.flagShowFastRegLink = switchR5;
        }
    }
}
