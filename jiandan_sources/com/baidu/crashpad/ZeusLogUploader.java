package com.baidu.crashpad;

import java.io.File;
import java.io.FilenameFilter;
import java.math.BigInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ZeusLogUploader {

    /* renamed from: fe  reason: collision with root package name */
    public static boolean f754fe = true;

    /* renamed from: rg  reason: collision with root package name */
    public static String f755rg = "";

    /* renamed from: th  reason: collision with root package name */
    public static boolean f756th = true;

    /* renamed from: yj  reason: collision with root package name */
    public static String f757yj;

    /* renamed from: ad  reason: collision with root package name */
    public String f758ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f759de;
    public String qw;

    public interface OnFinishedListener {
        void onFinished(String str, int i2, String str2);
    }

    public static class qw implements FilenameFilter {
        public String qw;

        public qw(String str) {
            this.qw = str;
        }

        public boolean accept(File file, String str) {
            if ("crashlog".equals(this.qw) || "recordlog".equals(this.qw)) {
                return str.endsWith(".bdmp");
            }
            if ("videolog".equals(this.qw)) {
                return str.endsWith(".log");
            }
            if ("nrlog".equals(this.qw)) {
                return str.endsWith(".nr");
            }
            return false;
        }
    }

    static {
        new BigInteger("65537");
    }

    public ZeusLogUploader(String str, String str2, boolean z) {
        this.f758ad = str;
        this.f759de = z;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("CUID").put(str2);
        try {
            jSONObject.put("CUID", jSONArray);
        } catch (JSONException unused) {
        }
        this.qw = jSONObject.toString();
    }

    /* renamed from: if  reason: not valid java name */
    public static void m12if(String str) {
        f757yj = str;
    }

    public static void o(String str) {
        f755rg = str;
    }

    public static void pf(boolean z) {
        f754fe = z;
    }

    public static boolean qw(String str, String str2, boolean z, OnFinishedListener onFinishedListener) {
        return new ZeusLogUploader(str2, (String) null, true).ppp(str, z, onFinishedListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0048 A[SYNTHETIC, Splitter:B:24:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d A[Catch:{ Exception -> 0x0050 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] rg(byte[] r7, int r8, java.lang.StringBuffer r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0051
            if (r8 > 0) goto L_0x0006
            goto L_0x0051
        L_0x0006:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            r2 = 4096(0x1000, float:5.74E-42)
            byte[] r2 = new byte[r2]
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x003c }
            int r4 = r7.length     // Catch:{ Exception -> 0x003c }
            if (r8 <= r4) goto L_0x0015
            int r8 = r7.length     // Catch:{ Exception -> 0x003c }
        L_0x0015:
            r4 = 0
            r3.<init>(r7, r4, r8)     // Catch:{ Exception -> 0x003c }
            java.util.zip.GZIPOutputStream r7 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0039 }
            r7.<init>(r1)     // Catch:{ Exception -> 0x0039 }
        L_0x001e:
            int r8 = r3.read(r2)     // Catch:{ Exception -> 0x0034 }
            r5 = -1
            if (r8 == r5) goto L_0x0029
            r7.write(r2, r4, r8)     // Catch:{ Exception -> 0x0034 }
            goto L_0x001e
        L_0x0029:
            r3.close()     // Catch:{ Exception -> 0x0034 }
            r7.close()     // Catch:{ Exception -> 0x0034 }
            byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0050
        L_0x0034:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x003f
        L_0x0039:
            r7 = move-exception
            r8 = r0
            goto L_0x003f
        L_0x003c:
            r7 = move-exception
            r8 = r0
            r3 = r8
        L_0x003f:
            java.lang.String r7 = r7.getMessage()
            r9.append(r7)
            if (r3 == 0) goto L_0x004b
            r3.close()     // Catch:{ Exception -> 0x0050 }
        L_0x004b:
            if (r8 == 0) goto L_0x0050
            r8.close()     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            return r0
        L_0x0051:
            java.lang.String r7 = "doCompress Failed, source is null; "
            r9.append(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.ZeusLogUploader.rg(byte[], int, java.lang.StringBuffer):byte[]");
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m13switch(boolean z) {
        f756th = z;
    }

    public static boolean th(String str, StringBuffer stringBuffer) {
        if (str == null || str.isEmpty()) {
            stringBuffer.append("Failed to remove empty file:" + str);
            return false;
        }
        File file = new File(str);
        if (file.isFile() && file.delete()) {
            return true;
        }
        stringBuffer.append("Failed to remove file:" + file.getName());
        return false;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.net.HttpURLConnection, java.security.SecureRandom, char[], javax.net.ssl.KeyManager[], java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r9v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r9v8 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x019b A[SYNTHETIC, Splitter:B:61:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a0 A[Catch:{ Exception -> 0x01a3 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean uk(byte[] r8, java.lang.String r9, boolean r10, java.lang.String r11, java.lang.StringBuffer r12) {
        /*
            r0 = 47
            int r0 = r11.lastIndexOf(r0)
            r1 = 1
            int r0 = r0 + r1
            java.lang.String r11 = r11.substring(r0)
            r0 = 0
            if (r8 == 0) goto L_0x01ad
            if (r11 == 0) goto L_0x01ad
            boolean r2 = r11.isEmpty()
            if (r2 == 0) goto L_0x0019
            goto L_0x01ad
        L_0x0019:
            java.lang.String r2 = "https://browserkernel.baidu.com/kw?type=engine"
            boolean r3 = com.baidu.crashpad.ZwDebugExtra.debugModel()
            if (r3 == 0) goto L_0x005b
            java.lang.String r3 = f755rg     // Catch:{ Exception -> 0x005b }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x005b }
            if (r3 != 0) goto L_0x005b
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x005b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r4.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r5 = f755rg     // Catch:{ Exception -> 0x005b }
            r4.append(r5)     // Catch:{ Exception -> 0x005b }
            java.lang.String r5 = "log_server.txt"
            r4.append(r5)     // Catch:{ Exception -> 0x005b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x005b }
            r3.<init>(r4)     // Catch:{ Exception -> 0x005b }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x005b }
            if (r4 == 0) goto L_0x005b
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ Exception -> 0x005b }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ Exception -> 0x005b }
            r5.<init>(r3)     // Catch:{ Exception -> 0x005b }
            r4.<init>(r5)     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = r4.readLine()     // Catch:{ Exception -> 0x005b }
            if (r3 == 0) goto L_0x0058
            r2 = r3
        L_0x0058:
            r4.close()     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            r3 = 4096(0x1000, float:5.74E-42)
            byte[] r3 = new byte[r3]
            r4 = 0
            if (r10 == 0) goto L_0x0184
            java.net.URL r10 = new java.net.URL     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r10.<init>(r2)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.lang.String r2 = "X.509"
            java.security.cert.CertificateFactory r2 = java.security.cert.CertificateFactory.getInstance(r2)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.lang.String r5 = "-----BEGIN CERTIFICATE-----\nMIICZTCCAc4CAQAwDQYJKoZIhvcNAQEEBQAwezELMAkGA1UEBhMCQ04xCzAJBgNV\nBAgTAkJKMQswCQYDVQQHEwJCSjELMAkGA1UEChMCQkQxCzAJBgNVBAsTAkJEMRYw\nFAYDVQQDEw13d3cuYmFpZHUuY29tMSAwHgYJKoZIhvcNAQkBFhFsaWJpbjAyQGJh\naWR1LmNvbTAeFw0xMjA1MTAwMjMzNTVaFw0xMjA2MDkwMjMzNTVaMHsxCzAJBgNV\nBAYTAkNOMQswCQYDVQQIEwJCSjELMAkGA1UEBxMCQkoxCzAJBgNVBAoTAkJEMQsw\nCQYDVQQLEwJCRDEWMBQGA1UEAxMNd3d3LmJhaWR1LmNvbTEgMB4GCSqGSIb3DQEJ\nARYRbGliaW4wMkBiYWlkdS5jb20wgZ8wDQYJKoZIhvcNAQEBBQADgY0AMIGJAoGB\nALckGzvn6jcMqYpXrZKuuCYlVJIgN2ETsnvjCtO1va5u3p0EL9CuR5BlHocJadzM\nhTI7rH/nao8mXRIcJ4Q6lOv5TAotcKUv7ri9YZ48smpE3+KXVB+Mjau05OfiYI2h\nqlYy56acRSgyp8Uj65PXL8+gae8Gx+6lq0XOKduolmmNAgMBAAEwDQYJKoZIhvcN\nAQEEBQADgYEAYGPEvv1fc4XySq+9+5jFi4TxlNy9vAWpHOjsmODM9gs5/9PQFG/c\nZc8Fz+T9IVRa8YI0mLuKlApGmvzHxwdWbtBU6AU8ifg1HBA/4VXweiq6fgRfaemd\njgW3PXjbd+OoZ0VI32TvrDErG83OYohQ5CAS2gKHfBXHJvKtmxUSdVE=\n-----END CERTIFICATE-----\n"
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0167 }
            byte[] r5 = r5.getBytes()     // Catch:{ all -> 0x0167 }
            r6.<init>(r5)     // Catch:{ all -> 0x0167 }
            java.security.cert.Certificate r2 = r2.generateCertificate(r6)     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = java.security.KeyStore.getDefaultType()     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.security.KeyStore r5 = java.security.KeyStore.getInstance(r5)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r5.load(r4, r4)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.lang.String r6 = "ca"
            r5.setCertificateEntry(r6, r2)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.lang.String r2 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            javax.net.ssl.TrustManagerFactory r2 = javax.net.ssl.TrustManagerFactory.getInstance(r2)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r2.init(r5)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.lang.String r5 = "TLS"
            javax.net.ssl.SSLContext r5 = javax.net.ssl.SSLContext.getInstance(r5)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            javax.net.ssl.TrustManager[] r2 = r2.getTrustManagers()     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r5.init(r4, r2, r4)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.net.URLConnection r10 = r10.openConnection()     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            javax.net.ssl.HttpsURLConnection r10 = (javax.net.ssl.HttpsURLConnection) r10     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r10.setDoInput(r1)     // Catch:{ Exception -> 0x0164 }
            r10.setDoOutput(r1)     // Catch:{ Exception -> 0x0164 }
            r10.setUseCaches(r0)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r2 = "POST"
            r10.setRequestMethod(r2)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r2 = "Connection"
            java.lang.String r5 = "Keep-Alive"
            r10.setRequestProperty(r2, r5)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r2 = "Content-Type"
            java.lang.String r5 = "application/x-gzip"
            r10.setRequestProperty(r2, r5)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r2 = "Content-Length"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0164 }
            r5.<init>()     // Catch:{ Exception -> 0x0164 }
            java.lang.String r6 = ""
            r5.append(r6)     // Catch:{ Exception -> 0x0164 }
            int r6 = r8.length     // Catch:{ Exception -> 0x0164 }
            r5.append(r6)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0164 }
            r10.setRequestProperty(r2, r5)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r2 = "Content-Disposition"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0164 }
            r5.<init>()     // Catch:{ Exception -> 0x0164 }
            java.lang.String r6 = "attchment;filename="
            r5.append(r6)     // Catch:{ Exception -> 0x0164 }
            r5.append(r11)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r11 = r5.toString()     // Catch:{ Exception -> 0x0164 }
            r10.setRequestProperty(r2, r11)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r11 = "LogType"
            r10.setRequestProperty(r11, r9)     // Catch:{ Exception -> 0x0164 }
            int r9 = r8.length     // Catch:{ Exception -> 0x0164 }
            r10.setFixedLengthStreamingMode(r9)     // Catch:{ Exception -> 0x0164 }
            r10.connect()     // Catch:{ Exception -> 0x0164 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0164 }
            r9.<init>(r8)     // Catch:{ Exception -> 0x0164 }
            java.io.OutputStream r4 = r10.getOutputStream()     // Catch:{ Exception -> 0x015f }
        L_0x0108:
            int r8 = r9.read(r3)     // Catch:{ Exception -> 0x015f }
            r11 = -1
            if (r8 == r11) goto L_0x0113
            r4.write(r3, r0, r8)     // Catch:{ Exception -> 0x015f }
            goto L_0x0108
        L_0x0113:
            r9.close()     // Catch:{ Exception -> 0x015f }
            r4.flush()     // Catch:{ Exception -> 0x015f }
            r4.close()     // Catch:{ Exception -> 0x015f }
            int r8 = r10.getResponseCode()     // Catch:{ Exception -> 0x015f }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015f }
            r11.<init>()     // Catch:{ Exception -> 0x015f }
            java.lang.String r2 = "CRASHPAD finish send the reqeust , responseCode = "
            r11.append(r2)     // Catch:{ Exception -> 0x015f }
            r11.append(r8)     // Catch:{ Exception -> 0x015f }
            java.lang.String r2 = ",  mUploadCrashLogFailedEncrypt="
            r11.append(r2)     // Catch:{ Exception -> 0x015f }
            boolean r2 = f756th     // Catch:{ Exception -> 0x015f }
            r11.append(r2)     // Catch:{ Exception -> 0x015f }
            r11.toString()     // Catch:{ Exception -> 0x015f }
            r11 = 200(0xc8, float:2.8E-43)
            if (r8 != r11) goto L_0x0147
            java.lang.String r8 = "Upload Success; The server has responed 200 . "
            r12.append(r8)     // Catch:{ Exception -> 0x015f }
            r10.disconnect()
            return r1
        L_0x0147:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015f }
            r11.<init>()     // Catch:{ Exception -> 0x015f }
            java.lang.String r1 = "doUpload Failed, The server has responsed Code "
            r11.append(r1)     // Catch:{ Exception -> 0x015f }
            r11.append(r8)     // Catch:{ Exception -> 0x015f }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x015f }
            r12.append(r8)     // Catch:{ Exception -> 0x015f }
            r10.disconnect()
            return r0
        L_0x015f:
            r8 = move-exception
            r7 = r4
            r4 = r9
            r9 = r7
            goto L_0x0192
        L_0x0164:
            r8 = move-exception
            r9 = r4
            goto L_0x0192
        L_0x0167:
            r8 = move-exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r9.<init>()     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.lang.String r10 = "Upload Failed; "
            r9.append(r10)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.lang.String r8 = r8.getMessage()     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r9.append(r8)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r12.append(r8)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r4.disconnect()
            return r0
        L_0x0184:
            java.lang.String r8 = "doUpload Failed, HTTP is never supported!"
            r12.append(r8)     // Catch:{ Exception -> 0x018f, all -> 0x018d }
            r4.disconnect()
            return r0
        L_0x018d:
            r8 = move-exception
            goto L_0x01a9
        L_0x018f:
            r8 = move-exception
            r9 = r4
            r10 = r9
        L_0x0192:
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x01a7 }
            r12.append(r8)     // Catch:{ all -> 0x01a7 }
            if (r4 == 0) goto L_0x019e
            r4.close()     // Catch:{ Exception -> 0x01a3 }
        L_0x019e:
            if (r9 == 0) goto L_0x01a3
            r9.close()     // Catch:{ Exception -> 0x01a3 }
        L_0x01a3:
            r10.disconnect()
            return r0
        L_0x01a7:
            r8 = move-exception
            r4 = r10
        L_0x01a9:
            r4.disconnect()
            throw r8
        L_0x01ad:
            if (r8 != 0) goto L_0x01b5
            java.lang.String r8 = "doUpload Failed, data is null"
            r12.append(r8)
            goto L_0x01c8
        L_0x01b5:
            if (r11 != 0) goto L_0x01bd
            java.lang.String r8 = "doUpload Failed, filename is null"
            r12.append(r8)
            goto L_0x01c8
        L_0x01bd:
            boolean r8 = r11.isEmpty()
            if (r8 == 0) goto L_0x01c8
            java.lang.String r8 = "doUpload Failed, filename is empty"
            r12.append(r8)
        L_0x01c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.ZeusLogUploader.uk(byte[], java.lang.String, boolean, java.lang.String, java.lang.StringBuffer):boolean");
    }

    public static boolean when(byte[] bArr) {
        return 12 < bArr.length && "uploadfailed".equals(new String(bArr, bArr.length - 12, 12));
    }

    public boolean ggg(String str, boolean z, OnFinishedListener onFinishedListener) {
        if (!f754fe || str == null || str.isEmpty() || !new File(str).exists()) {
            return false;
        }
        Thread thread = new Thread(new ad(str, this.f758ad, this.qw, this.f759de, z, onFinishedListener));
        thread.setName("T7@ZeusLogFile1");
        thread.start();
        return true;
    }

    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0047 A[SYNTHETIC, Splitter:B:30:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004e A[SYNTHETIC, Splitter:B:34:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0056 A[SYNTHETIC, Splitter:B:41:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005d A[SYNTHETIC, Splitter:B:45:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0072 A[Catch:{ Exception -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0073 A[Catch:{ Exception -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0098 A[SYNTHETIC, Splitter:B:65:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int i(java.lang.String r10, boolean r11) {
        /*
            r9 = this;
            if (r11 == 0) goto L_0x0004
            r0 = 6
            goto L_0x0005
        L_0x0004:
            r0 = 7
        L_0x0005:
            java.io.File r1 = new java.io.File
            r1.<init>(r10)
            boolean r2 = r1.exists()
            r3 = 0
            r4 = 0
            r5 = 5
            if (r2 == 0) goto L_0x0062
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0052, all -> 0x0043 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            r2.<init>()     // Catch:{ Exception -> 0x0041, all -> 0x003f }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x003d, all -> 0x003a }
        L_0x0026:
            int r7 = r1.read(r6)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            r8 = -1
            if (r7 == r8) goto L_0x0031
            r2.write(r6, r3, r7)     // Catch:{ Exception -> 0x003d, all -> 0x003a }
            goto L_0x0026
        L_0x0031:
            r2.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0036
        L_0x0035:
            r0 = 5
        L_0x0036:
            r1.close()     // Catch:{ Exception -> 0x0060 }
            goto L_0x0063
        L_0x003a:
            r10 = move-exception
            r4 = r2
            goto L_0x0045
        L_0x003d:
            goto L_0x0054
        L_0x003f:
            r10 = move-exception
            goto L_0x0045
        L_0x0041:
            r2 = r4
            goto L_0x0054
        L_0x0043:
            r10 = move-exception
            r1 = r4
        L_0x0045:
            if (r4 == 0) goto L_0x004c
            r4.close()     // Catch:{ Exception -> 0x004b }
            goto L_0x004c
        L_0x004b:
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            throw r10
        L_0x0052:
            r1 = r4
            r2 = r1
        L_0x0054:
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ Exception -> 0x005a }
            goto L_0x005b
        L_0x005a:
        L_0x005b:
            if (r1 == 0) goto L_0x0060
            r1.close()     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            r0 = 5
            goto L_0x0063
        L_0x0062:
            r2 = r4
        L_0x0063:
            byte[] r1 = r2.toByteArray()     // Catch:{ Exception -> 0x0095 }
            byte[] r2 = r2.toByteArray()     // Catch:{ Exception -> 0x0095 }
            int r2 = r2.length     // Catch:{ Exception -> 0x0095 }
            byte[] r1 = r9.yj(r1, r2, r11)     // Catch:{ Exception -> 0x0095 }
            if (r1 != 0) goto L_0x0073
            goto L_0x009b
        L_0x0073:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0095 }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0095 }
            r6.<init>(r10)     // Catch:{ Exception -> 0x0095 }
            r2.<init>(r6, r3)     // Catch:{ Exception -> 0x0095 }
            r2.write(r1)     // Catch:{ Exception -> 0x0093 }
            if (r11 == 0) goto L_0x008b
            java.lang.String r10 = "uploadfailed"
            byte[] r10 = r10.getBytes()     // Catch:{ Exception -> 0x0093 }
            r2.write(r10)     // Catch:{ Exception -> 0x0093 }
        L_0x008b:
            r2.flush()     // Catch:{ Exception -> 0x0093 }
            r2.close()     // Catch:{ Exception -> 0x0093 }
            r5 = r0
            goto L_0x009b
        L_0x0093:
            r4 = r2
            goto L_0x0096
        L_0x0095:
        L_0x0096:
            if (r4 == 0) goto L_0x009b
            r4.close()     // Catch:{ IOException -> 0x009b }
        L_0x009b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.ZeusLogUploader.i(java.lang.String, boolean):int");
    }

    public boolean ppp(String str, boolean z, OnFinishedListener onFinishedListener) {
        File[] listFiles;
        if (f754fe && str != null && !str.isEmpty()) {
            File file = new File(str);
            if (!(!file.exists() || (listFiles = file.listFiles(new qw(this.f758ad))) == null || listFiles.length == 0)) {
                Thread thread = new Thread(new ad(listFiles, this.f758ad, this.qw, this.f759de, z, onFinishedListener));
                thread.setName("T7@ZeusLogDir1");
                thread.start();
                return true;
            }
        }
        return false;
    }

    public final byte[] yj(byte[] bArr, int i2, boolean z) {
        if (bArr == null || bArr.length <= 0 || i2 <= 0 || f757yj == null) {
            return null;
        }
        if (i2 > bArr.length) {
            i2 = bArr.length;
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        fe.fe.uk.qw qwVar = new fe.fe.uk.qw(f757yj);
        byte[] ad2 = z ? qwVar.ad(bArr2) : qwVar.qw(bArr2);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (z) {
            return ad2;
        }
        "decrypt upload file run time:  (ms)" + (currentTimeMillis2 - currentTimeMillis);
        return ad2;
    }

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public String[] f760ad;

        /* renamed from: i  reason: collision with root package name */
        public StringBuffer f761i = new StringBuffer("");

        /* renamed from: if  reason: not valid java name */
        public boolean f7if;

        /* renamed from: o  reason: collision with root package name */
        public String f762o;

        /* renamed from: pf  reason: collision with root package name */
        public String f763pf;

        /* renamed from: th  reason: collision with root package name */
        public OnFinishedListener f764th;

        /* renamed from: uk  reason: collision with root package name */
        public int f765uk = 0;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f766yj;

        public ad(String str, String str2, String str3, boolean z, boolean z2, OnFinishedListener onFinishedListener) {
            this.f760ad = new String[]{str};
            this.f766yj = z2;
            this.f764th = onFinishedListener;
            this.f762o = str2;
            this.f763pf = str3;
            this.f7if = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x00a3 A[SYNTHETIC, Splitter:B:42:0x00a3] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x00d6 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r14 = this;
                java.lang.String r0 = "crashlog"
                java.lang.String[] r1 = r14.f760ad
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x0007:
                if (r4 >= r2) goto L_0x00da
                r5 = r1[r4]
                r6 = 0
                r7 = 1
                java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x009d }
                r8.<init>(r5)     // Catch:{ Exception -> 0x009d }
                int r6 = r8.available()     // Catch:{ Exception -> 0x009c }
                java.lang.String r9 = r14.f763pf     // Catch:{ Exception -> 0x009c }
                if (r9 == 0) goto L_0x003e
                java.lang.String r9 = r14.f762o     // Catch:{ Exception -> 0x009c }
                boolean r9 = r9.equals(r0)     // Catch:{ Exception -> 0x009c }
                if (r9 != 0) goto L_0x003e
                java.lang.String r9 = r14.f763pf     // Catch:{ Exception -> 0x009c }
                byte[] r9 = r9.getBytes()     // Catch:{ Exception -> 0x009c }
                int r9 = r9.length     // Catch:{ Exception -> 0x009c }
                int r10 = r6 + r9
                byte[] r10 = new byte[r10]     // Catch:{ Exception -> 0x009c }
                java.lang.String r11 = r14.f763pf     // Catch:{ Exception -> 0x009c }
                byte[] r11 = r11.getBytes()     // Catch:{ Exception -> 0x009c }
                java.lang.String r12 = r14.f763pf     // Catch:{ Exception -> 0x009c }
                byte[] r12 = r12.getBytes()     // Catch:{ Exception -> 0x009c }
                int r12 = r12.length     // Catch:{ Exception -> 0x009c }
                java.lang.System.arraycopy(r11, r3, r10, r3, r12)     // Catch:{ Exception -> 0x009c }
                goto L_0x0041
            L_0x003e:
                byte[] r10 = new byte[r6]     // Catch:{ Exception -> 0x009c }
                r9 = 0
            L_0x0041:
                int r6 = r8.read(r10, r9, r6)     // Catch:{ Exception -> 0x009c }
                int r9 = r9 + r6
                int r6 = r8.available()     // Catch:{ Exception -> 0x009c }
                if (r6 > 0) goto L_0x0041
                boolean r6 = com.baidu.crashpad.ZeusLogUploader.when(r10)     // Catch:{ Exception -> 0x009c }
                java.lang.String r9 = r14.f762o     // Catch:{ Exception -> 0x0098 }
                boolean r9 = r9.equals(r0)     // Catch:{ Exception -> 0x0098 }
                if (r9 == 0) goto L_0x0069
                if (r6 == 0) goto L_0x0069
                com.baidu.crashpad.ZeusLogUploader r9 = com.baidu.crashpad.ZeusLogUploader.this     // Catch:{ Exception -> 0x0098 }
                int r11 = r10.length     // Catch:{ Exception -> 0x0098 }
                int r11 = r11 + -12
                byte[] r10 = r9.yj(r10, r11, r3)     // Catch:{ Exception -> 0x0098 }
                if (r10 != 0) goto L_0x0069
                r9 = 8
                r14.f765uk = r9     // Catch:{ Exception -> 0x0098 }
            L_0x0069:
                int r9 = r10.length     // Catch:{ Exception -> 0x0098 }
                java.lang.StringBuffer r11 = r14.f761i     // Catch:{ Exception -> 0x0098 }
                byte[] r9 = com.baidu.crashpad.ZeusLogUploader.rg(r10, r9, r11)     // Catch:{ Exception -> 0x0098 }
                if (r9 != 0) goto L_0x0075
                r14.f765uk = r7     // Catch:{ Exception -> 0x0098 }
                goto L_0x0094
            L_0x0075:
                java.lang.String r10 = r14.f762o     // Catch:{ Exception -> 0x0098 }
                boolean r11 = r14.f7if     // Catch:{ Exception -> 0x0098 }
                java.lang.StringBuffer r12 = r14.f761i     // Catch:{ Exception -> 0x0098 }
                boolean r9 = com.baidu.crashpad.ZeusLogUploader.uk(r9, r10, r11, r5, r12)     // Catch:{ Exception -> 0x0098 }
                if (r9 != 0) goto L_0x0085
                r9 = 3
                r14.f765uk = r9     // Catch:{ Exception -> 0x0098 }
                goto L_0x0094
            L_0x0085:
                boolean r9 = r14.f766yj     // Catch:{ Exception -> 0x0098 }
                if (r9 == 0) goto L_0x0094
                java.lang.StringBuffer r9 = r14.f761i     // Catch:{ Exception -> 0x0098 }
                boolean r9 = com.baidu.crashpad.ZeusLogUploader.th(r5, r9)     // Catch:{ Exception -> 0x0098 }
                if (r9 != 0) goto L_0x0094
                r9 = 4
                r14.f765uk = r9     // Catch:{ Exception -> 0x0098 }
            L_0x0094:
                r8.close()     // Catch:{ Exception -> 0x0098 }
                goto L_0x00a7
            L_0x0098:
                r13 = r8
                r8 = r6
                r6 = r13
                goto L_0x009e
            L_0x009c:
                r6 = r8
            L_0x009d:
                r8 = 0
            L_0x009e:
                r9 = 5
                r14.f765uk = r9
                if (r6 == 0) goto L_0x00a6
                r6.close()     // Catch:{ Exception -> 0x00a6 }
            L_0x00a6:
                r6 = r8
            L_0x00a7:
                boolean r8 = com.baidu.crashpad.ZeusLogUploader.f756th
                if (r8 == 0) goto L_0x00c7
                int r8 = r14.f765uk
                if (r8 == 0) goto L_0x00c7
                java.lang.String r8 = r14.f762o
                boolean r8 = r8.equals(r0)
                if (r8 == 0) goto L_0x00c7
                if (r6 != 0) goto L_0x00c7
                com.baidu.crashpad.ZeusLogUploader r6 = com.baidu.crashpad.ZeusLogUploader.this
                int r6 = r6.i(r5, r7)
                r7 = 6
                if (r6 == r7) goto L_0x00c7
                r6 = 2
                r14.f765uk = r6
            L_0x00c7:
                com.baidu.crashpad.ZeusLogUploader$OnFinishedListener r6 = r14.f764th
                if (r6 == 0) goto L_0x00d6
                int r7 = r14.f765uk
                java.lang.StringBuffer r8 = r14.f761i
                java.lang.String r8 = r8.toString()
                r6.onFinished(r5, r7, r8)
            L_0x00d6:
                int r4 = r4 + 1
                goto L_0x0007
            L_0x00da:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.crashpad.ZeusLogUploader.ad.run():void");
        }

        public ad(File[] fileArr, String str, String str2, boolean z, boolean z2, OnFinishedListener onFinishedListener) {
            this.f760ad = new String[fileArr.length];
            for (int i2 = 0; i2 < fileArr.length; i2++) {
                this.f760ad[i2] = fileArr[i2].getPath();
            }
            this.f766yj = z2;
            this.f764th = onFinishedListener;
            this.f762o = str;
            this.f763pf = str2;
            this.f7if = z;
        }
    }
}
