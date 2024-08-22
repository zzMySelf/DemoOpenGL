package com.baidu.swan.apps.scheme.intercept;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.launch.AutoPreviewDeduplicateDelegation;
import com.baidu.swan.apps.launch.LaunchAction;
import com.baidu.swan.apps.performance.SwanAppPerformanceUBC;
import com.baidu.swan.apps.process.messaging.channel.SwanAppMessageChannel;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.event.SwanAppStabilityEvent;
import com.baidu.swan.apps.trace.ErrCode;
import com.baidu.swan.apps.trace.Tracer;
import com.baidu.swan.apps.util.SwanAppAPIUtils;
import com.baidu.swan.apps.util.SwanAppUrlUtils;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.pms.PMS;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.PMSRuntime;
import com.baidu.swan.pms.callback.GetOpenBundleIdCallback;
import com.baidu.swan.pms.node.host.HostNodeDataManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanAppLaunchInterceptor extends UnitedSchemeBaseInterceptor {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final Set<String> DEL_PARAMS_SET;
    private static final String EXTRA_DATA = "extraData";
    private static final String LAUNCH_INTERCEPTOR_NAME = "aiapps_launch_interceptor";
    private static final String LAUNCH_INTERNAL_KEY_ABTEST = "abtest";
    private static final String LAUNCH_INTERNAL_KEY_APPICON = "appIcon";
    private static final String LAUNCH_INTERNAL_KEY_CALLBACK = "callback";
    private static final String LAUNCH_INTERNAL_KEY_CB = "cb";
    private static final String LAUNCH_INTERNAL_KEY_DOWNLOADURL = "downloadUrl";
    private static final String LAUNCH_INTERNAL_KEY_HOST = "host";
    public static final String LAUNCH_INTERNAL_KEY_LAUNCH_TYPE = "launchType";
    private static final String LAUNCH_INTERNAL_KEY_LOGARGS = "logargs";
    private static final String LAUNCH_INTERNAL_KEY_NEEDLOG = "needlog";
    private static final String LAUNCH_INTERNAL_KEY_OAUTHTYPE = "oauthType";
    private static final String LAUNCH_INTERNAL_KEY_PORT = "port";
    private static final String LAUNCH_INTERNAL_KEY_SWANINFO = "_swaninfo";
    private static final String LAUNCH_INTERNAL_KEY_THIRD_EXT = "third_ext";
    private static final String LAUNCH_INTERNAL_KEY_UDID = "udid";
    private static final String LAUNCH_INTERNAL_KEY_UPGRADE = "upgrade";
    private static final String LAUNCH_INTERNAL_KEY_WEBGAMEURL = "webGameUrl";
    public static final String LAUNCH_INTERNAL_LAUNCH_TYPE_MINI = "mini";
    private static final String LAUNCH_INTERNAL_PARAMS_KEY = "_baiduboxapp";
    private static final String LAUNCH_SCHEME_HOST = "swan";
    private static final String PARAM_CLICK = "click";
    private static final String PARAM_CLICK_ID = "clkid";
    private static final String PARAM_SEARCH_ID = "searchid";
    private static final String PARAM_SEARCH_URL = "url";
    private static final String PARAM_VELOCE = "veloce";
    private static final String PARAM_VELOCE_START_TIME = "starttime";
    private static final String PROJECT_ID = "projectId";
    private static final String QUERY_SEPARATOR = "?";
    private static final String TAG = "SwanLaunchInterceptor";
    private static final String TOOL_IP = "tip";
    private static final String TOOL_PORT = "tport";

    static {
        HashSet hashSet = new HashSet();
        DEL_PARAMS_SET = hashSet;
        hashSet.add("_baiduboxapp");
        hashSet.add("callback");
        hashSet.add("upgrade");
        hashSet.add("_naExtParams");
        hashSet.add(LAUNCH_INTERNAL_KEY_OAUTHTYPE);
        hashSet.add("abtest");
        hashSet.add("third_ext");
        hashSet.add(LAUNCH_INTERNAL_KEY_WEBGAMEURL);
        hashSet.add("appIcon");
        hashSet.add("downloadUrl");
        hashSet.add("cb");
        hashSet.add(LAUNCH_INTERNAL_KEY_UDID);
        hashSet.add("host");
        hashSet.add("port");
        hashSet.add(LAUNCH_INTERNAL_KEY_SWANINFO);
        hashSet.add(LAUNCH_INTERNAL_KEY_NEEDLOG);
        hashSet.add("logargs");
    }

    public String getInterceptorName() {
        return LAUNCH_INTERCEPTOR_NAME;
    }

    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        return launchByScheme((SwanLauncher.EmbeddedAppLaunchHandler) null, entity, handler, "");
    }

    public static boolean launchByScheme(SwanLauncher.EmbeddedAppLaunchHandler embeddedAppLaunchHandler, UnitedSchemeEntity entity, CallbackHandler handler, String embedId) {
        String navi;
        SwanLauncher.EmbeddedAppLaunchHandler embeddedAppLaunchHandler2 = embeddedAppLaunchHandler;
        UnitedSchemeEntity unitedSchemeEntity = entity;
        Uri uri = entity.getUri();
        if (uri == null) {
            CallbackHandler callbackHandler = handler;
        } else if (!TextUtils.equals(uri.getHost(), "swan")) {
            CallbackHandler callbackHandler2 = handler;
        } else if (entity.isOnlyVerify()) {
            if (embeddedAppLaunchHandler2 != null) {
                embeddedAppLaunchHandler2.onFail("only verify");
            }
            return true;
        } else {
            String appId = SwanAppUrlUtils.getAppId(uri);
            if (DEBUG) {
                Log.d(TAG, "mAppId: " + appId);
            }
            if (TextUtils.isEmpty(appId)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ErrCode errCode = new ErrCode().feature(1).error(1).detail("appId is empty");
                Tracer.get().record(errCode);
                SwanAppUBCStatistic.onStability(new SwanAppStabilityEvent().from(SwanAppUBCStatistic.getUBCFrom(0)).errCode(errCode).addInfo("scheme", uri.toString()));
                SwanAppPerformanceUBC.recordLaunchFailed(errCode);
                if (embeddedAppLaunchHandler2 != null) {
                    embeddedAppLaunchHandler2.onFail("appId is empty");
                }
                return true;
            }
            String schema = uri.toString();
            SwanAppLog.i(TAG, "launch scheme = " + schema);
            String jsonString = unitedSchemeEntity.getParam("_baiduboxapp");
            if (!TextUtils.isEmpty(jsonString)) {
                try {
                    JSONObject object = new JSONObject(jsonString);
                    if (TextUtils.equals(object.optString("launchType"), "mini")) {
                        SwanAppRuntime.getCardIoc().processCardScheme(schema);
                        return true;
                    }
                    String navi2 = object.optString("navi");
                    if (object.optBoolean(LaunchAction.SWAN_APP_AUTO_PREVIEW) && ProcessUtils.isMainProcess()) {
                        Bundle bundle = new Bundle();
                        bundle.putString("srcAppId", appId);
                        SwanAppMessageChannel.sendMessageToAllClient(bundle, AutoPreviewDeduplicateDelegation.class);
                    }
                    navi = navi2;
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    navi = null;
                }
            } else {
                navi = null;
            }
            boolean shouldTransformBundleId = HostNodeDataManager.getInstance().shouldTransformBundleId(!SwanAppUtils.isBaiduBoxApp());
            if (!shouldTransformBundleId || !TextUtils.equals(navi, "naviTo")) {
                boolean z = shouldTransformBundleId;
                launchSwanApp(embeddedAppLaunchHandler, uri, appId, jsonString, entity, embedId);
            } else if (!PMSConstants.isPmsBdtlsEnabled(PMSRuntime.getPMSContext())) {
                SwanAppLog.e(TAG, "STOP :: Not Support BDTLS");
                if (embeddedAppLaunchHandler2 != null) {
                    embeddedAppLaunchHandler2.onFail("not support bdtls");
                }
                return false;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(appId);
                final SwanLauncher.EmbeddedAppLaunchHandler embeddedAppLaunchHandler3 = embeddedAppLaunchHandler;
                final String str = appId;
                final Uri uri2 = uri;
                AnonymousClass1 r11 = r1;
                final String str2 = jsonString;
                String str3 = schema;
                String schema2 = Swan.get().getApp().getAppKey();
                final UnitedSchemeEntity unitedSchemeEntity2 = entity;
                boolean z2 = shouldTransformBundleId;
                ArrayList arrayList2 = arrayList;
                final String str4 = embedId;
                AnonymousClass1 r1 = new GetOpenBundleIdCallback() {
                    public void onResult(Map<String, String> keyMap) {
                        if (keyMap == null) {
                            SwanLauncher.EmbeddedAppLaunchHandler embeddedAppLaunchHandler = SwanLauncher.EmbeddedAppLaunchHandler.this;
                            if (embeddedAppLaunchHandler != null) {
                                embeddedAppLaunchHandler.onFail("pms unknown error");
                                return;
                            }
                            return;
                        }
                        SwanAppLaunchInterceptor.launchSwanApp(SwanLauncher.EmbeddedAppLaunchHandler.this, uri2, keyMap.get(str), str2, unitedSchemeEntity2, str4);
                    }

                    public void onFail(Exception e2) {
                        SwanLauncher.EmbeddedAppLaunchHandler embeddedAppLaunchHandler = SwanLauncher.EmbeddedAppLaunchHandler.this;
                        if (embeddedAppLaunchHandler != null) {
                            embeddedAppLaunchHandler.onFail("pms unknown error");
                        }
                        if (SwanAppLaunchInterceptor.DEBUG) {
                            Log.e(SwanAppLaunchInterceptor.TAG, "getOpenBundleId", e2);
                        }
                    }
                };
                PMS.getOpenBundleId(arrayList2, schema2, r11);
            }
            LaunchAction.doLaunchStatusCallback(navi, appId, handler, unitedSchemeEntity, unitedSchemeEntity.getParam("cb"));
            return true;
        }
        if (embeddedAppLaunchHandler2 != null) {
            embeddedAppLaunchHandler2.onFail("uri error");
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02ee  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0352  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void launchSwanApp(com.baidu.swan.apps.env.launch.SwanLauncher.EmbeddedAppLaunchHandler r27, android.net.Uri r28, java.lang.String r29, java.lang.String r30, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r31, java.lang.String r32) {
        /*
            r1 = r27
            r2 = r28
            r3 = r29
            r4 = r31
            java.lang.String r0 = "third_ext"
            java.lang.String r5 = "aiapp_abtest_info"
            java.lang.String r6 = "ubc"
            java.lang.String r7 = "srcAppPage"
            java.lang.String r8 = "srcAppId"
            java.lang.String r9 = "extraData"
            java.lang.String r10 = getEncodeQuery(r28)
            boolean r11 = DEBUG
            java.lang.String r12 = "SwanLaunchInterceptor"
            if (r11 == 0) goto L_0x0039
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "query: "
            java.lang.StringBuilder r13 = r13.append(r14)
            java.lang.StringBuilder r13 = r13.append(r10)
            java.lang.String r13 = r13.toString()
            android.util.Log.d(r12, r13)
        L_0x0039:
            r13 = 1
            java.lang.String r14 = com.baidu.swan.apps.util.SwanAppUrlUtils.getPagePath(r3, r2, r13)
            if (r11 == 0) goto L_0x0057
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r13 = "pagePath: "
            java.lang.StringBuilder r13 = r15.append(r13)
            java.lang.StringBuilder r13 = r13.append(r14)
            java.lang.String r13 = r13.toString()
            android.util.Log.d(r12, r13)
        L_0x0057:
            java.lang.String r13 = com.baidu.swan.apps.env.launch.SwanLauncher.generateLaunchId()
            java.lang.String r15 = r28.toString()
            r16 = r15
            java.lang.String r15 = "_naExtParams"
            java.lang.String r1 = r2.getQueryParameter(r15)
            boolean r17 = android.text.TextUtils.isEmpty(r1)
            if (r17 != 0) goto L_0x0074
            java.lang.String r16 = getDeleteQuerySchema(r28)
            r2 = r16
            goto L_0x0076
        L_0x0074:
            r2 = r16
        L_0x0076:
            r16 = r15
            com.baidu.swan.apps.launch.model.SwanAppLaunchParams$Impl r15 = new com.baidu.swan.apps.launch.model.SwanAppLaunchParams$Impl
            r15.<init>()
            com.baidu.swan.apps.launch.model.SwanAppProperties r15 = r15.setAppId(r3)
            com.baidu.swan.apps.launch.model.SwanAppLaunchParams$Impl r15 = (com.baidu.swan.apps.launch.model.SwanAppLaunchParams.Impl) r15
            com.baidu.swan.apps.launch.model.SwanAppProperties r15 = r15.setLaunchScheme(r2)
            com.baidu.swan.apps.launch.model.SwanAppLaunchParams$Impl r15 = (com.baidu.swan.apps.launch.model.SwanAppLaunchParams.Impl) r15
            com.baidu.swan.apps.launch.model.SwanAppProperties r15 = r15.setLaunchId(r13)
            com.baidu.swan.apps.launch.model.SwanAppLaunchParams$Impl r15 = (com.baidu.swan.apps.launch.model.SwanAppLaunchParams.Impl) r15
            boolean r17 = android.text.TextUtils.isEmpty(r14)
            if (r17 != 0) goto L_0x00ba
            boolean r17 = android.text.TextUtils.isEmpty(r10)
            if (r17 != 0) goto L_0x00ba
            r17 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r14)
            r18 = r13
            java.lang.String r13 = "?"
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.StringBuilder r2 = r2.append(r10)
            java.lang.String r2 = r2.toString()
            r15.setPage(r2)
            goto L_0x00c7
        L_0x00ba:
            r17 = r2
            r18 = r13
            boolean r2 = android.text.TextUtils.isEmpty(r14)
            if (r2 != 0) goto L_0x00c7
            r15.setPage(r14)
        L_0x00c7:
            java.lang.String r2 = "default"
            r15.setLaunchAnimation(r2)
            r13 = 0
            r15.setLockScreenLaunchPath(r13)
            boolean r13 = android.text.TextUtils.isEmpty(r30)
            if (r13 != 0) goto L_0x0290
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x026c }
            r19 = r10
            r10 = r30
            r13.<init>(r10)     // Catch:{ JSONException -> 0x0268 }
            r20 = 0
            if (r11 == 0) goto L_0x00ed
            long r22 = java.lang.System.nanoTime()     // Catch:{ JSONException -> 0x00e8 }
            goto L_0x00ef
        L_0x00e8:
            r0 = move-exception
            r26 = r1
            goto L_0x0271
        L_0x00ed:
            r22 = r20
        L_0x00ef:
            com.baidu.swan.apps.stability.SwanAppStabilityDataUtil.parseConfig(r13, r3)     // Catch:{ JSONException -> 0x0268 }
            if (r11 == 0) goto L_0x0114
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0268 }
            r3.<init>()     // Catch:{ JSONException -> 0x0268 }
            java.lang.String r10 = "SwanAppStabilityConfig#parseConfig 耗时(ns): "
            java.lang.StringBuilder r3 = r3.append(r10)     // Catch:{ JSONException -> 0x0268 }
            long r24 = java.lang.System.nanoTime()     // Catch:{ JSONException -> 0x0268 }
            r10 = r0
            r26 = r1
            long r0 = r24 - r22
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0266 }
            android.util.Log.d(r12, r0)     // Catch:{ JSONException -> 0x0266 }
            goto L_0x0117
        L_0x0114:
            r10 = r0
            r26 = r1
        L_0x0117:
            java.lang.String r0 = "from"
            java.lang.String r0 = r13.optString(r0)     // Catch:{ JSONException -> 0x0266 }
            r15.setLaunchFrom(r0)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r0 = "notinhis"
            java.lang.String r0 = r13.optString(r0)     // Catch:{ JSONException -> 0x0266 }
            r15.setNotInHistory(r0)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r0 = "subscribeWithoutClick"
            java.lang.String r0 = r13.optString(r0)     // Catch:{ JSONException -> 0x0266 }
            r15.setSubscribeWithoutClick(r0)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r0 = "runtimeConfig"
            org.json.JSONObject r0 = r13.optJSONObject(r0)     // Catch:{ JSONException -> 0x0266 }
            r15.setRuntimeConfig(r0)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r0 = "appearanceAnimation"
            java.lang.String r0 = r13.optString(r0, r2)     // Catch:{ JSONException -> 0x0266 }
            r15.setLaunchAnimation(r0)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r0 = "lingjing_type"
            int r0 = r13.optInt(r0)     // Catch:{ JSONException -> 0x0266 }
            r15.setLingJingType(r0)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r0 = "ext"
            org.json.JSONObject r0 = r13.optJSONObject(r0)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r1 = r13.optString(r8)     // Catch:{ JSONException -> 0x0266 }
            r15.putExtraData((java.lang.String) r8, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0266 }
            com.baidu.swan.apps.runtime.SwanApp r1 = com.baidu.swan.apps.runtime.SwanApp.getOrNull()     // Catch:{ JSONException -> 0x0266 }
            if (r1 == 0) goto L_0x01aa
            com.baidu.swan.apps.runtime.SwanApp r1 = com.baidu.swan.apps.runtime.SwanApp.getOrNull()     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r1 = r1.getAppKey()     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r2 = "srcAppKey"
            r15.putExtraData((java.lang.String) r2, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0266 }
            com.baidu.swan.apps.runtime.SwanApp r2 = com.baidu.swan.apps.runtime.SwanApp.getOrNull()     // Catch:{ JSONException -> 0x0266 }
            com.baidu.swan.apps.launch.model.SwanAppLaunchInfo$Impl r2 = r2.getInfo()     // Catch:{ JSONException -> 0x0266 }
            int r2 = r2.getType()     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r3 = "srcPkgType"
            r8 = r5
            long r4 = (long) r2     // Catch:{ JSONException -> 0x0266 }
            r15.putExtraData((java.lang.String) r3, (long) r4)     // Catch:{ JSONException -> 0x0266 }
            if (r11 == 0) goto L_0x01ab
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0266 }
            r3.<init>()     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r4 = "srcAppKey = "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ JSONException -> 0x0266 }
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r4 = "  ,srcPkgType = "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ JSONException -> 0x0266 }
            java.lang.StringBuilder r3 = r3.append(r2)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x0266 }
            android.util.Log.d(r12, r3)     // Catch:{ JSONException -> 0x0266 }
            goto L_0x01ab
        L_0x01aa:
            r8 = r5
        L_0x01ab:
            boolean r1 = r13.isNull(r9)     // Catch:{ JSONException -> 0x0266 }
            if (r1 != 0) goto L_0x01b8
            java.lang.String r1 = r13.optString(r9)     // Catch:{ JSONException -> 0x0266 }
            r15.putExtraData((java.lang.String) r9, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0266 }
        L_0x01b8:
            java.lang.String r1 = r13.optString(r7)     // Catch:{ JSONException -> 0x0266 }
            r15.putExtraData((java.lang.String) r7, (java.lang.String) r1)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r1 = "sysExt"
            java.lang.String r1 = r13.optString(r1)     // Catch:{ JSONException -> 0x0266 }
            org.json.JSONObject r2 = com.baidu.swan.apps.util.SwanAppJSONUtils.parseString(r1)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r3 = "sessionId"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ JSONException -> 0x0266 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0266 }
            if (r4 == 0) goto L_0x01dd
            java.lang.String r4 = com.baidu.swan.apps.util.SwanAppUtils.generateSessionId()     // Catch:{ JSONException -> 0x0266 }
            r3 = r4
        L_0x01dd:
            r15.setSessionId(r3)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r4 = "rootSource"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x0266 }
            r15.setRootSource(r4)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r5 = "locking"
            boolean r5 = r13.optBoolean(r5)     // Catch:{ JSONException -> 0x0266 }
            if (r5 == 0) goto L_0x0203
            java.lang.String r7 = com.baidu.swan.apps.util.SwanAppUrlUtils.delParamsAndFileSeparator(r14)     // Catch:{ JSONException -> 0x0266 }
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0266 }
            if (r9 == 0) goto L_0x01ff
            java.lang.String r9 = java.io.File.separator     // Catch:{ JSONException -> 0x0266 }
            goto L_0x0200
        L_0x01ff:
            r9 = r7
        L_0x0200:
            r15.setLockScreenLaunchPath(r9)     // Catch:{ JSONException -> 0x0266 }
        L_0x0203:
            org.json.JSONObject r7 = r13.optJSONObject(r6)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r9 = r15.getLaunchFrom()     // Catch:{ JSONException -> 0x0266 }
            org.json.JSONObject r9 = com.baidu.swan.utils.ParserUtils.parseUBC(r9, r7)     // Catch:{ JSONException -> 0x0266 }
            r7 = r9
            if (r7 == 0) goto L_0x0219
            java.lang.String r9 = r7.toString()     // Catch:{ JSONException -> 0x0266 }
            r15.putExtraData((java.lang.String) r6, (java.lang.String) r9)     // Catch:{ JSONException -> 0x0266 }
        L_0x0219:
            if (r0 == 0) goto L_0x0242
            java.lang.String r6 = "clkid"
            java.lang.String r6 = r0.optString(r6)     // Catch:{ JSONException -> 0x0266 }
            r15.setClickId(r6)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r6 = r0.optString(r8)     // Catch:{ JSONException -> 0x0266 }
            r15.putExtraData((java.lang.String) r8, (java.lang.String) r6)     // Catch:{ JSONException -> 0x0266 }
            r6 = r10
            java.lang.String r8 = r0.optString(r6)     // Catch:{ JSONException -> 0x0266 }
            r15.putExtraData((java.lang.String) r6, (java.lang.String) r8)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r6 = "click_time"
            java.lang.String r8 = "click"
            r9 = -1
            long r8 = r0.optLong(r8, r9)     // Catch:{ JSONException -> 0x0266 }
            r15.putExtraData((java.lang.String) r6, (long) r8)     // Catch:{ JSONException -> 0x0266 }
        L_0x0242:
            java.lang.String r6 = "veloce"
            java.lang.String r6 = r13.optString(r6)     // Catch:{ JSONException -> 0x0266 }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0266 }
            if (r8 != 0) goto L_0x0265
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0266 }
            r8.<init>(r6)     // Catch:{ JSONException -> 0x0266 }
            java.lang.String r9 = "starttime"
            long r8 = r8.optLong(r9)     // Catch:{ JSONException -> 0x0266 }
            int r10 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1))
            if (r10 <= 0) goto L_0x0265
            java.lang.String r10 = "veloce_start_time"
            r15.putLong(r10, r8)     // Catch:{ JSONException -> 0x0266 }
        L_0x0265:
            goto L_0x0294
        L_0x0266:
            r0 = move-exception
            goto L_0x0271
        L_0x0268:
            r0 = move-exception
            r26 = r1
            goto L_0x0271
        L_0x026c:
            r0 = move-exception
            r26 = r1
            r19 = r10
        L_0x0271:
            boolean r1 = DEBUG
            if (r1 == 0) goto L_0x0294
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getLaunchFrom failed: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = android.util.Log.getStackTraceString(r0)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r12, r1)
            goto L_0x0294
        L_0x0290:
            r26 = r1
            r19 = r10
        L_0x0294:
            java.lang.String r0 = "tip"
            r1 = r31
            java.lang.String r0 = r1.getParam(r0)
            java.lang.String r2 = "tool_ip"
            r15.putString(r2, r0)
            java.lang.String r0 = "tport"
            java.lang.String r0 = r1.getParam(r0)
            java.lang.String r2 = "tool_port"
            r15.putString(r2, r0)
            java.lang.String r0 = "projectId"
            java.lang.String r2 = r1.getParam(r0)
            r15.putString(r0, r2)
            java.lang.String r0 = "fromHost"
            java.lang.String r2 = r1.getParam(r0)
            r15.putString(r0, r2)
            java.lang.String r0 = "spuId"
            java.lang.String r2 = r1.getParam(r0)
            r15.putString(r0, r2)
            java.lang.String r0 = "contentId"
            java.lang.String r2 = r1.getParam(r0)
            r15.putString(r0, r2)
            java.lang.String r0 = "swan_in_main_process"
            java.lang.String r2 = r1.getParam(r0)
            java.lang.String r3 = "1"
            boolean r3 = android.text.TextUtils.equals(r3, r2)
            r15.putBoolean(r0, r3)
            r3 = 0
            boolean r4 = android.text.TextUtils.isEmpty(r26)
            if (r4 != 0) goto L_0x02fc
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            r3 = r4
            r5 = r16
            r4 = r26
            r3.putString(r5, r4)
            goto L_0x02fe
        L_0x02fc:
            r4 = r26
        L_0x02fe:
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x0322
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "launchParams: "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r15)
            java.lang.String r6 = " \n_naExtParmas: "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r4)
            java.lang.String r5 = r5.toString()
            android.util.Log.d(r12, r5)
        L_0x0322:
            boolean r5 = android.text.TextUtils.isEmpty(r32)
            if (r5 != 0) goto L_0x0334
            java.lang.String r5 = "embed_id"
            r6 = r32
            r15.putString(r5, r6)
            r5 = 1
            r15.putBoolean(r0, r5)
            goto L_0x0336
        L_0x0334:
            r6 = r32
        L_0x0336:
            java.lang.String r0 = r15.getRuntimeConfig()
            if (r0 == 0) goto L_0x0352
            java.lang.String r0 = r15.getRuntimeConfig()
            boolean r0 = moveHalfAppTaskToFront(r0)
            if (r0 == 0) goto L_0x0352
            r5 = r4
            r4 = r27
            if (r4 == 0) goto L_0x0351
            java.lang.String r0 = "move half app task to front"
            r4.onFail(r0)
        L_0x0351:
            return
        L_0x0352:
            r5 = r4
            r4 = r27
            com.baidu.swan.apps.env.launch.SwanLauncher r0 = com.baidu.swan.apps.env.launch.SwanLauncher.getInstance()
            r0.launchByPropertys(r4, r15, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.scheme.intercept.SwanAppLaunchInterceptor.launchSwanApp(com.baidu.swan.apps.env.launch.SwanLauncher$EmbeddedAppLaunchHandler, android.net.Uri, java.lang.String, java.lang.String, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, java.lang.String):void");
    }

    private static boolean moveHalfAppTaskToFront(String runtimeConfig) {
        Context context;
        ActivityManager activityManager;
        try {
            int taskId = new JSONObject(runtimeConfig).optInt("curHalfAppTaskId", -1);
            if (taskId < 0 || !SwanAppAPIUtils.hasLollipop() || (context = SwanAppRuntime.getAppContext()) == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
                return false;
            }
            try {
                List<ActivityManager.AppTask> appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.isEmpty()) {
                    return false;
                }
                boolean isTaskAlive = false;
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    try {
                        ActivityManager.RecentTaskInfo recentTaskInfo = it.next().getTaskInfo();
                        if (recentTaskInfo != null) {
                            if (Build.VERSION.SDK_INT < 29) {
                                if (recentTaskInfo.id == taskId) {
                                    isTaskAlive = true;
                                    break;
                                }
                            } else if (recentTaskInfo.taskId == taskId) {
                                isTaskAlive = true;
                                break;
                            }
                        }
                    } catch (Exception e2) {
                        if (DEBUG) {
                            Log.e(TAG, "getTaskId", e2);
                        }
                    }
                }
                if (!isTaskAlive) {
                    return false;
                }
                try {
                    activityManager.moveTaskToFront(taskId, 2, (Bundle) null);
                    return true;
                } catch (Exception e3) {
                    SwanAppLog.e(TAG, "moveTaskToFront", e3);
                    return false;
                }
            } catch (Exception ex) {
                SwanAppLog.logToFile(TAG, "#getAppTasks error", ex);
                return false;
            }
        } catch (JSONException e4) {
            SwanAppLog.d(TAG, Log.getStackTraceString(e4));
            return false;
        }
    }

    private String getQuery(Uri uri) {
        return SwanAppUrlUtils.deleteQueryParam(uri.getQuery(), DEL_PARAMS_SET);
    }

    private static String getEncodeQuery(Uri uri) {
        return SwanAppUrlUtils.deleteQueryParam(uri.getEncodedQuery(), DEL_PARAMS_SET);
    }

    private static String getDeleteQuerySchema(Uri uri) {
        if (uri == null) {
            return "";
        }
        Set<String> deleteParams = new HashSet<>();
        deleteParams.add("_naExtParams");
        return SwanAppUrlUtils.getDeleteSchema(uri, deleteParams);
    }

    private String getLaunchFrom(UnitedSchemeEntity entity) {
        String jsonString = entity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(jsonString)) {
            return null;
        }
        try {
            return new JSONObject(jsonString).optString("from");
        } catch (JSONException jsonEx) {
            if (DEBUG) {
                Log.d(TAG, "getLaunchFrom failed: " + Log.getStackTraceString(jsonEx));
            }
            return null;
        }
    }
}
