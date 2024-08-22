package fe.mmm.qw.xxx.yj.g.ad;

import com.tera.scan.main.home.bean.recordwrapper.RecordWrapper;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.record.model.ScanRecordFile;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw implements RecordWrapper<Object> {
    @NotNull
    public final Object qw;

    public qw(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        this.qw = obj;
    }

    @Nullable
    public Long ad() {
        Object data = getData();
        if (data instanceof ScanRecord) {
            int i2 = (((ScanRecord) getData()).getModifyTime() > 0 ? 1 : (((ScanRecord) getData()).getModifyTime() == 0 ? 0 : -1));
            ScanRecord scanRecord = (ScanRecord) getData();
            return Long.valueOf((i2 == 0 ? scanRecord.getCreateTime() : scanRecord.getModifyTime()) * 1000);
        } else if (data instanceof ScanRecordExportFile) {
            return Long.valueOf(((ScanRecordExportFile) getData()).getServerCtime() * 1000);
        } else {
            return 0L;
        }
    }

    @NotNull
    public Object getData() {
        return this.qw;
    }

    @Nullable
    public Integer getFileCount() {
        if (getData() instanceof ScanRecord) {
            return Integer.valueOf(((ScanRecord) getData()).getPictureList().size());
        }
        return null;
    }

    @Nullable
    public String getFileName() {
        Object data = getData();
        if (data instanceof ScanRecord) {
            return ((ScanRecord) getData()).getName();
        }
        if (data instanceof ScanRecordExportFile) {
            return ((ScanRecordExportFile) getData()).getFileName();
        }
        return null;
    }

    @Nullable
    public String getIcon() {
        ScanRecordFile scanRecordFile;
        if (!(getData() instanceof ScanRecord) || (scanRecordFile = (ScanRecordFile) CollectionsKt___CollectionsKt.firstOrNull(((ScanRecord) getData()).getPictureList())) == null) {
            return null;
        }
        return scanRecordFile.getLocalPath();
    }

    @Nullable
    public Long qw() {
        Object data = getData();
        long j = 0;
        if (data instanceof ScanRecord) {
            for (ScanRecordFile size : ((ScanRecord) getData()).getPictureList()) {
                j += ((long) size.getSize()) * 1;
            }
            return Long.valueOf(j);
        } else if (data instanceof ScanRecordExportFile) {
            return Long.valueOf((long) ((ScanRecordExportFile) getData()).getSize());
        } else {
            return 0L;
        }
    }
}
