package com.baidu.netdisk.backup.task.find;

import android.content.Context;
import com.baidu.netdisk.BaseApplication;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.backup.constant.BackupType;
import com.baidu.netdisk.backup.db.provider.BackupProviderHelper;
import com.baidu.netdisk.backup.model.BackupTask;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000bH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/netdisk/backup/task/find/FindResultListener;", "Lcom/baidu/netdisk/backup/task/find/IFindResultListener;", "type", "Lcom/baidu/netdisk/backup/constant/BackupType;", "callback", "Lkotlin/Function0;", "", "(Lcom/baidu/netdisk/backup/constant/BackupType;Lkotlin/jvm/functions/Function0;)V", "onError", "onResult", "findFileResult", "Lcom/baidu/netdisk/backup/task/find/FindFileResult;", "saveToDB", "result", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FindResultListener.kt */
public final class FindResultListener implements IFindResultListener {
    private final Function0<Unit> callback;
    private final BackupType type;

    public FindResultListener(BackupType type2, Function0<Unit> callback2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
        this.callback = callback2;
    }

    public void onResult(FindFileResult findFileResult) {
        Intrinsics.checkNotNullParameter(findFileResult, "findFileResult");
        saveToDB(findFileResult);
    }

    public void onError() {
    }

    private final void saveToDB(FindFileResult result) {
        String bduss = AccountUtils.getInstance().getBduss();
        if (bduss != null) {
            Context context = BaseApplication.mContext;
            Intrinsics.checkNotNullExpressionValue(context, "mContext");
            BackupProviderHelper dbHelper = new BackupProviderHelper(bduss, context);
            List<BackupTask> reUploads = new ArrayList<>();
            List<BackupTask> newUploads = new ArrayList<>();
            for (FindFileInfo file : result.getFileInfos()) {
                if (!(file.getPath().length() == 0)) {
                    BackupTask task = dbHelper.queryTask(this.type.getType(), file.getPath());
                    if (task == null) {
                        String path = file.getPath();
                        String name = file.getName();
                        String extension = file.getExtension();
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                        String lowerCase = extension.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                        newUploads.add(new BackupTask(0, path, name, lowerCase, file.getSize(), file.getMTime(), false, false, false, this.type.getType(), 1, 0, 0, 0, 0));
                    } else if (!(task.getFileSize() > 0 && task.getFileSize() == file.getSize() && task.getModifyTime() == file.getMTime()) && (task.getFileSize() > 0 || task.getBackupState() != 4 || !Intrinsics.areEqual((Object) task.getFilePath(), (Object) file.getPath()) || !task.isServer())) {
                        if (task.getBackupState() != 2) {
                            long id = task.getId();
                            String filePath = task.getFilePath();
                            String fileName = task.getFileName();
                            String extension2 = task.getExtension();
                            String bduss2 = bduss;
                            Locale locale2 = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                            String lowerCase2 = extension2.toLowerCase(locale2);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                            reUploads.add(new BackupTask(id, filePath, fileName, lowerCase2, file.getSize(), file.getMTime(), false, false, false, this.type.getType(), 1, 0, 0, 0, 0));
                            bduss = bduss2;
                        }
                    }
                }
            }
            List ops = new ArrayList();
            for (BackupTask it : reUploads) {
                ops.add(dbHelper.getUpdateByIdOperator(it));
            }
            for (BackupTask it2 : newUploads) {
                ops.add(dbHelper.getInsertOperator(it2));
            }
            NetDiskLog.d("FindFileListener", "saveToDB " + dbHelper.applyBatch(ops) + " reUploads " + reUploads.size() + " newUploads " + newUploads.size());
            Function0<Unit> function0 = this.callback;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }
}
