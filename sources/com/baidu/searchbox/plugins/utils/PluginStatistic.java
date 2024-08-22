package com.baidu.searchbox.plugins.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.net.ProxyHttpClient;
import com.baidu.searchbox.plugins.bridge.ApsBusinessRuntime;
import com.baidu.searchbox.plugins.statistic.ApsBusinessStatisticContstants;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PluginStatistic {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String JSON_KEY_APP_ID = "app_id";
    public static final String JSON_KEY_COUNT = "count";
    public static final String JSON_KEY_CPU = "cpu";
    public static final String JSON_KEY_EXT = "ext";
    public static final String JSON_KEY_FAILED_MSG = "failed_msg";
    public static final String JSON_KEY_FROM = "from";
    public static final String JSON_KEY_IS_INVOKE_METHOD = "is_invoke_method";
    public static final String JSON_KEY_IS_PLUGIN_INITED = "plugin_inited";
    public static final String JSON_KEY_LOAD_STATUS_CODE = "load_status_code";
    public static final String JSON_KEY_METHOD_NAME = "method_name";
    public static final String JSON_KEY_OPTION = "option";
    public static final String JSON_KEY_PACKAGE_NAME = "package_name";
    public static final String JSON_KEY_PAGE = "page";
    public static final String JSON_KEY_PATCH = "isPatch";
    public static final String JSON_KEY_PLUGIN_VERSION = "plugin_version";
    public static final String JSON_KEY_RESULT = "result";
    public static final String JSON_KEY_SOURCE = "source";
    public static final String JSON_KEY_STATUS_CODE = "status_code";
    public static final String JSON_KEY_TYPE = "type";
    public static final String JSON_KEY_URL = "url";
    public static final String JSON_KEY_VALUE = "value";
    public static final String JSON_KEY_WIFI = "isWifi";
    private static final int LOG_HEADER_TYPE_ADD = 0;
    private static final int LOG_HEADER_TYPE_REMOVE = 2;
    private static final int LOG_HEADER_TYPE_SET = 1;
    private static final int LOG_HEADER_TYPE_UNKNOWN = -1;
    public static final int PLUGIN_INSTALL = 2;
    public static final String PLUGIN_INSTALL_RESULT_FAIL = "1";
    public static final String PLUGIN_INSTALL_RESULT_SUC = "0";
    public static final int PLUGIN_OPEN = 1;
    public static final int PLUGIN_UNINSTALL = 3;
    public static final int PLUGIN_UNINSTALL_RESULT_AUTO = 1;
    public static final int PLUGIN_UNINSTALL_RESULT_CLEANUP = 2;
    public static final int PLUGIN_UNINSTALL_RESULT_MANUAL = 0;
    private static final String TAG = "PluginStatistic";
    private static Map<String, Flow> sFlowMap = new HashMap();
    private String mPackageName;
    private int mType;

    protected PluginStatistic(int type) {
        this.mType = type;
    }

    public void setPackageName(String name) {
        this.mPackageName = name;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getType() {
        return this.mType;
    }

    public static void sendDownloadStatusGMVLog(String statusCode, String packageName, String pluginVersion) {
        if (!TextUtils.isEmpty(statusCode)) {
            if (PluginStatisticUtils.isPluginRealtimeUpload(packageName)) {
                JSONObject jObj = new JSONObject();
                try {
                    jObj.put("status_code", statusCode);
                    String str = "";
                    jObj.put("package_name", packageName != null ? packageName : str);
                    if (pluginVersion != null) {
                        str = pluginVersion;
                    }
                    jObj.put("plugin_version", str);
                    UBC.onEvent("132", jObj.toString());
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            } else if (DEBUG) {
                Log.d(TAG, "sendDownloadStatusGMVLog !isPluginRealtimeUpload: " + packageName);
            }
        }
    }

    public static void sendDownloadGMVLog(String statusCode, String packageName, String pluginVersion, String failedMsg) {
        if (!TextUtils.isEmpty(statusCode)) {
            if (PluginStatisticUtils.isPluginRealtimeUpload(packageName)) {
                JSONObject jObj = new JSONObject();
                try {
                    jObj.put("status_code", statusCode);
                    String str = "";
                    jObj.put("package_name", packageName != null ? packageName : str);
                    if (pluginVersion != null) {
                        str = pluginVersion;
                    }
                    jObj.put("plugin_version", str);
                    jObj.put("failed_msg", failedMsg);
                    UBC.onEvent("133", jObj.toString());
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            } else if (DEBUG) {
                Log.d(TAG, "sendDownloadGMVLog !isPluginRealtimeUpload: " + packageName);
            }
        }
    }

    public static void sendUninstallGMVLog(int statusCode, String packageName, String pluginVersion) {
        if (PluginStatisticUtils.isPluginRealtimeUpload(packageName)) {
            JSONObject jObj = new JSONObject();
            try {
                jObj.put("status_code", String.valueOf(statusCode));
                String str = "";
                jObj.put("package_name", packageName != null ? packageName : str);
                if (pluginVersion != null) {
                    str = pluginVersion;
                }
                jObj.put("plugin_version", str);
                UBC.onEvent(ApsBusinessStatisticContstants.UBC_APS_UNINSTALL_STATUS_ID, jObj.toString());
            } catch (JSONException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        } else if (DEBUG) {
            Log.d(TAG, "sendUninstallGMVLog !isPluginRealtimeUpload: " + packageName);
        }
    }

    public static void sendInstallGMVLog(String statusCode, String packageName, String result, String pluginVersion, boolean isRealtimeUpload) {
        if (!TextUtils.isEmpty(statusCode)) {
            if (isRealtimeUpload) {
                JSONObject jObj = new JSONObject();
                try {
                    jObj.put("status_code", statusCode);
                    String str = "";
                    jObj.put("package_name", packageName != null ? packageName : str);
                    jObj.put("result", result != null ? result : str);
                    if (pluginVersion != null) {
                        str = pluginVersion;
                    }
                    jObj.put("plugin_version", str);
                    UBC.onEvent("134", jObj.toString());
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            } else if (DEBUG) {
                Log.d(TAG, "sendInstallGMVLog !isPluginRealtimeUpload: " + packageName);
            }
        }
    }

    public static void addInvokePluginStatistic(Context context, int result, String packageName, String methodName, String from, String appId, String url, boolean isInvokeMethod, String pluginVersion, int loadStatusCode) {
        if (ApsBusinessRuntime.getApsBusinessInterface().isMainProcess()) {
            addInvokePluginStatisticInMainProcess(context, result, packageName, methodName, from, appId, url, isInvokeMethod, pluginVersion, loadStatusCode);
        }
    }

    public static void addInvokePluginSpeedStatistic(long duration, String packageName, String methodName, String from, boolean isPluginInited, int cpu, long installVersion) {
        Flow flow = UBC.beginFlow(ApsBusinessStatisticContstants.UBC_APS_INVOKE_SPEED_ID);
        Map<String, String> map = new HashMap<>();
        map.put("package_name", packageName);
        map.put("method_name", methodName);
        map.put("from", from != null ? from : "");
        map.put(JSON_KEY_IS_PLUGIN_INITED, isPluginInited ? "1" : "0");
        map.put("cpu", String.valueOf(cpu));
        map.put("option", new JSONObject().toString());
        map.put("duration", String.valueOf(duration));
        map.put("plugin_version", String.valueOf(installVersion));
        flow.setValue(map);
        flow.end();
        if (DEBUG) {
            Log.d(TAG, "addInvokePluginSpeedStatistic: " + map.toString());
        }
    }

    public static void addInvokePluginStatisticInMainProcess(Context context, int result, String packageName, String methodName, String from, String appId, String url, boolean isInvokeMethod, String pluginVersion, int loadStatusCode) {
        int count;
        if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(methodName)) {
            if (DEBUG && !PluginStatisticUtils.isPluginRealtimeUpload(packageName)) {
                Log.d(TAG, "addStatistic invoke plugin !isPluginRealtimeUpload: " + packageName);
            }
            if (PluginStatisticUtils.isPluginRealtimeUpload(packageName) && (count = PluginTCBoxManager.getInstance().doCheck(packageName, methodName, result, loadStatusCode)) >= 0) {
                JSONObject jObj = new JSONObject();
                try {
                    jObj.put("status_code", String.valueOf(result));
                    jObj.put("package_name", packageName);
                    jObj.put("method_name", methodName);
                    String str = "";
                    jObj.put("from", from != null ? from : str);
                    jObj.put("app_id", appId != null ? appId : str);
                    jObj.put("url", url != null ? url : str);
                    jObj.put(JSON_KEY_IS_INVOKE_METHOD, isInvokeMethod ? "1" : "0");
                    if (pluginVersion != null) {
                        str = pluginVersion;
                    }
                    jObj.put("plugin_version", str);
                    jObj.put(JSON_KEY_LOAD_STATUS_CODE, loadStatusCode);
                    jObj.put("count", count);
                    UBC.onEvent(ApsBusinessStatisticContstants.UBC_APS_INVOKE_RESULT_ID, jObj.toString());
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void addTCStatisticInPlugin(final Context context, final String url) {
        if (!TextUtils.isEmpty(url)) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    ProxyHttpClient httpClient = ApsBusinessRuntime.getApsBusinessInterface().createHttpClient(context);
                    try {
                        if (httpClient.executeSafely(new HttpGet(url)).getStatusLine().getStatusCode() == 200 && PluginStatistic.DEBUG) {
                            Log.d(PluginStatistic.TAG, "addTCStatisticInPlugin SC_OK");
                        }
                        if (httpClient == null) {
                            return;
                        }
                    } catch (Exception e2) {
                        if (PluginStatistic.DEBUG) {
                            e2.printStackTrace();
                        }
                        if (httpClient == null) {
                            return;
                        }
                    } catch (Throwable th2) {
                        if (httpClient != null) {
                            httpClient.close();
                        }
                        throw th2;
                    }
                    httpClient.close();
                }
            }, "addTCStatisticInPlugin", 3);
        }
    }

    public static void addTCStatistics(Context context, String logUrl, JSONArray logHeaderArray) {
        if (ApsBusinessRuntime.getApsBusinessInterface().isMainProcess()) {
            addTCStatisticsInMainProcess(context, logUrl, logHeaderArray);
        }
    }

    public static void addTCStatisticsInMainProcess(final Context context, final String logUrl, final JSONArray logHeaderArray) {
        if (!TextUtils.isEmpty(logUrl) && ApsUtilty.isCoarseGrainedUrl(logUrl)) {
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    Process.setThreadPriority(10);
                    ProxyHttpClient httpClient = ApsBusinessRuntime.getApsBusinessInterface().createHttpClient(context);
                    HttpGet httpGet = new HttpGet(logUrl);
                    if (logHeaderArray != null) {
                        int i2 = 0;
                        while (i2 < logHeaderArray.length()) {
                            try {
                                JSONObject jObj = logHeaderArray.getJSONObject(i2);
                                int type = jObj.optInt("type", -1);
                                String name = jObj.optString("name");
                                String value = jObj.optString("value");
                                if (!TextUtils.isEmpty(name) && value != null) {
                                    if (type == 1) {
                                        httpGet.setHeader(name, value);
                                    } else if (type == 0) {
                                        httpGet.addHeader(name, value);
                                    } else if (type == 2) {
                                        httpGet.removeHeaders(name);
                                    }
                                }
                                i2++;
                            } catch (JSONException e2) {
                                if (PluginStatistic.DEBUG) {
                                    e2.printStackTrace();
                                }
                                httpGet = new HttpGet(logUrl);
                            }
                        }
                    }
                    try {
                        JSONException e3 = httpClient.executeSafely(httpGet);
                        if (e3.getStatusLine().getStatusCode() == 200) {
                            if (PluginStatistic.DEBUG) {
                                Log.d(PluginStatistic.TAG, "addTCStatistics SC_OK");
                            }
                            if (e3.getEntity() != null && PluginStatistic.DEBUG) {
                                Log.d(PluginStatistic.TAG, "addTCStatistics httpEntity not null");
                            }
                        }
                        if (httpClient == null) {
                            return;
                        }
                    } catch (ClientProtocolException e4) {
                        if (PluginStatistic.DEBUG) {
                            e4.printStackTrace();
                        }
                        httpGet.abort();
                        if (httpClient == null) {
                            return;
                        }
                    } catch (IOException e5) {
                        if (PluginStatistic.DEBUG) {
                            e5.printStackTrace();
                        }
                        httpGet.abort();
                        if (httpClient == null) {
                            return;
                        }
                    } catch (Throwable th2) {
                        if (httpClient != null) {
                            httpClient.close();
                        }
                        throw th2;
                    }
                    httpClient.close();
                }
            }, "addTCStatistics", 3);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void sendPluginInstallSpeedStatistic(java.lang.String r9, java.lang.String r10, java.lang.String r11, long r12, boolean r14, boolean r15) {
        /*
            int r0 = r9.hashCode()
            switch(r0) {
                case -1573559573: goto L_0x0031;
                case -1573272144: goto L_0x0026;
                case -1572042797: goto L_0x001c;
                case 1725137426: goto L_0x0012;
                case 1725424855: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x003c
        L_0x0008:
            java.lang.String r0 = "end_part"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 4
            goto L_0x003d
        L_0x0012:
            java.lang.String r0 = "end_flow"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 1
            goto L_0x003d
        L_0x001c:
            java.lang.String r0 = "cancel_flow"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 2
            goto L_0x003d
        L_0x0026:
            java.lang.String r0 = "start_part"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 3
            goto L_0x003d
        L_0x0031:
            java.lang.String r0 = "start_flow"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0007
            r0 = 0
            goto L_0x003d
        L_0x003c:
            r0 = -1
        L_0x003d:
            java.lang.String r1 = "PluginStatistic"
            switch(r0) {
                case 0: goto L_0x014b;
                case 1: goto L_0x00b4;
                case 2: goto L_0x0090;
                case 3: goto L_0x006e;
                case 4: goto L_0x004d;
                default: goto L_0x0042;
            }
        L_0x0042:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x016d
            java.lang.String r0 = "Select WRONG event in flow statistic!"
            android.util.Log.e(r1, r0)
            goto L_0x016d
        L_0x004d:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0057
            java.lang.String r0 = "sendPluginInstallSpeedStatistic: UBC_END_PART"
            android.util.Log.d(r1, r0)
        L_0x0057:
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x016d
            if (r10 == 0) goto L_0x016d
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            java.lang.Object r0 = r0.get(r11)
            com.baidu.ubc.Flow r0 = (com.baidu.ubc.Flow) r0
            r0.endSlot(r10)
            goto L_0x016d
        L_0x006e:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0078
            java.lang.String r0 = "sendPluginInstallSpeedStatistic: UBC_START_PART"
            android.util.Log.d(r1, r0)
        L_0x0078:
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x016d
            if (r10 == 0) goto L_0x016d
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            java.lang.Object r0 = r0.get(r11)
            com.baidu.ubc.Flow r0 = (com.baidu.ubc.Flow) r0
            r1 = 0
            r0.startSlot(r10, r1)
            goto L_0x016d
        L_0x0090:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x009a
            java.lang.String r0 = "sendPluginInstallSpeedStatistic: UBC_CANCEL_FLOW"
            android.util.Log.d(r1, r0)
        L_0x009a:
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x016d
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            java.lang.Object r0 = r0.get(r11)
            com.baidu.ubc.Flow r0 = (com.baidu.ubc.Flow) r0
            r0.cancel()
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            r0.remove(r11)
            goto L_0x016d
        L_0x00b4:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x00be
            java.lang.String r2 = "sendPluginInstallSpeedStatistic: UBC_END_FLOW"
            android.util.Log.d(r1, r2)
        L_0x00be:
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r2 = sFlowMap
            boolean r2 = r2.containsKey(r11)
            if (r2 == 0) goto L_0x016d
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r2 = sFlowMap
            java.lang.Object r2 = r2.get(r11)
            com.baidu.ubc.Flow r2 = (com.baidu.ubc.Flow) r2
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0142 }
            r3.<init>()     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r4 = "type"
            java.lang.String r5 = "aps_install"
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r4 = "from"
            java.lang.String r5 = "research"
            r3.put(r4, r5)     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r4 = "value"
            r3.put(r4, r11)     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r4 = "source"
            r3.put(r4, r12)     // Catch:{ JSONException -> 0x0142 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0142 }
            r4.<init>()     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r5 = "isWifi"
            java.lang.String r6 = "1"
            java.lang.String r7 = "0"
            if (r14 == 0) goto L_0x00fe
            r8 = r6
            goto L_0x00ff
        L_0x00fe:
            r8 = r7
        L_0x00ff:
            r4.put(r5, r8)     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r5 = "isPatch"
            if (r15 == 0) goto L_0x0107
            goto L_0x0108
        L_0x0107:
            r6 = r7
        L_0x0108:
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r5 = "ext"
            java.lang.String r6 = r4.toString()     // Catch:{ JSONException -> 0x0142 }
            r3.put(r5, r6)     // Catch:{ JSONException -> 0x0142 }
            if (r0 == 0) goto L_0x0131
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0142 }
            r0.<init>()     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r5 = "sendPluginInstallSpeedStatistic: value.json to String = "
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r5 = r3.toString()     // Catch:{ JSONException -> 0x0142 }
            java.lang.StringBuilder r0 = r0.append(r5)     // Catch:{ JSONException -> 0x0142 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0142 }
            android.util.Log.d(r1, r0)     // Catch:{ JSONException -> 0x0142 }
        L_0x0131:
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x0142 }
            r2.setValueWithDuration(r0)     // Catch:{ JSONException -> 0x0142 }
            r2.end()     // Catch:{ JSONException -> 0x0142 }
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap     // Catch:{ JSONException -> 0x0142 }
            r0.remove(r11)     // Catch:{ JSONException -> 0x0142 }
            goto L_0x014a
        L_0x0142:
            r0 = move-exception
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x014a
            r0.printStackTrace()
        L_0x014a:
            goto L_0x016d
        L_0x014b:
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x0155
            java.lang.String r0 = "sendPluginInstallSpeedStatistic: UBC_START_FLOW"
            android.util.Log.d(r1, r0)
        L_0x0155:
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto L_0x0162
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r0 = sFlowMap
            r0.remove(r11)
        L_0x0162:
            java.lang.String r0 = "462"
            com.baidu.ubc.Flow r0 = com.baidu.ubc.UBC.beginFlow(r0)
            java.util.Map<java.lang.String, com.baidu.ubc.Flow> r1 = sFlowMap
            r1.put(r11, r0)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.plugins.utils.PluginStatistic.sendPluginInstallSpeedStatistic(java.lang.String, java.lang.String, java.lang.String, long, boolean, boolean):void");
    }
}
