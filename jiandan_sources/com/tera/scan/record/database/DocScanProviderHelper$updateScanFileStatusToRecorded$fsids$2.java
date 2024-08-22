package com.tera.scan.record.database;

import com.tera.scan.record.model.ScanRecordFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tera/scan/record/model/ScanRecordFile;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DocScanProviderHelper$updateScanFileStatusToRecorded$fsids$2 extends Lambda implements Function1<ScanRecordFile, CharSequence> {
    public static final DocScanProviderHelper$updateScanFileStatusToRecorded$fsids$2 INSTANCE = new DocScanProviderHelper$updateScanFileStatusToRecorded$fsids$2();

    public DocScanProviderHelper$updateScanFileStatusToRecorded$fsids$2() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull ScanRecordFile scanRecordFile) {
        Intrinsics.checkNotNullParameter(scanRecordFile, "it");
        String fsid = scanRecordFile.getFsid();
        Intrinsics.checkNotNull(fsid);
        return fsid;
    }
}
