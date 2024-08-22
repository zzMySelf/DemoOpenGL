package com.baidu.idl.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;

public class NetUtil {
    public static final String TAG = "NetUtil";

    public static abstract class RequestAdapter<T> {
        public static final int CONNECT_TIMEOUT = 5000;
        public static final int READ_TIMEOUT = 5000;
        public static final String REQUEST_METHOD = "POST";
        public static final int RESPONSE_STATUS_ERROR_IO = 2;
        public static final int RESPONSE_STATUS_ERROR_PARSE_JSON = 3;
        public static final int RESPONSE_STATUS_ERROR_RESPONSE_CODE = 4;
        public static final int RESPONSE_STATUS_ERROR_TIMEOUT = 1;
        public static final int RESPONSE_STATUS_ERROR_UNKNOWN = 5;
        public static final int RESPONSE_STATUS_NORMAL = 0;
        public static final int RETRY_COUNT = 2;

        public int getConnectTimeout() {
            return 5000;
        }

        public int getReadTimeout() {
            return 5000;
        }

        public String getRequestMethod() {
            return "POST";
        }

        public abstract String getRequestString();

        public int getRetryCount() {
            return 2;
        }

        public abstract String getURL();

        public abstract void onResponse(int i2, T t, Exception exc);

        public abstract T parseResponse(InputStream inputStream) throws IOException, JSONException;
    }

    public NetUtil() {
        throw new RuntimeException("This class instance can not be created.");
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.net.SocketTimeoutException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.net.SocketTimeoutException} */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11, types: [java.io.IOException] */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13, types: [org.json.JSONException] */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15, types: [java.lang.Exception] */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: type inference failed for: r2v32 */
    /* JADX WARNING: type inference failed for: r2v33 */
    /* JADX WARNING: type inference failed for: r2v34 */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b1, code lost:
        if (r7 != null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c9, code lost:
        if (r7 != null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e1, code lost:
        if (r7 != null) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e3, code lost:
        r7.disconnect();
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00e6, code lost:
        r8 = r2;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x010f A[EDGE_INSN: B:104:0x010f->B:89:0x010f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a5 A[SYNTHETIC, Splitter:B:31:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac A[SYNTHETIC, Splitter:B:35:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bd A[SYNTHETIC, Splitter:B:45:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c4 A[SYNTHETIC, Splitter:B:49:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d5 A[SYNTHETIC, Splitter:B:59:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00dc A[SYNTHETIC, Splitter:B:63:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f0 A[SYNTHETIC, Splitter:B:74:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f7 A[SYNTHETIC, Splitter:B:78:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0117 A[SYNTHETIC, Splitter:B:94:0x0117] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011e A[SYNTHETIC, Splitter:B:98:0x011e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void uploadData(com.baidu.idl.util.NetUtil.RequestAdapter<T> r11) {
        /*
            int r0 = r11.getRetryCount()
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
        L_0x0008:
            r5 = 0
            r6 = 1
            java.net.URL r7 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x00e8, IOException -> 0x00cc, JSONException -> 0x00b4, Exception -> 0x009c, all -> 0x0099 }
            java.lang.String r8 = r11.getURL()     // Catch:{ SocketTimeoutException -> 0x00e8, IOException -> 0x00cc, JSONException -> 0x00b4, Exception -> 0x009c, all -> 0x0099 }
            r7.<init>(r8)     // Catch:{ SocketTimeoutException -> 0x00e8, IOException -> 0x00cc, JSONException -> 0x00b4, Exception -> 0x009c, all -> 0x0099 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ SocketTimeoutException -> 0x00e8, IOException -> 0x00cc, JSONException -> 0x00b4, Exception -> 0x009c, all -> 0x0099 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ SocketTimeoutException -> 0x00e8, IOException -> 0x00cc, JSONException -> 0x00b4, Exception -> 0x009c, all -> 0x0099 }
            int r2 = r11.getConnectTimeout()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r7.setConnectTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r7.setDoInput(r6)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r7.setDoOutput(r6)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            int r2 = r11.getReadTimeout()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r7.setReadTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            java.lang.String r2 = r11.getRequestMethod()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r7.setRequestMethod(r2)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r7.setUseCaches(r5)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            java.io.OutputStream r3 = r7.getOutputStream()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            java.lang.String r2 = r11.getRequestString()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            java.lang.String r8 = "UTF-8"
            byte[] r2 = r2.getBytes(r8)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r3.write(r2)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r3.flush()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            int r2 = r7.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r2 == r8) goto L_0x0071
            r2 = 4
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r9.<init>()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            java.lang.String r10 = "ResponseCode: "
            r9.append(r10)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            int r10 = r7.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r9.append(r10)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            java.lang.String r9 = r9.toString()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r8.<init>(r9)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r2 = r1
            r6 = 4
            goto L_0x007b
        L_0x0071:
            java.io.InputStream r4 = r7.getInputStream()     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            java.lang.Object r2 = r11.parseResponse(r4)     // Catch:{ SocketTimeoutException -> 0x0096, IOException -> 0x0094, JSONException -> 0x0092, Exception -> 0x0090 }
            r8 = r1
            r6 = 0
        L_0x007b:
            if (r3 == 0) goto L_0x0082
            r3.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0082
        L_0x0081:
        L_0x0082:
            if (r4 == 0) goto L_0x0089
            r4.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x0089
        L_0x0088:
        L_0x0089:
            if (r7 == 0) goto L_0x0104
            r7.disconnect()
            goto L_0x0104
        L_0x0090:
            r2 = move-exception
            goto L_0x009f
        L_0x0092:
            r2 = move-exception
            goto L_0x00b7
        L_0x0094:
            r2 = move-exception
            goto L_0x00cf
        L_0x0096:
            r2 = move-exception
            goto L_0x00eb
        L_0x0099:
            r11 = move-exception
            goto L_0x0115
        L_0x009c:
            r6 = move-exception
            r7 = r2
            r2 = r6
        L_0x009f:
            r2.printStackTrace()     // Catch:{ all -> 0x0113 }
            r6 = 5
            if (r3 == 0) goto L_0x00aa
            r3.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00aa
        L_0x00a9:
        L_0x00aa:
            if (r4 == 0) goto L_0x00b1
            r4.close()     // Catch:{ IOException -> 0x00b0 }
            goto L_0x00b1
        L_0x00b0:
        L_0x00b1:
            if (r7 == 0) goto L_0x00e6
            goto L_0x00e3
        L_0x00b4:
            r6 = move-exception
            r7 = r2
            r2 = r6
        L_0x00b7:
            r2.printStackTrace()     // Catch:{ all -> 0x0113 }
            r6 = 3
            if (r3 == 0) goto L_0x00c2
            r3.close()     // Catch:{ IOException -> 0x00c1 }
            goto L_0x00c2
        L_0x00c1:
        L_0x00c2:
            if (r4 == 0) goto L_0x00c9
            r4.close()     // Catch:{ IOException -> 0x00c8 }
            goto L_0x00c9
        L_0x00c8:
        L_0x00c9:
            if (r7 == 0) goto L_0x00e6
            goto L_0x00e3
        L_0x00cc:
            r6 = move-exception
            r7 = r2
            r2 = r6
        L_0x00cf:
            r2.printStackTrace()     // Catch:{ all -> 0x0113 }
            r6 = 2
            if (r3 == 0) goto L_0x00da
            r3.close()     // Catch:{ IOException -> 0x00d9 }
            goto L_0x00da
        L_0x00d9:
        L_0x00da:
            if (r4 == 0) goto L_0x00e1
            r4.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e1
        L_0x00e0:
        L_0x00e1:
            if (r7 == 0) goto L_0x00e6
        L_0x00e3:
            r7.disconnect()
        L_0x00e6:
            r8 = r2
            goto L_0x0103
        L_0x00e8:
            r5 = move-exception
            r7 = r2
            r2 = r5
        L_0x00eb:
            r2.printStackTrace()     // Catch:{ all -> 0x0113 }
            if (r3 == 0) goto L_0x00f5
            r3.close()     // Catch:{ IOException -> 0x00f4 }
            goto L_0x00f5
        L_0x00f4:
        L_0x00f5:
            if (r4 == 0) goto L_0x00fc
            r4.close()     // Catch:{ IOException -> 0x00fb }
            goto L_0x00fc
        L_0x00fb:
        L_0x00fc:
            if (r7 == 0) goto L_0x0101
            r7.disconnect()
        L_0x0101:
            r8 = r2
            r5 = 1
        L_0x0103:
            r2 = r1
        L_0x0104:
            if (r5 == 0) goto L_0x010f
            int r5 = r0 + -1
            if (r0 > 0) goto L_0x010b
            goto L_0x010f
        L_0x010b:
            r0 = r5
            r2 = r7
            goto L_0x0008
        L_0x010f:
            r11.onResponse(r6, r2, r8)
            return
        L_0x0113:
            r11 = move-exception
            r2 = r7
        L_0x0115:
            if (r3 == 0) goto L_0x011c
            r3.close()     // Catch:{ IOException -> 0x011b }
            goto L_0x011c
        L_0x011b:
        L_0x011c:
            if (r4 == 0) goto L_0x0123
            r4.close()     // Catch:{ IOException -> 0x0122 }
            goto L_0x0123
        L_0x0122:
        L_0x0123:
            if (r2 == 0) goto L_0x0128
            r2.disconnect()
        L_0x0128:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.util.NetUtil.uploadData(com.baidu.idl.util.NetUtil$RequestAdapter):void");
    }
}
