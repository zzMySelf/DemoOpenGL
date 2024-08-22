package com.baidu.swan.apps.console.debugger.remotedebug;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.AppProcessManager;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.framework.ISwanFrameContainer;
import com.baidu.swan.apps.launch.model.SwanAppLaunchParams;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.StatFlow;
import com.baidu.swan.apps.statistic.StatRouter;
import com.baidu.swan.apps.statistic.SwanAppStatsUtils;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.event.SwanAppUBCEvent;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class RemoteDebugStatistic {
    private static final String APP_ID = "appid";
    public static final String APP_READY = "appready";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    static final String DOWNLOAD_FAIL = "downloadfail";
    static final String DOWNLOAD_START = "downloadstart";
    private static final String EVENT_NAME = "actionId";
    private static final String EXT = "ext";
    private static final String FROM = "from";
    private static final String FROM_SWAN = "swan";
    public static final String LOAD_MASTER = "loadmaster";
    public static final String PAGE_READY = "pageready";
    private static final String REMOTE = "remote-debug";
    private static final String TAG = "RemoteDebugStatistic";
    private static final String TIMESTAMP = "timestamp";
    private static final long TIME_OUT = 40000;
    public static final String UNZIP_END = "unzipend";
    public static final String UNZIP_START = "unzipstart";
    static final String ZIP_DOWNLOADED = "downloadsuccess";
    static StatFlow sFlow;
    private static volatile RemoteDebugStatistic sHandler;
    /* access modifiers changed from: private */
    public static boolean sIsFromNewIntent;
    private static Timer sTime;

    public abstract void handleEvent(String str);

    private RemoteDebugStatistic() {
    }

    public static RemoteDebugStatistic getInstance() {
        if (sHandler == null) {
            synchronized (SwanAppController.class) {
                if (sHandler == null) {
                    if (AppProcessManager.isServerProcess()) {
                        sHandler = new MainProcessHandler();
                    } else {
                        sHandler = new SwanProcessHandler();
                    }
                }
            }
        }
        return sHandler;
    }

    public void setFromNewIntent() {
        sIsFromNewIntent = true;
    }

    /* access modifiers changed from: package-private */
    public String getEventValue() {
        JSONObject event = new JSONObject();
        try {
            event.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.d(TAG, "add event content fail", e2);
            }
        }
        return event.toString();
    }

    /* access modifiers changed from: package-private */
    public void startFlow(boolean hasDownload) {
        if (sFlow == null) {
            StatFlow createFlow = SwanAppUBCStatistic.createFlow("1153");
            sFlow = createFlow;
            if (!hasDownload) {
                StatRouter.flowAddEvent(createFlow, DOWNLOAD_START, getEventValue());
                StatRouter.flowAddEvent(sFlow, ZIP_DOWNLOADED, getEventValue());
            }
            Timer timer = new Timer();
            sTime = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    if (RemoteDebugStatistic.DEBUG) {
                        Log.d(RemoteDebugStatistic.TAG, "timer: send remote debug ubc flow");
                    }
                    RemoteDebugStatistic.this.endFlow();
                    RemoteDebugStatistic.this.release();
                }
            }, TIME_OUT);
        }
    }

    /* access modifiers changed from: protected */
    public void endFlow() {
        if (sFlow != null) {
            JSONObject value = new JSONObject();
            JSONObject ext = new JSONObject();
            try {
                SwanApp app = SwanApp.getOrNull();
                ext.putOpt("appid", app == null ? "" : app.getAppKey());
                ext.putOpt("from", "remote-debug");
                SwanAppStatsUtils.addUbcStatisticCommonParams(ext);
                value.putOpt("from", "swan");
                value.putOpt("ext", ext);
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.d(TAG, "page ready statistic value is invalid ");
                }
            }
            StatRouter.flowSetValueWithDuration(sFlow, value.toString());
            StatRouter.endFlow(sFlow);
        }
    }

    /* access modifiers changed from: package-private */
    public void release() {
        Timer timer = sTime;
        if (timer != null) {
            timer.cancel();
            sTime = null;
        }
        sHandler = null;
        sFlow = null;
    }

    public static void handleSwanCoreEvent(JSONArray array) {
        if (array != null && array.length() > 0) {
            String eventName = "";
            JSONObject jsonObject = array.optJSONObject(0);
            if (jsonObject != null) {
                eventName = jsonObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(eventName) && sHandler != null) {
                sHandler.handleEvent(eventName);
            }
        }
    }

    private static class MainProcessHandler extends RemoteDebugStatistic {
        private MainProcessHandler() {
            super();
        }

        public void handleEvent(String eventName) {
            if (!TextUtils.isEmpty(eventName)) {
                if (RemoteDebugStatistic.DEBUG) {
                    Log.d(RemoteDebugStatistic.TAG, "remote-debug statistic event name is : " + eventName);
                }
                char c2 = 65535;
                switch (eventName.hashCode()) {
                    case 50335962:
                        if (eventName.equals(RemoteDebugStatistic.DOWNLOAD_START)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1109597094:
                        if (eventName.equals(RemoteDebugStatistic.DOWNLOAD_FAIL)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 1158237819:
                        if (eventName.equals(RemoteDebugStatistic.ZIP_DOWNLOADED)) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        startFlow(true);
                        StatRouter.flowAddEvent(sFlow, eventName, getEventValue());
                        return;
                    case 1:
                        if (sFlow != null) {
                            StatRouter.cancelFlow(sFlow);
                        }
                        release();
                        return;
                    case 2:
                        endFlow();
                        release();
                        return;
                    default:
                        if (sFlow != null) {
                            StatRouter.flowAddEvent(sFlow, eventName, getEventValue());
                            return;
                        }
                        return;
                }
            }
        }
    }

    private static class SwanProcessHandler extends RemoteDebugStatistic {
        private SwanProcessHandler() {
            super();
        }

        public void handleEvent(String eventName) {
            if (!TextUtils.isEmpty(eventName) && !RemoteDebugger.isReload()) {
                if (RemoteDebugStatistic.DEBUG) {
                    Log.d(RemoteDebugStatistic.TAG, "remote-debug statistic event name is : " + eventName);
                }
                char c2 = 65535;
                boolean z = true;
                switch (eventName.hashCode()) {
                    case 511060680:
                        if (eventName.equals(RemoteDebugStatistic.LOAD_MASTER)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 900970612:
                        if (eventName.equals("pageready")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        boolean isFinishing = true;
                        if (SwanApp.getOrNull() != null) {
                            ISwanFrameContainer frameContainer = SwanApp.getOrNull().getSwanFrameContainer();
                            if (frameContainer != null && !frameContainer.isContainerFinishing()) {
                                z = false;
                            }
                            isFinishing = z;
                        }
                        startFlow(isFinishing);
                        if (isFinishing) {
                            StatRouter.flowAddEvent(sFlow, eventName + "-destroy", getEventValue());
                            boolean unused = RemoteDebugStatistic.sIsFromNewIntent = false;
                            return;
                        } else if (RemoteDebugStatistic.sIsFromNewIntent) {
                            StatRouter.flowAddEvent(sFlow, eventName + "-preload", getEventValue());
                            boolean unused2 = RemoteDebugStatistic.sIsFromNewIntent = false;
                            return;
                        } else {
                            StatRouter.flowAddEvent(sFlow, eventName, getEventValue());
                            return;
                        }
                    case 1:
                        if (sFlow != null) {
                            StatRouter.flowAddEvent(sFlow, eventName, getEventValue());
                            endFlow();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (sFlow != null) {
                            StatRouter.flowAddEvent(sFlow, eventName, getEventValue());
                            return;
                        }
                        return;
                }
            }
        }
    }

    static void launchStatistic(SwanAppLaunchParams launchParams) {
        launchParams.requireExtraData().putString("aiapp_extra_need_download", "1");
        launchParams.requireExtraData().putString("aiapp_extra_pkg_downloading", "0");
        launchParams.requireExtraData().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        SwanAppUBCEvent event = new SwanAppUBCEvent();
        event.mFrom = SwanAppUBCStatistic.getUBCFrom(launchParams.getAppFrameType());
        event.fillLaunchId(launchParams.getLaunchId());
        event.setDataByLaunchParams(launchParams);
        event.mType = "launch";
        event.mNeeddown = "1";
        event.mSource = "remote-debug";
        JSONObject ext = SwanAppUBCStatistic.getExtFromLaunchScheme(launchParams.getLaunchScheme());
        event.mergeExtInfo(launchParams.requireExtraData().getString("ubc"));
        event.addExtLogInfo(ext);
        SwanAppUBCStatistic.onEvent(event);
    }

    static void onZipDownloaded(SwanAppLaunchParams launchParams) {
        SwanAppUBCEvent event = new SwanAppUBCEvent();
        event.setDataByLaunchParams(launchParams);
        event.mFrom = SwanAppUBCStatistic.getUBCFrom(launchParams.getAppFrameType());
        event.fillLaunchId(launchParams.getLaunchId());
        event.mType = "launch";
        event.mSource = "remote-debug";
        event.mValue = ZIP_DOWNLOADED;
        SwanAppUBCStatistic.onEvent(event);
    }

    public static void loadMasterStatistic() {
        SwanAppUBCEvent event = new SwanAppUBCEvent();
        event.mFrom = "swan";
        event.mType = "launch";
        event.mSource = "remote-debug";
        event.mValue = LOAD_MASTER;
        SwanAppUBCStatistic.onEvent(event);
    }

    public static void appReadyStatistic() {
        SwanAppUBCEvent event = new SwanAppUBCEvent();
        event.mFrom = "swan";
        event.mType = "launch";
        event.mSource = "remote-debug";
        event.mValue = "appready";
        SwanAppUBCStatistic.onEvent(event);
    }

    static void onDownloadStart() {
        SwanAppUBCEvent event = new SwanAppUBCEvent();
        event.mFrom = "swan";
        event.mType = "launch";
        event.mSource = "remote-debug";
        event.mValue = DOWNLOAD_START;
        SwanAppUBCStatistic.onEvent(event);
    }
}
