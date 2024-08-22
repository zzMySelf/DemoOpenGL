package com.baidu.sofire.xclient.privacycontrol.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a {
    public static a b;
    public final SQLiteDatabase a;

    /* renamed from: com.baidu.sofire.xclient.privacycontrol.d.a$a  reason: collision with other inner class name */
    public static class C0056a extends SQLiteOpenHelper {
        public C0056a(Context context) {
            super(context, "s_prv_ctl.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("create table if not exists r(a integer primary key autoincrement, b text, c long);");
            } catch (Throwable unused) {
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }

    public a(Context context) {
        this.a = new C0056a(context).getWritableDatabase();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context);
            }
            aVar = b;
        }
        return aVar;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(java.lang.String r7) {
        /*
            r6 = this;
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r7 = com.baidu.sofire.ac.PCMH.localEncrypt(r7)     // Catch:{ all -> 0x0009 }
        L_0x0009:
            java.lang.String r1 = "b"
            r0.put(r1, r7)
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r7 = java.lang.Long.valueOf(r1)
            java.lang.String r1 = "c"
            r0.put(r1, r7)
            java.lang.Class<com.baidu.sofire.xclient.privacycontrol.d.a> r7 = com.baidu.sofire.xclient.privacycontrol.d.a.class
            monitor-enter(r7)
            r1 = -1
            android.database.sqlite.SQLiteDatabase r3 = r6.a     // Catch:{ all -> 0x0029 }
            java.lang.String r4 = "r"
            r5 = 0
            long r1 = r3.insert(r4, r5, r0)     // Catch:{ all -> 0x0029 }
        L_0x0029:
            monitor-exit(r7)     // Catch:{ all -> 0x002b }
            return r1
        L_0x002b:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x002b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.d.a.a(java.lang.String):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x002c A[SYNTHETIC, Splitter:B:24:0x002c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a() {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 1
            android.database.sqlite.SQLiteDatabase r1 = r10.a     // Catch:{ all -> 0x0029 }
            java.lang.String r2 = "r"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0029 }
            if (r1 != 0) goto L_0x001a
            if (r1 == 0) goto L_0x0018
            r1.close()     // Catch:{ all -> 0x0018 }
        L_0x0018:
            monitor-exit(r10)
            return r0
        L_0x001a:
            int r2 = r1.getCount()     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            r1.close()     // Catch:{ all -> 0x0025 }
        L_0x0025:
            monitor-exit(r10)
            return r0
        L_0x0027:
            goto L_0x002a
        L_0x0029:
            r1 = 0
        L_0x002a:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ all -> 0x002f }
        L_0x002f:
            monitor-exit(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.d.a.a():boolean");
    }

    public synchronized boolean a(int i2) {
        try {
            if (this.a == null) {
                return false;
            }
            this.a.execSQL("delete from r where a IN (select a from r Limit " + i2 + ")");
            try {
                this.a.execSQL("vacuum");
            } catch (Throwable unused) {
            }
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0055, code lost:
        if (r10 == null) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.baidu.sofire.xclient.privacycontrol.e.a> b(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x005c }
            r0.<init>()     // Catch:{ all -> 0x005c }
            java.lang.String r8 = "c desc"
            r10 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.a     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "r"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r9 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0054 }
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0054 }
            if (r10 != 0) goto L_0x0023
            if (r10 == 0) goto L_0x0021
            r10.close()     // Catch:{ all -> 0x0021 }
        L_0x0021:
            monitor-exit(r11)
            return r0
        L_0x0023:
            boolean r12 = r10.moveToNext()     // Catch:{ all -> 0x0054 }
            if (r12 == 0) goto L_0x0057
            java.lang.String r12 = "b"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ all -> 0x0054 }
            java.lang.String r12 = r10.getString(r12)     // Catch:{ all -> 0x0054 }
            java.lang.String r12 = com.baidu.sofire.ac.PCMH.localDecrypt(r12)     // Catch:{ all -> 0x0037 }
        L_0x0037:
            java.lang.String r1 = "a"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ all -> 0x0054 }
            int r1 = r10.getInt(r1)     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "c"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0054 }
            long r2 = r10.getLong(r2)     // Catch:{ all -> 0x0054 }
            com.baidu.sofire.xclient.privacycontrol.e.a r4 = new com.baidu.sofire.xclient.privacycontrol.e.a     // Catch:{ all -> 0x0054 }
            r4.<init>(r1, r12, r2)     // Catch:{ all -> 0x0054 }
            r0.add(r4)     // Catch:{ all -> 0x0054 }
            goto L_0x0023
        L_0x0054:
            if (r10 == 0) goto L_0x005a
        L_0x0057:
            r10.close()     // Catch:{ all -> 0x005a }
        L_0x005a:
            monitor-exit(r11)
            return r0
        L_0x005c:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.xclient.privacycontrol.d.a.b(int):java.util.List");
    }
}
