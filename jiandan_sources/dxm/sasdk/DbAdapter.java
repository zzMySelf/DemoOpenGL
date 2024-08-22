package dxm.sasdk;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

public class DbAdapter {

    /* renamed from: fe  reason: collision with root package name */
    public static final String f7541fe = ("CREATE TABLE " + Table.EVENTS.getName() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "data" + " STRING NOT NULL, " + "created_at" + " INTEGER NOT NULL);");

    /* renamed from: rg  reason: collision with root package name */
    public static final String f7542rg;

    /* renamed from: ad  reason: collision with root package name */
    public final String f7543ad;

    /* renamed from: de  reason: collision with root package name */
    public qw f7544de = null;
    public final Context qw;

    public enum Table {
        EVENTS("events");
        
        public final String mTableName;

        /* access modifiers changed from: public */
        Table(String str) {
            this.mTableName = str;
        }

        public String getName() {
            return this.mTableName;
        }
    }

    public static class qw extends SQLiteOpenHelper {

        /* renamed from: ad  reason: collision with root package name */
        public final File f7545ad;

        public qw(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
            this.f7545ad = context.getDatabasePath(str);
        }

        public void de() {
            close();
            this.f7545ad.delete();
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            boolean booleanValue = DxmSdkSensorsDataAPI.xxx.booleanValue();
            sQLiteDatabase.execSQL(DbAdapter.f7541fe);
            sQLiteDatabase.execSQL(DbAdapter.f7542rg);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            boolean booleanValue = DxmSdkSensorsDataAPI.xxx.booleanValue();
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table.EVENTS.getName());
            sQLiteDatabase.execSQL(DbAdapter.f7541fe);
            sQLiteDatabase.execSQL(DbAdapter.f7542rg);
        }

        public boolean qw() {
            if (!this.f7545ad.exists() || Math.max(this.f7545ad.getUsableSpace(), 33554432) >= this.f7545ad.length()) {
                return true;
            }
            return false;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE INDEX IF NOT EXISTS time_idx ON ");
        sb.append(Table.EVENTS.getName());
        sb.append(" (");
        sb.append("created_at");
        sb.append(");");
        f7542rg = sb.toString();
    }

    public DbAdapter(Context context, String str) {
        this.qw = context;
        this.f7543ad = str;
        th();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        "Could not add data to table " + r10 + ". Re-initializing database.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008c, code lost:
        if (r9 != null) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        th();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0096, code lost:
        if (r3 != null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        r9 = r8.f7544de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        "Could not add data to table " + r10 + ". Re-initializing database.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b4, code lost:
        if (r9 != null) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b6, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ba, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        th();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00be, code lost:
        if (r3 != null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c3, code lost:
        r9 = r8.f7544de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c8, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c9, code lost:
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ca, code lost:
        if (r3 != null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00cc, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cf, code lost:
        r8.f7544de.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d4, code lost:
        throw r10;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0077, B:36:0x009f] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x009f */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cc A[Catch:{ all -> 0x00c8 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0077=Splitter:B:23:0x0077, B:36:0x009f=Splitter:B:36:0x009f} */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0093=Splitter:B:28:0x0093, B:41:0x00bb=Splitter:B:41:0x00bb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int de(org.json.JSONObject r9, dxm.sasdk.DbAdapter.Table r10) {
        /*
            r8 = this;
            dxm.sasdk.DbAdapter$qw r0 = r8.f7544de
            boolean r0 = r0.qw()
            r1 = 0
            if (r0 != 0) goto L_0x0020
            dxm.sasdk.DbAdapter$Table r0 = dxm.sasdk.DbAdapter.Table.EVENTS
            r2 = 100
            java.lang.String[] r0 = r8.rg(r0, r2)
            r2 = -2
            if (r0 != 0) goto L_0x0015
            return r2
        L_0x0015:
            r0 = r0[r1]
            dxm.sasdk.DbAdapter$Table r3 = dxm.sasdk.DbAdapter.Table.EVENTS
            int r0 = r8.fe(r0, r3)
            if (r0 > 0) goto L_0x0020
            return r2
        L_0x0020:
            java.lang.String r10 = r10.getName()
            r0 = -1
            dxm.sasdk.DbAdapter$qw r2 = r8.f7544de
            monitor-enter(r2)
            r3 = 0
            dxm.sasdk.DbAdapter$qw r4 = r8.f7544de     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            android.database.sqlite.SQLiteDatabase r4 = r4.getWritableDatabase()     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            r5.<init>()     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            java.lang.String r6 = "data"
            java.lang.String r9 = r9.toString()     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            r5.put(r6, r9)     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            java.lang.String r9 = "created_at"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            r5.put(r9, r6)     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            r4.insert(r10, r3, r5)     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            r9.<init>()     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            java.lang.String r5 = "SELECT COUNT(*) FROM "
            r9.append(r5)     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            r9.append(r10)     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            java.lang.String r9 = r9.toString()     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            android.database.Cursor r9 = r4.rawQuery(r9, r3)     // Catch:{ SQLiteException -> 0x009e, IllegalStateException -> 0x0076 }
            r9.moveToFirst()     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0077 }
            int r0 = r9.getInt(r1)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0077 }
            if (r9 == 0) goto L_0x006e
            r9.close()     // Catch:{ all -> 0x00d5 }
        L_0x006e:
            dxm.sasdk.DbAdapter$qw r9 = r8.f7544de     // Catch:{ all -> 0x00d5 }
        L_0x0070:
            r9.close()     // Catch:{ all -> 0x00d5 }
            goto L_0x00c6
        L_0x0074:
            r10 = move-exception
            goto L_0x00ca
        L_0x0076:
            r9 = r3
        L_0x0077:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r1.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = "Could not add data to table "
            r1.append(r4)     // Catch:{ all -> 0x00c8 }
            r1.append(r10)     // Catch:{ all -> 0x00c8 }
            java.lang.String r10 = ". Re-initializing database."
            r1.append(r10)     // Catch:{ all -> 0x00c8 }
            r1.toString()     // Catch:{ all -> 0x00c8 }
            if (r9 == 0) goto L_0x0092
            r9.close()     // Catch:{ all -> 0x00c8 }
            goto L_0x0093
        L_0x0092:
            r3 = r9
        L_0x0093:
            r8.th()     // Catch:{ all -> 0x0074 }
            if (r3 == 0) goto L_0x009b
            r3.close()     // Catch:{ all -> 0x00d5 }
        L_0x009b:
            dxm.sasdk.DbAdapter$qw r9 = r8.f7544de     // Catch:{ all -> 0x00d5 }
            goto L_0x0070
        L_0x009e:
            r9 = r3
        L_0x009f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r1.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = "Could not add data to table "
            r1.append(r4)     // Catch:{ all -> 0x00c8 }
            r1.append(r10)     // Catch:{ all -> 0x00c8 }
            java.lang.String r10 = ". Re-initializing database."
            r1.append(r10)     // Catch:{ all -> 0x00c8 }
            r1.toString()     // Catch:{ all -> 0x00c8 }
            if (r9 == 0) goto L_0x00ba
            r9.close()     // Catch:{ all -> 0x00c8 }
            goto L_0x00bb
        L_0x00ba:
            r3 = r9
        L_0x00bb:
            r8.th()     // Catch:{ all -> 0x0074 }
            if (r3 == 0) goto L_0x00c3
            r3.close()     // Catch:{ all -> 0x00d5 }
        L_0x00c3:
            dxm.sasdk.DbAdapter$qw r9 = r8.f7544de     // Catch:{ all -> 0x00d5 }
            goto L_0x0070
        L_0x00c6:
            monitor-exit(r2)     // Catch:{ all -> 0x00d5 }
            return r0
        L_0x00c8:
            r10 = move-exception
            r3 = r9
        L_0x00ca:
            if (r3 == 0) goto L_0x00cf
            r3.close()     // Catch:{ all -> 0x00d5 }
        L_0x00cf:
            dxm.sasdk.DbAdapter$qw r9 = r8.f7544de     // Catch:{ all -> 0x00d5 }
            r9.close()     // Catch:{ all -> 0x00d5 }
            throw r10     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00d5 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: dxm.sasdk.DbAdapter.de(org.json.JSONObject, dxm.sasdk.DbAdapter$Table):int");
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        "Could not clean sent records from " + r7 + ". Re-initializing database.";
        th();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (r1 != 0) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0069, code lost:
        r6 = r5.f7544de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006b, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        "Could not clean sent records from " + r7 + ". Re-initializing database.";
        th();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0087, code lost:
        if (r1 != 0) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008c, code lost:
        r6 = r5.f7544de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        r6 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0092, code lost:
        if (r1 != 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0097, code lost:
        r5.f7544de.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x004c, B:17:0x006f] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x004c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x006f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int fe(java.lang.String r6, dxm.sasdk.DbAdapter.Table r7) {
        /*
            r5 = this;
            java.lang.String r7 = r7.getName()
            dxm.sasdk.DbAdapter$qw r0 = r5.f7544de
            monitor-enter(r0)
            r1 = 0
            dxm.sasdk.DbAdapter$qw r2 = r5.f7544de     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            r3.<init>()     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            java.lang.String r4 = "_id <= "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            r3.append(r6)     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            java.lang.String r6 = r3.toString()     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            r2.delete(r7, r6, r1)     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            r6.<init>()     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            java.lang.String r3 = "SELECT COUNT(*) FROM "
            r6.append(r3)     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            r6.append(r7)     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            java.lang.String r6 = r6.toString()     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            android.database.Cursor r1 = r2.rawQuery(r6, r1)     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            r1.moveToFirst()     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            r6 = 0
            int r6 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x006f, IllegalStateException -> 0x004c }
            if (r1 == 0) goto L_0x0044
            r1.close()     // Catch:{ all -> 0x009d }
        L_0x0044:
            dxm.sasdk.DbAdapter$qw r7 = r5.f7544de     // Catch:{ all -> 0x009d }
            r7.close()     // Catch:{ all -> 0x009d }
            goto L_0x0090
        L_0x004a:
            r6 = move-exception
            goto L_0x0092
        L_0x004c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r6.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r2 = "Could not clean sent records from "
            r6.append(r2)     // Catch:{ all -> 0x004a }
            r6.append(r7)     // Catch:{ all -> 0x004a }
            java.lang.String r7 = ". Re-initializing database."
            r6.append(r7)     // Catch:{ all -> 0x004a }
            r6.toString()     // Catch:{ all -> 0x004a }
            r5.th()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ all -> 0x009d }
        L_0x0069:
            dxm.sasdk.DbAdapter$qw r6 = r5.f7544de     // Catch:{ all -> 0x009d }
        L_0x006b:
            r6.close()     // Catch:{ all -> 0x009d }
            goto L_0x008f
        L_0x006f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r6.<init>()     // Catch:{ all -> 0x004a }
            java.lang.String r2 = "Could not clean sent records from "
            r6.append(r2)     // Catch:{ all -> 0x004a }
            r6.append(r7)     // Catch:{ all -> 0x004a }
            java.lang.String r7 = ". Re-initializing database."
            r6.append(r7)     // Catch:{ all -> 0x004a }
            r6.toString()     // Catch:{ all -> 0x004a }
            r5.th()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x008c
            r1.close()     // Catch:{ all -> 0x009d }
        L_0x008c:
            dxm.sasdk.DbAdapter$qw r6 = r5.f7544de     // Catch:{ all -> 0x009d }
            goto L_0x006b
        L_0x008f:
            r6 = -1
        L_0x0090:
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            return r6
        L_0x0092:
            if (r1 == 0) goto L_0x0097
            r1.close()     // Catch:{ all -> 0x009d }
        L_0x0097:
            dxm.sasdk.DbAdapter$qw r7 = r5.f7544de     // Catch:{ all -> 0x009d }
            r7.close()     // Catch:{ all -> 0x009d }
            throw r6     // Catch:{ all -> 0x009d }
        L_0x009d:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: dxm.sasdk.DbAdapter.fe(java.lang.String, dxm.sasdk.DbAdapter$Table):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        "Could not pull records for SensorsData out of database " + r7 + ". Waiting to send.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0097, code lost:
        if (r8 != null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        r7 = r6.f7544de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        "Could not pull records for SensorsData out of database " + r7 + ". Waiting to send.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b5, code lost:
        if (r8 != null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ba, code lost:
        r7 = r6.f7544de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00bc, code lost:
        r7.close();
        r7 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d2, code lost:
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:27:0x0082, B:35:0x00a0] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a0 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d5 A[SYNTHETIC, Splitter:B:51:0x00d5] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x00a0=Splitter:B:35:0x00a0, B:27:0x0082=Splitter:B:27:0x0082} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] rg(dxm.sasdk.DbAdapter.Table r7, int r8) {
        /*
            r6 = this;
            java.lang.String r7 = r7.getName()
            dxm.sasdk.DbAdapter$qw r0 = r6.f7544de
            monitor-enter(r0)
            r1 = 0
            dxm.sasdk.DbAdapter$qw r2 = r6.f7544de     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            r3.<init>()     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            java.lang.String r4 = "SELECT * FROM "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            r3.append(r7)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            java.lang.String r4 = " ORDER BY "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            java.lang.String r4 = "created_at"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            java.lang.String r4 = " ASC LIMIT "
            r3.append(r4)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            r3.append(r8)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            java.lang.String r8 = r3.toString()     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            android.database.Cursor r8 = r2.rawQuery(r8, r1)     // Catch:{ SQLiteException -> 0x009f, IllegalStateException -> 0x0081, all -> 0x007f }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ SQLiteException -> 0x00a0, IllegalStateException -> 0x0082 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00a0, IllegalStateException -> 0x0082 }
            r3 = r1
        L_0x003f:
            boolean r4 = r8.moveToNext()     // Catch:{ SQLiteException -> 0x00a0, IllegalStateException -> 0x0082 }
            if (r4 == 0) goto L_0x0068
            boolean r4 = r8.isLast()     // Catch:{ SQLiteException -> 0x00a0, IllegalStateException -> 0x0082 }
            if (r4 == 0) goto L_0x0055
            java.lang.String r3 = "_id"
            int r3 = r8.getColumnIndex(r3)     // Catch:{ SQLiteException -> 0x00a0, IllegalStateException -> 0x0082 }
            java.lang.String r3 = r8.getString(r3)     // Catch:{ SQLiteException -> 0x00a0, IllegalStateException -> 0x0082 }
        L_0x0055:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003f }
            java.lang.String r5 = "data"
            int r5 = r8.getColumnIndex(r5)     // Catch:{ JSONException -> 0x003f }
            java.lang.String r5 = r8.getString(r5)     // Catch:{ JSONException -> 0x003f }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x003f }
            r2.put(r4)     // Catch:{ JSONException -> 0x003f }
            goto L_0x003f
        L_0x0068:
            int r4 = r2.length()     // Catch:{ SQLiteException -> 0x00a0, IllegalStateException -> 0x0082 }
            if (r4 <= 0) goto L_0x0073
            java.lang.String r7 = r2.toString()     // Catch:{ SQLiteException -> 0x00a0, IllegalStateException -> 0x0082 }
            goto L_0x0074
        L_0x0073:
            r7 = r1
        L_0x0074:
            if (r8 == 0) goto L_0x0079
            r8.close()     // Catch:{ all -> 0x00de }
        L_0x0079:
            dxm.sasdk.DbAdapter$qw r8 = r6.f7544de     // Catch:{ all -> 0x00de }
            r8.close()     // Catch:{ all -> 0x00de }
            goto L_0x00c1
        L_0x007f:
            r7 = move-exception
            goto L_0x00d3
        L_0x0081:
            r8 = r1
        L_0x0082:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
            r2.<init>()     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "Could not pull records for SensorsData out of database "
            r2.append(r3)     // Catch:{ all -> 0x00d1 }
            r2.append(r7)     // Catch:{ all -> 0x00d1 }
            java.lang.String r7 = ". Waiting to send."
            r2.append(r7)     // Catch:{ all -> 0x00d1 }
            r2.toString()     // Catch:{ all -> 0x00d1 }
            if (r8 == 0) goto L_0x009c
            r8.close()     // Catch:{ all -> 0x00de }
        L_0x009c:
            dxm.sasdk.DbAdapter$qw r7 = r6.f7544de     // Catch:{ all -> 0x00de }
            goto L_0x00bc
        L_0x009f:
            r8 = r1
        L_0x00a0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
            r2.<init>()     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "Could not pull records for SensorsData out of database "
            r2.append(r3)     // Catch:{ all -> 0x00d1 }
            r2.append(r7)     // Catch:{ all -> 0x00d1 }
            java.lang.String r7 = ". Waiting to send."
            r2.append(r7)     // Catch:{ all -> 0x00d1 }
            r2.toString()     // Catch:{ all -> 0x00d1 }
            if (r8 == 0) goto L_0x00ba
            r8.close()     // Catch:{ all -> 0x00de }
        L_0x00ba:
            dxm.sasdk.DbAdapter$qw r7 = r6.f7544de     // Catch:{ all -> 0x00de }
        L_0x00bc:
            r7.close()     // Catch:{ all -> 0x00de }
            r7 = r1
            r3 = r7
        L_0x00c1:
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            if (r3 == 0) goto L_0x00d0
            if (r7 == 0) goto L_0x00d0
            r8 = 2
            java.lang.String[] r8 = new java.lang.String[r8]
            r0 = 0
            r8[r0] = r3
            r0 = 1
            r8[r0] = r7
            return r8
        L_0x00d0:
            return r1
        L_0x00d1:
            r7 = move-exception
            r1 = r8
        L_0x00d3:
            if (r1 == 0) goto L_0x00d8
            r1.close()     // Catch:{ all -> 0x00de }
        L_0x00d8:
            dxm.sasdk.DbAdapter$qw r8 = r6.f7544de     // Catch:{ all -> 0x00de }
            r8.close()     // Catch:{ all -> 0x00de }
            throw r7     // Catch:{ all -> 0x00de }
        L_0x00de:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00de }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dxm.sasdk.DbAdapter.rg(dxm.sasdk.DbAdapter$Table, int):java.lang.String[]");
    }

    public void th() {
        qw qwVar = this.f7544de;
        if (qwVar != null) {
            qwVar.de();
        }
        this.f7544de = new qw(this.qw, this.f7543ad);
    }
}
