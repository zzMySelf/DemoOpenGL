package com.baidu.searchbox.account;

public interface ISmsLoginViewListener extends ILoginResultListener {
    void onCheckCodeViewHide();

    void onCheckCodeViewShow();

    void onRegister();
}
