package fe.when.ad.d;

import com.itextpdf.text.io.RandomAccessSource;
import fe.when.ad.c.qw;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.FileChannel;

public final class o {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f9321ad = false;

    /* renamed from: de  reason: collision with root package name */
    public boolean f9322de = false;
    public boolean qw = false;

    public RandomAccessSource ad(FileChannel fileChannel) throws IOException {
        if (fileChannel.size() <= 67108864) {
            return new fe(new de(fileChannel));
        }
        return new fe(new uk(fileChannel));
    }

    public final RandomAccessSource de(InputStream inputStream) throws IOException {
        try {
            return new qw(pf.de(inputStream));
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public final RandomAccessSource fe(String str) throws IOException {
        InputStream qw2 = pf.qw(str);
        if (qw2 != null) {
            return de(qw2);
        }
        throw new IOException(qw.ad("1.not.found.as.file.or.resource", str));
    }

    public o i(boolean z) {
        this.f9321ad = z;
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:43|44|45) */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a0, code lost:
        return new fe.when.ad.d.i(r1);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.io.RandomAccessSource qw(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.canRead()
            if (r1 != 0) goto L_0x0051
            java.lang.String r0 = "file:/"
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "http://"
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "https://"
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "jar:"
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "wsjar:"
            boolean r1 = r7.startsWith(r0)
            if (r1 != 0) goto L_0x0047
            boolean r0 = r7.startsWith(r0)
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = "vfszip:"
            boolean r0 = r7.startsWith(r0)
            if (r0 == 0) goto L_0x0042
            goto L_0x0047
        L_0x0042:
            com.itextpdf.text.io.RandomAccessSource r7 = r6.fe(r7)
            return r7
        L_0x0047:
            java.net.URL r0 = new java.net.URL
            r0.<init>(r7)
            com.itextpdf.text.io.RandomAccessSource r7 = r6.th(r0)
            return r7
        L_0x0051:
            boolean r1 = r6.qw
            if (r1 == 0) goto L_0x005f
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r7)
            com.itextpdf.text.io.RandomAccessSource r7 = r6.de(r0)
            return r7
        L_0x005f:
            boolean r7 = r6.f9322de
            if (r7 == 0) goto L_0x0066
            java.lang.String r7 = "rw"
            goto L_0x0068
        L_0x0066:
            java.lang.String r7 = "r"
        L_0x0068:
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            r1.<init>(r0, r7)
            boolean r7 = r6.f9322de
            if (r7 == 0) goto L_0x0078
            java.nio.channels.FileChannel r7 = r1.getChannel()
            r7.lock()
        L_0x0078:
            boolean r7 = r6.f9321ad
            if (r7 == 0) goto L_0x0082
            fe.when.ad.d.i r7 = new fe.when.ad.d.i
            r7.<init>(r1)
            return r7
        L_0x0082:
            long r2 = r1.length()     // Catch:{ IOException -> 0x00a6, RuntimeException -> 0x00a1 }
            r4 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0092
            fe.when.ad.d.i r7 = new fe.when.ad.d.i     // Catch:{ IOException -> 0x00a6, RuntimeException -> 0x00a1 }
            r7.<init>(r1)     // Catch:{ IOException -> 0x00a6, RuntimeException -> 0x00a1 }
            return r7
        L_0x0092:
            java.nio.channels.FileChannel r7 = r1.getChannel()     // Catch:{ MapFailedException -> 0x009b }
            com.itextpdf.text.io.RandomAccessSource r7 = r6.ad(r7)     // Catch:{ MapFailedException -> 0x009b }
            return r7
        L_0x009b:
            fe.when.ad.d.i r7 = new fe.when.ad.d.i     // Catch:{ IOException -> 0x00a6, RuntimeException -> 0x00a1 }
            r7.<init>(r1)     // Catch:{ IOException -> 0x00a6, RuntimeException -> 0x00a1 }
            return r7
        L_0x00a1:
            r7 = move-exception
            r1.close()     // Catch:{ IOException -> 0x00a5 }
        L_0x00a5:
            throw r7
        L_0x00a6:
            r7 = move-exception
            r1.close()     // Catch:{ IOException -> 0x00aa }
        L_0x00aa:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.when.ad.d.o.qw(java.lang.String):com.itextpdf.text.io.RandomAccessSource");
    }

    public RandomAccessSource rg(InputStream inputStream) throws IOException {
        try {
            return yj(pf.de(inputStream));
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public RandomAccessSource th(URL url) throws IOException {
        InputStream openStream = url.openStream();
        try {
            return rg(openStream);
        } finally {
            try {
                openStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public o uk(boolean z) {
        this.qw = z;
        return this;
    }

    public RandomAccessSource yj(byte[] bArr) {
        return new qw(bArr);
    }
}
