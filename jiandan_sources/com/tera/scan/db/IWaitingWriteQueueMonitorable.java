package com.tera.scan.db;

import androidx.annotation.WorkerThread;
import fe.mmm.qw.uk.ad;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH'J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u000bH&¨\u0006\u000e"}, d2 = {"Lcom/tera/scan/db/IWaitingWriteQueueMonitorable;", "", "maxSampleThreshold", "", "onWaitingLong", "", "writers", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tera/scan/db/ContentProviderWriter;", "runningWriter", "waitingTime", "", "waitingQueueSizeThreshold", "waitingTimeThreshold", "lib-database_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IWaitingWriteQueueMonitorable {
    int ad();

    long de();

    @WorkerThread
    void fe(@NotNull ConcurrentLinkedQueue<ad> concurrentLinkedQueue, @Nullable ad adVar, long j);

    int qw();
}
