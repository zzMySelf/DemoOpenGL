package com.baidu.swan.apps.favordata.callback;

public interface AddFavorItemCallback {
    void onAddFavorFail(boolean z);

    void onAddFavorSuccess();

    void onNetworkDisconnected();
}
