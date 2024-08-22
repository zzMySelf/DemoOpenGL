package com.baidu.cyberplayer.sdk.remote;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberPlayerCoreInvoker;
import com.baidu.cyberplayer.sdk.DuMediaPrefetchBase;
import com.baidu.cyberplayer.sdk.InstallBase;
import com.baidu.cyberplayer.sdk.PlayerConfigManager;
import com.baidu.cyberplayer.sdk.Utils;
import com.baidu.cyberplayer.sdk.config.DuMediaCfgConstants;
import com.baidu.cyberplayer.sdk.downloadcore.DuMediaDownloaderInfoBase;
import com.baidu.cyberplayer.sdk.remote.IDuMediaInstallListener;
import com.baidu.cyberplayer.sdk.remote.IRemotePlayerFactory;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemotePlayerFactory {
    public static final int BINDER_ALIVE = 1;
    private static final int BINDER_DIED = -1;
    private static final int BINDER_IDLE = 0;
    private static final int BINDER_RECOVERING = 2;
    private static final int BINDER_RECOVER_FAILED = -2;
    private static final String TAG = "RemotePlayerFactory";
    private static volatile RemotePlayerFactory sInstance = null;
    /* access modifiers changed from: private */
    public volatile boolean installSucessState = false;
    /* access modifiers changed from: private */
    public volatile int mBinderState = 0;
    /* access modifiers changed from: private */
    public String mClientID;
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CyberLog.i(RemotePlayerFactory.TAG, "Remote service connected");
            IRemotePlayerFactory unused = RemotePlayerFactory.this.mRemoteBinder = IRemotePlayerFactory.Stub.asInterface(iBinder);
            synchronized (RemotePlayerFactory.this) {
                int unused2 = RemotePlayerFactory.this.mBinderState = 1;
                UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.CONNECTED, System.currentTimeMillis());
            }
            try {
                RemotePlayerFactory.this.mRemoteBinder.asBinder().linkToDeath(RemotePlayerFactory.this.mDeathRecipient, 0);
                if (RemotePlayerFactory.this.mPrefetchListenerProxy != null) {
                    RemotePlayerFactory.this.mRemoteBinder.setPrefetchListener(RemotePlayerFactory.this.mPrefetchListenerProxy);
                }
                if (Utils.isAppInDebugMode()) {
                    if (RemotePlayerFactory.this.mDownloaderInfoListenerProxy != null) {
                        RemotePlayerFactory.this.mRemoteBinder.setDownloaderInfoListener(RemotePlayerFactory.this.mDownloaderInfoListenerProxy);
                    }
                    RemotePlayerFactory.this.mRemoteBinder.setDuMediaInstallListener(new IDuMediaInstallListener.Stub() {
                        public void onInstallSuccessed() {
                            CyberLog.i(RemotePlayerFactory.TAG, "setDownloaderInfoListenerRemote");
                            CyberPlayerCoreInvoker.setDownloaderInfoListenerRemote();
                        }

                        public IBinder asBinder() {
                            return null;
                        }
                    });
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                boolean unused3 = RemotePlayerFactory.this.installSucessState = false;
                IRemotePlayerFactory unused4 = RemotePlayerFactory.this.mRemoteBinder = null;
                synchronized (RemotePlayerFactory.this) {
                    int unused5 = RemotePlayerFactory.this.mBinderState = -1;
                    UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.LINK_DEATH_FAILED, System.currentTimeMillis());
                }
            }
            RemotePlayerFactory remotePlayerFactory = RemotePlayerFactory.this;
            remotePlayerFactory.remoteInstallNewType(remotePlayerFactory.mInstallType);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            CyberLog.e(RemotePlayerFactory.TAG, "RemotePlayer service disconnected");
            boolean unused = RemotePlayerFactory.this.installSucessState = false;
            IRemotePlayerFactory unused2 = RemotePlayerFactory.this.mRemoteBinder = null;
            synchronized (RemotePlayerFactory.this) {
                RemotePlayerFactory remotePlayerFactory = RemotePlayerFactory.this;
                int i2 = 2;
                if (remotePlayerFactory.mBinderState != 2) {
                    i2 = -1;
                }
                int unused3 = remotePlayerFactory.mBinderState = i2;
                UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.DISCONNECTED, System.currentTimeMillis());
            }
        }
    };
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        public void binderDied() {
            CyberLog.i(RemotePlayerFactory.TAG, "RemotePlayer service binder died");
            boolean unused = RemotePlayerFactory.this.installSucessState = false;
            if (RemotePlayerFactory.this.mRemoteBinder != null) {
                RemotePlayerFactory.this.mRemoteBinder.asBinder().unlinkToDeath(RemotePlayerFactory.this.mDeathRecipient, 0);
                IRemotePlayerFactory unused2 = RemotePlayerFactory.this.mRemoteBinder = null;
                synchronized (RemotePlayerFactory.this) {
                    int unused3 = RemotePlayerFactory.this.mBinderState = -1;
                    UbcRemoteStat.getInstance().updateUbcStat(UbcRemoteStat.BINDER_DIED, System.currentTimeMillis());
                    UbcRemoteStat.getInstance().uploadUbcStat();
                }
            }
            synchronized (RemotePlayerFactory.this.mLock) {
                Iterator<WeakReference<RemoteServerListener>> it = RemotePlayerFactory.this.mListenersList.iterator();
                while (it.hasNext()) {
                    RemoteServerListener listener = (RemoteServerListener) it.next().get();
                    if (listener != null) {
                        listener.binderDied();
                    } else {
                        it.remove();
                    }
                }
                RemotePlayerFactory.this.mListenersList.clear();
            }
            RemotePlayerFactory remotePlayerFactory = RemotePlayerFactory.this;
            remotePlayerFactory.connectRemote(remotePlayerFactory.mServiceClass, RemotePlayerFactory.this.mClientID, RemotePlayerFactory.this.mInstallType, InstallBase.getInstallOpts(), RemotePlayerFactory.this.mPcdnType);
        }
    };
    /* access modifiers changed from: private */
    public RemoteDownloaderInfoListenerProxy mDownloaderInfoListenerProxy = null;
    private boolean mEnableCallRemoteAsyncOpt = false;
    private boolean mInitMediaProcessSwitch = false;
    /* access modifiers changed from: private */
    public int mInstallType;
    /* access modifiers changed from: private */
    public ArrayList<WeakReference<RemoteServerListener>> mListenersList = new ArrayList<>();
    /* access modifiers changed from: private */
    public final Object mLock = new Object();
    private boolean mMediaProcessOpti = false;
    /* access modifiers changed from: private */
    public int mPcdnType;
    /* access modifiers changed from: private */
    public RemotePrefetchListenerProxy mPrefetchListenerProxy = null;
    /* access modifiers changed from: private */
    public volatile IRemotePlayerFactory mRemoteBinder;
    /* access modifiers changed from: private */
    public Class<?> mServiceClass;

    public interface RemoteServerListener {
        void binderDied();
    }

    public static RemotePlayerFactory getInstance() {
        if (sInstance == null) {
            synchronized (RemotePlayerFactory.class) {
                if (sInstance == null) {
                    sInstance = new RemotePlayerFactory();
                }
            }
        }
        return sInstance;
    }

    private RemotePlayerFactory() {
    }

    public synchronized int getBinderState() {
        return this.mBinderState;
    }

    /* Debug info: failed to restart local var, previous not found, register: 10 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public void connectRemote(java.lang.Class<?> r11, java.lang.String r12, int r13, java.util.Map<java.lang.String, java.lang.String> r14, int r15) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "RemotePlayerFactory"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RemotePlayer connectRemote connect service: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r13)
            java.lang.String r1 = r1.toString()
            com.baidu.cyberplayer.sdk.CyberLog.i(r0, r1)
            r10.mServiceClass = r11
            r10.mClientID = r12
            r10.mPcdnType = r15
            r10.mInstallType = r13
            java.lang.String r0 = "zeus_init_refactor"
            r1 = 1
            boolean r0 = com.baidu.cyberplayer.sdk.PlayerConfigManager.get((java.lang.String) r0, (boolean) r1)
            android.content.Intent r2 = new android.content.Intent
            android.content.Context r3 = com.baidu.cyberplayer.sdk.InstallBase.getApplicationContext()
            java.lang.Class<?> r4 = r10.mServiceClass
            r2.<init>(r3, r4)
            java.lang.String r3 = "clientID"
            java.lang.String r4 = r10.mClientID
            r2.putExtra(r3, r4)
            java.lang.String r3 = "installType"
            int r4 = r10.mInstallType
            r2.putExtra(r3, r4)
            java.lang.String r3 = com.baidu.cyberplayer.sdk.PlayerConfigManager.getAppPlayerConfigOptions()
            if (r14 == 0) goto L_0x0059
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L_0x0059
            java.lang.String r4 = "appPlayerConfigOpts"
            java.lang.String r4 = com.baidu.cyberplayer.sdk.utils.MD5Util.string2md5(r4)
            r14.put(r4, r3)
        L_0x0059:
            java.util.Map r4 = com.baidu.cyberplayer.sdk.PlayerConfigManager.getConditions()     // Catch:{ Exception -> 0x009d }
            if (r14 == 0) goto L_0x009c
            if (r4 == 0) goto L_0x009c
            int r5 = r4.size()     // Catch:{ Exception -> 0x009d }
            if (r5 <= 0) goto L_0x009c
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x009d }
            r5.<init>()     // Catch:{ Exception -> 0x009d }
            java.util.Set r6 = r4.entrySet()     // Catch:{ Exception -> 0x009d }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x009d }
        L_0x0074:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x009d }
            if (r7 == 0) goto L_0x008f
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x009d }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x009d }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x009d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x009d }
            java.lang.Object r9 = r7.getValue()     // Catch:{ Exception -> 0x009d }
            r5.put(r8, r9)     // Catch:{ Exception -> 0x009d }
            goto L_0x0074
        L_0x008f:
            java.lang.String r6 = "globalConditions"
            java.lang.String r6 = com.baidu.cyberplayer.sdk.utils.MD5Util.string2md5(r6)     // Catch:{ Exception -> 0x009d }
            java.lang.String r7 = r5.toString()     // Catch:{ Exception -> 0x009d }
            r14.put(r6, r7)     // Catch:{ Exception -> 0x009d }
        L_0x009c:
            goto L_0x009e
        L_0x009d:
            r4 = move-exception
        L_0x009e:
            if (r14 == 0) goto L_0x00b0
            java.lang.String r4 = "binder_enable_sdk_player_refract"
            boolean r5 = com.baidu.cyberplayer.sdk.PlayerConfigManager.isSDKPlayerRefactorEnable()
            if (r5 == 0) goto L_0x00ab
            java.lang.String r5 = "1"
            goto L_0x00ad
        L_0x00ab:
            java.lang.String r5 = "0"
        L_0x00ad:
            r14.put(r4, r5)
        L_0x00b0:
            java.lang.String r4 = "installOpts"
            r5 = r14
            java.io.Serializable r5 = (java.io.Serializable) r5
            r2.putExtra(r4, r5)
            java.lang.String r4 = "isZeusLauncher"
            r2.putExtra(r4, r0)
            java.lang.String r4 = "pcdnType"
            int r5 = r10.mPcdnType
            r2.putExtra(r4, r5)
            java.lang.String r4 = "mediaProcessOpti"
            boolean r5 = r10.isMedisProccessOpti()
            r2.putExtra(r4, r5)
            r4 = 0
            android.content.Context r5 = com.baidu.cyberplayer.sdk.InstallBase.getApplicationContext()     // Catch:{ Exception -> 0x00f0 }
            android.content.ServiceConnection r6 = r10.mConnection     // Catch:{ Exception -> 0x00f0 }
            boolean r5 = r5.bindService(r2, r6, r1)     // Catch:{ Exception -> 0x00f0 }
            r4 = r5
            monitor-enter(r10)     // Catch:{ Exception -> 0x00f0 }
            r5 = 2
            r10.mBinderState = r5     // Catch:{ all -> 0x00ed }
            com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat r5 = com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat.getInstance()     // Catch:{ all -> 0x00ed }
            java.lang.String r6 = "bind"
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ed }
            r5.updateUbcStat(r6, r7)     // Catch:{ all -> 0x00ed }
            monitor-exit(r10)     // Catch:{ all -> 0x00ed }
            goto L_0x00f8
        L_0x00ed:
            r5 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00ed }
            throw r5     // Catch:{ Exception -> 0x00f0 }
        L_0x00f0:
            r5 = move-exception
            java.lang.String r6 = "RemotePlayerFactory"
            java.lang.String r7 = "Failed binding to service!"
            com.baidu.cyberplayer.sdk.CyberLog.e(r6, r7)
        L_0x00f8:
            if (r4 != 0) goto L_0x0117
            java.lang.String r5 = "RemotePlayerFactory"
            java.lang.String r6 = "Failed binding to service! need retry!"
            com.baidu.cyberplayer.sdk.CyberLog.i(r5, r6)
            monitor-enter(r10)
            r5 = -2
            r10.mBinderState = r5     // Catch:{ all -> 0x0114 }
            com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat r5 = com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat.getInstance()     // Catch:{ all -> 0x0114 }
            java.lang.String r6 = "bindFail"
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0114 }
            r5.updateUbcStat(r6, r7)     // Catch:{ all -> 0x0114 }
            monitor-exit(r10)     // Catch:{ all -> 0x0114 }
            goto L_0x0117
        L_0x0114:
            r1 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0114 }
            throw r1
        L_0x0117:
            int r5 = r10.mInstallType
            r10.remoteInstallNewType(r5)
            java.lang.String r5 = "exp_enable_call_remote_async_opt"
            boolean r1 = com.baidu.cyberplayer.sdk.PlayerConfigManager.getFast((java.lang.String) r5, (boolean) r1)
            r10.mEnableCallRemoteAsyncOpt = r1
            java.lang.String r1 = "RemotePlayerFactory"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "connectRemote end, mEnableCallRemoteAsyncOpt:"
            java.lang.StringBuilder r5 = r5.append(r6)
            boolean r6 = r10.mEnableCallRemoteAsyncOpt
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.baidu.cyberplayer.sdk.CyberLog.i(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.cyberplayer.sdk.remote.RemotePlayerFactory.connectRemote(java.lang.Class, java.lang.String, int, java.util.Map, int):void");
    }

    public IBinder createPlayer(int mode) {
        if (!isBindleValid()) {
            return null;
        }
        try {
            return this.mRemoteBinder.createPlayer(mode);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public IBinder createPlayer2(IDuMediaPlayerClient client, int mode) {
        if (!isBindleValid()) {
            return null;
        }
        try {
            return this.mRemoteBinder.createPlayer2(client, mode);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public IBinder createExtractor() {
        if (!isBindleValid()) {
            return null;
        }
        try {
            return this.mRemoteBinder.createExtractor();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void setDownloaderInfoListener(DuMediaDownloaderInfoBase.OnDownloaderInfoListener listener) {
        if (Utils.isAppInDebugMode() && this.mRemoteBinder != null) {
            CyberLog.w(TAG, "setDownloaderInfoListener:" + listener);
            boolean needUpdateListener = true;
            RemoteDownloaderInfoListenerProxy remoteDownloaderInfoListenerProxy = this.mDownloaderInfoListenerProxy;
            if (remoteDownloaderInfoListenerProxy == null) {
                this.mDownloaderInfoListenerProxy = new RemoteDownloaderInfoListenerProxy(listener);
            } else {
                needUpdateListener = remoteDownloaderInfoListenerProxy.updateDownloaderInfoListener(listener);
            }
            if (needUpdateListener) {
                try {
                    CyberLog.i(TAG, "mRemoteBinder.setDownloaderInfoListener");
                    this.mRemoteBinder.setDownloaderInfoListener(this.mDownloaderInfoListenerProxy);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean setPrefetchListener(DuMediaPrefetchBase.OnPrefetchListener listerner) {
        if (this.mRemoteBinder == null) {
            return false;
        }
        CyberLog.w(TAG, "[PrefetchCallback]setPrefetchListenertusChanged:" + listerner);
        boolean needUpdateListener = true;
        RemotePrefetchListenerProxy remotePrefetchListenerProxy = this.mPrefetchListenerProxy;
        if (remotePrefetchListenerProxy == null) {
            this.mPrefetchListenerProxy = new RemotePrefetchListenerProxy(listerner);
        } else {
            needUpdateListener = remotePrefetchListenerProxy.updatePrefetchListener(listerner);
        }
        if (!needUpdateListener) {
            return true;
        }
        try {
            this.mRemoteBinder.setPrefetchListener(this.mPrefetchListenerProxy);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean prefetch(String url, String ua, String header, int type, int prefetchOffset, int prefetchSize, String stageType, int pcdnEnableByUser, int kernelNetEnableByUser, int p2pEnableByUser, int pcdnTypeByUser, DuMediaPrefetchOptions options, DuMediaPrefetchBase.OnPrefetchListener listener) {
        if (!isBindleValid()) {
            return false;
        }
        try {
            setPrefetchListener(listener);
            if (this.mEnableCallRemoteAsyncOpt) {
                this.mRemoteBinder.prefetchAsync(url, ua, header, type, prefetchOffset, prefetchSize, stageType, pcdnEnableByUser, kernelNetEnableByUser, p2pEnableByUser, pcdnTypeByUser, options);
                return true;
            }
            this.mRemoteBinder.prefetch(url, ua, header, type, prefetchOffset, prefetchSize, stageType, pcdnEnableByUser, kernelNetEnableByUser, p2pEnableByUser, pcdnTypeByUser, options);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public int getNetworkRank() {
        if (this.mRemoteBinder == null) {
            return -1;
        }
        try {
            return this.mRemoteBinder.getNetworkRank();
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public void setAppCondition(String key, String value) {
        if (this.mRemoteBinder != null) {
            try {
                if (this.mEnableCallRemoteAsyncOpt) {
                    this.mRemoteBinder.setAppConditionAsync(key, value);
                } else {
                    this.mRemoteBinder.setAppCondition(key, value);
                }
            } catch (RemoteException e2) {
            }
        }
    }

    public void setAppOption(String key, String value) {
        if (this.mRemoteBinder != null) {
            try {
                if (this.mEnableCallRemoteAsyncOpt) {
                    this.mRemoteBinder.setAppOptionAsync(key, value);
                } else {
                    this.mRemoteBinder.setAppOption(key, value);
                }
            } catch (RemoteException e2) {
            }
        }
    }

    public void setAppOptionWithCond(String key, String value, LinkedHashMap<String, String> condition) {
        if (this.mRemoteBinder != null) {
            String[] array = null;
            if (condition != null) {
                try {
                    if (condition.size() > 0) {
                        array = new String[(condition.size() * 2)];
                        int index = 0;
                        for (Map.Entry<String, String> entry : condition.entrySet()) {
                            array[index] = entry.getKey();
                            array[index + 1] = entry.getValue();
                            index += 2;
                        }
                    }
                } catch (RemoteException e2) {
                    return;
                }
            }
            if (this.mEnableCallRemoteAsyncOpt != 0) {
                this.mRemoteBinder.setAppOptionWithCondAsync(key, value, array);
            } else {
                this.mRemoteBinder.setAppOptionWithCond(key, value, array);
            }
        }
    }

    public void sendGlobalCommandToRemote(String what, int arg1, long arg2, String arg3, DuMediaPrefetchOptions options) {
        sendGlobalCommandToRemote(what, arg1, arg2, arg3, options, false);
    }

    public void sendGlobalCommandToRemote(String what, int arg1, long arg2, String arg3, DuMediaPrefetchOptions options, boolean forceSync) {
        if (this.mRemoteBinder != null) {
            if (!forceSync) {
                try {
                    if (this.mEnableCallRemoteAsyncOpt) {
                        this.mRemoteBinder.sendGlobalCommondAsync(what, arg1, arg2, arg3, options);
                        return;
                    }
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            this.mRemoteBinder.sendGlobalCommond(what, arg1, arg2, arg3, options);
        }
    }

    public int hasCacheFile(String url) {
        if (this.mRemoteBinder == null) {
            return -1;
        }
        try {
            return this.mRemoteBinder.hasCacheFile(url) ? 1 : 0;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public long getVideoCacheSizeCanBeCleared() {
        if (this.mRemoteBinder == null) {
            return -1;
        }
        try {
            return this.mRemoteBinder.calculateVideoCacheSizeCanBeCleared();
        } catch (RemoteException e2) {
            return -1;
        }
    }

    public boolean updatePlayerConfig(String json) {
        if (this.mRemoteBinder == null) {
            return false;
        }
        try {
            this.mRemoteBinder.updatePlayerConfig(json);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void addListener(RemoteServerListener l) {
        synchronized (this.mLock) {
            this.mListenersList.add(new WeakReference(l));
        }
    }

    public void removeListener(RemoteServerListener l) {
        synchronized (this.mLock) {
            Iterator<WeakReference<RemoteServerListener>> it = this.mListenersList.iterator();
            while (it.hasNext()) {
                RemoteServerListener listener = (RemoteServerListener) it.next().get();
                if (listener == null || listener.equals(l)) {
                    it.remove();
                }
            }
        }
    }

    public IBinder createDownloader(int type, String dir, DuMediaPrefetchOptions options) {
        if (!isBindleValid()) {
            return null;
        }
        try {
            return this.mRemoteBinder.createDownloader(type, dir, options);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void remoteInstallNewType(int installType) {
        if (this.mRemoteBinder != null) {
            try {
                CyberLog.d(TAG, "RemoteBinder remoteInstallNewType: " + installType);
                if (this.mEnableCallRemoteAsyncOpt) {
                    this.mRemoteBinder.remoteInstallNewTypeAsync(installType);
                } else {
                    this.mRemoteBinder.remoteInstallNewType(installType);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean remoteInstallSuccess() {
        if (this.mRemoteBinder == null) {
            return false;
        }
        try {
            return this.mRemoteBinder.remoteInstallSuccess();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean isBindleValid() {
        if (this.mRemoteBinder == null) {
            return false;
        }
        if (isMedisProccessOpti()) {
            try {
                if (!this.installSucessState) {
                    this.installSucessState = this.mRemoteBinder.remoteInstallSuccess();
                }
                return this.installSucessState;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } else if (this.mRemoteBinder != null) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMedisProccessOpti() {
        if (!this.mInitMediaProcessSwitch) {
            this.mMediaProcessOpti = PlayerConfigManager.get(DuMediaCfgConstants.KEY_MEDIA_PROCESS_INIT_OPTI, true);
            this.mInitMediaProcessSwitch = true;
        }
        return this.mMediaProcessOpti;
    }
}
