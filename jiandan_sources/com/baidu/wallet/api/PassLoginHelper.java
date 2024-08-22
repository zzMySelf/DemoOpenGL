package com.baidu.wallet.api;

import android.content.Context;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.GlobalCallback;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.passport.LoginImpl;
import com.baidu.wallet.passport.PassLoginUtil;
import com.dxmpay.wallet.api.WalletLoginHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PassLoginHelper extends LoginHelperProxy {
    public static final int DYNAMIC_CALL_PASS_TYPE_ALL = 28;
    public static final int DYNAMIC_CALL_PASS_TYPE_BDUSS = 27;
    public static final int DYNAMIC_CALL_PASS_TYPE_UID = 26;
    public static WalletLoginHelper c;
    public WalletApiExtListener.LoginstatuSyncListener a;
    public final String b;
    public IWalletLoginListener d;
    public Context e;
    public IWalletListener f;

    public static class a {
        public static final PassLoginHelper a = new PassLoginHelper();
    }

    public static final PassLoginHelper getInstance() {
        return a.a;
    }

    public void clearOpenBduss() {
        logout(false);
    }

    public void configPass(Context context) {
        Domain domain = Domain.DOMAIN_ONLINE;
        String environment = DebugConfig.getInstance(context).getEnvironment();
        boolean z = true;
        if ("QA".equalsIgnoreCase(environment)) {
            domain = Domain.DOMAIN_QA;
        } else if ("RD".equalsIgnoreCase(environment)) {
            domain = Domain.DOMAIN_QA;
        } else {
            z = false;
        }
        SapiConfiguration.Builder initialShareStrategy = new SapiConfiguration.Builder(context).setProductLineInfo("bdwalletsdk", "1", "3s9y80v8ipz8huoh9k06hurn2lia5eez").setRuntimeEnvironment(domain).setSocialBindType(BindType.EXPLICIT).initialShareStrategy(LoginShareStrategy.DISABLED);
        Switch switchR = Switch.ON;
        SapiAccountManager.getInstance().init(initialShareStrategy.smsLoginConfig(new SapiConfiguration.SmsLoginConfig(switchR, switchR, switchR)).configurableViewLayout(Switch.ON).setSupportFaceLogin(false).sofireSdkConfig("600000", "69a0826db896e8c99e5d7bf63a14de3d", 600000).debug(z).build());
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, String str, Class<?>[] clsArr) {
        objArr[i3] = a(i2);
        new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new PASSMethodCallTransfer.DynamicCallbak() {
            public void onFailure(int i2, String str) {
                LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i2 + " , " + str);
            }
        }, clsArr);
    }

    public int getBdussState() {
        return SapiAccountManager.getInstance().getAccountService().getBdussState();
    }

    @Deprecated
    public Map<String, String> getLoginData(String str) {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener == null) {
            return Collections.emptyMap();
        }
        return iWalletLoginListener.getLoginData(str);
    }

    @Deprecated
    public String getLoginStoken(String str) {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginStoken(str);
        }
        return iWalletLoginListener.getLoginStoken(str);
    }

    public int getLoginType() {
        return 0;
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener == null) {
            PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener, i2);
        } else {
            iWalletLoginListener.getOpenBduss(z, iLoginBackListener, i2);
        }
    }

    public String getOpenLoginToken() {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginOpenToken();
        }
        return iWalletLoginListener.getOpenLoginToken();
    }

    public String getPassUid() {
        Map<String, String> loginData = getLoginData();
        if (loginData != null) {
            return loginData.get("pass_uid");
        }
        return null;
    }

    public String getPassUserName() {
        Map<String, String> loginData = getLoginData();
        if (loginData != null) {
            return loginData.get("pass_user_name");
        }
        return null;
    }

    public WalletApiExtListener.LoginstatuSyncListener getSyncLoginListener() {
        return this.a;
    }

    public String getTpl() {
        return "walletapp".equals(BeanConstants.CHANNEL_ID) ? "baiduwalletapp" : "bdwalletsdk";
    }

    public String getUnionId() {
        try {
            Map<String, String> loginData = getLoginData();
            if (loginData != null) {
                return loginData.get("pass_union_id");
            }
            return null;
        } catch (Exception e2) {
            LogUtil.d("Sensor", e2.getMessage());
            return null;
        }
    }

    public void handlerWalletError(int i2) {
        DXMSdkSAUtils.onEvent("#handlerWalletError");
        onHandleWalletError(i2);
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener != null) {
            iWalletLoginListener.handlerWalletError(i2);
        }
    }

    public void init(Context context, IWalletListener iWalletListener) {
        this.f = iWalletListener;
        this.d = new LoginImpl(context);
        PassLoginUtil.getInstance().init();
        this.e = DxmApplicationContextImpl.getApplicationContext(context);
    }

    public boolean isDxmPassportLogin() {
        return false;
    }

    public boolean isInnerPassLogin() {
        return false;
    }

    public boolean isLogin() {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().isLogin();
        }
        return iWalletLoginListener.isLogin();
    }

    public boolean isPassLogin() {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().isPassLogin();
        }
        return iWalletLoginListener.isPassLogin();
    }

    public void login(ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isPassLogin()) {
            if (iLoginBackListener != null) {
                iLoginBackListener.onSuccess(0, "");
            }
        } else if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener);
            }
        } else {
            IWalletListener iWalletListener = this.f;
            if (iWalletListener != null) {
                iWalletListener.login(iLoginBackListener);
            } else if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "");
            }
        }
    }

    public void logout() {
        PassLoginUtil.getInstance().logout();
    }

    public void onHandleWalletError(int i2) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.a;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.onHandleWalletError(i2);
        }
    }

    public void onLoginChanaged(Context context, Map<String, String> map) {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener != null) {
            iWalletLoginListener.onLoginChanaged(context, map);
        }
    }

    public void onWebViewLogout(Context context) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.a;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.onWebViewLogout(context);
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener, String str) {
        clearOpenBduss();
        if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener, str);
                return;
            }
            return;
        }
        IWalletListener iWalletListener = this.f;
        if (iWalletListener != null) {
            if (iWalletListener instanceof IWalletListener2) {
                ((IWalletListener2) iWalletListener).login(iLoginBackListener, str);
            } else {
                iWalletListener.login(iLoginBackListener);
            }
        } else if (iLoginBackListener != null) {
            iLoginBackListener.onFail(-1, "");
        }
    }

    public void registerGlobalCallback(final Context context) {
        SapiAccountManager.setGlobalCallback(new GlobalCallback() {
            public void onLoginStatusChange() {
                LogUtil.d(PassLoginHelper.this.b, "loginstate change");
            }

            public void onLogoutSuccess(SapiAccount sapiAccount) {
                super.onLogoutSuccess(sapiAccount);
                LogUtil.d(PassLoginHelper.this.b, "logout success");
            }

            public void onNeedInitPassSdk() {
                PassLoginHelper.this.configPass(context);
            }
        });
    }

    public void setIntervalDuration(long j) {
        PassLoginUtil.getInstance().setIntervalDuration(j);
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        this.a = loginstatuSyncListener;
    }

    public void setOpenBdussErrorCodeShowFlag(boolean z) {
        PassLoginUtil.getInstance().setErrorCodeSwitchFlag(z);
    }

    public boolean startPage(String str) {
        if (this.e == null) {
            return false;
        }
        DXMSdkSAUtils.onEvent("#startPage");
        if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.d;
            if (iWalletLoginListener != null && !iWalletLoginListener.startPage(str)) {
                BaiduWalletDelegate.getInstance().openH5Module(this.e, str, true);
            }
        } else {
            IWalletListener iWalletListener = this.f;
            if (iWalletListener == null) {
                LogUtil.d(this.b, "mWalletListener is null");
                Context context = this.e;
                GlobalUtils.toast(context, ResUtils.getString(context, "bd_wallet_load_fail"));
            } else if (!iWalletListener.startPage(str)) {
                BaiduWalletDelegate.getInstance().openH5Module(this.e, str, true);
            }
        }
        return true;
    }

    public void syncH5LoginStatus(Context context, final String str) {
        final int bdussState = getBdussState();
        String str2 = this.b;
        LogUtil.d(str2, "syncH5login bdussState = " + bdussState);
        if (bdussState == 2 || bdussState == 4) {
            syncLoginStatus(context, "", new WalletApiExtListener.SyncLoginStatusCb() {
                public void onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult syncResult) {
                    String a2 = PassLoginHelper.this.b;
                    LogUtil.d(a2, "syncH5logoin onResult code = " + syncResult);
                    DXMSdkSAUtils.onEventWithValues("DXMSyncH5LoginState", Arrays.asList(new String[]{String.valueOf(syncResult.getVal()), str, String.valueOf(bdussState)}));
                    if (syncResult == WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS) {
                        WalletLoginHelper.getInstance().getOpenBduss(false, (ILoginBackListener) null, 3);
                        WalletLoginHelper.getInstance().getOpenBduss(false, (ILoginBackListener) null);
                    }
                }
            });
        } else if (bdussState == 3) {
            String str3 = this.b;
            LogUtil.d(str3, "syncH5login = " + bdussState + " ; invoke logout");
            DXMSdkSAUtils.onEventWithValues("#invokePassLogout", Arrays.asList(new String[]{String.valueOf(str)}));
            onWebViewLogout(context);
            logout();
            AccountManager.getInstance(context).logout();
            WalletLoginHelper.getInstance().logout(false);
        }
    }

    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.a;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.syncLoginStatus(context, str, syncLoginStatusCb);
        }
    }

    public void verifyPassLogin(ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isPassLogin()) {
            getOpenBduss(true, iLoginBackListener, 5);
        } else if (iLoginBackListener != null) {
            iLoginBackListener.onFail(-1, "");
        }
    }

    public PassLoginHelper() {
        this.b = WalletLoginHelper.class.getSimpleName();
    }

    private PASSMethodCallTransfer.ParamsWap a(int i2) {
        PASSMethodCallTransfer.ParamsWap paramsWap = new PASSMethodCallTransfer.ParamsWap();
        paramsWap.param = "";
        HashMap hashMap = new HashMap();
        paramsWap.attributes = hashMap;
        if (i2 == 26) {
            hashMap.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
        } else if (i2 == 27) {
            hashMap.put(PASSMethodCallTransfer.ParamsWap.BDUSS, "bduss");
        } else {
            hashMap.put(PASSMethodCallTransfer.ParamsWap.UID, "uid");
        }
        return paramsWap;
    }

    public void logout(boolean z) {
        PassLoginUtil.getInstance().logout(z);
    }

    public Map<String, String> getLoginData() {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener == null) {
            return Collections.emptyMap();
        }
        return iWalletLoginListener.getLoginData(getTpl());
    }

    public String getLoginStoken() {
        IWalletLoginListener iWalletLoginListener = this.d;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginStoken(getTpl());
        }
        return iWalletLoginListener.getLoginStoken(getTpl());
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        getOpenBduss(z, iLoginBackListener, 0);
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, int i4, String str, Class<?>[] clsArr) {
        if (i2 == 28) {
            objArr[i3] = a(26);
            objArr[i4] = a(27);
        }
        new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new PASSMethodCallTransfer.DynamicCallbak() {
            public void onFailure(int i2, String str) {
                LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i2 + " , " + str);
            }
        }, clsArr);
    }

    public void init(Context context, SapiConfiguration sapiConfiguration) {
        SapiAccountManager.getInstance().init(sapiConfiguration);
    }

    public void verifyPassLogin(boolean z, ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isPassLogin()) {
            getOpenBduss(z, iLoginBackListener, 5);
        } else if (iLoginBackListener != null) {
            iLoginBackListener.onFail(-1, "未登录");
        }
    }

    public void login(ILoginBackListener iLoginBackListener, String str) {
        clearOpenBduss();
        if (isPassLogin()) {
            if (iLoginBackListener != null) {
                iLoginBackListener.onSuccess(0, "");
            }
        } else if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener, str);
            }
        } else {
            IWalletListener iWalletListener = this.f;
            if (iWalletListener != null) {
                if (iWalletListener instanceof IWalletListener2) {
                    ((IWalletListener2) iWalletListener).login(iLoginBackListener, str);
                } else {
                    iWalletListener.login(iLoginBackListener);
                }
            } else if (iLoginBackListener != null) {
                iLoginBackListener.onFail(-1, "");
            }
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.d;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener);
                return;
            }
            return;
        }
        IWalletListener iWalletListener = this.f;
        if (iWalletListener != null) {
            if (iWalletListener instanceof IWalletListener2) {
                ((IWalletListener2) iWalletListener).login(iLoginBackListener);
            } else {
                iWalletListener.login(iLoginBackListener);
            }
        } else if (iLoginBackListener != null) {
            iLoginBackListener.onFail(-1, "");
        }
    }
}
