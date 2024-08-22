package com.baidu.wallet.api;

import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.passport.ThirdPartyLoginUtil;
import com.dxmpay.wallet.api.WalletLoginHelper;

public class WalletApiExt {
    public static WalletApiExt a;
    public WalletApiExtListener.SensorsAdapter b;

    public static class a {
        public static final WalletApiExt a = new WalletApiExt();
    }

    public static final WalletApiExt getInstance() {
        return a.a;
    }

    public WalletApiExtListener.SensorsAdapter getSensorsAdapter() {
        return this.b;
    }

    public void setLoginSyncListener(WalletApiExtListener.LoginstatuSyncListener loginstatuSyncListener) {
        WalletLoginHelper.getInstance().setLoginSyncListener(loginstatuSyncListener);
        WalletLoginHelper.getInstance().setLoginSyncListener(loginstatuSyncListener);
    }

    public void setSensorsAdapterImpl(WalletApiExtListener.SensorsAdapter sensorsAdapter) {
        this.b = sensorsAdapter;
    }

    public void setThirdPartyLoginImpl(WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface) {
        ThirdPartyLoginUtil.getInstance().setThirdPartyLoginImpl(thirdPartyLoginInterface);
        com.dxmpay.wallet.passport.ThirdPartyLoginUtil.getInstance().setThirdPartyLoginImpl(thirdPartyLoginInterface);
    }

    public WalletApiExt() {
    }
}
