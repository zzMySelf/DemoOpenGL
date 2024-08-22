package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.api.base.ISwanApi;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.result.ISwanApiResult;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.api.utils.SwanApiSafeUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.master.isolation.MasterIsolationHelper;
import com.baidu.swan.apps.system.wifi.WifiApi;
import java.util.concurrent.ConcurrentHashMap;

public class SwanApi$$WifiV8Module {
    private static final boolean DEBUG = false;
    private static final String TAG = "Api-Base";
    private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
    private ISwanApiContext mSwanApiContext;

    public SwanApi$$WifiV8Module(ISwanApiContext mSwanApiContext2) {
        this.mSwanApiContext = mSwanApiContext2;
    }

    @JavascriptInterface
    public String connectWifi(String $params) {
        WifiApi swanApi;
        try {
            Object obj = this.mApis.get("1879401452");
            if (obj == null || !(obj instanceof WifiApi)) {
                swanApi = new WifiApi(this.mSwanApiContext);
                this.mApis.put("1879401452", swanApi);
            } else {
                swanApi = (WifiApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/connectWifi");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Wifi.connectWifi")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.connectWifi($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Wifi.connectWifi[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getConnectedWifi(String $params) {
        WifiApi swanApi;
        try {
            Object obj = this.mApis.get("1879401452");
            if (obj == null || !(obj instanceof WifiApi)) {
                swanApi = new WifiApi(this.mSwanApiContext);
                this.mApis.put("1879401452", swanApi);
            } else {
                swanApi = (WifiApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getConnectedWifi");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Wifi.getConnectedWifi")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getConnectedWifi($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Wifi.getConnectedWifi[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getWifiList(String $params) {
        WifiApi swanApi;
        try {
            Object obj = this.mApis.get("1879401452");
            if (obj == null || !(obj instanceof WifiApi)) {
                swanApi = new WifiApi(this.mSwanApiContext);
                this.mApis.put("1879401452", swanApi);
            } else {
                swanApi = (WifiApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getWifiList");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Wifi.getWifiList")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getWifiList($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Wifi.getWifiList[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String startWifi(String $params) {
        WifiApi swanApi;
        try {
            Object obj = this.mApis.get("1879401452");
            if (obj == null || !(obj instanceof WifiApi)) {
                swanApi = new WifiApi(this.mSwanApiContext);
                this.mApis.put("1879401452", swanApi);
            } else {
                swanApi = (WifiApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/startWifi");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Wifi.startWifi")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.startWifi($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Wifi.startWifi[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String stopWifi(String $params) {
        WifiApi swanApi;
        try {
            Object obj = this.mApis.get("1879401452");
            if (obj == null || !(obj instanceof WifiApi)) {
                swanApi = new WifiApi(this.mSwanApiContext);
                this.mApis.put("1879401452", swanApi);
            } else {
                swanApi = (WifiApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/stopWifi");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Wifi.stopWifi")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.stopWifi($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Wifi.stopWifi[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }
}
