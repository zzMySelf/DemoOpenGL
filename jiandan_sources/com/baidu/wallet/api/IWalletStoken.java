package com.baidu.wallet.api;

import java.util.Map;

public interface IWalletStoken {
    Map<String, String> getLoginData();

    String getLoginStoken();

    String getTpl();
}
