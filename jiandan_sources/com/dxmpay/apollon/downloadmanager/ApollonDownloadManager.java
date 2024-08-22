package com.dxmpay.apollon.downloadmanager;

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

    /* renamed from: th  reason: collision with root package name */
    public static ApollonDownloadManager f3965th;

    /* renamed from: ad  reason: collision with root package name */
    public final HashMap<Long, ad> f3966ad = new HashMap<>();

    /* renamed from: de  reason: collision with root package name */
    public final String f3967de;

    /* renamed from: fe  reason: collision with root package name */
    public Context f3968fe;
    public final DownloadManager qw;

    /* renamed from: rg  reason: collision with root package name */
    public SparseArray<DownloadManager.Request> f3969rg = new SparseArray<>();

    public interface DownloadListener {
        void onChanged(DownloadItemInfo downloadItemInfo);
    }

    public final class ad extends ContentObserver {

        /* renamed from: ad  reason: collision with root package name */
        public final HashSet<DownloadListener> f3970ad;

        /* renamed from: de  reason: collision with root package name */
        public long f3971de;

        /* renamed from: fe  reason: collision with root package name */
        public long f3972fe;
        public DownloadItemInfo qw;

        /* renamed from: rg  reason: collision with root package name */
        public int f3973rg;

        /* renamed from: th  reason: collision with root package name */
        public Context f3974th;

        public void ad(DownloadItemInfo downloadItemInfo) {
            this.qw = downloadItemInfo;
        }

        public boolean de() {
            return this.f3970ad.isEmpty();
        }

        public final synchronized boolean fe(DownloadListener downloadListener) {
            return this.f3970ad.add(downloadListener);
        }

        public void onChange(boolean z) {
            super.onChange(z);
            if (ApollonDownloadManager.this.fe(this.qw)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((this.f3973rg != this.qw.getDownloadState() || this.f3971de != this.qw.getCurrentBytes()) && this.f3972fe != currentTimeMillis) {
                    if (2 == this.qw.getDownloadState()) {
                        DownloadItemInfo downloadItemInfo = this.qw;
                        downloadItemInfo.setSpeed(((downloadItemInfo.getCurrentBytes() - this.f3971de) * 1000) / (currentTimeMillis - this.f3972fe));
                    } else {
                        this.qw.setSpeed(0);
                    }
                    this.f3971de = this.qw.getCurrentBytes();
                    this.f3973rg = this.qw.getDownloadState();
                    this.f3972fe = currentTimeMillis;
                    synchronized (this) {
                        int size = this.f3970ad.size();
                        DownloadListener[] downloadListenerArr = new DownloadListener[size];
                        this.f3970ad.toArray(downloadListenerArr);
                        for (int i2 = 0; i2 < size; i2++) {
                            downloadListenerArr[i2].onChanged(this.qw);
                        }
                    }
                    if ((this.qw.getDownloadState() & 24) != 0) {
                        ApollonDownloadManager.this.unregisterObserver(this.f3974th, this.qw.getDownloadId());
                    }
                }
            }
        }

        public final synchronized void th() {
            this.f3970ad.clear();
        }

        public final synchronized boolean yj(DownloadListener downloadListener) {
            return this.f3970ad.remove(downloadListener);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ad(android.content.Context r4, long r5) {
            /*
                r2 = this;
                com.dxmpay.apollon.downloadmanager.ApollonDownloadManager.this = r3
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
                r2.f3970ad = r3
                r0 = 0
                r2.f3971de = r0
                r2.f3972fe = r0
                r3 = 1
                r2.f3973rg = r3
                com.dxmpay.apollon.downloadmanager.DownloadItemInfo r3 = new com.dxmpay.apollon.downloadmanager.DownloadItemInfo
                r3.<init>(r5)
                r2.qw = r3
                android.content.Context r3 = r4.getApplicationContext()
                r2.f3974th = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.downloadmanager.ApollonDownloadManager.ad.<init>(com.dxmpay.apollon.downloadmanager.ApollonDownloadManager, android.content.Context, long):void");
        }
    }

    public ApollonDownloadManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f3968fe = applicationContext;
        this.qw = (DownloadManager) applicationContext.getSystemService("download");
        this.f3967de = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public static ApollonDownloadManager getInstance(Context context) {
        if (f3965th == null) {
            f3965th = new ApollonDownloadManager(context);
        }
        return f3965th;
    }

    public final String ad(String str) {
        String str2 = str.startsWith(this.f3967de) ? null : this.f3967de;
        File parentFile = new File(str2, str).getParentFile();
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            return null;
        }
        return str2 == null ? str.substring(this.f3967de.length()) : str;
    }

    public void cancelDownload(long j) {
        this.qw.remove(new long[]{j});
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
        String ad2 = ad(str2);
        if (ad2 == null) {
            return -1;
        }
        DownloadManager.Request qw2 = qw(str, ad2, str3, z, z2, z3, str4);
        int hashCode = qw2.hashCode();
        this.f3969rg.put(hashCode, qw2);
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
        return this.qw.enqueue(qw(Environment.DIRECTORY_DOWNLOADS, str, str2, z, z2, z3, ".apk"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        if (r0 == null) goto L_0x007c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean fe(com.dxmpay.apollon.downloadmanager.DownloadItemInfo r11) {
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
            android.app.DownloadManager r5 = r10.qw     // Catch:{ Exception -> 0x0076, all -> 0x006f }
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
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.downloadmanager.ApollonDownloadManager.fe(com.dxmpay.apollon.downloadmanager.DownloadItemInfo):boolean");
    }

    public DownloadItemInfo queryDownloadData(long j) {
        if (j == -1) {
            return null;
        }
        DownloadItemInfo downloadItemInfo = new DownloadItemInfo(j);
        fe(downloadItemInfo);
        return downloadItemInfo;
    }

    public final DownloadManager.Request qw(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void registerObserver(android.content.Context r8, long r9, com.dxmpay.apollon.downloadmanager.ApollonDownloadManager.DownloadListener r11) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r11 == 0) goto L_0x0050
            r0 = -1
            int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x000a
            goto L_0x0050
        L_0x000a:
            java.util.HashMap<java.lang.Long, com.dxmpay.apollon.downloadmanager.ApollonDownloadManager$ad> r0 = r7.f3966ad     // Catch:{ all -> 0x004d }
            java.lang.Long r1 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x004d }
            com.dxmpay.apollon.downloadmanager.ApollonDownloadManager$ad r0 = (com.dxmpay.apollon.downloadmanager.ApollonDownloadManager.ad) r0     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0048
            com.dxmpay.apollon.downloadmanager.ApollonDownloadManager$ad r0 = new com.dxmpay.apollon.downloadmanager.ApollonDownloadManager$ad     // Catch:{ all -> 0x004d }
            r6 = 0
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r1.<init>(r3, r4)     // Catch:{ all -> 0x004d }
            java.util.HashMap<java.lang.Long, com.dxmpay.apollon.downloadmanager.ApollonDownloadManager$ad> r1 = r7.f3966ad     // Catch:{ all -> 0x004d }
            java.lang.Long r2 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x004d }
            r1.put(r2, r0)     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r1.<init>()     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "content://downloads/my_downloads/"
            r1.append(r2)     // Catch:{ all -> 0x004d }
            r1.append(r9)     // Catch:{ all -> 0x004d }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x004d }
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ all -> 0x004d }
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch:{ all -> 0x004d }
            r10 = 1
            r8.registerContentObserver(r9, r10, r0)     // Catch:{ all -> 0x004d }
        L_0x0048:
            boolean unused = r0.fe(r11)     // Catch:{ all -> 0x004d }
            monitor-exit(r7)
            return
        L_0x004d:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x0050:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.downloadmanager.ApollonDownloadManager.registerObserver(android.content.Context, long, com.dxmpay.apollon.downloadmanager.ApollonDownloadManager$DownloadListener):void");
    }

    public void unregisterObserver(Context context, long j, DownloadListener downloadListener) {
        ad adVar;
        if (j != -1 && (adVar = this.f3966ad.get(Long.valueOf(j))) != null) {
            boolean unused = adVar.yj(downloadListener);
            if (adVar.de()) {
                context.getContentResolver().unregisterContentObserver(adVar);
                this.f3966ad.remove(Uri.parse(com.baidu.apollon.downloadmanager.ApollonDownloadManager.b + j));
            }
        }
    }

    public synchronized long doDownload(String str, String str2, String str3, boolean z, boolean z2, boolean z3, String str4) {
        if (!TextUtils.isEmpty(str3)) {
            if (str3.startsWith("http://") || str3.startsWith("https://")) {
                return this.qw.enqueue(qw(str, str2, str3, z, z2, z3, str4));
            }
        }
        return -1;
    }

    public ApollonDownloadManager(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f3968fe = applicationContext;
        this.qw = (DownloadManager) applicationContext.getSystemService("download");
        this.f3967de = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    public void unregisterObserver(Context context, long j) {
        ad adVar;
        if (j != -1 && (adVar = this.f3966ad.get(Long.valueOf(j))) != null) {
            adVar.th();
            context.getContentResolver().unregisterContentObserver(adVar);
            this.f3966ad.remove(Uri.parse(com.baidu.apollon.downloadmanager.ApollonDownloadManager.b + j));
        }
    }

    public void doDownload(int i2) {
        if (-1 != i2) {
            DownloadManager.Request request = this.f3969rg.get(i2, (Object) null);
            if (request != null) {
                this.f3969rg.delete(i2);
            }
            ContentResolver contentResolver = this.f3968fe.getContentResolver();
            ad remove = this.f3966ad.remove(Long.valueOf((long) i2));
            if (remove != null) {
                contentResolver.unregisterContentObserver(remove);
                long enqueue = this.qw.enqueue(request);
                this.f3966ad.put(Long.valueOf(enqueue), remove);
                remove.ad(new DownloadItemInfo(enqueue));
                contentResolver.registerContentObserver(Uri.parse(com.baidu.apollon.downloadmanager.ApollonDownloadManager.b + enqueue), true, remove);
            }
        }
    }
}
