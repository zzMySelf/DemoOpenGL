package fe.fe.ddd.th.qw;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import fe.fe.ddd.i.qw.qw;

public class de extends SQLiteOpenHelper {

    /* renamed from: ad  reason: collision with root package name */
    public static de f1666ad;

    /* renamed from: th  reason: collision with root package name */
    public static SQLiteDatabase f1667th;

    public de(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    public static synchronized de de() {
        de deVar;
        synchronized (de.class) {
            if (f1666ad == null) {
                f1666ad = new de(qw.qw(), "com.baidu.searchbox.cloudcommand", (SQLiteDatabase.CursorFactory) null, 1);
            }
            deVar = f1666ad;
        }
        return deVar;
    }

    public static synchronized SQLiteDatabase qw() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (de.class) {
            if (f1667th == null) {
                f1667th = de().getWritableDatabase();
            }
            sQLiteDatabase = f1667th;
        }
        return sQLiteDatabase;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table cloudcommand(msgId text primary key,type text ,dispatched integer,version text,timestamp integer)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
