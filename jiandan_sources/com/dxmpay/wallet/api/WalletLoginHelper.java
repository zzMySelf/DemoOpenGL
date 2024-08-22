package com.dxmpay.wallet.api;

import android.content.Context;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.openbduss.PASSMethodCallTransfer;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletListener;
import com.baidu.wallet.api.IWalletListener2;
import com.baidu.wallet.api.IWalletLoginListener;
import com.baidu.wallet.api.IWalletStoken;
import com.baidu.wallet.api.WalletApiExtListener;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import com.dxmpay.wallet.passport.LoginImpl;
import com.dxmpay.wallet.passport.PassLoginUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WalletLoginHelper implements IWalletLoginListener, IWalletStoken, WalletApiExtListener.LoginstatuSyncListener {
    public static final int DYNAMIC_CALL_PASS_TYPE_ALL = 28;
    public static final int DYNAMIC_CALL_PASS_TYPE_BDUSS = 27;
    public static final int DYNAMIC_CALL_PASS_TYPE_UID = 26;

    /* renamed from: ad  reason: collision with root package name */
    public final String f4132ad;

    /* renamed from: i  reason: collision with root package name */
    public WalletApiExtListener.LoginstatuSyncListener f4133i;

    /* renamed from: th  reason: collision with root package name */
    public IWalletLoginListener f4134th;

    /* renamed from: uk  reason: collision with root package name */
    public IWalletListener f4135uk;

    /* renamed from: yj  reason: collision with root package name */
    public Context f4136yj;

    public class ad extends PASSMethodCallTransfer.DynamicCallbak {
        public ad(WalletLoginHelper walletLoginHelper) {
        }

        public void onFailure(int i2, String str) {
            LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i2 + " , " + str);
        }
    }

    public class de implements WalletApiExtListener.SyncLoginStatusCb {
        public de() {
        }

        public void onResult(WalletApiExtListener.SyncLoginStatusCb.SyncResult syncResult) {
            String unused = WalletLoginHelper.this.f4132ad;
            "syncH5login onResult code = " + syncResult;
            StatisticManager.onEventWithValue("DXMSyncH5LoginState", String.valueOf(syncResult.getVal()));
            if (syncResult == WalletApiExtListener.SyncLoginStatusCb.SyncResult.SUCCESS) {
                WalletLoginHelper.getInstance().getOpenBduss(false, (ILoginBackListener) null);
            }
        }
    }

    public static class fe {
        public static final WalletLoginHelper qw = new WalletLoginHelper((qw) null);
    }

    public class qw extends PASSMethodCallTransfer.DynamicCallbak {
        public qw(WalletLoginHelper walletLoginHelper) {
        }

        public void onFailure(int i2, String str) {
            LogUtil.errord("PASS", "DYNAMIC CALL PASS FAILED ERROR MSG: " + i2 + " , " + str);
        }
    }

    public /* synthetic */ WalletLoginHelper(qw qwVar) {
        this();
    }

    public static final WalletLoginHelper getInstance() {
        return fe.qw;
    }

    public void clearOpenBduss() {
        logout(false);
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, String str, Class<?>[] clsArr) {
        objArr[i3] = qw(i2);
        new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new qw(this), clsArr);
    }

    public int getBdussState() {
        if (DxmPassManagerDelegate.getInstance().hasDxmPass()) {
            return DxmPassManagerDelegate.getInstance().getBdussState();
        }
        return SapiAccountManager.getInstance().getAccountService().getBdussState();
    }

    @Deprecated
    public Map<String, String> getLoginData(String str) {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
        if (iWalletLoginListener == null) {
            return Collections.emptyMap();
        }
        return iWalletLoginListener.getLoginData(str);
    }

    @Deprecated
    public String getLoginStoken(String str) {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginStoken(str);
        }
        return iWalletLoginListener.getLoginStoken(str);
    }

    public int getLoginType() {
        return 0;
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener) {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
        if (iWalletLoginListener == null) {
            PassLoginUtil.getInstance().getOpenBduss(z, iLoginBackListener);
        } else {
            iWalletLoginListener.getOpenBduss(z, iLoginBackListener);
        }
    }

    public void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2) {
    }

    public String getOpenLoginToken() {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
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
        return this.f4133i;
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
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public void handlerWalletError(int i2) {
        StatisticManager.onEvent("#handlerWalletError");
        onHandleWalletError(i2);
        IWalletLoginListener iWalletLoginListener = this.f4134th;
        if (iWalletLoginListener != null) {
            iWalletLoginListener.handlerWalletError(i2);
        }
    }

    public void init(Context context, IWalletListener iWalletListener) {
        this.f4135uk = iWalletListener;
        this.f4134th = new LoginImpl(context);
        PassLoginUtil.getInstance().init();
        this.f4136yj = context.getApplicationContext();
    }

    public boolean isInnerPassLogin() {
        return false;
    }

    public boolean isLogin() {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().isLogin();
        }
        return iWalletLoginListener.isLogin();
    }

    public boolean isPassLogin() {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
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
            IWalletLoginListener iWalletLoginListener = this.f4134th;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener);
            }
        } else {
            IWalletListener iWalletListener = this.f4135uk;
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
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.f4133i;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.onHandleWalletError(i2);
        }
    }

    public void onLoginChanaged(Context context, Map<String, String> map) {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
        if (iWalletLoginListener != null) {
            iWalletLoginListener.onLoginChanaged(context, map);
        }
    }

    public void onWebViewLogout(Context context) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.f4133i;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.onWebViewLogout(context);
        }
    }

    public void onlyLogin(ILoginBackListener iLoginBackListener, String str) {
        clearOpenBduss();
        if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.f4134th;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener, str);
                return;
            }
            return;
        }
        IWalletListener iWalletListener = this.f4135uk;
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

    public final PASSMethodCallTransfer.ParamsWap qw(int i2) {
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

    public void setIntervalDuration(long j) {
        PassLoginUtil.getInstance().setIntervalDuration(j);
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        this.f4133i = loginstatuSyncListener;
    }

    public void setOpenBdussErrorCodeShowFlag(boolean z) {
        PassLoginUtil.getInstance().setErrorCodeSwitchFlag(z);
    }

    public boolean startPage(String str) {
        if (this.f4136yj == null) {
            return false;
        }
        StatisticManager.onEvent("#startPage");
        if (isInnerPassLogin()) {
            IWalletLoginListener iWalletLoginListener = this.f4134th;
            if (iWalletLoginListener != null && !iWalletLoginListener.startPage(str)) {
                BaiduWalletDelegate.getInstance().openH5Module(this.f4136yj, str, true);
            }
        } else {
            IWalletListener iWalletListener = this.f4135uk;
            if (iWalletListener == null) {
                Context context = this.f4136yj;
                GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_load_fail"));
            } else if (!iWalletListener.startPage(str)) {
                BaiduWalletDelegate.getInstance().openH5Module(this.f4136yj, str, true);
            }
        }
        return true;
    }

    public void syncH5LoginStatus(Context context) {
        int i2;
        if (DxmPassManagerDelegate.getInstance().hasDxmPass()) {
            i2 = DxmPassManagerDelegate.getInstance().getBdussState();
        } else {
            i2 = SapiAccountManager.getInstance().getAccountService().getBdussState();
        }
        if (i2 == 2 || i2 == 4) {
            syncLoginStatus(context, "", new de());
        } else if (i2 == 3) {
            StatisticManager.onEvent("#invokePassLogout");
            onWebViewLogout(context);
            logout();
            AccountManager.getInstance(context).logout();
        }
    }

    public void syncLoginStatus(Context context, String str, WalletApiExtListener.SyncLoginStatusCb syncLoginStatusCb) {
        WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener = this.f4133i;
        if (loginstatuSyncListener != null) {
            loginstatuSyncListener.syncLoginStatus(context, str, syncLoginStatusCb);
        }
    }

    public void verifyPassLogin(ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isPassLogin()) {
            getOpenBduss(true, iLoginBackListener);
        } else if (iLoginBackListener != null) {
            iLoginBackListener.onFail(-1, "");
        }
    }

    public WalletLoginHelper() {
        this.f4132ad = WalletLoginHelper.class.getSimpleName();
    }

    public void logout(boolean z) {
        PassLoginUtil.getInstance().logout(z);
    }

    public Map<String, String> getLoginData() {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
        if (iWalletLoginListener == null) {
            return Collections.emptyMap();
        }
        return iWalletLoginListener.getLoginData(getTpl());
    }

    public String getLoginStoken() {
        IWalletLoginListener iWalletLoginListener = this.f4134th;
        if (iWalletLoginListener == null) {
            return PassLoginUtil.getInstance().getLoginStoken(getTpl());
        }
        return iWalletLoginListener.getLoginStoken(getTpl());
    }

    public void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, int i4, String str, Class<?>[] clsArr) {
        if (i2 == 28) {
            objArr[i3] = qw(26);
            objArr[i4] = qw(27);
        }
        new PASSMethodCallTransfer().dynamicCallMethod(obj, objArr, str, new ad(this), clsArr);
    }

    public void verifyPassLogin(boolean z, ILoginBackListener iLoginBackListener) {
        clearOpenBduss();
        if (isPassLogin()) {
            getOpenBduss(z, iLoginBackListener);
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
            IWalletLoginListener iWalletLoginListener = this.f4134th;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener, str);
            }
        } else {
            IWalletListener iWalletListener = this.f4135uk;
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
            IWalletLoginListener iWalletLoginListener = this.f4134th;
            if (iWalletLoginListener != null) {
                iWalletLoginListener.login(iLoginBackListener);
                return;
            }
            return;
        }
        IWalletListener iWalletListener = this.f4135uk;
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
