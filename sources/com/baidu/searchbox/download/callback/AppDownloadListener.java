package com.baidu.searchbox.download.callback;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.model.StopStatus;

public class AppDownloadListener implements DownloadListener {
    private static final int PROGRESS_ONE_HUNDRED = 100;
    private IAppDownloadListener mApkDownloadListener;
    private Context mContext;
    private DownloadManagerExt mDownloadManagerExt = DownloadManagerExt.getInstance();
    private Uri mUri;

    public AppDownloadListener(Context context, Uri uri, IAppDownloadListener apkDownloadListener) {
        this.mApkDownloadListener = apkDownloadListener;
        this.mContext = context;
        this.mUri = uri;
    }

    /* renamed from: com.baidu.searchbox.download.callback.AppDownloadListener$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$download$model$DownloadState;

        static {
            int[] iArr = new int[DownloadState.values().length];
            $SwitchMap$com$baidu$searchbox$download$model$DownloadState = iArr;
            try {
                iArr[DownloadState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOAD_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOADED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.DOWNLOAD_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$download$model$DownloadState[DownloadState.NOT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public void onChanged(DownloadBean pdb) {
        int progress;
        int pauseProgress;
        boolean complete;
        if (pdb == null || pdb.getStatus() != 0) {
            long id = DownloadManagerExt.getInstance().getIdFromUri(this.mUri);
            if (id > -1) {
                this.mApkDownloadListener.onStopped(id, StopStatus.DOWNLOAD_FAIL);
                return;
            }
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$download$model$DownloadState[pdb.getDownloadState().ordinal()]) {
            case 1:
                long currentBytes = pdb.getCurrentBytes();
                long totalBytes = pdb.getTotalBytes();
                if (totalBytes <= 0) {
                    progress = pdb.getProgress();
                } else {
                    progress = (int) ((100 * currentBytes) / totalBytes);
                }
                if (currentBytes > 0 && progress != 100) {
                    String extraInfo = pdb.getExtraInfo();
                    this.mApkDownloadListener.onProgressChanged(pdb.getDownloadId(), progress);
                    this.mApkDownloadListener.onProgress(pdb.getDownloadId(), currentBytes, totalBytes, progress, extraInfo);
                    return;
                }
                return;
            case 2:
                long pauseCurrentBytes = pdb.getCurrentBytes();
                long pauseTotalBytes = pdb.getTotalBytes();
                long pdbPausedId = pdb.getDownloadId();
                if (pauseTotalBytes <= 0) {
                    pauseProgress = pdb.getProgress();
                } else {
                    pauseProgress = (int) ((100 * pauseCurrentBytes) / pauseTotalBytes);
                }
                if (pauseCurrentBytes > 0 && pauseProgress != 100) {
                    this.mApkDownloadListener.onPause(pdbPausedId, pauseProgress);
                    return;
                }
                return;
            case 3:
                boolean z = true;
                if (pdb.getTotalBytes() <= 0) {
                    if (pdb.getProgress() != 100) {
                        z = false;
                    }
                    complete = z;
                } else {
                    if (pdb.getCurrentBytes() != pdb.getTotalBytes()) {
                        z = false;
                    }
                    complete = z;
                }
                if (complete) {
                    this.mApkDownloadListener.onSuccess(pdb.getDownloadId(), pdb.getTotalBytes());
                    this.mDownloadManagerExt.unregisterObserver(this.mContext, pdb.getUri());
                    return;
                }
                return;
            case 4:
                this.mApkDownloadListener.onStopped(pdb.getDownloadId(), StopStatus.DOWNLOAD_FAIL);
                return;
            case 5:
                this.mApkDownloadListener.onStopped(pdb.getDownloadId(), StopStatus.DOWNLOAD_UNSTART);
                return;
            default:
                return;
        }
    }
}
