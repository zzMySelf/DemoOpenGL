package com.baidu.searchbox.deviceinfo.utils.proxy;

import com.baidu.searchbox.deviceinfo.ILaunchSpeedDataProvider;
import com.baidu.searchbox.launch.LaunchSpeedDataProvider_Factory;

public class LaunchSpeedDataRuntime {
    public static ILaunchSpeedDataProvider getLaunchSpeedDataProvider() {
        return LaunchSpeedDataProvider_Factory.get();
    }
}
