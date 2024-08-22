package com.baidu.swan.apps.network;

import android.os.Bundle;
import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.swan.apps.process.ipc.SwanProcessCallManager;
import com.baidu.swan.apps.process.ipc.SwanProcessCallResult;

public class SwanGetNetworkQuality extends ProviderDelegation {
    public static final String NET_QUALITY = "net_quality";

    public Bundle execCall(Bundle bundle) {
        Bundle result = new Bundle();
        if (SwanAppNetworkUtils.isNetworkConnected()) {
            result.putInt("net_quality", NetworkQuality.getNetworkQuality());
        } else {
            result.putInt("net_quality", 3);
        }
        return result;
    }

    public static int getNetStatus() {
        SwanProcessCallResult result = SwanProcessCallManager.callMainProcessSyncResult(SwanGetNetworkQuality.class, (Bundle) null);
        if (result.isOk()) {
            return result.mResult.getInt("net_quality", -1);
        }
        return -1;
    }
}
