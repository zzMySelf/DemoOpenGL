package fe.fe.o.rg.qw;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.io.PathUtils;

public class ad extends SQLiteOpenHelper {
    public ad(Context context) {
        super(context, "bddownloads.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final void de(SQLiteDatabase sQLiteDatabase, int i2) {
        if (i2 == 2) {
            fe(sQLiteDatabase, PathUtils.DIRCTORY_DOWNLOAD, "progress_map", "TEXT");
            return;
        }
        throw new IllegalStateException("Don't know how to upgrade to " + i2);
    }

    public final void fe(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        sQLiteDatabase.execSQL("ALTER TABLE " + str + " ADD COLUMN " + str2 + " " + str3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        qw(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        qw(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        while (true) {
            i2++;
            if (i2 <= i3) {
                de(sQLiteDatabase, i2);
            } else {
                return;
            }
        }
    }

    public final void qw(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, name TEXT, path TEXT, data TEXT, mimetype TEXT, etag TEXT, tasktype INTEGER, status INTEGER DEFAULT 0, lastmodification BIGINT DEFAULT " + System.currentTimeMillis() + StringUtil.ARRAY_ELEMENT_SEPARATOR + "total_bytes" + " BIGINT DEFAULT 0, " + "current_bytes" + " BIGINT DEFAULT 0, " + "progress_map" + " TEXT, " + "retry_count" + " INTEGER DEFAULT 0);");
        } catch (SQLException e) {
            throw e;
        }
    }
}
