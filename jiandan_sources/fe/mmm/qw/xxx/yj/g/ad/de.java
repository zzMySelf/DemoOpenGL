package fe.mmm.qw.xxx.yj.g.ad;

import com.tera.scan.main.home.bean.recordwrapper.RecordWrapper;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordFile;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de implements RecordWrapper<ScanRecord> {
    @NotNull
    public final ScanRecord qw;

    public de(@NotNull ScanRecord scanRecord) {
        Intrinsics.checkNotNullParameter(scanRecord, "data");
        this.qw = scanRecord;
    }

    @Nullable
    public Long ad() {
        int i2 = (getData().getModifyTime() > 0 ? 1 : (getData().getModifyTime() == 0 ? 0 : -1));
        ScanRecord de2 = getData();
        return Long.valueOf((i2 == 0 ? de2.getCreateTime() : de2.getModifyTime()) * 1000);
    }

    @NotNull
    /* renamed from: de */
    public ScanRecord getData() {
        return this.qw;
    }

    @Nullable
    public Integer getFileCount() {
        return Integer.valueOf(getData().getPictureList().size());
    }

    @Nullable
    public String getFileName() {
        return getData().getName();
    }

    @Nullable
    public String getIcon() {
        ScanRecordFile scanRecordFile = (ScanRecordFile) CollectionsKt___CollectionsKt.firstOrNull(getData().getPictureList());
        if (scanRecordFile != null) {
            return scanRecordFile.getLocalPath();
        }
        return null;
    }

    @Nullable
    public Long qw() {
        long j = 0;
        for (ScanRecordFile size : getData().getPictureList()) {
            j += ((long) size.getSize()) * 1;
        }
        return Long.valueOf(j);
    }
}
