package com.tera.scan.record.database;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.apollon.webmanager.a;
import com.google.common.base.Ascii;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.db.BaseContentProvider;
import com.tera.scan.flutter.documentscan.OCRRectifyActivity;
import fe.mmm.qw.uk.qw;
import fe.mmm.qw.uk.rg;
import java.io.File;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002J'\u0010\u0012\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002J'\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0019\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002J'\u0010\u001a\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002¢\u0006\u0002\u0010\u0016J\u0014\u0010\u001b\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002J'\u0010\u001c\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011H\u0002¢\u0006\u0002\u0010\u0016J\u001c\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001b\u0010\"\u001a\u00020#2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0002\u0010$J\u001b\u0010%\u001a\u00020#2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0002\u0010$J\u001a\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+H\u0002J\u001b\u0010,\u001a\u00020#2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0002\u0010$J\u001b\u0010-\u001a\u00020#2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0002\u0010$J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020\u000eH\u0002J\n\u00102\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u00103\u001a\u0004\u0018\u00010#2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u00104\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u00105\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u0001072\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u001c\u00108\u001a\u00020\u000e2\b\u00106\u001a\u0004\u0018\u0001072\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J'\u00109\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0014¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020/H\u0016J3\u0010<\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010=\u001a\u0004\u0018\u00010#2\u0010\u0010>\u001a\f\u0012\u0006\b\u0001\u0012\u00020#\u0018\u00010\u0014H\u0014¢\u0006\u0002\u0010?J\u0012\u0010@\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001e\u0010A\u001a\u0004\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0015H\u0014J\u001c\u0010B\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0015H\u0016JQ\u0010C\u001a\u0004\u0018\u00010D2\b\u0010(\u001a\u0004\u0018\u00010)2\u0010\u0010E\u001a\f\u0012\u0006\b\u0001\u0012\u00020#\u0018\u00010\u00142\b\u0010=\u001a\u0004\u0018\u00010#2\u0010\u0010>\u001a\f\u0012\u0006\b\u0001\u0012\u00020#\u0018\u00010\u00142\b\u0010F\u001a\u0004\u0018\u00010#H\u0014¢\u0006\u0002\u0010GJ=\u0010H\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00152\b\u0010=\u001a\u0004\u0018\u00010#2\u0010\u0010>\u001a\f\u0012\u0006\b\u0001\u0012\u00020#\u0018\u00010\u0014H\u0014¢\u0006\u0002\u0010IJ\u001c\u0010J\u001a\u00020\u000e2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006K"}, d2 = {"Lcom/tera/scan/record/database/DocScanProvider;", "Lcom/tera/scan/db/BaseContentProvider;", "()V", "lock", "", "mOpenHelper", "Lcom/tera/scan/db/BaseSQLiteOpenHelper;", "uriMatcher", "Landroid/content/UriMatcher;", "getUriMatcher", "()Landroid/content/UriMatcher;", "uriMatcher$delegate", "Lkotlin/Lazy;", "appendExportFileKeys", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "appendExportFileValues", "values", "", "Landroid/content/ContentValues;", "([Landroid/content/ContentValues;Ljava/lang/StringBuilder;)V", "appendLocalFileKeys", "appendLocalFileValues", "appendScanFileKeys", "appendScanFileValues", "appendScanRecordKeys", "appendScanRecordValues", "attachInfo", "context", "Landroid/content/Context;", "info", "Landroid/content/pm/ProviderInfo;", "buildExportFileInsertStatement", "", "([Landroid/content/ContentValues;)Ljava/lang/String;", "buildLocalInsertStatement", "buildQuerySelectionBuilder", "Lcom/tera/scan/db/SelectionBuilder;", "uri", "Landroid/net/Uri;", "match", "", "buildScanFileInsertStatement", "buildScanRecordInsertStatement", "checkBduss", "", "bduss", "close", "getOpenHelper", "getType", "notify", "onAfterApply", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onBeforeApply", "onBulkInsert", "(Landroid/net/Uri;[Landroid/content/ContentValues;)I", "onCreate", "onDelete", "selection", "selectionArgs", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "onDeleteNotify", "onInsert", "onInsertNotify", "onQuery", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "onUpdate", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "onUpdateNotify", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DocScanProvider extends BaseContentProvider {
    @NotNull
    public final Object lock = new Object();
    @Nullable
    public qw mOpenHelper;
    @NotNull
    public final Lazy uriMatcher$delegate = LazyKt__LazyJVMKt.lazy(DocScanProvider$uriMatcher$2.INSTANCE);

    private final void appendExportFileKeys(StringBuilder sb) {
        sb.append("INSERT INTO ");
        sb.append("tb_doc_scan_export_file");
        sb.append(" (");
        sb.append("record_id");
        sb.append(",");
        sb.append("fsid");
        sb.append(",");
        sb.append("server_path");
        sb.append(",");
        sb.append("local_path");
        sb.append(",");
        sb.append("filename");
        sb.append(",");
        sb.append("server_ctime");
        sb.append(",");
        sb.append("size");
        sb.append(",");
        sb.append("status");
        sb.append(") VALUES ");
    }

    private final void appendExportFileValues(ContentValues[] contentValuesArr, StringBuilder sb) {
        int length = contentValuesArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("('");
            if (contentValuesArr[i2].get("record_id") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("record_id"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("fsid") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("fsid"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("server_path") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("server_path"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("local_path") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("local_path"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("filename") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("filename"));
            }
            sb.append("',");
            if (contentValuesArr[i2].get("server_ctime") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("server_ctime"));
            }
            sb.append(",");
            if (contentValuesArr[i2].get("size") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("size"));
            }
            sb.append(",");
            if (contentValuesArr[i2].get("status") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("status"));
            }
            sb.append(")");
            if (i2 != contentValuesArr.length - 1) {
                sb.append(",");
            }
        }
    }

    private final void appendLocalFileKeys(StringBuilder sb) {
        sb.append("INSERT INTO ");
        sb.append("tb_doc_scan_local_record");
        sb.append(" (");
        sb.append("record_id");
        sb.append(",");
        sb.append(OCRRectifyActivity.EXTRA_SAVE_PATH);
        sb.append(") VALUES ");
    }

    private final void appendLocalFileValues(ContentValues[] contentValuesArr, StringBuilder sb) {
        int length = contentValuesArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("('");
            if (contentValuesArr[i2].get("record_id") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("record_id"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("fsid") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("fsid"));
            }
            sb.append("')");
            if (i2 != contentValuesArr.length - 1) {
                sb.append(",");
            }
        }
    }

    private final void appendScanFileKeys(StringBuilder sb) {
        sb.append("INSERT INTO ");
        sb.append("tb_doc_scan_file");
        sb.append(" (");
        sb.append("record_id");
        sb.append(",");
        sb.append("fsid");
        sb.append(",");
        sb.append("position");
        sb.append(",");
        sb.append("server_path");
        sb.append(",");
        sb.append("local_path");
        sb.append(",");
        sb.append("size");
        sb.append(",");
        sb.append("status");
        sb.append(") VALUES ");
    }

    private final void appendScanFileValues(ContentValues[] contentValuesArr, StringBuilder sb) {
        int length = contentValuesArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("('");
            if (contentValuesArr[i2].get("record_id") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("record_id"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("fsid") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("fsid"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("position") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("position"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("server_path") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("server_path"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("local_path") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("local_path"));
            }
            sb.append("',");
            if (contentValuesArr[i2].get("size") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("size"));
            }
            sb.append(",");
            if (contentValuesArr[i2].get("status") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("status"));
            }
            sb.append(")");
            if (i2 != contentValuesArr.length - 1) {
                sb.append(",");
            }
        }
    }

    private final void appendScanRecordKeys(StringBuilder sb) {
        sb.append("INSERT INTO ");
        sb.append("tb_doc_scan_record");
        sb.append(" (");
        sb.append("record_id");
        sb.append(",");
        sb.append("name");
        sb.append(",");
        sb.append("display_name");
        sb.append(",");
        sb.append("m_time");
        sb.append(",");
        sb.append("category");
        sb.append(",");
        sb.append("c_time");
        sb.append(",");
        sb.append("open_time");
        sb.append(",");
        sb.append("export_file_type");
        sb.append(") VALUES ");
    }

    private final void appendScanRecordValues(ContentValues[] contentValuesArr, StringBuilder sb) {
        int length = contentValuesArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("('");
            if (contentValuesArr[i2].get("record_id") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("record_id"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("name") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("name"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("display_name") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("display_name"));
            }
            sb.append("','");
            if (contentValuesArr[i2].get("m_time") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("m_time"));
            }
            sb.append("',");
            if (contentValuesArr[i2].get("category") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("category"));
            }
            sb.append(",");
            if (contentValuesArr[i2].get("c_time") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("c_time"));
            }
            sb.append(",");
            if (contentValuesArr[i2].get("open_time") == null) {
                sb.append(0);
            } else {
                sb.append(contentValuesArr[i2].get("open_time"));
            }
            sb.append(",'");
            if (contentValuesArr[i2].get("export_file_type") == null) {
                sb.append("NULL");
            } else {
                sb.append(contentValuesArr[i2].get("export_file_type"));
            }
            sb.append("')");
            if (i2 != contentValuesArr.length - 1) {
                sb.append(",");
            }
        }
    }

    private final String buildExportFileInsertStatement(ContentValues[] contentValuesArr) {
        StringBuilder sb = new StringBuilder();
        appendExportFileKeys(sb);
        appendExportFileValues(contentValuesArr, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    private final String buildLocalInsertStatement(ContentValues[] contentValuesArr) {
        StringBuilder sb = new StringBuilder();
        appendLocalFileKeys(sb);
        appendLocalFileValues(contentValuesArr, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    private final rg buildQuerySelectionBuilder(Uri uri, int i2) {
        rg rgVar = new rg();
        if (i2 == 1) {
            String str = "tb_doc_scan_record" + " LEFT JOIN " + "tb_doc_scan_local_record";
            rgVar.yj(str + Ascii.CASE_MASK + ("ON " + "tb_doc_scan_record" + ".record_id = " + "tb_doc_scan_local_record" + ".record_id"));
            Intrinsics.checkNotNullExpressionValue(rgVar, "{\n                val re…inConnect\")\n            }");
        } else if (i2 == 2) {
            rgVar.yj("tb_doc_scan_file");
            Intrinsics.checkNotNullExpressionValue(rgVar, "{\n                select…TABLE_NAME)\n            }");
        } else if (i2 == 3) {
            rgVar.yj("tb_doc_scan_export_file");
            Intrinsics.checkNotNullExpressionValue(rgVar, "{\n                select…TABLE_NAME)\n            }");
        } else if (i2 == 4) {
            rgVar.yj("tb_doc_scan_local_record");
            Intrinsics.checkNotNullExpressionValue(rgVar, "{\n                select…TABLE_NAME)\n            }");
        } else {
            LoggerKt.e$default("Unknown uri: " + uri, (Object) null, 1, (Object) null);
            throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        return rgVar;
    }

    private final String buildScanFileInsertStatement(ContentValues[] contentValuesArr) {
        StringBuilder sb = new StringBuilder();
        appendScanFileKeys(sb);
        appendScanFileValues(contentValuesArr, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    private final String buildScanRecordInsertStatement(ContentValues[] contentValuesArr) {
        StringBuilder sb = new StringBuilder();
        appendScanRecordKeys(sb);
        appendScanRecordValues(contentValuesArr, sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    private final boolean checkBduss(String str) {
        return !TextUtils.isEmpty(str) && Intrinsics.areEqual((Object) str, (Object) fe.mmm.qw.p030switch.rg.qw.qw().getBduss());
    }

    private final void close() {
        LoggerKt.d$default("扫描记录数据库 关闭", (Object) null, 1, (Object) null);
        qw qwVar = this.mOpenHelper;
        if (qwVar != null) {
            qwVar.close();
        }
        this.mOpenHelper = null;
    }

    private final UriMatcher getUriMatcher() {
        return (UriMatcher) this.uriMatcher$delegate.getValue();
    }

    private final void notify(Uri uri) {
        Context context;
        if (!Intrinsics.areEqual((Object) this.mThreadInTransaction.get(), (Object) Boolean.TRUE) && (context = getContext()) != null) {
            context.getContentResolver().notifyChange(uri, (ContentObserver) null, false);
        }
    }

    public void attachInfo(@Nullable Context context, @Nullable ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        getUriMatcher().addURI(DocScanContract.qw.i(), "tb_doc_scan_record", 1);
        getUriMatcher().addURI(DocScanContract.qw.i(), "tb_doc_scan_file", 2);
        getUriMatcher().addURI(DocScanContract.qw.i(), "tb_doc_scan_export_file", 3);
        getUriMatcher().addURI(DocScanContract.qw.i(), "tb_doc_scan_local_record", 4);
        getUriMatcher().addURI(DocScanContract.qw.i(), a.d, 5);
    }

    @Nullable
    public qw getOpenHelper() {
        String str;
        File filesDir;
        File dataDir;
        String uid = fe.mmm.qw.p030switch.rg.qw.qw().isLogin() ? fe.mmm.qw.p030switch.rg.qw.qw().getUid() : "offline_scan";
        String bduss = fe.mmm.qw.p030switch.rg.qw.qw().getBduss();
        String str2 = null;
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb = new StringBuilder();
            Context context = getContext();
            if (!(context == null || (dataDir = context.getDataDir()) == null)) {
                str2 = dataDir.getAbsolutePath();
            }
            sb.append(str2);
            sb.append(File.separator);
            sb.append(a.d);
            sb.append(File.separator);
            sb.append(uid);
            sb.append(File.separator);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            Context context2 = getContext();
            if (!(context2 == null || (filesDir = context2.getFilesDir()) == null)) {
                str2 = filesDir.getAbsolutePath();
            }
            sb2.append(str2);
            sb2.append(File.separator);
            sb2.append(a.d);
            sb2.append(File.separator);
            sb2.append(uid);
            sb2.append(File.separator);
            str = sb2.toString();
        }
        if (!new File(str).exists()) {
            new File(str).mkdirs();
        }
        if (this.mOpenHelper == null && !TextUtils.isEmpty(bduss)) {
            synchronized (this.lock) {
                String bduss2 = fe.mmm.qw.p030switch.rg.qw.qw().getBduss();
                if (this.mOpenHelper == null && !TextUtils.isEmpty(bduss2)) {
                    this.mOpenHelper = new fe.mmm.qw.rrr.qw.qw(getContext(), str);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return this.mOpenHelper;
    }

    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public boolean onAfterApply(@Nullable SQLiteDatabase sQLiteDatabase, @Nullable Uri uri) {
        return getUriMatcher().match(uri) != 5;
    }

    public void onBeforeApply(@Nullable SQLiteDatabase sQLiteDatabase, @Nullable Uri uri) {
        if (sQLiteDatabase == null) {
            close();
            return;
        }
        String uk2 = DocScanContract.qw.uk(uri);
        String bduss = fe.mmm.qw.p030switch.rg.qw.qw().getBduss();
        if (TextUtils.isEmpty(bduss) || (!TextUtils.isEmpty(uk2) && !Intrinsics.areEqual((Object) uk2, (Object) bduss))) {
            if (sQLiteDatabase.inTransaction()) {
                sQLiteDatabase.endTransaction();
            }
            close();
            throw new OperationApplicationException("user is logout");
        } else if (getUriMatcher().match(uri) == 5) {
            if (sQLiteDatabase.inTransaction()) {
                sQLiteDatabase.endTransaction();
            }
            close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onBulkInsert(@org.jetbrains.annotations.Nullable android.net.Uri r6, @org.jetbrains.annotations.Nullable android.content.ContentValues[] r7) {
        /*
            r5 = this;
            fe.mmm.qw.uk.qw r0 = r5.getOpenHelper()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            com.tera.scan.record.database.DocScanContract r2 = com.tera.scan.record.database.DocScanContract.qw
            java.lang.String r2 = r2.uk(r6)
            boolean r2 = r5.checkBduss(r2)
            if (r2 != 0) goto L_0x0015
            return r1
        L_0x0015:
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()
            boolean r2 = fe.mmm.qw.uk.fe.qw(r0)
            if (r2 != 0) goto L_0x0021
            r6 = -2
            return r6
        L_0x0021:
            if (r0 == 0) goto L_0x009a
            r2 = 1
            if (r7 == 0) goto L_0x0031
            int r3 = r7.length
            if (r3 != 0) goto L_0x002b
            r3 = 1
            goto L_0x002c
        L_0x002b:
            r3 = 0
        L_0x002c:
            if (r3 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r3 = 0
            goto L_0x0032
        L_0x0031:
            r3 = 1
        L_0x0032:
            if (r3 != 0) goto L_0x009a
            r3 = r7[r1]
            boolean r3 = fe.mmm.qw.uk.fe.de(r3)
            if (r3 == 0) goto L_0x003d
            goto L_0x009a
        L_0x003d:
            android.content.UriMatcher r3 = r5.getUriMatcher()
            int r3 = r3.match(r6)
            if (r3 == r2) goto L_0x0092
            r4 = 2
            if (r3 == r4) goto L_0x008a
            r4 = 3
            if (r3 == r4) goto L_0x0082
            r4 = 4
            if (r3 != r4) goto L_0x0058
            java.lang.String r6 = r5.buildLocalInsertStatement(r7)
            r0.execSQL(r6)
            goto L_0x0099
        L_0x0058:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unknown uri: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            r1 = 0
            com.mars.kotlin.extension.LoggerKt.e$default(r7, r1, r2, r1)
            java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r7.<init>(r6)
            throw r7
        L_0x0082:
            java.lang.String r6 = r5.buildExportFileInsertStatement(r7)
            r0.execSQL(r6)
            goto L_0x0099
        L_0x008a:
            java.lang.String r6 = r5.buildScanFileInsertStatement(r7)
            r0.execSQL(r6)
            goto L_0x0099
        L_0x0092:
            java.lang.String r6 = r5.buildScanRecordInsertStatement(r7)
            r0.execSQL(r6)
        L_0x0099:
            return r1
        L_0x009a:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.record.database.DocScanProvider.onBulkInsert(android.net.Uri, android.content.ContentValues[]):int");
    }

    public boolean onCreate() {
        return true;
    }

    public int onDelete(@Nullable Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int match = getUriMatcher().match(uri);
        int i2 = -1;
        if (match == 5) {
            close();
            return -1;
        }
        qw openHelper = getOpenHelper();
        String uk2 = DocScanContract.qw.uk(uri);
        if (openHelper != null && checkBduss(uk2)) {
            SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
            if (match == 1) {
                i2 = writableDatabase.delete("tb_doc_scan_record", str, strArr);
            } else if (match == 2) {
                i2 = writableDatabase.delete("tb_doc_scan_file", str, strArr);
            } else if (match == 3) {
                i2 = writableDatabase.delete("tb_doc_scan_export_file", str, strArr);
            } else if (match == 4) {
                i2 = writableDatabase.delete("tb_doc_scan_local_record", str, strArr);
            }
            onDeleteNotify(uri);
        }
        return i2;
    }

    public void onDeleteNotify(@Nullable Uri uri) {
        if (uri != null) {
            notify(uri);
        }
    }

    @Nullable
    public Uri onInsert(@Nullable Uri uri, @Nullable ContentValues contentValues) {
        qw openHelper = getOpenHelper();
        String uk2 = DocScanContract.qw.uk(uri);
        if (openHelper == null || !checkBduss(uk2)) {
            Intrinsics.checkNotNull(uri);
            return ContentUris.withAppendedId(uri, -1);
        }
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        int match = getUriMatcher().match(uri);
        if (match == 1) {
            writableDatabase.insertOrThrow("tb_doc_scan_record", (String) null, contentValues);
            return uri;
        } else if (match == 2) {
            writableDatabase.insertOrThrow("tb_doc_scan_file", (String) null, contentValues);
            return uri;
        } else if (match == 3) {
            writableDatabase.insertOrThrow("tb_doc_scan_export_file", (String) null, contentValues);
            return uri;
        } else if (match != 4) {
            return null;
        } else {
            writableDatabase.insertOrThrow("tb_doc_scan_local_record", (String) null, contentValues);
            return uri;
        }
    }

    public void onInsertNotify(@Nullable Uri uri, @Nullable ContentValues contentValues) {
        if (uri != null) {
            notify(uri);
        }
    }

    @Nullable
    public Cursor onQuery(@Nullable Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        qw openHelper = getOpenHelper();
        ContentResolver contentResolver = null;
        if (openHelper == null || !checkBduss(DocScanContract.qw.uk(uri))) {
            return null;
        }
        SQLiteDatabase readableDatabase = openHelper.getReadableDatabase();
        if (Intrinsics.areEqual((Object) "rawQuery", (Object) str2)) {
            LoggerKt.d$default("raw query: " + str, (Object) null, 1, (Object) null);
            return readableDatabase.rawQuery(str, (String[]) null);
        }
        rg buildQuerySelectionBuilder = buildQuerySelectionBuilder(uri, getUriMatcher().match(uri));
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        buildQuerySelectionBuilder.uk(str, (String[]) Arrays.copyOf(strArr2, strArr2.length));
        Cursor rg2 = buildQuerySelectionBuilder.rg(readableDatabase, strArr, str2);
        if (rg2 != null) {
            Context context = getContext();
            if (context != null) {
                contentResolver = context.getContentResolver();
            }
            rg2.setNotificationUri(contentResolver, uri);
        }
        return rg2;
    }

    public int onUpdate(@Nullable Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int i2;
        qw openHelper = getOpenHelper();
        String uk2 = DocScanContract.qw.uk(uri);
        if (openHelper == null || !checkBduss(uk2)) {
            return -1;
        }
        int match = getUriMatcher().match(uri);
        if (match == 5) {
            close();
            return -1;
        }
        SQLiteDatabase writableDatabase = openHelper.getWritableDatabase();
        if (match == 1) {
            i2 = writableDatabase.update("tb_doc_scan_record", contentValues, str, strArr);
        } else if (match == 2) {
            i2 = writableDatabase.update("tb_doc_scan_file", contentValues, str, strArr);
        } else if (match == 3) {
            i2 = writableDatabase.update("tb_doc_scan_export_file", contentValues, str, strArr);
        } else if (match != 4) {
            i2 = 0;
        } else {
            i2 = writableDatabase.update("tb_doc_scan_local_record", contentValues, str, strArr);
        }
        onUpdateNotify(uri, contentValues);
        return i2;
    }

    public void onUpdateNotify(@Nullable Uri uri, @Nullable ContentValues contentValues) {
        if (uri != null) {
            notify(uri);
        }
    }
}
