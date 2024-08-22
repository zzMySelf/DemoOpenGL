package com.baidu.sapi2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.netdisk.network.Constants;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.DynamicPwdWithAuthCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetCertStatusCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserAttrInfoCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.IsShowRealNameCallback;
import com.baidu.sapi2.callback.LoginWithUCAuthCallback;
import com.baidu.sapi2.callback.NetCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.UserLogoutCallback;
import com.baidu.sapi2.callback.ValidateWithHaoKanCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.GetOnlineAppCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback;
import com.baidu.sapi2.contacts.callback.GetContactsCallback;
import com.baidu.sapi2.contacts.dto.GetContactsDTO;
import com.baidu.sapi2.contacts.dto.SendSmsDTO;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.GetQrCodeImageDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
import com.baidu.sapi2.dto.Web2NativeLoginDTO;
import com.baidu.sapi2.enums.PortraitCategory;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.LocalRefreshTokenResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.share.GetOnlineRequestShareModel;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.voicesearch.component.vglog.VgLogConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class SapiAccountService implements ISAccountService {
    public static final String BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    private static final String DISPLAY_TYPE_NATIVE = "native";
    private static final String TAG = SapiAccountService.class.getSimpleName();
    private SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    /* access modifiers changed from: private */
    public SapiAccountRepository sapiAccountRepository = new SapiAccountRepository();

    SapiAccountService() {
    }

    /* access modifiers changed from: package-private */
    public String getWapShareLoginUrl() {
        return this.sapiAccountRepository.getWapShareLoginUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getAuthWidgetUrl(boolean isCashierSDK) {
        return this.sapiAccountRepository.getAuthWidgetUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getAuthRequestParams(isCashierSDK);
    }

    /* access modifiers changed from: package-private */
    public String getAuthWidgetUrl() {
        return this.sapiAccountRepository.getAuthWidgetUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getAuthRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getLoginUrl() {
        return this.sapiAccountRepository.getWapLoginUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getLoginBackUrl() {
        return this.sapiAccountRepository.getWapLoginBackUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getForgetPwdUrl() {
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("client", "android"));
        list.add(new PassNameValuePair("clientfrom", "native"));
        list.add(new PassNameValuePair("adapter", "3"));
        list.add(new PassNameValuePair("banner", "1"));
        list.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.sapiAccountRepository.getWapForgetPwdUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams(false) + "&" + SapiUtils.createRequestParams(list);
    }

    /* access modifiers changed from: package-private */
    public String getBindWidgetUrl(BindWidgetAction action) {
        if (action != null) {
            List<PassNameValuePair> list = new ArrayList<>();
            list.add(new PassNameValuePair("adapter", "3"));
            return this.sapiAccountRepository.getBindWidgetUrl(action) + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams() + "&" + SapiUtils.createRequestParams(list);
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    /* access modifiers changed from: package-private */
    public String getUniteVerifyUrl() {
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("adapter", "3"));
        return this.sapiAccountRepository.getUniteVerifyUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams() + "&" + SapiUtils.createRequestParams(list);
    }

    /* access modifiers changed from: package-private */
    public String getNormalizeGuestAccountUrl(SocialType type) {
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("type", type.getName()));
        list.add(new PassNameValuePair("ostype", String.valueOf(type.getType())));
        return this.sapiAccountRepository.getNormalizeGuestAccountUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams() + "&" + SapiUtils.createRequestParams(list);
    }

    /* access modifiers changed from: package-private */
    public String getAddressManageUrl() {
        return this.sapiAccountRepository.getContactAddressUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getCertGuardUrl() {
        return this.sapiAccountRepository.getCertGuardUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getChangeUsernameUrl() {
        return this.sapiAccountRepository.getChangeUsername() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getDoubleListUrl() {
        return this.sapiAccountRepository.getDoubleListUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getPersonalInfoUrl() {
        return this.sapiAccountRepository.getPersonalInfoUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getInvoiceBuildUrl() {
        return this.sapiAccountRepository.getInvoiceAddressUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams(true);
    }

    /* access modifiers changed from: package-private */
    public String getSwitchAccountUrl() {
        return this.sapiAccountRepository.getSwitchAccountUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    public String getExplainCameraDeatilUrl() {
        return this.sapiAccountRepository.getExplainCameraDeatilUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    public String getChildVerifyUrl() {
        return this.sapiAccountRepository.getChildVerifyUrl() + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams();
    }

    /* access modifiers changed from: package-private */
    public String getAccountCenterUrl(String refer) {
        String url;
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("adapter", "3"));
        list.add(new PassNameValuePair("wapsec", "center"));
        if (this.configuration.accountCenterRealAutnen) {
            list.add(new PassNameValuePair("realName", "1"));
        } else {
            list.add(new PassNameValuePair("realName", "0"));
        }
        if (SapiWebView.ACCOUNT_CENTER_REAL_NAME.equals(refer)) {
            url = this.sapiAccountRepository.getAccountRealNameUrl();
        } else if (SapiWebView.ACCOUNT_CENTER_CHECK.equals(refer)) {
            list.add(new PassNameValuePair("hidebtmback", "1"));
            list.add(new PassNameValuePair("slidePage", "1"));
            url = this.sapiAccountRepository.getAccountCenterCheckUrl();
        } else {
            url = this.sapiAccountRepository.getAcccountCenterUrl();
        }
        return url + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams(false) + "&" + SapiUtils.createRequestParams(list);
    }

    /* access modifiers changed from: package-private */
    public String getRealnameAuthenticateUrl() {
        SapiConfiguration configuration2 = SapiAccountManager.getInstance().getSapiConfiguration();
        String url = configuration2.environment.getWap() + "/wp/";
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("appid", configuration2.appId));
        SapiUtils.getClientId(configuration2.context);
        return url + GameCenterUtils.SCHEME_SWAN_SUFFIX + getRequestParams() + "&" + SapiUtils.createRequestParams(list);
    }

    public String getCancelRealNameUrl() {
        SapiConfiguration configuration2 = SapiAccountManager.getInstance().getSapiConfiguration();
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("tpl", configuration2.tpl));
        list.add(new PassNameValuePair("throughPage", "1"));
        list.add(new PassNameValuePair("adapter", "3"));
        return this.sapiAccountRepository.getCancelRealName() + GameCenterUtils.SCHEME_SWAN_SUFFIX + SapiUtils.createRequestParams(list);
    }

    /* access modifiers changed from: package-private */
    public String getRequestParams() {
        return getRequestParams(true);
    }

    /* access modifiers changed from: package-private */
    public String getAuthRequestParams(boolean isCashierSDK) {
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("clientfrom", "native"));
        if (isCashierSDK) {
            list.add(new PassNameValuePair("tpl", "tspd_trade"));
        } else {
            list.add(new PassNameValuePair("tpl", this.configuration.tpl));
        }
        list.add(new PassNameValuePair("login_share_strategy", this.configuration.loginShareStrategy().getStrValue()));
        list.add(new PassNameValuePair("client", "android"));
        if (this.configuration.showBottomBack) {
            list.add(new PassNameValuePair("adapter", "8"));
        } else {
            list.add(new PassNameValuePair("adapter", this.configuration.customActionBarEnabled ? "3" : ""));
        }
        list.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        list.add(new PassNameValuePair("act", this.configuration.socialBindType.getName()));
        list.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.configuration.smsLoginConfig.flagHideExtraEntry.ordinal())));
        list.add(new PassNameValuePair("loginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowLoginLink.ordinal())));
        list.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        list.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.configuration.smsLoginConfig.flagShowFastRegLink.ordinal())));
        list.add(new PassNameValuePair("lPlayout", String.valueOf(this.configuration.configurableViewLayout.ordinal())));
        if (this.configuration.uniteVerify) {
            list.add(new PassNameValuePair("connect", "1"));
        }
        if (this.configuration.language == Language.ENGLISH) {
            list.add(new PassNameValuePair(VgLogConfig.LANG, f.f11716a));
        }
        list.add(new PassNameValuePair("suppcheck", "1"));
        if (this.configuration.supportFaceLogin) {
            list.add(new PassNameValuePair("scanface", "1"));
            list.add(new PassNameValuePair("liveAbility", "1"));
        }
        if (this.configuration.disableVoiceVerify) {
            list.add(new PassNameValuePair("disable_voice_vcode", "1"));
        }
        return SapiUtils.createRequestParams(list);
    }

    /* access modifiers changed from: package-private */
    public String getAuthRequestParams() {
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("tpl", this.configuration.tpl));
        list.add(new PassNameValuePair("clientfrom", "native"));
        list.add(new PassNameValuePair("client", "android"));
        list.add(new PassNameValuePair("adapter", "3"));
        list.add(new PassNameValuePair("skin", ""));
        list.add(new PassNameValuePair("liveAbility", "1"));
        list.add(new PassNameValuePair("suppcheck", "1"));
        return SapiUtils.createRequestParams(list);
    }

    /* access modifiers changed from: package-private */
    public String getRequestParams(boolean configActionBar) {
        List<PassNameValuePair> list = new ArrayList<>();
        list.add(new PassNameValuePair("clientfrom", "native"));
        list.add(new PassNameValuePair("tpl", this.configuration.tpl));
        list.add(new PassNameValuePair("login_share_strategy", this.configuration.loginShareStrategy().getStrValue()));
        list.add(new PassNameValuePair("client", "android"));
        if (this.configuration.showBottomBack) {
            list.add(new PassNameValuePair("adapter", "8"));
        } else if (configActionBar) {
            list.add(new PassNameValuePair("adapter", this.configuration.customActionBarEnabled ? "3" : ""));
        }
        list.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        list.add(new PassNameValuePair("act", this.configuration.socialBindType.getName()));
        list.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.configuration.smsLoginConfig.flagHideExtraEntry.ordinal())));
        list.add(new PassNameValuePair("loginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowLoginLink.ordinal())));
        list.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        list.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.configuration.smsLoginConfig.flagShowFastRegLink.ordinal())));
        list.add(new PassNameValuePair("lPlayout", String.valueOf(this.configuration.configurableViewLayout.ordinal())));
        if (this.configuration.uniteVerify) {
            list.add(new PassNameValuePair("connect", "1"));
        }
        if (this.configuration.language == Language.ENGLISH) {
            list.add(new PassNameValuePair(VgLogConfig.LANG, f.f11716a));
        }
        list.add(new PassNameValuePair("suppcheck", "1"));
        if (this.configuration.supportFaceLogin) {
            list.add(new PassNameValuePair("scanface", "1"));
            list.add(new PassNameValuePair("liveAbility", "1"));
        }
        if (this.configuration.disableVoiceVerify) {
            list.add(new PassNameValuePair("disable_voice_vcode", "1"));
        }
        return SapiUtils.createRequestParams(list);
    }

    /* access modifiers changed from: package-private */
    public String getUrlSSOFinish() {
        return this.sapiAccountRepository.getDomainSSOFinish();
    }

    /* access modifiers changed from: package-private */
    public String getUrlSSOSecondcard() {
        return this.sapiAccountRepository.getDomainSSOSecondcard();
    }

    /* access modifiers changed from: package-private */
    public String getUrlAfterAuth() {
        return this.sapiAccountRepository.getDomainAfterAuth();
    }

    /* access modifiers changed from: package-private */
    public String getUrlFinishBind() {
        return this.sapiAccountRepository.getDomainFinishBind();
    }

    /* access modifiers changed from: package-private */
    public boolean fastRegDynamicPwdLogin(SapiCallBack<SapiAccountResponse> callBack, String phoneNum, String password) {
        return this.sapiAccountRepository.dynamicPwdLogin(callBack, phoneNum, password, false);
    }

    public void cancelRequest() {
        this.sapiAccountRepository.cancelRequest();
    }

    public void fillUsername(FillUsernameCallback callback, String bduss, String username) {
        this.sapiAccountRepository.fillUsername(callback, bduss, username);
    }

    @Deprecated
    public void setPortrait(SetPortraitCallback callback, String bduss, byte[] file, String contentType) {
        SetPortraitDTO dto = new SetPortraitDTO();
        dto.bduss = bduss;
        dto.file = file;
        dto.contentType = contentType;
        setPortrait(dto, callback);
    }

    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback callback) {
        new PortraitService(this.configuration, "9.10.10").setPortrait(setPortraitDTO, callback);
    }

    public void setPopularPortrait(SetPopularPortraitCallback callback, SetPopularPortraitDTO dto) {
        new PortraitService(this.configuration, "9.10.10").setPopularPortrait(callback, dto);
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback callback, GetHistoryPortraitsDTO dto) {
        new PortraitService(this.configuration, "9.10.10").getHistoryPortraits(callback, dto);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback callback, String bduss, PortraitCategory category) {
        new PortraitService(this.configuration, "9.10.10").getPopularPortraitsInfo(callback, bduss, category);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback callback, String bduss) {
        new PortraitService(this.configuration, "9.10.10").getPopularPortraitsInfo(callback, bduss, PortraitCategory.NORMAL);
    }

    public void getUserInfo(GetUserInfoCallback callback, String bduss) {
        this.sapiAccountRepository.getUserInfo(callback, bduss);
    }

    public void getUserInfo(GetUserInfoCallback callback, String bduss, String ptoken) {
        this.sapiAccountRepository.getUserInfo(callback, bduss, ptoken);
    }

    public void getUserInfo(GetUserInfoCallback callback, String bduss, String loginType, String logExtra) {
        this.sapiAccountRepository.getUserInfo(callback, bduss, loginType, logExtra);
    }

    public void getUserInfo(String bduss, String pToken, NetCallback callback) {
        this.sapiAccountRepository.getUserInfo(bduss, pToken, "", "", callback);
    }

    public void generateSsoHash(SsoHashCallback callback, String callingPkg, String callingAppId) {
        this.sapiAccountRepository.generateSsoHash(callback, callingPkg, callingAppId);
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> callback, GetQrCodeImageDTO getQrCodeImageDTO) {
        QrCodeService.getInstance(this.configuration, "9.10.10").getQrCodeImage(callback, getQrCodeImageDTO);
    }

    public void getQrCodeLoginWithEncuidImage(SapiCallback<GetQrCodeImageResult> callback, GetQrCodeImageDTO getQrCodeImageDTO, String bduss, String stoken) {
        QrCodeService.getInstance(this.configuration, "9.10.10").getQrCodeLoginWithEnuidImage(callback, getQrCodeImageDTO, bduss, stoken);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback callback, QrLoginStstusCheckDTO dto) {
        QrCodeService.getInstance(this.configuration, "9.10.10").qrLoginStatusCheck(callback, dto, true);
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback callback, QrLoginStstusCheckDTO dto) {
        dto.isJoinCodeLogin = true;
        QrCodeService.getInstance(this.configuration, "9.10.10").qrLoginStatusCheck(callback, dto, true);
    }

    public void stopQrLoginStatusCheck() {
        QrCodeService.getInstance(this.configuration, "9.10.10").stopLoginStatusCheck();
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> callback, String url, String cmd) {
        QrCodeService.getInstance(this.configuration, "9.10.10").qrAppLogin(callback, url, cmd);
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> callBack, String phoneNum) {
        return this.sapiAccountRepository.getDynamicPwd(callBack, phoneNum);
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> callback, String phoneNumber) {
        EnhancedService.getInstance(this.configuration, "9.10.10").getDynamicPwd(callback, phoneNumber);
    }

    public void getDynamicPwd(GetDynamicPwdCallback callback, String phoneNumber, String captcha) {
        getDynamicPwd(callback, phoneNumber, captcha, (Map<String, String>) null);
    }

    public void getDynamicPwd(GetDynamicPwdCallback callback, String phoneNumber, String captcha, Map<String, String> extraParams) {
        EnhancedService.getInstance(this.configuration, "9.10.10").getDynamicPwd(callback, phoneNumber, captcha, extraParams);
    }

    public void getDynamicPwd(DynamicPwdWithAuthCallback callback, String phoneNumber, boolean isGuideAuthLogin) {
        EnhancedService.getInstance(this.configuration, "9.10.10").getDynamicPwd(callback, phoneNumber, isGuideAuthLogin);
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> callBack, String phoneNum, String password) {
        return this.sapiAccountRepository.dynamicPwdLogin(callBack, phoneNum, password, true);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> callback, String phoneNumber, String dynamicPwd) {
        EnhancedService.getInstance(this.configuration, "9.10.10").dynamicPwdLogin(callback, phoneNumber, dynamicPwd, (Map<String, String>) null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback callback, String phoneNumber, String dynamicPwd) {
        dynamicPwdLogin(callback, phoneNumber, dynamicPwd, (Map<String, String>) null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback callback, String phoneNumber, String dynamicPwd, Map<String, String> extraParams) {
        EnhancedService.getInstance(this.configuration, "9.10.10").dynamicPwdLogin((SapiCallback<DynamicPwdLoginResult>) callback, phoneNumber, dynamicPwd, extraParams);
    }

    public void dynamicPwdLogin(DynamicPwdWithAuthCallback callback, String phoneNumber, String dynamicPwd, boolean isGuideAuthLogin) {
        EnhancedService.getInstance(this.configuration, "9.10.10").dynamicPwdLogin(callback, phoneNumber, dynamicPwd, isGuideAuthLogin);
    }

    public void startLooper(String channelID, DynamicPwdWithAuthCallback callback) {
        EnhancedService.getInstance(this.configuration, "9.10.10").startLooper(channelID, callback);
    }

    public void stopLooperLoginCheck() {
        EnhancedService.getInstance(this.configuration, "9.10.10").stopLooperLoginCheck();
    }

    public String getCaptchaKey() {
        return EnhancedService.getInstance(this.configuration, "9.10.10").getCaptchaKey();
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> callback) {
        EnhancedService.getInstance(this.configuration, "9.10.10").getCaptcha(callback);
    }

    public boolean isStokenExist(String bduss, List<String> targetTplList) {
        return this.sapiAccountRepository.isStokenExist(bduss, targetTplList);
    }

    /* access modifiers changed from: package-private */
    public boolean isStokenExist(SapiAccount session, List<String> targetTplList) {
        return this.sapiAccountRepository.isAccountStokenExist(session, targetTplList);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback callback, String bduss, List<String> targetTplList) {
        return getTplStoken(callback, bduss, targetTplList, true);
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getTplStoken(GetTplStokenCallback callback, String bduss, List<String> targetTplList, boolean shouldValidate) {
        return this.sapiAccountRepository.getTplStoken(callback, bduss, targetTplList, shouldValidate);
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> callback, String bduss) {
        this.sapiAccountRepository.oauth(callback, bduss, (String) null, (String) null);
    }

    public void oauthWithScope(SapiCallback<OAuthResult> callback, String bduss, String openPlatformId, String scope) {
        this.sapiAccountRepository.oauth(callback, bduss, openPlatformId, scope);
    }

    public void oauth(SapiCallback<OAuthResult> callback, String bduss, String openPlatformId) {
        this.sapiAccountRepository.oauth(callback, bduss, openPlatformId, (String) null);
    }

    public void oauthAccessToken(SapiCallback<OAuthResult> callback, String bduss, String openPlatformId, boolean forceRefresh) {
        if (!TextUtils.isEmpty(bduss) && !TextUtils.isEmpty(openPlatformId) && callback != null) {
            if (forceRefresh) {
                this.sapiAccountRepository.oauth(callback, bduss, openPlatformId, (String) null);
            } else {
                this.sapiAccountRepository.oauthAccessToken(callback, bduss, openPlatformId);
            }
        }
    }

    public boolean refreshLocalAccessToken(String bduss, String openPlatformId, String newToken, String newRefreshToken) {
        return this.sapiAccountRepository.refreshLocalAccessToken(bduss, openPlatformId, newToken, newRefreshToken);
    }

    public LocalRefreshTokenResult syncGetLocalRefreshToken(String bduss, String openPlatformId) {
        return this.sapiAccountRepository.syncGetLocalRefreshToken(bduss, openPlatformId);
    }

    public void web2NativeLogin(Web2NativeLoginCallback callback) {
        web2NativeLogin(callback, true);
    }

    public void web2NativeLogin(Web2NativeLoginCallback callback, Web2NativeLoginDTO web2NativeLoginDTO) {
        this.sapiAccountRepository.web2NativeLogin(callback, web2NativeLoginDTO);
    }

    public void web2NativeLogin(Web2NativeLoginCallback callback, boolean overWriteNAAccount) {
        Web2NativeLoginDTO web2NativeLoginDTO = new Web2NativeLoginDTO();
        web2NativeLoginDTO.overWriteNAAccount = overWriteNAAccount;
        this.sapiAccountRepository.web2NativeLogin(callback, web2NativeLoginDTO);
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback callback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.sapiAccountRepository.iqiyiSSOLogin(callback, iqiyiLoginDTO);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> callback, String bduss) {
        this.sapiAccountRepository.checkUserFaceId(callback, bduss, (Map<String, String>) null);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> callback, String bduss, Map<String, String> paramsMap) {
        this.sapiAccountRepository.checkUserFaceId(callback, bduss, paramsMap);
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> callback, String openAppid, String openApikey) {
        this.sapiAccountRepository.extendSysWebViewMethodCheck(callback, openAppid, openApikey);
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> callback, String bduss) {
        this.sapiAccountRepository.checkFaceLoginStatus(callback, bduss);
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> callback, String bduss, boolean faceLoginSwitch, String callbackKey) {
        this.sapiAccountRepository.faceLoginSwitch(callback, bduss, faceLoginSwitch, callbackKey);
    }

    public boolean webLogin(Context context) {
        SapiAccount account;
        if (context == null || (account = SapiContext.getInstance().getCurrentAccount()) == null) {
            return false;
        }
        return SapiUtils.webLogin(context, account.bduss, account.ptoken);
    }

    public boolean webLogin(final Context context, String bduss) {
        if (context == null || TextUtils.isEmpty(bduss)) {
            return false;
        }
        List<String> list = new ArrayList<>();
        list.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
            public void onSuccess(GetTplStokenResult result) {
                SapiAccountService.asyncStoken2Web(context, result.tplStokenMap.get("pp"));
            }

            public void onFailure(GetTplStokenResult result) {
            }

            public void onStart() {
            }

            public void onFinish() {
            }
        }, bduss, list);
        SapiAccount account = SapiContext.getInstance().getAccountFromBduss(bduss);
        if (account != null) {
            return asyncBduss2Web(context, account.bduss, account.ptoken);
        }
        return asyncBduss2Web(context, bduss, (String) null);
    }

    public boolean webLogin(Context context, String bduss, String ptoken) {
        return webLogin(context, bduss);
    }

    private boolean asyncBduss2Web(Context context, String bduss, String ptoken) {
        if (context == null || TextUtils.isEmpty(bduss)) {
            return false;
        }
        try {
            List<PassNameValuePair> cookies = new ArrayList<>();
            for (String domain : SapiUtils.getAuthorizedDomains()) {
                if (!bduss.equals(SapiUtils.getCookie(SapiUtils.COOKIE_URL_PREFIX + domain, Constants.NETDISK_BDUSS_FIELD_NAME))) {
                    cookies.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + domain, SapiUtils.buildBDUSSBFESSCookie(domain, bduss)));
                    cookies.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + domain, SapiUtils.buildBDUSSCookie(domain, bduss)));
                }
            }
            if (!TextUtils.isEmpty(ptoken)) {
                for (String domain2 : SapiUtils.getAuthorizedDomainsForPtoken()) {
                    if (!ptoken.equals(SapiUtils.getCookie("https://" + domain2, "PTOKEN"))) {
                        cookies.add(new PassNameValuePair("https://" + domain2, SapiUtils.buildPtokenCookie(domain2, ptoken)));
                    }
                }
            }
            SapiUtils.syncCookies(context, cookies);
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }

    static boolean asyncStoken2Web(Context context, String stoken) {
        if (context == null || TextUtils.isEmpty(stoken)) {
            return false;
        }
        try {
            List<PassNameValuePair> cookies = new ArrayList<>();
            if (!TextUtils.isEmpty(stoken)) {
                for (String domain : SapiUtils.getAuthorizedDomainsForPtoken()) {
                    if (!stoken.equals(SapiUtils.getCookie("https://" + domain, Constants.COOKIE_STOKEN))) {
                        cookies.add(new PassNameValuePair("https://" + domain, SapiUtils.buildStokenCookie(domain, stoken)));
                    }
                }
            }
            SapiUtils.syncCookies(context, cookies);
            return true;
        } catch (Throwable th2) {
            return false;
        }
    }

    public void getContacts(GetContactsCallback callback, GetContactsDTO getContactDTO) {
        Log.d(TAG, "getContacts: ");
        GetContactsService.getInstance(this.configuration, "9.10.10").getContacts(callback, getContactDTO);
    }

    public void sendContactsSms(SendSmsDTO sendSmsDTO) {
        GetContactsService.getInstance(this.configuration, "9.10.10").sendSMS(sendSmsDTO);
    }

    public void relaseContactsSource() {
        GetContactsService.getInstance(this.configuration, "9.10.10").relaseContactsSource();
    }

    public void getOpenBduss(GetOpenBdussDTO dto, GetOpenBdussCallback callback) {
        new OpenBdussService(this.configuration, "9.10.10").getOpenBduss(dto, callback);
    }

    public int getBdussState() {
        return new OpenBdussService(this.configuration, "9.10.10").getBdussState();
    }

    /* access modifiers changed from: package-private */
    public void loadOneKeyLogin(OneKeyLoginCallback callback, String token, String signParams, LoadExternalWebViewActivityCallback innerCallback) {
        loadOneKeyLogin(callback, token, signParams, true, innerCallback);
    }

    /* access modifiers changed from: package-private */
    public void loadOneKeyLogin(OneKeyLoginCallback callback, String token, String signParams, boolean doYYNormalOneKey, LoadExternalWebViewActivityCallback innerCallback) {
        this.sapiAccountRepository.loadOneKeyLogin(callback, token, signParams, doYYNormalOneKey, innerCallback);
    }

    public void handleOneKeyLoginResult(OneKeyLoginCallback callback, String xml) {
        SapiAccountResponse response = SapiCoreUtil.parseAccountXmlToResponse("business_from_one_key_login", xml);
        if (response != null) {
            String operator = new OneKeyLoginSdkCall().getOperatorType();
            if ("CM".equals(operator)) {
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CM.getName());
            } else if ("CU".equals(operator)) {
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CU.getName());
            } else if ("CT".equals(operator)) {
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CT.getName());
            }
            SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount(response));
            authorizeOneKeyLoginSuccess(callback, response.accountType);
            return;
        }
        new OneKeyLoginSdkCall().loadOneKeyLoginFail(callback, -103, (String) null);
    }

    private SapiAccount sapiAccountResponseToAccount(SapiAccountResponse response) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = response.uid;
        sapiAccount.bduss = response.bduss;
        sapiAccount.displayname = response.displayname;
        sapiAccount.stoken = response.stoken;
        sapiAccount.ptoken = response.ptoken;
        sapiAccount.email = response.email;
        sapiAccount.username = response.username;
        sapiAccount.app = TextUtils.isEmpty(response.app) ? SapiUtils.getAppName(this.configuration.context) : response.app;
        sapiAccount.extra = response.extra;
        sapiAccount.fromType = response.fromType.getValue();
        if (SocialType.UNKNOWN != response.socialType) {
            sapiAccount.addSocialInfo(response.socialType, response.socialPortraitUrl, response.socialNickname, response.openid);
            sapiAccount.putExtra("account_type", Integer.valueOf(response.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.configuration.tpl);
        if (!response.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(response.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(response.actionType);
        sapiAccount.addIsGuestAccount(response.isGuestAccount);
        if (!TextUtils.isEmpty(response.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(this.configuration.context, response.livingUname);
        }
        return sapiAccount;
    }

    private void authorizeOneKeyLoginSuccess(OneKeyLoginCallback callback, AccountType accountType) {
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(0);
        callback.onSuccess(oneKeyLoginResult);
    }

    public void preGetPhoneInfo() {
        new OneKeyLoginSdkCall().preGetPhoneInfo(this.configuration, "product");
    }

    public void preGetPhoneInfo(Context context, String scene, int connectTimeout, boolean withLogin, OneKeyLoginOptCallback oneKeyLoginOptCallback) {
        OneKeyLoginSdkCall.getInstance().preGetPhoneInfo(context, scene, connectTimeout, withLogin, oneKeyLoginOptCallback);
    }

    public JSONObject getPhoneNumAndOperatorType() {
        return new OneKeyLoginSdkCall().getEncryptPhone();
    }

    public void getOneKeyLoginToken(OneKeyLoginSdkCall.TokenListener listener) {
        new OneKeyLoginSdkCall().getToken(this.configuration, listener);
    }

    public void getOneKeyLoginIsAvailable(final GetOneKeyLoginStateDTO dto, final OneKeyLoginCallback callback) {
        if (callback == null) {
            Log.e(TAG, "When check oneKeyLogin's ability, oneKeyLoginCallback can't be null!");
        } else if (Build.VERSION.SDK_INT < 19) {
            OneKeyLoginSdkCall.getInstance().preGetPhoneFail(callback, -109, (String) null);
        } else {
            OneKeyLoginOptResult optResult = OneKeyLoginSdkCall.getInstance().getPreLoginOptResult();
            if (optResult == null || TextUtils.isEmpty(optResult.getSecurityPhone())) {
                OneKeyLoginSdkCall.getInstance().preGetPhoneInfo(this.configuration.context, OneKeyLoginSdkCall.OKL_SCENE_SAPI, dto.connectTimeout, false, new OneKeyLoginOptCallback() {
                    public void onFinish(OneKeyLoginOptResult optResult) {
                        if (optResult == null) {
                            OneKeyLoginSdkCall.getInstance().preGetPhoneFail(callback, -100, (String) null);
                        } else if (TextUtils.isEmpty(optResult.getSecurityPhone())) {
                            OneKeyLoginSdkCall.getInstance().preGetPhoneFail(callback, optResult.getCode(), optResult.getSubCode(), (String) null);
                        } else {
                            SapiAccountService.this.sapiAccountRepository.checkOneKeyLoginIsAvailable(callback, optResult.getSecurityPhone(), dto.connectTimeout);
                        }
                    }
                });
            } else {
                this.sapiAccountRepository.checkOneKeyLoginIsAvailable(callback, optResult.getSecurityPhone(), dto.connectTimeout);
            }
        }
    }

    public void setCloudShareAccount(int shareEvent, ShareStorage.StorageModel storageModel) {
        this.sapiAccountRepository.setCloudShareAccount(shareEvent, storageModel);
    }

    public void getShareV3App(String tpl, List<String> pkgList, String currentPkg, GetShareV3AppCallback callback) {
        this.sapiAccountRepository.getShareV3App(tpl, pkgList, currentPkg, callback);
    }

    public void checkAvailableLoginHistory(String loginHistoryInfo, LoginHistoryCallback callback) {
        this.sapiAccountRepository.checkAvailableLoginHistory(loginHistoryInfo, callback);
    }

    public void getOnlineAppShareModel(List<GetOnlineRequestShareModel> applist, String frominterflow, GetOnlineAppCallback callback) {
        this.sapiAccountRepository.getOnlineAppShareModel(applist, frominterflow, callback);
    }

    public void getCertInfo(GetCertStatusCallback callback) {
        this.sapiAccountRepository.getCertStatus(callback);
    }

    public void userLogout(int logoutType, UserLogoutCallback callback) {
        this.sapiAccountRepository.userLogout(logoutType, callback);
    }

    public void isShowRealNameGuide(IsShowRealNameGuideDTO dto, IsShowRealNameCallback callback) {
        this.sapiAccountRepository.isShowRealNameGuide(dto, callback);
    }

    public void getUserAttrInfo(String appName, String fields, String extFields, String localKey, GetUserAttrInfoCallback callback) {
        this.sapiAccountRepository.getUserAttrInfo(appName, fields, extFields, localKey, callback);
    }

    public void loginWithUCAuth(String tpl, String appId, String ucData, LoginWithUCAuthCallback callback) {
        this.sapiAccountRepository.loginWithUCAuth(tpl, appId, ucData, callback);
    }

    public void validateOnlyHaoKan(String bduss, ValidateWithHaoKanCallback callback) {
        this.sapiAccountRepository.validateOnlyHaoKan(bduss, callback);
    }
}
