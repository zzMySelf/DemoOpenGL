package fe.mmm.qw.uk;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import fe.mmm.qw.i.qw;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f8568ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f8569de = false;

    /* renamed from: fe  reason: collision with root package name */
    public static boolean f8570fe = false;
    public static boolean qw = false;

    public static synchronized boolean ad(SQLiteDatabase sQLiteDatabase) {
        synchronized (fe.class) {
            if (f8569de) {
                boolean z = f8570fe;
                return z;
            } else if (sQLiteDatabase == null) {
                f8569de = true;
                boolean z2 = f8570fe;
                return z2;
            } else {
                try {
                    String simpleQueryForString = sQLiteDatabase.compileStatement("SELECT sqlite_version()").simpleQueryForString();
                    qw.uk("SqliteDBHelper", "SQLite version=" + simpleQueryForString);
                    String[] split = simpleQueryForString.split("\\.");
                    boolean z3 = false;
                    if ((split.length >= 3 && Integer.valueOf(split[0]).intValue() > 3) || (Integer.valueOf(split[0]).intValue() == 3 && Integer.valueOf(split[1]).intValue() >= 7)) {
                        if (Build.VERSION.SDK_INT >= 11) {
                            z3 = true;
                        }
                        f8570fe = z3;
                    }
                } catch (NumberFormatException e) {
                    qw.th("SqliteDBHelper", "canInsertRows NumberFormat", e);
                } catch (SQLiteException e2) {
                    try {
                        qw.th("SqliteDBHelper", "canInsertRows SQLite", e2);
                    } catch (Throwable th2) {
                        f8569de = true;
                        throw th2;
                    }
                }
                f8569de = true;
                boolean z4 = f8570fe;
                return z4;
            }
        }
    }

    public static boolean de(ContentValues contentValues) {
        if (contentValues == null) {
            return false;
        }
        return "CHECK_DB_VERSION".equals(contentValues.getAsString("CHECK_DB_VERSION"));
    }

    public static synchronized boolean qw(SQLiteDatabase sQLiteDatabase) {
        synchronized (fe.class) {
            if (qw) {
                boolean z = f8568ad;
                return z;
            } else if (sQLiteDatabase == null) {
                qw = true;
                boolean z2 = f8568ad;
                return z2;
            } else {
                try {
                    String simpleQueryForString = sQLiteDatabase.compileStatement("SELECT sqlite_version()").simpleQueryForString();
                    qw.uk("SqliteDBHelper", "SQLite version=" + simpleQueryForString);
                    String[] split = simpleQueryForString.split("\\.");
                    if ((split.length >= 3 && Integer.valueOf(split[0]).intValue() > 3) || ((Integer.valueOf(split[0]).intValue() == 3 && Integer.valueOf(split[1]).intValue() > 7) || (Integer.valueOf(split[0]).intValue() == 3 && Integer.valueOf(split[1]).intValue() == 7 && Integer.valueOf(split[2]).intValue() >= 11))) {
                        f8568ad = true;
                    }
                } catch (NumberFormatException e) {
                    qw.th("SqliteDBHelper", "canInsertRows NumberFormat", e);
                } catch (SQLiteException e2) {
                    try {
                        qw.th("SqliteDBHelper", "canInsertRows SQLite", e2);
                    } catch (Throwable th2) {
                        qw = true;
                        throw th2;
                    }
                }
                qw = true;
                boolean z3 = f8568ad;
                return z3;
            }
        }
    }
}
