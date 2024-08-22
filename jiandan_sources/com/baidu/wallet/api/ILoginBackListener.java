package com.baidu.wallet.api;

public interface ILoginBackListener {
    void onFail(int i2, String str);

    void onSuccess(int i2, String str);
}
