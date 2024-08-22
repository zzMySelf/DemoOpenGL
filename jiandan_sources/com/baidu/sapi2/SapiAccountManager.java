package com.baidu.sapi2;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.AccountSetResultCallback;
import com.baidu.sapi2.callback.GetUserAttrInfoCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.callback.IsShowRealNameCallback;
import com.baidu.sapi2.callback.LoginWithUCAuthCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.callback.ShareModelResultCallback;
import com.baidu.sapi2.callback.ShareModelWithCheckCallback;
import com.baidu.sapi2.callback.TidConvertSidCallback;
import com.baidu.sapi2.callback.UbcUploadImplCallback;
import com.baidu.sapi2.callback.UserLogoutCallback;
import com.baidu.sapi2.callback.ValidateWithHaoKanCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.common.LoginHistoryModel;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.GetUserAttrInfoDTO;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.loginhistory.AccountLoginAction;
import com.baidu.sapi2.dto.loginhistory.LoginHistoryItem;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.outsdk.PassBiometricCall;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.LoginWithUCAuthResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.utils.CommonUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sofire.ac.FH;
import com.baidu.sso.SSOManager;
import com.baidu.wallet.api.IWalletLoginListener;
import fe.fe.ppp.ad.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SapiAccountManager implements ISAccountManager {
    public static final int LOGOUT_TYPE_CLOSE_AN_ACCOUNT = 4;
    public static final int LOGOUT_TYPE_DEFAULT = 0;
    public static final int LOGOUT_TYPE_FREEZE_AN_ACCOUNT = 5;
    public static final int LOGOUT_TYPE_LOGIN_STATUS_ERROR = 3;
    public static final int LOGOUT_TYPE_LOGIN_STATUS_OVERDUE = 2;
    public static final int LOGOUT_TYPE_USER_OPERATION = 1;
    public static final String SESSION_BDUSS = "bduss";
    public static final String SESSION_DISPLAYNAME = "displayname";
    public static final String SESSION_UID = "uid";
    public static final String TAG = "SapiAccountManager";
    public static final int VERSION_CODE = 250;
    public static final String VERSION_NAME = "9.10.7.3";
    public static CheckUrlIsAvailableListener checkUrlIsAvailablelister;
    public static GlobalCallback globalCallback;
    public static SapiAccountManager instance;
    public static SapiAccountService sapiAccountService;
    public static SapiConfiguration sapiConfiguration;
    public static ServiceManager serviceManager;
    public static final List<String> sessionKeys;
    public static TidConvertSidCallback tidConvertSidCallback;
    public char isUseOpenBdussTpl = 0;
    public UbcUploadImplCallback ubcUploadImplCallback;

    public interface CheckUrlIsAvailableListener {
        void handleWebPageUrl(String str);

        boolean onCheckUrlIsAvailable(String str);
    }

    static {
        ArrayList arrayList = new ArrayList();
        sessionKeys = arrayList;
        arrayList.add("uid");
        sessionKeys.add("displayname");
        sessionKeys.add("bduss");
    }

    /* access modifiers changed from: private */
    public void checkIntegratedEnviroment() {
        try {
            Class.forName("fe.fe.ppp.qw");
        } catch (Exception unused) {
            CommonUtil.throwException("please update pass-httpclient sdk to last version");
        }
        try {
            Class.forName("com.baidu.sofire.ac.FH");
        } catch (Exception unused2) {
            CommonUtil.throwException("please import the package : sofire-sdk-*.aar");
        }
        if (sapiConfiguration.supportFaceLogin) {
            try {
                Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
            } catch (Throwable unused3) {
                CommonUtil.throwException("please import the package :pass-module-face.aar");
            }
        }
        if (sapiConfiguration.loginShareStrategy() != LoginShareStrategy.DISABLED && globalCallback == null) {
            CommonUtil.showErrorNotice("please register globalCallback to support share login function");
        }
    }

    public static CheckUrlIsAvailableListener getCheckUrlIsAvailablelister() {
        return checkUrlIsAvailablelister;
    }

    public static GlobalCallback getGlobalCallback() {
        GlobalCallback globalCallback2 = globalCallback;
        return globalCallback2 == null ? new GlobalCallback() {
            public void onLoginStatusChange() {
            }

            public void onNeedInitPassSdk() {
            }
        } : globalCallback2;
    }

    public static synchronized SapiAccountManager getInstance() {
        SapiAccountManager sapiAccountManager;
        synchronized (SapiAccountManager.class) {
            if (instance == null) {
                instance = new SapiAccountManager();
            }
            sapiAccountManager = instance;
        }
        return sapiAccountManager;
    }

    public static TidConvertSidCallback getTidConvertSidCallback() {
        return tidConvertSidCallback;
    }

    /* access modifiers changed from: private */
    public void initSofireSDK(SapiConfiguration sapiConfiguration2) {
        FH.init(sapiConfiguration2.context, sapiConfiguration2.sofireAppKey, sapiConfiguration2.sofireSecKey, 1);
        FH.setAgreePolicy(sapiConfiguration2.context, sapiConfiguration2.isAgreeDangerousProtocol());
    }

    private void loadHistoryActionLogin(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback, boolean z) {
        List<AccountLoginAction> loadHistoryAccounts = LoginHistoryLoginModel.loadHistoryAccounts();
        if (loadHistoryAccounts == null || loadHistoryAccounts.size() == 0) {
            statLoginHistoryLogin(z, false);
            loginHistoryCallback.onLoginFailure();
            return;
        }
        int size = loadHistoryAccounts.size();
        for (int i2 = 0; i2 < size; i2++) {
            AccountLoginAction accountLoginAction = loadHistoryAccounts.get(i2);
            if (TextUtils.equals(ad.rg(accountLoginAction.sapiAccount.bduss.getBytes(), false), loginHistoryModel.bduss)) {
                statLoginHistoryLogin(z, true);
                validate(accountLoginAction.sapiAccount);
                getUserInfoAndRefershAccount(accountLoginAction.sapiAccount, Enums.LastLoginType.HISTORY.getValue(), new JSONObject().toString());
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.HISTORY.getName());
                SapiUtils.getLastLoginType();
                loginHistoryCallback.onLoginSuccess(accountLoginAction.sapiAccount);
                return;
            }
        }
        statLoginHistoryLogin(z, false);
        loginHistoryCallback.onLoginFailure();
    }

    /* access modifiers changed from: private */
    public void processAvailableHistory(List<LoginHistoryItem> list, JSONArray jSONArray, LoginHistoryCallback loginHistoryCallback) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                String optString = jSONObject.optString(IWalletLoginListener.KEY_LOGIN_TYPE);
                String optString2 = jSONObject.optString("bduss");
                if (!TextUtils.isEmpty(optString2) && TextUtils.equals(optString, "history")) {
                    List<AccountLoginAction> loadHistoryAccounts = LoginHistoryLoginModel.loadHistoryAccounts();
                    if (loadHistoryAccounts != null && !loadHistoryAccounts.isEmpty()) {
                        for (int i3 = 0; i3 < loadHistoryAccounts.size(); i3++) {
                            AccountLoginAction accountLoginAction = loadHistoryAccounts.get(i3);
                            if (TextUtils.equals(ad.rg(accountLoginAction.sapiAccount.bduss.getBytes(), false), optString2)) {
                                jSONObject.put("uid", accountLoginAction.sapiAccount.uid);
                            }
                        }
                    }
                    arrayList.add(LoginHistoryModel.fromJSONObject(jSONObject));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("history_count", "" + list.size());
        hashMap.put("available_count", "" + arrayList.size());
        StatService.onEventAutoStat("na_history_show", hashMap);
        if (arrayList.size() > 0) {
            loginHistoryCallback.onSuccess(arrayList);
        } else {
            loginHistoryCallback.onFailure();
        }
    }

    public static void registerCheckUrlIsAvailableListener(CheckUrlIsAvailableListener checkUrlIsAvailableListener) {
        checkUrlIsAvailablelister = checkUrlIsAvailableListener;
    }

    public static void setGlobalCallback(GlobalCallback globalCallback2) {
        globalCallback = globalCallback2;
    }

    public static void setTidConvertSidCallback(TidConvertSidCallback tidConvertSidCallback2) {
        tidConvertSidCallback = tidConvertSidCallback2;
    }

    private void statLoginHistoryLogin(boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        String str = "1";
        hashMap.put("show_count", str);
        if (!z2) {
            str = "0";
        }
        hashMap.put("success_count", str);
        hashMap.put("f", z ? "na" : "web");
        StatService.onEventAutoStat("na_history_login", hashMap);
    }

    public static void unregisterCheckUrlIsAvailableListener() {
        checkUrlIsAvailablelister = null;
    }

    public void checkAvailableLoginHistory(final LoginHistoryCallback loginHistoryCallback) {
        String str;
        final List<LoginHistoryItem> availableLoginHistoryItems = LoginHistoryLoginModel.getAvailableLoginHistoryItems();
        JSONArray jSONArray = LoginHistoryItem.toJSONArray(availableLoginHistoryItems);
        if (jSONArray == null) {
            str = null;
        } else {
            str = jSONArray.toString();
        }
        if (TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("history_count", "0");
            hashMap.put("available_count", "0");
            StatService.onEventAutoStat("na_history_show", hashMap);
            loginHistoryCallback.onFailure();
            return;
        }
        getInstance().getAccountService().checkAvailableLoginHistory(str, new LoginHistoryCallback() {
            public void onFailure() {
                loginHistoryCallback.onFailure();
            }

            public void onResult(JSONArray jSONArray) {
                SapiAccountManager.this.processAvailableHistory(availableLoginHistoryItems, jSONArray, loginHistoryCallback);
            }
        });
    }

    public void checkInitialization() {
        if (sapiConfiguration == null) {
            getGlobalCallback().onNeedInitPassSdk();
        }
        if (sapiConfiguration == null && Log.enabled) {
            throw new IllegalStateException(SapiAccountManager.class.getSimpleName() + " have not been initialized");
        }
    }

    public SapiAccountService getAccountService() {
        checkInitialization();
        return sapiAccountService;
    }

    public SapiConfiguration getConfignation() {
        checkInitialization();
        return sapiConfiguration;
    }

    public String getCurrentZid(Context context) {
        return SapiSafeFacade.getInstance().getCurrentZid(context);
    }

    public ISAccountService getIsAccountService() {
        return getAccountService();
    }

    public List<SapiAccount> getLoginAccounts() {
        checkInitialization();
        return SapiContext.getInstance().getLoginAccounts();
    }

    public void getOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback) {
        GetOneKeyLoginStateDTO getOneKeyLoginStateDTO = new GetOneKeyLoginStateDTO();
        getOneKeyLoginStateDTO.connectTimeout = 15000;
        SapiAccountService sapiAccountService2 = sapiAccountService;
        if (sapiAccountService2 != null) {
            sapiAccountService2.getOneKeyLoginIsAvailable(getOneKeyLoginStateDTO, oneKeyLoginCallback);
        }
    }

    public SapiSafeFacade getSafeFacade() {
        checkInitialization();
        return SapiSafeFacade.getInstance();
    }

    public SapiConfiguration getSapiConfiguration() {
        checkInitialization();
        return sapiConfiguration;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r0 = r0.toJSONObject();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getSession(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            r2.checkInitialization()
            com.baidu.sapi2.SapiAccount r0 = r2.getSession()
            boolean r1 = r2.isValidSessionKey(r3)
            if (r1 == 0) goto L_0x0021
            boolean r1 = r2.isLogin()
            if (r1 == 0) goto L_0x0021
            if (r0 != 0) goto L_0x0016
            goto L_0x0021
        L_0x0016:
            org.json.JSONObject r0 = r0.toJSONObject()
            if (r0 == 0) goto L_0x0021
            java.lang.String r3 = r0.optString(r3, r4)
            return r3
        L_0x0021:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.SapiAccountManager.getSession(java.lang.String, java.lang.String):java.lang.String");
    }

    public void getShareModels(long j, ShareModelCallback shareModelCallback) {
        getShareModels(j, true, shareModelCallback);
    }

    public int getSmsCodeLength() {
        return EnhancedService.getInstance(sapiConfiguration, "9.10.7.3").getSmsCodeLength();
    }

    public String getTpl() {
        SapiConfiguration sapiConfiguration2 = sapiConfiguration;
        return sapiConfiguration2 == null ? "" : sapiConfiguration2.tpl;
    }

    public UbcUploadImplCallback getUbcUploadImplCallback() {
        UbcUploadImplCallback ubcUploadImplCallback2 = this.ubcUploadImplCallback;
        return ubcUploadImplCallback2 == null ? new UbcUploadImplCallback() {
            public void onEvent(String str, JSONObject jSONObject) {
            }
        } : ubcUploadImplCallback2;
    }

    public void getUserAttrInfo(GetUserAttrInfoDTO getUserAttrInfoDTO, GetUserAttrInfoCallback getUserAttrInfoCallback) {
        if (getUserAttrInfoDTO == null || TextUtils.isEmpty(getUserAttrInfoDTO.mAppname)) {
            GetUserAttrInfoResult getUserAttrInfoResult = new GetUserAttrInfoResult();
            getUserAttrInfoResult.setResultCode(-103);
            getUserAttrInfoResult.setResultMsg("请核对入参");
            getUserAttrInfoCallback.onFailure(getUserAttrInfoResult);
            return;
        }
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null || TextUtils.isEmpty(currentAccount.bduss)) {
            GetUserAttrInfoResult getUserAttrInfoResult2 = new GetUserAttrInfoResult();
            getUserAttrInfoResult2.setResultCode(-102);
            getUserAttrInfoResult2.setResultMsg(GetUserAttrInfoResult.MSG_NOT_LOGIN);
            getUserAttrInfoCallback.onFailure(getUserAttrInfoResult2);
            return;
        }
        List<String> list = getUserAttrInfoDTO.mFields;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!(list == null || list.size() == 0)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str = list.get(i2);
                if (str != null) {
                    sb.append("\"");
                    sb.append(str);
                    sb.append("\"");
                    if (i2 < list.size() - 1) {
                        sb.append(",");
                    }
                }
            }
        }
        sb.append("]");
        List<String> list2 = getUserAttrInfoDTO.mExtFields;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        if (!(list2 == null || list2.size() == 0)) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                String str2 = list2.get(i3);
                if (str2 != null) {
                    sb2.append("\"");
                    sb2.append(str2);
                    sb2.append("\"");
                    if (i3 < list2.size() - 1) {
                        sb2.append(",");
                    }
                }
            }
        }
        sb2.append("]");
        String substring = ad.rg(String.format("%s%s%s%s", new Object[]{currentAccount.bduss, getUserAttrInfoDTO.mAppname, sb, sb2}).getBytes(), false).substring(0, 16);
        GetUserAttrInfoResult parseFromJSONObject = GetUserAttrInfoResult.parseFromJSONObject(SapiContext.getInstance().getUserAttrInfo(substring));
        String str3 = SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_FUSION).extraParams;
        long j = 0;
        if (!TextUtils.isEmpty(str3)) {
            try {
                j = new JSONObject(str3).optLong("rt");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (parseFromJSONObject.isAvailable(j)) {
            getUserAttrInfoCallback.onSuccess(parseFromJSONObject);
            return;
        }
        getInstance().getAccountService().getUserAttrInfo(getUserAttrInfoDTO.mAppname, sb.toString(), sb2.toString(), substring, getUserAttrInfoCallback);
    }

    public void getUserInfoAndRefershAccount(final SapiAccount sapiAccount, int i2, String str) {
        if (sapiAccount != null) {
            getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() {
                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                }

                public void onFailure(GetUserInfoResult getUserInfoResult) {
                }

                public void onFinish() {
                }

                public void onStart() {
                }

                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    if (getUserInfoResult != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(getUserInfoResult.uid)) {
                        SapiAccount sapiAccount = sapiAccount;
                        sapiAccount.username = getUserInfoResult.username;
                        sapiAccount.displayname = getUserInfoResult.displayname;
                        sapiAccount.portrait = getUserInfoResult.portraitSign;
                        SapiAccountManager.getInstance().validate(sapiAccount);
                    }
                }
            }, sapiAccount.bduss, String.valueOf(i2), str);
        }
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList() {
        return getV2ShareModelList("");
    }

    public String getVersionName() {
        return "9.10.7.3";
    }

    public String getZidAndCheckSafe(Context context, String str, int i2) {
        return SapiSafeFacade.getInstance().getZidAndCheckSafe(context, str, i2);
    }

    public synchronized void init(final SapiConfiguration sapiConfiguration2) {
        if (sapiConfiguration2 == null) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " initialized failed: SapiConfiguration can't be null");
        } else if (sapiConfiguration == null) {
            sapiConfiguration = sapiConfiguration2;
            sapiAccountService = new SapiAccountService();
            ServiceManager instance2 = ServiceManager.getInstance();
            serviceManager = instance2;
            instance2.setIsAccountManager(this);
            setUbcUploadImplCallback(sapiConfiguration2.ubcUploadImplCallback);
            new OneKeyLoginSdkCall().initOneKeyLoginSdk(sapiConfiguration2);
            Log.d("SDK_INIT", "start time=" + System.currentTimeMillis());
            if (sapiConfiguration2.context instanceof Application) {
                ActivityStackManager.getInstance().register((Application) sapiConfiguration2.context);
            } else if (sapiConfiguration2.deApplicationContext != null) {
                ActivityStackManager.getInstance().register((Application) sapiConfiguration2.deApplicationContext);
            }
            ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() {
                public void run() {
                    boolean z;
                    try {
                        SapiAccountManager.this.checkIntegratedEnviroment();
                    } catch (RuntimeException e) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                throw e;
                            }
                        });
                    }
                    SapiContext instance = SapiContext.getInstance();
                    instance.setShareStorage((JSONArray) null);
                    new ShareCallPacking().syncMarkLoginState((!instance.isFirstLaunch() || SapiAccountManager.sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) ? 0 : 4);
                    sapiConfiguration2.clientIp = SapiUtils.getLocalIpAddress();
                    List<String> initialCachePackagesWhiteList = SapiOptions.getInitialCachePackagesWhiteList();
                    String packageName = sapiConfiguration2.context.getPackageName();
                    Iterator<String> it = initialCachePackagesWhiteList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (packageName.matches(it.next())) {
                                z = false;
                                break;
                            }
                        } else {
                            z = true;
                            break;
                        }
                    }
                    if (z) {
                        new SapiCache().init(sapiConfiguration2.context);
                    }
                    instance.setHostsHijacked(SapiDeviceUtils.checkHosts(sapiConfiguration2.context));
                    try {
                        Class.forName("com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager");
                        Class.forName("com.baidu.pass.face.platform.FaceSDKManager");
                        new PassBiometricCall().initPassBioSDK(SapiAccountManager.sapiConfiguration);
                    } catch (Exception unused) {
                        Log.e("SDK_INIT", "VIS SDK可能未集成，请集成正确的VIS SDK");
                        sapiConfiguration2.supportFaceLogin = false;
                    }
                    if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_NEW_INIT_SOFIRE).meetGray) {
                        Log.e("SDK_INIT", "old sofire init run");
                        SapiAccountManager.this.initSofireSDK(sapiConfiguration2);
                    }
                    if (TextUtils.isEmpty(SapiUtils.getCookieBduss()) || TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
                        SapiAccountManager.getInstance().getAccountService().webLogin(sapiConfiguration2.context);
                    }
                    Log.d("SDK_INIT", "end time=" + System.currentTimeMillis());
                    LoginHistoryLoginModel.updateLoginHistoryInfo();
                    SapiConfiguration sapiConfiguration = sapiConfiguration2;
                    SapiUtils.setCookiesTPLCuid(sapiConfiguration.context, sapiConfiguration.mTPLCuid);
                }
            }));
            if (SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.KEY_NEW_INIT_SOFIRE).meetGray) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        try {
                            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                                public boolean queueIdle() {
                                    Log.e("SDK_INIT", "new sofire init run");
                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                    SapiAccountManager.this.initSofireSDK(sapiConfiguration2);
                                    return false;
                                }
                            });
                        } catch (Exception e) {
                            SapiAccountManager.this.initSofireSDK(sapiConfiguration2);
                            Log.e(e);
                        }
                    }
                });
            }
        } else {
            Log.d(getClass().getSimpleName() + " had already been initialized", new Object[0]);
        }
    }

    public boolean isLogin() {
        checkInitialization();
        return SapiAccount.isValidAccount(SapiContext.getInstance().getCurrentAccount());
    }

    public void isShowRealNameGuide(IsShowRealNameCallback isShowRealNameCallback) {
        IsShowRealNameGuideDTO isShowRealNameGuideDTO = new IsShowRealNameGuideDTO();
        isShowRealNameGuideDTO.type = "setting";
        SapiAccount session = getSession();
        isShowRealNameGuideDTO.historyTime = SapiContext.getInstance().getClickRealNameTimes(session != null ? session.uid : "");
        getInstance().getAccountService().isShowRealNameGuide(isShowRealNameGuideDTO, isShowRealNameCallback);
    }

    public boolean isValidSessionKey(String str) {
        return !TextUtils.isEmpty(str) && sessionKeys.contains(str);
    }

    public void loadHistoryActionLoginFromNa(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback) {
        loadHistoryActionLogin(loginHistoryModel, loginHistoryCallback, true);
    }

    public void loadHistoryActionLoginFromWap(LoginHistoryModel loginHistoryModel, LoginHistoryCallback loginHistoryCallback) {
        loadHistoryActionLogin(loginHistoryModel, loginHistoryCallback, false);
    }

    public void loginWithUCAuth(String str, LoginWithUCAuthCallback loginWithUCAuthCallback) {
        if (TextUtils.isEmpty(str)) {
            LoginWithUCAuthResult loginWithUCAuthResult = new LoginWithUCAuthResult();
            loginWithUCAuthResult.setResultCode(-103);
            loginWithUCAuthResult.setResultMsg("请核对入参");
            loginWithUCAuthCallback.onFailure(loginWithUCAuthResult);
        } else if (sapiConfiguration == null) {
            LoginWithUCAuthResult loginWithUCAuthResult2 = new LoginWithUCAuthResult();
            loginWithUCAuthResult2.setResultCode(-102);
            loginWithUCAuthResult2.setResultMsg(LoginWithUCAuthResult.MSG_NOT_INIT);
            loginWithUCAuthCallback.onFailure(loginWithUCAuthResult2);
        } else {
            SapiAccountService accountService = getInstance().getAccountService();
            SapiConfiguration sapiConfiguration2 = sapiConfiguration;
            accountService.loginWithUCAuth(sapiConfiguration2.tpl, sapiConfiguration2.appId, str, loginWithUCAuthCallback);
        }
    }

    public void logout() {
        logout(0);
    }

    public void onShareEvent(List<ShareStorage.StorageModel> list, String str) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            for (ShareStorage.StorageModel next : list) {
                if (next != null) {
                    jSONArray.put(next.tpl);
                    jSONArray2.put(next.app);
                }
            }
        }
    }

    public void removeLoginAccount(boolean z, SapiAccount sapiAccount) {
        checkInitialization();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        SapiContext.getInstance().removeLoginAccount(sapiAccount);
        new ShareCallPacking().asyncMarkLoginState(3);
        if (z && currentAccount != null && !TextUtils.isEmpty(sapiAccount.uid) && sapiAccount.uid.equals(currentAccount.uid)) {
            getGlobalCallback().onLogoutSuccess(sapiAccount);
        }
    }

    public void setAgreeDangerousProtocol(boolean z) {
        SapiConfiguration sapiConfiguration2 = getSapiConfiguration();
        if (sapiConfiguration2 != null) {
            sapiConfiguration2.setAgreeDangerousProtocol(z);
            sapiConfiguration2.clientIp = SapiUtils.getLocalIpAddress();
            try {
                SSOManager.fe().i(sapiConfiguration2.context, sapiConfiguration2.isAgreeDangerousProtocol());
            } catch (Exception unused) {
                Log.e("setAgreeProtocol", "一键登录可能未集成,不需要设置是否同意隐私协议");
            } catch (Throwable unused2) {
                Log.e("setAgreeProtocol", "一键登录可能未集成,不需要设置是否同意隐私协议");
            }
            try {
                new PassBiometricCall().setFaceModuleAgreeDangerousProtocol(z);
            } catch (Exception unused3) {
                Log.e("setAgreeProtocol", "VIS SDK可能未集成,不需要设置是否同意隐私协议");
            } catch (Throwable unused4) {
                Log.e("setAgreeProtocol", "VIS SDK可能未集成,不需要设置是否同意隐私协议");
            }
        }
    }

    public void setSid() {
        if (tidConvertSidCallback != null) {
            String tid = SapiContext.getInstance().getTid();
            if (!TextUtils.isEmpty(tid)) {
                SapiContext.getInstance().setSearchBoxSid(tidConvertSidCallback.tidConvertSid(tid.split("-")));
                return;
            }
            Log.d(TAG, "tid is null or empty");
            return;
        }
        Log.d(TAG, "convert tid to sid failed, because tidConvertSidCallback is null");
    }

    public void setUbcUploadImplCallback(UbcUploadImplCallback ubcUploadImplCallback2) {
        this.ubcUploadImplCallback = ubcUploadImplCallback2;
    }

    public boolean validate(SapiAccount sapiAccount) {
        return validate(sapiAccount, true, true, false);
    }

    public void validateBdussCookie(Context context) {
        String cookieBduss = SapiUtils.getCookieBduss();
        String cookieBdussBfess = SapiUtils.getCookieBdussBfess();
        if (TextUtils.isEmpty(cookieBduss) && !TextUtils.isEmpty(cookieBdussBfess)) {
            SapiUtils.webLogout(context);
        }
        if (!TextUtils.isEmpty(cookieBduss) && TextUtils.isEmpty(cookieBdussBfess)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String next : SapiUtils.getAuthorizedDomains()) {
                    arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + next, SapiUtils.buildBDUSSBFESSCookie(next, cookieBduss)));
                }
                SapiUtils.syncCookies(context, arrayList);
            } catch (Throwable th2) {
                Log.e(th2.getMessage(), new Object[0]);
            }
        }
    }

    public void validateOnlyHaoKan(String str, ValidateWithHaoKanCallback validateWithHaoKanCallback) {
        SapiAccountService sapiAccountService2 = sapiAccountService;
        if (sapiAccountService2 != null) {
            sapiAccountService2.validateOnlyHaoKan(str, validateWithHaoKanCallback);
        }
    }

    public void getShareModels(long j, final boolean z, final ShareModelCallback shareModelCallback) {
        checkInitialization();
        ShareLoginModel.getInstance().getShareModels(j, new ShareModelWithCheckCallback() {
            public void compatibilityOld(List<ShareStorage.StorageModel> list, String str) {
                SapiAccountManager.this.onShareEvent(list, str);
                if (z) {
                    ShareUtils.getOnlineAppShareModel(list, str, shareModelCallback);
                } else {
                    shareModelCallback.onReceiveShareModels(list);
                }
            }

            public void onFailure(int i2, String str, String str2) {
                compatibilityOld(new ArrayList(), str2);
            }

            public void onSuccess(List<ShareStorage.StorageModel> list, String str) {
                compatibilityOld(list, str);
            }
        });
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        checkInitialization();
        return ShareLoginModel.getInstance().getV2ShareModelList(str);
    }

    public void logout(int i2) {
        getInstance().getAccountService().userLogout(i2, new UserLogoutCallback() {
            public void onFailure(SapiResult sapiResult) {
                Object[] objArr = new Object[1];
                objArr[0] = sapiResult == null ? "result is null" : Integer.valueOf(sapiResult.getResultCode());
                Log.e(Log.TAG, objArr);
            }

            public void onSuccess(SapiResult sapiResult) {
                Object[] objArr = new Object[1];
                objArr[0] = sapiResult == null ? "result is null" : Integer.valueOf(sapiResult.getResultCode());
                Log.e(Log.TAG, objArr);
            }
        });
        StatService.onEvent("logout", Collections.singletonMap("di", SapiDeviceInfo.getDeviceInfo("sdk_api_logout")));
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        removeLoginAccount(true, currentAccount);
        if (currentAccount != null) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_UID, currentAccount.uid);
        }
    }

    public boolean validate(SapiAccount sapiAccount, boolean z, boolean z2) {
        return validate(sapiAccount, z, z2, false);
    }

    public boolean validate(SapiAccount sapiAccount, boolean z, boolean z2, boolean z3) {
        checkInitialization();
        if (sapiAccount == null) {
            return false;
        }
        ShareAccountAccessor.getAccessor().updatePtoken(sapiAccount);
        SapiContext instance2 = SapiContext.getInstance();
        instance2.setCurrentAccount(sapiAccount, z2, z3, (AccountSetResultCallback) null);
        instance2.addLoginAccount(sapiAccount);
        new PtokenStat().onEvent(PtokenStat.NATIVE_2_WEB);
        if (z) {
            new ShareStorage().asyncSet(2);
        }
        getGlobalCallback().onValidateSuccess(sapiAccount);
        return true;
    }

    public void getShareModels(long j, ShareModelResultCallback shareModelResultCallback) {
        getShareModels(j, true, shareModelResultCallback);
    }

    public void getShareModels(long j, final boolean z, final ShareModelResultCallback shareModelResultCallback) {
        checkInitialization();
        ShareLoginModel.getInstance().getShareModels(j, new ShareModelWithCheckCallback() {
            public void onFailure(int i2, String str, String str2) {
                Log.e("sss", "未获取到互通数据from=" + str2);
                SapiAccountManager.this.onShareEvent(new ArrayList(), str2);
                ShareModelResultCallback shareModelResultCallback = shareModelResultCallback;
                if (shareModelResultCallback != null) {
                    shareModelResultCallback.onFailure(i2, str);
                }
            }

            public void onSuccess(List<ShareStorage.StorageModel> list, String str) {
                Log.e("sss", "获取到互通数据from=" + str);
                if (z) {
                    Log.e("sss", "发起检测互通登录数据是有有效");
                    ShareUtils.getOnlineAppShareModel(list, str, shareModelResultCallback);
                    return;
                }
                shareModelResultCallback.onSuccess(list);
            }
        });
    }

    public String getSession(String str) {
        checkInitialization();
        return getSession(str, (String) null);
    }

    public SapiAccount getSession() {
        checkInitialization();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (this.isUseOpenBdussTpl == 0) {
            SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
            if (!sapiOptions.getOpenBdussTpls().contains(getConfignation().tpl) || sapiOptions.canGetBduss) {
                this.isUseOpenBdussTpl = 2;
            } else {
                this.isUseOpenBdussTpl = 1;
            }
        }
        if (currentAccount != null && this.isUseOpenBdussTpl == 1) {
            currentAccount.uid = "";
            currentAccount.bduss = "";
        }
        return currentAccount;
    }
}
