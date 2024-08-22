package fe.mmm.qw.rrr.qw;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tera.scan.db.IUpgradable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw extends fe.mmm.qw.uk.qw {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qw(@Nullable Context context, @NotNull String str) {
        super(context, str + "doc_scan.db", (SQLiteDatabase.CursorFactory) null, 3);
        Intrinsics.checkNotNullParameter(str, "path");
    }

    @Nullable
    public IUpgradable de() {
        return new de();
    }

    public final void fe(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_doc_scan_export_file ( _id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, record_id TEXT , fsid TEXT UNIQUE, server_path TEXT, local_path TEXT, filename TEXT, server_ctime INTEGER, size INTEGER, status INTEGER)");
        }
    }

    public void onCreate(@Nullable SQLiteDatabase sQLiteDatabase) {
        th(sQLiteDatabase);
        rg(sQLiteDatabase);
        fe(sQLiteDatabase);
        yj(sQLiteDatabase);
    }

    public final void rg(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_doc_scan_file (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, record_id TEXT , fsid TEXT , position INTEGER, server_path TEXT, local_path TEXT, size INTEGER, status INTEGER NOT NULL)");
        }
    }

    public final void th(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS  tb_doc_scan_record (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, record_id TEXT UNIQUE ON CONFLICT REPLACE, name TEXT, display_name TEXT, m_time INTEGER, category INTEGER, c_time INTEGER NOT NULL DEFAULT 0, open_time INTEGER NOT NULL DEFAULT 0, export_file_type TEXT)");
        }
    }

    public final void yj(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_doc_scan_local_record ( _id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, record_id TEXT, save_path TEXT)");
        }
    }
}
