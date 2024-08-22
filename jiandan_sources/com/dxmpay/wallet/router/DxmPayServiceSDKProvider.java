package com.dxmpay.wallet.router;

import com.baidu.wallet.router.RouterProvider;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;

public class DxmPayServiceSDKProvider extends RouterProvider {
    public void registerActions() {
        registerAction("enterDxmPayService", new EnterDxmPayServiceAction());
    }
}
