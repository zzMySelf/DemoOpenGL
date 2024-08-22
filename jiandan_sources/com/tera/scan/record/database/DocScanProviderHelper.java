package com.tera.scan.record.database;

import android.annotation.SuppressLint;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.mars.kotlin.extension.ContentValuesKt;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.SequenceKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import com.tera.scan.record.database.DocScanContract;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.record.model.ScanRecordFile;
import fe.mmm.qw.p030switch.rg.qw;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0011\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001c\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u001c\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001cJ\u001c\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u001e\u0010 \u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001cJ\u001c\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u001c\u0010#\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cJ&\u0010%\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\b0(j\b\u0012\u0004\u0012\u00020\b`)J\u001e\u0010*\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003J\u001c\u0010-\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001cJ\u001c\u0010.\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cJ\u001c\u00100\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cJ\"\u00101\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000103\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001c022\u0006\u0010\u0017\u001a\u00020\u0018J0\u00104\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000103\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001c022\u0006\u0010\u0017\u001a\u00020\u00182\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u001cJ\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u0017\u001a\u00020\u0018J-\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010:\u001a\u00020&H\u0001¢\u0006\u0002\b;J+\u0010<\u001a\b\u0012\u0004\u0012\u0002090\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00032\u0006\u0010:\u001a\u00020&H\u0001¢\u0006\u0002\b=J)\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030?2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0000¢\u0006\u0002\bAJD\u0010B\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000103\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001c022\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001a2\f\u00105\u001a\b\u0012\u0004\u0012\u0002060\u001cH\u0007J\u0018\u0010B\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0003J@\u0010E\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u000103\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001c022\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020\u001aH\u0007J5\u0010F\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c0G2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030H¢\u0006\u0002\u0010IJ\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0003J\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0003J \u0010K\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002J\u001c\u0010L\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001cJ \u0010M\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010N\u001a\u00020&J\u001c\u0010O\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cJ$\u0010P\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00032\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cJ \u0010R\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010N\u001a\u00020&J&\u0010S\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\n2\u0006\u0010U\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\u0003J\u001c\u0010W\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0?J\u001e\u0010Y\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\u0003J'\u0010[\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010^J\u001c\u0010_\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006a"}, d2 = {"Lcom/tera/scan/record/database/DocScanProviderHelper;", "", "bduss", "", "(Ljava/lang/String;)V", "getBduss", "()Ljava/lang/String;", "buildInsertScanRecordExportFileOperation", "Landroid/content/ContentProviderOperation;", "export", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "builder", "Landroid/content/ContentProviderOperation$Builder;", "buildInsertScanRecordFileOperation", "scanRecordFile", "Lcom/tera/scan/record/model/ScanRecordFile;", "buildInsertScanRecordOperation", "scanRecord", "Lcom/tera/scan/record/model/ScanRecord;", "buildUpdateScanRecordFileOperation", "buildUpdateScanRecordOperation", "closeDatabase", "", "context", "Landroid/content/Context;", "deleteScanRecordByRecordIds", "", "recordIds", "", "deleteScanRecordExportFile", "exportFiles", "deleteScanRecordExportFileByScanRecordIds", "deleteScanRecordFileByFSIds", "fsIds", "deleteScanRecordFileByScanRecordIds", "deleteScanRecordFiles", "recordFiles", "flush", "", "batch", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "insertRecordSavePath", "recordId", "savePath", "insertScanRecordExportFile", "insertScanRecordFile", "records", "insertScanRecords", "queryAllExportRecord", "Lkotlin/Pair;", "Landroid/database/Cursor;", "queryAllScanRecord", "orders", "Lcom/tera/scan/record/database/ScanRecordSortRule;", "queryNeedBindScanRecord", "queryNotUploadedScanExportFiles", "Lcom/tera/scan/record/model/ScanUploadFile;", "queryFailed", "queryNotUploadedScanExportFiles$scan_record_aiscanConfigRelease", "queryNotUploadedScanFiles", "queryNotUploadedScanFiles$scan_record_aiscanConfigRelease", "queryRecordIDsWhichHaveNotUploadFiles", "", "ignoreFailedIds", "queryRecordIDsWhichHaveNotUploadFiles$scan_record_aiscanConfigRelease", "queryScanRecord", "offset", "pageSize", "queryScanRecordExportFiles", "queryScanRecordFiles", "", "", "(Landroid/content/Context;[Ljava/lang/String;)Ljava/util/Map;", "queryUploadSuccessScanRecordFiles", "updateRecordSavePath", "updateScanExportFileStatusToLocal", "updateScanExportFileUploadStatus", "isNotify", "updateScanFileStatusToLocal", "updateScanFileStatusToRecorded", "scanRecordFiles", "updateScanFileUploadSuccessOrFailed", "updateScanRecordExportFile", "exportFile", "newName", "newLocalPath", "updateScanRecordFile", "fileList", "updateScanRecordName", "name", "updateScanRecordOpenTime", "timeInSecond", "", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;)Z", "updateScanRecords", "updateList", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("DocScanProviderHelper")
public final class DocScanProviderHelper {
    @Nullable
    public final String qw;

    public DocScanProviderHelper(@Nullable String str) {
        this.qw = str;
    }

    public final int aaa(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(str2, "name");
        ContentValues ContentValues = ContentValuesKt.ContentValues(new DocScanProviderHelper$updateScanRecordName$values$1(str2));
        return context.getContentResolver().update(DocScanContract.qw.yj(qw.qw().getBduss()), ContentValues, "record_id = ?", new String[]{str});
    }

    @NotNull
    public final ContentProviderOperation ad(@NotNull ScanRecordFile scanRecordFile, @NotNull ContentProviderOperation.Builder builder) {
        Intrinsics.checkNotNullParameter(scanRecordFile, "scanRecordFile");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.withValue("record_id", scanRecordFile.getRecordId()).withValue("fsid", scanRecordFile.getFsid()).withValue("size", Integer.valueOf(scanRecordFile.getSize())).withValue("position", Integer.valueOf(scanRecordFile.getOrder())).withValue("status", Integer.valueOf(scanRecordFile.getStatus().ordinal())).withValue("local_path", scanRecordFile.getLocalPath()).withValue("server_path", scanRecordFile.getRemotePath());
        ContentProviderOperation build = builder.withYieldAllowed(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.withYieldAllowed(true).build()");
        return build;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.tera.scan.record.model.ScanRecordFile> ddd(@org.jetbrains.annotations.NotNull android.content.Context r10, @org.jetbrains.annotations.NotNull java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "recordId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.content.ContentResolver r1 = r10.getContentResolver()
            com.tera.scan.record.database.DocScanContract r10 = com.tera.scan.record.database.DocScanContract.qw
            com.tera.scan.framework.framework.FrameworkAccount r2 = fe.mmm.qw.p030switch.rg.qw.qw()
            java.lang.String r2 = r2.getBduss()
            r3 = 0
            r4 = 2
            r7 = 0
            android.net.Uri r2 = com.tera.scan.record.database.DocScanContract.th(r10, r2, r3, r4, r7)
            com.tera.scan.record.database.DocScanContract$ad r10 = com.tera.scan.record.database.DocScanContract.ad.qw
            java.lang.String[] r10 = r10.qw()
            r8 = 1
            java.lang.String[] r5 = new java.lang.String[r8]
            r5[r3] = r11
            java.lang.String r4 = "record_id = ?"
            java.lang.String r6 = "position"
            r3 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6)
            if (r10 == 0) goto L_0x0065
            boolean r11 = r10.moveToFirst()     // Catch:{ all -> 0x0057 }
            if (r11 != 0) goto L_0x0041
            goto L_0x004e
        L_0x0041:
            com.tera.scan.record.model.ScanRecordFile r11 = fe.mmm.qw.rrr.de.qw.de(r10)     // Catch:{ all -> 0x0057 }
            r0.add(r11)     // Catch:{ all -> 0x0057 }
            boolean r11 = r10.moveToNext()     // Catch:{ all -> 0x0057 }
            if (r11 != 0) goto L_0x0041
        L_0x004e:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0057 }
            kotlin.io.CloseableKt.closeFinally(r10, r7)     // Catch:{ all -> 0x005e }
            com.mars.kotlin.extension.ExpectKt.success(r11)     // Catch:{ all -> 0x005e }
            goto L_0x0065
        L_0x0057:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r11)     // Catch:{ all -> 0x005e }
            throw r1     // Catch:{ all -> 0x005e }
        L_0x005e:
            r10 = move-exception
            com.mars.kotlin.extension.LoggerKt.e$default(r10, r7, r8, r7)
            com.mars.kotlin.extension.ExpectKt.failure(r10)
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.record.database.DocScanProviderHelper.ddd(android.content.Context, java.lang.String):java.util.List");
    }

    @NotNull
    public final ContentProviderOperation de(@NotNull ScanRecord scanRecord, @NotNull ContentProviderOperation.Builder builder) {
        Intrinsics.checkNotNullParameter(scanRecord, "scanRecord");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.withValue("record_id", scanRecord.getRecordId()).withValue("display_name", scanRecord.getDisplayName()).withValue("c_time", Long.valueOf(scanRecord.getCreateTime())).withValue("open_time", Long.valueOf(scanRecord.getOpenTime())).withValue("name", scanRecord.getName()).withValue("m_time", Long.valueOf(scanRecord.getModifyTime())).withValue("category", Integer.valueOf(scanRecord.getCategory())).withValue("export_file_type", scanRecord.getExportType());
        ContentProviderOperation build = builder.withYieldAllowed(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.withYieldAllowed(true).build()");
        return build;
    }

    public final void fe(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ContentResolver contentResolver = context.getContentResolver();
            ExpectKt.success(contentResolver != null ? Integer.valueOf(contentResolver.delete(DocScanContract.qw.qw(this.qw), "", (String[]) null)) : null);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a1, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r14, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a5, code lost:
        throw r2;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tera.scan.record.model.ScanRecord ggg(@org.jetbrains.annotations.NotNull android.content.Context r13, @org.jetbrains.annotations.NotNull java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "recordId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.tera.scan.record.database.DocScanContract$de r0 = com.tera.scan.record.database.DocScanContract.de.qw
            java.lang.String[] r0 = r0.qw()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.length
            r1.<init>(r2)
            int r2 = r0.length
            r3 = 0
            r4 = 0
        L_0x0019:
            java.lang.String r5 = "tb_doc_scan_record"
            if (r4 >= r2) goto L_0x0039
            r6 = r0[r4]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r5)
            r5 = 46
            r7.append(r5)
            r7.append(r6)
            java.lang.String r5 = r7.toString()
            r1.add(r5)
            int r4 = r4 + 1
            goto L_0x0019
        L_0x0039:
            java.lang.String[] r0 = new java.lang.String[r3]
            java.lang.Object[] r0 = r1.toArray(r0)
            if (r0 == 0) goto L_0x00b8
            java.lang.String[] r0 = (java.lang.String[]) r0
            android.content.ContentResolver r6 = r13.getContentResolver()
            com.tera.scan.record.database.DocScanContract r1 = com.tera.scan.record.database.DocScanContract.qw
            com.tera.scan.framework.framework.FrameworkAccount r2 = fe.mmm.qw.p030switch.rg.qw.qw()
            java.lang.String r2 = r2.getBduss()
            android.net.Uri r7 = r1.yj(r2)
            java.lang.String r1 = "save_path"
            java.lang.Object[] r0 = kotlin.collections.ArraysKt___ArraysJvmKt.plus((T[]) r0, r1)
            r8 = r0
            java.lang.String[] r8 = (java.lang.String[]) r8
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            java.lang.String r1 = ".record_id = ?"
            r0.append(r1)
            java.lang.String r9 = r0.toString()
            r0 = 1
            java.lang.String[] r10 = new java.lang.String[r0]
            r10[r3] = r14
            r11 = 0
            android.database.Cursor r14 = r6.query(r7, r8, r9, r10, r11)
            r1 = 0
            if (r14 == 0) goto L_0x00b7
            boolean r2 = r14.moveToFirst()     // Catch:{ all -> 0x009f }
            if (r2 == 0) goto L_0x0096
            com.tera.scan.record.model.ScanRecord r2 = fe.mmm.qw.rrr.de.qw.ad(r14)     // Catch:{ all -> 0x009f }
            java.util.List r3 = r2.getPictureList()     // Catch:{ all -> 0x009f }
            java.lang.String r4 = r2.getRecordId()     // Catch:{ all -> 0x009f }
            java.util.List r13 = r12.ddd(r13, r4)     // Catch:{ all -> 0x009f }
            r3.addAll(r13)     // Catch:{ all -> 0x009f }
            goto L_0x0097
        L_0x0096:
            r2 = r1
        L_0x0097:
            kotlin.io.CloseableKt.closeFinally(r14, r1)     // Catch:{ all -> 0x00a6 }
            com.mars.kotlin.extension.fp.Either$Right r13 = com.mars.kotlin.extension.ExpectKt.success(r2)     // Catch:{ all -> 0x00a6 }
            goto L_0x00ae
        L_0x009f:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r14, r13)     // Catch:{ all -> 0x00a6 }
            throw r2     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r13 = move-exception
            com.mars.kotlin.extension.LoggerKt.e$default(r13, r1, r0, r1)
            com.mars.kotlin.extension.fp.Either$Left r13 = com.mars.kotlin.extension.ExpectKt.failure(r13)
        L_0x00ae:
            if (r13 == 0) goto L_0x00b7
            java.lang.Object r13 = com.mars.kotlin.extension.ExpectKt.successOrNull(r13)
            r1 = r13
            com.tera.scan.record.model.ScanRecord r1 = (com.tera.scan.record.model.ScanRecord) r1
        L_0x00b7:
            return r1
        L_0x00b8:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            java.lang.String r14 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.record.database.DocScanProviderHelper.ggg(android.content.Context, java.lang.String):com.tera.scan.record.model.ScanRecord");
    }

    public final int i(@NotNull Context context, @NotNull List<ScanRecordFile> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "recordFiles");
        if (list.isEmpty()) {
            return 0;
        }
        ContentProviderResult[] applyBatch = context.getContentResolver().applyBatch(DocScanContract.qw.i(), SequenceKt.toArrayList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), DocScanProviderHelper$deleteScanRecordFiles$operations$1.INSTANCE), new DocScanProviderHelper$deleteScanRecordFiles$operations$2(DocScanContract.th(DocScanContract.qw, qw.qw().getBduss(), false, 2, (Object) null), "record_id = ?"))));
        Intrinsics.checkNotNullExpressionValue(applyBatch, "context.contentResolver\n…operations.toArrayList())");
        int i2 = 0;
        for (ContentProviderResult contentProviderResult : applyBatch) {
            Integer num = contentProviderResult.count;
            if (num == null) {
                num = 0;
            }
            Intrinsics.checkNotNullExpressionValue(num, "t.count ?: 0");
            i2 += num.intValue();
        }
        return i2;
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m892if(@NotNull Context context, @NotNull List<ScanRecordFile> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "records");
        if (list.isEmpty()) {
            return true;
        }
        ArrayList arrayList = null;
        Uri th2 = DocScanContract.th(DocScanContract.qw, qw.qw().getBduss(), false, 2, (Object) null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ScanRecordFile ad2 : list) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(th2);
            Intrinsics.checkNotNullExpressionValue(newInsert, "newInsert(uri)");
            arrayList3.add(ad(ad2, newInsert));
        }
        arrayList2.addAll(arrayList3);
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(context.getContentResolver().applyBatch(DocScanContract.qw.i(), arrayList));
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th3));
        }
        return Result.m1162isSuccessimpl(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mmm(@org.jetbrains.annotations.NotNull android.content.Context r6, @org.jetbrains.annotations.NotNull com.tera.scan.record.model.ScanRecordExportFile r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9) {
        /*
            r5 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "exportFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "newName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "newLocalPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.tera.scan.record.database.DocScanContract r0 = com.tera.scan.record.database.DocScanContract.qw
            com.tera.scan.framework.framework.FrameworkAccount r1 = fe.mmm.qw.p030switch.rg.qw.qw()
            java.lang.String r1 = r1.getBduss()
            r2 = 0
            r3 = 2
            r4 = 0
            android.net.Uri r0 = com.tera.scan.record.database.DocScanContract.fe(r0, r1, r2, r3, r4)
            com.tera.scan.record.database.DocScanProviderHelper$updateScanRecordExportFile$values$1 r1 = new com.tera.scan.record.database.DocScanProviderHelper$updateScanRecordExportFile$values$1
            r1.<init>(r8, r9)
            android.content.ContentValues r8 = com.mars.kotlin.extension.ContentValuesKt.ContentValues(r1)
            java.lang.String r9 = r7.getFsid()
            r1 = 1
            if (r9 == 0) goto L_0x003e
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r9)
            if (r9 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r9 = 0
            goto L_0x003f
        L_0x003e:
            r9 = 1
        L_0x003f:
            java.lang.String r4 = "record_id = ?"
            if (r9 == 0) goto L_0x0091
            java.lang.String r9 = r7.getRecordId()
            if (r9 == 0) goto L_0x0052
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r9 = 0
            goto L_0x0053
        L_0x0052:
            r9 = 1
        L_0x0053:
            if (r9 != 0) goto L_0x0091
            java.lang.String r9 = r7.getLocalPath()
            if (r9 == 0) goto L_0x0064
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r9)
            if (r9 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r9 = 0
            goto L_0x0065
        L_0x0064:
            r9 = 1
        L_0x0065:
            if (r9 != 0) goto L_0x0091
            android.content.ContentResolver r6 = r6.getContentResolver()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            java.lang.String r4 = " AND local_path = ?"
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.String r4 = r7.getRecordId()
            r3[r2] = r4
            java.lang.String r7 = r7.getLocalPath()
            r3[r1] = r7
            int r6 = r6.update(r0, r8, r9, r3)
            if (r6 <= 0) goto L_0x00cd
            goto L_0x00cc
        L_0x0091:
            java.lang.String r9 = r7.getFsid()
            if (r9 == 0) goto L_0x00a0
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r9)
            if (r9 == 0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r9 = 0
            goto L_0x00a1
        L_0x00a0:
            r9 = 1
        L_0x00a1:
            if (r9 != 0) goto L_0x00cd
            android.content.ContentResolver r6 = r6.getContentResolver()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r4)
            java.lang.String r4 = " AND fsid = ?"
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.String r4 = r7.getRecordId()
            r3[r2] = r4
            java.lang.String r7 = r7.getFsid()
            r3[r1] = r7
            int r6 = r6.update(r0, r8, r9, r3)
            if (r6 <= 0) goto L_0x00cd
        L_0x00cc:
            r2 = 1
        L_0x00cd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.record.database.DocScanProviderHelper.mmm(android.content.Context, com.tera.scan.record.model.ScanRecordExportFile, java.lang.String, java.lang.String):boolean");
    }

    @NotNull
    public final Map<String, List<ScanRecordFile>> nn(@NotNull Context context, @NotNull String[] strArr) {
        String str;
        Throwable th2;
        String[] strArr2 = strArr;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr2, "recordIds");
        ArrayList arrayList = new ArrayList();
        if (!(strArr2.length == 0)) {
            str = "record_id IN (" + ArraysKt___ArraysKt.joinToString$default((Object[]) strArr, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) DocScanProviderHelper$queryScanRecordFiles$selection$1.INSTANCE, 31, (Object) null) + ')';
        } else {
            str = null;
        }
        Cursor query = context.getContentResolver().query(DocScanContract.th(DocScanContract.qw, qw.qw().getBduss(), false, 2, (Object) null), DocScanContract.ad.qw.qw(), str, strArr, "record_id, position");
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(fe.mmm.qw.rrr.de.qw.de(query));
                    } while (query.moveToNext());
                }
                Unit unit = Unit.INSTANCE;
                try {
                    CloseableKt.closeFinally(query, (Throwable) null);
                    ExpectKt.success(unit);
                } catch (Throwable th3) {
                    LoggerKt.e$default(th3, (Object) null, 1, (Object) null);
                    ExpectKt.failure(th3);
                }
            } catch (Throwable th4) {
                Throwable th5 = th4;
                CloseableKt.closeFinally(query, th2);
                throw th5;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object next : arrayList) {
            String recordId = ((ScanRecordFile) next).getRecordId();
            Object obj = linkedHashMap.get(recordId);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(recordId, obj);
            }
            ((List) obj).add(next);
        }
        return linkedHashMap;
    }

    public final boolean o(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "recordId");
        Intrinsics.checkNotNullParameter(str2, "savePath");
        if (str2.length() == 0) {
            return false;
        }
        context.getContentResolver().insert(DocScanContract.qw.ad(qw.qw().getBduss()), ContentValuesKt.ContentValues(new DocScanProviderHelper$insertRecordSavePath$values$1(str, str2)));
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(Boolean.TRUE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        return Result.m1162isSuccessimpl(obj);
    }

    public final boolean pf(@NotNull Context context, @NotNull List<ScanRecordExportFile> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "exportFiles");
        if (list.isEmpty()) {
            return true;
        }
        ArrayList arrayList = null;
        Uri fe2 = DocScanContract.fe(DocScanContract.qw, qw.qw().getBduss(), false, 2, (Object) null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ScanRecordExportFile qw2 : list) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(fe2);
            Intrinsics.checkNotNullExpressionValue(newInsert, "newInsert(uri)");
            arrayList3.add(qw(qw2, newInsert));
        }
        arrayList2.addAll(arrayList3);
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(context.getContentResolver().applyBatch(DocScanContract.qw.i(), arrayList));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        return Result.m1162isSuccessimpl(obj);
    }

    @NotNull
    public final Pair<Cursor, List<ScanRecord>> ppp(@NotNull Context context, @NotNull List<? extends ScanRecordSortRule> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "orders");
        return vvv(context, 0, Integer.MAX_VALUE, list);
    }

    public final boolean qqq(@NotNull Context context, @Nullable Long l, @Nullable String str) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = false;
        if (str == null) {
            return false;
        }
        ContentValues ContentValues = ContentValuesKt.ContentValues(new DocScanProviderHelper$updateScanRecordOpenTime$values$1(l, Calendar.getInstance().getTimeInMillis() / ((long) 1000)));
        int update = context.getContentResolver().update(DocScanContract.qw.yj(qw.qw().getBduss()), ContentValues, "record_id = ? ", new String[]{str});
        try {
            Result.Companion companion = Result.Companion;
            if (update > 0) {
                z = true;
            }
            bool = Result.m1155constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            bool = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.m1161isFailureimpl(bool)) {
            bool = bool2;
        }
        return ((Boolean) bool).booleanValue();
    }

    @NotNull
    public final ContentProviderOperation qw(@NotNull ScanRecordExportFile scanRecordExportFile, @NotNull ContentProviderOperation.Builder builder) {
        Intrinsics.checkNotNullParameter(scanRecordExportFile, ShareDirectionType.EXPORT);
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.withValue("record_id", scanRecordExportFile.getRecordId()).withValue("fsid", scanRecordExportFile.getFsid()).withValue("filename", scanRecordExportFile.getFileName()).withValue("status", Integer.valueOf(scanRecordExportFile.getStatus().ordinal())).withValue("size", Integer.valueOf(scanRecordExportFile.getSize())).withValue("local_path", scanRecordExportFile.getLocalPath()).withValue("server_path", scanRecordExportFile.getServerPath()).withValue("server_ctime", Long.valueOf(scanRecordExportFile.getServerCtime()));
        ContentProviderOperation build = builder.withYieldAllowed(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.withYieldAllowed(true).build()");
        return build;
    }

    public final int rg(@NotNull Context context, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "recordIds");
        if (list.isEmpty()) {
            return 0;
        }
        uk(context, list);
        yj(context, list);
        ContentResolver contentResolver = context.getContentResolver();
        Uri yj2 = DocScanContract.qw.yj(qw.qw().getBduss());
        return contentResolver.delete(yj2, "record_id IN (" + CollectionsKt___CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, DocScanProviderHelper$deleteScanRecordByRecordIds$1.INSTANCE, 31, (Object) null) + ')', (String[]) null);
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m893switch(@NotNull Context context, @NotNull List<ScanRecord> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "records");
        Uri yj2 = DocScanContract.qw.yj(qw.qw().getBduss());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (ScanRecord scanRecord : list) {
            m892if(context, scanRecord.getPictureList());
            String savePath = scanRecord.getSavePath();
            if (savePath != null) {
                o(context, scanRecord.getRecordId(), savePath);
            }
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(yj2);
            Intrinsics.checkNotNullExpressionValue(newInsert, "newInsert(uri)");
            arrayList2.add(de(scanRecord, newInsert));
        }
        arrayList.addAll(arrayList2);
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        if (arrayList == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(context.getContentResolver().applyBatch(DocScanContract.qw.i(), arrayList));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        return Result.m1162isSuccessimpl(obj);
    }

    public final int th(@NotNull Context context, @NotNull List<ScanRecordExportFile> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "exportFiles");
        if (list.isEmpty()) {
            return 0;
        }
        ContentProviderResult[] applyBatch = context.getContentResolver().applyBatch(DocScanContract.qw.i(), SequenceKt.toArrayList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(list), DocScanProviderHelper$deleteScanRecordExportFile$operations$1.INSTANCE), new DocScanProviderHelper$deleteScanRecordExportFile$operations$2(DocScanContract.fe(DocScanContract.qw, qw.qw().getBduss(), false, 2, (Object) null), "record_id = ?"))));
        Intrinsics.checkNotNullExpressionValue(applyBatch, "context.contentResolver\n…operations.toArrayList())");
        int i2 = 0;
        for (ContentProviderResult contentProviderResult : applyBatch) {
            Integer num = contentProviderResult.count;
            if (num == null) {
                num = 0;
            }
            Intrinsics.checkNotNullExpressionValue(num, "t.count ?: 0");
            i2 += num.intValue();
        }
        return i2;
    }

    public final int uk(@NotNull Context context, @NotNull List<String> list) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "recordIds");
        if (list.isEmpty()) {
            return 0;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri th2 = DocScanContract.th(DocScanContract.qw, qw.qw().getBduss(), false, 2, (Object) null);
        return contentResolver.delete(th2, "record_id IN (" + CollectionsKt___CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ')', (String[]) null);
    }

    @NotNull
    @SuppressLint({"Recycle"})
    public final Pair<Cursor, List<ScanRecord>> vvv(@NotNull Context context, int i2, int i3, @NotNull List<? extends ScanRecordSortRule> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "orders");
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, DocScanProviderHelper$queryScanRecord$order$1.INSTANCE, 31, (Object) null);
        String[] qw2 = DocScanContract.de.qw.qw();
        ArrayList arrayList = new ArrayList(qw2.length);
        for (String str : qw2) {
            arrayList.add("tb_doc_scan_record." + str);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            ArrayList<ScanRecord> arrayList2 = new ArrayList<>();
            Cursor query = context.getContentResolver().query(DocScanContract.qw.yj(qw.qw().getBduss()), (String[]) ArraysKt___ArraysJvmKt.plus((T[]) (String[]) array, OCRRectifyActivity.EXTRA_SAVE_PATH), (String) null, (String[]) null, joinToString$default + " LIMIT " + i3 + " OFFSET " + i2);
            try {
                Result.Companion companion = Result.Companion;
                boolean z = true;
                if (query == null || !query.moveToFirst()) {
                    z = false;
                }
                if (z) {
                    do {
                        arrayList2.add(fe.mmm.qw.rrr.de.qw.ad(query));
                    } while (query.moveToNext());
                }
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            for (ScanRecord recordId : arrayList2) {
                arrayList3.add(recordId.getRecordId());
            }
            Object[] array2 = arrayList3.toArray(new String[0]);
            if (array2 != null) {
                Map<String, List<ScanRecordFile>> nn = nn(context, (String[]) array2);
                for (ScanRecord scanRecord : arrayList2) {
                    List list2 = nn.get(scanRecord.getRecordId());
                    if (list2 != null) {
                        scanRecord.getPictureList().addAll(list2);
                    }
                }
                return new Pair<>(query, arrayList2);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @NotNull
    public final Pair<Cursor, List<ScanRecordExportFile>> when(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return xxx(context, (String) null, 0, Integer.MAX_VALUE);
    }

    @NotNull
    @SuppressLint({"Recycle"})
    public final Pair<Cursor, List<ScanRecordExportFile>> xxx(@NotNull Context context, @Nullable String str, int i2, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        String str2 = "server_ctime DESC ";
        if (i3 > 0 && i2 >= 0) {
            str2 = str2 + " LIMIT " + i3 + " OFFSET " + i2;
        }
        String str3 = str2;
        boolean z = false;
        Cursor query = context.getContentResolver().query(DocScanContract.fe(DocScanContract.qw, qw.qw().getBduss(), false, 2, (Object) null), DocScanContract.qw.qw.qw(), str != null ? "record_id = ?" : null, str != null ? new String[]{str} : null, str3);
        try {
            Result.Companion companion = Result.Companion;
            if (query != null && query.moveToFirst()) {
                z = true;
            }
            if (z) {
                do {
                    arrayList.add(fe.mmm.qw.rrr.de.qw.qw(query));
                } while (query.moveToNext());
            }
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        return new Pair<>(query, arrayList);
    }

    public final int yj(@NotNull Context context, @NotNull List<String> list) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "recordIds");
        if (list.isEmpty()) {
            return 0;
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri fe2 = DocScanContract.fe(DocScanContract.qw, qw.qw().getBduss(), false, 2, (Object) null);
        return contentResolver.delete(fe2, "record_id IN (" + CollectionsKt___CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ')', (String[]) null);
    }
}
