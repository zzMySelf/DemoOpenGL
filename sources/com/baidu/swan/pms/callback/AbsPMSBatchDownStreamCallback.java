package com.baidu.swan.pms.callback;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.model.PMSError;
import com.baidu.swan.pms.network.response.PMSGetPkgListResponse;

public abstract class AbsPMSBatchDownStreamCallback<T> extends AbsPMSDownStreamCallback<T> {
    public abstract void onSingleFetchError(PMSGetPkgListResponse.Item item, PMSAppInfo pMSAppInfo, PMSError pMSError);

    public abstract void onSwanAppInfoUpdate(PMSAppInfo pMSAppInfo, PMSAppInfo pMSAppInfo2);

    public void onPkgMainEmptyForbidden(PMSAppInfo swanAppInfo) {
    }
}
