package com.baidu.searchbox.lightbrowser.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserUBC;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfilePerformanceFlow {
    public static final String INVALID_CONTEXT_ID = "-1";
    public static final String KEY_ACTION = "action";
    public static final String KEY_BUSINESS_TYPE = "businessType";
    public static final String KEY_CURRENT_CONTEXT = "current_context";
    public static final String KEY_EXTRA = "ext";
    public static final String KEY_FRAME_SOURCE = "frameSource";
    public static final String KEY_ORIGINAL_CONTEXT = "original_context";
    private static final String PERFORMANCE_ID = "824";
    private static volatile String sContextId = "-1";
    private static JSONObject sExtraInfo;
    private static volatile Flow sFlow;

    private ProfilePerformanceFlow() {
    }

    public static Flow instanceFlow(String contextId) {
        if (sFlow == null) {
            synchronized (PerformanceFlowUtil.class) {
                if (sFlow == null) {
                    sFlow = ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).beginFlow(PERFORMANCE_ID);
                    if (!TextUtils.isEmpty(contextId)) {
                        sContextId = contextId;
                    } else {
                        sContextId = "-1";
                    }
                    sExtraInfo = new JSONObject();
                }
            }
        }
        return sFlow;
    }

    public static synchronized void addEvent(String id) {
        synchronized (ProfilePerformanceFlow.class) {
            if (sFlow != null) {
                sFlow.addEvent(id, System.currentTimeMillis() + "");
            }
        }
    }

    public static synchronized void addEvent(String id, String value) {
        synchronized (ProfilePerformanceFlow.class) {
            if (sFlow != null) {
                sFlow.addEvent(id, value);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void setValue(java.lang.String r4) {
        /*
            java.lang.Class<com.baidu.searchbox.lightbrowser.statistic.ProfilePerformanceFlow> r0 = com.baidu.searchbox.lightbrowser.statistic.ProfilePerformanceFlow.class
            monitor-enter(r0)
            com.baidu.ubc.Flow r1 = sFlow     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            com.baidu.ubc.Flow r1 = sFlow     // Catch:{ all -> 0x002c }
            r1.setValueWithDuration(r4)     // Catch:{ all -> 0x002c }
            boolean r1 = com.baidu.searchbox.lightbrowser.LightBrowserRuntime.GLOBAL_DEBUG     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            java.lang.String r1 = "PerformanceFlowUtil"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r2.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r3 = "Value: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x002c }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x002c }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r0)
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.lightbrowser.statistic.ProfilePerformanceFlow.setValue(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void endFlow() {
        /*
            java.lang.Class<com.baidu.searchbox.lightbrowser.statistic.ProfilePerformanceFlow> r0 = com.baidu.searchbox.lightbrowser.statistic.ProfilePerformanceFlow.class
            monitor-enter(r0)
            com.baidu.ubc.Flow r1 = sFlow     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)
            return
        L_0x0009:
            com.baidu.ubc.Flow r1 = sFlow     // Catch:{ all -> 0x001e }
            r1.end()     // Catch:{ all -> 0x001e }
            resetFlow()     // Catch:{ all -> 0x001e }
            boolean r1 = com.baidu.searchbox.lightbrowser.LightBrowserRuntime.GLOBAL_DEBUG     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x001c
            java.lang.String r1 = "PerformanceFlowUtil"
            java.lang.String r2 = "End Flow"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r0)
            return
        L_0x001e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.lightbrowser.statistic.ProfilePerformanceFlow.endFlow():void");
    }

    public static boolean hasFlow() {
        return sFlow != null;
    }

    public static synchronized void resetFlow() {
        synchronized (ProfilePerformanceFlow.class) {
            if (sFlow != null) {
                sFlow = null;
                sExtraInfo = null;
            }
        }
    }

    public static synchronized void resetFlow(String contextId) {
        synchronized (ProfilePerformanceFlow.class) {
            if (TextUtils.equals(contextId, sContextId)) {
                resetFlow();
            }
        }
    }

    public static synchronized String appendPerformanceContentString(String frameSource, String businessType) {
        String jSONObject;
        synchronized (ProfilePerformanceFlow.class) {
            if (sExtraInfo == null) {
                sExtraInfo = new JSONObject();
            }
            try {
                if (!TextUtils.isEmpty(frameSource)) {
                    sExtraInfo.put("frameSource", frameSource);
                }
                if (!TextUtils.isEmpty(businessType)) {
                    sExtraInfo.put("businessType", businessType);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            jSONObject = sExtraInfo.toString();
        }
        return jSONObject;
    }

    public static String getPerformanceContentString(String page, String type, String cId, String extra) {
        return getPerformanceContentString("", "", "", "", cId, extra);
    }

    public static String getPerformanceContentString(String page, String type, String value, String action, String currentContextId, String extra) {
        if (!checkFlowContextValid(currentContextId)) {
            resetFlow();
        }
        if (sExtraInfo == null) {
            sExtraInfo = new JSONObject();
        }
        try {
            sExtraInfo.put("action", action);
            sExtraInfo.put("original_context", sContextId);
            sExtraInfo.put("current_context", currentContextId);
            sExtraInfo.put("ext", extra);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return sExtraInfo.toString();
    }

    public static String getPerformanceExtra(Context context, String url, String slog) {
        return ILightBrowserUBC.Impl.get().getPerformanceExtra(context, url, slog);
    }

    private static boolean checkFlowContextValid(String currentContextId) {
        if (TextUtils.isEmpty(currentContextId) || TextUtils.isEmpty(sContextId)) {
            return false;
        }
        if (TextUtils.equals("-1", sContextId)) {
            sContextId = currentContextId;
        }
        return sContextId.equals(currentContextId);
    }
}
