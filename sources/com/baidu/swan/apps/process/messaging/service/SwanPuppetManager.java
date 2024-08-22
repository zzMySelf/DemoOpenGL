package com.baidu.swan.apps.process.messaging.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.ipc.SwanProcessCallStub;
import com.baidu.swan.apps.process.messaging.SwanAppMessenger;
import com.baidu.swan.apps.process.messaging.SwanMsgCooker;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.util.typedbox.TypedBox;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class SwanPuppetManager {
    private static final int ALLOW_RESCUE_MAX_COUNT = 3;
    public static final long ALLOW_RESCUE_MAX_TIME_LIMIT = TimeUnit.MINUTES.toMillis(5);
    static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    static final String TAG = "SwanPuppetManager";
    private final PuppetCallback mCallbacker;
    /* access modifiers changed from: private */
    public final Set<PuppetCallback> mCallbacks;
    private final LinkedHashMap<SwanAppProcessInfo, SwanClientPuppet> mClientsMap;
    public final Handler mHandler;
    public final Messenger mMessenger;
    private final SwanProcessReuseStrategy mProcessReuseStrategy;
    private final Deque<Long> mRescueRecords;
    private long mRescueRefractoryUntil;
    public final SwanProcessCallStub processStub;

    public interface ClientFilter<FILTER> {
        boolean accept(FILTER filter, SwanClientPuppet swanClientPuppet);
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static SwanPuppetManager sInstance = new SwanPuppetManager();

        private Holder() {
        }
    }

    public static SwanPuppetManager get() {
        if (!DEBUG || ProcessUtils.isMainProcess()) {
            return Holder.sInstance;
        }
        throw new IllegalStateException("SwanAppClientObjManager should run in main process only");
    }

    private SwanPuppetManager() {
        LinkedHashMap<SwanAppProcessInfo, SwanClientPuppet> linkedHashMap = new LinkedHashMap<>();
        this.mClientsMap = linkedHashMap;
        SwanProcessReuseStrategy processReuseStrategy = SwanAppRuntime.getConfigRuntime().getProcessReuseStrategy();
        this.mProcessReuseStrategy = processReuseStrategy;
        this.mRescueRecords = new ArrayDeque();
        SwanAppMessengerService.SwanAppServiceHandler swanAppServiceHandler = new SwanAppMessengerService.SwanAppServiceHandler();
        this.mHandler = swanAppServiceHandler;
        this.mMessenger = new Messenger(swanAppServiceHandler);
        this.processStub = new SwanProcessCallStub(swanAppServiceHandler);
        this.mRescueRefractoryUntil = 0;
        this.mCallbacks = new HashSet();
        this.mCallbacker = new PuppetCallback() {
            public void onEvent(final String event, final SwanClientPuppet client) {
                if (SwanPuppetManager.DEBUG) {
                    Log.i(SwanPuppetManager.TAG, "onEvent: to=" + SwanPuppetManager.this.mCallbacks.size() + " event=" + event + " client=" + client.mProcess);
                }
                synchronized (SwanPuppetManager.this.mCallbacks) {
                    TypedBox.forEach(Swan.getMainHandler(), new TypedCallback<PuppetCallback>() {
                        public void onCallback(PuppetCallback msg) {
                            msg.onEvent(event, client);
                        }
                    }, SwanPuppetManager.this.mCallbacks);
                }
            }

            public void timeout() {
            }
        };
        processReuseStrategy.initProcessMapOrder(linkedHashMap);
        for (SwanAppProcessInfo process : SwanAppProcessInfo.indices()) {
            if (process != null && process.isSwanAppProcess()) {
                this.mClientsMap.put(process, new SwanClientPuppet(process));
            }
        }
    }

    public void incrementRescueRefractoryPeriod(long period) {
        if (period > 0) {
            this.mRescueRefractoryUntil = System.currentTimeMillis() + period;
        }
    }

    /* access modifiers changed from: package-private */
    public PuppetCallback getCallbacker() {
        return this.mCallbacker;
    }

    public void addCallback(PuppetCallback callback) {
        addCallback(callback, -1);
    }

    public void addCallback(final PuppetCallback callback, long term) {
        synchronized (this.mCallbacks) {
            this.mCallbacks.add(callback);
            if (DEBUG) {
                Log.i(TAG, "addCallback: after = " + this.mCallbacks.size());
            }
        }
        if (term > 0) {
            Swan.getMainHandler().postDelayed(new Runnable() {
                public void run() {
                    synchronized (SwanPuppetManager.this.mCallbacks) {
                        if (SwanPuppetManager.this.mCallbacks.contains(callback)) {
                            if (SwanPuppetManager.DEBUG) {
                                Log.i(SwanPuppetManager.TAG, "timeout: callback = " + callback);
                            }
                            SwanPuppetManager.this.delCallback(callback);
                            callback.timeout();
                        }
                    }
                }
            }, term);
        }
    }

    public void delCallback(PuppetCallback callback) {
        synchronized (this.mCallbacks) {
            this.mCallbacks.remove(callback);
            if (DEBUG) {
                Log.i(TAG, "delCallback: after = " + this.mCallbacks.size());
            }
        }
    }

    public synchronized SwanClientPuppet getClientObj(int processId) {
        return getClientObj(SwanAppProcessInfo.indexOf(processId));
    }

    public synchronized SwanClientPuppet getClientObj(SwanAppProcessInfo process) {
        return this.mClientsMap.get(process);
    }

    public synchronized <FILTER> SwanClientPuppet getClientObj(FILTER filter, ClientFilter<FILTER> clientFilter) {
        for (SwanClientPuppet clientObj : this.mClientsMap.values()) {
            if (clientFilter.accept(filter, clientObj)) {
                return clientObj;
            }
        }
        return null;
    }

    public synchronized LinkedHashSet<SwanClientPuppet> getClientObjs() {
        return new LinkedHashSet<>(this.mClientsMap.values());
    }

    public boolean hasSwanProcessOnline() {
        LinkedHashSet<SwanClientPuppet> clients = get().getClientObjs();
        if (clients.isEmpty()) {
            return false;
        }
        Iterator it = clients.iterator();
        while (it.hasNext()) {
            SwanClientPuppet client = (SwanClientPuppet) it.next();
            if (client.isProcessOnline() && !client.mProcess.isSwanAppInMainProcess()) {
                SwanAppLog.logToFile(TAG, "Has SwanProcess Online");
                return true;
            }
        }
        SwanAppLog.logToFile(TAG, "No SwanProcess Online");
        return false;
    }

    public boolean hasSwanProcessReady() {
        LinkedHashSet<SwanClientPuppet> clients = get().getClientObjs();
        if (clients.isEmpty()) {
            return false;
        }
        Iterator it = clients.iterator();
        while (it.hasNext()) {
            SwanClientPuppet client = (SwanClientPuppet) it.next();
            if (client.isProcessOnline() && !client.mProcess.isSwanAppInMainProcess() && client.isPreloadReady()) {
                SwanAppLog.logToFile(TAG, "Has SwanProcess Ready");
                return true;
            }
        }
        SwanAppLog.logToFile(TAG, "No SwanProcess Ready");
        return false;
    }

    public synchronized SwanClientPuppet getAvailableProcessInfo(String appId, boolean isMain, boolean forceReuse) {
        return getAvailableProcessInfo(appId, isMain, (SwanAppProcessInfo) null, forceReuse);
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    public synchronized SwanClientPuppet getAvailableProcessInfo(String appId, boolean isMain, SwanAppProcessInfo noReuseProcess, boolean forceReuse) {
        if (isMain) {
            return getClientObj(SwanAppProcessInfo.MAIN);
        }
        SwanClientPuppet client = findSwanAppClientByAppId(appId);
        if (this.mProcessReuseStrategy.isAvailableProcess(client)) {
            return client;
        }
        if (forceReuse) {
            return computeMultiplexProcess(noReuseProcess);
        }
        return computNextAvailableProcess(noReuseProcess);
    }

    public synchronized SwanClientPuppet getProcessInfoAndResort(String appId, boolean isMain) {
        return getProcessInfoAndResort(appId, isMain, (SwanAppProcessInfo) null, false);
    }

    public synchronized SwanClientPuppet getProcessInfoAndResort(String appId, boolean isMain, SwanAppProcessInfo noReuseProcess, boolean forceReuse) {
        SwanClientPuppet client;
        client = getAvailableProcessInfo(appId, isMain, noReuseProcess, forceReuse);
        lruResortClient(client.mProcess);
        return client;
    }

    public synchronized SwanClientPuppet computNextAvailableProcess() {
        return computNextAvailableProcess((SwanAppProcessInfo) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e3, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.baidu.swan.apps.process.messaging.service.SwanClientPuppet computNextAvailableProcess(com.baidu.swan.apps.process.SwanAppProcessInfo r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "b4 computeNextAvailableProcess"
            r8.logStatus(r0)     // Catch:{ all -> 0x00f8 }
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x0009:
            int r3 = com.baidu.swan.apps.process.SwanAppProcessInfo.PROCESS_ID_END     // Catch:{ all -> 0x00f8 }
            if (r2 > r3) goto L_0x005d
            com.baidu.swan.apps.process.messaging.service.SwanProcessReuseStrategy r3 = r8.mProcessReuseStrategy     // Catch:{ all -> 0x00f8 }
            int r4 = com.baidu.swan.apps.process.SwanAppProcessInfo.PROCESS_ID_END     // Catch:{ all -> 0x00f8 }
            int r3 = r3.reCalculateProcessIndex(r2, r4)     // Catch:{ all -> 0x00f8 }
            java.util.LinkedHashMap<com.baidu.swan.apps.process.SwanAppProcessInfo, com.baidu.swan.apps.process.messaging.service.SwanClientPuppet> r4 = r8.mClientsMap     // Catch:{ all -> 0x00f8 }
            com.baidu.swan.apps.process.SwanAppProcessInfo r5 = com.baidu.swan.apps.process.SwanAppProcessInfo.indexOf(r3)     // Catch:{ all -> 0x00f8 }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x00f8 }
            com.baidu.swan.apps.process.messaging.service.SwanClientPuppet r4 = (com.baidu.swan.apps.process.messaging.service.SwanClientPuppet) r4     // Catch:{ all -> 0x00f8 }
            com.baidu.swan.apps.process.messaging.service.SwanProcessReuseStrategy r5 = r8.mProcessReuseStrategy     // Catch:{ all -> 0x00f8 }
            boolean r5 = r5.isIllegalProcess(r4)     // Catch:{ all -> 0x00f8 }
            if (r5 == 0) goto L_0x002a
            goto L_0x005a
        L_0x002a:
            boolean r5 = r4.isPreloadReady()     // Catch:{ all -> 0x00f8 }
            if (r5 == 0) goto L_0x004e
            boolean r5 = DEBUG     // Catch:{ all -> 0x00f8 }
            if (r5 == 0) goto L_0x004c
            java.lang.String r5 = "SwanPuppetManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r6.<init>()     // Catch:{ all -> 0x00f8 }
            java.lang.String r7 = "computeNextAvailableProcess: firstPreloadedClient="
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r6 = r6.append(r4)     // Catch:{ all -> 0x00f8 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00f8 }
            android.util.Log.i(r5, r6)     // Catch:{ all -> 0x00f8 }
        L_0x004c:
            monitor-exit(r8)
            return r4
        L_0x004e:
            if (r0 != 0) goto L_0x0057
            boolean r5 = r4.isProcessOnline()     // Catch:{ all -> 0x00f8 }
            if (r5 == 0) goto L_0x0057
            r0 = r4
        L_0x0057:
            if (r1 != 0) goto L_0x005a
            r1 = r4
        L_0x005a:
            int r2 = r2 + 1
            goto L_0x0009
        L_0x005d:
            if (r0 == 0) goto L_0x007d
            boolean r2 = DEBUG     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x007b
            java.lang.String r2 = "SwanPuppetManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r3.<init>()     // Catch:{ all -> 0x00f8 }
            java.lang.String r4 = "computeNextAvailableProcess: firstConnectedEmptyClient="
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00f8 }
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x00f8 }
        L_0x007b:
            monitor-exit(r8)
            return r0
        L_0x007d:
            if (r1 == 0) goto L_0x009d
            boolean r2 = DEBUG     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x009b
            java.lang.String r2 = "SwanPuppetManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r3.<init>()     // Catch:{ all -> 0x00f8 }
            java.lang.String r4 = "computeNextAvailableProcess: firstEmptyClient="
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x00f8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00f8 }
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x00f8 }
        L_0x009b:
            monitor-exit(r8)
            return r1
        L_0x009d:
            java.util.LinkedHashMap<com.baidu.swan.apps.process.SwanAppProcessInfo, com.baidu.swan.apps.process.messaging.service.SwanClientPuppet> r2 = r8.mClientsMap     // Catch:{ all -> 0x00f8 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x00f8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00f8 }
        L_0x00a7:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00f8 }
            if (r3 == 0) goto L_0x00e5
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00f8 }
            com.baidu.swan.apps.process.messaging.service.SwanClientPuppet r3 = (com.baidu.swan.apps.process.messaging.service.SwanClientPuppet) r3     // Catch:{ all -> 0x00f8 }
            if (r9 == 0) goto L_0x00be
            int r4 = r9.index     // Catch:{ all -> 0x00f8 }
            com.baidu.swan.apps.process.SwanAppProcessInfo r5 = r3.mProcess     // Catch:{ all -> 0x00f8 }
            int r5 = r5.index     // Catch:{ all -> 0x00f8 }
            if (r4 != r5) goto L_0x00be
            goto L_0x00a7
        L_0x00be:
            com.baidu.swan.apps.process.messaging.service.SwanProcessReuseStrategy r4 = r8.mProcessReuseStrategy     // Catch:{ all -> 0x00f8 }
            boolean r4 = r4.isReusableProcess(r3)     // Catch:{ all -> 0x00f8 }
            if (r4 == 0) goto L_0x00e4
            boolean r2 = DEBUG     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x00e2
            java.lang.String r2 = "SwanPuppetManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r4.<init>()     // Catch:{ all -> 0x00f8 }
            java.lang.String r5 = "computeNextAvailableProcess: lruClient="
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r4 = r4.append(r3)     // Catch:{ all -> 0x00f8 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00f8 }
            android.util.Log.i(r2, r4)     // Catch:{ all -> 0x00f8 }
        L_0x00e2:
            monitor-exit(r8)
            return r3
        L_0x00e4:
            goto L_0x00a7
        L_0x00e5:
            boolean r2 = DEBUG     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x00f0
            java.lang.String r2 = "SwanPuppetManager"
            java.lang.String r3 = "computeNextAvailableProcess: P0"
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x00f8 }
        L_0x00f0:
            com.baidu.swan.apps.process.SwanAppProcessInfo r2 = com.baidu.swan.apps.process.SwanAppProcessInfo.P0     // Catch:{ all -> 0x00f8 }
            com.baidu.swan.apps.process.messaging.service.SwanClientPuppet r2 = r8.getClientObj((com.baidu.swan.apps.process.SwanAppProcessInfo) r2)     // Catch:{ all -> 0x00f8 }
            monitor-exit(r8)
            return r2
        L_0x00f8:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.process.messaging.service.SwanPuppetManager.computNextAvailableProcess(com.baidu.swan.apps.process.SwanAppProcessInfo):com.baidu.swan.apps.process.messaging.service.SwanClientPuppet");
    }

    public SwanClientPuppet computeMultiplexProcess(SwanAppProcessInfo noReuseProcess) {
        SwanClientPuppet firstOccupiedClient = null;
        SwanClientPuppet firstWebViewFinishClient = null;
        for (int index = 0; index <= SwanAppProcessInfo.PROCESS_ID_END; index++) {
            SwanClientPuppet client = this.mClientsMap.get(SwanAppProcessInfo.indexOf(this.mProcessReuseStrategy.reCalculateProcessIndex(index, SwanAppProcessInfo.PROCESS_ID_END)));
            if (!this.mProcessReuseStrategy.isIllegalProcess(client, true)) {
                if (!client.isPreloadReady() || client.hasAppOccupied()) {
                    if (client.hasAppOccupied() && firstOccupiedClient == null && client.isWebViewFinish()) {
                        firstOccupiedClient = client;
                    }
                    if (!client.hasAppOccupied() && client.isWebViewFinish()) {
                        firstWebViewFinishClient = client;
                    }
                } else {
                    if (DEBUG) {
                        Log.i(TAG, "computeMultiplexProcess: firstPreloadedClient=" + client);
                    }
                    return client;
                }
            }
        }
        if (firstWebViewFinishClient != null) {
            if (DEBUG) {
                Log.i(TAG, "computeMultiplexProcess: firstWebViewFinishClient=" + firstWebViewFinishClient);
            }
            return firstWebViewFinishClient;
        } else if (firstOccupiedClient != null) {
            if (DEBUG) {
                Log.i(TAG, "computeMultiplexProcess: firstOccupiedClient=" + firstOccupiedClient);
            }
            return firstOccupiedClient;
        } else {
            for (SwanClientPuppet client2 : this.mClientsMap.values()) {
                if ((noReuseProcess == null || noReuseProcess.index != client2.mProcess.index) && this.mProcessReuseStrategy.isReusableProcess(client2)) {
                    if (DEBUG) {
                        Log.i(TAG, "computeMultiplexProcess: lruClient=" + client2);
                    }
                    return client2;
                }
            }
            return getClientObj(SwanAppProcessInfo.P0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.baidu.swan.apps.process.messaging.service.SwanClientPuppet computNextPreloadProcess() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "b4 computeNextPreloadProcess"
            r7.logStatus(r0)     // Catch:{ all -> 0x0072 }
            r0 = 0
            r1 = 0
        L_0x0008:
            int r2 = com.baidu.swan.apps.process.SwanAppProcessInfo.PROCESS_ID_END     // Catch:{ all -> 0x0072 }
            if (r1 > r2) goto L_0x0054
            com.baidu.swan.apps.process.messaging.service.SwanProcessReuseStrategy r2 = r7.mProcessReuseStrategy     // Catch:{ all -> 0x0072 }
            int r3 = com.baidu.swan.apps.process.SwanAppProcessInfo.PROCESS_ID_END     // Catch:{ all -> 0x0072 }
            int r2 = r2.reCalculateProcessIndex(r1, r3)     // Catch:{ all -> 0x0072 }
            java.util.LinkedHashMap<com.baidu.swan.apps.process.SwanAppProcessInfo, com.baidu.swan.apps.process.messaging.service.SwanClientPuppet> r3 = r7.mClientsMap     // Catch:{ all -> 0x0072 }
            com.baidu.swan.apps.process.SwanAppProcessInfo r4 = com.baidu.swan.apps.process.SwanAppProcessInfo.indexOf(r2)     // Catch:{ all -> 0x0072 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0072 }
            com.baidu.swan.apps.process.messaging.service.SwanClientPuppet r3 = (com.baidu.swan.apps.process.messaging.service.SwanClientPuppet) r3     // Catch:{ all -> 0x0072 }
            com.baidu.swan.apps.process.messaging.service.SwanProcessReuseStrategy r4 = r7.mProcessReuseStrategy     // Catch:{ all -> 0x0072 }
            boolean r4 = r4.isIllegalProcess(r3)     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x0029
            goto L_0x0051
        L_0x0029:
            boolean r4 = r3.isPreloadReady()     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x004e
            boolean r4 = DEBUG     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x004b
            java.lang.String r4 = "SwanPuppetManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r5.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r6 = "computeNextPreloadProcess: return null by found empty process="
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x0072 }
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0072 }
            android.util.Log.i(r4, r5)     // Catch:{ all -> 0x0072 }
        L_0x004b:
            r4 = 0
            monitor-exit(r7)
            return r4
        L_0x004e:
            if (r0 != 0) goto L_0x0051
            r0 = r3
        L_0x0051:
            int r1 = r1 + 1
            goto L_0x0008
        L_0x0054:
            boolean r1 = DEBUG     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x0070
            java.lang.String r1 = "SwanPuppetManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r2.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r3 = "computeNextPreloadProcess: firstPreloadableClient="
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0072 }
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0072 }
            android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0072 }
        L_0x0070:
            monitor-exit(r7)
            return r0
        L_0x0072:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.process.messaging.service.SwanPuppetManager.computNextPreloadProcess():com.baidu.swan.apps.process.messaging.service.SwanClientPuppet");
    }

    public synchronized SwanClientPuppet findSwanAppClientByAppId(String appId) {
        List<SwanClientPuppet> list = findSwanAppClientsByAppId(appId);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public synchronized List<SwanClientPuppet> findSwanAppClientsByAppId(String appId) {
        List<SwanClientPuppet> list;
        list = new ArrayList<>();
        if (!TextUtils.isEmpty(appId)) {
            for (SwanClientPuppet clientObj : this.mClientsMap.values()) {
                if (TextUtils.equals(clientObj.getAppId(), appId)) {
                    list.add(clientObj);
                }
            }
        }
        return list;
    }

    public synchronized Map<SwanAppProcessInfo, SwanClientPuppet> getAllClientObjects() {
        return new LinkedHashMap(this.mClientsMap);
    }

    public synchronized void lruResortClient(SwanAppProcessInfo process) {
        SwanClientPuppet object = (SwanClientPuppet) this.mClientsMap.remove(process);
        if (object != null) {
            this.mClientsMap.put(process, object);
        }
        if (DEBUG) {
            logStatus("lru -> " + process);
        }
    }

    public synchronized void deduplicateClients(String appId, SwanClientPuppet protectedClient) {
        if (!TextUtils.isEmpty(appId)) {
            List<SwanClientPuppet> exClients = get().findSwanAppClientsByAppId(appId);
            if (!exClients.isEmpty()) {
                for (SwanClientPuppet exClient : exClients) {
                    if (!(exClient == protectedClient || exClient == null || !exClient.hasAppOccupied())) {
                        if (DEBUG) {
                            Log.i(TAG, "deduplicateClients: protectedClient=" + protectedClient);
                            Log.i(TAG, "deduplicateClients: exClient=" + exClient);
                        }
                        exClient.resetPreload().resetLoadedApp();
                        if (exClient.isProcessOnline()) {
                            SwanAppMessenger.get().send(new SwanMsgCooker(110, new Bundle()).addTarget(exClient.mProcess.getClientMsgTarget()));
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void tryRescue() {
        synchronized (this.mRescueRecords) {
            if (checkRescuable()) {
                this.mRescueRecords.offer(Long.valueOf(System.currentTimeMillis()));
                Bundle ext = new Bundle();
                ext.putString("bundle_key_preload_preload_scene", "1");
                SwanAppPreloadHelper.tryPreloadIfKeepAlive(SwanAppRuntime.getAppContext(), ext);
            }
        }
    }

    private boolean checkRescuable() {
        synchronized (this.mRescueRecords) {
            logRescueStatus("checkRescuable ===>");
            boolean result = false;
            if (this.mRescueRefractoryUntil > System.currentTimeMillis()) {
                logRescueStatus(String.format(Locale.getDefault(), "disallowRescue by mRescueRefractoryUntil(%d)", new Object[]{Long.valueOf(this.mRescueRefractoryUntil)}));
                return false;
            } else if (this.mRescueRecords.size() < 3) {
                logRescueStatus(String.format(Locale.getDefault(), "allowRescue by size(%d) < max(%d)", new Object[]{Integer.valueOf(this.mRescueRecords.size()), 3}));
                return true;
            } else {
                int purgeLengthCount = this.mRescueRecords.size() - 3;
                logRescueStatus("after offer purgeCount=" + purgeLengthCount);
                if (purgeLengthCount > 0) {
                    for (int i2 = 0; i2 < purgeLengthCount; i2++) {
                        logRescueStatus("purge: " + this.mRescueRecords.poll());
                    }
                }
                logRescueStatus("after purge");
                Long oldestRecord = this.mRescueRecords.peek();
                if (oldestRecord == null) {
                    logRescueStatus("allowRescue by null oldestRecord is should not happen");
                    return true;
                }
                long oldestRecordDuration = System.currentTimeMillis() - oldestRecord.longValue();
                if (oldestRecordDuration > ALLOW_RESCUE_MAX_TIME_LIMIT) {
                    result = true;
                }
                logRescueStatus("allowRescue:" + result + " oldestRecordDuration:" + oldestRecordDuration);
                return result;
            }
        }
    }

    private void logRescueStatus(String msg) {
        if (DEBUG) {
            Log.i(TAG, "SwanRescue:: status => " + msg);
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            for (Long record : this.mRescueRecords) {
                Log.i(TAG, "SwanRescue::   >>>  record @ " + dateFormat.format(new Date(record.longValue())));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void handleMsgOnLaunchFinish(Message msg) {
        SwanClientPuppet client;
        if (msg != null) {
            SwanAppProcessInfo process = SwanAppProcessInfo.indexOf(msg.arg1);
            if (process.isSwanAppProcess() && (client = getClientObj(process)) != null && (msg.obj instanceof Bundle)) {
                Bundle bundle = (Bundle) msg.obj;
                bundle.setClassLoader(getClass().getClassLoader());
                client.updateLaunchCost(bundle.getLong("property_launch_cost", -1));
            }
        }
    }

    public void logStatus() {
        logStatus((String) null);
    }

    public void logStatus(String action) {
        if (DEBUG) {
            Log.i(TAG, "\nlogStatus by " + (TextUtils.isEmpty(action) ? "" : action) + ":\n" + toString());
        }
    }

    public String toString() {
        Collection<SwanClientPuppet> clients = getClientObjs();
        StringBuilder sb = new StringBuilder().append(super.toString()).append(":").append("\n-> clients: ");
        for (SwanClientPuppet client : clients) {
            sb.append("\n--> ").append(client.toString());
        }
        return sb.toString();
    }
}
