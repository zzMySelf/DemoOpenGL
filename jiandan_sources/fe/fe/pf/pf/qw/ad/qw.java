package fe.fe.pf.pf.qw.ad;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.dlife.ctaccountapi.v;
import fe.fe.pf.yj.fe.de.de;
import fe.fe.pf.yj.fe.de.fe;
import fe.fe.pf.yj.rg.qw;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;

public class qw {

    /* renamed from: th  reason: collision with root package name */
    public static final String[] f2814th = {"f0fb772cce0da4ed791213b800defea286494ab98d00e1101cbf78a35e70ec4b"};

    /* renamed from: ad  reason: collision with root package name */
    public Context f2815ad;

    /* renamed from: de  reason: collision with root package name */
    public qw.C0142qw f2816de;

    /* renamed from: fe  reason: collision with root package name */
    public ZipFile f2817fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public PackageManager f2818rg;

    public static class ad {
        public long qw;

        public static ad qw(qw qwVar) {
            try {
                String th2 = qwVar.th("info");
                if (TextUtils.isEmpty(th2)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(th2);
                ad adVar = new ad();
                adVar.qw = jSONObject.getLong("version");
                return adVar;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* renamed from: fe.fe.pf.pf.qw.ad.qw$qw  reason: collision with other inner class name */
    public class C0131qw implements FilenameFilter {
        public C0131qw(qw qwVar) {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(".cfgtmp");
        }
    }

    public void ad(String str, Context context, qw.C0142qw qwVar) {
        this.qw = str;
        this.f2815ad = context;
        this.f2816de = qwVar;
        this.f2818rg = context.getPackageManager();
    }

    public boolean de() {
        File[] listFiles = this.f2816de.ad().listFiles(new C0131qw(this));
        int i2 = 0;
        if (listFiles == null) {
            return false;
        }
        int length = listFiles.length;
        boolean z = false;
        while (i2 < length) {
            listFiles[i2].delete();
            i2++;
            z = true;
        }
        return z;
    }

    public boolean fe() {
        ZipFile zipFile = this.f2817fe;
        if (zipFile == null) {
            return false;
        }
        de.fe(zipFile);
        this.f2817fe = null;
        return true;
    }

    public long i() {
        ad qw2 = ad.qw(this);
        if (qw2 != null) {
            return qw2.qw;
        }
        return 0;
    }

    public long o() {
        try {
            Bundle bundle = this.f2818rg.getPackageInfo(this.qw, 128).applicationInfo.metaData;
            if (bundle == null) {
                return -1;
            }
            String string = bundle.getString("com.baidu.helios.tc.qver");
            if (TextUtils.isEmpty(string) || !string.startsWith(v.d)) {
                return -1;
            }
            return Long.valueOf(string.substring(1)).longValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public boolean pf() {
        if (this.f2817fe != null) {
            return true;
        }
        File yj2 = yj();
        if (!yj2.exists()) {
            return false;
        }
        try {
            this.f2817fe = new ZipFile(yj2);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x009b, code lost:
        fe.fe.pf.yj.fe.de.de.ad(r3);
        fe.fe.pf.yj.fe.de.de.ad(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a1, code lost:
        if (r4 != null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r4.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a6, code lost:
        return 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v8 java.io.InputStream) = (r3v0 java.io.InputStream), (r3v9 java.io.InputStream), (r3v9 java.io.InputStream), (r3v9 java.io.InputStream), (r3v9 java.io.InputStream), (r3v9 java.io.InputStream) binds: [B:8:0x002d, B:9:?, B:11:0x0037, B:13:0x003b, B:14:?, B:22:0x004a] A[DONT_GENERATE, DONT_INLINE], Splitter:B:8:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00c3 A[SYNTHETIC, Splitter:B:72:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00d2 A[SYNTHETIC, Splitter:B:80:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00e1 A[SYNTHETIC, Splitter:B:88:0x00e1] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00f0 A[SYNTHETIC, Splitter:B:96:0x00f0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int qw() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f2815ad     // Catch:{ Exception -> 0x00f4 }
            java.lang.String r1 = r14.qw     // Catch:{ Exception -> 0x00f4 }
            r2 = 0
            android.content.Context r0 = r0.createPackageContext(r1, r2)     // Catch:{ Exception -> 0x00f4 }
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ Exception -> 0x00f4 }
            fe.fe.pf.yj.rg.qw$qw r1 = r14.f2816de
            r1.qw()
            java.io.File r1 = r14.yj()
            r3 = 0
            r1.delete()     // Catch:{ FileNotFoundException -> 0x00e5, IOException -> 0x00d6, Exception -> 0x00c7, all -> 0x00b8 }
            java.lang.String r4 = "cfg"
            java.lang.String r5 = ".cfgtmp"
            java.io.File r6 = r1.getParentFile()     // Catch:{ FileNotFoundException -> 0x00e5, IOException -> 0x00d6, Exception -> 0x00c7, all -> 0x00b8 }
            java.io.File r4 = java.io.File.createTempFile(r4, r5, r6)     // Catch:{ FileNotFoundException -> 0x00e5, IOException -> 0x00d6, Exception -> 0x00c7, all -> 0x00b8 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00b4, Exception -> 0x00b2, all -> 0x00af }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00b6, IOException -> 0x00b4, Exception -> 0x00b2, all -> 0x00af }
            java.lang.String r6 = "com.baidu.helios/c.dat"
            java.io.InputStream r3 = r0.open(r6)     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            r0 = 16384(0x4000, float:2.2959E-41)
            fe.fe.pf.yj.fe.de.fe.qw(r3, r5, r0)     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            r0 = 3
            java.security.cert.X509Certificate[][] r6 = com.baidu.helios.trusts.zone.verifier.ZipSignatureSchemeV2Verifier.aaa(r4)     // Catch:{ Exception -> 0x009b, all -> 0x00a7 }
            int r7 = r6.length     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            if (r7 != 0) goto L_0x004a
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r5)
            if (r4 == 0) goto L_0x0049
            r4.delete()     // Catch:{ Exception -> 0x0049 }
        L_0x0049:
            return r0
        L_0x004a:
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            int r8 = r6.length     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            r9 = 0
        L_0x0051:
            if (r9 >= r8) goto L_0x0070
            r10 = r6[r9]     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            if (r10 == 0) goto L_0x006d
            int r11 = r10.length     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            r12 = 0
        L_0x0059:
            if (r12 >= r11) goto L_0x006d
            r13 = r10[r12]     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            if (r13 == 0) goto L_0x006a
            byte[] r13 = r13.getSignature()     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            java.lang.String r13 = fe.fe.pf.yj.fe.de.th.de(r13)     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            r7.add(r13)     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
        L_0x006a:
            int r12 = r12 + 1
            goto L_0x0059
        L_0x006d:
            int r9 = r9 + 1
            goto L_0x0051
        L_0x0070:
            java.util.HashSet r6 = new java.util.HashSet     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            java.lang.String[] r8 = f2814th     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            java.util.Collections.addAll(r6, r8)     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            boolean r6 = r6.equals(r7)     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            if (r6 == 0) goto L_0x008f
            r4.renameTo(r1)     // Catch:{ FileNotFoundException -> 0x00ad, IOException -> 0x00ab, Exception -> 0x00a9, all -> 0x00a7 }
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r5)
            if (r4 == 0) goto L_0x008e
            r4.delete()     // Catch:{ Exception -> 0x008e }
        L_0x008e:
            return r2
        L_0x008f:
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r5)
            if (r4 == 0) goto L_0x009a
            r4.delete()     // Catch:{ Exception -> 0x009a }
        L_0x009a:
            return r0
        L_0x009b:
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r5)
            if (r4 == 0) goto L_0x00a6
            r4.delete()     // Catch:{ Exception -> 0x00a6 }
        L_0x00a6:
            return r0
        L_0x00a7:
            r0 = move-exception
            goto L_0x00bb
        L_0x00a9:
            goto L_0x00c9
        L_0x00ab:
            goto L_0x00d8
        L_0x00ad:
            goto L_0x00e7
        L_0x00af:
            r0 = move-exception
            r5 = r3
            goto L_0x00bb
        L_0x00b2:
            r5 = r3
            goto L_0x00c9
        L_0x00b4:
            r5 = r3
            goto L_0x00d8
        L_0x00b6:
            r5 = r3
            goto L_0x00e7
        L_0x00b8:
            r0 = move-exception
            r4 = r3
            r5 = r4
        L_0x00bb:
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r5)
            if (r4 == 0) goto L_0x00c6
            r4.delete()     // Catch:{ Exception -> 0x00c6 }
        L_0x00c6:
            throw r0
        L_0x00c7:
            r4 = r3
            r5 = r4
        L_0x00c9:
            r0 = 4
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r5)
            if (r4 == 0) goto L_0x00d5
            r4.delete()     // Catch:{ Exception -> 0x00d5 }
        L_0x00d5:
            return r0
        L_0x00d6:
            r4 = r3
            r5 = r4
        L_0x00d8:
            r0 = 2
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r5)
            if (r4 == 0) goto L_0x00e4
            r4.delete()     // Catch:{ Exception -> 0x00e4 }
        L_0x00e4:
            return r0
        L_0x00e5:
            r4 = r3
            r5 = r4
        L_0x00e7:
            r0 = 5
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r5)
            if (r4 == 0) goto L_0x00f3
            r4.delete()     // Catch:{ Exception -> 0x00f3 }
        L_0x00f3:
            return r0
        L_0x00f4:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.pf.qw.ad.qw.qw():int");
    }

    public boolean rg() {
        return yj().delete();
    }

    public String th(String str) throws TrustSubject.ConfigNotFoundException {
        try {
            InputStream uk2 = uk(str);
            String ad2 = fe.ad(uk2, "UTF-8");
            de.ad(uk2);
            return ad2;
        } catch (IOException e) {
            throw new TrustSubject.ConfigNotFoundException((Throwable) e);
        } catch (Throwable th2) {
            de.ad((Closeable) null);
            throw th2;
        }
    }

    public final InputStream uk(String str) throws TrustSubject.ConfigNotFoundException {
        try {
            return this.f2817fe.getInputStream(new ZipEntry(str));
        } catch (Exception e) {
            throw new TrustSubject.ConfigNotFoundException((Throwable) e);
        }
    }

    public final File yj() {
        return this.f2816de.fe("c.dat");
    }
}
