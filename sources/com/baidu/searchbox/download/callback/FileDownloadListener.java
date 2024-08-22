package com.baidu.searchbox.download.callback;

import android.content.Context;
import android.net.Uri;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.DownloadBean;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.searchbox.download.unified.IP2pDownloadListener;

public class FileDownloadListener implements DownloadListener {
    private IDownloadListener mApkDownloadListener;
    private Context mContext;
    private DownloadManagerExt mDownloadManagerExt = DownloadManagerExt.getInstance();

    public FileDownloadListener(Context context, IDownloadListener apkDownloadListener) {
        this.mApkDownloadListener = apkDownloadListener;
        this.mContext = context;
    }

    /* renamed from: com.baidu.searchbox.download.callback.FileDownloadListener$1  reason: invalid class name */
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
        if (pdb == null || pdb.getStatus() != 0) {
            this.mApkDownloadListener.onStopped(StopStatus.DOWNLOAD_FAIL);
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$baidu$searchbox$download$model$DownloadState[pdb.getDownloadState().ordinal()]) {
            case 1:
                long currentBytes = pdb.getCurrentBytes();
                long totalBytes = pdb.getTotalBytes();
                if (totalBytes > 0) {
                    int progress = (int) Math.floor((double) ((100 * currentBytes) / totalBytes));
                    if (currentBytes > 0 && totalBytes > 0 && progress != 100) {
                        this.mApkDownloadListener.onProgressChanged(pdb.getUri(), progress);
                        IDownloadListener iDownloadListener = this.mApkDownloadListener;
                        if (iDownloadListener instanceof IP2pDownloadListener) {
                            ((IP2pDownloadListener) iDownloadListener).onProgress(pdb.getUri(), currentBytes, totalBytes, progress, pdb.getExtraInfo());
                            return;
                        }
                        iDownloadListener.onProgress(pdb.getUri(), currentBytes, totalBytes);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                long pauseCurrentBytes = pdb.getCurrentBytes();
                long pauseTotalBytes = pdb.getTotalBytes();
                Uri pdbPausedUri = pdb.getUri();
                if (pauseTotalBytes <= 0) {
                    this.mApkDownloadListener.onPause(pdbPausedUri, 0);
                    return;
                }
                int pauseProgress = (int) Math.floor((double) ((100 * pauseCurrentBytes) / pauseTotalBytes));
                if (pauseCurrentBytes > 0 && pauseTotalBytes > 0 && pauseProgress != 100) {
                    this.mApkDownloadListener.onPause(pdbPausedUri, pauseProgress);
                    return;
                }
                return;
            case 3:
                if (pdb.getCurrentBytes() == pdb.getTotalBytes() && pdb.getCurrentBytes() > 0 && pdb.getTotalBytes() > 0) {
                    Uri pdbDownloadedUri = pdb.getUri();
                    IDownloadListener iDownloadListener2 = this.mApkDownloadListener;
                    if (iDownloadListener2 instanceof IP2pDownloadListener) {
                        ((IP2pDownloadListener) iDownloadListener2).onSuccess(pdbDownloadedUri, pdb.getTotalBytes());
                    } else {
                        iDownloadListener2.onSuccess(pdbDownloadedUri);
                    }
                    this.mDownloadManagerExt.unregisterObserver(this.mContext, pdbDownloadedUri);
                    return;
                }
                return;
            case 4:
                this.mApkDownloadListener.onStopped(StopStatus.DOWNLOAD_FAIL);
                return;
            case 5:
                this.mApkDownloadListener.onStopped(StopStatus.DOWNLOAD_UNSTART);
                return;
            default:
                return;
        }
    }
}
