package fe.fe.o.rg.qw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.util.io.PathUtils;

public final class qw {
    public qw(Context context) {
    }

    public long ad(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.insert(PathUtils.DIRCTORY_DOWNLOAD, (String) null, contentValues);
    }

    public Cursor de(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return sQLiteDatabase.query(PathUtils.DIRCTORY_DOWNLOAD, strArr, str, strArr2, str2, str3, str4);
    }

    public int qw(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        return sQLiteDatabase.update(PathUtils.DIRCTORY_DOWNLOAD, contentValues, str, strArr);
    }
}
