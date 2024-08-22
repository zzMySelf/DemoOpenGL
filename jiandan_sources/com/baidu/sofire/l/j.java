package com.baidu.sofire.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.sofire.a.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

@SuppressLint({"NewApi"})
public class j {
    public Context a;
    public String b;
    public String c;
    public boolean d = false;

    public j(Context context) {
        this.a = context;
    }

    public final HttpURLConnection a(Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            throw new IllegalArgumentException();
        }
        if (!this.b.equals("POST") && !this.b.equals(ShareTarget.METHOD_GET)) {
            this.b = "POST";
        }
        URL url = new URL(this.c);
        String str = null;
        int i2 = 80;
        if (!c.m(this.a)) {
            if (Build.VERSION.SDK_INT >= 13) {
                str = System.getProperties().getProperty("http.proxyHost");
                String property = System.getProperties().getProperty("http.proxyPort");
                if (!TextUtils.isEmpty(property)) {
                    try {
                        i2 = Integer.parseInt(property);
                    } catch (Throwable unused) {
                    }
                }
                i2 = -1;
            } else {
                str = Proxy.getHost(this.a);
                i2 = Proxy.getPort(this.a);
            }
        }
        if (str == null || i2 <= 0) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2)));
        }
        if ("https".equals(url.getProtocol())) {
            try {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            } catch (Throwable unused2) {
                int i3 = a.a;
            }
        }
        httpURLConnection.setRequestMethod(this.b);
        httpURLConnection.setDoInput(true);
        if ("POST".equals(this.b)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(120000);
        httpURLConnection.setReadTimeout(120000);
        String str2 = c.p(this.a)[0];
        httpURLConnection.setRequestProperty("User-Agent", "eos" + "/" + str2 + "/" + y.a(this.a) + "/" + "3.6.7.0");
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
        httpURLConnection.setRequestProperty("x-device-id", k.a(e.a(this.a)));
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0071 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.InputStream a(byte[] r8, java.net.HttpURLConnection r9) throws java.io.IOException, android.accounts.NetworkErrorException {
        /*
            r7 = this;
            r0 = 1
            java.lang.String r1 = "gzip"
            r2 = 0
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 0
            if (r8 != 0) goto L_0x0033
            int r8 = r9.getResponseCode()     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            if (r8 != r3) goto L_0x0029
            java.io.InputStream r8 = r9.getInputStream()     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            java.lang.String r9 = r9.getContentEncoding()     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            if (r3 != 0) goto L_0x0026
            boolean r9 = r1.equalsIgnoreCase(r9)     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            if (r9 == 0) goto L_0x0026
            r7.d = r0     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            goto L_0x0028
        L_0x0026:
            r7.d = r2     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
        L_0x0028:
            return r8
        L_0x0029:
            android.accounts.NetworkErrorException r9 = new android.accounts.NetworkErrorException     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            r9.<init>(r8)     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            throw r9     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
        L_0x0033:
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            java.io.OutputStream r6 = r9.getOutputStream()     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x007b, NetworkErrorException -> 0x0079, all -> 0x0071 }
            r5.write(r8)     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            r5.flush()     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            int r8 = r9.getResponseCode()     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            if (r8 != r3) goto L_0x005f
            java.io.InputStream r8 = r9.getInputStream()     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            java.lang.String r9 = r9.getContentEncoding()     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            boolean r9 = r1.equalsIgnoreCase(r9)     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            if (r9 == 0) goto L_0x0059
            r7.d = r0     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            goto L_0x005b
        L_0x0059:
            r7.d = r2     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
        L_0x005b:
            r5.close()     // Catch:{ all -> 0x005e }
        L_0x005e:
            return r8
        L_0x005f:
            android.accounts.NetworkErrorException r9 = new android.accounts.NetworkErrorException     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            r9.<init>(r8)     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
            throw r9     // Catch:{ IOException -> 0x006e, NetworkErrorException -> 0x006b, all -> 0x0069 }
        L_0x0069:
            r4 = r5
            goto L_0x0071
        L_0x006b:
            r8 = move-exception
            r4 = r5
            goto L_0x007a
        L_0x006e:
            r8 = move-exception
            r4 = r5
            goto L_0x007c
        L_0x0071:
            int r8 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x007d }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x007d }
            r8.<init>()     // Catch:{ all -> 0x007d }
            throw r8     // Catch:{ all -> 0x007d }
        L_0x0079:
            r8 = move-exception
        L_0x007a:
            throw r8     // Catch:{ all -> 0x007d }
        L_0x007b:
            r8 = move-exception
        L_0x007c:
            throw r8     // Catch:{ all -> 0x007d }
        L_0x007d:
            r8 = move-exception
            if (r4 == 0) goto L_0x0083
            r4.close()     // Catch:{ all -> 0x0083 }
        L_0x0083:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.j.a(byte[], java.net.HttpURLConnection):java.io.InputStream");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0033 A[Catch:{ all -> 0x003f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r2, byte[] r3, java.util.Map<java.lang.String, java.lang.String> r4) throws java.io.IOException, java.lang.InterruptedException, android.accounts.NetworkErrorException {
        /*
            r1 = this;
            com.baidu.sofire.b.l.b()
            android.content.Context r0 = r1.a     // Catch:{ all -> 0x003f }
            boolean r0 = com.baidu.sofire.l.r.a((android.content.Context) r0)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "POST"
            r1.b = r0     // Catch:{ all -> 0x003f }
            r1.c = r2     // Catch:{ all -> 0x003f }
            r2 = 0
            java.net.HttpURLConnection r4 = r1.a((java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ all -> 0x002a }
            java.io.InputStream r2 = r1.a((byte[]) r3, (java.net.HttpURLConnection) r4)     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = r1.a((java.io.InputStream) r2)     // Catch:{ all -> 0x0028 }
            r2.close()     // Catch:{ all -> 0x003f }
            r4.disconnect()     // Catch:{ all -> 0x003f }
            com.baidu.sofire.b.l.a()
            return r3
        L_0x0028:
            r3 = move-exception
            goto L_0x002c
        L_0x002a:
            r3 = move-exception
            r4 = r2
        L_0x002c:
            if (r2 == 0) goto L_0x0031
            r2.close()     // Catch:{ all -> 0x003f }
        L_0x0031:
            if (r4 == 0) goto L_0x0036
            r4.disconnect()     // Catch:{ all -> 0x003f }
        L_0x0036:
            throw r3     // Catch:{ all -> 0x003f }
        L_0x0037:
            android.accounts.NetworkErrorException r2 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x003f }
            java.lang.String r3 = "Not allow background connect."
            r2.<init>(r3)     // Catch:{ all -> 0x003f }
            throw r2     // Catch:{ all -> 0x003f }
        L_0x003f:
            r2 = move-exception
            com.baidu.sofire.b.l.a()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.j.a(java.lang.String, byte[], java.util.Map):java.lang.String");
    }

    public final String a(InputStream inputStream) throws IOException, InterruptedException {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                if (byteArray != null) {
                    if (this.d) {
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        byte[] bArr2 = new byte[2048];
                        while (true) {
                            int read2 = gZIPInputStream.read(bArr2, 0, 2048);
                            if (read2 == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read2);
                        }
                        gZIPInputStream.close();
                        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                        byteArrayOutputStream2.flush();
                        byteArrayOutputStream2.close();
                        byteArrayInputStream.close();
                        byteArray = byteArray2;
                    }
                    if (byteArray != null) {
                        return new String(byteArray);
                    }
                    throw new IOException();
                }
                throw new IOException("responseBytes");
            } catch (Throwable unused) {
                int i2 = a.a;
                throw new IOException();
            }
        } else {
            throw new IOException("InputStream");
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [byte[], java.io.InputStream] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e A[SYNTHETIC, Splitter:B:17:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0033 A[Catch:{ all -> 0x003f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4) throws java.io.IOException, java.lang.InterruptedException, android.accounts.NetworkErrorException {
        /*
            r2 = this;
            com.baidu.sofire.b.l.b()
            android.content.Context r0 = r2.a     // Catch:{ all -> 0x003f }
            boolean r0 = com.baidu.sofire.l.r.a((android.content.Context) r0)     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "GET"
            r1 = 0
            r2.b = r0     // Catch:{ all -> 0x002a }
            r2.c = r3     // Catch:{ all -> 0x002a }
            java.net.HttpURLConnection r3 = r2.a((java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ all -> 0x002a }
            java.io.InputStream r1 = r2.a((byte[]) r1, (java.net.HttpURLConnection) r3)     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = r2.a((java.io.InputStream) r1)     // Catch:{ all -> 0x0028 }
            r1.close()     // Catch:{ all -> 0x003f }
            r3.disconnect()     // Catch:{ all -> 0x003f }
            com.baidu.sofire.b.l.a()
            return r4
        L_0x0028:
            r4 = move-exception
            goto L_0x002c
        L_0x002a:
            r4 = move-exception
            r3 = r1
        L_0x002c:
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ all -> 0x003f }
        L_0x0031:
            if (r3 == 0) goto L_0x0036
            r3.disconnect()     // Catch:{ all -> 0x003f }
        L_0x0036:
            throw r4     // Catch:{ all -> 0x003f }
        L_0x0037:
            android.accounts.NetworkErrorException r3 = new android.accounts.NetworkErrorException     // Catch:{ all -> 0x003f }
            java.lang.String r4 = "Not allow background connect."
            r3.<init>(r4)     // Catch:{ all -> 0x003f }
            throw r3     // Catch:{ all -> 0x003f }
        L_0x003f:
            r3 = move-exception
            com.baidu.sofire.b.l.a()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.j.a(java.lang.String, java.util.Map):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Map, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:39|40) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:52|53|54|55) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:45|46|(2:48|49)|(1:51)|54|55) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r7 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x006a, code lost:
        if (r2 != 0) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006f, code lost:
        if (r6 != null) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0071, code lost:
        r6.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0077, code lost:
        com.baidu.sofire.b.l.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x007a, code lost:
        return false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0061 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0068 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0075 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x0087 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x005a=Splitter:B:36:0x005a, B:48:0x006c=Splitter:B:48:0x006c, B:58:0x007e=Splitter:B:58:0x007e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r6, java.io.File r7) {
        /*
            r5 = this;
            com.baidu.sofire.b.l.b()
            android.content.Context r0 = r5.a     // Catch:{ all -> 0x008a }
            boolean r0 = com.baidu.sofire.l.c.l(r0)     // Catch:{ all -> 0x008a }
            r1 = 0
            if (r0 != 0) goto L_0x0010
            com.baidu.sofire.b.l.a()
            return r1
        L_0x0010:
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x001a
            com.baidu.sofire.b.l.a()
            return r1
        L_0x001a:
            android.content.Context r0 = r5.a     // Catch:{ all -> 0x008a }
            boolean r0 = com.baidu.sofire.l.r.a((android.content.Context) r0)     // Catch:{ all -> 0x008a }
            if (r0 != 0) goto L_0x0026
            com.baidu.sofire.b.l.a()
            return r1
        L_0x0026:
            java.lang.String r0 = "GET"
            r2 = 0
            r5.b = r0     // Catch:{ all -> 0x0067 }
            r5.c = r6     // Catch:{ all -> 0x0067 }
            java.net.HttpURLConnection r6 = r5.a((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ all -> 0x0067 }
            android.content.Context r0 = r5.a     // Catch:{ all -> 0x0068 }
            boolean r0 = com.baidu.sofire.l.c.l(r0)     // Catch:{ all -> 0x0068 }
            if (r0 != 0) goto L_0x003a
            goto L_0x0054
        L_0x003a:
            java.io.InputStream r0 = r6.getInputStream()     // Catch:{ IOException -> 0x0052 }
            java.lang.String r3 = "gzip"
            java.lang.String r4 = r6.getContentEncoding()     // Catch:{ IOException -> 0x0052 }
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ IOException -> 0x0052 }
            if (r3 == 0) goto L_0x004e
            r3 = 1
            r5.d = r3     // Catch:{ IOException -> 0x0052 }
            goto L_0x0050
        L_0x004e:
            r5.d = r1     // Catch:{ IOException -> 0x0052 }
        L_0x0050:
            r2 = r0
            goto L_0x0054
        L_0x0052:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0068 }
        L_0x0054:
            boolean r7 = r5.a((java.io.InputStream) r2, (java.io.File) r7)     // Catch:{ all -> 0x0068 }
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ all -> 0x0061 }
        L_0x005d:
            r6.disconnect()     // Catch:{ all -> 0x0061 }
            goto L_0x0063
        L_0x0061:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x008a }
        L_0x0063:
            com.baidu.sofire.b.l.a()
            return r7
        L_0x0067:
            r6 = r2
        L_0x0068:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x006f
            r2.close()     // Catch:{ all -> 0x0075 }
        L_0x006f:
            if (r6 == 0) goto L_0x0077
            r6.disconnect()     // Catch:{ all -> 0x0075 }
            goto L_0x0077
        L_0x0075:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x008a }
        L_0x0077:
            com.baidu.sofire.b.l.a()
            return r1
        L_0x007b:
            r7 = move-exception
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ all -> 0x0087 }
        L_0x0081:
            if (r6 == 0) goto L_0x0089
            r6.disconnect()     // Catch:{ all -> 0x0087 }
            goto L_0x0089
        L_0x0087:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x008a }
        L_0x0089:
            throw r7     // Catch:{ all -> 0x008a }
        L_0x008a:
            r6 = move-exception
            com.baidu.sofire.b.l.a()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.j.a(java.lang.String, java.io.File):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:26|27|(2:29|30)|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0040, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0041, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0042, code lost:
        if (r1 != null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0048, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x004a, code lost:
        throw r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r5, java.io.File r6) {
        /*
            r4 = this;
            boolean r0 = r4.d
            if (r0 == 0) goto L_0x000d
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x000b }
            r0.<init>(r5)     // Catch:{ IOException -> 0x000b }
            r5 = r0
            goto L_0x000d
        L_0x000b:
            int r0 = com.baidu.sofire.a.a.a
        L_0x000d:
            r0 = 0
            if (r5 != 0) goto L_0x0011
            return r0
        L_0x0011:
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0035 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ all -> 0x0035 }
            r2.<init>(r6)     // Catch:{ all -> 0x0035 }
            r1.<init>(r2)     // Catch:{ all -> 0x0035 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0036 }
        L_0x001f:
            int r2 = r5.read(r6)     // Catch:{ all -> 0x0036 }
            r3 = -1
            if (r2 == r3) goto L_0x002d
            r1.write(r6, r0, r2)     // Catch:{ all -> 0x0036 }
            r1.flush()     // Catch:{ all -> 0x0036 }
            goto L_0x001f
        L_0x002d:
            r5 = 1
            r1.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            int r6 = com.baidu.sofire.a.a.a
        L_0x0034:
            return r5
        L_0x0035:
            r1 = 0
        L_0x0036:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0040
            r1.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0040
        L_0x003e:
            int r5 = com.baidu.sofire.a.a.a
        L_0x0040:
            return r0
        L_0x0041:
            r5 = move-exception
            if (r1 == 0) goto L_0x004a
            r1.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004a
        L_0x0048:
            int r6 = com.baidu.sofire.a.a.a
        L_0x004a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.j.a(java.io.InputStream, java.io.File):boolean");
    }
}
