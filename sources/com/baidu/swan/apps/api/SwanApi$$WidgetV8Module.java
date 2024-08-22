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
import com.baidu.swan.apps.impl.widget.CustomWidgetApi;
import com.baidu.swan.apps.impl.widget.WidgetApi;
import java.util.concurrent.ConcurrentHashMap;

public class SwanApi$$WidgetV8Module {
    private static final boolean DEBUG = false;
    private static final String TAG = "Api-Base";
    private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
    private ISwanApiContext mSwanApiContext;

    public SwanApi$$WidgetV8Module(ISwanApiContext mSwanApiContext2) {
        this.mSwanApiContext = mSwanApiContext2;
    }

    @JavascriptInterface
    public String addCustomWidget(String $params) {
        CustomWidgetApi swanApi;
        try {
            Object obj = this.mApis.get("-1810954934");
            if (obj == null || !(obj instanceof CustomWidgetApi)) {
                swanApi = new CustomWidgetApi(this.mSwanApiContext);
                this.mApis.put("-1810954934", swanApi);
            } else {
                swanApi = (CustomWidgetApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/addCustomWidget");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Widget.addCustomWidget")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.addCustomWidget($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Widget.addCustomWidget[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String addWidget(String $params) {
        WidgetApi swanApi;
        try {
            Object obj = this.mApis.get("542124411");
            if (obj == null || !(obj instanceof WidgetApi)) {
                swanApi = new WidgetApi(this.mSwanApiContext);
                this.mApis.put("542124411", swanApi);
            } else {
                swanApi = (WidgetApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/addWidget");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Widget.addWidget")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.addWidget($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Widget.addWidget[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String checkWidgetState(String $params) {
        WidgetApi swanApi;
        try {
            Object obj = this.mApis.get("542124411");
            if (obj == null || !(obj instanceof WidgetApi)) {
                swanApi = new WidgetApi(this.mSwanApiContext);
                this.mApis.put("542124411", swanApi);
            } else {
                swanApi = (WidgetApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/checkWidgetState");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Widget.checkWidgetState")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.checkWidgetState($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Widget.checkWidgetState[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String updateCustomWidgetConfig(String $params) {
        CustomWidgetApi swanApi;
        try {
            Object obj = this.mApis.get("-1810954934");
            if (obj == null || !(obj instanceof CustomWidgetApi)) {
                swanApi = new CustomWidgetApi(this.mSwanApiContext);
                this.mApis.put("-1810954934", swanApi);
            } else {
                swanApi = (CustomWidgetApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/updateCustomWidgetConfig");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Widget.updateCustomWidgetConfig")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.updateCustomWidgetConfig($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Widget.updateCustomWidgetConfig[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }
}
