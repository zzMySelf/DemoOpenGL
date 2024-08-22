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
import com.baidu.swan.apps.impl.menu.favorite.SwanAppAddFavorPageApi;
import com.baidu.swan.apps.impl.menu.favorite.SwanAppCheckFavorPageApi;
import com.baidu.swan.apps.impl.menu.favorite.SwanAppDeleteFavorPageApi;
import java.util.concurrent.ConcurrentHashMap;

public class SwanApi$$FavorV8Module {
    private static final boolean DEBUG = false;
    private static final String TAG = "Api-Base";
    private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
    private ISwanApiContext mSwanApiContext;

    public SwanApi$$FavorV8Module(ISwanApiContext mSwanApiContext2) {
        this.mSwanApiContext = mSwanApiContext2;
    }

    @JavascriptInterface
    public String addPageFavor(String $params) {
        SwanAppAddFavorPageApi swanApi;
        try {
            Object obj = this.mApis.get("321692016");
            if (obj == null || !(obj instanceof SwanAppAddFavorPageApi)) {
                swanApi = new SwanAppAddFavorPageApi(this.mSwanApiContext);
                this.mApis.put("321692016", swanApi);
            } else {
                swanApi = (SwanAppAddFavorPageApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/addPageFavor");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Favor.addPageFavor")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.addPageFavor($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Favor.addPageFavor[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String checkPageFavor(String $params) {
        SwanAppCheckFavorPageApi swanApi;
        try {
            Object obj = this.mApis.get("-1285528873");
            if (obj == null || !(obj instanceof SwanAppCheckFavorPageApi)) {
                swanApi = new SwanAppCheckFavorPageApi(this.mSwanApiContext);
                this.mApis.put("-1285528873", swanApi);
            } else {
                swanApi = (SwanAppCheckFavorPageApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/checkPageFavor");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Favor.checkPageFavor")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.checkPageFavor($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Favor.checkPageFavor[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String deletePageFavor(String $params) {
        SwanAppDeleteFavorPageApi swanApi;
        try {
            Object obj = this.mApis.get("1709213110");
            if (obj == null || !(obj instanceof SwanAppDeleteFavorPageApi)) {
                swanApi = new SwanAppDeleteFavorPageApi(this.mSwanApiContext);
                this.mApis.put("1709213110", swanApi);
            } else {
                swanApi = (SwanAppDeleteFavorPageApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/deletePageFavor");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Favor.deletePageFavor")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.deletePageFavor($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Favor.deletePageFavor[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }
}
