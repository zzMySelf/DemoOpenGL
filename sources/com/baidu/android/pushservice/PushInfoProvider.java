package com.baidu.android.pushservice;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import com.baidu.android.pushservice.util.Utility;

public class PushInfoProvider extends ContentProvider {

    /* renamed from: a  reason: collision with root package name */
    public Context f7848a;

    /* renamed from: b  reason: collision with root package name */
    public UriMatcher f7849b = new UriMatcher(-1);

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        Context context = getContext();
        this.f7848a = context;
        String str = Utility.w(context) ? "pushinfo_v3" : "pushinfo";
        if (this.f7849b == null) {
            this.f7849b = new UriMatcher(-1);
        }
        try {
            this.f7849b.addURI(this.f7848a.getPackageName() + ".bdpush", str, 1);
            this.f7849b.addURI(this.f7848a.getPackageName() + ".bdpush", "verif", 2);
            this.f7849b.addURI(this.f7848a.getPackageName() + ".bdpush", "msgInfo", 3);
            this.f7849b.addURI(this.f7848a.getPackageName() + ".bdpush", "appstatus", 4);
        } catch (Throwable th2) {
        }
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor query(android.net.Uri r10, java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) {
        /*
            r9 = this;
            android.content.Context r0 = r9.getContext()
            com.baidu.android.pushservice.w.a r0 = com.baidu.android.pushservice.w.a.a((android.content.Context) r0)
            r1 = 0
            r0.a((int) r1)
            java.lang.Object r0 = com.baidu.android.pushservice.n.d.b()
            monitor-enter(r0)
            android.content.UriMatcher r1 = r9.f7849b     // Catch:{ Exception -> 0x0072 }
            int r10 = r1.match(r10)     // Catch:{ Exception -> 0x0072 }
            switch(r10) {
                case 1: goto L_0x005b;
                case 2: goto L_0x0046;
                case 3: goto L_0x0031;
                case 4: goto L_0x001c;
                default: goto L_0x001a;
            }     // Catch:{ Exception -> 0x0072 }
        L_0x001a:
            goto L_0x0073
        L_0x001c:
            android.content.Context r10 = r9.f7848a     // Catch:{ Exception -> 0x0072 }
            android.database.sqlite.SQLiteDatabase r1 = com.baidu.android.pushservice.n.d.d(r10)     // Catch:{ Exception -> 0x0072 }
            if (r1 == 0) goto L_0x0073
            java.lang.String r2 = "PushAppStatus"
            r6 = 0
            r7 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r8 = r14
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0074
        L_0x0031:
            android.content.Context r10 = r9.f7848a     // Catch:{ Exception -> 0x0072 }
            android.database.sqlite.SQLiteDatabase r1 = com.baidu.android.pushservice.n.d.d(r10)     // Catch:{ Exception -> 0x0072 }
            if (r1 == 0) goto L_0x0073
            java.lang.String r2 = "PushMsgInfos"
            r6 = 0
            r7 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r8 = r14
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0074
        L_0x0046:
            android.content.Context r10 = r9.f7848a     // Catch:{ Exception -> 0x0072 }
            android.database.sqlite.SQLiteDatabase r1 = com.baidu.android.pushservice.n.d.d(r10)     // Catch:{ Exception -> 0x0072 }
            if (r1 == 0) goto L_0x0073
            java.lang.String r2 = "PushVerifInfo"
            r6 = 0
            r7 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r8 = r14
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0074
        L_0x005b:
            android.content.Context r10 = r9.f7848a     // Catch:{ Exception -> 0x0072 }
            android.database.sqlite.SQLiteDatabase r1 = com.baidu.android.pushservice.n.d.d(r10)     // Catch:{ Exception -> 0x0072 }
            if (r1 == 0) goto L_0x0073
            java.lang.String r2 = "PushShareInfo"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0074
        L_0x0070:
            r10 = move-exception
            goto L_0x0076
        L_0x0072:
            r10 = move-exception
        L_0x0073:
            r10 = 0
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            return r10
        L_0x0076:
            monitor-exit(r0)     // Catch:{ all -> 0x0070 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.PushInfoProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0076, code lost:
        if (r12 != null) goto L_0x0078;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0063 A[Catch:{ Exception -> 0x006c, all -> 0x005f, all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068 A[Catch:{ Exception -> 0x006c, all -> 0x005f, all -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0070 A[Catch:{ Exception -> 0x006c, all -> 0x005f, all -> 0x0074 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int update(android.net.Uri r12, android.content.ContentValues r13, java.lang.String r14, java.lang.String[] r15) {
        /*
            r11 = this;
            android.content.Context r15 = r11.getContext()
            com.baidu.android.pushservice.w.a r15 = com.baidu.android.pushservice.w.a.a((android.content.Context) r15)
            r0 = 0
            r15.a((int) r0)
            java.lang.Object r15 = com.baidu.android.pushservice.n.d.b()
            monitor-enter(r15)
            r0 = 0
            r1 = -1
            android.content.UriMatcher r3 = r11.f7849b     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            int r12 = r3.match(r12)     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            r3 = 1
            if (r12 == r3) goto L_0x001f
            r12 = r0
            goto L_0x0057
        L_0x001f:
            android.content.Context r12 = r11.f7848a     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            android.database.sqlite.SQLiteDatabase r12 = com.baidu.android.pushservice.n.d.d(r12)     // Catch:{ Exception -> 0x006c, all -> 0x005f }
            if (r12 == 0) goto L_0x0057
            java.lang.String r4 = "PushShareInfo"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r12
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0055, all -> 0x0053 }
            if (r3 == 0) goto L_0x0044
            int r4 = r3.getCount()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            if (r4 == 0) goto L_0x0044
            java.lang.String r4 = "PushShareInfo"
            int r13 = r12.update(r4, r13, r14, r0)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            long r13 = (long) r13     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            goto L_0x004a
        L_0x0044:
            java.lang.String r14 = "PushShareInfo"
            long r13 = r12.insert(r14, r0, r13)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
        L_0x004a:
            r1 = r13
            r0 = r3
            goto L_0x0057
        L_0x004d:
            r13 = move-exception
            r0 = r3
            goto L_0x0061
        L_0x0050:
            r13 = move-exception
            r0 = r3
            goto L_0x006e
        L_0x0053:
            r13 = move-exception
            goto L_0x0061
        L_0x0055:
            r13 = move-exception
            goto L_0x006e
        L_0x0057:
            if (r0 == 0) goto L_0x005c
            r0.close()     // Catch:{ all -> 0x0074 }
        L_0x005c:
            if (r12 == 0) goto L_0x007b
            goto L_0x0078
        L_0x005f:
            r13 = move-exception
            r12 = r0
        L_0x0061:
            if (r0 == 0) goto L_0x0066
            r0.close()     // Catch:{ all -> 0x0074 }
        L_0x0066:
            if (r12 == 0) goto L_0x006b
            r12.close()     // Catch:{ all -> 0x0074 }
        L_0x006b:
            throw r13     // Catch:{ all -> 0x0074 }
        L_0x006c:
            r12 = move-exception
            r12 = r0
        L_0x006e:
            if (r0 == 0) goto L_0x0076
            r0.close()     // Catch:{ all -> 0x0074 }
            goto L_0x0076
        L_0x0074:
            r12 = move-exception
            goto L_0x007e
        L_0x0076:
            if (r12 == 0) goto L_0x007b
        L_0x0078:
            r12.close()     // Catch:{ all -> 0x0074 }
        L_0x007b:
            monitor-exit(r15)     // Catch:{ all -> 0x0074 }
            int r12 = (int) r1     // Catch:{ all -> 0x0074 }
            return r12
        L_0x007e:
            monitor-exit(r15)     // Catch:{ all -> 0x0074 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.pushservice.PushInfoProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
