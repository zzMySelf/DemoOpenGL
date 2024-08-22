package com.baidu.swan.apps.api.module.utils;

import android.text.TextUtils;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager;
import com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.fragment.SwanAppFragment;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.embed.page.ISwanPageManager;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.model.SwanAppLaunchInfo;
import com.baidu.swan.apps.lifecycle.SwanAppController;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.SwanAppPerformanceUBC;
import com.baidu.swan.apps.performance.SwanAppRoutePerformUtils;
import com.baidu.swan.apps.performance.TraceDataManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.stable.SwanAppStabilityTracer;
import com.baidu.swan.apps.statistic.event.SwanAppUrlLoadFlowEvent;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UbcFlowJarApi extends AbsUtilsApi {
    private static final String ACTION_UBC_FLOW_JAR = "ubcFlowJar";
    private static final String EXT_DATA = "data";
    private static final String EXT_KEY = "ext";
    private static final String KEY_EXT_FCP = "fcp";
    private static final String KEY_EXT_PAGE_ID = "pageId";
    private static final String KEY_EXT_TYPE = "type";
    private static final String TAG = "UbcFlowJarApi";
    private static final String VALUE_EXT_TYPE = "preFCPReport";
    private static final String WHITELIST_NAME = "swanAPI/ubcFlowJar";

    public UbcFlowJarApi(ISwanApiContext swanApiContext) {
        super(swanApiContext);
    }

    public String getLogTag() {
        return TAG;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        if (r5.equals("670") != false) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.swan.apps.api.result.SwanApiResult ubcFlowJar(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "#ubcFlowJar"
            r1 = 0
            r9.logInfo(r0, r1)
            com.baidu.swan.apps.runtime.SwanApp r0 = com.baidu.swan.apps.runtime.SwanApp.getOrNull()
            if (r0 != 0) goto L_0x0017
            com.baidu.swan.apps.api.result.SwanApiResult r1 = new com.baidu.swan.apps.api.result.SwanApiResult
            r2 = 1001(0x3e9, float:1.403E-42)
            java.lang.String r3 = "swan app is null"
            r1.<init>((int) r2, (java.lang.String) r3)
            return r1
        L_0x0017:
            android.util.Pair r2 = r9.parseJson(r10)
            java.lang.Object r3 = r2.first
            com.baidu.swan.apps.api.result.SwanApiResult r3 = (com.baidu.swan.apps.api.result.SwanApiResult) r3
            boolean r4 = r3.isSuccess()
            if (r4 != 0) goto L_0x0026
            return r3
        L_0x0026:
            java.lang.Object r4 = r2.second
            org.json.JSONObject r4 = (org.json.JSONObject) r4
            java.lang.String r5 = "flowId"
            java.lang.String r5 = r4.optString(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            r7 = 201(0xc9, float:2.82E-43)
            if (r6 == 0) goto L_0x0040
            java.lang.String r1 = "empty flowId"
            com.baidu.swan.apps.api.result.SwanApiResult r6 = new com.baidu.swan.apps.api.result.SwanApiResult
            r6.<init>((int) r7, (java.lang.String) r1)
            return r6
        L_0x0040:
            r6 = -1
            int r8 = r5.hashCode()
            switch(r8) {
                case 53647: goto L_0x007c;
                case 53648: goto L_0x0072;
                case 55357: goto L_0x0068;
                case 56506: goto L_0x005e;
                case 46733230: goto L_0x0054;
                case 1529139648: goto L_0x0049;
                default: goto L_0x0048;
            }
        L_0x0048:
            goto L_0x0085
        L_0x0049:
            java.lang.String r1 = "renderMonitorLog"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0048
            r1 = 5
            goto L_0x0086
        L_0x0054:
            java.lang.String r1 = "10360"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0048
            r1 = 2
            goto L_0x0086
        L_0x005e:
            java.lang.String r1 = "967"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0048
            r1 = 4
            goto L_0x0086
        L_0x0068:
            java.lang.String r1 = "805"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0048
            r1 = 1
            goto L_0x0086
        L_0x0072:
            java.lang.String r1 = "671"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0048
            r1 = 3
            goto L_0x0086
        L_0x007c:
            java.lang.String r8 = "670"
            boolean r8 = r5.equals(r8)
            if (r8 == 0) goto L_0x0048
            goto L_0x0086
        L_0x0085:
            r1 = r6
        L_0x0086:
            java.lang.String r6 = "data"
            switch(r1) {
                case 0: goto L_0x00b8;
                case 1: goto L_0x00b0;
                case 2: goto L_0x00a4;
                case 3: goto L_0x009c;
                case 4: goto L_0x0098;
                case 5: goto L_0x0094;
                default: goto L_0x008b;
            }
        L_0x008b:
            java.lang.String r1 = "unknown flowId"
            com.baidu.swan.apps.api.result.SwanApiResult r6 = new com.baidu.swan.apps.api.result.SwanApiResult
            r6.<init>((int) r7, (java.lang.String) r1)
            return r6
        L_0x0094:
            handleRenderMonitor(r4)
            goto L_0x00bc
        L_0x0098:
            handleRoutePerformMsg(r4)
            goto L_0x00bc
        L_0x009c:
            org.json.JSONArray r1 = r4.optJSONArray(r6)
            handleStabilityMessage(r1)
            goto L_0x00bc
        L_0x00a4:
            com.baidu.swan.apps.web.statistics.WebStatsStrategy r1 = com.baidu.swan.apps.web.statistics.WebStatisticManager.getStrategy()
            org.json.JSONArray r6 = r4.optJSONArray(r6)
            r1.onJsFmpSubmit(r6)
            goto L_0x00bc
        L_0x00b0:
            org.json.JSONArray r1 = r4.optJSONArray(r6)
            handleUrlLoadDataFlow(r1)
            goto L_0x00bc
        L_0x00b8:
            handlePerformMsg(r4, r0)
        L_0x00bc:
            com.baidu.swan.apps.api.result.SwanApiResult r1 = com.baidu.swan.apps.api.result.SwanApiResult.ok()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.api.module.utils.UbcFlowJarApi.ubcFlowJar(java.lang.String):com.baidu.swan.apps.api.result.SwanApiResult");
    }

    public static void handlePerformMsg(final JSONObject joParams, final SwanApp swanApp) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                JSONObject extJson = joParams.optJSONObject("ext");
                if (TextUtils.equals(UbcFlowJarApi.VALUE_EXT_TYPE, extJson == null ? "" : extJson.optString("type"))) {
                    UbcFlowJarApi.doHandleFcpMsg(extJson);
                } else {
                    UbcFlowJarApi.doHandlePerformMsg(joParams, swanApp);
                }
            }
        }, "handlePerformMsg", 2);
    }

    /* JADX WARNING: type inference failed for: r8v10, types: [com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doHandlePerformMsg(org.json.JSONObject r11, com.baidu.swan.apps.runtime.SwanApp r12) {
        /*
            com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime r0 = com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime.getInstance()
            com.baidu.swan.apps.core.master.SwanAppMasterContainer r0 = r0.getMasterContainer()
            r1 = 0
            boolean r2 = r0 instanceof com.baidu.swan.apps.core.master.V8MasterAdapter
            if (r2 == 0) goto L_0x0014
            r2 = r0
            com.baidu.swan.apps.core.master.V8MasterAdapter r2 = (com.baidu.swan.apps.core.master.V8MasterAdapter) r2
            int r1 = r2.getCodeCacheStatus()
        L_0x0014:
            r2 = 1
            com.baidu.swan.apps.statistic.SwanAppLaunchUbc.setFirstRender(r2)
            java.lang.String r2 = "realsuccess"
            boolean r2 = com.baidu.swan.apps.statistic.SwanAppUbcControl.canStatLaunch(r2)
            if (r2 == 0) goto L_0x0024
            com.baidu.swan.apps.statistic.SwanAppLaunchUbc.onPageRenderSuccess()
        L_0x0024:
            java.lang.String r2 = "startup"
            com.baidu.swan.apps.performance.HybridUbcFlow r2 = com.baidu.swan.apps.performance.SwanAppPerformanceUBC.requireSession(r2)
            java.lang.String r3 = "ext"
            org.json.JSONObject r3 = r11.optJSONObject(r3)
            java.lang.String r4 = "0"
            java.lang.String r5 = ""
            r6 = 0
            if (r3 == 0) goto L_0x0065
            java.lang.String r7 = "hasWebView"
            java.lang.String r8 = "0"
            java.lang.String r4 = r3.optString(r7, r8)
            java.lang.String r7 = "hasRelaunch"
            java.lang.String r5 = r3.optString(r7)
            java.lang.String r7 = "pageId"
            java.lang.String r7 = r3.optString(r7)
            com.baidu.swan.apps.lifecycle.SwanAppController r8 = com.baidu.swan.apps.lifecycle.SwanAppController.getInstance()
            com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager r8 = r8.getWebViewManager(r7)
            boolean r9 = r8 instanceof com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager
            if (r9 == 0) goto L_0x005c
            r6 = r8
            com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager r6 = (com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager) r6
        L_0x005c:
            java.lang.String r9 = java.lang.String.valueOf(r3)
            java.lang.String r10 = "flow_ext"
            r2.putExt(r10, r9)
        L_0x0065:
            java.lang.String r7 = "1"
            boolean r8 = android.text.TextUtils.equals(r4, r7)
            if (r8 == 0) goto L_0x0084
            com.baidu.swan.apps.performance.HybridUbcFlow$SubmitStrategy r8 = r2.getSubmitStrategy()
            com.baidu.swan.apps.performance.HybridUbcFlow$SubmitStrategy r9 = com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.HYBRID
            if (r8 != r9) goto L_0x007b
            com.baidu.swan.apps.performance.HybridUbcFlow$SubmitStrategy r9 = com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.HYBRID_WEB
            r2.setSubmitStrategy(r9)
            goto L_0x0084
        L_0x007b:
            com.baidu.swan.apps.performance.HybridUbcFlow$SubmitStrategy r9 = com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.RELAUNCH
            if (r8 != r9) goto L_0x0084
            com.baidu.swan.apps.performance.HybridUbcFlow$SubmitStrategy r9 = com.baidu.swan.apps.performance.HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB
            r2.setSubmitStrategy(r9)
        L_0x0084:
            java.lang.String r8 = "none"
            boolean r8 = android.text.TextUtils.equals(r5, r8)
            if (r8 == 0) goto L_0x009a
            boolean r7 = android.text.TextUtils.equals(r4, r7)
            if (r7 == 0) goto L_0x0097
            r2.webPaintFlowDone()
            goto L_0x009a
        L_0x0097:
            r2.naPaintFlowDone(r6)
        L_0x009a:
            java.lang.String r7 = "data"
            org.json.JSONArray r7 = r11.optJSONArray(r7)
            handleFcpRecord(r2, r12, r4, r6, r7)
            java.lang.String r8 = java.lang.String.valueOf(r1)
            java.lang.String r9 = "codecache"
            com.baidu.swan.apps.performance.HybridUbcFlow r8 = r2.putExt(r9, r8)
            int r9 = getSlaveCodeCacheStatus()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            java.lang.String r10 = "slave_codecache"
            com.baidu.swan.apps.performance.HybridUbcFlow r8 = r8.putExt(r10, r9)
            java.util.List r9 = parseEvents(r7)
            com.baidu.swan.apps.performance.HybridUbcFlow r8 = r8.record((java.util.List<com.baidu.swan.apps.performance.UbcFlowEvent>) r9)
            r8.h5FlowDone()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.api.module.utils.UbcFlowJarApi.doHandlePerformMsg(org.json.JSONObject, com.baidu.swan.apps.runtime.SwanApp):void");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void doHandleFcpMsg(org.json.JSONObject r7) {
        /*
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.lang.String r1 = "pageId"
            java.lang.String r1 = r7.optString(r1)
            com.baidu.swan.apps.lifecycle.SwanAppController r2 = com.baidu.swan.apps.lifecycle.SwanAppController.getInstance()
            com.baidu.swan.apps.adaptation.webview.ISwanAppWebViewManager r2 = r2.getWebViewManager(r1)
            boolean r3 = r2 instanceof com.baidu.swan.apps.core.slave.SwanAppSlaveManager
            if (r3 == 0) goto L_0x001a
            r0 = r2
            com.baidu.swan.apps.core.slave.SwanAppSlaveManager r0 = (com.baidu.swan.apps.core.slave.SwanAppSlaveManager) r0
        L_0x001a:
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            java.lang.String r3 = "fcp"
            long r3 = r7.optLong(r3)
            java.lang.String r5 = "startup"
            com.baidu.swan.apps.performance.HybridUbcFlow r5 = com.baidu.swan.apps.performance.SwanAppPerformanceUBC.getSession(r5)
            com.baidu.swan.apps.core.slave.SwanAppWebViewWidget r6 = r0.getWebViewWidget()
            if (r6 != 0) goto L_0x0032
            r6 = r0
            goto L_0x0036
        L_0x0032:
            com.baidu.swan.apps.core.slave.SwanAppWebViewWidget r6 = r0.getWebViewWidget()
        L_0x0036:
            r0 = r6
            r0.handleFeFcp(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.api.module.utils.UbcFlowJarApi.doHandleFcpMsg(org.json.JSONObject):void");
    }

    private static int getSlaveCodeCacheStatus() {
        SwanAppFragment topSwanAppFragment;
        ISwanAppSlaveManager<?> curSlaveManager;
        ISwanPageManager fragmentManager = SwanAppController.getInstance().getSwanPageManager();
        if (fragmentManager == null || (topSwanAppFragment = fragmentManager.getTopSwanAppFragment()) == null || (curSlaveManager = topSwanAppFragment.getCurrentWebViewManager()) == null) {
            return 0;
        }
        return curSlaveManager.getCodeCacheStatus();
    }

    private static void handleFcpRecord(HybridUbcFlow flow, SwanApp swanApp, String webType, ISwanAppSlaveManager slaveManager, JSONArray fePerfData) {
        final HybridUbcFlow hybridUbcFlow = flow;
        final String str = webType;
        final ISwanAppSlaveManager iSwanAppSlaveManager = slaveManager;
        if (hybridUbcFlow == null) {
            JSONArray jSONArray = fePerfData;
        } else if (swanApp == null) {
            JSONArray jSONArray2 = fePerfData;
        } else {
            ISwanAppSlaveManager manager = slaveManager;
            if (manager instanceof SwanAppSlaveManager) {
                ((SwanAppSlaveManager) (manager.getWebViewWidget() == null ? manager : manager.getWebViewWidget())).handleFePerformMsg(str, hybridUbcFlow, fePerfData);
            } else {
                JSONArray jSONArray3 = fePerfData;
            }
            if (BdZeusUtil.isWebkitLoaded()) {
                long totalWaitTime = SwanAppRuntime.getSwanAppAbTestRuntime().getRecordFcpSwitch();
                if (totalWaitTime > 0) {
                    SwanAppLaunchInfo launchInfo = swanApp.getLaunchInfo();
                    boolean isTimeout = false;
                    long remainTime = 0;
                    if (launchInfo != null) {
                        long pastTime = System.currentTimeMillis() - launchInfo.getExtStartTimestamp();
                        if (pastTime >= totalWaitTime) {
                            isTimeout = true;
                        } else {
                            remainTime = totalWaitTime - pastTime;
                        }
                    }
                    if (isTimeout) {
                        if (TextUtils.equals(str, "1")) {
                            flow.webPaintFlowDone();
                        } else {
                            hybridUbcFlow.naPaintFlowDone(iSwanAppSlaveManager);
                        }
                    } else if (remainTime > 0) {
                        SwanAppExecutorUtils.delayPostOnComputation(new Runnable() {
                            public void run() {
                                if (TextUtils.equals(str, "1")) {
                                    hybridUbcFlow.webPaintFlowDone();
                                } else {
                                    hybridUbcFlow.naPaintFlowDone(iSwanAppSlaveManager);
                                }
                            }
                        }, "waitFcp", remainTime, TimeUnit.MILLISECONDS);
                    }
                }
            } else if (TextUtils.equals(str, "1")) {
                flow.webPaintFlowDone();
            } else {
                flow.naPaintFlowDone();
            }
        }
    }

    public static void handleRenderMonitor(JSONObject joParams) {
        JSONArray dataArray = joParams.optJSONArray("data");
        if (dataArray != null && dataArray.length() >= 1) {
            TraceDataManager.getInstance().addTraceData(dataArray.optJSONObject(0));
        }
    }

    public static void handleRoutePerformMsg(JSONObject joParams) {
        JSONObject extJson;
        if (joParams != null && (extJson = joParams.optJSONObject("ext")) != null) {
            String routeId = extJson.optString(SwanAppRoutePerformUtils.EXT_ROUTE_ID_KEY);
            if (!TextUtils.isEmpty(routeId)) {
                HybridUbcFlow flow = SwanAppPerformanceUBC.requireSession("route", routeId);
                if (TextUtils.equals(extJson.optString(SwanAppRoutePerformUtils.EXT_HAS_WEB_VIEW_KEY), "1")) {
                    flow.setSubmitStrategy(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
                }
                flow.record(parseEvents(joParams.optJSONArray("data"))).h5FlowDone();
                ISwanAppWebViewManager viewManager = SwanAppController.getInstance().getWebViewManager(extJson.optString("slaveId"));
                if (viewManager instanceof SwanAppSlaveManager) {
                    ((SwanAppSlaveManager) viewManager).h5RouteDone();
                }
            }
        }
    }

    public static List<UbcFlowEvent> parseEvents(JSONArray jaEvents) {
        List<UbcFlowEvent> events = new ArrayList<>();
        if (jaEvents == null) {
            return events;
        }
        for (int i2 = 0; i2 < jaEvents.length(); i2++) {
            UbcFlowEvent event = parseEvent(jaEvents.optJSONObject(i2));
            if (event != null) {
                event.srcType("FE");
                events.add(event);
            }
        }
        return events;
    }

    public static UbcFlowEvent parseEvent(JSONObject joEvent) {
        if (joEvent == null) {
            return null;
        }
        String id = joEvent.optString("actionId");
        long time = joEvent.optLong("timestamp");
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return new UbcFlowEvent(id).time(time);
    }

    public static void handleUrlLoadDataFlow(JSONArray dataArray) {
        SwanAppFragment topFragment = SwanAppController.getInstance().getTopSwanAppFragment();
        if (topFragment != null) {
            try {
                JSONObject obj = dataArray.getJSONObject(0);
                if (obj != null) {
                    String eventId = obj.getString("eventId");
                    String timeStampStr = obj.optString("timeStamp");
                    long timeStamp = 0;
                    if (!TextUtils.isEmpty(timeStampStr)) {
                        try {
                            timeStamp = Long.valueOf(timeStampStr).longValue();
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                    topFragment.loadUrlFinishedFromJS(new SwanAppUrlLoadFlowEvent(eventId, timeStamp));
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void handleStabilityMessage(JSONArray dataArray) {
        SwanAppLog.logToFile(TAG, "FlowJarAction-671: " + (dataArray == null ? "null" : dataArray));
        if (dataArray != null && dataArray.length() != 0) {
            int len = dataArray.length();
            for (int i2 = 0; i2 < len; i2++) {
                try {
                    JSONObject item = dataArray.getJSONObject(i2);
                    if (TextUtils.equals(item.optString("type"), SwanAppStabilityTracer.TRACE_TYPE_FE)) {
                        SwanAppStabilityTracer.getInstance().recordFETrace(item);
                    } else {
                        SwanAppStabilityTracer.getInstance().recordTrace(item);
                    }
                } catch (JSONException e2) {
                }
            }
        }
    }
}
