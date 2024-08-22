package com.tera.scan.db;

import androidx.annotation.WorkerThread;
import fe.mmm.qw.uk.ad;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/tera/scan/db/ISlowWriteMonitorable;", "", "maxSampleTime", "", "onSlowWrite", "", "writer", "Lcom/tera/scan/db/ContentProviderWriter;", "slowThreshold", "", "lib-database_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISlowWriteMonitorable {
    int ad();

    @WorkerThread
    void de(@NotNull ad adVar);

    long qw();
}
