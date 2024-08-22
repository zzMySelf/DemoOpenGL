package com.baidu.swan.apps.console.debugger.wirelessdebug;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.launch.model.SwanAppLaunchParams;
import com.baidu.swan.apps.launch.model.SwanAppProperties;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.scheme.UnitedSchemeSwanAppDispatcher;
import com.baidu.swan.apps.scheme.actions.SwanAppAction;
import com.baidu.swan.apps.statistic.SwanAppUBCStatistic;
import com.baidu.swan.apps.statistic.event.SwanAppUBCEvent;
import com.baidu.swan.apps.storage.sp.SwanAppSpHelper;
import com.baidu.swan.apps.toast.UniversalToast;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class WirelessDebugAction extends SwanAppAction {
    private static final String DATA_ERROR_URL = "errorURL";
    private static final String ERROR_PAGE_PARAM_IP = "404";
    public static final String LAUNCH_FROM = "adb-debug";
    private static final String MODULE_NAME = "/swanAPI/wirelessdebuglaunch";
    protected static final String TAG = "WirelessDebugAction";
    private static final int THREAD_POOL_SIZE = 4;
    private static final int TIME_OUT_MS = 1500;
    /* access modifiers changed from: private */
    public WirelessDebugModel mDebugModel;
    private int mThreadCompletionCount;
    private ExecutorService mThreadService;

    public WirelessDebugAction(UnitedSchemeSwanAppDispatcher dispatcher) {
        super(dispatcher, MODULE_NAME);
    }

    public boolean handle(Context context, UnitedSchemeEntity entity, CallbackHandler handler, SwanApp swanApp) {
        JSONObject params = UnitedSchemeUtility.optParamsAsJo(entity);
        if (params == null || params.length() <= 0) {
            SwanAppLog.e(TAG, "param is null");
            entity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        WirelessDebugModel obtainDebugModel = WirelessDebugModel.obtainDebugModel(params);
        this.mDebugModel = obtainDebugModel;
        if (obtainDebugModel == null || obtainDebugModel.isInvalid()) {
            if (DEBUG) {
                Log.e(TAG, "Wireless Debug params is invalid");
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        downloadBundle(context, entity, handler);
        return true;
    }

    private void downloadBundle(Context context, UnitedSchemeEntity entity, CallbackHandler handler) {
        int hostsCount;
        WirelessDebugAction wirelessDebugAction = this;
        File targetFile = WirelessDebugBundleHelper.getDebugBundleFile();
        if (targetFile.exists()) {
            targetFile.delete();
        }
        wirelessDebugAction.mThreadService = Executors.newFixedThreadPool(4);
        wirelessDebugAction.mThreadCompletionCount = 0;
        if (wirelessDebugAction.mDebugModel.mHostArray == null) {
            Context context2 = context;
        } else if (wirelessDebugAction.mDebugModel.mHostArray.length() <= 0) {
            Context context3 = context;
        } else {
            int hostsCount2 = wirelessDebugAction.mDebugModel.mHostArray.length();
            int i2 = 0;
            while (i2 < hostsCount2) {
                String debuggerUrl = wirelessDebugAction.mDebugModel.getDebuggerUrl(i2);
                if (TextUtils.isEmpty(debuggerUrl)) {
                    int i3 = wirelessDebugAction.mThreadCompletionCount + 1;
                    wirelessDebugAction.mThreadCompletionCount = i3;
                    if (i3 >= hostsCount2) {
                        SwanAppLog.e(TAG, "Hosts are invalid");
                        wirelessDebugAction.showErrorPage(context, "404");
                        hostsCount = hostsCount2;
                    } else {
                        Context context4 = context;
                        hostsCount = hostsCount2;
                    }
                } else {
                    Context context5 = context;
                    String wsUrl = wirelessDebugAction.mDebugModel.getWsUrl(i2);
                    ExecutorService executorService = wirelessDebugAction.mThreadService;
                    final Context context6 = context;
                    final String str = debuggerUrl;
                    final String str2 = wsUrl;
                    final File file = targetFile;
                    AnonymousClass2 r8 = r0;
                    final UnitedSchemeEntity unitedSchemeEntity = entity;
                    hostsCount = hostsCount2;
                    ExecutorService executorService2 = executorService;
                    final CallbackHandler callbackHandler = handler;
                    AnonymousClass2 r0 = new Runnable() {
                        public void run() {
                            WirelessDebugAction.this.startDownload(context6, str, str2, file, unitedSchemeEntity, callbackHandler);
                        }
                    };
                    executorService2.execute(r8);
                }
                i2++;
                wirelessDebugAction = this;
                hostsCount2 = hostsCount;
            }
            Context context7 = context;
            int i4 = hostsCount2;
            return;
        }
        final Context context8 = context;
        final File file2 = targetFile;
        final UnitedSchemeEntity unitedSchemeEntity2 = entity;
        final CallbackHandler callbackHandler2 = handler;
        ExecutorUtilsExt.postOnSerial(new Runnable() {
            public void run() {
                WirelessDebugAction wirelessDebugAction = WirelessDebugAction.this;
                wirelessDebugAction.startDownload(context8, wirelessDebugAction.mDebugModel.mAppUrl, WirelessDebugAction.this.mDebugModel.mWsUrl, file2, unitedSchemeEntity2, callbackHandler2);
            }
        }, TAG);
    }

    /* Debug info: failed to restart local var, previous not found, register: 5 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b4, code lost:
        if (r1 >= r5.mDebugModel.mHostArray.length()) goto L_0x00b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startDownload(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.io.File r9, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r10, com.baidu.searchbox.unitedscheme.CallbackHandler r11) {
        /*
            r5 = this;
            com.baidu.swan.network.manager.SwanHttpManager r0 = com.baidu.swan.network.manager.SwanHttpManager.getDefault()     // Catch:{ IOException -> 0x0096 }
            com.baidu.swan.network.builder.SwanGetRequestBuilder r0 = r0.getRequest()     // Catch:{ IOException -> 0x0096 }
            com.baidu.searchbox.http.request.HttpRequestBuilder r0 = r0.url(r7)     // Catch:{ IOException -> 0x0096 }
            com.baidu.searchbox.http.request.GetRequest$GetRequestBuilder r0 = (com.baidu.searchbox.http.request.GetRequest.GetRequestBuilder) r0     // Catch:{ IOException -> 0x0096 }
            r1 = 1500(0x5dc, float:2.102E-42)
            com.baidu.searchbox.http.request.HttpRequestBuilder r0 = r0.connectionTimeout(r1)     // Catch:{ IOException -> 0x0096 }
            com.baidu.searchbox.http.request.GetRequest$GetRequestBuilder r0 = (com.baidu.searchbox.http.request.GetRequest.GetRequestBuilder) r0     // Catch:{ IOException -> 0x0096 }
            com.baidu.searchbox.http.request.GetRequest r0 = r0.build()     // Catch:{ IOException -> 0x0096 }
            okhttp3.Response r0 = r0.executeSync()     // Catch:{ IOException -> 0x0096 }
            if (r0 == 0) goto L_0x0090
            int r1 = r0.code()     // Catch:{ all -> 0x0084 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x0090
            okhttp3.ResponseBody r1 = r0.body()     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x0090
            okhttp3.ResponseBody r1 = r0.body()     // Catch:{ all -> 0x0084 }
            java.io.InputStream r1 = r1.byteStream()     // Catch:{ all -> 0x0084 }
            com.baidu.swan.utils.SwanAppStreamUtils.streamToFile(r1, r9)     // Catch:{ all -> 0x0084 }
            com.baidu.swan.apps.launch.model.SwanAppLaunchParams$Impl r2 = r5.parseDebugParams()     // Catch:{ all -> 0x0084 }
            android.content.Intent r2 = com.baidu.swan.apps.launch.model.SwanAppLaunchParams.createLaunchParamsIntent(r6, r2)     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = "masterPreload"
            com.baidu.swan.apps.console.debugger.wirelessdebug.WirelessDebugModel r4 = r5.mDebugModel     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = r4.mMasterPreload     // Catch:{ all -> 0x0084 }
            r2.putExtra(r3, r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = "slavePreload"
            com.baidu.swan.apps.console.debugger.wirelessdebug.WirelessDebugModel r4 = r5.mDebugModel     // Catch:{ all -> 0x0084 }
            java.lang.String r4 = r4.mSlavePreload     // Catch:{ all -> 0x0084 }
            r2.putExtra(r3, r4)     // Catch:{ all -> 0x0084 }
            java.lang.String r3 = "extraWSUrl"
            r2.putExtra(r3, r8)     // Catch:{ all -> 0x0084 }
            r6.startActivity(r2)     // Catch:{ all -> 0x0084 }
            r3 = 0
            org.json.JSONObject r3 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r3)     // Catch:{ all -> 0x0084 }
            com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.callCallback((com.baidu.searchbox.unitedscheme.CallbackHandler) r11, (com.baidu.searchbox.unitedscheme.UnitedSchemeEntity) r10, (org.json.JSONObject) r3)     // Catch:{ all -> 0x0084 }
            java.util.concurrent.ExecutorService r3 = r5.mThreadService     // Catch:{ all -> 0x0084 }
            if (r3 == 0) goto L_0x006f
            r3.shutdownNow()     // Catch:{ all -> 0x0084 }
            r3 = 0
            r5.mThreadService = r3     // Catch:{ all -> 0x0084 }
        L_0x006f:
            boolean r3 = com.baidu.searchbox.process.ipc.util.ProcessUtils.isMainProcess()     // Catch:{ all -> 0x0084 }
            if (r3 != 0) goto L_0x0090
            boolean r3 = DEBUG     // Catch:{ all -> 0x0084 }
            if (r3 == 0) goto L_0x0080
            java.lang.String r3 = "WirelessDebugAction"
            java.lang.String r4 = "Suicide for reload."
            android.util.Log.d(r3, r4)     // Catch:{ all -> 0x0084 }
        L_0x0080:
            com.baidu.swan.apps.console.debugger.wirelessdebug.WirelessDebugger.finishAndTryRemoveTask()     // Catch:{ all -> 0x0084 }
            goto L_0x0090
        L_0x0084:
            r1 = move-exception
            if (r0 == 0) goto L_0x008f
            r0.close()     // Catch:{ all -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r2 = move-exception
            r1.addSuppressed(r2)     // Catch:{ IOException -> 0x0096 }
        L_0x008f:
            throw r1     // Catch:{ IOException -> 0x0096 }
        L_0x0090:
            if (r0 == 0) goto L_0x0095
            r0.close()     // Catch:{ IOException -> 0x0096 }
        L_0x0095:
            goto L_0x00c6
        L_0x0096:
            r0 = move-exception
            r1 = 1001(0x3e9, float:1.403E-42)
            org.json.JSONObject r1 = com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility.wrapCallbackParams(r1)
            r10.result = r1
            monitor-enter(r5)
            com.baidu.swan.apps.console.debugger.wirelessdebug.WirelessDebugModel r1 = r5.mDebugModel     // Catch:{ all -> 0x00c7 }
            org.json.JSONArray r1 = r1.mHostArray     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x00b6
            int r1 = r5.mThreadCompletionCount     // Catch:{ all -> 0x00c7 }
            int r1 = r1 + 1
            r5.mThreadCompletionCount = r1     // Catch:{ all -> 0x00c7 }
            com.baidu.swan.apps.console.debugger.wirelessdebug.WirelessDebugModel r2 = r5.mDebugModel     // Catch:{ all -> 0x00c7 }
            org.json.JSONArray r2 = r2.mHostArray     // Catch:{ all -> 0x00c7 }
            int r2 = r2.length()     // Catch:{ all -> 0x00c7 }
            if (r1 < r2) goto L_0x00c5
        L_0x00b6:
            java.lang.String r1 = "WirelessDebugAction"
            java.lang.String r2 = "Host IPs are invalid"
            com.baidu.swan.apps.console.SwanAppLog.e(r1, r2)     // Catch:{ all -> 0x00c7 }
            java.lang.String r1 = "404"
            r5.showErrorPage(r6, r1)     // Catch:{ all -> 0x00c7 }
            r5.onDownloadFail()     // Catch:{ all -> 0x00c7 }
        L_0x00c5:
            monitor-exit(r5)     // Catch:{ all -> 0x00c7 }
        L_0x00c6:
            return
        L_0x00c7:
            r1 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00c7 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.console.debugger.wirelessdebug.WirelessDebugAction.startDownload(android.content.Context, java.lang.String, java.lang.String, java.io.File, com.baidu.searchbox.unitedscheme.UnitedSchemeEntity, com.baidu.searchbox.unitedscheme.CallbackHandler):void");
    }

    private SwanAppLaunchParams.Impl parseDebugParams() {
        return (SwanAppLaunchParams.Impl) ((SwanAppLaunchParams.Impl) ((SwanAppLaunchParams.Impl) new SwanAppLaunchParams.Impl().setAppId(this.mDebugModel.mAppKey)).setDebug(false)).setNotInHistory(this.mDebugModel.mNotInHistory);
    }

    private void showErrorPage(Context context, String errorCode) {
        String errorUrl = SwanAppSpHelper.getInstance().getString("errorURL", "");
        if (TextUtils.isEmpty(errorUrl)) {
            UniversalToast.makeText(context, (CharSequence) "IPs are invalid ：" + errorCode).showToast();
        } else {
            SchemeRouter.invoke(context, SchemeConfig.getSchemeHead() + "://v1/easybrowse/open?url=" + getEncodeValue(errorUrl + GameCenterUtils.SCHEME_SWAN_SUFFIX + errorCode));
        }
    }

    private String getEncodeValue(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (!DEBUG) {
                return value;
            }
            Log.e(TAG, "url encode fail", e2);
            return value;
        }
    }

    private void onDownloadFail() {
        SwanAppProperties launchParams = Swan.get().getApp().getInfo();
        SwanAppUBCEvent event = new SwanAppUBCEvent();
        event.setDataByLaunchParams(launchParams);
        event.mFrom = SwanAppUBCStatistic.getUBCFrom(launchParams.getAppFrameType());
        event.fillLaunchId(launchParams.getLaunchId());
        event.mType = "launch";
        event.mSource = LAUNCH_FROM;
        event.mValue = "download_fail";
        SwanAppUBCStatistic.onEvent(event);
    }
}
