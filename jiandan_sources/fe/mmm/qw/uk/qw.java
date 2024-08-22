package fe.mmm.qw.uk;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.tera.scan.db.IUpgradable;
import com.tera.scan.db.IVersion;

public abstract class qw extends SQLiteOpenHelper {
    public qw(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }

    public abstract IUpgradable de();

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        fe.mmm.qw.i.qw.ppp("BaseSQLiteOpenHelper", "数据库降级:" + i2 + "," + i3);
    }

    @TargetApi(11)
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        try {
            if (qw(sQLiteDatabase)) {
                boolean enableWriteAheadLogging = sQLiteDatabase.enableWriteAheadLogging();
                fe.mmm.qw.i.qw.ad("BaseSQLiteOpenHelper", "enableWriteAheadLogging:" + enableWriteAheadLogging);
            }
        } catch (SQLiteException e) {
            fe.mmm.qw.i.qw.ggg("BaseSQLiteOpenHelper", "enableWriteAheadLogging failed", e);
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        IUpgradable de2 = de();
        if (de2 != null) {
            while (true) {
                i2++;
                if (i2 <= i3) {
                    IVersion qw = de2.qw(i2);
                    if (qw != null) {
                        try {
                            qw.qw(sQLiteDatabase);
                        } catch (SQLiteException e) {
                            fe.mmm.qw.i.qw.th("BaseSQLiteOpenHelper", "update failed！", e);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean qw(SQLiteDatabase sQLiteDatabase) {
        return fe.ad(sQLiteDatabase);
    }
}
