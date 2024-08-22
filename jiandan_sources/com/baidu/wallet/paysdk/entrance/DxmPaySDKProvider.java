package com.baidu.wallet.paysdk.entrance;

import com.baidu.wallet.router.RouterProvider;
import com.dxmpay.wallet.core.beans.BeanConstants;

public class DxmPaySDKProvider extends RouterProvider {
    public void registerActions() {
        registerAction("gotoWalletService", new EnterWalletServiceAction());
        registerAction("enterClearRnAuthBack", new EnterWalletClearRnAuthBackAction());
        registerAction("enterSetRnAuthResult", new EnterWalletSetRnAuthResultAction());
        registerAction("enterDoPayWithParams", new EnterWalletDoPayWithParamsAction());
        registerAction("enterDoInnerBind", new EnterWalletDoInnerBindAction());
        registerAction("enterDoRnAuth", new EnterWalletDoRnAuthAction());
        registerAction("enterGetPayMethod", new EnterWalletGetPayMethodAction());
        registerAction("enterChangePayMethod", new EnterWalletChangePayMethodAction());
        registerAction("enterPreOrderPay", new EnterWalletPreOrderPayAction());
        registerAction("enterDoRemotePay", new EnterWalletDoRemotePayAction());
        registerAction("enterDoPostEvent", new EnterWalletDoPostEventAction());
        registerAction(BeanConstants.SDK_ENTER_WALLET_DXM_PAY_SERVICE, new EnterWalletDxmPayServiceAction());
    }
}
