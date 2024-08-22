package com.baidu.fsg.base.statistics;

import java.net.URLEncoder;
import java.util.Map;

class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11756a = "logsender";

    interface a {
        void a();

        void b();
    }

    k() {
    }

    private String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey())).append("=").append(URLEncoder.encode((String) next.getValue())).append("&");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, com.baidu.fsg.base.statistics.k.a r7) {
        /*
            r4 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0078 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0078 }
            java.net.URLConnection r5 = r1.openConnection()     // Catch:{ Exception -> 0x0078 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0078 }
            r0 = 0
            r5.setUseCaches(r0)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r1 = 1
            r5.setDoOutput(r1)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r2 = "POST"
            r5.setRequestMethod(r2)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r2 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r5.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r5.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            java.lang.String r6 = r4.a(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            int r2 = r6.length()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r5.setFixedLengthStreamingMode(r2)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r2 = 30000(0x7530, float:4.2039E-41)
            r5.setConnectTimeout(r2)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r5.setReadTimeout(r2)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r5.connect()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            int r2 = r6.length()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            if (r2 <= 0) goto L_0x0054
            java.io.OutputStream r2 = r5.getOutputStream()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r2.write(r6)     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r2.flush()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r2.close()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
        L_0x0054:
            int r6 = r5.getResponseCode()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r2 > r6) goto L_0x0061
            r2 = 300(0x12c, float:4.2E-43)
            if (r2 <= r6) goto L_0x0061
            r0 = r1
        L_0x0061:
            if (r0 == 0) goto L_0x0067
            r7.a()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
            goto L_0x006a
        L_0x0067:
            r7.b()     // Catch:{ Exception -> 0x0073, all -> 0x0070 }
        L_0x006a:
            if (r5 == 0) goto L_0x008d
            r5.disconnect()
            goto L_0x008d
        L_0x0070:
            r6 = move-exception
            r0 = r5
            goto L_0x008e
        L_0x0073:
            r6 = move-exception
            r0 = r5
            goto L_0x0079
        L_0x0076:
            r6 = move-exception
            goto L_0x008e
        L_0x0078:
            r6 = move-exception
        L_0x0079:
            r6.printStackTrace()     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = "logsender"
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0076 }
            com.baidu.fsg.base.utils.LogUtil.d(r5, r6)     // Catch:{ all -> 0x0076 }
            r7.b()     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x008d
            r0.disconnect()
        L_0x008d:
            return
        L_0x008e:
            if (r0 == 0) goto L_0x0093
            r0.disconnect()
        L_0x0093:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.fsg.base.statistics.k.a(java.lang.String, java.util.Map, com.baidu.fsg.base.statistics.k$a):void");
    }
}
