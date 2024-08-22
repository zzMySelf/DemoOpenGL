package fe.nn.qw;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final String f8780ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f8781de;

    /* renamed from: fe  reason: collision with root package name */
    public final int f8782fe;
    public final boolean qw;

    /* renamed from: rg  reason: collision with root package name */
    public SQLiteDatabase f8783rg;

    /* renamed from: th  reason: collision with root package name */
    public boolean f8784th;

    /* renamed from: fe.nn.qw.qw$qw  reason: collision with other inner class name */
    public class C0303qw implements DatabaseErrorHandler {
        public C0303qw(qw qwVar) {
        }

        public void onCorruption(SQLiteDatabase sQLiteDatabase) {
        }
    }

    public qw(String str, int i2, boolean z, int i3) {
        this.f8780ad = str;
        this.qw = z;
        this.f8781de = i2;
        this.f8782fe = i3;
    }

    public static void ad(String str) {
        SQLiteDatabase.deleteDatabase(new File(str));
    }

    public SQLiteDatabase de() {
        return this.f8783rg;
    }

    public String fe() {
        return "[" + rg() + "] ";
    }

    public void qw() {
        this.f8783rg.close();
    }

    public String rg() {
        Thread currentThread = Thread.currentThread();
        return "" + this.f8781de + "," + currentThread.getName() + "(" + currentThread.getId() + ")";
    }

    public SQLiteDatabase th() {
        return this.f8783rg;
    }

    public void uk() {
        this.f8783rg = SQLiteDatabase.openDatabase(this.f8780ad, (SQLiteDatabase.CursorFactory) null, 1, new C0303qw(this));
    }

    public void yj() {
        this.f8783rg = SQLiteDatabase.openDatabase(this.f8780ad, (SQLiteDatabase.CursorFactory) null, 268435456);
    }
}
