package com.baidu.searchbox.download.center.ui;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.boxdownload.IBoxDownloadDbOperator;
import com.baidu.searchbox.boxdownload.model.DownloadDbItem;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ioc.IDownloadCenterApp;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import com.baidu.searchbox.videoplayer.interfaces.ICyberVideoDownloadManager;
import com.baidu.searchbox.videoplayer.interfaces.VideoSourceInfo;

public class VideoContinueActivity extends BaseActivity {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_DOWNLOAD_INFO = "key_download_info";
    public static final String KEY_DOWNLOAD_TYPE = "key_download_type";
    private static final String TAG = "VideoContinueActivity";
    /* access modifiers changed from: private */
    public long mDownloadId;
    private int mDownloadType;
    /* access modifiers changed from: private */
    public boolean mIsPauseToStart;
    private BroadcastReceiver mNetChangeReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            NetworkInfo info;
            if (intent.getAction().equals(PreloadConstantsKt.CONNECTIVITY_ACTION) && (info = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null && info.isConnectedOrConnecting() && info.getType() == 1) {
                VideoContinueActivity.this.finish();
                if (VideoContinueActivity.DEBUG) {
                    Log.v(VideoContinueActivity.TAG, "receiver wifi connected,close this");
                }
                VideoContinueActivity.this.showCloseMsg();
            }
        }
    };

    public void stableApiStub() {
    }

    private void registerNetChangeReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
        registerReceiver(this.mNetChangeReceiver, filter);
    }

    private void unregisterNetChangeReceiver() {
        unregisterReceiver(this.mNetChangeReceiver);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int type = -2;
        String title = getString(R.string.download_video_continue_title);
        String content = getString(R.string.download_video_continue_content);
        String yesString = getString(R.string.yes);
        String noString = getString(R.string.no);
        if (getIntent() != null) {
            this.mDownloadId = getIntent().getLongExtra("download_id", -1);
            getIntent().removeExtra("download_id");
            this.mIsPauseToStart = getIntent().getBooleanExtra(DownloadConstants.DOWNLOAD_PAUSE_TOSTART, false);
            getIntent().removeExtra(DownloadConstants.DOWNLOAD_PAUSE_TOSTART);
            ContentValues contentValues = (ContentValues) getIntent().getParcelableExtra(KEY_DOWNLOAD_INFO);
            if (contentValues != null) {
                Integer downloadTypeObj = contentValues.getAsInteger(KEY_DOWNLOAD_TYPE);
                if (downloadTypeObj != null) {
                    this.mDownloadType = downloadTypeObj.intValue();
                } else {
                    this.mDownloadType = 0;
                }
            }
            if (this.mDownloadType == 6) {
                type = 6;
                content = getString(R.string.novel_download_continue_content);
                yesString = getString(R.string.offline);
                noString = getString(com.baidu.searchbox.appframework.actiontoolbar.R.string.cancel);
                title = getString(com.baidu.android.common.ui.style.R.string.story_offline);
            }
        }
        final int downloadType = type;
        new BoxAlertDialog.Builder(this).setTitle((CharSequence) title).setNegativeButton((CharSequence) noString, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (-1 != VideoContinueActivity.this.mDownloadId) {
                    DownloadDbItem downloadDbItem = ((IBoxDownloadDbOperator) ServiceManager.getService(IBoxDownloadDbOperator.Companion.getSERVICE_REFERENCE())).queryItem(VideoContinueActivity.this.mDownloadId);
                    if (downloadDbItem == null || downloadDbItem.getBusinessType() != 1 || TextUtils.isEmpty(downloadDbItem.getBusinessId())) {
                        DownloadManagerExt.getInstance().pauseDownload(VideoContinueActivity.this.mDownloadId);
                        return;
                    }
                    ((ICyberVideoDownloadManager) ServiceManager.getService(ICyberVideoDownloadManager.SERVICE_REFERENCE)).pauseDownload(downloadDbItem.getBusinessId());
                }
            }
        }).setPositiveButton((CharSequence) yesString, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                DownloadDbItem downloadDbItem = ((IBoxDownloadDbOperator) ServiceManager.getService(IBoxDownloadDbOperator.Companion.getSERVICE_REFERENCE())).queryItem(VideoContinueActivity.this.mDownloadId);
                if (downloadDbItem == null || downloadDbItem.getBusinessType() != 1 || TextUtils.isEmpty(downloadDbItem.getBusinessId())) {
                    IDownloadCenterApp.Impl.get().doPositiveBtnJob(VideoContinueActivity.this.mDownloadId, VideoContinueActivity.this.mIsPauseToStart, downloadType);
                    return;
                }
                VideoSourceInfo videoSourceInfo = new VideoSourceInfo();
                videoSourceInfo.passthroughJsonStr = downloadDbItem.getExtraInfo();
                ((ICyberVideoDownloadManager) ServiceManager.getService(ICyberVideoDownloadManager.SERVICE_REFERENCE)).startDownload(downloadDbItem.getBusinessId(), videoSourceInfo);
            }
        }).setMessage(content).setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                VideoContinueActivity.this.finish();
            }
        }).show(true);
        registerNetChangeReceiver();
        setVPlayerOrientationChange(false);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterNetChangeReceiver();
        setVPlayerOrientationChange(true);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ConnectManager cm = new ConnectManager(this);
        if (cm.getNetType() != null && cm.getNetType().equalsIgnoreCase("wifi")) {
            if (DEBUG) {
                Log.v(TAG, "onresume wifi connected,close this");
            }
            showCloseMsg();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mDownloadId = intent.getLongExtra("download_id", -1);
        intent.removeExtra("download_id");
        this.mIsPauseToStart = getIntent().getBooleanExtra(DownloadConstants.DOWNLOAD_PAUSE_TOSTART, false);
        getIntent().removeExtra(DownloadConstants.DOWNLOAD_PAUSE_TOSTART);
    }

    /* access modifiers changed from: private */
    public void showCloseMsg() {
        IDownloadCenterApp.Impl.get().showCloseMsg(this.mDownloadId, this.mIsPauseToStart, this.mDownloadType);
    }

    private void setVPlayerOrientationChange(boolean enable) {
        IDownloadCenterApp.Impl.get().setVPlayerOrientationChange(this.mDownloadType, enable);
    }
}
