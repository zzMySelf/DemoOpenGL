package com.baidu.android.app.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.app.account.ILoginContext;
import com.baidu.android.app.account.utils.AccountSharedpreferencesUtils;
import com.baidu.android.app.account.utils.AccountUBCHelperKt;
import com.baidu.android.app.account.utils.LogDescription;
import com.baidu.android.app.account.utils.LogUtils;
import com.baidu.android.app.account.utils.ThirdLoginUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.ext.widget.dialog.BaseDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.NormalizeGuestAccountCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.searchbox.account.AccountShareLoginProxyActivity;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IGetBoxAccountListener;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.IShareLoginInfoCallback;
import com.baidu.searchbox.account.IShareLoginResultListener;
import com.baidu.searchbox.account.ISmsLoginViewListener;
import com.baidu.searchbox.account.R;
import com.baidu.searchbox.account.component.AccountBaseComponent;
import com.baidu.searchbox.account.component.AccountComponentConfig;
import com.baidu.searchbox.account.component.AccountHalfScreenDialog;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.dialog.HalfScreenDialogActivity;
import com.baidu.searchbox.account.listener.ChildGuarderDialogUtil;
import com.baidu.searchbox.account.manager.AccountLoginDialogManager;
import com.baidu.searchbox.account.manager.BoxShareLoginDegradeManager;
import com.baidu.searchbox.account.manager.BoxSmsLoginViewManager;
import com.baidu.searchbox.account.manager.LaunchLoginGuideDialogManager;
import com.baidu.searchbox.account.manager.LoginAgreementManagerKt;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.account.result.BoxHistoryLoginResult;
import com.baidu.searchbox.account.result.BoxLoginHistoryModel;
import com.baidu.searchbox.account.result.BoxShareLoginResult;
import com.baidu.searchbox.account.userinfo.activity.UserInfoCompleteActivity;
import com.baidu.searchbox.account.view.AccountSMSLoginView;
import com.baidu.searchbox.account.view.IAccountSmsLoginView;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.ubc.UBCManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BoxLoginBridge implements IBoxLoginBridge {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = BoxAccountRuntime.isDebug();
    public static final int DEFAULT_LOGIN_SRC_MAX_LENGTH = 100;
    private static final int NICK_GUIDE_ACTIVITY_NO_RESULT = -1;
    private static final String NORMAL_ACCOUNT_SUB_TITLE = "sub_title";
    private static final String NORMAL_ACCOUNT_TITLE = "title";
    private static final String TAG = "BoxLoginBridge";
    private static final String UBC_EXT_KEY_BIND_PRE = "con_guestbd";
    private static final String UBC_EXT_KEY_PANEL = "panel";
    private static final String UBC_EXT_KEY_SHARE = "hutonghint";
    private static final String UBC_EXT_KEY_SHARE_APP = "hutongsrc";
    private static final String UBC_EXT_VALUE_BIND_BY_BIND = "0";
    private static final String UBC_EXT_VALUE_BIND_BY_LOGIN = "1";
    private static final String UBC_EXT_VALUE_CUSTOM_PANEL = "2";
    private static final String UBC_EXT_VALUE_PAGE = "0";
    private static final String UBC_EXT_VALUE_PANEL = "1";
    public static final String UBC_FROM = "from";
    public static final String UBC_PAGE = "page";
    public static final String UBC_SOURCE = "source";
    public static final String UBC_SUB_SOURCE = "subsource";
    public static final String UBC_TYPE = "type";
    public static final String UBC_VALUE = "value";
    /* access modifiers changed from: private */
    public BoxSapiAccountManager mAccountManager = ((BoxSapiAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE));
    private BoxAccountSync mAccountSync = BoxSapiAccountSync.getInstance(AppRuntime.getAppContext());
    /* access modifiers changed from: private */
    public Context mContext;
    DialogLoginListener mDialogLoginListener = new DialogLoginListener() {
        public void onFailure(WebAuthResult webAuthResult) {
            if (webAuthResult != null) {
                BoxAccountManager.webAuthErrors.put(Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg());
            } else {
                BoxAccountManager.webAuthErrors.put(Integer.valueOf(AccountUBCHelperKt.UBC_WEBAUTH_CODE_UNKONW), "未知错误");
            }
            BoxLoginBridge.this.onLoginFailure();
            LogUtils.writeOnlineLog(LogDescription.ERROR_DIALOG_OR_SHARE_LOGIN, BoxLoginBridge.this.getFailInfo(webAuthResult), "mDialoginListener", false, BoxLoginBridge.this.needUpload(webAuthResult));
            if (BoxLoginBridge.this.isLimitRegisterFailed(webAuthResult) || (BoxLoginBridge.this.isWebLoginAuthFailed(webAuthResult) && BoxLoginBridge.this.mParams != null && BoxLoginBridge.this.mParams.mLoginMode == 15)) {
                BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                boxLoginBridge.onLoginFailHintAndStat(webAuthResult, boxLoginBridge.mParams, false);
            }
        }

        public void onSuccess(WebAuthResult webAuthResult) {
            BoxLoginBridge.this.onLoginSuccess(webAuthResult);
            if (BoxLoginBridge.this.isWebLoginAuthFailed(webAuthResult) && BoxLoginBridge.this.mParams != null && BoxLoginBridge.this.mParams.mLoginMode == 15 && BoxLoginBridge.this.mParams.mLoginMode != SapiUtils.getLastLoginType()) {
                BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                boxLoginBridge.onLoginFailHintAndStat(webAuthResult, boxLoginBridge.mParams, false);
            }
        }

        public void onCancel(int loginMode, int loginViewType, int loginStyle) {
            BoxLoginBridge.this.mParams.mLoginMode = loginMode;
            BoxLoginBridge.this.mParams.mLoginViewType = loginViewType;
            BoxLoginBridge.this.mParams.loginStyle = loginStyle;
            BoxLoginBridge.this.loginFinish(-2);
        }

        public void switchLogin(int loginMode, boolean shareLoginSwitch) {
            switchLogin(loginMode, shareLoginSwitch, false, BoxLoginBridge.this.mParams.mLoginViewType, BoxLoginBridge.this.mParams.loginStyle);
        }

        public void switchLogin(int loginMode, boolean shareLoginSwitch, boolean isAcceptAgreement, int loginViewType, int loginStyle) {
            if (BoxLoginBridge.DEBUG) {
                Log.i(BoxLoginBridge.TAG, "onWeChatLoginResult result:" + loginMode);
            }
            BoxLoginBridge.this.mParams.isAcceptBrowserModeAgreement = isAcceptAgreement;
            if (BoxLoginBridge.this.mParams.mLoginMode == 5 && BoxLoginBridge.this.mContext != BdBoxActivityManager.getRealTopActivity() && (BdBoxActivityManager.getRealTopActivity() instanceof HalfScreenDialogActivity) && (BoxLoginBridge.this.mContext instanceof Activity)) {
                Context unused = BoxLoginBridge.this.mContext = BdBoxActivityManager.getRealTopActivity();
            }
            BoxLoginBridge.this.mParams.mLoginMode = loginMode;
            BoxLoginBridge.this.mParams.mLoginViewType = loginViewType;
            BoxLoginBridge.this.mParams.loginStyle = loginStyle;
            if (loginMode == 0 || loginMode == 1 || loginMode == 22 || loginMode == 16) {
                BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                boxLoginBridge.baiduLogin(boxLoginBridge.mParams, shareLoginSwitch, "");
            } else if (BoxLoginBridge.this.isOnekeyLogin()) {
                BoxLoginBridge boxLoginBridge2 = BoxLoginBridge.this;
                boxLoginBridge2.oneKeyLogin(boxLoginBridge2.mParams, BoxLoginBridge.this.mFlag);
            } else {
                BoxLoginBridge boxLoginBridge3 = BoxLoginBridge.this;
                boxLoginBridge3.thirdLogin(boxLoginBridge3.mParams, BoxLoginBridge.this.mFlag);
            }
            BoxLoginBridge boxLoginBridge4 = BoxLoginBridge.this;
            boxLoginBridge4.statisticUBC("popup", boxLoginBridge4.mParams, "1");
        }

        public void switchLoginWithPhone(int loginMode, boolean shareLoginSwitch, String phone) {
            if (BoxLoginBridge.DEBUG) {
                Log.i(BoxLoginBridge.TAG, "onWeChatLoginResult result:" + loginMode);
            }
            BoxLoginBridge.this.mParams.mLoginMode = loginMode;
            if (loginMode == 0 || loginMode == 1 || loginMode == 16) {
                BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                boxLoginBridge.baiduLogin(boxLoginBridge.mParams, shareLoginSwitch, phone);
            } else {
                BoxLoginBridge boxLoginBridge2 = BoxLoginBridge.this;
                boxLoginBridge2.thirdLogin(boxLoginBridge2.mParams, BoxLoginBridge.this.mFlag);
            }
            BoxLoginBridge boxLoginBridge3 = BoxLoginBridge.this;
            boxLoginBridge3.statisticUBC("popup", boxLoginBridge3.mParams, "1");
        }

        public void swtichHistoryLogin(int loginMode, BoxHistoryLoginResult result, ILoginResultListener listener) {
            BoxLoginBridge.this.mParams.mLoginMode = loginMode;
            BoxLoginBridge.this.mParams.loginStyle = AccountBaseComponent.mLoginStyle;
            ILoginResultListener unused = BoxLoginBridge.this.mHalfScreenResultListener = listener;
            if (result != null) {
                BoxLoginBridge.this.mParams.loginHistoryModel = result.getHistoryModel();
            }
            BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
            boxLoginBridge.historyLogin(boxLoginBridge.mParams, BoxLoginBridge.this.mFlag);
        }

        public void switchShareLogin(int loginMode, BoxShareLoginResult result, ILoginResultListener listener) {
            BoxLoginBridge.this.mParams.mLoginMode = loginMode;
            BoxLoginBridge.this.mParams.loginStyle = AccountBaseComponent.mLoginStyle;
            ILoginResultListener unused = BoxLoginBridge.this.mHalfScreenResultListener = listener;
            if (BoxLoginBridge.this.mParams.mLoginMode == 15) {
                if (result != null) {
                    BoxLoginBridge.this.mParams.mShareLoginApp = result.getFromApp();
                    BoxLoginBridge.this.mParams.mShareLoginDisplayname = result.getDisplayName();
                }
                BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                boxLoginBridge.shareLogin(boxLoginBridge.mParams, BoxLoginBridge.this.mFlag);
                BoxLoginBridge boxLoginBridge2 = BoxLoginBridge.this;
                boxLoginBridge2.statisticForShareLogin(boxLoginBridge2.mParams);
            }
        }

        public void onOtherPageSuccess() {
            BoxLoginBridge.this.loginFinish(0);
        }
    };
    /* access modifiers changed from: private */
    public int mFlag;
    /* access modifiers changed from: private */
    public ILoginResultListener mHalfScreenResultListener;
    /* access modifiers changed from: private */
    public ILoginResultListener mListener;
    private BaseDialog mLoadingView;
    /* access modifiers changed from: private */
    public boolean mLoginFinish = true;
    /* access modifiers changed from: private */
    public LoginParams mParams;

    public interface DialogLoginListener {
        void onCancel(int i2, int i3, int i4);

        void onFailure(WebAuthResult webAuthResult);

        void onOtherPageSuccess();

        void onSuccess(WebAuthResult webAuthResult);

        void switchLogin(int i2, boolean z);

        void switchLogin(int i2, boolean z, boolean z2, int i3, int i4);

        void switchLoginWithPhone(int i2, boolean z, String str);

        void switchShareLogin(int i2, BoxShareLoginResult boxShareLoginResult, ILoginResultListener iLoginResultListener);

        void swtichHistoryLogin(int i2, BoxHistoryLoginResult boxHistoryLoginResult, ILoginResultListener iLoginResultListener);
    }

    public BoxLoginBridge() {
        BoxAccountManager.oneKeyErrors.clear();
        BoxAccountManager.webAuthErrors.clear();
    }

    public void login(Context context, LoginParams params, ILoginResultListener listener) {
        login(context, params, 0, listener);
    }

    public void login(Context context, LoginParams params, int flag, ILoginResultListener listener) {
        if (DEBUG) {
            Log.i(TAG, "login");
        }
        if (params == null) {
            params = LoginParams.getDefaultParams();
        }
        LogUtils.writeOnlineLog("login", "", "login", true, false);
        this.mParams = params;
        this.mListener = listener;
        this.mFlag = flag;
        this.mContext = context;
        if (params.mLoginMode == 6) {
            SapiAccountManager.getInstance().getConfignation().smsLoginConfig.flagHideExtraEntry = Switch.ON;
        }
        if (isThirdLogin(params.mLoginMode)) {
            thirdLogin(params, flag);
        } else if (params.mLoginMode == 5) {
            this.mLoginFinish = false;
            params.mLoginViewType = 1;
            AccountLoginDialogManager.showLoginComponentDialog(context, params, this.mDialogLoginListener, new AccountHalfScreenDialog.OnAccountComponentButtonClickListener() {
                public void onButtonClick(int buttonType) {
                    if (BoxLoginBridge.this.mListener != null && buttonType == 8) {
                        BoxLoginBridge.this.mListener.onResult(-2);
                    }
                }
            });
            return;
        } else if (params.mLoginMode == 12 || params.mLoginMode == 13 || params.mLoginMode == 14) {
            oneKeyLogin(params, flag);
        } else if (params.mLoginMode == 15) {
            shareLogin(params, flag);
        } else if (params.mLoginMode == 22) {
            historyLogin(params, flag);
        } else if (params.mLoginMode == 21) {
            autoLogin(params);
        } else {
            baiduLogin(params, false, "");
        }
        if (params.mLoginMode == 10) {
            statisticUBC("popup", params, "2");
        } else if (params.mLoginMode == 15) {
            statisticForShareLogin(params);
        } else if (params.mLoginMode == 12 || params.mLoginMode == 13 || params.mLoginMode == 14) {
            statisticUBC("popup", params, "0");
        } else {
            statisticUBC("popup", params, "0");
        }
    }

    /* access modifiers changed from: private */
    public void baiduLogin(final LoginParams params, boolean shareLoginSwitch, String phone) {
        if (DEBUG) {
            Log.i(TAG, "baiduLogin");
        }
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.openEnterAnimId = R.anim.login_slide_in_from_bottom;
        webLoginDTO.closeExitAnimId = R.anim.login_slide_out_from_top;
        webLoginDTO.openExitAnimId = R.anim.account_hold;
        webLoginDTO.closeEnterAnimId = R.anim.account_hold;
        webLoginDTO.statExtra = getLoginSrcToPass(params);
        if (shareLoginSwitch) {
            webLoginDTO.shareV2Disable = true;
        } else {
            webLoginDTO.shareV2Disable = false;
        }
        if (16 == params.mLoginMode) {
            webLoginDTO.excludeTypes = AccountBaseComponent.filterLoginStyle(params);
        }
        webLoginDTO.finishActivityAfterSuc = false;
        WebLoginDTO.Config loginConfig = getThirdLoginConfig(params.mThirdLogin);
        loginConfig.supportTouchGuide = false;
        webLoginDTO.config = loginConfig;
        webLoginDTO.loginType = searchbox2passLoginType(params.mLoginMode);
        webLoginDTO.extraParams.add(SapiWebView.EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN);
        webLoginDTO.extraParams.add(SapiWebView.EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER);
        webLoginDTO.isAcceptBrowseModeAgreement = params.isAcceptBrowserModeAgreement;
        if (!TextUtils.isEmpty(phone)) {
            webLoginDTO.preSetUname = phone;
        }
        passportSDK.startLogin(this.mContext, new WebAuthListener() {
            public void onSuccess(WebAuthResult result) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "baiduLogin-onSuccess");
                }
                BoxLoginBridge.this.onLoginResultCallBack(result);
            }

            public void onFailure(WebAuthResult result) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "baiduLogin-onFailure");
                }
                BoxAccountManager.webAuthErrors.put(Integer.valueOf(result.getResultCode()), result.getResultMsg());
                if (BoxLoginBridge.this.mParams.isHistoryFailJumpPass()) {
                    BoxLoginBridge.this.mParams.mHistoryFailJumpPass = false;
                    BoxLoginBridge.this.loginFinish(-1);
                } else {
                    BoxLoginBridge.this.onLoginFailure();
                }
                LogUtils.writeOnlineLog(LogDescription.ERROR_BAIDU_LOGIN, BoxLoginBridge.this.getFailInfo(result), "baiduLogin", false, BoxLoginBridge.this.needUpload(result));
                BoxLoginBridge.this.onLoginFailHintAndStat(result, params, true);
            }

            public void beforeSuccess(SapiAccount session) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "baiduLogin-beforeSuccess");
                }
            }
        }, webLoginDTO);
    }

    /* access modifiers changed from: private */
    public void thirdLogin(final LoginParams params, int flag) {
        if (DEBUG) {
            Log.i(TAG, "thirdLogin");
        }
        this.mFlag = flag;
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebSocialLoginDTO socialLoginDTO = new WebSocialLoginDTO();
        socialLoginDTO.openExitAnimId = R.anim.account_hold;
        socialLoginDTO.closeEnterAnimId = R.anim.account_hold;
        socialLoginDTO.socialType = searchbox2PassLoginSocialType(params.mLoginMode);
        socialLoginDTO.finishActivityAfterSuc = false;
        socialLoginDTO.statExtra = getLoginSrcToPass(params);
        socialLoginDTO.context = this.mContext;
        socialLoginDTO.needBpPush = params.mNeedBpPush;
        socialLoginDTO.pushBpFrom = params.mPushBpFrom;
        passportSDK.loadThirdPartyLogin((WebAuthListener) new ThirdLoginCallback() {
            public void onSuccess(WebAuthResult result) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "thirdLogin-onSuccess");
                }
                BoxLoginBridge.this.onLoginResultCallBack(result);
                if (result != null) {
                    BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                    if (boxLoginBridge.isNoSupportGuestLogin(boxLoginBridge.mFlag)) {
                        result.finishActivity();
                    }
                }
            }

            public void onFailure(WebAuthResult result) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "thirdLogin-onFailure");
                }
                BoxAccountManager.webAuthErrors.put(Integer.valueOf(result.getResultCode()), result.getResultMsg());
                BoxLoginBridge.this.onLoginFailure();
                LogUtils.writeOnlineLog(LogDescription.ERROR_THIRD_LOGIN, BoxLoginBridge.this.getFailInfo(result), "thirdLogin", false, BoxLoginBridge.this.needUpload(result));
                BoxLoginBridge.this.onLoginFailHintAndStat(result, params, true);
            }

            public void onAuthSuccess() {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "thirdLogin-onAuthSuccess");
                }
                BoxLoginBridge.this.handleShareLoginResult(1000);
                BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                boxLoginBridge.statisticUBC(BoxAccountContants.LOGIN_TYPE_AUTH_SUCCESS, boxLoginBridge.mParams, "0");
            }

            public void onAuthFailure(int i2, String s) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "thirdLogin-onAuthFailure");
                }
                BoxLoginBridge.this.handleShareLoginResult(-1001);
            }
        }, socialLoginDTO);
    }

    /* access modifiers changed from: private */
    public void shareLogin(final LoginParams params, final int flag) {
        if (DEBUG) {
            Log.i(TAG, "shareLogin");
        }
        ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).getShareLoginInfo(new IShareLoginInfoCallback() {
            public void onResult(BoxShareLoginResult result) {
                if (BoxLoginBridge.this.mContext != null) {
                    if (result == null || (TextUtils.equals(result.getFromApp(), params.mShareLoginApp) && TextUtils.equals(result.getDisplayName(), params.mShareLoginDisplayname) && !BoxLoginBridge.this.checkAppInstalled(result.getAppPkg()))) {
                        BoxLoginBridge.this.mDialogLoginListener.onFailure((WebAuthResult) null);
                        return;
                    }
                    int unused = BoxLoginBridge.this.mFlag = flag;
                    WebSocialLoginDTO socialLoginDTO = new WebSocialLoginDTO();
                    socialLoginDTO.openExitAnimId = R.anim.account_hold;
                    socialLoginDTO.closeEnterAnimId = R.anim.account_hold;
                    socialLoginDTO.finishActivityAfterSuc = false;
                    socialLoginDTO.statExtra = BoxLoginBridge.this.getLoginSrcToPass(params);
                    socialLoginDTO.context = BoxLoginBridge.this.mContext;
                    Intent intent = new Intent(BoxLoginBridge.this.mContext, AccountShareLoginProxyActivity.class);
                    intent.putExtra(AccountShareLoginProxyActivity.EXTRA_APP_KEY, params.mShareLoginApp);
                    intent.putExtra(AccountShareLoginProxyActivity.EXTRA_DISPLAY_KEY, params.mShareLoginDisplayname);
                    ThirdLoginUtils.setDialogLoginListener(BoxLoginBridge.this.mDialogLoginListener);
                    BoxLoginBridge.this.mContext.startActivity(intent);
                }
            }
        }, 1500);
    }

    private void autoLogin(LoginParams params) {
        PassportSDK.getInstance().startSchemeLoginForQA(this.mContext, params.mAutoLoginUrl, new WebAuthListener() {
            public void onSuccess(WebAuthResult result) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "baiduLogin-onSuccess");
                }
                BoxLoginBridge.this.onLoginResultCallBack(result);
                BoxLoginBridge.this.hideLoadingView();
            }

            public void onFailure(WebAuthResult result) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "baiduLogin-onFailure");
                }
                BoxAccountManager.webAuthErrors.put(Integer.valueOf(result.getResultCode()), result.getResultMsg());
                BoxLoginBridge.this.onLoginFailure();
                LogUtils.writeOnlineLog(LogDescription.ERROR_ONEKEY_FAIL_LOGIN, BoxLoginBridge.this.getFailInfo(result), "autoLogin", false, BoxLoginBridge.this.needUpload(result));
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean checkAppInstalled(String pkgName) {
        PackageInfo packageInfo;
        if (pkgName == null || pkgName.isEmpty()) {
            return false;
        }
        try {
            packageInfo = AppRuntime.getAppContext().getPackageManager().getPackageInfo(pkgName, 0);
        } catch (Exception e2) {
            LogUtils.e(e2.toString());
            packageInfo = null;
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    private void showLoadingView() {
        Context context = this.mContext;
        if (!(this.mContext == BdBoxActivityManager.getRealTopActivity() || BdBoxActivityManager.getRealTopActivity() == null || !(this.mContext instanceof Activity))) {
            context = BdBoxActivityManager.getRealTopActivity();
        }
        try {
            BaseDialog baseDialog = new BaseDialog(context, R.style.dialogTransparent);
            this.mLoadingView = baseDialog;
            baseDialog.setCanceledOnTouchOutside(false);
            this.mLoadingView.setCancelable(false);
            this.mLoadingView.setEnableImmersion(true);
            this.mLoadingView.setContentView(com.baidu.android.common.ui.R.layout.novel_loading_layout);
            View rootView = this.mLoadingView.findViewById(com.baidu.android.common.ui.R.id.root_container);
            ProgressBar progressBar = (ProgressBar) this.mLoadingView.findViewById(com.baidu.android.common.ui.R.id.loading_bar);
            TextView msg = (TextView) this.mLoadingView.findViewById(com.baidu.android.common.ui.R.id.message);
            if (rootView != null) {
                rootView.setBackground(ResourcesCompat.getDrawable(rootView.getResources(), com.baidu.android.common.loading.R.drawable.novel_loading_bg, (Resources.Theme) null));
            }
            if (progressBar != null) {
                progressBar.setIndeterminateDrawable(ResourcesCompat.getDrawable(progressBar.getResources(), com.baidu.searchbox.ui.R.drawable.loading_progress_animation, (Resources.Theme) null));
            }
            if (msg != null) {
                msg.setTextColor(msg.getResources().getColor(com.baidu.android.common.loading.R.color.loading_text_color));
                msg.setText(R.string.account_onekey_loading);
            }
            this.mLoadingView.show();
        } catch (Throwable e2) {
            LogUtils.e("showLoadingView", e2.getMessage());
        }
    }

    public void hideLoadingView() {
        BaseDialog baseDialog;
        Context context = this.mContext;
        if ((context instanceof Activity) && !((Activity) context).isFinishing() && (baseDialog = this.mLoadingView) != null) {
            baseDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void historyLogin(final LoginParams params, int flag) {
        showLoadingView();
        if (DEBUG) {
            LogUtils.i(TAG, "historyLogin");
        }
        this.mFlag = flag;
        if (!HttpManager.getDefault(BoxAccountRuntime.getAppContext()).isNetWorkConnected()) {
            hideLoadingView();
            UniversalToast.makeText(BoxAccountRuntime.getAppContext(), R.string.account_network_exception).show();
            BoxAccountManager.webAuthErrors.put(Integer.valueOf(AccountUBCHelperKt.UBC_WEBAUTH_CODE_NO_NETWORK), (Object) null);
            onLoginFailure();
        } else if (params.loginHistoryModel == null) {
            hideLoadingView();
            baiduLogin(params, false, "");
        } else {
            SapiAccountManager.getInstance().loadHistoryActionLoginFromNa(parsePassLoginHistoryModel(params.loginHistoryModel), new LoginHistoryCallback() {
                public void onLoginSuccess(SapiAccount sapiAccount) {
                    BoxLoginBridge.this.hideLoadingView();
                    if (!SapiAccountManager.getInstance().validate(sapiAccount) && BoxLoginBridge.DEBUG) {
                        LogUtils.i(BoxLoginBridge.TAG, "历史登录成功，但是互通信息同步失败");
                    }
                    BoxLoginBridge.this.onLoginSuccess((SapiResult) null);
                }

                public void onLoginFailure() {
                    BoxLoginBridge.this.hideLoadingView();
                    BoxLoginBridge.this.onLoginFailure();
                    if (params.mLoginSrc != null && !BoxAccountContants.LOGIN_VALUE_HOMEPAGE_TASK.equals(params.mLoginSrc.getSrc())) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), com.baidu.account.R.string.account_login_failure_switch_other).show();
                    }
                    BoxAccountManager.webAuthErrors.put(Integer.valueOf(AccountUBCHelperKt.UBC_WEBAUTH_CODE_UNKONW), "");
                    LogUtils.writeOnlineLog(LogDescription.ERROR_HISTORY_LOGIN, "History login data is empty", "historyLogin", false, true);
                }
            });
        }
    }

    private LoginHistoryModel parsePassLoginHistoryModel(BoxLoginHistoryModel loginHistoryModel) {
        LoginHistoryModel model = new LoginHistoryModel();
        model.uid = loginHistoryModel.getUid();
        model.displayname = loginHistoryModel.getDisplayName();
        model.username = loginHistoryModel.getUserName();
        model.portrait = loginHistoryModel.getPortrait();
        model.portraitSign = loginHistoryModel.getPortraitSign();
        model.recent = loginHistoryModel.getRecent();
        model.loginType = loginHistoryModel.getLoginType();
        model.bduss = loginHistoryModel.getBduss();
        return model;
    }

    /* access modifiers changed from: private */
    public void oneKeyLogin(final LoginParams params, int flag) {
        showLoadingView();
        if (DEBUG) {
            Log.i(TAG, "oneKeyLogin");
        }
        this.mFlag = flag;
        WebSocialLoginDTO socialLoginDTO = new WebSocialLoginDTO();
        socialLoginDTO.openExitAnimId = R.anim.account_hold;
        socialLoginDTO.closeEnterAnimId = R.anim.account_hold;
        socialLoginDTO.finishActivityAfterSuc = false;
        socialLoginDTO.statExtra = getLoginSrcToPass(params);
        socialLoginDTO.context = this.mContext;
        GetOneKeyLoginStateDTO dto = new GetOneKeyLoginStateDTO();
        dto.connectTimeout = 5000;
        AccountUBCHelperKt.statisticUBCGetOneKeyInfo(AccountUBCHelperKt.loginViewType2From(this.mParams.mLoginViewType), BoxAccountContants.LOGIN_TYPE_HUANHAO, (String) null, params.mLoginSrc.getSrc());
        SapiAccountManager.getInstance().getAccountService().getOneKeyLoginIsAvailable(dto, new OneKeyLoginCallback() {
            public void available(OneKeyLoginResult result) {
                if (result == null) {
                    BoxAccountManager.oneKeyErrors.put(-1, "返回原因为空");
                }
                String sign = BoxLoginBridge.this.machiningSignWithCuid(result.sign);
                if (!result.enable) {
                    BoxLoginBridge.this.getOneKeyLoginResultCode((OneKeyLoginResult) null, params);
                    BoxLoginBridge.this.onLoginFailure();
                    LogUtils.writeOnlineLog(LogDescription.ERROR_ONEKEY_LOGIN, "onekey not available", "onekeyLogin", false, true);
                }
                final boolean oneKeyLoginOpenVerficationPage = params.mOneKeyLoginOpenVerficationPage;
                PassportSDK.getInstance().loadOneKeyLogin(BoxLoginBridge.this.mContext, sign, oneKeyLoginOpenVerficationPage, new OneKeyLoginCallback() {
                    public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
                        BoxLoginBridge.this.onLoginResultCallBack(oneKeyLoginResult);
                        BoxLoginBridge.this.hideLoadingView();
                        if (BoxLoginBridge.this.mAccountManager != null) {
                            BoxLoginBridge.this.mAccountManager.updateLocalOneKeyInfo(oneKeyLoginResult);
                        }
                    }

                    public void onFail(OneKeyLoginResult oneKeyLoginResult) {
                        BoxLoginBridge.this.getOneKeyLoginResultCode(oneKeyLoginResult, params);
                        if (oneKeyLoginResult == null) {
                            BoxAccountManager.oneKeyErrors.put(-1, "返回原因为空");
                        } else {
                            BoxAccountManager.oneKeyErrors.put(Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg());
                        }
                        if (BoxLoginBridge.this.isLimitRegisterFailed(oneKeyLoginResult) || !oneKeyLoginOpenVerficationPage) {
                            BoxLoginBridge.this.onLoginFailure();
                            LogUtils.writeOnlineLog(LogDescription.ERROR_LOAD_ONEKEY_LOGIN, BoxLoginBridge.this.getFailInfo(oneKeyLoginResult), "onekeyLogin", false, true);
                        } else {
                            BoxLoginBridge.this.oneKeyLoginFailToLogin(params, false, "");
                        }
                        BoxLoginBridge.this.onLoginFailHintAndStat(oneKeyLoginResult, params, true);
                    }

                    public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
                        super.onGuideProcess(oneKeyLoginResult);
                        BoxLoginBridge.this.hideLoadingView();
                    }
                });
            }

            public void unAvailable(OneKeyLoginResult result) {
                BoxLoginBridge.this.getOneKeyLoginResultCode(result, params);
                BoxAccountManager.oneKeyErrors.put(Integer.valueOf(result.getResultCode()), result.getResultMsg());
                BoxLoginBridge.this.onLoginFailure();
                LogUtils.writeOnlineLog(LogDescription.EVENT_ONEKEY_LOGIN_UNAVAIL, BoxLoginBridge.this.getFailInfo(result), "onekeyLogin", false, true);
                BoxLoginBridge.this.onLoginFailHintAndStat(result, params, true);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getOneKeyLoginResultCode(OneKeyLoginResult oneKeyLoginResult, LoginParams params) {
        int resultCode = -1;
        if (oneKeyLoginResult != null) {
            resultCode = oneKeyLoginResult.getResultCode();
        }
        AccountUBCHelperKt.statisticUBCGetOneKeyInfo(AccountUBCHelperKt.loginViewType2From(this.mParams.mLoginViewType), "huanhao_fail", Integer.toString(resultCode), params.mLoginSrc.getSrc());
    }

    /* access modifiers changed from: private */
    public void oneKeyLoginFailToLogin(LoginParams params, boolean shareLoginSwitch, String phone) {
        if (DEBUG) {
            Log.i(TAG, "baiduLogin");
        }
        PassportSDK passportSDK = PassportSDK.getInstance();
        WebLoginDTO webLoginDTO = new WebLoginDTO();
        webLoginDTO.openEnterAnimId = R.anim.login_slide_in_from_bottom;
        webLoginDTO.closeExitAnimId = R.anim.login_slide_out_from_top;
        webLoginDTO.openExitAnimId = R.anim.account_hold;
        webLoginDTO.closeEnterAnimId = R.anim.account_hold;
        webLoginDTO.statExtra = getLoginSrcToPass(params);
        if (shareLoginSwitch) {
            webLoginDTO.shareV2Disable = true;
        } else {
            webLoginDTO.shareV2Disable = false;
        }
        webLoginDTO.finishActivityAfterSuc = false;
        WebLoginDTO.Config loginConfig = getThirdLoginConfig(params.mThirdLogin);
        loginConfig.supportTouchGuide = false;
        webLoginDTO.config = loginConfig;
        webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL;
        webLoginDTO.extraParams.add(SapiWebView.EXTRA_SMS_LOGIN_SHOW_SOCIAL_LOGIN);
        webLoginDTO.extraParams.add(SapiWebView.EXTRA_SUPPORT_OVERSEAS_PHONE_NUMBER);
        webLoginDTO.extraParams.add(SapiWebView.EXTRA_ERROR_ONE_KEY_LOGIN_FAIL);
        if (!TextUtils.isEmpty(phone)) {
            webLoginDTO.preSetUname = phone;
        }
        passportSDK.startLogin(this.mContext, new WebAuthListener() {
            public void onSuccess(WebAuthResult result) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "baiduLogin-onSuccess");
                }
                BoxLoginBridge.this.onLoginResultCallBack(result);
                BoxLoginBridge.this.hideLoadingView();
            }

            public void onFailure(WebAuthResult result) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "baiduLogin-onFailure");
                }
                BoxAccountManager.webAuthErrors.put(Integer.valueOf(result.getResultCode()), result.getResultMsg());
                BoxLoginBridge.this.onLoginFailure();
                LogUtils.writeOnlineLog(LogDescription.ERROR_ONEKEY_FAIL_LOGIN, BoxLoginBridge.this.getFailInfo(result), "onekeyLoginFailToLogin", false, BoxLoginBridge.this.needUpload(result));
            }

            public void beforeSuccess(SapiAccount session) {
                if (BoxLoginBridge.DEBUG) {
                    Log.i(BoxLoginBridge.TAG, "baiduLogin-beforeSuccess");
                }
            }
        }, webLoginDTO);
    }

    /* access modifiers changed from: private */
    public String getFailInfo(SapiResult result) {
        if (result == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("resultCode = ").append(result.getResultCode());
        builder.append(", resultMsg = ").append(result.getResultMsg());
        return builder.toString();
    }

    /* access modifiers changed from: private */
    public boolean needUpload(SapiResult result) {
        if (result == null || -301 == result.getResultCode()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public String machiningSignWithCuid(String sign) {
        if (TextUtils.isEmpty(sign) || sign.length() <= 7) {
            return null;
        }
        return sign.substring(0, 8) + MD5Util.toMd5((sign.substring(8) + MD5Util.toMd5(DeviceId.getDeviceID(AppRuntime.getAppContext()).getBytes(), false)).getBytes(), false);
    }

    /* access modifiers changed from: private */
    public void onLoginResultCallBack(SapiResult result) {
        if (!isGuestLogin() || !isNoSupportGuestLogin(this.mFlag)) {
            onLoginSuccess(result);
            return;
        }
        onLoginSuccess(result, false, false, false);
        bindPhone(true, result);
    }

    /* access modifiers changed from: private */
    public void onLoginSuccess(SapiResult result) {
        onLoginSuccess(result, true, false, false);
    }

    /* access modifiers changed from: private */
    public void onLoginSuccess(SapiResult result, boolean isFinish, boolean isBindSuccess, boolean isByLogin) {
        String ubcExtBind;
        if (DEBUG) {
            Log.i(TAG, "onLoginSuccess isLogin:");
        }
        DefaultSharedPrefsWrapper.getInstance().putString(BoxAccountContants.ACCOUNT_SHARE_LOGIN_USERNAME, "");
        AccountCheckBdussAndUploadManager.markAccountBdussLose(false);
        if (ILoginContext.Impl.get().isBrowserMode()) {
            ILoginContext.Impl.get().changeBrowserModeToAuthority();
        }
        LaunchLoginGuideDialogManager.recordLoginGuideVersionAndFlushWarmVersion();
        switch (SapiUtils.getLastLoginType()) {
            case 1:
                this.mParams.mLoginMode = 0;
                break;
            case 2:
                this.mParams.mLoginMode = 1;
                break;
            case 3:
                this.mParams.mLoginMode = 8;
                break;
            case 4:
                this.mParams.mLoginMode = 2;
                break;
            case 5:
                this.mParams.mLoginMode = 4;
                break;
            case 6:
                this.mParams.mLoginMode = 3;
                break;
            case 8:
            case 9:
                this.mParams.mLoginMode = 15;
                DefaultSharedPrefsWrapper.getInstance().putString(BoxAccountContants.ACCOUNT_SHARE_LOGIN_USERNAME, AccountCheckBdussAndUploadManager.getEncodedUserName(this.mAccountManager.getSapiSession().getSession("BoxAccount_displayname")));
                break;
            case 15:
                this.mParams.mLoginMode = 11;
                break;
            case 16:
                this.mParams.mLoginMode = 12;
                break;
            case 17:
                this.mParams.mLoginMode = 13;
                break;
            case 18:
                this.mParams.mLoginMode = 14;
                break;
            case 21:
                this.mParams.mLoginMode = 22;
                break;
            case 100:
                this.mParams.mLoginMode = 17;
                break;
        }
        UserAccountActionItem loginSrc = this.mParams.mLoginSrc;
        if (isBindSuccess) {
            loginSrc.setAction(UserAccountActionItem.UserAccountAction.BIND.getName());
        } else {
            loginSrc.setAction(UserAccountActionItem.UserAccountAction.LOGIN.getName());
        }
        this.mAccountSync.boxLoginSync(loginSrc);
        if (isBindSuccess) {
            if (isByLogin) {
                ubcExtBind = "1";
            } else {
                ubcExtBind = "0";
            }
            statisticUBC("bd_success", this.mParams, (String) null, (String) null, ubcExtBind);
        } else {
            statisticUBC("success", this.mParams, (String) null, isGuestLogin() ? "guest" : null, (String) null);
        }
        if (ILoginContext.Impl.get().isBrowserMode()) {
            ILoginContext.Impl.get().changeBrowserModeToAuthority();
        }
        if (isFinish) {
            onFinish(result);
        }
    }

    /* access modifiers changed from: private */
    public void onFinish(final SapiResult result) {
        this.mAccountManager.getAccountInfoFromServer(new IGetBoxAccountListener() {
            public void onSuccess(BoxAccount account) {
                boolean unused = BoxLoginBridge.this.mLoginFinish = true;
                BoxLoginBridge.this.mAccountManager.notifyAllLoginStatusChangedListeners(false, true);
                SapiResult sapiResult = result;
                if (sapiResult instanceof WebAuthResult) {
                    ((WebAuthResult) sapiResult).finishActivity();
                } else if (sapiResult instanceof NormalizeGuestAccountResult) {
                    ((NormalizeGuestAccountResult) sapiResult).finishActivity();
                }
                BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                boolean noSupportGuestLogin = boxLoginBridge.isNoSupportGuestLogin(boxLoginBridge.mFlag);
                if (!BoxLoginBridge.this.isGuestLogin() || !noSupportGuestLogin) {
                    BoxLoginBridge.this.loginFinish(0);
                } else {
                    BoxLoginBridge.this.loginFinish(-1);
                }
            }

            public void onFailed(int errorCode) {
                BoxLoginBridge.this.loginFinish(-1);
                SapiResult sapiResult = result;
                if (sapiResult instanceof WebAuthResult) {
                    ((WebAuthResult) sapiResult).finishActivity();
                } else if (sapiResult instanceof NormalizeGuestAccountResult) {
                    ((NormalizeGuestAccountResult) sapiResult).finishActivity();
                }
                LogUtils.writeOnlineLog(LogDescription.ERROR_REQUEST_GET, "login success, but fail to get user info, errorCode = " + errorCode, "onFinish", false, false);
            }
        });
    }

    public void changeToUserInfoCompleteActivity(Context context, boolean isInitialPortrait) {
        Intent intent = new Intent(context, UserInfoCompleteActivity.class);
        intent.putExtra(UserInfoCompleteActivity.HAS_PORTRAIT, isInitialPortrait);
        AccountSharedpreferencesUtils.getInstance().setStringPreference("1", "1");
        PreferenceUtils.setString("1", "1");
        ActivityUtils.startActivitySafely(context, intent);
    }

    /* access modifiers changed from: private */
    public void onLoginFailure() {
        if (isOnekeyLogin() && this.mParams.isOnekeyFailJumpPass()) {
            this.mDialogLoginListener.switchLogin(1, false);
        } else if (!isHistoryLogin() || !this.mParams.isOnekeyFailJumpPass()) {
            loginFinish(-1);
        } else {
            this.mParams.mHistoryFailJumpPass = true;
            this.mDialogLoginListener.switchLogin(22, false);
        }
        AccountUBCHelperKt.ubc5455(this.mParams);
        BoxShareLoginDegradeManager.INSTANCE.updateShareLoginFailure(this.mParams);
        hideLoadingView();
    }

    /* access modifiers changed from: private */
    public void loginFinish(int resultType) {
        if (DEBUG) {
            Log.i(TAG, "loginFinish" + resultType);
        }
        switch (resultType) {
            case -1:
                statisticUBCOnResult("fail");
                handleLoginResult(resultType);
                break;
            case 0:
                statisticUBCOnResult("success");
                DefaultSharedPrefsWrapper.getInstance().putBoolean(LoginAgreementManagerKt.FIRST_LOGIN, false);
                handleLoginResult(resultType);
                AccountBaseComponent.mLoginStyle = -1;
                break;
            default:
                statisticUBCOnResult("cancel");
                handleLoginResult(-2);
                break;
        }
        sendAccessibilityText(resultType);
        ILoginResultListener iLoginResultListener = this.mHalfScreenResultListener;
        if (iLoginResultListener != null) {
            iLoginResultListener.onResult(resultType);
        }
        AccountUBCHelperKt.setSPassLogin(false);
    }

    private void sendAccessibilityText(int resultType) {
        AccessibilityManager manager;
        AccessibilityEvent event;
        String text;
        Context context = this.mContext;
        if (context != null && (manager = (AccessibilityManager) context.getSystemService("accessibility")) != null && manager.isEnabled() && (event = AccessibilityEvent.obtain()) != null) {
            event.setEventType(16384);
            event.setClassName(getClass().getName());
            event.setPackageName(this.mContext.getPackageName());
            if (resultType == 0) {
                text = this.mContext.getResources().getString(R.string.account_accessibility_login_success);
            } else if (resultType == -1) {
                text = this.mContext.getResources().getString(R.string.account_accessibility_login_fail);
            } else {
                text = this.mContext.getResources().getString(R.string.account_accessibility_login_cancel);
            }
            event.getText().add(text);
            manager.sendAccessibilityEvent(event);
        }
    }

    private void statisticUBCOnResult(String resultType) {
        int needMoreExt;
        String str;
        if (this.mParams.mLoginViewType != 7) {
            LoginParams loginParams = this.mParams;
            loginParams.loginStyle = toValidateLoginStyle(loginParams.loginStyle);
            String from = AccountUBCHelperKt.loginViewType2From(this.mParams.mLoginViewType);
            String page = AccountUBCHelperKt.loginStyle2Page(this.mParams.loginStyle);
            if (resultType.equals("success")) {
                needMoreExt = 1;
            } else if (resultType.equals("fail")) {
                needMoreExt = 2;
            } else {
                needMoreExt = 0;
            }
            if (AccountUBCHelperKt.getSPassLogin() != 0) {
                str = "pass";
            } else {
                str = loginMode2UBCRefactoryValue(this.mParams.mLoginMode);
            }
            String value = str;
            if (value.equals("pass") && (resultType.equals("success") || resultType.equals("fail"))) {
                statisticUBCValue(BoxAccountContants.SHARE_LOGIN_UBC_ID_REFACTORY, "blue_white", "blue_white", resultType, value, needMoreExt);
            }
            statisticUBCValue(BoxAccountContants.SHARE_LOGIN_UBC_ID_REFACTORY, from, page, resultType, value, needMoreExt);
        }
    }

    private String loginMode2UBCRefactoryValue(int loginMode) {
        switch (loginMode) {
            case 0:
            case 16:
                return "pass";
            case 1:
            case 5:
            case 6:
            case 10:
                return "sms";
            case 2:
            case 18:
                return "wechat";
            case 3:
            case 19:
                return "qq";
            case 4:
                return "weibo";
            case 12:
                return BoxAccountContants.LOGIN_VALUE_OPERATOR_YD;
            case 13:
                return BoxAccountContants.LOGIN_VALUE_OPERATOR_LT;
            case 14:
                return BoxAccountContants.LOGIN_VALUE_OPERATOR_DX;
            case 15:
                return "hutong";
            case 17:
                return "yy";
            case 22:
                return "hislogin";
            default:
                return "";
        }
    }

    private void statisticUBCValue(String ubcId, String from, String page, String type, String value, int needMoreExt) {
        if (!type.equals("cancel") || !value.equals("pass")) {
            LoginParams loginParams = this.mParams;
            AccountUBCHelperKt.statisticUbcOnEvent(ubcId, from, page, type, value, (loginParams == null || loginParams.mLoginSrc == null) ? "" : this.mParams.mLoginSrc.getSrc(), Integer.valueOf(needMoreExt));
        }
    }

    /* access modifiers changed from: package-private */
    public void handleLoginResult(final int resultCode) {
        UiThreadUtil.getMainHandler().post(new Runnable() {
            public void run() {
                if (BoxLoginBridge.this.mListener != null) {
                    BoxLoginBridge.this.mListener.onResult(resultCode);
                    BoxLoginBridge.this.release();
                }
                if (resultCode == 0) {
                    ChildGuarderDialogUtil.INSTANCE.ifChildToCheckDialog();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void handleShareLoginResult(final int resultCode) {
        UiThreadUtil.getMainHandler().post(new Runnable() {
            public void run() {
                if (BoxLoginBridge.this.mListener != null && (BoxLoginBridge.this.mListener instanceof IShareLoginResultListener)) {
                    ((IShareLoginResultListener) BoxLoginBridge.this.mListener).onAuthResult(resultCode);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void release() {
        if (this.mParams.mLoginMode != 5 && this.mParams.mLoginMode != 10 && this.mLoginFinish) {
            this.mListener = null;
            this.mContext = null;
        }
    }

    private String searchbox2passLoginType(int loginMode) {
        switch (loginMode) {
            case 0:
                return WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            case 1:
                return WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
            case 6:
                return WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
            case 16:
                return WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            default:
                return WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
        }
    }

    private SocialType searchbox2PassLoginSocialType(int loginMode) {
        switch (loginMode) {
            case 2:
                return SocialType.WEIXIN;
            case 3:
                return SocialType.QQ_SSO;
            case 4:
                return getSinaLoginType();
            case 17:
                return SocialType.YY;
            case 18:
                return SocialType.WEIXIN_BACKGROUND;
            case 19:
                return SocialType.QQ_SSO_BACKGROUND;
            default:
                return null;
        }
    }

    private boolean isThirdLogin(int loginMode) {
        return loginMode == 3 || loginMode == 2 || loginMode == 4 || loginMode == 17 || loginMode == 18 || loginMode == 19;
    }

    public void combineLogin(Context context, LoginParams params, int flag, ILoginResultListener listener) {
        if ((params == null || params.mThirdLogin) && isGuestLogin()) {
            bindPhone(context, params, listener);
        } else {
            login(context, params, flag, listener);
        }
    }

    public IAccountSmsLoginView startBoxSmsLoginView(Context context, LoginParams params, ISmsLoginViewListener smsViewLoginListener) {
        if (DEBUG) {
            Log.i(TAG, "login");
        }
        if (params == null) {
            params = LoginParams.getDefaultParams();
        }
        this.mParams = params;
        this.mContext = context;
        this.mListener = smsViewLoginListener;
        if (params.mLoginMode != 10) {
            return null;
        }
        statisticUBC("popup", params, "2");
        return new BoxSmsLoginViewManager(context, smsViewLoginListener, this.mDialogLoginListener, getLoginSrcToPass(params), params.mShowKeyBoard).getView();
    }

    public AccountSMSLoginView startBoxSmsLoginViewV2(Context context, LoginParams params, ISmsLoginViewListener smsViewLoginListener) {
        if (DEBUG) {
            Log.i(TAG, "login");
        }
        if (params == null) {
            params = LoginParams.getDefaultParams();
        }
        this.mParams = params;
        this.mContext = context;
        this.mListener = smsViewLoginListener;
        if (params.mLoginMode != 10) {
            return null;
        }
        statisticUBC("popup", params, "2");
        AccountSMSLoginView accountSMSLoginView = new AccountSMSLoginView(context, params.mShowKeyBoard, false, 100);
        accountSMSLoginView.setSmsLoginViewListener(smsViewLoginListener);
        accountSMSLoginView.setLoginDialogListener(this.mDialogLoginListener);
        accountSMSLoginView.setSmsLoginStatExtra(getLoginSrcToPass(params));
        return accountSMSLoginView;
    }

    public void showLoginComponentDialog(Context context, AccountComponentConfig config, ILoginResultListener lister) {
        int i2;
        if (config == null) {
            config = AccountComponentConfig.getDefaulgParamsBuilder().build();
        }
        this.mParams = new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, config.mLoginSrc)).setLoginViewType(1).build();
        this.mListener = lister;
        this.mContext = context;
        if (config.mIsSupportGuest) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        this.mFlag = i2;
        this.mLoginFinish = false;
        AccountLoginDialogManager.showLoginComponentDialog(context, config, this.mDialogLoginListener);
    }

    private void doStaticsUbcOnBind(String page, String type) {
        statisticUBCValue(BoxAccountContants.SHARE_LOGIN_UBC_ID_REFACTORY, "account", page, type, loginMode2UBCRefactoryValue(this.mParams.mLoginMode), 1);
    }

    /* access modifiers changed from: private */
    public void staticsUbcOnBind(String type) {
        statisticUBCValue(BoxAccountContants.SHARE_LOGIN_UBC_ID_REFACTORY, AccountUBCHelperKt.loginViewType2From(this.mParams.mLoginViewType), AccountUBCHelperKt.loginStyle2Page(this.mParams.loginStyle), type, loginMode2UBCRefactoryValue(this.mParams.mLoginMode), 1);
    }

    private void bindPhone(boolean isLogin, SapiResult loginResult) {
        SapiAccount sapiAccount = SapiAccountManager.getInstance().getSession();
        String bduss = "";
        if (sapiAccount != null) {
            bduss = sapiAccount.bduss;
        }
        PassportSDK passportSDK = PassportSDK.getInstance();
        NormalizeGuestAccountDTO accountDTO = new NormalizeGuestAccountDTO();
        accountDTO.finishActivityAfterSuc = false;
        accountDTO.bduss = bduss;
        accountDTO.finishActivityAfterSuc = isLogin;
        JSONObject description = new JSONObject();
        try {
            String normalAccountTitle = this.mParams.mNormalAccountTitle;
            if (!TextUtils.isEmpty(normalAccountTitle)) {
                description.put("title", normalAccountTitle);
            }
            String normalAccountSubTitle = this.mParams.mNormalAccountSubTitle;
            if (!TextUtils.isEmpty(normalAccountSubTitle)) {
                description.put("sub_title", normalAccountSubTitle);
            }
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.d(TAG, "AccountNormalPage set title is error" + e2);
            }
        }
        if (description.length() > 0) {
            accountDTO.description = description.toString();
        }
        final PassportSDK passportSDK2 = passportSDK;
        final boolean z = isLogin;
        final SapiResult sapiResult = loginResult;
        final NormalizeGuestAccountDTO normalizeGuestAccountDTO = accountDTO;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (BoxLoginBridge.this.mContext != null) {
                    BoxLoginBridge.this.staticsUbcOnBind("bd_popup");
                    passportSDK2.startNormalizeGuestAccount(BoxLoginBridge.this.mContext, new NormalizeGuestAccountCallback() {
                        public void onSuccess(NormalizeGuestAccountResult result) {
                            if (z) {
                                BoxLoginBridge.this.staticsUbcOnBind("bd_success");
                                BoxLoginBridge.this.onLoginSuccess(sapiResult, true, true, z);
                                return;
                            }
                            BoxLoginBridge.this.onLoginSuccess(result, true, true, z);
                        }

                        public void onFailure(NormalizeGuestAccountResult result) {
                            if (z) {
                                BoxLoginBridge.this.onFinish(sapiResult);
                            } else {
                                BoxLoginBridge.this.onLoginFailure();
                                LogUtils.writeOnlineLog(LogDescription.ERROR_BIND_PHONE, BoxLoginBridge.this.getFailInfo(result), "bindPhone", false, BoxLoginBridge.this.needUpload(result));
                            }
                            if (result != null && result.getResultCode() != -301) {
                                UniversalToast.makeText(BoxAccountRuntime.getAppContext(), R.string.account_bind_failure).showToast();
                                BoxLoginBridge.this.onLoginFailHintAndStat(result, BoxLoginBridge.this.mParams, false);
                            }
                        }
                    }, normalizeGuestAccountDTO);
                    BoxLoginBridge boxLoginBridge = BoxLoginBridge.this;
                    boxLoginBridge.statisticUBC("bd_popup", boxLoginBridge.mParams, (String) null);
                }
            }
        }, 500);
    }

    public void bindPhone(Context context, LoginParams params, ILoginResultListener listener) {
        this.mListener = listener;
        if (params == null) {
            params = LoginParams.getDefaultParams();
        }
        this.mParams = params;
        this.mContext = context;
        bindPhone(false, (SapiResult) null);
    }

    private WebLoginDTO.Config getThirdLoginConfig(boolean thirdLoginSwitch) {
        WebLoginDTO.Config config = new WebLoginDTO.Config();
        List<FastLoginFeature> fastLoginFeatureList = new ArrayList<>();
        if (thirdLoginSwitch) {
            if (ThirdLoginUtils.isWeChatShow()) {
                fastLoginFeatureList.add(FastLoginFeature.TX_WEIXIN_SSO);
            }
            if (ThirdLoginUtils.isQQShow()) {
                fastLoginFeatureList.add(FastLoginFeature.TX_QQ_SSO);
            }
            if (ThirdLoginUtils.isSinaShow()) {
                fastLoginFeatureList.add(getConfigSinaLoginType());
            }
            if (ThirdLoginUtils.isYYShow()) {
                fastLoginFeatureList.add(FastLoginFeature.YY_SSO);
            }
            config.fastLoginFeatureList = fastLoginFeatureList;
        }
        return config;
    }

    /* access modifiers changed from: private */
    public void statisticUBC(String type, LoginParams loginParams, String isPanel) {
        statisticUBC(type, loginParams, isPanel, (String) null, (String) null);
    }

    private void statisticUBC(String type, LoginParams loginParams, String isPanel, String page, String bindExt) {
        statisticUBCWithId(BoxAccountContants.LOGIN_UBC_ID, type, loginParams, isPanel, page, bindExt, (JSONObject) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void statisticUBCWithId(java.lang.String r19, java.lang.String r20, com.baidu.searchbox.account.params.LoginParams r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, org.json.JSONObject r25) {
        /*
            r18 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r4 = r0
            java.lang.String r0 = "from"
            java.lang.String r5 = "account"
            r4.put(r0, r5)     // Catch:{ JSONException -> 0x0158 }
            boolean r0 = android.text.TextUtils.isEmpty(r20)     // Catch:{ JSONException -> 0x0158 }
            if (r0 != 0) goto L_0x001f
            java.lang.String r0 = "type"
            r4.put(r0, r2)     // Catch:{ JSONException -> 0x0158 }
        L_0x001f:
            com.baidu.searchbox.account.data.UserAccountActionItem r0 = r3.mLoginSrc     // Catch:{ JSONException -> 0x0158 }
            if (r0 == 0) goto L_0x004b
            java.lang.String r5 = r0.getSrc()     // Catch:{ JSONException -> 0x0158 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0158 }
            if (r5 != 0) goto L_0x0037
            java.lang.String r5 = "source"
            java.lang.String r6 = r0.getSrc()     // Catch:{ JSONException -> 0x0158 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0158 }
        L_0x0037:
            java.lang.String r5 = r0.getSubSrc()     // Catch:{ JSONException -> 0x0158 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0158 }
            if (r5 != 0) goto L_0x004b
            java.lang.String r5 = "subsource"
            java.lang.String r6 = r0.getSubSrc()     // Catch:{ JSONException -> 0x0158 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0158 }
        L_0x004b:
            java.lang.String r5 = "value"
            int r6 = r3.mLoginMode     // Catch:{ JSONException -> 0x0158 }
            r7 = r18
            java.lang.String r6 = r7.loginMode2UBCValue(r6)     // Catch:{ JSONException -> 0x0156 }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0156 }
            com.baidu.pyramid.runtime.service.ServiceReference r5 = com.baidu.searchbox.account.BoxAccountManager.SERVICE_REFERENCE     // Catch:{ JSONException -> 0x0156 }
            java.lang.Object r5 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r5)     // Catch:{ JSONException -> 0x0156 }
            com.baidu.searchbox.account.BoxAccountManager r5 = (com.baidu.searchbox.account.BoxAccountManager) r5     // Catch:{ JSONException -> 0x0156 }
            boolean r6 = r5.isGuestLogin()     // Catch:{ JSONException -> 0x0156 }
            com.baidu.android.app.account.ILoginContext r8 = com.baidu.android.app.account.ILoginContext.Impl.get()     // Catch:{ JSONException -> 0x0156 }
            boolean r8 = r8.isBrowserMode()     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r9 = "page"
            if (r6 == 0) goto L_0x007a
            if (r8 == 0) goto L_0x007a
            java.lang.String r10 = "guest_liulan"
            r4.put(r9, r10)     // Catch:{ JSONException -> 0x0156 }
            goto L_0x0089
        L_0x007a:
            if (r6 == 0) goto L_0x0082
            java.lang.String r10 = "guest"
            r4.put(r9, r10)     // Catch:{ JSONException -> 0x0156 }
            goto L_0x0089
        L_0x0082:
            if (r8 == 0) goto L_0x0089
            java.lang.String r10 = "liulan"
            r4.put(r9, r10)     // Catch:{ JSONException -> 0x0156 }
        L_0x0089:
            r9 = r25
            if (r9 != 0) goto L_0x0093
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0156 }
            r10.<init>()     // Catch:{ JSONException -> 0x0156 }
            r9 = r10
        L_0x0093:
            java.lang.String r10 = "674"
            boolean r10 = android.text.TextUtils.equals(r1, r10)     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r11 = "ext"
            if (r10 == 0) goto L_0x00d1
            java.lang.String r10 = "success"
            boolean r10 = android.text.TextUtils.equals(r2, r10)     // Catch:{ JSONException -> 0x0156 }
            if (r10 != 0) goto L_0x00ae
            java.lang.String r10 = "bd_success"
            boolean r10 = android.text.TextUtils.equals(r2, r10)     // Catch:{ JSONException -> 0x0156 }
            if (r10 == 0) goto L_0x00d1
        L_0x00ae:
            java.lang.String r10 = "id"
            java.lang.String r12 = "news_0000000000000000000"
            r9.put(r10, r12)     // Catch:{ JSONException -> 0x0156 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0156 }
            r10.<init>()     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r12 = "gr_ext"
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0156 }
            r13.<init>()     // Catch:{ JSONException -> 0x0156 }
            r10.put(r12, r13)     // Catch:{ JSONException -> 0x0156 }
            r9.put(r11, r10)     // Catch:{ JSONException -> 0x0156 }
            java.lang.String r12 = "pos"
            r13 = 200000(0x30d40, float:2.8026E-40)
            r9.put(r12, r13)     // Catch:{ JSONException -> 0x0156 }
        L_0x00d1:
            boolean r10 = android.text.TextUtils.isEmpty(r22)     // Catch:{ JSONException -> 0x0156 }
            if (r10 != 0) goto L_0x00e0
            java.lang.String r10 = "panel"
            r12 = r22
            r9.put(r10, r12)     // Catch:{ JSONException -> 0x0154 }
            goto L_0x00e2
        L_0x00e0:
            r12 = r22
        L_0x00e2:
            boolean r10 = android.text.TextUtils.isEmpty(r24)     // Catch:{ JSONException -> 0x0154 }
            if (r10 != 0) goto L_0x00f0
            java.lang.String r10 = "con_guestbd"
            r13 = r24
            r9.put(r10, r13)     // Catch:{ JSONException -> 0x0152 }
            goto L_0x00f2
        L_0x00f0:
            r13 = r24
        L_0x00f2:
            int r10 = r3.mLoginViewType     // Catch:{ JSONException -> 0x0152 }
            r14 = -1
            if (r10 == r14) goto L_0x00fe
            java.lang.String r10 = "loginviewtype"
            int r14 = r3.mLoginViewType     // Catch:{ JSONException -> 0x0152 }
            r9.put(r10, r14)     // Catch:{ JSONException -> 0x0152 }
        L_0x00fe:
            com.baidu.sapi2.SapiAccountManager r10 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ JSONException -> 0x0152 }
            com.baidu.sapi2.SapiAccount r10 = r10.getSession()     // Catch:{ JSONException -> 0x0152 }
            if (r10 == 0) goto L_0x0146
            r14 = 15
            int r15 = r3.mLoginMode     // Catch:{ JSONException -> 0x0152 }
            if (r14 != r15) goto L_0x0146
            java.lang.String r14 = r10.app     // Catch:{ JSONException -> 0x0152 }
            java.lang.String r15 = r10.getShareAccountPkg()     // Catch:{ JSONException -> 0x0152 }
            boolean r16 = android.text.TextUtils.isEmpty(r14)     // Catch:{ JSONException -> 0x0152 }
            if (r16 != 0) goto L_0x0143
            boolean r16 = android.text.TextUtils.isEmpty(r15)     // Catch:{ JSONException -> 0x0152 }
            r17 = r0
            java.lang.String r0 = "hutongsrc"
            if (r16 != 0) goto L_0x013f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0152 }
            r2.<init>()     // Catch:{ JSONException -> 0x0152 }
            java.lang.StringBuilder r2 = r2.append(r14)     // Catch:{ JSONException -> 0x0152 }
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ JSONException -> 0x0152 }
            java.lang.StringBuilder r2 = r2.append(r15)     // Catch:{ JSONException -> 0x0152 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0152 }
            r9.put(r0, r2)     // Catch:{ JSONException -> 0x0152 }
            goto L_0x0148
        L_0x013f:
            r9.put(r0, r14)     // Catch:{ JSONException -> 0x0152 }
            goto L_0x0148
        L_0x0143:
            r17 = r0
            goto L_0x0148
        L_0x0146:
            r17 = r0
        L_0x0148:
            int r0 = r9.length()     // Catch:{ JSONException -> 0x0152 }
            if (r0 == 0) goto L_0x0151
            r4.put(r11, r9)     // Catch:{ JSONException -> 0x0152 }
        L_0x0151:
            goto L_0x0162
        L_0x0152:
            r0 = move-exception
            goto L_0x015f
        L_0x0154:
            r0 = move-exception
            goto L_0x015d
        L_0x0156:
            r0 = move-exception
            goto L_0x015b
        L_0x0158:
            r0 = move-exception
            r7 = r18
        L_0x015b:
            r12 = r22
        L_0x015d:
            r13 = r24
        L_0x015f:
            r0.printStackTrace()
        L_0x0162:
            com.baidu.pyramid.runtime.service.ServiceReference r0 = com.baidu.ubc.UBCManager.SERVICE_REFERENCE
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)
            com.baidu.ubc.UBCManager r0 = (com.baidu.ubc.UBCManager) r0
            java.lang.String r2 = r4.toString()
            r0.onEvent((java.lang.String) r1, (java.lang.String) r2)
            boolean r2 = DEBUG
            if (r2 == 0) goto L_0x0195
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r3 = ":"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "BoxLoginBridge"
            android.util.Log.d(r3, r2)
        L_0x0195:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.app.account.BoxLoginBridge.statisticUBCWithId(java.lang.String, java.lang.String, com.baidu.searchbox.account.params.LoginParams, java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    private String loginMode2UBCValue(int loginMode) {
        switch (loginMode) {
            case 0:
                return "username";
            case 1:
                return "phone";
            case 2:
            case 18:
                return "wechat";
            case 3:
            case 19:
                return "qq";
            case 4:
                return "weibo";
            case 5:
                return "phone";
            case 6:
                return "phone";
            case 8:
                return "face";
            case 10:
                return "phone";
            case 11:
                return "finger";
            case 12:
                return BoxAccountContants.LOGIN_VALUE_YD;
            case 13:
                return BoxAccountContants.LOGIN_VALUE_LT;
            case 14:
                return BoxAccountContants.LOGIN_VALUE_DX;
            case 15:
                return AccountCheckBdussAndUploadManager.getShareUbcValue();
            case 16:
                return "other";
            case 17:
                return "yy";
            default:
                return null;
        }
    }

    public static int toValidateLoginStyle(int originLoginStyle) {
        if (originLoginStyle == 5 || originLoginStyle == 4 || originLoginStyle == 3) {
            return -1;
        }
        return originLoginStyle;
    }

    private SocialType getSinaLoginType() {
        return SocialType.SINA_WEIBO_SSO;
    }

    private FastLoginFeature getConfigSinaLoginType() {
        return FastLoginFeature.SINA_WEIBO_SSO;
    }

    /* access modifiers changed from: private */
    public String getLoginSrcToPass(LoginParams params) {
        if (!TextUtils.isEmpty(params.mLoginSrcToPass)) {
            try {
                String result = URLEncoder.encode(params.mLoginSrcToPass, "UTF-8");
                if (result.length() <= 100) {
                    return result;
                }
                JSONObject jsonSrc = new JSONObject();
                jsonSrc.put("src", params.mLoginSrc.getSrc());
                return URLEncoder.encode(jsonSrc.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            } catch (JSONException e3) {
                e3.printStackTrace();
                return null;
            }
        } else {
            try {
                JSONObject jsonSrc2 = new JSONObject();
                jsonSrc2.put("src", params.mLoginSrc.getSrc());
                return URLEncoder.encode(jsonSrc2.toString(), "UTF-8");
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                return null;
            } catch (JSONException e5) {
                e5.printStackTrace();
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public void statisticForShareLogin(LoginParams loginParams) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("from", "account");
            jsonObject.put("type", "popup");
            jsonObject.put("value", AccountCheckBdussAndUploadManager.getShareUbcValue());
            UserAccountActionItem loginSrc = loginParams.mLoginSrc;
            if (loginSrc != null) {
                if (!TextUtils.isEmpty(loginSrc.getSrc())) {
                    jsonObject.put("source", loginSrc.getSrc());
                }
                if (!TextUtils.isEmpty(loginSrc.getSubSrc())) {
                    jsonObject.put(UBC_SUB_SOURCE, loginSrc.getSubSrc());
                }
            }
            boolean guestLogin = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isGuestLogin();
            boolean isPrivacyMode = ILoginContext.Impl.get().isBrowserMode();
            if (guestLogin && isPrivacyMode) {
                jsonObject.put("page", "guest_liulan");
            } else if (guestLogin) {
                jsonObject.put("page", "guest");
            } else if (isPrivacyMode) {
                jsonObject.put("page", "liulan");
            }
            JSONObject jsonExt = new JSONObject();
            if (loginParams.mLoginViewType != -1) {
                jsonExt.put(BoxAccountContants.UBC_EXT_KEY_LOGIN_VIEW_TYPE, loginParams.mLoginViewType);
            }
            List<ShareStorage.StorageModel> dataList = SapiAccountManager.getInstance().getV2ShareModelList();
            String ext = "";
            for (int i2 = 0; i2 < dataList.size(); i2++) {
                ShareStorage.StorageModel storageModel = dataList.get(i2);
                if (storageModel != null) {
                    ext = ext + storageModel.app + "/" + storageModel.pkg;
                    if (i2 != dataList.size() - 1) {
                        ext = ext + "_";
                    }
                }
            }
            jsonExt.put(UBC_EXT_KEY_SHARE, ext);
            jsonObject.put("ext", jsonExt);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(BoxAccountContants.LOGIN_UBC_ID, jsonObject.toString());
        LogUtils.d("lastLogin", "share ubc = 674" + jsonObject.toString());
    }

    /* access modifiers changed from: private */
    public boolean isNoSupportGuestLogin(int flag) {
        return (flag & 2) != 0;
    }

    /* access modifiers changed from: private */
    public boolean isGuestLogin() {
        SapiAccount account = SapiAccountManager.getInstance().getSession();
        return account != null && account.isGuestAccount();
    }

    /* access modifiers changed from: private */
    public void onLoginFailHintAndStat(SapiResult result, LoginParams params, boolean isToast) {
        if (isLimitRegisterFailed(result)) {
            if (!TextUtils.isEmpty(result.getResultMsg())) {
                UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) result.getResultMsg()).show();
            } else {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.account_login_limit_register_failed).show();
            }
            failStat(result, params);
        } else if (isLoginOnHalfPanel() && isWebLoginAuthFailed(result)) {
            if (isToast) {
                UniversalToast.makeText(AppRuntime.getAppContext(), R.string.account_login_failed).show();
            }
            failStat(result, params);
        }
    }

    private void failStat(SapiResult result, LoginParams params) {
        JSONObject ext = null;
        if (result != null) {
            ext = new JSONObject();
            try {
                ext.put("error_code", result.getResultCode());
                ext.put("error_msg", result.getResultMsg());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        statisticUBCWithId(BoxAccountContants.LOGIN_FAIL_UBC_ID, isLimitRegisterFailed(result) ? BoxAccountContants.LOGIN_TYPE_LIMIT_REGISTER : "banping", params, (String) null, (String) null, (String) null, ext);
    }

    /* access modifiers changed from: private */
    public boolean isWebLoginAuthFailed(SapiResult result) {
        return (result == null || result.getResultCode() == -301) ? false : true;
    }

    /* access modifiers changed from: private */
    public boolean isLimitRegisterFailed(SapiResult result) {
        return result != null && result.getResultCode() == 100073;
    }

    private boolean isLoginOnHalfPanel() {
        LoginParams loginParams = this.mParams;
        return loginParams != null && loginParams.mLoginViewType == 1;
    }

    /* access modifiers changed from: private */
    public boolean isOnekeyLogin() {
        LoginParams loginParams = this.mParams;
        return loginParams != null && (loginParams.mLoginMode == 12 || this.mParams.mLoginMode == 13 || this.mParams.mLoginMode == 14);
    }

    private boolean isShareLogin() {
        LoginParams loginParams = this.mParams;
        return loginParams != null && loginParams.mLoginMode == 15;
    }

    private boolean isHistoryLogin() {
        LoginParams loginParams = this.mParams;
        return loginParams != null && loginParams.mLoginMode == 22;
    }
}
