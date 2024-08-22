package com.baidu.wallet.utils;

import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.apollon.downloadmanager.ApollonDownloadManager;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Downloader {
    public static final int f = 1;
    public DownloadManager a;
    public final Pattern b;
    public final Pattern c;
    public Handler d;
    public ContentResolver e;
    public final String g;

    public interface DownloaderListener {
        void onProgress(String str, int i2, long j, long j2);
    }

    public final class a extends ContentObserver {
        public long b;
        public DownloaderListener c;
        public String d;
        public final int e = 24;

        public a(Handler handler, String str, long j, DownloaderListener downloaderListener) {
            super(handler);
            this.d = str;
            this.b = j;
            this.c = downloaderListener;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            r10.c = null;
            com.baidu.wallet.utils.Downloader.b(r10.a).unregisterContentObserver(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
            if (r11 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
            r12 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
            r0 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x006e */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0083  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(long r11) {
            /*
                r10 = this;
                r0 = 0
                com.baidu.wallet.utils.Downloader r1 = com.baidu.wallet.utils.Downloader.this     // Catch:{ Exception -> 0x006d, all -> 0x006b }
                android.app.DownloadManager r1 = r1.a     // Catch:{ Exception -> 0x006d, all -> 0x006b }
                android.app.DownloadManager$Query r2 = new android.app.DownloadManager$Query     // Catch:{ Exception -> 0x006d, all -> 0x006b }
                r2.<init>()     // Catch:{ Exception -> 0x006d, all -> 0x006b }
                r3 = 1
                long[] r3 = new long[r3]     // Catch:{ Exception -> 0x006d, all -> 0x006b }
                r4 = 0
                r3[r4] = r11     // Catch:{ Exception -> 0x006d, all -> 0x006b }
                android.app.DownloadManager$Query r11 = r2.setFilterById(r3)     // Catch:{ Exception -> 0x006d, all -> 0x006b }
                android.database.Cursor r11 = r1.query(r11)     // Catch:{ Exception -> 0x006d, all -> 0x006b }
                if (r11 == 0) goto L_0x0065
                int r12 = r11.getCount()     // Catch:{ Exception -> 0x006e }
                if (r12 == 0) goto L_0x0065
                boolean r12 = r11.moveToFirst()     // Catch:{ Exception -> 0x006e }
                if (r12 != 0) goto L_0x0029
                goto L_0x0065
            L_0x0029:
                java.lang.String r12 = "total_size"
                int r12 = r11.getColumnIndexOrThrow(r12)     // Catch:{ Exception -> 0x006e }
                java.lang.String r1 = "bytes_so_far"
                int r1 = r11.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x006e }
                java.lang.String r2 = "status"
                int r2 = r11.getColumnIndex(r2)     // Catch:{ Exception -> 0x006e }
                long r6 = r11.getLong(r12)     // Catch:{ Exception -> 0x006e }
                long r8 = r11.getLong(r1)     // Catch:{ Exception -> 0x006e }
                int r12 = r11.getInt(r2)     // Catch:{ Exception -> 0x006e }
                com.baidu.wallet.utils.Downloader$DownloaderListener r1 = r10.c     // Catch:{ Exception -> 0x006e }
                if (r1 == 0) goto L_0x0053
                com.baidu.wallet.utils.Downloader$DownloaderListener r3 = r10.c     // Catch:{ Exception -> 0x006e }
                java.lang.String r4 = r10.d     // Catch:{ Exception -> 0x006e }
                r5 = r12
                r3.onProgress(r4, r5, r6, r8)     // Catch:{ Exception -> 0x006e }
            L_0x0053:
                r12 = r12 & 24
                if (r12 == 0) goto L_0x0062
                r10.c = r0     // Catch:{ Exception -> 0x006e }
                com.baidu.wallet.utils.Downloader r12 = com.baidu.wallet.utils.Downloader.this     // Catch:{ Exception -> 0x006e }
                android.content.ContentResolver r12 = r12.e     // Catch:{ Exception -> 0x006e }
                r12.unregisterContentObserver(r10)     // Catch:{ Exception -> 0x006e }
            L_0x0062:
                if (r11 == 0) goto L_0x007e
                goto L_0x007b
            L_0x0065:
                if (r11 == 0) goto L_0x006a
                r11.close()
            L_0x006a:
                return
            L_0x006b:
                r12 = move-exception
                goto L_0x0081
            L_0x006d:
                r11 = r0
            L_0x006e:
                r10.c = r0     // Catch:{ all -> 0x007f }
                com.baidu.wallet.utils.Downloader r12 = com.baidu.wallet.utils.Downloader.this     // Catch:{ all -> 0x007f }
                android.content.ContentResolver r12 = r12.e     // Catch:{ all -> 0x007f }
                r12.unregisterContentObserver(r10)     // Catch:{ all -> 0x007f }
                if (r11 == 0) goto L_0x007e
            L_0x007b:
                r11.close()
            L_0x007e:
                return
            L_0x007f:
                r12 = move-exception
                r0 = r11
            L_0x0081:
                if (r0 == 0) goto L_0x0086
                r0.close()
            L_0x0086:
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.utils.Downloader.a.a(long):void");
        }

        public void onChange(boolean z) {
            super.onChange(z);
            a(this.b);
        }
    }

    public class b {
        public String a;
        public DownloaderListener b;
        public String c;

        public b() {
        }
    }

    public static final class c {
        public static Downloader a = new Downloader();
    }

    public static Downloader getInstance() {
        return c.a;
    }

    public void download(String str, String str2, DownloaderListener downloaderListener) {
        if (str != null ? this.c.matcher(str).matches() : false) {
            b bVar = new b();
            bVar.a = str;
            bVar.b = downloaderListener;
            bVar.c = str2;
            this.d.obtainMessage(1, bVar).sendToTarget();
            return;
        }
        a(downloaderListener, str);
    }

    public void init(Context context) {
        if (this.a == null && context != null) {
            this.a = (DownloadManager) context.getSystemService("download");
            this.e = context.getContentResolver();
            HandlerThread handlerThread = new HandlerThread("downloader");
            handlerThread.start();
            this.d = new Handler(handlerThread.getLooper()) {
                public void handleMessage(Message message) {
                    if (1 == message.what) {
                        b bVar = (b) message.obj;
                        if (Downloader.this.a == null) {
                            Downloader.this.a(bVar.b, bVar.a);
                        } else {
                            Downloader.this.a(bVar.a, bVar.b, bVar.c);
                        }
                    }
                }
            };
        }
    }

    public Downloader() {
        this.b = Pattern.compile(".*\\/(.*)");
        this.c = Pattern.compile("^(https?)://.*");
        this.g = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    private String b(String str) {
        String str2 = str.startsWith(this.g) ? null : this.g;
        File parentFile = new File(str2, str).getParentFile();
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            return null;
        }
        return str2 == null ? str.substring(this.g.length()) : str;
    }

    /* access modifiers changed from: private */
    public void a(String str, DownloaderListener downloaderListener, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = a(str);
        }
        if (str2 == null) {
            a(downloaderListener, str);
            return;
        }
        String b2 = b(str2);
        if (b2 == null) {
            a(downloaderListener, str);
            return;
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setNotificationVisibility(2);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, b2);
            request.setAllowedNetworkTypes(2);
            long enqueue = this.a.enqueue(request);
            a aVar = new a(this.d, str, enqueue, downloaderListener);
            this.e.registerContentObserver(Uri.parse(ApollonDownloadManager.b + enqueue), true, aVar);
        } catch (Exception e2) {
            a(downloaderListener, str);
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(DownloaderListener downloaderListener, String str) {
        if (downloaderListener != null) {
            downloaderListener.onProgress(str, 16, 0, 0);
        }
    }

    private String a(String str) {
        Matcher matcher = this.b.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }
}
