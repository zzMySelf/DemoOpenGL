package com.baidu.wallet.api;

import java.util.Map;

public interface ILoginValidateListener {
    void onValidateSuccess(Map<String, String> map);
}
