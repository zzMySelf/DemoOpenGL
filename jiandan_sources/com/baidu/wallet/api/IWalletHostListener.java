package com.baidu.wallet.api;

public interface IWalletHostListener {
    void login(ILoginBackListener iLoginBackListener);

    boolean startPage(String str);
}
