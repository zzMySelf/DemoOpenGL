package fe.fe.mmm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.ubc.bypass.BypassConstants$Funnel;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import fe.fe.mmm.u.qw;
import fe.fe.mmm.u.yj;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class eee extends SQLiteOpenHelper {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f2015i = tt.vvv();

    /* renamed from: if  reason: not valid java name */
    public static ReentrantLock f49if = new ReentrantLock();

    /* renamed from: o  reason: collision with root package name */
    public static final String f2016o = (tt.i() + "bdbehavior.db");

    /* renamed from: pf  reason: collision with root package name */
    public static eee f2017pf = null;

    /* renamed from: ad  reason: collision with root package name */
    public fe f2018ad;

    /* renamed from: th  reason: collision with root package name */
    public Context f2019th;

    /* renamed from: uk  reason: collision with root package name */
    public ReentrantReadWriteLock f2020uk = new ReentrantReadWriteLock(true);

    /* renamed from: yj  reason: collision with root package name */
    public String f2021yj;

    public eee(Context context) {
        super(context, f2016o, (SQLiteDatabase.CursorFactory) null, 14);
        this.f2018ad = new fe(context);
        this.f2019th = context;
    }

    public static eee D(Context context) {
        if (f2017pf == null) {
            f49if.lock();
            if (f2017pf == null) {
                f2017pf = new eee(context);
            }
            f49if.unlock();
        }
        return f2017pf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x0181 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0137 A[Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0148 A[Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0157 A[Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0168 A[Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0182 A[Catch:{ RuntimeException -> 0x01ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01cf A[Catch:{ all -> 0x01c8 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:93:0x01e0=Splitter:B:93:0x01e0, B:89:0x01d2=Splitter:B:89:0x01d2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int A(java.lang.String r23, fe.fe.mmm.l r24) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "bizInfo"
            java.lang.String r3 = "bizparam"
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            android.database.sqlite.SQLiteDatabase r5 = r22.getReadableDatabase()     // Catch:{ SQLException -> 0x01e6 }
            r6 = 0
            r0 = r23
            android.database.Cursor r6 = r5.rawQuery(r0, r6)     // Catch:{ RuntimeException -> 0x01ca }
            if (r6 == 0) goto L_0x01c1
            int r0 = r6.getCount()     // Catch:{ RuntimeException -> 0x01ca }
            if (r0 <= 0) goto L_0x01c1
            r6.moveToFirst()     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "flowid"
            int r8 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "flowhandle"
            int r9 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "state"
            int r10 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "begintime"
            int r11 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "endtime"
            int r12 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "content"
            int r13 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "option"
            int r14 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "reserve1"
            int r15 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "reserve2"
            int r4 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "slot"
            int r7 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01ca }
            java.lang.String r0 = "extend"
            int r1 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            java.lang.String r0 = "logid"
            r16 = r5
            int r5 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            java.lang.String r0 = "uuid"
            r17 = r5
            int r5 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            java.lang.String r0 = "appversion"
            r18 = r5
            int r5 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
        L_0x007f:
            java.lang.String r0 = "2"
            r19 = r5
            java.lang.String r5 = r6.getString(r10)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r0 == 0) goto L_0x0189
            fe.fe.mmm.ddd r5 = new fe.fe.mmm.ddd     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r5.<init>()     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            java.lang.String r0 = r6.getString(r8)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r5.g(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            int r0 = r6.getInt(r9)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r5.f(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r20 = r8
            r21 = r9
            long r8 = r6.getLong(r11)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r5.aaa(r8)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            long r8 = r6.getLong(r12)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r5.b(r8)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            int r0 = r6.getInt(r14)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r5.j(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            java.lang.String r0 = r6.getString(r13)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r8 != 0) goto L_0x00c6
            r5.tt(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
        L_0x00c6:
            java.lang.String r0 = r6.getString(r15)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r8 != 0) goto L_0x00d3
            r5.e(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
        L_0x00d3:
            java.lang.String r0 = r6.getString(r4)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r0 != 0) goto L_0x00e4
            java.lang.String r0 = r6.getString(r4)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r5.rrr(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
        L_0x00e4:
            java.lang.String r0 = r6.getString(r7)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r7 < 0) goto L_0x00f3
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r8 != 0) goto L_0x00f3
            r5.k(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
        L_0x00f3:
            java.lang.String r0 = r6.getString(r1)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r0 != 0) goto L_0x013b
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0131 }
            java.lang.String r8 = r6.getString(r1)     // Catch:{ JSONException -> 0x0131 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x0131 }
            java.lang.String r8 = "ctr"
            boolean r8 = r0.has(r8)     // Catch:{ JSONException -> 0x0131 }
            if (r8 == 0) goto L_0x0115
            r8 = 1
            r5.a(r8)     // Catch:{ JSONException -> 0x0113 }
            goto L_0x0116
        L_0x0113:
            r0 = move-exception
            goto L_0x0133
        L_0x0115:
            r8 = 1
        L_0x0116:
            boolean r9 = r0.has(r3)     // Catch:{ JSONException -> 0x0113 }
            if (r9 == 0) goto L_0x0123
            org.json.JSONObject r9 = r0.optJSONObject(r3)     // Catch:{ JSONException -> 0x0113 }
            r5.eee(r9)     // Catch:{ JSONException -> 0x0113 }
        L_0x0123:
            boolean r9 = r0.has(r2)     // Catch:{ JSONException -> 0x0113 }
            if (r9 == 0) goto L_0x013c
            java.lang.String r0 = r0.optString(r2)     // Catch:{ JSONException -> 0x0113 }
            r5.qqq(r0)     // Catch:{ JSONException -> 0x0113 }
            goto L_0x013c
        L_0x0131:
            r0 = move-exception
            r8 = 1
        L_0x0133:
            boolean r9 = f2015i     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r9 == 0) goto L_0x013c
            r0.printStackTrace()     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            goto L_0x013c
        L_0x013b:
            r8 = 1
        L_0x013c:
            r9 = r17
            java.lang.String r0 = r6.getString(r9)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            boolean r17 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r17 != 0) goto L_0x014b
            r5.h(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
        L_0x014b:
            r8 = r18
            java.lang.String r0 = r6.getString(r8)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            boolean r17 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r17 != 0) goto L_0x015a
            r5.m(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
        L_0x015a:
            r17 = r1
            r1 = r19
            java.lang.String r0 = r6.getString(r1)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            boolean r18 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            if (r18 != 0) goto L_0x016b
            r5.mmm(r0)     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
        L_0x016b:
            int r0 = r5.pf()     // Catch:{ RuntimeException -> 0x01bd, all -> 0x01b9 }
            r19 = r1
            r18 = r3
            r3 = r16
            r1 = r22
            r16 = r2
            r2 = r24
            boolean r0 = r1.uk(r3, r5, r0, r2)     // Catch:{ RuntimeException -> 0x01ca }
            if (r0 != 0) goto L_0x0182
            goto L_0x01a3
        L_0x0182:
            boolean r0 = r24.j()     // Catch:{ RuntimeException -> 0x01ca }
            if (r0 == 0) goto L_0x019d
            goto L_0x01a3
        L_0x0189:
            r20 = r8
            r21 = r9
            r9 = r17
            r8 = r18
            r17 = r1
            r18 = r3
            r3 = r16
            r1 = r22
            r16 = r2
            r2 = r24
        L_0x019d:
            boolean r0 = r6.moveToNext()     // Catch:{ RuntimeException -> 0x01ca }
            if (r0 != 0) goto L_0x01a5
        L_0x01a3:
            r4 = 1
            goto L_0x01c2
        L_0x01a5:
            r2 = r16
            r1 = r17
            r5 = r19
            r16 = r3
            r17 = r9
            r3 = r18
            r9 = r21
            r18 = r8
            r8 = r20
            goto L_0x007f
        L_0x01b9:
            r0 = move-exception
            r1 = r22
            goto L_0x01e0
        L_0x01bd:
            r0 = move-exception
            r1 = r22
            goto L_0x01cb
        L_0x01c1:
            r4 = 0
        L_0x01c2:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x01c6 }
            goto L_0x01d6
        L_0x01c6:
            r0 = move-exception
            goto L_0x01e8
        L_0x01c8:
            r0 = move-exception
            goto L_0x01e0
        L_0x01ca:
            r0 = move-exception
        L_0x01cb:
            boolean r2 = f2015i     // Catch:{ all -> 0x01c8 }
            if (r2 == 0) goto L_0x01d2
            r0.printStackTrace()     // Catch:{ all -> 0x01c8 }
        L_0x01d2:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x01e6 }
            r4 = 0
        L_0x01d6:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            goto L_0x01f9
        L_0x01e0:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x01e6 }
            throw r0     // Catch:{ SQLException -> 0x01e6 }
        L_0x01e4:
            r0 = move-exception
            goto L_0x01fa
        L_0x01e6:
            r0 = move-exception
            r4 = 0
        L_0x01e8:
            boolean r2 = f2015i     // Catch:{ all -> 0x01e4 }
            if (r2 == 0) goto L_0x01ef
            r0.printStackTrace()     // Catch:{ all -> 0x01e4 }
        L_0x01ef:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x01e4 }
            java.lang.String r3 = "read_"
            java.lang.String r5 = "getFlowData"
            r2.uk(r0, r3, r5)     // Catch:{ all -> 0x01e4 }
            goto L_0x01d6
        L_0x01f9:
            return r4
        L_0x01fa:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.A(java.lang.String, fe.fe.mmm.l):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01b7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b8, code lost:
        r5 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01ba, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01bb, code lost:
        r5 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01c9, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a8 A[SYNTHETIC, Splitter:B:21:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01b7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c9 A[Catch:{ all -> 0x01d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.fe.mmm.ddd B(java.lang.String r18, int r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "bizInfo"
            java.lang.String r3 = "bizparam"
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r4.readLock()
            r4.lock()
            fe.fe.mmm.ddd r4 = new fe.fe.mmm.ddd
            r5 = 0
            r6 = r19
            r4.<init>(r0, r6, r5)
            android.database.sqlite.SQLiteDatabase r14 = r17.getWritableDatabase()
            r7 = 2
            java.lang.String[] r15 = new java.lang.String[r7]     // Catch:{ Exception -> 0x01c2, all -> 0x01be }
            r7 = 0
            r15[r7] = r0     // Catch:{ Exception -> 0x01c2, all -> 0x01be }
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x01c2, all -> 0x01be }
            r13 = 1
            r15[r13] = r0     // Catch:{ Exception -> 0x01c2, all -> 0x01be }
            java.lang.String[] r10 = new java.lang.String[r13]     // Catch:{ Exception -> 0x01c2, all -> 0x01be }
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x01c2, all -> 0x01be }
            r10[r7] = r0     // Catch:{ Exception -> 0x01c2, all -> 0x01be }
            java.lang.String r7 = "event"
            r8 = 0
            java.lang.String r9 = "flowhandle=?"
            r11 = 0
            r12 = 0
            r0 = 0
            r6 = r14
            r5 = 1
            r13 = r0
            android.database.Cursor r13 = r6.query(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x01c2, all -> 0x01be }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x01ba, all -> 0x01b7 }
            r0.<init>()     // Catch:{ Exception -> 0x01ba, all -> 0x01b7 }
            java.lang.String r12 = "begintime"
            java.lang.String r11 = "content"
            if (r13 == 0) goto L_0x008d
            boolean r6 = r13.moveToFirst()     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            if (r6 == 0) goto L_0x008d
            java.lang.String r6 = "eventid"
            int r6 = r13.getColumnIndex(r6)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            int r7 = r13.getColumnIndex(r12)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            int r8 = r13.getColumnIndex(r11)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
        L_0x0060:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            r9.<init>()     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            java.lang.String r10 = "id"
            java.lang.String r5 = r13.getString(r6)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            r9.put(r10, r5)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            java.lang.String r5 = "timestamp"
            java.lang.String r10 = r13.getString(r7)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            r9.put(r5, r10)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            java.lang.String r5 = r13.getString(r8)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            r9.put(r11, r5)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            r0.put(r9)     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            boolean r5 = r13.moveToNext()     // Catch:{ Exception -> 0x008a, all -> 0x01b7 }
            if (r5 != 0) goto L_0x0088
            goto L_0x008d
        L_0x0088:
            r5 = 1
            goto L_0x0060
        L_0x008a:
            r0 = move-exception
            goto L_0x01bc
        L_0x008d:
            r4.c(r0)     // Catch:{ Exception -> 0x01ba, all -> 0x01b7 }
            java.lang.String r7 = "flow"
            r8 = 0
            java.lang.String r9 = "flowid=? AND flowhandle=?"
            r0 = 0
            r5 = 0
            r16 = 0
            r6 = r14
            r10 = r15
            r14 = r11
            r11 = r0
            r0 = r12
            r12 = r5
            r5 = r13
            r13 = r16
            android.database.Cursor r6 = r6.query(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x01b4, all -> 0x01b2 }
            if (r6 == 0) goto L_0x01a1
            boolean r7 = r6.moveToFirst()     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            if (r7 == 0) goto L_0x01a1
            int r0 = r6.getColumnIndex(r0)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r7 = "endtime"
            int r7 = r6.getColumnIndex(r7)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            int r8 = r6.getColumnIndex(r14)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r9 = "slot"
            int r9 = r6.getColumnIndex(r9)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r10 = "option"
            int r10 = r6.getColumnIndex(r10)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r11 = "reserve1"
            int r11 = r6.getColumnIndex(r11)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r12 = "reserve2"
            int r12 = r6.getColumnIndex(r12)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r13 = "extend"
            int r13 = r6.getColumnIndex(r13)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r14 = "logid"
            int r14 = r6.getColumnIndex(r14)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r15 = "uuid"
            int r15 = r6.getColumnIndex(r15)     // Catch:{ Exception -> 0x019e, all -> 0x019c }
            java.lang.String r1 = "appversion"
            int r1 = r6.getColumnIndex(r1)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            r19 = r1
            long r0 = r6.getLong(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            r4.aaa(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            long r0 = r6.getLong(r7)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            r4.b(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            java.lang.String r0 = r6.getString(r8)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            r4.tt(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            java.lang.String r0 = r6.getString(r9)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            r4.k(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            int r0 = r6.getInt(r10)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            r4.j(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            java.lang.String r0 = r6.getString(r11)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            r4.e(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            java.lang.String r0 = r6.getString(r12)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            r4.rrr(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            java.lang.String r0 = r6.getString(r13)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            if (r1 != 0) goto L_0x0159
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0155 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0155 }
            java.lang.String r0 = "ctr"
            boolean r0 = r1.has(r0)     // Catch:{ JSONException -> 0x0155 }
            if (r0 == 0) goto L_0x013a
            r0 = 1
            r4.a(r0)     // Catch:{ JSONException -> 0x0155 }
        L_0x013a:
            boolean r0 = r1.has(r3)     // Catch:{ JSONException -> 0x0155 }
            if (r0 == 0) goto L_0x0147
            org.json.JSONObject r0 = r1.optJSONObject(r3)     // Catch:{ JSONException -> 0x0155 }
            r4.eee(r0)     // Catch:{ JSONException -> 0x0155 }
        L_0x0147:
            boolean r0 = r1.has(r2)     // Catch:{ JSONException -> 0x0155 }
            if (r0 == 0) goto L_0x0159
            java.lang.String r0 = r1.optString(r2)     // Catch:{ JSONException -> 0x0155 }
            r4.qqq(r0)     // Catch:{ JSONException -> 0x0155 }
            goto L_0x0159
        L_0x0155:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
        L_0x0159:
            java.lang.String r0 = r6.getString(r14)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            if (r1 != 0) goto L_0x0166
            r4.h(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
        L_0x0166:
            java.lang.String r0 = r6.getString(r15)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            if (r1 != 0) goto L_0x0173
            r4.m(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
        L_0x0173:
            r1 = r19
            java.lang.String r0 = r6.getString(r1)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
            if (r1 != 0) goto L_0x0182
            r4.mmm(r0)     // Catch:{ Exception -> 0x0198, all -> 0x0194 }
        L_0x0182:
            fe.fe.mmm.u.qw.qw(r5)
            fe.fe.mmm.u.qw.qw(r6)
            r1 = r17
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r4
        L_0x0194:
            r0 = move-exception
            r1 = r17
            goto L_0x01d2
        L_0x0198:
            r0 = move-exception
            r1 = r17
            goto L_0x019f
        L_0x019c:
            r0 = move-exception
            goto L_0x01d2
        L_0x019e:
            r0 = move-exception
        L_0x019f:
            r13 = r5
            goto L_0x01c5
        L_0x01a1:
            fe.fe.mmm.u.qw.qw(r5)
        L_0x01a4:
            fe.fe.mmm.u.qw.qw(r6)
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            r2 = 0
            return r2
        L_0x01b2:
            r0 = move-exception
            goto L_0x01c0
        L_0x01b4:
            r0 = move-exception
            r13 = r5
            goto L_0x01bc
        L_0x01b7:
            r0 = move-exception
            r5 = r13
            goto L_0x01c0
        L_0x01ba:
            r0 = move-exception
            r5 = r13
        L_0x01bc:
            r6 = 0
            goto L_0x01c5
        L_0x01be:
            r0 = move-exception
            r5 = 0
        L_0x01c0:
            r6 = 0
            goto L_0x01d2
        L_0x01c2:
            r0 = move-exception
            r6 = 0
            r13 = 0
        L_0x01c5:
            boolean r2 = f2015i     // Catch:{ all -> 0x01d0 }
            if (r2 == 0) goto L_0x01cc
            r0.printStackTrace()     // Catch:{ all -> 0x01d0 }
        L_0x01cc:
            fe.fe.mmm.u.qw.qw(r13)
            goto L_0x01a4
        L_0x01d0:
            r0 = move-exception
            r5 = r13
        L_0x01d2:
            fe.fe.mmm.u.qw.qw(r5)
            fe.fe.mmm.u.qw.qw(r6)
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.B(java.lang.String, int):fe.fe.mmm.ddd");
    }

    public final String C(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append("'");
            sb.append(arrayList.get(i2));
            sb.append("'");
        }
        return sb.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: fe.fe.mmm.eee} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: fe.fe.mmm.eee} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: fe.fe.mmm.eee} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: fe.fe.mmm.eee} */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01ff, code lost:
        r0 = e;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ca, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cb, code lost:
        r22 = null;
        r3 = r24;
        r1 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d4, code lost:
        r14 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d6, code lost:
        r19 = " IS NULL OR b.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0123, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0129, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012a, code lost:
        r17 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0131, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0132, code lost:
        r1 = r21;
        r22 = null;
        r3 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013b, code lost:
        r23 = "SELECT COUNT(*) FROM ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x013d, code lost:
        r14 = r19;
        r1 = r21;
        r19 = " IS NULL OR b.";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x020c A[Catch:{ all -> 0x0222 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ca A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0131 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0148 A[Catch:{ all -> 0x01f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0189 A[Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a3 A[Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01df A[Catch:{ all -> 0x01e8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.ubc.UBCUploadTimingManager.fe E() {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r2 = "')"
            java.lang.String r3 = "'"
            java.lang.String r4 = " IS NULL OR b."
            java.lang.String r5 = " AND (b."
            java.lang.String r6 = " AND b."
            java.lang.String r0 = "reallog"
            java.lang.String r7 = " WHERE "
            java.lang.String r8 = " = b."
            java.lang.String r9 = "ON a."
            java.lang.String r10 = " b "
            java.lang.String r11 = "config"
            java.lang.String r12 = "LEFT JOIN "
            java.lang.String r13 = " a "
            java.lang.String r14 = "SELECT COUNT(*) FROM "
            java.lang.String r15 = "eventid"
            r16 = r3
            java.lang.String r3 = "1"
            r17 = r6
            java.lang.String r6 = " = '"
            r18 = r2
            java.lang.String r2 = "switch"
            r19 = r3
            com.baidu.ubc.UBCUploadTimingManager$fe r3 = new com.baidu.ubc.UBCUploadTimingManager$fe
            r3.<init>()
            fe.fe.mmm.i r20 = fe.fe.mmm.i.vvv()
            boolean r20 = r20.j()
            r21 = r3
            java.util.concurrent.locks.ReentrantReadWriteLock r3 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r3.readLock()
            r3.lock()
            android.database.sqlite.SQLiteDatabase r3 = r24.getReadableDatabase()     // Catch:{ SQLException -> 0x0204, all -> 0x0201 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x013a, all -> 0x0131 }
            r1.<init>()     // Catch:{ RuntimeException -> 0x013a, all -> 0x0131 }
            r1.append(r14)     // Catch:{ RuntimeException -> 0x013a, all -> 0x0131 }
            r23 = r14
            java.lang.String r14 = "event"
            r1.append(r14)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r13)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r12)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r11)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r10)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r9)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r15)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r8)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r15)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r7)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            java.lang.String r14 = "a."
            r1.append(r14)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            java.lang.String r14 = "flowhandle"
            r1.append(r14)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            java.lang.String r14 = " = "
            r1.append(r14)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r14 = -1
            r1.append(r14)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            java.lang.String r14 = " AND "
            r1.append(r14)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            java.lang.String r14 = "(a."
            r1.append(r14)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r0)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            java.lang.String r14 = " = '0' OR a."
            r1.append(r14)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            r1.append(r0)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            java.lang.String r0 = " = '')"
            r1.append(r0)     // Catch:{ RuntimeException -> 0x012f, all -> 0x0131 }
            if (r20 == 0) goto L_0x00d9
            r1.append(r5)     // Catch:{ RuntimeException -> 0x00d3, all -> 0x00ca }
            r1.append(r2)     // Catch:{ RuntimeException -> 0x00d3, all -> 0x00ca }
            r1.append(r4)     // Catch:{ RuntimeException -> 0x00d3, all -> 0x00ca }
            r1.append(r2)     // Catch:{ RuntimeException -> 0x00d3, all -> 0x00ca }
            r1.append(r6)     // Catch:{ RuntimeException -> 0x00d3, all -> 0x00ca }
            r14 = r19
            r1.append(r14)     // Catch:{ RuntimeException -> 0x00c8, all -> 0x00ca }
            r19 = r4
            r4 = r18
            r1.append(r4)     // Catch:{ RuntimeException -> 0x00c3, all -> 0x00ca }
            r18 = r4
            r4 = r16
            goto L_0x00f2
        L_0x00c3:
            r0 = move-exception
            r18 = r4
            goto L_0x012c
        L_0x00c8:
            r0 = move-exception
            goto L_0x00d6
        L_0x00ca:
            r0 = move-exception
            r22 = 0
            r3 = r24
            r1 = r21
            goto L_0x01fb
        L_0x00d3:
            r0 = move-exception
            r14 = r19
        L_0x00d6:
            r19 = r4
            goto L_0x012c
        L_0x00d9:
            r14 = r19
            r19 = r4
            r4 = r17
            r1.append(r4)     // Catch:{ RuntimeException -> 0x0129, all -> 0x0131 }
            r1.append(r2)     // Catch:{ RuntimeException -> 0x0129, all -> 0x0131 }
            r1.append(r6)     // Catch:{ RuntimeException -> 0x0129, all -> 0x0131 }
            r1.append(r14)     // Catch:{ RuntimeException -> 0x0129, all -> 0x0131 }
            r17 = r4
            r4 = r16
            r1.append(r4)     // Catch:{ RuntimeException -> 0x0125, all -> 0x0131 }
        L_0x00f2:
            java.lang.String r0 = r1.toString()     // Catch:{ RuntimeException -> 0x0125, all -> 0x0131 }
            r16 = r4
            r1 = 0
            android.database.Cursor r4 = r3.rawQuery(r0, r1)     // Catch:{ RuntimeException -> 0x0123, all -> 0x0131 }
            if (r4 == 0) goto L_0x011d
            int r0 = r4.getCount()     // Catch:{ RuntimeException -> 0x0119, all -> 0x0114 }
            if (r0 <= 0) goto L_0x011d
            r4.moveToFirst()     // Catch:{ RuntimeException -> 0x0119, all -> 0x0114 }
            r1 = 0
            int r0 = r4.getInt(r1)     // Catch:{ RuntimeException -> 0x0119, all -> 0x0114 }
            r1 = r21
            r1.qw = r0     // Catch:{ RuntimeException -> 0x0112 }
            goto L_0x011f
        L_0x0112:
            r0 = move-exception
            goto L_0x0144
        L_0x0114:
            r0 = move-exception
            r1 = r21
            goto L_0x01f7
        L_0x0119:
            r0 = move-exception
            r1 = r21
            goto L_0x0144
        L_0x011d:
            r1 = r21
        L_0x011f:
            fe.fe.mmm.u.qw.qw(r4)     // Catch:{ SQLException -> 0x01f2, all -> 0x01ee }
            goto L_0x014c
        L_0x0123:
            r0 = move-exception
            goto L_0x012c
        L_0x0125:
            r0 = move-exception
            r16 = r4
            goto L_0x012c
        L_0x0129:
            r0 = move-exception
            r17 = r4
        L_0x012c:
            r1 = r21
            goto L_0x0143
        L_0x012f:
            r0 = move-exception
            goto L_0x013d
        L_0x0131:
            r0 = move-exception
            r1 = r21
            r22 = 0
            r3 = r24
            goto L_0x01fb
        L_0x013a:
            r0 = move-exception
            r23 = r14
        L_0x013d:
            r14 = r19
            r1 = r21
            r19 = r4
        L_0x0143:
            r4 = 0
        L_0x0144:
            boolean r21 = f2015i     // Catch:{ all -> 0x01f6 }
            if (r21 == 0) goto L_0x011f
            r0.printStackTrace()     // Catch:{ all -> 0x01f6 }
            goto L_0x011f
        L_0x014c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.<init>()     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r4 = r23
            r0.append(r4)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            java.lang.String r4 = "flow"
            r0.append(r4)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r13)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r12)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r11)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r10)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r9)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            java.lang.String r4 = "flowid"
            r0.append(r4)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r8)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r15)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r7)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            java.lang.String r4 = " a."
            r0.append(r4)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            java.lang.String r4 = "endtime"
            r0.append(r4)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            java.lang.String r4 = " IS NOT NULL"
            r0.append(r4)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            if (r20 == 0) goto L_0x01a3
            r0.append(r5)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r2)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r4 = r19
            r0.append(r4)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r2)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r6)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r14)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r2 = r18
            r0.append(r2)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            goto L_0x01b6
        L_0x01a3:
            r4 = r17
            r0.append(r4)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r2)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r6)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r0.append(r14)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r2 = r16
            r0.append(r2)     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
        L_0x01b6:
            java.lang.String r0 = r0.toString()     // Catch:{ RuntimeException -> 0x01d9, all -> 0x01d4 }
            r2 = 0
            android.database.Cursor r2 = r3.rawQuery(r0, r2)     // Catch:{ RuntimeException -> 0x01d2 }
            if (r2 == 0) goto L_0x01e2
            int r0 = r2.getCount()     // Catch:{ RuntimeException -> 0x01d2 }
            if (r0 <= 0) goto L_0x01e2
            r2.moveToFirst()     // Catch:{ RuntimeException -> 0x01d2 }
            r3 = 0
            int r0 = r2.getInt(r3)     // Catch:{ RuntimeException -> 0x01d2 }
            r1.f1126ad = r0     // Catch:{ RuntimeException -> 0x01d2 }
            goto L_0x01e2
        L_0x01d2:
            r0 = move-exception
            goto L_0x01db
        L_0x01d4:
            r0 = move-exception
            r2 = 0
        L_0x01d6:
            r3 = r24
            goto L_0x01ea
        L_0x01d9:
            r0 = move-exception
            r2 = 0
        L_0x01db:
            boolean r3 = f2015i     // Catch:{ all -> 0x01e8 }
            if (r3 == 0) goto L_0x01e2
            r0.printStackTrace()     // Catch:{ all -> 0x01e8 }
        L_0x01e2:
            fe.fe.mmm.u.qw.qw(r2)     // Catch:{ SQLException -> 0x01f2, all -> 0x01ee }
            r3 = r24
            goto L_0x0218
        L_0x01e8:
            r0 = move-exception
            goto L_0x01d6
        L_0x01ea:
            fe.fe.mmm.u.qw.qw(r2)     // Catch:{ SQLException -> 0x01ff }
            throw r0     // Catch:{ SQLException -> 0x01ff }
        L_0x01ee:
            r0 = move-exception
            r3 = r24
            goto L_0x0223
        L_0x01f2:
            r0 = move-exception
            r3 = r24
            goto L_0x0208
        L_0x01f6:
            r0 = move-exception
        L_0x01f7:
            r3 = r24
            r22 = r4
        L_0x01fb:
            fe.fe.mmm.u.qw.qw(r22)     // Catch:{ SQLException -> 0x01ff }
            throw r0     // Catch:{ SQLException -> 0x01ff }
        L_0x01ff:
            r0 = move-exception
            goto L_0x0208
        L_0x0201:
            r0 = move-exception
            r3 = r1
            goto L_0x0223
        L_0x0204:
            r0 = move-exception
            r3 = r1
            r1 = r21
        L_0x0208:
            boolean r2 = f2015i     // Catch:{ all -> 0x0222 }
            if (r2 == 0) goto L_0x020f
            r0.printStackTrace()     // Catch:{ all -> 0x0222 }
        L_0x020f:
            fe.fe.mmm.fe r2 = r3.f2018ad     // Catch:{ all -> 0x0222 }
            java.lang.String r4 = "read_"
            java.lang.String r5 = "getLogNumbers"
            r2.uk(r0, r4, r5)     // Catch:{ all -> 0x0222 }
        L_0x0218:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r3.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r1
        L_0x0222:
            r0 = move-exception
        L_0x0223:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r3.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.E():com.baidu.ubc.UBCUploadTimingManager$fe");
    }

    public int F(l lVar) {
        StringBuilder sb = new StringBuilder(256);
        sb.append("SELECT * FROM ");
        sb.append(NotificationCompat.CATEGORY_EVENT);
        sb.append(" WHERE ");
        sb.append("flowhandle");
        sb.append(" = ");
        sb.append(-1);
        sb.append(" AND ");
        sb.append("reallog");
        sb.append(" = \"1\"");
        return x(sb.toString(), lVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0107 A[Catch:{ all -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0119 A[SYNTHETIC, Splitter:B:40:0x0119] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x00fa=Splitter:B:26:0x00fa, B:47:0x012b=Splitter:B:47:0x012b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, fe.fe.mmm.aaa.qw> G(int r21) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "logid"
            java.lang.String r3 = "callcnt"
            java.lang.String r4 = "count"
            java.lang.String r5 = "ubcid"
            java.lang.String r6 = "getRecentUBCRecords"
            java.lang.String r7 = "read_"
            java.lang.String r8 = "ubctime"
            java.lang.String r9 = ", "
            r10 = 0
            if (r0 > 0) goto L_0x0018
            return r10
        L_0x0018:
            java.util.concurrent.locks.ReentrantReadWriteLock r11 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r11 = r11.readLock()
            r11.lock()
            android.database.sqlite.SQLiteDatabase r11 = r20.getReadableDatabase()     // Catch:{ SQLException -> 0x014e }
            java.util.HashMap r19 = new java.util.HashMap     // Catch:{ SQLException -> 0x014e }
            r19.<init>()     // Catch:{ SQLException -> 0x014e }
            r11.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x013a, RuntimeException -> 0x0131 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.<init>()     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r13 = "SELECT "
            r12.append(r13)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r5)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r8)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r4)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r3)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r2)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r9 = " FROM "
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r9 = "arrival"
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r9 = " WHERE "
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r9 = "date("
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r8)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r9 = ") > date('now', 'localtime', '-"
            r12.append(r9)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r0 = " day') "
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r0 = " AND "
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r0 = "state"
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r0 = " = "
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r0 = 0
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r0 = " ORDER BY date("
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            r12.append(r8)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r0 = ")"
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r0 = " DESC"
            r12.append(r0)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            java.lang.String r0 = r12.toString()     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            android.database.Cursor r9 = r11.rawQuery(r0, r10)     // Catch:{ SQLException -> 0x0101, all -> 0x00fe }
            if (r9 == 0) goto L_0x00fa
            int r0 = r9.getCount()     // Catch:{ SQLException -> 0x00f8 }
            if (r0 <= 0) goto L_0x00fa
            r9.moveToFirst()     // Catch:{ SQLException -> 0x00f8 }
            int r0 = r9.getColumnIndex(r5)     // Catch:{ SQLException -> 0x00f8 }
            int r5 = r9.getColumnIndex(r8)     // Catch:{ SQLException -> 0x00f8 }
            int r4 = r9.getColumnIndex(r4)     // Catch:{ SQLException -> 0x00f8 }
            int r3 = r9.getColumnIndex(r3)     // Catch:{ SQLException -> 0x00f8 }
            int r2 = r9.getColumnIndex(r2)     // Catch:{ SQLException -> 0x00f8 }
        L_0x00c2:
            java.lang.String r15 = r9.getString(r0)     // Catch:{ SQLException -> 0x00f8 }
            java.lang.String r14 = r9.getString(r5)     // Catch:{ SQLException -> 0x00f8 }
            int r8 = r9.getInt(r4)     // Catch:{ SQLException -> 0x00f8 }
            int r17 = r9.getInt(r3)     // Catch:{ SQLException -> 0x00f8 }
            java.lang.String r18 = r9.getString(r2)     // Catch:{ SQLException -> 0x00f8 }
            r12 = 1
            if (r8 < r12) goto L_0x00f1
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ SQLException -> 0x00f8 }
            if (r12 != 0) goto L_0x00f1
            boolean r12 = android.text.TextUtils.isEmpty(r14)     // Catch:{ SQLException -> 0x00f8 }
            if (r12 == 0) goto L_0x00e6
            goto L_0x00f1
        L_0x00e6:
            fe.fe.mmm.aaa r12 = fe.fe.mmm.aaa.o()     // Catch:{ SQLException -> 0x00f8 }
            r13 = r19
            r16 = r8
            r12.th(r13, r14, r15, r16, r17, r18)     // Catch:{ SQLException -> 0x00f8 }
        L_0x00f1:
            boolean r8 = r9.moveToNext()     // Catch:{ SQLException -> 0x00f8 }
            if (r8 != 0) goto L_0x00c2
            goto L_0x00fa
        L_0x00f8:
            r0 = move-exception
            goto L_0x0103
        L_0x00fa:
            fe.fe.mmm.u.qw.qw(r9)     // Catch:{ SQLException -> 0x013a, RuntimeException -> 0x0131 }
            goto L_0x0110
        L_0x00fe:
            r0 = move-exception
            r9 = r10
            goto L_0x012b
        L_0x0101:
            r0 = move-exception
            r9 = r10
        L_0x0103:
            boolean r2 = f2015i     // Catch:{ all -> 0x012a }
            if (r2 == 0) goto L_0x010a
            r0.printStackTrace()     // Catch:{ all -> 0x012a }
        L_0x010a:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x012a }
            r2.uk(r0, r7, r6)     // Catch:{ all -> 0x012a }
            goto L_0x00fa
        L_0x0110:
            r11.setTransactionSuccessful()     // Catch:{ SQLException -> 0x013a, RuntimeException -> 0x0131 }
            int r0 = r19.size()     // Catch:{ SQLException -> 0x013a, RuntimeException -> 0x0131 }
            if (r0 <= 0) goto L_0x0126
            r11.endTransaction()     // Catch:{ SQLException -> 0x014e }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r19
        L_0x0126:
            r11.endTransaction()     // Catch:{ SQLException -> 0x014e }
            goto L_0x015b
        L_0x012a:
            r0 = move-exception
        L_0x012b:
            fe.fe.mmm.u.qw.qw(r9)     // Catch:{ SQLException -> 0x013a, RuntimeException -> 0x0131 }
            throw r0     // Catch:{ SQLException -> 0x013a, RuntimeException -> 0x0131 }
        L_0x012f:
            r0 = move-exception
            goto L_0x0148
        L_0x0131:
            r0 = move-exception
            boolean r2 = f2015i     // Catch:{ all -> 0x012f }
            if (r2 == 0) goto L_0x0126
            r0.printStackTrace()     // Catch:{ all -> 0x012f }
            goto L_0x0126
        L_0x013a:
            r0 = move-exception
            boolean r2 = f2015i     // Catch:{ all -> 0x012f }
            if (r2 == 0) goto L_0x0142
            r0.printStackTrace()     // Catch:{ all -> 0x012f }
        L_0x0142:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x012f }
            r2.uk(r0, r7, r6)     // Catch:{ all -> 0x012f }
            goto L_0x0126
        L_0x0148:
            r11.endTransaction()     // Catch:{ SQLException -> 0x014e }
            throw r0     // Catch:{ SQLException -> 0x014e }
        L_0x014c:
            r0 = move-exception
            goto L_0x0165
        L_0x014e:
            r0 = move-exception
            boolean r2 = f2015i     // Catch:{ all -> 0x014c }
            if (r2 == 0) goto L_0x0156
            r0.printStackTrace()     // Catch:{ all -> 0x014c }
        L_0x0156:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x014c }
            r2.uk(r0, r7, r6)     // Catch:{ all -> 0x014c }
        L_0x015b:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r10
        L_0x0165:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.G(int):java.util.Map");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: fe.fe.mmm.xxx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: fe.fe.mmm.xxx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v11, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: fe.fe.mmm.xxx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: fe.fe.mmm.xxx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: fe.fe.mmm.xxx} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: fe.fe.mmm.xxx} */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fa, code lost:
        r13 = th;
        r6 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f2 A[Catch:{ all -> 0x00fa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.fe.mmm.xxx H(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "uploadindex"
            java.lang.String r1 = "uploadfirst"
            java.lang.String r2 = "reserve2"
            java.lang.String r3 = "reserve1"
            java.lang.String r4 = "state"
            java.lang.String r5 = " , "
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = r12.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r6 = r6.readLock()
            r6.lock()
            r6 = 0
            android.database.sqlite.SQLiteDatabase r7 = r12.getReadableDatabase()     // Catch:{ SQLException -> 0x0104 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0104 }
            r8.<init>()     // Catch:{ SQLException -> 0x0104 }
            java.lang.String r9 = "SELECT "
            r8.append(r9)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r4)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r3)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r2)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r1)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r0)     // Catch:{ SQLException -> 0x0104 }
            java.lang.String r5 = " FROM "
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            java.lang.String r5 = "file"
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            java.lang.String r5 = " WHERE "
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            java.lang.String r5 = "filename"
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            java.lang.String r5 = "=\""
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            r8.append(r13)     // Catch:{ SQLException -> 0x0104 }
            java.lang.String r5 = "\""
            r8.append(r5)     // Catch:{ SQLException -> 0x0104 }
            java.lang.String r5 = r8.toString()     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            android.database.Cursor r5 = r7.rawQuery(r5, r6)     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            if (r5 == 0) goto L_0x00e5
            int r7 = r5.getCount()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            if (r7 <= 0) goto L_0x00e5
            r5.moveToFirst()     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            int r4 = r5.getColumnIndex(r4)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            int r3 = r5.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            int r2 = r5.getColumnIndex(r2)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            int r1 = r5.getColumnIndex(r1)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            int r0 = r5.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.String r4 = r5.getString(r4)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            java.lang.String r7 = ""
            r8 = 0
            boolean r9 = r5.isNull(r3)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            if (r9 != 0) goto L_0x0098
            java.lang.String r7 = r5.getString(r3)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
        L_0x0098:
            boolean r3 = r5.isNull(r2)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            if (r3 != 0) goto L_0x00a6
            java.lang.String r2 = r5.getString(r2)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            boolean r8 = r12.L(r2)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
        L_0x00a6:
            boolean r2 = r5.isNull(r1)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r9 = 0
            if (r2 != 0) goto L_0x00b3
            long r1 = r5.getLong(r1)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            goto L_0x00b4
        L_0x00b3:
            r1 = r9
        L_0x00b4:
            boolean r3 = r5.isNull(r0)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r11 = 1
            if (r3 != 0) goto L_0x00c0
            int r0 = r5.getInt(r0)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            goto L_0x00c1
        L_0x00c0:
            r0 = 1
        L_0x00c1:
            fe.fe.mmm.xxx r3 = new fe.fe.mmm.xxx     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            r3.<init>(r13, r4, r7, r8)     // Catch:{ Exception -> 0x00e1, all -> 0x00dd }
            int r13 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r13 <= 0) goto L_0x00d2
            r3.yj(r1)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            goto L_0x00d2
        L_0x00ce:
            r13 = move-exception
            goto L_0x00df
        L_0x00d0:
            r13 = move-exception
            goto L_0x00e3
        L_0x00d2:
            if (r0 <= 0) goto L_0x00d8
            r3.th(r0)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
            goto L_0x00db
        L_0x00d8:
            r3.th(r11)     // Catch:{ Exception -> 0x00d0, all -> 0x00ce }
        L_0x00db:
            r6 = r3
            goto L_0x00e5
        L_0x00dd:
            r13 = move-exception
            r3 = r6
        L_0x00df:
            r6 = r5
            goto L_0x00fb
        L_0x00e1:
            r13 = move-exception
            r3 = r6
        L_0x00e3:
            r6 = r5
            goto L_0x00ee
        L_0x00e5:
            fe.fe.mmm.u.qw.qw(r5)     // Catch:{ SQLException -> 0x0104 }
            goto L_0x0115
        L_0x00e9:
            r13 = move-exception
            r3 = r6
            goto L_0x00fb
        L_0x00ec:
            r13 = move-exception
            r3 = r6
        L_0x00ee:
            boolean r0 = f2015i     // Catch:{ all -> 0x00fa }
            if (r0 == 0) goto L_0x00f5
            r13.printStackTrace()     // Catch:{ all -> 0x00fa }
        L_0x00f5:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x00ff }
            r6 = r3
            goto L_0x0115
        L_0x00fa:
            r13 = move-exception
        L_0x00fb:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x00ff }
            throw r13     // Catch:{ SQLException -> 0x00ff }
        L_0x00ff:
            r13 = move-exception
            r6 = r3
            goto L_0x0105
        L_0x0102:
            r13 = move-exception
            goto L_0x011f
        L_0x0104:
            r13 = move-exception
        L_0x0105:
            boolean r0 = f2015i     // Catch:{ all -> 0x0102 }
            if (r0 == 0) goto L_0x010c
            r13.printStackTrace()     // Catch:{ all -> 0x0102 }
        L_0x010c:
            fe.fe.mmm.fe r0 = r12.f2018ad     // Catch:{ all -> 0x0102 }
            java.lang.String r1 = "read_"
            java.lang.String r2 = "getSendingFile"
            r0.uk(r13, r1, r2)     // Catch:{ all -> 0x0102 }
        L_0x0115:
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = r12.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r13 = r13.readLock()
            r13.unlock()
            return r6
        L_0x011f:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r12.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.H(java.lang.String):fe.fe.mmm.xxx");
    }

    public final String I(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery;
        String str = null;
        try {
            rawQuery = sQLiteDatabase.rawQuery("PRAGMA synchronous", (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        str = rawQuery.getString(0);
                    } while (rawQuery.moveToNext());
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return str;
        throw th;
    }

    public void J(SparseArray<ArrayList> sparseArray) {
        this.f2020uk.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursor = null;
            try {
                cursor = readableDatabase.rawQuery("SELECT " + "eventid" + " , " + "type" + " , " + "cycle" + " FROM " + "config" + " WHERE " + "switch" + "=\"" + "1" + "\"" + " AND (" + "reallog" + " = \"0\" OR " + "reallog" + " = \"\")", (String[]) null);
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("eventid");
                    int columnIndex2 = cursor.getColumnIndex("type");
                    int columnIndex3 = cursor.getColumnIndex("cycle");
                    boolean k = i.vvv().k();
                    int rrr = i.vvv().rrr();
                    do {
                        String string = cursor.getString(columnIndex);
                        if (!ggg.qw(string)) {
                            cursor.getString(columnIndex2);
                            int i2 = cursor.getInt(columnIndex3);
                            if (i2 != 0) {
                                if (k) {
                                    i2 = rrr;
                                } else if (i2 < 1) {
                                    i2 = 1;
                                } else if (i2 > 720) {
                                    i2 = CameraUtilsForScan.MAX_SIZE_HEIGHT;
                                }
                            }
                            if (string != null) {
                                ArrayList arrayList = sparseArray.get(i2);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    sparseArray.put(i2, arrayList);
                                }
                                arrayList.add(string);
                            }
                        }
                    } while (cursor.moveToNext());
                }
            } catch (RuntimeException e) {
                if (f2015i) {
                    e.printStackTrace();
                }
            }
            qw.qw(cursor);
        } catch (SQLException e2) {
            try {
                if (f2015i) {
                    e2.printStackTrace();
                }
                this.f2018ad.uk(e2, "read_", "initId");
            } catch (Throwable th2) {
                this.f2020uk.readLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            qw.qw((Cursor) null);
            throw th3;
        }
        this.f2020uk.readLock().unlock();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0229 A[Catch:{ all -> 0x0222 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01e2 A[Catch:{ RuntimeException -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ee A[LOOP:0: B:17:0x0084->B:97:0x01ee, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K(fe.fe.mmm.uk r27) {
        /*
            r26 = this;
            r1 = r26
            java.lang.String r2 = "gflow"
            java.lang.String r3 = "ch"
            java.lang.String r4 = "isSend"
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.lock()
            android.database.sqlite.SQLiteDatabase r0 = r26.getReadableDatabase()     // Catch:{ SQLException -> 0x0224 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0224 }
            r5.<init>()     // Catch:{ SQLException -> 0x0224 }
            java.lang.String r6 = "SELECT * FROM "
            r5.append(r6)     // Catch:{ SQLException -> 0x0224 }
            java.lang.String r6 = "config"
            r5.append(r6)     // Catch:{ SQLException -> 0x0224 }
            r6 = 0
            java.lang.String r5 = r5.toString()     // Catch:{ RuntimeException -> 0x0208 }
            android.database.Cursor r6 = r0.rawQuery(r5, r6)     // Catch:{ RuntimeException -> 0x0208 }
            if (r27 != 0) goto L_0x0039
            fe.fe.mmm.uk r0 = new fe.fe.mmm.uk     // Catch:{ RuntimeException -> 0x0208, all -> 0x0036 }
            r0.<init>()     // Catch:{ RuntimeException -> 0x0208, all -> 0x0036 }
            r5 = r0
            goto L_0x003b
        L_0x0036:
            r0 = move-exception
            goto L_0x021e
        L_0x0039:
            r5 = r27
        L_0x003b:
            if (r6 == 0) goto L_0x0210
            int r0 = r6.getCount()     // Catch:{ RuntimeException -> 0x0208 }
            if (r0 <= 0) goto L_0x0210
            r6.moveToFirst()     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "eventid"
            int r7 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "switch"
            int r8 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "sample"
            int r9 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "reserve1"
            int r10 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "reserve2"
            int r11 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "cycle"
            int r12 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "uploadrule"
            int r13 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "recordrule"
            int r14 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "extend"
            int r15 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = "reallog"
            int r1 = r6.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x0208 }
            r16 = r2
        L_0x0084:
            java.lang.String r2 = r6.getString(r7)     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.String r0 = r6.getString(r8)     // Catch:{ RuntimeException -> 0x0208 }
            int r17 = r6.getInt(r9)     // Catch:{ RuntimeException -> 0x0208 }
            r27 = r7
            java.lang.String r7 = r6.getString(r10)     // Catch:{ RuntimeException -> 0x0208 }
            r18 = r8
            java.lang.String r8 = r6.getString(r11)     // Catch:{ RuntimeException -> 0x0208 }
            r19 = r9
            int r9 = r6.getInt(r12)     // Catch:{ RuntimeException -> 0x0208 }
            r20 = r10
            int r10 = r6.getInt(r13)     // Catch:{ RuntimeException -> 0x0208 }
            r21 = r11
            int r11 = r6.getInt(r14)     // Catch:{ RuntimeException -> 0x0208 }
            r22 = r12
            java.lang.String r12 = r6.getString(r15)     // Catch:{ RuntimeException -> 0x0208 }
            r23 = r13
            java.lang.String r13 = r6.getString(r1)     // Catch:{ RuntimeException -> 0x0208 }
            boolean r24 = fe.fe.mmm.ggg.qw(r2)     // Catch:{ RuntimeException -> 0x0208 }
            r25 = r1
            java.lang.String r1 = "1"
            if (r24 == 0) goto L_0x0101
            fe.fe.mmm.ggg r2 = new fe.fe.mmm.ggg     // Catch:{ RuntimeException -> 0x0208 }
            r2.<init>()     // Catch:{ RuntimeException -> 0x0208 }
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch:{ RuntimeException -> 0x0208 }
            r2.qw = r0     // Catch:{ RuntimeException -> 0x0208 }
            if (r9 != 0) goto L_0x00d3
            r0 = 1
            goto L_0x00d4
        L_0x00d3:
            r0 = 0
        L_0x00d4:
            r2.f2027ad = r0     // Catch:{ RuntimeException -> 0x0208 }
            r2.f2028de = r9     // Catch:{ RuntimeException -> 0x0208 }
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ RuntimeException -> 0x0208 }
            if (r0 != 0) goto L_0x00f9
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f1 }
            r0.<init>(r12)     // Catch:{ JSONException -> 0x00f1 }
            boolean r1 = r0.has(r4)     // Catch:{ JSONException -> 0x00f1 }
            if (r1 == 0) goto L_0x00f9
            r1 = 1
            boolean r0 = r0.optBoolean(r4, r1)     // Catch:{ JSONException -> 0x00f1 }
            r2.f2029fe = r0     // Catch:{ JSONException -> 0x00f1 }
            goto L_0x00f9
        L_0x00f1:
            r0 = move-exception
            boolean r1 = f2015i     // Catch:{ RuntimeException -> 0x0208 }
            if (r1 == 0) goto L_0x00f9
            r0.printStackTrace()     // Catch:{ RuntimeException -> 0x0208 }
        L_0x00f9:
            r5.qw = r2     // Catch:{ RuntimeException -> 0x0208 }
            r24 = r4
            r4 = r16
            goto L_0x01e7
        L_0x0101:
            r24 = r4
            java.lang.String r4 = "0"
            boolean r4 = android.text.TextUtils.equals(r0, r4)     // Catch:{ RuntimeException -> 0x0208 }
            if (r4 == 0) goto L_0x0111
            java.util.HashSet<java.lang.String> r0 = r5.f2209ad     // Catch:{ RuntimeException -> 0x0208 }
            r0.add(r2)     // Catch:{ RuntimeException -> 0x0208 }
            goto L_0x011c
        L_0x0111:
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch:{ RuntimeException -> 0x0208 }
            if (r0 == 0) goto L_0x011c
            java.util.HashSet<java.lang.String> r0 = r5.f2216th     // Catch:{ RuntimeException -> 0x0208 }
            r0.add(r2)     // Catch:{ RuntimeException -> 0x0208 }
        L_0x011c:
            if (r9 != 0) goto L_0x0123
            java.util.HashSet<java.lang.String> r0 = r5.f2210de     // Catch:{ RuntimeException -> 0x0208 }
            r0.add(r2)     // Catch:{ RuntimeException -> 0x0208 }
        L_0x0123:
            boolean r0 = android.text.TextUtils.equals(r7, r1)     // Catch:{ RuntimeException -> 0x0208 }
            if (r0 == 0) goto L_0x012e
            java.util.HashSet<java.lang.String> r0 = r5.f2215rg     // Catch:{ RuntimeException -> 0x0208 }
            r0.add(r2)     // Catch:{ RuntimeException -> 0x0208 }
        L_0x012e:
            if (r17 <= 0) goto L_0x0139
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r5.f2217uk     // Catch:{ RuntimeException -> 0x0208 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)     // Catch:{ RuntimeException -> 0x0208 }
            r0.put(r2, r4)     // Catch:{ RuntimeException -> 0x0208 }
        L_0x0139:
            boolean r0 = android.text.TextUtils.isEmpty(r8)     // Catch:{ RuntimeException -> 0x0208 }
            if (r0 != 0) goto L_0x0144
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r5.f2212i     // Catch:{ RuntimeException -> 0x0208 }
            r0.put(r2, r8)     // Catch:{ RuntimeException -> 0x0208 }
        L_0x0144:
            if (r10 == 0) goto L_0x0152
            if (r11 == 0) goto L_0x0152
            fe.fe.mmm.ppp r0 = new fe.fe.mmm.ppp     // Catch:{ RuntimeException -> 0x0208 }
            r0.<init>(r2, r11, r10)     // Catch:{ RuntimeException -> 0x0208 }
            java.util.HashMap<java.lang.String, fe.fe.mmm.ppp> r4 = r5.f2213o     // Catch:{ RuntimeException -> 0x0208 }
            r4.put(r2, r0)     // Catch:{ RuntimeException -> 0x0208 }
        L_0x0152:
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ RuntimeException -> 0x0208 }
            if (r0 != 0) goto L_0x01da
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01d3 }
            r0.<init>(r12)     // Catch:{ JSONException -> 0x01d3 }
            java.lang.String r4 = "idtype"
            boolean r4 = r0.has(r4)     // Catch:{ JSONException -> 0x01d3 }
            if (r4 == 0) goto L_0x016a
            java.util.HashSet<java.lang.String> r4 = r5.f2214pf     // Catch:{ JSONException -> 0x01d3 }
            r4.add(r2)     // Catch:{ JSONException -> 0x01d3 }
        L_0x016a:
            boolean r4 = r0.has(r3)     // Catch:{ JSONException -> 0x01d3 }
            if (r4 == 0) goto L_0x017f
            java.lang.String r4 = r0.getString(r3)     // Catch:{ JSONException -> 0x01d3 }
            boolean r4 = android.text.TextUtils.equals(r4, r1)     // Catch:{ JSONException -> 0x01d3 }
            if (r4 == 0) goto L_0x017f
            java.util.HashSet<java.lang.String> r4 = r5.f2218yj     // Catch:{ JSONException -> 0x01d3 }
            r4.add(r2)     // Catch:{ JSONException -> 0x01d3 }
        L_0x017f:
            r4 = r16
            boolean r7 = r0.has(r4)     // Catch:{ JSONException -> 0x01d1 }
            if (r7 == 0) goto L_0x0196
            int r7 = r0.getInt(r4)     // Catch:{ JSONException -> 0x01d1 }
            if (r7 == 0) goto L_0x0196
            java.util.HashMap<java.lang.String, java.lang.Integer> r8 = r5.f63switch     // Catch:{ JSONException -> 0x01d1 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ JSONException -> 0x01d1 }
            r8.put(r2, r7)     // Catch:{ JSONException -> 0x01d1 }
        L_0x0196:
            java.lang.String r7 = "uploadType"
            r8 = -1
            int r7 = r0.optInt(r7, r8)     // Catch:{ JSONException -> 0x01d1 }
            if (r7 == r8) goto L_0x01a8
            java.util.HashMap<java.lang.String, java.lang.Integer> r8 = r5.when     // Catch:{ JSONException -> 0x01d1 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ JSONException -> 0x01d1 }
            r8.put(r2, r7)     // Catch:{ JSONException -> 0x01d1 }
        L_0x01a8:
            java.lang.String r7 = "lcache"
            r8 = 2
            int r7 = r0.optInt(r7, r8)     // Catch:{ JSONException -> 0x01d1 }
            r8 = 1
            if (r7 == r8) goto L_0x01b4
            if (r7 != 0) goto L_0x01bd
        L_0x01b4:
            java.util.HashMap<java.lang.String, java.lang.Integer> r8 = r5.ppp     // Catch:{ JSONException -> 0x01d1 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ JSONException -> 0x01d1 }
            r8.put(r2, r7)     // Catch:{ JSONException -> 0x01d1 }
        L_0x01bd:
            java.lang.String r7 = "bizparam"
            org.json.JSONArray r0 = r0.optJSONArray(r7)     // Catch:{ JSONException -> 0x01d1 }
            if (r0 == 0) goto L_0x01dc
            int r7 = r0.length()     // Catch:{ JSONException -> 0x01d1 }
            if (r7 <= 0) goto L_0x01dc
            java.util.HashMap<java.lang.String, org.json.JSONArray> r7 = r5.ggg     // Catch:{ JSONException -> 0x01d1 }
            r7.put(r2, r0)     // Catch:{ JSONException -> 0x01d1 }
            goto L_0x01dc
        L_0x01d1:
            r0 = move-exception
            goto L_0x01d6
        L_0x01d3:
            r0 = move-exception
            r4 = r16
        L_0x01d6:
            r0.printStackTrace()     // Catch:{ RuntimeException -> 0x0208 }
            goto L_0x01dc
        L_0x01da:
            r4 = r16
        L_0x01dc:
            boolean r0 = android.text.TextUtils.equals(r13, r1)     // Catch:{ RuntimeException -> 0x0208 }
            if (r0 == 0) goto L_0x01e7
            java.util.HashSet<java.lang.String> r0 = r5.f62if     // Catch:{ RuntimeException -> 0x0208 }
            r0.add(r2)     // Catch:{ RuntimeException -> 0x0208 }
        L_0x01e7:
            boolean r0 = r6.moveToNext()     // Catch:{ RuntimeException -> 0x0208 }
            if (r0 != 0) goto L_0x01ee
            goto L_0x0210
        L_0x01ee:
            r7 = r27
            r16 = r4
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            r12 = r22
            r13 = r23
            r4 = r24
            r1 = r25
            goto L_0x0084
        L_0x0204:
            r0 = move-exception
            r1 = r26
            goto L_0x021e
        L_0x0208:
            r0 = move-exception
            boolean r1 = f2015i     // Catch:{ all -> 0x0204 }
            if (r1 == 0) goto L_0x0210
            r0.printStackTrace()     // Catch:{ all -> 0x0204 }
        L_0x0210:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x021a, all -> 0x0216 }
            r1 = r26
            goto L_0x0235
        L_0x0216:
            r0 = move-exception
            r1 = r26
            goto L_0x023f
        L_0x021a:
            r0 = move-exception
            r1 = r26
            goto L_0x0225
        L_0x021e:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x0224 }
            throw r0     // Catch:{ SQLException -> 0x0224 }
        L_0x0222:
            r0 = move-exception
            goto L_0x023f
        L_0x0224:
            r0 = move-exception
        L_0x0225:
            boolean r2 = f2015i     // Catch:{ all -> 0x0222 }
            if (r2 == 0) goto L_0x022c
            r0.printStackTrace()     // Catch:{ all -> 0x0222 }
        L_0x022c:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x0222 }
            java.lang.String r3 = "read_"
            java.lang.String r4 = "initRuleCache"
            r2.uk(r0, r3, r4)     // Catch:{ all -> 0x0222 }
        L_0x0235:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return
        L_0x023f:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.K(fe.fe.mmm.uk):void");
    }

    public final boolean L(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (TextUtils.equals(new JSONObject(str).optString("ubc_data_backend_type", "0"), "1")) {
                return true;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final boolean M() {
        return "1".equals(this.f2021yj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a8 A[Catch:{ all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void N(fe.fe.mmm.vvv r15) {
        /*
            r14 = this;
            if (r15 == 0) goto L_0x00ee
            java.lang.String r0 = r15.ppp()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000e
            goto L_0x00ee
        L_0x000e:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r0 = -1
            r2 = 0
            r4 = -1
            android.content.ContentValues r5 = r14.y(r15)     // Catch:{ SQLException -> 0x00a2 }
            java.lang.String r6 = r15.when()     // Catch:{ SQLException -> 0x00a2 }
            java.lang.String r7 = r15.ppp()     // Catch:{ SQLException -> 0x00a2 }
            int r8 = r15.m145switch()     // Catch:{ SQLException -> 0x00a2 }
            android.database.sqlite.SQLiteDatabase r9 = r14.getWritableDatabase()     // Catch:{ SQLException -> 0x00a2 }
            r9.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x00a2 }
            boolean r6 = r14.aaa(r6, r7, r8, r9)     // Catch:{ all -> 0x0095 }
            if (r6 == 0) goto L_0x0076
            java.lang.String r6 = "event"
            r10 = 0
            long r5 = r9.insert(r6, r10, r5)     // Catch:{ all -> 0x0095 }
            boolean r10 = f2015i     // Catch:{ all -> 0x0093 }
            if (r10 == 0) goto L_0x0054
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r10.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r11 = "saveEvent#performTransaction: rowId="
            r10.append(r11)     // Catch:{ all -> 0x0093 }
            r10.append(r5)     // Catch:{ all -> 0x0093 }
            r10.toString()     // Catch:{ all -> 0x0093 }
        L_0x0054:
            int r10 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x0077
            com.baidu.ubc.UBCUploadTimingManager r10 = com.baidu.ubc.UBCUploadTimingManager.o()     // Catch:{ all -> 0x0093 }
            r10.ddd(r7, r8)     // Catch:{ all -> 0x0093 }
            int r7 = r15.m145switch()     // Catch:{ all -> 0x0093 }
            if (r7 != r4) goto L_0x0077
            fe.fe.mmm.aaa r7 = fe.fe.mmm.aaa.o()     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = r15.ppp()     // Catch:{ all -> 0x0093 }
            r10 = 0
            java.lang.String r11 = r15.vvv()     // Catch:{ all -> 0x0093 }
            r7.ad(r8, r10, r11)     // Catch:{ all -> 0x0093 }
            goto L_0x0077
        L_0x0076:
            r5 = r0
        L_0x0077:
            r9.setTransactionSuccessful()     // Catch:{ all -> 0x0093 }
            r9.endTransaction()     // Catch:{ SQLException -> 0x009b }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            int r0 = r15.m145switch()
            if (r0 != r4) goto L_0x00cc
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00c3
            com.baidu.ubc.bypass.BypassConstants$Funnel r0 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_SUCCESS_EVENT
            goto L_0x00c5
        L_0x0093:
            r7 = move-exception
            goto L_0x0097
        L_0x0095:
            r7 = move-exception
            r5 = r0
        L_0x0097:
            r9.endTransaction()     // Catch:{ SQLException -> 0x009b }
            throw r7     // Catch:{ SQLException -> 0x009b }
        L_0x009b:
            r7 = move-exception
            goto L_0x00a4
        L_0x009d:
            r5 = move-exception
            r12 = r0
            r0 = r5
            r5 = r12
            goto L_0x00ce
        L_0x00a2:
            r7 = move-exception
            r5 = r0
        L_0x00a4:
            boolean r8 = f2015i     // Catch:{ all -> 0x00cd }
            if (r8 == 0) goto L_0x00ab
            r7.printStackTrace()     // Catch:{ all -> 0x00cd }
        L_0x00ab:
            fe.fe.mmm.fe r5 = r14.f2018ad     // Catch:{ all -> 0x009d }
            java.lang.String r6 = "write_"
            java.lang.String r8 = "saveEvent"
            r5.uk(r7, r6, r8)     // Catch:{ all -> 0x009d }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            int r0 = r15.m145switch()
            if (r0 != r4) goto L_0x00cc
        L_0x00c3:
            com.baidu.ubc.bypass.BypassConstants$Funnel r0 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_ERROR_EVENT
        L_0x00c5:
            long r1 = r15.mmm()
            fe.fe.mmm.n.qw.fe(r0, r1)
        L_0x00cc:
            return
        L_0x00cd:
            r0 = move-exception
        L_0x00ce:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r1.writeLock()
            r1.unlock()
            int r1 = r15.m145switch()
            if (r1 != r4) goto L_0x00ed
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x00e4
            com.baidu.ubc.bypass.BypassConstants$Funnel r1 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_SUCCESS_EVENT
            goto L_0x00e6
        L_0x00e4:
            com.baidu.ubc.bypass.BypassConstants$Funnel r1 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_ERROR_EVENT
        L_0x00e6:
            long r2 = r15.mmm()
            fe.fe.mmm.n.qw.fe(r1, r2)
        L_0x00ed:
            throw r0
        L_0x00ee:
            boolean r15 = f2015i
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.N(fe.fe.mmm.vvv):void");
    }

    public void O(List<vvv> list) {
        if (list == null || list.size() == 0) {
            boolean z = f2015i;
            return;
        }
        for (vvv N : list) {
            N(N);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A[Catch:{ JSONException -> 0x00f0, all -> 0x0126 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010f A[Catch:{ JSONException -> 0x00f0, all -> 0x0126 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void P(fe.fe.mmm.ddd r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x0152
            java.lang.String r0 = r8.ppp()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000e
            goto L_0x0152
        L_0x000e:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r7.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            android.database.sqlite.SQLiteDatabase r0 = r7.getWritableDatabase()     // Catch:{ SQLException -> 0x012d }
            r0.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x012d }
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch:{ all -> 0x0126 }
            r1.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = "flowid"
            java.lang.String r3 = r8.ppp()     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = "flowhandle"
            int r3 = r8.when()     // Catch:{ all -> 0x0126 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = "state"
            java.lang.String r3 = r8.xxx()     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = "begintime"
            long r3 = r8.rg()     // Catch:{ all -> 0x0126 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
            org.json.JSONObject r2 = r8.ggg()     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = "content"
            if (r2 == 0) goto L_0x0063
            org.json.JSONObject r2 = r8.ggg()     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0126 }
            r1.put(r3, r2)     // Catch:{ all -> 0x0126 }
            goto L_0x006a
        L_0x0063:
            java.lang.String r2 = r8.o()     // Catch:{ all -> 0x0126 }
            r1.put(r3, r2)     // Catch:{ all -> 0x0126 }
        L_0x006a:
            java.lang.String r2 = "option"
            int r3 = r8.vvv()     // Catch:{ all -> 0x0126 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = "reserve1"
            java.lang.String r3 = r8.m120switch()     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = r8.i()     // Catch:{ all -> 0x0126 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0126 }
            if (r2 != 0) goto L_0x0093
            java.lang.String r2 = "reserve2"
            java.lang.String r3 = r8.i()     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
        L_0x0093:
            java.lang.String r2 = r8.ddd()     // Catch:{ all -> 0x0126 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0126 }
            if (r2 != 0) goto L_0x00a6
            java.lang.String r2 = "uuid"
            java.lang.String r3 = r8.ddd()     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
        L_0x00a6:
            java.lang.String r2 = r8.fe()     // Catch:{ all -> 0x0126 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0126 }
            if (r2 != 0) goto L_0x00b9
            java.lang.String r2 = "appversion"
            java.lang.String r3 = r8.fe()     // Catch:{ all -> 0x0126 }
            r1.put(r2, r3)     // Catch:{ all -> 0x0126 }
        L_0x00b9:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0126 }
            r2.<init>()     // Catch:{ all -> 0x0126 }
            r3 = 1
            boolean r4 = r8.nn()     // Catch:{ JSONException -> 0x00f0 }
            r5 = 0
            if (r4 == 0) goto L_0x00ce
            java.lang.String r4 = "ctr"
            java.lang.String r6 = "1"
            r2.put(r4, r6)     // Catch:{ JSONException -> 0x00f0 }
            r3 = 0
        L_0x00ce:
            org.json.JSONObject r4 = r8.uk()     // Catch:{ JSONException -> 0x00f0 }
            if (r4 == 0) goto L_0x00e0
            int r6 = r4.length()     // Catch:{ JSONException -> 0x00f0 }
            if (r6 <= 0) goto L_0x00e0
            java.lang.String r6 = "bizparam"
            r2.put(r6, r4)     // Catch:{ JSONException -> 0x00f0 }
            r3 = 0
        L_0x00e0:
            java.lang.String r8 = r8.th()     // Catch:{ JSONException -> 0x00f0 }
            boolean r4 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x00f0 }
            if (r4 != 0) goto L_0x00f8
            java.lang.String r4 = "bizInfo"
            r2.put(r4, r8)     // Catch:{ JSONException -> 0x00f0 }
            goto L_0x00f9
        L_0x00f0:
            r8 = move-exception
            boolean r4 = f2015i     // Catch:{ all -> 0x0126 }
            if (r4 == 0) goto L_0x00f8
            r8.printStackTrace()     // Catch:{ all -> 0x0126 }
        L_0x00f8:
            r5 = r3
        L_0x00f9:
            if (r5 != 0) goto L_0x0104
            java.lang.String r8 = "extend"
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0126 }
            r1.put(r8, r2)     // Catch:{ all -> 0x0126 }
        L_0x0104:
            java.lang.String r8 = "flow"
            r2 = 0
            long r1 = r0.insert(r8, r2, r1)     // Catch:{ all -> 0x0126 }
            boolean r8 = f2015i     // Catch:{ all -> 0x0126 }
            if (r8 == 0) goto L_0x011f
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r8.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r3 = "saveFlow#performTransaction: rowId="
            r8.append(r3)     // Catch:{ all -> 0x0126 }
            r8.append(r1)     // Catch:{ all -> 0x0126 }
            r8.toString()     // Catch:{ all -> 0x0126 }
        L_0x011f:
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0126 }
            r0.endTransaction()     // Catch:{ SQLException -> 0x012d }
            goto L_0x013e
        L_0x0126:
            r8 = move-exception
            r0.endTransaction()     // Catch:{ SQLException -> 0x012d }
            throw r8     // Catch:{ SQLException -> 0x012d }
        L_0x012b:
            r8 = move-exception
            goto L_0x0148
        L_0x012d:
            r8 = move-exception
            boolean r0 = f2015i     // Catch:{ all -> 0x012b }
            if (r0 == 0) goto L_0x0135
            r8.printStackTrace()     // Catch:{ all -> 0x012b }
        L_0x0135:
            fe.fe.mmm.fe r0 = r7.f2018ad     // Catch:{ all -> 0x012b }
            java.lang.String r1 = "write_"
            java.lang.String r2 = "saveFlow"
            r0.uk(r8, r1, r2)     // Catch:{ all -> 0x012b }
        L_0x013e:
            java.util.concurrent.locks.ReentrantReadWriteLock r8 = r7.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r8 = r8.writeLock()
            r8.unlock()
            return
        L_0x0148:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r7.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            throw r8
        L_0x0152:
            boolean r8 = f2015i
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.P(fe.fe.mmm.ddd):void");
    }

    public void Q() {
        SQLiteDatabase writableDatabase;
        this.f2020uk.writeLock().lock();
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            ContentValues contentValues = new ContentValues();
            contentValues.put(WXLoginActivity.w, "1");
            int update = writableDatabase.update("file", contentValues, (String) null, (String[]) null);
            if (f2015i) {
                "updateAllSentFileFail#performTransaction: update file table:" + update;
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e) {
            try {
                if (f2015i) {
                    e.printStackTrace();
                }
                this.f2018ad.uk(e, "write_", "updateAllSentFileFail");
            } catch (Throwable th2) {
                this.f2020uk.writeLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            throw th3;
        }
        this.f2020uk.writeLock().unlock();
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:77:0x01f2=Splitter:B:77:0x01f2, B:87:0x0209=Splitter:B:87:0x0209} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean R(java.util.List<fe.fe.mmm.Cswitch> r15) {
        /*
            r14 = this;
            java.lang.String r0 = ","
            r1 = 0
            if (r15 == 0) goto L_0x0238
            int r2 = r15.size()
            if (r2 != 0) goto L_0x000d
            goto L_0x0238
        L_0x000d:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.lock()
            android.database.sqlite.SQLiteDatabase r2 = r14.getWritableDatabase()     // Catch:{ SQLException -> 0x0213 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0213 }
            r3.<init>()     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "replace into "
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "config"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "("
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "eventid"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "type"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "recordrule"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "uploadrule"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "cycle"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "switch"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "sample"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "reserve1"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "reserve2"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r4 = "extend"
            r3.append(r4)     // Catch:{ SQLException -> 0x0213 }
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r0 = "reallog"
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r0 = ")"
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r0 = " values(?,?,?,?,?,?,?,?,?,?,?)"
            r3.append(r0)     // Catch:{ SQLException -> 0x0213 }
            java.lang.String r0 = r3.toString()     // Catch:{ SQLException -> 0x0213 }
            android.database.sqlite.SQLiteStatement r0 = r2.compileStatement(r0)     // Catch:{ SQLException -> 0x0213 }
            r2.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x0213 }
            java.util.Iterator r3 = r15.iterator()     // Catch:{ JSONException -> 0x0201 }
        L_0x009c:
            boolean r4 = r3.hasNext()     // Catch:{ JSONException -> 0x0201 }
            r5 = 1
            if (r4 == 0) goto L_0x01d7
            java.lang.Object r4 = r3.next()     // Catch:{ JSONException -> 0x0201 }
            fe.fe.mmm.switch r4 = (fe.fe.mmm.Cswitch) r4     // Catch:{ JSONException -> 0x0201 }
            r0.clearBindings()     // Catch:{ JSONException -> 0x0201 }
            java.lang.String r6 = r4.fe()     // Catch:{ JSONException -> 0x0201 }
            r0.bindString(r5, r6)     // Catch:{ JSONException -> 0x0201 }
            int r6 = r4.o()     // Catch:{ JSONException -> 0x0201 }
            r7 = 2
            java.lang.String r8 = "0"
            java.lang.String r9 = "1"
            if (r6 != r5) goto L_0x00c2
            r0.bindString(r7, r9)     // Catch:{ JSONException -> 0x0201 }
            goto L_0x00c5
        L_0x00c2:
            r0.bindString(r7, r8)     // Catch:{ JSONException -> 0x0201 }
        L_0x00c5:
            int r5 = r4.th()     // Catch:{ JSONException -> 0x0201 }
            int r6 = r4.rg()     // Catch:{ JSONException -> 0x0201 }
            if (r5 == 0) goto L_0x00db
            if (r6 == 0) goto L_0x00db
            r10 = 3
            long r11 = (long) r5     // Catch:{ JSONException -> 0x0201 }
            r0.bindLong(r10, r11)     // Catch:{ JSONException -> 0x0201 }
            r5 = 4
            long r10 = (long) r6     // Catch:{ JSONException -> 0x0201 }
            r0.bindLong(r5, r10)     // Catch:{ JSONException -> 0x0201 }
        L_0x00db:
            boolean r5 = r4.vvv()     // Catch:{ JSONException -> 0x0201 }
            r10 = 0
            r6 = 5
            if (r5 == 0) goto L_0x00e8
            r0.bindLong(r6, r10)     // Catch:{ JSONException -> 0x0201 }
            goto L_0x00f0
        L_0x00e8:
            int r5 = r4.i()     // Catch:{ JSONException -> 0x0201 }
            long r12 = (long) r5     // Catch:{ JSONException -> 0x0201 }
            r0.bindLong(r6, r12)     // Catch:{ JSONException -> 0x0201 }
        L_0x00f0:
            boolean r5 = r4.mmm()     // Catch:{ JSONException -> 0x0201 }
            r6 = 6
            if (r5 == 0) goto L_0x00fb
            r0.bindString(r6, r9)     // Catch:{ JSONException -> 0x0201 }
            goto L_0x00fe
        L_0x00fb:
            r0.bindString(r6, r8)     // Catch:{ JSONException -> 0x0201 }
        L_0x00fe:
            r5 = 7
            int r6 = r4.uk()     // Catch:{ JSONException -> 0x0201 }
            long r12 = (long) r6     // Catch:{ JSONException -> 0x0201 }
            r0.bindLong(r5, r12)     // Catch:{ JSONException -> 0x0201 }
            boolean r5 = r4.m139switch()     // Catch:{ JSONException -> 0x0201 }
            r6 = 8
            if (r5 == 0) goto L_0x0113
            r0.bindString(r6, r9)     // Catch:{ JSONException -> 0x0201 }
            goto L_0x0116
        L_0x0113:
            r0.bindString(r6, r8)     // Catch:{ JSONException -> 0x0201 }
        L_0x0116:
            java.lang.String r5 = r4.ad()     // Catch:{ JSONException -> 0x0201 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0201 }
            if (r6 != 0) goto L_0x0125
            r6 = 9
            r0.bindString(r6, r5)     // Catch:{ JSONException -> 0x0201 }
        L_0x0125:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0201 }
            r5.<init>()     // Catch:{ JSONException -> 0x0201 }
            boolean r6 = r4.ppp()     // Catch:{ JSONException -> 0x0201 }
            if (r6 == 0) goto L_0x0135
            java.lang.String r6 = "idtype"
            r5.put(r6, r9)     // Catch:{ JSONException -> 0x0201 }
        L_0x0135:
            boolean r6 = r4.ggg()     // Catch:{ JSONException -> 0x0201 }
            if (r6 == 0) goto L_0x0140
            java.lang.String r6 = "ch"
            r5.put(r6, r9)     // Catch:{ JSONException -> 0x0201 }
        L_0x0140:
            boolean r6 = r4.when()     // Catch:{ JSONException -> 0x0201 }
            if (r6 == 0) goto L_0x014b
            java.lang.String r6 = "dfc"
            r5.put(r6, r9)     // Catch:{ JSONException -> 0x0201 }
        L_0x014b:
            java.lang.String r6 = "version"
            java.lang.String r12 = r4.m138if()     // Catch:{ JSONException -> 0x0201 }
            r5.put(r6, r12)     // Catch:{ JSONException -> 0x0201 }
            int r6 = r4.de()     // Catch:{ JSONException -> 0x0201 }
            boolean r12 = r4.nn()     // Catch:{ JSONException -> 0x0201 }
            if (r12 == 0) goto L_0x0167
            java.lang.String r12 = "gflow"
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ JSONException -> 0x0201 }
            r5.put(r12, r6)     // Catch:{ JSONException -> 0x0201 }
        L_0x0167:
            boolean r6 = r4.aaa()     // Catch:{ JSONException -> 0x0201 }
            if (r6 != 0) goto L_0x017a
            java.lang.String r6 = "uploadType"
            int r12 = r4.pf()     // Catch:{ JSONException -> 0x0201 }
            java.lang.String r12 = java.lang.Integer.toString(r12)     // Catch:{ JSONException -> 0x0201 }
            r5.put(r6, r12)     // Catch:{ JSONException -> 0x0201 }
        L_0x017a:
            int r6 = r4.yj()     // Catch:{ JSONException -> 0x0201 }
            if (r6 == r7) goto L_0x0185
            java.lang.String r7 = "lcache"
            r5.put(r7, r6)     // Catch:{ JSONException -> 0x0201 }
        L_0x0185:
            java.lang.String r6 = r4.fe()     // Catch:{ JSONException -> 0x0201 }
            boolean r6 = fe.fe.mmm.ggg.qw(r6)     // Catch:{ JSONException -> 0x0201 }
            if (r6 == 0) goto L_0x0198
            java.lang.String r6 = "isSend"
            boolean r7 = r4.ddd()     // Catch:{ JSONException -> 0x0201 }
            r5.put(r6, r7)     // Catch:{ JSONException -> 0x0201 }
        L_0x0198:
            org.json.JSONArray r6 = r4.qw()     // Catch:{ JSONException -> 0x0201 }
            if (r6 == 0) goto L_0x01a9
            int r7 = r6.length()     // Catch:{ JSONException -> 0x0201 }
            if (r7 <= 0) goto L_0x01a9
            java.lang.String r7 = "bizparam"
            r5.put(r7, r6)     // Catch:{ JSONException -> 0x0201 }
        L_0x01a9:
            r6 = 10
            java.lang.String r5 = r5.toString()     // Catch:{ JSONException -> 0x0201 }
            r0.bindString(r6, r5)     // Catch:{ JSONException -> 0x0201 }
            boolean r4 = r4.xxx()     // Catch:{ JSONException -> 0x0201 }
            r5 = 11
            if (r4 == 0) goto L_0x01be
            r0.bindString(r5, r9)     // Catch:{ JSONException -> 0x0201 }
            goto L_0x01c1
        L_0x01be:
            r0.bindString(r5, r8)     // Catch:{ JSONException -> 0x0201 }
        L_0x01c1:
            int r4 = r0.executeUpdateDelete()     // Catch:{ JSONException -> 0x0201 }
            long r4 = (long) r4
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 > 0) goto L_0x009c
            r2.endTransaction()     // Catch:{ SQLException -> 0x0213 }
            java.util.concurrent.locks.ReentrantReadWriteLock r15 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r15 = r15.writeLock()
            r15.unlock()
            return r1
        L_0x01d7:
            r2.setTransactionSuccessful()     // Catch:{ JSONException -> 0x0201 }
            boolean r0 = f2015i     // Catch:{ JSONException -> 0x0201 }
            if (r0 == 0) goto L_0x01f2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0201 }
            r0.<init>()     // Catch:{ JSONException -> 0x0201 }
            java.lang.String r3 = "updateConfig success count: "
            r0.append(r3)     // Catch:{ JSONException -> 0x0201 }
            int r15 = r15.size()     // Catch:{ JSONException -> 0x0201 }
            r0.append(r15)     // Catch:{ JSONException -> 0x0201 }
            r0.toString()     // Catch:{ JSONException -> 0x0201 }
        L_0x01f2:
            r2.endTransaction()     // Catch:{ SQLException -> 0x0213 }
            java.util.concurrent.locks.ReentrantReadWriteLock r15 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r15 = r15.writeLock()
            r15.unlock()
            return r5
        L_0x01ff:
            r15 = move-exception
            goto L_0x020d
        L_0x0201:
            r15 = move-exception
            boolean r0 = f2015i     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x0209
            r15.printStackTrace()     // Catch:{ all -> 0x01ff }
        L_0x0209:
            r2.endTransaction()     // Catch:{ SQLException -> 0x0213 }
            goto L_0x0224
        L_0x020d:
            r2.endTransaction()     // Catch:{ SQLException -> 0x0213 }
            throw r15     // Catch:{ SQLException -> 0x0213 }
        L_0x0211:
            r15 = move-exception
            goto L_0x022e
        L_0x0213:
            r15 = move-exception
            boolean r0 = f2015i     // Catch:{ all -> 0x0211 }
            if (r0 == 0) goto L_0x021b
            r15.printStackTrace()     // Catch:{ all -> 0x0211 }
        L_0x021b:
            fe.fe.mmm.fe r0 = r14.f2018ad     // Catch:{ all -> 0x0211 }
            java.lang.String r2 = "write_"
            java.lang.String r3 = "updateConfigList"
            r0.uk(r15, r2, r3)     // Catch:{ all -> 0x0211 }
        L_0x0224:
            java.util.concurrent.locks.ReentrantReadWriteLock r15 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r15 = r15.writeLock()
            r15.unlock()
            return r1
        L_0x022e:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r14.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            throw r15
        L_0x0238:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.R(java.util.List):boolean");
    }

    public void S(String str, int i2, String str2) {
        SQLiteDatabase writableDatabase;
        if (i2 < 0 || TextUtils.isEmpty(str)) {
            boolean z = f2015i;
            return;
        }
        this.f2020uk.writeLock().lock();
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", str2);
            int update = writableDatabase.update("flow", contentValues, "flowid" + "=\"" + str + "\"" + " AND " + "flowhandle" + " = " + i2, (String[]) null);
            if (f2015i && update != 1) {
                "updateFlowValue#performTransaction: updateFlowValue count:" + update;
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e) {
            try {
                if (f2015i) {
                    e.printStackTrace();
                }
                this.f2018ad.uk(e, "write_", "updateFlowValue");
            } catch (Throwable th2) {
                this.f2020uk.writeLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            throw th3;
        }
        this.f2020uk.writeLock().unlock();
    }

    public void T(String str) {
        SQLiteDatabase writableDatabase;
        this.f2020uk.writeLock().lock();
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            ContentValues contentValues = new ContentValues();
            contentValues.put(WXLoginActivity.w, "1");
            int update = writableDatabase.update("file", contentValues, "filename" + "=\"" + str + "\"", (String[]) null);
            if (f2015i) {
                "updateSendedFileFail#performTransaction: update file table:" + update;
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e) {
            try {
                if (f2015i) {
                    e.printStackTrace();
                }
                this.f2018ad.uk(e, "write_", "updateSendFileFail");
            } catch (Throwable th2) {
                this.f2020uk.writeLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            throw th3;
        }
        this.f2020uk.writeLock().unlock();
    }

    public boolean U(String str, String str2, int i2) {
        SQLiteDatabase writableDatabase;
        this.f2020uk.writeLock().lock();
        boolean z = false;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            ContentValues contentValues = new ContentValues();
            contentValues.put(WXLoginActivity.w, str2);
            contentValues.put("uploadindex", Integer.valueOf(i2));
            int update = writableDatabase.update("file", contentValues, "filename" + "=\"" + str + "\"" + " AND " + WXLoginActivity.w + " != '" + str2 + "'", (String[]) null);
            if (f2015i) {
                "optUpdateSendFileState#update uploadCount = " + i2;
                "optUpdateSendFileState#update file: count = " + update;
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            if (update > 0) {
                z = true;
            }
            this.f2020uk.writeLock().unlock();
            return z;
        } catch (SQLException e) {
            try {
                if (f2015i) {
                    e.printStackTrace();
                }
                this.f2018ad.uk(e, "write_", "updateSendFileState");
                return false;
            } finally {
                this.f2020uk.writeLock().unlock();
            }
        } catch (Throwable th2) {
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v36, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v37, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v38, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v39, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v40, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0183, code lost:
        if (r6.size() > 0) goto L_0x0185;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02ce A[Catch:{ SQLException -> 0x0323, all -> 0x0320 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02fe A[Catch:{ SQLException -> 0x0323, all -> 0x0320 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0300 A[Catch:{ SQLException -> 0x0323, all -> 0x0320 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0307 A[Catch:{ SQLException -> 0x0323, all -> 0x0320 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0309 A[Catch:{ SQLException -> 0x0323, all -> 0x0320 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0314 A[Catch:{ SQLException -> 0x0323, all -> 0x0320 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0334 A[Catch:{ all -> 0x03bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x033b A[Catch:{ all -> 0x03bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0377 A[Catch:{ all -> 0x03bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fe A[Catch:{ all -> 0x00d2, all -> 0x0158 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016a A[SYNTHETIC, Splitter:B:50:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017f A[Catch:{ all -> 0x0171 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0215 A[SYNTHETIC, Splitter:B:76:0x0215] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0254 A[Catch:{ SQLException -> 0x02b4, all -> 0x02ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0257 A[Catch:{ SQLException -> 0x02b4, all -> 0x02ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x025f A[Catch:{ SQLException -> 0x02b4, all -> 0x02ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0262 A[Catch:{ SQLException -> 0x02b4, all -> 0x02ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x026e A[SYNTHETIC, Splitter:B:96:0x026e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(fe.fe.mmm.l r28, java.lang.String r29) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.String r0 = "0"
            java.lang.String r4 = "result:"
            android.util.SparseArray r5 = r28.nn()
            java.util.ArrayList r6 = r28.xxx()
            java.util.ArrayList r7 = r28.ddd()
            boolean r8 = r28.l()
            java.util.concurrent.locks.ReentrantReadWriteLock r9 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r9 = r9.writeLock()
            r9.lock()
            android.database.sqlite.SQLiteDatabase r11 = r27.getWritableDatabase()     // Catch:{ SQLException -> 0x032c, all -> 0x0326 }
            r11.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x032c, all -> 0x0326 }
            java.lang.String r12 = "event"
            java.lang.String r13 = " ; checkpoint : "
            java.lang.String r14 = ")"
            java.lang.String r15 = "flowhandle"
            java.lang.String r10 = "wal sync : "
            java.lang.String r9 = " in ("
            r16 = r4
            if (r5 == 0) goto L_0x00ef
            int r17 = r5.size()     // Catch:{ all -> 0x00e5 }
            if (r17 <= 0) goto L_0x00ef
            int r4 = r5.size()     // Catch:{ all -> 0x00e5 }
            r18 = r13
            java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ all -> 0x00db }
            r13.<init>(r4)     // Catch:{ all -> 0x00db }
            r19 = r10
            r10 = 0
        L_0x004e:
            if (r10 >= r4) goto L_0x0062
            int r20 = r5.keyAt(r10)     // Catch:{ all -> 0x00d2 }
            r21 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r20)     // Catch:{ all -> 0x00d2 }
            r13.add(r4)     // Catch:{ all -> 0x00d2 }
            int r10 = r10 + 1
            r4 = r21
            goto L_0x004e
        L_0x0062:
            java.lang.String r4 = r1.C(r13)     // Catch:{ all -> 0x00d2 }
            boolean r10 = f2015i     // Catch:{ all -> 0x00d2 }
            if (r10 == 0) goto L_0x0082
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r10.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r13 = "save file name "
            r10.append(r13)     // Catch:{ all -> 0x00d2 }
            r10.append(r3)     // Catch:{ all -> 0x00d2 }
            java.lang.String r13 = " delete flow handle ids = "
            r10.append(r13)     // Catch:{ all -> 0x00d2 }
            r10.append(r4)     // Catch:{ all -> 0x00d2 }
            r10.toString()     // Catch:{ all -> 0x00d2 }
        L_0x0082:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r10.<init>()     // Catch:{ all -> 0x00d2 }
            r10.append(r15)     // Catch:{ all -> 0x00d2 }
            r10.append(r9)     // Catch:{ all -> 0x00d2 }
            r10.append(r4)     // Catch:{ all -> 0x00d2 }
            r10.append(r14)     // Catch:{ all -> 0x00d2 }
            java.lang.String r4 = "flow"
            java.lang.String r13 = r10.toString()     // Catch:{ all -> 0x00d2 }
            r20 = r8
            r8 = 0
            int r4 = r11.delete(r4, r13, r8)     // Catch:{ all -> 0x00d2 }
            boolean r8 = f2015i     // Catch:{ all -> 0x00d2 }
            if (r8 == 0) goto L_0x00b4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            r8.<init>()     // Catch:{ all -> 0x00d2 }
            java.lang.String r13 = "clearUploadedData#performTransaction: flow table delete count:"
            r8.append(r13)     // Catch:{ all -> 0x00d2 }
            r8.append(r4)     // Catch:{ all -> 0x00d2 }
            r8.toString()     // Catch:{ all -> 0x00d2 }
        L_0x00b4:
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x0158 }
            r10 = 0
            int r8 = r11.delete(r12, r8, r10)     // Catch:{ all -> 0x0158 }
            boolean r10 = f2015i     // Catch:{ all -> 0x0158 }
            if (r10 == 0) goto L_0x00f6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
            r10.<init>()     // Catch:{ all -> 0x0158 }
            java.lang.String r13 = "clearUploadedData#performTransaction:  delete flow -> event table count:"
            r10.append(r13)     // Catch:{ all -> 0x0158 }
            r10.append(r8)     // Catch:{ all -> 0x0158 }
            r10.toString()     // Catch:{ all -> 0x0158 }
            goto L_0x00f6
        L_0x00d2:
            r0 = move-exception
            r13 = r0
            r6 = r16
            r9 = r18
            r8 = r19
            goto L_0x00e2
        L_0x00db:
            r0 = move-exception
            r13 = r0
            r8 = r10
            r6 = r16
            r9 = r18
        L_0x00e2:
            r0 = 0
            goto L_0x0161
        L_0x00e5:
            r0 = move-exception
            r8 = r10
            r9 = r13
            r6 = r16
            r4 = 0
            r13 = r0
            r0 = 0
            goto L_0x02c5
        L_0x00ef:
            r20 = r8
            r19 = r10
            r18 = r13
            r4 = 0
        L_0x00f6:
            if (r6 == 0) goto L_0x0164
            int r8 = r6.size()     // Catch:{ all -> 0x0158 }
            if (r8 <= 0) goto L_0x0164
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
            r8.<init>()     // Catch:{ all -> 0x0158 }
            java.lang.String r7 = r1.C(r7)     // Catch:{ all -> 0x0158 }
            boolean r10 = f2015i     // Catch:{ all -> 0x0158 }
            if (r10 == 0) goto L_0x011b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
            r10.<init>()     // Catch:{ all -> 0x0158 }
            java.lang.String r13 = "delete event rowIds = "
            r10.append(r13)     // Catch:{ all -> 0x0158 }
            r10.append(r7)     // Catch:{ all -> 0x0158 }
            r10.toString()     // Catch:{ all -> 0x0158 }
        L_0x011b:
            java.lang.String r10 = "_id"
            r8.append(r10)     // Catch:{ all -> 0x0158 }
            r8.append(r9)     // Catch:{ all -> 0x0158 }
            r8.append(r7)     // Catch:{ all -> 0x0158 }
            r8.append(r14)     // Catch:{ all -> 0x0158 }
            java.lang.String r7 = " AND "
            r8.append(r7)     // Catch:{ all -> 0x0158 }
            r8.append(r15)     // Catch:{ all -> 0x0158 }
            java.lang.String r7 = " = "
            r8.append(r7)     // Catch:{ all -> 0x0158 }
            r7 = -1
            r8.append(r7)     // Catch:{ all -> 0x0158 }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x0158 }
            r8 = 0
            int r7 = r11.delete(r12, r7, r8)     // Catch:{ all -> 0x0158 }
            boolean r8 = f2015i     // Catch:{ all -> 0x0158 }
            if (r8 == 0) goto L_0x0165
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0158 }
            r8.<init>()     // Catch:{ all -> 0x0158 }
            java.lang.String r9 = "clearUploadedData#performTransaction: event table count2:"
            r8.append(r9)     // Catch:{ all -> 0x0158 }
            r8.append(r7)     // Catch:{ all -> 0x0158 }
            r8.toString()     // Catch:{ all -> 0x0158 }
            goto L_0x0165
        L_0x0158:
            r0 = move-exception
            r13 = r0
            r0 = r4
            r6 = r16
            r9 = r18
            r8 = r19
        L_0x0161:
            r4 = 0
            goto L_0x02c5
        L_0x0164:
            r7 = 0
        L_0x0165:
            r1.b(r11, r2)     // Catch:{ all -> 0x02bb }
            if (r5 == 0) goto L_0x017d
            int r8 = r5.size()     // Catch:{ all -> 0x0171 }
            if (r8 > 0) goto L_0x0185
            goto L_0x017d
        L_0x0171:
            r0 = move-exception
            r13 = r0
            r0 = r4
            r4 = r7
            r6 = r16
            r9 = r18
            r8 = r19
            goto L_0x02c5
        L_0x017d:
            if (r6 == 0) goto L_0x0209
            int r6 = r6.size()     // Catch:{ all -> 0x0171 }
            if (r6 <= 0) goto L_0x0209
        L_0x0185:
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ all -> 0x0171 }
            r6.<init>()     // Catch:{ all -> 0x0171 }
            java.lang.String r8 = "filename"
            r6.put(r8, r3)     // Catch:{ all -> 0x0171 }
            java.lang.String r8 = "state"
            r6.put(r8, r0)     // Catch:{ all -> 0x0171 }
            java.lang.String r8 = "reserve1"
            if (r20 == 0) goto L_0x019a
            java.lang.String r0 = "1"
        L_0x019a:
            r6.put(r8, r0)     // Catch:{ all -> 0x0171 }
            java.lang.String r0 = "uploadfirst"
            long r8 = r28.c()     // Catch:{ all -> 0x0171 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0171 }
            r6.put(r0, r8)     // Catch:{ all -> 0x0171 }
            java.lang.String r0 = "uploadindex"
            int r8 = r28.d()     // Catch:{ all -> 0x0171 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0171 }
            r6.put(r0, r8)     // Catch:{ all -> 0x0171 }
            boolean r0 = r28.g()     // Catch:{ all -> 0x0171 }
            if (r0 == 0) goto L_0x01cc
            java.lang.String r0 = r27.z(r28)     // Catch:{ all -> 0x0171 }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0171 }
            if (r8 != 0) goto L_0x01cc
            java.lang.String r8 = "reserve2"
            r6.put(r8, r0)     // Catch:{ all -> 0x0171 }
        L_0x01cc:
            java.lang.String r0 = "file"
            r8 = 0
            long r8 = r11.insert(r0, r8, r6)     // Catch:{ all -> 0x0171 }
            boolean r0 = f2015i     // Catch:{ all -> 0x0171 }
            if (r0 == 0) goto L_0x01e7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
            r0.<init>()     // Catch:{ all -> 0x0171 }
            java.lang.String r6 = "clearUploadedData#save file: rowId="
            r0.append(r6)     // Catch:{ all -> 0x0171 }
            r0.append(r8)     // Catch:{ all -> 0x0171 }
            r0.toString()     // Catch:{ all -> 0x0171 }
        L_0x01e7:
            java.util.ArrayList r0 = r28.mmm()     // Catch:{ all -> 0x0171 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0171 }
            r6.<init>()     // Catch:{ all -> 0x0171 }
            java.lang.String r8 = "dec:"
            r6.append(r8)     // Catch:{ all -> 0x0171 }
            r6.append(r7)     // Catch:{ all -> 0x0171 }
            java.lang.String r8 = " dfc:"
            r6.append(r8)     // Catch:{ all -> 0x0171 }
            r6.append(r4)     // Catch:{ all -> 0x0171 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0171 }
            com.baidu.ubc.constants.EnumConstants$RunTime r8 = com.baidu.ubc.constants.EnumConstants$RunTime.FILE_SAVE_DELETE_DB     // Catch:{ all -> 0x0171 }
            fe.fe.mmm.m.pf(r0, r3, r6, r8)     // Catch:{ all -> 0x0171 }
        L_0x0209:
            r11.setTransactionSuccessful()     // Catch:{ all -> 0x02bb }
            r11.endTransaction()     // Catch:{ SQLException -> 0x02b4, all -> 0x02ad }
            boolean r0 = r27.M()     // Catch:{ SQLException -> 0x02b4, all -> 0x02ad }
            if (r0 == 0) goto L_0x0247
            java.lang.String r0 = r1.qqq(r11)     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            boolean r6 = f2015i     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            if (r6 == 0) goto L_0x0237
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            r6.<init>()     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            r8 = r19
            r6.append(r8)     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            java.lang.String r8 = r1.f2021yj     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            r6.append(r8)     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            r9 = r18
            r6.append(r9)     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            r6.append(r0)     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            r6.toString()     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
        L_0x0237:
            com.baidu.ubc.constants.EnumConstants$RunTime r6 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_CHECK_POINT     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            fe.fe.mmm.m.m128switch(r0, r6)     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            goto L_0x0247
        L_0x023d:
            r0 = move-exception
            r6 = r16
            goto L_0x02b1
        L_0x0242:
            r0 = move-exception
            r6 = r16
            goto L_0x02b8
        L_0x0247:
            com.baidu.ubc.UBCUploadTimingManager r0 = com.baidu.ubc.UBCUploadTimingManager.o()     // Catch:{ SQLException -> 0x02b4, all -> 0x02ad }
            r0.when(r7, r4)     // Catch:{ SQLException -> 0x02b4, all -> 0x02ad }
            java.util.ArrayList r0 = r28.ddd()     // Catch:{ SQLException -> 0x02b4, all -> 0x02ad }
            if (r5 != 0) goto L_0x0257
            r25 = 0
            goto L_0x025d
        L_0x0257:
            int r5 = r5.size()     // Catch:{ SQLException -> 0x02b4, all -> 0x02ad }
            r25 = r5
        L_0x025d:
            if (r0 != 0) goto L_0x0262
            r24 = 0
            goto L_0x0268
        L_0x0262:
            int r0 = r0.size()     // Catch:{ SQLException -> 0x02b4, all -> 0x02ad }
            r24 = r0
        L_0x0268:
            int r0 = r7 + r4
            int r5 = r25 + r24
            if (r0 >= r5) goto L_0x027b
            fe.fe.mmm.c r21 = fe.fe.mmm.c.de()     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
            java.lang.String r26 = "deleteDataBySaveFile"
            r22 = r7
            r23 = r4
            r21.uk(r22, r23, r24, r25, r26)     // Catch:{ SQLException -> 0x0242, all -> 0x023d }
        L_0x027b:
            com.baidu.ubc.database.UBCDatabaseErrorHandler r0 = com.baidu.ubc.database.UBCDatabaseErrorHandler.qw()
            r4 = 1
            r0.de(r4)
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            r5 = 0
            r2.fe(r5, r7)
            java.util.ArrayList r0 = r28.mmm()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r6 = r16
            r2.append(r6)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r5 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_UPLOADED_DATA
            fe.fe.mmm.m.pf(r0, r3, r2, r5)
            r9 = 1
            goto L_0x03ba
        L_0x02ad:
            r0 = move-exception
            r6 = r16
            r4 = 1
        L_0x02b1:
            r9 = 1
            goto L_0x03bc
        L_0x02b4:
            r0 = move-exception
            r6 = r16
            r4 = 1
        L_0x02b8:
            r9 = 1
            goto L_0x0330
        L_0x02bb:
            r0 = move-exception
            r6 = r16
            r9 = r18
            r8 = r19
            r13 = r0
            r0 = r4
            r4 = r7
        L_0x02c5:
            r11.endTransaction()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            boolean r7 = r27.M()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            if (r7 == 0) goto L_0x02f1
            java.lang.String r7 = r1.qqq(r11)     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            boolean r10 = f2015i     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            if (r10 == 0) goto L_0x02ec
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r10.<init>()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r10.append(r8)     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            java.lang.String r8 = r1.f2021yj     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r10.append(r8)     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r10.append(r9)     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r10.append(r7)     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r10.toString()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
        L_0x02ec:
            com.baidu.ubc.constants.EnumConstants$RunTime r8 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_CHECK_POINT     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            fe.fe.mmm.m.m128switch(r7, r8)     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
        L_0x02f1:
            com.baidu.ubc.UBCUploadTimingManager r7 = com.baidu.ubc.UBCUploadTimingManager.o()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r7.when(r4, r0)     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            java.util.ArrayList r7 = r28.ddd()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            if (r5 != 0) goto L_0x0300
            r11 = 0
            goto L_0x0305
        L_0x0300:
            int r5 = r5.size()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r11 = r5
        L_0x0305:
            if (r7 != 0) goto L_0x0309
            r10 = 0
            goto L_0x030e
        L_0x0309:
            int r5 = r7.size()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            r10 = r5
        L_0x030e:
            int r5 = r4 + r0
            int r7 = r11 + r10
            if (r5 >= r7) goto L_0x031f
            fe.fe.mmm.c r7 = fe.fe.mmm.c.de()     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
            java.lang.String r12 = "deleteDataBySaveFile"
            r8 = r4
            r9 = r0
            r7.uk(r8, r9, r10, r11, r12)     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
        L_0x031f:
            throw r13     // Catch:{ SQLException -> 0x0323, all -> 0x0320 }
        L_0x0320:
            r0 = move-exception
            r7 = r4
            goto L_0x0329
        L_0x0323:
            r0 = move-exception
            r7 = r4
            goto L_0x032f
        L_0x0326:
            r0 = move-exception
            r6 = r4
            r7 = 0
        L_0x0329:
            r9 = 0
            goto L_0x03bc
        L_0x032c:
            r0 = move-exception
            r6 = r4
            r7 = 0
        L_0x032f:
            r9 = 0
        L_0x0330:
            boolean r4 = f2015i     // Catch:{ all -> 0x03bb }
            if (r4 == 0) goto L_0x0337
            r0.printStackTrace()     // Catch:{ all -> 0x03bb }
        L_0x0337:
            boolean r4 = r0 instanceof android.database.sqlite.SQLiteDatabaseCorruptException     // Catch:{ all -> 0x03bb }
            if (r4 == 0) goto L_0x0377
            boolean r4 = f2015i     // Catch:{ all -> 0x03bb }
            if (r4 == 0) goto L_0x0353
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03bb }
            r4.<init>()     // Catch:{ all -> 0x03bb }
            java.lang.String r5 = "CorruptException db : "
            r4.append(r5)     // Catch:{ all -> 0x03bb }
            java.lang.String r5 = r0.getMessage()     // Catch:{ all -> 0x03bb }
            r4.append(r5)     // Catch:{ all -> 0x03bb }
            r4.toString()     // Catch:{ all -> 0x03bb }
        L_0x0353:
            fe.fe.mmm.c r4 = fe.fe.mmm.c.de()     // Catch:{ all -> 0x03bb }
            java.lang.String r5 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x03bb }
            r4.rg(r5)     // Catch:{ all -> 0x03bb }
            java.util.ArrayList r4 = r28.mmm()     // Catch:{ all -> 0x03bb }
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x03bb }
            com.baidu.ubc.constants.EnumConstants$RunTime r5 = com.baidu.ubc.constants.EnumConstants$RunTime.DB_CORRUPT     // Catch:{ all -> 0x03bb }
            fe.fe.mmm.m.pf(r4, r3, r0, r5)     // Catch:{ all -> 0x03bb }
            com.baidu.ubc.database.UBCDatabaseErrorHandler r0 = com.baidu.ubc.database.UBCDatabaseErrorHandler.qw()     // Catch:{ all -> 0x03bb }
            android.database.sqlite.SQLiteDatabase r4 = r27.getWritableDatabase()     // Catch:{ all -> 0x03bb }
            r0.ad(r4)     // Catch:{ all -> 0x03bb }
            goto L_0x038d
        L_0x0377:
            fe.fe.mmm.fe r4 = r1.f2018ad     // Catch:{ all -> 0x03bb }
            java.lang.String r5 = "write_"
            java.lang.String r8 = "clearUploadedData"
            r4.uk(r0, r5, r8)     // Catch:{ all -> 0x03bb }
            java.util.ArrayList r4 = r28.mmm()     // Catch:{ all -> 0x03bb }
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ all -> 0x03bb }
            com.baidu.ubc.constants.EnumConstants$RunTime r5 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_UPLOADED_DATA_SQL_ERROR     // Catch:{ all -> 0x03bb }
            fe.fe.mmm.m.pf(r4, r3, r0, r5)     // Catch:{ all -> 0x03bb }
        L_0x038d:
            com.baidu.ubc.database.UBCDatabaseErrorHandler r0 = com.baidu.ubc.database.UBCDatabaseErrorHandler.qw()
            r4 = 0
            r0.de(r4)
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            r2.fe(r4, r7)
            java.util.ArrayList r0 = r28.mmm()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r4 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_UPLOADED_DATA
            fe.fe.mmm.m.pf(r0, r3, r2, r4)
            r9 = 0
        L_0x03ba:
            return r9
        L_0x03bb:
            r0 = move-exception
        L_0x03bc:
            com.baidu.ubc.database.UBCDatabaseErrorHandler r4 = com.baidu.ubc.database.UBCDatabaseErrorHandler.qw()
            r4.de(r9)
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r4 = r4.writeLock()
            r4.unlock()
            r4 = 0
            r2.fe(r4, r7)
            java.util.ArrayList r2 = r28.mmm()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            r4.append(r9)
            java.lang.String r4 = r4.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r5 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_UPLOADED_DATA
            fe.fe.mmm.m.pf(r2, r3, r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.a(fe.fe.mmm.l, java.lang.String):boolean");
    }

    public final boolean aaa(String str, String str2, int i2, SQLiteDatabase sQLiteDatabase) {
        this.f2020uk.writeLock().lock();
        try {
            boolean equals = str.equals(str2);
            boolean z = false;
            if (!equals) {
                Cursor cursor = null;
                try {
                    cursor = sQLiteDatabase.rawQuery("SELECT " + WXLoginActivity.w + " FROM " + "flow" + " WHERE " + "flowhandle" + " = " + i2, (String[]) null);
                    if (cursor != null && cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        String string = cursor.getString(0);
                        if (!TextUtils.isEmpty(string) && "1".equals(string)) {
                            z = true;
                        }
                    }
                } catch (SQLException e) {
                    if (f2015i) {
                        e.printStackTrace();
                    }
                    this.f2018ad.uk(e, "read_", "checkFlowValid");
                } catch (RuntimeException e2) {
                    if (f2015i) {
                        e2.printStackTrace();
                    }
                }
                qw.qw(cursor);
            } else {
                z = true;
            }
            this.f2020uk.writeLock().unlock();
            return z;
        } catch (Throwable th2) {
            this.f2020uk.writeLock().unlock();
            throw th2;
        }
    }

    public void b(SQLiteDatabase sQLiteDatabase, l lVar) {
        if (lVar != null && !lVar.h() && lVar.m126switch().size() >= 1) {
            this.f2020uk.writeLock().lock();
            try {
                Set<String> set = lVar.m126switch();
                String[] strArr = (String[]) set.toArray(new String[set.size()]);
                String[] strArr2 = new String[set.size()];
                Arrays.fill(strArr2, "?");
                String join = TextUtils.join(",", strArr2);
                StringBuilder sb = new StringBuilder();
                sb.append("date(");
                sb.append("ubctime");
                sb.append(") in (");
                sb.append(join);
                sb.append(")");
                String sb2 = sb.toString();
                sb.append(" AND ");
                sb.append("date(");
                sb.append("ubctime");
                sb.append(") < date('now', 'localtime')");
                int delete = sQLiteDatabase.delete("arrival", sb.toString(), strArr);
                if (f2015i) {
                    "clearUploadedUBCRecords delete " + delete + " records";
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(WXLoginActivity.w, 1);
                int update = sQLiteDatabase.update("arrival", contentValues, sb2, strArr);
                if (f2015i) {
                    "clearUploadedUBCRecords update " + update + " records";
                }
            } catch (SQLException e) {
                if (f2015i) {
                    e.printStackTrace();
                }
                this.f2018ad.uk(e, "write_", "clearUploadedUBCRecords");
            } catch (Throwable th2) {
                this.f2020uk.writeLock().unlock();
                throw th2;
            }
            this.f2020uk.writeLock().unlock();
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE arrival (_id INTEGER PRIMARY KEY AUTOINCREMENT,ubcid TEXT,ubctime TEXT DEFAULT CURRENT_DATE,count INTEGER,state INTEGER,reserve1 TEXT,callcnt INTEGER,logid TEXT);");
        } catch (SQLException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
    }

    public final void d(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT,logid TEXT,savefile INTEGER,uuid TEXT,appversion TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT,logid TEXT,savefile INTEGER,uuid TEXT,appversion TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
        sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT,uploadfirst LONG,uploadindex INTEGER);");
        sQLiteDatabase.execSQL("CREATE TABLE arrival (_id INTEGER PRIMARY KEY AUTOINCREMENT,ubcid TEXT,ubctime TEXT DEFAULT CURRENT_DATE,count INTEGER,state INTEGER,reserve1 TEXT,callcnt INTEGER,logid TEXT);");
        k.qw().yj("ubc_cloudconfig_version", "0");
    }

    public final void ddd(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN appversion TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN appversion TEXT");
        } catch (SQLiteException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public void de(l lVar) {
        boolean j = i.vvv().j();
        this.f2020uk.readLock().lock();
        try {
            x(p(true, true, j), lVar);
            if (!lVar.f()) {
                if (!lVar.j()) {
                    x(p(true, false, j), lVar);
                    if (!lVar.f()) {
                        if (!lVar.j()) {
                            A(p(false, true, j), lVar);
                            if (!lVar.f()) {
                                if (!lVar.j()) {
                                    A(p(false, false, j), lVar);
                                    this.f2020uk.readLock().unlock();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            this.f2020uk.readLock().unlock();
        } catch (SQLException e) {
            if (f2015i) {
                e.printStackTrace();
            }
            this.f2018ad.uk(e, "read_", "acquireAllValidDataWithOptNonRealCycle");
        } catch (Throwable th2) {
            this.f2020uk.readLock().unlock();
            throw th2;
        }
    }

    public final void e(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT,uploadfirst LONG,uploadindex INTEGER);");
        } catch (SQLException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public void eee() {
        k(false, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r5v8, types: [int] */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[Catch:{ all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0052=Splitter:B:27:0x0052, B:8:0x0027=Splitter:B:8:0x0027} */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f(fe.fe.mmm.l r9) {
        /*
            r8 = this;
            java.lang.String r0 = "deleteAllRealLog"
            java.lang.String r1 = "write_"
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r8.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.lock()
            r2 = 0
            r3 = 1
            android.database.sqlite.SQLiteDatabase r4 = r8.getWritableDatabase()     // Catch:{ SQLException -> 0x005a, all -> 0x0058 }
            r4.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x005a, all -> 0x0058 }
            java.lang.String r5 = "event"
            java.lang.String r6 = "reallog =?"
            java.lang.String r7 = "1"
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ SQLException -> 0x0030, all -> 0x002d }
            int r5 = r4.delete(r5, r6, r7)     // Catch:{ SQLException -> 0x0030, all -> 0x002d }
            r4.setTransactionSuccessful()     // Catch:{ SQLException -> 0x002b }
        L_0x0027:
            r4.endTransaction()     // Catch:{ SQLException -> 0x0056 }
            goto L_0x003f
        L_0x002b:
            r6 = move-exception
            goto L_0x0032
        L_0x002d:
            r6 = move-exception
            r5 = 0
            goto L_0x0052
        L_0x0030:
            r6 = move-exception
            r5 = 0
        L_0x0032:
            boolean r7 = f2015i     // Catch:{ all -> 0x0051 }
            if (r7 == 0) goto L_0x0039
            r6.printStackTrace()     // Catch:{ all -> 0x0051 }
        L_0x0039:
            fe.fe.mmm.fe r7 = r8.f2018ad     // Catch:{ all -> 0x0051 }
            r7.uk(r6, r1, r0)     // Catch:{ all -> 0x0051 }
            goto L_0x0027
        L_0x003f:
            if (r5 <= 0) goto L_0x0042
            r2 = 1
        L_0x0042:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r8.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            if (r9 == 0) goto L_0x0050
            r9.fe(r3, r5)
        L_0x0050:
            return r2
        L_0x0051:
            r6 = move-exception
        L_0x0052:
            r4.endTransaction()     // Catch:{ SQLException -> 0x0056 }
            throw r6     // Catch:{ SQLException -> 0x0056 }
        L_0x0056:
            r4 = move-exception
            goto L_0x005c
        L_0x0058:
            r0 = move-exception
            goto L_0x0079
        L_0x005a:
            r4 = move-exception
            r5 = 0
        L_0x005c:
            boolean r6 = f2015i     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x0063
            r4.printStackTrace()     // Catch:{ all -> 0x0077 }
        L_0x0063:
            fe.fe.mmm.fe r6 = r8.f2018ad     // Catch:{ all -> 0x0077 }
            r6.uk(r4, r1, r0)     // Catch:{ all -> 0x0077 }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r8.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            if (r9 == 0) goto L_0x0076
            r9.fe(r3, r5)
        L_0x0076:
            return r2
        L_0x0077:
            r0 = move-exception
            r2 = r5
        L_0x0079:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r8.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r1.writeLock()
            r1.unlock()
            if (r9 == 0) goto L_0x0087
            r9.fe(r3, r2)
        L_0x0087:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.f(fe.fe.mmm.l):boolean");
    }

    public final void fe(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE arrival ADD COLUMN callcnt INTEGER");
        } catch (SQLException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r3 != -1) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        fe.fe.mmm.c.de().i(r3, r8, "deleteFileByExceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0073, code lost:
        if (r3 != -1) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c A[Catch:{ all -> 0x0077 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int g(int r8) {
        /*
            r7 = this;
            java.lang.String r0 = "deleteFileByExceeded"
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r7.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r1.writeLock()
            r1.lock()
            r1 = -1
            android.database.sqlite.SQLiteDatabase r2 = r7.getWritableDatabase()     // Catch:{ SQLException -> 0x0056, all -> 0x0053 }
            r2.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x0056, all -> 0x0053 }
            java.lang.String r3 = "file"
            r4 = 0
            int r3 = r2.delete(r3, r4, r4)     // Catch:{ all -> 0x004b }
            boolean r4 = f2015i     // Catch:{ all -> 0x0049 }
            if (r4 == 0) goto L_0x002e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r4.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r5 = "deleteAllSentFile#performTransaction: delete file table:"
            r4.append(r5)     // Catch:{ all -> 0x0049 }
            r4.append(r3)     // Catch:{ all -> 0x0049 }
            r4.toString()     // Catch:{ all -> 0x0049 }
        L_0x002e:
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0049 }
            r2.endTransaction()     // Catch:{ SQLException -> 0x0051 }
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r7.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.unlock()
            if (r3 >= r8) goto L_0x0076
            if (r3 == r1) goto L_0x0076
        L_0x0041:
            fe.fe.mmm.c r1 = fe.fe.mmm.c.de()
            r1.i(r3, r8, r0)
            goto L_0x0076
        L_0x0049:
            r4 = move-exception
            goto L_0x004d
        L_0x004b:
            r4 = move-exception
            r3 = -1
        L_0x004d:
            r2.endTransaction()     // Catch:{ SQLException -> 0x0051 }
            throw r4     // Catch:{ SQLException -> 0x0051 }
        L_0x0051:
            r2 = move-exception
            goto L_0x0058
        L_0x0053:
            r2 = move-exception
            r3 = -1
            goto L_0x0078
        L_0x0056:
            r2 = move-exception
            r3 = -1
        L_0x0058:
            boolean r4 = f2015i     // Catch:{ all -> 0x0077 }
            if (r4 == 0) goto L_0x005f
            r2.printStackTrace()     // Catch:{ all -> 0x0077 }
        L_0x005f:
            fe.fe.mmm.fe r4 = r7.f2018ad     // Catch:{ all -> 0x0077 }
            java.lang.String r5 = "write_"
            java.lang.String r6 = "deleteAllSentFile"
            r4.uk(r2, r5, r6)     // Catch:{ all -> 0x0077 }
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r7.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.unlock()
            if (r3 >= r8) goto L_0x0076
            if (r3 == r1) goto L_0x0076
            goto L_0x0041
        L_0x0076:
            return r3
        L_0x0077:
            r2 = move-exception
        L_0x0078:
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = r7.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r4 = r4.writeLock()
            r4.unlock()
            if (r3 >= r8) goto L_0x008c
            if (r3 == r1) goto L_0x008c
            fe.fe.mmm.c r1 = fe.fe.mmm.c.de()
            r1.i(r3, r8, r0)
        L_0x008c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.g(int):int");
    }

    public final void ggg(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
        } catch (SQLException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public boolean h(String str) {
        SQLiteDatabase writableDatabase;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f2020uk.writeLock().lock();
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            Cursor rawQuery = writableDatabase.rawQuery("SELECT * FROM " + "config" + " WHERE " + "eventid" + "=\"" + str + "\"", (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.getCount() != 0) {
                    int delete = writableDatabase.delete("config", "eventid =? ", new String[]{str});
                    writableDatabase.setTransactionSuccessful();
                    qw.qw(rawQuery);
                    writableDatabase.endTransaction();
                    if (delete > 0) {
                        z = true;
                    }
                    this.f2020uk.writeLock().unlock();
                    return z;
                }
            }
            qw.qw(rawQuery);
            writableDatabase.endTransaction();
            this.f2020uk.writeLock().unlock();
            return true;
        } catch (SQLException e) {
            try {
                if (f2015i) {
                    e.printStackTrace();
                }
                this.f2018ad.uk(e, "write_", "deleteConfig");
                return false;
            } finally {
                this.f2020uk.writeLock().unlock();
            }
        } catch (Throwable th2) {
            qw.qw((Cursor) null);
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    public void j(String str) {
        SQLiteDatabase writableDatabase;
        this.f2020uk.writeLock().lock();
        int i2 = -1;
        try {
            writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            i2 = writableDatabase.delete("file", "filename" + "=\"" + str + "\"", (String[]) null);
            if (f2015i) {
                "deleteSendedFile#performTransaction: delete file table:" + i2;
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            this.f2020uk.writeLock().unlock();
            if (i2 != 0) {
            }
        } catch (SQLException e) {
            try {
                if (f2015i) {
                    e.printStackTrace();
                }
                this.f2018ad.uk(e, "write_", "deleteSentFile");
            } finally {
                this.f2020uk.writeLock().unlock();
                if (i2 == 0) {
                    c.de().i(i2, 1, "deleteFileByUploader");
                }
            }
        } catch (Throwable th2) {
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v13, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v14, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v16, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v18, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v19, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0214 A[SYNTHETIC, Splitter:B:110:0x0214] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0432 A[Catch:{ all -> 0x050e }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0449 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0480  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x049c  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04c2  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x051e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x0556  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0572  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x058f  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0598  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0122 A[EDGE_INSN: B:242:0x0122->B:71:0x0122 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:245:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0123 A[Catch:{ all -> 0x0128, all -> 0x016d }, LOOP:0: B:59:0x00f0->B:72:0x0123, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013b A[Catch:{ all -> 0x0128, all -> 0x016d }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e8 A[SYNTHETIC, Splitter:B:99:0x01e8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(boolean r32, boolean r33) {
        /*
            r31 = this;
            r1 = r31
            r9 = r32
            r10 = r33
            java.lang.String r0 = ")"
            java.lang.String r2 = "option"
            java.lang.String r3 = "flowhandle"
            java.lang.String r4 = "event"
            java.lang.String r11 = "deleteFileByInvalid"
            java.lang.String r5 = "flow"
            java.lang.String r12 = ";expireTime:"
            java.lang.String r13 = "clear:"
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r6 = r6.writeLock()
            r6.lock()
            android.database.sqlite.SQLiteDatabase r8 = r31.getWritableDatabase()     // Catch:{ SQLException -> 0x0425, all -> 0x0419 }
            r8.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x0425, all -> 0x0419 }
            long r16 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x03fb }
            fe.fe.mmm.i r18 = fe.fe.mmm.i.vvv()     // Catch:{ all -> 0x03fb }
            int r7 = r18.m124switch()     // Catch:{ all -> 0x03fb }
            long r6 = (long) r7     // Catch:{ all -> 0x03fb }
            long r6 = r16 - r6
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x03fb }
            r15.<init>()     // Catch:{ all -> 0x03fb }
            r25 = r11
            java.lang.String r11 = "endtime < "
            r15.append(r11)     // Catch:{ all -> 0x03f5 }
            r15.append(r6)     // Catch:{ all -> 0x03f5 }
            java.lang.String r11 = r15.toString()     // Catch:{ all -> 0x03f5 }
            r15 = 0
            int r11 = r8.delete(r5, r11, r15)     // Catch:{ all -> 0x03ec }
            boolean r15 = f2015i     // Catch:{ all -> 0x03e2 }
            if (r15 == 0) goto L_0x007d
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r15.<init>()     // Catch:{ all -> 0x0070 }
            r26 = r12
            java.lang.String r12 = "clearInvalidData: delete flow count:"
            r15.append(r12)     // Catch:{ all -> 0x0069 }
            r15.append(r11)     // Catch:{ all -> 0x0069 }
            r15.toString()     // Catch:{ all -> 0x0069 }
            goto L_0x007f
        L_0x0069:
            r0 = move-exception
            r7 = r13
            r5 = r25
            r6 = r26
            goto L_0x0075
        L_0x0070:
            r0 = move-exception
            r6 = r12
            r7 = r13
            r5 = r25
        L_0x0075:
            r12 = 0
        L_0x0076:
            r15 = 0
            r23 = -1
            r24 = 0
            goto L_0x0407
        L_0x007d:
            r26 = r12
        L_0x007f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x03db }
            r12.<init>()     // Catch:{ all -> 0x03db }
            java.lang.String r15 = "begintime < "
            r12.append(r15)     // Catch:{ all -> 0x03db }
            r12.append(r6)     // Catch:{ all -> 0x03db }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x03db }
            r15 = 0
            int r12 = r8.delete(r4, r12, r15)     // Catch:{ all -> 0x03d1 }
            boolean r16 = f2015i     // Catch:{ all -> 0x03c6 }
            if (r16 == 0) goto L_0x00bb
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b4 }
            r15.<init>()     // Catch:{ all -> 0x00b4 }
            r27 = r13
            java.lang.String r13 = "clearInvalidData: delete event count:"
            r15.append(r13)     // Catch:{ all -> 0x00ac }
            r15.append(r12)     // Catch:{ all -> 0x00ac }
            r15.toString()     // Catch:{ all -> 0x00ac }
            goto L_0x00bd
        L_0x00ac:
            r0 = move-exception
            r5 = r25
            r6 = r26
            r7 = r27
            goto L_0x0076
        L_0x00b4:
            r0 = move-exception
            r7 = r13
            r5 = r25
            r6 = r26
            goto L_0x0076
        L_0x00bb:
            r27 = r13
        L_0x00bd:
            java.lang.String r13 = "file"
            r17 = 0
            java.lang.String r18 = "uploadfirst < ?"
            r15 = 1
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ all -> 0x03b9 }
            java.lang.String r19 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x03b9 }
            r24 = 0
            r15[r24] = r19     // Catch:{ all -> 0x03af }
            r20 = 0
            r21 = 0
            r22 = 0
            r28 = r12
            r19 = r15
            r12 = 0
            r15 = r8
            r16 = r13
            android.database.Cursor r15 = r15.query(r16, r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x03a1 }
            if (r15 == 0) goto L_0x0135
            boolean r13 = r15.moveToFirst()     // Catch:{ all -> 0x012a }
            if (r13 == 0) goto L_0x0135
            java.lang.String r13 = "filename"
            int r13 = r15.getColumnIndex(r13)     // Catch:{ all -> 0x012a }
            r23 = -1
        L_0x00f0:
            java.lang.String r12 = r15.getString(r13)     // Catch:{ all -> 0x0128 }
            boolean r17 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0128 }
            if (r17 != 0) goto L_0x0118
            r14.add(r12)     // Catch:{ all -> 0x0128 }
            int r23 = r23 + 1
            boolean r17 = f2015i     // Catch:{ all -> 0x0128 }
            if (r17 == 0) goto L_0x0118
            r17 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0128 }
            r13.<init>()     // Catch:{ all -> 0x0128 }
            r18 = r14
            java.lang.String r14 = "deleteTimeoutFile db delete:"
            r13.append(r14)     // Catch:{ all -> 0x016d }
            r13.append(r12)     // Catch:{ all -> 0x016d }
            r13.toString()     // Catch:{ all -> 0x016d }
            goto L_0x011c
        L_0x0118:
            r17 = r13
            r18 = r14
        L_0x011c:
            boolean r12 = r15.moveToNext()     // Catch:{ all -> 0x016d }
            if (r12 != 0) goto L_0x0123
            goto L_0x0139
        L_0x0123:
            r13 = r17
            r14 = r18
            goto L_0x00f0
        L_0x0128:
            r0 = move-exception
            goto L_0x0170
        L_0x012a:
            r0 = move-exception
            r5 = r25
            r6 = r26
            r7 = r27
            r12 = r28
            goto L_0x0405
        L_0x0135:
            r18 = r14
            r23 = -1
        L_0x0139:
            if (r23 <= 0) goto L_0x017a
            java.lang.String r12 = "file"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x016d }
            r13.<init>()     // Catch:{ all -> 0x016d }
            java.lang.String r14 = "uploadfirst < "
            r13.append(r14)     // Catch:{ all -> 0x016d }
            r13.append(r6)     // Catch:{ all -> 0x016d }
            java.lang.String r6 = r13.toString()     // Catch:{ all -> 0x016d }
            r7 = 0
            int r6 = r8.delete(r12, r6, r7)     // Catch:{ all -> 0x016d }
            boolean r7 = f2015i     // Catch:{ all -> 0x0169 }
            if (r7 == 0) goto L_0x0167
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
            r7.<init>()     // Catch:{ all -> 0x0169 }
            java.lang.String r12 = "clearInvalidData: delete file count:"
            r7.append(r12)     // Catch:{ all -> 0x0169 }
            r7.append(r6)     // Catch:{ all -> 0x0169 }
            r7.toString()     // Catch:{ all -> 0x0169 }
        L_0x0167:
            r12 = r6
            goto L_0x017c
        L_0x0169:
            r0 = move-exception
            r23 = r6
            goto L_0x016e
        L_0x016d:
            r0 = move-exception
        L_0x016e:
            r14 = r18
        L_0x0170:
            r5 = r25
            r6 = r26
            r7 = r27
            r12 = r28
            goto L_0x0407
        L_0x017a:
            r12 = r23
        L_0x017c:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0391 }
            r13 = 86400000(0x5265c00, double:4.2687272E-316)
            long r6 = r6 - r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0391 }
            r14 = 256(0x100, float:3.59E-43)
            r13.<init>(r14)     // Catch:{ all -> 0x0391 }
            java.lang.String r14 = "SELECT "
            r13.append(r14)     // Catch:{ all -> 0x0391 }
            r13.append(r3)     // Catch:{ all -> 0x0391 }
            java.lang.String r14 = " FROM "
            r13.append(r14)     // Catch:{ all -> 0x0391 }
            r13.append(r5)     // Catch:{ all -> 0x0391 }
            java.lang.String r14 = " WHERE "
            r13.append(r14)     // Catch:{ all -> 0x0391 }
            java.lang.String r14 = "begintime"
            r13.append(r14)     // Catch:{ all -> 0x0391 }
            java.lang.String r14 = " < "
            r13.append(r14)     // Catch:{ all -> 0x0391 }
            r13.append(r6)     // Catch:{ all -> 0x0391 }
            java.lang.String r6 = " AND "
            r13.append(r6)     // Catch:{ all -> 0x0391 }
            java.lang.String r6 = "endtime"
            r13.append(r6)     // Catch:{ all -> 0x0391 }
            java.lang.String r6 = " is NULL "
            r13.append(r6)     // Catch:{ all -> 0x0391 }
            java.lang.String r6 = " AND ("
            r13.append(r6)     // Catch:{ all -> 0x0391 }
            r13.append(r2)     // Catch:{ all -> 0x0391 }
            java.lang.String r6 = " = 0 OR "
            r13.append(r6)     // Catch:{ all -> 0x0391 }
            r13.append(r2)     // Catch:{ all -> 0x0391 }
            java.lang.String r2 = " = "
            r13.append(r2)     // Catch:{ all -> 0x0391 }
            r2 = 4
            r13.append(r2)     // Catch:{ all -> 0x0391 }
            r13.append(r0)     // Catch:{ all -> 0x0391 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0391 }
            r2.<init>()     // Catch:{ all -> 0x0391 }
            java.lang.String r6 = r13.toString()     // Catch:{ all -> 0x037f }
            r7 = 0
            android.database.Cursor r6 = r8.rawQuery(r6, r7)     // Catch:{ all -> 0x0372 }
            if (r6 == 0) goto L_0x020b
            int r7 = r6.getCount()     // Catch:{ all -> 0x0207 }
            if (r7 <= 0) goto L_0x020b
            r6.moveToFirst()     // Catch:{ all -> 0x0207 }
            int r7 = r6.getColumnIndex(r3)     // Catch:{ all -> 0x0207 }
        L_0x01f5:
            int r13 = r6.getInt(r7)     // Catch:{ all -> 0x0207 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0207 }
            r2.add(r13)     // Catch:{ all -> 0x0207 }
            boolean r13 = r6.moveToNext()     // Catch:{ all -> 0x0207 }
            if (r13 != 0) goto L_0x01f5
            goto L_0x020b
        L_0x0207:
            r0 = move-exception
            r2 = r6
            goto L_0x0374
        L_0x020b:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ all -> 0x0391 }
            int r6 = r2.size()     // Catch:{ all -> 0x0391 }
            if (r6 <= 0) goto L_0x0258
            boolean r6 = f2015i     // Catch:{ all -> 0x0253 }
            if (r6 == 0) goto L_0x022c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0253 }
            r6.<init>()     // Catch:{ all -> 0x0253 }
            java.lang.String r7 = "clearInvalidData: delete flow count2:"
            r6.append(r7)     // Catch:{ all -> 0x0253 }
            int r7 = r2.size()     // Catch:{ all -> 0x0253 }
            r6.append(r7)     // Catch:{ all -> 0x0253 }
            r6.toString()     // Catch:{ all -> 0x0253 }
        L_0x022c:
            java.lang.String r2 = r1.C(r2)     // Catch:{ all -> 0x0253 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0253 }
            r6.<init>()     // Catch:{ all -> 0x0253 }
            r6.append(r3)     // Catch:{ all -> 0x0253 }
            java.lang.String r3 = " in ("
            r6.append(r3)     // Catch:{ all -> 0x0253 }
            r6.append(r2)     // Catch:{ all -> 0x0253 }
            r6.append(r0)     // Catch:{ all -> 0x0253 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0253 }
            r2 = 0
            r8.delete(r5, r0, r2)     // Catch:{ all -> 0x0253 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0253 }
            r8.delete(r4, r0, r2)     // Catch:{ all -> 0x0253 }
            goto L_0x0258
        L_0x0253:
            r0 = move-exception
            r23 = r12
            goto L_0x016e
        L_0x0258:
            r8.setTransactionSuccessful()     // Catch:{ all -> 0x0391 }
            r8.endTransaction()     // Catch:{ SQLException -> 0x0363, all -> 0x0354 }
            fe.fe.mmm.u.qw.qw(r15)     // Catch:{ SQLException -> 0x0363, all -> 0x0354 }
            int r13 = r1.n(r5, r9, r10)     // Catch:{ SQLException -> 0x0363, all -> 0x0354 }
            int r0 = r1.n(r4, r9, r10)     // Catch:{ SQLException -> 0x0346, all -> 0x0337 }
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.unlock()
            if (r11 > 0) goto L_0x027c
            if (r28 <= 0) goto L_0x0277
            goto L_0x027c
        L_0x0277:
            r6 = r26
            r7 = r27
            goto L_0x02e2
        L_0x027c:
            fe.fe.mmm.i r2 = fe.fe.mmm.i.vvv()
            int r2 = r2.m124switch()
            java.lang.String r14 = java.lang.String.valueOf(r2)
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            r6 = 0
            r3 = r14
            r4 = r11
            r5 = r28
            r7 = r32
            r8 = r33
            r2.ppp(r3, r4, r5, r6, r7, r8)
            com.baidu.ubc.UBCUploadTimingManager r2 = com.baidu.ubc.UBCUploadTimingManager.o()
            r3 = r28
            r2.when(r3, r11)
            if (r3 <= 0) goto L_0x02c2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r7 = r27
            r2.append(r7)
            r2.append(r3)
            r6 = r26
            r2.append(r6)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r3 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_EVENT_OVERTIME
            fe.fe.mmm.m.m128switch(r2, r3)
            goto L_0x02c6
        L_0x02c2:
            r6 = r26
            r7 = r27
        L_0x02c6:
            if (r11 <= 0) goto L_0x02e2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r11)
            r2.append(r6)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r3 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_FLOW_OVERTIME
            fe.fe.mmm.m.m128switch(r2, r3)
        L_0x02e2:
            if (r13 > 0) goto L_0x02e6
            if (r0 <= 0) goto L_0x02ed
        L_0x02e6:
            com.baidu.ubc.UBCUploadTimingManager r0 = com.baidu.ubc.UBCUploadTimingManager.o()
            r0.ppp()
        L_0x02ed:
            if (r12 <= 0) goto L_0x050d
            fe.fe.mmm.i r0 = fe.fe.mmm.i.vvv()
            int r0 = r0.m124switch()
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            r2.m118switch(r0, r12, r9, r10)
            android.content.Context r2 = r1.f2019th
            java.lang.String r2 = fe.fe.mmm.j.de(r2)
            r14 = r18
            fe.fe.mmm.u.ad.ad(r2, r14)
            int r2 = r14.size()
            if (r12 >= r2) goto L_0x031c
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            int r3 = r14.size()
            r5 = r25
            r2.i(r12, r3, r5)
        L_0x031c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r12)
            r2.append(r6)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = r14.toString()
            goto L_0x0508
        L_0x0337:
            r0 = move-exception
            r3 = r28
            r24 = r13
            r8 = r18
            r7 = r25
            r15 = r26
            r14 = r27
            r13 = r12
            goto L_0x0360
        L_0x0346:
            r0 = move-exception
            r14 = r18
            r5 = r25
            r6 = r26
            r7 = r27
            r3 = r28
            r24 = r13
            goto L_0x036e
        L_0x0354:
            r0 = move-exception
            r3 = r28
            r13 = r12
            r8 = r18
            r7 = r25
            r15 = r26
            r14 = r27
        L_0x0360:
            r12 = r3
            goto L_0x0513
        L_0x0363:
            r0 = move-exception
            r14 = r18
            r5 = r25
            r6 = r26
            r7 = r27
            r3 = r28
        L_0x036e:
            r13 = r12
            r12 = r3
            goto L_0x042e
        L_0x0372:
            r0 = move-exception
            r2 = r7
        L_0x0374:
            r14 = r18
            r5 = r25
            r6 = r26
            r7 = r27
            r3 = r28
            goto L_0x038b
        L_0x037f:
            r0 = move-exception
            r14 = r18
            r5 = r25
            r6 = r26
            r7 = r27
            r3 = r28
            r2 = 0
        L_0x038b:
            fe.fe.mmm.u.qw.qw(r2)     // Catch:{ all -> 0x038f }
            throw r0     // Catch:{ all -> 0x038f }
        L_0x038f:
            r0 = move-exception
            goto L_0x039c
        L_0x0391:
            r0 = move-exception
            r14 = r18
            r5 = r25
            r6 = r26
            r7 = r27
            r3 = r28
        L_0x039c:
            r23 = r12
            r12 = r3
            goto L_0x0407
        L_0x03a1:
            r0 = move-exception
            r2 = r12
            r5 = r25
            r6 = r26
            r7 = r27
            r3 = r28
            r15 = r2
            r12 = r3
            goto L_0x0405
        L_0x03af:
            r0 = move-exception
            r3 = r12
            r5 = r25
            r6 = r26
            r7 = r27
            r2 = 0
            goto L_0x03c4
        L_0x03b9:
            r0 = move-exception
            r3 = r12
            r5 = r25
            r6 = r26
            r7 = r27
            r2 = 0
            r24 = 0
        L_0x03c4:
            r15 = r2
            goto L_0x0405
        L_0x03c6:
            r0 = move-exception
            r3 = r12
            r7 = r13
            r2 = r15
            r5 = r25
            r6 = r26
            r24 = 0
            goto L_0x0405
        L_0x03d1:
            r0 = move-exception
            r7 = r13
            r2 = r15
            r5 = r25
            r6 = r26
            r24 = 0
            goto L_0x0404
        L_0x03db:
            r0 = move-exception
            r7 = r13
            r5 = r25
            r6 = r26
            goto L_0x03e7
        L_0x03e2:
            r0 = move-exception
            r6 = r12
            r7 = r13
            r5 = r25
        L_0x03e7:
            r2 = 0
            r24 = 0
            r15 = r2
            goto L_0x0404
        L_0x03ec:
            r0 = move-exception
            r6 = r12
            r7 = r13
            r2 = r15
            r5 = r25
            r24 = 0
            goto L_0x0403
        L_0x03f5:
            r0 = move-exception
            r6 = r12
            r7 = r13
            r5 = r25
            goto L_0x03ff
        L_0x03fb:
            r0 = move-exception
            r5 = r11
            r6 = r12
            r7 = r13
        L_0x03ff:
            r2 = 0
            r24 = 0
            r15 = r2
        L_0x0403:
            r11 = 0
        L_0x0404:
            r12 = 0
        L_0x0405:
            r23 = -1
        L_0x0407:
            r8.endTransaction()     // Catch:{ SQLException -> 0x0415, all -> 0x040e }
            fe.fe.mmm.u.qw.qw(r15)     // Catch:{ SQLException -> 0x0415, all -> 0x040e }
            throw r0     // Catch:{ SQLException -> 0x0415, all -> 0x040e }
        L_0x040e:
            r0 = move-exception
            r15 = r6
            r8 = r14
            r13 = r23
            goto L_0x0511
        L_0x0415:
            r0 = move-exception
            r13 = r23
            goto L_0x042e
        L_0x0419:
            r0 = move-exception
            r24 = 0
            r7 = r11
            r15 = r12
            r8 = r14
            r11 = 0
            r12 = 0
            r14 = r13
            r13 = -1
            goto L_0x0513
        L_0x0425:
            r0 = move-exception
            r5 = r11
            r6 = r12
            r7 = r13
            r24 = 0
            r11 = 0
            r12 = 0
            r13 = -1
        L_0x042e:
            boolean r2 = f2015i     // Catch:{ all -> 0x050e }
            if (r2 == 0) goto L_0x0435
            r0.printStackTrace()     // Catch:{ all -> 0x050e }
        L_0x0435:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x050e }
            java.lang.String r3 = "write_"
            java.lang.String r4 = "doClearInvalidData"
            r2.uk(r0, r3, r4)     // Catch:{ all -> 0x050e }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            if (r11 > 0) goto L_0x0453
            if (r12 <= 0) goto L_0x044c
            goto L_0x0453
        L_0x044c:
            r25 = r5
            r15 = r6
            r18 = r14
            r14 = r7
            goto L_0x04b6
        L_0x0453:
            fe.fe.mmm.i r0 = fe.fe.mmm.i.vvv()
            int r0 = r0.m124switch()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            r8 = 0
            r3 = r0
            r4 = r11
            r15 = r5
            r5 = r12
            r25 = r15
            r15 = r6
            r6 = r8
            r8 = r7
            r7 = r32
            r18 = r14
            r14 = r8
            r8 = r33
            r2.ppp(r3, r4, r5, r6, r7, r8)
            com.baidu.ubc.UBCUploadTimingManager r2 = com.baidu.ubc.UBCUploadTimingManager.o()
            r2.when(r12, r11)
            if (r12 <= 0) goto L_0x049a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r12)
            r2.append(r15)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r3 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_EVENT_OVERTIME
            fe.fe.mmm.m.m128switch(r2, r3)
        L_0x049a:
            if (r11 <= 0) goto L_0x04b6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r11)
            r2.append(r15)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r2 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_FLOW_OVERTIME
            fe.fe.mmm.m.m128switch(r0, r2)
        L_0x04b6:
            if (r24 > 0) goto L_0x04b9
            goto L_0x04c0
        L_0x04b9:
            com.baidu.ubc.UBCUploadTimingManager r0 = com.baidu.ubc.UBCUploadTimingManager.o()
            r0.ppp()
        L_0x04c0:
            if (r13 <= 0) goto L_0x050d
            fe.fe.mmm.i r0 = fe.fe.mmm.i.vvv()
            int r0 = r0.m124switch()
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            r2.m118switch(r0, r13, r9, r10)
            android.content.Context r2 = r1.f2019th
            java.lang.String r2 = fe.fe.mmm.j.de(r2)
            r8 = r18
            fe.fe.mmm.u.ad.ad(r2, r8)
            int r2 = r8.size()
            if (r13 >= r2) goto L_0x04ef
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            int r3 = r8.size()
            r7 = r25
            r2.i(r13, r3, r7)
        L_0x04ef:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r13)
            r2.append(r15)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = r8.toString()
        L_0x0508:
            com.baidu.ubc.constants.EnumConstants$RunTime r3 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_FILE_OVERTIME
            fe.fe.mmm.m.uk(r2, r0, r3)
        L_0x050d:
            return
        L_0x050e:
            r0 = move-exception
            r15 = r6
            r8 = r14
        L_0x0511:
            r14 = r7
            r7 = r5
        L_0x0513:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.unlock()
            if (r11 > 0) goto L_0x0528
            if (r12 <= 0) goto L_0x0521
            goto L_0x0528
        L_0x0521:
            r17 = r0
            r29 = r7
            r30 = r8
            goto L_0x058c
        L_0x0528:
            fe.fe.mmm.i r2 = fe.fe.mmm.i.vvv()
            int r2 = r2.m124switch()
            java.lang.String r6 = java.lang.String.valueOf(r2)
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            r16 = 0
            r3 = r6
            r4 = r11
            r5 = r12
            r17 = r0
            r0 = r6
            r6 = r16
            r29 = r7
            r7 = r32
            r30 = r8
            r8 = r33
            r2.ppp(r3, r4, r5, r6, r7, r8)
            com.baidu.ubc.UBCUploadTimingManager r2 = com.baidu.ubc.UBCUploadTimingManager.o()
            r2.when(r12, r11)
            if (r12 <= 0) goto L_0x0570
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r12)
            r2.append(r15)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r3 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_EVENT_OVERTIME
            fe.fe.mmm.m.m128switch(r2, r3)
        L_0x0570:
            if (r11 <= 0) goto L_0x058c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r11)
            r2.append(r15)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r2 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_FLOW_OVERTIME
            fe.fe.mmm.m.m128switch(r0, r2)
        L_0x058c:
            if (r24 > 0) goto L_0x058f
            goto L_0x0596
        L_0x058f:
            com.baidu.ubc.UBCUploadTimingManager r0 = com.baidu.ubc.UBCUploadTimingManager.o()
            r0.ppp()
        L_0x0596:
            if (r13 <= 0) goto L_0x05e3
            fe.fe.mmm.i r0 = fe.fe.mmm.i.vvv()
            int r0 = r0.m124switch()
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            r2.m118switch(r0, r13, r9, r10)
            android.content.Context r2 = r1.f2019th
            java.lang.String r2 = fe.fe.mmm.j.de(r2)
            r3 = r30
            fe.fe.mmm.u.ad.ad(r2, r3)
            int r2 = r3.size()
            if (r13 >= r2) goto L_0x05c5
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            int r4 = r3.size()
            r5 = r29
            r2.i(r13, r4, r5)
        L_0x05c5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r14)
            r2.append(r13)
            r2.append(r15)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = r3.toString()
            com.baidu.ubc.constants.EnumConstants$RunTime r3 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_FILE_OVERTIME
            fe.fe.mmm.m.uk(r2, r0, r3)
        L_0x05e3:
            throw r17
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.k(boolean, boolean):void");
    }

    public final void l(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE event");
        sQLiteDatabase.execSQL("DROP TABLE flow");
        sQLiteDatabase.execSQL("DROP TABLE config");
        sQLiteDatabase.execSQL("DROP TABLE file");
        sQLiteDatabase.execSQL("DROP TABLE arrival");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cb A[Catch:{ all -> 0x00e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(java.lang.String r6, int r7, long r8, org.json.JSONArray r10, java.lang.String r11) {
        /*
            r5 = this;
            if (r7 < 0) goto L_0x00fc
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x000a
            goto L_0x00fc
        L_0x000a:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r5.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.getWritableDatabase()     // Catch:{ SQLException -> 0x00c5 }
            r1.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x00c5 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x00bb }
            r2.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "state"
            java.lang.String r4 = "2"
            r2.put(r3, r4)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "endtime"
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00bb }
            r2.put(r3, r4)     // Catch:{ all -> 0x00bb }
            boolean r3 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00bb }
            if (r3 != 0) goto L_0x003b
            java.lang.String r3 = "logid"
            r2.put(r3, r11)     // Catch:{ all -> 0x00bb }
        L_0x003b:
            if (r10 == 0) goto L_0x004c
            int r3 = r10.length()     // Catch:{ all -> 0x00bb }
            if (r3 <= 0) goto L_0x004c
            java.lang.String r3 = "slot"
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00bb }
            r2.put(r3, r10)     // Catch:{ all -> 0x00bb }
        L_0x004c:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r10.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "flowid"
            r10.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "=\""
            r10.append(r3)     // Catch:{ all -> 0x00bb }
            r10.append(r6)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "\""
            r10.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = " AND "
            r10.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "flowhandle"
            r10.append(r3)     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = " = "
            r10.append(r3)     // Catch:{ all -> 0x00bb }
            r10.append(r7)     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = r10.toString()     // Catch:{ all -> 0x00bb }
            java.lang.String r10 = "flow"
            r3 = 0
            int r7 = r1.update(r10, r2, r7, r3)     // Catch:{ all -> 0x00bb }
            boolean r10 = f2015i     // Catch:{ all -> 0x00b9 }
            if (r10 == 0) goto L_0x0097
            r10 = 1
            if (r7 == r10) goto L_0x0097
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r10.<init>()     // Catch:{ all -> 0x00b9 }
            java.lang.String r2 = "endFlow#performTransaction: endFlow count:"
            r10.append(r2)     // Catch:{ all -> 0x00b9 }
            r10.append(r7)     // Catch:{ all -> 0x00b9 }
            r10.toString()     // Catch:{ all -> 0x00b9 }
        L_0x0097:
            fe.fe.mmm.aaa r10 = fe.fe.mmm.aaa.o()     // Catch:{ all -> 0x00b9 }
            r10.ad(r6, r0, r11)     // Catch:{ all -> 0x00b9 }
            com.baidu.ubc.UBCUploadTimingManager r10 = com.baidu.ubc.UBCUploadTimingManager.o()     // Catch:{ all -> 0x00b9 }
            r10.nn(r6, r7)     // Catch:{ all -> 0x00b9 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x00b9 }
            r1.endTransaction()     // Catch:{ SQLException -> 0x00c1 }
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = r5.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r6 = r6.writeLock()
            r6.unlock()
            if (r7 <= 0) goto L_0x00e0
            com.baidu.ubc.bypass.BypassConstants$Funnel r6 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_SUCCESS_FLOW
            goto L_0x00e2
        L_0x00b9:
            r6 = move-exception
            goto L_0x00bd
        L_0x00bb:
            r6 = move-exception
            r7 = 0
        L_0x00bd:
            r1.endTransaction()     // Catch:{ SQLException -> 0x00c1 }
            throw r6     // Catch:{ SQLException -> 0x00c1 }
        L_0x00c1:
            r6 = move-exception
            goto L_0x00c7
        L_0x00c3:
            r6 = move-exception
            goto L_0x00e8
        L_0x00c5:
            r6 = move-exception
            r7 = 0
        L_0x00c7:
            boolean r10 = f2015i     // Catch:{ all -> 0x00e6 }
            if (r10 == 0) goto L_0x00ce
            r6.printStackTrace()     // Catch:{ all -> 0x00e6 }
        L_0x00ce:
            fe.fe.mmm.fe r7 = r5.f2018ad     // Catch:{ all -> 0x00c3 }
            java.lang.String r10 = "write_"
            java.lang.String r11 = "endFlow"
            r7.uk(r6, r10, r11)     // Catch:{ all -> 0x00c3 }
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = r5.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r6 = r6.writeLock()
            r6.unlock()
        L_0x00e0:
            com.baidu.ubc.bypass.BypassConstants$Funnel r6 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_ERROR_FLOW
        L_0x00e2:
            fe.fe.mmm.n.qw.fe(r6, r8)
            return
        L_0x00e6:
            r6 = move-exception
            r0 = r7
        L_0x00e8:
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = r5.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r7 = r7.writeLock()
            r7.unlock()
            if (r0 <= 0) goto L_0x00f6
            com.baidu.ubc.bypass.BypassConstants$Funnel r7 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_SUCCESS_FLOW
            goto L_0x00f8
        L_0x00f6:
            com.baidu.ubc.bypass.BypassConstants$Funnel r7 = com.baidu.ubc.bypass.BypassConstants$Funnel.DB_ERROR_FLOW
        L_0x00f8:
            fe.fe.mmm.n.qw.fe(r7, r8)
            throw r6
        L_0x00fc:
            boolean r6 = f2015i
            if (r7 >= 0) goto L_0x0107
            fe.fe.mmm.c r6 = fe.fe.mmm.c.de()
            r6.when()
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.m(java.lang.String, int, long, org.json.JSONArray, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c9 A[Catch:{ all -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mmm(java.lang.String r11, int r12) {
        /*
            r10 = this;
            if (r12 < 0) goto L_0x0106
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 == 0) goto L_0x000a
            goto L_0x0106
        L_0x000a:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r10.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r0 = -1
            android.database.sqlite.SQLiteDatabase r1 = r10.getWritableDatabase()     // Catch:{ SQLException -> 0x00c3, all -> 0x00c0 }
            r1.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x00c3, all -> 0x00c0 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r2.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = "flowid"
            r2.append(r3)     // Catch:{ all -> 0x00b5 }
            java.lang.String r3 = "=\""
            r2.append(r3)     // Catch:{ all -> 0x00b5 }
            r2.append(r11)     // Catch:{ all -> 0x00b5 }
            java.lang.String r11 = "\""
            r2.append(r11)     // Catch:{ all -> 0x00b5 }
            java.lang.String r11 = " AND "
            r2.append(r11)     // Catch:{ all -> 0x00b5 }
            java.lang.String r11 = "flowhandle"
            r2.append(r11)     // Catch:{ all -> 0x00b5 }
            java.lang.String r11 = " = "
            r2.append(r11)     // Catch:{ all -> 0x00b5 }
            r2.append(r12)     // Catch:{ all -> 0x00b5 }
            java.lang.String r11 = r2.toString()     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "flow"
            r3 = 0
            int r6 = r1.delete(r2, r11, r3)     // Catch:{ all -> 0x00b5 }
            boolean r11 = f2015i     // Catch:{ all -> 0x00b5 }
            if (r11 == 0) goto L_0x0063
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
            r11.<init>()     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "cancelFlow#performTransaction: cancelFlow flow count:"
            r11.append(r2)     // Catch:{ all -> 0x00b5 }
            r11.append(r6)     // Catch:{ all -> 0x00b5 }
            r11.toString()     // Catch:{ all -> 0x00b5 }
        L_0x0063:
            java.lang.String r11 = "event"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r0.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r2 = "flowhandle = "
            r0.append(r2)     // Catch:{ all -> 0x00b2 }
            r0.append(r12)     // Catch:{ all -> 0x00b2 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x00b2 }
            int r11 = r1.delete(r11, r12, r3)     // Catch:{ all -> 0x00b2 }
            boolean r12 = f2015i     // Catch:{ all -> 0x00b2 }
            if (r12 == 0) goto L_0x008e
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r12.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r0 = "cancelFlow#performTransaction: cancelFlow event count:"
            r12.append(r0)     // Catch:{ all -> 0x00b2 }
            r12.append(r11)     // Catch:{ all -> 0x00b2 }
            r12.toString()     // Catch:{ all -> 0x00b2 }
        L_0x008e:
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x00b2 }
            r1.endTransaction()     // Catch:{ SQLException -> 0x00af, all -> 0x00ac }
            java.util.concurrent.locks.ReentrantReadWriteLock r11 = r10.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r11 = r11.writeLock()
            r11.unlock()
            if (r6 != 0) goto L_0x00ec
            fe.fe.mmm.c r4 = fe.fe.mmm.c.de()
            r5 = 0
            r7 = 0
            r8 = 1
            java.lang.String r9 = "deleteFlowByCancel"
            r4.uk(r5, r6, r7, r8, r9)
            goto L_0x00ec
        L_0x00ac:
            r11 = move-exception
            r2 = r6
            goto L_0x00ee
        L_0x00af:
            r11 = move-exception
            r2 = r6
            goto L_0x00c5
        L_0x00b2:
            r11 = move-exception
            r0 = r6
            goto L_0x00b6
        L_0x00b5:
            r11 = move-exception
        L_0x00b6:
            r1.endTransaction()     // Catch:{ SQLException -> 0x00bd, all -> 0x00ba }
            throw r11     // Catch:{ SQLException -> 0x00bd, all -> 0x00ba }
        L_0x00ba:
            r11 = move-exception
            r2 = r0
            goto L_0x00ee
        L_0x00bd:
            r11 = move-exception
            r2 = r0
            goto L_0x00c5
        L_0x00c0:
            r11 = move-exception
            r2 = -1
            goto L_0x00ee
        L_0x00c3:
            r11 = move-exception
            r2 = -1
        L_0x00c5:
            boolean r12 = f2015i     // Catch:{ all -> 0x00ed }
            if (r12 == 0) goto L_0x00cc
            r11.printStackTrace()     // Catch:{ all -> 0x00ed }
        L_0x00cc:
            fe.fe.mmm.fe r12 = r10.f2018ad     // Catch:{ all -> 0x00ed }
            java.lang.String r0 = "write_"
            java.lang.String r1 = "cancelFlow"
            r12.uk(r11, r0, r1)     // Catch:{ all -> 0x00ed }
            java.util.concurrent.locks.ReentrantReadWriteLock r11 = r10.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r11 = r11.writeLock()
            r11.unlock()
            if (r2 != 0) goto L_0x00ec
            fe.fe.mmm.c r0 = fe.fe.mmm.c.de()
            r1 = 0
            r3 = 0
            r4 = 1
            java.lang.String r5 = "deleteFlowByCancel"
            r0.uk(r1, r2, r3, r4, r5)
        L_0x00ec:
            return
        L_0x00ed:
            r11 = move-exception
        L_0x00ee:
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = r10.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r12 = r12.writeLock()
            r12.unlock()
            if (r2 != 0) goto L_0x0105
            fe.fe.mmm.c r0 = fe.fe.mmm.c.de()
            r1 = 0
            r3 = 0
            r4 = 1
            java.lang.String r5 = "deleteFlowByCancel"
            r0.uk(r1, r2, r3, r4, r5)
        L_0x0105:
            throw r11
        L_0x0106:
            boolean r11 = f2015i
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.mmm(java.lang.String, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0103, code lost:
        if (androidx.core.app.NotificationCompat.CATEGORY_EVENT.equals(r15) != false) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0105, code lost:
        r2 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_EVENT_LIMIT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0108, code lost:
        r2 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_FLOW_LIMIT;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010a, code lost:
        fe.fe.mmm.m.m128switch(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0172, code lost:
        if (androidx.core.app.NotificationCompat.CATEGORY_EVENT.equals(r15) != false) goto L_0x0105;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098 A[Catch:{ all -> 0x0114 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5 A[Catch:{ all -> 0x0111 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x012e A[Catch:{ all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0182  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:52:0x0116=Splitter:B:52:0x0116, B:21:0x008a=Splitter:B:21:0x008a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n(java.lang.String r15, boolean r16, boolean r17) {
        /*
            r14 = this;
            r1 = r14
            r8 = r15
            java.lang.String r0 = "_id"
            java.lang.String r9 = "event"
            java.lang.String r10 = ";table:"
            java.lang.String r11 = ";del:"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.lock()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r14.getWritableDatabase()     // Catch:{ SQLException -> 0x0128, all -> 0x0125 }
            r3.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x0128, all -> 0x0125 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r4.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "SELECT COUNT(*), MIN("
            r4.append(r5)     // Catch:{ all -> 0x011a }
            r4.append(r0)     // Catch:{ all -> 0x011a }
            java.lang.String r5 = "), MAX("
            r4.append(r5)     // Catch:{ all -> 0x011a }
            r4.append(r0)     // Catch:{ all -> 0x011a }
            java.lang.String r0 = ") FROM "
            r4.append(r0)     // Catch:{ all -> 0x011a }
            r4.append(r15)     // Catch:{ all -> 0x011a }
            r5 = 0
            java.lang.String r0 = r4.toString()     // Catch:{ RuntimeException -> 0x0091, all -> 0x008e }
            android.database.Cursor r4 = r3.rawQuery(r0, r5)     // Catch:{ RuntimeException -> 0x0091, all -> 0x008e }
            if (r4 == 0) goto L_0x0089
            int r0 = r4.getCount()     // Catch:{ RuntimeException -> 0x0087 }
            if (r0 <= 0) goto L_0x0089
            r4.moveToFirst()     // Catch:{ RuntimeException -> 0x0087 }
            int r0 = r4.getInt(r2)     // Catch:{ RuntimeException -> 0x0087 }
            fe.fe.mmm.i r6 = fe.fe.mmm.i.vvv()     // Catch:{ RuntimeException -> 0x0087 }
            int r6 = r6.when()     // Catch:{ RuntimeException -> 0x0087 }
            if (r0 <= r6) goto L_0x0089
            r0 = 1
            int r0 = r4.getInt(r0)     // Catch:{ RuntimeException -> 0x0087 }
            r6 = 2
            int r7 = r4.getInt(r6)     // Catch:{ RuntimeException -> 0x0087 }
            int r13 = r0 + r7
            int r13 = r13 / r6
            java.lang.String r6 = "min:"
            r12.append(r6)     // Catch:{ RuntimeException -> 0x0085 }
            r12.append(r0)     // Catch:{ RuntimeException -> 0x0085 }
            java.lang.String r0 = ";max:"
            r12.append(r0)     // Catch:{ RuntimeException -> 0x0085 }
            r12.append(r7)     // Catch:{ RuntimeException -> 0x0085 }
            java.lang.String r0 = ";mid:"
            r12.append(r0)     // Catch:{ RuntimeException -> 0x0085 }
            r12.append(r13)     // Catch:{ RuntimeException -> 0x0085 }
            goto L_0x008a
        L_0x0085:
            r0 = move-exception
            goto L_0x0094
        L_0x0087:
            r0 = move-exception
            goto L_0x0093
        L_0x0089:
            r13 = 0
        L_0x008a:
            fe.fe.mmm.u.qw.qw(r4)     // Catch:{ all -> 0x011a }
            goto L_0x009c
        L_0x008e:
            r0 = move-exception
            goto L_0x0116
        L_0x0091:
            r0 = move-exception
            r4 = r5
        L_0x0093:
            r13 = 0
        L_0x0094:
            boolean r6 = f2015i     // Catch:{ all -> 0x0114 }
            if (r6 == 0) goto L_0x008a
            r0.printStackTrace()     // Catch:{ all -> 0x0114 }
            goto L_0x008a
        L_0x009c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x011a }
            r0.<init>()     // Catch:{ all -> 0x011a }
            java.lang.String r4 = "_id < "
            r0.append(r4)     // Catch:{ all -> 0x011a }
            r0.append(r13)     // Catch:{ all -> 0x011a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x011a }
            int r13 = r3.delete(r15, r0, r5)     // Catch:{ all -> 0x011a }
            boolean r0 = f2015i     // Catch:{ all -> 0x0111 }
            if (r0 == 0) goto L_0x00c5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0111 }
            r0.<init>()     // Catch:{ all -> 0x0111 }
            java.lang.String r2 = "ensureDataBaseLimit#performTransaction: delete count:"
            r0.append(r2)     // Catch:{ all -> 0x0111 }
            r0.append(r13)     // Catch:{ all -> 0x0111 }
            r0.toString()     // Catch:{ all -> 0x0111 }
        L_0x00c5:
            r3.setTransactionSuccessful()     // Catch:{ all -> 0x0111 }
            r3.endTransaction()     // Catch:{ SQLException -> 0x010f }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            if (r13 <= 0) goto L_0x0175
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            fe.fe.mmm.i r0 = fe.fe.mmm.i.vvv()
            int r0 = r0.when()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            r4 = r13
            r5 = r15
            r6 = r16
            r7 = r17
            r2.fe(r3, r4, r5, r6, r7)
            r12.append(r11)
            r12.append(r13)
            r12.append(r10)
            r12.append(r15)
            java.lang.String r0 = r12.toString()
            boolean r2 = r9.equals(r15)
            if (r2 == 0) goto L_0x0108
        L_0x0105:
            com.baidu.ubc.constants.EnumConstants$RunTime r2 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_EVENT_LIMIT
            goto L_0x010a
        L_0x0108:
            com.baidu.ubc.constants.EnumConstants$RunTime r2 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_FLOW_LIMIT
        L_0x010a:
            fe.fe.mmm.m.m128switch(r0, r2)
            goto L_0x0175
        L_0x010f:
            r0 = move-exception
            goto L_0x012a
        L_0x0111:
            r0 = move-exception
            r2 = r13
            goto L_0x011b
        L_0x0114:
            r0 = move-exception
            r5 = r4
        L_0x0116:
            fe.fe.mmm.u.qw.qw(r5)     // Catch:{ all -> 0x011a }
            throw r0     // Catch:{ all -> 0x011a }
        L_0x011a:
            r0 = move-exception
        L_0x011b:
            r3.endTransaction()     // Catch:{ SQLException -> 0x0122, all -> 0x011f }
            throw r0     // Catch:{ SQLException -> 0x0122, all -> 0x011f }
        L_0x011f:
            r0 = move-exception
            r13 = r2
            goto L_0x0177
        L_0x0122:
            r0 = move-exception
            r13 = r2
            goto L_0x012a
        L_0x0125:
            r0 = move-exception
            r13 = 0
            goto L_0x0177
        L_0x0128:
            r0 = move-exception
            r13 = 0
        L_0x012a:
            boolean r2 = f2015i     // Catch:{ all -> 0x0176 }
            if (r2 == 0) goto L_0x0131
            r0.printStackTrace()     // Catch:{ all -> 0x0176 }
        L_0x0131:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x0176 }
            java.lang.String r3 = "write_"
            java.lang.String r4 = "ensureDataBaseLimit"
            r2.uk(r0, r3, r4)     // Catch:{ all -> 0x0176 }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            if (r13 <= 0) goto L_0x0175
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            fe.fe.mmm.i r0 = fe.fe.mmm.i.vvv()
            int r0 = r0.when()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            r4 = r13
            r5 = r15
            r6 = r16
            r7 = r17
            r2.fe(r3, r4, r5, r6, r7)
            r12.append(r11)
            r12.append(r13)
            r12.append(r10)
            r12.append(r15)
            java.lang.String r0 = r12.toString()
            boolean r2 = r9.equals(r15)
            if (r2 == 0) goto L_0x0108
            goto L_0x0105
        L_0x0175:
            return r13
        L_0x0176:
            r0 = move-exception
        L_0x0177:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.unlock()
            if (r13 <= 0) goto L_0x01b9
            fe.fe.mmm.c r2 = fe.fe.mmm.c.de()
            fe.fe.mmm.i r3 = fe.fe.mmm.i.vvv()
            int r3 = r3.when()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r4 = r13
            r5 = r15
            r6 = r16
            r7 = r17
            r2.fe(r3, r4, r5, r6, r7)
            r12.append(r11)
            r12.append(r13)
            r12.append(r10)
            r12.append(r15)
            java.lang.String r2 = r12.toString()
            boolean r3 = r9.equals(r15)
            if (r3 == 0) goto L_0x01b4
            com.baidu.ubc.constants.EnumConstants$RunTime r3 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_EVENT_LIMIT
            goto L_0x01b6
        L_0x01b4:
            com.baidu.ubc.constants.EnumConstants$RunTime r3 = com.baidu.ubc.constants.EnumConstants$RunTime.CLEAR_DB_FLOW_LIMIT
        L_0x01b6:
            fe.fe.mmm.m.m128switch(r2, r3)
        L_0x01b9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.n(java.lang.String, boolean, boolean):int");
    }

    public final void nn(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE file ADD COLUMN uploadfirst LONG");
            sQLiteDatabase.execSQL("ALTER TABLE file ADD COLUMN uploadindex INTEGER");
        } catch (SQLiteException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.enableWriteAheadLogging();
        super.onConfigure(sQLiteDatabase);
        this.f2021yj = I(sQLiteDatabase);
        yj.ad().fe(this.f2021yj);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (f2015i) {
            "Creating database " + f2016o + " version " + 14;
        }
        try {
            d(sQLiteDatabase);
            k.qw().yj("ubc_cloudconfig_version", "0");
        } catch (Exception e) {
            "Error while creating db: " + e.toString();
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (f2015i) {
            "Downgrade database " + f2016o + " old version :" + i2 + " new version :" + i3;
        }
        try {
            sQLiteDatabase.beginTransaction();
            l(sQLiteDatabase);
            d(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Throwable th2) {
            sQLiteDatabase.endTransaction();
            throw th2;
        }
        sQLiteDatabase.endTransaction();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        xxx(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        ppp(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        ddd(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005a, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        vvv(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onUpgrade(android.database.sqlite.SQLiteDatabase r3, int r4, int r5) {
        /*
            r2 = this;
            boolean r0 = f2015i
            if (r0 == 0) goto L_0x0026
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Upgrade database "
            r0.append(r1)
            java.lang.String r1 = f2016o
            r0.append(r1)
            java.lang.String r1 = " old version :"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " new version :"
            r0.append(r1)
            r0.append(r5)
            r0.toString()
        L_0x0026:
            r3.beginTransaction()     // Catch:{ all -> 0x0061 }
        L_0x0029:
            if (r4 >= r5) goto L_0x005d
            switch(r4) {
                case 1: goto L_0x0057;
                case 2: goto L_0x0053;
                case 3: goto L_0x004f;
                case 4: goto L_0x004b;
                case 5: goto L_0x002e;
                case 6: goto L_0x0047;
                case 7: goto L_0x0043;
                case 8: goto L_0x003f;
                case 9: goto L_0x002f;
                case 10: goto L_0x0032;
                case 11: goto L_0x0035;
                case 12: goto L_0x0038;
                case 13: goto L_0x003b;
                default: goto L_0x002e;
            }     // Catch:{ all -> 0x0061 }
        L_0x002e:
            goto L_0x005a
        L_0x002f:
            r2.nn(r3)     // Catch:{ all -> 0x0061 }
        L_0x0032:
            r2.vvv(r3)     // Catch:{ all -> 0x0061 }
        L_0x0035:
            r2.xxx(r3)     // Catch:{ all -> 0x0061 }
        L_0x0038:
            r2.ppp(r3)     // Catch:{ all -> 0x0061 }
        L_0x003b:
            r2.ddd(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x005a
        L_0x003f:
            r2.fe(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x005a
        L_0x0043:
            r2.c(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x005a
        L_0x0047:
            r2.when(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x005a
        L_0x004b:
            r2.yj(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x005a
        L_0x004f:
            r2.th(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x005a
        L_0x0053:
            r2.ggg(r3)     // Catch:{ all -> 0x0061 }
            goto L_0x005a
        L_0x0057:
            r2.e(r3)     // Catch:{ all -> 0x0061 }
        L_0x005a:
            int r4 = r4 + 1
            goto L_0x0029
        L_0x005d:
            r3.setTransactionSuccessful()     // Catch:{ all -> 0x0061 }
            goto L_0x0081
        L_0x0061:
            r4 = move-exception
            boolean r5 = f2015i     // Catch:{ all -> 0x0085 }
            if (r5 == 0) goto L_0x0081
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r5.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0085 }
            r5.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r0 = "\n"
            r5.append(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = android.util.Log.getStackTraceString(r4)     // Catch:{ all -> 0x0085 }
            r5.append(r4)     // Catch:{ all -> 0x0085 }
            r5.toString()     // Catch:{ all -> 0x0085 }
        L_0x0081:
            r3.endTransaction()
            return
        L_0x0085:
            r4 = move-exception
            r3.endTransaction()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.onUpgrade(android.database.sqlite.SQLiteDatabase, int, int):void");
    }

    public final String p(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT a.* FROM ");
        if (z) {
            sb.append(NotificationCompat.CATEGORY_EVENT);
            sb.append(" a ");
            sb.append("LEFT JOIN ");
            sb.append("config");
            sb.append(" b ");
            sb.append("ON a.");
            sb.append("eventid");
            sb.append(" = b.");
            sb.append("eventid");
            sb.append(" WHERE ");
            sb.append("a.");
            sb.append("flowhandle");
            sb.append(" = ");
            sb.append(-1);
            sb.append(" AND ");
            sb.append("(a.");
            sb.append("reallog");
            sb.append(" = '0' OR a.");
            sb.append("reallog");
            sb.append(" = '')");
        } else {
            sb.append("flow");
            sb.append(" a ");
            sb.append("LEFT JOIN ");
            sb.append("config");
            sb.append(" b ");
            sb.append("ON a.");
            sb.append("flowid");
            sb.append(" = b.");
            sb.append("eventid");
            sb.append(" WHERE ");
            sb.append("a.");
            sb.append("endtime");
            sb.append(" IS NOT NULL");
        }
        if (z3) {
            sb.append(" AND (b.");
            sb.append("switch");
            sb.append(" IS NULL OR b.");
            sb.append("switch");
            sb.append(" = '");
            sb.append("1");
            sb.append("')");
        } else {
            sb.append(" AND b.");
            sb.append("switch");
            sb.append(" = '");
            sb.append("1");
            sb.append("'");
        }
        if (z2) {
            sb.append(" AND ");
            sb.append("(b.");
            sb.append("cycle");
            sb.append(" = 0)");
            sb.append(" ORDER BY a.");
            sb.append("begintime");
            sb.append(" DESC");
        } else {
            sb.append(" AND ");
            sb.append("(b.");
            sb.append("cycle");
            sb.append(" > 0)");
            sb.append(" ORDER BY a.");
            sb.append("begintime");
            sb.append(" ASC");
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x014e A[Catch:{ all -> 0x0161 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0174 A[Catch:{ all -> 0x016c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pf(java.lang.String r24, java.lang.String r25) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            r2 = r25
            java.lang.String r3 = "ubctime"
            java.lang.String r4 = "ubcid"
            java.lang.String r5 = "addOrUpdateUBCRecord"
            java.lang.String r6 = "write_"
            boolean r7 = android.text.TextUtils.isEmpty(r24)
            if (r7 != 0) goto L_0x0190
            boolean r7 = android.text.TextUtils.isEmpty(r25)
            if (r7 == 0) goto L_0x001c
            goto L_0x0190
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r7 = r7.writeLock()
            r7.lock()
            android.database.sqlite.SQLiteDatabase r7 = r23.getWritableDatabase()     // Catch:{ SQLException -> 0x016e }
            r7.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x016e }
            r15 = 0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            r8.<init>()     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            r8.append(r4)     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            java.lang.String r9 = " = ?"
            r8.append(r9)     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            java.lang.String r9 = " AND "
            r8.append(r9)     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            java.lang.String r9 = "date("
            r8.append(r9)     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            r8.append(r3)     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            java.lang.String r9 = ")"
            r8.append(r9)     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            java.lang.String r9 = " = date('now', 'localtime')"
            r8.append(r9)     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            java.lang.String r14 = r8.toString()     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            r13 = 1
            java.lang.String[] r12 = new java.lang.String[r13]     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            r16 = 0
            r12[r16] = r0     // Catch:{ SQLException -> 0x0146, all -> 0x013f }
            java.lang.String r9 = "arrival"
            r10 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r8 = r7
            r11 = r14
            r20 = r12
            r21 = 1
            r13 = r17
            r22 = r14
            r14 = r18
            r17 = r5
            r5 = r15
            r15 = r19
            android.database.Cursor r15 = r8.query(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ SQLException -> 0x013c, all -> 0x0139 }
            java.lang.String r8 = "arrival"
            java.lang.String r9 = "state"
            java.lang.String r10 = "logid"
            java.lang.String r11 = "count"
            if (r15 == 0) goto L_0x00e9
            int r12 = r15.getCount()     // Catch:{ SQLException -> 0x00e7 }
            if (r12 <= 0) goto L_0x00e9
            r15.moveToFirst()     // Catch:{ SQLException -> 0x00e7 }
            int r0 = r15.getColumnIndex(r11)     // Catch:{ SQLException -> 0x00e7 }
            int r3 = r15.getColumnIndex(r10)     // Catch:{ SQLException -> 0x00e7 }
            int r0 = r15.getInt(r0)     // Catch:{ SQLException -> 0x00e7 }
            java.lang.String r3 = r15.getString(r3)     // Catch:{ SQLException -> 0x00e7 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ SQLException -> 0x00e7 }
            r4.<init>()     // Catch:{ SQLException -> 0x00e7 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLException -> 0x00e7 }
            r4.put(r9, r5)     // Catch:{ SQLException -> 0x00e7 }
            int r5 = r0 + 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLException -> 0x00e7 }
            r4.put(r11, r5)     // Catch:{ SQLException -> 0x00e7 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLException -> 0x00e7 }
            if (r5 == 0) goto L_0x00ba
            if (r0 > 0) goto L_0x00c5
        L_0x00ba:
            fe.fe.mmm.aaa r0 = fe.fe.mmm.aaa.o()     // Catch:{ SQLException -> 0x00e7 }
            java.lang.String r0 = r0.m116if(r3, r2)     // Catch:{ SQLException -> 0x00e7 }
            r4.put(r10, r0)     // Catch:{ SQLException -> 0x00e7 }
        L_0x00c5:
            r2 = r20
            r0 = r22
            int r0 = r7.update(r8, r4, r0, r2)     // Catch:{ SQLException -> 0x00e7 }
            boolean r2 = f2015i     // Catch:{ SQLException -> 0x00e7 }
            if (r2 == 0) goto L_0x012b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x00e7 }
            r2.<init>()     // Catch:{ SQLException -> 0x00e7 }
            java.lang.String r3 = "addUBCRecords update "
            r2.append(r3)     // Catch:{ SQLException -> 0x00e7 }
            r2.append(r0)     // Catch:{ SQLException -> 0x00e7 }
            java.lang.String r0 = " records"
            r2.append(r0)     // Catch:{ SQLException -> 0x00e7 }
            r2.toString()     // Catch:{ SQLException -> 0x00e7 }
            goto L_0x012b
        L_0x00e7:
            r0 = move-exception
            goto L_0x014a
        L_0x00e9:
            if (r15 == 0) goto L_0x012b
            java.text.SimpleDateFormat r12 = new java.text.SimpleDateFormat     // Catch:{ SQLException -> 0x00e7 }
            java.lang.String r13 = "yyyy-MM-dd"
            r12.<init>(r13)     // Catch:{ SQLException -> 0x00e7 }
            java.util.Date r13 = new java.util.Date     // Catch:{ SQLException -> 0x00e7 }
            r13.<init>()     // Catch:{ SQLException -> 0x00e7 }
            java.lang.String r12 = r12.format(r13)     // Catch:{ SQLException -> 0x00e7 }
            android.content.ContentValues r13 = new android.content.ContentValues     // Catch:{ SQLException -> 0x00e7 }
            r13.<init>()     // Catch:{ SQLException -> 0x00e7 }
            r13.put(r4, r0)     // Catch:{ SQLException -> 0x00e7 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)     // Catch:{ SQLException -> 0x00e7 }
            r13.put(r11, r0)     // Catch:{ SQLException -> 0x00e7 }
            java.lang.String r0 = "callcnt"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLException -> 0x00e7 }
            r13.put(r0, r4)     // Catch:{ SQLException -> 0x00e7 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLException -> 0x00e7 }
            r13.put(r9, r0)     // Catch:{ SQLException -> 0x00e7 }
            r13.put(r3, r12)     // Catch:{ SQLException -> 0x00e7 }
            fe.fe.mmm.aaa r0 = fe.fe.mmm.aaa.o()     // Catch:{ SQLException -> 0x00e7 }
            java.lang.String r0 = r0.uk(r2)     // Catch:{ SQLException -> 0x00e7 }
            r13.put(r10, r0)     // Catch:{ SQLException -> 0x00e7 }
            r7.insert(r8, r5, r13)     // Catch:{ SQLException -> 0x00e7 }
        L_0x012b:
            r7.setTransactionSuccessful()     // Catch:{ SQLException -> 0x00e7 }
            fe.fe.mmm.u.qw.qw(r15)     // Catch:{ SQLException -> 0x0135 }
            r7.endTransaction()     // Catch:{ SQLException -> 0x0135 }
            goto L_0x017c
        L_0x0135:
            r0 = move-exception
            r3 = r17
            goto L_0x0170
        L_0x0139:
            r0 = move-exception
            r15 = r5
            goto L_0x0143
        L_0x013c:
            r0 = move-exception
            r15 = r5
            goto L_0x014a
        L_0x013f:
            r0 = move-exception
            r17 = r5
            r5 = r15
        L_0x0143:
            r3 = r17
            goto L_0x0163
        L_0x0146:
            r0 = move-exception
            r17 = r5
            r5 = r15
        L_0x014a:
            boolean r2 = f2015i     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x0151
            r0.printStackTrace()     // Catch:{ all -> 0x0161 }
        L_0x0151:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x0161 }
            r3 = r17
            r2.uk(r0, r6, r3)     // Catch:{ all -> 0x015f }
            fe.fe.mmm.u.qw.qw(r15)     // Catch:{ SQLException -> 0x016a }
            r7.endTransaction()     // Catch:{ SQLException -> 0x016a }
            goto L_0x017c
        L_0x015f:
            r0 = move-exception
            goto L_0x0163
        L_0x0161:
            r0 = move-exception
            goto L_0x0143
        L_0x0163:
            fe.fe.mmm.u.qw.qw(r15)     // Catch:{ SQLException -> 0x016a }
            r7.endTransaction()     // Catch:{ SQLException -> 0x016a }
            throw r0     // Catch:{ SQLException -> 0x016a }
        L_0x016a:
            r0 = move-exception
            goto L_0x0170
        L_0x016c:
            r0 = move-exception
            goto L_0x0186
        L_0x016e:
            r0 = move-exception
            r3 = r5
        L_0x0170:
            boolean r2 = f2015i     // Catch:{ all -> 0x016c }
            if (r2 == 0) goto L_0x0177
            r0.printStackTrace()     // Catch:{ all -> 0x016c }
        L_0x0177:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x016c }
            r2.uk(r0, r6, r3)     // Catch:{ all -> 0x016c }
        L_0x017c:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            return
        L_0x0186:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.unlock()
            throw r0
        L_0x0190:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.pf(java.lang.String, java.lang.String):void");
    }

    public final void ppp(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE arrival ADD COLUMN logid TEXT");
        } catch (SQLiteException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public int q(l lVar, l lVar2) {
        int s = s(lVar, lVar2);
        if (lVar.j() && lVar2.j()) {
            return 1;
        }
        if (!lVar.f() || !lVar2.f()) {
            return r(lVar, lVar2) | s;
        }
        return 0;
    }

    public final String qqq(SQLiteDatabase sQLiteDatabase) {
        Cursor rawQuery;
        StringBuilder sb = new StringBuilder();
        try {
            rawQuery = sQLiteDatabase.rawQuery("PRAGMA wal_checkpoint(FULL);", (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    do {
                        sb.append(rawQuery.getString(0));
                        sb.append("_");
                        sb.append(rawQuery.getString(1));
                        sb.append("_");
                        sb.append(rawQuery.getString(2));
                    } while (rawQuery.moveToNext());
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return sb.toString();
        throw th;
    }

    public void qw(l lVar) {
        eee eee = this;
        l lVar2 = lVar;
        boolean j = i.vvv().j();
        eee.f2020uk.readLock().lock();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT a.* FROM ");
            String str = "SELECT a.* FROM ";
            sb.append(NotificationCompat.CATEGORY_EVENT);
            sb.append(" a ");
            sb.append("LEFT JOIN ");
            sb.append("config");
            sb.append(" b ");
            sb.append("ON a.");
            sb.append("eventid");
            sb.append(" = b.");
            sb.append("eventid");
            sb.append(" WHERE ");
            sb.append("a.");
            sb.append("flowhandle");
            sb.append(" = ");
            sb.append(-1);
            sb.append(" AND ");
            sb.append("(a.");
            sb.append("reallog");
            sb.append(" = '0' OR a.");
            sb.append("reallog");
            sb.append(" = '')");
            String str2 = " WHERE ";
            String str3 = "eventid";
            String str4 = " = b.";
            String str5 = "ON a.";
            String str6 = " b ";
            String str7 = "config";
            if (j) {
                sb.append(" AND (b.");
                sb.append("switch");
                sb.append(" IS NULL OR b.");
                sb.append("switch");
                sb.append(" = '");
                sb.append("1");
                sb.append("')");
            } else {
                sb.append(" AND b.");
                sb.append("switch");
                sb.append(" = '");
                sb.append("1");
                sb.append("'");
            }
            sb.append(" ORDER BY b.");
            sb.append("cycle");
            sb.append(" ASC");
            String str8 = " ASC";
            l lVar3 = lVar;
            eee.x(sb.toString(), lVar3);
            if (!lVar.f()) {
                if (!lVar.j()) {
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        sb2.append(str);
                        sb2.append("flow");
                        sb2.append(" a ");
                        sb2.append("LEFT JOIN ");
                        sb2.append(str7);
                        sb2.append(str6);
                        sb2.append(str5);
                        sb2.append("flowid");
                        sb2.append(str4);
                        sb2.append(str3);
                        sb2.append(str2);
                        sb2.append(" a.");
                        sb2.append("endtime");
                        sb2.append(" IS NOT NULL");
                        if (j) {
                            sb2.append(" AND (b.");
                            sb2.append("switch");
                            sb2.append(" IS NULL OR b.");
                            sb2.append("switch");
                            sb2.append(" = '");
                            sb2.append("1");
                            sb2.append("')");
                        } else {
                            sb2.append(" AND b.");
                            sb2.append("switch");
                            sb2.append(" = '");
                            sb2.append("1");
                            sb2.append("'");
                        }
                        sb2.append(" ORDER BY b.");
                        sb2.append("cycle");
                        sb2.append(str8);
                        eee = this;
                        eee.A(sb2.toString(), lVar3);
                    } catch (SQLException e) {
                        e = e;
                        eee = this;
                        try {
                            if (f2015i) {
                                e.printStackTrace();
                            }
                            eee.f2018ad.uk(e, "read_", "acquireAllValidData");
                            eee.f2020uk.readLock().unlock();
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            eee.f2020uk.readLock().unlock();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        eee = this;
                        eee.f2020uk.readLock().unlock();
                        throw th;
                    }
                    eee.f2020uk.readLock().unlock();
                    return;
                }
            }
            eee.f2020uk.readLock().unlock();
        } catch (SQLException e2) {
            e = e2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00dc, code lost:
        if (r24.f() == false) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01ee A[LOOP:0: B:11:0x0071->B:108:0x01ee, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0219 A[Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e, all -> 0x0222 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0230 A[Catch:{ all -> 0x0227 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01eb A[EDGE_INSN: B:148:0x01eb->B:107:0x01eb ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:131:0x0223=Splitter:B:131:0x0223, B:116:0x0208=Splitter:B:116:0x0208} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int r(fe.fe.mmm.l r24, fe.fe.mmm.l r25) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r0 = "bizInfo"
            java.lang.String r2 = "bizparam"
            java.lang.String r3 = "option"
            java.lang.String r4 = "SELECT * FROM event WHERE flowhandle = -1 AND reallog = \"0\""
            java.util.concurrent.locks.ReentrantReadWriteLock r5 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r5 = r5.readLock()
            r5.lock()
            boolean r6 = r24.j()     // Catch:{ SQLException -> 0x0229 }
            boolean r7 = r25.j()     // Catch:{ SQLException -> 0x0229 }
            android.database.sqlite.SQLiteDatabase r8 = r23.getReadableDatabase()     // Catch:{ SQLException -> 0x0229 }
            r9 = 0
            android.database.Cursor r9 = r8.rawQuery(r4, r9)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            if (r9 == 0) goto L_0x0206
            int r4 = r9.getCount()     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            if (r4 <= 0) goto L_0x0206
            r9.moveToFirst()     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r4 = "eventid"
            int r4 = r9.getColumnIndex(r4)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r8 = "begintime"
            int r8 = r9.getColumnIndex(r8)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r10 = "content"
            int r10 = r9.getColumnIndex(r10)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r11 = "reserve1"
            int r11 = r9.getColumnIndex(r11)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r12 = "reserve2"
            int r12 = r9.getColumnIndex(r12)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r13 = "extend"
            int r13 = r9.getColumnIndex(r13)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r14 = "_id"
            int r14 = r9.getColumnIndex(r14)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r15 = "logid"
            int r15 = r9.getColumnIndex(r15)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            java.lang.String r5 = "uuid"
            int r5 = r9.getColumnIndex(r5)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            r16 = r6
            java.lang.String r6 = "appversion"
            int r6 = r9.getColumnIndex(r6)     // Catch:{ JSONException -> 0x021d, RuntimeException -> 0x0212, all -> 0x020e }
            r18 = r6
            r17 = 0
        L_0x0071:
            java.lang.String r6 = r9.getString(r4)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r19 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r19 == 0) goto L_0x008c
            r19 = r4
            r6 = r5
            r21 = r7
            r22 = r8
            r7 = r18
            r5 = r24
        L_0x0086:
            r18 = r0
            r0 = r25
            goto L_0x01b7
        L_0x008c:
            r19 = r4
            fe.fe.mmm.vvv r4 = new fe.fe.mmm.vvv     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r4.<init>(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r20 = r5
            fe.fe.mmm.i r5 = fe.fe.mmm.i.vvv()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r5 = r5.rg(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r16 == 0) goto L_0x00a3
            if (r7 == 0) goto L_0x00a3
            goto L_0x01eb
        L_0x00a3:
            if (r16 == 0) goto L_0x00b2
            if (r5 == 0) goto L_0x00b2
        L_0x00a7:
            r5 = r24
            r21 = r7
            r22 = r8
            r7 = r18
            r6 = r20
            goto L_0x0086
        L_0x00b2:
            if (r7 == 0) goto L_0x00b7
            if (r5 != 0) goto L_0x00b7
            goto L_0x00a7
        L_0x00b7:
            boolean r6 = r24.f()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r6 == 0) goto L_0x00d6
            boolean r6 = r25.f()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r6 == 0) goto L_0x00d6
            fe.fe.mmm.u.qw.qw(r9)     // Catch:{ SQLException -> 0x00d1 }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            r2 = 0
            return r2
        L_0x00d1:
            r0 = move-exception
            r5 = r17
            goto L_0x022c
        L_0x00d6:
            if (r5 == 0) goto L_0x00de
            boolean r6 = r24.f()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r6 != 0) goto L_0x00a7
        L_0x00de:
            if (r5 == 0) goto L_0x00e7
            boolean r6 = r25.f()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r6 == 0) goto L_0x00e7
            goto L_0x00a7
        L_0x00e7:
            int r6 = r9.getInt(r14)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r4.k(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r21 = r7
            long r6 = r9.getLong(r8)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r4.l(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            java.lang.String r6 = r9.getString(r10)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r7 != 0) goto L_0x0104
            r4.b(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x0104:
            java.lang.String r6 = r9.getString(r11)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r7 != 0) goto L_0x0111
            r4.e(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x0111:
            java.lang.String r6 = r9.getString(r12)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r7 != 0) goto L_0x011e
            r4.a(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x011e:
            java.lang.String r6 = r9.getString(r13)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r22 = r8
            r8 = 1
            if (r7 != 0) goto L_0x0163
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r7.<init>(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            java.lang.String r6 = "ctr"
            boolean r6 = r7.has(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r6 == 0) goto L_0x013b
            r4.c(r8)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x013b:
            boolean r6 = r7.has(r3)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r6 == 0) goto L_0x0149
            r6 = 0
            int r8 = r7.optInt(r3, r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r4.h(r8)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x0149:
            boolean r6 = r7.has(r2)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r6 == 0) goto L_0x0156
            org.json.JSONObject r6 = r7.optJSONObject(r2)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r4.tt(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x0156:
            boolean r6 = r7.has(r0)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r6 == 0) goto L_0x0163
            java.lang.String r6 = r7.optString(r0)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r4.rrr(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x0163:
            java.lang.String r6 = r9.getString(r15)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r7 != 0) goto L_0x0170
            r4.g(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x0170:
            r6 = r20
            java.lang.String r7 = r9.getString(r6)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r8 != 0) goto L_0x017f
            r4.m(r7)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x017f:
            r7 = r18
            java.lang.String r8 = r9.getString(r7)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            boolean r18 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r18 != 0) goto L_0x018e
            r4.eee(r8)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
        L_0x018e:
            int r8 = r4.o()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r5 == 0) goto L_0x01ab
            r5 = r24
            boolean r4 = r1.rg(r4, r8, r5)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r4 != 0) goto L_0x019e
            goto L_0x0086
        L_0x019e:
            boolean r4 = r24.j()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            r18 = r0
            if (r4 == 0) goto L_0x01a8
            r16 = 1
        L_0x01a8:
            r0 = r25
            goto L_0x01c1
        L_0x01ab:
            r5 = r24
            r18 = r0
            r0 = r25
            boolean r4 = r1.rg(r4, r8, r0)     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r4 != 0) goto L_0x01b9
        L_0x01b7:
            r4 = 0
            goto L_0x01e5
        L_0x01b9:
            boolean r4 = r25.j()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r4 == 0) goto L_0x01c1
            r21 = 1
        L_0x01c1:
            if (r17 != 0) goto L_0x01c5
            r17 = 1
        L_0x01c5:
            boolean r4 = r24.f()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r4 == 0) goto L_0x01df
            boolean r4 = r25.f()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r4 == 0) goto L_0x01df
            fe.fe.mmm.u.qw.qw(r9)     // Catch:{ SQLException -> 0x00d1 }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            r4 = 0
            return r4
        L_0x01df:
            r4 = 0
            if (r16 == 0) goto L_0x01e5
            if (r21 == 0) goto L_0x01e5
            goto L_0x01eb
        L_0x01e5:
            boolean r8 = r9.moveToNext()     // Catch:{ JSONException -> 0x0203, RuntimeException -> 0x01ff, all -> 0x01fb }
            if (r8 != 0) goto L_0x01ee
        L_0x01eb:
            r5 = r17
            goto L_0x0208
        L_0x01ee:
            r5 = r6
            r0 = r18
            r4 = r19
            r8 = r22
            r18 = r7
            r7 = r21
            goto L_0x0071
        L_0x01fb:
            r0 = move-exception
            r5 = r17
            goto L_0x0223
        L_0x01ff:
            r0 = move-exception
            r5 = r17
            goto L_0x0215
        L_0x0203:
            r5 = r17
            goto L_0x021f
        L_0x0206:
            r4 = 0
            r5 = 0
        L_0x0208:
            fe.fe.mmm.u.qw.qw(r9)     // Catch:{ SQLException -> 0x020c }
            goto L_0x023c
        L_0x020c:
            r0 = move-exception
            goto L_0x022c
        L_0x020e:
            r0 = move-exception
            r4 = 0
            r5 = 0
            goto L_0x0223
        L_0x0212:
            r0 = move-exception
            r4 = 0
            r5 = 0
        L_0x0215:
            boolean r2 = f2015i     // Catch:{ all -> 0x0222 }
            if (r2 == 0) goto L_0x0208
            r0.printStackTrace()     // Catch:{ all -> 0x0222 }
            goto L_0x0208
        L_0x021d:
            r4 = 0
            r5 = 0
        L_0x021f:
            boolean r0 = f2015i     // Catch:{ all -> 0x0222 }
            goto L_0x0208
        L_0x0222:
            r0 = move-exception
        L_0x0223:
            fe.fe.mmm.u.qw.qw(r9)     // Catch:{ SQLException -> 0x020c }
            throw r0     // Catch:{ SQLException -> 0x020c }
        L_0x0227:
            r0 = move-exception
            goto L_0x0246
        L_0x0229:
            r0 = move-exception
            r4 = 0
            r5 = 0
        L_0x022c:
            boolean r2 = f2015i     // Catch:{ all -> 0x0227 }
            if (r2 == 0) goto L_0x0233
            r0.printStackTrace()     // Catch:{ all -> 0x0227 }
        L_0x0233:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x0227 }
            java.lang.String r3 = "read_"
            java.lang.String r4 = "getAllEventDataExcludeReallog"
            r2.uk(r0, r3, r4)     // Catch:{ all -> 0x0227 }
        L_0x023c:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r5
        L_0x0246:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.r(fe.fe.mmm.l, fe.fe.mmm.l):int");
    }

    public final boolean rg(vvv vvv, int i2, l lVar) {
        fe.fe.mmm.n.qw.rg(BypassConstants$Funnel.PACKAGE_QUERY_EVENT, vvv.mmm(), lVar.eee());
        boolean de2 = lVar.de(vvv, i2);
        if (de2) {
            if (!TextUtils.isEmpty(vvv.pf())) {
                lVar.x("1");
            }
            long mmm = vvv.mmm();
            if (mmm > 0) {
                if (lVar.qqq() == 0 || mmm < lVar.qqq()) {
                    lVar.w(mmm, 0);
                }
                if (mmm > lVar.aaa()) {
                    lVar.w(0, mmm);
                }
            }
            fe.fe.mmm.n.qw.rg(BypassConstants$Funnel.PACKAGE_TO_FILE_EVENT, vvv.mmm(), lVar.eee());
        }
        return de2;
    }

    public void rrr(boolean z) {
        k(z, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:158:0x028b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x028c, code lost:
        r10 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x028e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x028f, code lost:
        r10 = r1;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0296, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f1, code lost:
        if (r28.f() == false) goto L_0x00f3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01f7 A[Catch:{ RuntimeException -> 0x0260, all -> 0x025e }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0213 A[Catch:{ RuntimeException -> 0x0260, all -> 0x025e }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0221 A[SYNTHETIC, Splitter:B:115:0x0221] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0253 A[LOOP:0: B:11:0x008f->B:133:0x0253, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0282 A[Catch:{ all -> 0x0286 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x028b A[ExcHandler: all (th java.lang.Throwable), PHI: r1 
      PHI: (r1v5 fe.fe.mmm.eee) = (r1v0 fe.fe.mmm.eee), (r1v7 fe.fe.mmm.eee), (r1v7 fe.fe.mmm.eee) binds: [B:1:0x0011, B:32:0x00d7, B:33:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0296 A[Catch:{ all -> 0x02ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0250 A[EDGE_INSN: B:173:0x0250->B:132:0x0250 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b0 A[Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01bf A[Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01d0 A[Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01d9  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:155:0x0287=Splitter:B:155:0x0287, B:143:0x026f=Splitter:B:143:0x026f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int s(fe.fe.mmm.l r28, fe.fe.mmm.l r29) {
        /*
            r27 = this;
            r1 = r27
            java.lang.String r2 = "bizInfo"
            java.lang.String r3 = "bizparam"
            java.lang.String r0 = " SELECT * FROM flow"
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r4.readLock()
            r4.lock()
            boolean r5 = r28.j()     // Catch:{ SQLException -> 0x028e, all -> 0x028b }
            boolean r6 = r29.j()     // Catch:{ SQLException -> 0x028e, all -> 0x028b }
            android.database.sqlite.SQLiteDatabase r7 = r27.getReadableDatabase()     // Catch:{ SQLException -> 0x028e, all -> 0x028b }
            r8 = 0
            android.database.Cursor r8 = r7.rawQuery(r0, r8)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            if (r8 == 0) goto L_0x026c
            int r0 = r8.getCount()     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            if (r0 <= 0) goto L_0x026c
            r8.moveToFirst()     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "flowid"
            int r9 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "flowhandle"
            int r10 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "state"
            int r11 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "begintime"
            int r12 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "endtime"
            int r13 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "content"
            int r14 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "option"
            int r15 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "reserve1"
            int r4 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "reserve2"
            r16 = r5
            int r5 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "slot"
            r17 = r6
            int r6 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "extend"
            r18 = r7
            int r7 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "logid"
            r19 = r2
            int r2 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "uuid"
            r20 = r2
            int r2 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            java.lang.String r0 = "appversion"
            r21 = r2
            int r2 = r8.getColumnIndex(r0)     // Catch:{ RuntimeException -> 0x027a, all -> 0x0275 }
            r22 = 0
        L_0x008f:
            java.lang.String r0 = "2"
            r23 = r2
            java.lang.String r2 = r8.getString(r11)     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            boolean r0 = r0.equals(r2)     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            if (r0 == 0) goto L_0x0240
            java.lang.String r0 = r8.getString(r9)     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            int r2 = r8.getInt(r10)     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            if (r2 >= 0) goto L_0x00a9
            goto L_0x0240
        L_0x00a9:
            r24 = r10
            fe.fe.mmm.i r10 = fe.fe.mmm.i.vvv()     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            boolean r10 = r10.rg(r0)     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            if (r16 == 0) goto L_0x00ba
            if (r17 == 0) goto L_0x00ba
            r10 = r1
            goto L_0x0250
        L_0x00ba:
            if (r16 == 0) goto L_0x00c6
            if (r10 == 0) goto L_0x00c6
        L_0x00be:
            r10 = r1
            r25 = r11
            r2 = r18
            r11 = 0
            goto L_0x0248
        L_0x00c6:
            if (r17 == 0) goto L_0x00cb
            if (r10 != 0) goto L_0x00cb
            goto L_0x00be
        L_0x00cb:
            boolean r0 = r28.f()     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            if (r0 == 0) goto L_0x00eb
            boolean r0 = r29.f()     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            if (r0 == 0) goto L_0x00eb
            fe.fe.mmm.u.qw.qw(r8)     // Catch:{ SQLException -> 0x00e5, all -> 0x028b }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            r2 = 0
            return r2
        L_0x00e5:
            r0 = move-exception
            r10 = r1
        L_0x00e7:
            r4 = r22
            goto L_0x0292
        L_0x00eb:
            if (r10 == 0) goto L_0x00f3
            boolean r0 = r28.f()     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            if (r0 != 0) goto L_0x00be
        L_0x00f3:
            if (r10 == 0) goto L_0x00fc
            boolean r0 = r29.f()     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            if (r0 == 0) goto L_0x00fc
            goto L_0x00be
        L_0x00fc:
            r25 = r11
            fe.fe.mmm.ddd r11 = new fe.fe.mmm.ddd     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            r11.<init>()     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            java.lang.String r0 = r8.getString(r9)     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            r11.g(r0)     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            r11.f(r2)     // Catch:{ RuntimeException -> 0x0267, all -> 0x0262 }
            long r0 = r8.getLong(r12)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            r11.aaa(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            long r0 = r8.getLong(r13)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            r11.b(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            int r0 = r8.getInt(r15)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            r11.j(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            java.lang.String r0 = r8.getString(r14)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r1 != 0) goto L_0x012f
            r11.tt(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
        L_0x012f:
            java.lang.String r0 = r8.getString(r4)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r1 != 0) goto L_0x013c
            r11.e(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
        L_0x013c:
            java.lang.String r0 = r8.getString(r5)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r0 != 0) goto L_0x014d
            java.lang.String r0 = r8.getString(r5)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            r11.rrr(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
        L_0x014d:
            java.lang.String r0 = r8.getString(r6)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r6 < 0) goto L_0x015c
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r1 != 0) goto L_0x015c
            r11.k(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
        L_0x015c:
            java.lang.String r1 = r8.getString(r7)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r0 != 0) goto L_0x01a4
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x019c }
            java.lang.String r2 = r8.getString(r7)     // Catch:{ JSONException -> 0x019c }
            r0.<init>(r2)     // Catch:{ JSONException -> 0x019c }
            java.lang.String r2 = "ctr"
            boolean r2 = r0.has(r2)     // Catch:{ JSONException -> 0x019c }
            if (r2 == 0) goto L_0x017c
            r2 = 1
            r11.a(r2)     // Catch:{ JSONException -> 0x019c }
            goto L_0x017d
        L_0x017c:
            r2 = 1
        L_0x017d:
            boolean r26 = r0.has(r3)     // Catch:{ JSONException -> 0x019c }
            if (r26 == 0) goto L_0x018a
            org.json.JSONObject r2 = r0.optJSONObject(r3)     // Catch:{ JSONException -> 0x019c }
            r11.eee(r2)     // Catch:{ JSONException -> 0x019c }
        L_0x018a:
            r2 = r19
            boolean r19 = r0.has(r2)     // Catch:{ JSONException -> 0x019a }
            if (r19 == 0) goto L_0x01a2
            java.lang.String r0 = r0.optString(r2)     // Catch:{ JSONException -> 0x019a }
            r11.qqq(r0)     // Catch:{ JSONException -> 0x019a }
            goto L_0x01a2
        L_0x019a:
            r0 = move-exception
            goto L_0x019f
        L_0x019c:
            r0 = move-exception
            r2 = r19
        L_0x019f:
            r0.printStackTrace()     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
        L_0x01a2:
            r19 = r2
        L_0x01a4:
            r2 = r20
            java.lang.String r0 = r8.getString(r2)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r1 != 0) goto L_0x01b3
            r11.h(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
        L_0x01b3:
            r1 = r21
            java.lang.String r0 = r8.getString(r1)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            boolean r20 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r20 != 0) goto L_0x01c2
            r11.m(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
        L_0x01c2:
            r21 = r1
            r1 = r23
            java.lang.String r0 = r8.getString(r1)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            boolean r20 = android.text.TextUtils.isEmpty(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r20 != 0) goto L_0x01d3
            r11.mmm(r0)     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
        L_0x01d3:
            int r0 = r11.pf()     // Catch:{ RuntimeException -> 0x023c, all -> 0x0238 }
            if (r10 == 0) goto L_0x01f7
            r10 = r27
            r23 = r1
            r20 = r2
            r2 = r18
            r1 = r28
            boolean r0 = r10.uk(r2, r11, r0, r1)     // Catch:{ RuntimeException -> 0x0260, all -> 0x025e }
            if (r0 != 0) goto L_0x01ec
            r1 = r29
            goto L_0x0207
        L_0x01ec:
            boolean r0 = r28.j()     // Catch:{ RuntimeException -> 0x0260, all -> 0x025e }
            r1 = r29
            if (r0 == 0) goto L_0x0211
            r16 = 1
            goto L_0x0211
        L_0x01f7:
            r10 = r27
            r23 = r1
            r20 = r2
            r2 = r18
            r1 = r29
            boolean r0 = r10.uk(r2, r11, r0, r1)     // Catch:{ RuntimeException -> 0x0260, all -> 0x025e }
            if (r0 != 0) goto L_0x0209
        L_0x0207:
            r11 = 0
            goto L_0x024a
        L_0x0209:
            boolean r0 = r29.j()     // Catch:{ RuntimeException -> 0x0260, all -> 0x025e }
            if (r0 == 0) goto L_0x0211
            r17 = 1
        L_0x0211:
            if (r22 != 0) goto L_0x0215
            r22 = 1
        L_0x0215:
            boolean r0 = r28.f()     // Catch:{ RuntimeException -> 0x0260, all -> 0x025e }
            if (r0 == 0) goto L_0x0232
            boolean r0 = r29.f()     // Catch:{ RuntimeException -> 0x0260, all -> 0x025e }
            if (r0 == 0) goto L_0x0232
            fe.fe.mmm.u.qw.qw(r8)     // Catch:{ SQLException -> 0x022f }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r10.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            r11 = 0
            return r11
        L_0x022f:
            r0 = move-exception
            goto L_0x00e7
        L_0x0232:
            r11 = 0
            if (r16 == 0) goto L_0x024a
            if (r17 == 0) goto L_0x024a
            goto L_0x0250
        L_0x0238:
            r0 = move-exception
            r10 = r27
            goto L_0x0264
        L_0x023c:
            r0 = move-exception
            r10 = r27
            goto L_0x0269
        L_0x0240:
            r24 = r10
            r25 = r11
            r2 = r18
            r11 = 0
            r10 = r1
        L_0x0248:
            r1 = r29
        L_0x024a:
            boolean r0 = r8.moveToNext()     // Catch:{ RuntimeException -> 0x0260, all -> 0x025e }
            if (r0 != 0) goto L_0x0253
        L_0x0250:
            r4 = r22
            goto L_0x026f
        L_0x0253:
            r18 = r2
            r1 = r10
            r2 = r23
            r10 = r24
            r11 = r25
            goto L_0x008f
        L_0x025e:
            r0 = move-exception
            goto L_0x0264
        L_0x0260:
            r0 = move-exception
            goto L_0x0269
        L_0x0262:
            r0 = move-exception
            r10 = r1
        L_0x0264:
            r4 = r22
            goto L_0x0287
        L_0x0267:
            r0 = move-exception
            r10 = r1
        L_0x0269:
            r4 = r22
            goto L_0x027e
        L_0x026c:
            r10 = r1
            r11 = 0
            r4 = 0
        L_0x026f:
            fe.fe.mmm.u.qw.qw(r8)     // Catch:{ SQLException -> 0x0273 }
            goto L_0x02a2
        L_0x0273:
            r0 = move-exception
            goto L_0x0292
        L_0x0275:
            r0 = move-exception
            r10 = r1
            r11 = 0
            r4 = 0
            goto L_0x0287
        L_0x027a:
            r0 = move-exception
            r10 = r1
            r11 = 0
            r4 = 0
        L_0x027e:
            boolean r1 = f2015i     // Catch:{ all -> 0x0286 }
            if (r1 == 0) goto L_0x026f
            r0.printStackTrace()     // Catch:{ all -> 0x0286 }
            goto L_0x026f
        L_0x0286:
            r0 = move-exception
        L_0x0287:
            fe.fe.mmm.u.qw.qw(r8)     // Catch:{ SQLException -> 0x0273 }
            throw r0     // Catch:{ SQLException -> 0x0273 }
        L_0x028b:
            r0 = move-exception
            r10 = r1
            goto L_0x02ad
        L_0x028e:
            r0 = move-exception
            r10 = r1
            r11 = 0
            r4 = 0
        L_0x0292:
            boolean r1 = f2015i     // Catch:{ all -> 0x02ac }
            if (r1 == 0) goto L_0x0299
            r0.printStackTrace()     // Catch:{ all -> 0x02ac }
        L_0x0299:
            fe.fe.mmm.fe r1 = r10.f2018ad     // Catch:{ all -> 0x02ac }
            java.lang.String r2 = "read_"
            java.lang.String r3 = "getAllFlowData"
            r1.uk(r0, r2, r3)     // Catch:{ all -> 0x02ac }
        L_0x02a2:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r10.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r4
        L_0x02ac:
            r0 = move-exception
        L_0x02ad:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r10.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.s(fe.fe.mmm.l, fe.fe.mmm.l):int");
    }

    /* renamed from: switch  reason: not valid java name */
    public void m122switch(String str, boolean z) {
        SQLiteDatabase writableDatabase;
        if (!TextUtils.isEmpty(str)) {
            this.f2020uk.writeLock().lock();
            String str2 = "callcnt";
            String str3 = z ? str2 : "count";
            if (z) {
                str2 = "count";
            }
            try {
                writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    SQLiteStatement compileStatement = writableDatabase.compileStatement("UPDATE " + "arrival" + " SET " + str3 + " = " + str3 + " + 1, " + WXLoginActivity.w + " = " + 0 + " WHERE " + "ubcid" + " = ?" + " AND " + "date(" + "ubctime" + ")" + " = date('now', 'localtime')");
                    compileStatement.clearBindings();
                    compileStatement.bindString(1, str);
                    if (compileStatement.executeUpdateDelete() <= 0) {
                        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ubcid", str);
                        contentValues.put(str3, 1);
                        contentValues.put(str2, 0);
                        contentValues.put(WXLoginActivity.w, 0);
                        contentValues.put("ubctime", format);
                        writableDatabase.insert("arrival", (String) null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } catch (SQLException e) {
                    if (f2015i) {
                        e.printStackTrace();
                    }
                    this.f2018ad.uk(e, "write_", "addOrUpdateUBCRecord");
                }
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                try {
                    if (f2015i) {
                        e2.printStackTrace();
                    }
                    this.f2018ad.uk(e2, "write_", "addOrUpdateUBCRecord");
                } catch (Throwable th2) {
                    this.f2020uk.writeLock().unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                writableDatabase.endTransaction();
                throw th3;
            }
            this.f2020uk.writeLock().unlock();
        }
    }

    public HashMap<String, String> t(ArrayList<String> arrayList) {
        this.f2020uk.readLock().lock();
        HashMap<String, String> hashMap = new HashMap<>();
        String C = C(arrayList);
        try {
            Cursor cursor = null;
            try {
                cursor = getReadableDatabase().rawQuery("SELECT " + "eventid" + "," + "extend" + " FROM " + "config" + " WHERE " + "eventid" + " in (" + C + ")", (String[]) null);
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("eventid");
                    int columnIndex2 = cursor.getColumnIndex("extend");
                    do {
                        String string = cursor.getString(columnIndex);
                        String string2 = cursor.getString(columnIndex2);
                        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                            hashMap.put(string, string2);
                        }
                    } while (cursor.moveToNext());
                }
            } catch (SQLiteException e) {
                if (f2015i) {
                    e.printStackTrace();
                }
            }
            qw.qw(cursor);
        } catch (SQLException e2) {
            try {
                if (f2015i) {
                    e2.printStackTrace();
                }
            } catch (Throwable th2) {
                this.f2020uk.readLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            qw.qw((Cursor) null);
            throw th3;
        }
        this.f2020uk.readLock().unlock();
        return hashMap;
    }

    public final void th(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x011f A[Catch:{ all -> 0x0118 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tt() {
        /*
            r13 = this;
            java.lang.String r0 = "_id"
            java.lang.String r1 = "ubctime"
            java.lang.String r2 = "clearInvalidUBCRecords"
            java.lang.String r3 = "date("
            java.lang.String r4 = "write_"
            java.lang.String r5 = "arrival"
            java.util.concurrent.locks.ReentrantReadWriteLock r6 = r13.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r6 = r6.writeLock()
            r6.lock()
            android.database.sqlite.SQLiteDatabase r6 = r13.getWritableDatabase()     // Catch:{ SQLException -> 0x0134 }
            r6.beginTransactionNonExclusive()     // Catch:{ SQLException -> 0x0134 }
            r7 = 7
            r8 = 0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x011a }
            r9.<init>()     // Catch:{ SQLException -> 0x011a }
            r9.append(r3)     // Catch:{ SQLException -> 0x011a }
            r9.append(r1)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r10 = ") <= date('now', 'localtime', '-"
            r9.append(r10)     // Catch:{ SQLException -> 0x011a }
            r9.append(r7)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r7 = " day') "
            r9.append(r7)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r7 = r9.toString()     // Catch:{ SQLException -> 0x011a }
            int r7 = r6.delete(r5, r7, r8)     // Catch:{ SQLException -> 0x011a }
            boolean r9 = f2015i     // Catch:{ SQLException -> 0x011a }
            java.lang.String r10 = " records"
            java.lang.String r11 = "clearInvalidUBCRecords delete "
            if (r9 == 0) goto L_0x0057
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x011a }
            r9.<init>()     // Catch:{ SQLException -> 0x011a }
            r9.append(r11)     // Catch:{ SQLException -> 0x011a }
            r9.append(r7)     // Catch:{ SQLException -> 0x011a }
            r9.append(r10)     // Catch:{ SQLException -> 0x011a }
            r9.toString()     // Catch:{ SQLException -> 0x011a }
        L_0x0057:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x011a }
            r7.<init>()     // Catch:{ SQLException -> 0x011a }
            java.lang.String r9 = "state"
            r7.append(r9)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r9 = " = "
            r7.append(r9)     // Catch:{ SQLException -> 0x011a }
            r9 = 1
            r7.append(r9)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r12 = " AND "
            r7.append(r12)     // Catch:{ SQLException -> 0x011a }
            r7.append(r3)     // Catch:{ SQLException -> 0x011a }
            r7.append(r1)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r1 = ") < date('now', 'localtime')"
            r7.append(r1)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r1 = r7.toString()     // Catch:{ SQLException -> 0x011a }
            int r1 = r6.delete(r5, r1, r8)     // Catch:{ SQLException -> 0x011a }
            boolean r3 = f2015i     // Catch:{ SQLException -> 0x011a }
            if (r3 == 0) goto L_0x0097
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x011a }
            r3.<init>()     // Catch:{ SQLException -> 0x011a }
            r3.append(r11)     // Catch:{ SQLException -> 0x011a }
            r3.append(r1)     // Catch:{ SQLException -> 0x011a }
            r3.append(r10)     // Catch:{ SQLException -> 0x011a }
            r3.toString()     // Catch:{ SQLException -> 0x011a }
        L_0x0097:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x011a }
            r1.<init>()     // Catch:{ SQLException -> 0x011a }
            java.lang.String r3 = "SELECT COUNT(*), MIN("
            r1.append(r3)     // Catch:{ SQLException -> 0x011a }
            r1.append(r0)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r3 = "), MAX("
            r1.append(r3)     // Catch:{ SQLException -> 0x011a }
            r1.append(r0)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r0 = ") FROM "
            r1.append(r0)     // Catch:{ SQLException -> 0x011a }
            r1.append(r5)     // Catch:{ SQLException -> 0x011a }
            java.lang.String r0 = r1.toString()     // Catch:{ SQLException -> 0x011a }
            android.database.Cursor r0 = r6.rawQuery(r0, r8)     // Catch:{ SQLException -> 0x011a }
            r1 = 0
            if (r0 == 0) goto L_0x00e5
            int r3 = r0.getCount()     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            if (r3 <= 0) goto L_0x00e5
            r0.moveToFirst()     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            int r3 = r0.getInt(r1)     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            r7 = 15000(0x3a98, float:2.102E-41)
            if (r3 <= r7) goto L_0x00e5
            int r1 = r0.getInt(r9)     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            r3 = 2
            int r3 = r0.getInt(r3)     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            int r1 = r1 + r3
            int r1 = r1 / 3
            goto L_0x00e5
        L_0x00dd:
            r1 = move-exception
            r8 = r0
            r0 = r1
            goto L_0x012b
        L_0x00e1:
            r1 = move-exception
            r8 = r0
            r0 = r1
            goto L_0x011b
        L_0x00e5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            r3.<init>()     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            java.lang.String r7 = "_id < "
            r3.append(r7)     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            r3.append(r1)     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            java.lang.String r1 = r3.toString()     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            int r1 = r6.delete(r5, r1, r8)     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            boolean r3 = f2015i     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            if (r3 == 0) goto L_0x010e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            r3.<init>()     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            java.lang.String r5 = "clearInvalidUBCRecords delete count:"
            r3.append(r5)     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            r3.append(r1)     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            r3.toString()     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
        L_0x010e:
            r6.setTransactionSuccessful()     // Catch:{ SQLException -> 0x00e1, all -> 0x00dd }
            fe.fe.mmm.u.qw.qw(r0)     // Catch:{ SQLException -> 0x0134 }
        L_0x0114:
            r6.endTransaction()     // Catch:{ SQLException -> 0x0134 }
            goto L_0x0141
        L_0x0118:
            r0 = move-exception
            goto L_0x012b
        L_0x011a:
            r0 = move-exception
        L_0x011b:
            boolean r1 = f2015i     // Catch:{ all -> 0x0118 }
            if (r1 == 0) goto L_0x0122
            r0.printStackTrace()     // Catch:{ all -> 0x0118 }
        L_0x0122:
            fe.fe.mmm.fe r1 = r13.f2018ad     // Catch:{ all -> 0x0118 }
            r1.uk(r0, r4, r2)     // Catch:{ all -> 0x0118 }
            fe.fe.mmm.u.qw.qw(r8)     // Catch:{ SQLException -> 0x0134 }
            goto L_0x0114
        L_0x012b:
            fe.fe.mmm.u.qw.qw(r8)     // Catch:{ SQLException -> 0x0134 }
            r6.endTransaction()     // Catch:{ SQLException -> 0x0134 }
            throw r0     // Catch:{ SQLException -> 0x0134 }
        L_0x0132:
            r0 = move-exception
            goto L_0x014b
        L_0x0134:
            r0 = move-exception
            boolean r1 = f2015i     // Catch:{ all -> 0x0132 }
            if (r1 == 0) goto L_0x013c
            r0.printStackTrace()     // Catch:{ all -> 0x0132 }
        L_0x013c:
            fe.fe.mmm.fe r1 = r13.f2018ad     // Catch:{ all -> 0x0132 }
            r1.uk(r0, r4, r2)     // Catch:{ all -> 0x0132 }
        L_0x0141:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r13.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.unlock()
            return
        L_0x014b:
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = r13.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r1.writeLock()
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.tt():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x011f A[Catch:{ all -> 0x0123 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x0112=Splitter:B:45:0x0112, B:56:0x0124=Splitter:B:56:0x0124} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.fe.mmm.Cswitch u(java.lang.String r24) {
        /*
            r23 = this;
            r1 = r23
            java.lang.String r0 = "isSend"
            java.lang.String r2 = "uploadType"
            java.lang.String r3 = "1"
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r4.readLock()
            r4.lock()
            r4 = 0
            android.database.sqlite.SQLiteDatabase r5 = r23.getReadableDatabase()     // Catch:{ SQLException -> 0x012a }
            java.lang.String r6 = "SELECT * FROM %s where eventid = \"%s\""
            r7 = 2
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ SQLException -> 0x012a }
            java.lang.String r9 = "config"
            r10 = 0
            r8[r10] = r9     // Catch:{ SQLException -> 0x012a }
            r9 = 1
            r8[r9] = r24     // Catch:{ SQLException -> 0x012a }
            java.lang.String r6 = java.lang.String.format(r6, r8)     // Catch:{ SQLException -> 0x012a }
            android.database.Cursor r5 = r5.rawQuery(r6, r4)     // Catch:{ RuntimeException -> 0x0119, all -> 0x0116 }
            if (r5 == 0) goto L_0x0112
            int r6 = r5.getCount()     // Catch:{ RuntimeException -> 0x0110 }
            if (r6 <= 0) goto L_0x0112
            r5.moveToFirst()     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r6 = "eventid"
            int r6 = r5.getColumnIndex(r6)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r8 = "switch"
            int r8 = r5.getColumnIndex(r8)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r11 = "cycle"
            int r11 = r5.getColumnIndex(r11)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r12 = "reserve1"
            int r12 = r5.getColumnIndex(r12)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r13 = "type"
            int r13 = r5.getColumnIndex(r13)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r14 = "extend"
            int r14 = r5.getColumnIndex(r14)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r15 = "reallog"
            int r15 = r5.getColumnIndex(r15)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r6 = r5.getString(r6)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r8 = r5.getString(r8)     // Catch:{ RuntimeException -> 0x0110 }
            boolean r18 = android.text.TextUtils.equals(r8, r3)     // Catch:{ RuntimeException -> 0x0110 }
            int r20 = r5.getInt(r11)     // Catch:{ RuntimeException -> 0x0110 }
            if (r20 != 0) goto L_0x0075
            r19 = 1
            goto L_0x0077
        L_0x0075:
            r19 = 0
        L_0x0077:
            java.lang.String r8 = r5.getString(r12)     // Catch:{ RuntimeException -> 0x0110 }
            boolean r22 = android.text.TextUtils.equals(r8, r3)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r8 = r5.getString(r13)     // Catch:{ RuntimeException -> 0x0110 }
            boolean r21 = android.text.TextUtils.equals(r3, r8)     // Catch:{ RuntimeException -> 0x0110 }
            fe.fe.mmm.switch r8 = new fe.fe.mmm.switch     // Catch:{ RuntimeException -> 0x0110 }
            r16 = r8
            r17 = r6
            r16.<init>(r17, r18, r19, r20, r21, r22)     // Catch:{ RuntimeException -> 0x0110 }
            java.lang.String r10 = r5.getString(r14)     // Catch:{ RuntimeException -> 0x0110 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ RuntimeException -> 0x0110 }
            if (r11 != 0) goto L_0x00f8
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f0 }
            r11.<init>(r10)     // Catch:{ JSONException -> 0x00f0 }
            java.lang.String r10 = "dfc"
            java.lang.String r10 = r11.optString(r10)     // Catch:{ JSONException -> 0x00f0 }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ JSONException -> 0x00f0 }
            if (r12 != 0) goto L_0x00b2
            boolean r10 = android.text.TextUtils.equals(r10, r3)     // Catch:{ JSONException -> 0x00f0 }
            r8.a(r10)     // Catch:{ JSONException -> 0x00f0 }
        L_0x00b2:
            java.lang.String r10 = "version"
            java.lang.String r10 = r11.optString(r10)     // Catch:{ JSONException -> 0x00f0 }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ JSONException -> 0x00f0 }
            if (r12 != 0) goto L_0x00c1
            r8.k(r10)     // Catch:{ JSONException -> 0x00f0 }
        L_0x00c1:
            boolean r10 = r11.has(r2)     // Catch:{ JSONException -> 0x00f0 }
            if (r10 == 0) goto L_0x00cf
            r10 = -1
            int r2 = r11.optInt(r2, r10)     // Catch:{ JSONException -> 0x00f0 }
            r8.j(r2)     // Catch:{ JSONException -> 0x00f0 }
        L_0x00cf:
            java.lang.String r2 = "lcache"
            int r2 = r11.optInt(r2, r7)     // Catch:{ JSONException -> 0x00f0 }
            if (r2 == r9) goto L_0x00d9
            if (r2 != 0) goto L_0x00dc
        L_0x00d9:
            r8.e(r2)     // Catch:{ JSONException -> 0x00f0 }
        L_0x00dc:
            boolean r2 = fe.fe.mmm.ggg.qw(r6)     // Catch:{ JSONException -> 0x00f0 }
            if (r2 == 0) goto L_0x00f8
            boolean r2 = r11.has(r0)     // Catch:{ JSONException -> 0x00f0 }
            if (r2 == 0) goto L_0x00f8
            boolean r0 = r11.optBoolean(r0, r9)     // Catch:{ JSONException -> 0x00f0 }
            r8.b(r0)     // Catch:{ JSONException -> 0x00f0 }
            goto L_0x00f8
        L_0x00f0:
            r0 = move-exception
            boolean r2 = f2015i     // Catch:{ RuntimeException -> 0x0110 }
            if (r2 == 0) goto L_0x00f8
            r0.printStackTrace()     // Catch:{ RuntimeException -> 0x0110 }
        L_0x00f8:
            java.lang.String r0 = r5.getString(r15)     // Catch:{ RuntimeException -> 0x0110 }
            boolean r0 = android.text.TextUtils.equals(r0, r3)     // Catch:{ RuntimeException -> 0x0110 }
            r8.h(r0)     // Catch:{ RuntimeException -> 0x0110 }
            fe.fe.mmm.u.qw.qw(r5)     // Catch:{ SQLException -> 0x012a }
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r8
        L_0x0110:
            r0 = move-exception
            goto L_0x011b
        L_0x0112:
            fe.fe.mmm.u.qw.qw(r5)     // Catch:{ SQLException -> 0x012a }
            goto L_0x013b
        L_0x0116:
            r0 = move-exception
            r5 = r4
            goto L_0x0124
        L_0x0119:
            r0 = move-exception
            r5 = r4
        L_0x011b:
            boolean r2 = f2015i     // Catch:{ all -> 0x0123 }
            if (r2 == 0) goto L_0x0112
            r0.printStackTrace()     // Catch:{ all -> 0x0123 }
            goto L_0x0112
        L_0x0123:
            r0 = move-exception
        L_0x0124:
            fe.fe.mmm.u.qw.qw(r5)     // Catch:{ SQLException -> 0x012a }
            throw r0     // Catch:{ SQLException -> 0x012a }
        L_0x0128:
            r0 = move-exception
            goto L_0x0145
        L_0x012a:
            r0 = move-exception
            boolean r2 = f2015i     // Catch:{ all -> 0x0128 }
            if (r2 == 0) goto L_0x0132
            r0.printStackTrace()     // Catch:{ all -> 0x0128 }
        L_0x0132:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x0128 }
            java.lang.String r3 = "read_"
            java.lang.String r5 = "getConfigItemDataByActionId"
            r2.uk(r0, r3, r5)     // Catch:{ all -> 0x0128 }
        L_0x013b:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            return r4
        L_0x0145:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.u(java.lang.String):fe.fe.mmm.switch");
    }

    public final boolean uk(SQLiteDatabase sQLiteDatabase, ddd ddd, int i2, l lVar) {
        if (ddd.when() < 0) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT ");
            sb.append("eventid");
            sb.append(" , ");
            sb.append("begintime");
            sb.append(" , ");
            sb.append("content");
            sb.append(" FROM ");
            sb.append(NotificationCompat.CATEGORY_EVENT);
            sb.append(" WHERE ");
            sb.append("flowhandle");
            sb.append(" = ");
            sb.append(ddd.when());
            Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), (String[]) null);
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.moveToFirst();
                int columnIndex = rawQuery.getColumnIndex("eventid");
                int columnIndex2 = rawQuery.getColumnIndex("begintime");
                int columnIndex3 = rawQuery.getColumnIndex("content");
                do {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", rawQuery.getString(columnIndex));
                    jSONObject.put("timestamp", Long.toString(rawQuery.getLong(columnIndex2)));
                    jSONObject.put("content", rawQuery.getString(columnIndex3));
                    jSONArray.put(jSONObject);
                } while (rawQuery.moveToNext());
                ddd.c(jSONArray);
            }
            qw.qw(rawQuery);
            fe.fe.mmm.n.qw.rg(BypassConstants$Funnel.PACKAGE_QUERY_FLOW, ddd.m119if(), lVar.eee());
            if (lVar.de(ddd, i2)) {
                if (!TextUtils.isEmpty(ddd.m120switch())) {
                    lVar.x("1");
                }
                if (ddd.m119if() > 0 && ddd.m119if() > lVar.aaa()) {
                    lVar.w(0, ddd.m119if());
                }
                if (ddd.rg() > 0 && (lVar.qqq() == 0 || ddd.rg() < lVar.qqq())) {
                    lVar.w(ddd.rg(), 0);
                }
                fe.fe.mmm.n.qw.rg(BypassConstants$Funnel.PACKAGE_TO_FILE_FLOW, ddd.m119if(), lVar.eee());
                return true;
            }
        } catch (JSONException unused) {
            boolean z = f2015i;
        } catch (RuntimeException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        } catch (Throwable th2) {
            qw.qw((Cursor) null);
            throw th2;
        }
        return false;
    }

    public int v() {
        this.f2020uk.readLock().lock();
        int i2 = 0;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            Cursor cursor = null;
            try {
                cursor = readableDatabase.rawQuery("SELECT COUNT(" + "eventid" + ") FROM " + "config", (String[]) null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    i2 = cursor.getInt(0);
                }
            } catch (SQLException e) {
                if (f2015i) {
                    e.printStackTrace();
                }
            }
            qw.qw(cursor);
        } catch (SQLException e2) {
            try {
                if (f2015i) {
                    e2.printStackTrace();
                }
            } catch (Throwable th2) {
                this.f2020uk.readLock().unlock();
                throw th2;
            }
        } catch (Throwable th3) {
            qw.qw((Cursor) null);
            throw th3;
        }
        this.f2020uk.readLock().unlock();
        return i2;
    }

    public final void vvv(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN logid TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN logid TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN savefile INTEGER");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN savefile INTEGER");
        } catch (SQLiteException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public int w(ArrayList<String> arrayList, boolean z, l lVar) {
        l lVar2 = lVar;
        String C = C(arrayList);
        String str = z ? " in  (" : " not in (";
        if (TextUtils.isEmpty(C) && z) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(256);
        if (z || !TextUtils.isEmpty(C)) {
            sb.append("SELECT * ");
            sb.append(" FROM ");
            sb.append("flow");
            sb.append(" WHERE ");
            sb.append("flowid");
            sb.append(str);
            sb.append(C);
            sb.append(")");
        } else {
            sb.append("SELECT * FROM ");
            sb.append("flow");
        }
        int A = A(sb.toString(), lVar2);
        if (lVar.f()) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(256);
        if (z || !TextUtils.isEmpty(C)) {
            sb2.append("SELECT *  FROM ");
            sb2.append(NotificationCompat.CATEGORY_EVENT);
            sb2.append(" WHERE ");
            sb2.append("eventid");
            sb2.append(str);
            sb2.append(C);
            sb2.append(")");
            sb2.append(" AND ");
            sb2.append("flowhandle");
            sb2.append(" = ");
            sb2.append(-1);
            sb2.append(" AND ");
            sb2.append("reallog");
            sb2.append(" = \"0\"");
        } else {
            sb2.append("SELECT *  FROM ");
            sb2.append(NotificationCompat.CATEGORY_EVENT);
            sb2.append(" WHERE ");
            sb2.append("flowhandle");
            sb2.append(" = ");
            sb2.append(-1);
            sb2.append(" AND ");
            sb2.append("reallog");
            sb2.append(" = \"0\"");
        }
        return x(sb2.toString(), lVar2) | A;
    }

    public final void when(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
        } catch (SQLException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0166 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int x(java.lang.String r21, fe.fe.mmm.l r22) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "bizInfo"
            java.lang.String r2 = "bizparam"
            java.lang.String r3 = "option"
            java.util.concurrent.locks.ReentrantReadWriteLock r4 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = r4.readLock()
            r4.lock()
            android.database.sqlite.SQLiteDatabase r5 = r20.getReadableDatabase()     // Catch:{ SQLException -> 0x017a }
            r6 = 0
            r7 = r21
            android.database.Cursor r6 = r5.rawQuery(r7, r6)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r6 == 0) goto L_0x0151
            int r7 = r6.getCount()     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r7 <= 0) goto L_0x0151
            r6.moveToFirst()     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r7 = "eventid"
            int r7 = r6.getColumnIndex(r7)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r8 = "begintime"
            int r8 = r6.getColumnIndex(r8)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r9 = "content"
            int r9 = r6.getColumnIndex(r9)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r10 = "reserve1"
            int r10 = r6.getColumnIndex(r10)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r11 = "reserve2"
            int r11 = r6.getColumnIndex(r11)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r12 = "extend"
            int r12 = r6.getColumnIndex(r12)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r13 = "_id"
            int r13 = r6.getColumnIndex(r13)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r14 = "logid"
            int r14 = r6.getColumnIndex(r14)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r15 = "uuid"
            int r15 = r6.getColumnIndex(r15)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r4 = "appversion"
            int r4 = r6.getColumnIndex(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x0063:
            java.lang.String r5 = r6.getString(r7)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            boolean r17 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r17 == 0) goto L_0x0075
            r5 = r22
            r17 = r7
            r16 = r8
            goto L_0x0143
        L_0x0075:
            r17 = r7
            fe.fe.mmm.vvv r7 = new fe.fe.mmm.vvv     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            int r5 = r6.getInt(r13)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r7.k(r5)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r18 = r4
            long r4 = r6.getLong(r8)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r7.l(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r4 = r6.getString(r9)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r5 != 0) goto L_0x0099
            r7.b(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x0099:
            java.lang.String r4 = r6.getString(r10)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r5 != 0) goto L_0x00a6
            r7.e(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x00a6:
            java.lang.String r4 = r6.getString(r11)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r4 != 0) goto L_0x00b7
            java.lang.String r4 = r6.getString(r11)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r7.a(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x00b7:
            java.lang.String r4 = r6.getString(r12)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r4 != 0) goto L_0x0103
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r5 = r6.getString(r12)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r4.<init>(r5)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            java.lang.String r5 = "ctr"
            boolean r5 = r4.has(r5)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r5 == 0) goto L_0x00d7
            r5 = 1
            r7.c(r5)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            goto L_0x00d8
        L_0x00d7:
            r5 = 1
        L_0x00d8:
            boolean r19 = r4.has(r3)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r16 = r8
            r5 = 0
            if (r19 == 0) goto L_0x00e8
            int r8 = r4.optInt(r3, r5)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r7.h(r8)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x00e8:
            boolean r8 = r4.has(r2)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r8 == 0) goto L_0x00f5
            org.json.JSONObject r8 = r4.optJSONObject(r2)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r7.tt(r8)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x00f5:
            boolean r8 = r4.has(r0)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r8 == 0) goto L_0x0106
            java.lang.String r4 = r4.optString(r0)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r7.rrr(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            goto L_0x0106
        L_0x0103:
            r16 = r8
            r5 = 0
        L_0x0106:
            java.lang.String r4 = r6.getString(r14)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r8 != 0) goto L_0x0113
            r7.g(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x0113:
            java.lang.String r4 = r6.getString(r15)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r8 != 0) goto L_0x0120
            r7.m(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x0120:
            r4 = r18
            java.lang.String r8 = r6.getString(r4)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            boolean r18 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r18 != 0) goto L_0x012f
            r7.eee(r8)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
        L_0x012f:
            int r8 = r7.o()     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            r5 = r22
            boolean r7 = r1.rg(r7, r8, r5)     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r7 != 0) goto L_0x013c
            goto L_0x0149
        L_0x013c:
            boolean r7 = r22.j()     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r7 == 0) goto L_0x0143
            goto L_0x0149
        L_0x0143:
            boolean r7 = r6.moveToNext()     // Catch:{ JSONException -> 0x0166, RuntimeException -> 0x015a }
            if (r7 != 0) goto L_0x014b
        L_0x0149:
            r4 = 1
            goto L_0x0152
        L_0x014b:
            r8 = r16
            r7 = r17
            goto L_0x0063
        L_0x0151:
            r4 = 0
        L_0x0152:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x0156 }
            goto L_0x016a
        L_0x0156:
            r0 = move-exception
            goto L_0x017c
        L_0x0158:
            r0 = move-exception
            goto L_0x0174
        L_0x015a:
            r0 = move-exception
            boolean r2 = f2015i     // Catch:{ all -> 0x0158 }
            if (r2 == 0) goto L_0x0162
            r0.printStackTrace()     // Catch:{ all -> 0x0158 }
        L_0x0162:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x017a }
            goto L_0x0169
        L_0x0166:
            boolean r0 = f2015i     // Catch:{ all -> 0x0158 }
            goto L_0x0162
        L_0x0169:
            r4 = 0
        L_0x016a:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
            r0.unlock()
            goto L_0x018d
        L_0x0174:
            fe.fe.mmm.u.qw.qw(r6)     // Catch:{ SQLException -> 0x017a }
            throw r0     // Catch:{ SQLException -> 0x017a }
        L_0x0178:
            r0 = move-exception
            goto L_0x018e
        L_0x017a:
            r0 = move-exception
            r4 = 0
        L_0x017c:
            boolean r2 = f2015i     // Catch:{ all -> 0x0178 }
            if (r2 == 0) goto L_0x0183
            r0.printStackTrace()     // Catch:{ all -> 0x0178 }
        L_0x0183:
            fe.fe.mmm.fe r2 = r1.f2018ad     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = "read_"
            java.lang.String r5 = "getEventData"
            r2.uk(r0, r3, r5)     // Catch:{ all -> 0x0178 }
            goto L_0x016a
        L_0x018d:
            return r4
        L_0x018e:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = r1.f2020uk
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.eee.x(java.lang.String, fe.fe.mmm.l):int");
    }

    public final void xxx(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN uuid TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN uuid TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE arrival ADD COLUMNlogid TEXT");
        } catch (SQLiteException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public final ContentValues y(vvv vvv) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(vvv.m145switch()));
        contentValues.put("eventid", vvv.ppp());
        contentValues.put("begintime", Long.valueOf(vvv.mmm()));
        if (!TextUtils.isEmpty(vvv.i())) {
            contentValues.put("content", vvv.i());
        } else if (vvv.ggg() != null && !TextUtils.isEmpty(vvv.ggg().toString())) {
            contentValues.put("content", vvv.ggg().toString());
        }
        if (!TextUtils.isEmpty(vvv.pf())) {
            contentValues.put("reserve1", vvv.pf());
        }
        if (!TextUtils.isEmpty(vvv.uk())) {
            contentValues.put("reserve2", vvv.uk());
        }
        if (!TextUtils.isEmpty(vvv.vvv())) {
            contentValues.put("logid", vvv.vvv());
        }
        if (!TextUtils.isEmpty(vvv.aaa())) {
            contentValues.put(UrlOcrConfig.IdCardKey.UUID, vvv.aaa());
        }
        if (!TextUtils.isEmpty(vvv.fe())) {
            contentValues.put("appversion", vvv.fe());
        }
        JSONObject jSONObject = new JSONObject();
        boolean z = true;
        try {
            boolean z2 = false;
            if (vvv.qqq()) {
                jSONObject.put("ctr", "1");
                z = false;
            }
            if ((vvv.xxx() & 128) != 0) {
                jSONObject.put("option", vvv.xxx());
                z = false;
            }
            JSONObject yj2 = vvv.yj();
            if (yj2 != null && yj2.length() > 0) {
                jSONObject.put("bizparam", yj2);
                z = false;
            }
            String rg2 = vvv.rg();
            if (!TextUtils.isEmpty(rg2)) {
                jSONObject.put("bizInfo", rg2);
            } else {
                z2 = z;
            }
            if (!z2) {
                contentValues.put("extend", jSONObject.toString());
            }
        } catch (JSONException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(vvv.ddd())) {
            contentValues.put("reallog", vvv.ddd());
        } else {
            contentValues.put("reallog", "0");
        }
        return contentValues;
    }

    public final void yj(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            if (f2015i) {
                e.printStackTrace();
            }
        }
    }

    public final String z(l lVar) {
        if (lVar == null || !lVar.g()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ubc_data_backend_type", "1");
            return jSONObject.toString();
        } catch (JSONException e) {
            if (!f2015i) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }
}
