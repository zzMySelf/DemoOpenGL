package fe.fe.o.fe.qw.ad;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.down.loopj.android.b.b;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class qw implements Runnable {

    /* renamed from: if  reason: not valid java name */
    public static final ExecutorService f74if = Executors.newFixedThreadPool(2);

    /* renamed from: ad  reason: collision with root package name */
    public String f2518ad;

    /* renamed from: i  reason: collision with root package name */
    public b f2519i;

    /* renamed from: o  reason: collision with root package name */
    public Context f2520o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f2521pf;

    /* renamed from: th  reason: collision with root package name */
    public int f2522th;

    /* renamed from: uk  reason: collision with root package name */
    public List f2523uk;

    /* renamed from: yj  reason: collision with root package name */
    public String f2524yj;

    static {
        Class<qw> cls = qw.class;
    }

    public qw(Context context, boolean z, String str, List list, b bVar) {
        this.f2518ad = ShareTarget.METHOD_GET;
        this.f2522th = 3;
        this.f2521pf = false;
        this.f2520o = context.getApplicationContext();
        this.f2524yj = str;
        this.f2521pf = z;
        this.f2523uk = list;
        this.f2519i = bVar;
    }

    public qw(Context context, boolean z, String str, List list, b bVar, int i2) {
        this(context, z, str, list, bVar);
        this.f2522th = i2;
    }

    public void ad(String str) {
        this.f2518ad = str;
    }

    public final boolean de(String str) {
        return str != null && str.contains("gzip");
    }

    public void qw() {
        f74if.execute(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b5 A[Catch:{ InterruptedException -> 0x00c8, all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ce A[SYNTHETIC, Splitter:B:63:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d8 A[SYNTHETIC, Splitter:B:68:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e7 A[SYNTHETIC, Splitter:B:75:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f1 A[SYNTHETIC, Splitter:B:80:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x00e0 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            java.lang.System.currentTimeMillis()
            java.lang.String r0 = r9.f2524yj
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0013
            com.baidu.down.loopj.android.b.b r0 = r9.f2519i
            if (r0 == 0) goto L_0x0012
            r0.a()
        L_0x0012:
            return
        L_0x0013:
            r0 = 0
        L_0x0014:
            int r1 = r9.f2522th
            if (r0 >= r1) goto L_0x00fa
            r1 = 0
            fe.fe.o.fe.qw.ad.ad r2 = new fe.fe.o.fe.qw.ad.ad     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            android.content.Context r3 = r9.f2520o     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            boolean r4 = r9.f2521pf     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            r2.<init>((android.content.Context) r3, (boolean) r4)     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            java.lang.String r3 = r9.f2524yj     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            r4 = 0
            java.lang.String r5 = r9.f2518ad     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            java.util.List r6 = r9.f2523uk     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            r7 = 0
            r8 = 0
            java.net.HttpURLConnection r2 = r2.fe(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            r2.connect()     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r3 != r4) goto L_0x0088
            java.lang.String r3 = r2.getContentEncoding()     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            boolean r3 = r9.de(r3)     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            if (r3 == 0) goto L_0x004e
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            goto L_0x0052
        L_0x004e:
            java.io.InputStream r3 = r2.getInputStream()     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
        L_0x0052:
            java.lang.String r2 = ""
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0084, all -> 0x007f }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0084, all -> 0x007f }
            r5.<init>(r3)     // Catch:{ Exception -> 0x0084, all -> 0x007f }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0084, all -> 0x007f }
        L_0x005e:
            java.lang.String r1 = r4.readLine()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            if (r1 == 0) goto L_0x0074
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            r5.<init>()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            r5.append(r2)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            r5.append(r1)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            java.lang.String r2 = r5.toString()     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            goto L_0x005e
        L_0x0074:
            com.baidu.down.loopj.android.b.b r1 = r9.f2519i     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            r1.a(r2)     // Catch:{ Exception -> 0x007d, all -> 0x007b }
            r1 = r3
            goto L_0x008e
        L_0x007b:
            r0 = move-exception
            goto L_0x0081
        L_0x007d:
            r2 = move-exception
            goto L_0x0086
        L_0x007f:
            r0 = move-exception
            r4 = r1
        L_0x0081:
            r1 = r3
            goto L_0x00e5
        L_0x0084:
            r2 = move-exception
            r4 = r1
        L_0x0086:
            r1 = r3
            goto L_0x00a8
        L_0x0088:
            com.baidu.down.loopj.android.b.b r2 = r9.f2519i     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            r2.a()     // Catch:{ Exception -> 0x00a6, all -> 0x00a3 }
            r4 = r1
        L_0x008e:
            if (r1 == 0) goto L_0x0098
            r1.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0098:
            if (r4 == 0) goto L_0x00a2
            r4.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x00a2
        L_0x009e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a2:
            return
        L_0x00a3:
            r0 = move-exception
            r4 = r1
            goto L_0x00e5
        L_0x00a6:
            r2 = move-exception
            r4 = r1
        L_0x00a8:
            r2.printStackTrace()     // Catch:{ all -> 0x00e4 }
            if (r0 != 0) goto L_0x00c2
            java.lang.String r2 = r9.f2524yj     // Catch:{ all -> 0x00e4 }
            boolean r2 = android.webkit.URLUtil.isHttpsUrl(r2)     // Catch:{ all -> 0x00e4 }
            if (r2 == 0) goto L_0x00c2
            java.lang.String r2 = r9.f2524yj     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "https://"
            java.lang.String r5 = "http://"
            java.lang.String r2 = r2.replaceFirst(r3, r5)     // Catch:{ all -> 0x00e4 }
            r9.f2524yj = r2     // Catch:{ all -> 0x00e4 }
            goto L_0x00cc
        L_0x00c2:
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x00c8 }
            goto L_0x00cc
        L_0x00c8:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x00e4 }
        L_0x00cc:
            if (r1 == 0) goto L_0x00d6
            r1.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00d6:
            if (r4 == 0) goto L_0x00e0
            r4.close()     // Catch:{ IOException -> 0x00dc }
            goto L_0x00e0
        L_0x00dc:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00e0:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x00e4:
            r0 = move-exception
        L_0x00e5:
            if (r1 == 0) goto L_0x00ef
            r1.close()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00ef
        L_0x00eb:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00ef:
            if (r4 == 0) goto L_0x00f9
            r4.close()     // Catch:{ IOException -> 0x00f5 }
            goto L_0x00f9
        L_0x00f5:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00f9:
            throw r0
        L_0x00fa:
            com.baidu.down.loopj.android.b.b r0 = r9.f2519i
            if (r0 == 0) goto L_0x0101
            r0.a()
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.fe.qw.ad.qw.run():void");
    }
}
