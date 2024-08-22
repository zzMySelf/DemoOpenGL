package com.baidu.wallet.api;

import android.content.Context;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class WalletLoginHelper implements IWalletLoginListener, IWalletStoken, WalletApiExtListener.LoginstatuSyncListener {
    public static final int DYNAMIC_CALL_PASS_TYPE_ALL = 28;
    public static final int DYNAMIC_CALL_PASS_TYPE_BDUSS = 27;
    public static final int DYNAMIC_CALL_PASS_TYPE_UID = 26;
    public static final int OTHRE = 0;
    public static final int SDK_AFTER_LOGIN = 6;
    public static final int SDK_LANGBRIDGE_ENTRANCE_FLAG = 1;
    public static final int SDK_SCANCODE_ENTRANCE_FLAG = 2;
    public static final int SDK_START_SYNC_STATUS_FLAG = 4;
    public static final int SDK_START_VERIFY_LOGINSTATUS_FLAG = 5;
    public static final int SDK_SYNC_STATUS_FLAG = 3;
    public static final String c = "is_dxm_login";
    public static final String e = "com.dxm.pass_gate.DxmAccountManager";
    public WalletApiExtListener.LoginstatuSyncListener a;
    public final String b;
    public LoginHelperProxy d;
    public boolean f;
    public Class<?> g;
    public boolean h;

    public static class a {
        public static final WalletLoginHelper a = new WalletLoginHelper();
    }

    public static final WalletLoginHelper getInstance() {
        return a.a;
    }

    public void clearOpenBduss() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.clearOpenBduss();
        }
    }

    public void configPass(Context context) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.configPass(context);
        }
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, String str, Class<?>[] clsArr) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.dynamicCallPass(obj, objArr, i2, i3, str, clsArr);
        }
    }

    public int getBdussState() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.getBdussState();
        }
        return 0;
    }

    @Deprecated
    public Map<String, String> getLoginData(String str) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.getLoginData(str);
        }
        return Collections.emptyMap();
    }

    @Deprecated
    public String getLoginStoken(String str) {
        LoginHelperProxy loginHelperProxy = this.d;
        return loginHelperProxy != null ? loginHelperProxy.getLoginStoken(str) : "";
    }

    public int getLoginType() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.getLoginType();
        }
        return 0;
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.getOpenBduss(z, iLoginBackListener, i2);
        }
    }

    public String getOpenLoginToken() {
        LoginHelperProxy loginHelperProxy = this.d;
        return loginHelperProxy != null ? loginHelperProxy.getOpenLoginToken() : "";
    }

    public String getPassUid() {
        LoginHelperProxy loginHelperProxy = this.d;
        return loginHelperProxy != null ? loginHelperProxy.getPassUid() : "";
    }

    public String getPassUserName() {
        LoginHelperProxy loginHelperProxy = this.d;
        return loginHelperProxy != null ? loginHelperProxy.getPassUserName() : "";
    }

    public WalletApiExtListener.LoginstatuSyncListener getSyncLoginListener() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.getSyncLoginListener();
        }
        return null;
    }

    public String getTpl() {
        LoginHelperProxy loginHelperProxy = this.d;
        return loginHelperProxy != null ? loginHelperProxy.getTpl() : "";
    }

    public String getUnionId() {
        LoginHelperProxy loginHelperProxy = this.d;
        return loginHelperProxy != null ? loginHelperProxy.getUnionId() : "";
    }

    public void handlerWalletError(int i2) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.handlerWalletError(i2);
        }
    }

    public void init(Context context, IWalletListener iWalletListener) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.init(context, iWalletListener);
        }
    }

    public boolean isDxmLogin() {
        if (!this.f) {
            try {
                this.g = Class.forName(e);
            } catch (Throwable unused) {
            }
            this.f = true;
        }
        if (!this.h) {
            this.h = true;
            if (this.g != null) {
                DXMSdkSAUtils.onEventWithValues(c, Arrays.asList(new String[]{"1"}));
            } else {
                DXMSdkSAUtils.onEventWithValues(c, Arrays.asList(new String[]{"2"}));
            }
        }
        if (this.g != null) {
            return true;
        }
        return false;
    }

    public boolean isDxmPassportLogin() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.isDxmPassportLogin();
        }
        return false;
    }

    public boolean isInnerPassLogin() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.isInnerPassLogin();
        }
        return false;
    }

    public boolean isLogin() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.isLogin();
        }
        return false;
    }

    public boolean isPassLogin() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.isPassLogin();
        }
        return false;
    }

    public void login(ILoginBackListener iLoginBackListener) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.login(iLoginBackListener);
        }
    }

    public void logout() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.logout();
        }
    }

    public void onHandleWalletError(int i2) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.onHandleWalletError(i2);
        }
    }

    public void onLoginChanaged(Context context, Map<String, String> map) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.onLoginChanaged(context, map);
        }
    }

    public void onWebViewLogout(Context context) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.onWebViewLogout(context);
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener, String str) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.onlyLogin(iLoginBackListener, str);
        }
    }

    public void registerGlobalCallback(Context context) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.registerGlobalCallback(context);
        }
    }

    public void setIntervalDuration(long j) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.setIntervalDuration(j);
        }
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.setLoginSyncListener(loginstatuSyncListener);
        }
    }

    public void setOpenBdussErrorCodeShowFlag(boolean z) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.setOpenBdussErrorCodeShowFlag(z);
        }
    }

    public boolean startPage(String str) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.startPage(str);
        }
        return false;
    }

    public void syncH5LoginStatus(Context context, String str) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.syncH5LoginStatus(context, str);
        }
    }

    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.syncLoginStatus(context, str, syncLoginStatusCb);
        }
    }

    public void verifyPassLogin(ILoginBackListener iLoginBackListener) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.verifyPassLogin(iLoginBackListener);
        }
    }

    public WalletLoginHelper() {
        this.b = WalletLoginHelper.class.getSimpleName();
        this.h = false;
        if (isDxmLogin()) {
            this.d = DxmLoginHelper.getInstance();
        } else {
            this.d = PassLoginHelper.getInstance();
        }
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, int i4, String str, Class<?>[] clsArr) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.dynamicCallPass(obj, objArr, i2, i3, i4, str, clsArr);
        }
    }

    public String getLoginStoken() {
        LoginHelperProxy loginHelperProxy = this.d;
        return loginHelperProxy != null ? loginHelperProxy.getLoginStoken(getTpl()) : "";
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.getOpenBduss(z, iLoginBackListener, 0);
        }
    }

    public void init(Context context, SapiConfiguration sapiConfiguration) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.init(context, sapiConfiguration);
        }
    }

    public void login(ILoginBackListener iLoginBackListener, String str) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.login(iLoginBackListener, str);
        }
    }

    public void logout(boolean z) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.logout(z);
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.onlyLogin(iLoginBackListener);
        }
    }

    public void verifyPassLogin(boolean z, ILoginBackListener iLoginBackListener) {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            loginHelperProxy.verifyPassLogin(z, iLoginBackListener);
        }
    }

    public Map<String, String> getLoginData() {
        LoginHelperProxy loginHelperProxy = this.d;
        if (loginHelperProxy != null) {
            return loginHelperProxy.getLoginData(getTpl());
        }
        return Collections.emptyMap();
    }
}
