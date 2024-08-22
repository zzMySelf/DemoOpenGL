package fe.mmm.qw.xxx.yj.g.ad;

import com.tera.scan.main.home.bean.recordwrapper.RecordWrapper;
import com.tera.scan.record.model.ScanRecordExportFile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad implements RecordWrapper<ScanRecordExportFile> {
    @NotNull
    public final ScanRecordExportFile qw;

    public ad(@NotNull ScanRecordExportFile scanRecordExportFile) {
        Intrinsics.checkNotNullParameter(scanRecordExportFile, "data");
        this.qw = scanRecordExportFile;
    }

    @Nullable
    public Long ad() {
        return Long.valueOf(getData().getServerCtime() * 1000);
    }

    @NotNull
    /* renamed from: de */
    public ScanRecordExportFile getData() {
        return this.qw;
    }

    @Nullable
    public Integer getFileCount() {
        return RecordWrapper.qw.qw(this);
    }

    @Nullable
    public String getFileName() {
        return getData().getFileName();
    }

    @Nullable
    public String getIcon() {
        return null;
    }

    @Nullable
    public Long qw() {
        return Long.valueOf((long) getData().getSize());
    }
}
