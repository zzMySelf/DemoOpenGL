package fe.fe.nn.p005if;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import fe.fe.nn.ppp.de;
import java.util.ArrayList;

/* renamed from: fe.fe.nn.if.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile qw f2247ad;
    public final ad qw;

    /* renamed from: fe.fe.nn.if.qw$ad */
    public static class ad extends SQLiteOpenHelper {
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("create table if not exists rp_tb(id integer primary key autoincrement, a text, c integer, d integer);");
            } catch (Throwable th2) {
                de.fe(th2);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 == 1 && i3 == 2) {
                try {
                    sQLiteDatabase.delete("rp_tb", (String) null, (String[]) null);
                } catch (Throwable th2) {
                    de.fe(th2);
                }
            }
        }

        public ad(Context context) {
            super(context, "sso.db", (SQLiteDatabase.CursorFactory) null, 2);
        }
    }

    public qw(Context context) {
        this.qw = new ad(context);
    }

    public static qw qw(Context context) {
        if (f2247ad == null) {
            synchronized (qw.class) {
                if (f2247ad == null) {
                    f2247ad = new qw(context);
                }
            }
        }
        return f2247ad;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb A[SYNTHETIC, Splitter:B:40:0x00bb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<fe.fe.nn.p006switch.qw> ad(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            fe.fe.nn.if.qw$ad r1 = r6.qw     // Catch:{ all -> 0x00b4 }
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ all -> 0x00b4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r2.<init>()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "SELECT * FROM rp_tb WHERE c IN ("
            r2.append(r3)     // Catch:{ all -> 0x00b4 }
            r2.append(r7)     // Catch:{ all -> 0x00b4 }
            java.lang.String r7 = ") LIMIT 100"
            r2.append(r7)     // Catch:{ all -> 0x00b4 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x00b4 }
            android.database.Cursor r7 = r1.rawQuery(r7, r0)     // Catch:{ all -> 0x00b4 }
            if (r7 == 0) goto L_0x00a3
            int r1 = r7.getCount()     // Catch:{ all -> 0x00a1 }
            if (r1 != 0) goto L_0x002b
            goto L_0x00a3
        L_0x002b:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00a1 }
            r1.<init>()     // Catch:{ all -> 0x00a1 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00a1 }
            r2.<init>()     // Catch:{ all -> 0x00a1 }
        L_0x0035:
            boolean r3 = r7.moveToNext()     // Catch:{ all -> 0x00a1 }
            if (r3 == 0) goto L_0x0087
            fe.fe.nn.switch.qw r3 = new fe.fe.nn.switch.qw     // Catch:{ all -> 0x00a1 }
            r3.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = "id"
            int r4 = r7.getColumnIndex(r4)     // Catch:{ all -> 0x00a1 }
            int r4 = r7.getInt(r4)     // Catch:{ all -> 0x00a1 }
            r3.ad(r4)     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = "a"
            int r4 = r7.getColumnIndex(r4)     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = r7.getString(r4)     // Catch:{ all -> 0x00a1 }
            byte[] r4 = fe.fe.nn.ppp.qw.ad(r4)     // Catch:{ all -> 0x00a1 }
            if (r4 != 0) goto L_0x0061
            r2.add(r3)     // Catch:{ all -> 0x00a1 }
            goto L_0x0035
        L_0x0061:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x00a1 }
            r5.<init>(r4)     // Catch:{ all -> 0x00a1 }
            r3.de(r5)     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = "c"
            int r4 = r7.getColumnIndex(r4)     // Catch:{ all -> 0x00a1 }
            int r4 = r7.getInt(r4)     // Catch:{ all -> 0x00a1 }
            r3.yj(r4)     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = "d"
            int r4 = r7.getColumnIndex(r4)     // Catch:{ all -> 0x00a1 }
            int r4 = r7.getInt(r4)     // Catch:{ all -> 0x00a1 }
            r3.rg(r4)     // Catch:{ all -> 0x00a1 }
            r1.add(r3)     // Catch:{ all -> 0x00a1 }
            goto L_0x0035
        L_0x0087:
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x00a1 }
            if (r3 != 0) goto L_0x0090
            r6.fe(r2)     // Catch:{ all -> 0x00a1 }
        L_0x0090:
            if (r7 == 0) goto L_0x00a0
            boolean r0 = r7.isClosed()     // Catch:{ all -> 0x009c }
            if (r0 != 0) goto L_0x00a0
            r7.close()     // Catch:{ all -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r7 = move-exception
            fe.fe.nn.ppp.de.fe(r7)
        L_0x00a0:
            return r1
        L_0x00a1:
            r1 = move-exception
            goto L_0x00b6
        L_0x00a3:
            if (r7 == 0) goto L_0x00b3
            boolean r1 = r7.isClosed()     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x00b3
            r7.close()     // Catch:{ all -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r7 = move-exception
            fe.fe.nn.ppp.de.fe(r7)
        L_0x00b3:
            return r0
        L_0x00b4:
            r1 = move-exception
            r7 = r0
        L_0x00b6:
            fe.fe.nn.ppp.de.fe(r1)     // Catch:{ all -> 0x00ca }
            if (r7 == 0) goto L_0x00c9
            boolean r1 = r7.isClosed()     // Catch:{ all -> 0x00c5 }
            if (r1 != 0) goto L_0x00c9
            r7.close()     // Catch:{ all -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r7 = move-exception
            fe.fe.nn.ppp.de.fe(r7)
        L_0x00c9:
            return r0
        L_0x00ca:
            r0 = move-exception
            if (r7 == 0) goto L_0x00db
            boolean r1 = r7.isClosed()     // Catch:{ all -> 0x00d7 }
            if (r1 != 0) goto L_0x00db
            r7.close()     // Catch:{ all -> 0x00d7 }
            goto L_0x00db
        L_0x00d7:
            r7 = move-exception
            fe.fe.nn.ppp.de.fe(r7)
        L_0x00db:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.p005if.qw.ad(java.lang.String):java.util.ArrayList");
    }

    public final void de(fe.fe.nn.p006switch.qw qwVar) {
        try {
            SQLiteDatabase writableDatabase = this.qw.getWritableDatabase();
            writableDatabase.delete("rp_tb", "id=?", new String[]{String.valueOf(qwVar.qw())});
        } catch (Throwable th2) {
            System.currentTimeMillis();
            de.fe(th2);
        }
    }

    public void fe(ArrayList<fe.fe.nn.p006switch.qw> arrayList) {
        if (arrayList != null) {
            try {
                if (arrayList.size() != 0) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        de(arrayList.get(i2));
                    }
                }
            } catch (Throwable th2) {
                de.fe(th2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cc A[SYNTHETIC, Splitter:B:40:0x00cc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<fe.fe.nn.p006switch.qw> rg(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "d"
            r1 = 0
            fe.fe.nn.if.qw$ad r2 = r7.qw     // Catch:{ all -> 0x00c5 }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ all -> 0x00c5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c5 }
            r3.<init>()     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "SELECT * FROM rp_tb WHERE c IN ("
            r3.append(r4)     // Catch:{ all -> 0x00c5 }
            r3.append(r8)     // Catch:{ all -> 0x00c5 }
            java.lang.String r8 = ") and "
            r3.append(r8)     // Catch:{ all -> 0x00c5 }
            r3.append(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r8 = "="
            r3.append(r8)     // Catch:{ all -> 0x00c5 }
            r8 = 2
            r3.append(r8)     // Catch:{ all -> 0x00c5 }
            java.lang.String r8 = " LIMIT 100"
            r3.append(r8)     // Catch:{ all -> 0x00c5 }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x00c5 }
            android.database.Cursor r8 = r2.rawQuery(r8, r1)     // Catch:{ all -> 0x00c5 }
            if (r8 == 0) goto L_0x00b4
            int r2 = r8.getCount()     // Catch:{ all -> 0x00b2 }
            if (r2 != 0) goto L_0x003e
            goto L_0x00b4
        L_0x003e:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00b2 }
            r2.<init>()     // Catch:{ all -> 0x00b2 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00b2 }
            r3.<init>()     // Catch:{ all -> 0x00b2 }
        L_0x0048:
            boolean r4 = r8.moveToNext()     // Catch:{ all -> 0x00b2 }
            if (r4 == 0) goto L_0x0098
            fe.fe.nn.switch.qw r4 = new fe.fe.nn.switch.qw     // Catch:{ all -> 0x00b2 }
            r4.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r5 = "id"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ all -> 0x00b2 }
            int r5 = r8.getInt(r5)     // Catch:{ all -> 0x00b2 }
            r4.ad(r5)     // Catch:{ all -> 0x00b2 }
            java.lang.String r5 = "a"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ all -> 0x00b2 }
            java.lang.String r5 = r8.getString(r5)     // Catch:{ all -> 0x00b2 }
            byte[] r5 = fe.fe.nn.ppp.qw.ad(r5)     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x0074
            r3.add(r4)     // Catch:{ all -> 0x00b2 }
            goto L_0x0048
        L_0x0074:
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x00b2 }
            r6.<init>(r5)     // Catch:{ all -> 0x00b2 }
            r4.de(r6)     // Catch:{ all -> 0x00b2 }
            java.lang.String r5 = "c"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ all -> 0x00b2 }
            int r5 = r8.getInt(r5)     // Catch:{ all -> 0x00b2 }
            r4.yj(r5)     // Catch:{ all -> 0x00b2 }
            int r5 = r8.getColumnIndex(r0)     // Catch:{ all -> 0x00b2 }
            int r5 = r8.getInt(r5)     // Catch:{ all -> 0x00b2 }
            r4.rg(r5)     // Catch:{ all -> 0x00b2 }
            r2.add(r4)     // Catch:{ all -> 0x00b2 }
            goto L_0x0048
        L_0x0098:
            boolean r0 = r3.isEmpty()     // Catch:{ all -> 0x00b2 }
            if (r0 != 0) goto L_0x00a1
            r7.fe(r3)     // Catch:{ all -> 0x00b2 }
        L_0x00a1:
            if (r8 == 0) goto L_0x00b1
            boolean r0 = r8.isClosed()     // Catch:{ all -> 0x00ad }
            if (r0 != 0) goto L_0x00b1
            r8.close()     // Catch:{ all -> 0x00ad }
            goto L_0x00b1
        L_0x00ad:
            r8 = move-exception
            fe.fe.nn.ppp.de.fe(r8)
        L_0x00b1:
            return r2
        L_0x00b2:
            r0 = move-exception
            goto L_0x00c7
        L_0x00b4:
            if (r8 == 0) goto L_0x00c4
            boolean r0 = r8.isClosed()     // Catch:{ all -> 0x00c0 }
            if (r0 != 0) goto L_0x00c4
            r8.close()     // Catch:{ all -> 0x00c0 }
            goto L_0x00c4
        L_0x00c0:
            r8 = move-exception
            fe.fe.nn.ppp.de.fe(r8)
        L_0x00c4:
            return r1
        L_0x00c5:
            r0 = move-exception
            r8 = r1
        L_0x00c7:
            fe.fe.nn.ppp.de.fe(r0)     // Catch:{ all -> 0x00db }
            if (r8 == 0) goto L_0x00da
            boolean r0 = r8.isClosed()     // Catch:{ all -> 0x00d6 }
            if (r0 != 0) goto L_0x00da
            r8.close()     // Catch:{ all -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r8 = move-exception
            fe.fe.nn.ppp.de.fe(r8)
        L_0x00da:
            return r1
        L_0x00db:
            r0 = move-exception
            if (r8 == 0) goto L_0x00ec
            boolean r1 = r8.isClosed()     // Catch:{ all -> 0x00e8 }
            if (r1 != 0) goto L_0x00ec
            r8.close()     // Catch:{ all -> 0x00e8 }
            goto L_0x00ec
        L_0x00e8:
            r8 = move-exception
            fe.fe.nn.ppp.de.fe(r8)
        L_0x00ec:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.p005if.qw.rg(java.lang.String):java.util.ArrayList");
    }

    public void th(fe.fe.nn.p006switch.qw qwVar) {
        if (qwVar != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("a", fe.fe.nn.ppp.qw.qw(qwVar.fe().getBytes()));
                contentValues.put("c", Integer.valueOf(qwVar.uk()));
                contentValues.put("d", Integer.valueOf(qwVar.th()));
                this.qw.getWritableDatabase().insert("rp_tb", (String) null, contentValues);
            } catch (Throwable th2) {
                de.fe(th2);
            }
        }
    }
}
