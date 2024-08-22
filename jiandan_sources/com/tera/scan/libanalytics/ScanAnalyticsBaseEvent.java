package com.tera.scan.libanalytics;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fH&¨\u0006\r"}, d2 = {"Lcom/tera/scan/libanalytics/ScanAnalyticsBaseEvent;", "", "init", "", "context", "Landroid/content/Context;", "isDebug", "", "track", "eventName", "", "properties", "", "lib_analytics_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ScanAnalyticsBaseEvent {

    public static final class qw {
        public static /* synthetic */ void qw(ScanAnalyticsBaseEvent scanAnalyticsBaseEvent, String str, List list, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    list = null;
                }
                scanAnalyticsBaseEvent.qw(str, list);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
    }

    void qw(@NotNull String str, @Nullable List<String> list);
}
