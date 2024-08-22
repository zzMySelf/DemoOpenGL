package fe.uk.qw.i;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.google.common.base.Ascii;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.cache.DiskLruCache;
import org.apache.commons.lang3.StringUtils;

public final class qw implements Closeable {

    /* renamed from: ad  reason: collision with root package name */
    public final File f5622ad;
    public long ggg = 0;

    /* renamed from: i  reason: collision with root package name */
    public final int f5623i;

    /* renamed from: if  reason: not valid java name */
    public long f228if = 0;

    /* renamed from: o  reason: collision with root package name */
    public long f5624o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f5625pf;
    public int ppp;

    /* renamed from: switch  reason: not valid java name */
    public Writer f229switch;

    /* renamed from: th  reason: collision with root package name */
    public final File f5626th;

    /* renamed from: uk  reason: collision with root package name */
    public final File f5627uk;
    public final ThreadPoolExecutor vvv = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ad((C0230qw) null));
    public final LinkedHashMap<String, fe> when = new LinkedHashMap<>(0, 0.75f, true);
    public final Callable<Void> xxx = new C0230qw();

    /* renamed from: yj  reason: collision with root package name */
    public final File f5628yj;

    public static final class ad implements ThreadFactory {
        public ad() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ ad(C0230qw qwVar) {
            this();
        }
    }

    public final class de {

        /* renamed from: ad  reason: collision with root package name */
        public final boolean[] f5629ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f5630de;
        public final fe qw;

        public /* synthetic */ de(qw qwVar, fe feVar, C0230qw qwVar2) {
            this(feVar);
        }

        public void ad() {
            if (!this.f5630de) {
                try {
                    qw();
                } catch (IOException unused) {
                }
            }
        }

        public void qw() throws IOException {
            qw.this.ppp(this, false);
        }

        public void rg() throws IOException {
            qw.this.ppp(this, true);
            this.f5630de = true;
        }

        public File th(int i2) throws IOException {
            File pf2;
            synchronized (qw.this) {
                if (this.qw.f5636th == this) {
                    if (!this.qw.f5635rg) {
                        this.f5629ad[i2] = true;
                    }
                    pf2 = this.qw.pf(i2);
                    qw.this.f5622ad.mkdirs();
                } else {
                    throw new IllegalStateException();
                }
            }
            return pf2;
        }

        public de(fe feVar) {
            this.qw = feVar;
            this.f5629ad = feVar.f5635rg ? null : new boolean[qw.this.f5625pf];
        }
    }

    public final class fe {

        /* renamed from: ad  reason: collision with root package name */
        public final long[] f5632ad;

        /* renamed from: de  reason: collision with root package name */
        public File[] f5633de;

        /* renamed from: fe  reason: collision with root package name */
        public File[] f5634fe;
        public final String qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f5635rg;

        /* renamed from: th  reason: collision with root package name */
        public de f5636th;

        /* renamed from: yj  reason: collision with root package name */
        public long f5638yj;

        public /* synthetic */ fe(qw qwVar, String str, C0230qw qwVar2) {
            this(str);
        }

        /* renamed from: if  reason: not valid java name */
        public String m367if() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f5632ad) {
                sb.append(Ascii.CASE_MASK);
                sb.append(append);
            }
            return sb.toString();
        }

        public File o(int i2) {
            return this.f5633de[i2];
        }

        public File pf(int i2) {
            return this.f5634fe[i2];
        }

        /* renamed from: switch  reason: not valid java name */
        public final IOException m368switch(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void when(String[] strArr) throws IOException {
            if (strArr.length == qw.this.f5625pf) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f5632ad[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        m368switch(strArr);
                        throw null;
                    }
                }
                return;
            }
            m368switch(strArr);
            throw null;
        }

        public fe(String str) {
            this.qw = str;
            this.f5632ad = new long[qw.this.f5625pf];
            this.f5633de = new File[qw.this.f5625pf];
            this.f5634fe = new File[qw.this.f5625pf];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < qw.this.f5625pf; i2++) {
                sb.append(i2);
                this.f5633de[i2] = new File(qw.this.f5622ad, sb.toString());
                sb.append(".tmp");
                this.f5634fe[i2] = new File(qw.this.f5622ad, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* renamed from: fe.uk.qw.i.qw$qw  reason: collision with other inner class name */
    public class C0230qw implements Callable<Void> {
        public C0230qw() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: qw */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                fe.uk.qw.i.qw r0 = fe.uk.qw.i.qw.this
                monitor-enter(r0)
                fe.uk.qw.i.qw r1 = fe.uk.qw.i.qw.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f229switch     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                fe.uk.qw.i.qw r1 = fe.uk.qw.i.qw.this     // Catch:{ all -> 0x0028 }
                r1.d()     // Catch:{ all -> 0x0028 }
                fe.uk.qw.i.qw r1 = fe.uk.qw.i.qw.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.aaa()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                fe.uk.qw.i.qw r1 = fe.uk.qw.i.qw.this     // Catch:{ all -> 0x0028 }
                r1.a()     // Catch:{ all -> 0x0028 }
                fe.uk.qw.i.qw r1 = fe.uk.qw.i.qw.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.ppp = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.i.qw.C0230qw.call():java.lang.Void");
        }
    }

    public final class rg {
        public final File[] qw;

        public /* synthetic */ rg(qw qwVar, String str, long j, File[] fileArr, long[] jArr, C0230qw qwVar2) {
            this(str, j, fileArr, jArr);
        }

        public File qw(int i2) {
            return this.qw[i2];
        }

        public rg(String str, long j, File[] fileArr, long[] jArr) {
            this.qw = fileArr;
        }
    }

    public qw(File file, int i2, int i3, long j) {
        File file2 = file;
        this.f5622ad = file2;
        this.f5623i = i2;
        this.f5626th = new File(file2, DiskLruCache.JOURNAL_FILE);
        this.f5628yj = new File(file2, DiskLruCache.JOURNAL_FILE_TEMP);
        this.f5627uk = new File(file2, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.f5625pf = i3;
        this.f5624o = j;
    }

    public static void c(File file, File file2, boolean z) throws IOException {
        if (z) {
            vvv(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void nn(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static qw qqq(File file, int i2, int i3, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    c(file2, file3, false);
                }
            }
            qw qwVar = new qw(file, i2, i3, j);
            if (qwVar.f5626th.exists()) {
                try {
                    qwVar.rrr();
                    qwVar.eee();
                    return qwVar;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    qwVar.ggg();
                }
            }
            file.mkdirs();
            qw qwVar2 = new qw(file, i2, i3, j);
            qwVar2.a();
            return qwVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public static void vvv(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void when(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void a() throws IOException {
        if (this.f229switch != null) {
            when(this.f229switch);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5628yj), de.qw));
        try {
            bufferedWriter.write(DiskLruCache.MAGIC);
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.f5623i));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.f5625pf));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(StringUtils.LF);
            for (fe next : this.when.values()) {
                if (next.f5636th != null) {
                    bufferedWriter.write("DIRTY " + next.qw + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.qw + next.m367if() + 10);
                }
            }
            when(bufferedWriter);
            if (this.f5626th.exists()) {
                c(this.f5626th, this.f5627uk, true);
            }
            c(this.f5628yj, this.f5626th, false);
            this.f5627uk.delete();
            this.f229switch = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5626th, true), de.qw));
        } catch (Throwable th2) {
            when(bufferedWriter);
            throw th2;
        }
    }

    public final boolean aaa() {
        int i2 = this.ppp;
        return i2 >= 2000 && i2 >= this.when.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.m366switch()     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, fe.uk.qw.i.qw$fe> r0 = r7.when     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            fe.uk.qw.i.qw$fe r0 = (fe.uk.qw.i.qw.fe) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            fe.uk.qw.i.qw$de r2 = r0.f5636th     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0017
            goto L_0x008d
        L_0x0017:
            int r2 = r7.f5625pf     // Catch:{ all -> 0x008f }
            if (r1 >= r2) goto L_0x0059
            java.io.File r2 = r0.o(r1)     // Catch:{ all -> 0x008f }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0043
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r8.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r8     // Catch:{ all -> 0x008f }
        L_0x0043:
            long r2 = r7.f228if     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f5632ad     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            long r2 = r2 - r5
            r7.f228if = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f5632ad     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0059:
            int r0 = r7.ppp     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.ppp = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f229switch     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f229switch     // Catch:{ all -> 0x008f }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f229switch     // Catch:{ all -> 0x008f }
            r0.append(r8)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f229switch     // Catch:{ all -> 0x008f }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, fe.uk.qw.i.qw$fe> r0 = r7.when     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.aaa()     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008b
            java.util.concurrent.ThreadPoolExecutor r8 = r7.vvv     // Catch:{ all -> 0x008f }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.xxx     // Catch:{ all -> 0x008f }
            r8.submit(r0)     // Catch:{ all -> 0x008f }
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.i.qw.b(java.lang.String):boolean");
    }

    public synchronized void close() throws IOException {
        if (this.f229switch != null) {
            Iterator it = new ArrayList(this.when.values()).iterator();
            while (it.hasNext()) {
                fe feVar = (fe) it.next();
                if (feVar.f5636th != null) {
                    feVar.f5636th.qw();
                }
            }
            d();
            when(this.f229switch);
            this.f229switch = null;
        }
    }

    public final void d() throws IOException {
        while (this.f228if > this.f5624o) {
            b((String) this.when.entrySet().iterator().next().getKey());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized fe.uk.qw.i.qw.de ddd(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m366switch()     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, fe.uk.qw.i.qw$fe> r0 = r5.when     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            fe.uk.qw.i.qw$fe r0 = (fe.uk.qw.i.qw.fe) r0     // Catch:{ all -> 0x005d }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r1 = r0.f5638yj     // Catch:{ all -> 0x005d }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r3
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            fe.uk.qw.i.qw$fe r0 = new fe.uk.qw.i.qw$fe     // Catch:{ all -> 0x005d }
            r0.<init>(r5, r6, r3)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, fe.uk.qw.i.qw$fe> r7 = r5.when     // Catch:{ all -> 0x005d }
            r7.put(r6, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0034
        L_0x002c:
            fe.uk.qw.i.qw$de r7 = r0.f5636th     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r3
        L_0x0034:
            fe.uk.qw.i.qw$de r7 = new fe.uk.qw.i.qw$de     // Catch:{ all -> 0x005d }
            r7.<init>(r5, r0, r3)     // Catch:{ all -> 0x005d }
            fe.uk.qw.i.qw.de unused = r0.f5636th = r7     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f229switch     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f229switch     // Catch:{ all -> 0x005d }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f229switch     // Catch:{ all -> 0x005d }
            r8.append(r6)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f229switch     // Catch:{ all -> 0x005d }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f229switch     // Catch:{ all -> 0x005d }
            nn(r6)     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r7
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.i.qw.ddd(java.lang.String, long):fe.uk.qw.i.qw$de");
    }

    public final void eee() throws IOException {
        vvv(this.f5628yj);
        Iterator<fe> it = this.when.values().iterator();
        while (it.hasNext()) {
            fe next = it.next();
            int i2 = 0;
            if (next.f5636th == null) {
                while (i2 < this.f5625pf) {
                    this.f228if += next.f5632ad[i2];
                    i2++;
                }
            } else {
                de unused = next.f5636th = null;
                while (i2 < this.f5625pf) {
                    vvv(next.o(i2));
                    vvv(next.pf(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public void ggg() throws IOException {
        close();
        de.ad(this.f5622ad);
    }

    public synchronized rg mmm(String str) throws IOException {
        m366switch();
        fe feVar = this.when.get(str);
        if (feVar == null) {
            return null;
        }
        if (!feVar.f5635rg) {
            return null;
        }
        for (File exists : feVar.f5633de) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.ppp++;
        this.f229switch.append(DiskLruCache.READ);
        this.f229switch.append(Ascii.CASE_MASK);
        this.f229switch.append(str);
        this.f229switch.append(10);
        if (aaa()) {
            this.vvv.submit(this.xxx);
        }
        return new rg(this, str, feVar.f5638yj, feVar.f5633de, feVar.f5632ad, (C0230qw) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void ppp(fe.uk.qw.i.qw.de r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            fe.uk.qw.i.qw$fe r0 = r10.qw     // Catch:{ all -> 0x010e }
            fe.uk.qw.i.qw$de r1 = r0.f5636th     // Catch:{ all -> 0x010e }
            if (r1 != r10) goto L_0x0108
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f5635rg     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.f5625pf     // Catch:{ all -> 0x010e }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f5629ad     // Catch:{ all -> 0x010e }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.pf(r2)     // Catch:{ all -> 0x010e }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x010e }
            if (r3 != 0) goto L_0x0030
            r10.qw()     // Catch:{ all -> 0x010e }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.qw()     // Catch:{ all -> 0x010e }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r11.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x010e }
            r11.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010e }
            r10.<init>(r11)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x004d:
            int r10 = r9.f5625pf     // Catch:{ all -> 0x010e }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.pf(r1)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.o(r1)     // Catch:{ all -> 0x010e }
            r10.renameTo(r2)     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f5632ad     // Catch:{ all -> 0x010e }
            r3 = r10[r1]     // Catch:{ all -> 0x010e }
            long r5 = r2.length()     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f5632ad     // Catch:{ all -> 0x010e }
            r10[r1] = r5     // Catch:{ all -> 0x010e }
            long r7 = r9.f228if     // Catch:{ all -> 0x010e }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f228if = r7     // Catch:{ all -> 0x010e }
            goto L_0x007e
        L_0x007b:
            vvv(r10)     // Catch:{ all -> 0x010e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.ppp     // Catch:{ all -> 0x010e }
            r1 = 1
            int r10 = r10 + r1
            r9.ppp = r10     // Catch:{ all -> 0x010e }
            r10 = 0
            fe.uk.qw.i.qw.de unused = r0.f5636th = r10     // Catch:{ all -> 0x010e }
            boolean r10 = r0.f5635rg     // Catch:{ all -> 0x010e }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00c9
            boolean unused = r0.f5635rg = r1     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.qw     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.m367if()     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00ec
            long r10 = r9.ggg     // Catch:{ all -> 0x010e }
            r1 = 1
            long r1 = r1 + r10
            r9.ggg = r1     // Catch:{ all -> 0x010e }
            long unused = r0.f5638yj = r10     // Catch:{ all -> 0x010e }
            goto L_0x00ec
        L_0x00c9:
            java.util.LinkedHashMap<java.lang.String, fe.uk.qw.i.qw$fe> r10 = r9.when     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.qw     // Catch:{ all -> 0x010e }
            r10.remove(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.qw     // Catch:{ all -> 0x010e }
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
        L_0x00ec:
            java.io.Writer r10 = r9.f229switch     // Catch:{ all -> 0x010e }
            nn(r10)     // Catch:{ all -> 0x010e }
            long r10 = r9.f228if     // Catch:{ all -> 0x010e }
            long r0 = r9.f5624o     // Catch:{ all -> 0x010e }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ff
            boolean r10 = r9.aaa()     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x0106
        L_0x00ff:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.vvv     // Catch:{ all -> 0x010e }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.xxx     // Catch:{ all -> 0x010e }
            r10.submit(r11)     // Catch:{ all -> 0x010e }
        L_0x0106:
            monitor-exit(r9)
            return
        L_0x0108:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            r10.<init>()     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x010e:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.i.qw.ppp(fe.uk.qw.i.qw$de, boolean):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.ppp = r0 - r9.when.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.fe() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f229switch = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f5626th, true), fe.uk.qw.i.de.qw));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void rrr() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            fe.uk.qw.i.ad r1 = new fe.uk.qw.i.ad
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f5626th
            r2.<init>(r3)
            java.nio.charset.Charset r3 = fe.uk.qw.i.de.qw
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.rg()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.rg()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.rg()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.rg()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.rg()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f5623i     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f5625pf     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.rg()     // Catch:{ EOFException -> 0x005f }
            r9.tt(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, fe.uk.qw.i.qw$fe> r2 = r9.when     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.ppp = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.fe()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.a()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f5626th     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = fe.uk.qw.i.de.qw     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f229switch = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            fe.uk.qw.i.de.qw(r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            fe.uk.qw.i.de.qw(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.i.qw.rrr():void");
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m366switch() {
        if (this.f229switch == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final void tt(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith(DiskLruCache.REMOVE)) {
                    this.when.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            fe feVar = this.when.get(str2);
            if (feVar == null) {
                feVar = new fe(this, str2, (C0230qw) null);
                this.when.put(str2, feVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(DiskLruCache.CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = feVar.f5635rg = true;
                de unused2 = feVar.f5636th = null;
                feVar.when(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DiskLruCache.DIRTY)) {
                de unused3 = feVar.f5636th = new de(this, feVar, (C0230qw) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(DiskLruCache.READ)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public de xxx(String str) throws IOException {
        return ddd(str, -1);
    }
}
