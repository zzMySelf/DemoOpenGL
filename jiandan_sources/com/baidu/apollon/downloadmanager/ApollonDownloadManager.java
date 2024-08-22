package com.baidu.apollon.downloadmanager;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

@TargetApi(9)
public final class ApollonDownloadManager {
    public static final String a = "WalletDownloadManager";
    public static final String b = "content://downloads/my_downloads/";
    public static ApollonDownloadManager c;
    public final DownloadManager d;
    public final HashMap<Long, a> e = new HashMap<>();
    public final String f;
    public Context g = null;
    public SparseArray<DownloadManager.Request> h = new SparseArray<>();

    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    public final class a extends ContentObserver {
        public DownloadItemInfo b;
        public final HashSet<DownloadListener> c;
        public long d;
        public long e;
        public int f;
        public Context g;

        public void onChange(boolean z) {
            super.onChange(z);
            if (ApollonDownloadManager.this.a(this.b)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f != this.b.getDownloadState() || this.d != this.b.getCurrentBytes()) && this.e != currentTimeMillis) {
                    if (2 == this.b.getDownloadState()) {
                        DownloadItemInfo downloadItemInfo = this.b;
                        downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.d) * 1000) / (currentTimeMillis - this.e));
                    } else {
                        this.b.setSpeed(0);
                    }
                    this.d = this.b.getCurrentBytes();
                    this.f = this.b.getDownloadState();
                    this.e = currentTimeMillis;
                    synchronized (this) {
                        int size = this.c.size();
                        DownloadListener[] downloadListenerArr = new DownloadListener[size];
                        this.c.toArray(downloadListenerArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            downloadListenerArr[i2].onChanged(this.b);
                        }
                    }
                    if ((this.b.getDownloadState() & 24) != 0) {
                        ApollonDownloadManager.this.unregisterObserver(this.g, this.b.getDownloadId());
                    }
                }
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(android.content.Context r4, long r5) {
            /*
                r2 = this;
                com.baidu.apollon.downloadmanager.ApollonDownloadManager.this = r3
                android.os.Handler r3 = new android.os.Handler
                if (r4 == 0) goto L_0x000e
                android.os.Looper r0 = r4.getMainLooper()
                r3.<init>(r0)
                goto L_0x0011
            L_0x000e:
                r3.<init>()
            L_0x0011:
                r2.<init>(r3)
                java.util.HashSet r3 = new java.util.HashSet
                r3.<init>()
                r2.c = r3
                r0 = 0
                r2.d = r0
                r2.e = r0
                r3 = 1
                r2.f = r3
                com.baidu.apollon.downloadmanager.DownloadItemInfo r3 = new com.baidu.apollon.downloadmanager.DownloadItemInfo
                r3.<init>(r5)
                r2.b = r3
                android.content.Context r3 = com.baidu.apollon.utils.DxmApplicationContextImpl.getApplicationContext(r4)
                r2.g = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.downloadmanager.ApollonDownloadManager.a.<init>(com.baidu.apollon.downloadmanager.ApollonDownloadManager, android.content.Context, long):void");
        }

        /* access modifiers changed from: private */
        public synchronized boolean b(DownloadListener downloadListener) {
            return this.c.remove(downloadListener);
        }

        /* access modifiers changed from: private */
        public synchronized void b() {
            this.c.clear();
        }

        public void a(DownloadItemInfo downloadItemInfo) {
            this.b = downloadItemInfo;
        }

        /* access modifiers changed from: private */
        public synchronized boolean a(DownloadListener downloadListener) {
            return this.c.add(downloadListener);
        }

        public boolean a() {
            return this.c.isEmpty();
        }
    }

    public ApollonDownloadManager(Context context) {
        this.g = context;
        this.d = (DownloadManager) context.getSystemService("download");
        this.f = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public static ApollonDownloadManager getInstance(Context context) {
        if (c == null) {
            c = new ApollonDownloadManager(context);
        }
        return c;
    }

    public void cancelDownload(long j) {
        this.d.remove(new long[]{j});
    }

    public int createTask(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        String str5 = str3;
        if (TextUtils.isEmpty(str3)) {
            return -1;
        }
        if (!str3.startsWith("http://") && !str3.startsWith("https://")) {
            return -1;
        }
        String str6 = str2;
        String a2 = a(str2);
        if (a2 == null) {
            return -1;
        }
        DownloadManager.Request a3 = a(str, a2, str3, z, z2, z3, str4);
        int hashCode = a3.hashCode();
        this.h.put(hashCode, a3);
        return hashCode;
    }

    @Deprecated
    public long doDownload(String str, String str2, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
            return -1;
        }
        return this.d.enqueue(a(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
    }

    public DownloadItemInfo queryDownloadData(long j) {
        if (j == -1) {
            return null;
        }
        DownloadItemInfo downloadItemInfo = new DownloadItemInfo(j);
        a(downloadItemInfo);
        return downloadItemInfo;
    }

    public void registerObserver(Context context, long j, DownloadListener downloadListener) {
        if (downloadListener != null && -1 != j) {
            a aVar = this.e.get(Long.valueOf(j));
            if (aVar == null) {
                aVar = new a(context, j);
                this.e.put(Long.valueOf(j), aVar);
                context.getContentResolver().registerContentObserver(Uri.parse(b + j), true, aVar);
            }
            boolean unused = aVar.a(downloadListener);
        }
    }

    public void unregisterObserver(Context context, long j, DownloadListener downloadListener) {
        a aVar;
        if (j != -1 && (aVar = this.e.get(Long.valueOf(j))) != null) {
            boolean unused = aVar.b(downloadListener);
            if (aVar.a()) {
                context.getContentResolver().unregisterContentObserver(aVar);
                this.e.remove(Uri.parse(b + j));
            }
        }
    }

    private String a(String str) {
        String str2 = str.startsWith(this.f) ? null : this.f;
        File parentFile = new File(str2, str).getParentFile();
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            return null;
        }
        return str2 == null ? str.substring(this.f.length()) : str;
    }

    @Deprecated
    public long doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        if (TextUtils.isEmpty(str3)) {
            return -1;
        }
        if (!str3.startsWith("http://") && !str3.startsWith("https://")) {
            return -1;
        }
        return this.d.enqueue(a(str, str2, str3, z, z2, z3, str4));
    }

    public void doDownload(int i2) {
        if (-1 != i2) {
            DownloadManager.Request request = this.h.get(i2, (Object) null);
            if (request != null) {
                this.h.delete(i2);
            }
            ContentResolver contentResolver = this.g.getContentResolver();
            a remove = this.e.remove(Long.valueOf((long) i2));
            if (remove != null) {
                contentResolver.unregisterContentObserver(remove);
                long enqueue = this.d.enqueue(request);
                this.e.put(Long.valueOf(enqueue), remove);
                remove.a(new DownloadItemInfo(enqueue));
                contentResolver.registerContentObserver(Uri.parse(b + enqueue), true, remove);
            }
        }
    }

    public void unregisterObserver(Context context, long j) {
        a aVar;
        if (j != -1 && (aVar = this.e.get(Long.valueOf(j))) != null) {
            aVar.b();
            context.getContentResolver().unregisterContentObserver(aVar);
            this.e.remove(Uri.parse(b + j));
        }
    }

    private DownloadManager.Request a(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str3));
        if (z3) {
            request.setAllowedNetworkTypes(2);
        } else {
            request.setAllowedNetworkTypes(3);
        }
        request.setShowRunningNotification(z);
        request.setVisibleInDownloadsUi(z2);
        request.setDestinationInExternalPublicDir(str, str2 + str4);
        return request;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        if (r0 == null) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.baidu.apollon.downloadmanager.DownloadItemInfo r11) {
        /*
            r10 = this;
            long r0 = r11.getDownloadId()
            r2 = -1
            r4 = 0
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x000c
            return r4
        L_0x000c:
            r0 = 0
            r1 = 1
            android.app.DownloadManager r5 = r10.d     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            android.app.DownloadManager$Query r6 = new android.app.DownloadManager$Query     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            r6.<init>()     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            long[] r7 = new long[r1]     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            long r8 = r11.getDownloadId()     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            r7[r4] = r8     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            android.app.DownloadManager$Query r6 = r6.setFilterById(r7)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            android.database.Cursor r0 = r5.query(r6)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            if (r0 == 0) goto L_0x005e
            int r5 = r0.getCount()     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            if (r5 == 0) goto L_0x005e
            boolean r5 = r0.moveToFirst()     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            if (r5 != 0) goto L_0x0034
            goto L_0x005e
        L_0x0034:
            java.lang.String r2 = "total_size"
            int r2 = r0.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            java.lang.String r3 = "bytes_so_far"
            int r3 = r0.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            java.lang.String r4 = "status"
            int r4 = r0.getColumnIndex(r4)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            long r5 = r0.getLong(r2)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            long r2 = r0.getLong(r3)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            int r4 = r0.getInt(r4)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            r11.setTotalBytes(r5)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            r11.setCurrentBytes(r2)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            r11.setDownloadState(r4)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            if (r0 == 0) goto L_0x007c
            goto L_0x0079
        L_0x005e:
            r5 = 0
            r11.setCurrentBytes(r5)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            r11.setTotalBytes(r2)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            r11.setDownloadState(r1)     // Catch:{ Exception -> 0x0076, all -> 0x006f }
            if (r0 == 0) goto L_0x006e
            r0.close()
        L_0x006e:
            return r4
        L_0x006f:
            r11 = move-exception
            if (r0 == 0) goto L_0x0075
            r0.close()
        L_0x0075:
            throw r11
        L_0x0076:
            if (r0 == 0) goto L_0x007c
        L_0x0079:
            r0.close()
        L_0x007c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.downloadmanager.ApollonDownloadManager.a(com.baidu.apollon.downloadmanager.DownloadItemInfo):boolean");
    }
}
