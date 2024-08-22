package com.baidu.swan.game.ad.downloader.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.config.DownloadConfig;
import com.baidu.swan.game.ad.downloader.core.DownloadTaskImpl;
import com.baidu.swan.game.ad.downloader.db.DownloadDBController;
import com.baidu.swan.game.ad.downloader.interfaces.IDownloadDBController;
import com.baidu.swan.game.ad.downloader.interfaces.IDownloadManager;
import com.baidu.swan.game.ad.downloader.interfaces.IDownloadResponse;
import com.baidu.swan.game.ad.downloader.interfaces.IDownloadTask;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.utils.ApkUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class DownloadManagerImpl implements IDownloadManager, DownloadTaskImpl.DownloadTaskListener {
    private static final long APK_INSATLL_TIME_OUT = 60000;
    private static final int MIN_EXECUTE_INTERVAL_MS = 500;
    private static DownloadManagerImpl sInstance;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Uri, BroadcastReceiver> mAddPackageReceiverList = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Uri, Timer> mAddPackageTimerList = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, IDownloadTask> mCacheDownloadTask;
    private final DownloadConfig mConfig;
    /* access modifiers changed from: private */
    public final Context mContext;
    private final IDownloadDBController mDownloadDBController;
    private final IDownloadResponse mDownloadResponse;
    private final List<DownloadInfo> mDownloadingCaches;
    private ExecutorService mExecutorService;
    private long mLastExecuteTime;

    private DownloadManagerImpl(Context context, DownloadConfig config) {
        this.mContext = context;
        if (config == null) {
            this.mConfig = new DownloadConfig();
        } else {
            this.mConfig = config;
        }
        if (this.mConfig.getDownloadDBController() == null) {
            this.mDownloadDBController = new DownloadDBController(context, this.mConfig);
        } else {
            this.mDownloadDBController = this.mConfig.getDownloadDBController();
        }
        this.mDownloadingCaches = new ArrayList();
        this.mCacheDownloadTask = new ConcurrentHashMap<>();
        this.mDownloadDBController.pauseAllDownloading();
        this.mExecutorService = Executors.newFixedThreadPool(this.mConfig.getDownloadThread());
        this.mDownloadResponse = new DownloadResponseImpl(this.mDownloadDBController);
    }

    public static synchronized IDownloadManager getInstance(Context context, DownloadConfig config) {
        DownloadManagerImpl downloadManagerImpl;
        synchronized (DownloadManagerImpl.class) {
            if (sInstance == null) {
                sInstance = new DownloadManagerImpl(context, config);
            }
            downloadManagerImpl = sInstance;
        }
        return downloadManagerImpl;
    }

    public synchronized void download(DownloadInfo downloadInfo) {
        this.mDownloadingCaches.add(downloadInfo);
        prepareDownload(downloadInfo);
    }

    private void prepareDownload(DownloadInfo downloadInfo) {
        if (this.mCacheDownloadTask.size() >= this.mConfig.getDownloadThread()) {
            downloadInfo.setStatus(DownloadState.WAIT.value());
            this.mDownloadResponse.onStatusChanged(downloadInfo);
            return;
        }
        DownloadTaskImpl downloadTask = new DownloadTaskImpl(this.mExecutorService, this.mDownloadResponse, downloadInfo, this);
        this.mCacheDownloadTask.put(downloadInfo.getId(), downloadTask);
        downloadInfo.setStatus(DownloadState.PREPARE_DOWNLOAD.value());
        this.mDownloadResponse.onStatusChanged(downloadInfo);
        downloadTask.start();
    }

    public synchronized void pause(DownloadInfo downloadInfo) {
        if (isExecute()) {
            pauseInner(downloadInfo);
        }
    }

    private void prepareDownloadNextTask() {
        for (DownloadInfo downloadInfo : this.mDownloadingCaches) {
            if (downloadInfo.getStatus() == DownloadState.WAIT.value()) {
                prepareDownload(downloadInfo);
                return;
            }
        }
    }

    public synchronized void resume(DownloadInfo downloadInfo) {
        if (isExecute()) {
            prepareDownload(downloadInfo);
        }
    }

    public synchronized void remove(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            downloadInfo.setStatus(DownloadState.DELETED.value());
            this.mCacheDownloadTask.remove(downloadInfo.getId());
            this.mDownloadingCaches.remove(downloadInfo);
            this.mDownloadDBController.delete(downloadInfo);
            this.mDownloadResponse.onStatusChanged(downloadInfo);
            new File(downloadInfo.getPath()).delete();
        }
    }

    public synchronized void destroy() {
        cleanAllInstalledListener();
        IDownloadDBController iDownloadDBController = this.mDownloadDBController;
        if (iDownloadDBController != null) {
            iDownloadDBController.close();
        }
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mExecutorService = null;
        }
        sInstance = null;
    }

    public synchronized DownloadInfo getDownloadById(String id) {
        DownloadInfo downloadInfo;
        downloadInfo = null;
        Iterator<DownloadInfo> it = this.mDownloadingCaches.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadInfo d2 = it.next();
            if (d2.getId().equals(id)) {
                downloadInfo = d2;
                break;
            }
        }
        if (downloadInfo == null) {
            downloadInfo = this.mDownloadDBController.findDownloadedInfoById(id);
        }
        return downloadInfo;
    }

    public List<DownloadInfo> findAllDownloading() {
        return this.mDownloadingCaches;
    }

    public List<DownloadInfo> findAllDownloaded() {
        return this.mDownloadDBController.findAllDownloaded();
    }

    public IDownloadDBController getDownloadDBController() {
        return this.mDownloadDBController;
    }

    public synchronized void resumeAll() {
        if (isExecute()) {
            for (DownloadInfo downloadInfo : this.mDownloadingCaches) {
                prepareDownload(downloadInfo);
            }
        }
    }

    public synchronized void pauseAll() {
        if (isExecute()) {
            for (DownloadInfo downloadInfo : this.mDownloadingCaches) {
                pauseInner(downloadInfo);
            }
        }
    }

    public void install() {
    }

    private void pauseInner(DownloadInfo downloadInfo) {
        downloadInfo.setStatus(DownloadState.DOWNLOAD_PAUSED.value());
        this.mCacheDownloadTask.remove(downloadInfo.getId());
        this.mDownloadResponse.onStatusChanged(downloadInfo);
        prepareDownloadNextTask();
    }

    public synchronized void onDownloadSuccess(DownloadInfo downloadInfo) {
        ApkUtils.installApk(downloadInfo.getPath(), false);
        this.mCacheDownloadTask.remove(downloadInfo.getId());
        this.mDownloadingCaches.remove(downloadInfo);
        prepareDownloadNextTask();
    }

    public synchronized boolean isExecute() {
        if (System.currentTimeMillis() - this.mLastExecuteTime <= 500) {
            return false;
        }
        this.mLastExecuteTime = System.currentTimeMillis();
        return true;
    }

    public synchronized void setAppInstalledListener(String packageName, Uri uri, SwanApkDownloadResult<Boolean> listener) {
        if (ApkUtils.hasInstalled(AppRuntime.getAppContext(), packageName)) {
            listener.onResult(true);
        }
    }

    /* access modifiers changed from: private */
    public void cleanInstalledListener(Context context, Uri uri) {
        BroadcastReceiver cacheReceiver = this.mAddPackageReceiverList.remove(uri);
        if (cacheReceiver != null) {
            context.unregisterReceiver(cacheReceiver);
        }
        Timer cacheTimer = this.mAddPackageTimerList.remove(uri);
        if (cacheTimer != null) {
            cacheTimer.cancel();
        }
    }

    private void cleanAllInstalledListener() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                for (Map.Entry<Uri, BroadcastReceiver> entry : DownloadManagerImpl.this.mAddPackageReceiverList.entrySet()) {
                    DownloadManagerImpl downloadManagerImpl = DownloadManagerImpl.this;
                    downloadManagerImpl.cleanInstalledListener(downloadManagerImpl.mContext, entry.getKey());
                }
                timer.cancel();
            }
        }, 60000);
    }

    public static abstract class SwanApkDownloadResult<T> {
        public void onResult(T t) {
        }
    }
}
