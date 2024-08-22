package fe.mmm.qw.nn.de.pf;

import android.os.SystemClock;
import fe.mmm.qw.i.qw;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public HttpURLConnection f8110ad;

    /* renamed from: de  reason: collision with root package name */
    public long f8111de = 0;
    public boolean qw = false;

    public ad(HttpURLConnection httpURLConnection) {
        this.f8110ad = httpURLConnection;
        this.qw = "gzip".equals(httpURLConnection.getContentEncoding());
    }

    public long ad() {
        return this.f8111de;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String de(java.io.InputStream r7) throws java.io.IOException {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0055
            java.lang.String r0 = ""
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ UnsupportedEncodingException -> 0x0034, all -> 0x0032 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ UnsupportedEncodingException -> 0x0034, all -> 0x0032 }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r7, r4)     // Catch:{ UnsupportedEncodingException -> 0x0034, all -> 0x0032 }
            r2.<init>(r3)     // Catch:{ UnsupportedEncodingException -> 0x0034, all -> 0x0032 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ UnsupportedEncodingException -> 0x0030 }
            r1.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0030 }
        L_0x0016:
            java.lang.String r0 = r2.readLine()     // Catch:{ UnsupportedEncodingException -> 0x0030 }
            if (r0 == 0) goto L_0x0025
            r1.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0030 }
            java.lang.String r3 = "\n"
            r1.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x0030 }
            goto L_0x0016
        L_0x0025:
            java.lang.String r0 = r1.toString()     // Catch:{ UnsupportedEncodingException -> 0x0030 }
            r2.close()
            r7.close()
            return r0
        L_0x0030:
            r1 = move-exception
            goto L_0x0038
        L_0x0032:
            r0 = move-exception
            goto L_0x004c
        L_0x0034:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x0038:
            java.lang.String r3 = "HttpResponse"
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x004a }
            fe.mmm.qw.i.qw.th(r3, r4, r1)     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0046
            r2.close()
        L_0x0046:
            r7.close()
            return r0
        L_0x004a:
            r0 = move-exception
            r1 = r2
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()
        L_0x0051:
            r7.close()
            throw r0
        L_0x0055:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r0 = "InputStream is null"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.nn.de.pf.ad.de(java.io.InputStream):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String fe(java.io.InputStream r7) throws java.io.IOException {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x004b
            r0 = 0
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x0039 }
            r1.<init>(r7)     // Catch:{ all -> 0x0039 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0032 }
        L_0x0011:
            int r3 = r1.read(r0)     // Catch:{ all -> 0x0032 }
            r4 = -1
            if (r3 == r4) goto L_0x001d
            r4 = 0
            r2.write(r0, r4, r3)     // Catch:{ all -> 0x0032 }
            goto L_0x0011
        L_0x001d:
            byte[] r0 = r2.toByteArray()     // Catch:{ all -> 0x0032 }
            r2.close()
            r1.close()
            r7.close()
            java.lang.String r7 = new java.lang.String
            java.lang.String r1 = "UTF-8"
            r7.<init>(r0, r1)
            return r7
        L_0x0032:
            r0 = move-exception
            goto L_0x003d
        L_0x0034:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x003d
        L_0x0039:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x003d:
            if (r2 == 0) goto L_0x0042
            r2.close()
        L_0x0042:
            if (r1 == 0) goto L_0x0047
            r1.close()
        L_0x0047:
            r7.close()
            throw r0
        L_0x004b:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r0 = "InputStream is null"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.nn.de.pf.ad.fe(java.io.InputStream):java.lang.String");
    }

    public String qw() throws IOException {
        InputStream inputStream;
        try {
            inputStream = this.f8110ad.getInputStream();
        } catch (Exception unused) {
            inputStream = this.f8110ad.getErrorStream();
            qw.ppp("HttpResponse", "get input stream failed and get error stream");
        }
        if (!this.qw) {
            String de2 = de(inputStream);
            th(SystemClock.elapsedRealtime());
            return de2;
        }
        String fe2 = fe(inputStream);
        th(SystemClock.elapsedRealtime());
        return fe2;
    }

    public void rg(int i2) {
    }

    public void th(long j) {
        this.f8111de = j;
    }
}
