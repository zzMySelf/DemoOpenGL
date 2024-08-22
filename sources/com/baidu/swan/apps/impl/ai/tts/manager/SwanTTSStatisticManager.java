package com.baidu.swan.apps.impl.ai.tts.manager;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.model.SwanAppPageParam;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.statistic.IStat;
import com.baidu.swan.apps.statistic.StatRouter;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.event.SwanAppUBCBaseEvent;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import org.json.JSONObject;

public class SwanTTSStatisticManager {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String EXT_APP_NAME = "appname";
    private static final String EXT_CAPTURE_STATE = "capturestate";
    private static final String EXT_CAPTURE_TYPE = "capturetype";
    private static final String EXT_DIALOG = "dialog";
    private static final String EXT_HOST_NAME = "hostname";
    private static final String EXT_HOST_VERSION = "hostversion";
    private static final String EXT_INVOKE_FROM = "invokefrom";
    private static final String EXT_IS_MENU_TAP = "ismenutap";
    private static final String EXT_TRIGGER_PERIOD = "triggerperiod";
    private static final String EXT_WEB_URL = "weburl";
    private static final String TAG = "StanTTSStatisticManager";
    public static final String TYPE_COMMON_API = "commonapi";
    public static final String TYPE_CUSTOM_API = "customapi";
    public static final String VALUE_BACK = "back";
    public static final String VALUE_DENIED = "denied";
    public static final String VALUE_DISABLE = "disable";
    public static final String VALUE_FAIL = "fail";
    public static final String VALUE_FRONT = "front";
    public static final String VALUE_SUCCESS = "success";
    private static TTSStatisticEvent sStatisticEvent;

    public static synchronized TTSStatisticEvent requireStatisticEvent() {
        TTSStatisticEvent tTSStatisticEvent;
        synchronized (SwanTTSStatisticManager.class) {
            if (sStatisticEvent == null) {
                sStatisticEvent = new TTSStatisticEvent();
                if (DEBUG) {
                    Log.i(TAG, "requireStatisticEvent-new event.");
                }
            }
            tTSStatisticEvent = sStatisticEvent;
        }
        return tTSStatisticEvent;
    }

    public static synchronized void releaseStatisticEvent() {
        synchronized (SwanTTSStatisticManager.class) {
            sStatisticEvent = null;
        }
    }

    /* access modifiers changed from: private */
    public static void addStatisticCommonParam(SwanAppUBCBaseEvent event) {
        SwanAppLaunchInfo.Impl launchInfo = Swan.get().getApp().getInfo();
        event.mFrom = SwanAppUBCStatistic.getUBCFrom(launchInfo.getAppFrameType());
        event.mAppId = launchInfo.getAppId();
        event.addExt("appname", launchInfo.getAppTitle());
        event.addExt("hostname", SwanAppRuntime.getConfig().getHostName());
        event.addExt(EXT_HOST_VERSION, SwanAppUtils.getVersionName());
    }

    /* access modifiers changed from: private */
    public static void doStatisticOnComputationThread(final SwanAppUBCBaseEvent ubcEvent) {
        SwanAppExecutorUtils.postOnComputation(new Runnable() {
            public void run() {
                JSONObject eventJson = SwanAppUBCBaseEvent.this.toJSONObject();
                if (SwanTTSStatisticManager.DEBUG) {
                    Log.i(SwanTTSStatisticManager.TAG, "requireStatisticEvent-submit:" + eventJson);
                }
                StatRouter.onEvent(IStat.UBC_ID_SWAN_TTS, eventJson);
            }
        }, "SwanTTSStatistic");
    }

    public static class TTSStatisticEvent extends SwanAppUBCBaseEvent {
        private int invokeFrom;
        private boolean isMenuTap;
        private String mCaptureState;
        private String mCaptureType;
        private String mPermissionDialogStatus;
        private long mTriggerStartTime;
        private String mWebUrl;

        private TTSStatisticEvent() {
            this.mTriggerStartTime = System.currentTimeMillis();
        }

        public TTSStatisticEvent resetStatisticStartTime() {
            this.mTriggerStartTime = System.currentTimeMillis();
            return this;
        }

        public TTSStatisticEvent setType(String type) {
            this.mType = type;
            return this;
        }

        public TTSStatisticEvent setValue(String value) {
            this.mValue = value;
            return this;
        }

        public TTSStatisticEvent setIsMenuTap(boolean isMenuTap2) {
            this.isMenuTap = isMenuTap2;
            return this;
        }

        public TTSStatisticEvent setInvokeFrom(int invokeFrom2) {
            this.invokeFrom = invokeFrom2;
            return this;
        }

        public TTSStatisticEvent updateWebUrl(SwanAppPageParam pageParam) {
            PMSAppInfo pmsAppInfo = Swan.get().getApp().getInfo().getPmsAppInfo();
            String path = SwanAppPageParam.buildPageWithParams(pageParam);
            if (pmsAppInfo != null && !TextUtils.isEmpty(path)) {
                this.mWebUrl = pmsAppInfo.webUrl + File.separator + path;
            }
            return this;
        }

        public TTSStatisticEvent setCaptureType(String captureType) {
            this.mCaptureType = captureType;
            return this;
        }

        public TTSStatisticEvent setCaptureState(String captureState) {
            this.mCaptureState = captureState;
            return this;
        }

        public TTSStatisticEvent setPermissionStatus(int permissionStatus) {
            if (permissionStatus == -1) {
                this.mPermissionDialogStatus = String.valueOf(1);
            } else if (permissionStatus == -2) {
                this.mPermissionDialogStatus = String.valueOf(0);
            } else {
                this.mPermissionDialogStatus = null;
            }
            if (permissionStatus != 1) {
                resetStatisticStartTime();
            }
            return this;
        }

        private String getTriggerPeriod() {
            return String.valueOf(System.currentTimeMillis() - this.mTriggerStartTime);
        }

        private void buildStatisticEvent() {
            if (TextUtils.isEmpty(this.mWebUrl)) {
                updateWebUrl(SwanAppUtils.getCurSwanAppPageParam());
            }
            addExt(SwanTTSStatisticManager.EXT_TRIGGER_PERIOD, getTriggerPeriod());
            addExt(SwanTTSStatisticManager.EXT_IS_MENU_TAP, this.isMenuTap ? "1" : "0");
            addExt(SwanTTSStatisticManager.EXT_INVOKE_FROM, Integer.valueOf(this.invokeFrom));
            addExt(SwanTTSStatisticManager.EXT_WEB_URL, this.mWebUrl);
            addExt(SwanTTSStatisticManager.EXT_CAPTURE_TYPE, this.mCaptureType);
            addExt(SwanTTSStatisticManager.EXT_CAPTURE_STATE, this.mCaptureState);
            addExt(SwanTTSStatisticManager.EXT_DIALOG, this.mPermissionDialogStatus);
            SwanTTSStatisticManager.addStatisticCommonParam(this);
        }

        public void submit() {
            SwanTTSStatisticManager.releaseStatisticEvent();
            buildStatisticEvent();
            SwanTTSStatisticManager.doStatisticOnComputationThread(this);
            if (DEBUG) {
                Log.i(SwanTTSStatisticManager.TAG, "TTSStatisticEvent:submit.");
            }
        }
    }
}
