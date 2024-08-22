package fe.fe.ddd.when.qw.yj.i;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;

public class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static boolean f1726fe = AppConfig.rg();

    /* renamed from: rg  reason: collision with root package name */
    public static volatile qw f1727rg;

    /* renamed from: ad  reason: collision with root package name */
    public String f1728ad;

    /* renamed from: de  reason: collision with root package name */
    public SharedPreferences f1729de;
    public String qw;

    public qw() {
        fe();
    }

    public static qw ad() {
        if (f1727rg == null) {
            synchronized (qw.class) {
                if (f1727rg == null) {
                    f1727rg = new qw();
                }
            }
        }
        return f1727rg;
    }

    public String de() {
        return this.qw;
    }

    public final void fe() {
        this.f1729de = fe.fe.ddd.i.qw.qw.qw().getSharedPreferences("com.baidu.common.pubparam", 0);
        th();
        rg();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3 = f1726fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.close();
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r0 = f1726fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        throw r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String i() {
        /*
            r4 = this;
            android.content.Context r0 = fe.fe.ddd.i.qw.qw.qw()
            android.content.res.Resources r0 = r0.getResources()
            android.content.Context r1 = fe.fe.ddd.i.qw.qw.qw()
            java.lang.String r1 = r1.getPackageName()
            java.lang.String r2 = "tnconfig"
            java.lang.String r3 = "raw"
            int r1 = r0.getIdentifier(r2, r3, r1)
            r2 = 0
            if (r1 != 0) goto L_0x001c
            return r2
        L_0x001c:
            java.io.InputStream r0 = r0.openRawResource(r1)
            java.io.BufferedReader r1 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            r3.<init>(r0)
            r1.<init>(r3)
            java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x003b }
            r0.close()     // Catch:{ Exception -> 0x0035 }
            r1.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0043
        L_0x0035:
            boolean r0 = f1726fe
            goto L_0x0043
        L_0x0039:
            r2 = move-exception
            goto L_0x0044
        L_0x003b:
            boolean r3 = f1726fe     // Catch:{ all -> 0x0039 }
            r0.close()     // Catch:{ Exception -> 0x0035 }
            r1.close()     // Catch:{ Exception -> 0x0035 }
        L_0x0043:
            return r2
        L_0x0044:
            r0.close()     // Catch:{ Exception -> 0x004b }
            r1.close()     // Catch:{ Exception -> 0x004b }
            goto L_0x004e
        L_0x004b:
            boolean r0 = f1726fe
        L_0x004e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.qw.yj.i.qw.i():java.lang.String");
    }

    public final void o() {
        this.f1729de.edit().putString("channel", this.f1728ad).apply();
    }

    public String qw() {
        return this.f1728ad;
    }

    public final void rg() {
        String yj2 = yj();
        this.f1728ad = yj2;
        if (TextUtils.isEmpty(yj2) && !TextUtils.isEmpty(this.qw)) {
            this.f1728ad = this.qw;
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.io.InputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004c A[SYNTHETIC, Splitter:B:28:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054 A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0062 A[SYNTHETIC, Splitter:B:39:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006a A[Catch:{ Exception -> 0x0066 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String uk() {
        /*
            r5 = this;
            java.lang.String r0 = "file:///android_asset/channel"
            r1 = 0
            android.content.Context r2 = fe.fe.ddd.i.qw.qw.qw()     // Catch:{ IOException -> 0x0046, all -> 0x0041 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ IOException -> 0x0046, all -> 0x0041 }
            java.io.InputStream r0 = r2.open(r0)     // Catch:{ IOException -> 0x0046, all -> 0x0041 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003d, all -> 0x0038 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003d, all -> 0x0038 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x003d, all -> 0x0038 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x003d, all -> 0x0038 }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
            r0.close()     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
            r2.close()     // Catch:{ IOException -> 0x0034, all -> 0x0032 }
            if (r0 == 0) goto L_0x002b
            r0.close()     // Catch:{ Exception -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            goto L_0x002f
        L_0x002b:
            r2.close()     // Catch:{ Exception -> 0x0029 }
            goto L_0x005b
        L_0x002f:
            boolean r0 = f1726fe
            goto L_0x005b
        L_0x0032:
            r1 = move-exception
            goto L_0x0060
        L_0x0034:
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0048
        L_0x0038:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
            goto L_0x0060
        L_0x003d:
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x0048
        L_0x0041:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L_0x0060
        L_0x0046:
            r0 = r1
            r2 = r0
        L_0x0048:
            boolean r3 = f1726fe     // Catch:{ all -> 0x005c }
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ Exception -> 0x0050 }
            goto L_0x0052
        L_0x0050:
            goto L_0x0058
        L_0x0052:
            if (r2 == 0) goto L_0x005a
            r2.close()     // Catch:{ Exception -> 0x0050 }
            goto L_0x005a
        L_0x0058:
            boolean r1 = f1726fe
        L_0x005a:
            r1 = r0
        L_0x005b:
            return r1
        L_0x005c:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0060:
            if (r0 == 0) goto L_0x0068
            r0.close()     // Catch:{ Exception -> 0x0066 }
            goto L_0x0068
        L_0x0066:
            goto L_0x006e
        L_0x0068:
            if (r2 == 0) goto L_0x0070
            r2.close()     // Catch:{ Exception -> 0x0066 }
            goto L_0x0070
        L_0x006e:
            boolean r0 = f1726fe
        L_0x0070:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.qw.yj.i.qw.uk():java.lang.String");
    }

    public final String yj() {
        return this.f1729de.getString("channel", (String) null);
    }
}
