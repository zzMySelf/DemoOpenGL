package com.baidu.android.app.account.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.baidu.android.app.account.BiometricsManager;
import com.baidu.android.app.account.BoxSapiAccountManager;
import com.baidu.android.app.account.BoxSapiAccountSync;
import com.baidu.android.app.account.ioc.AccountBusinessRuntime;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.fsg.api.RimServiceCallback;
import com.baidu.fsg.face.liveness.utils.enums.LivenessRecogType;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.activity.BindWidgetActivity;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.LoginWithUCAuthResult;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.account.IGetBoxAccountListener;
import com.baidu.searchbox.account.IGetTplStokenCallback;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.account.data.OnGetTplStokenResult;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.searchbox.account.params.LoginParams;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.login.LoginManager;
import com.baidu.searchbox.plugins.annotation.PluginAccessable;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccountPluginManager implements NoProGuard {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String KEY_AUTHSID = "authsid";
    private static final String KEY_CREDENTIAL_KEY = "credentialKey";
    private static final String KEY_ERRMSG = "errmsg";
    private static final String KEY_ERRNO = "errno";
    private static final String TAG = "AccountPluginManager";
    private static AccountPluginManager sInstance;
    private BoxAccountManager mAccountManager = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE));
    /* access modifiers changed from: private */
    public Context mContext;
    private final WeakHashMap<LoginManager.LoginStatusChangedListener, IAccountStatusChangedListener> mListenerProxy = new WeakHashMap<>();

    public interface IPluginLivenessRecogCallback extends NoProGuard {
        void onFailure(String str);

        void onFinish();

        void onStart();

        void onSuccess(String str);
    }

    public interface OnBindPhoneListener extends NoProGuard {
        public static final int FAILED = -1;
        public static final int SUCCESS = 0;

        void onResult(int i2);
    }

    public interface OnGetOpenBdussCallback extends NoProGuard {
        void onFailure(AccountOpenBdussResult accountOpenBdussResult);

        void onFinish();

        void onStart();

        void onSuccess(AccountOpenBdussResult accountOpenBdussResult);
    }

    public interface OnPluginDynamicSmsLoginListener extends NoProGuard {
        void onFailure(int i2);

        void onFinish();

        void onStart();

        void onSuccess();
    }

    public interface OnPluginGetBoxAccountListener extends NoProGuard {
        public static final int ERROR_BDUSS_EXPIRED = -1;
        public static final int ERROR_COMMON = -3;
        public static final int ERROR_NETWORK_FAILED = -2;

        void onFailed(int i2);

        void onSuccess(JSONObject jSONObject);
    }

    public interface OnPluginGetCaptchaListener extends NoProGuard {
        void onFailure(int i2);

        void onFinish();

        void onStart();

        void onSuccess(byte[] bArr);
    }

    public interface OnPluginGetDynamicPwdListener extends NoProGuard {
        void onNetworkFailed();

        void onSuccess();

        void onSystemError(int i2);
    }

    public interface OnPluginGetDynamicPwdNeedCaptchaListener extends NoProGuard {
        void onCaptchaRequired(int i2);

        void onFailure(int i2);

        void onFinish();

        void onStart();

        void onSuccess();
    }

    public interface OnPluginGetTplStokenCallback extends NoProGuard {
        void onFailure(String str);

        void onFinish();

        void onStart();

        void onSuccess(String str);
    }

    public interface OnPluginLoginResultListener extends NoProGuard {
        public static final int CANCELD = -2;
        public static final int FAILED = -1;
        public static final int SUCCESS = 0;

        void onResult(int i2);
    }

    public interface OnPluginSafeFacadeCallback extends NoProGuard {
        void onFailure(String str);

        void onFinish();

        void onStart();

        void onSuccess(String str);
    }

    public interface OnPluginSmsLoginListener extends NoProGuard {
        void onNetworkFailed();

        void onSuccess();

        void onSystemError(int i2);
    }

    public interface OnWeb2NativeLoginCallback extends NoProGuard {
        void onBdussEmpty();

        void onBdussExpired();

        void onFailure();

        void onFinish();

        void onStart();

        void onSuccess();
    }

    public static synchronized AccountPluginManager getInstance(Context context) {
        AccountPluginManager accountPluginManager;
        synchronized (AccountPluginManager.class) {
            if (sInstance == null) {
                sInstance = new AccountPluginManager(context);
            }
            accountPluginManager = sInstance;
        }
        return accountPluginManager;
    }

    public static synchronized void release() {
        synchronized (AccountPluginManager.class) {
            AccountPluginManager accountPluginManager = sInstance;
            if (accountPluginManager != null) {
                WeakHashMap<LoginManager.LoginStatusChangedListener, IAccountStatusChangedListener> weakHashMap = accountPluginManager.mListenerProxy;
                if (weakHashMap != null) {
                    weakHashMap.clear();
                }
                sInstance.mAccountManager = null;
                sInstance = null;
            }
        }
    }

    private AccountPluginManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @PluginAccessable(methodName = "isLogin", paramClasses = {})
    public boolean isLogin() {
        return this.mAccountManager.isLogin();
    }

    @PluginAccessable(methodName = "isLogin", paramClasses = {boolean.class})
    public boolean isLogin(boolean isSupportGuestLogin) {
        return this.mAccountManager.isLogin(isSupportGuestLogin ? 0 : 2);
    }

    @PluginAccessable(methodName = "getTplStoken", paramClasses = {OnPluginGetTplStokenCallback.class, String.class, List.class})
    public void getTplStoken(final OnPluginGetTplStokenCallback callback, String bduss, List<String> tpls) {
        BoxAccountManager boxAccountManager = this.mAccountManager;
        if (boxAccountManager instanceof BoxSapiAccountManager) {
            ((BoxSapiAccountManager) boxAccountManager).getTplStoken(new IGetTplStokenCallback() {
                public void onSuccess(OnGetTplStokenResult getTplStokenResult) {
                    OnPluginGetTplStokenCallback onPluginGetTplStokenCallback = callback;
                    if (onPluginGetTplStokenCallback == null) {
                        return;
                    }
                    if (getTplStokenResult != null) {
                        try {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("errcode", getTplStokenResult.mErrCode);
                            jsonObject.put("errmsg", getTplStokenResult.mErrMsg);
                            jsonObject.put("failureType", getTplStokenResult.mFailureType);
                            if (getTplStokenResult.mStokens != null) {
                                jsonObject.put("data", new JSONObject(getTplStokenResult.mStokens));
                            }
                            callback.onSuccess(jsonObject.toString());
                        } catch (JSONException e2) {
                            callback.onFailure((String) null);
                        }
                    } else {
                        onPluginGetTplStokenCallback.onFailure((String) null);
                    }
                }

                public void onFailure(OnGetTplStokenResult getTplStokenResult) {
                    OnPluginGetTplStokenCallback onPluginGetTplStokenCallback = callback;
                    if (onPluginGetTplStokenCallback == null) {
                        return;
                    }
                    if (getTplStokenResult != null) {
                        try {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("errcode", getTplStokenResult.mErrCode);
                            jsonObject.put("errmsg", getTplStokenResult.mErrMsg);
                            jsonObject.put("failureType", getTplStokenResult.mFailureType);
                            callback.onFailure(jsonObject.toString());
                        } catch (JSONException e2) {
                            callback.onFailure((String) null);
                        }
                    } else {
                        onPluginGetTplStokenCallback.onFailure((String) null);
                    }
                }

                public void onStart() {
                    OnPluginGetTplStokenCallback onPluginGetTplStokenCallback = callback;
                    if (onPluginGetTplStokenCallback != null) {
                        onPluginGetTplStokenCallback.onStart();
                    }
                }

                public void onFinish() {
                    OnPluginGetTplStokenCallback onPluginGetTplStokenCallback = callback;
                    if (onPluginGetTplStokenCallback != null) {
                        onPluginGetTplStokenCallback.onFinish();
                    }
                }
            }, bduss, tpls);
        }
    }

    @PluginAccessable(methodName = "getDisplayName", paramClasses = {})
    public String getDisplayName() {
        return this.mAccountManager.getSession("BoxAccount_displayname");
    }

    @PluginAccessable(methodName = "getUserId", paramClasses = {})
    public String getUserId() {
        return this.mAccountManager.getSession("BoxAccount_uid");
    }

    @PluginAccessable(methodName = "getBdussState", paramClasses = {})
    public int getBdussState() {
        return SapiAccountManager.getInstance().getAccountService().getBdussState();
    }

    @PluginAccessable(methodName = "login", paramClasses = {})
    @Deprecated
    public void login() {
        login((PluginLoginParams) null);
    }

    @PluginAccessable(methodName = "login", paramClasses = {PluginLoginParams.class, OnPluginLoginResultListener.class})
    public void login(PluginLoginParams param, final OnPluginLoginResultListener listener) {
        LoginParams realParam = PluginLoginParams.buildBoxLoginParams(param);
        this.mAccountManager.combineLogin(this.mContext, realParam, realParam.mNoSupportGuestLogin ? 2 : 0, new ILoginResultListener() {
            public void onResult(int resultCode) {
                OnPluginLoginResultListener onPluginLoginResultListener = listener;
                if (onPluginLoginResultListener != null) {
                    switch (resultCode) {
                        case -2:
                            onPluginLoginResultListener.onResult(-2);
                            return;
                        case -1:
                            onPluginLoginResultListener.onResult(-1);
                            return;
                        case 0:
                            onPluginLoginResultListener.onResult(0);
                            return;
                        default:
                            onPluginLoginResultListener.onResult(-1);
                            return;
                    }
                }
            }
        });
    }

    @PluginAccessable(methodName = "login", paramClasses = {PluginLoginParams.class})
    public void login(PluginLoginParams param) {
        login(param, (OnPluginLoginResultListener) null);
    }

    @PluginAccessable(methodName = "login", paramClasses = {String.class, OnPluginLoginResultListener.class})
    public void login(String params, final OnPluginLoginResultListener listener) {
        LoginParams realParam = PluginLoginParams.buildBoxLoginParams(params);
        this.mAccountManager.combineLogin(this.mContext, realParam, realParam.mNoSupportGuestLogin ? 2 : 0, new ILoginResultListener() {
            public void onResult(int resultCode) {
                OnPluginLoginResultListener onPluginLoginResultListener = listener;
                if (onPluginLoginResultListener != null) {
                    switch (resultCode) {
                        case -2:
                            onPluginLoginResultListener.onResult(-2);
                            return;
                        case -1:
                            onPluginLoginResultListener.onResult(-1);
                            return;
                        case 0:
                            onPluginLoginResultListener.onResult(0);
                            return;
                        default:
                            onPluginLoginResultListener.onResult(-1);
                            return;
                    }
                }
            }
        });
    }

    @PluginAccessable(methodName = "getCaptcha", paramClasses = {OnPluginGetCaptchaListener.class})
    public void getCaptcha(final OnPluginGetCaptchaListener listener) {
        BoxAccountManager boxAccountManager = this.mAccountManager;
        if (boxAccountManager instanceof BoxSapiAccountManager) {
            ((BoxSapiAccountManager) boxAccountManager).getCaptcha(new BoxSapiAccountManager.OnGetCaptchaListener() {
                public void onSuccess(GetCaptchaResult result) {
                    OnPluginGetCaptchaListener onPluginGetCaptchaListener = listener;
                    if (onPluginGetCaptchaListener != null) {
                        onPluginGetCaptchaListener.onSuccess(result.captchaImage);
                    }
                }

                public void onStart() {
                    OnPluginGetCaptchaListener onPluginGetCaptchaListener = listener;
                    if (onPluginGetCaptchaListener != null) {
                        onPluginGetCaptchaListener.onStart();
                    }
                }

                public void onFinish() {
                    OnPluginGetCaptchaListener onPluginGetCaptchaListener = listener;
                    if (onPluginGetCaptchaListener != null) {
                        onPluginGetCaptchaListener.onFinish();
                    }
                }

                public void onFailure(GetCaptchaResult result) {
                    OnPluginGetCaptchaListener onPluginGetCaptchaListener = listener;
                    if (onPluginGetCaptchaListener != null) {
                        onPluginGetCaptchaListener.onFailure(result.getResultCode());
                    }
                }
            });
        }
    }

    @PluginAccessable(methodName = "smsLoginGetDynamicPwd", paramClasses = {String.class, OnPluginGetDynamicPwdListener.class})
    @Deprecated
    public void smsLoginGetDynamicPwd(String phoneNum, final OnPluginGetDynamicPwdListener listener) {
        BoxAccountManager boxAccountManager = this.mAccountManager;
        if (boxAccountManager instanceof BoxSapiAccountManager) {
            ((BoxSapiAccountManager) boxAccountManager).smsLoginGetDynamicPwd(phoneNum, new BoxSapiAccountManager.OnGetDynamicPwdListener() {
                public void onNetworkFailed() {
                    OnPluginGetDynamicPwdListener onPluginGetDynamicPwdListener = listener;
                    if (onPluginGetDynamicPwdListener != null) {
                        onPluginGetDynamicPwdListener.onNetworkFailed();
                    }
                }

                public void onSuccess() {
                    OnPluginGetDynamicPwdListener onPluginGetDynamicPwdListener = listener;
                    if (onPluginGetDynamicPwdListener != null) {
                        onPluginGetDynamicPwdListener.onSuccess();
                    }
                }

                public void onSystemError(int arg0) {
                    OnPluginGetDynamicPwdListener onPluginGetDynamicPwdListener = listener;
                    if (onPluginGetDynamicPwdListener != null) {
                        onPluginGetDynamicPwdListener.onSystemError(arg0);
                    }
                }
            });
        }
    }

    @PluginAccessable(methodName = "smsLoginGetDynamicPwd", paramClasses = {String.class, String.class, OnPluginGetDynamicPwdNeedCaptchaListener.class})
    public void smsLoginGetDynamicPwd(String phoneNum, String captcha, final OnPluginGetDynamicPwdNeedCaptchaListener listener) {
        BoxAccountManager boxAccountManager = this.mAccountManager;
        if (boxAccountManager instanceof BoxSapiAccountManager) {
            ((BoxSapiAccountManager) boxAccountManager).smsLoginGetDynamicPwd(phoneNum, captcha, new BoxSapiAccountManager.OnGetDynamicPwdNeedCaptchaListener() {
                public void onCaptchaRequired(GetDynamicPwdResult result) {
                    OnPluginGetDynamicPwdNeedCaptchaListener onPluginGetDynamicPwdNeedCaptchaListener = listener;
                    if (onPluginGetDynamicPwdNeedCaptchaListener != null) {
                        onPluginGetDynamicPwdNeedCaptchaListener.onCaptchaRequired(result.getResultCode());
                    }
                }

                public void onFailure(GetDynamicPwdResult result) {
                    OnPluginGetDynamicPwdNeedCaptchaListener onPluginGetDynamicPwdNeedCaptchaListener = listener;
                    if (onPluginGetDynamicPwdNeedCaptchaListener != null) {
                        onPluginGetDynamicPwdNeedCaptchaListener.onFailure(result.getResultCode());
                    }
                }

                public void onFinish() {
                    OnPluginGetDynamicPwdNeedCaptchaListener onPluginGetDynamicPwdNeedCaptchaListener = listener;
                    if (onPluginGetDynamicPwdNeedCaptchaListener != null) {
                        onPluginGetDynamicPwdNeedCaptchaListener.onFinish();
                    }
                }

                public void onStart() {
                    OnPluginGetDynamicPwdNeedCaptchaListener onPluginGetDynamicPwdNeedCaptchaListener = listener;
                    if (onPluginGetDynamicPwdNeedCaptchaListener != null) {
                        onPluginGetDynamicPwdNeedCaptchaListener.onStart();
                    }
                }

                public void onSuccess(GetDynamicPwdResult result) {
                    OnPluginGetDynamicPwdNeedCaptchaListener onPluginGetDynamicPwdNeedCaptchaListener = listener;
                    if (onPluginGetDynamicPwdNeedCaptchaListener != null) {
                        onPluginGetDynamicPwdNeedCaptchaListener.onSuccess();
                    }
                }
            });
        }
    }

    @PluginAccessable(methodName = "smsLogin", paramClasses = {String.class, String.class, OnPluginDynamicSmsLoginListener.class})
    public void smsLogin(String phoneNum, String pwd, final OnPluginDynamicSmsLoginListener listener) {
        BoxAccountManager boxAccountManager = this.mAccountManager;
        if (boxAccountManager instanceof BoxSapiAccountManager) {
            ((BoxSapiAccountManager) boxAccountManager).smsLogin(phoneNum, pwd, (BoxSapiAccountManager.OnDynamicSmsLoginListener) new BoxSapiAccountManager.OnDynamicSmsLoginListener() {
                public void onSuccess() {
                    OnPluginDynamicSmsLoginListener onPluginDynamicSmsLoginListener = listener;
                    if (onPluginDynamicSmsLoginListener != null) {
                        onPluginDynamicSmsLoginListener.onSuccess();
                    }
                }

                public void onStart() {
                    OnPluginDynamicSmsLoginListener onPluginDynamicSmsLoginListener = listener;
                    if (onPluginDynamicSmsLoginListener != null) {
                        onPluginDynamicSmsLoginListener.onStart();
                    }
                }

                public void onFinish() {
                    OnPluginDynamicSmsLoginListener onPluginDynamicSmsLoginListener = listener;
                    if (onPluginDynamicSmsLoginListener != null) {
                        onPluginDynamicSmsLoginListener.onFinish();
                    }
                }

                public void onFailure(DynamicPwdLoginResult result) {
                    OnPluginDynamicSmsLoginListener onPluginDynamicSmsLoginListener = listener;
                    if (onPluginDynamicSmsLoginListener != null) {
                        onPluginDynamicSmsLoginListener.onFailure(result.getResultCode());
                    }
                }
            });
        }
    }

    @PluginAccessable(methodName = "smsLogin", paramClasses = {String.class, String.class, OnPluginSmsLoginListener.class})
    @Deprecated
    public void smsLogin(String phoneNum, String pwd, final OnPluginSmsLoginListener listener) {
        BoxAccountManager boxAccountManager = this.mAccountManager;
        if (boxAccountManager instanceof BoxSapiAccountManager) {
            ((BoxSapiAccountManager) boxAccountManager).smsLogin(phoneNum, pwd, (BoxSapiAccountManager.OnSmsLoginListener) new BoxSapiAccountManager.OnSmsLoginListener() {
                public void onNetworkFailed() {
                    OnPluginSmsLoginListener onPluginSmsLoginListener = listener;
                    if (onPluginSmsLoginListener != null) {
                        onPluginSmsLoginListener.onNetworkFailed();
                    }
                }

                public void onSuccess() {
                    OnPluginSmsLoginListener onPluginSmsLoginListener = listener;
                    if (onPluginSmsLoginListener != null) {
                        onPluginSmsLoginListener.onSuccess();
                    }
                }

                public void onSystemError(int arg0) {
                    OnPluginSmsLoginListener onPluginSmsLoginListener = listener;
                    if (onPluginSmsLoginListener != null) {
                        onPluginSmsLoginListener.onSystemError(arg0);
                    }
                }
            });
        }
    }

    @PluginAccessable(methodName = "logout", paramClasses = {PluginLogoutParams.class})
    public void logout(PluginLogoutParams src) {
        this.mAccountManager.logout(PluginLogoutParams.buildBoxLogoutParams(src));
        BoxAccountManager.oneKeyErrors.clear();
    }

    @PluginAccessable(methodName = "logout", paramClasses = {})
    @Deprecated
    public void logout() {
        logout((PluginLogoutParams) null);
    }

    @PluginAccessable(methodName = "getBduss", paramClasses = {})
    public String getBduss() {
        return this.mAccountManager.getSession("BoxAccount_bduss");
    }

    @PluginAccessable(methodName = "getPToken", paramClasses = {})
    public String getPToken() {
        return "";
    }

    @PluginAccessable(methodName = "getSToken", paramClasses = {})
    public String getSToken() {
        return "";
    }

    @PluginAccessable(methodName = "getBoxAccount", paramClasses = {})
    public JSONObject getBoxAccount() {
        BoxAccount account = this.mAccountManager.getBoxAccount();
        if (account != null) {
            return account.toJson();
        }
        return null;
    }

    @PluginAccessable(methodName = "getBoxAccount", paramClasses = {int.class, OnPluginGetBoxAccountListener.class})
    public JSONObject getBoxAccount(int mode, final OnPluginGetBoxAccountListener listener) {
        BoxAccount account = this.mAccountManager.getBoxAccount(mode, new IGetBoxAccountListener() {
            public void onSuccess(BoxAccount account) {
                OnPluginGetBoxAccountListener onPluginGetBoxAccountListener = listener;
                if (onPluginGetBoxAccountListener == null) {
                    return;
                }
                if (account != null) {
                    onPluginGetBoxAccountListener.onSuccess(account.toJson());
                } else {
                    onPluginGetBoxAccountListener.onSuccess((JSONObject) null);
                }
            }

            public void onFailed(int errorCode) {
                OnPluginGetBoxAccountListener onPluginGetBoxAccountListener = listener;
                if (onPluginGetBoxAccountListener != null) {
                    onPluginGetBoxAccountListener.onFailed(errorCode);
                }
            }
        });
        if (account != null) {
            return account.toJson();
        }
        return null;
    }

    @PluginAccessable(methodName = "getBoxAccount", paramClasses = {Integer.class, OnPluginGetBoxAccountListener.class})
    public JSONObject getBoxAccount(Integer mode, OnPluginGetBoxAccountListener listener) {
        return getBoxAccount(mode.intValue(), listener);
    }

    @PluginAccessable(methodName = "web2NativeLogin", paramClasses = {PluginLoginParams.class})
    public void web2NativeLogin(PluginLoginParams params) {
        final LoginParams realParam = PluginLoginParams.buildBoxLoginParams(params);
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() {
            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                BoxSapiAccountSync.getInstance(AccountPluginManager.this.mContext).boxLoginSync(realParam.mLoginSrc);
            }

            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
            }

            public void onStart() {
            }

            public void onFinish() {
            }
        });
    }

    @PluginAccessable(methodName = "web2NativeLogin", paramClasses = {PluginLoginParams.class, OnWeb2NativeLoginCallback.class})
    public void web2NativeLogin(PluginLoginParams params, final OnWeb2NativeLoginCallback onWeb2NativeLoginCallback) {
        final LoginParams realParam = PluginLoginParams.buildBoxLoginParams(params);
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() {
            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                OnWeb2NativeLoginCallback onWeb2NativeLoginCallback = onWeb2NativeLoginCallback;
                if (onWeb2NativeLoginCallback != null) {
                    onWeb2NativeLoginCallback.onBdussEmpty();
                }
            }

            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                OnWeb2NativeLoginCallback onWeb2NativeLoginCallback = onWeb2NativeLoginCallback;
                if (onWeb2NativeLoginCallback != null) {
                    onWeb2NativeLoginCallback.onBdussExpired();
                }
            }

            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                BoxSapiAccountSync.getInstance(AccountPluginManager.this.mContext).boxLoginSync(realParam.mLoginSrc);
                final BoxSapiAccountManager accountManager = (BoxSapiAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
                accountManager.getAccountInfoFromServer(new IGetBoxAccountListener() {
                    public void onSuccess(BoxAccount account) {
                        accountManager.notifyAllLoginStatusChangedListeners(false, true);
                    }

                    public void onFailed(int errorCode) {
                    }
                });
                OnWeb2NativeLoginCallback onWeb2NativeLoginCallback = onWeb2NativeLoginCallback;
                if (onWeb2NativeLoginCallback != null) {
                    onWeb2NativeLoginCallback.onSuccess();
                }
            }

            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                OnWeb2NativeLoginCallback onWeb2NativeLoginCallback = onWeb2NativeLoginCallback;
                if (onWeb2NativeLoginCallback != null) {
                    onWeb2NativeLoginCallback.onFailure();
                }
            }

            public void onStart() {
                OnWeb2NativeLoginCallback onWeb2NativeLoginCallback = onWeb2NativeLoginCallback;
                if (onWeb2NativeLoginCallback != null) {
                    onWeb2NativeLoginCallback.onStart();
                }
            }

            public void onFinish() {
                OnWeb2NativeLoginCallback onWeb2NativeLoginCallback = onWeb2NativeLoginCallback;
                if (onWeb2NativeLoginCallback != null) {
                    onWeb2NativeLoginCallback.onFinish();
                }
            }
        });
    }

    @PluginAccessable(methodName = "addLoginStatusChangedListener", paramClasses = {LoginManager.LoginStatusChangedListener.class})
    public void addLoginStatusChangedListener(final LoginManager.LoginStatusChangedListener l) {
        IAccountStatusChangedListener realListener = new IAccountStatusChangedListener() {
            public void onLoginStatusChanged(boolean oldStatus, boolean newStatus) {
                l.onLoginStatusChanged(oldStatus, newStatus);
            }
        };
        this.mListenerProxy.put(l, realListener);
        this.mAccountManager.addLoginStatusChangedListener(realListener);
    }

    @PluginAccessable(methodName = "removeLoginStatusChangedListener", paramClasses = {LoginManager.LoginStatusChangedListener.class})
    public void removeLoginStatusChangedListener(LoginManager.LoginStatusChangedListener l) {
        IAccountStatusChangedListener realListener = this.mListenerProxy.get(l);
        if (realListener != null) {
            this.mAccountManager.removeLoginStatusChangedListener(realListener);
            this.mListenerProxy.remove(l);
        }
    }

    @PluginAccessable(methodName = "bindPhone", paramClasses = {Activity.class, boolean.class, int.class})
    public void bindPhone(Activity activity, boolean hasBind, int requestCode) {
        if (!hasBind) {
            Intent intent = new Intent(activity, BindWidgetActivity.class);
            intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, BindWidgetAction.BIND_MOBILE);
            activity.startActivityForResult(intent, requestCode);
            return;
        }
        Intent intent2 = new Intent(activity, BindWidgetActivity.class);
        intent2.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, BindWidgetAction.REBIND_MOBILE);
        activity.startActivityForResult(intent2, requestCode);
    }

    @PluginAccessable(methodName = "bindPhone", paramClasses = {Fragment.class, boolean.class, int.class})
    public void bindPhone(Fragment fragment, boolean hasBind, int requestCode) {
        if (!hasBind) {
            Intent intent = new Intent(AppRuntime.getAppContext(), BindWidgetActivity.class);
            intent.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, BindWidgetAction.BIND_MOBILE);
            fragment.startActivityForResult(intent, requestCode);
            return;
        }
        Intent intent2 = new Intent(AppRuntime.getAppContext(), BindWidgetActivity.class);
        intent2.putExtra(BindWidgetActivity.EXTRA_BIND_WIDGET_ACTION, BindWidgetAction.REBIND_MOBILE);
        fragment.startActivityForResult(intent2, requestCode);
    }

    @PluginAccessable(methodName = "checkSafeAsync", paramClasses = {String.class, String.class, Integer.class, OnPluginSafeFacadeCallback.class})
    public void checkSafeAsync(String uid, String methodName, Integer callEnv, OnPluginSafeFacadeCallback callback) {
        checkSafeAsync(uid, methodName, Integer.valueOf(callEnv.intValue()), callback);
    }

    @PluginAccessable(methodName = "livenessRecognize", paramClasses = {String.class, IPluginLivenessRecogCallback.class})
    public void livenessRecognize(String param, IPluginLivenessRecogCallback callback) {
        LivenessRecogType livenessRecogType;
        final IPluginLivenessRecogCallback iPluginLivenessRecogCallback = callback;
        if (DEBUG) {
            Log.i(TAG, "livenessRecognize");
        }
        try {
            JSONObject jsonObject = new JSONObject(param);
            String stoken = jsonObject.optString(LoginWithUCAuthResult.KEY_DATA_STOKEN);
            String showGuidePage = jsonObject.optString("showGuidePage");
            int recordVideo = jsonObject.getInt("recordVideo");
            String actionType = jsonObject.optString("actionType");
            String realName = jsonObject.optString("realName");
            String idCardNum = jsonObject.optString("idCardNum");
            String authToken = jsonObject.optString("authToken");
            String recogType = jsonObject.optString("livenessType");
            String productId = jsonObject.optString("productId");
            String livenessServiceId = jsonObject.optString("livenessServiceId");
            String spParams = jsonObject.optString("spParams");
            String imageFlag = jsonObject.optString("imageFlag");
            char c2 = 65535;
            switch (recogType.hashCode()) {
                case -737788718:
                    if (recogType.equals("certinfo")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 93600275:
                    if (recogType.equals("bduss")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1480140113:
                    if (recogType.equals("authtoken")) {
                        c2 = 1;
                        break;
                    }
                    break;
                default:
                    JSONObject jSONObject = jsonObject;
                    break;
            }
            switch (c2) {
                case 0:
                    livenessRecogType = LivenessRecogType.RECOG_TYPE_BDUSS;
                    break;
                case 1:
                    livenessRecogType = LivenessRecogType.RECOG_TYPE_AUTHTOKEN;
                    break;
                case 2:
                    livenessRecogType = LivenessRecogType.RECOG_TYPE_CERTINFO;
                    break;
                default:
                    livenessRecogType = null;
                    break;
            }
            if (livenessRecogType == null) {
                livenessFailureCallback(iPluginLivenessRecogCallback);
                return;
            }
            BiometricsManager.LivenessItem livenessItem = new BiometricsManager.LivenessItem();
            livenessItem.authToken = authToken;
            livenessItem.livenessRecogType = livenessRecogType;
            livenessItem.livenessServiceId = livenessServiceId;
            livenessItem.spParams = spParams;
            livenessItem.recordVideo = recordVideo;
            livenessItem.realName = realName;
            livenessItem.idCardNum = idCardNum;
            livenessItem.stoken = stoken;
            livenessItem.productId = productId;
            livenessItem.serviceType = actionType;
            livenessItem.showGuidePage = showGuidePage;
            livenessItem.imageFlag = imageFlag;
            LivenessRecogType livenessRecogType2 = livenessRecogType;
            String str = stoken;
            String str2 = showGuidePage;
            BiometricsManager.getInstance().livenessRecognize(AppRuntime.getAppContext(), livenessItem, new RimServiceCallback() {
                public void onResult(int retCode, Map<String, Object> resultMap) {
                    JSONObject data = new JSONObject();
                    if (resultMap == null) {
                        data.put("errno", -1);
                        data.put("errmsg", "system error");
                        iPluginLivenessRecogCallback.onFailure(data.toString());
                    } else if (retCode == 0) {
                        try {
                            data.put("errno", retCode);
                            data.put("errmsg", resultMap.get("retMsg"));
                            JSONObject resultJson = new JSONObject((String) resultMap.get("result"));
                            data.put(AccountPluginManager.KEY_CREDENTIAL_KEY, resultJson.optString("callbackkey", (String) null));
                            data.put("authsid", resultJson.optString("authsid", (String) null));
                            iPluginLivenessRecogCallback.onSuccess(data.toString());
                        } catch (JSONException e2) {
                            if (AccountPluginManager.DEBUG) {
                                Log.e(AccountPluginManager.TAG, "livenessRecognize", e2);
                            }
                        }
                    } else {
                        data.put("errno", retCode);
                        data.put("errmsg", resultMap.get("retMsg"));
                        iPluginLivenessRecogCallback.onFailure(data.toString());
                    }
                }
            });
        } catch (JSONException e2) {
            livenessFailureCallback(iPluginLivenessRecogCallback);
        }
    }

    @PluginAccessable(methodName = "livenessRecognize", paramClasses = {Context.class, String.class, IPluginLivenessRecogCallback.class})
    public void livenessRecognize(Context context, String param, IPluginLivenessRecogCallback callback) {
        LivenessRecogType livenessRecogType;
        final IPluginLivenessRecogCallback iPluginLivenessRecogCallback = callback;
        if (DEBUG) {
            Log.i(TAG, "livenessRecognize");
        }
        try {
            JSONObject jsonObject = new JSONObject(param);
            String stoken = jsonObject.optString(LoginWithUCAuthResult.KEY_DATA_STOKEN);
            String showGuidePage = jsonObject.optString("showGuidePage");
            int recordVideo = jsonObject.getInt("recordVideo");
            String actionType = jsonObject.optString("actionType");
            String realName = jsonObject.optString("realName");
            String idCardNum = jsonObject.optString("idCardNum");
            String authToken = jsonObject.optString("authToken");
            String recogType = jsonObject.optString("livenessType");
            String productId = jsonObject.optString("productId");
            String livenessServiceId = jsonObject.optString("livenessServiceId");
            String spParams = jsonObject.optString("spParams");
            String imageFlag = jsonObject.optString("imageFlag");
            char c2 = 65535;
            switch (recogType.hashCode()) {
                case -737788718:
                    if (recogType.equals("certinfo")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 93600275:
                    if (recogType.equals("bduss")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1480140113:
                    if (recogType.equals("authtoken")) {
                        c2 = 1;
                        break;
                    }
                    break;
                default:
                    JSONObject jSONObject = jsonObject;
                    break;
            }
            switch (c2) {
                case 0:
                    livenessRecogType = LivenessRecogType.RECOG_TYPE_BDUSS;
                    break;
                case 1:
                    livenessRecogType = LivenessRecogType.RECOG_TYPE_AUTHTOKEN;
                    break;
                case 2:
                    livenessRecogType = LivenessRecogType.RECOG_TYPE_CERTINFO;
                    break;
                default:
                    livenessRecogType = null;
                    break;
            }
            if (livenessRecogType == null) {
                livenessFailureCallback(iPluginLivenessRecogCallback);
                Context context2 = context;
                return;
            }
            BiometricsManager.LivenessItem livenessItem = new BiometricsManager.LivenessItem();
            livenessItem.authToken = authToken;
            livenessItem.livenessRecogType = livenessRecogType;
            livenessItem.livenessServiceId = livenessServiceId;
            livenessItem.spParams = spParams;
            livenessItem.recordVideo = recordVideo;
            livenessItem.realName = realName;
            livenessItem.idCardNum = idCardNum;
            livenessItem.stoken = stoken;
            livenessItem.productId = productId;
            livenessItem.serviceType = actionType;
            livenessItem.showGuidePage = showGuidePage;
            livenessItem.imageFlag = imageFlag;
            LivenessRecogType livenessRecogType2 = livenessRecogType;
            String str = stoken;
            String str2 = showGuidePage;
            try {
                BiometricsManager.getInstance().livenessRecognize(context, livenessItem, new RimServiceCallback() {
                    public void onResult(int retCode, Map<String, Object> resultMap) {
                        JSONObject data = new JSONObject();
                        if (resultMap == null) {
                            data.put("errno", -1);
                            data.put("errmsg", "system error");
                            iPluginLivenessRecogCallback.onFailure(data.toString());
                        } else if (retCode == 0) {
                            try {
                                data.put("errno", retCode);
                                data.put("errmsg", resultMap.get("retMsg"));
                                JSONObject resultJson = new JSONObject((String) resultMap.get("result"));
                                data.put(AccountPluginManager.KEY_CREDENTIAL_KEY, resultJson.optString("callbackkey", (String) null));
                                data.put("authsid", resultJson.optString("authsid", (String) null));
                                iPluginLivenessRecogCallback.onSuccess(data.toString());
                            } catch (JSONException e2) {
                                if (AccountPluginManager.DEBUG) {
                                    Log.e(AccountPluginManager.TAG, "livenessRecognize", e2);
                                }
                            }
                        } else {
                            data.put("errno", retCode);
                            data.put("errmsg", resultMap.get("retMsg"));
                            iPluginLivenessRecogCallback.onFailure(data.toString());
                        }
                    }
                });
            } catch (JSONException e2) {
            }
        } catch (JSONException e3) {
            Context context3 = context;
            livenessFailureCallback(iPluginLivenessRecogCallback);
        }
    }

    private void livenessFailureCallback(IPluginLivenessRecogCallback callback) {
        if (callback != null) {
            try {
                JSONObject data = new JSONObject();
                data.put("errno", -1);
                data.put("errmsg", "param not correct");
                callback.onFailure(data.toString());
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.e(TAG, "livenessFailureCallback exception:");
                }
            }
        }
    }

    @PluginAccessable(methodName = "profile", paramClasses = {String.class})
    public void profile(final String params) {
        if (DEBUG) {
            Log.i(TAG, "profile params:" + params);
        }
        final BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (boxAccountManager.isLogin()) {
            gotoUserInfo(params);
            return;
        }
        boxAccountManager.login(AppRuntime.getAppContext(), new LoginParams.Builder().setLoginSrc(new UserAccountActionItem(UserAccountActionItem.UserAccountAction.LOGIN, UserAccountActionItem.UserAccountType.NATIVE, "hudong_personalpage")).build(), new ILoginResultListener() {
            public void onResult(int resultCode) {
                if (boxAccountManager.isLogin()) {
                    AccountPluginManager.this.gotoUserInfo(params);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void gotoUserInfo(String params) {
        try {
            JSONObject jsonObject = new JSONObject(params);
            String uid = jsonObject.getString("uid");
            String src = jsonObject.optString("src");
            String ext = jsonObject.optString("ext");
            ActivityUtils.startActivitySafely(AppRuntime.getAppContext(), AccountBusinessRuntime.getAccountBusinessContext().getUserInfoIntent(uid, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "plugin_" + src, ext));
        } catch (Exception e2) {
            if (DEBUG) {
                Log.i(TAG, "profile exception:" + e2);
            }
        }
    }

    @PluginAccessable(methodName = "syncNA2Webview", paramClasses = {})
    public void syncNA2Webview() {
        BoxAccountManager boxAccountManager = this.mAccountManager;
        if (boxAccountManager instanceof BoxSapiAccountManager) {
            ((BoxSapiAccountManager) boxAccountManager).sdkLogin2Web(AppRuntime.getAppContext());
        }
    }

    @PluginAccessable(methodName = "getOpenBduss", paramClasses = {String.class, List.class, OnGetOpenBdussCallback.class})
    public void getOpenBduss(String clientId, List<String> tplList, final OnGetOpenBdussCallback openBdussCallback) {
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
                OnGetOpenBdussCallback onGetOpenBdussCallback = openBdussCallback;
                if (onGetOpenBdussCallback != null) {
                    onGetOpenBdussCallback.onStart();
                }
            }

            public void onFinish() {
                OnGetOpenBdussCallback onGetOpenBdussCallback = openBdussCallback;
                if (onGetOpenBdussCallback != null) {
                    onGetOpenBdussCallback.onFinish();
                }
            }
        });
    }
}
