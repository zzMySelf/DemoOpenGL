package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.swan.apps.api.base.ISwanApi;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.module.lockscreen.LockScreenApi;
import com.baidu.swan.apps.api.module.orientation.PageOrientationApi;
import com.baidu.swan.apps.api.module.system.AccelerometerApi;
import com.baidu.swan.apps.api.module.system.BrightnessApi;
import com.baidu.swan.apps.api.module.system.ClipboardApi;
import com.baidu.swan.apps.api.module.system.CompassApi;
import com.baidu.swan.apps.api.module.system.DeviceInfoApi;
import com.baidu.swan.apps.api.module.system.ExitFullScreenApi;
import com.baidu.swan.apps.api.module.system.GetDeviceProfileApi;
import com.baidu.swan.apps.api.module.system.GetThemeModeApi;
import com.baidu.swan.apps.api.module.system.GyroscopeApi;
import com.baidu.swan.apps.api.module.system.HalfScreenToFullScreenApi;
import com.baidu.swan.apps.api.module.system.PhoneCallApi;
import com.baidu.swan.apps.api.module.system.PhoneContactsApi;
import com.baidu.swan.apps.api.module.system.PictureInPictureApi;
import com.baidu.swan.apps.api.module.system.RequestFullScreenApi;
import com.baidu.swan.apps.api.module.system.ScreenRecordEnabledApi;
import com.baidu.swan.apps.api.module.system.ShowSMSPanelApi;
import com.baidu.swan.apps.api.module.system.TouchEventInfoApi;
import com.baidu.swan.apps.api.module.system.VolumeApi;
import com.baidu.swan.apps.api.result.ISwanApiResult;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.api.utils.SwanApiSafeUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.master.isolation.MasterIsolationHelper;
import com.baidu.swan.apps.menu.UpdateMenuStyleApi;
import java.util.concurrent.ConcurrentHashMap;

public class SwanApi$$SystemV8Module {
    private static final boolean DEBUG = false;
    private static final String TAG = "Api-Base";
    private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
    private ISwanApiContext mSwanApiContext;

    public SwanApi$$SystemV8Module(ISwanApiContext mSwanApiContext2) {
        this.mSwanApiContext = mSwanApiContext2;
    }

    @JavascriptInterface
    public String changeScreenOrientation(String $params) {
        PageOrientationApi swanApi;
        try {
            Object obj = this.mApis.get("-449844858");
            if (obj == null || !(obj instanceof PageOrientationApi)) {
                swanApi = new PageOrientationApi(this.mSwanApiContext);
                this.mApis.put("-449844858", swanApi);
            } else {
                swanApi = (PageOrientationApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/changeScreenOrientation");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.changeScreenOrientation")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.changeScreenOrientation($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.changeScreenOrientation[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String checkIsPictureInPictureActive() {
        PictureInPictureApi swanApi;
        try {
            Object obj = this.mApis.get("-1556979089");
            if (obj == null || !(obj instanceof PictureInPictureApi)) {
                swanApi = new PictureInPictureApi(this.mSwanApiContext);
                this.mApis.put("-1556979089", swanApi);
            } else {
                swanApi = (PictureInPictureApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/checkIsPictureInPictureActive");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.checkIsPictureInPictureActive")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.checkIsPictureInPictureActive();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.checkIsPictureInPictureActive[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String checkPhoneContactsAuthorization(String $params) {
        PhoneContactsApi swanApi;
        try {
            Object obj = this.mApis.get("-1112806039");
            if (obj == null || !(obj instanceof PhoneContactsApi)) {
                swanApi = new PhoneContactsApi(this.mSwanApiContext);
                this.mApis.put("-1112806039", swanApi);
            } else {
                swanApi = (PhoneContactsApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, PhoneContactsApi.WHITELIST_NAME);
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.checkPhoneContactsAuthorization")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.checkPhoneContactsAuthorization($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.checkPhoneContactsAuthorization[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String disableUserScreenRecord() {
        ScreenRecordEnabledApi swanApi;
        try {
            Object obj = this.mApis.get("-1603606074");
            if (obj == null || !(obj instanceof ScreenRecordEnabledApi)) {
                swanApi = new ScreenRecordEnabledApi(this.mSwanApiContext);
                this.mApis.put("-1603606074", swanApi);
            } else {
                swanApi = (ScreenRecordEnabledApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/disableUserScreenRecord");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.disableUserScreenRecord")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.disableUserScreenRecord();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.disableUserScreenRecord[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String enableUserScreenRecord() {
        ScreenRecordEnabledApi swanApi;
        try {
            Object obj = this.mApis.get("-1603606074");
            if (obj == null || !(obj instanceof ScreenRecordEnabledApi)) {
                swanApi = new ScreenRecordEnabledApi(this.mSwanApiContext);
                this.mApis.put("-1603606074", swanApi);
            } else {
                swanApi = (ScreenRecordEnabledApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/enableUserScreenRecord");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.enableUserScreenRecord")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.enableUserScreenRecord();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.enableUserScreenRecord[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String exitFullScreen(String $params) {
        ExitFullScreenApi swanApi;
        try {
            Object obj = this.mApis.get("1936205521");
            if (obj == null || !(obj instanceof ExitFullScreenApi)) {
                swanApi = new ExitFullScreenApi(this.mSwanApiContext);
                this.mApis.put("1936205521", swanApi);
            } else {
                swanApi = (ExitFullScreenApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/exitFullScreen");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.exitFullScreen")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.exitFullScreen($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.exitFullScreen[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getBrightness() {
        BrightnessApi swanApi;
        try {
            Object obj = this.mApis.get("99997465");
            if (obj == null || !(obj instanceof BrightnessApi)) {
                swanApi = new BrightnessApi(this.mSwanApiContext);
                this.mApis.put("99997465", swanApi);
            } else {
                swanApi = (BrightnessApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getBrightness");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.getBrightness")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getBrightness();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.getBrightness[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getClipboardData(String $params) {
        ClipboardApi swanApi;
        try {
            Object obj = this.mApis.get("-518757484");
            if (obj == null || !(obj instanceof ClipboardApi)) {
                swanApi = new ClipboardApi(this.mSwanApiContext);
                this.mApis.put("-518757484", swanApi);
            } else {
                swanApi = (ClipboardApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getClipboardData");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.getClipboardData")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getClipboardData($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.getClipboardData[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getDeviceInfo(String $params) {
        DeviceInfoApi swanApi;
        try {
            Object obj = this.mApis.get("1694151270");
            if (obj == null || !(obj instanceof DeviceInfoApi)) {
                swanApi = new DeviceInfoApi(this.mSwanApiContext);
                this.mApis.put("1694151270", swanApi);
            } else {
                swanApi = (DeviceInfoApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getDeviceInfo");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.getDeviceInfo")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getDeviceInfo($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.getDeviceInfo[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getDeviceProfile(String $params) {
        GetDeviceProfileApi swanApi;
        try {
            Object obj = this.mApis.get("-1321681619");
            if (obj == null || !(obj instanceof GetDeviceProfileApi)) {
                swanApi = new GetDeviceProfileApi(this.mSwanApiContext);
                this.mApis.put("-1321681619", swanApi);
            } else {
                swanApi = (GetDeviceProfileApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getDeviceProfile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.getDeviceProfile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getDeviceProfile($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.getDeviceProfile[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getMediaVolume() {
        VolumeApi swanApi;
        try {
            Object obj = this.mApis.get("447234992");
            if (obj == null || !(obj instanceof VolumeApi)) {
                swanApi = new VolumeApi(this.mSwanApiContext);
                this.mApis.put("447234992", swanApi);
            } else {
                swanApi = (VolumeApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getMediaVolume");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.getMediaVolume")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getMediaVolume();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.getMediaVolume[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getThemeMode() {
        GetThemeModeApi swanApi;
        try {
            Object obj = this.mApis.get("-1834369804");
            if (obj == null || !(obj instanceof GetThemeModeApi)) {
                swanApi = new GetThemeModeApi(this.mSwanApiContext);
                this.mApis.put("-1834369804", swanApi);
            } else {
                swanApi = (GetThemeModeApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getThemeMode");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.getThemeMode")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.getThemeMode();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.getThemeMode[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String isScreenLockedSync() {
        LockScreenApi swanApi;
        try {
            Object obj = this.mApis.get("927184347");
            if (obj == null || !(obj instanceof LockScreenApi)) {
                swanApi = new LockScreenApi(this.mSwanApiContext);
                this.mApis.put("927184347", swanApi);
            } else {
                swanApi = (LockScreenApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/isScreenLockedSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.isScreenLockedSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.isScreenLockedSync();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.isScreenLockedSync[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String lockScreenOrientation(String $params) {
        PageOrientationApi swanApi;
        try {
            Object obj = this.mApis.get("-449844858");
            if (obj == null || !(obj instanceof PageOrientationApi)) {
                swanApi = new PageOrientationApi(this.mSwanApiContext);
                this.mApis.put("-449844858", swanApi);
            } else {
                swanApi = (PageOrientationApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/lockScreenOrientation");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.lockScreenOrientation")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.lockScreenOrientation($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.lockScreenOrientation[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String makePhoneCall(String $params) {
        PhoneCallApi swanApi;
        try {
            Object obj = this.mApis.get("-1569246082");
            if (obj == null || !(obj instanceof PhoneCallApi)) {
                swanApi = new PhoneCallApi(this.mSwanApiContext);
                this.mApis.put("-1569246082", swanApi);
            } else {
                swanApi = (PhoneCallApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/makePhoneCall");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.makePhoneCall")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.makePhoneCall($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.makePhoneCall[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String openSMSPanel(String $params) {
        ShowSMSPanelApi swanApi;
        try {
            Object obj = this.mApis.get("1099851202");
            if (obj == null || !(obj instanceof ShowSMSPanelApi)) {
                swanApi = new ShowSMSPanelApi(this.mSwanApiContext);
                this.mApis.put("1099851202", swanApi);
            } else {
                swanApi = (ShowSMSPanelApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/openSMSPanel");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.openSMSPanel")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.openSystemSMSPanel($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.openSMSPanel[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String pictureInPicture(String $params) {
        PictureInPictureApi swanApi;
        try {
            Object obj = this.mApis.get("-1556979089");
            if (obj == null || !(obj instanceof PictureInPictureApi)) {
                swanApi = new PictureInPictureApi(this.mSwanApiContext);
                this.mApis.put("-1556979089", swanApi);
            } else {
                swanApi = (PictureInPictureApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/live/pictureInPicture");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.pictureInPicture")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.livePlayerPictureInPicture($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.pictureInPicture[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String pictureInPictureForVideo(String $params) {
        PictureInPictureApi swanApi;
        try {
            Object obj = this.mApis.get("-1556979089");
            if (obj == null || !(obj instanceof PictureInPictureApi)) {
                swanApi = new PictureInPictureApi(this.mSwanApiContext);
                this.mApis.put("-1556979089", swanApi);
            } else {
                swanApi = (PictureInPictureApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/video/pictureInPicture");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.pictureInPictureForVideo")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.videoPictureInPicture($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.pictureInPictureForVideo[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String requestFullScreen(String $params) {
        RequestFullScreenApi swanApi;
        try {
            Object obj = this.mApis.get("-1707203360");
            if (obj == null || !(obj instanceof RequestFullScreenApi)) {
                swanApi = new RequestFullScreenApi(this.mSwanApiContext);
                this.mApis.put("-1707203360", swanApi);
            } else {
                swanApi = (RequestFullScreenApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/requestFullScreen");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.requestFullScreen")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.setFullScreen($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.requestFullScreen[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String setClipboardData(String $params) {
        ClipboardApi swanApi;
        try {
            Object obj = this.mApis.get("-518757484");
            if (obj == null || !(obj instanceof ClipboardApi)) {
                swanApi = new ClipboardApi(this.mSwanApiContext);
                this.mApis.put("-518757484", swanApi);
            } else {
                swanApi = (ClipboardApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/setClipboardData");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.setClipboardData")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.setClipboardData($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.setClipboardData[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String setErrorPageType(String $params) {
        UpdateMenuStyleApi swanApi;
        try {
            Object obj = this.mApis.get("1161486049");
            if (obj == null || !(obj instanceof UpdateMenuStyleApi)) {
                swanApi = new UpdateMenuStyleApi(this.mSwanApiContext);
                this.mApis.put("1161486049", swanApi);
            } else {
                swanApi = (UpdateMenuStyleApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/setErrorPageType");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.setErrorPageType")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.changeMenuStyle($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.setErrorPageType[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String setMediaVolume(String $params) {
        VolumeApi swanApi;
        try {
            Object obj = this.mApis.get("447234992");
            if (obj == null || !(obj instanceof VolumeApi)) {
                swanApi = new VolumeApi(this.mSwanApiContext);
                this.mApis.put("447234992", swanApi);
            } else {
                swanApi = (VolumeApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/setMediaVolume");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.setMediaVolume")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.setMediaVolume($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.setMediaVolume[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String startAccelerometer(String $params) {
        AccelerometerApi swanApi;
        try {
            Object obj = this.mApis.get("1372680763");
            if (obj == null || !(obj instanceof AccelerometerApi)) {
                swanApi = new AccelerometerApi(this.mSwanApiContext);
                this.mApis.put("1372680763", swanApi);
            } else {
                swanApi = (AccelerometerApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/startAccelerometer");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.startAccelerometer")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.startAccelerometer($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.startAccelerometer[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String startCompass(String $params) {
        CompassApi swanApi;
        try {
            Object obj = this.mApis.get("1689255576");
            if (obj == null || !(obj instanceof CompassApi)) {
                swanApi = new CompassApi(this.mSwanApiContext);
                this.mApis.put("1689255576", swanApi);
            } else {
                swanApi = (CompassApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/startCompass");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.startCompass")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.startCompass($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.startCompass[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String startGyroscope(String $params) {
        GyroscopeApi swanApi;
        try {
            Object obj = this.mApis.get("347728325");
            if (obj == null || !(obj instanceof GyroscopeApi)) {
                swanApi = new GyroscopeApi(this.mSwanApiContext);
                this.mApis.put("347728325", swanApi);
            } else {
                swanApi = (GyroscopeApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/startGyroscope");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.startGyroscope")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.startGyroscope($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.startGyroscope[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String startTouchEventListener() {
        TouchEventInfoApi swanApi;
        try {
            Object obj = this.mApis.get("-192606591");
            if (obj == null || !(obj instanceof TouchEventInfoApi)) {
                swanApi = new TouchEventInfoApi(this.mSwanApiContext);
                this.mApis.put("-192606591", swanApi);
            } else {
                swanApi = (TouchEventInfoApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/startTouchEventListener");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.startTouchEventListener")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.startTouchEventListener();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.startTouchEventListener[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String stopAccelerometer() {
        AccelerometerApi swanApi;
        try {
            Object obj = this.mApis.get("1372680763");
            if (obj == null || !(obj instanceof AccelerometerApi)) {
                swanApi = new AccelerometerApi(this.mSwanApiContext);
                this.mApis.put("1372680763", swanApi);
            } else {
                swanApi = (AccelerometerApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/stopAccelerometer");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.stopAccelerometer")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.stopAccelerometer();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.stopAccelerometer[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String stopCompass(String $params) {
        CompassApi swanApi;
        try {
            Object obj = this.mApis.get("1689255576");
            if (obj == null || !(obj instanceof CompassApi)) {
                swanApi = new CompassApi(this.mSwanApiContext);
                this.mApis.put("1689255576", swanApi);
            } else {
                swanApi = (CompassApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/stopCompass");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.stopCompass")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.stopCompass($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.stopCompass[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String stopCompass() {
        CompassApi swanApi;
        try {
            Object obj = this.mApis.get("1689255576");
            if (obj == null || !(obj instanceof CompassApi)) {
                swanApi = new CompassApi(this.mSwanApiContext);
                this.mApis.put("1689255576", swanApi);
            } else {
                swanApi = (CompassApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/stopCompass");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.stopCompass")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.stopCompass();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.stopCompass[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String stopGyroscope() {
        GyroscopeApi swanApi;
        try {
            Object obj = this.mApis.get("347728325");
            if (obj == null || !(obj instanceof GyroscopeApi)) {
                swanApi = new GyroscopeApi(this.mSwanApiContext);
                this.mApis.put("347728325", swanApi);
            } else {
                swanApi = (GyroscopeApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/stopGyroscope");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.stopGyroscope")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.stopGyroscope();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.stopGyroscope[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String stopTouchEventListener() {
        TouchEventInfoApi swanApi;
        try {
            Object obj = this.mApis.get("-192606591");
            if (obj == null || !(obj instanceof TouchEventInfoApi)) {
                swanApi = new TouchEventInfoApi(this.mSwanApiContext);
                this.mApis.put("-192606591", swanApi);
            } else {
                swanApi = (TouchEventInfoApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/stopTouchEventListener");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.stopTouchEventListener")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.stopTouchEventListener();
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.stopTouchEventListener[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String switchEmbeddedSmartProgram(String $params) {
        HalfScreenToFullScreenApi swanApi;
        try {
            Object obj = this.mApis.get("-736661483");
            if (obj == null || !(obj instanceof HalfScreenToFullScreenApi)) {
                swanApi = new HalfScreenToFullScreenApi(this.mSwanApiContext);
                this.mApis.put("-736661483", swanApi);
            } else {
                swanApi = (HalfScreenToFullScreenApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/switchEmbeddedSmartProgram");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.switchEmbeddedSmartProgram")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.switchEmbeddedSmartProgram($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.switchEmbeddedSmartProgram[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String unlockScreen(String $params) {
        LockScreenApi swanApi;
        try {
            Object obj = this.mApis.get("927184347");
            if (obj == null || !(obj instanceof LockScreenApi)) {
                swanApi = new LockScreenApi(this.mSwanApiContext);
                this.mApis.put("927184347", swanApi);
            } else {
                swanApi = (LockScreenApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/unlockScreen");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.unlockScreen")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.unlockScreen($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.unlockScreen[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String unlockScreenOrientation(String $params) {
        PageOrientationApi swanApi;
        try {
            Object obj = this.mApis.get("-449844858");
            if (obj == null || !(obj instanceof PageOrientationApi)) {
                swanApi = new PageOrientationApi(this.mSwanApiContext);
                this.mApis.put("-449844858", swanApi);
            } else {
                swanApi = (PageOrientationApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/unlockScreenOrientation");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "System.unlockScreenOrientation")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.unlockScreenOrientation($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[System.unlockScreenOrientation[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }
}
