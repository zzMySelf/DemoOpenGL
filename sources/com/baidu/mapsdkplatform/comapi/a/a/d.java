package com.baidu.mapsdkplatform.comapi.a.a;

import android.content.Context;
import android.os.Build;
import com.baidu.iknow.android.net.request.base.IRequest;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.SyncSysInfo;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.baidu.mapsdkplatform.comapi.util.h;
import com.baidu.mapsdkplatform.comjni.util.JNIHandler;
import com.baidu.mms.voicesearch.voice.utils.NetConfig;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.zip.GZIPOutputStream;

/* compiled from: NativeCrashUtil */
public class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f14815a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f14816b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f14817c = "";

    /* renamed from: d  reason: collision with root package name */
    private Context f14818d;

    /* compiled from: NativeCrashUtil */
    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f14819a = new d();
    }

    public static d c() {
        return a.f14819a;
    }

    private void d() {
        if (g.b().a() != null) {
            String a2 = g.b().a().a();
            if (!a2.isEmpty()) {
                String str = a2 + File.separator + "crash";
                File file = new File(str);
                if (file.exists()) {
                    f14815a = str;
                } else if (file.mkdir()) {
                    f14815a = str;
                } else {
                    f14815a = a2;
                }
            }
        }
    }

    private HttpURLConnection e() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.map.baidu.com/lbs_sdkcc/report").openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", IRequest.Body.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=bd_map_sdk_cc");
            httpURLConnection.setRequestProperty("Cache-Control", NetConfig.NO_CACHE);
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.setConnectTimeout(10000);
            return httpURLConnection;
        } catch (Exception e2) {
            return null;
        }
    }

    private void f() {
        String str;
        String str2 = f14815a;
        if (str2 != null && !str2.isEmpty() && (str = f14816b) != null && !str.isEmpty()) {
            String str3 = f14815a + File.separator + f14816b;
            b.a().a(str3);
            JNIHandler.registerNativeHandler(str3);
        }
    }

    private void g() {
        if (NetworkUtil.isNetworkAvailable(this.f14818d)) {
            new Thread(new c(this)).start();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e9, code lost:
        r10 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x013e A[SYNTHETIC, Splitter:B:106:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x014a A[SYNTHETIC, Splitter:B:114:0x014a] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x015d A[SYNTHETIC, Splitter:B:123:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e9 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:39:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012b A[SYNTHETIC, Splitter:B:97:0x012b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(java.io.File r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            r1 = 0
            java.net.HttpURLConnection r2 = r9.e()     // Catch:{ Exception -> 0x0144, all -> 0x0125 }
            if (r2 != 0) goto L_0x0015
            if (r2 == 0) goto L_0x0013
            r2.disconnect()     // Catch:{ Exception -> 0x0012 }
            goto L_0x0013
        L_0x000f:
            r10 = move-exception
            goto L_0x0161
        L_0x0012:
            r10 = move-exception
        L_0x0013:
            monitor-exit(r9)
            return r0
        L_0x0015:
            r2.connect()     // Catch:{ Exception -> 0x0121, all -> 0x011e }
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ Exception -> 0x0121, all -> 0x011e }
            java.lang.StringBuilder r4 = r9.a((java.io.File) r10)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            byte[] r4 = r9.a((byte[]) r4)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r3.write(r4)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r4.<init>()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.lang.String r5 = "--bd_map_sdk_cc"
            r4.append(r5)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.lang.String r5 = "\r\n"
            r4.append(r5)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.lang.String r5 = "Content-Disposition: form-data; name=\"file\"; filename=\"c.txt\"\r\n"
            r4.append(r5)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.lang.String r5 = "\r\n"
            r4.append(r5)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            byte[] r4 = r9.a((byte[]) r4)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r3.write(r4)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            long r5 = r10.length()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            int r5 = (int) r5     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.io.DataInputStream r5 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r6.<init>(r10)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
        L_0x006f:
            int r7 = r5.read(r6)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r8 = -1
            if (r7 == r8) goto L_0x007a
            r4.write(r6, r0, r7)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            goto L_0x006f
        L_0x007a:
            byte[] r6 = r4.toByteArray()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            byte[] r6 = r9.a((byte[]) r6)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r3.write(r6)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r5.close()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r4.close()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.lang.String r4 = "\r\n--bd_map_sdk_cc--\r\n"
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            byte[] r4 = r9.a((byte[]) r4)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r3.write(r4)     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r3.flush()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            int r4 = r2.getResponseCode()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L_0x00f6
            java.io.InputStream r4 = r2.getInputStream()     // Catch:{ Exception -> 0x0119, all -> 0x0114 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            r6.<init>(r4)     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00f1, all -> 0x00ed }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
            r1.<init>()     // Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
        L_0x00b6:
            int r6 = r5.read()     // Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
            if (r6 == r8) goto L_0x00c1
            char r6 = (char) r6     // Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
            r1.append(r6)     // Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
            goto L_0x00b6
        L_0x00c1:
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00eb, all -> 0x00e9 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00e6, all -> 0x00e9 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00e6, all -> 0x00e9 }
            java.lang.String r0 = "status"
            boolean r0 = r1.has(r0)     // Catch:{ Exception -> 0x00e6, all -> 0x00e9 }
            if (r0 == 0) goto L_0x00e7
            java.lang.String r0 = "status"
            int r0 = r1.getInt(r0)     // Catch:{ Exception -> 0x00e6, all -> 0x00e9 }
            if (r0 != 0) goto L_0x00e7
            boolean r0 = r10.exists()     // Catch:{ Exception -> 0x00e6, all -> 0x00e9 }
            if (r0 == 0) goto L_0x00e7
            r10.delete()     // Catch:{ Exception -> 0x00e6, all -> 0x00e9 }
            goto L_0x00e7
        L_0x00e6:
            r10 = move-exception
        L_0x00e7:
            r1 = r4
            goto L_0x00f7
        L_0x00e9:
            r10 = move-exception
            goto L_0x00ef
        L_0x00eb:
            r10 = move-exception
            goto L_0x00f3
        L_0x00ed:
            r10 = move-exception
            r5 = r1
        L_0x00ef:
            r1 = r3
            goto L_0x0129
        L_0x00f1:
            r10 = move-exception
            r5 = r1
        L_0x00f3:
            r1 = r3
            goto L_0x0148
        L_0x00f6:
            r5 = r1
        L_0x00f7:
            if (r3 == 0) goto L_0x00fe
            r3.close()     // Catch:{ Exception -> 0x00fd }
            goto L_0x00fe
        L_0x00fd:
            r10 = move-exception
        L_0x00fe:
            if (r1 == 0) goto L_0x010a
            if (r5 == 0) goto L_0x010a
            r1.close()     // Catch:{ Exception -> 0x0109 }
            r5.close()     // Catch:{ Exception -> 0x0109 }
            goto L_0x010a
        L_0x0109:
            r10 = move-exception
        L_0x010a:
            if (r2 == 0) goto L_0x0111
            r2.disconnect()     // Catch:{ Exception -> 0x0110 }
            goto L_0x0111
        L_0x0110:
            r10 = move-exception
        L_0x0111:
            r10 = 1
            monitor-exit(r9)
            return r10
        L_0x0114:
            r10 = move-exception
            r4 = r1
            r5 = r4
            r1 = r3
            goto L_0x0129
        L_0x0119:
            r10 = move-exception
            r4 = r1
            r5 = r4
            r1 = r3
            goto L_0x0148
        L_0x011e:
            r10 = move-exception
            r4 = r1
            goto L_0x0128
        L_0x0121:
            r10 = move-exception
            r4 = r1
            r5 = r4
            goto L_0x0148
        L_0x0125:
            r10 = move-exception
            r2 = r1
            r4 = r2
        L_0x0128:
            r5 = r4
        L_0x0129:
            if (r1 == 0) goto L_0x0130
            r1.close()     // Catch:{ Exception -> 0x012f }
            goto L_0x0130
        L_0x012f:
            r0 = move-exception
        L_0x0130:
            if (r4 == 0) goto L_0x013c
            if (r5 == 0) goto L_0x013c
            r4.close()     // Catch:{ Exception -> 0x013b }
            r5.close()     // Catch:{ Exception -> 0x013b }
            goto L_0x013c
        L_0x013b:
            r0 = move-exception
        L_0x013c:
            if (r2 == 0) goto L_0x0143
            r2.disconnect()     // Catch:{ Exception -> 0x0142 }
            goto L_0x0143
        L_0x0142:
            r0 = move-exception
        L_0x0143:
            throw r10     // Catch:{ all -> 0x000f }
        L_0x0144:
            r10 = move-exception
            r2 = r1
            r4 = r2
            r5 = r4
        L_0x0148:
            if (r1 == 0) goto L_0x014f
            r1.close()     // Catch:{ Exception -> 0x014e }
            goto L_0x014f
        L_0x014e:
            r10 = move-exception
        L_0x014f:
            if (r4 == 0) goto L_0x015b
            if (r5 == 0) goto L_0x015b
            r4.close()     // Catch:{ Exception -> 0x015a }
            r5.close()     // Catch:{ Exception -> 0x015a }
            goto L_0x015b
        L_0x015a:
            r10 = move-exception
        L_0x015b:
            if (r2 == 0) goto L_0x0164
            r2.disconnect()     // Catch:{ Exception -> 0x0163 }
            goto L_0x0164
        L_0x0161:
            monitor-exit(r9)
            throw r10
        L_0x0163:
            r10 = move-exception
        L_0x0164:
            monitor-exit(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapsdkplatform.comapi.a.a.d.b(java.io.File):boolean");
    }

    public void a(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr.length > 0) {
                f14817c = strArr[0];
            }
            this.f14818d = context;
            String g2 = h.g();
            if (!g2.isEmpty()) {
                if (g2.contains("_")) {
                    g2 = g2.replaceAll("_", "");
                }
                f14816b = g2 + "_" + h.n() + "_";
                d();
                f();
                g();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(File[] fileArr) {
        int length = fileArr.length;
        for (int i2 = 0; i2 < length - 10; i2++) {
            int i3 = i2 + 10;
            File file = fileArr[i3];
            if (file != null && file.exists()) {
                fileArr[i3].delete();
            }
        }
    }

    private StringBuilder a(File file) {
        String[] split = file.getName().substring(0, file.getName().length() - 4).split("_");
        StringBuilder sb = new StringBuilder();
        sb.append("--bd_map_sdk_cc");
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"phoneinfo\"\r\n");
        sb.append("\r\n");
        sb.append(URLDecoder.decode(SyncSysInfo.getPhoneInfo() + "&abi=" + f14817c));
        sb.append("\r\n");
        sb.append("--bd_map_sdk_cc");
        sb.append("\r\n");
        String str = split[0];
        if (str != null && !str.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"packname\"\r\n");
            sb.append("\r\n");
            sb.append(split[0]);
            sb.append("\r\n");
            sb.append("--bd_map_sdk_cc");
            sb.append("\r\n");
        }
        String str2 = split[1];
        if (str2 != null && !str2.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"version\"\r\n");
            sb.append("\r\n");
            sb.append(split[1]);
            sb.append("\r\n");
            sb.append("--bd_map_sdk_cc");
            sb.append("\r\n");
        }
        String str3 = split[2];
        if (str3 != null && !str3.isEmpty()) {
            sb.append("Content-Disposition: form-data; name=\"timestamp\"\r\n");
            sb.append("\r\n");
            sb.append(split[2]);
            sb.append("\r\n");
            sb.append("--bd_map_sdk_cc");
            sb.append("\r\n");
        }
        sb.append("Content-Disposition: form-data; name=\"os\"\r\n");
        sb.append("\r\n");
        sb.append("android");
        sb.append("\r\n");
        sb.append("--bd_map_sdk_cc");
        sb.append("\r\n");
        return sb;
    }

    private byte[] a(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        a((InputStream) byteArrayInputStream, (OutputStream) byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                try {
                    outputStream.close();
                    inputStream.close();
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
        }
    }
}
