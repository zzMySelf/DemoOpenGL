package com.baidu.netdisk.backup.task;

import android.content.Context;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.backup.constant.BackupErrorKt;
import com.baidu.netdisk.backup.constant.BackupType;
import com.baidu.netdisk.backup.constant.DocumentBackupType;
import com.baidu.netdisk.backup.constant.DocumentBackupTypeKt;
import com.baidu.netdisk.backup.db.provider.BackupProviderHelper;
import com.baidu.netdisk.backup.db.provider.BackupProviderHelperKt;
import com.baidu.netdisk.backup.model.BackupTask;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.transfer.transmitter.constant.ErrorCode;
import com.baidu.netdisk.transfer.transmitter.statuscallback.IBackupStatusCallback;
import com.baidu.netdisk.ubc.UBCStatistics;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/netdisk/backup/task/BackupStatusCallback;", "Lcom/baidu/netdisk/transfer/transmitter/statuscallback/IBackupStatusCallback;", "task", "Lcom/baidu/netdisk/backup/model/BackupTask;", "(Lcom/baidu/netdisk/backup/model/BackupTask;)V", "onFailed", "", "errCode", "", "extraInfo", "", "onPause", "onStart", "onSuccess", "content", "onUpdate", "size", "", "rate", "report", "isSucceed", "", "setMd5", "md5", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupStatusCallback.kt */
public final class BackupStatusCallback implements IBackupStatusCallback {
    private final BackupTask task;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BackupStatusCallback.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentBackupType.values().length];
            iArr[DocumentBackupType.PDF.ordinal()] = 1;
            iArr[DocumentBackupType.WORD.ordinal()] = 2;
            iArr[DocumentBackupType.EXCEL.ordinal()] = 3;
            iArr[DocumentBackupType.PPT.ordinal()] = 4;
            iArr[DocumentBackupType.TXT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BackupStatusCallback(BackupTask task2) {
        Intrinsics.checkNotNullParameter(task2, "task");
        this.task = task2;
    }

    public void onSuccess(String content) {
        NetDiskLog.d("BackupStatusCallback", "onSuccess " + this.task.getFileName());
        BackupProviderHelper dbHelper = BackupProviderHelperKt.dbHelper();
        if (dbHelper != null) {
            BackupProviderHelper.updateTaskState$default(dbHelper, this.task.getId(), 4, 0, 0, 12, (Object) null);
        }
        BackupTaskManager.INSTANCE.onJobSucceed();
        report(true);
    }

    private final void report(boolean isSucceed) {
        String value;
        String source;
        Object obj;
        String page = isSucceed ? "success" : "failure";
        if (this.task.getBackupType() == BackupType.DOCUMENT.getType()) {
            DocumentBackupType documentTypeBySuffix = DocumentBackupTypeKt.getDocumentTypeBySuffix(this.task.getExtension());
            switch (documentTypeBySuffix == null ? -1 : WhenMappings.$EnumSwitchMapping$0[documentTypeBySuffix.ordinal()]) {
                case 1:
                    value = "pdf";
                    break;
                case 2:
                    value = "word";
                    break;
                case 3:
                    value = DownloadStatisticConstants.UBC_VALUE_EXCEL;
                    break;
                case 4:
                    value = "ppt";
                    break;
                case 5:
                    value = "txt";
                    break;
                default:
                    value = "";
                    break;
            }
        } else {
            value = "";
        }
        int backupType = this.task.getBackupType();
        if (backupType == BackupType.PHOTO.getType()) {
            source = "image";
        } else if (backupType == BackupType.VIDEO.getType()) {
            source = "video";
        } else if (backupType == BackupType.DOCUMENT.getType()) {
            source = "file";
        } else {
            source = "";
        }
        JSONObject json = new JSONObject();
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl(json.put("size", this.task.getFileSize()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable it = Result.m8974exceptionOrNullimpl(obj);
        if (it != null) {
            NetDiskLog.e("BackupStatusCallback", it.getMessage(), it);
        }
        UBCStatistics.onEventStatistics("4435", "file", "beifen", page, value, source, json);
    }

    public int onUpdate(long size, long rate) {
        NetDiskLog.d("BackupStatusCallback", "onUpdate " + size + ' ' + rate);
        BackupProviderHelper dbHelper = BackupProviderHelperKt.dbHelper();
        if (dbHelper == null) {
            return 0;
        }
        dbHelper.updateTaskProgress(this.task.getId(), size, rate);
        return 0;
    }

    public void onStart() {
        NetDiskLog.d("BackupStatusCallback", "onStart");
        String bduss = AccountUtils.getInstance().getBduss();
        Context context = BaseApplication.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        BackupProviderHelper.updateTaskState$default(new BackupProviderHelper(bduss, context), this.task.getId(), 2, 0, 0, 12, (Object) null);
    }

    public void onFailed(int errCode, String extraInfo) {
        ErrorCode errorCode = BackupErrorKt.convertErrorCode(errCode);
        NetDiskLog.d("BackupStatusCallback", "onFail " + errorCode + ' ' + errCode + ' ' + extraInfo);
        BackupProviderHelper dbHelper = BackupProviderHelperKt.dbHelper();
        if (dbHelper != null) {
            dbHelper.updateTaskState(this.task.getId(), 5, errorCode.mErrno, errCode);
        }
        BackupTaskManager.INSTANCE.onJobFailed(errorCode);
        report(false);
    }

    public void onPause() {
        NetDiskLog.d("BackupStatusCallback", "onPause");
        BackupProviderHelper dbHelper = BackupProviderHelperKt.dbHelper();
        if (dbHelper != null) {
            BackupProviderHelper.updateTaskState$default(dbHelper, this.task.getId(), 3, 0, 0, 12, (Object) null);
        }
        BackupTaskManager.INSTANCE.onJobPause();
    }

    public void setMd5(String md5) {
        NetDiskLog.d("BackupStatusCallback", "setMd5 " + md5);
    }
}
