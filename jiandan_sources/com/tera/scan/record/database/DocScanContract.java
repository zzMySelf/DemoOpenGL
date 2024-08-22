package com.tera.scan.record.database;

import android.net.Uri;
import com.baidu.apollon.webmanager.a;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.framework.kernel.architecture.data.BaseContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\t\u001c\u001d\u001e\u001f !\"#$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0019\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/tera/scan/record/database/DocScanContract;", "Lcom/tera/scan/framework/kernel/architecture/data/BaseContract;", "()V", "CONTENT_AUTHORITY", "", "getCONTENT_AUTHORITY", "()Ljava/lang/String;", "CONTENT_URI", "Landroid/net/Uri;", "getCONTENT_URI", "()Landroid/net/Uri;", "PATH_CLOSE_DATABASE", "PATH_DOC_EXPORT_FILE", "PATH_DOC_LOCAL", "PATH_DOC_SCAN_FILE", "PATH_DOC_SCAN_FILE_UPLOAD", "PATH_DOC_SCAN_RECORD", "buildCloseDatabaseUri", "bduss", "buildDocLocalUri", "buildExportFileUri", "isNotify", "", "buildScanFileUploadUri", "buildScanFileUri", "buildScanRecordUri", "getBduss", "uri", "ExportFileColumn", "ExportFileColumnQuery", "LocalColumn", "LocalColumnQuery", "ScanFileColumn", "ScanFileColumnQuery", "ScanRecordColumn", "ScanRecordColumnQuery", "Tables", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DocScanContract implements BaseContract {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final String f7171ad = (fe.mmm.qw.de.ad.qw.qw.f7755yj + ".ocr.doc_scan");
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public static final Uri f7172de;
    @NotNull
    public static final DocScanContract qw = new DocScanContract();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/tera/scan/record/database/DocScanContract$ExportFileColumn;", "", "Companion", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ExportFileColumn {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/tera/scan/record/database/DocScanContract$LocalColumn;", "", "Companion", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LocalColumn {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/tera/scan/record/database/DocScanContract$ScanFileColumn;", "", "Companion", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ScanFileColumn {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/tera/scan/record/database/DocScanContract$ScanRecordColumn;", "", "Companion", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ScanRecordColumn {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/tera/scan/record/database/DocScanContract$Tables;", "", "Companion", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Tables {
    }

    public static final class ad {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public static final String[] f7173ad = {"_id", "record_id", "fsid", "position", "server_path", "local_path", "size", "status"};
        @NotNull
        public static final ad qw = new ad();

        @NotNull
        public final String[] qw() {
            return f7173ad;
        }
    }

    public static final class de {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public static final String[] f7174ad = {"record_id", "name", "display_name", "m_time", "category", "open_time", "c_time", "export_file_type"};
        @NotNull
        public static final de qw = new de();

        @NotNull
        public final String[] qw() {
            return f7174ad;
        }
    }

    public static final class qw {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public static final String[] f7175ad = {"_id", "record_id", "fsid", "server_path", "local_path", "filename", "server_ctime", "size", "status"};
        @NotNull
        public static final qw qw = new qw();

        @NotNull
        public final String[] qw() {
            return f7175ad;
        }
    }

    static {
        Uri parse = Uri.parse("content://" + f7171ad);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(\"content://$CONTENT_AUTHORITY\")");
        f7172de = parse;
    }

    public static /* synthetic */ Uri fe(DocScanContract docScanContract, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return docScanContract.de(str, z);
    }

    public static /* synthetic */ Uri th(DocScanContract docScanContract, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return docScanContract.rg(str, z);
    }

    @NotNull
    public final Uri ad(@Nullable String str) {
        Object d = LoggerKt.d(f7172de.buildUpon().appendPath("tb_doc_scan_local_record").appendQueryParameter("bduss", Uri.encode(str)).build(), "uri_uri");
        Intrinsics.checkNotNullExpressionValue(d, "CONTENT_URI.buildUpon().…ss)).build().d(\"uri_uri\")");
        return (Uri) d;
    }

    @NotNull
    public final Uri de(@Nullable String str, boolean z) {
        Object d = LoggerKt.d(f7172de.buildUpon().appendPath("tb_doc_scan_export_file").appendQueryParameter("bduss", Uri.encode(str)).appendQueryParameter("is_notify", String.valueOf(z)).build(), "uri_uri");
        Intrinsics.checkNotNullExpressionValue(d, "CONTENT_URI.buildUpon().…    .build().d(\"uri_uri\")");
        return (Uri) d;
    }

    @NotNull
    public final String i() {
        return f7171ad;
    }

    @NotNull
    public final Uri qw(@Nullable String str) {
        Object d = LoggerKt.d(f7172de.buildUpon().appendPath(a.d).appendQueryParameter("bduss", Uri.encode(str)).build(), "uri_uri");
        Intrinsics.checkNotNullExpressionValue(d, "CONTENT_URI.buildUpon().…ss)).build().d(\"uri_uri\")");
        return (Uri) d;
    }

    @NotNull
    public final Uri rg(@Nullable String str, boolean z) {
        Object d = LoggerKt.d(f7172de.buildUpon().appendPath("tb_doc_scan_file").appendQueryParameter("bduss", Uri.encode(str)).appendQueryParameter("is_notify", String.valueOf(z)).build(), "uri_uri");
        Intrinsics.checkNotNullExpressionValue(d, "CONTENT_URI.buildUpon().…    .build().d(\"uri_uri\")");
        return (Uri) d;
    }

    @NotNull
    public final String uk(@Nullable Uri uri) {
        if (uri == null) {
            return "";
        }
        String decode = Uri.decode(uri.getQueryParameter("bduss"));
        Intrinsics.checkNotNullExpressionValue(decode, "decode(bduss)");
        return decode;
    }

    @NotNull
    public final Uri yj(@Nullable String str) {
        Object d = LoggerKt.d(f7172de.buildUpon().appendPath("tb_doc_scan_record").appendQueryParameter("bduss", Uri.encode(str)).build(), "uri_uri");
        Intrinsics.checkNotNullExpressionValue(d, "CONTENT_URI.buildUpon().…ss)).build().d(\"uri_uri\")");
        return (Uri) d;
    }
}
