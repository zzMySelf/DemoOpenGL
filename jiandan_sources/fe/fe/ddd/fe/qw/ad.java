package fe.fe.ddd.fe.qw;

public class ad {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.io.BufferedReader} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.fe.ddd.fe.qw.yj qw(@androidx.annotation.NonNull java.lang.String r7) {
        /*
            java.lang.String r0 = "application/json"
            java.lang.String r1 = "UTF-8"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 0
            fe.fe.ddd.fe.qw.i r4 = fe.fe.ddd.fe.qw.i.qw()     // Catch:{ IOException -> 0x00ca, all -> 0x00bb }
            java.lang.String r4 = r4.ad()     // Catch:{ IOException -> 0x00ca, all -> 0x00bb }
            java.net.URL r5 = new java.net.URL     // Catch:{ IOException -> 0x00ca, all -> 0x00bb }
            r5.<init>(r4)     // Catch:{ IOException -> 0x00ca, all -> 0x00bb }
            java.net.URLConnection r4 = r5.openConnection()     // Catch:{ IOException -> 0x00ca, all -> 0x00bb }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ IOException -> 0x00ca, all -> 0x00bb }
            java.lang.String r5 = "POST"
            r4.setRequestMethod(r5)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r5 = 30000(0x7530, float:4.2039E-41)
            r4.setReadTimeout(r5)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r4.setConnectTimeout(r5)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r5 = 1
            r4.setDoInput(r5)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r4.setDoOutput(r5)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r4.setInstanceFollowRedirects(r5)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r5 = 0
            r4.setUseCaches(r5)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r5 = "Charset"
            r4.setRequestProperty(r5, r1)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r5 = "Content-type"
            r4.setRequestProperty(r5, r0)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r5 = "accept"
            r4.setRequestProperty(r5, r0)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r7 = fe.fe.ddd.fe.qw.rg.ad(r7)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            if (r7 == 0) goto L_0x0070
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            if (r0 != 0) goto L_0x0070
            byte[] r0 = r7.getBytes(r1)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r1 = "Content-Length"
            int r0 = r0.length     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            r4.setRequestProperty(r1, r0)     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            java.io.OutputStream r0 = r4.getOutputStream()     // Catch:{ IOException -> 0x00b8, all -> 0x00b5 }
            byte[] r7 = r7.getBytes()     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
            r0.write(r7)     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
            r0.flush()     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
            goto L_0x0071
        L_0x0070:
            r0 = r3
        L_0x0071:
            int r7 = r4.getResponseCode()     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
            r1 = 200(0xc8, float:2.8E-43)
            if (r7 != r1) goto L_0x009a
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
            java.io.InputStream r5 = r4.getInputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
            r1.<init>(r5)     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
            r7.<init>(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00ae }
        L_0x0087:
            java.lang.String r1 = r7.readLine()     // Catch:{ IOException -> 0x0098, all -> 0x0093 }
            if (r1 == 0) goto L_0x0091
            r2.append(r1)     // Catch:{ IOException -> 0x0098, all -> 0x0093 }
            goto L_0x0087
        L_0x0091:
            r3 = r7
            goto L_0x009a
        L_0x0093:
            r1 = move-exception
            r3 = r0
            r0 = r7
            r7 = r1
            goto L_0x00be
        L_0x0098:
            goto L_0x00cd
        L_0x009a:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r0)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r3)
            if (r4 == 0) goto L_0x00a5
            r4.disconnect()
        L_0x00a5:
            java.lang.String r7 = r2.toString()
            fe.fe.ddd.fe.qw.yj r7 = fe.fe.ddd.fe.qw.rg.de(r7)
            return r7
        L_0x00ae:
            r7 = move-exception
            r6 = r3
            r3 = r0
            r0 = r6
            goto L_0x00be
        L_0x00b3:
            r7 = r3
            goto L_0x00cd
        L_0x00b5:
            r7 = move-exception
            r0 = r3
            goto L_0x00be
        L_0x00b8:
            r7 = r3
            r0 = r7
            goto L_0x00cd
        L_0x00bb:
            r7 = move-exception
            r0 = r3
            r4 = r0
        L_0x00be:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r3)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r0)
            if (r4 == 0) goto L_0x00c9
            r4.disconnect()
        L_0x00c9:
            throw r7
        L_0x00ca:
            r7 = r3
            r0 = r7
            r4 = r0
        L_0x00cd:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r0)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r7)
            if (r4 == 0) goto L_0x00d8
            r4.disconnect()
        L_0x00d8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.fe.qw.ad.qw(java.lang.String):fe.fe.ddd.fe.qw.yj");
    }
}
