package com.baidu.netdisk.backup.scanner;

import com.baidu.netdisk.backup.constant.BackupType;
import com.baidu.netdisk.backup.task.find.FindResultListener;
import com.baidu.netdisk.backup.task.find.IFindResultListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\fR\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/netdisk/backup/scanner/BackupScannerManager;", "", "()V", "callback", "Lkotlin/Function0;", "", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "listeners", "", "Lcom/baidu/netdisk/backup/constant/BackupType;", "Lcom/baidu/netdisk/backup/task/find/IFindResultListener;", "scanners", "Lcom/baidu/netdisk/backup/scanner/IScanner;", "isAllScanComplete", "", "removeAllScan", "removeScan", "type", "startScan", "stopAllScanner", "stopScan", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupScannerManager.kt */
public final class BackupScannerManager {
    public static final BackupScannerManager INSTANCE = new BackupScannerManager();
    private static Function0<Unit> callback;
    private static final Map<BackupType, IFindResultListener> listeners = new LinkedHashMap();
    private static final Map<BackupType, IScanner> scanners = new LinkedHashMap();

    private BackupScannerManager() {
    }

    public final Function0<Unit> getCallback() {
        return callback;
    }

    public final void setCallback(Function0<Unit> function0) {
        callback = function0;
    }

    public final void startScan(BackupType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Map<BackupType, IScanner> map = scanners;
        IScanner scanner = map.get(type);
        if (scanner == null) {
            scanner = ScannerKt.getScanner(type);
        }
        map.put(type, scanner);
        IFindResultListener listener = listeners.get(type);
        if (listener == null) {
            listener = new FindResultListener(type, callback);
        }
        scanner.setFindListener(listener);
        scanner.startScan();
    }

    public final void stopScan(BackupType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IScanner iScanner = scanners.get(type);
        if (iScanner != null) {
            iScanner.stopScan();
        }
    }

    public final void removeAllScan() {
        scanners.clear();
    }

    public final void removeScan(BackupType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IScanner remove = scanners.remove(type);
        if (remove != null) {
            remove.stopScan();
        }
    }

    public final void stopAllScanner() {
        for (IScanner it : scanners.values()) {
            it.stopScan();
        }
    }

    public final boolean isAllScanComplete() {
        Object obj;
        Iterator it = scanners.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!((IScanner) obj).isScanComplete()) {
                break;
            }
        }
        return obj == null;
    }
}
