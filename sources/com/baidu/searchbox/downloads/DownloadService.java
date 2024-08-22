package com.baidu.searchbox.downloads;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.OpenDownloadReceiver;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.business.util.DownloadUtils;
import com.baidu.searchbox.download.callback.IDownloadServiceCallback;
import com.baidu.searchbox.download.callback.ISystemFacade;
import com.baidu.searchbox.download.component.DownloadReceiver;
import com.baidu.searchbox.download.component.RealSystemFacade;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import com.baidu.searchbox.download.ioc.IDownloadApp;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.Constants;
import com.baidu.searchbox.download.model.DownloadInfo;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.downloads.DownloadManagerContentObserver;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadService {
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final int MSG_UPDATE_FROM_PROVIDER = 1;
    public static final String TAG = "DownloadService";
    private static final long WAIT_TIMEOUT = 10000;
    private static DownloadService sInstance;
    /* access modifiers changed from: private */
    public Context mContext = AppRuntime.getAppContext();
    /* access modifiers changed from: private */
    public Map<Long, DownloadInfo> mDownloads = new HashMap();
    ISystemFacade mISystemFacade;
    /* access modifiers changed from: private */
    public AtomicBoolean mIsUpdating = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public boolean mMediaScannerConnecting;
    /* access modifiers changed from: private */
    public MyMediaScannerConnection mMediaScannerConnection;
    /* access modifiers changed from: private */
    public MyMediaScannerConnectionClient mMediaScannerConnectionClient;
    /* access modifiers changed from: private */
    public Object mMediaScannerService;
    private BroadcastReceiver mNotificationReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            DownloadInfo[] infos;
            String action = intent.getAction();
            if (action.equals(DownloadConstants.ACTION_DOWNLOAD_STOP_NOTIFICATION)) {
                boolean unused = DownloadService.this.mNotificationStopped = true;
                if (DownloadService.this.mISystemFacade == null) {
                    DownloadService.this.mISystemFacade = new RealSystemFacade(context);
                }
                synchronized (DownloadService.this.mDownloads) {
                    Collection<DownloadInfo> values = DownloadService.this.mDownloads.values();
                    infos = (DownloadInfo[]) values.toArray(new DownloadInfo[values.size()]);
                }
                for (DownloadInfo info : infos) {
                    if (!(info == null || info.mStatus == 200)) {
                        DownloadService.this.mISystemFacade.cancelNotification(info.mId);
                    }
                }
            } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_START_NOTIFICATION)) {
                boolean unused2 = DownloadService.this.mNotificationStopped = false;
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mNotificationStopped;
    /* access modifiers changed from: private */
    public DownloadNotification mNotifier;
    private DownloadManagerContentObserver mObserver;
    /* access modifiers changed from: private */
    public volatile boolean mPendingUpdate;
    /* access modifiers changed from: private */
    public volatile HandlerThread mUpdateHandlerThread;
    /* access modifiers changed from: private */
    public volatile UpdateHandler mUpdateThreadHandler;

    public interface OnScanCompletedListener {
        void onScanCompleted(String str, Uri uri);
    }

    public static DownloadService getInstance() {
        if (sInstance == null) {
            synchronized (DownloadManagerExt.class) {
                if (sInstance == null) {
                    sInstance = new DownloadService();
                }
            }
        }
        return sInstance;
    }

    private DownloadService() {
        init();
    }

    private void registerNotificationReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadConstants.ACTION_DOWNLOAD_STOP_NOTIFICATION);
        filter.addAction(DownloadConstants.ACTION_DOWNLOAD_START_NOTIFICATION);
        filter.addAction(DownloadConstants.ACTION_DOWNLOAD_COMPLETE);
        DownloadUtils.safeRegisterReceiver(this.mContext, this.mNotificationReceiver, filter);
    }

    private void registerDownloadedReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadConstants.ACTION_DOWNLOAD_STOP_NOTIFICATION);
        filter.addAction(DownloadConstants.ACTION_DOWNLOAD_START_NOTIFICATION);
        DownloadUtils.safeRegisterReceiver(this.mContext, this.mNotificationReceiver, filter);
    }

    private void unregisterNotificationReceiver() {
        DownloadUtils.safeUnRegisterReceiver(this.mContext, this.mNotificationReceiver);
    }

    public class MyMediaScannerConnection extends MediaScannerConnection {
        public MyMediaScannerConnection(Context context, MediaScannerConnection.MediaScannerConnectionClient client) {
            super(context, client);
        }

        /* Debug info: failed to restart local var, previous not found, register: 3 */
        public void onServiceConnected(ComponentName className, IBinder service) {
            super.onServiceConnected(className, service);
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "Connected to Media Scanner");
            }
            synchronized (DownloadService.this) {
                try {
                    boolean unused = DownloadService.this.mMediaScannerConnecting = false;
                    Object unused2 = DownloadService.this.mMediaScannerService = this;
                    if (DownloadService.this.mMediaScannerService != null) {
                        DownloadService.this.updateFromProvider();
                    }
                    DownloadService.this.notifyAll();
                } catch (Throwable th2) {
                    DownloadService.this.notifyAll();
                    throw th2;
                }
            }
        }

        public void onServiceDisconnected(ComponentName className) {
            super.onServiceDisconnected(className);
            try {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "Disconnected from Media Scanner");
                }
                synchronized (DownloadService.this) {
                    Object unused = DownloadService.this.mMediaScannerService = null;
                    boolean unused2 = DownloadService.this.mMediaScannerConnecting = false;
                    DownloadService.this.notifyAll();
                }
            } catch (Throwable th2) {
                synchronized (DownloadService.this) {
                    Object unused3 = DownloadService.this.mMediaScannerService = null;
                    boolean unused4 = DownloadService.this.mMediaScannerConnecting = false;
                    DownloadService.this.notifyAll();
                    throw th2;
                }
            }
        }

        /* Debug info: failed to restart local var, previous not found, register: 5 */
        public void disconnectMediaScanner() {
            DownloadService downloadService;
            synchronized (DownloadService.this) {
                boolean unused = DownloadService.this.mMediaScannerConnecting = false;
                if (DownloadService.this.mMediaScannerService != null) {
                    Object unused2 = DownloadService.this.mMediaScannerService = null;
                    if (Constants.LOGVV) {
                        Log.v("DownloadManager", "Disconnecting from Media Scanner");
                    }
                    try {
                        disconnect();
                        downloadService = DownloadService.this;
                    } catch (IllegalArgumentException ex) {
                        try {
                            Log.w("DownloadManager", "unbindService failed: " + ex);
                            downloadService = DownloadService.this;
                        } catch (Throwable th2) {
                            DownloadService.this.notifyAll();
                            throw th2;
                        }
                    }
                    downloadService.notifyAll();
                }
            }
        }
    }

    static class MyMediaScannerConnectionClient implements MediaScannerConnection.MediaScannerConnectionClient {
        OnScanCompletedListener listener;

        MyMediaScannerConnectionClient() {
        }

        public void onMediaScannerConnected() {
        }

        public void onScanCompleted(String path, Uri uri) {
            OnScanCompletedListener onScanCompletedListener = this.listener;
            if (onScanCompletedListener != null) {
                onScanCompletedListener.onScanCompleted(path, uri);
            }
        }
    }

    public void init() {
        if (DEBUG) {
            Log.e(TAG, "DownloadService init()");
        }
        if (Constants.LOGVV) {
            Log.v("DownloadManager", "Service onCreate");
        }
        dealComponetsDisabled();
        Context context = this.mContext;
        if (context instanceof IDownloadServiceCallback) {
            ((IDownloadServiceCallback) context).onDownloadServiceCreate();
        }
        if (this.mISystemFacade == null) {
            this.mISystemFacade = new RealSystemFacade(this.mContext);
        }
        DownloadManagerContentObserver downloadManagerContentObserver = new DownloadManagerContentObserver();
        this.mObserver = downloadManagerContentObserver;
        downloadManagerContentObserver.setChange(new DownloadManagerContentObserver.ChangeProxy() {
            public void onChange(boolean selfChange) {
                if (Constants.LOGVV) {
                    Log.v("DownloadManager", "Service ContentObserver received notification");
                }
                DownloadService.this.updateFromProvider();
            }
        });
        this.mContext.getContentResolver().registerContentObserver(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, true, this.mObserver);
        synchronized (this) {
            this.mMediaScannerService = null;
            this.mMediaScannerConnecting = false;
        }
        this.mMediaScannerConnectionClient = new MyMediaScannerConnectionClient();
        this.mMediaScannerConnection = new MyMediaScannerConnection(this.mContext, this.mMediaScannerConnectionClient);
        this.mNotifier = DownloadNotification.getInstance();
        registerNotificationReceiver();
        if (!DownloadSharedPrefsUtils.getInstance().getBoolean(DownloadCenterUtils.DOWNLOAD_COLD_OP_2, true)) {
            updateFromProvider();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        this.mContext.getContentResolver().unregisterContentObserver(this.mObserver);
        if (Constants.LOGVV) {
            Log.v("DownloadManager", "Service onDestroy");
        }
        unregisterNotificationReceiver();
        this.mMediaScannerConnection.disconnectMediaScanner();
        if (DEBUG) {
            Log.e(TAG, "DownloadService finalize()");
        }
        super.finalize();
    }

    /* access modifiers changed from: private */
    public void updateFromProvider() {
        if (DownloadSharedPrefsUtils.getInstance().getBoolean(DownloadCenterUtils.DOWNLOAD_COLD_OP_2, true)) {
            synchronized (this) {
                this.mPendingUpdate = true;
                if (this.mUpdateHandlerThread == null || !this.mUpdateHandlerThread.isAlive()) {
                    this.mUpdateHandlerThread = new HandlerThread("Download Service", 10);
                    this.mISystemFacade.startThread(this.mUpdateHandlerThread);
                    ExecutorUtilsExt.postOnElastic(new Runnable() {
                        public void run() {
                            DownloadService downloadService = DownloadService.this;
                            DownloadService downloadService2 = DownloadService.this;
                            UpdateHandler unused = downloadService.mUpdateThreadHandler = new UpdateHandler(downloadService2.mUpdateHandlerThread.getLooper());
                            DownloadService.this.mUpdateThreadHandler.removeMessages(1);
                            DownloadService.this.mUpdateThreadHandler.sendMessage(DownloadService.this.mUpdateThreadHandler.obtainMessage(1));
                        }
                    }, "updateFromProvider", 4);
                }
            }
            if (!this.mIsUpdating.get() && this.mUpdateThreadHandler != null) {
                this.mUpdateThreadHandler.removeMessages(1);
                this.mUpdateThreadHandler.sendMessage(this.mUpdateThreadHandler.obtainMessage(1));
                return;
            }
            return;
        }
        synchronized (this) {
            this.mPendingUpdate = true;
            if (this.mUpdateHandlerThread == null || !this.mUpdateHandlerThread.isAlive()) {
                this.mUpdateHandlerThread = new HandlerThread("Download Service", 10);
                this.mISystemFacade.startThread(this.mUpdateHandlerThread);
                this.mUpdateThreadHandler = new UpdateHandler(this.mUpdateHandlerThread.getLooper());
            }
        }
        if (!this.mIsUpdating.get()) {
            this.mUpdateThreadHandler.removeMessages(1);
            this.mUpdateThreadHandler.sendMessage(this.mUpdateThreadHandler.obtainMessage(1));
        }
    }

    public void start() {
        updateFromProvider();
    }

    private class UpdateHandler extends Handler {
        public UpdateHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                doUpdate();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x0217 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00d8 A[Catch:{ Exception -> 0x0108, all -> 0x0103 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00e3 A[Catch:{ Exception -> 0x0108, all -> 0x0103 }] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00e5 A[Catch:{ Exception -> 0x0108, all -> 0x0103 }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0117 A[LOOP:2: B:63:0x0111->B:65:0x0117, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0129  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x015c  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0171  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0177  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0194  */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x0222 A[LOOP:0: B:1:0x001e->B:99:0x0222, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void doUpdate() {
            /*
                r23 = this;
                r1 = r23
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.mIsUpdating
                r2 = 1
                r0.set(r2)
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                r0.trimDatabase()
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                r0.removeSpuriousFiles()
                r0 = 0
                r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r4 = r3
                r3 = r0
            L_0x001e:
                com.baidu.searchbox.downloads.DownloadService r6 = com.baidu.searchbox.downloads.DownloadService.this
                monitor-enter(r6)
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this     // Catch:{ all -> 0x0225 }
                r7 = 0
                boolean unused = r0.mPendingUpdate = r7     // Catch:{ all -> 0x0225 }
                monitor-exit(r6)     // Catch:{ all -> 0x0225 }
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                com.baidu.searchbox.download.callback.ISystemFacade r0 = r0.mISystemFacade
                long r8 = r0.currentTimeMillis()
                r6 = 0
                r3 = 0
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                java.util.HashSet r0 = new java.util.HashSet
                com.baidu.searchbox.downloads.DownloadService r10 = com.baidu.searchbox.downloads.DownloadService.this
                java.util.Map r10 = r10.mDownloads
                java.util.Set r10 = r10.keySet()
                r0.<init>(r10)
                r10 = r0
                r11 = 0
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                android.content.Context r0 = r0.mContext     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                android.content.ContentResolver r12 = r0.getContentResolver()     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                android.net.Uri r13 = com.baidu.searchbox.download.model.Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
                android.database.Cursor r0 = r12.query(r13, r14, r15, r16, r17)     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                r11 = r0
                if (r11 != 0) goto L_0x0065
                com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r11)
                return
            L_0x0065:
                com.baidu.searchbox.download.model.DownloadInfo$Reader r0 = new com.baidu.searchbox.download.model.DownloadInfo$Reader     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                com.baidu.searchbox.downloads.DownloadService r12 = com.baidu.searchbox.downloads.DownloadService.this     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                android.content.Context r12 = r12.mContext     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                android.content.ContentResolver r12 = r12.getContentResolver()     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                r0.<init>(r12, r11)     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                java.lang.String r12 = "_id"
                int r12 = r11.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                r11.moveToFirst()     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
            L_0x007d:
                boolean r13 = r11.isAfterLast()     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                if (r13 != 0) goto L_0x00f5
                long r13 = r11.getLong(r12)     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                java.lang.Long r15 = java.lang.Long.valueOf(r13)     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                r10.remove(r15)     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                com.baidu.searchbox.downloads.DownloadService r15 = com.baidu.searchbox.downloads.DownloadService.this     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                java.util.Map r15 = r15.mDownloads     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                java.lang.Long r2 = java.lang.Long.valueOf(r13)     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                java.lang.Object r2 = r15.get(r2)     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                com.baidu.searchbox.download.model.DownloadInfo r2 = (com.baidu.searchbox.download.model.DownloadInfo) r2     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                if (r2 == 0) goto L_0x00a6
                com.baidu.searchbox.downloads.DownloadService r15 = com.baidu.searchbox.downloads.DownloadService.this     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                r15.updateDownload(r0, r2, r8)     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                goto L_0x00ad
            L_0x00a6:
                com.baidu.searchbox.downloads.DownloadService r15 = com.baidu.searchbox.downloads.DownloadService.this     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                com.baidu.searchbox.download.model.DownloadInfo r15 = r15.insertDownload(r0, r8)     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                r2 = r15
            L_0x00ad:
                boolean r15 = r2.shouldScanFile()     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                if (r15 == 0) goto L_0x00ce
                com.baidu.searchbox.downloads.DownloadService r15 = com.baidu.searchbox.downloads.DownloadService.this     // Catch:{ Exception -> 0x00ff, all -> 0x00fb }
                r17 = r3
                r3 = 1
                boolean r15 = r15.scanFile(r2, r3, r7)     // Catch:{ Exception -> 0x00ca, all -> 0x00c6 }
                if (r15 != 0) goto L_0x00d0
                r3 = 1
                r6 = 1
                r22 = r6
                r6 = r3
                r3 = r22
                goto L_0x00d2
            L_0x00c6:
                r0 = move-exception
                r3 = r17
                goto L_0x0104
            L_0x00ca:
                r0 = move-exception
                r3 = r17
                goto L_0x0109
            L_0x00ce:
                r17 = r3
            L_0x00d0:
                r3 = r17
            L_0x00d2:
                boolean r15 = r2.hasCompletionNotification()     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                if (r15 == 0) goto L_0x00d9
                r3 = 1
            L_0x00d9:
                long r17 = r2.nextAction(r8)     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                r19 = 0
                int r15 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
                if (r15 != 0) goto L_0x00e5
                r3 = 1
                goto L_0x00f0
            L_0x00e5:
                int r15 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
                if (r15 <= 0) goto L_0x00f0
                int r15 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
                if (r15 >= 0) goto L_0x00f0
                r3 = 1
                r4 = r17
            L_0x00f0:
                r11.moveToNext()     // Catch:{ Exception -> 0x0108, all -> 0x0103 }
                r2 = 1
                goto L_0x007d
            L_0x00f5:
                r17 = r3
                com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r11)
                goto L_0x010d
            L_0x00fb:
                r0 = move-exception
                r17 = r3
                goto L_0x0104
            L_0x00ff:
                r0 = move-exception
                r17 = r3
                goto L_0x0109
            L_0x0103:
                r0 = move-exception
            L_0x0104:
                com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r11)
                throw r0
            L_0x0108:
                r0 = move-exception
            L_0x0109:
                com.baidu.android.util.io.Closeables.closeSafely((android.database.Cursor) r11)
            L_0x010d:
                java.util.Iterator r0 = r10.iterator()
            L_0x0111:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0127
                java.lang.Object r2 = r0.next()
                java.lang.Long r2 = (java.lang.Long) r2
                com.baidu.searchbox.downloads.DownloadService r12 = com.baidu.searchbox.downloads.DownloadService.this
                long r13 = r2.longValue()
                r12.deleteDownload(r13)
                goto L_0x0111
            L_0x0127:
                if (r6 != 0) goto L_0x0154
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                java.util.Map r0 = r0.mDownloads
                java.util.Collection r0 = r0.values()
                java.util.Iterator r0 = r0.iterator()
            L_0x0137:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0154
                java.lang.Object r2 = r0.next()
                com.baidu.searchbox.download.model.DownloadInfo r2 = (com.baidu.searchbox.download.model.DownloadInfo) r2
                boolean r12 = r2.mDeleted
                if (r12 == 0) goto L_0x0153
                java.lang.String r12 = r2.mMediaProviderUri
                boolean r12 = android.text.TextUtils.isEmpty(r12)
                if (r12 == 0) goto L_0x0153
                r6 = 1
                r0 = 1
                r3 = r0
                goto L_0x0154
            L_0x0153:
                goto L_0x0137
            L_0x0154:
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                boolean r0 = r0.mNotificationStopped
                if (r0 != 0) goto L_0x016f
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                com.baidu.searchbox.downloads.DownloadNotification r0 = r0.mNotifier
                com.baidu.searchbox.downloads.DownloadService r2 = com.baidu.searchbox.downloads.DownloadService.this
                java.util.Map r2 = r2.mDownloads
                java.util.Collection r2 = r2.values()
                r0.updateNotification(r2)
            L_0x016f:
                if (r6 == 0) goto L_0x0177
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                r0.bindMediaScanner()
                goto L_0x0180
            L_0x0177:
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                com.baidu.searchbox.downloads.DownloadService$MyMediaScannerConnection r0 = r0.mMediaScannerConnection
                r0.disconnectMediaScanner()
            L_0x0180:
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                java.util.Map r0 = r0.mDownloads
                java.util.Collection r0 = r0.values()
                java.util.Iterator r0 = r0.iterator()
            L_0x018e:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x020c
                java.lang.Object r2 = r0.next()
                com.baidu.searchbox.download.model.DownloadInfo r2 = (com.baidu.searchbox.download.model.DownloadInfo) r2
                boolean r12 = r2.mDeleted
                if (r12 == 0) goto L_0x0205
                java.lang.String r12 = r2.mMediaProviderUri
                boolean r12 = android.text.TextUtils.isEmpty(r12)
                if (r12 == 0) goto L_0x01d5
                boolean r12 = r2.shouldScanFile()
                if (r12 == 0) goto L_0x01b5
                com.baidu.searchbox.downloads.DownloadService r12 = com.baidu.searchbox.downloads.DownloadService.this
                r13 = 1
                boolean unused = r12.scanFile(r2, r7, r13)
                r20 = r8
                goto L_0x0208
            L_0x01b5:
                r13 = 1
                com.baidu.searchbox.downloads.DownloadService r12 = com.baidu.searchbox.downloads.DownloadService.this
                android.content.Context r12 = r12.mContext
                android.content.ContentResolver r14 = r12.getContentResolver()
                r20 = r8
                long r7 = r2.mId
                java.lang.String r12 = r2.mFileName
                java.lang.String r15 = r2.mMimeType
                int r9 = r2.mVisibility
                r18 = r15
                r15 = r7
                r17 = r12
                r19 = r9
                com.baidu.searchbox.download.util.DownloadHelper.deleteFile(r14, r15, r17, r18, r19)
                goto L_0x0208
            L_0x01d5:
                r20 = r8
                r13 = 1
                com.baidu.searchbox.downloads.DownloadService r7 = com.baidu.searchbox.downloads.DownloadService.this
                android.content.Context r7 = r7.mContext
                java.lang.String r8 = r2.mMediaProviderUri
                android.net.Uri r8 = android.net.Uri.parse(r8)
                r9 = 0
                com.baidu.searchbox.download.util.DownloadMediaHelper.deleteFromMediaProvider(r7, r8, r9, r9)
                com.baidu.searchbox.downloads.DownloadService r7 = com.baidu.searchbox.downloads.DownloadService.this
                android.content.Context r7 = r7.mContext
                android.content.ContentResolver r14 = r7.getContentResolver()
                long r7 = r2.mId
                java.lang.String r9 = r2.mFileName
                java.lang.String r12 = r2.mMimeType
                int r15 = r2.mVisibility
                r19 = r15
                r15 = r7
                r17 = r9
                r18 = r12
                com.baidu.searchbox.download.util.DownloadHelper.deleteFile(r14, r15, r17, r18, r19)
                goto L_0x0208
            L_0x0205:
                r20 = r8
                r13 = 1
            L_0x0208:
                r8 = r20
                r7 = 0
                goto L_0x018e
            L_0x020c:
                r20 = r8
                r13 = 1
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                boolean r0 = r0.mPendingUpdate
                if (r0 != 0) goto L_0x0222
                com.baidu.searchbox.downloads.DownloadService r0 = com.baidu.searchbox.downloads.DownloadService.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.mIsUpdating
                r2 = 0
                r0.set(r2)
                return
            L_0x0222:
                r2 = r13
                goto L_0x001e
            L_0x0225:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0225 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.downloads.DownloadService.UpdateHandler.doUpdate():void");
        }
    }

    /* access modifiers changed from: private */
    public void bindMediaScanner() {
        synchronized (this) {
            try {
                if (!this.mMediaScannerConnecting) {
                    this.mMediaScannerConnecting = true;
                    this.mMediaScannerConnection.connect();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void removeSpuriousFiles() {
        File[] files = Environment.getDownloadCacheDirectory().listFiles();
        if (files != null) {
            HashSet<String> fileSet = new HashSet<>();
            for (int i2 = 0; i2 < files.length; i2++) {
                if (!files[i2].getName().equals(Constants.KNOWN_SPURIOUS_FILENAME) && !files[i2].getName().equalsIgnoreCase("recovery")) {
                    fileSet.add(files[i2].getPath());
                }
            }
            Cursor cursor = this.mContext.getContentResolver().query(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        fileSet.remove(cursor.getString(0));
                    } while (cursor.moveToNext());
                }
                Closeables.closeSafely(cursor);
            }
            Iterator<String> iterator = fileSet.iterator();
            while (iterator.hasNext()) {
                String filename = iterator.next();
                if (Constants.LOGV) {
                    Log.v("DownloadManager", "deleting spurious file " + filename);
                }
                if (!new File(filename).delete() && DEBUG) {
                    Log.w("DownloadManager", "removeSpuriousFiles delete file failed");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void trimDatabase() {
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, new String[]{"_id"}, "status >= '200'", (String[]) null, "lastmod");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int columnId = cursor.getColumnIndexOrThrow("_id");
                for (int numDelete = cursor.getCount() - 21000; numDelete > 0; numDelete--) {
                    DownloadMediaHelper.deleteFromMediaProvider(this.mContext, ContentUris.withAppendedId(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, cursor.getLong(columnId)), (String) null, (String[]) null);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                }
            }
            Closeables.closeSafely(cursor);
        } else if (DEBUG) {
            Log.e("DownloadManager", "null cursor in trimDatabase");
        }
    }

    /* access modifiers changed from: private */
    public DownloadInfo insertDownload(DownloadInfo.Reader reader, long now) {
        DownloadInfo info = reader.newDownloadInfo(this.mContext, this.mISystemFacade);
        synchronized (this.mDownloads) {
            this.mDownloads.put(Long.valueOf(info.mId), info);
        }
        if (Constants.LOGVV) {
            info.logVerboseInfo();
        }
        if (info.mStatus != 192 || info.mRangeValue == null || info.mRangeValue.isEmpty()) {
            info.startIfReady(now);
        } else {
            if (info.mId < 0 && DEBUG) {
                Log.w("DownloadManager", "deleteDownload delete file failed");
            }
            IDownloadApp.Impl.get().cancelDownload(info.mId);
            info.mDeleted = true;
        }
        return info;
    }

    /* access modifiers changed from: private */
    public void updateDownload(DownloadInfo.Reader reader, DownloadInfo info, long now) {
        int oldVisibility = info.mVisibility;
        int oldStatus = info.mStatus;
        reader.updateFromDatabase(info);
        boolean justCompleted = false;
        if (oldVisibility != 1 || info.mVisibility == 1 || !Downloads.Impl.isStatusCompleted(info.mStatus)) {
        }
        if (!Downloads.Impl.isStatusCompleted(oldStatus) && Downloads.Impl.isStatusCompleted(info.mStatus)) {
            justCompleted = true;
        }
        if (justCompleted) {
            this.mISystemFacade.cancelNotification(info.mId);
        }
        info.startIfReady(now);
    }

    /* access modifiers changed from: private */
    public void deleteDownload(long id) {
        DownloadInfo info = this.mDownloads.get(Long.valueOf(id));
        if (info != null) {
            if (info.shouldScanFile()) {
                scanFile(info, false, false);
            }
            if (info.mStatus == 192) {
                info.mStatus = 490;
            }
            if (!(info.mDestination == 0 || info.mDestination == 5 || info.mFileName == null)) {
                try {
                    if (!DownloadMediaHelper.deleteMediaFile(this.mContext, info.mFileName, info.mMimeType) && DEBUG) {
                        Log.w("DownloadManager", "deleteDownload delete file failed");
                    }
                } catch (Exception e2) {
                    if (DEBUG) {
                        throw new DebugException(TAG, e2);
                    }
                }
            }
            this.mISystemFacade.cancelNotification(info.mId);
            synchronized (this.mDownloads) {
                this.mDownloads.remove(Long.valueOf(info.mId));
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean scanFile(DownloadInfo info, boolean updateDatabase, boolean deleteFile) {
        DownloadInfo downloadInfo = info;
        synchronized (this) {
            if (this.mMediaScannerService == null) {
                return false;
            }
            if (Constants.LOGV) {
                Log.v("DownloadManager", "Scanning file " + downloadInfo.mFileName);
            }
            try {
                final Uri key = info.getAllDownloadsUri();
                final String mimeType = downloadInfo.mMimeType;
                final ContentResolver resolver = this.mContext.getContentResolver();
                final long id = downloadInfo.mId;
                final boolean scaned = downloadInfo.mMediaScanned;
                final int visibility = downloadInfo.mVisibility;
                final boolean z = updateDatabase;
                final boolean z2 = deleteFile;
                this.mMediaScannerConnectionClient.listener = new OnScanCompletedListener() {
                    /* JADX INFO: finally extract failed */
                    public void onScanCompleted(String path, Uri uri) {
                        long identy = Binder.clearCallingIdentity();
                        try {
                            if (z) {
                                boolean changed = false;
                                ContentValues values = new ContentValues();
                                if (!scaned) {
                                    values.put(Constants.MEDIA_SCANNED, 1);
                                    changed = true;
                                }
                                if (uri != null) {
                                    values.put("mediaprovider_uri", uri.toString());
                                    changed = true;
                                }
                                if (changed && DownloadService.this.mContext.getContentResolver().update(key, values, (String) null, (String[]) null) == 0 && Constants.LOGV) {
                                    Log.v("DownloadManager", "Scanning file update failed " + key);
                                }
                            } else if (z2) {
                                if (uri != null) {
                                    DownloadMediaHelper.deleteFromMediaProvider(DownloadService.this.mContext, uri, (String) null, (String[]) null);
                                }
                                DownloadHelper.deleteFile(resolver, id, path, mimeType, visibility);
                            }
                            Binder.restoreCallingIdentity(identy);
                            DownloadService.this.mMediaScannerConnectionClient.listener = null;
                        } catch (Throwable th2) {
                            Binder.restoreCallingIdentity(identy);
                            throw th2;
                        }
                    }
                };
                if (TextUtils.isEmpty(downloadInfo.mFileName)) {
                    return false;
                }
                this.mMediaScannerConnection.scanFile(downloadInfo.mFileName, downloadInfo.mMimeType);
                return true;
            } catch (Exception e2) {
                Log.w("DownloadManager", "Failed to scan file " + downloadInfo.mFileName);
                return false;
            }
        }
    }

    private void dealComponetsDisabled() {
        PackageManager pm = this.mContext.getPackageManager();
        if (!IDownloadApp.Impl.get().isComponentEnable(this.mContext, DownloadReceiver.class.getName())) {
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "enable the disabled downloadreceiver");
            }
            pm.setComponentEnabledSetting(new ComponentName(this.mContext.getPackageName(), DownloadReceiver.class.getName()), 1, 1);
        }
        if (!IDownloadApp.Impl.get().isComponentEnable(this.mContext, OpenDownloadReceiver.class.getName())) {
            if (Constants.LOGVV) {
                Log.v("DownloadManager", "enable the disabled OpenDownloadReceiver");
            }
            pm.setComponentEnabledSetting(new ComponentName(this.mContext.getPackageName(), OpenDownloadReceiver.class.getName()), 1, 1);
        }
    }
}
