package fe.fe.th.i;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import com.baidu.android.util.io.PathUtils;
import com.baidu.clientupdate.a.a;
import com.baidu.clientupdate.download.Download;
import com.baidu.sapi2.result.OpenBdussResult;
import fe.fe.aaa.ad;
import fe.fe.aaa.qw;

public class i extends SQLiteOpenHelper {

    /* renamed from: th  reason: collision with root package name */
    public static i f3099th;

    /* renamed from: ad  reason: collision with root package name */
    public Context f3100ad;

    public i(Context context) {
        super(context, "lcupdatedown.db", (SQLiteDatabase.CursorFactory) null, 3);
        this.f3100ad = context;
    }

    public static String[] nn(long[] jArr) {
        String[] strArr = new String[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            strArr[i2] = Long.toString(jArr[i2]);
        }
        return strArr;
    }

    /* renamed from: switch  reason: not valid java name */
    public static String m215switch(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 > 0) {
                sb.append("OR ");
            }
            sb.append("_id");
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    public static synchronized i yj(Context context) {
        i iVar;
        synchronized (i.class) {
            if (f3099th == null) {
                f3099th = new i(context);
            }
            iVar = f3099th;
        }
        return iVar;
    }

    public void aaa() {
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(OpenBdussResult.PARAMS_FLAG, "0");
            writableDatabase.update("logs", contentValues, (String) null, (String[]) null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            pf();
        } catch (Exception e2) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e2));
        }
    }

    public final ContentValues ddd(Download download) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", download.mFileName);
        contentValues.put("saved_path_for_user", download.mSavedPath);
        contentValues.put("uri", download.mUrl);
        contentValues.put("mimetype", download.mMimeType);
        contentValues.put("etag", download.mETag);
        contentValues.put("status", Integer.valueOf(download.mState.ordinal()));
        contentValues.put("total_bytes", Long.valueOf(download.mFileLength));
        contentValues.put("current_bytes", Long.valueOf(download.mCurrentLength));
        contentValues.put("notificationneeded", Integer.valueOf(download.mNeedNotification ? 1 : 0));
        contentValues.put("notificationshowed", Boolean.valueOf(download.mNotificationShowed));
        contentValues.put("saved_source_key_user", download.mSourceKey);
        contentValues.put("failreason", download.mFailReason);
        return contentValues;
    }

    public long de(a aVar) {
        long j = -1;
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            ContentValues xxx = xxx(aVar);
            writableDatabase.beginTransaction();
            j = writableDatabase.insert("logs", (String) null, xxx);
            ad.ad(this.f3100ad).fe("lcsdk_xml", "time", System.currentTimeMillis());
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return j;
        } catch (Exception e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            return j;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r2 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
        if (r2 != null) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean eee() {
        /*
            r12 = this;
            java.lang.String r0 = "DownloadDBHelper"
            r1 = 0
            r2 = 0
            android.content.Context r3 = r12.f3100ad     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            fe.fe.th.i.i r3 = yj(r3)     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            android.database.sqlite.SQLiteDatabase r3 = r3.getReadableDatabase()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            r3.beginTransaction()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            java.lang.String r5 = "logs"
            r6 = 0
            java.lang.String r7 = "nm=?"
            java.lang.String r4 = "a6"
            java.lang.String[] r8 = new java.lang.String[]{r4}     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r3
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            r3.setTransactionSuccessful()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            if (r2 == 0) goto L_0x0034
            int r0 = r2.getCount()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            if (r0 == 0) goto L_0x0034
            r0 = 1
            r1 = 1
        L_0x0034:
            if (r2 == 0) goto L_0x0055
        L_0x0036:
            r2.close()
            goto L_0x0055
        L_0x003a:
            r0 = move-exception
            goto L_0x0056
        L_0x003c:
            r3 = move-exception
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)     // Catch:{ all -> 0x003a }
            fe.fe.aaa.qw.ad(r0, r3)     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0055
            goto L_0x0036
        L_0x0047:
            r3 = move-exception
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)     // Catch:{ all -> 0x003a }
            fe.fe.aaa.qw.ad(r0, r3)     // Catch:{ all -> 0x003a }
            r12.pf()     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0055
            goto L_0x0036
        L_0x0055:
            return r1
        L_0x0056:
            if (r2 == 0) goto L_0x005b
            r2.close()
        L_0x005b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.i.i.eee():boolean");
    }

    public long fe(Download download) {
        long j = -1;
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            ContentValues ddd = ddd(download);
            writableDatabase.beginTransaction();
            j = writableDatabase.insert(PathUtils.DIRCTORY_DOWNLOAD, (String) null, ddd);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            download.mId = j;
            return j;
        } catch (Exception e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            return j;
        }
    }

    public void ggg(Download download) {
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.update(PathUtils.DIRCTORY_DOWNLOAD, ddd(download), "_id = ?", new String[]{Long.toString(download.mId)});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (Exception e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
        }
    }

    public void mmm() {
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put(OpenBdussResult.PARAMS_FLAG, "1");
            writableDatabase.update("logs", contentValues, (String) null, (String[]) null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            pf();
        } catch (Exception e2) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e2));
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        qw.qw("DownloadDBHelper", "populating new database");
        uk(sQLiteDatabase);
        when(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        qw.qw("DownloadDBHelper", i2 + " to " + i3 + ", which will destroy all old data");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
        onCreate(sQLiteDatabase);
    }

    public int pf() {
        int i2 = 0;
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            writableDatabase.beginTransaction();
            i2 = writableDatabase.delete("logs", (String) null, (String[]) null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i2;
        } catch (Exception e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            return i2;
        }
    }

    public void ppp(a aVar) {
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.update("logs", xxx(aVar), "nm = ?", new String[]{aVar.c});
            ad.ad(this.f3100ad).fe("lcsdk_xml", "time", System.currentTimeMillis());
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (IllegalStateException e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            pf();
        } catch (Exception e2) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e2));
        }
    }

    public Cursor qqq() {
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = yj(this.f3100ad).getReadableDatabase();
            readableDatabase.beginTransaction();
            cursor = readableDatabase.query("logs", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            readableDatabase.setTransactionSuccessful();
            readableDatabase.endTransaction();
            return cursor;
        } catch (IllegalStateException e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            if (cursor != null) {
                cursor.close();
            }
            pf();
            return cursor;
        } catch (Exception e2) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e2));
            if (cursor == null) {
                return cursor;
            }
            cursor.close();
            return cursor;
        }
    }

    public int qw(long... jArr) {
        int i2 = 0;
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            writableDatabase.beginTransaction();
            i2 = writableDatabase.delete(PathUtils.DIRCTORY_DOWNLOAD, m215switch(jArr), nn(jArr));
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i2;
        } catch (Exception e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            return i2;
        }
    }

    public Cursor rg() {
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = yj(this.f3100ad).getReadableDatabase();
            readableDatabase.beginTransaction();
            cursor = readableDatabase.query(PathUtils.DIRCTORY_DOWNLOAD, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            readableDatabase.setTransactionSuccessful();
            readableDatabase.endTransaction();
            return cursor;
        } catch (Exception e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            if (cursor == null) {
                return cursor;
            }
            cursor.close();
            return cursor;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        if (r2 == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
        if (r2 != null) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean rrr() {
        /*
            r12 = this;
            java.lang.String r0 = "DownloadDBHelper"
            r1 = 0
            r2 = 0
            android.content.Context r3 = r12.f3100ad     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            fe.fe.th.i.i r3 = yj(r3)     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            android.database.sqlite.SQLiteDatabase r3 = r3.getReadableDatabase()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            r3.beginTransaction()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            java.lang.String r5 = "logs"
            r6 = 0
            java.lang.String r7 = "nm=?"
            java.lang.String r4 = "a9"
            java.lang.String[] r8 = new java.lang.String[]{r4}     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            r9 = 0
            r10 = 0
            r11 = 0
            r4 = r3
            android.database.Cursor r2 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            r3.setTransactionSuccessful()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            r3.endTransaction()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            if (r2 == 0) goto L_0x0034
            int r0 = r2.getCount()     // Catch:{ IllegalStateException -> 0x0047, Exception -> 0x003c }
            if (r0 == 0) goto L_0x0034
            r0 = 1
            r1 = 1
        L_0x0034:
            if (r2 == 0) goto L_0x0055
        L_0x0036:
            r2.close()
            goto L_0x0055
        L_0x003a:
            r0 = move-exception
            goto L_0x0056
        L_0x003c:
            r3 = move-exception
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)     // Catch:{ all -> 0x003a }
            fe.fe.aaa.qw.ad(r0, r3)     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0055
            goto L_0x0036
        L_0x0047:
            r3 = move-exception
            java.lang.String r3 = android.util.Log.getStackTraceString(r3)     // Catch:{ all -> 0x003a }
            fe.fe.aaa.qw.ad(r0, r3)     // Catch:{ all -> 0x003a }
            r12.pf()     // Catch:{ all -> 0x003a }
            if (r2 == 0) goto L_0x0055
            goto L_0x0036
        L_0x0055:
            return r1
        L_0x0056:
            if (r2 == 0) goto L_0x005b
            r2.close()
        L_0x005b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.i.i.rrr():boolean");
    }

    public Cursor th(String str) {
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = yj(this.f3100ad).getReadableDatabase();
            readableDatabase.beginTransaction();
            cursor = readableDatabase.query("logs", (String[]) null, "nm=?", new String[]{str}, (String) null, (String) null, (String) null);
            readableDatabase.setTransactionSuccessful();
            readableDatabase.endTransaction();
            return cursor;
        } catch (IllegalStateException e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            if (cursor != null) {
                cursor.close();
            }
            pf();
            return cursor;
        } catch (Exception e2) {
            if (cursor != null) {
                cursor.close();
            }
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e2));
            return cursor;
        }
    }

    public final void uk(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, _data TEXT, saved_path_for_user TEXT, mimetype TEXT, etag TEXT, visibility INTEGER, status INTEGER, total_bytes INTEGER, current_bytes INTEGER, notificationneeded INTEGER, notificationshowed BOOLEAN NOT NULL DEFAULT 0, saved_source_key_user TEXT, failreason TEXT);");
        } catch (SQLException unused) {
            qw.ad("DownloadDBHelper", "couldn't create table in downloads database");
        }
    }

    public int vvv() {
        int i2 = 0;
        try {
            SQLiteDatabase writableDatabase = yj(this.f3100ad).getWritableDatabase();
            writableDatabase.beginTransaction();
            i2 = writableDatabase.delete("logs", "flag=?", new String[]{"1"});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return i2;
        } catch (Exception e) {
            qw.ad("DownloadDBHelper", Log.getStackTraceString(e));
            return i2;
        }
    }

    public final void when(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS logs");
            sQLiteDatabase.execSQL("CREATE TABLE logs(ug TEXT,nm TEXT, sessioninfo TEXT, stm TEXT, sc TEXT, etm TEXT, mg TEXT, ex TEXT,flag TEXT  DEFAULT '0',PRIMARY KEY(nm));");
        } catch (SQLException unused) {
            qw.ad("DownloadDBHelper", "couldn't create table in logs database");
        }
    }

    public final ContentValues xxx(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ug", aVar.b);
        contentValues.put("sessioninfo", aVar.a + "\"tm\":\"" + (System.currentTimeMillis() / 1000) + "\"}");
        contentValues.put(SearchView.IME_OPTION_NO_MICROPHONE, aVar.c);
        contentValues.put("stm", aVar.e.toString());
        contentValues.put("sc", aVar.f.toString());
        contentValues.put("etm", aVar.g.toString());
        contentValues.put("mg", aVar.h.toString());
        contentValues.put("ex", aVar.f746i.toString());
        return contentValues;
    }
}
