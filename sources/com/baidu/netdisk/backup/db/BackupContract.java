package com.baidu.netdisk.backup.db;

import android.app.Application;
import android.net.Uri;
import android.provider.BaseColumns;
import com.baidu.netdisk.base.storage.db.BaseContract;
import com.baidu.netdisk.kernel.ApplicationUtil;
import com.baidu.searchbox.downloads.DownloadConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/baidu/netdisk/backup/db/BackupContract;", "Lcom/baidu/netdisk/base/storage/db/BaseContract;", "()V", "CONTENT_AUTHORITY", "", "getCONTENT_AUTHORITY", "()Ljava/lang/String;", "BackupColumns", "BackupDatabase", "Database", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackupContract.kt */
public final class BackupContract implements BaseContract {
    public static final BackupContract INSTANCE = new BackupContract();

    private BackupContract() {
    }

    public final String getCONTENT_AUTHORITY() {
        StringBuilder sb = new StringBuilder();
        Application application = ApplicationUtil.Companion.getApplication();
        return sb.append(application != null ? application.getPackageName() : null).append(".netdisk.backup").toString();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/netdisk/backup/db/BackupContract$Database;", "", "()V", "CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "buildDatabaseUri", "bduss", "", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BackupContract.kt */
    public static final class Database {
        private static final Uri CONTENT_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + BackupContract.INSTANCE.getCONTENT_AUTHORITY() + "/close_database");
        public static final Database INSTANCE = new Database();

        private Database() {
        }

        public final Uri buildDatabaseUri(String bduss) {
            Uri build = CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
            Intrinsics.checkNotNullExpressionValue(build, "CONTENT_URI.buildUpon()\n…ri.encode(bduss)).build()");
            return build;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/baidu/netdisk/backup/db/BackupContract$BackupDatabase;", "", "()V", "CONTENT_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "buildUri", "bduss", "", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BackupContract.kt */
    public static final class BackupDatabase {
        private static final Uri CONTENT_URI = Uri.parse(DownloadConstants.LOCAL_DATA_URI_PREFIX + BackupContract.INSTANCE.getCONTENT_AUTHORITY() + "/backup");
        public static final BackupDatabase INSTANCE = new BackupDatabase();

        private BackupDatabase() {
        }

        public final Uri buildUri(String bduss) {
            Uri build = CONTENT_URI.buildUpon().appendQueryParameter("bduss", Uri.encode(bduss)).build();
            Intrinsics.checkNotNullExpressionValue(build, "CONTENT_URI.buildUpon()\n…ri.encode(bduss)).build()");
            return build;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/netdisk/backup/db/BackupContract$BackupColumns;", "Landroid/provider/BaseColumns;", "()V", "BACKUP_STATE", "", "BACKUP_TYPE", "ERROR_CODE", "ERROR_ORIGINAL_CODE", "FILE_EXTENSION", "FILE_MTIME", "FILE_NAME", "FILE_PATH", "FILE_SIZE", "IS_COMPRESSED", "IS_REPORT", "IS_SERVER", "OFFSET", "RATE", "BaiduNetDiskModules_BackUp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BackupContract.kt */
    public static final class BackupColumns implements BaseColumns {
        public static final String BACKUP_STATE = "backup_state";
        public static final String BACKUP_TYPE = "backup_type";
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_ORIGINAL_CODE = "error_original_code";
        public static final String FILE_EXTENSION = "file_extension";
        public static final String FILE_MTIME = "file_mtime";
        public static final String FILE_NAME = "file_name";
        public static final String FILE_PATH = "file_path";
        public static final String FILE_SIZE = "file_size";
        public static final BackupColumns INSTANCE = new BackupColumns();
        public static final String IS_COMPRESSED = "is_compressed";
        public static final String IS_REPORT = "is_report";
        public static final String IS_SERVER = "is_server";
        public static final String OFFSET = "offset";
        public static final String RATE = "rate";

        private BackupColumns() {
        }
    }
}
