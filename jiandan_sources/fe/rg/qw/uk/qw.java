package fe.rg.qw.uk;

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
    public final File f5054ad;
    public long ggg = 0;

    /* renamed from: i  reason: collision with root package name */
    public final int f5055i;

    /* renamed from: if  reason: not valid java name */
    public long f194if = 0;

    /* renamed from: o  reason: collision with root package name */
    public long f5056o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f5057pf;
    public int ppp;

    /* renamed from: switch  reason: not valid java name */
    public Writer f195switch;

    /* renamed from: th  reason: collision with root package name */
    public final File f5058th;

    /* renamed from: uk  reason: collision with root package name */
    public final File f5059uk;
    public final ThreadPoolExecutor vvv = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ad((C0216qw) null));
    public final LinkedHashMap<String, fe> when = new LinkedHashMap<>(0, 0.75f, true);
    public final Callable<Void> xxx = new C0216qw();

    /* renamed from: yj  reason: collision with root package name */
    public final File f5060yj;

    public static final class ad implements ThreadFactory {
        public ad() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ ad(C0216qw qwVar) {
            this();
        }
    }

    public final class de {

        /* renamed from: ad  reason: collision with root package name */
        public final boolean[] f5061ad;

        /* renamed from: de  reason: collision with root package name */
        public boolean f5062de;
        public final fe qw;

        public /* synthetic */ de(qw qwVar, fe feVar, C0216qw qwVar2) {
            this(feVar);
        }

        public void ad() {
            if (!this.f5062de) {
                try {
                    qw();
                } catch (IOException unused) {
                }
            }
        }

        public void qw() throws IOException {
            qw.this.when(this, false);
        }

        public void rg() throws IOException {
            qw.this.when(this, true);
            this.f5062de = true;
        }

        public File th(int i2) throws IOException {
            File pf2;
            synchronized (qw.this) {
                if (this.qw.f5068th == this) {
                    if (!this.qw.f5067rg) {
                        this.f5061ad[i2] = true;
                    }
                    pf2 = this.qw.pf(i2);
                    if (!qw.this.f5054ad.exists()) {
                        qw.this.f5054ad.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return pf2;
        }

        public de(fe feVar) {
            this.qw = feVar;
            this.f5061ad = feVar.f5067rg ? null : new boolean[qw.this.f5057pf];
        }
    }

    public final class fe {

        /* renamed from: ad  reason: collision with root package name */
        public final long[] f5064ad;

        /* renamed from: de  reason: collision with root package name */
        public File[] f5065de;

        /* renamed from: fe  reason: collision with root package name */
        public File[] f5066fe;
        public final String qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f5067rg;

        /* renamed from: th  reason: collision with root package name */
        public de f5068th;

        /* renamed from: yj  reason: collision with root package name */
        public long f5070yj;

        public /* synthetic */ fe(qw qwVar, String str, C0216qw qwVar2) {
            this(str);
        }

        /* renamed from: if  reason: not valid java name */
        public String m321if() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.f5064ad) {
                sb.append(Ascii.CASE_MASK);
                sb.append(append);
            }
            return sb.toString();
        }

        public File o(int i2) {
            return this.f5065de[i2];
        }

        public File pf(int i2) {
            return this.f5066fe[i2];
        }

        /* renamed from: switch  reason: not valid java name */
        public final IOException m322switch(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void when(String[] strArr) throws IOException {
            if (strArr.length == qw.this.f5057pf) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    try {
                        this.f5064ad[i2] = Long.parseLong(strArr[i2]);
                        i2++;
                    } catch (NumberFormatException unused) {
                        m322switch(strArr);
                        throw null;
                    }
                }
                return;
            }
            m322switch(strArr);
            throw null;
        }

        public fe(String str) {
            this.qw = str;
            this.f5064ad = new long[qw.this.f5057pf];
            this.f5065de = new File[qw.this.f5057pf];
            this.f5066fe = new File[qw.this.f5057pf];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < qw.this.f5057pf; i2++) {
                sb.append(i2);
                this.f5065de[i2] = new File(qw.this.f5054ad, sb.toString());
                sb.append(".tmp");
                this.f5066fe[i2] = new File(qw.this.f5054ad, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* renamed from: fe.rg.qw.uk.qw$qw  reason: collision with other inner class name */
    public class C0216qw implements Callable<Void> {
        public C0216qw() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: qw */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                fe.rg.qw.uk.qw r0 = fe.rg.qw.uk.qw.this
                monitor-enter(r0)
                fe.rg.qw.uk.qw r1 = fe.rg.qw.uk.qw.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f195switch     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                fe.rg.qw.uk.qw r1 = fe.rg.qw.uk.qw.this     // Catch:{ all -> 0x0028 }
                r1.b()     // Catch:{ all -> 0x0028 }
                fe.rg.qw.uk.qw r1 = fe.rg.qw.uk.qw.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.nn()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                fe.rg.qw.uk.qw r1 = fe.rg.qw.uk.qw.this     // Catch:{ all -> 0x0028 }
                r1.rrr()     // Catch:{ all -> 0x0028 }
                fe.rg.qw.uk.qw r1 = fe.rg.qw.uk.qw.this     // Catch:{ all -> 0x0028 }
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
            throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.uk.qw.C0216qw.call():java.lang.Void");
        }
    }

    public final class rg {
        public final File[] qw;

        public /* synthetic */ rg(qw qwVar, String str, long j, File[] fileArr, long[] jArr, C0216qw qwVar2) {
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
        this.f5054ad = file2;
        this.f5055i = i2;
        this.f5058th = new File(file2, DiskLruCache.JOURNAL_FILE);
        this.f5060yj = new File(file2, DiskLruCache.JOURNAL_FILE_TEMP);
        this.f5059uk = new File(file2, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.f5057pf = i3;
        this.f5056o = j;
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            ggg(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void ggg(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static qw mmm(File file, int i2, int i3, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            qw qwVar = new qw(file, i2, i3, j);
            if (qwVar.f5058th.exists()) {
                try {
                    qwVar.qqq();
                    qwVar.aaa();
                    return qwVar;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    qwVar.ppp();
                }
            }
            file.mkdirs();
            qw qwVar2 = new qw(file, i2, i3, j);
            qwVar2.rrr();
            return qwVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public final void aaa() throws IOException {
        ggg(this.f5060yj);
        Iterator<fe> it = this.when.values().iterator();
        while (it.hasNext()) {
            fe next = it.next();
            int i2 = 0;
            if (next.f5068th == null) {
                while (i2 < this.f5057pf) {
                    this.f194if += next.f5064ad[i2];
                    i2++;
                }
            } else {
                de unused = next.f5068th = null;
                while (i2 < this.f5057pf) {
                    ggg(next.o(i2));
                    ggg(next.pf(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final void b() throws IOException {
        while (this.f194if > this.f5056o) {
            tt((String) this.when.entrySet().iterator().next().getKey());
        }
    }

    public synchronized void close() throws IOException {
        if (this.f195switch != null) {
            Iterator it = new ArrayList(this.when.values()).iterator();
            while (it.hasNext()) {
                fe feVar = (fe) it.next();
                if (feVar.f5068th != null) {
                    feVar.f5068th.qw();
                }
            }
            b();
            this.f195switch.close();
            this.f195switch = null;
        }
    }

    public synchronized rg ddd(String str) throws IOException {
        m320switch();
        fe feVar = this.when.get(str);
        if (feVar == null) {
            return null;
        }
        if (!feVar.f5067rg) {
            return null;
        }
        for (File exists : feVar.f5065de) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.ppp++;
        this.f195switch.append(DiskLruCache.READ);
        this.f195switch.append(Ascii.CASE_MASK);
        this.f195switch.append(str);
        this.f195switch.append(10);
        if (nn()) {
            this.vvv.submit(this.xxx);
        }
        return new rg(this, str, feVar.f5070yj, feVar.f5065de, feVar.f5064ad, (C0216qw) null);
    }

    public final void eee(String str) throws IOException {
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
                feVar = new fe(this, str2, (C0216qw) null);
                this.when.put(str2, feVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(DiskLruCache.CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = feVar.f5067rg = true;
                de unused2 = feVar.f5068th = null;
                feVar.when(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DiskLruCache.DIRTY)) {
                de unused3 = feVar.f5068th = new de(this, feVar, (C0216qw) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(DiskLruCache.READ)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    public final boolean nn() {
        int i2 = this.ppp;
        return i2 >= 2000 && i2 >= this.when.size();
    }

    public void ppp() throws IOException {
        close();
        de.ad(this.f5054ad);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.ppp = r0 - r9.when.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.fe() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        rrr();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f195switch = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f5058th, true), fe.rg.qw.uk.de.qw));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void qqq() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            fe.rg.qw.uk.ad r1 = new fe.rg.qw.uk.ad
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f5058th
            r2.<init>(r3)
            java.nio.charset.Charset r3 = fe.rg.qw.uk.de.qw
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
            int r7 = r9.f5055i     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f5057pf     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.rg()     // Catch:{ EOFException -> 0x005f }
            r9.eee(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, fe.rg.qw.uk.qw$fe> r2 = r9.when     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.ppp = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.fe()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.rrr()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f5058th     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = fe.rg.qw.uk.de.qw     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f195switch = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            fe.rg.qw.uk.de.qw(r1)
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
            fe.rg.qw.uk.de.qw(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.uk.qw.qqq():void");
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void rrr() throws IOException {
        if (this.f195switch != null) {
            this.f195switch.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5060yj), de.qw));
        try {
            bufferedWriter.write(DiskLruCache.MAGIC);
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write("1");
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.f5055i));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(Integer.toString(this.f5057pf));
            bufferedWriter.write(StringUtils.LF);
            bufferedWriter.write(StringUtils.LF);
            for (fe next : this.when.values()) {
                if (next.f5068th != null) {
                    bufferedWriter.write("DIRTY " + next.qw + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.qw + next.m321if() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f5058th.exists()) {
                a(this.f5058th, this.f5059uk, true);
            }
            a(this.f5060yj, this.f5058th, false);
            this.f5059uk.delete();
            this.f195switch = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f5058th, true), de.qw));
        } catch (Throwable th2) {
            bufferedWriter.close();
            throw th2;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m320switch() {
        if (this.f195switch == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean tt(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.m320switch()     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, fe.rg.qw.uk.qw$fe> r0 = r7.when     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            fe.rg.qw.uk.qw$fe r0 = (fe.rg.qw.uk.qw.fe) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            fe.rg.qw.uk.qw$de r2 = r0.f5068th     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0017
            goto L_0x008d
        L_0x0017:
            int r2 = r7.f5057pf     // Catch:{ all -> 0x008f }
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
            long r2 = r7.f194if     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f5064ad     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            long r2 = r2 - r5
            r7.f194if = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f5064ad     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0059:
            int r0 = r7.ppp     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.ppp = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f195switch     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f195switch     // Catch:{ all -> 0x008f }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f195switch     // Catch:{ all -> 0x008f }
            r0.append(r8)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f195switch     // Catch:{ all -> 0x008f }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, fe.rg.qw.uk.qw$fe> r0 = r7.when     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.nn()     // Catch:{ all -> 0x008f }
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
        throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.uk.qw.tt(java.lang.String):boolean");
    }

    public de vvv(String str) throws IOException {
        return xxx(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void when(fe.rg.qw.uk.qw.de r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            fe.rg.qw.uk.qw$fe r0 = r10.qw     // Catch:{ all -> 0x010e }
            fe.rg.qw.uk.qw$de r1 = r0.f5068th     // Catch:{ all -> 0x010e }
            if (r1 != r10) goto L_0x0108
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f5067rg     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x004d
            r2 = 0
        L_0x0015:
            int r3 = r9.f5057pf     // Catch:{ all -> 0x010e }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f5061ad     // Catch:{ all -> 0x010e }
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
            int r10 = r9.f5057pf     // Catch:{ all -> 0x010e }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.pf(r1)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.o(r1)     // Catch:{ all -> 0x010e }
            r10.renameTo(r2)     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f5064ad     // Catch:{ all -> 0x010e }
            r3 = r10[r1]     // Catch:{ all -> 0x010e }
            long r5 = r2.length()     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f5064ad     // Catch:{ all -> 0x010e }
            r10[r1] = r5     // Catch:{ all -> 0x010e }
            long r7 = r9.f194if     // Catch:{ all -> 0x010e }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f194if = r7     // Catch:{ all -> 0x010e }
            goto L_0x007e
        L_0x007b:
            ggg(r10)     // Catch:{ all -> 0x010e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.ppp     // Catch:{ all -> 0x010e }
            r1 = 1
            int r10 = r10 + r1
            r9.ppp = r10     // Catch:{ all -> 0x010e }
            r10 = 0
            fe.rg.qw.uk.qw.de unused = r0.f5068th = r10     // Catch:{ all -> 0x010e }
            boolean r10 = r0.f5067rg     // Catch:{ all -> 0x010e }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00c9
            boolean unused = r0.f5067rg = r1     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.qw     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.m321if()     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00ec
            long r10 = r9.ggg     // Catch:{ all -> 0x010e }
            r1 = 1
            long r1 = r1 + r10
            r9.ggg = r1     // Catch:{ all -> 0x010e }
            long unused = r0.f5070yj = r10     // Catch:{ all -> 0x010e }
            goto L_0x00ec
        L_0x00c9:
            java.util.LinkedHashMap<java.lang.String, fe.rg.qw.uk.qw$fe> r10 = r9.when     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.qw     // Catch:{ all -> 0x010e }
            r10.remove(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.qw     // Catch:{ all -> 0x010e }
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
        L_0x00ec:
            java.io.Writer r10 = r9.f195switch     // Catch:{ all -> 0x010e }
            r10.flush()     // Catch:{ all -> 0x010e }
            long r10 = r9.f194if     // Catch:{ all -> 0x010e }
            long r0 = r9.f5056o     // Catch:{ all -> 0x010e }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ff
            boolean r10 = r9.nn()     // Catch:{ all -> 0x010e }
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
        throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.uk.qw.when(fe.rg.qw.uk.qw$de, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized fe.rg.qw.uk.qw.de xxx(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m320switch()     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, fe.rg.qw.uk.qw$fe> r0 = r5.when     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            fe.rg.qw.uk.qw$fe r0 = (fe.rg.qw.uk.qw.fe) r0     // Catch:{ all -> 0x005d }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r1 = r0.f5070yj     // Catch:{ all -> 0x005d }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r3
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            fe.rg.qw.uk.qw$fe r0 = new fe.rg.qw.uk.qw$fe     // Catch:{ all -> 0x005d }
            r0.<init>(r5, r6, r3)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, fe.rg.qw.uk.qw$fe> r7 = r5.when     // Catch:{ all -> 0x005d }
            r7.put(r6, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0034
        L_0x002c:
            fe.rg.qw.uk.qw$de r7 = r0.f5068th     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r3
        L_0x0034:
            fe.rg.qw.uk.qw$de r7 = new fe.rg.qw.uk.qw$de     // Catch:{ all -> 0x005d }
            r7.<init>(r5, r0, r3)     // Catch:{ all -> 0x005d }
            fe.rg.qw.uk.qw.de unused = r0.f5068th = r7     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f195switch     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f195switch     // Catch:{ all -> 0x005d }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f195switch     // Catch:{ all -> 0x005d }
            r8.append(r6)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f195switch     // Catch:{ all -> 0x005d }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f195switch     // Catch:{ all -> 0x005d }
            r6.flush()     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r7
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.rg.qw.uk.qw.xxx(java.lang.String, long):fe.rg.qw.uk.qw$de");
    }
}
