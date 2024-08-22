package com.baidu.swan.apps.adaptation.interfaces;

public interface ISwanAppAdaptation {
    IOAuthObjectCreator createOAuthObjectCreator();

    IAccountSyncManager getAccountSyncManager();
}
