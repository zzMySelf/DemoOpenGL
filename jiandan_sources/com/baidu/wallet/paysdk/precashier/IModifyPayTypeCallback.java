package com.baidu.wallet.paysdk.precashier;

public interface IModifyPayTypeCallback {
    void onPayTypeModified(PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData);

    void onPayTypeModifiedFailed(int i2, String str);

    @Deprecated
    void onPayTypeSetted();
}
