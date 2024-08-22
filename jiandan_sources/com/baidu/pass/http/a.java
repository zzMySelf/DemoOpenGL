package com.baidu.pass.http;

import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.pass.http.MultipartHashMap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class a {
    public static final String d = "HttpStack";
    public static final String e = "Set-Cookie";
    public static final char[] f = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static final String g = "User-Agent";
    public static final int h = 15000;
    public String a = "AgzTBLLDxWSdvY0AbyfzsK8KCwpuSV";
    public boolean b = false;
    public HttpRequestHandler c = null;

    /* renamed from: com.baidu.pass.http.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0035a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.baidu.pass.http.Method[] r0 = com.baidu.pass.http.Method.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.pass.http.Method r1 = com.baidu.pass.http.Method.GET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.pass.http.Method r1 = com.baidu.pass.http.Method.POST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.http.a.C0035a.<clinit>():void");
        }
    }

    private HttpURLConnection b(PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(passHttpParamDTO.url);
        if (TextUtils.isEmpty(passHttpParamDTO.proxyHost)) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(passHttpParamDTO.proxyHost, passHttpParamDTO.proxyPort)));
        }
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        return httpURLConnection;
    }

    public a a(HttpRequestHandler httpRequestHandler) {
        this.c = httpRequestHandler;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte[]} */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0073, code lost:
        if (r2 != null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007e, code lost:
        if (r2 == null) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.baidu.pass.http.PassHttpClientRequest r7) throws java.io.IOException, java.lang.IllegalArgumentException {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x00aa
            boolean r0 = r7.cancelRequest
            if (r0 == 0) goto L_0x0008
            goto L_0x00aa
        L_0x0008:
            r6.a()
            int[] r0 = com.baidu.pass.http.a.C0035a.a
            com.baidu.pass.http.Method r1 = r7.method
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0042
            r1 = 2
            if (r0 != r1) goto L_0x0029
            com.baidu.pass.http.PassHttpParamDTO r0 = r7.paramDTO
            java.net.HttpURLConnection r0 = r6.b(r0)
            com.baidu.pass.http.PassHttpParamDTO r1 = r7.paramDTO
            byte[] r1 = r6.a((java.net.HttpURLConnection) r0, (com.baidu.pass.http.PassHttpParamDTO) r1)
            goto L_0x0049
        L_0x0029:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.baidu.pass.http.Method r7 = r7.method
            r1.append(r7)
            java.lang.String r7 = " method not support"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x0042:
            com.baidu.pass.http.PassHttpParamDTO r0 = r7.paramDTO
            java.net.HttpURLConnection r0 = r6.a((com.baidu.pass.http.PassHttpParamDTO) r0)
            r1 = r2
        L_0x0049:
            com.baidu.pass.http.PassHttpParamDTO r3 = r7.paramDTO
            int r3 = r3.connectTimeout
            r6.a((java.net.HttpURLConnection) r0, (int) r3)
            com.baidu.pass.http.PassHttpParamDTO r3 = r7.paramDTO
            java.lang.String r3 = r3.userAgent
            r6.a((java.net.HttpURLConnection) r0, (java.lang.String) r3)
            com.baidu.pass.http.PassHttpParamDTO r3 = r7.paramDTO
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r3.headers
            r6.a((java.net.HttpURLConnection) r0, (java.util.HashMap<java.lang.String, java.lang.String>) r3)
            android.content.Context r3 = r7.context
            com.baidu.pass.http.PassHttpParamDTO r4 = r7.paramDTO
            com.baidu.pass.http.b.b(r3, r0, r4)
            if (r1 == 0) goto L_0x0083
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ Exception -> 0x007d, all -> 0x0076 }
            if (r2 == 0) goto L_0x0073
            r2.write(r1)     // Catch:{ Exception -> 0x007d, all -> 0x0076 }
            r2.flush()     // Catch:{ Exception -> 0x007d, all -> 0x0076 }
        L_0x0073:
            if (r2 == 0) goto L_0x0083
            goto L_0x0080
        L_0x0076:
            r7 = move-exception
            if (r2 == 0) goto L_0x007c
            r2.close()     // Catch:{ Exception -> 0x007c }
        L_0x007c:
            throw r7
        L_0x007d:
            if (r2 == 0) goto L_0x0083
        L_0x0080:
            r2.close()     // Catch:{ Exception -> 0x0083 }
        L_0x0083:
            java.io.InputStream r1 = r0.getInputStream()
            int r2 = r0.getResponseCode()
            java.util.HashMap r3 = r6.a((java.net.HttpURLConnection) r0)
            byte[] r4 = r6.a((java.io.InputStream) r1)
            r1.close()     // Catch:{ Exception -> 0x0097 }
            goto L_0x0098
        L_0x0097:
        L_0x0098:
            android.content.Context r1 = r7.context
            com.baidu.pass.http.PassHttpParamDTO r5 = r7.paramDTO
            com.baidu.pass.http.b.a(r1, r0, r5)
            boolean r0 = r7.cancelRequest
            if (r0 != 0) goto L_0x00aa
            com.baidu.pass.http.HttpResponseHandler r7 = r7.responseHandler
            if (r7 == 0) goto L_0x00aa
            r7.b(r2, r3, r4)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.http.a.a(com.baidu.pass.http.PassHttpClientRequest):void");
    }

    private void a(HttpURLConnection httpURLConnection, HashMap<String, String> hashMap) {
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public void a(HttpURLConnection httpURLConnection, String str) {
        if (!TextUtils.isEmpty(str)) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
    }

    private void a(HttpURLConnection httpURLConnection, int i2) {
        httpURLConnection.setConnectTimeout(i2 == 0 ? 15000 : i2);
        if (i2 == 0) {
            i2 = 15000;
        }
        httpURLConnection.setReadTimeout(i2);
    }

    private byte[] a(HttpURLConnection httpURLConnection, PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpHashMap httpHashMap = passHttpParamDTO.paramsMap;
        if (httpHashMap instanceof MultipartHashMap) {
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.a);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            HttpHashMap httpHashMap2 = passHttpParamDTO.paramsMap;
            if (httpHashMap2 != null) {
                for (Map.Entry entry : httpHashMap2.getMap().entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                        a(byteArrayOutputStream, URLEncoder.encode((String) entry.getKey(), "UTF-8"), URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                    }
                }
            }
            MultipartHashMap.a aVar = ((MultipartHashMap) passHttpParamDTO.paramsMap).fileWrapper;
            a(byteArrayOutputStream, aVar.a, aVar.b, aVar.d, aVar.c);
            a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (!(httpHashMap instanceof HttpHashMap)) {
            return null;
        } else {
            byte[] bytes = a(httpHashMap).getBytes("UTF-8");
            HttpRequestHandler httpRequestHandler = this.c;
            return httpRequestHandler != null ? httpRequestHandler.compress(bytes) : bytes;
        }
    }

    private HttpURLConnection a(PassHttpParamDTO passHttpParamDTO) throws IOException {
        HttpURLConnection httpURLConnection;
        String a2 = a(passHttpParamDTO.paramsMap);
        if (!TextUtils.isEmpty(a2)) {
            passHttpParamDTO.url += "?" + a2;
        }
        URL url = new URL(passHttpParamDTO.url);
        if (TextUtils.isEmpty(passHttpParamDTO.proxyHost)) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(passHttpParamDTO.proxyHost, passHttpParamDTO.proxyPort)));
        }
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0050=Splitter:B:29:0x0050, B:15:0x0036=Splitter:B:15:0x0036} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.io.InputStream r7) {
        /*
            r6 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r0.<init>(r7)
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream
            r7.<init>()
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream
            r1.<init>(r7)
            r2 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r2]
        L_0x0013:
            r3 = 0
            int r4 = r0.read(r2)     // Catch:{ IOException -> 0x003c }
            if (r4 <= 0) goto L_0x001f
            r5 = 0
            r1.write(r2, r5, r4)     // Catch:{ IOException -> 0x003c }
            goto L_0x0013
        L_0x001f:
            r1.flush()     // Catch:{ IOException -> 0x003c }
            byte[] r3 = r7.toByteArray()     // Catch:{ IOException -> 0x003c }
            r1.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x002e:
            r0.close()     // Catch:{ IOException -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0036:
            r7.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x003a:
            r2 = move-exception
            goto L_0x0059
        L_0x003c:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x003a }
            r1.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0048:
            r0.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0050:
            r7.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0058:
            return r3
        L_0x0059:
            r1.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0061:
            r0.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0069:
            r7.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0071:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.pass.http.a.a(java.io.InputStream):byte[]");
    }

    private HashMap<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap<String, String> hashMap = new HashMap<>();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i2 = 0; i2 < size; i2++) {
            String headerFieldKey = httpURLConnection.getHeaderFieldKey(i2);
            String headerField = httpURLConnection.getHeaderField(i2);
            if ("Set-Cookie".equals(headerFieldKey) && !TextUtils.isEmpty(headerField) && headerField.contains("=")) {
                headerFieldKey = headerField.substring(0, headerField.indexOf("="));
            }
            hashMap.put(headerFieldKey, headerField);
        }
        return hashMap;
    }

    private void a() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = f;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        this.a = sb.toString();
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i2 = 0; i2 < 30; i2++) {
            char[] cArr = f;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        byte[] bytes = ("\r\n--" + this.a + "\r\n").getBytes();
        if (!this.b) {
            this.b = true;
            byteArrayOutputStream.write(("--" + this.a + "\r\n").getBytes());
            return;
        }
        byteArrayOutputStream.write(bytes);
    }

    private void a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2) throws IOException {
        a(byteArrayOutputStream);
        byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
        byteArrayOutputStream.write(str2.getBytes());
    }

    private ByteArrayOutputStream a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2, InputStream inputStream, String str3) throws IOException {
        try {
            a(byteArrayOutputStream);
            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
            if (str3 != null) {
                byteArrayOutputStream.write(("Content-Type: " + str3 + "\r\n\r\n").getBytes());
            } else {
                byteArrayOutputStream.write("Content-Type: application/octet-stream\r\n\r\n".getBytes());
            }
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return byteArrayOutputStream;
        } catch (IOException e3) {
            throw e3;
        } catch (Throwable th2) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th2;
        }
    }

    private String a(HttpHashMap httpHashMap) {
        StringBuilder sb = new StringBuilder();
        if (!(httpHashMap == null || httpHashMap.getMap() == null)) {
            for (Map.Entry entry : httpHashMap.getMap().entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    try {
                        sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                        sb.append("=");
                        sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                        sb.append(com.alipay.sdk.m.s.a.n);
                    } catch (UnsupportedEncodingException e2) {
                        c.a(e2.getMessage());
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(sb)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
