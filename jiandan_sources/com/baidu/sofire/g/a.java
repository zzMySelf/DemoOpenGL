package com.baidu.sofire.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import com.baidu.apollon.restnet.rest.g;
import com.baidu.sofire.ac.F;
import com.baidu.wallet.paysdk.b.j;
import com.cmic.sso.sdk.e.i;

public class a {
    public static a d;
    public final C0053a a;
    public SQLiteDatabase b;
    public final Context c;

    /* renamed from: com.baidu.sofire.g.a$a  reason: collision with other inner class name */
    public class C0053a extends SQLiteOpenHelper {
        public C0053a(a aVar, Context context) {
            super(context, "d.db", (SQLiteDatabase.CursorFactory) null, 3);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c integer, e integer,f integer,h text, g integer, i integer, j text, d long);");
            sQLiteDatabase.execSQL("create table if not exists c(a integer primary key autoincrement, b text); ");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            if (i2 <= 1) {
                sQLiteDatabase.execSQL("alter table r add i integer default 0;");
            }
            if (i2 <= 2) {
                sQLiteDatabase.execSQL("ALTER TABLE r ADD COLUMN j TEXT");
            }
        }
    }

    public a(Context context) {
        this.c = context;
        this.a = new C0053a(this, context);
        a();
    }

    public final void a() {
        try {
            this.b = this.a.getWritableDatabase();
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a(context);
            }
            aVar = d;
        }
        return aVar;
    }

    public long a(com.baidu.sofire.h.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("b", aVar.c);
        contentValues.put("c", Integer.valueOf(aVar.d));
        contentValues.put("d", Long.valueOf(aVar.f));
        contentValues.put("e", Integer.valueOf(aVar.h));
        contentValues.put(g.a, Integer.valueOf(aVar.g));
        contentValues.put("f", Integer.valueOf(aVar.f1088i));
        contentValues.put(i.a, Integer.valueOf(aVar.j));
        contentValues.put(j.q, aVar.k);
        String str = aVar.e;
        try {
            str = Base64.encodeToString(F.getInstance().ae(str.getBytes(), "xVOTuxgN3lkRN2v4".getBytes(com.baidu.apollon.heartbeat.a.h)), 0);
        } catch (Exception unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
        contentValues.put("h", str);
        try {
            return this.b.insert("r", (String) null, contentValues);
        } catch (Throwable unused2) {
            int i3 = com.baidu.sofire.a.a.a;
            return -1;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:27|26|28|30|31|32|33|34|35|36|(2:37|38)|41|42) */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:27|26|28|30|31|32|33|34|35|36|37|38|41|42) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1 = com.baidu.sofire.a.a.a;
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9.b.setTransactionSuccessful();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r9.b.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        com.baidu.sofire.i.b.g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r10 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005d, code lost:
        r10 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007f, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r9.b.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        com.baidu.sofire.i.b.g = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008d, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0062 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0069 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0073 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x0086 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.util.List<java.lang.Integer> r10) {
        /*
            r9 = this;
            r0 = -1
            android.database.sqlite.SQLiteDatabase r1 = r9.b     // Catch:{ all -> 0x0061 }
            r1.beginTransaction()     // Catch:{ all -> 0x0061 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0061 }
            r1 = -1
        L_0x000b:
            boolean r2 = r10.hasNext()     // Catch:{ all -> 0x0060 }
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r10.next()     // Catch:{ all -> 0x0060 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x0060 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0060 }
            android.database.sqlite.SQLiteDatabase r3 = r9.b     // Catch:{ all -> 0x003d }
            java.lang.String r4 = "r"
            java.lang.String r5 = "a=?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x003d }
            r7 = 0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            r8.<init>()     // Catch:{ all -> 0x003d }
            r8.append(r2)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = ""
            r8.append(r2)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x003d }
            r6[r7] = r2     // Catch:{ all -> 0x003d }
            int r1 = r3.delete(r4, r5, r6)     // Catch:{ all -> 0x003d }
            goto L_0x0040
        L_0x003d:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0062 }
            r1 = -1
        L_0x0040:
            if (r1 > 0) goto L_0x000b
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0062 }
            com.baidu.sofire.i.b.g = r2     // Catch:{ all -> 0x0062 }
            goto L_0x000b
        L_0x0049:
            android.database.sqlite.SQLiteDatabase r10 = r9.b     // Catch:{ all -> 0x0060 }
            r10.setTransactionSuccessful()     // Catch:{ all -> 0x0060 }
            android.database.sqlite.SQLiteDatabase r10 = r9.b     // Catch:{ all -> 0x0054 }
            r10.endTransaction()     // Catch:{ all -> 0x0054 }
            goto L_0x007e
        L_0x0054:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005b }
            com.baidu.sofire.i.b.g = r2     // Catch:{ all -> 0x005b }
            goto L_0x005d
        L_0x005b:
            int r10 = com.baidu.sofire.a.a.a
        L_0x005d:
            int r10 = com.baidu.sofire.a.a.a
            goto L_0x007e
        L_0x0060:
            r0 = r1
        L_0x0061:
            r1 = r0
        L_0x0062:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0069 }
            com.baidu.sofire.i.b.g = r2     // Catch:{ all -> 0x0069 }
            goto L_0x006b
        L_0x0069:
            int r10 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x007f }
        L_0x006b:
            int r10 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x007f }
            android.database.sqlite.SQLiteDatabase r10 = r9.b     // Catch:{ all -> 0x0073 }
            r10.endTransaction()     // Catch:{ all -> 0x0073 }
            goto L_0x007e
        L_0x0073:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x007a }
            com.baidu.sofire.i.b.g = r2     // Catch:{ all -> 0x007a }
            goto L_0x007c
        L_0x007a:
            int r10 = com.baidu.sofire.a.a.a
        L_0x007c:
            int r10 = com.baidu.sofire.a.a.a
        L_0x007e:
            return r1
        L_0x007f:
            r10 = move-exception
            android.database.sqlite.SQLiteDatabase r0 = r9.b     // Catch:{ all -> 0x0086 }
            r0.endTransaction()     // Catch:{ all -> 0x0086 }
            goto L_0x0091
        L_0x0086:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008d }
            com.baidu.sofire.i.b.g = r0     // Catch:{ all -> 0x008d }
            goto L_0x008f
        L_0x008d:
            int r0 = com.baidu.sofire.a.a.a
        L_0x008f:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0091:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.g.a.a(java.util.List):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: java.lang.String} */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:23|24|45) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r4 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x017d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x018a, code lost:
        if (r8 != null) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0190, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0192, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x016e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x017f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d3 A[Catch:{ Exception -> 0x017f }, LOOP:0: B:17:0x00d3->B:25:0x0170, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0179 A[SYNTHETIC, Splitter:B:27:0x0179] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.baidu.sofire.h.a> a(int r22, boolean r23) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            long r3 = java.lang.System.currentTimeMillis()
            android.content.Context r5 = r1.c
            com.baidu.sofire.j.a r5 = com.baidu.sofire.j.a.a((android.content.Context) r5)
            r6 = 2
            r7 = 100
            if (r0 == r6) goto L_0x0020
            android.content.SharedPreferences r8 = r5.e
            java.lang.String r9 = "up_nu_li"
            int r7 = r8.getInt(r9, r7)
        L_0x0020:
            r8 = 0
            r9 = 3600000(0x36ee80, float:5.044674E-39)
            java.lang.String r10 = ")"
            java.lang.String r11 = "f"
            if (r23 == 0) goto L_0x0096
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "(d < ("
            r0.append(r5)
            r0.append(r3)
            java.lang.String r5 = "-"
            r0.append(r5)
            r0.append(r11)
            java.lang.String r5 = "*"
            r0.append(r5)
            r0.append(r9)
            java.lang.String r5 = ") and "
            r0.append(r5)
            r0.append(r11)
            java.lang.String r5 = "!= 0)"
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "(d<="
            r5.append(r6)
            r12 = 259200000(0xf731400, double:1.280618154E-315)
            long r3 = r3 - r12
            r5.append(r3)
            r5.append(r10)
            java.lang.String r3 = r5.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "("
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = " or "
            r4.append(r0)
            r4.append(r3)
            r4.append(r0)
            java.lang.String r0 = "(i=5)"
            r4.append(r0)
            r4.append(r10)
            java.lang.String r0 = r4.toString()
        L_0x0094:
            r15 = r0
            goto L_0x00bc
        L_0x0096:
            if (r0 != r6) goto L_0x009a
            r15 = r8
            goto L_0x00bc
        L_0x009a:
            android.content.SharedPreferences r0 = r5.e
            r5 = 3
            java.lang.String r6 = "re_net_wt"
            int r0 = r0.getInt(r6, r5)
            int r0 = r0 * r9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "(g!=2 or d<="
            r5.append(r6)
            long r12 = (long) r0
            long r3 = r3 - r12
            r5.append(r3)
            r5.append(r10)
            java.lang.String r0 = r5.toString()
            goto L_0x0094
        L_0x00bc:
            java.lang.String r19 = "d desc"
            android.database.sqlite.SQLiteDatabase r12 = r1.b     // Catch:{ Exception -> 0x017f }
            java.lang.String r13 = "r"
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            java.lang.String r20 = java.lang.Integer.toString(r7)     // Catch:{ Exception -> 0x017f }
            android.database.Cursor r8 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x017f }
            if (r8 == 0) goto L_0x0177
        L_0x00d3:
            boolean r0 = r8.moveToNext()     // Catch:{ Exception -> 0x017f }
            if (r0 == 0) goto L_0x0177
            com.baidu.sofire.h.a r0 = new com.baidu.sofire.h.a     // Catch:{ Exception -> 0x017f }
            r0.<init>()     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "a"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            int r3 = r8.getInt(r3)     // Catch:{ Exception -> 0x017f }
            r0.a = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "b"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = r8.getString(r3)     // Catch:{ Exception -> 0x017f }
            r0.c = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "c"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            int r3 = r8.getInt(r3)     // Catch:{ Exception -> 0x017f }
            r0.d = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "d"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            long r3 = r8.getLong(r3)     // Catch:{ Exception -> 0x017f }
            r0.f = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "g"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            int r3 = r8.getInt(r3)     // Catch:{ Exception -> 0x017f }
            r0.g = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "e"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            int r3 = r8.getInt(r3)     // Catch:{ Exception -> 0x017f }
            r0.h = r3     // Catch:{ Exception -> 0x017f }
            int r3 = r8.getColumnIndexOrThrow(r11)     // Catch:{ Exception -> 0x017f }
            int r3 = r8.getInt(r3)     // Catch:{ Exception -> 0x017f }
            r0.f1088i = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "i"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            int r3 = r8.getInt(r3)     // Catch:{ Exception -> 0x017f }
            r0.j = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "j"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = r8.getString(r3)     // Catch:{ Exception -> 0x017f }
            r0.k = r3     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = "h"
            int r3 = r8.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x017f }
            java.lang.String r3 = r8.getString(r3)     // Catch:{ Exception -> 0x017f }
            com.baidu.sofire.ac.F r4 = com.baidu.sofire.ac.F.getInstance()     // Catch:{ Exception -> 0x016e }
            r5 = 0
            byte[] r5 = android.util.Base64.decode(r3, r5)     // Catch:{ Exception -> 0x016e }
            java.lang.String r6 = "xVOTuxgN3lkRN2v4"
            java.lang.String r7 = "utf-8"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ Exception -> 0x016e }
            byte[] r4 = r4.ad(r5, r6)     // Catch:{ Exception -> 0x016e }
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x016e }
            r5.<init>(r4)     // Catch:{ Exception -> 0x016e }
            r3 = r5
            goto L_0x0170
        L_0x016e:
            int r4 = com.baidu.sofire.a.a.a     // Catch:{ Exception -> 0x017f }
        L_0x0170:
            r0.e = r3     // Catch:{ Exception -> 0x017f }
            r2.add(r0)     // Catch:{ Exception -> 0x017f }
            goto L_0x00d3
        L_0x0177:
            if (r8 == 0) goto L_0x0189
            r8.close()     // Catch:{ Exception -> 0x0187 }
            goto L_0x0189
        L_0x017d:
            r0 = move-exception
            goto L_0x018a
        L_0x017f:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x017d }
            if (r8 == 0) goto L_0x0189
            r8.close()     // Catch:{ Exception -> 0x0187 }
            goto L_0x0189
        L_0x0187:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0189:
            return r2
        L_0x018a:
            if (r8 == 0) goto L_0x0192
            r8.close()     // Catch:{ Exception -> 0x0190 }
            goto L_0x0192
        L_0x0190:
            int r2 = com.baidu.sofire.a.a.a
        L_0x0192:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.g.a.a(int, boolean):java.util.List");
    }
}
