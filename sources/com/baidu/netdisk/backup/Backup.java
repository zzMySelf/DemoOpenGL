package com.baidu.netdisk.backup;

import com.baidu.growthsystem.wealth.common.constant.WealthVideoYalogConstantKt;
import com.baidu.netdisk.account.AccountUtils;
import com.baidu.netdisk.backup.config.BackupConfig;
import com.baidu.netdisk.backup.constant.BackupPathsKt;
import com.baidu.netdisk.backup.constant.BackupType;
import com.baidu.netdisk.backup.constant.DocumentBackupType;
import com.baidu.netdisk.backup.model.BackupState;
import com.baidu.netdisk.backup.monitor.ForegroundMonitor;
import com.baidu.netdisk.backup.task.BackupStateManager;
import com.baidu.netdisk.backup.task.BackupTaskManager;
import com.baidu.netdisk.backup.task.PrivilegeCheckerKt;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.transfer.base.IUploadCallback;
import com.baidu.netdisk.transfer.transmitter.constant.ErrorCode;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006*\u0001\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0014J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010&\u001a\u00020\u0014J\u0016\u0010'\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0011J\u0016\u0010)\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0011J\u000e\u0010*\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0011J$\u0010+\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190-2\u0006\u0010.\u001a\u00020\u0011J\u000e\u0010/\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u0011J\u0006\u00100\u001a\u00020\u0014J\b\u00101\u001a\u00020\u000eH\u0002J\u0006\u00102\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/netdisk/backup/Backup;", "", "()V", "config", "Lcom/baidu/netdisk/backup/config/BackupConfig;", "listeners", "", "Lcom/baidu/netdisk/backup/IBackupListener;", "stateListener", "com/baidu/netdisk/backup/Backup$stateListener$1", "Lcom/baidu/netdisk/backup/Backup$stateListener$1;", "taskManager", "Lcom/baidu/netdisk/backup/task/BackupTaskManager;", "addListeners", "", "listener", "checkLogin", "", "getBackupInfo", "Lkotlin/Pair;", "Lcom/baidu/netdisk/transfer/transmitter/constant/ErrorCode;", "Lcom/baidu/netdisk/backup/BackupInfo;", "getBackupState", "Lcom/baidu/netdisk/backup/model/BackupState;", "getRemotePath", "", "isBackupEnable", "type", "Lcom/baidu/netdisk/backup/constant/BackupType;", "isCellularBackup", "isDocumentBackupTypeEnable", "Lcom/baidu/netdisk/backup/constant/DocumentBackupType;", "isWiFiOnly", "manualScanBackupMedia", "callback", "Lcom/baidu/netdisk/transfer/base/IUploadCallback;", "pause", "removeListeners", "resume", "setBackupEnable", "enable", "setDocumentBackupTypeEnable", "setEnableObserve", "setPaths", "paths", "", "needMonitor", "setWiFiOnly", "start", "startIfNeed", "stop", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Backup.kt */
public final class Backup {
    public static final Backup INSTANCE = new Backup();
    private static final BackupConfig config = BackupConfig.INSTANCE;
    /* access modifiers changed from: private */
    public static final Set<IBackupListener> listeners = new LinkedHashSet();
    private static final Backup$stateListener$1 stateListener;
    private static final BackupTaskManager taskManager;

    private Backup() {
    }

    static {
        BackupTaskManager backupTaskManager = BackupTaskManager.INSTANCE;
        taskManager = backupTaskManager;
        Backup$stateListener$1 backup$stateListener$1 = new Backup$stateListener$1();
        stateListener = backup$stateListener$1;
        backupTaskManager.setListener(backup$stateListener$1);
    }

    public final void manualScanBackupMedia(IUploadCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        taskManager.manualScanBackupMedia(callback);
    }

    private final void startIfNeed() {
        BackupTaskManager backupTaskManager = taskManager;
        if (!backupTaskManager.isStarted()) {
            backupTaskManager.start();
        } else if (backupTaskManager.isStarted() && backupTaskManager.isPaused()) {
            backupTaskManager.resume();
        }
    }

    public final ErrorCode start() {
        NetDiskLog.d("Backup", "start");
        if (!checkLogin()) {
            return ErrorCode.ERROR_NOT_LOGIN;
        }
        startIfNeed();
        return ErrorCode.ERROR_DEFAULT;
    }

    public final ErrorCode pause() {
        NetDiskLog.d("Backup", "pause");
        if (!checkLogin()) {
            return ErrorCode.ERROR_NOT_LOGIN;
        }
        taskManager.pause();
        return ErrorCode.ERROR_DEFAULT;
    }

    public final ErrorCode resume() {
        NetDiskLog.d("Backup", "resume");
        if (!checkLogin()) {
            return ErrorCode.ERROR_NOT_LOGIN;
        }
        startIfNeed();
        return ErrorCode.ERROR_DEFAULT;
    }

    public final ErrorCode stop() {
        NetDiskLog.d("Backup", "stop");
        if (!checkLogin()) {
            return ErrorCode.ERROR_NOT_LOGIN;
        }
        taskManager.stop();
        return ErrorCode.ERROR_DEFAULT;
    }

    public final boolean isBackupEnable(BackupType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        NetDiskLog.d("Backup", "isBackupEnable " + type);
        if (!checkLogin()) {
            return false;
        }
        return config.isBackupEnable(type);
    }

    public final ErrorCode setBackupEnable(BackupType type, boolean enable) {
        int ret;
        Intrinsics.checkNotNullParameter(type, "type");
        NetDiskLog.e("Backup", "setBackupEnable " + type + ' ' + enable);
        if (!checkLogin()) {
            NetDiskLog.e("Backup", WealthVideoYalogConstantKt.YALOG_VALUE_ERROR_MSG_NOT_LOGIN);
            return ErrorCode.ERROR_NOT_LOGIN;
        } else if (isBackupEnable(type) == enable) {
            NetDiskLog.e("Backup", "already configed");
            return ErrorCode.ERROR_DEFAULT;
        } else if (!enable || (ret = PrivilegeCheckerKt.getPrivilegeChecker(type).check()) == ErrorCode.ERROR_DEFAULT.mErrno) {
            config.setBackupEnable(type, enable);
            if (enable) {
                startIfNeed();
            }
            return ErrorCode.ERROR_DEFAULT;
        } else {
            NetDiskLog.e("Backup", "privilege check failed");
            ErrorCode errorCodeFromCustom = ErrorCode.getErrorCodeFromCustom(ret);
            Intrinsics.checkNotNullExpressionValue(errorCodeFromCustom, "getErrorCodeFromCustom(ret)");
            return errorCodeFromCustom;
        }
    }

    public final boolean isDocumentBackupTypeEnable(DocumentBackupType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!checkLogin()) {
            return false;
        }
        return config.isDocumentBackupTypeEnable(type);
    }

    public final ErrorCode setDocumentBackupTypeEnable(DocumentBackupType type, boolean enable) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (!checkLogin()) {
            return ErrorCode.ERROR_NOT_LOGIN;
        }
        if (isDocumentBackupTypeEnable(type) == enable) {
            return ErrorCode.ERROR_DEFAULT;
        }
        config.setDocumentBackupTypeEnable(type, enable);
        return ErrorCode.ERROR_DEFAULT;
    }

    public final boolean isWiFiOnly() {
        if (!checkLogin()) {
            return false;
        }
        return config.isWiFiOnly();
    }

    public final ErrorCode setWiFiOnly(boolean enable) {
        if (!checkLogin()) {
            return ErrorCode.ERROR_NOT_LOGIN;
        }
        if (enable == isWiFiOnly()) {
            return ErrorCode.ERROR_DEFAULT;
        }
        config.setWiFiOnly(enable);
        return ErrorCode.ERROR_DEFAULT;
    }

    public final void addListeners(IBackupListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<IBackupListener> set = listeners;
        synchronized (set) {
            set.add(listener);
        }
    }

    public final void removeListeners(IBackupListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Set<IBackupListener> set = listeners;
        synchronized (set) {
            set.remove(listener);
        }
    }

    public final Pair<ErrorCode, BackupInfo> getBackupInfo() {
        if (!checkLogin()) {
            return new Pair<>(ErrorCode.ERROR_NOT_LOGIN, new BackupInfo(new BackupState(0, 0), 0, 0, 0, 0, 0, "", false));
        }
        ForegroundMonitor.INSTANCE.check();
        return new Pair<>(ErrorCode.ERROR_DEFAULT, taskManager.getBackupInfo());
    }

    public final BackupState getBackupState() {
        if (!checkLogin()) {
            return new BackupState(0, 0);
        }
        return BackupStateManager.INSTANCE.getBackupState();
    }

    public final boolean isCellularBackup() {
        return checkLogin() && taskManager.isCellularBackup();
    }

    public final String getRemotePath() {
        return BackupPathsKt.getBACKUP_PATH_ROOT();
    }

    public final ErrorCode setEnableObserve(boolean enable) {
        if (!checkLogin()) {
            return ErrorCode.ERROR_NOT_LOGIN;
        }
        if (BackupConfig.INSTANCE.isEnableObserve() == enable) {
            return ErrorCode.ERROR_DEFAULT;
        }
        BackupConfig.INSTANCE.setEnableObserve(enable);
        return ErrorCode.ERROR_DEFAULT;
    }

    public final ErrorCode setPaths(BackupType type, List<String> paths, boolean needMonitor) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(paths, "paths");
        if (!checkLogin()) {
            return ErrorCode.ERROR_NOT_LOGIN;
        }
        BackupConfig.INSTANCE.setPaths(type, paths);
        BackupConfig.INSTANCE.setMonitorEnable(type, needMonitor);
        return ErrorCode.ERROR_DEFAULT;
    }

    private final boolean checkLogin() {
        boolean $this$checkLogin_u24lambda_u2d2 = AccountUtils.getInstance().isLogin();
        if (!$this$checkLogin_u24lambda_u2d2) {
            NetDiskLog.d("Backup", "checkLogin failed");
        }
        return $this$checkLogin_u24lambda_u2d2;
    }
}
