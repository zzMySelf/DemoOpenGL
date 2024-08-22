package com.baidu.sapi2.share;

import com.baidu.sapi2.SapiAccount;

public interface BdussStatusCallback {
    void onBdussInvalidate(String str);

    void onResultAccount(SapiAccount sapiAccount);
}
