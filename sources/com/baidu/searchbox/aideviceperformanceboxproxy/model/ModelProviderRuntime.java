package com.baidu.searchbox.aideviceperformanceboxproxy.model;

import com.baidu.searchbox.aideviceperformance.amendeddevicescore.IAmendedDeviceScoreModelProvider;
import com.baidu.searchbox.aideviceperformance.device.IDeviceInfoModelProvider;
import com.baidu.searchbox.aideviceperformance.dynamic.IDynamicModelProvider;
import com.baidu.searchbox.deviceinfo.amendeddevice.AmendedDeviceScoreModelProvider_Factory;
import com.baidu.searchbox.deviceinfo.device.DeviceInfoModelProvider_Factory;
import com.baidu.searchbox.deviceinfo.dynamic.DynamicModelProvider_Factory;

public class ModelProviderRuntime {
    public static IDeviceInfoModelProvider deviceInfoModelProvider() {
        return DeviceInfoModelProvider_Factory.get();
    }

    public static IDynamicModelProvider dynamicModelProvider() {
        return DynamicModelProvider_Factory.get();
    }

    public static IAmendedDeviceScoreModelProvider amendedDeviceScoreModelProvider() {
        return AmendedDeviceScoreModelProvider_Factory.get();
    }
}
