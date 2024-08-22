package fe.fe.yj.qw;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;

public class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static boolean f3221fe = AppConfig.rg();

    /* renamed from: rg  reason: collision with root package name */
    public static qw f3222rg;

    /* renamed from: ad  reason: collision with root package name */
    public String f3223ad;

    /* renamed from: de  reason: collision with root package name */
    public SharedPreferences f3224de;
    public String qw;

    public qw() {
        fe();
    }

    public static qw ad() {
        if (f3222rg == null) {
            synchronized (qw.class) {
                if (f3222rg == null) {
                    f3222rg = new qw();
                }
            }
        }
        return f3222rg;
    }

    public String de() {
        return this.qw;
    }

    public final void fe() {
        this.f3224de = fe.fe.ddd.i.qw.qw.qw().getSharedPreferences("com.baidu.common.pubparam", 0);
        th();
        rg();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|14|15|16|17|18) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|4|5|6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r3 = f3221fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1.close();
        r2.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0029 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0039 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0024 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:7:0x0024=Splitter:B:7:0x0024, B:16:0x0039=Splitter:B:16:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String i() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = fe.fe.ddd.i.qw.qw.qw()     // Catch:{ Exception -> 0x003c }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x003c }
            r2 = 2131820544(0x7f110000, float:1.9273806E38)
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch:{ Exception -> 0x003c }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003c }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003c }
            r3.<init>(r1)     // Catch:{ Exception -> 0x003c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x003c }
            java.lang.String r0 = r2.readLine()     // Catch:{ Exception -> 0x0029 }
            r1.close()     // Catch:{ Exception -> 0x0024 }
            r2.close()     // Catch:{ Exception -> 0x0024 }
            goto L_0x003f
        L_0x0024:
            boolean r1 = f3221fe     // Catch:{ Exception -> 0x003c }
            goto L_0x003f
        L_0x0027:
            r3 = move-exception
            goto L_0x0032
        L_0x0029:
            boolean r3 = f3221fe     // Catch:{ all -> 0x0027 }
            r1.close()     // Catch:{ Exception -> 0x0024 }
            r2.close()     // Catch:{ Exception -> 0x0024 }
            goto L_0x003f
        L_0x0032:
            r1.close()     // Catch:{ Exception -> 0x0039 }
            r2.close()     // Catch:{ Exception -> 0x0039 }
            goto L_0x003b
        L_0x0039:
            boolean r1 = f3221fe     // Catch:{ Exception -> 0x003c }
        L_0x003b:
            throw r3     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            boolean r1 = f3221fe
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.yj.qw.qw.i():java.lang.String");
    }

    public final void o() {
        this.f3224de.edit().putString("channel", this.f3223ad).apply();
    }

    public String qw() {
        return this.f3223ad;
    }

    public final void rg() {
        String yj2 = yj();
        this.f3223ad = yj2;
        if (TextUtils.isEmpty(yj2) && !TextUtils.isEmpty(this.qw)) {
            this.f3223ad = this.qw;
            o();
        }
    }

    public final void th() {
        String i2 = i();
        this.qw = i2;
        if (TextUtils.isEmpty(i2)) {
            this.qw = uk();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r3 = f3221fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        if (r0 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0042, code lost:
        r0 = f3221fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        if (r2 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0048, code lost:
        r1 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004b A[SYNTHETIC, Splitter:B:35:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0053 A[SYNTHETIC, Splitter:B:40:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String uk() {
        /*
            r5 = this;
            java.lang.String r0 = "channel"
            r1 = 0
            android.content.Context r2 = fe.fe.ddd.i.qw.qw.qw()     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            java.io.InputStream r0 = r2.open(r0)     // Catch:{ Exception -> 0x0038, all -> 0x0033 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0031, all -> 0x002c }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0031, all -> 0x002c }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x003a }
            if (r0 == 0) goto L_0x0025
            r0.close()     // Catch:{ Exception -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            boolean r0 = f3221fe
        L_0x0025:
            r2.close()     // Catch:{ Exception -> 0x0029 }
            goto L_0x0047
        L_0x0029:
            boolean r0 = f3221fe
            goto L_0x0047
        L_0x002c:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
            goto L_0x0049
        L_0x0031:
            r2 = r1
            goto L_0x003a
        L_0x0033:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x0049
        L_0x0038:
            r0 = r1
            r2 = r0
        L_0x003a:
            boolean r3 = f3221fe     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0044
            r0.close()     // Catch:{ Exception -> 0x0042 }
            goto L_0x0044
        L_0x0042:
            boolean r0 = f3221fe
        L_0x0044:
            if (r2 == 0) goto L_0x0047
            goto L_0x0025
        L_0x0047:
            return r1
        L_0x0048:
            r1 = move-exception
        L_0x0049:
            if (r0 == 0) goto L_0x0051
            r0.close()     // Catch:{ Exception -> 0x004f }
            goto L_0x0051
        L_0x004f:
            boolean r0 = f3221fe
        L_0x0051:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ Exception -> 0x0057 }
            goto L_0x0059
        L_0x0057:
            boolean r0 = f3221fe
        L_0x0059:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.yj.qw.qw.uk():java.lang.String");
    }

    public final String yj() {
        return this.f3224de.getString("channel", (String) null);
    }
}
