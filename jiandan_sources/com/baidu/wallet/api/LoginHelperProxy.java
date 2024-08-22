package com.baidu.wallet.api;

import android.content.Context;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.wallet.api.WalletApiExtListener;

public abstract class LoginHelperProxy implements IWalletLoginListener, IWalletStoken, WalletApiExtListener.LoginstatuSyncListener {
    public abstract void clearOpenBduss();

    public abstract void configPass(Context context);

    public abstract void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, int i4, String str, Class<?>[] clsArr);

    public abstract void dynamicCallPass(Object obj, Object[] objArr, int i2, int i3, String str, Class<?>[] clsArr);

    public abstract int getBdussState();

    public abstract String getPassUid();

    public abstract String getPassUserName();

    public abstract WalletApiExtListener.LoginstatuSyncListener getSyncLoginListener();

    public abstract String getTpl();

    public abstract String getUnionId();

    public abstract void init(Context context, SapiConfiguration sapiConfiguration);

    public abstract void init(Context context, IWalletListener iWalletListener);

    public abstract boolean isDxmPassportLogin();

    public abstract boolean isInnerPassLogin();

    public abstract void logout();

    public abstract void logout(boolean z);

    public abstract void onlyLogin(ILoginBackListener iLoginBackListener);

    public abstract void onlyLogin(ILoginBackListener iLoginBackListener, String str);

    public abstract void registerGlobalCallback(Context context);

    public abstract void setIntervalDuration(long j);

    public abstract void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener);

    public abstract void setOpenBdussErrorCodeShowFlag(boolean z);

    public abstract void syncH5LoginStatus(Context context, String str);

    public abstract void verifyPassLogin(ILoginBackListener iLoginBackListener);

    public abstract void verifyPassLogin(boolean z, ILoginBackListener iLoginBackListener);
}
