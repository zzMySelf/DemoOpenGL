package com.dlife.ctaccountapi;

import android.content.Context;
import android.text.TextUtils;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class l {
    public static final String a = "l";

    public static class a implements HostnameVerifier {
        public boolean verify(String str, SSLSession sSLSession) {
            HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
            return defaultHostnameVerifier.verify("id6.me", sSLSession) || defaultHostnameVerifier.verify("card.e.189.cn", sSLSession);
        }
    }

    public static k a(Context context, HttpURLConnection httpURLConnection) {
        String str;
        k kVar = new k();
        try {
            Map headerFields = httpURLConnection.getHeaderFields();
            List list = (List) headerFields.get("Log-Level");
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    String str2 = (String) list.get(0);
                    if (!TextUtils.isEmpty(str2)) {
                        e.a(context, str2);
                    }
                }
            }
            List list2 = (List) headerFields.get("dm");
            if (list2 != null && !list2.isEmpty() && (str = (String) list2.get(0)) != null && (str.equals("1") || str.equals("2"))) {
                String g = n.g(context);
                if (!TextUtils.isEmpty(g) && !g.equals(str)) {
                    kVar.b = true;
                }
            }
            List list3 = (List) headerFields.get("p-ikgx");
            if (list3 != null && !list3.isEmpty()) {
                String str3 = (String) list3.get(0);
                if (!TextUtils.isEmpty(str3)) {
                    kVar.a = str3;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return kVar;
    }

    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r10v8 */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r10v24 */
    /* JADX WARNING: type inference failed for: r1v50 */
    /* JADX WARNING: type inference failed for: r10v41 */
    /* JADX WARNING: type inference failed for: r10v43 */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0283, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0284, code lost:
        r11 = r19;
        r10 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02b5, code lost:
        r0 = e;
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02b7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02bb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02bc, code lost:
        r8 = r29;
        r11 = r19;
        r10 = r20;
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02c5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x030f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0310, code lost:
        r7 = r23;
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        r2 = r0;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x032b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x032e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0331, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0334, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        r2 = r0;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x034e, code lost:
        if (r1 != null) goto L_0x04d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0355, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0356, code lost:
        r7 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0359, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x035a, code lost:
        r7 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x035e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x035f, code lost:
        r8 = r29;
        r11 = r19;
        r10 = r20;
        r9 = r22;
        r7 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0372, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0373, code lost:
        r8 = r29;
        r7 = r13;
        r11 = r19;
        r10 = r20;
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0382, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r8 = r2;
        r9 = "card.e.189.cn";
        r7 = r13;
        r1 = null;
        r11 = r19;
        r10 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0383, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x038c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x038d, code lost:
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x038e, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x038f, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x03d0, code lost:
        if (r1 != null) goto L_0x04d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x03d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x03d5, code lost:
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x03d6, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x03d7, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0418, code lost:
        if (r1 != null) goto L_0x04d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0420, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0421, code lost:
        r8 = r2;
        r11 = "2";
        r7 = r13;
        r10 = "1";
        r9 = "card.e.189.cn";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r3 = r0;
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        r7.a = "{\"result\":80006,\"msg\":\"域名解析异常\"}";
        cn.com.chinatelecom.gateway.lib.CtAuth.warn(a, "sendRequest UnknownHostException-preauth-" + r2.getMessage(), r2);
        com.dlife.ctaccountapi.e.a(r33).a("doPost UnknownHostException -- " + r2.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x046e, code lost:
        r7.c = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0471, code lost:
        r7.c = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0480, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0488, code lost:
        if (r1 == null) goto L_0x04d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x048b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x048c, code lost:
        r7 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x048d, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:?, code lost:
        r16.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x04d1, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x04d2, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0188, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0189, code lost:
        r8 = r29;
        r2 = r0;
        r7 = r13;
        r1 = null;
        r11 = r19;
        r10 = r20;
        r9 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02b7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:119:0x0254] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02b9 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:119:0x0254] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02c5 A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:119:0x0254] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046 A[ExcHandler: all (r0v59 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:12:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x032b A[Catch:{ SocketTimeoutException -> 0x0352, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }, ExcHandler: all (th java.lang.Throwable), Splitter:B:182:0x0323] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b A[ExcHandler: IOException (r0v58 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:12:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x032e A[Catch:{ SocketTimeoutException -> 0x0352, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }, ExcHandler: IOException (e java.io.IOException), Splitter:B:182:0x0323] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0331 A[Catch:{ SocketTimeoutException -> 0x0352, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }, ExcHandler: UnknownHostException (e java.net.UnknownHostException), Splitter:B:182:0x0323] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x034b A[SYNTHETIC, Splitter:B:203:0x034b] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0355 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:75:0x019c] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0359 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:75:0x019c] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x035e A[ExcHandler: UnknownHostException (e java.net.UnknownHostException), Splitter:B:75:0x019c] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x038c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:7:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x03cd A[SYNTHETIC, Splitter:B:230:0x03cd] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x03d4 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:7:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d A[ExcHandler: SocketTimeoutException (r0v55 'e' java.net.SocketTimeoutException A[CUSTOM_DECLARE]), Splitter:B:12:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0415 A[SYNTHETIC, Splitter:B:241:0x0415] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x042e  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x046e A[Catch:{ all -> 0x041c }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0471 A[Catch:{ all -> 0x041c }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0478 A[SYNTHETIC, Splitter:B:259:0x0478] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0480 A[Catch:{ all -> 0x047c }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0485 A[SYNTHETIC, Splitter:B:266:0x0485] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x048b A[ExcHandler: SocketTimeoutException (e java.net.SocketTimeoutException), Splitter:B:7:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04cc A[SYNTHETIC, Splitter:B:276:0x04cc] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x04d1 A[Catch:{ all -> 0x04d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x04dc A[SYNTHETIC, Splitter:B:286:0x04dc] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x04e1 A[Catch:{ all -> 0x04e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab A[SYNTHETIC, Splitter:B:41:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e6 A[SYNTHETIC, Splitter:B:53:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015c A[Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0161 A[Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0206  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.dlife.ctaccountapi.p a(android.content.Context r28, java.lang.String r29, java.lang.String r30, android.net.Network r31, java.lang.String r32, java.lang.String r33, boolean r34) {
        /*
            r1 = r28
            r2 = r29
            r3 = r31
            java.lang.String r4 = "POST"
            java.lang.String r5 = "{\"result\":80005,\"msg\":\"Socket超时异常\"}"
            java.lang.String r6 = "Accept-Charset"
            java.lang.String r7 = "*/*"
            java.lang.String r8 = "accept"
            java.lang.String r9 = "1"
            java.lang.String r10 = "card.e.189.cn"
            java.lang.String r11 = "UTF-8"
            java.lang.String r12 = "2"
            com.dlife.ctaccountapi.p r13 = new com.dlife.ctaccountapi.p
            r13.<init>()
            int r14 = cn.com.chinatelecom.gateway.lib.CtAuth.mConnTimeoutL
            r15 = 3000(0xbb8, float:4.204E-42)
            if (r14 > 0) goto L_0x0025
            r14 = 3000(0xbb8, float:4.204E-42)
        L_0x0025:
            int r16 = cn.com.chinatelecom.gateway.lib.CtAuth.mReadTimeout
            if (r16 > 0) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r15 = r16
        L_0x002c:
            r16 = 0
            r17 = r5
            java.net.URL r5 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0420, IOException -> 0x03d4, all -> 0x038c }
            r5.<init>(r2)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0420, IOException -> 0x03d4, all -> 0x038c }
            r19 = r12
            r12 = 21
            if (r3 == 0) goto L_0x0066
            r20 = r9
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0050, IOException -> 0x004b, all -> 0x0046 }
            if (r9 < r12) goto L_0x0068
            java.net.URLConnection r5 = r3.openConnection(r5)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0050, IOException -> 0x004b, all -> 0x0046 }
            goto L_0x006c
        L_0x0046:
            r0 = move-exception
            r2 = r0
            r7 = r13
            goto L_0x038f
        L_0x004b:
            r0 = move-exception
            r2 = r0
            r7 = r13
            goto L_0x03d7
        L_0x0050:
            r0 = move-exception
            r8 = r2
            r9 = r10
            r7 = r13
            r1 = r16
            r11 = r19
            r10 = r20
        L_0x005a:
            r2 = r0
            goto L_0x042c
        L_0x005d:
            r0 = move-exception
            r3 = r0
            r7 = r13
        L_0x0060:
            r2 = r16
        L_0x0062:
            r1 = r17
            goto L_0x0492
        L_0x0066:
            r20 = r9
        L_0x0068:
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
        L_0x006c:
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            r5.setRequestProperty(r8, r7)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            r5.setRequestMethod(r4)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            r9 = 1
            r5.setDoOutput(r9)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            r5.setDoInput(r9)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            r5.setConnectTimeout(r14)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            r5.setReadTimeout(r15)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            r9 = 0
            r5.setUseCaches(r9)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            javax.net.ssl.HostnameVerifier r9 = a()     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            r5.setHostnameVerifier(r9)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            if (r9 >= r12) goto L_0x0094
            r12 = 0
            r5.setInstanceFollowRedirects(r12)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0050, IOException -> 0x004b, all -> 0x0046 }
        L_0x0094:
            r5.addRequestProperty(r6, r11)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0382, IOException -> 0x03d4, all -> 0x038c }
            java.lang.String r12 = "deviceId"
            r2 = r32
            r5.addRequestProperty(r12, r2)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x037e, IOException -> 0x03d4, all -> 0x038c }
            java.lang.String r2 = "reqId"
            r12 = r33
            r5.addRequestProperty(r2, r12)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x037e, IOException -> 0x03d4, all -> 0x038c }
            boolean r2 = android.text.TextUtils.isEmpty(r30)     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x037e, IOException -> 0x03d4, all -> 0x038c }
            if (r2 != 0) goto L_0x00d9
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x00cb, IOException -> 0x004b, all -> 0x0046 }
            java.io.BufferedOutputStream r12 = new java.io.BufferedOutputStream     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x00cb, IOException -> 0x004b, all -> 0x0046 }
            r22 = r10
            java.io.OutputStream r10 = r5.getOutputStream()     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            r12.<init>(r10)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            r2.<init>(r12)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            r10 = r30
            byte[] r10 = r10.getBytes(r11)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            r2.write(r10)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            r2.flush()     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            r2.close()     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            goto L_0x00de
        L_0x00cb:
            r0 = move-exception
            r8 = r29
            r2 = r0
            r9 = r10
            r7 = r13
            r1 = r16
            r11 = r19
            r10 = r20
            goto L_0x042c
        L_0x00d9:
            r22 = r10
            r5.connect()     // Catch:{ SocketTimeoutException -> 0x048b, UnknownHostException -> 0x0372, IOException -> 0x03d4, all -> 0x038c }
        L_0x00de:
            java.lang.String r2 = "Location"
            r10 = 302(0x12e, float:4.23E-43)
            r12 = 21
            if (r9 >= r12) goto L_0x0197
            int r12 = r5.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            if (r12 != r10) goto L_0x0197
            java.lang.String r5 = r5.getHeaderField(r2)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            boolean r12 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            if (r12 != 0) goto L_0x014b
            java.lang.String r12 = "connectivity"
            java.lang.Object r12 = r1.getSystemService(r12)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            android.net.ConnectivityManager r12 = (android.net.ConnectivityManager) r12     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            r10 = 5
            android.net.NetworkInfo r23 = r12.getNetworkInfo(r10)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            android.net.NetworkInfo$State r10 = r23.getState()     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.CONNECTED     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            int r1 = r10.compareTo(r1)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            if (r1 != 0) goto L_0x014b
            java.lang.String r1 = com.dlife.ctaccountapi.m.a((java.lang.String) r5)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            int r1 = com.dlife.ctaccountapi.m.b((java.lang.String) r1)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            java.lang.String r10 = "android.net.ConnectivityManager"
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch:{ SocketTimeoutException -> 0x005d, UnknownHostException -> 0x0188, IOException -> 0x004b, all -> 0x0046 }
            r23 = r13
            java.lang.String r13 = "requestRouteToHost"
            r24 = r2
            r2 = 2
            r25 = r6
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            java.lang.Class r26 = java.lang.Integer.TYPE     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r21 = 0
            r6[r21] = r26     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r18 = 1
            r6[r18] = r26     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            java.lang.reflect.Method r6 = r10.getMethod(r13, r6)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r10 = 5
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r13 = 0
            r2[r13] = r10     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r10 = 1
            r2[r10] = r1     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r6.invoke(r12, r2)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            goto L_0x0151
        L_0x014b:
            r24 = r2
            r25 = r6
            r23 = r13
        L_0x0151:
            java.net.URL r1 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r1.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            if (r3 == 0) goto L_0x0161
            r2 = 21
            if (r9 < r2) goto L_0x0161
            java.net.URLConnection r1 = r3.openConnection(r1)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            goto L_0x0165
        L_0x0161:
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
        L_0x0165:
            r5 = r1
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r5.setRequestProperty(r8, r7)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r5.setRequestMethod(r4)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r1 = 1
            r5.setDoOutput(r1)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r5.setDoInput(r1)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r5.setConnectTimeout(r14)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r5.setReadTimeout(r15)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r1 = 0
            r5.setUseCaches(r1)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r1 = r25
            r5.addRequestProperty(r1, r11)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r5.connect()     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            goto L_0x019c
        L_0x0188:
            r0 = move-exception
            r8 = r29
            r2 = r0
            r7 = r13
            r1 = r16
            r11 = r19
            r10 = r20
            r9 = r22
            goto L_0x042c
        L_0x0197:
            r24 = r2
            r1 = r6
            r23 = r13
        L_0x019c:
            int r2 = r5.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x036b, UnknownHostException -> 0x035e, IOException -> 0x0359, all -> 0x0355 }
            r4 = 302(0x12e, float:4.23E-43)
            if (r2 != r4) goto L_0x0206
            r2 = r24
            java.lang.String r2 = r5.getHeaderField(r2)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            java.net.URL r4 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r4.<init>(r2)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            if (r3 == 0) goto L_0x01ba
            r2 = 21
            if (r9 < r2) goto L_0x01ba
            java.net.URLConnection r2 = r3.openConnection(r4)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            goto L_0x01be
        L_0x01ba:
            java.net.URLConnection r2 = r4.openConnection()     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
        L_0x01be:
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r2.setRequestProperty(r8, r7)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            java.lang.String r3 = "GET"
            r2.setRequestMethod(r3)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r2.setConnectTimeout(r14)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r2.setReadTimeout(r15)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r3 = 0
            r2.setUseCaches(r3)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r2.addRequestProperty(r1, r11)     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r2.connect()     // Catch:{ SocketTimeoutException -> 0x01fc, UnknownHostException -> 0x01ec, IOException -> 0x01e4, all -> 0x01dc }
            r7 = r23
            goto L_0x0347
        L_0x01dc:
            r0 = move-exception
            r2 = r0
            r1 = r16
            r7 = r23
            goto L_0x0391
        L_0x01e4:
            r0 = move-exception
            r2 = r0
            r1 = r16
            r7 = r23
            goto L_0x03d9
        L_0x01ec:
            r0 = move-exception
            r8 = r29
            r2 = r0
            r1 = r16
            r11 = r19
            r10 = r20
            r9 = r22
            r7 = r23
            goto L_0x042c
        L_0x01fc:
            r0 = move-exception
            r3 = r0
            r2 = r16
            r1 = r17
            r7 = r23
            goto L_0x0492
        L_0x0206:
            r1 = 200(0xc8, float:2.8E-43)
            r3 = 0
            if (r2 != r1) goto L_0x0315
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ SocketTimeoutException -> 0x030f, UnknownHostException -> 0x035e, IOException -> 0x0359, all -> 0x0355 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0308, UnknownHostException -> 0x02fb, IOException -> 0x02f5, all -> 0x02ef }
            r2.<init>()     // Catch:{ SocketTimeoutException -> 0x0308, UnknownHostException -> 0x02fb, IOException -> 0x02f5, all -> 0x02ef }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ SocketTimeoutException -> 0x0308, UnknownHostException -> 0x02fb, IOException -> 0x02f5, all -> 0x02ef }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ SocketTimeoutException -> 0x0308, UnknownHostException -> 0x02fb, IOException -> 0x02f5, all -> 0x02ef }
            r7.<init>(r1)     // Catch:{ SocketTimeoutException -> 0x0308, UnknownHostException -> 0x02fb, IOException -> 0x02f5, all -> 0x02ef }
            r6.<init>(r7)     // Catch:{ SocketTimeoutException -> 0x0308, UnknownHostException -> 0x02fb, IOException -> 0x02f5, all -> 0x02ef }
        L_0x021f:
            java.lang.String r7 = r6.readLine()     // Catch:{ SocketTimeoutException -> 0x02e7, UnknownHostException -> 0x02d7, IOException -> 0x02cf, all -> 0x02c7 }
            if (r7 == 0) goto L_0x024e
            r2.append(r7)     // Catch:{ SocketTimeoutException -> 0x0248, UnknownHostException -> 0x023a, IOException -> 0x0234, all -> 0x022e }
            java.lang.String r7 = "\n"
            r2.append(r7)     // Catch:{ SocketTimeoutException -> 0x0248, UnknownHostException -> 0x023a, IOException -> 0x0234, all -> 0x022e }
            goto L_0x021f
        L_0x022e:
            r0 = move-exception
            r2 = r0
            r7 = r23
            goto L_0x02cb
        L_0x0234:
            r0 = move-exception
            r2 = r0
            r7 = r23
            goto L_0x02d3
        L_0x023a:
            r0 = move-exception
            r8 = r29
            r2 = r0
            r11 = r19
            r10 = r20
            r9 = r22
            r7 = r23
            goto L_0x02e3
        L_0x0248:
            r0 = move-exception
            r2 = r0
            r7 = r23
            goto L_0x02eb
        L_0x024e:
            java.lang.String r2 = r2.toString()     // Catch:{ SocketTimeoutException -> 0x02e7, UnknownHostException -> 0x02d7, IOException -> 0x02cf, all -> 0x02c7 }
            r7 = r23
            r7.a = r2     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02bb, IOException -> 0x02b9, all -> 0x02b7 }
            r2 = r28
            com.dlife.ctaccountapi.k r5 = a(r2, r5)     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02bb, IOException -> 0x02b9, all -> 0x02b7 }
            boolean r8 = r5.b     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02bb, IOException -> 0x02b9, all -> 0x02b7 }
            if (r8 == 0) goto L_0x028a
            if (r34 == 0) goto L_0x028a
            r8 = r29
            r9 = r22
            boolean r10 = r8.contains(r9)     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x0283, IOException -> 0x02b9, all -> 0x02b7 }
            if (r10 == 0) goto L_0x0279
            r10 = r20
            r7.c = r10     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x0273, IOException -> 0x02b9, all -> 0x02b7 }
            r11 = r19
            goto L_0x027f
        L_0x0273:
            r0 = move-exception
            r2 = r0
            r11 = r19
            goto L_0x02e3
        L_0x0279:
            r10 = r20
            r11 = r19
            r7.c = r11     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
        L_0x027f:
            r12 = 1
            r7.b = r12     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
            goto L_0x0292
        L_0x0283:
            r0 = move-exception
            r11 = r19
            r10 = r20
            goto L_0x02e2
        L_0x028a:
            r8 = r29
            r11 = r19
            r10 = r20
            r9 = r22
        L_0x0292:
            java.lang.String r5 = r5.a     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
            com.dlife.ctaccountapi.b r12 = com.dlife.ctaccountapi.e.a((java.lang.String) r33)     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
            r12.h(r5)     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
            if (r34 != 0) goto L_0x02b1
            java.lang.String r5 = "id6.me"
            boolean r5 = r8.contains(r5)     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
            if (r5 == 0) goto L_0x02a9
        L_0x02a5:
            com.dlife.ctaccountapi.n.a((android.content.Context) r2, (long) r3)     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
            goto L_0x02b1
        L_0x02a9:
            com.dlife.ctaccountapi.n.a((android.content.Context) r2, (java.lang.String) r11)     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ SocketTimeoutException -> 0x02c5, UnknownHostException -> 0x02b5, IOException -> 0x02b9, all -> 0x02b7 }
            goto L_0x02a5
        L_0x02b1:
            r16 = r6
            goto L_0x0349
        L_0x02b5:
            r0 = move-exception
            goto L_0x02e2
        L_0x02b7:
            r0 = move-exception
            goto L_0x02ca
        L_0x02b9:
            r0 = move-exception
            goto L_0x02d2
        L_0x02bb:
            r0 = move-exception
            r8 = r29
            r11 = r19
            r10 = r20
            r9 = r22
            goto L_0x02e2
        L_0x02c5:
            r0 = move-exception
            goto L_0x02ea
        L_0x02c7:
            r0 = move-exception
            r7 = r23
        L_0x02ca:
            r2 = r0
        L_0x02cb:
            r16 = r6
            goto L_0x0391
        L_0x02cf:
            r0 = move-exception
            r7 = r23
        L_0x02d2:
            r2 = r0
        L_0x02d3:
            r16 = r6
            goto L_0x03d9
        L_0x02d7:
            r0 = move-exception
            r8 = r29
            r11 = r19
            r10 = r20
            r9 = r22
            r7 = r23
        L_0x02e2:
            r2 = r0
        L_0x02e3:
            r16 = r6
            goto L_0x042c
        L_0x02e7:
            r0 = move-exception
            r7 = r23
        L_0x02ea:
            r2 = r0
        L_0x02eb:
            r3 = r2
            r16 = r6
            goto L_0x030c
        L_0x02ef:
            r0 = move-exception
            r7 = r23
            r2 = r0
            goto L_0x0391
        L_0x02f5:
            r0 = move-exception
            r7 = r23
            r2 = r0
            goto L_0x03d9
        L_0x02fb:
            r0 = move-exception
            r8 = r29
            r11 = r19
            r10 = r20
            r9 = r22
            r7 = r23
            goto L_0x005a
        L_0x0308:
            r0 = move-exception
            r7 = r23
            r3 = r0
        L_0x030c:
            r2 = r1
            goto L_0x0062
        L_0x030f:
            r0 = move-exception
            r7 = r23
            r3 = r0
            goto L_0x0060
        L_0x0315:
            r2 = r28
            r8 = r29
            r11 = r19
            r10 = r20
            r9 = r22
            r7 = r23
            if (r34 != 0) goto L_0x0337
            com.dlife.ctaccountapi.n.a((android.content.Context) r2, (long) r3)     // Catch:{ SocketTimeoutException -> 0x0334, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }
            r1 = r17
            r7.a = r1     // Catch:{ SocketTimeoutException -> 0x0352, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }
            return r7
        L_0x032b:
            r0 = move-exception
            goto L_0x038e
        L_0x032e:
            r0 = move-exception
            goto L_0x03d6
        L_0x0331:
            r0 = move-exception
            goto L_0x0429
        L_0x0334:
            r0 = move-exception
            goto L_0x048d
        L_0x0337:
            r1 = r17
            boolean r2 = r8.contains(r9)     // Catch:{ SocketTimeoutException -> 0x0352, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }
            if (r2 == 0) goto L_0x0342
            r7.c = r10     // Catch:{ SocketTimeoutException -> 0x0352, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }
            goto L_0x0344
        L_0x0342:
            r7.c = r11     // Catch:{ SocketTimeoutException -> 0x0352, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }
        L_0x0344:
            r2 = 1
            r7.b = r2     // Catch:{ SocketTimeoutException -> 0x0352, UnknownHostException -> 0x0331, IOException -> 0x032e, all -> 0x032b }
        L_0x0347:
            r1 = r16
        L_0x0349:
            if (r16 == 0) goto L_0x034e
            r16.close()     // Catch:{ all -> 0x04d5 }
        L_0x034e:
            if (r1 == 0) goto L_0x04d5
            goto L_0x04d2
        L_0x0352:
            r0 = move-exception
            goto L_0x048f
        L_0x0355:
            r0 = move-exception
            r7 = r23
            goto L_0x038e
        L_0x0359:
            r0 = move-exception
            r7 = r23
            goto L_0x03d6
        L_0x035e:
            r0 = move-exception
            r8 = r29
            r11 = r19
            r10 = r20
            r9 = r22
            r7 = r23
            goto L_0x0429
        L_0x036b:
            r0 = move-exception
            r1 = r17
            r7 = r23
            goto L_0x048f
        L_0x0372:
            r0 = move-exception
            r8 = r29
            r7 = r13
            r11 = r19
            r10 = r20
            r9 = r22
            goto L_0x0429
        L_0x037e:
            r0 = move-exception
            r8 = r29
            goto L_0x0384
        L_0x0382:
            r0 = move-exception
            r8 = r2
        L_0x0384:
            r9 = r10
            r7 = r13
            r11 = r19
            r10 = r20
            goto L_0x0429
        L_0x038c:
            r0 = move-exception
            r7 = r13
        L_0x038e:
            r2 = r0
        L_0x038f:
            r1 = r16
        L_0x0391:
            java.lang.String r3 = "{\"result\":80001,\"msg\":\"请求异常\"}"
            r7.a = r3     // Catch:{ all -> 0x041c }
            java.lang.String r3 = a     // Catch:{ all -> 0x041c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x041c }
            r4.<init>()     // Catch:{ all -> 0x041c }
            java.lang.String r5 = "sendRequest Throwable-preauth-"
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r5 = r2.getMessage()     // Catch:{ all -> 0x041c }
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x041c }
            cn.com.chinatelecom.gateway.lib.CtAuth.warn(r3, r4, r2)     // Catch:{ all -> 0x041c }
            com.dlife.ctaccountapi.b r3 = com.dlife.ctaccountapi.e.a((java.lang.String) r33)     // Catch:{ all -> 0x041c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x041c }
            r4.<init>()     // Catch:{ all -> 0x041c }
            java.lang.String r5 = "doPost Throwable -- "
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x041c }
            r4.append(r2)     // Catch:{ all -> 0x041c }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x041c }
            r3.a((java.lang.String) r2)     // Catch:{ all -> 0x041c }
            if (r16 == 0) goto L_0x03d0
            r16.close()     // Catch:{ all -> 0x04d5 }
        L_0x03d0:
            if (r1 == 0) goto L_0x04d5
            goto L_0x04d2
        L_0x03d4:
            r0 = move-exception
            r7 = r13
        L_0x03d6:
            r2 = r0
        L_0x03d7:
            r1 = r16
        L_0x03d9:
            java.lang.String r3 = "{\"result\":80007,\"msg\":\"IO异常\"}"
            r7.a = r3     // Catch:{ all -> 0x041c }
            java.lang.String r3 = a     // Catch:{ all -> 0x041c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x041c }
            r4.<init>()     // Catch:{ all -> 0x041c }
            java.lang.String r5 = "sendRequest IOException-preauth-"
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r5 = r2.getMessage()     // Catch:{ all -> 0x041c }
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x041c }
            cn.com.chinatelecom.gateway.lib.CtAuth.warn(r3, r4, r2)     // Catch:{ all -> 0x041c }
            com.dlife.ctaccountapi.b r3 = com.dlife.ctaccountapi.e.a((java.lang.String) r33)     // Catch:{ all -> 0x041c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x041c }
            r4.<init>()     // Catch:{ all -> 0x041c }
            java.lang.String r5 = "doPost IOException -- "
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x041c }
            r4.append(r2)     // Catch:{ all -> 0x041c }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x041c }
            r3.a((java.lang.String) r2)     // Catch:{ all -> 0x041c }
            if (r16 == 0) goto L_0x0418
            r16.close()     // Catch:{ all -> 0x04d5 }
        L_0x0418:
            if (r1 == 0) goto L_0x04d5
            goto L_0x04d2
        L_0x041c:
            r0 = move-exception
        L_0x041d:
            r2 = r0
            goto L_0x04da
        L_0x0420:
            r0 = move-exception
            r8 = r2
            r11 = r12
            r7 = r13
            r27 = r10
            r10 = r9
            r9 = r27
        L_0x0429:
            r2 = r0
            r1 = r16
        L_0x042c:
            if (r34 != 0) goto L_0x0468
            java.lang.String r3 = "{\"result\":80006,\"msg\":\"域名解析异常\"}"
            r7.a = r3     // Catch:{ all -> 0x041c }
            java.lang.String r3 = a     // Catch:{ all -> 0x041c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x041c }
            r4.<init>()     // Catch:{ all -> 0x041c }
            java.lang.String r5 = "sendRequest UnknownHostException-preauth-"
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r5 = r2.getMessage()     // Catch:{ all -> 0x041c }
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x041c }
            cn.com.chinatelecom.gateway.lib.CtAuth.warn(r3, r4, r2)     // Catch:{ all -> 0x041c }
            com.dlife.ctaccountapi.b r3 = com.dlife.ctaccountapi.e.a((java.lang.String) r33)     // Catch:{ all -> 0x041c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x041c }
            r4.<init>()     // Catch:{ all -> 0x041c }
            java.lang.String r5 = "doPost UnknownHostException -- "
            r4.append(r5)     // Catch:{ all -> 0x041c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x041c }
            r4.append(r2)     // Catch:{ all -> 0x041c }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x041c }
            r3.a((java.lang.String) r2)     // Catch:{ all -> 0x041c }
        L_0x0468:
            boolean r2 = r8.contains(r9)     // Catch:{ all -> 0x041c }
            if (r2 == 0) goto L_0x0471
            r7.c = r10     // Catch:{ all -> 0x041c }
            goto L_0x0473
        L_0x0471:
            r7.c = r11     // Catch:{ all -> 0x041c }
        L_0x0473:
            r2 = 1
            r7.b = r2     // Catch:{ all -> 0x041c }
            if (r16 == 0) goto L_0x047e
            r16.close()     // Catch:{ all -> 0x047c }
            goto L_0x047e
        L_0x047c:
            goto L_0x0483
        L_0x047e:
            if (r1 == 0) goto L_0x0483
            r1.close()     // Catch:{ all -> 0x047c }
        L_0x0483:
            if (r16 == 0) goto L_0x0488
            r16.close()     // Catch:{ all -> 0x04d5 }
        L_0x0488:
            if (r1 == 0) goto L_0x04d5
            goto L_0x04d2
        L_0x048b:
            r0 = move-exception
            r7 = r13
        L_0x048d:
            r1 = r17
        L_0x048f:
            r3 = r0
            r2 = r16
        L_0x0492:
            r7.a = r1     // Catch:{ all -> 0x04d6 }
            java.lang.String r1 = a     // Catch:{ all -> 0x04d6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x04d6 }
            r4.<init>()     // Catch:{ all -> 0x04d6 }
            java.lang.String r5 = "sendRequest SocketTimeoutException-preauth-"
            r4.append(r5)     // Catch:{ all -> 0x04d6 }
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x04d6 }
            r4.append(r5)     // Catch:{ all -> 0x04d6 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x04d6 }
            cn.com.chinatelecom.gateway.lib.CtAuth.warn(r1, r4, r3)     // Catch:{ all -> 0x04d6 }
            com.dlife.ctaccountapi.b r1 = com.dlife.ctaccountapi.e.a((java.lang.String) r33)     // Catch:{ all -> 0x04d6 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x04d6 }
            r4.<init>()     // Catch:{ all -> 0x04d6 }
            java.lang.String r5 = "doPost SocketTimeoutException -- "
            r4.append(r5)     // Catch:{ all -> 0x04d6 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x04d6 }
            r4.append(r3)     // Catch:{ all -> 0x04d6 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x04d6 }
            r1.a((java.lang.String) r3)     // Catch:{ all -> 0x04d6 }
            if (r16 == 0) goto L_0x04cf
            r16.close()     // Catch:{ all -> 0x04d5 }
        L_0x04cf:
            if (r2 == 0) goto L_0x04d5
            r1 = r2
        L_0x04d2:
            r1.close()     // Catch:{ all -> 0x04d5 }
        L_0x04d5:
            return r7
        L_0x04d6:
            r0 = move-exception
            r1 = r2
            goto L_0x041d
        L_0x04da:
            if (r16 == 0) goto L_0x04df
            r16.close()     // Catch:{ all -> 0x04e4 }
        L_0x04df:
            if (r1 == 0) goto L_0x04e4
            r1.close()     // Catch:{ all -> 0x04e4 }
        L_0x04e4:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.l.a(android.content.Context, java.lang.String, java.lang.String, android.net.Network, java.lang.String, java.lang.String, boolean):com.dlife.ctaccountapi.p");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e0, code lost:
        if (r1 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e2, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fe, code lost:
        if (r1 == null) goto L_0x0104;
     */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f3 A[SYNTHETIC, Splitter:B:53:0x00f3] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fb A[Catch:{ Exception -> 0x00f7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r16, java.lang.String r17, android.net.Network r18) {
        /*
            r0 = r18
            java.lang.String r1 = "UTF-8"
            java.lang.String r2 = "Accept-Charset"
            java.lang.String r3 = "GET"
            java.lang.String r4 = "Keep-Alive"
            java.lang.String r5 = "connection"
            java.lang.String r6 = "*/*"
            java.lang.String r7 = "accept"
            java.lang.String r8 = ""
            int r9 = cn.com.chinatelecom.gateway.lib.CtAuth.mConnTimeoutL
            r10 = 3000(0xbb8, float:4.204E-42)
            if (r9 > 0) goto L_0x001a
            r9 = 3000(0xbb8, float:4.204E-42)
        L_0x001a:
            int r11 = cn.com.chinatelecom.gateway.lib.CtAuth.mReadTimeout
            if (r11 > 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r10 = r11
        L_0x0020:
            java.net.URL r12 = new java.net.URL     // Catch:{ all -> 0x00e6 }
            r13 = r17
            r12.<init>(r13)     // Catch:{ all -> 0x00e6 }
            r13 = 21
            if (r0 == 0) goto L_0x0034
            int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00e6 }
            if (r14 < r13) goto L_0x0034
            java.net.URLConnection r12 = r0.openConnection(r12)     // Catch:{ all -> 0x00e6 }
            goto L_0x0038
        L_0x0034:
            java.net.URLConnection r12 = r12.openConnection()     // Catch:{ all -> 0x00e6 }
        L_0x0038:
            javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12     // Catch:{ all -> 0x00e6 }
            r12.setRequestProperty(r7, r6)     // Catch:{ all -> 0x00e6 }
            r12.setRequestProperty(r5, r4)     // Catch:{ all -> 0x00e6 }
            r12.setRequestMethod(r3)     // Catch:{ all -> 0x00e6 }
            r14 = 0
            r12.setDoOutput(r14)     // Catch:{ all -> 0x00e6 }
            r15 = 1
            r12.setDoInput(r15)     // Catch:{ all -> 0x00e6 }
            r12.setConnectTimeout(r9)     // Catch:{ all -> 0x00e6 }
            r12.setReadTimeout(r10)     // Catch:{ all -> 0x00e6 }
            r12.setUseCaches(r14)     // Catch:{ all -> 0x00e6 }
            r12.addRequestProperty(r2, r1)     // Catch:{ all -> 0x00e6 }
            r12.connect()     // Catch:{ all -> 0x00e6 }
            int r11 = r12.getResponseCode()     // Catch:{ all -> 0x00e6 }
            r15 = 302(0x12e, float:4.23E-43)
            if (r11 != r15) goto L_0x009e
            java.lang.String r11 = "Location"
            java.lang.String r11 = r12.getHeaderField(r11)     // Catch:{ all -> 0x00e6 }
            java.net.URL r12 = new java.net.URL     // Catch:{ all -> 0x00e6 }
            r12.<init>(r11)     // Catch:{ all -> 0x00e6 }
            if (r0 == 0) goto L_0x0078
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00e6 }
            if (r11 < r13) goto L_0x0078
            java.net.URLConnection r0 = r0.openConnection(r12)     // Catch:{ all -> 0x00e6 }
            goto L_0x007c
        L_0x0078:
            java.net.URLConnection r0 = r12.openConnection()     // Catch:{ all -> 0x00e6 }
        L_0x007c:
            r12 = r0
            javax.net.ssl.HttpsURLConnection r12 = (javax.net.ssl.HttpsURLConnection) r12     // Catch:{ all -> 0x00e6 }
            r12.setRequestProperty(r7, r6)     // Catch:{ all -> 0x00e6 }
            r12.setRequestProperty(r5, r4)     // Catch:{ all -> 0x00e6 }
            r12.setRequestMethod(r3)     // Catch:{ all -> 0x00e6 }
            r12.setDoOutput(r14)     // Catch:{ all -> 0x00e6 }
            r0 = 1
            r12.setDoInput(r0)     // Catch:{ all -> 0x00e6 }
            r12.setConnectTimeout(r9)     // Catch:{ all -> 0x00e6 }
            r12.setReadTimeout(r10)     // Catch:{ all -> 0x00e6 }
            r12.setUseCaches(r14)     // Catch:{ all -> 0x00e6 }
            r12.addRequestProperty(r2, r1)     // Catch:{ all -> 0x00e6 }
            r12.connect()     // Catch:{ all -> 0x00e6 }
        L_0x009e:
            int r0 = r12.getResponseCode()     // Catch:{ all -> 0x00e6 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x00d3
            java.io.InputStream r1 = r12.getInputStream()     // Catch:{ all -> 0x00e6 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x00d1 }
            r2.<init>(r1)     // Catch:{ all -> 0x00d1 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x00cf }
            r3.<init>(r2)     // Catch:{ all -> 0x00cf }
        L_0x00b4:
            java.lang.String r0 = r3.readLine()     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x00ca
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cc }
            r4.<init>()     // Catch:{ all -> 0x00cc }
            r4.append(r8)     // Catch:{ all -> 0x00cc }
            r4.append(r0)     // Catch:{ all -> 0x00cc }
            java.lang.String r8 = r4.toString()     // Catch:{ all -> 0x00cc }
            goto L_0x00b4
        L_0x00ca:
            r11 = r3
            goto L_0x00d6
        L_0x00cc:
            r0 = move-exception
            r11 = r3
            goto L_0x00ea
        L_0x00cf:
            r0 = move-exception
            goto L_0x00e9
        L_0x00d1:
            r0 = move-exception
            goto L_0x00e8
        L_0x00d3:
            r1 = 0
            r2 = 0
            r11 = 0
        L_0x00d6:
            if (r11 == 0) goto L_0x00db
            r11.close()     // Catch:{ Exception -> 0x00f7 }
        L_0x00db:
            if (r2 == 0) goto L_0x00e0
            r2.close()     // Catch:{ Exception -> 0x00f7 }
        L_0x00e0:
            if (r1 == 0) goto L_0x0104
        L_0x00e2:
            r1.close()     // Catch:{ Exception -> 0x00f7 }
            goto L_0x0104
        L_0x00e6:
            r0 = move-exception
            r1 = 0
        L_0x00e8:
            r2 = 0
        L_0x00e9:
            r11 = 0
        L_0x00ea:
            java.lang.String r3 = a     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = "doGet error"
            cn.com.chinatelecom.gateway.lib.CtAuth.warn(r3, r4, r0)     // Catch:{ all -> 0x0105 }
            if (r11 == 0) goto L_0x00f9
            r11.close()     // Catch:{ Exception -> 0x00f7 }
            goto L_0x00f9
        L_0x00f7:
            r0 = move-exception
            goto L_0x0101
        L_0x00f9:
            if (r2 == 0) goto L_0x00fe
            r2.close()     // Catch:{ Exception -> 0x00f7 }
        L_0x00fe:
            if (r1 == 0) goto L_0x0104
            goto L_0x00e2
        L_0x0101:
            r0.printStackTrace()
        L_0x0104:
            return r8
        L_0x0105:
            r0 = move-exception
            r3 = r0
            if (r11 == 0) goto L_0x010f
            r11.close()     // Catch:{ Exception -> 0x010d }
            goto L_0x010f
        L_0x010d:
            r0 = move-exception
            goto L_0x011a
        L_0x010f:
            if (r2 == 0) goto L_0x0114
            r2.close()     // Catch:{ Exception -> 0x010d }
        L_0x0114:
            if (r1 == 0) goto L_0x011d
            r1.close()     // Catch:{ Exception -> 0x010d }
            goto L_0x011d
        L_0x011a:
            r0.printStackTrace()
        L_0x011d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dlife.ctaccountapi.l.a(android.content.Context, java.lang.String, android.net.Network):java.lang.String");
    }

    public static final HostnameVerifier a() {
        return new a();
    }
}
