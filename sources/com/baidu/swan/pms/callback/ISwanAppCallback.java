package com.baidu.swan.pms.callback;

import com.baidu.swan.pms.model.PMSAppInfo;

public interface ISwanAppCallback {
    void onSwanAppReceive(PMSAppInfo pMSAppInfo);
}
