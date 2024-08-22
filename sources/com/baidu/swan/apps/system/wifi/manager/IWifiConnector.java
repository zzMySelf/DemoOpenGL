package com.baidu.swan.apps.system.wifi.manager;

import com.baidu.swan.apps.system.wifi.model.SwanWifiAccessData;
import com.baidu.swan.apps.system.wifi.model.WifiAccessPoint;
import com.baidu.swan.apps.system.wifi.model.WifiCallbackResult;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

public interface IWifiConnector {
    void connectWifi(SwanWifiAccessData swanWifiAccessData, TypedCallback<WifiCallbackResult<WifiAccessPoint>> typedCallback);
}
