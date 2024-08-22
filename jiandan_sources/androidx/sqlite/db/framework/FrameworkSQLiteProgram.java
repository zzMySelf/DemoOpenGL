package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteProgram mDelegate;

    public FrameworkSQLiteProgram(SQLiteProgram sQLiteProgram) {
        this.mDelegate = sQLiteProgram;
    }

    public void bindBlob(int i2, byte[] bArr) {
        this.mDelegate.bindBlob(i2, bArr);
    }

    public void bindDouble(int i2, double d) {
        this.mDelegate.bindDouble(i2, d);
    }

    public void bindLong(int i2, long j) {
        this.mDelegate.bindLong(i2, j);
    }

    public void bindNull(int i2) {
        this.mDelegate.bindNull(i2);
    }

    public void bindString(int i2, String str) {
        this.mDelegate.bindString(i2, str);
    }

    public void clearBindings() {
        this.mDelegate.clearBindings();
    }

    public void close() {
        this.mDelegate.close();
    }
}
