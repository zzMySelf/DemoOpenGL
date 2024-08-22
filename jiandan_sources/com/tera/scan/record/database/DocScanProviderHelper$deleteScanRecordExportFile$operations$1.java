package com.tera.scan.record.database;

import com.tera.scan.record.model.ScanRecordExportFile;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "file", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "invoke", "(Lcom/tera/scan/record/model/ScanRecordExportFile;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DocScanProviderHelper$deleteScanRecordExportFile$operations$1 extends Lambda implements Function1<ScanRecordExportFile, Boolean> {
    public static final DocScanProviderHelper$deleteScanRecordExportFile$operations$1 INSTANCE = new DocScanProviderHelper$deleteScanRecordExportFile$operations$1();

    public DocScanProviderHelper$deleteScanRecordExportFile$operations$1() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        if ((r4 == null || kotlin.text.StringsKt__StringsJVMKt.isBlank(r4)) == false) goto L_0x003c;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull com.tera.scan.record.model.ScanRecordExportFile r4) {
        /*
            r3 = this;
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = r4.getRecordId()
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r4.getFsid()
            if (r0 == 0) goto L_0x0025
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r0 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r0 = 0
            goto L_0x0026
        L_0x0025:
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x003c
            java.lang.String r4 = r4.getLocalPath()
            if (r4 == 0) goto L_0x0037
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r4)
            if (r4 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r4 = 0
            goto L_0x0038
        L_0x0037:
            r4 = 1
        L_0x0038:
            if (r4 != 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.record.database.DocScanProviderHelper$deleteScanRecordExportFile$operations$1.invoke(com.tera.scan.record.model.ScanRecordExportFile):java.lang.Boolean");
    }
}
