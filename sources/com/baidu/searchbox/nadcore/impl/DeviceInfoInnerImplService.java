package com.baidu.searchbox.nadcore.impl;

import com.baidu.nadcore.core.IDeviceInfoInner;
import com.baidu.pyramid.runtime.service.CachedServiceFetcher;
import com.baidu.pyramid.runtime.service.ServiceNotFoundException;
import com.baidu.searchbox.feed.ad.ApkStateManager;

public class DeviceInfoInnerImplService extends CachedServiceFetcher<IDeviceInfoInner> {
    /* access modifiers changed from: protected */
    public IDeviceInfoInner createService() throws ServiceNotFoundException {
        return new IDeviceInfoInner() {
            public String iadEx() {
                return ApkStateManager.getApkStateEx();
            }
        };
    }
}
