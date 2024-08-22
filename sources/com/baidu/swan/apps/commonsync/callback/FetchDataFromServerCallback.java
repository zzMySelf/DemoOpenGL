package com.baidu.swan.apps.commonsync.callback;

import com.baidu.swan.apps.commonsync.CommonSyncServerData;

public interface FetchDataFromServerCallback {
    void onFail();

    void onSuccess(CommonSyncServerData commonSyncServerData);
}
