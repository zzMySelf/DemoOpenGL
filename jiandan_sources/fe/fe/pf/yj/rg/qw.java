package fe.fe.pf.yj.rg;

import android.content.Context;
import fe.fe.pf.yj.de.ad;
import fe.fe.pf.yj.fe.de.de;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class qw {

    /* renamed from: de  reason: collision with root package name */
    public static final boolean f2981de = (fe.fe.pf.yj.qw.qw & false);

    /* renamed from: ad  reason: collision with root package name */
    public C0142qw f2982ad;
    public Context qw;

    public qw(Context context) {
        this.qw = context;
        de().mkdirs();
    }

    public static void qw(File file) {
        file.mkdirs();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|18|24|25|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        r1 = r3;
        r3 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0047 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String rg(java.io.File r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            qw(r3)
            java.io.File r0 = new java.io.File
            r0.<init>(r3, r4)
            r3 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0046, all -> 0x0041 }
            r4.<init>()     // Catch:{ Exception -> 0x0046, all -> 0x0041 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0047 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0047 }
            r3 = 8192(0x2000, float:1.14794E-41)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x003f, all -> 0x003d }
        L_0x0017:
            int r0 = r1.read(r3)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            if (r0 <= 0) goto L_0x0022
            r2 = 0
            r4.write(r3, r2, r0)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            goto L_0x0017
        L_0x0022:
            byte[] r3 = r4.toByteArray()     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            if (r6 == 0) goto L_0x0031
            fe.fe.pf.yj.de.ad r6 = new fe.fe.pf.yj.de.ad     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r6.<init>()     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            byte[] r3 = r6.qw(r3)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
        L_0x0031:
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            r6.<init>(r3, r5)     // Catch:{ Exception -> 0x003f, all -> 0x003d }
            fe.fe.pf.yj.fe.de.de.ad(r1)
            fe.fe.pf.yj.fe.de.de.ad(r4)
            return r6
        L_0x003d:
            r3 = move-exception
            goto L_0x0055
        L_0x003f:
            r3 = r1
            goto L_0x0047
        L_0x0041:
            r4 = move-exception
            r1 = r3
            r3 = r4
            r4 = r1
            goto L_0x0055
        L_0x0046:
            r4 = r3
        L_0x0047:
            boolean r5 = f2981de     // Catch:{ all -> 0x0052 }
            fe.fe.pf.yj.fe.de.de.ad(r3)
            fe.fe.pf.yj.fe.de.de.ad(r4)
            java.lang.String r3 = ""
            return r3
        L_0x0052:
            r5 = move-exception
            r1 = r3
            r3 = r5
        L_0x0055:
            fe.fe.pf.yj.fe.de.de.ad(r1)
            fe.fe.pf.yj.fe.de.de.ad(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.yj.rg.qw.rg(java.io.File, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean th(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th2;
        qw(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            if (z) {
                try {
                    fileOutputStream.write(new ad().ad(str2.getBytes(str3)));
                } catch (Exception unused) {
                    fileOutputStream2 = fileOutputStream;
                    de.ad(fileOutputStream2);
                    return false;
                } catch (Throwable th3) {
                    th2 = th3;
                    de.ad(fileOutputStream);
                    throw th2;
                }
            } else {
                fileOutputStream.write(str2.getBytes(str3));
            }
            de.ad(fileOutputStream);
            return true;
        } catch (Exception unused2) {
            de.ad(fileOutputStream2);
            return false;
        } catch (Throwable th4) {
            Throwable th5 = th4;
            fileOutputStream = null;
            th2 = th5;
            de.ad(fileOutputStream);
            throw th2;
        }
    }

    public File ad() {
        return new File(this.qw.getApplicationInfo().dataDir);
    }

    public final File de() {
        return new File(ad(), ".helios");
    }

    public synchronized C0142qw fe() {
        if (this.f2982ad == null) {
            this.f2982ad = new C0142qw(".helios", (C0142qw) null);
        }
        return this.f2982ad;
    }

    /* renamed from: fe.fe.pf.yj.rg.qw$qw  reason: collision with other inner class name */
    public final class C0142qw {

        /* renamed from: ad  reason: collision with root package name */
        public String f2983ad;

        /* renamed from: de  reason: collision with root package name */
        public C0142qw f2984de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f2985fe;
        public File qw;

        public C0142qw(String str, C0142qw qwVar) {
            this.f2985fe = false;
            this.f2983ad = str;
            this.f2984de = qwVar;
            this.f2985fe = false;
        }

        public File ad() {
            File file;
            File file2 = this.qw;
            if (file2 != null) {
                return file2;
            }
            if (this.f2984de == null) {
                file = new File(qw.this.ad(), this.f2983ad);
            } else {
                file = new File(this.f2984de.ad(), this.f2983ad);
            }
            this.qw = file;
            return file;
        }

        public String de() {
            return this.f2983ad;
        }

        public File fe(String str) {
            return new File(this.qw, str);
        }

        public boolean i(String str, String str2, boolean z) {
            return qw.th(ad(), str, str2, "UTF-8", z);
        }

        public void qw() {
            ad().mkdirs();
        }

        public C0142qw rg() {
            return this.f2984de;
        }

        public C0142qw th(String str) {
            return new C0142qw(str, this);
        }

        public C0142qw uk(File file) {
            if (!this.f2985fe) {
                ArrayList arrayList = new ArrayList();
                C0142qw qwVar = this;
                do {
                    arrayList.add(qwVar.de());
                    qwVar = qwVar.rg();
                } while (qwVar != null);
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    size--;
                    file = new File(file, (String) arrayList.get(size));
                }
                return new C0142qw(file);
            }
            throw new IllegalStateException("isolate session is not support");
        }

        public String yj(String str, boolean z) {
            return qw.rg(ad(), str, "UTF-8", z);
        }

        public C0142qw(File file) {
            this.f2985fe = false;
            this.f2985fe = true;
            this.qw = file;
            this.f2983ad = file.getName();
        }
    }
}
