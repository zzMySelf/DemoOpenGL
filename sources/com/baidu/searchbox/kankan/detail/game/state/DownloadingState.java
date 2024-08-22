package com.baidu.searchbox.kankan.detail.game.state;

import android.net.Uri;
import android.util.Log;
import com.baidu.searchbox.download.FileDownloader;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.model.DownloadState;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.searchbox.generalcommunity.context.GCommunityRuntime;
import com.baidu.searchbox.kankan.detail.game.GameTask;
import com.baidu.searchbox.kankan.detail.game.GameTasksManager;
import com.baidu.searchbox.kankan.detail.game.state.GameTaskState;

public class DownloadingState extends GameTaskState implements IDownloadListener {
    private static final String PAUSE_TASK_TEXT = "继续下载";
    private boolean mIsPause = false;
    private int mProgress = 0;
    private String mTaskText;

    public DownloadingState(GameTask gameTask) {
        super(gameTask);
    }

    public void onChangeToState() {
        DownloadState curDownloadState = FileDownloader.getDownloadState(this.mGameTask.getUri());
        if (curDownloadState == DownloadState.DOWNLOAD_PAUSED && FileDownloader.canDownloadResume(this.mGameTask.getUri())) {
            this.mIsPause = true;
        } else if (curDownloadState == DownloadState.DOWNLOADING) {
            this.mIsPause = false;
            FileDownloader.resumeDownload(this.mGameTask.getUri(), this);
        } else if (curDownloadState == DownloadState.DOWNLOADED) {
            this.mGameTask.setCurState(this.mGameTask.getInstallState());
        } else {
            this.mGameTask.setCurState(this.mGameTask.getOriginalState());
        }
    }

    public String getTaskText() {
        if (this.mIsPause) {
            this.mTaskText = PAUSE_TASK_TEXT;
        } else {
            this.mTaskText = this.mProgress + "%";
        }
        return this.mTaskText;
    }

    public void onClick() {
        if (this.mGameTask.getUri() != null) {
            boolean z = !this.mIsPause;
            this.mIsPause = z;
            if (z) {
                this.mTaskText = PAUSE_TASK_TEXT;
                FileDownloader.pauseDownloadSafety(this.mGameTask.getUri());
                GameTasksManager.postStateEvent(this);
            } else if (FileDownloader.canDownloadResume(this.mGameTask.getUri())) {
                FileDownloader.resumeDownload(this.mGameTask.getUri(), this);
                GameTasksManager.postStateEvent(this);
            } else {
                this.mGameTask.setCurState(this.mGameTask.getOriginalState());
            }
        }
    }

    public GameTaskState.StateCode getStateCode() {
        if (this.mIsPause) {
            return GameTaskState.StateCode.PAUSE_STATE;
        }
        return GameTaskState.StateCode.DOWNLOADING_STATE;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public void onProgressChanged(Uri uri, int newProgress) {
        this.mProgress = newProgress;
        GameTasksManager.postStateEvent(this);
    }

    public void onStopped(StopStatus stopStatus) {
        if (GCommunityRuntime.GLOBAL_DEBUG) {
            Log.d(DownloadingState.class.getSimpleName(), "onStopped, StopStatus = " + stopStatus.name());
        }
        this.mIsPause = true;
        GameTasksManager.postStateEvent(this);
    }

    public void onPause(Uri uri, int newProgress) {
        this.mProgress = newProgress;
    }

    public void onSuccess(Uri uri) {
        this.mGameTask.setCurState(this.mGameTask.getInstallState());
    }

    public void onProgress(Uri uri, long currentSize, long totalSize) {
    }
}
