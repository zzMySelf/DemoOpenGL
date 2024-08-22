package com.baidu.swan.apps.core.prehandle;

import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.core.prelink.SwanPrelinkManager;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancookie.SwanCookieManager;

public final class LaunchEventController {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String TAG = "AppLaunchMessenger";
    private boolean mHasDispatchedEvent;

    private LaunchEventController() {
        this.mHasDispatchedEvent = false;
    }

    public static LaunchEventController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* Debug info: failed to restart local var, previous not found, register: 22 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x023c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void dispatchLaunchEvent(com.baidu.swan.apps.core.master.SwanAppMasterContainer r23, com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager r24, com.baidu.swan.apps.launch.model.SwanAppLaunchInfo r25, com.baidu.swan.apps.runtime.config.SwanAppConfigData r26, com.baidu.swan.apps.install.SwanAppBundleHelper.SwanAppLoadInfo r27, boolean r28, java.lang.String r29, java.lang.String r30) {
        /*
            r22 = this;
            r1 = r22
            r0 = r24
            r2 = r26
            r3 = r27
            r4 = r29
            monitor-enter(r22)
            boolean r5 = DEBUG     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x001e
            java.lang.String r6 = "AppLaunchMessenger"
            java.lang.String r7 = "dispatchLaunchEvent"
            android.util.Log.d(r6, r7)     // Catch:{ all -> 0x02fd }
            java.lang.String r6 = "SwanPrelink"
            java.lang.String r7 = "start dispatch launch event"
            android.util.Log.d(r6, r7)     // Catch:{ all -> 0x02fd }
        L_0x001e:
            boolean r6 = r1.mHasDispatchedEvent     // Catch:{ all -> 0x02fd }
            if (r6 == 0) goto L_0x002b
            if (r28 == 0) goto L_0x0029
            r5 = 14
            com.baidu.swan.apps.core.turbo.AppReadyHelper.updateAppReadyState(r5)     // Catch:{ all -> 0x02fd }
        L_0x0029:
            monitor-exit(r22)
            return
        L_0x002b:
            r6 = 1
            if (r28 == 0) goto L_0x0031
            com.baidu.swan.apps.core.turbo.AppReadyHelper.updateAppReadyState(r6)     // Catch:{ all -> 0x02fd }
        L_0x0031:
            java.lang.String r7 = r2.getPageType(r4)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.core.turbo.AppReadyEvent r8 = new com.baidu.swan.apps.core.turbo.AppReadyEvent     // Catch:{ all -> 0x02fd }
            r8.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r2.mOriginAppData     // Catch:{ all -> 0x02fd }
            r8.appConfig = r9     // Catch:{ all -> 0x02fd }
            if (r3 == 0) goto L_0x004d
            java.lang.String r9 = r3.mAppBundlePath     // Catch:{ all -> 0x02fd }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x02fd }
            if (r9 != 0) goto L_0x004d
            java.lang.String r9 = r3.mAppBundlePath     // Catch:{ all -> 0x02fd }
            r8.appPath = r9     // Catch:{ all -> 0x02fd }
            goto L_0x0072
        L_0x004d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r9.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r10 = r25.getAppId()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r25.getVersion()     // Catch:{ all -> 0x02fd }
            java.io.File r10 = com.baidu.swan.apps.install.SwanAppBundleHelper.ReleaseBundleHelper.getUnzipFolder(r10, r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r10 = r10.getPath()     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x02fd }
            java.lang.String r10 = java.io.File.separator     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02fd }
            r8.appPath = r9     // Catch:{ all -> 0x02fd }
        L_0x0072:
            java.lang.String r9 = r24.getWebViewId()     // Catch:{ all -> 0x02fd }
            r8.webviewId = r9     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = ""
            r8.viewMode = r9     // Catch:{ all -> 0x02fd }
            r8.pageUrl = r4     // Catch:{ all -> 0x02fd }
            boolean r9 = r25.isConsoleSwitch()     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x02fd }
            r8.sConsole = r9     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.runtime.SwanApp r9 = com.baidu.swan.apps.runtime.SwanApp.get()     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = com.baidu.swan.apps.core.turbo.AppReadyEvent.getRootPath(r9, r4)     // Catch:{ all -> 0x02fd }
            r8.rootPath = r9     // Catch:{ all -> 0x02fd }
            r8.pageType = r7     // Catch:{ all -> 0x02fd }
            if (r5 != 0) goto L_0x00a3
            com.baidu.swan.apps.lifecycle.SwanAppController r10 = com.baidu.swan.apps.lifecycle.SwanAppController.getInstance()     // Catch:{ all -> 0x02fd }
            boolean r10 = r10.isSupportDebug()     // Catch:{ all -> 0x02fd }
            if (r10 == 0) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r10 = 0
            goto L_0x00a4
        L_0x00a3:
            r10 = r6
        L_0x00a4:
            r8.showPerformancePanel = r10     // Catch:{ all -> 0x02fd }
            boolean r11 = r24.isT7WebView()     // Catch:{ all -> 0x02fd }
            r8.isT7Available = r11     // Catch:{ all -> 0x02fd }
            r8.slaveReady = r6     // Catch:{ all -> 0x02fd }
            com.baidu.swan.pms.model.PMSAppInfo r11 = r25.getPmsAppInfo()     // Catch:{ all -> 0x02fd }
            if (r11 == 0) goto L_0x00c0
            java.lang.String r12 = r11.userActionApis     // Catch:{ all -> 0x02fd }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x02fd }
            if (r12 != 0) goto L_0x00c0
            java.lang.String r12 = r11.userActionApis     // Catch:{ all -> 0x02fd }
            r8.userActionApis = r12     // Catch:{ all -> 0x02fd }
        L_0x00c0:
            boolean r12 = com.baidu.swan.apps.prepose.util.SwanAppDebugUtil.isUserDebug()     // Catch:{ all -> 0x02fd }
            if (r12 == 0) goto L_0x00cc
            java.lang.String r13 = com.baidu.swan.apps.console.debugger.UserDebugParams.getMasterPreloadFilePath()     // Catch:{ all -> 0x02fd }
            r8.preloadFile = r13     // Catch:{ all -> 0x02fd }
        L_0x00cc:
            android.os.Bundle r13 = r25.getExtraData()     // Catch:{ all -> 0x02fd }
            if (r13 == 0) goto L_0x00e0
            java.lang.String r14 = "extraData"
            java.lang.String r14 = r13.getString(r14)     // Catch:{ all -> 0x02fd }
            boolean r15 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x02fd }
            if (r15 != 0) goto L_0x00e0
            r8.extraData = r14     // Catch:{ all -> 0x02fd }
        L_0x00e0:
            if (r5 == 0) goto L_0x00eb
            java.lang.String r14 = "AppLaunchMessenger"
            java.lang.String r15 = r8.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.d(r14, r15)     // Catch:{ all -> 0x02fd }
        L_0x00eb:
            com.baidu.swan.apps.performance.HybridUbcFlow r14 = com.baidu.swan.apps.performance.SwanAppPerformanceUBC.requireSession()     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.performance.UbcFlowEvent r15 = new com.baidu.swan.apps.performance.UbcFlowEvent     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = "master_dispatch_start"
            r15.<init>(r9)     // Catch:{ all -> 0x02fd }
            r14.record((com.baidu.swan.apps.performance.UbcFlowEvent) r15)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.stable.SwanAppStabilityTracer r9 = com.baidu.swan.apps.stable.SwanAppStabilityTracer.getInstance()     // Catch:{ all -> 0x02fd }
            java.lang.String r14 = "master_dispatch_start"
            r9.recordTrace((java.lang.String) r14)     // Catch:{ all -> 0x02fd }
            r9 = r23
            r9.onPreAppReadyEventDispatch(r8)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime r14 = com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime.getInstance()     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.event.message.SwanAppCommonMessage r15 = com.baidu.swan.apps.core.turbo.AppReadyEvent.createAppReadyMessage(r8)     // Catch:{ all -> 0x02fd }
            r14.sendJSMessage(r15)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.adaptation.interfaces.ISwanAppHostEvent r14 = com.baidu.swan.apps.ioc.SwanAppRuntime.getSwanAppHostEvent()     // Catch:{ all -> 0x02fd }
            r14.onAppReady()     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime r14 = com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime.getInstance()     // Catch:{ all -> 0x02fd }
            boolean r15 = r8.isT7Available     // Catch:{ all -> 0x02fd }
            r14.updateT7Available(r15)     // Catch:{ all -> 0x02fd }
            java.lang.String r14 = r25.getRemoteDebug()     // Catch:{ all -> 0x02fd }
            boolean r14 = com.baidu.swan.apps.prepose.util.SwanAppDebugUtil.isRemoteDebug(r14)     // Catch:{ all -> 0x02fd }
            boolean r15 = r25.isLocalDebug()     // Catch:{ all -> 0x02fd }
            if (r14 == 0) goto L_0x013f
            com.baidu.swan.apps.console.debugger.remotedebug.RemoteDebugStatistic.appReadyStatistic()     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.console.debugger.remotedebug.RemoteDebugStatistic r6 = com.baidu.swan.apps.console.debugger.remotedebug.RemoteDebugStatistic.getInstance()     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = "appready"
            r6.handleEvent(r9)     // Catch:{ all -> 0x02fd }
            goto L_0x014a
        L_0x013f:
            if (r15 == 0) goto L_0x014a
            com.baidu.swan.apps.console.debugger.localdebug.LocalDebugStatistic r6 = com.baidu.swan.apps.console.debugger.localdebug.LocalDebugStatistic.getInstance()     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = "appready"
            r6.handleEvent(r9)     // Catch:{ all -> 0x02fd }
        L_0x014a:
            java.lang.String r6 = com.baidu.swan.apps.util.SwanAppUrlUtils.delAllParamsFromUrl(r29)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = com.baidu.swan.apps.scheme.actions.route.SwanAppPageAlias.checkRoutesPath(r6)     // Catch:{ all -> 0x02fd }
            r16 = r6
            com.baidu.swan.apps.lifecycle.SwanAppController r6 = com.baidu.swan.apps.lifecycle.SwanAppController.getInstance()     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.runtime.config.WindowConfig r6 = r6.getPageWindowConfig(r9)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.core.turbo.PageReadyEvent r17 = new com.baidu.swan.apps.core.turbo.PageReadyEvent     // Catch:{ all -> 0x02fd }
            r17.<init>()     // Catch:{ all -> 0x02fd }
            r18 = r17
            if (r3 == 0) goto L_0x017d
            r17 = r9
            java.lang.String r9 = r3.mAppBundlePath     // Catch:{ all -> 0x02fd }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x02fd }
            if (r9 != 0) goto L_0x017a
            java.lang.String r9 = r3.mAppBundlePath     // Catch:{ all -> 0x02fd }
            r3 = r18
            r3.appPath = r9     // Catch:{ all -> 0x02fd }
            r18 = r11
            r19 = r13
            goto L_0x01aa
        L_0x017a:
            r3 = r18
            goto L_0x0181
        L_0x017d:
            r17 = r9
            r3 = r18
        L_0x0181:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r9.<init>()     // Catch:{ all -> 0x02fd }
            r18 = r11
            java.lang.String r11 = r25.getAppId()     // Catch:{ all -> 0x02fd }
            r19 = r13
            java.lang.String r13 = r25.getVersion()     // Catch:{ all -> 0x02fd }
            java.io.File r11 = com.baidu.swan.apps.install.SwanAppBundleHelper.ReleaseBundleHelper.getUnzipFolder(r11, r13)     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r11.getPath()     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = java.io.File.separator     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02fd }
            r3.appPath = r9     // Catch:{ all -> 0x02fd }
        L_0x01aa:
            r3.pagePath = r4     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r6.onReachBottomDistance     // Catch:{ all -> 0x02fd }
            r3.onReachBottomDistance = r9     // Catch:{ all -> 0x02fd }
            r3.pageType = r7     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r8.rootPath     // Catch:{ all -> 0x02fd }
            r3.rootPath = r9     // Catch:{ all -> 0x02fd }
            boolean r9 = r25.isConsoleSwitch()     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x02fd }
            r3.sConsole = r9     // Catch:{ all -> 0x02fd }
            r3.showPerformancePanel = r10     // Catch:{ all -> 0x02fd }
            boolean r9 = r24.isT7WebView()     // Catch:{ all -> 0x02fd }
            r3.isT7Available = r9     // Catch:{ all -> 0x02fd }
            r9 = 1
            r3.isFirstPage = r9     // Catch:{ all -> 0x02fd }
            if (r12 == 0) goto L_0x01d3
            java.lang.String r9 = com.baidu.swan.apps.console.debugger.UserDebugParams.getSlavePreloadFilePath()     // Catch:{ all -> 0x02fd }
            r3.preloadFile = r9     // Catch:{ all -> 0x02fd }
        L_0x01d3:
            if (r14 == 0) goto L_0x01e0
            com.baidu.swan.apps.console.debugger.remotedebug.RemoteDebugStatistic r9 = com.baidu.swan.apps.console.debugger.remotedebug.RemoteDebugStatistic.getInstance()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "pageready"
            r9.handleEvent(r11)     // Catch:{ all -> 0x02fd }
            goto L_0x01ec
        L_0x01e0:
            if (r15 == 0) goto L_0x01ec
            com.baidu.swan.apps.console.debugger.localdebug.LocalDebugStatistic r9 = com.baidu.swan.apps.console.debugger.localdebug.LocalDebugStatistic.getInstance()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "pageready"
            r9.handleEvent(r11)     // Catch:{ all -> 0x02fd }
        L_0x01ec:
            if (r5 == 0) goto L_0x01f7
            java.lang.String r9 = "AppLaunchMessenger"
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.d(r9, r11)     // Catch:{ all -> 0x02fd }
        L_0x01f7:
            com.baidu.swan.apps.performance.HybridUbcFlow r9 = com.baidu.swan.apps.performance.SwanAppPerformanceUBC.requireSession()     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.performance.UbcFlowEvent r11 = new com.baidu.swan.apps.performance.UbcFlowEvent     // Catch:{ all -> 0x02fd }
            java.lang.String r13 = "slave_dispatch_start"
            r11.<init>(r13)     // Catch:{ all -> 0x02fd }
            r9.record((com.baidu.swan.apps.performance.UbcFlowEvent) r11)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.stable.SwanAppStabilityTracer r9 = com.baidu.swan.apps.stable.SwanAppStabilityTracer.getInstance()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "slave_dispatch_start"
            r9.recordTrace((java.lang.String) r11)     // Catch:{ all -> 0x02fd }
            r0.onPrePageReadyEventDispatch(r3)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.util.SwanAppRefererUtils.setSlaveWebviewReferer()     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.adaptation.webview.ISwanAppWebView r9 = r24.getWebView()     // Catch:{ all -> 0x02fd }
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r9.setDefaultViewSize(r11, r11, r4)     // Catch:{ all -> 0x02fd }
            r0.setPathWithQuery(r4)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime r9 = com.baidu.swan.apps.core.turbo.SwanAppCoreRuntime.getInstance()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r24.getWebViewId()     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.event.message.SwanAppCommonMessage r13 = com.baidu.swan.apps.core.turbo.PageReadyEvent.createPageReadyMessage(r3)     // Catch:{ all -> 0x02fd }
            r9.sendJSMessage(r11, r13)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r24.getWebViewId()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r3.pagePath     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.statistic.SwanAppLaunchUbc.updateArrivalSlavePath(r9, r11)     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x02dd
            java.lang.String r5 = "AppLaunchMessenger"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r9.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "app path: "
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r8.appPath     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.d(r5, r9)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = "AppLaunchMessenger"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r9.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "webviewId: "
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r24.getWebViewId()     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.d(r5, r9)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = "AppLaunchMessenger"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r9.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "pageUrl: "
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r4)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.d(r5, r9)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = "AppLaunchMessenger"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r9.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "pagePath: "
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r3.pagePath     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.d(r5, r9)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = "AppLaunchMessenger"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r9.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "onReachBottomDistance: "
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r3.onReachBottomDistance     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.d(r5, r9)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = "AppLaunchMessenger"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r9.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "sConsole:"
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = r3.sConsole     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r9 = r9.append(r11)     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.d(r5, r9)     // Catch:{ all -> 0x02fd }
        L_0x02dd:
            r1.afterLaunchEventSent(r2)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.adaptation.interfaces.ISwanExternalTransferStats r5 = com.baidu.swan.apps.ioc.SwanAppRuntime.getSwanExternalTransferStats()     // Catch:{ all -> 0x02fd }
            java.lang.String r9 = "mini_init_end"
            long r20 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = java.lang.String.valueOf(r20)     // Catch:{ all -> 0x02fd }
            r13 = 0
            r5.report(r9, r11, r13)     // Catch:{ all -> 0x02fd }
            com.baidu.swan.apps.performance.PerformanceObserverManager r5 = com.baidu.swan.apps.performance.PerformanceObserverManager.INSTANCE     // Catch:{ all -> 0x02fd }
            r5.dispatchLoadPackageEvent()     // Catch:{ all -> 0x02fd }
            r5 = 1
            r1.mHasDispatchedEvent = r5     // Catch:{ all -> 0x02fd }
            monitor-exit(r22)
            return
        L_0x02fd:
            r0 = move-exception
            monitor-exit(r22)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.core.prehandle.LaunchEventController.dispatchLaunchEvent(com.baidu.swan.apps.core.master.SwanAppMasterContainer, com.baidu.swan.apps.adaptation.webview.ISwanAppSlaveManager, com.baidu.swan.apps.launch.model.SwanAppLaunchInfo, com.baidu.swan.apps.runtime.config.SwanAppConfigData, com.baidu.swan.apps.install.SwanAppBundleHelper$SwanAppLoadInfo, boolean, java.lang.String, java.lang.String):void");
    }

    private void afterLaunchEventSent(SwanAppConfigData configData) {
        if (DEBUG) {
            Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
        }
        SwanPrelinkManager.getInstance().startPreLink(Swan.get().getAppId(), false);
        SwanCookieManager.getInstance().preInit();
    }

    public synchronized void reset() {
        this.mHasDispatchedEvent = false;
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final LaunchEventController INSTANCE = new LaunchEventController();

        private SingletonHolder() {
        }
    }
}
