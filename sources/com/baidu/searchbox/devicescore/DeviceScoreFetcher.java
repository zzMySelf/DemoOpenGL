package com.baidu.searchbox.devicescore;

import com.baidu.pyramid.runtime.service.CachedServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;

public class DeviceScoreFetcher extends CachedServiceFetcher<IDeviceScore> {
    /* access modifiers changed from: protected */
    public IDeviceScore createService() throws ServiceNotFoundException {
        return DeviceScoreManager.getInstance();
    }
}
