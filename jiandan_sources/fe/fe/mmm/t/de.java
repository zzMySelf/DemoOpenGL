package fe.fe.mmm.t;

import fe.fe.mmm.tt;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;

public class de extends GZIPOutputStream {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f2145i = tt.vvv();

    /* renamed from: ad  reason: collision with root package name */
    public MessageDigest f2146ad = null;

    /* renamed from: th  reason: collision with root package name */
    public int f2147th = 0;

    /* renamed from: uk  reason: collision with root package name */
    public StringBuilder f2148uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f2149yj = 0;

    public de(OutputStream outputStream) throws IOException {
        super(outputStream);
    }

    public String de() {
        StringBuilder sb = this.f2148uk;
        return sb != null ? sb.toString() : "";
    }

    public final void fe() {
        if (this.f2146ad == null) {
            try {
                this.f2146ad = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        MessageDigest messageDigest = this.f2146ad;
        if (messageDigest != null) {
            messageDigest.reset();
        }
    }

    public byte[] qw() {
        MessageDigest messageDigest = this.f2146ad;
        if (messageDigest == null || this.f2147th != 2) {
            return null;
        }
        return messageDigest.digest();
    }

    public void rg() {
        this.f2147th = 1;
        this.f2149yj = 0;
        if (f2145i) {
            this.f2148uk = new StringBuilder();
        }
    }

    public void th() {
        this.f2147th = 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void write(byte[] r3, int r4, int r5) throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            super.write(r3, r4, r5)     // Catch:{ all -> 0x003e }
            int r0 = r2.f2149yj     // Catch:{ all -> 0x003e }
            int r0 = r0 + r5
            r2.f2149yj = r0     // Catch:{ all -> 0x003e }
            int r0 = r2.f2147th     // Catch:{ all -> 0x003e }
            r1 = 1
            if (r0 != r1) goto L_0x003c
            byte r0 = r3[r4]     // Catch:{ all -> 0x003e }
            r1 = 58
            if (r0 != r1) goto L_0x001c
            java.security.MessageDigest r0 = r2.f2146ad     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x001c
            int r4 = r4 + 1
            int r5 = r5 + -1
        L_0x001c:
            java.security.MessageDigest r0 = r2.f2146ad     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x0023
            r2.fe()     // Catch:{ all -> 0x003e }
        L_0x0023:
            java.security.MessageDigest r0 = r2.f2146ad     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x0029
            monitor-exit(r2)
            return
        L_0x0029:
            java.security.MessageDigest r0 = r2.f2146ad     // Catch:{ all -> 0x003e }
            r0.update(r3, r4, r5)     // Catch:{ all -> 0x003e }
            boolean r0 = f2145i     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003c
            java.lang.StringBuilder r0 = r2.f2148uk     // Catch:{ all -> 0x003e }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x003e }
            r1.<init>(r3, r4, r5)     // Catch:{ all -> 0x003e }
            r0.append(r1)     // Catch:{ all -> 0x003e }
        L_0x003c:
            monitor-exit(r2)
            return
        L_0x003e:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.mmm.t.de.write(byte[], int, int):void");
    }
}
