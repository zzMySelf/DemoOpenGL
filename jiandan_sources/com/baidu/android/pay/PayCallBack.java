package com.baidu.android.pay;

public interface PayCallBack {
    boolean isHideLoadingDialog();

    void onPayResult(int i2, String str);
}
