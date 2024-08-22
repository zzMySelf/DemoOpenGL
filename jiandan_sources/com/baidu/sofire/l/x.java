package com.baidu.sofire.l;

import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class x {

    /* renamed from: i  reason: collision with root package name */
    public static x f1095i = null;
    public static String j = "";
    public static Object k = new Object();
    public Context a;
    public FileLock b;
    public FileOutputStream c = null;
    public File d;
    public File e;
    public File f;
    public File g;
    public a h = null;

    public class a extends FileObserver {
        public Context a;

        /* renamed from: com.baidu.sofire.l.x$a$a  reason: collision with other inner class name */
        public class C0055a implements Runnable {
            public C0055a() {
            }

            public void run() {
                try {
                    synchronized (x.class) {
                        x xVar = x.this;
                        x xVar2 = x.f1095i;
                        xVar.b(true);
                        String a2 = x.a(x.this.e);
                        x.this.b();
                        if (!TextUtils.isEmpty(a2)) {
                            x.j = a2;
                        }
                    }
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.a.a;
                }
            }
        }

        public a(Context context, String str) {
            super(str, 2);
            this.a = context;
        }

        public void onEvent(int i2, @Nullable String str) {
            try {
                w.a(this.a).a((Runnable) new C0055a());
            } catch (Throwable unused) {
                int i3 = com.baidu.sofire.a.a.a;
            }
        }
    }

    public x(Context context) {
        this.a = context;
        try {
            this.d = new File(new File(new File(c.f(context), "sofire_tmp"), ".tmp"), ".tfd");
            this.e = new File(this.d, "ztf");
            this.f = new File(this.d, "zuf");
            this.g = new File(this.d, "zcf");
            if (!this.d.exists()) {
                this.d.mkdirs();
            }
        } catch (Throwable th2) {
            c.a(th2);
        }
    }

    public static synchronized x a(Context context) {
        x xVar;
        synchronized (x.class) {
            if (f1095i == null) {
                f1095i = new x(context);
            }
            xVar = f1095i;
        }
        return xVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(boolean r5) {
        /*
            r4 = this;
            java.lang.Object r0 = k
            monitor-enter(r0)
            java.io.File r1 = r4.d     // Catch:{ all -> 0x004f }
            r2 = 0
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return r2
        L_0x000a:
            boolean r1 = r1.exists()     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x0015
            java.io.File r1 = r4.d     // Catch:{ all -> 0x004f }
            r1.mkdirs()     // Catch:{ all -> 0x004f }
        L_0x0015:
            java.io.File r1 = r4.e     // Catch:{ all -> 0x004f }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x0025
            java.io.File r1 = r4.e     // Catch:{ all -> 0x0023 }
            r1.createNewFile()     // Catch:{ all -> 0x0023 }
            goto L_0x0025
        L_0x0023:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x004f }
        L_0x0025:
            java.io.File r1 = r4.e     // Catch:{ all -> 0x004f }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x002f
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return r2
        L_0x002f:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x004b }
            java.io.File r3 = r4.e     // Catch:{ all -> 0x004b }
            r1.<init>(r3, r5)     // Catch:{ all -> 0x004b }
            r4.c = r1     // Catch:{ all -> 0x004b }
            java.nio.channels.FileChannel r5 = r1.getChannel()     // Catch:{ all -> 0x004b }
            java.nio.channels.FileLock r5 = r5.lock()     // Catch:{ all -> 0x004b }
            r4.b = r5     // Catch:{ all -> 0x004b }
            boolean r5 = r5.isValid()     // Catch:{ all -> 0x004b }
            if (r5 == 0) goto L_0x004d
            r5 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return r5
        L_0x004b:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x004f }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            return r2
        L_0x004f:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004f }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.x.b(boolean):boolean");
    }

    public synchronized void a(String str, boolean z) {
        synchronized (k) {
            if (b(true)) {
                if (this.c != null) {
                    a(str, z ? this.g : this.f, false);
                    b();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r8 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r8 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0057 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.String, java.lang.String> a(boolean r8, boolean r9) {
        /*
            r7 = this;
            java.lang.Object r0 = k     // Catch:{ all -> 0x0066 }
            monitor-enter(r0)     // Catch:{ all -> 0x0066 }
            r1 = 1
            boolean r1 = r7.b(r1)     // Catch:{ all -> 0x0063 }
            if (r1 != 0) goto L_0x0015
            android.util.Pair r8 = new android.util.Pair     // Catch:{ all -> 0x0063 }
            java.lang.String r9 = ""
            java.lang.String r1 = ""
            r8.<init>(r9, r1)     // Catch:{ all -> 0x0063 }
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return r8
        L_0x0015:
            java.lang.String r1 = ""
            java.lang.String r2 = ""
            r3 = 0
            if (r8 == 0) goto L_0x003a
            java.io.File r8 = r7.g     // Catch:{ all -> 0x0038 }
            if (r8 == 0) goto L_0x003a
            boolean r8 = r8.exists()     // Catch:{ all -> 0x0038 }
            if (r8 == 0) goto L_0x003a
            java.io.File r8 = r7.g     // Catch:{ all -> 0x0038 }
            long r5 = r8.length()     // Catch:{ all -> 0x0038 }
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x003a
            java.io.File r8 = r7.g     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = a((java.io.File) r8)     // Catch:{ all -> 0x0038 }
            goto L_0x003a
        L_0x0038:
            int r8 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0063 }
        L_0x003a:
            if (r9 == 0) goto L_0x0059
            java.io.File r8 = r7.f     // Catch:{ all -> 0x0057 }
            if (r8 == 0) goto L_0x0059
            boolean r8 = r8.exists()     // Catch:{ all -> 0x0057 }
            if (r8 == 0) goto L_0x0059
            java.io.File r8 = r7.f     // Catch:{ all -> 0x0057 }
            long r8 = r8.length()     // Catch:{ all -> 0x0057 }
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0059
            java.io.File r8 = r7.f     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = a((java.io.File) r8)     // Catch:{ all -> 0x0057 }
            goto L_0x0059
        L_0x0057:
            int r8 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0063 }
        L_0x0059:
            r7.b()     // Catch:{ all -> 0x0063 }
            android.util.Pair r8 = new android.util.Pair     // Catch:{ all -> 0x0063 }
            r8.<init>(r1, r2)     // Catch:{ all -> 0x0063 }
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return r8
        L_0x0063:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r8     // Catch:{ all -> 0x0066 }
        L_0x0066:
            int r8 = com.baidu.sofire.a.a.a
            android.util.Pair r8 = new android.util.Pair
            java.lang.String r9 = ""
            java.lang.String r0 = ""
            r8.<init>(r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.x.a(boolean, boolean):android.util.Pair");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r1 = r3.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
        if (r1 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0020, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r1 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r2 = r3.c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0032, code lost:
        if (r2 != null) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0034, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r2 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0024 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0038 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:25:0x0030=Splitter:B:25:0x0030, B:18:0x0024=Splitter:B:18:0x0024} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r3 = this;
            java.lang.Object r0 = k
            monitor-enter(r0)
            java.nio.channels.FileLock r1 = r3.b     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.isValid()     // Catch:{ all -> 0x001a }
            if (r1 == 0) goto L_0x0012
            java.nio.channels.FileLock r1 = r3.b     // Catch:{ all -> 0x001a }
            r1.release()     // Catch:{ all -> 0x001a }
        L_0x0012:
            java.io.FileOutputStream r1 = r3.c     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0026
            r1.close()     // Catch:{ all -> 0x0024 }
            goto L_0x0026
        L_0x001a:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002f }
            java.io.FileOutputStream r1 = r3.c     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0026
            r1.close()     // Catch:{ all -> 0x0024 }
            goto L_0x0026
        L_0x0024:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002d }
        L_0x0026:
            r1 = 0
            r3.b = r1     // Catch:{ all -> 0x002d }
            r3.c = r1     // Catch:{ all -> 0x002d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r1 = move-exception
            goto L_0x003b
        L_0x002f:
            r1 = move-exception
            java.io.FileOutputStream r2 = r3.c     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x003a
            r2.close()     // Catch:{ all -> 0x0038 }
            goto L_0x003a
        L_0x0038:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002d }
        L_0x003a:
            throw r1     // Catch:{ all -> 0x002d }
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.x.b():void");
    }

    public String a(boolean z) {
        File file;
        synchronized (k) {
            if (!TextUtils.isEmpty(j)) {
                String str = j;
                return str;
            } else if (!b(true)) {
                return "";
            } else {
                String str2 = "";
                File file2 = this.e;
                if (file2 != null && file2.exists() && this.e.length() > 0) {
                    str2 = a(this.e);
                }
                if (!TextUtils.isEmpty(str2)) {
                    b();
                    j = str2;
                    a();
                    String str3 = j;
                    return str3;
                }
                String str4 = "";
                File file3 = this.g;
                if (file3 != null && file3.exists() && this.g.length() > 0) {
                    str4 = a(this.g);
                    if (!TextUtils.isEmpty(str4)) {
                        b();
                        j = a(str4);
                        a();
                        String str5 = j;
                        return str5;
                    }
                }
                if (TextUtils.isEmpty(str4) && (file = this.f) != null && file.exists() && this.f.length() > 0) {
                    String a2 = a(this.f);
                    if (!TextUtils.isEmpty(a2)) {
                        b();
                        String a3 = a(a2);
                        return a3;
                    }
                }
                if (z) {
                    String a4 = e.a();
                    if (TextUtils.isEmpty(a4)) {
                        b();
                        return "";
                    }
                    boolean a5 = a(a4, this.f, false);
                    b();
                    if (!a5) {
                        return "";
                    }
                    String a6 = a(a4);
                    return a6;
                }
                b();
                return "";
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|18|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:27|28|29|30) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0041 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x004b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0058 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x0058=Splitter:B:38:0x0058, B:29:0x004b=Splitter:B:29:0x004b, B:19:0x003d=Splitter:B:19:0x003d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r5, java.io.File r6, boolean r7) {
        /*
            r4 = this;
            java.lang.Object r0 = k
            monitor-enter(r0)
            java.io.File r1 = r4.d     // Catch:{ all -> 0x005b }
            r2 = 0
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r2
        L_0x000a:
            boolean r1 = r1.exists()     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x0015
            java.io.File r1 = r4.d     // Catch:{ all -> 0x005b }
            r1.mkdirs()     // Catch:{ all -> 0x005b }
        L_0x0015:
            r1 = 0
            if (r7 == 0) goto L_0x001c
            java.io.FileOutputStream r6 = r4.c     // Catch:{ all -> 0x0041 }
            r1 = r6
            goto L_0x0022
        L_0x001c:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0041 }
            r3.<init>(r6)     // Catch:{ all -> 0x0041 }
            r1 = r3
        L_0x0022:
            r6 = 16
            byte[] r6 = com.baidu.sofire.l.g.a(r6)     // Catch:{ all -> 0x0041 }
            byte[] r5 = r5.getBytes()     // Catch:{ all -> 0x0041 }
            r3 = 1
            byte[] r5 = com.baidu.sofire.l.g.b(r6, r5, r3)     // Catch:{ all -> 0x0041 }
            r1.write(r5)     // Catch:{ all -> 0x0041 }
            r1.flush()     // Catch:{ all -> 0x0041 }
            if (r7 != 0) goto L_0x003f
            r1.close()     // Catch:{ all -> 0x003d }
            goto L_0x003f
        L_0x003d:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x005b }
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r3
        L_0x0041:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x004f }
            if (r1 == 0) goto L_0x004d
            if (r7 != 0) goto L_0x004d
            r1.close()     // Catch:{ all -> 0x004b }
            goto L_0x004d
        L_0x004b:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x005b }
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r2
        L_0x004f:
            r5 = move-exception
            if (r1 == 0) goto L_0x005a
            if (r7 != 0) goto L_0x005a
            r1.close()     // Catch:{ all -> 0x0058 }
            goto L_0x005a
        L_0x0058:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x005b }
        L_0x005a:
            throw r5     // Catch:{ all -> 0x005b }
        L_0x005b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.x.a(java.lang.String, java.io.File, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f A[SYNTHETIC, Splitter:B:13:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r4) {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ all -> 0x002c }
            r0.<init>(r4)     // Catch:{ all -> 0x002c }
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r4]     // Catch:{ all -> 0x002a }
            r2 = 0
            int r4 = r0.read(r1, r2, r4)     // Catch:{ all -> 0x002a }
            byte[] r3 = new byte[r4]     // Catch:{ all -> 0x002a }
            java.lang.System.arraycopy(r1, r2, r3, r2, r4)     // Catch:{ all -> 0x002a }
            r4 = 16
            byte[] r4 = com.baidu.sofire.l.g.a(r4)     // Catch:{ all -> 0x002a }
            r1 = 1
            byte[] r4 = com.baidu.sofire.l.g.a(r4, r3, r1)     // Catch:{ all -> 0x002a }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x002a }
            r1.<init>(r4)     // Catch:{ all -> 0x002a }
            r0.close()     // Catch:{ all -> 0x0027 }
            goto L_0x0037
        L_0x0027:
            int r4 = com.baidu.sofire.a.a.a
            goto L_0x0037
        L_0x002a:
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ all -> 0x0033 }
            goto L_0x0035
        L_0x0033:
            int r4 = com.baidu.sofire.a.a.a
        L_0x0035:
            java.lang.String r1 = ""
        L_0x0037:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.x.a(java.io.File):java.lang.String");
    }

    public final void a() {
        File file = this.d;
        if (file != null && this.e != null) {
            try {
                if (!file.exists()) {
                    this.d.mkdirs();
                }
                if (!this.e.exists()) {
                    this.e.createNewFile();
                }
                if (this.h == null) {
                    a aVar = new a(this.a, this.e.getAbsolutePath());
                    this.h = aVar;
                    aVar.startWatching();
                }
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.a.a;
            }
        }
    }

    public static String a(String str) {
        String[] split;
        byte[] bArr;
        if (!TextUtils.isEmpty(str) && (split = str.split("\\|")) != null && split.length == 2) {
            if (!TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                StringBuilder sb = new StringBuilder();
                sb.append(split[0]);
                try {
                    bArr = new byte[1];
                    v.a.nextBytes(bArr);
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.a.a;
                    bArr = new byte[]{0};
                }
                String str2 = "";
                for (byte b2 : bArr) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        hexString = '0' + hexString;
                    }
                    str2 = str2 + hexString.toUpperCase();
                }
                sb.append(str2);
                return sb.toString();
            }
        }
        return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
    }
}
