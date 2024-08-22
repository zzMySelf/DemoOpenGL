package com.baidu.sofire.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.sofire.b.j;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.l.c;
import com.baidu.sofire.l.g;
import com.dlife.ctaccountapi.l;
import com.dlife.ctaccountapi.v;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import fe.mmm.qw.tt.th.th;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"Range"})
public class a {
    public static a d;
    public C0050a a;
    public SQLiteDatabase b;
    public Context c;

    /* renamed from: com.baidu.sofire.c.a$a  reason: collision with other inner class name */
    public class C0050a extends SQLiteOpenHelper {
        public C0050a(Context context) {
            super(context, "tpgcc.db", (SQLiteDatabase.CursorFactory) null, a.this.getClass());
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a.this.getClass();
                sQLiteDatabase.execSQL("create table pgn(k INTEGER PRIMARY KEY ON CONFLICT ABORT,p TEXT UNIQUE ON CONFLICT ABORT,v TEXT,n INTEGER,s INTEGER,i INTEGER,u INTEGER,la INTEGER,o INTEGER,r INTEGER,ap INTEGER,apk TEXT,cl TEXT,b TEXT,t TEXT,ac BLOB,st INTEGER,du INTEGER,th INTEGER,m5 TEXT,rs INTEGER,l TEXT,pr INTEGER DEFAULT -1,pdld INTEGER DEFAULT 0,pe TEXT,a TEXT)");
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0027 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x003a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onUpgrade(android.database.sqlite.SQLiteDatabase r2, int r3, int r4) {
            /*
                r1 = this;
                r0 = 3
                if (r3 >= r0) goto L_0x001c
                if (r4 < r0) goto L_0x001c
                r2.beginTransaction()     // Catch:{ all -> 0x0061 }
                java.lang.String r0 = "ALTER TABLE pgn ADD COLUMN pr INTEGER  DEFAULT -1"
                r2.execSQL(r0)     // Catch:{ all -> 0x0011 }
                r2.setTransactionSuccessful()     // Catch:{ all -> 0x0011 }
                goto L_0x0013
            L_0x0011:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0017 }
            L_0x0013:
                r2.endTransaction()     // Catch:{ all -> 0x0061 }
                goto L_0x001c
            L_0x0017:
                r3 = move-exception
                r2.endTransaction()     // Catch:{ all -> 0x0061 }
                throw r3     // Catch:{ all -> 0x0061 }
            L_0x001c:
                r0 = 4
                if (r3 >= r0) goto L_0x0029
                if (r4 < r0) goto L_0x0029
                java.lang.String r0 = "drop table if exists tbch"
                r2.execSQL(r0)     // Catch:{ all -> 0x0027 }
                goto L_0x0029
            L_0x0027:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0061 }
            L_0x0029:
                r0 = 5
                if (r3 >= r0) goto L_0x0045
                if (r4 < r0) goto L_0x0045
                r2.beginTransaction()     // Catch:{ all -> 0x0061 }
                java.lang.String r0 = "ALTER TABLE pgn ADD COLUMN pdld INTEGER  DEFAULT -1"
                r2.execSQL(r0)     // Catch:{ all -> 0x003a }
                r2.setTransactionSuccessful()     // Catch:{ all -> 0x003a }
                goto L_0x003c
            L_0x003a:
                int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0040 }
            L_0x003c:
                r2.endTransaction()     // Catch:{ all -> 0x0061 }
                goto L_0x0045
            L_0x0040:
                r3 = move-exception
                r2.endTransaction()     // Catch:{ all -> 0x0061 }
                throw r3     // Catch:{ all -> 0x0061 }
            L_0x0045:
                r0 = 6
                if (r3 >= r0) goto L_0x0063
                if (r4 < r0) goto L_0x0063
                r2.beginTransaction()     // Catch:{ all -> 0x0061 }
                java.lang.String r3 = "ALTER TABLE pgn ADD COLUMN pe TEXT"
                r2.execSQL(r3)     // Catch:{ all -> 0x0056 }
                r2.setTransactionSuccessful()     // Catch:{ all -> 0x0056 }
                goto L_0x0058
            L_0x0056:
                int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x005c }
            L_0x0058:
                r2.endTransaction()     // Catch:{ all -> 0x0061 }
                goto L_0x0063
            L_0x005c:
                r3 = move-exception
                r2.endTransaction()     // Catch:{ all -> 0x0061 }
                throw r3     // Catch:{ all -> 0x0061 }
            L_0x0061:
                int r2 = com.baidu.sofire.a.a.a
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.C0050a.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
        }
    }

    public a(Context context) {
        this.c = context.getApplicationContext();
        C0050a aVar = new C0050a(context.getApplicationContext());
        this.a = aVar;
        try {
            this.b = aVar.getWritableDatabase();
        } catch (Throwable th2) {
            c.a(th2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ee, code lost:
        if (r1 != null) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00f4, code lost:
        if (r1.isClosed() == false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00f6, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00fd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00fe, code lost:
        if (r1 != null) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0104, code lost:
        if (r1.isClosed() == false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0106, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x010a, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00ec */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.baidu.sofire.core.ApkInfo> b() {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.b     // Catch:{ all -> 0x00eb }
            java.lang.String r2 = "pgn"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00eb }
            if (r1 == 0) goto L_0x00df
        L_0x0015:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x00ec }
            if (r2 == 0) goto L_0x00df
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x00ec }
            r2.<init>()     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "k"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x00ec }
            r2.key = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "n"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x00ec }
            r2.initStatus = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00ec }
            r2.packageName = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "a"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00ec }
            r2.pkgPath = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "l"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00ec }
            r2.libPath = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "v"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00ec }
            r2.versionName = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "apk"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00ec }
            r2.dexPath = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "ap"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x00ec }
            r2.apkParseSuc = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "cl"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00ec }
            r2.className = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "th"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x00ec }
            r2.applicationTheme = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "st"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            long r3 = r1.getLong(r3)     // Catch:{ all -> 0x00ec }
            r2.startTime = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "du"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x00ec }
            r2.duration = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "m5"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00ec }
            r2.apkMD5 = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "pr"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            int r3 = r1.getInt(r3)     // Catch:{ all -> 0x00ec }
            r2.priority = r3     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = "pe"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x00ec }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x00ec }
            r4 = 24
            java.lang.String r3 = com.baidu.sofire.l.g.a(r3, r4)     // Catch:{ all -> 0x00ec }
            r2.es = r3     // Catch:{ all -> 0x00ec }
            r0.add(r2)     // Catch:{ all -> 0x00ec }
            goto L_0x0015
        L_0x00df:
            if (r1 == 0) goto L_0x00fc
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x00fa }
            if (r2 != 0) goto L_0x00fc
            r1.close()     // Catch:{ all -> 0x00fa }
            goto L_0x00fc
        L_0x00eb:
            r1 = 0
        L_0x00ec:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00fd }
            if (r1 == 0) goto L_0x00fc
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x00fa }
            if (r2 != 0) goto L_0x00fc
            r1.close()     // Catch:{ all -> 0x00fa }
            goto L_0x00fc
        L_0x00fa:
            int r1 = com.baidu.sofire.a.a.a
        L_0x00fc:
            return r0
        L_0x00fd:
            r0 = move-exception
            if (r1 == 0) goto L_0x010c
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x010a }
            if (r2 != 0) goto L_0x010c
            r1.close()     // Catch:{ all -> 0x010a }
            goto L_0x010c
        L_0x010a:
            int r1 = com.baidu.sofire.a.a.a
        L_0x010c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.b():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005b, code lost:
        if (r2 != null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (r2.isClosed() == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0063, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        if (r2 != null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0071, code lost:
        if (r2.isClosed() == false) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0059 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Integer, java.lang.String> c() {
        /*
            r10 = this;
            java.lang.String r0 = "'"
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r10.b     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = "pgn"
            r4 = 0
            java.lang.String r5 = "n=1"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x004c
        L_0x0018:
            boolean r3 = r2.moveToNext()     // Catch:{ all -> 0x0059 }
            if (r3 == 0) goto L_0x004c
            java.lang.String r3 = "k"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x0059 }
            int r3 = r2.getInt(r3)     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = "v"
            int r4 = r2.getColumnIndex(r4)     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x0059 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0059 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r5.<init>()     // Catch:{ all -> 0x0059 }
            r5.append(r0)     // Catch:{ all -> 0x0059 }
            r5.append(r4)     // Catch:{ all -> 0x0059 }
            r5.append(r0)     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0059 }
            r1.put(r3, r4)     // Catch:{ all -> 0x0059 }
            goto L_0x0018
        L_0x004c:
            if (r2 == 0) goto L_0x0069
            boolean r0 = r2.isClosed()     // Catch:{ all -> 0x0067 }
            if (r0 != 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x0067 }
            goto L_0x0069
        L_0x0058:
            r2 = 0
        L_0x0059:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0069
            boolean r0 = r2.isClosed()     // Catch:{ all -> 0x0067 }
            if (r0 != 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x0067 }
            goto L_0x0069
        L_0x0067:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0069:
            return r1
        L_0x006a:
            r0 = move-exception
            if (r2 == 0) goto L_0x0079
            boolean r1 = r2.isClosed()     // Catch:{ all -> 0x0077 }
            if (r1 != 0) goto L_0x0079
            r2.close()     // Catch:{ all -> 0x0077 }
            goto L_0x0079
        L_0x0077:
            int r1 = com.baidu.sofire.a.a.a
        L_0x0079:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.c():java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        if (r1 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        if (r1.isClosed() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0057, code lost:
        if (r1 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r1.isClosed() == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005f, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Integer, java.lang.String> d() {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r9.b     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = "pgn"
            r3 = 0
            java.lang.String r4 = "n=1"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0038
        L_0x0016:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0038
            java.lang.String r2 = "k"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ all -> 0x0045 }
            int r2 = r1.getInt(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "p"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ all -> 0x0045 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0045 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0045 }
            goto L_0x0016
        L_0x0038:
            if (r1 == 0) goto L_0x0055
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x0053 }
            if (r2 != 0) goto L_0x0055
            r1.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0055
        L_0x0044:
            r1 = 0
        L_0x0045:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0055
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x0053 }
            if (r2 != 0) goto L_0x0055
            r1.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0055
        L_0x0053:
            int r1 = com.baidu.sofire.a.a.a
        L_0x0055:
            return r0
        L_0x0056:
            r0 = move-exception
            if (r1 == 0) goto L_0x0065
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x0063 }
            if (r2 != 0) goto L_0x0065
            r1.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0065
        L_0x0063:
            int r1 = com.baidu.sofire.a.a.a
        L_0x0065:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.d():java.util.Map");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r11 != null) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004d, code lost:
        if (r11.isClosed() == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004f, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0057, code lost:
        if (r11 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x005d, code lost:
        if (r11.isClosed() == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005f, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
        r11 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0045 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "s"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.b     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = "pgn"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0044 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r5.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r6 = "k="
            r5.append(r6)     // Catch:{ all -> 0x0044 }
            r5.append(r11)     // Catch:{ all -> 0x0044 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0044 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0044 }
            r2 = 1
            if (r11 == 0) goto L_0x0038
            boolean r3 = r11.moveToFirst()     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0038
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0045 }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x0045 }
            if (r0 != r2) goto L_0x0038
            r1 = 1
        L_0x0038:
            if (r11 == 0) goto L_0x0055
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x0055
            r11.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0055
        L_0x0044:
            r11 = 0
        L_0x0045:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0056 }
            if (r11 == 0) goto L_0x0055
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x0055
            r11.close()     // Catch:{ all -> 0x0053 }
            goto L_0x0055
        L_0x0053:
            int r11 = com.baidu.sofire.a.a.a
        L_0x0055:
            return r1
        L_0x0056:
            r0 = move-exception
            if (r11 == 0) goto L_0x0065
            boolean r1 = r11.isClosed()     // Catch:{ all -> 0x0063 }
            if (r1 != 0) goto L_0x0065
            r11.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0065
        L_0x0063:
            int r11 = com.baidu.sofire.a.a.a
        L_0x0065:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.e(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        if (r10 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r10.isClosed() == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r10 != null) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0052, code lost:
        if (r10.isClosed() == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0058, code lost:
        r10 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(int r10) {
        /*
            r9 = this;
            java.lang.String r1 = "pgn"
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r9.b     // Catch:{ all -> 0x0039 }
            java.lang.String r2 = "p"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ all -> 0x0039 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
            r3.<init>()     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "k="
            r3.append(r4)     // Catch:{ all -> 0x0039 }
            r3.append(r10)     // Catch:{ all -> 0x0039 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0039 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0039 }
            if (r10 == 0) goto L_0x002d
            int r0 = r10.getCount()     // Catch:{ all -> 0x003a }
            if (r0 <= 0) goto L_0x002d
            r8 = 1
        L_0x002d:
            if (r10 == 0) goto L_0x004a
            boolean r0 = r10.isClosed()     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x004a
            r10.close()     // Catch:{ all -> 0x0048 }
            goto L_0x004a
        L_0x0039:
            r10 = 0
        L_0x003a:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x004b }
            if (r10 == 0) goto L_0x004a
            boolean r0 = r10.isClosed()     // Catch:{ all -> 0x0048 }
            if (r0 != 0) goto L_0x004a
            r10.close()     // Catch:{ all -> 0x0048 }
            goto L_0x004a
        L_0x0048:
            int r10 = com.baidu.sofire.a.a.a
        L_0x004a:
            return r8
        L_0x004b:
            r0 = move-exception
            if (r10 == 0) goto L_0x005a
            boolean r1 = r10.isClosed()     // Catch:{ all -> 0x0058 }
            if (r1 != 0) goto L_0x005a
            r10.close()     // Catch:{ all -> 0x0058 }
            goto L_0x005a
        L_0x0058:
            int r10 = com.baidu.sofire.a.a.a
        L_0x005a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.f(int):boolean");
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

    public long a(ApkInfo apkInfo) {
        if (apkInfo == null) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, Integer.valueOf(apkInfo.initStatus));
        contentValues.put("p", apkInfo.packageName);
        contentValues.put("a", apkInfo.pkgPath);
        contentValues.put(l.a, apkInfo.libPath);
        contentValues.put(v.d, apkInfo.versionName);
        contentValues.put("apk", apkInfo.dexPath);
        contentValues.put("ap", Integer.valueOf(apkInfo.apkParseSuc));
        contentValues.put("cl", apkInfo.className);
        contentValues.put("st", Long.valueOf(apkInfo.startTime));
        contentValues.put("du", Integer.valueOf(apkInfo.duration));
        contentValues.put("m5", apkInfo.apkMD5);
        contentValues.put(th.f8525rg, Integer.valueOf(apkInfo.applicationTheme));
        contentValues.put("pr", Integer.valueOf(apkInfo.priority));
        contentValues.put("pe", g.b(apkInfo.es, 24));
        if (f(apkInfo.key)) {
            try {
                SQLiteDatabase sQLiteDatabase = this.b;
                return (long) sQLiteDatabase.update("pgn", contentValues, "k=" + apkInfo.key, (String[]) null);
            } catch (Throwable unused) {
                return 0;
            }
        } else {
            contentValues.put("k", Integer.valueOf(apkInfo.key));
            return this.b.insert("pgn", (String) null, contentValues);
        }
    }

    public void c(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, Integer.valueOf(i3));
            SQLiteDatabase sQLiteDatabase = this.b;
            sQLiteDatabase.update("pgn", contentValues, "k=" + i2, (String[]) null);
        } catch (Throwable unused) {
            int i4 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r11 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r11.isClosed() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r11 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005a, code lost:
        if (r11.isClosed() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005c, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
        r11 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int d(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "n"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.b     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "pgn"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0041 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r5.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r6 = "k="
            r5.append(r6)     // Catch:{ all -> 0x0041 }
            r5.append(r11)     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0041 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0041 }
            if (r11 == 0) goto L_0x0035
            boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x0035
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0042 }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x0042 }
            r1 = r0
        L_0x0035:
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0052
            r11.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0052
        L_0x0041:
            r11 = 0
        L_0x0042:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0053 }
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0052
            r11.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0052
        L_0x0050:
            int r11 = com.baidu.sofire.a.a.a
        L_0x0052:
            return r1
        L_0x0053:
            r0 = move-exception
            if (r11 == 0) goto L_0x0062
            boolean r1 = r11.isClosed()     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0062
            r11.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0062
        L_0x0060:
            int r11 = com.baidu.sofire.a.a.a
        L_0x0062:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.d(int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r11 != null) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r11.isClosed() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004c, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0054, code lost:
        if (r11 != null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005a, code lost:
        if (r11.isClosed() == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005c, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
        r11 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c(int r11) {
        /*
            r10 = this;
            java.lang.String r0 = "pdld"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.b     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "pgn"
            java.lang.String[] r4 = new java.lang.String[]{r0}     // Catch:{ all -> 0x0041 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            r5.<init>()     // Catch:{ all -> 0x0041 }
            java.lang.String r6 = "k="
            r5.append(r6)     // Catch:{ all -> 0x0041 }
            r5.append(r11)     // Catch:{ all -> 0x0041 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0041 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0041 }
            if (r11 == 0) goto L_0x0035
            boolean r2 = r11.moveToFirst()     // Catch:{ all -> 0x0042 }
            if (r2 == 0) goto L_0x0035
            int r0 = r11.getColumnIndex(r0)     // Catch:{ all -> 0x0042 }
            int r0 = r11.getInt(r0)     // Catch:{ all -> 0x0042 }
            r1 = r0
        L_0x0035:
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0052
            r11.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0052
        L_0x0041:
            r11 = 0
        L_0x0042:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0053 }
            if (r11 == 0) goto L_0x0052
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0052
            r11.close()     // Catch:{ all -> 0x0050 }
            goto L_0x0052
        L_0x0050:
            int r11 = com.baidu.sofire.a.a.a
        L_0x0052:
            return r1
        L_0x0053:
            r0 = move-exception
            if (r11 == 0) goto L_0x0062
            boolean r1 = r11.isClosed()     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0062
            r11.close()     // Catch:{ all -> 0x0060 }
            goto L_0x0062
        L_0x0060:
            int r11 = com.baidu.sofire.a.a.a
        L_0x0062:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.c(int):int");
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.b.delete("pgn", "p=?", new String[]{str});
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
    }

    public void a() {
        List<Integer> list;
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((ArrayList) b()).iterator();
            while (it.hasNext()) {
                ApkInfo apkInfo = (ApkInfo) it.next();
                if (!c.f(apkInfo.pkgPath) && (list = j.j) != null && !list.contains(Integer.valueOf(apkInfo.key))) {
                    arrayList.add(apkInfo);
                }
            }
            j jVar = j.g;
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ApkInfo apkInfo2 = (ApkInfo) it2.next();
                if (jVar != null) {
                    jVar.d(apkInfo2.packageName);
                }
                File parentFile = new File(apkInfo2.pkgPath).getParentFile();
                if (parentFile.exists()) {
                    c.e(parentFile.getAbsolutePath());
                }
                SQLiteDatabase sQLiteDatabase = this.b;
                sQLiteDatabase.delete("pgn", "k=" + apkInfo2.key, (String[]) null);
                String canonicalPath = new File(c.f(this.c), "sofire_tmp").getCanonicalPath();
                c.e(canonicalPath + "/." + apkInfo2.key);
                Context context = this.c;
                if (context != null) {
                    c.e(context.getFileStreamPath(apkInfo2.packageName).getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f5, code lost:
        if (r1.isClosed() == false) goto L_0x00f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f7, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00ed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f1 A[SYNTHETIC, Splitter:B:26:0x00f1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.sofire.core.ApkInfo b(int r10) {
        /*
            r9 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.b     // Catch:{ all -> 0x00ec }
            java.lang.String r2 = "pgn"
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ec }
            r4.<init>()     // Catch:{ all -> 0x00ec }
            java.lang.String r5 = "k="
            r4.append(r5)     // Catch:{ all -> 0x00ec }
            r4.append(r10)     // Catch:{ all -> 0x00ec }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00ec }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ec }
            if (r1 == 0) goto L_0x00e0
            boolean r2 = r1.moveToFirst()     // Catch:{ all -> 0x00ed }
            if (r2 == 0) goto L_0x00e0
            com.baidu.sofire.core.ApkInfo r2 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x00ed }
            r2.<init>()     // Catch:{ all -> 0x00ed }
            r2.key = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "n"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x00de }
            r2.initStatus = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "p"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x00de }
            r2.packageName = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "a"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x00de }
            r2.pkgPath = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "l"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x00de }
            r2.libPath = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "v"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x00de }
            r2.versionName = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "apk"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x00de }
            r2.dexPath = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "ap"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x00de }
            r2.apkParseSuc = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "cl"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x00de }
            r2.className = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "th"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x00de }
            r2.applicationTheme = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "st"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            long r3 = r1.getLong(r10)     // Catch:{ all -> 0x00de }
            r2.startTime = r3     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "du"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x00de }
            r2.duration = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "m5"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x00de }
            r2.apkMD5 = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "pr"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            int r10 = r1.getInt(r10)     // Catch:{ all -> 0x00de }
            r2.priority = r10     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "pe"
            int r10 = r1.getColumnIndex(r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = r1.getString(r10)     // Catch:{ all -> 0x00de }
            r0 = 24
            java.lang.String r10 = com.baidu.sofire.l.g.a(r10, r0)     // Catch:{ all -> 0x00de }
            r2.es = r10     // Catch:{ all -> 0x00de }
            r0 = r2
            goto L_0x00e0
        L_0x00de:
            r0 = r2
            goto L_0x00ed
        L_0x00e0:
            if (r1 == 0) goto L_0x00fd
            boolean r10 = r1.isClosed()     // Catch:{ all -> 0x00fb }
            if (r10 != 0) goto L_0x00fd
            r1.close()     // Catch:{ all -> 0x00fb }
            goto L_0x00fd
        L_0x00ec:
            r1 = r0
        L_0x00ed:
            int r10 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x00fe }
            if (r1 == 0) goto L_0x00fd
            boolean r10 = r1.isClosed()     // Catch:{ all -> 0x00fb }
            if (r10 != 0) goto L_0x00fd
            r1.close()     // Catch:{ all -> 0x00fb }
            goto L_0x00fd
        L_0x00fb:
            int r10 = com.baidu.sofire.a.a.a
        L_0x00fd:
            return r0
        L_0x00fe:
            r10 = move-exception
            if (r1 == 0) goto L_0x010d
            boolean r0 = r1.isClosed()     // Catch:{ all -> 0x010b }
            if (r0 != 0) goto L_0x010d
            r1.close()     // Catch:{ all -> 0x010b }
            goto L_0x010d
        L_0x010b:
            int r0 = com.baidu.sofire.a.a.a
        L_0x010d:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.b(int):com.baidu.sofire.core.ApkInfo");
    }

    public void d(int i2, int i3) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("pr", Integer.valueOf(i3));
            SQLiteDatabase sQLiteDatabase = this.b;
            sQLiteDatabase.update("pgn", contentValues, "k=" + i2, (String[]) null);
        } catch (Throwable unused) {
            int i4 = com.baidu.sofire.a.a.a;
        }
    }

    public void a(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("s", Integer.valueOf(i3));
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            sQLiteDatabase.update("pgn", contentValues, "k=" + i2 + " and " + GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION + "=1", (String[]) null);
        } catch (Throwable unused) {
            int i4 = com.baidu.sofire.a.a.a;
        }
    }

    public void a(int i2) {
        if (i2 > 0) {
            try {
                SQLiteDatabase sQLiteDatabase = this.b;
                sQLiteDatabase.delete("pgn", "k=" + i2, (String[]) null);
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.a.a;
            }
        }
    }

    public void b(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("pdld", Integer.valueOf(i3));
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            sQLiteDatabase.update("pgn", contentValues, "k=" + i2, (String[]) null);
        } catch (Throwable unused) {
            int i4 = com.baidu.sofire.a.a.a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00fc, code lost:
        if (r11.isClosed() == false) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fe, code lost:
        r11.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00f4 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f8 A[SYNTHETIC, Splitter:B:29:0x00f8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.sofire.core.ApkInfo b(java.lang.String r11) {
        /*
            r10 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.database.sqlite.SQLiteDatabase r2 = r10.b     // Catch:{ all -> 0x00f3 }
            java.lang.String r3 = "pgn"
            r4 = 0
            java.lang.String r5 = "p=?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ all -> 0x00f3 }
            r0 = 0
            r6[r0] = r11     // Catch:{ all -> 0x00f3 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00f3 }
            if (r11 == 0) goto L_0x00e7
            boolean r0 = r11.moveToFirst()     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x00e7
            com.baidu.sofire.core.ApkInfo r0 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x00f4 }
            r0.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.String r1 = "k"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x00e5 }
            r0.key = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "n"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x00e5 }
            r0.initStatus = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "p"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x00e5 }
            r0.packageName = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "a"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x00e5 }
            r0.pkgPath = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "l"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x00e5 }
            r0.libPath = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "v"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x00e5 }
            r0.versionName = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "apk"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x00e5 }
            r0.dexPath = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "ap"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x00e5 }
            r0.apkParseSuc = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "cl"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x00e5 }
            r0.className = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "th"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x00e5 }
            r0.applicationTheme = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "st"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            long r1 = r11.getLong(r1)     // Catch:{ all -> 0x00e5 }
            r0.startTime = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "du"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x00e5 }
            r0.duration = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "m5"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x00e5 }
            r0.apkMD5 = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "pr"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            int r1 = r11.getInt(r1)     // Catch:{ all -> 0x00e5 }
            r0.priority = r1     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = "pe"
            int r1 = r11.getColumnIndex(r1)     // Catch:{ all -> 0x00e5 }
            java.lang.String r1 = r11.getString(r1)     // Catch:{ all -> 0x00e5 }
            r2 = 24
            java.lang.String r1 = com.baidu.sofire.l.g.a(r1, r2)     // Catch:{ all -> 0x00e5 }
            r0.es = r1     // Catch:{ all -> 0x00e5 }
            r1 = r0
            goto L_0x00e7
        L_0x00e5:
            r1 = r0
            goto L_0x00f4
        L_0x00e7:
            if (r11 == 0) goto L_0x0104
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0102 }
            if (r0 != 0) goto L_0x0104
            r11.close()     // Catch:{ all -> 0x0102 }
            goto L_0x0104
        L_0x00f3:
            r11 = r1
        L_0x00f4:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0105 }
            if (r11 == 0) goto L_0x0104
            boolean r0 = r11.isClosed()     // Catch:{ all -> 0x0102 }
            if (r0 != 0) goto L_0x0104
            r11.close()     // Catch:{ all -> 0x0102 }
            goto L_0x0104
        L_0x0102:
            int r11 = com.baidu.sofire.a.a.a
        L_0x0104:
            return r1
        L_0x0105:
            r0 = move-exception
            if (r11 == 0) goto L_0x0114
            boolean r1 = r11.isClosed()     // Catch:{ all -> 0x0112 }
            if (r1 != 0) goto L_0x0114
            r11.close()     // Catch:{ all -> 0x0112 }
            goto L_0x0114
        L_0x0112:
            int r11 = com.baidu.sofire.a.a.a
        L_0x0114:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.c.a.b(java.lang.String):com.baidu.sofire.core.ApkInfo");
    }
}
