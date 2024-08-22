package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.api.base.ISwanApi;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.module.utils.CalcMD5Api;
import com.baidu.swan.apps.api.module.utils.CheckAppInstallApi;
import com.baidu.swan.apps.api.module.utils.CloseAppApi;
import com.baidu.swan.apps.api.module.utils.CommonSysInfoApi;
import com.baidu.swan.apps.api.module.utils.DesktopShortcutApi;
import com.baidu.swan.apps.api.module.utils.GetAbilityDegradeTipsApi;
import com.baidu.swan.apps.api.module.utils.GetPerformanceLevelApi;
import com.baidu.swan.apps.api.module.utils.HandleExceptionApi;
import com.baidu.swan.apps.api.module.utils.LogApi;
import com.baidu.swan.apps.api.module.utils.PageBackModalApi;
import com.baidu.swan.apps.api.module.utils.PreviewImageApi;
import com.baidu.swan.apps.api.module.utils.SystemInfoApi;
import com.baidu.swan.apps.api.module.utils.UbcFlowJarApi;
import com.baidu.swan.apps.api.result.ISwanApiResult;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.api.utils.SwanApiSafeUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.master.isolation.MasterIsolationHelper;
import com.baidu.swan.apps.map.model.SwanBuiltinApi;
import com.baidu.swan.apps.scheme.actions.prefetch.PreloadPackageApi;
import com.baidu.swan.apps.screenshot.HideCaptureScreenShareDialogApi;
import com.baidu.swan.apps.screenshot.capturelongscreen.CaptureLongScreenApi;
import java.util.concurrent.ConcurrentHashMap;

public class SwanApi$$UtilsWebviewModule {
    private static final boolean DEBUG = false;
    private static final String TAG = "Api-Base";
    private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
    private ISwanApiContext mSwanApiContext;

    public SwanApi$$UtilsWebviewModule(ISwanApiContext mSwanApiContext2) {
        this.mSwanApiContext = mSwanApiContext2;
    }

    @JavascriptInterface
    public String addToDesktop(String $params) {
        DesktopShortcutApi swanApi;
        try {
            Object obj = this.mApis.get("201194468");
            if (obj == null || !(obj instanceof DesktopShortcutApi)) {
                swanApi = new DesktopShortcutApi(this.mSwanApiContext);
                this.mApis.put("201194468", swanApi);
            } else {
                swanApi = (DesktopShortcutApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/addToDesktop");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.addToDesktop")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.addToDesktop($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.addToDesktop[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String calcMD5(String $params) {
        CalcMD5Api swanApi;
        try {
            Object obj = this.mApis.get("-1412306947");
            if (obj == null || !(obj instanceof CalcMD5Api)) {
                swanApi = new CalcMD5Api(this.mSwanApiContext);
                this.mApis.put("-1412306947", swanApi);
            } else {
                swanApi = (CalcMD5Api) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/calcMD5");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.calcMD5")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.calcMD5($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.calcMD5[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String captureLongScreenshot(String $params) {
        CaptureLongScreenApi swanApi;
        try {
            Object obj = this.mApis.get("-2054995659");
            if (obj == null || !(obj instanceof CaptureLongScreenApi)) {
                swanApi = new CaptureLongScreenApi(this.mSwanApiContext);
                this.mApis.put("-2054995659", swanApi);
            } else {
                swanApi = (CaptureLongScreenApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/captureLongScreenshot");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.captureLongScreenshot")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.captureLongScreen($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.captureLongScreenshot[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String checkAppInstalled(String $params) {
        CheckAppInstallApi swanApi;
        try {
            Object obj = this.mApis.get("1626415364");
            if (obj == null || !(obj instanceof CheckAppInstallApi)) {
                swanApi = new CheckAppInstallApi(this.mSwanApiContext);
                this.mApis.put("1626415364", swanApi);
            } else {
                swanApi = (CheckAppInstallApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/checkAppInstalled");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.checkAppInstalled")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.checkAppInstalled($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.checkAppInstalled[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String closeBuiltinPage() {
        SwanBuiltinApi swanApi;
        try {
            Object obj = this.mApis.get("-195108578");
            if (obj == null || !(obj instanceof SwanBuiltinApi)) {
                swanApi = new SwanBuiltinApi(this.mSwanApiContext);
                this.mApis.put("-195108578", swanApi);
            } else {
                swanApi = (SwanBuiltinApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/closeBuiltinPage");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.closeBuiltinPage")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.closeBuiltinPage();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.closeBuiltinPage[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String disablePageBackModal(String $params) {
        PageBackModalApi swanApi;
        try {
            Object obj = this.mApis.get("900146959");
            if (obj == null || !(obj instanceof PageBackModalApi)) {
                swanApi = new PageBackModalApi(this.mSwanApiContext);
                this.mApis.put("900146959", swanApi);
            } else {
                swanApi = (PageBackModalApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/disablePageBackModal");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.disablePageBackModal")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.disablePageBackModal($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.disablePageBackModal[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String enablePageBackModal(String $params) {
        PageBackModalApi swanApi;
        try {
            Object obj = this.mApis.get("900146959");
            if (obj == null || !(obj instanceof PageBackModalApi)) {
                swanApi = new PageBackModalApi(this.mSwanApiContext);
                this.mApis.put("900146959", swanApi);
            } else {
                swanApi = (PageBackModalApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/enablePageBackModal");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.enablePageBackModal")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.enablePageBackModal($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.enablePageBackModal[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getAbilityDegradeTips() {
        GetAbilityDegradeTipsApi swanApi;
        try {
            Object obj = this.mApis.get("1403299244");
            if (obj == null || !(obj instanceof GetAbilityDegradeTipsApi)) {
                swanApi = new GetAbilityDegradeTipsApi(this.mSwanApiContext);
                this.mApis.put("1403299244", swanApi);
            } else {
                swanApi = (GetAbilityDegradeTipsApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getAbilityDegradeTips");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.getAbilityDegradeTips")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getAbilityDegradeTipsApi();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.getAbilityDegradeTips[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getCommonSysInfo(String $params) {
        CommonSysInfoApi swanApi;
        try {
            Object obj = this.mApis.get("-836768778");
            if (obj == null || !(obj instanceof CommonSysInfoApi)) {
                swanApi = new CommonSysInfoApi(this.mSwanApiContext);
                this.mApis.put("-836768778", swanApi);
            } else {
                swanApi = (CommonSysInfoApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getCommonSysInfo");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.getCommonSysInfo")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getCommonSysInfo($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.getCommonSysInfo[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getCommonSysInfoSync() {
        SystemInfoApi swanApi;
        try {
            Object obj = this.mApis.get("-1011537871");
            if (obj == null || !(obj instanceof SystemInfoApi)) {
                swanApi = new SystemInfoApi(this.mSwanApiContext);
                this.mApis.put("-1011537871", swanApi);
            } else {
                swanApi = (SystemInfoApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getCommonSysInfoSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.getCommonSysInfoSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getCommonSysInfoSync();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.getCommonSysInfoSync[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getPerformanceLevel(String $params) {
        GetPerformanceLevelApi swanApi;
        try {
            Object obj = this.mApis.get("-810858308");
            if (obj == null || !(obj instanceof GetPerformanceLevelApi)) {
                swanApi = new GetPerformanceLevelApi(this.mSwanApiContext);
                this.mApis.put("-810858308", swanApi);
            } else {
                swanApi = (GetPerformanceLevelApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getPerformanceLevel");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.getPerformanceLevel")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getPerformanceLevel($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.getPerformanceLevel[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getSystemInfo() {
        SystemInfoApi swanApi;
        try {
            Object obj = this.mApis.get("-1011537871");
            if (obj == null || !(obj instanceof SystemInfoApi)) {
                swanApi = new SystemInfoApi(this.mSwanApiContext);
                this.mApis.put("-1011537871", swanApi);
            } else {
                swanApi = (SystemInfoApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getSystemInfo");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.getSystemInfo")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getSystemInfo();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.getSystemInfo[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getSystemInfoAsync(String $params) {
        SystemInfoApi swanApi;
        try {
            Object obj = this.mApis.get("-1011537871");
            if (obj == null || !(obj instanceof SystemInfoApi)) {
                swanApi = new SystemInfoApi(this.mSwanApiContext);
                this.mApis.put("-1011537871", swanApi);
            } else {
                swanApi = (SystemInfoApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getSystemInfoAsync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.getSystemInfoAsync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getSystemInfoAsync($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.getSystemInfoAsync[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getSystemInfoSync() {
        SystemInfoApi swanApi;
        try {
            Object obj = this.mApis.get("-1011537871");
            if (obj == null || !(obj instanceof SystemInfoApi)) {
                swanApi = new SystemInfoApi(this.mSwanApiContext);
                this.mApis.put("-1011537871", swanApi);
            } else {
                swanApi = (SystemInfoApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getSystemInfoSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.getSystemInfoSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getSystemInfoSync();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.getSystemInfoSync[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String handleException(String $params) {
        HandleExceptionApi swanApi;
        try {
            Object obj = this.mApis.get("-2097727681");
            if (obj == null || !(obj instanceof HandleExceptionApi)) {
                swanApi = new HandleExceptionApi(this.mSwanApiContext);
                this.mApis.put("-2097727681", swanApi);
            } else {
                swanApi = (HandleExceptionApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/handleException");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.handleException")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.handleException($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.handleException[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String hasCloseHandler(String $params) {
        CloseAppApi swanApi;
        try {
            Object obj = this.mApis.get("2084449317");
            if (obj == null || !(obj instanceof CloseAppApi)) {
                swanApi = new CloseAppApi(this.mSwanApiContext);
                this.mApis.put("2084449317", swanApi);
            } else {
                swanApi = (CloseAppApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/hasCloseHandler");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.hasCloseHandler")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.hasCloseHandler($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.hasCloseHandler[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String hideCaptureScreenShareDialog(String $params) {
        HideCaptureScreenShareDialogApi swanApi;
        try {
            Object obj = this.mApis.get("1031678042");
            if (obj == null || !(obj instanceof HideCaptureScreenShareDialogApi)) {
                swanApi = new HideCaptureScreenShareDialogApi(this.mSwanApiContext);
                this.mApis.put("1031678042", swanApi);
            } else {
                swanApi = (HideCaptureScreenShareDialogApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/hideCaptureScreenShareDialog");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.hideCaptureScreenShareDialog")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.hideCaptureScreenShareDialog($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.hideCaptureScreenShareDialog[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String logToFile(String $params) {
        LogApi swanApi;
        try {
            Object obj = this.mApis.get("1751900130");
            if (obj == null || !(obj instanceof LogApi)) {
                swanApi = new LogApi(this.mSwanApiContext);
                this.mApis.put("1751900130", swanApi);
            } else {
                swanApi = (LogApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/logToFile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.logToFile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.logToFile($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.logToFile[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String openBuiltinPage(String $params) {
        SwanBuiltinApi swanApi;
        try {
            Object obj = this.mApis.get("-195108578");
            if (obj == null || !(obj instanceof SwanBuiltinApi)) {
                swanApi = new SwanBuiltinApi(this.mSwanApiContext);
                this.mApis.put("-195108578", swanApi);
            } else {
                swanApi = (SwanBuiltinApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/openBuiltinPage");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.openBuiltinPage")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.openBuiltinPage($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.openBuiltinPage[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String preloadPackage(String $params) {
        PreloadPackageApi swanApi;
        try {
            Object obj = this.mApis.get("1748196865");
            if (obj == null || !(obj instanceof PreloadPackageApi)) {
                swanApi = new PreloadPackageApi(this.mSwanApiContext);
                this.mApis.put("1748196865", swanApi);
            } else {
                swanApi = (PreloadPackageApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/preloadPackage");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.preloadPackage")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.preloadPackage($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.preloadPackage[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String previewImage(String $params) {
        PreviewImageApi swanApi;
        try {
            Object obj = this.mApis.get("589529211");
            if (obj == null || !(obj instanceof PreviewImageApi)) {
                swanApi = new PreviewImageApi(this.mSwanApiContext);
                this.mApis.put("589529211", swanApi);
            } else {
                swanApi = (PreviewImageApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/previewImage");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.previewImage")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.handlePreviewImage($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.previewImage[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String ubcFlowJar(String $params) {
        UbcFlowJarApi swanApi;
        try {
            Object obj = this.mApis.get("-577481801");
            if (obj == null || !(obj instanceof UbcFlowJarApi)) {
                swanApi = new UbcFlowJarApi(this.mSwanApiContext);
                this.mApis.put("-577481801", swanApi);
            } else {
                swanApi = (UbcFlowJarApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/ubcFlowJar");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "Utils.ubcFlowJar")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.ubcFlowJar($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[Utils.ubcFlowJar[type:Webview, v8 binding:false] with exception]]", t);
            throw t;
        }
    }
}
