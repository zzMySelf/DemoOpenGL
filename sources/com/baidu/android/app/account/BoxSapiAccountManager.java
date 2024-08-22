package com.baidu.android.app.account;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.app.account.ILoginContext;
import com.baidu.android.app.account.utils.AccountSrcUtils;
import com.baidu.android.app.account.utils.AccountUBCHelperKt;
import com.baidu.android.app.account.utils.LogDescription;
import com.baidu.android.app.account.utils.LogUtils;
import com.baidu.android.app.account.utils.ThirdLoginUtils;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.pass.biometrics.face.liveness.callback.PassFaceRecogCallback;
import com.baidu.pass.biometrics.face.liveness.result.PassFaceRecogResult;
import com.baidu.pass.ecommerce.callback.GetLocationCallback;
import com.baidu.pass.ecommerce.callback.GetScenePermissionCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.activity.SwitchAccountActivity;
import com.baidu.sapi2.bio.BiometricsManager;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.callback.AuthWidgetCallback;
import com.baidu.sapi2.callback.ChangeUsernameCallback;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.IsShowRealNameCallback;
import com.baidu.sapi2.callback.LoadDuVipPayCallBack;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.PersonalInfoCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.VerifyUserFaceIDCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.contacts.bean.UserPhoneBean;
import com.baidu.sapi2.contacts.callback.GetContactsCallback;
import com.baidu.sapi2.contacts.dto.GetContactsDTO;
import com.baidu.sapi2.contacts.dto.SendSmsDTO;
import com.baidu.sapi2.contacts.result.GetContactsResult;
import com.baidu.sapi2.dto.AccountToolsDTO;
import com.baidu.sapi2.dto.ChangeUserNameDTO;
import com.baidu.sapi2.dto.FaceIDVerifyCertInfoDTO;
import com.baidu.sapi2.dto.FaceIDVerifyDTO;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.PersonalInfoDTO;
import com.baidu.sapi2.dto.RealNameDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import com.baidu.sapi2.ecommerce.callback.InvoiceBuildCallback;
import com.baidu.sapi2.ecommerce.callback.MapStatusAndLocateCallback;
import com.baidu.sapi2.ecommerce.dto.AddressManageDTO;
import com.baidu.sapi2.ecommerce.dto.AddressScenePermissionDTO;
import com.baidu.sapi2.ecommerce.dto.InvoiceBuildDTO;
import com.baidu.sapi2.ecommerce.result.AddressManageResult;
import com.baidu.sapi2.ecommerce.result.InvoiceBuildResult;
import com.baidu.sapi2.enums.PortraitCategory;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.ChangeUsernameResult;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.IsShowRealNameGuideResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.sapi2.result.RealNameFaceIDResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.UnRealNameFaceIDResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindInfoAction;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountDialogContext;
import com.baidu.searchbox.account.IAccountFaceRecogCallback;
import com.baidu.searchbox.account.IAccountQueryListener;
import com.baidu.searchbox.account.IAccountRequestListener;
import com.baidu.searchbox.account.IAccountToolsCallback;
import com.baidu.searchbox.account.IAddressManageCallback;
import com.baidu.searchbox.account.IAuthWidgetCallback;
import com.baidu.searchbox.account.IBdussAlertVerificationCallback;
import com.baidu.searchbox.account.ICheckBdussAlertStatusCallback;
import com.baidu.searchbox.account.ICheckUserFaceIdCallback;
import com.baidu.searchbox.account.IDownloadLibMmlCallback;
import com.baidu.searchbox.account.IGetBoxAccountListener;
import com.baidu.searchbox.account.IGetContactsCallback;
import com.baidu.searchbox.account.IGetOpenBdussCallback;
import com.baidu.searchbox.account.IGetTplStokenCallback;
import com.baidu.searchbox.account.IGetUserCertInfoListener;
import com.baidu.searchbox.account.IHistoryLoginCallback;
import com.baidu.searchbox.account.ILoginAgreeDialogCallback;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.INickNameGuideDialogListener;
import com.baidu.searchbox.account.INickNamePortraitDialogCallback;
import com.baidu.searchbox.account.IOneKeyLoginCallback;
import com.baidu.searchbox.account.IOneKeyLoginOptCallback;
import com.baidu.searchbox.account.ISapiCallback;
import com.baidu.searchbox.account.ISettingsRealNameGuidCallback;
import com.baidu.searchbox.account.IShareLoginInfoCallback;
import com.baidu.searchbox.account.ISmsLoginViewListener;
import com.baidu.searchbox.account.ITokenListener;
import com.baidu.searchbox.account.IUploadPortraitListener;
import com.baidu.searchbox.account.IVerifyUserFaceIDForSwanListener;
import com.baidu.searchbox.account.IVerifyUserFaceIDListener;
import com.baidu.searchbox.account.IWeb2NativeLoginCallback;
import com.baidu.searchbox.account.IWebModifyPwdCallback;
import com.baidu.searchbox.account.LoginInfoCallback;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.account.address.BoxAddressBuildDTO;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import com.baidu.searchbox.account.component.AccountHalfScreenDialog;
import com.baidu.searchbox.account.component.AccountLoginAgreeConfig;
import com.baidu.searchbox.account.component.AccountOperationConfig;
import com.baidu.searchbox.account.component.AccountOperationManager;
import com.baidu.searchbox.account.component.AccountPersuadeView;
import com.baidu.searchbox.account.component.AccountQuickLoginManager;
import com.baidu.searchbox.account.component.AccountTaskGuideView;
import com.baidu.searchbox.account.component.AccountWealthTaskPacketLoginView;
import com.baidu.searchbox.account.component.IAccountComponentCallback;
import com.baidu.searchbox.account.component.NicknamePortraitConfig;
import com.baidu.searchbox.account.config.IAccountConfig;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.data.OnGetTplStokenResult;
import com.baidu.searchbox.account.data.SearchBoxRealNameResult;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.dialog.HalfScreenDialogActivity;
import com.baidu.searchbox.account.dialog.NickNameDialogActivity;
import com.baidu.searchbox.account.dialog.NickNameDialogManager;
import com.baidu.searchbox.account.dto.BoxGetContactDTO;
import com.baidu.searchbox.account.dto.BoxSendSmsDTO;
import com.baidu.searchbox.account.event.GetUserInfoEvent;
import com.baidu.searchbox.account.event.UserInfoChangeEvent;
import com.baidu.searchbox.account.invoicebuild.BoxInvoiceBuildCallback;
import com.baidu.searchbox.account.invoicebuild.BoxInvoiceBuildDTO;
import com.baidu.searchbox.account.invoicebuild.BoxInvoiceBuildResult;
import com.baidu.searchbox.account.listener.ChildGuarderDialogUtil;
import com.baidu.searchbox.account.listener.IModifyUserInfoListener;
import com.baidu.searchbox.account.manager.AbstractBoxAccountManager;
import com.baidu.searchbox.account.manager.AccountDebugManager;
import com.baidu.searchbox.account.manager.AccountLoginDialogManager;
import com.baidu.searchbox.account.manager.BoxPortraitManager;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.account.params.LogoutParams;
import com.baidu.searchbox.account.pms.MmlModelChannelKt;
import com.baidu.searchbox.account.request.AccountBindRequest;
import com.baidu.searchbox.account.request.AccountFirstPopupRequest;
import com.baidu.searchbox.account.request.AccountGetRequest;
import com.baidu.searchbox.account.request.AccountNicknamePopupRequest;
import com.baidu.searchbox.account.request.AccountPublicGetRequest;
import com.baidu.searchbox.account.request.AccountSaveRequest;
import com.baidu.searchbox.account.request.AccountStatusRequest;
import com.baidu.searchbox.account.result.AccountOpenBdussResult;
import com.baidu.searchbox.account.result.BoxAddressManageResult;
import com.baidu.searchbox.account.result.BoxFaceRecogResult;
import com.baidu.searchbox.account.result.BoxGetContactResult;
import com.baidu.searchbox.account.result.BoxHistoryLoginResult;
import com.baidu.searchbox.account.result.BoxLoginHistoryModel;
import com.baidu.searchbox.account.result.BoxOauthResult;
import com.baidu.searchbox.account.result.BoxOneKeyLoginOptResult;
import com.baidu.searchbox.account.result.BoxOneKeyLoginResult;
import com.baidu.searchbox.account.result.BoxSapiResult;
import com.baidu.searchbox.account.result.BoxShareLoginResult;
import com.baidu.searchbox.account.result.BoxUserPhoneBean;
import com.baidu.searchbox.account.result.LoginResult;
import com.baidu.searchbox.account.result.NickNameGuideErrorCode;
import com.baidu.searchbox.account.result.ThirdLoginResult;
import com.baidu.searchbox.account.session.BoxCookieSession;
import com.baidu.searchbox.account.session.BoxLocalSession;
import com.baidu.searchbox.account.session.BoxSapiSession;
import com.baidu.searchbox.account.userinfo.activity.AccountCenterProxyActivity;
import com.baidu.searchbox.account.userinfo.activity.AccountNickNameActivity;
import com.baidu.searchbox.account.userinfo.activity.AccountUserInfoEditActivity;
import com.baidu.searchbox.account.userinfo.utils.VipBuyUtilsKt;
import com.baidu.searchbox.account.view.IAccountSmsLoginView;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.location.BoxLocationManager;
import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.location.LocationListener;
import com.baidu.searchbox.location.util.LocationUtils;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.scene.IPermissionSceneApi;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.ubc.UBCManager;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;

public class BoxSapiAccountManager extends AbstractBoxAccountManager {
    private static final String ACCOUNT_LOGIN_CUSTOM_CSS_URL = "account_login_custom_css_url";
    private static final String ADDRESS_MANAGER_SOURCE = "address_management";
    private static final String ADDRESS_SOURCE = "personal_address";
    private static final String ADDRESS__UBC_ID = "1042";
    private static final int ERROR_NOT_LOGIN = -100;
    private static final int ERROR_OTHER = -200;
    public static final String HISTORY_LOGIN_CLOSE = "0";
    public static final String HISTORY_LOGIN_OPEN = "1";
    public static final String HISTORY_LOGIN_SWITCH = "history_login_switch";
    private static final String INVOICE_MANAGER_SOURCE = "invoice_management";
    private static final String INVOICE_SOURCE = "personal_receipt";
    private static final String INVOICE_UBC_ID = "1128";
    private static final String KEY_ACCOUNT_PREF_UPDATED = "key_account_pref_updated";
    private static final String KEY_ACCOUNT_PREF_UPDATED_6_6 = "key_account_pref_updated_6_6";
    public static final String KEY_ACCOUNT_RESTART_SHARE_SWITCH = "account_restart_share_switch";
    public static final String LOGIN_SHOW_TYPE_DEFAULT = "share_onekey_history_normal";
    private static final String LOGIN_SHOW_TYPE_HISTORY = "history";
    private static final String LOGIN_SHOW_TYPE_NORMAL = "normal";
    private static final String LOGIN_SHOW_TYPE_ONEKEY = "onekey";
    private static final String LOGIN_SHOW_TYPE_SHARE = "share";
    private static final String LOGIN_SHOW_TYPE_WECHAT = "wechat";
    public static final String PREF_ACCOUNT_RESTART_SHARE_TIME = "account_restart_share_time";
    private static final String SCHEME_BJH = "baiduboxapp://swan/jEwtEbQQTgu7i8brHEM0Qb9QlliHL0q5/pages/newmodify/index";
    private static final String SCHEME_BJH_H5 = "baiduboxapp://v1/easybrowse/open?layoutfullscreen=1&barcolor=00000000&backlocation=1&newbrowser=1&style=%7B%22toolbaricons%22%3A%7B%22template_id%22%3A2%7D%7D&url=https%3A%2F%2Fbaijiahao.baidu.com%2Fbuilder%2Fh5%2Fpass%2Fauth%2Fmodify%3Ffrom%3Dshuangqingdan";
    private static final String SELECT_ADDRESS_SCENE = "address";
    private static final String SELECT_ADDRESS_SOURCE = "address_choose";
    private static final String SELECT_INVOICE_SOURCE = "invoice_choose";
    private static final String SHOW_VALUE = "show";
    private static final String TAG = "BoxSapiAccountManager";
    private static final long TIME_ONE_SECOND = 1000;
    public static final int TYPE_ACCOUNT_DEFAULT = -1;
    private static final String URL_PASS_AUTH_DETAIL = "https://auth.baidu.com/thrones-mobile?id=";
    private static final String WECHAT_PACKAGE = "com.tencent.mm";
    /* access modifiers changed from: private */
    public static BoxAccount mBoxAccount;
    /* access modifiers changed from: private */
    public static BoxOneKeyLoginResult mLocalOneKeyResult;
    private static boolean sHasPrefetched;
    /* access modifiers changed from: private */
    public LocationListener mLocationListener;
    private WebBindWidgetCallback webBindWidgetCallback;

    public interface OnDynamicSmsLoginListener extends NoProGuard {
        void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult);

        void onFinish();

        void onStart();

        void onSuccess();
    }

    public interface OnGetCaptchaListener extends NoProGuard {
        void onFailure(GetCaptchaResult getCaptchaResult);

        void onFinish();

        void onStart();

        void onSuccess(GetCaptchaResult getCaptchaResult);
    }

    public interface OnGetDynamicPwdListener extends NoProGuard {
        void onNetworkFailed();

        void onSuccess();

        void onSystemError(int i2);
    }

    public interface OnGetDynamicPwdNeedCaptchaListener extends NoProGuard {
        void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult);

        void onFailure(GetDynamicPwdResult getDynamicPwdResult);

        void onFinish();

        void onStart();

        void onSuccess(GetDynamicPwdResult getDynamicPwdResult);
    }

    public interface OnSmsLoginListener extends NoProGuard {
        void onNetworkFailed();

        void onSuccess();

        void onSystemError(int i2);
    }

    public BoxSapiAccountManager() {
        PassSapiHelper.initSapiComponent(AppRuntime.getAppContext());
        cloudSwitcherDealer();
        ILoginContext.Impl.get().registerPrivacyModeEvent();
    }

    private void cloudSwitcherDealer() {
        boolean shouldRestartShare = DefaultSharedPrefsWrapper.getInstance().getBoolean("account_restart_share_switch", false);
        long lastLogoutTime = BoxAccountPreference.getAccountLongPreference("pref_key_logout_time", 0);
        long restartTime = DefaultSharedPrefsWrapper.getInstance().getLong(PREF_ACCOUNT_RESTART_SHARE_TIME, 0);
        if (shouldRestartShare && System.currentTimeMillis() - lastLogoutTime > 1000 * restartTime) {
            prepare();
        }
    }

    public void login(Context context, LoginParams params, ILoginResultListener listener) {
        localConfig(params);
        new BoxLoginBridge().login(context, params, listener);
    }

    public void login(Context context, LoginParams params) {
        login(context, params, (ILoginResultListener) null);
    }

    public void combineLogin(Context context, LoginParams params, int flag, ILoginResultListener listener) {
        localConfig(params);
        new BoxLoginBridge().combineLogin(context, params, flag, listener);
    }

    public IAccountSmsLoginView startBoxSmsLoginView(Context context, LoginParams params, ISmsLoginViewListener smsViewLoginListener) {
        localConfig(params);
        return new BoxLoginBridge().startBoxSmsLoginView(context, params, smsViewLoginListener);
    }

    public IAccountSmsLoginView startBoxSmsLoginViewV2(Context context, LoginParams params, ISmsLoginViewListener smsViewLoginListener) {
        localConfig(params);
        return new BoxLoginBridge().startBoxSmsLoginViewV2(context, params, smsViewLoginListener);
    }

    public void bindPhone(Context context, LoginParams params, ILoginResultListener listener) {
        localConfig(params);
        new BoxLoginBridge().bindPhone(context, params, listener);
    }

    public boolean isLogin(int flag) {
        if ((flag & 2) != 0) {
            return isLogin() && !isGuestLogin();
        }
        return isLogin();
    }

    public boolean isGuestLogin() {
        SapiAccount account = SapiAccountManager.getInstance().getSession();
        return account != null && account.isGuestAccount();
    }

    @Deprecated
    public BoxAccount getBoxAccount(int mode, IGetBoxAccountListener listener) {
        BoxAccount boxAccount = getBoxAccount();
        if (boxAccount == null) {
            listener.onFailed(-3);
        } else {
            listener.onSuccess(boxAccount);
        }
        return boxAccount;
    }

    public void checkBdussAndAlert(Activity activity, boolean isShowAlert, String ubcSource, ICheckBdussAlertStatusCallback alertStatusCallback) {
        checkBdussAndAlert(activity, isShowAlert, ubcSource, alertStatusCallback, (IAccountDialogContext) null);
    }

    public void checkBdussAndAlert(Activity activity, boolean isShowAlert, String ubcSource, ICheckBdussAlertStatusCallback alertStatusCallback, IAccountDialogContext dialogContext) {
        checkBdussAndAlert(activity, isShowAlert, ubcSource, alertStatusCallback, dialogContext, (IBdussAlertVerificationCallback) null);
    }

    public void checkBdussAndAlert(Activity activity, boolean isShowAlert, String ubcSource, ICheckBdussAlertStatusCallback alertStatusCallback, IAccountDialogContext dialogContext, IBdussAlertVerificationCallback verificationCallback) {
        new AccountCheckBdussAndUploadManager().checkBdussAndAlert(activity, isShowAlert, ubcSource, alertStatusCallback, dialogContext, verificationCallback);
    }

    public void modifyUserInfo(long type, BoxAccount boxAccount, final IAccountRequestListener accountRequestListener) {
        new AccountSaveRequest().requestUserInfo(type, boxAccount, PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString(BoxAccountContants.ACCOUNT_EXT_FIELDS_KEYS, (String) null), new IModifyUserInfoListener() {
            public void onSuccess(BoxAccount boxAccount) {
                if (boxAccount != null) {
                    BoxAccount unused = BoxSapiAccountManager.mBoxAccount = boxAccount;
                    IAccountRequestListener iAccountRequestListener = accountRequestListener;
                    if (iAccountRequestListener != null) {
                        iAccountRequestListener.onSuccess(BoxSapiAccountManager.mBoxAccount);
                    }
                    BdEventBus.Companion.getDefault().post(new UserInfoChangeEvent());
                }
            }

            public void onFailure(BoxAccount.ErrorBean errorBean) {
                IAccountRequestListener iAccountRequestListener = accountRequestListener;
                if (iAccountRequestListener != null) {
                    iAccountRequestListener.onFailed(errorBean);
                }
            }

            public void onBdussExpired(String msg) {
                BoxSapiAccountManager.this.logout(new LogoutParams.Builder().setLogoutSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, "save_bduss_expired")).build());
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) msg).showToast();
            }
        });
    }

    public void modifyUserInfo(JSONObject accountJson, final IAccountRequestListener accountRequestListener) {
        new AccountSaveRequest().requestUserInfo(accountJson, PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString(BoxAccountContants.ACCOUNT_EXT_FIELDS_KEYS, (String) null), new IModifyUserInfoListener() {
            public void onSuccess(BoxAccount boxAccount) {
                if (boxAccount != null) {
                    BoxAccount unused = BoxSapiAccountManager.mBoxAccount = boxAccount;
                    IAccountRequestListener iAccountRequestListener = accountRequestListener;
                    if (iAccountRequestListener != null) {
                        iAccountRequestListener.onSuccess(BoxSapiAccountManager.mBoxAccount);
                    }
                    BdEventBus.Companion.getDefault().post(new UserInfoChangeEvent());
                }
            }

            public void onFailure(BoxAccount.ErrorBean errorBean) {
                IAccountRequestListener iAccountRequestListener = accountRequestListener;
                if (iAccountRequestListener != null) {
                    iAccountRequestListener.onFailed(errorBean);
                }
            }

            public void onBdussExpired(String msg) {
                BoxSapiAccountManager.this.logout(new LogoutParams.Builder().setLogoutSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, "save_bduss_expired")).build());
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) msg).showToast();
            }
        });
    }

    public void getAccountInfoFromServer(final IGetBoxAccountListener listener) {
        if (getSession("BoxAccount_bduss") != null) {
            new AccountGetRequest().requestUserInfo(PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString(BoxAccountContants.ACCOUNT_EXT_FIELDS_KEYS, (String) null), new IModifyUserInfoListener() {
                public void onSuccess(BoxAccount boxAccount) {
                    if (boxAccount != null) {
                        BoxAccount unused = BoxSapiAccountManager.mBoxAccount = boxAccount;
                        IGetBoxAccountListener iGetBoxAccountListener = listener;
                        if (iGetBoxAccountListener != null) {
                            iGetBoxAccountListener.onSuccess(boxAccount);
                        }
                        BdEventBus.Companion.getDefault().post(new UserInfoChangeEvent());
                        BdEventBus.Companion.getDefault().post(new GetUserInfoEvent());
                    }
                }

                public void onFailure(BoxAccount.ErrorBean errorBean) {
                    IGetBoxAccountListener iGetBoxAccountListener = listener;
                    if (iGetBoxAccountListener != null) {
                        iGetBoxAccountListener.onFailed(-3);
                    }
                    LogUtils.writeOnlineLog(LogDescription.ERROR_REQUEST_GET, errorBean != null ? errorBean.getErrorMsg() : "", "getAccountInfoFromServer", false, false);
                }

                public void onBdussExpired(String msg) {
                    BoxSapiAccountManager.this.logout(new LogoutParams.Builder().setLogoutSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, "get_bduss_expired")).build());
                    UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) msg).showToast();
                }
            });
        } else if (listener != null) {
            listener.onFailed(-3);
        }
    }

    public void getAccountFirstPopupFromServer(final IGetBoxAccountListener listener) {
        if (getSession("BoxAccount_bduss") != null) {
            new AccountFirstPopupRequest().requestFirstPopup(new IModifyUserInfoListener() {
                public void onSuccess(BoxAccount boxAccount) {
                    if (boxAccount != null) {
                        BoxSapiAccountManager.mBoxAccount.setFirstPopType(boxAccount.getFirstPopType());
                        BoxSapiAccountManager.mBoxAccount.setFirstDistributeNickname(boxAccount.getFirstDistributeNickname());
                        if (!TextUtils.isEmpty(boxAccount.getNickname())) {
                            BoxSapiAccountManager.mBoxAccount.setNickname(boxAccount.getNickname());
                            BdEventBus.Companion.getDefault().post(new UserInfoChangeEvent());
                        }
                        IGetBoxAccountListener iGetBoxAccountListener = listener;
                        if (iGetBoxAccountListener != null) {
                            iGetBoxAccountListener.onSuccess(BoxSapiAccountManager.mBoxAccount);
                        }
                    }
                }

                public void onFailure(BoxAccount.ErrorBean errorBean) {
                    IGetBoxAccountListener iGetBoxAccountListener = listener;
                    if (iGetBoxAccountListener != null) {
                        iGetBoxAccountListener.onFailed(errorBean.getErrorCode());
                    }
                }

                public void onBdussExpired(String msg) {
                    BoxSapiAccountManager.this.logout(new LogoutParams.Builder().setLogoutSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, "get_bduss_expired")).build());
                    UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) msg).showToast();
                }
            });
        } else if (listener != null) {
            listener.onFailed(-3);
        }
    }

    public void getAccountNicknamePopupFromServer(int nicknameDialogType, final IGetBoxAccountListener listener) {
        if (getSession("BoxAccount_bduss") != null) {
            String popType = "";
            if (nicknameDialogType == 0) {
                popType = "0";
            } else if (nicknameDialogType == 1) {
                popType = "1";
            }
            new AccountNicknamePopupRequest().requestNickname(popType, new IModifyUserInfoListener() {
                public void onSuccess(BoxAccount boxAccount) {
                    if (boxAccount != null) {
                        BoxSapiAccountManager.mBoxAccount.setPopType(boxAccount.getPopType());
                        BoxSapiAccountManager.mBoxAccount.setGuideNickDialogInterval(String.valueOf(boxAccount.getGuideNickDialogInterval()));
                        BoxSapiAccountManager.mBoxAccount.setRecommendNick(boxAccount.getRecommendNick());
                        IGetBoxAccountListener iGetBoxAccountListener = listener;
                        if (iGetBoxAccountListener != null) {
                            iGetBoxAccountListener.onSuccess(BoxSapiAccountManager.mBoxAccount);
                        }
                        BdEventBus.Companion.getDefault().post(new UserInfoChangeEvent());
                    }
                }

                public void onFailure(BoxAccount.ErrorBean errorBean) {
                    IGetBoxAccountListener iGetBoxAccountListener = listener;
                    if (iGetBoxAccountListener != null) {
                        iGetBoxAccountListener.onFailed(errorBean.getErrorCode());
                    }
                }

                public void onBdussExpired(String msg) {
                    BoxSapiAccountManager.this.logout(new LogoutParams.Builder().setLogoutSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGOUT, UserAccountActionItem.UserAccountType.NATIVE, "get_bduss_expired")).build());
                    UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) msg).showToast();
                }
            });
        } else if (listener != null) {
            listener.onFailed(-3);
        }
    }

    public BoxAccount getBoxAccount() {
        JSONObject extJson;
        if (!isLogin()) {
            return null;
        }
        BoxAccount boxAccount = mBoxAccount;
        if (boxAccount != null) {
            boxAccount.bduss = getSession("BoxAccount_bduss");
            mBoxAccount.ptoken = getSession("BoxAccount_ptoken");
            mBoxAccount.uid = getSession("BoxAccount_uid");
            mBoxAccount.displayname = getSession("BoxAccount_displayname");
            return mBoxAccount;
        }
        BoxAccount boxAccount2 = new BoxAccount();
        mBoxAccount = boxAccount2;
        boxAccount2.bduss = getSession("BoxAccount_bduss");
        mBoxAccount.ptoken = getSession("BoxAccount_ptoken");
        mBoxAccount.uid = getSession("BoxAccount_uid");
        mBoxAccount.displayname = getSession("BoxAccount_displayname");
        mBoxAccount.setUk(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_UK, ""));
        mBoxAccount.portrait = BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_PORTRAIT, "");
        mBoxAccount.dynamicPortrait = BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_DYNAMIC_PORTRAIT, "");
        mBoxAccount.setOrnament(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_ORNAMENT, ""));
        mBoxAccount.setOrnamentId(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_ORNAMENT_ID, ""));
        mBoxAccount.setAvatarBig(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_AVATAR_BIG, ""));
        mBoxAccount.portraitSign = BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_PORTRAIT_SIGN, "");
        mBoxAccount.incompleteUser = BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_INCOMPLETE_USER, false);
        mBoxAccount.isInitialPortrait = BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_IS_INITAL_PORTRAIT, false);
        mBoxAccount.nickname = BoxAccountPreference.getAccountStringPreference("user_login_nickname_key", "");
        mBoxAccount.isLay = BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_ISLAY, "1");
        mBoxAccount.deadline = BoxAccountPreference.getAccountLongPreference(BoxAccountContants.ACCOUNT_DEADLINE, 0);
        mBoxAccount.expiryTime = BoxAccountPreference.getAccountIntPreference(BoxAccountContants.ACCOUNT_EXPIRYTIME, 90);
        mBoxAccount.setGender(BoxAccountPreference.getAccountIntPreference(BoxAccountContants.ACCOUNT_GENDER, -1));
        mBoxAccount.setVip(BoxAccountPreference.getAccountIntPreference(BoxAccountContants.ACCOUNT_VIP, -1));
        mBoxAccount.setMemberVip(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_MEMBER_VIP, ""));
        mBoxAccount.setBCArticle(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_BC_ARTICLE, ""));
        mBoxAccount.setAge(BoxAccountPreference.getAccountIntPreference(BoxAccountContants.ACCOUNT_AGE, -1));
        mBoxAccount.setSignature(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_SIGN, (String) null));
        mBoxAccount.setCity(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_CITY, (String) null));
        mBoxAccount.setHoroscope(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_HOROSCOPE, (String) null));
        mBoxAccount.setSearchByInterestSwitch(BoxAccountPreference.getAccountBooleanPreference("search_by_interest", false));
        mBoxAccount.setSearchByTelSwitch(BoxAccountPreference.getAccountBooleanPreference("search_by_tel", false));
        mBoxAccount.setAddressSwitch(BoxAccountPreference.getAccountBooleanPreference("address_switch", false));
        mBoxAccount.setUserType(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_USER_TYPE, "0"));
        mBoxAccount.setGuideNickDialogInterval(String.valueOf(BoxAccountPreference.getAccountLongPreference(BoxAccountContants.ACCOUNT_NICK_GUIDE_INTERVAL, 0)));
        mBoxAccount.setIsDefaultNick(BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_IS_DEFAULT_NICK, false));
        mBoxAccount.setPopType(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_POP_TYPE, "1"));
        mBoxAccount.setRecommendNick(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_RECOMMEND_NICK, ""));
        mBoxAccount.setShowComment(BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_SHOW_COMMENT_SWTICH, true));
        mBoxAccount.setAttentionFansSwitch(BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_SHOW_ATTENTION_FANS_SWITCH, true));
        try {
            extJson = new JSONObject(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_EXT_FIELDS, (String) null));
        } catch (Exception e2) {
            extJson = null;
        }
        if (extJson != null) {
            HashMap<String, String> extData = new HashMap<>();
            Iterator<String> keys = extJson.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                extData.put(next, extJson.optString(next));
            }
            mBoxAccount.setExtFields(extData);
        }
        try {
            mBoxAccount.getNickNameAudit().parse(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_NICK_AUDIT, ""));
            mBoxAccount.getSignatureAudit().parse(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_SIGN_AUDIT, ""));
        } catch (Exception e3) {
            LogUtils.e("getBoxAccount", "parse audit error " + e3.getMessage());
        }
        mBoxAccount.setShowType(BoxAccountPreference.getAccountIntPreference(BoxAccountContants.ACCOUNT_SHOW_TYPE, 0));
        mBoxAccount.setOperateWidgetNum(BoxAccountPreference.getAccountIntPreference(BoxAccountContants.ACCOUNT_OPERATE_WIDGET_NUM, 0));
        mBoxAccount.setUserWidgetNum(BoxAccountPreference.getAccountIntPreference("user_widget_num", 0));
        mBoxAccount.setNewFlag(BoxAccountPreference.getAccountBooleanPreference("new_flag", false));
        mBoxAccount.setIsChildAccount(BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_IS_CHILD, false));
        mBoxAccount.setShowGender(BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_IS_SHOW_GENDER, true));
        mBoxAccount.setShowCity(BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_IS_SHOW_CITY, true));
        mBoxAccount.setShowAge(BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_IS_SHOW_AGE, true));
        mBoxAccount.setShowStar(BoxAccountPreference.getAccountBooleanPreference(BoxAccountContants.ACCOUNT_IS_SHOW_STAR, true));
        mBoxAccount.setBirthday(BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_BIRTHDAY, ""));
        return mBoxAccount;
    }

    public List<String> getAuthorizedDomains(Context context) {
        return SapiUtils.getAuthorizedDomains();
    }

    public List<String> getAuthorizedDomainsForPtoken(Context context) {
        return SapiUtils.getAuthorizedDomainsForPtoken();
    }

    public String buildBDUSSCookie(String domain, String bduss) {
        return SapiUtils.buildBDUSSCookie(domain, bduss);
    }

    public String buildBDUSSBFESSCookie(String domain, String bduss) {
        return SapiUtils.buildBDUSSBFESSCookie(domain, bduss);
    }

    public String buildPtokenCookie(String domain, String ptoken) {
        LogUtils.writeOnlineLog(LogUtils.DATA_ID_PTOKEN, "tpl_stoken", "ptoken is null = " + TextUtils.isEmpty(ptoken), "buildPtokenCookie", true, true, LogUtils.canUploadPtokenLog() && TextUtils.isEmpty(ptoken));
        return SapiUtils.buildPtokenCookie(domain, ptoken);
    }

    public void loginStatusCheck(UserAccountActionItem src) {
        BoxSapiAccountSync.getInstance(AppRuntime.getAppContext()).syncCheck(src);
    }

    public boolean isWxAppInstalledAndSupported() {
        IWXAPI wxApi = WXAPIFactory.createWXAPI(AppRuntime.getAppContext(), (String) null);
        wxApi.registerApp(PassportDevelop.WX_APPID);
        return wxApi.isWXAppInstalled();
    }

    @Deprecated
    public void smsLoginGetDynamicPwd(String phoneNum, final OnGetDynamicPwdListener listener) {
        prepare();
        SapiAccountManager.getInstance().getAccountService().getDynamicPwd((SapiCallBack<SapiResponse>) new SapiCallBack<SapiResponse>() {
            public void onNetworkFailed() {
                OnGetDynamicPwdListener onGetDynamicPwdListener = listener;
                if (onGetDynamicPwdListener != null) {
                    onGetDynamicPwdListener.onNetworkFailed();
                }
            }

            public void onSuccess(SapiResponse arg0) {
                OnGetDynamicPwdListener onGetDynamicPwdListener = listener;
                if (onGetDynamicPwdListener != null) {
                    onGetDynamicPwdListener.onSuccess();
                }
            }

            public void onSystemError(int arg0) {
                OnGetDynamicPwdListener onGetDynamicPwdListener = listener;
                if (onGetDynamicPwdListener != null) {
                    onGetDynamicPwdListener.onSystemError(arg0);
                }
            }
        }, phoneNum);
    }

    public void smsLoginGetDynamicPwd(String phoneNum, String captcha, final OnGetDynamicPwdNeedCaptchaListener listener) {
        prepare();
        SapiAccountManager.getInstance().getAccountService().getDynamicPwd((GetDynamicPwdCallback) new GetDynamicPwdCallback() {
            public void onCaptchaRequired(GetDynamicPwdResult result) {
                OnGetDynamicPwdNeedCaptchaListener onGetDynamicPwdNeedCaptchaListener = listener;
                if (onGetDynamicPwdNeedCaptchaListener != null) {
                    onGetDynamicPwdNeedCaptchaListener.onCaptchaRequired(result);
                }
            }

            public void onFailure(GetDynamicPwdResult result) {
                OnGetDynamicPwdNeedCaptchaListener onGetDynamicPwdNeedCaptchaListener = listener;
                if (onGetDynamicPwdNeedCaptchaListener != null) {
                    onGetDynamicPwdNeedCaptchaListener.onFailure(result);
                }
            }

            public void onFinish() {
                OnGetDynamicPwdNeedCaptchaListener onGetDynamicPwdNeedCaptchaListener = listener;
                if (onGetDynamicPwdNeedCaptchaListener != null) {
                    onGetDynamicPwdNeedCaptchaListener.onFinish();
                }
            }

            public void onStart() {
                OnGetDynamicPwdNeedCaptchaListener onGetDynamicPwdNeedCaptchaListener = listener;
                if (onGetDynamicPwdNeedCaptchaListener != null) {
                    onGetDynamicPwdNeedCaptchaListener.onStart();
                }
            }

            public void onSuccess(GetDynamicPwdResult result) {
                OnGetDynamicPwdNeedCaptchaListener onGetDynamicPwdNeedCaptchaListener = listener;
                if (onGetDynamicPwdNeedCaptchaListener != null) {
                    onGetDynamicPwdNeedCaptchaListener.onSuccess(result);
                }
            }
        }, phoneNum, captcha);
    }

    public void getCaptcha(final OnGetCaptchaListener listener) {
        if (!TextUtils.isEmpty(SapiAccountManager.getInstance().getAccountService().getCaptchaKey())) {
            SapiAccountManager.getInstance().getAccountService().getCaptcha(new SapiCallback<GetCaptchaResult>() {
                public void onSuccess(GetCaptchaResult result) {
                    OnGetCaptchaListener onGetCaptchaListener = listener;
                    if (onGetCaptchaListener != null) {
                        onGetCaptchaListener.onSuccess(result);
                    }
                }

                public void onFailure(GetCaptchaResult result) {
                    OnGetCaptchaListener onGetCaptchaListener = listener;
                    if (onGetCaptchaListener != null) {
                        onGetCaptchaListener.onFailure(result);
                    }
                }

                public void onStart() {
                    OnGetCaptchaListener onGetCaptchaListener = listener;
                    if (onGetCaptchaListener != null) {
                        onGetCaptchaListener.onStart();
                    }
                }

                public void onFinish() {
                    listener.onFinish();
                }
            });
        }
    }

    public void smsLogin(String phoneNum, String pwd, final OnDynamicSmsLoginListener listener) {
        prepare();
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin((DynamicPwdLoginCallback) new DynamicPwdLoginCallback() {
            public void onFailure(DynamicPwdLoginResult result) {
                OnDynamicSmsLoginListener onDynamicSmsLoginListener = listener;
                if (onDynamicSmsLoginListener != null) {
                    onDynamicSmsLoginListener.onFailure(result);
                }
            }

            public void onFinish() {
                OnDynamicSmsLoginListener onDynamicSmsLoginListener = listener;
                if (onDynamicSmsLoginListener != null) {
                    onDynamicSmsLoginListener.onFinish();
                }
            }

            public void onStart() {
                OnDynamicSmsLoginListener onDynamicSmsLoginListener = listener;
                if (onDynamicSmsLoginListener != null) {
                    onDynamicSmsLoginListener.onStart();
                }
            }

            public void onSuccess(DynamicPwdLoginResult arg0) {
                if (listener != null) {
                    BoxSapiAccountSync.getInstance(BoxSapiAccountManager.this.mContext).boxLoginSync(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "sms_nalogin"));
                    listener.onSuccess();
                }
            }
        }, phoneNum, pwd);
    }

    @Deprecated
    public void smsLogin(String phoneNum, String pwd, final OnSmsLoginListener listener) {
        prepare();
        SapiAccountManager.getInstance().getAccountService().dynamicPwdLogin((SapiCallBack<SapiAccountResponse>) new SapiCallBack<SapiAccountResponse>() {
            public void onNetworkFailed() {
                OnSmsLoginListener onSmsLoginListener = listener;
                if (onSmsLoginListener != null) {
                    onSmsLoginListener.onNetworkFailed();
                }
            }

            public void onSuccess(SapiAccountResponse arg0) {
                if (listener != null) {
                    BoxSapiAccountSync.getInstance(BoxSapiAccountManager.this.mContext).boxLoginSync(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "sms_nalogin"));
                    listener.onSuccess();
                }
            }

            public void onSystemError(int arg0) {
                OnSmsLoginListener onSmsLoginListener = listener;
                if (onSmsLoginListener != null) {
                    onSmsLoginListener.onSystemError(arg0);
                }
            }
        }, phoneNum, pwd);
    }

    private void localConfig(LoginParams params) {
        prepare();
        BiometricsManager.getInstance();
        SapiAccountManager.getInstance().getConfignation().isNightMode = NightModeHelper.getNightModeSwitcherState();
        SapiAccountManager.getInstance().getConfignation().smsLoginConfig.flagHideExtraEntry = Switch.OFF;
        if (params != null) {
            String customLoginCss = params.mCustomLoginCss;
            if (!TextUtils.isEmpty(customLoginCss)) {
                SapiAccountManager.getInstance().getConfignation().skin = customLoginCss;
            } else {
                SapiAccountManager.getInstance().getConfignation().skin = PassSapiHelper.CUSTOM_THEME_URL;
            }
            PassSapiHelper.configTitle();
        }
    }

    public BoxCookieSession getCookieSession() {
        if (this.mCookieSession == null) {
            this.mCookieSession = new BoxCookieSession(getContext());
        }
        return this.mCookieSession;
    }

    public BoxLocalSession getLocalSession() {
        if (this.mLocalSession == null) {
            this.mLocalSession = new BoxLocalSession(getContext());
        }
        return this.mLocalSession;
    }

    public BoxOneKeyLoginResult getLocalOneKeyInfo() {
        return mLocalOneKeyResult;
    }

    public void checkBind(IAccountQueryListener listener) {
        if (listener != null) {
            if (!isLogin(2)) {
                JSONObject data = new JSONObject();
                try {
                    data.put("bind", false);
                    listener.onSuccess(data);
                } catch (JSONException e2) {
                    LogUtils.e(AccountBindRequest.TAG);
                }
            }
            new AccountBindRequest().checkBind(listener);
        }
    }

    public void getUserLevelInfo(IAccountQueryListener listener) {
        if (listener != null) {
            if (!isLogin(2)) {
                BoxAccount boxAccount = new BoxAccount();
                boxAccount.getErrorBean().setErrorCode(-100);
                listener.onFailed(boxAccount.getErrorBean());
            }
            new AccountPublicGetRequest().getUserLevelInfo(listener);
        }
    }

    public BoxSapiSession getSapiSession() {
        if (this.mSapiSession == null) {
            this.mSapiSession = new BoxSapiSession(getContext());
        }
        return this.mSapiSession;
    }

    /* access modifiers changed from: protected */
    public void clearAccountInfo() {
        BoxAccountPreference.clear();
    }

    public void prefetchLocalOneKeyInfo() {
        if (!isLogin(2) && mLocalOneKeyResult == null && !sHasPrefetched) {
            sHasPrefetched = true;
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    BoxSapiAccountManager.this.getOneKeyLoginInfo(new IOneKeyLoginCallback() {
                        public void onResult(BoxOneKeyLoginResult result) {
                            BoxOneKeyLoginResult unused = BoxSapiAccountManager.mLocalOneKeyResult = result;
                        }
                    });
                }
            }, "prefetchLocalOneKeyInfo", 1);
        }
    }

    public void updateLocalOneKeyInfo() {
        BoxOneKeyLoginResult boxOneKeyLoginResult = mLocalOneKeyResult;
        if (boxOneKeyLoginResult == null || !boxOneKeyLoginResult.isEnable()) {
            ExecutorUtilsExt.postOnSerial(new Runnable() {
                public void run() {
                    AccountUBCHelperKt.statisticUBCGetOneKeyInfo("coldstart", BoxAccountContants.LOGIN_TYPE_YUQUHAO, (String) null, (String) null);
                    BoxSapiAccountManager.this.getOneKeyLoginInfo(new IOneKeyLoginCallback() {
                        public void onResult(BoxOneKeyLoginResult result) {
                            BoxOneKeyLoginResult unused = BoxSapiAccountManager.mLocalOneKeyResult = result;
                            if (!result.isEnable()) {
                                int resultCode = -1;
                                if (result != null) {
                                    resultCode = result.getResultCode();
                                }
                                AccountUBCHelperKt.statisticUBCGetOneKeyInfo("coldstart", "yuquhao_fail", Integer.toString(resultCode), (String) null);
                            }
                        }
                    });
                }
            }, "getOneKeyData");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateLocalOneKeyInfo(com.baidu.sapi2.result.OneKeyLoginResult r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0072
            boolean r0 = r4.enable     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x0072
            com.baidu.searchbox.account.result.BoxOneKeyLoginResult r0 = mLocalOneKeyResult     // Catch:{ all -> 0x0066 }
            boolean r1 = r4.enable     // Catch:{ all -> 0x0066 }
            r0.setEnable(r1)     // Catch:{ all -> 0x0066 }
            com.baidu.searchbox.account.result.BoxOneKeyLoginResult r0 = mLocalOneKeyResult     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = r4.operator     // Catch:{ all -> 0x0066 }
            r0.setOperatorType(r1)     // Catch:{ all -> 0x0066 }
            com.baidu.searchbox.account.result.BoxOneKeyLoginResult r0 = mLocalOneKeyResult     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = r4.encryptPhoneNum     // Catch:{ all -> 0x0066 }
            r0.setEncryptPhoneNum(r1)     // Catch:{ all -> 0x0066 }
            com.baidu.searchbox.account.result.BoxOneKeyLoginResult r0 = mLocalOneKeyResult     // Catch:{ all -> 0x0066 }
            boolean r1 = r4.hasHistory     // Catch:{ all -> 0x0066 }
            r0.setHasHistory(r1)     // Catch:{ all -> 0x0066 }
            java.lang.String r0 = r4.operator     // Catch:{ all -> 0x0066 }
            r1 = -1
            int r2 = r0.hashCode()     // Catch:{ all -> 0x0066 }
            switch(r2) {
                case 2154: goto L_0x0041;
                case 2161: goto L_0x0037;
                case 2162: goto L_0x002d;
                default: goto L_0x002c;
            }     // Catch:{ all -> 0x0066 }
        L_0x002c:
            goto L_0x004a
        L_0x002d:
            java.lang.String r2 = "CU"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x002c
            r1 = 1
            goto L_0x004a
        L_0x0037:
            java.lang.String r2 = "CT"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x002c
            r1 = 2
            goto L_0x004a
        L_0x0041:
            java.lang.String r2 = "CM"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x002c
            r1 = 0
        L_0x004a:
            switch(r1) {
                case 0: goto L_0x005e;
                case 1: goto L_0x0056;
                case 2: goto L_0x004e;
                default: goto L_0x004d;
            }     // Catch:{ all -> 0x0066 }
        L_0x004d:
            goto L_0x0072
        L_0x004e:
            com.baidu.searchbox.account.result.BoxOneKeyLoginResult r0 = mLocalOneKeyResult     // Catch:{ all -> 0x0066 }
            r1 = 14
            r0.setLoginMode(r1)     // Catch:{ all -> 0x0066 }
            goto L_0x0072
        L_0x0056:
            com.baidu.searchbox.account.result.BoxOneKeyLoginResult r0 = mLocalOneKeyResult     // Catch:{ all -> 0x0066 }
            r1 = 13
            r0.setLoginMode(r1)     // Catch:{ all -> 0x0066 }
            goto L_0x0072
        L_0x005e:
            com.baidu.searchbox.account.result.BoxOneKeyLoginResult r0 = mLocalOneKeyResult     // Catch:{ all -> 0x0066 }
            r1 = 12
            r0.setLoginMode(r1)     // Catch:{ all -> 0x0066 }
            goto L_0x0072
        L_0x0066:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "updateLocalOneKey"
            com.baidu.android.app.account.utils.LogUtils.e((java.lang.String) r2, (java.lang.String) r1)
            goto L_0x0073
        L_0x0072:
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.app.account.BoxSapiAccountManager.updateLocalOneKeyInfo(com.baidu.sapi2.result.OneKeyLoginResult):void");
    }

    public void getAccessToken(String bduss, final ISapiCallback<BoxOauthResult> accessTokenCallback, boolean forceRefresh) {
        if (accessTokenCallback != null) {
            if (TextUtils.isEmpty(bduss)) {
                BoxOauthResult result = new BoxOauthResult();
                result.setResultCode(-301);
                result.setResultMsg("bduss 本地不存在");
                accessTokenCallback.onFailure(result);
            }
            SapiAccountManager.getInstance().getAccountService().oauthAccessToken(new SapiCallback<OAuthResult>() {
                public void onSuccess(OAuthResult oAuthResult) {
                    accessTokenCallback.onSuccess(BoxSapiAccountManager.this.getAccessTokenResult(oAuthResult));
                }

                public void onFailure(OAuthResult oAuthResult) {
                    accessTokenCallback.onFailure(BoxSapiAccountManager.this.getAccessTokenResult(oAuthResult));
                }

                public void onStart() {
                    accessTokenCallback.onStart();
                }

                public void onFinish() {
                    accessTokenCallback.onFinish();
                }
            }, bduss, BoxAccountRuntime.getAccountConfig().getYYApiKey(), forceRefresh);
        }
    }

    /* access modifiers changed from: private */
    public BoxOauthResult getAccessTokenResult(OAuthResult oAuthResult) {
        if (oAuthResult == null) {
            return null;
        }
        BoxOauthResult result = new BoxOauthResult();
        result.accessToken = oAuthResult.accessToken;
        result.setResultCode(oAuthResult.getResultCode());
        result.setResultMsg(oAuthResult.getResultMsg());
        return result;
    }

    public void getTplStoken(final IGetTplStokenCallback onGetTplStokenCallback, String bduss, List<String> tpls) {
        if (!TextUtils.isEmpty(bduss)) {
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() {
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (onGetTplStokenCallback != null) {
                        OnGetTplStokenResult result = new OnGetTplStokenResult();
                        if (getTplStokenResult != null) {
                            result.mStokens = getTplStokenResult.tplStokenMap;
                            result.mErrCode = getTplStokenResult.getResultCode();
                            result.mErrMsg = getTplStokenResult.getResultMsg();
                            if (getTplStokenResult.failureType != null) {
                                result.mFailureType = getTplStokenResult.failureType.name();
                            }
                        }
                        onGetTplStokenCallback.onSuccess(result);
                    }
                }

                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    if (onGetTplStokenCallback != null) {
                        OnGetTplStokenResult result = new OnGetTplStokenResult();
                        if (getTplStokenResult != null) {
                            result.mStokens = getTplStokenResult.tplStokenMap;
                            result.mErrCode = getTplStokenResult.getResultCode();
                            result.mErrMsg = getTplStokenResult.getResultMsg();
                            if (getTplStokenResult.failureType != null) {
                                result.mFailureType = getTplStokenResult.failureType.name();
                            }
                        }
                        onGetTplStokenCallback.onFailure(result);
                    }
                }

                public void onStart() {
                    IGetTplStokenCallback iGetTplStokenCallback = onGetTplStokenCallback;
                    if (iGetTplStokenCallback != null) {
                        iGetTplStokenCallback.onStart();
                    }
                }

                public void onFinish() {
                    IGetTplStokenCallback iGetTplStokenCallback = onGetTplStokenCallback;
                    if (iGetTplStokenCallback != null) {
                        iGetTplStokenCallback.onFinish();
                    }
                }
            }, bduss, tpls);
        } else if (onGetTplStokenCallback != null) {
            OnGetTplStokenResult result = new OnGetTplStokenResult();
            result.mErrCode = -301;
            result.mErrMsg = "bduss 本地不存在";
            onGetTplStokenCallback.onFailure(result);
        }
    }

    public void setThirdLoginSwitch(int thirdLoginSwitch) {
        DefaultSharedPrefsWrapper.getInstance().putInt("account_third_login_switch", thirdLoginSwitch);
    }

    public void startAccountNickNameActivity(Activity activity, String source, String nicknameText, int requestCode) {
        BoxAccountManager mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (mLoginManager.isLogin(2)) {
            editNickName(activity, source, nicknameText, requestCode);
            return;
        }
        final BoxAccountManager boxAccountManager = mLoginManager;
        final Activity activity2 = activity;
        final String str = source;
        final String str2 = nicknameText;
        final int i2 = requestCode;
        mLoginManager.combineLogin(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "hudong_personalprofile")).build(), 2, new ILoginResultListener() {
            public void onResult(int resultCode) {
                if (boxAccountManager.isLogin(2)) {
                    BoxSapiAccountManager.this.editNickName(activity2, str, str2, i2);
                }
            }
        });
    }

    public void startAccountUserInfoEditActivity(Activity activity, Bundle bundle, int requestCode) {
        BoxAccountManager mLoginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (mLoginManager.isLogin(2)) {
            Intent intent = new Intent(activity, AccountUserInfoEditActivity.class);
            intent.putExtras(bundle);
            activity.startActivityForResult(intent, requestCode);
            return;
        }
        final BoxAccountManager boxAccountManager = mLoginManager;
        final Activity activity2 = activity;
        final Bundle bundle2 = bundle;
        final int i2 = requestCode;
        mLoginManager.combineLogin(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "hudong_personalprofile")).build(), 2, new ILoginResultListener() {
            public void onResult(int resultCode) {
                if (boxAccountManager.isLogin(2)) {
                    Intent intent = new Intent(activity2, AccountUserInfoEditActivity.class);
                    intent.putExtras(bundle2);
                    activity2.startActivityForResult(intent, i2);
                }
            }
        });
    }

    public void showNickNameGuideDialog(Activity activity, String source) {
        NickNameDialogManager.showShareLoginDialog(activity, source, (INickNameGuideDialogListener) null);
    }

    public void showNickNameGuideDialog(Activity activity, String source, INickNameGuideDialogListener listener) {
        NickNameDialogManager.showShareLoginDialog(activity, source, listener);
    }

    public void showNickNameGuideDialog(Activity activity, int nicknameDialogType, String source, INickNameGuideDialogListener listener) {
        NickNameDialogManager.showShareLoginDialog(activity, nicknameDialogType, source, listener);
    }

    public void showNickNameGuideDialogWithActivity(Activity activity, String source, int requestCode) {
        showNickNameGuideDialogWithActivity(activity, -1, source, requestCode);
    }

    public void showNickNameGuideDialogWithActivity(Activity activity, int nicknameDialogType, String source, int requestCode) {
        try {
            Intent intent = new Intent(activity, NickNameDialogActivity.class);
            intent.putExtra(NickNameDialogActivity.KEY_DIALOG_TYPE, nicknameDialogType);
            intent.putExtra("source", source);
            activity.startActivityForResult(intent, requestCode);
        } catch (Exception ex) {
            LogUtils.e(TAG, ex.toString());
        }
    }

    public void dismissNickNameGuideDialog() {
        NickNameDialogManager.dismissDialog();
    }

    public int nickGuideDialogShowStatus() {
        BoxAccount boxAccount = getBoxAccount();
        if (!isLogin(2)) {
            return NickNameGuideErrorCode.NO_SUPPORT_GUEST_LOGIN;
        }
        if (!boxAccount.isDefaultNick()) {
            return NickNameGuideErrorCode.NO_DEFAULT_NICKNAME;
        }
        if ((System.currentTimeMillis() / 1000) - NickNameDialogManager.getLastTime() < boxAccount.getGuideNickDialogInterval()) {
            return NickNameGuideErrorCode.UNARRIVED_TIME_INTERVAL;
        }
        return 0;
    }

    public int nickGuideDialogShowStatus(int nicknameDialogType) {
        int i2 = nicknameDialogType;
        BoxAccount boxAccount = getBoxAccount();
        if (!isLogin(2)) {
            return NickNameGuideErrorCode.NO_SUPPORT_GUEST_LOGIN;
        }
        if (!boxAccount.isDefaultNick()) {
            return NickNameGuideErrorCode.NO_DEFAULT_NICKNAME;
        }
        long currentTime = System.currentTimeMillis() / 1000;
        long lastTime = NickNameDialogManager.getLastTime();
        long nickDialogInterval = 0;
        if (i2 == 0) {
            nickDialogInterval = NickNameDialogManager.getNickNameDistributeInterval();
        } else if (i2 == 1) {
            nickDialogInterval = NickNameDialogManager.getNickNameRecommendInterval();
        }
        if (currentTime - lastTime < nickDialogInterval) {
            return NickNameGuideErrorCode.UNARRIVED_TIME_INTERVAL;
        }
        long times = NickNameDialogManager.getShowCount();
        long maxTimes = NickNameDialogManager.getMaxShowGuideTimes();
        long notShowInterval = NickNameDialogManager.getNotShowGuideInterval();
        if (times < maxTimes || currentTime - lastTime >= notShowInterval) {
            return 0;
        }
        return NickNameGuideErrorCode.UNARRIVED_TIME_INTERVAL;
    }

    /* access modifiers changed from: private */
    public void editNickName(Activity activity, String source, String nicknameText, int requestCode) {
        BoxAccount boxAccount = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getBoxAccount();
        if (NickNameDialogManager.checkNickModifyDurationAndTimes(boxAccount)) {
            Intent intent = new Intent(activity, AccountNickNameActivity.class);
            intent.putExtra(AccountNickNameActivity.EXTRA_DATA_NICKNAME_KEY, nicknameText);
            intent.putExtra(AccountNickNameActivity.PAGE_SRC, source);
            activity.startActivityForResult(intent, requestCode);
            return;
        }
        new BoxAlertDialog.Builder(activity).setTitle((CharSequence) activity.getResources().getString(R.string.account_login_dialog_needback_title)).setMessage(activity.getResources().getString(R.string.account_user_info_hint_exceed) + boxAccount.getNickModifyDurationOfDay() + activity.getResources().getString(R.string.account_user_info_hint_end_two)).setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setNegativeButton((CharSequence) null, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setNeutralButton((CharSequence) activity.getResources().getString(R.string.account_user_info_dialog_neutralbtn), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        }).show();
    }

    public int getNickNamePortraitType() {
        return NickNameDialogManager.getNickNamePortraitType();
    }

    public void showNicknamePortraitDialog(Activity activity, NicknamePortraitConfig config, INickNamePortraitDialogCallback callback) {
        NickNameDialogManager.showNicknamePortraitDialog(activity, config, callback);
    }

    public boolean isShow(int index) {
        return ThirdLoginUtils.isShow(index);
    }

    public void verifyUserFaceId(Context context, String businessSence, final IVerifyUserFaceIDListener verifyUserFaceIDListener) {
        FaceIDVerifyDTO verifyDTO = new FaceIDVerifyDTO();
        verifyDTO.businessSence = businessSence;
        if (SapiAccountManager.getInstance().getSession() != null) {
            verifyDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
        }
        if (context instanceof Activity) {
            PassportSDK.getInstance().verifyUserFaceId((Activity) context, new VerifyUserFaceIDCallback() {
                public void onSuccess(SapiResult result) {
                    if (verifyUserFaceIDListener != null) {
                        SearchBoxRealNameResult searchBoxRealNameResult = new SearchBoxRealNameResult();
                        if (result instanceof RealNameFaceIDResult) {
                            searchBoxRealNameResult.callbackkey = ((RealNameFaceIDResult) result).callBackKey;
                            verifyUserFaceIDListener.onSuccess(searchBoxRealNameResult);
                        } else if (result instanceof UnRealNameFaceIDResult) {
                            searchBoxRealNameResult.callbackkey = ((UnRealNameFaceIDResult) result).registerResult;
                            verifyUserFaceIDListener.onSuccess(searchBoxRealNameResult);
                        }
                    }
                }

                public void onFailure(SapiResult result) {
                    IVerifyUserFaceIDListener iVerifyUserFaceIDListener = verifyUserFaceIDListener;
                    if (iVerifyUserFaceIDListener != null) {
                        iVerifyUserFaceIDListener.onFailure(result.getResultCode(), result.getResultMsg());
                    }
                }
            }, verifyDTO);
        }
    }

    public void verifyUserFaceId(Activity context, String subpro, String name, String idCardNo, final IVerifyUserFaceIDListener verifyUserFaceIDListener) {
        FaceIDVerifyCertInfoDTO dto = new FaceIDVerifyCertInfoDTO();
        dto.subpro = subpro;
        dto.realName = name;
        dto.idCardNo = idCardNo;
        PassportSDK.getInstance().verifyUserFaceIDWithCertInfo(context, new PassFaceRecogCallback() {
            public void onSuccess(PassFaceRecogResult result) {
                if (verifyUserFaceIDListener != null) {
                    SearchBoxRealNameResult searchBoxRealNameResult = new SearchBoxRealNameResult();
                    searchBoxRealNameResult.callbackkey = result.callbackkey;
                    verifyUserFaceIDListener.onSuccess(searchBoxRealNameResult);
                }
            }

            public void onFailure(PassFaceRecogResult result) {
                IVerifyUserFaceIDListener iVerifyUserFaceIDListener = verifyUserFaceIDListener;
                if (iVerifyUserFaceIDListener != null) {
                    iVerifyUserFaceIDListener.onFailure(result.getResultCode(), result.getResultMsg());
                }
            }
        }, dto);
    }

    public void checkUSerFaceId(Context context, final ICheckUserFaceIdCallback callback) {
        if (isLogin(2)) {
            SapiAccountManager.getInstance().getAccountService().checkUserFaceId(new SapiCallback<CheckUserFaceIdResult>() {
                public void onSuccess(CheckUserFaceIdResult result) {
                    JSONObject ret = new JSONObject();
                    try {
                        ret.put("liveingUname", result.livingUname);
                        ret.put(BoxAccountContants.AUTH_SID, result.authsid);
                        ret.put(BoxAccountContants.AUTH_WIDGET_URL, result.authWidgetURL);
                        ret.put(BoxAccountContants.FACE_LOGIN_SWITCH, result.faceLoginSwitch);
                        ret.put("action", result.action);
                        ret.put("codeCheckUserFaceid", result.status);
                        ret.put("msgCheckUserFaceid", result.getResultMsg());
                    } catch (Exception e2) {
                        ICheckUserFaceIdCallback iCheckUserFaceIdCallback = callback;
                        if (iCheckUserFaceIdCallback != null) {
                            iCheckUserFaceIdCallback.onFailure(-200, result.getResultMsg());
                        }
                        LogUtils.e("realname", "onSuccess error" + e2.getMessage());
                    }
                    ICheckUserFaceIdCallback iCheckUserFaceIdCallback2 = callback;
                    if (iCheckUserFaceIdCallback2 != null) {
                        iCheckUserFaceIdCallback2.onSuccess(ret);
                    }
                }

                public void onFailure(CheckUserFaceIdResult result) {
                    ICheckUserFaceIdCallback iCheckUserFaceIdCallback = callback;
                    if (iCheckUserFaceIdCallback != null && result != null) {
                        iCheckUserFaceIdCallback.onFailure(result.getResultCode(), result.getResultMsg());
                    }
                }

                public void onStart() {
                }

                public void onFinish() {
                }
            }, getBoxAccount().bduss, (Map<String, String>) null);
        } else if (callback != null) {
            callback.onFailure(-100, context.getResources().getString(R.string.account_no_login_hint));
        }
    }

    public void loadAccountRealName(Context context, String businessScene, IVerifyUserFaceIDListener accountRealNameListener) {
        loadAccountRealName(context, businessScene, 0, accountRealNameListener);
    }

    public void loadAccountRealName(Context context, String businessScene, int realNameLevel, final IVerifyUserFaceIDListener accountRealNameListener) {
        if (isLogin(0)) {
            RealNameDTO realNameDTO = new RealNameDTO();
            if (SapiAccountManager.getInstance().getSession() != null) {
                realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            }
            realNameDTO.scene = businessScene;
            realNameDTO.needCbKey = true;
            realNameDTO.realNameLevel = realNameLevel;
            PassportSDK.getInstance().loadAccountRealName(context, new AccountRealNameCallback() {
                public void onFinish(AccountRealNameResult result) {
                    super.onFinish(result);
                    if (accountRealNameListener != null) {
                        if (result.getResultCode() == 0) {
                            SearchBoxRealNameResult searchBoxRealNameResult = new SearchBoxRealNameResult();
                            if (result.seniorRealNameSuc) {
                                searchBoxRealNameResult.callbackkey = result.callbackkey;
                                searchBoxRealNameResult.seniorRealNameSuc = true;
                                accountRealNameListener.onSuccess(searchBoxRealNameResult);
                                return;
                            } else if (result.juniorRealNameSuc) {
                                searchBoxRealNameResult.callbackkey = result.callbackkey;
                                searchBoxRealNameResult.juniorRealNameSuc = true;
                                accountRealNameListener.onSuccess(searchBoxRealNameResult);
                                return;
                            }
                        }
                        accountRealNameListener.onFailure(result.getResultCode(), result.getResultMsg());
                    }
                }
            }, realNameDTO);
        } else if (accountRealNameListener != null) {
            accountRealNameListener.onFailure(-1, context.getResources().getString(R.string.account_no_login_hint));
        }
    }

    public void loadAccountRealNameForSwan(Context context, String businessScene, int realNameLevel, final IVerifyUserFaceIDForSwanListener listener) {
        final SearchBoxRealNameResult searchBoxRealNameResult = new SearchBoxRealNameResult();
        if (isLogin(0)) {
            RealNameDTO realNameDTO = new RealNameDTO();
            if (SapiAccountManager.getInstance().getSession() != null) {
                realNameDTO.bduss = SapiAccountManager.getInstance().getSession().bduss;
            }
            realNameDTO.scene = businessScene;
            realNameDTO.needCbKey = true;
            realNameDTO.realNameLevel = realNameLevel;
            PassportSDK.getInstance().loadAccountRealName(context, new AccountRealNameCallback() {
                public void onFinish(AccountRealNameResult result) {
                    super.onFinish(result);
                    if (listener != null) {
                        searchBoxRealNameResult.callbackkey = result.callbackkey;
                        searchBoxRealNameResult.seniorRealNameSuc = result.seniorRealNameSuc;
                        searchBoxRealNameResult.juniorRealNameSuc = result.juniorRealNameSuc;
                        searchBoxRealNameResult.resultCode = result.getResultCode();
                        searchBoxRealNameResult.resultMsg = result.getResultMsg();
                        searchBoxRealNameResult.subResultCode = result.subResultCode;
                        searchBoxRealNameResult.subResultMsg = result.subResultMsg;
                        listener.onResult(searchBoxRealNameResult);
                    }
                }
            }, realNameDTO);
        } else if (listener != null) {
            searchBoxRealNameResult.resultCode = -1;
            searchBoxRealNameResult.resultMsg = context.getResources().getString(R.string.account_no_login_hint);
            listener.onResult(searchBoxRealNameResult);
        }
    }

    public void loadModifyPwd(final IWebModifyPwdCallback callback) {
        if (!TextUtils.isEmpty(getBoxAccount().getBduss())) {
            AccountToolsDTO accountToolsDTO = new AccountToolsDTO();
            accountToolsDTO.context = getContext();
            accountToolsDTO.toolsType = 5;
            PassportSDK.getInstance().loadAccountTools(accountToolsDTO, new AccountToolsCallback() {
                public void onFinish(SapiResult result) {
                    BoxSapiResult modifyPwdResult = new BoxSapiResult();
                    modifyPwdResult.setResultCode(result.getResultCode());
                    modifyPwdResult.setResultMsg(result.getResultMsg());
                    callback.onFinish(modifyPwdResult);
                }
            });
        }
    }

    public void loadAccountPage(Context context, int type, String source, IAccountToolsCallback callback) {
        switch (type) {
            case 1:
                loadAccountTools(context, 4, callback);
                return;
            case 2:
                loadAccountTools(context, 3, callback);
                return;
            case 4:
                Router.invoke(AppRuntime.getAppContext(), AccountConstants.easyBrowserScheme + getEncodeUrl(URL_PASS_AUTH_DETAIL + BoxLocalSessionManager.getInstance().getUK() + "#/detail"));
                return;
            case 5:
                PassportSDK.getInstance().loadBindInfo(context, BindInfoAction.BIND_MOBILE);
                return;
            case 6:
                PassportSDK.getInstance().loadBindInfo(context, BindInfoAction.BIND_EMAIL);
                return;
            case 7:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                int accountPage = getPassAccountPageType(type);
                if (accountPage != -1) {
                    loadAccountTools(context, accountPage, callback);
                    return;
                }
                return;
            case 8:
                if (isUserTypeBaijiahao()) {
                    Router.invoke(AppRuntime.getAppContext(), SCHEME_BJH_H5);
                    return;
                } else {
                    context.startActivity(new Intent(context, AccountUserInfoEditActivity.class));
                    return;
                }
            case 11:
                ChangeUserNameDTO dto = new ChangeUserNameDTO();
                dto.extraParams = new HashMap<>(1);
                dto.extraParams.put("source", source);
                PassportSDK.getInstance().loadChangeUsername(context, dto, new ChangeUsernameCallback() {
                    public void onFinish(ChangeUsernameResult result) {
                        super.onFinish(result);
                    }

                    public void onOpenDuVipPay(LoadDuVipPayCallBack loadDuVipPayCallBack) {
                        BoxSapiAccountManager.this.buyVipCommon(loadDuVipPayCallBack);
                    }
                });
                return;
            default:
                return;
        }
    }

    private int getPassAccountPageType(int type) {
        HashMap<Integer, Integer> pageMap = new HashMap<>();
        pageMap.put(12, 5);
        pageMap.put(13, 6);
        pageMap.put(14, 7);
        pageMap.put(15, 9);
        pageMap.put(16, 10);
        pageMap.put(17, 11);
        pageMap.put(18, 1);
        pageMap.put(7, 8);
        Integer page = pageMap.get(Integer.valueOf(type));
        if (page != null) {
            return page.intValue();
        }
        return -1;
    }

    public void buyVipCommon(final LoadDuVipPayCallBack loadDuVipPayCallBack) {
        final JSONObject result = new JSONObject();
        VipBuyUtilsKt.buyVipCommon(VipBuyUtilsKt.PURCHASE_DU_VIP_SCHEME_UPDATEUSERNAME, 1, new Function0<Unit>() {
            public Unit invoke() {
                try {
                    result.put("error_code", 1);
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
                loadDuVipPayCallBack.onFinish(result.toString());
                return null;
            }
        }, new Function1<Integer, Unit>() {
            public Unit invoke(Integer errorCode) {
                try {
                    result.put("error_code", errorCode);
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
                loadDuVipPayCallBack.onFinish(result.toString());
                return null;
            }
        });
    }

    public void loadAccountPage(Context context, int type, String source, IAccountToolsCallback toolsCallback, final IAuthWidgetCallback authWidgetCallback, JSONObject jsonObject) {
        switch (type) {
            case 3:
            case 10:
                Intent intent = new Intent(context, AccountCenterProxyActivity.class);
                if (type == 3) {
                    intent.putExtra(AccountCenterProxyActivity.KEY_ACCOUNT_CENTER_REFER, AccountCenterProxyActivity.BOX_ACCOUNT_REFER_ACCOUNT_CENTER);
                } else {
                    intent.putExtra(AccountCenterProxyActivity.KEY_ACCOUNT_CENTER_REFER, AccountCenterProxyActivity.BOX_ACCOUNT_REFER_ACCOUNT_CHECK);
                }
                intent.putExtra(AccountCenterProxyActivity.KEY_ACCOUNT_EXT_PARAMS, genPassParams(source, jsonObject));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
                return;
            case 9:
                if (jsonObject != null) {
                    String authId = jsonObject.optString("authid");
                    String scene = jsonObject.optString("scene");
                    if (!TextUtils.isEmpty(authId) && !TextUtils.isEmpty(scene)) {
                        PassportSDK.getInstance().startSpeciallyAuthWidget(new AuthWidgetCallback<SapiResult>() {
                            public void onSuccess(String content) {
                                IAuthWidgetCallback iAuthWidgetCallback = authWidgetCallback;
                                if (iAuthWidgetCallback != null) {
                                    iAuthWidgetCallback.onSuccess(content);
                                }
                            }

                            public void onFailure(SapiResult sapiResult) {
                                IAuthWidgetCallback iAuthWidgetCallback = authWidgetCallback;
                                if (iAuthWidgetCallback == null) {
                                    return;
                                }
                                if (sapiResult != null) {
                                    BoxSapiResult result = new BoxSapiResult();
                                    result.setResultCode(sapiResult.getResultCode());
                                    result.setResultMsg(sapiResult.getResultMsg());
                                    authWidgetCallback.onFailure(result);
                                    return;
                                }
                                iAuthWidgetCallback.onFailure((BoxSapiResult) null);
                            }
                        }, authId, scene);
                        return;
                    } else if (authWidgetCallback != null) {
                        authWidgetCallback.onFailure((BoxSapiResult) null);
                        return;
                    } else {
                        return;
                    }
                } else if (authWidgetCallback != null) {
                    authWidgetCallback.onFailure((BoxSapiResult) null);
                    return;
                } else {
                    return;
                }
            default:
                loadAccountPage(context, type, source, toolsCallback);
                return;
        }
    }

    private String genPassParams(String source, JSONObject jsonObject) {
        try {
            JSONObject clientParamsObj = new JSONObject();
            if (jsonObject != null && jsonObject.has(BoxAccountContants.KEY_CLIENT_PARAMS)) {
                clientParamsObj = jsonObject.getJSONObject(BoxAccountContants.KEY_CLIENT_PARAMS);
            }
            if (!clientParamsObj.has("source")) {
                clientParamsObj.put("source", source);
            }
            return clientParamsObj.toString();
        } catch (JSONException e2) {
            if (!AppConfig.isDebug()) {
                return "";
            }
            e2.printStackTrace();
            return "";
        }
    }

    private boolean isUserTypeBaijiahao() {
        BoxAccount boxAccount = getBoxAccount();
        if (boxAccount != null) {
            return TextUtils.equals(boxAccount.getUserType(), "1");
        }
        return false;
    }

    private String getPassTpl() {
        IAccountConfig accountConfig = BoxAccountRuntime.getAccountConfig();
        if (accountConfig != null) {
            return accountConfig.getPassTpl();
        }
        return null;
    }

    private String getEncodeUrl(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return url;
        }
    }

    private void loadAccountTools(Context context, int toolsType, final IAccountToolsCallback callback) {
        AccountToolsDTO accountToolsDTO = new AccountToolsDTO();
        accountToolsDTO.context = context;
        accountToolsDTO.toolsType = toolsType;
        PassportSDK.getInstance().loadAccountTools(accountToolsDTO, new AccountToolsCallback() {
            public void onFinish(SapiResult result) {
                if (callback != null) {
                    BoxSapiResult sapiResult = new BoxSapiResult();
                    sapiResult.setResultCode(result.getResultCode());
                    sapiResult.setResultMsg(result.getResultMsg());
                    callback.onFinish(sapiResult);
                }
            }
        });
    }

    public void loadSwitchAccountPage() {
        SapiAccountManager.getInstance().getConfignation().isNightMode = NightModeHelper.getNightModeSwitcherState();
        PassSapiHelper.configTitle();
        SwitchAccountDTO switchAccountDTO = new SwitchAccountDTO();
        switchAccountDTO.supportQueryAssociatedAccount = false;
        PassportSDK.getInstance().loadSwitchAccount(switchAccountDTO, new WebAuthListener() {
            public void onSuccess(final WebAuthResult result) {
                LogUtils.i("switchAccount", "switch success, result code = " + result.getResultCode() + ",resultMsg = " + result.getResultMsg());
                BoxSapiAccountManager.this.getCookieSession().clearOpenBduss();
                BoxCookieSession.clearStokenCookie();
                BoxSapiAccountSync.getInstance(AppRuntime.getAppContext()).boxLoginSync();
                BoxSapiAccountManager.this.getAccountInfoFromServer(new IGetBoxAccountListener() {
                    public void onSuccess(BoxAccount account) {
                        BoxSapiAccountManager.statisticUBCWithId("727", "success", "switch");
                        BoxSapiAccountManager.this.notifyAllLoginStatusChangedListeners(true, true);
                        WebAuthResult webAuthResult = result;
                        if (webAuthResult != null) {
                            webAuthResult.finishActivity();
                        }
                        ChildGuarderDialogUtil.INSTANCE.ifChildToCheckDialog();
                    }

                    public void onFailed(int errorCode) {
                        if (BdBoxActivityManager.getRealTopActivity() instanceof SwitchAccountActivity) {
                            BdBoxActivityManager.getRealTopActivity().finish();
                        }
                    }
                });
            }

            public void onFailure(WebAuthResult result) {
                LogUtils.i("switchAccount", "switch fail, result code = " + result.getResultCode() + ",resultMsg = " + result.getResultMsg());
            }
        });
    }

    public static void statisticUBCWithId(String ubcId, String type, String src) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("from", "account");
            if (!TextUtils.isEmpty(type)) {
                jsonObject.put("type", type);
            }
            jsonObject.put("source", src);
            boolean guestLogin = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isGuestLogin();
            boolean isPrivacyMode = ILoginContext.Impl.get().isBrowserMode();
            if (!guestLogin || !isPrivacyMode) {
                if (guestLogin) {
                    jsonObject.put("page", "guest");
                } else if (isPrivacyMode) {
                    jsonObject.put("page", "liulan");
                }
                ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(ubcId, jsonObject.toString());
                LogUtils.d("switchAccount", ubcId + ":" + jsonObject.toString());
            }
            jsonObject.put("page", "guest_liulan");
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(ubcId, jsonObject.toString());
            LogUtils.d("switchAccount", ubcId + ":" + jsonObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void loadAddressManage(final Context context, final BoxAddressBuildDTO buildDTO) {
        try {
            localConfig((LoginParams) null);
            if (isLogin(2)) {
                if (SapiContext.getInstance().getCurrentAccount() != null) {
                    addressUBC(ADDRESS_MANAGER_SOURCE, buildDTO.source);
                    startAddressManager(context, buildDTO);
                    return;
                }
            }
            combineLogin(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, ADDRESS_SOURCE)).build(), 2, new ILoginResultListener() {
                public void onResult(int resultCode) {
                    if (BoxSapiAccountManager.this.isLogin(2) && SapiContext.getInstance().getCurrentAccount() != null) {
                        BoxSapiAccountManager.this.addressUBC(BoxSapiAccountManager.ADDRESS_MANAGER_SOURCE, buildDTO.source);
                        BoxSapiAccountManager.this.startAddressManager(context, buildDTO);
                    }
                }
            });
        } catch (Throwable e2) {
            LogUtils.e("loadAddressManage", e2.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void startAddressManager(Context context, BoxAddressBuildDTO buildDTO) {
        PassSapiHelper.configTitle();
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        addressManageDTO.type = "0";
        addressManageDTO.sweepLightLoading = true;
        addressManageDTO.tplse = buildDTO.tplse;
        addressManageDTO.tplt = buildDTO.tplt;
        addressManageDTO.mapStatusAndLocateCallback = getMapCallback();
        addressManageDTO.permissionsDTO = new PermissionsDTO();
        addressManageDTO.permissionsDTO.permissions = new String[]{"android.permission.RECORD_AUDIO"};
        addressManageDTO.showBottomBack = true ^ UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment();
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new AddressManageCallback() {
            public void onFinish(AddressManageResult result) {
            }
        });
    }

    private MapStatusAndLocateCallback getMapCallback() {
        return new MapStatusAndLocateCallback() {
            public boolean isMapInitSuccess() {
                return ILoginContext.Impl.get().checkBdMapInited();
            }

            public boolean showScenePermissionView(Context context, AddressScenePermissionDTO dto, GetScenePermissionCallback callback) {
                IPermissionSceneApi sceneApi = IPermissionSceneApi.Companion.getApi();
                if (sceneApi == null || dto == null) {
                    return true;
                }
                sceneApi.requestAuthorization(context, dto.permission, dto.sceneID, dto.source, dto.isStrongDependency, new BoxSapiAccountManager$34$$ExternalSyntheticLambda0(callback));
                return true;
            }

            static /* synthetic */ void lambda$showScenePermissionView$0(GetScenePermissionCallback callback, boolean grant) {
                if (callback != null) {
                    callback.onPermission(grant);
                }
            }

            public void requestLocation(final GetLocationCallback callback) {
                if (callback != null) {
                    final BoxLocationManager boxLocationManager = (BoxLocationManager) ServiceManager.getService(BoxLocationManager.SERVICE_REFERENCE);
                    LocationListener unused = BoxSapiAccountManager.this.mLocationListener = new LocationListener() {
                        public void onReceiveLocation(LocationInfo locationInfo) {
                            LocationInfo location = LocationUtils.transformLocationInfoCoorType(locationInfo, "gcj02");
                            boxLocationManager.delLocationListener(BoxSapiAccountManager.this.mLocationListener);
                            LocationListener unused = BoxSapiAccountManager.this.mLocationListener = null;
                            if (location == null) {
                                callback.onGetLocation(0.0d, 0.0d);
                            } else {
                                callback.onGetLocation(location.latitude, location.longitude);
                            }
                        }

                        public void onError(int errCode) {
                            boxLocationManager.delLocationListener(BoxSapiAccountManager.this.mLocationListener);
                            LocationListener unused = BoxSapiAccountManager.this.mLocationListener = null;
                            LogUtils.d("address", "onError errCode=" + errCode);
                            callback.onGetLocation(0.0d, 0.0d);
                        }
                    };
                    boxLocationManager.requestSceneLocation(AppRuntime.getAppContext(), "address", BoxSapiAccountManager.this.mLocationListener);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void startSelectAddress(Context context, boolean selectAddedAddress, BoxAddressBuildDTO buildDTO, boolean isShowBottomBar, final IAddressManageCallback addressManageCallback) {
        PassSapiHelper.configTitle();
        AddressManageDTO addressManageDTO = new AddressManageDTO();
        if (buildDTO.isOpenAddAddress) {
            addressManageDTO.type = "0";
            addressManageDTO.openPageName = "1";
        } else {
            addressManageDTO.type = "1";
            addressManageDTO.openPageName = "0";
        }
        addressManageDTO.sweepLightLoading = true;
        addressManageDTO.tplt = buildDTO.tplt;
        addressManageDTO.tplse = buildDTO.tplse;
        addressManageDTO.selectAddedAddress = selectAddedAddress;
        addressManageDTO.showBottomBack = isShowBottomBar;
        addressManageDTO.mapStatusAndLocateCallback = getMapCallback();
        addressManageDTO.permissionsDTO = new PermissionsDTO();
        addressManageDTO.permissionsDTO.permissions = new String[]{"android.permission.RECORD_AUDIO"};
        PassportSDK.getInstance().loadAddressManage(context, addressManageDTO, new AddressManageCallback() {
            public void onFinish(AddressManageResult result) {
                BoxAddressManageResult boxAddressManageResult = new BoxAddressManageResult();
                boxAddressManageResult.setResultCode(result.getResultCode());
                boxAddressManageResult.setResultMsg(result.getResultMsg());
                boxAddressManageResult.map = result.map;
                addressManageCallback.onFinish(boxAddressManageResult);
            }
        });
    }

    public void selectAddress(Context context, boolean isShowBottomBar, BoxAddressBuildDTO buildDTO, IAddressManageCallback addressManageCallback) {
        selectAddress(context, false, isShowBottomBar, buildDTO, addressManageCallback);
    }

    public void selectAddress(Context context, boolean selectAddedAddress, boolean isShowBottomBar, BoxAddressBuildDTO buildDTO, IAddressManageCallback addressManageCallback) {
        if (!isLogin(2)) {
            final BoxAddressBuildDTO boxAddressBuildDTO = buildDTO;
            final Context context2 = context;
            final boolean z = selectAddedAddress;
            final boolean z2 = isShowBottomBar;
            final IAddressManageCallback iAddressManageCallback = addressManageCallback;
            combineLogin(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, ADDRESS_SOURCE)).build(), 2, new ILoginResultListener() {
                public void onResult(int resultCode) {
                    if (BoxSapiAccountManager.this.isLogin(2)) {
                        BoxSapiAccountManager.this.addressUBC(BoxSapiAccountManager.SELECT_ADDRESS_SOURCE, boxAddressBuildDTO.source);
                        BoxSapiAccountManager.this.startSelectAddress(context2, z, boxAddressBuildDTO, z2, iAddressManageCallback);
                    }
                }
            });
            BoxAddressBuildDTO boxAddressBuildDTO2 = buildDTO;
            return;
        }
        addressUBC(SELECT_ADDRESS_SOURCE, buildDTO.source);
        startSelectAddress(context, selectAddedAddress, buildDTO, isShowBottomBar, addressManageCallback);
    }

    /* access modifiers changed from: private */
    public void addressUBC(String page, String source) {
        UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", "show");
            jsonObject.put("page", page);
            jsonObject.put("source", source);
            ubcManager.onEvent("1042", jsonObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void startInvoiceManager(final Context context, final BoxInvoiceBuildDTO boxInvoiceBuildDTO) {
        if (boxInvoiceBuildDTO != null) {
            if (!isLogin(2)) {
                combineLogin(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, INVOICE_SOURCE)).build(), 2, new ILoginResultListener() {
                    public void onResult(int resultCode) {
                        if (BoxSapiAccountManager.this.isLogin(2)) {
                            BoxSapiAccountManager.this.invoiceUBC(BoxSapiAccountManager.INVOICE_MANAGER_SOURCE, boxInvoiceBuildDTO.source);
                            BoxSapiAccountManager.this.startBoxInvoiceManager(context, boxInvoiceBuildDTO);
                        }
                    }
                });
                return;
            }
            invoiceUBC(INVOICE_MANAGER_SOURCE, boxInvoiceBuildDTO.source);
            startBoxInvoiceManager(context, boxInvoiceBuildDTO);
        }
    }

    /* access modifiers changed from: private */
    public void startBoxInvoiceManager(Context context, BoxInvoiceBuildDTO boxInvoiceBuildDTO) {
        PassSapiHelper.configTitle();
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = "0";
        invoiceBuildDTO.isExamineVAT = boxInvoiceBuildDTO.isExamineVAT;
        invoiceBuildDTO.sweepLightLoading = true;
        invoiceBuildDTO.tplse = boxInvoiceBuildDTO.tplse;
        invoiceBuildDTO.tplt = boxInvoiceBuildDTO.tplt;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new InvoiceBuildCallback() {
            public void onFinish(InvoiceBuildResult invoiceBuildResult) {
                SapiAccountManager.getInstance().getConfignation().showBottomBack = !UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment();
            }
        });
    }

    /* access modifiers changed from: private */
    public void startBoxSelectInvoice(Context context, boolean isShowBottomBar, BoxInvoiceBuildDTO boxInvoiceBuildDTO, final BoxInvoiceBuildCallback boxInvoiceBuildCallback) {
        PassSapiHelper.configTitle();
        SapiAccountManager.getInstance().getConfignation().showBottomBack = isShowBottomBar;
        InvoiceBuildDTO invoiceBuildDTO = new InvoiceBuildDTO();
        invoiceBuildDTO.TYPE = "1";
        invoiceBuildDTO.isExamineVAT = boxInvoiceBuildDTO.isExamineVAT;
        invoiceBuildDTO.sweepLightLoading = true;
        invoiceBuildDTO.tplt = boxInvoiceBuildDTO.tplt;
        invoiceBuildDTO.tplse = boxInvoiceBuildDTO.tplse;
        PassportSDK.getInstance().loadInvoiceBuild(context, invoiceBuildDTO, new InvoiceBuildCallback() {
            public void onFinish(InvoiceBuildResult invoiceBuildResult) {
                BoxInvoiceBuildResult boxInvoiceBuildResult = new BoxInvoiceBuildResult();
                boxInvoiceBuildResult.setResultCode(invoiceBuildResult.getResultCode());
                boxInvoiceBuildResult.setResultMsg(invoiceBuildResult.getResultMsg());
                boxInvoiceBuildResult.map = invoiceBuildResult.map;
                BoxInvoiceBuildCallback boxInvoiceBuildCallback = boxInvoiceBuildCallback;
                if (boxInvoiceBuildCallback != null) {
                    boxInvoiceBuildCallback.onFinish(boxInvoiceBuildResult);
                }
            }
        });
    }

    public void startSelectInvoice(Context context, boolean isShowBottomBar, BoxInvoiceBuildDTO boxInvoiceBuildDTO, BoxInvoiceBuildCallback boxInvoiceBuildCallback) {
        if (boxInvoiceBuildDTO != null) {
            if (!isLogin(2)) {
                final BoxInvoiceBuildDTO boxInvoiceBuildDTO2 = boxInvoiceBuildDTO;
                final Context context2 = context;
                final boolean z = isShowBottomBar;
                final BoxInvoiceBuildCallback boxInvoiceBuildCallback2 = boxInvoiceBuildCallback;
                combineLogin(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, INVOICE_SOURCE)).build(), 2, new ILoginResultListener() {
                    public void onResult(int resultCode) {
                        if (BoxSapiAccountManager.this.isLogin(2)) {
                            BoxSapiAccountManager.this.invoiceUBC(BoxSapiAccountManager.SELECT_INVOICE_SOURCE, boxInvoiceBuildDTO2.source);
                            BoxSapiAccountManager.this.startBoxSelectInvoice(context2, z, boxInvoiceBuildDTO2, boxInvoiceBuildCallback2);
                        }
                    }
                });
                return;
            }
            invoiceUBC(SELECT_INVOICE_SOURCE, boxInvoiceBuildDTO.source);
            startBoxSelectInvoice(context, isShowBottomBar, boxInvoiceBuildDTO, boxInvoiceBuildCallback);
        }
    }

    public void getOpenBduss(String clientId, List<String> tplList, final IGetOpenBdussCallback openBdussCallback) {
        GetOpenBdussDTO getOpenBdussDTO = new GetOpenBdussDTO();
        getOpenBdussDTO.clientId = clientId;
        getOpenBdussDTO.targetTplList = tplList;
        SapiAccountManager.getInstance().getAccountService().getOpenBduss(getOpenBdussDTO, new GetOpenBdussCallback() {
            public void onSuccess(OpenBdussResult openBdussResult) {
                if (openBdussCallback != null && openBdussResult != null) {
                    AccountOpenBdussResult accountOpenBdussResult = new AccountOpenBdussResult();
                    accountOpenBdussResult.setResultCode(openBdussResult.getResultCode());
                    accountOpenBdussResult.setResultMsg(openBdussResult.getResultMsg());
                    accountOpenBdussResult.setBduss(openBdussResult.bduss);
                    accountOpenBdussResult.setDisplayname(openBdussResult.displayname);
                    accountOpenBdussResult.setFlag(openBdussResult.flag);
                    accountOpenBdussResult.setOpenBduss(openBdussResult.openBduss);
                    accountOpenBdussResult.setTplStokenMap(openBdussResult.tplStokenMap);
                    accountOpenBdussResult.setUid(openBdussResult.uid);
                    accountOpenBdussResult.setUnionid(openBdussResult.unionid);
                    openBdussCallback.onSuccess(accountOpenBdussResult);
                }
            }

            public void onFailure(OpenBdussResult openBdussResult) {
                if (openBdussCallback != null && openBdussResult != null) {
                    AccountOpenBdussResult accountOpenBdussResult = new AccountOpenBdussResult();
                    accountOpenBdussResult.setResultCode(openBdussResult.getResultCode());
                    accountOpenBdussResult.setResultMsg(openBdussResult.getResultMsg());
                    accountOpenBdussResult.setBduss(openBdussResult.bduss);
                    accountOpenBdussResult.setDisplayname(openBdussResult.displayname);
                    accountOpenBdussResult.setFlag(openBdussResult.flag);
                    accountOpenBdussResult.setOpenBduss(openBdussResult.openBduss);
                    accountOpenBdussResult.setTplStokenMap(openBdussResult.tplStokenMap);
                    accountOpenBdussResult.setUid(openBdussResult.uid);
                    accountOpenBdussResult.setUnionid(openBdussResult.unionid);
                    openBdussCallback.onFailure(accountOpenBdussResult);
                }
            }

            public void onStart() {
                IGetOpenBdussCallback iGetOpenBdussCallback = openBdussCallback;
                if (iGetOpenBdussCallback != null) {
                    iGetOpenBdussCallback.onStart();
                }
            }

            public void onFinish() {
                IGetOpenBdussCallback iGetOpenBdussCallback = openBdussCallback;
                if (iGetOpenBdussCallback != null) {
                    iGetOpenBdussCallback.onFinish();
                }
            }
        });
    }

    public void sendContactsSms(BoxSendSmsDTO boxSendSmsDTO) {
        if (boxSendSmsDTO != null) {
            SendSmsDTO sendSmsDTO = new SendSmsDTO();
            sendSmsDTO.context = boxSendSmsDTO.context;
            sendSmsDTO.encryptPhones = boxSendSmsDTO.encryptPhones;
            sendSmsDTO.smsContent = boxSendSmsDTO.smsContent;
            SapiAccountManager.getInstance().getAccountService().sendContactsSms(sendSmsDTO);
        }
    }

    public void getContacts(BoxGetContactDTO boxGetContactDTO, final IGetContactsCallback callback) {
        if (boxGetContactDTO != null) {
            GetContactsDTO getContactDTO = new GetContactsDTO();
            getContactDTO.pageNo = boxGetContactDTO.pageNo;
            getContactDTO.isUploadAllContactsData = boxGetContactDTO.isUploadAllContactsData;
            getContactDTO.isGetLocalContacts = boxGetContactDTO.isGetLocalContacts;
            getContactDTO.onlyUploadPhoneNumber = boxGetContactDTO.onlyUploadPhoneNumber;
            SapiAccountManager.getInstance().getAccountService().getContacts(new GetContactsCallback() {
                public void onSuccess(GetContactsResult getContactResult) {
                    if (callback != null && getContactResult != null) {
                        BoxGetContactResult boxGetContactResult = new BoxGetContactResult();
                        boxGetContactResult.itemCount = getContactResult.itemCount;
                        boxGetContactResult.name = getContactResult.name;
                        boxGetContactResult.pageCount = getContactResult.pageCount;
                        boxGetContactResult.pageNo = getContactResult.pageNo;
                        boxGetContactResult.pageSize = getContactResult.pageSize;
                        boxGetContactResult.phone = getContactResult.phone;
                        List<UserPhoneBean> userPhoneBeans = getContactResult.userPhoneBeans;
                        if (userPhoneBeans != null) {
                            ArrayList<BoxUserPhoneBean> boxUserPhoneBeans = new ArrayList<>();
                            for (int i2 = 0; i2 < userPhoneBeans.size(); i2++) {
                                boxUserPhoneBeans.add(BoxUserPhoneBean.fromJson(userPhoneBeans.get(i2).toJson()));
                            }
                            boxGetContactResult.userPhoneBeans = boxUserPhoneBeans;
                        }
                        boxGetContactResult.setResultCode(getContactResult.getResultCode());
                        boxGetContactResult.setResultMsg(getContactResult.getResultMsg());
                        callback.onSuccess(boxGetContactResult);
                    }
                }

                public void onFailure(GetContactsResult getContactResult) {
                    if (callback != null && getContactResult != null) {
                        BoxGetContactResult boxGetContactResult = new BoxGetContactResult();
                        boxGetContactResult.itemCount = getContactResult.itemCount;
                        boxGetContactResult.name = getContactResult.name;
                        boxGetContactResult.pageCount = getContactResult.pageCount;
                        boxGetContactResult.pageNo = getContactResult.pageNo;
                        boxGetContactResult.pageSize = getContactResult.pageSize;
                        boxGetContactResult.phone = getContactResult.phone;
                        List<UserPhoneBean> userPhoneBeans = getContactResult.userPhoneBeans;
                        if (userPhoneBeans != null) {
                            ArrayList<BoxUserPhoneBean> boxUserPhoneBeans = new ArrayList<>();
                            for (int i2 = 0; i2 < userPhoneBeans.size(); i2++) {
                                boxUserPhoneBeans.add(BoxUserPhoneBean.fromJson(userPhoneBeans.get(i2).toJson()));
                            }
                            boxGetContactResult.userPhoneBeans = boxUserPhoneBeans;
                        }
                        boxGetContactResult.setResultCode(getContactResult.getResultCode());
                        boxGetContactResult.setResultMsg(getContactResult.getResultMsg());
                        callback.onFailure(boxGetContactResult);
                    }
                }

                public void onStart() {
                    IGetContactsCallback iGetContactsCallback = callback;
                    if (iGetContactsCallback != null) {
                        iGetContactsCallback.onStart();
                    }
                }

                public void onFinish() {
                    IGetContactsCallback iGetContactsCallback = callback;
                    if (iGetContactsCallback != null) {
                        iGetContactsCallback.onFinish();
                    }
                }
            }, getContactDTO);
        }
    }

    /* access modifiers changed from: private */
    public void invoiceUBC(String page, String source) {
        UBCManager ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("type", "show");
            jsonObject.put("page", page);
            jsonObject.put("source", source);
            ubcManager.onEvent(INVOICE_UBC_ID, jsonObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void getOneKeyLoginInfo(IOneKeyLoginCallback oneKeyLoginCallback) {
        getOneKeyLoginInfo(false, oneKeyLoginCallback);
    }

    public void getOneKeyLoginInfo(boolean isFastTimeout, final IOneKeyLoginCallback oneKeyLoginCallback) {
        int i2;
        LoginResult debugLoginResult = AccountDebugManager.INSTANCE.getDebugLoginResult();
        if (debugLoginResult instanceof BoxOneKeyLoginResult) {
            oneKeyLoginCallback.onResult((BoxOneKeyLoginResult) debugLoginResult);
            return;
        }
        GetOneKeyLoginStateDTO dto = new GetOneKeyLoginStateDTO();
        if (isFastTimeout) {
            i2 = 1000;
        } else {
            i2 = 5000;
        }
        dto.connectTimeout = i2;
        SapiAccountManager.getInstance().getAccountService().getOneKeyLoginIsAvailable(dto, new OneKeyLoginCallback() {
            public void available(OneKeyLoginResult oneKeyLoginResult) {
                char c2 = 65535;
                if (oneKeyLoginResult == null) {
                    BoxAccountManager.oneKeyErrors.put(-1, "返回原因为空");
                    oneKeyLoginCallback.onResult((BoxOneKeyLoginResult) null);
                    return;
                }
                boolean enable = oneKeyLoginResult.enable;
                String operator = oneKeyLoginResult.operator;
                String encryptPhoneNum = oneKeyLoginResult.encryptPhoneNum;
                boolean hasHistory = oneKeyLoginResult.hasHistory;
                int resultCode = oneKeyLoginResult.getResultCode();
                String resultMsg = oneKeyLoginResult.getResultMsg();
                BoxOneKeyLoginResult boxOneKeyLoginResult = new BoxOneKeyLoginResult();
                boxOneKeyLoginResult.setEnable(enable);
                boxOneKeyLoginResult.setOperatorType(operator);
                boxOneKeyLoginResult.setEncryptPhoneNum(encryptPhoneNum);
                boxOneKeyLoginResult.setHasHistory(hasHistory);
                boxOneKeyLoginResult.setResultCode(resultCode);
                boxOneKeyLoginResult.setResultMsg(resultMsg);
                switch (operator.hashCode()) {
                    case 2154:
                        if (operator.equals("CM")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 2161:
                        if (operator.equals("CT")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 2162:
                        if (operator.equals("CU")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        boxOneKeyLoginResult.setLoginMode(12);
                        break;
                    case 1:
                        boxOneKeyLoginResult.setLoginMode(13);
                        break;
                    case 2:
                        boxOneKeyLoginResult.setLoginMode(14);
                        break;
                }
                oneKeyLoginCallback.onResult(boxOneKeyLoginResult);
            }

            public void unAvailable(OneKeyLoginResult oneKeyLoginResult) {
                super.unAvailable(oneKeyLoginResult);
                if (oneKeyLoginResult == null) {
                    BoxAccountManager.oneKeyErrors.put(-1, "返回原因为空");
                    oneKeyLoginCallback.onResult((BoxOneKeyLoginResult) null);
                    return;
                }
                BoxOneKeyLoginResult loginResult = new BoxOneKeyLoginResult();
                loginResult.setResultCode(oneKeyLoginResult.getResultCode());
                loginResult.setResultMsg(oneKeyLoginResult.getResultMsg());
                loginResult.setEnable(false);
                loginResult.setFinish(true);
                BoxAccountManager.oneKeyErrors.put(Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg());
                oneKeyLoginCallback.onResult(loginResult);
            }
        });
    }

    public BoxShareLoginResult getShareLoginInfo() {
        List<ShareStorage.StorageModel> v2ShareModelList = SapiAccountManager.getInstance().getV2ShareModelList();
        if (v2ShareModelList == null || v2ShareModelList.size() <= 0) {
            return null;
        }
        for (ShareStorage.StorageModel storageModel : v2ShareModelList) {
            if (storageModel != null && !TextUtils.isEmpty(storageModel.displayname) && !TextUtils.isEmpty(storageModel.app)) {
                BoxShareLoginResult boxShareLoginResult = new BoxShareLoginResult();
                boxShareLoginResult.setAppPkg(storageModel.pkg);
                boxShareLoginResult.setDisplayName(storageModel.displayname);
                boxShareLoginResult.setFromApp(storageModel.app);
                boxShareLoginResult.setPortraitUrl(storageModel.url);
                boxShareLoginResult.setEnable(true);
                LogUtils.writeOnlineLog(LogDescription.EVENT_SHARE_LOGIN, "from app =" + boxShareLoginResult.getFromApp(), "getShareLoginInfo", true, false);
                return boxShareLoginResult;
            }
        }
        return null;
    }

    public void getLoginInfo(boolean isFastTimeout, LoginInfoCallback callback) {
        getLoginInfo("share_onekey_history_normal", isFastTimeout, callback);
    }

    public void getLoginInfo(String sourceLoginPriority, boolean isFastTimeout, final LoginInfoCallback callback) {
        if (TextUtils.isEmpty(sourceLoginPriority)) {
            callback.onResult((LoginResult) null);
            return;
        }
        final String loginPriority = getLoginPriority(sourceLoginPriority);
        final HashMap<String, LoginResult> loginResultMap = new HashMap<>();
        if (SapiUtils.isAppInstalled(getContext(), "com.tencent.mm") && loginPriority.contains("wechat")) {
            ThirdLoginResult result = new ThirdLoginResult();
            result.setFinish(true);
            result.setEnable(true);
            loginResultMap.put("wechat", result);
        }
        ThirdLoginResult result2 = new ThirdLoginResult();
        result2.setFinish(true);
        result2.setEnable(true);
        loginResultMap.put("normal", result2);
        getShareLoginInfo(new IShareLoginInfoCallback() {
            public void onResult(BoxShareLoginResult result) {
                if (result == null) {
                    result = new BoxShareLoginResult();
                }
                result.setFinish(true);
                loginResultMap.put("share", result);
                BoxSapiAccountManager.this.refreshView(loginPriority, loginResultMap, callback);
            }
        }, 1500);
        BoxOneKeyLoginResult boxOneKeyLoginResult = mLocalOneKeyResult;
        if (boxOneKeyLoginResult == null || !boxOneKeyLoginResult.isEnable()) {
            AccountUBCHelperKt.statisticUBCGetOneKeyInfo(callback.getErrorFrom(), BoxAccountContants.LOGIN_TYPE_YUQUHAO, (String) null, callback.getSource());
            getOneKeyLoginInfo(isFastTimeout, new IOneKeyLoginCallback() {
                public void onResult(BoxOneKeyLoginResult result) {
                    int resultCode = -1;
                    if (result != null) {
                        resultCode = result.getResultCode();
                    }
                    if (result == null) {
                        result = new BoxOneKeyLoginResult();
                    }
                    if (!result.isEnable()) {
                        AccountUBCHelperKt.statisticUBCGetOneKeyInfo(callback.getErrorFrom(), "yuquhao_fail", Integer.toString(resultCode), callback.getSource());
                    }
                    result.setFinish(true);
                    loginResultMap.put("onekey", result);
                    BoxSapiAccountManager.this.refreshView(loginPriority, loginResultMap, callback);
                }
            });
        } else {
            mLocalOneKeyResult.setFinish(true);
            loginResultMap.put("onekey", mLocalOneKeyResult);
            refreshView(loginPriority, loginResultMap, callback);
        }
        getHistoryLoginInfo(new IHistoryLoginCallback() {
            public void onResult(BoxHistoryLoginResult result) {
                if (result == null) {
                    result = new BoxHistoryLoginResult();
                }
                result.setFinish(true);
                loginResultMap.put("history", result);
                BoxSapiAccountManager.this.refreshView(loginPriority, loginResultMap, callback);
            }
        });
    }

    private String getLoginPriority(String sourceLoginPriority) {
        String result = sourceLoginPriority;
        if (SapiUtils.isAppInstalled(getContext(), "com.tencent.mm") || !sourceLoginPriority.contains("wechat")) {
            return result;
        }
        return sourceLoginPriority.replace("wechat", "");
    }

    /* access modifiers changed from: private */
    public void refreshView(String loginPriority, HashMap<String, LoginResult> loginResultMap, LoginInfoCallback callback) {
        for (String keyword : loginPriority.split("_")) {
            if (!TextUtils.isEmpty(keyword)) {
                LoginResult loginResult = loginResultMap.get(keyword);
                if (loginResult != null && loginResult.isFinish()) {
                    if (loginResult.isEnable()) {
                        synchronized (BoxSapiAccountManager.class) {
                            if (callback != null) {
                                if (!callback.isCallBacked()) {
                                    callback.onResult(loginResult);
                                    callback.setCallBacked(true);
                                    return;
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void getShareLoginInfo(final IShareLoginInfoCallback callback, long timeout) {
        SapiAccountManager.getInstance().getShareModels(timeout, (ShareModelCallback) new ShareModelCallback() {
            /* JADX WARNING: type inference failed for: r1v1, types: [com.baidu.searchbox.account.result.LoginResult] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onReceiveShareModels(java.util.List<com.baidu.sapi2.share.ShareStorage.StorageModel> r8) {
                /*
                    r7 = this;
                    com.baidu.searchbox.account.result.BoxShareLoginResult r0 = new com.baidu.searchbox.account.result.BoxShareLoginResult
                    r0.<init>()
                    if (r8 == 0) goto L_0x0075
                    int r1 = r8.size()
                    if (r1 <= 0) goto L_0x0075
                    java.util.Iterator r1 = r8.iterator()
                L_0x0011:
                    boolean r2 = r1.hasNext()
                    if (r2 == 0) goto L_0x0075
                    java.lang.Object r2 = r1.next()
                    com.baidu.sapi2.share.ShareStorage$StorageModel r2 = (com.baidu.sapi2.share.ShareStorage.StorageModel) r2
                    if (r2 == 0) goto L_0x0074
                    java.lang.String r3 = r2.displayname
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L_0x0074
                    java.lang.String r3 = r2.app
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto L_0x0074
                    com.baidu.searchbox.account.result.BoxShareLoginResult r1 = new com.baidu.searchbox.account.result.BoxShareLoginResult
                    r1.<init>()
                    r0 = r1
                    java.lang.String r1 = r2.pkg
                    r0.setAppPkg(r1)
                    java.lang.String r1 = r2.displayname
                    r0.setDisplayName(r1)
                    java.lang.String r1 = r2.app
                    r0.setFromApp(r1)
                    java.lang.String r1 = r2.url
                    r0.setPortraitUrl(r1)
                    com.baidu.searchbox.account.manager.BoxShareLoginDegradeManager r1 = com.baidu.searchbox.account.manager.BoxShareLoginDegradeManager.INSTANCE
                    boolean r1 = r1.isShareLoginEnable()
                    r0.setEnable(r1)
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r3 = "from app ="
                    java.lang.StringBuilder r1 = r1.append(r3)
                    java.lang.String r3 = r0.getFromApp()
                    java.lang.StringBuilder r1 = r1.append(r3)
                    java.lang.String r1 = r1.toString()
                    r3 = 1
                    r4 = 0
                    java.lang.String r5 = "share_login"
                    java.lang.String r6 = "getShareLoginInfo"
                    com.baidu.android.app.account.utils.LogUtils.writeOnlineLog(r5, r1, r6, r3, r4)
                    goto L_0x0075
                L_0x0074:
                    goto L_0x0011
                L_0x0075:
                    com.baidu.searchbox.account.manager.AccountDebugManager r1 = com.baidu.searchbox.account.manager.AccountDebugManager.INSTANCE
                    com.baidu.searchbox.account.result.LoginResult r1 = r1.getDebugLoginResult()
                    boolean r2 = r1 instanceof com.baidu.searchbox.account.result.BoxShareLoginResult
                    if (r2 == 0) goto L_0x0082
                    r0 = r1
                    com.baidu.searchbox.account.result.BoxShareLoginResult r0 = (com.baidu.searchbox.account.result.BoxShareLoginResult) r0
                L_0x0082:
                    r2 = r0
                    com.baidu.android.app.account.BoxSapiAccountManager$47$1 r3 = new com.baidu.android.app.account.BoxSapiAccountManager$47$1
                    r3.<init>(r2)
                    com.baidu.android.util.concurrent.UiThreadUtils.runOnUiThread(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.app.account.BoxSapiAccountManager.AnonymousClass47.onReceiveShareModels(java.util.List):void");
            }
        });
    }

    public void upLoadPortrait(int portraitType, Bitmap portrait, IUploadPortraitListener uploadPortraitListener) {
        BoxPortraitManager.getInstance().uploadUserPortrait(uploadPortraitListener, portrait, portraitType, false);
    }

    public void upLoadPortrait(int portraitType, Bitmap portrait, IUploadPortraitListener uploadPortraitListener, int portraitAttribute) {
        BoxPortraitManager.getInstance().uploadUserPortrait(uploadPortraitListener, portrait, portraitType, false, portraitAttribute);
    }

    public int getLastLoginType() {
        int lastLoginType = SapiUtils.getLastLoginType();
        switch (lastLoginType) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 8;
            case 4:
                return 2;
            case 5:
                return 4;
            case 6:
                return 3;
            case 8:
            case 9:
                return 15;
            case 15:
                return 11;
            case 16:
                return 12;
            case 17:
                return 13;
            case 18:
                return 14;
            default:
                return lastLoginType;
        }
    }

    public void getOperationView(Context context, AccountOperationConfig config, IAccountComponentCallback callback) {
        AccountOperationManager.getInstance().initOperationView(context, config, callback);
    }

    public void getTaskGuideView(Context context, int viewStyle, AccountComponentConfig config, IAccountComponentCallback callback) {
        AccountTaskGuideView guideView = new AccountTaskGuideView(context, viewStyle, callback);
        config.mOnekeyFailJumpPass = false;
        guideView.initData(config, true);
    }

    public void getWealthTaskView(Context context, IAccountComponentCallback callback, String loginBtnText, String panelPriority, String normalLoginText, String wxLoginText, Bitmap wxLogo, AccountComponentConfig config) {
        String wealthPanelPriority;
        String str = panelPriority;
        AccountComponentConfig accountComponentConfig = config;
        if (TextUtils.isEmpty(panelPriority)) {
            wealthPanelPriority = "normal";
        } else if (!str.contains("normal")) {
            wealthPanelPriority = str + "_" + "normal";
        } else {
            wealthPanelPriority = panelPriority;
        }
        AccountWealthTaskPacketLoginView guideView = new AccountWealthTaskPacketLoginView(context, callback, loginBtnText, wealthPanelPriority, normalLoginText, wxLoginText, wxLogo);
        accountComponentConfig.mOnekeyFailJumpPass = false;
        guideView.initData(accountComponentConfig, true);
    }

    public void getPersuadeView(Context context, AccountComponentConfig config, IAccountComponentCallback callback) {
        AccountPersuadeView guideView = new AccountPersuadeView(context, callback);
        config.mOnekeyFailJumpPass = false;
        guideView.initData(config, true);
    }

    public void dismissOperationView() {
        AccountOperationManager.getInstance().release();
    }

    public void showLoginComponentDialog(Context context, AccountComponentConfig config, ILoginResultListener listener) {
        localConfig((LoginParams) null);
        new BoxLoginBridge().showLoginComponentDialog(context, config, listener);
    }

    public boolean canShowLoginComponent(String nodeName) {
        return ILoginContext.Impl.get().canPop(nodeName);
    }

    public boolean showLoginComponentWithCloudControl(Context context, AccountComponentConfig config, final ILoginResultListener listener, final String nodeName) {
        if (isLogin(0) || !ILoginContext.Impl.get().checkAndRecordPopTime(nodeName)) {
            return false;
        }
        showLoginComponentDialog(context, config, new ILoginResultListener() {
            public void onResult(int resultCode) {
                ILoginContext.Impl.get().setDialogLoginResult(nodeName, resultCode);
                listener.onResult(resultCode);
            }
        });
        return true;
    }

    public int getHalfDialogUnLoginCount(String nodeName) {
        return ILoginContext.Impl.get().getUnLoginCount(nodeName);
    }

    public void getQuickLoginView(Context context, int viewType, AccountComponentConfig config, IAccountComponentCallback callback) {
        new AccountQuickLoginManager().initView(context, viewType, config, callback);
    }

    public void accountLaunchTask(IGetBoxAccountListener listener) {
        getAccountInfoFromServer(listener);
        if (isLogin(2)) {
            BdEventBus.Companion.getDefault().register(this, GetUserInfoEvent.class, 1, new Action<GetUserInfoEvent>() {
                public void call(GetUserInfoEvent getUserInfoEvent) {
                    if (AppConfig.isDebug()) {
                        Log.d(BoxSapiAccountManager.TAG, "info/get返回 触发检查");
                    }
                    ChildGuarderDialogUtil.INSTANCE.ifChildToCheckDialog();
                    BdEventBus.Companion.getDefault().unregister(BoxSapiAccountManager.this);
                }
            });
        }
        if (!AccountSrcUtils.getAccountSrcLoadStatus()) {
            UserAccountActionItem accountSrc = AccountSrcUtils.getAccountSrc();
            String uk = BoxAccountPreference.getAccountStringPreference(BoxAccountContants.ACCOUNT_UK, "");
            BoxSapiAccountManager boxSapiAccountManager = (BoxSapiAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            new AccountStatusRequest().userxStatus(accountSrc, uk, boxSapiAccountManager.getLocalSession().getSession("BoxAccount_bduss"), boxSapiAccountManager.getCookieSession().getSession("BoxAccount_bduss"));
        }
        SapiAccountManager.getInstance().setSid();
        if (!isLogin(2)) {
            getShareLoginInfo((IShareLoginInfoCallback) null, 1500);
            updateLocalOneKeyInfo();
        }
    }

    private boolean isLastOneKey() {
        int lastLoginType = SapiUtils.getLastLoginType();
        return lastLoginType == 18 || lastLoginType == 17 || lastLoginType == 16;
    }

    public void getFaceRecogBiometricInfo(Activity activity, int quality, final IAccountFaceRecogCallback faceRecogCallback) {
        BiometricsManager.getInstance().recogWithFaceLive(activity, quality, new PassFaceRecogCallback() {
            public void onSuccess(PassFaceRecogResult passFaceRecogResult) {
                if (faceRecogCallback == null) {
                    return;
                }
                if (passFaceRecogResult == null) {
                    BoxFaceRecogResult result = new BoxFaceRecogResult();
                    result.resultCode = -202;
                    faceRecogCallback.onFailure(result);
                    return;
                }
                faceRecogCallback.onSuccess(BoxSapiAccountManager.this.transferPassFaceRecogResult(passFaceRecogResult));
            }

            public void onFailure(PassFaceRecogResult passFaceRecogResult) {
                if (faceRecogCallback == null) {
                    return;
                }
                if (passFaceRecogResult == null) {
                    BoxFaceRecogResult result = new BoxFaceRecogResult();
                    result.resultCode = -202;
                    faceRecogCallback.onFailure(result);
                    return;
                }
                faceRecogCallback.onFailure(BoxSapiAccountManager.this.transferPassFaceRecogResult(passFaceRecogResult));
            }
        });
    }

    /* access modifiers changed from: private */
    public BoxFaceRecogResult transferPassFaceRecogResult(PassFaceRecogResult passFaceRecogResult) {
        BoxFaceRecogResult result = new BoxFaceRecogResult();
        result.callbackkey = passFaceRecogResult.callbackkey;
        result.authSid = passFaceRecogResult.authSid;
        result.video = passFaceRecogResult.video;
        result.extraJson = passFaceRecogResult.extraJson;
        result.faceimage = passFaceRecogResult.faceimage;
        result.imgdigests = passFaceRecogResult.imgdigests;
        result.originalImage = passFaceRecogResult.originalImage;
        result.resultCode = passFaceRecogResult.getResultCode();
        result.resultMsg = passFaceRecogResult.getResultMsg();
        return result;
    }

    public int getBdussState() {
        return SapiAccountManager.getInstance().getAccountService().getBdussState();
    }

    public void web2NativeLogin(final LoginParams params, final IWeb2NativeLoginCallback iWeb2NativeLoginCallback) {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() {
            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                IWeb2NativeLoginCallback iWeb2NativeLoginCallback = iWeb2NativeLoginCallback;
                if (iWeb2NativeLoginCallback != null) {
                    iWeb2NativeLoginCallback.onBdussEmpty();
                }
            }

            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                IWeb2NativeLoginCallback iWeb2NativeLoginCallback = iWeb2NativeLoginCallback;
                if (iWeb2NativeLoginCallback != null) {
                    iWeb2NativeLoginCallback.onBdussExpired();
                }
            }

            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                BoxSapiAccountSync.getInstance(BoxSapiAccountManager.this.mContext).boxLoginSync(params.mLoginSrc);
                BoxSapiAccountManager.this.getAccountInfoFromServer(new IGetBoxAccountListener() {
                    public void onSuccess(BoxAccount account) {
                        BoxSapiAccountManager.this.notifyAllLoginStatusChangedListeners(false, true);
                    }

                    public void onFailed(int errorCode) {
                    }
                });
                IWeb2NativeLoginCallback iWeb2NativeLoginCallback = iWeb2NativeLoginCallback;
                if (iWeb2NativeLoginCallback != null) {
                    iWeb2NativeLoginCallback.onSuccess();
                }
            }

            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                IWeb2NativeLoginCallback iWeb2NativeLoginCallback = iWeb2NativeLoginCallback;
                if (iWeb2NativeLoginCallback != null) {
                    iWeb2NativeLoginCallback.onFailure();
                }
            }

            public void onStart() {
                IWeb2NativeLoginCallback iWeb2NativeLoginCallback = iWeb2NativeLoginCallback;
                if (iWeb2NativeLoginCallback != null) {
                    iWeb2NativeLoginCallback.onStart();
                }
            }

            public void onFinish() {
                IWeb2NativeLoginCallback iWeb2NativeLoginCallback = iWeb2NativeLoginCallback;
                if (iWeb2NativeLoginCallback != null) {
                    iWeb2NativeLoginCallback.onFinish();
                }
            }
        });
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback callback) {
        SapiAccount sapiAccount = SapiContext.getInstance().getCurrentAccount();
        if (sapiAccount != null) {
            SapiAccountManager.getInstance().getAccountService().getPopularPortraitsInfo(callback, sapiAccount.bduss, PortraitCategory.NEW);
        }
    }

    public void setPopularPortrait(String series, int num, SetPopularPortraitCallback callback) {
        SapiAccount sapiAccount = SapiContext.getInstance().getCurrentAccount();
        if (sapiAccount != null) {
            SetPopularPortraitDTO dto = new SetPopularPortraitDTO();
            dto.bduss = sapiAccount.bduss;
            dto.series = series;
            dto.num = num;
            SapiAccountManager.getInstance().getAccountService().setPopularPortrait(callback, dto);
        }
    }

    public void sdkLogin2Web(Context context) {
        if (isLogin()) {
            SapiAccountManager.getInstance().getAccountService().webLogin(context);
        }
    }

    public void loadChildActivity(Context context, final IVerifyUserFaceIDListener iVerifyUserFaceIDListener) {
        PassportSDK.getInstance().loadChildActivity(context, new AccountRealNameCallback() {
            public void onFinish(AccountRealNameResult accountRealNameResult) {
                super.onFinish(accountRealNameResult);
                if (iVerifyUserFaceIDListener != null) {
                    if (accountRealNameResult.getResultCode() == 0) {
                        SearchBoxRealNameResult searchBoxRealNameResult = new SearchBoxRealNameResult();
                        searchBoxRealNameResult.callbackkey = accountRealNameResult.callbackkey;
                        iVerifyUserFaceIDListener.onSuccess(searchBoxRealNameResult);
                        return;
                    }
                    iVerifyUserFaceIDListener.onFailure(accountRealNameResult.getResultCode(), accountRealNameResult.getResultMsg());
                }
            }
        });
    }

    public void showLoginAgreementDialog(Context context, AccountLoginAgreeConfig config, ILoginAgreeDialogCallback callback) {
        AccountLoginDialogManager.showLoginAgreementDialog(context, config, callback);
    }

    public void hideLoginComponentDialog(Context context) {
        Activity halfScreenDialogActivity = BdBoxActivityManager.getSpecifiedActivity(HalfScreenDialogActivity.class);
        if (halfScreenDialogActivity != null && !ActivityUtils.isDestroyed(halfScreenDialogActivity)) {
            halfScreenDialogActivity.finish();
        }
        if (context instanceof FragmentActivity) {
            Fragment fragment = ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag(AccountLoginDialogManager.TAG);
            if (fragment instanceof AccountHalfScreenDialog) {
                AccountHalfScreenDialog halfScreenDialog = (AccountHalfScreenDialog) fragment;
                halfScreenDialog.dismissAllowingStateLoss();
                halfScreenDialog.release();
            }
        }
    }

    public void getHistoryLoginInfo(final IHistoryLoginCallback callback) {
        LoginResult debugLoginResult = AccountDebugManager.INSTANCE.getDebugLoginResult();
        if (debugLoginResult instanceof BoxHistoryLoginResult) {
            callback.onResult((BoxHistoryLoginResult) debugLoginResult);
        } else if (callback != null) {
            final BoxHistoryLoginResult result = new BoxHistoryLoginResult();
            if (DefaultSharedPrefsWrapper.getInstance().getString(HISTORY_LOGIN_SWITCH, "0").equals("1")) {
                result.setSupport(true);
                SapiAccountManager.getInstance().checkAvailableLoginHistory(new LoginHistoryCallback() {
                    public void onSuccess(List<LoginHistoryModel> historyModels) {
                        if (historyModels == null || historyModels.isEmpty()) {
                            callback.onResult((BoxHistoryLoginResult) null);
                            return;
                        }
                        BoxLoginHistoryModel model = null;
                        Iterator<LoginHistoryModel> it = historyModels.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            LoginHistoryModel passModel = it.next();
                            if (passModel != null && !TextUtils.isEmpty(passModel.uid) && !TextUtils.isEmpty(passModel.displayname) && !TextUtils.isEmpty(passModel.bduss)) {
                                model = new BoxLoginHistoryModel(passModel.uid, passModel.displayname, passModel.username, passModel.portrait, passModel.portraitSign, passModel.recent, passModel.loginType, passModel.bduss);
                                break;
                            }
                        }
                        result.setEnable(true);
                        result.setHistoryModel(model);
                        callback.onResult(result);
                    }

                    public void onFailure() {
                        callback.onResult(result);
                    }
                });
                return;
            }
            result.setSupport(false);
            callback.onResult(result);
        }
    }

    public String getClientId(Context context) {
        return SapiUtils.getClientId(context);
    }

    public void preGetPhoneInfo(Context context, String scene, int connectTimeout, boolean withLogin, final IOneKeyLoginOptCallback callback) {
        if (callback != null) {
            SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
            if (accountService == null) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, " accountService is null");
                }
                callback.onFinish((BoxOneKeyLoginOptResult) null);
                return;
            }
            accountService.preGetPhoneInfo(context, scene, connectTimeout, withLogin, new OneKeyLoginOptCallback() {
                public void onFinish(OneKeyLoginOptResult optResult) {
                    if (optResult == null) {
                        if (AppConfig.isDebug()) {
                            Log.d(BoxSapiAccountManager.TAG, "optResult is null");
                        }
                        callback.onFinish((BoxOneKeyLoginOptResult) null);
                        return;
                    }
                    if (optResult.getCode() == 0 && optResult.getSubCode() == 0 && !TextUtils.isEmpty(optResult.getOperateType()) && !TextUtils.isEmpty(optResult.getSecurityPhone())) {
                        if (AppConfig.isDebug()) {
                            Log.d(BoxSapiAccountManager.TAG, "operateType is " + optResult.getOperateType() + "\nsecurityPhone is " + optResult.getSecurityPhone() + "\n");
                        }
                        callback.onFinish(new BoxOneKeyLoginOptResult(optResult.getCode(), optResult.getSubCode(), optResult.getOperateType(), optResult.getSecurityPhone()));
                        return;
                    }
                    callback.onFinish(new BoxOneKeyLoginOptResult(optResult.getCode(), optResult.getSubCode(), "", ""));
                }
            });
        } else if (AppConfig.isDebug()) {
            Log.d(TAG, " callback is null");
        }
    }

    public void getOneKeyLoginToken(final ITokenListener listener) {
        if (listener != null) {
            SapiAccountService accountService = SapiAccountManager.getInstance().getAccountService();
            if (accountService == null) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "SapiAccountService is null");
                }
                listener.onGetTokenComplete((JSONObject) null);
                return;
            }
            accountService.getOneKeyLoginToken(new OneKeyLoginSdkCall.TokenListener() {
                public void onGetTokenComplete(JSONObject jsonObject) {
                    if (AppConfig.isDebug() && jsonObject != null) {
                        Log.d(BoxSapiAccountManager.TAG, "onGetTokenComplete ---> TokenObject is " + jsonObject.toString());
                    }
                    listener.onGetTokenComplete(jsonObject);
                }
            });
        } else if (AppConfig.isDebug()) {
            Log.d(TAG, "ITokenListener is null");
        }
    }

    public void downloadLibMml(IDownloadLibMmlCallback listener) {
        PmsManager.getInstance().execute(new RequestParams().setRunType(MmlModelChannelKt.PMS_RUN_TYPE).addChannel(MmlModelChannelKt.buildDownloadMmlParams(listener)));
    }

    public void getUserCertInfo(IGetUserCertInfoListener listener) {
        ChildGuarderDialogUtil.INSTANCE.getUserCertInfo(listener);
    }

    public boolean shouldShowFirstPopupDialog() {
        BoxAccount boxAccount = getBoxAccount();
        return isLogin() && boxAccount != null && TextUtils.equals(boxAccount.getIsLay(), "0");
    }

    public void showFirstPopupDistributeDialog(Activity activity, String source, INickNamePortraitDialogCallback listener) {
        NickNameDialogManager.showFirstPopupDistributeDialog(activity, source, listener);
    }

    public void isShowSettingsRealNameGuide(final ISettingsRealNameGuidCallback settingsTipsCallback) {
        SapiAccountManager.getInstance().isShowRealNameGuide(new IsShowRealNameCallback() {
            public void onSuccess(IsShowRealNameGuideResult realNameGuidInfo) {
                if (realNameGuidInfo == null) {
                    settingsTipsCallback.onRealNameGuidTipsCallback((String) null);
                    return;
                }
                boolean z = true;
                if (1 != realNameGuidInfo.isGuide) {
                    z = false;
                }
                boolean isShowTips = z;
                String tipText = realNameGuidInfo.text;
                if (!isShowTips || TextUtils.isEmpty(tipText)) {
                    settingsTipsCallback.onRealNameGuidTipsCallback((String) null);
                } else {
                    settingsTipsCallback.onRealNameGuidTipsCallback(tipText);
                }
            }

            public void onFailure(IsShowRealNameGuideResult isShowRealNameGuideResult) {
                settingsTipsCallback.onRealNameGuidTipsCallback((String) null);
            }
        });
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        if (r5.equals(com.baidu.searchbox.account.dto.BoxWebBindWidgetDTOKt.BIND_MOBILE) != false) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadBindWidget(java.lang.String r5, final com.baidu.searchbox.account.IWebBindWidgetCallback r6) {
        /*
            r4 = this;
            com.baidu.android.app.account.BoxSapiAccountManager$57 r0 = new com.baidu.android.app.account.BoxSapiAccountManager$57
            r0.<init>(r6)
            r4.webBindWidgetCallback = r0
            r0 = 0
            boolean r1 = r4.isLogin(r0)
            if (r1 != 0) goto L_0x0017
            r0 = -10001(0xffffffffffffd8ef, float:NaN)
            java.lang.String r1 = "请登录"
            r6.onBindResult(r0, r1)
            return
        L_0x0017:
            com.baidu.sapi2.dto.WebBindWidgetDTO r1 = new com.baidu.sapi2.dto.WebBindWidgetDTO
            r1.<init>()
            com.baidu.sapi2.SapiAccountManager r2 = com.baidu.sapi2.SapiAccountManager.getInstance()
            com.baidu.sapi2.SapiAccount r2 = r2.getSession()
            java.lang.String r2 = r2.bduss
            r1.bduss = r2
            r2 = -1
            int r3 = r5.hashCode()
            switch(r3) {
                case -1354585052: goto L_0x0063;
                case -1211717289: goto L_0x0059;
                case -323631033: goto L_0x004f;
                case 182837821: goto L_0x0045;
                case 225949658: goto L_0x003b;
                case 1106827937: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x006c
        L_0x0031:
            java.lang.String r0 = "/wp/bindwidget-unbindemail"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0030
            r0 = 5
            goto L_0x006d
        L_0x003b:
            java.lang.String r0 = "/wp/bindwidget-bindemail"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0030
            r0 = 1
            goto L_0x006d
        L_0x0045:
            java.lang.String r0 = "/wp/bindwidget-unbindmobile"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x006d
        L_0x004f:
            java.lang.String r0 = "/wp/bindwidget-rebindemail"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0030
            r0 = 3
            goto L_0x006d
        L_0x0059:
            java.lang.String r0 = "/wp/bindwidget-rebindmobile"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0030
            r0 = 2
            goto L_0x006d
        L_0x0063:
            java.lang.String r3 = "/wp/bindwidget-bindmobile"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0030
            goto L_0x006d
        L_0x006c:
            r0 = r2
        L_0x006d:
            switch(r0) {
                case 0: goto L_0x008a;
                case 1: goto L_0x0085;
                case 2: goto L_0x0080;
                case 3: goto L_0x007b;
                case 4: goto L_0x0076;
                case 5: goto L_0x0071;
                default: goto L_0x0070;
            }
        L_0x0070:
            goto L_0x008f
        L_0x0071:
            com.baidu.sapi2.utils.enums.BindWidgetAction r0 = com.baidu.sapi2.utils.enums.BindWidgetAction.UNBIND_EMAIL
            r1.bindWidgetAction = r0
            goto L_0x008f
        L_0x0076:
            com.baidu.sapi2.utils.enums.BindWidgetAction r0 = com.baidu.sapi2.utils.enums.BindWidgetAction.UNBIND_MOBILE
            r1.bindWidgetAction = r0
            goto L_0x008f
        L_0x007b:
            com.baidu.sapi2.utils.enums.BindWidgetAction r0 = com.baidu.sapi2.utils.enums.BindWidgetAction.REBIND_EMAIL
            r1.bindWidgetAction = r0
            goto L_0x008f
        L_0x0080:
            com.baidu.sapi2.utils.enums.BindWidgetAction r0 = com.baidu.sapi2.utils.enums.BindWidgetAction.REBIND_MOBILE
            r1.bindWidgetAction = r0
            goto L_0x008f
        L_0x0085:
            com.baidu.sapi2.utils.enums.BindWidgetAction r0 = com.baidu.sapi2.utils.enums.BindWidgetAction.BIND_EMAIL
            r1.bindWidgetAction = r0
            goto L_0x008f
        L_0x008a:
            com.baidu.sapi2.utils.enums.BindWidgetAction r0 = com.baidu.sapi2.utils.enums.BindWidgetAction.BIND_MOBILE
            r1.bindWidgetAction = r0
        L_0x008f:
            com.baidu.sapi2.PassportSDK r0 = com.baidu.sapi2.PassportSDK.getInstance()
            com.baidu.sapi2.callback.WebBindWidgetCallback r2 = r4.webBindWidgetCallback
            r0.loadBindWidget(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.app.account.BoxSapiAccountManager.loadBindWidget(java.lang.String, com.baidu.searchbox.account.IWebBindWidgetCallback):void");
    }

    public void openPersonalInfoExportPage(Context context) {
        if (context != null) {
            PassportSDK.getInstance().loadPersonalInfoActivity(context, new PersonalInfoDTO(), (PersonalInfoCallback) null);
        }
    }
}
