package com.baidu.swan.card.card.core;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.baidu.swan.card.card.core.SwanCardCoreRuntime;
import com.baidu.swan.card.launch.forbidden.CardPageForbiddenManager;
import com.baidu.swan.card.launch.model.SwanCoreVersion;
import com.baidu.swan.card.render.engine.event.JSEventDispatcher;
import com.baidu.swan.card.render.engine.event.msg.SwanCardBaseMessage;
import com.baidu.swan.card.render.jscontainer.interfaces.ISwanAppWebViewManager;
import com.baidu.swan.card.render.jscontainer.interfaces.SwanAppWebViewCallback;
import com.baidu.swan.card.render.jscontainer.interfaces.WebViewLifecycleDispatcher;
import com.baidu.swan.card.utils.SwanAppLibConfig;
import com.baidu.swan.card.utils.SwanAppSwanCoreUtils;
import com.baidu.swan.card.utils.SwanCardLog;
import com.baidu.swan.card.utils.SwanCardUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SwanCardGroup implements SwanAppWebViewCallback {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String DEFAULT_GROUP = "default";
    public static final int MAX_PREFETCH_RUNTIME_SIZE = 2;
    private static final String TAG = "SwanCardGroup";
    private static volatile SwanCardGroup sInstance;
    private final ConcurrentHashMap<String, SwanCardAppGlobal> mAppGlobals = new ConcurrentHashMap<>();
    private final Object mGlobalLock = new Object();
    private final HashMap<String, ISwanAppWebViewManager> mManagerMap = new HashMap<>();
    private final Object mRuntimeLock = new Object();
    private final ArrayMap<String, SwanCardCoreRuntime> sPrefetchRuntimes = new ArrayMap<>();
    private final LinkedList<SwanCardCoreRuntime> sPreloadRuntimes = new LinkedList<>();
    private final ConcurrentHashMap<String, List<SwanCardCoreRuntime>> sUsedRuntimes = new ConcurrentHashMap<>();

    private SwanCardGroup() {
        WebViewLifecycleDispatcher.register(this);
    }

    public static SwanCardGroup get() {
        if (sInstance == null) {
            synchronized (SwanCardGroup.class) {
                if (sInstance == null) {
                    sInstance = new SwanCardGroup();
                }
            }
        }
        return sInstance;
    }

    public SwanCardAppGlobal getAppGlobal(String appId) {
        SwanCardAppGlobal appGlobal;
        if (TextUtils.isEmpty(appId)) {
            return new SwanCardAppGlobal("");
        }
        synchronized (this.mGlobalLock) {
            appGlobal = this.mAppGlobals.get(appId);
            if (appGlobal == null) {
                appGlobal = new SwanCardAppGlobal(appId);
                this.mAppGlobals.put(appId, appGlobal);
            }
        }
        return appGlobal;
    }

    public List<SwanCardAppGlobal> getAppGlobals() {
        ArrayList arrayList;
        synchronized (this.mGlobalLock) {
            arrayList = new ArrayList(this.mAppGlobals.values());
        }
        return arrayList;
    }

    private void releaseAppGlobal(String appId) {
        SwanCardAppGlobal appGlobal;
        if (!TextUtils.isEmpty(appId)) {
            synchronized (this.mGlobalLock) {
                appGlobal = this.mAppGlobals.remove(appId);
            }
            if (appGlobal != null) {
                appGlobal.releaseAll();
            }
            CardPageForbiddenManager.get().release(appId);
        }
    }

    public SwanCardCoreRuntime getCoreRuntime(String group) {
        if (TextUtils.isEmpty(group)) {
            group = "default";
        }
        synchronized (this.mRuntimeLock) {
            SwanCardCoreRuntime coreRuntime = getLatestRuntime(group);
            if (coreRuntime != null) {
                return coreRuntime;
            }
            SwanCardCoreRuntime coreRuntime2 = pollPrefetchRuntime(group);
            if (coreRuntime2 != null) {
                saveUsedRuntime(group, coreRuntime2);
                return coreRuntime2;
            }
            SwanCardCoreRuntime coreRuntime3 = pollPreloadRuntime();
            if (coreRuntime3 == null) {
                coreRuntime3 = new SwanCardCoreRuntime();
            }
            coreRuntime3.setGroup(group);
            saveUsedRuntime(group, coreRuntime3);
            return coreRuntime3;
        }
    }

    public SwanCardCoreRuntime hitCoreRuntime(String group) {
        if (TextUtils.isEmpty(group)) {
            group = "default";
        }
        synchronized (this.mRuntimeLock) {
            SwanCardCoreRuntime coreRuntime = getLatestRuntime(group);
            if (coreRuntime != null) {
                return coreRuntime;
            }
            SwanCardCoreRuntime swanCardCoreRuntime = this.sPrefetchRuntimes.get(group);
            return swanCardCoreRuntime;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0058, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.swan.card.card.core.SwanCardCoreRuntime getLatestRuntime(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.mRuntimeLock
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<com.baidu.swan.card.card.core.SwanCardCoreRuntime>> r1 = r12.sUsedRuntimes     // Catch:{ all -> 0x0059 }
            java.lang.Object r1 = r1.get(r13)     // Catch:{ all -> 0x0059 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x0059 }
            r2 = 0
            if (r1 == 0) goto L_0x0057
            int r3 = r1.size()     // Catch:{ all -> 0x0059 }
            if (r3 > 0) goto L_0x0015
            goto L_0x0057
        L_0x0015:
            r3 = 0
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0059 }
            com.baidu.swan.card.card.core.SwanCardCoreRuntime r3 = (com.baidu.swan.card.card.core.SwanCardCoreRuntime) r3     // Catch:{ all -> 0x0059 }
            java.util.Iterator r4 = r1.iterator()     // Catch:{ all -> 0x0059 }
        L_0x0020:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0059 }
            if (r5 == 0) goto L_0x004d
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0059 }
            com.baidu.swan.card.card.core.SwanCardCoreRuntime r5 = (com.baidu.swan.card.card.core.SwanCardCoreRuntime) r5     // Catch:{ all -> 0x0059 }
            if (r3 != 0) goto L_0x0030
            r6 = r2
            goto L_0x0034
        L_0x0030:
            com.baidu.swan.card.launch.model.SwanCoreVersion r6 = r3.getSwanCoreVersion()     // Catch:{ all -> 0x0059 }
        L_0x0034:
            if (r6 != 0) goto L_0x0038
            r3 = r5
            goto L_0x0020
        L_0x0038:
            if (r5 != 0) goto L_0x003c
            r7 = r2
            goto L_0x0040
        L_0x003c:
            com.baidu.swan.card.launch.model.SwanCoreVersion r7 = r5.getSwanCoreVersion()     // Catch:{ all -> 0x0059 }
        L_0x0040:
            if (r7 != 0) goto L_0x0043
            goto L_0x0020
        L_0x0043:
            long r8 = r7.swanCoreVersionCode     // Catch:{ all -> 0x0059 }
            long r10 = r6.swanCoreVersionCode     // Catch:{ all -> 0x0059 }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x004c
            r3 = r5
        L_0x004c:
            goto L_0x0020
        L_0x004d:
            boolean r4 = com.baidu.swan.card.utils.SwanAppSwanCoreUtils.isCoreRuntimeNewest(r3)     // Catch:{ all -> 0x0059 }
            if (r4 != 0) goto L_0x0055
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            return r2
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            return r3
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            return r2
        L_0x0059:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0059 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.card.card.core.SwanCardGroup.getLatestRuntime(java.lang.String):com.baidu.swan.card.card.core.SwanCardCoreRuntime");
    }

    private void saveUsedRuntime(String group, SwanCardCoreRuntime runtime) {
        synchronized (this.mRuntimeLock) {
            List<SwanCardCoreRuntime> runtimes = this.sUsedRuntimes.get(group);
            if (runtimes == null) {
                runtimes = new ArrayList<>();
                this.sUsedRuntimes.put(group, runtimes);
            }
            runtimes.add(runtime);
        }
    }

    private SwanCardCoreRuntime pollPreloadRuntime() {
        SwanCardCoreRuntime coreRuntime = null;
        synchronized (this.mRuntimeLock) {
            if (!this.sPreloadRuntimes.isEmpty()) {
                coreRuntime = this.sPreloadRuntimes.remove(0);
            }
        }
        if (coreRuntime == null || SwanAppSwanCoreUtils.isCoreRuntimeNewest(coreRuntime)) {
            return coreRuntime;
        }
        final SwanCardCoreRuntime toReleasedRuntime = coreRuntime;
        SwanCardUtil.postOnUi(new Runnable() {
            public void run() {
                SwanCardLog.logToFile(SwanCardGroup.TAG, "getCoreRuntime: preloadRuntime is not newest");
                toReleasedRuntime.release();
            }
        });
        return new SwanCardCoreRuntime();
    }

    public void preloadCoreRuntime() {
        SwanCardCoreRuntime runtime = null;
        synchronized (this.mRuntimeLock) {
            if (this.sPreloadRuntimes.isEmpty()) {
                runtime = new SwanCardCoreRuntime();
                this.sPreloadRuntimes.add(runtime);
            }
        }
        if (runtime != null) {
            runtime.preloadCoreRuntime();
        }
    }

    private SwanCardCoreRuntime pollPrefetchRuntime(String group) {
        SwanCardCoreRuntime coreRuntime;
        synchronized (this.mRuntimeLock) {
            coreRuntime = this.sPrefetchRuntimes.remove(group);
        }
        if (coreRuntime == null || SwanAppSwanCoreUtils.isCoreRuntimeNewest(coreRuntime)) {
            return coreRuntime;
        }
        final SwanCardCoreRuntime toReleasedRuntime = coreRuntime;
        SwanCardUtil.postOnUi(new Runnable() {
            public void run() {
                toReleasedRuntime.release();
            }
        });
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (com.baidu.swan.card.utils.SwanAppSwanCoreUtils.isCoreRuntimeNewest(r1) != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        r0 = r1;
        com.baidu.swan.card.utils.SwanCardUtil.postOnUi(new com.baidu.swan.card.card.core.SwanCardGroup.AnonymousClass3(r4));
        r1 = new com.baidu.swan.card.card.core.SwanCardCoreRuntime();
        r4.sPrefetchRuntimes.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0065, code lost:
        r1.setGroup(r5);
        r1.prepareRuntime(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void prefetchCoreRuntime(java.lang.String r5, com.baidu.swan.card.card.core.SwanCardCoreRuntime.PrepareStatusCallback r6) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0009
            java.lang.String r0 = "default"
            goto L_0x000a
        L_0x0009:
            r0 = r5
        L_0x000a:
            r5 = r0
            java.lang.Object r0 = r4.mRuntimeLock
            monitor-enter(r0)
            com.baidu.swan.card.card.core.SwanCardCoreRuntime r1 = r4.getLatestRuntime(r5)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x0019
            r6.onReady(r1)     // Catch:{ all -> 0x006c }
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            return
        L_0x0019:
            androidx.collection.ArrayMap<java.lang.String, com.baidu.swan.card.card.core.SwanCardCoreRuntime> r2 = r4.sPrefetchRuntimes     // Catch:{ all -> 0x006c }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x006c }
            com.baidu.swan.card.card.core.SwanCardCoreRuntime r2 = (com.baidu.swan.card.card.core.SwanCardCoreRuntime) r2     // Catch:{ all -> 0x006c }
            r1 = r2
            if (r1 != 0) goto L_0x004a
            androidx.collection.ArrayMap<java.lang.String, com.baidu.swan.card.card.core.SwanCardCoreRuntime> r2 = r4.sPrefetchRuntimes     // Catch:{ all -> 0x006c }
            int r2 = r2.size()     // Catch:{ all -> 0x006c }
            r3 = 2
            if (r2 >= r3) goto L_0x0034
            com.baidu.swan.card.card.core.SwanCardCoreRuntime r2 = new com.baidu.swan.card.card.core.SwanCardCoreRuntime     // Catch:{ all -> 0x006c }
            r2.<init>()     // Catch:{ all -> 0x006c }
            r1 = r2
            goto L_0x0045
        L_0x0034:
            androidx.collection.ArrayMap<java.lang.String, com.baidu.swan.card.card.core.SwanCardCoreRuntime> r2 = r4.sPrefetchRuntimes     // Catch:{ all -> 0x006c }
            r3 = 0
            java.lang.Object r3 = r2.keyAt(r3)     // Catch:{ all -> 0x006c }
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x006c }
            com.baidu.swan.card.card.core.SwanCardCoreRuntime r2 = (com.baidu.swan.card.card.core.SwanCardCoreRuntime) r2     // Catch:{ all -> 0x006c }
            r1 = r2
            r1.onReuseWithPrefetchEnv()     // Catch:{ all -> 0x006c }
        L_0x0045:
            androidx.collection.ArrayMap<java.lang.String, com.baidu.swan.card.card.core.SwanCardCoreRuntime> r2 = r4.sPrefetchRuntimes     // Catch:{ all -> 0x006c }
            r2.put(r5, r1)     // Catch:{ all -> 0x006c }
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            boolean r0 = com.baidu.swan.card.utils.SwanAppSwanCoreUtils.isCoreRuntimeNewest(r1)
            if (r0 != 0) goto L_0x0065
            r0 = r1
            com.baidu.swan.card.card.core.SwanCardGroup$3 r2 = new com.baidu.swan.card.card.core.SwanCardGroup$3
            r2.<init>(r0)
            com.baidu.swan.card.utils.SwanCardUtil.postOnUi(r2)
            com.baidu.swan.card.card.core.SwanCardCoreRuntime r2 = new com.baidu.swan.card.card.core.SwanCardCoreRuntime
            r2.<init>()
            r1 = r2
            androidx.collection.ArrayMap<java.lang.String, com.baidu.swan.card.card.core.SwanCardCoreRuntime> r2 = r4.sPrefetchRuntimes
            r2.put(r5, r1)
        L_0x0065:
            r1.setGroup(r5)
            r1.prepareRuntime(r6)
            return
        L_0x006c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.card.card.core.SwanCardGroup.prefetchCoreRuntime(java.lang.String, com.baidu.swan.card.card.core.SwanCardCoreRuntime$PrepareStatusCallback):void");
    }

    public void removeCoreRuntime(SwanCardCoreRuntime runtime) {
        if (runtime != null) {
            synchronized (this.mRuntimeLock) {
                this.sPreloadRuntimes.remove(runtime);
                String group = runtime.getGroup();
                if (!TextUtils.isEmpty(group)) {
                    List<SwanCardCoreRuntime> runtimes = this.sUsedRuntimes.get(group);
                    if (runtimes != null) {
                        runtimes.remove(runtime);
                    }
                    this.sPrefetchRuntimes.remove(group);
                }
            }
        }
    }

    public void releaseForCoreUpdate() {
        SwanCardLog.logToFile(TAG, "releaseForCoreUpdate");
        LinkedList<SwanCardCoreRuntime> list = new LinkedList<>();
        synchronized (this.mRuntimeLock) {
            Iterator it = this.sPreloadRuntimes.iterator();
            while (it.hasNext()) {
                SwanCardCoreRuntime item = (SwanCardCoreRuntime) it.next();
                if (!SwanAppSwanCoreUtils.isCoreRuntimeNewest(item)) {
                    list.add(item);
                }
            }
            if (!list.isEmpty()) {
                this.sPreloadRuntimes.removeAll(list);
            }
        }
        if (list.isEmpty()) {
            preloadCoreRuntime();
            return;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SwanCardCoreRuntime runtime = (SwanCardCoreRuntime) it2.next();
            if (runtime.isMasterReady()) {
                runtime.release();
                preloadCoreRuntime();
            } else {
                if (runtime.mReleaseCallback == null) {
                    runtime.mReleaseCallback = new SwanCardCoreRuntime.PrepareStatusCallback() {
                        /* access modifiers changed from: protected */
                        public void onReady(final SwanCardCoreRuntime runtime) {
                            SwanCardLog.logToFile(SwanCardGroup.TAG, "onReady releaseForCoreUpdate");
                            SwanCardUtil.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (TextUtils.isEmpty(runtime.getGroup())) {
                                        runtime.release();
                                        SwanCardGroup.this.preloadCoreRuntime();
                                    }
                                }
                            });
                        }

                        /* access modifiers changed from: protected */
                        public void onFail(final SwanCardCoreRuntime runtime) {
                            SwanCardLog.logToFile(SwanCardGroup.TAG, "onFail releaseForCoreUpdate");
                            SwanCardUtil.runOnUiThread(new Runnable() {
                                public void run() {
                                    if (TextUtils.isEmpty(runtime.getGroup())) {
                                        runtime.release();
                                        SwanCardGroup.this.preloadCoreRuntime();
                                    }
                                }
                            });
                        }
                    };
                }
                runtime.prepareRuntime(runtime.mReleaseCallback);
            }
        }
    }

    public ArrayList<Long> getSwanCoreVersions() {
        ArrayList<Long> usedVersions = new ArrayList<>();
        synchronized (this.mRuntimeLock) {
            for (List<SwanCardCoreRuntime> runtimes : this.sUsedRuntimes.values()) {
                for (SwanCardCoreRuntime runtime : runtimes) {
                    SwanCoreVersion swanCoreVersion = runtime.getSwanCoreVersion();
                    if (swanCoreVersion != null && !usedVersions.contains(Long.valueOf(swanCoreVersion.swanCoreVersionCode))) {
                        usedVersions.add(Long.valueOf(swanCoreVersion.swanCoreVersionCode));
                    }
                }
            }
            Iterator it = this.sPreloadRuntimes.iterator();
            while (it.hasNext()) {
                SwanCoreVersion swanCoreVersion2 = ((SwanCardCoreRuntime) it.next()).getSwanCoreVersion();
                if (swanCoreVersion2 != null && !usedVersions.contains(Long.valueOf(swanCoreVersion2.swanCoreVersionCode))) {
                    usedVersions.add(Long.valueOf(swanCoreVersion2.swanCoreVersionCode));
                }
            }
            for (SwanCardCoreRuntime runtime2 : this.sPrefetchRuntimes.values()) {
                SwanCoreVersion swanCoreVersion3 = runtime2.getSwanCoreVersion();
                if (swanCoreVersion3 != null && !usedVersions.contains(Long.valueOf(swanCoreVersion3.swanCoreVersionCode))) {
                    usedVersions.add(Long.valueOf(swanCoreVersion3.swanCoreVersionCode));
                }
            }
        }
        if (DEBUG) {
            Log.d(TAG, "getSwanCoreVersions: " + usedVersions.toString());
        }
        return usedVersions;
    }

    public synchronized ISwanAppWebViewManager getWebViewManager(String id) {
        if (!this.mManagerMap.isEmpty()) {
            if (!TextUtils.isEmpty(id)) {
                return this.mManagerMap.get(id);
            }
        }
        return null;
    }

    public void sendJSMessage(String webviewId, SwanCardBaseMessage message) {
        ISwanAppWebViewManager viewManager = getWebViewManager(webviewId);
        if (viewManager != null) {
            JSEventDispatcher.dispatchJSEvent(viewManager.getWebView(), message);
        } else if (DEBUG) {
            Log.e(TAG, "can't find view manager. webviewId: " + webviewId + " message: " + message);
        }
    }

    public synchronized void onCreate(ISwanAppWebViewManager viewManager) {
        this.mManagerMap.put(viewManager.getWebViewId(), viewManager);
    }

    public void onResume(ISwanAppWebViewManager viewManager) {
    }

    public void onPause(ISwanAppWebViewManager viewManager) {
    }

    public synchronized void onDestroy(ISwanAppWebViewManager viewManager) {
        this.mManagerMap.remove(viewManager.getWebViewId());
    }

    public void onCardAppRelease(String appId) {
        if (DEBUG) {
            Log.d(TAG, "onCardAppRelease:" + appId);
        }
        releaseAppGlobal(appId);
    }

    public static String getGroupId(String group, SwanCoreVersion swanCoreVersion) {
        String group2 = TextUtils.isEmpty(group) ? "default" : group;
        if (swanCoreVersion == null || TextUtils.isEmpty(swanCoreVersion.swanCoreVersionName)) {
            return group2;
        }
        return group2 + "_" + swanCoreVersion.swanCoreVersionName;
    }

    public static String getGroupByGroupId(String groupId) {
        if (TextUtils.isEmpty(groupId)) {
            return "default";
        }
        int splitIndex = groupId.lastIndexOf("_");
        if (splitIndex < 0) {
            return groupId;
        }
        return groupId.substring(0, splitIndex);
    }

    public static String getSwanCoreVersionNameByGroupId(String groupId) {
        int splitIndex;
        if (!TextUtils.isEmpty(groupId) && (splitIndex = groupId.lastIndexOf("_")) >= 0 && splitIndex != groupId.length() - 1) {
            return groupId.substring(splitIndex + 1);
        }
        return "";
    }
}
