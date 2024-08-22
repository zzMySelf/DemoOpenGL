package com.baidu.netdisk.backup.monitor;

import com.baidu.netdisk.backup.task.find.FindFileInfo;
import com.baidu.netdisk.backup.task.find.FindFileResult;
import com.baidu.netdisk.backup.task.find.IFindResultListener;
import com.baidu.netdisk.kernel.architecture.debug.NetDiskLog;
import com.baidu.netdisk.statistics.ThreadJob;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0014R#\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/baidu/netdisk/backup/monitor/MonitorJob;", "Lcom/baidu/netdisk/statistics/ThreadJob;", "()V", "changedFileList", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lkotlin/Pair;", "Ljava/io/File;", "Lcom/baidu/netdisk/backup/task/find/IFindResultListener;", "getChangedFileList", "()Ljava/util/concurrent/LinkedBlockingQueue;", "performExecute", "", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MonitorJob.kt */
public final class MonitorJob extends ThreadJob {
    private final LinkedBlockingQueue<Pair<File, IFindResultListener>> changedFileList = new LinkedBlockingQueue<>();

    public MonitorJob() {
        super("FileMonitor");
    }

    public final LinkedBlockingQueue<Pair<File, IFindResultListener>> getChangedFileList() {
        return this.changedFileList;
    }

    /* access modifiers changed from: protected */
    public void performExecute() {
        NetDiskLog.d("MonitorJob", "performExecute");
        ArrayList<Pair> tempChangedFileInfo = new ArrayList<>();
        this.changedFileList.drainTo(tempChangedFileInfo);
        for (Pair pair : tempChangedFileInfo) {
            File file = (File) pair.component1();
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "file.name");
            ((IFindResultListener) pair.component2()).onResult(new FindFileResult(CollectionsKt.arrayListOf(new FindFileInfo(absolutePath, name, FilesKt.getExtension(file), file.length(), file.lastModified()))));
        }
    }
}
