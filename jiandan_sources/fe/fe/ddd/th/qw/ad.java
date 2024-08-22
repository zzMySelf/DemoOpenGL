package fe.fe.ddd.th.qw;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static ad f1665ad;
    public SQLiteDatabase qw = de.qw();

    public static synchronized ad ad() {
        ad adVar;
        synchronized (ad.class) {
            if (f1665ad == null) {
                f1665ad = new ad();
            }
            adVar = f1665ad;
        }
        return adVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0087, code lost:
        if (r1 == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0089, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x008c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x007e, code lost:
        if (r1 != null) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<fe.fe.ddd.th.qw.qw> de(java.lang.String r11, int r12) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.qw     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r3 = "cloudcommand"
            r4 = 0
            java.lang.String r5 = "msgId =? and dispatched =?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLException -> 0x0083 }
            r7 = 0
            r6[r7] = r11     // Catch:{ SQLException -> 0x0083 }
            r11 = 1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0083 }
            r7.<init>()     // Catch:{ SQLException -> 0x0083 }
            r7.append(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = ""
            r7.append(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = r7.toString()     // Catch:{ SQLException -> 0x0083 }
            r6[r11] = r12     // Catch:{ SQLException -> 0x0083 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLException -> 0x0083 }
        L_0x002e:
            boolean r11 = r1.moveToNext()     // Catch:{ SQLException -> 0x0083 }
            if (r11 == 0) goto L_0x007e
            fe.fe.ddd.th.qw.qw r11 = new fe.fe.ddd.th.qw.qw     // Catch:{ SQLException -> 0x0083 }
            r11.<init>()     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = "type"
            int r12 = r1.getColumnIndex(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = r1.getString(r12)     // Catch:{ SQLException -> 0x0083 }
            r11.fe(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = "msgId"
            int r12 = r1.getColumnIndex(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = r1.getString(r12)     // Catch:{ SQLException -> 0x0083 }
            r11.ad(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = "dispatched"
            int r12 = r1.getColumnIndex(r12)     // Catch:{ SQLException -> 0x0083 }
            int r12 = r1.getInt(r12)     // Catch:{ SQLException -> 0x0083 }
            r11.qw(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = "version"
            int r12 = r1.getColumnIndex(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = r1.getString(r12)     // Catch:{ SQLException -> 0x0083 }
            r11.rg(r12)     // Catch:{ SQLException -> 0x0083 }
            java.lang.String r12 = "timestamp"
            int r12 = r1.getColumnIndex(r12)     // Catch:{ SQLException -> 0x0083 }
            long r2 = r1.getLong(r12)     // Catch:{ SQLException -> 0x0083 }
            r11.de(r2)     // Catch:{ SQLException -> 0x0083 }
            r0.add(r11)     // Catch:{ SQLException -> 0x0083 }
            goto L_0x002e
        L_0x007e:
            if (r1 == 0) goto L_0x008c
            goto L_0x0089
        L_0x0081:
            r11 = move-exception
            goto L_0x008d
        L_0x0083:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x008c
        L_0x0089:
            r1.close()
        L_0x008c:
            return r0
        L_0x008d:
            if (r1 == 0) goto L_0x0092
            r1.close()
        L_0x0092:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.th.qw.ad.de(java.lang.String, int):java.util.List");
    }

    public boolean qw(String str, String str2, int i2, String str3, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", str);
        contentValues.put("msgId", str2);
        contentValues.put("dispatched", Integer.valueOf(i2));
        contentValues.put("version", str3);
        contentValues.put("timestamp", Long.valueOf(j));
        return this.qw.insert("cloudcommand", (String) null, contentValues) != -1;
    }
}
