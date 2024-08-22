package fe.fe.o.rg.de;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import fe.fe.o.rg.qw.ad;
import fe.fe.o.rg.qw.qw;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public SQLiteDatabase f2620ad;

    /* renamed from: de  reason: collision with root package name */
    public Context f2621de;

    /* renamed from: fe  reason: collision with root package name */
    public qw f2622fe;
    public ad qw;

    public fe(Context context) {
        this.f2621de = context;
        ad adVar = new ad(context);
        this.qw = adVar;
        try {
            this.f2620ad = adVar.getWritableDatabase();
        } catch (SQLiteException unused) {
        }
        this.f2622fe = new qw(this.f2621de);
    }

    public Cursor ad(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        return this.f2622fe.de(this.f2620ad, strArr, str, strArr2, str2, str3, str4);
    }

    public int de(ContentValues contentValues, String str, String[] strArr) {
        return this.f2622fe.qw(this.f2620ad, contentValues, str, strArr);
    }

    public long qw(String str, String str2, String str3, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uri", str);
        contentValues.put("name", str2);
        contentValues.put("path", str3);
        contentValues.put("tasktype", Integer.valueOf(i2));
        return this.f2622fe.ad(this.f2620ad, contentValues);
    }
}
