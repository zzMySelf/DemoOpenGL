package com.baidu.netdisk.backup.transmiter;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.SystemClock;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.backup.Backup;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.kernel.util.network.ConnectivityState;
import com.baidu.netdisk.storage.RFile;
import com.baidu.netdisk.transfer.transmitter.TransmitterOptions;
import com.baidu.netdisk.transfer.transmitter.UploadTransmitter;
import com.baidu.netdisk.transfer.transmitter.statuscallback.IBackupStatusCallback;
import com.baidu.netdisk.transfer.transmitter.throwable.StopRequestException;

public class BackupUploadTransmitter extends UploadTransmitter {
    private static final String TAG = "BackupUploadTransmitter";

    public BackupUploadTransmitter(int taskId, RFile localPath, String remotePath, String fileName, TransmitterOptions options, String bduss, String uid, int source) {
        super(taskId, localPath, remotePath, fileName, options, (ContentResolver) null, (Uri) null, bduss, uid, source, (String) null);
    }

    public void start() {
        if (this.mOptions.getStatusCallback() != null) {
            ((IBackupStatusCallback) this.mOptions.getStatusCallback()).onStart();
        }
        super.start();
    }

    public void pause() {
        if (this.mOptions.getStatusCallback() != null) {
            ((IBackupStatusCallback) this.mOptions.getStatusCallback()).onPause();
        }
        super.pause();
    }

    /* access modifiers changed from: protected */
    public void getFileMd5(long fileSize, RFile filePath) {
        super.getFileMd5(fileSize, filePath);
        if (!checkFileSizeSame()) {
            this.mAllMd5List = null;
        }
    }

    private boolean checkFileSizeSame() {
        SystemClock.sleep(100);
        NetDiskLog.w(TAG, "fileSize is match path=" + this.mLocalFile.localUrl());
        return this.fileSize == (this.mCompressFile == null ? this.mLocalFile.length() : this.mCompressFile.length());
    }

    /* access modifiers changed from: protected */
    public boolean isInternetBackupDisable() {
        return Backup.INSTANCE.isWiFiOnly();
    }

    /* access modifiers changed from: protected */
    public void checkCondition() throws StopRequestException {
        super.checkCondition();
        if (!ConnectivityState.isWifi(BaseApplication.getInstance()) && isInternetBackupDisable()) {
            throw new StopRequestException(103, "checkWiFi waiting for wifi");
        }
    }

    /* access modifiers changed from: protected */
    public void checkBlockCondition() throws StopRequestException {
        super.checkBlockCondition();
        if (!ConnectivityState.isWifi(BaseApplication.getInstance()) && isInternetBackupDisable()) {
            throw new StopRequestException(103, "blockUpload waiting for wifi");
        }
    }

    /* access modifiers changed from: protected */
    public boolean pcsBlockCheckWifiCondition() {
        if (ConnectivityState.isWifi(BaseApplication.getInstance()) || !isInternetBackupDisable()) {
            return super.pcsBlockCheckWifiCondition();
        }
        NetDiskLog.d(TAG, "PcsUploadBlockHelper.blockUpload isWaitingWifi return false");
        return false;
    }
}
