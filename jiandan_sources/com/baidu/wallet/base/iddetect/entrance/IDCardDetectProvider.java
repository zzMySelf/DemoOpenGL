package com.baidu.wallet.base.iddetect.entrance;

import com.baidu.wallet.router.RouterProvider;

public class IDCardDetectProvider extends RouterProvider {
    public void registerActions() {
        registerAction("enterIdCardDetect", new EnterWalletIdCardDetectAction());
    }
}
