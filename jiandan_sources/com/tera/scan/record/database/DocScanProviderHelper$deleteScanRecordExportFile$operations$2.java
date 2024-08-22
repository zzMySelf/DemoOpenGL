package com.tera.scan.record.database;

import android.content.ContentProviderOperation;
import android.net.Uri;
import com.tera.scan.record.model.ScanRecordExportFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/content/ContentProviderOperation;", "file", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DocScanProviderHelper$deleteScanRecordExportFile$operations$2 extends Lambda implements Function1<ScanRecordExportFile, ContentProviderOperation> {
    public final /* synthetic */ String $recordSelection;
    public final /* synthetic */ Uri $uri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocScanProviderHelper$deleteScanRecordExportFile$operations$2(Uri uri, String str) {
        super(1);
        this.$uri = uri;
        this.$recordSelection = str;
    }

    @NotNull
    public final ContentProviderOperation invoke(@NotNull ScanRecordExportFile scanRecordExportFile) {
        Intrinsics.checkNotNullParameter(scanRecordExportFile, "file");
        String fsid = scanRecordExportFile.getFsid();
        if (fsid == null || StringsKt__StringsJVMKt.isBlank(fsid)) {
            ContentProviderOperation.Builder newDelete = ContentProviderOperation.newDelete(this.$uri);
            return newDelete.withSelection(this.$recordSelection + " AND local_path = ?", new String[]{scanRecordExportFile.getRecordId(), scanRecordExportFile.getLocalPath()}).build();
        }
        ContentProviderOperation.Builder newDelete2 = ContentProviderOperation.newDelete(this.$uri);
        return newDelete2.withSelection(this.$recordSelection + " AND fsid = ?", new String[]{scanRecordExportFile.getRecordId(), scanRecordExportFile.getFsid()}).build();
    }
}
