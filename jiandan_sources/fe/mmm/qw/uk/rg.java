package fe.mmm.qw.uk;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDiskIOException;
import android.text.TextUtils;
import com.google.android.gms.actions.SearchIntents;
import fe.mmm.qw.i.qw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<String, String> f8571ad = new HashMap();

    /* renamed from: de  reason: collision with root package name */
    public final StringBuilder f8572de = new StringBuilder();

    /* renamed from: fe  reason: collision with root package name */
    public final ArrayList<String> f8573fe = new ArrayList<>();
    public String qw = null;

    public String ad() {
        return this.f8572de.toString();
    }

    public String[] de() {
        ArrayList<String> arrayList = this.f8573fe;
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void fe(String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = this.f8571ad.get(strArr[i2]);
            if (str != null) {
                strArr[i2] = str;
            }
        }
    }

    public final void qw() {
        if (this.qw == null) {
            throw new IllegalStateException("Table not specified");
        }
    }

    public Cursor rg(SQLiteDatabase sQLiteDatabase, String[] strArr, String str) {
        return th(sQLiteDatabase, strArr, (String) null, (String) null, str, (String) null);
    }

    public Cursor th(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String str2, String str3, String str4) {
        String[] strArr2 = strArr;
        qw();
        if (strArr2 != null) {
            fe(strArr2);
        }
        qw.m973switch("SelectionBuilder", "query(columns=" + Arrays.toString(strArr) + ") " + this);
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            return sQLiteDatabase.query(this.qw, strArr, ad(), de(), str, str2, str3, str4);
        } catch (SQLiteDiskIOException e) {
            qw.ggg("SelectionBuilder", SearchIntents.EXTRA_QUERY, e);
            return null;
        } catch (IllegalStateException e2) {
            qw.ggg("SelectionBuilder", SearchIntents.EXTRA_QUERY, e2);
            return null;
        } catch (Exception e3) {
            qw.ggg("SelectionBuilder", SearchIntents.EXTRA_QUERY, e3);
            return null;
        }
    }

    public String toString() {
        return "SelectionBuilder[table=" + this.qw + ", selection=" + ad() + ", selectionArgs=" + Arrays.toString(de()) + "]";
    }

    public rg uk(String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f8572de.length() > 0) {
                this.f8572de.append(" AND ");
            }
            StringBuilder sb = this.f8572de;
            sb.append("(");
            sb.append(str);
            sb.append(")");
            if (strArr != null) {
                Collections.addAll(this.f8573fe, strArr);
            }
            return this;
        } else if (strArr == null || strArr.length <= 0) {
            return this;
        } else {
            throw new IllegalArgumentException("Valid selection required when including arguments=");
        }
    }

    public rg yj(String str) {
        this.qw = str;
        return this;
    }
}
