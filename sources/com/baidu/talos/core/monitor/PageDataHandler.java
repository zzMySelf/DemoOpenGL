package com.baidu.talos.core.monitor;

import android.util.Log;
import com.baidu.talos.monitor.IDataHandler;
import com.baidu.talos.monitor.MonitorData;
import com.baidu.talos.monitor.PerformanceMonitorConstants;
import com.baidu.talos.tracelog.LogParams;
import com.baidu.talos.tracelog.TalosYaLogger;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class PageDataHandler implements IDataHandler {
    private static final int MAX_LOG_LEN = 3900;
    private static final String TAG = "TLS_PageDataHandler";

    public void handleError(MonitorData monitorData) {
        if (monitorData != null) {
            ConcurrentHashMap<String, String> dataCollection = new ConcurrentHashMap<>();
            dataCollection.putAll(monitorData.monitorDataCollection);
            dataCollection.put(PerformanceMonitorConstants.PAGE_TALOS_EXT, new JSONObject(monitorData.talosExtDataMap).toString());
            Log.e(TAG, monitorData.mErrorMsg.toString());
            Log.e(TAG, converMonitorDataToStr(monitorData));
            JSONObject logObj = new JSONObject(dataCollection);
            showLogSeg("ubcData:" + logObj);
            TalosYaLogger.yaLogD(LogParams.TAG_1601IDATAHANDLER, "PageDataHandler handleError: " + logObj);
        }
    }

    public void handleSuccess(MonitorData monitorData) {
        Object obj;
        Object obj2;
        MonitorData monitorData2 = monitorData;
        ConcurrentHashMap<String, String> monitorDataCollection = new ConcurrentHashMap<>();
        StringBuilder strBufer = new StringBuilder();
        strBufer.append("=============RenderManager:PagePerformance=============\n");
        if (monitorData2 != null) {
            ConcurrentHashMap<String, String> talosExtDataMap = monitorData2.talosExtDataMap;
            monitorDataCollection.putAll(monitorData2.monitorDataCollection);
            monitorDataCollection.put(PerformanceMonitorConstants.PAGE_TALOS_EXT, new JSONObject(talosExtDataMap).toString());
            strBufer.append(converMonitorDataToStr(monitorData));
            strBufer.append("\n");
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT) && monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_TALOS_INIT)) {
                strBufer.append("initCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_TALOS_INIT)).longValue()));
                strBufer.append("\n");
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_PULL_BUNDLE) && monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT)) {
                strBufer.append("ePullBundle:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_PULL_BUNDLE)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_RUNTIME) && monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT)) {
                strBufer.append("checkBundleCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_CREATE_RUNTIME)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
            } else if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME) && monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT)) {
                strBufer.append("checkBundleCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
            }
            strBufer.append("\n");
            strBufer.append("\n");
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_CREATE_RUNTIME) && talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_RUNTIME)) {
                strBufer.append("createRuntimeCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_CREATE_RUNTIME)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_CREATE_RUNTIME)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_CREATE_RUNTIME) && talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_ROOT_VIEW)) {
                strBufer.append("threadCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_CREATE_ROOT_VIEW)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_CREATE_RUNTIME)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_ROOT_VIEW) && talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_CREATE_ROOT_VIEW)) {
                strBufer.append("createRootViewCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_CREATE_ROOT_VIEW)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_CREATE_ROOT_VIEW)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_CREATE_ROOT_VIEW) && talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_LOAD_THEME_FONT)) {
                strBufer.append("threadCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_LOAD_THEME_FONT)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_CREATE_ROOT_VIEW)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_LOAD_THEME_FONT) && talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_LOAD_THEME_FONT)) {
                strBufer.append("loadThemeFont:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_LOAD_THEME_FONT)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_LOAD_THEME_FONT)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_LOAD_THEME_FONT) && monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME)) {
                strBufer.append("threadCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_LOAD_THEME_FONT)).longValue()));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME) && monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT) && monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME)) {
                strBufer.append("initRunTimeCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME)).longValue()));
                strBufer.append("\n");
                strBufer.append("nativeInitRunTime:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
                strBufer.append("\n");
                strBufer.append("\n");
            }
            if (!monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME)) {
                obj = PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME;
            } else if (!monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_LOAD_PAGE)) {
                obj = PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME;
            } else if (!monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE)) {
                obj = PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME;
            } else if (!monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_LOAD_PAGE)) {
                obj = PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME;
            } else if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_LOAD_MODULE)) {
                StringBuilder append = new StringBuilder().append("threadCost:");
                long longValue = Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_LOAD_PAGE)).longValue();
                long longValue2 = Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME)).longValue();
                obj = PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME;
                strBufer.append(append.append(longValue - longValue2).toString());
                strBufer.append("\n");
                strBufer.append("loadBizInfoCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_LOAD_MODULE)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_LOAD_PAGE)).longValue()));
                strBufer.append("\n");
                strBufer.append("threadCost1:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_LOAD_MODULE)).longValue()));
                strBufer.append("\n");
                strBufer.append("eInitRunTime:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
                strBufer.append("\n");
                strBufer.append("loadPage:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_LOAD_PAGE)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
                strBufer.append("\n");
                strBufer.append("\n");
            } else {
                obj = PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME;
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME)) {
                obj2 = obj;
                if (monitorDataCollection.containsKey(obj2)) {
                    strBufer.append("initBridgeCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME)).longValue() - Long.valueOf(monitorDataCollection.get(obj2)).longValue()));
                    strBufer.append("\n");
                }
            } else {
                obj2 = obj;
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_LOAD_PAGE) && monitorDataCollection.containsKey(obj2)) {
                strBufer.append("bindBridgeCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_LOAD_PAGE)).longValue() - Long.valueOf(monitorDataCollection.get(obj2)).longValue()));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_DO_RUN_APPLICATION) && monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT)) {
                strBufer.append("runApp:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_RUN_APPLICATION)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
                strBufer.append("\n");
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE) && monitorDataCollection.containsKey(obj2)) {
                strBufer.append("runtimeCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE)).longValue() - Long.valueOf(monitorDataCollection.get(obj2)).longValue()));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_LOAD_PAGE) && monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE)) {
                strBufer.append("bundleLoadCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_LOAD_PAGE)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_SSR_REQ) && talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_SSR_REQ)) {
                strBufer.append("ssrReqCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_SSR_REQ)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_SSR_REQ)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_SSR_REQ) && talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_SSR_REQ_BODY)) {
                strBufer.append("ssrReqBodyReadCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_SSR_REQ_BODY)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_SSR_REQ)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_PARSE_SSR_DATA) && talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_PARSE_SSR_DATA)) {
                strBufer.append("parseSSRDataCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_PARSE_SSR_DATA)).longValue() - Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_PARSE_SSR_DATA)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_JS_MOUNTED) && monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT)) {
                strBufer.append("ttiCost:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_JS_MOUNTED)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_VIEW) && monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT)) {
                strBufer.append("fcpCost:" + (Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_VIEW)).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("firstMeaningfulPaint") && monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT)) {
                strBufer.append("fmpCost:" + (Long.valueOf(monitorDataCollection.get("firstMeaningfulPaint")).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.START_INIT)).longValue()));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("firstMeaningfulPaint") && monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_DO_RUN_APPLICATION)) {
                strBufer.append("renderCost:" + (Long.valueOf(monitorDataCollection.get("firstMeaningfulPaint")).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_RUN_APPLICATION)).longValue()));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_JS_MOUNTED) && monitorDataCollection.containsKey("firstMeaningfulPaint")) {
                strBufer.append("tti - fmp:" + (Long.valueOf(talosExtDataMap.get(PerformanceMonitorConstants.PAGE_JS_MOUNTED)).longValue() - Long.valueOf(monitorDataCollection.get("firstMeaningfulPaint")).longValue()));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("firstMeaningfulPaint") && monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_TALOS_INIT)) {
                strBufer.append("totalCost:" + (Long.valueOf(monitorDataCollection.get("firstMeaningfulPaint")).longValue() - Long.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_TALOS_INIT)).longValue()));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_TALOS_EXT)) {
                strBufer.append("extINfo:" + String.valueOf(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_TALOS_EXT)));
                strBufer.append("\n");
            }
        }
        showLogSeg(strBufer.toString());
        JSONObject logObj = new JSONObject(monitorDataCollection);
        showLogSeg(" RenderManager ubcData:" + logObj);
        TalosYaLogger.yaLogD(LogParams.TAG_1601IDATAHANDLER, "PageDataHandler handleSuccess: " + logObj);
    }

    private void showLogSeg(String log) {
        if (log.length() > MAX_LOG_LEN) {
            Log.d(TAG, "\n" + log.substring(0, MAX_LOG_LEN));
            showLogSeg(log.substring(MAX_LOG_LEN, log.length()));
            return;
        }
        Log.d(TAG, "\n" + log);
    }

    private String converMonitorDataToStr(MonitorData monitorData) {
        ConcurrentHashMap<String, String> monitorDataCollection = monitorData.monitorDataCollection;
        ConcurrentHashMap<String, String> talosExtDataMap = monitorData.talosExtDataMap;
        StringBuilder strBufer = new StringBuilder("");
        if (monitorDataCollection != null) {
            if (monitorDataCollection.containsKey("deviceScore")) {
                strBufer.append("deviceScore:" + monitorDataCollection.get("deviceScore"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("mainBiz")) {
                strBufer.append("mainBiz:" + monitorDataCollection.get("mainBiz"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("mainBizV")) {
                strBufer.append("mainBizV:" + monitorDataCollection.get("mainBizV"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("bizName")) {
                strBufer.append("bizName:" + monitorDataCollection.get("bizName"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("bizV")) {
                strBufer.append("bizV:" + monitorDataCollection.get("bizV"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("renderType")) {
                strBufer.append("renderType:" + monitorDataCollection.get("renderType"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("layoutType")) {
                strBufer.append("layoutType:" + monitorDataCollection.get("layoutType"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_CACHED_RUNTIME)) {
                strBufer.append("cachedRuntime:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_CACHED_RUNTIME));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_CACHED_BIZ)) {
                strBufer.append("cachedBiz:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_CACHED_BIZ));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_FMP_WAIT_VALID_NODE)) {
                strBufer.append("fmpWaitVNode:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_FMP_WAIT_VALID_NODE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_BIZ_CUSTOM_FMP)) {
                strBufer.append("bizCustomFMP:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_BIZ_CUSTOM_FMP));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_IS_FULL_SCREEN_FMP)) {
                strBufer.append("isFullScreenFMP:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_IS_FULL_SCREEN_FMP));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_TALOS_INIT)) {
                strBufer.append("sTalosInit:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_TALOS_INIT));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.START_INIT)) {
                strBufer.append("sInit:" + monitorDataCollection.get(PerformanceMonitorConstants.START_INIT));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_PULL_BUNDLE)) {
                strBufer.append("ePullBundle:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_PULL_BUNDLE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_PREFETCH_DATA)) {
                strBufer.append("sPrefetchData:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_PREFETCH_DATA));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_PREFETCH_DATA)) {
                strBufer.append("ePrefetchData:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_PREFETCH_DATA));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_RUNTIME)) {
                strBufer.append("sCreateRunTime:" + talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_CREATE_RUNTIME));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_CREATE_RUNTIME)) {
                strBufer.append("eCreateRunTime:" + talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_CREATE_RUNTIME));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_ROOT_VIEW)) {
                strBufer.append("sCreateRootView:" + talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_CREATE_ROOT_VIEW));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_CREATE_ROOT_VIEW)) {
                strBufer.append("eCreateRootView:" + talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_CREATE_ROOT_VIEW));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_LOAD_THEME_FONT)) {
                strBufer.append("sLoadThemeFont:" + talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_LOAD_THEME_FONT));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_END_LOAD_THEME_FONT)) {
                strBufer.append("eLoadThemeFont:" + talosExtDataMap.get(PerformanceMonitorConstants.PAGE_END_LOAD_THEME_FONT));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME)) {
                strBufer.append("sInitRunTime:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_INIT_RUNTIME));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME)) {
                strBufer.append("eInitRunTime:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_INIT_RUNTIME));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_START_SSR)) {
                strBufer.append("sSSRRender:" + talosExtDataMap.get(PerformanceMonitorConstants.PAGE_START_SSR));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("eInitReactContext")) {
                strBufer.append("eInitReactContext:" + monitorDataCollection.get("eInitReactContext"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_LOAD_PAGE)) {
                strBufer.append("sLoadPage:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_LOAD_PAGE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_LOAD_MODULE)) {
                strBufer.append("sLoadModule:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_LOAD_MODULE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_LOAD_MODULE)) {
                strBufer.append("eLoadModule:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_LOAD_MODULE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_PENDING_LOAD_PAGE)) {
                strBufer.append("pLoadPage:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_PENDING_LOAD_PAGE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_NATIVE_LOAD_PAGE)) {
                strBufer.append("nativeLoadPage:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_NATIVE_LOAD_PAGE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE)) {
                strBufer.append("doLoadPage:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_LOAD_PAGE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("useCodeCache")) {
                strBufer.append("useCodeCache:" + monitorDataCollection.get("useCodeCache"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("sLoadCodeCache")) {
                strBufer.append("sLoadCodeCache:" + monitorDataCollection.get("sLoadCodeCache"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("eLoadCodeCache")) {
                strBufer.append("eLoadCodeCache:" + monitorDataCollection.get("eLoadCodeCache"));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_END_LOAD_PAGE)) {
                strBufer.append("eLoadPage:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_END_LOAD_PAGE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_RUN_PAGE)) {
                strBufer.append("sRunPage:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_RUN_PAGE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_PENDING_RUN_PAGE)) {
                strBufer.append("pRunPage:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_PENDING_RUN_PAGE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_DO_RUN_PAGE)) {
                strBufer.append("doRunPage:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_RUN_PAGE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_DO_RUN_APPLICATION)) {
                strBufer.append("doRunApp:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_DO_RUN_APPLICATION));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_JS_NODE)) {
                strBufer.append("sCreateFJsNode:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_JS_NODE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_VALID_NODE)) {
                strBufer.append("sCreateFVNode:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_VALID_NODE));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_VIEW)) {
                strBufer.append("sCreateFView:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_CREATE_FIRST_VIEW));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_START_CREATE_LAST_VIEW)) {
                strBufer.append("startCreateLastView:" + monitorDataCollection.get(PerformanceMonitorConstants.PAGE_START_CREATE_LAST_VIEW));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey("firstMeaningfulPaint")) {
                strBufer.append("eFirstPage:" + monitorDataCollection.get("firstMeaningfulPaint"));
                strBufer.append("\n");
            }
            if (talosExtDataMap.containsKey(PerformanceMonitorConstants.PAGE_JS_MOUNTED)) {
                strBufer.append("jsMounted:" + talosExtDataMap.get(PerformanceMonitorConstants.PAGE_JS_MOUNTED));
                strBufer.append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_FMP_VIEW_COUNT)) {
                strBufer.append(PerformanceMonitorConstants.PAGE_FMP_VIEW_COUNT).append(":").append(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_FMP_VIEW_COUNT)).append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_NODE_COUNT)) {
                strBufer.append(PerformanceMonitorConstants.PAGE_NODE_COUNT).append(":").append(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_NODE_COUNT)).append("\n");
            }
            if (monitorDataCollection.containsKey(PerformanceMonitorConstants.PAGE_BIZ_CUSTOM_FMP)) {
                strBufer.append(PerformanceMonitorConstants.PAGE_BIZ_CUSTOM_FMP).append(":").append(monitorDataCollection.get(PerformanceMonitorConstants.PAGE_BIZ_CUSTOM_FMP)).append("\n");
            }
        }
        return strBufer.toString();
    }
}
