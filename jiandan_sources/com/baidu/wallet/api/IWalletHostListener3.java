package com.baidu.wallet.api;

import java.util.Map;

public interface IWalletHostListener3 extends IWalletHostListener {
    public static final String KEY_INDIVIDUATION = "individuation";
    public static final String STRING_VALUE_OF_FALSE = "0";
    public static final String STRING_VALUE_OF_TRUE = "1";

    Map<String, String> getConfiguration();
}
