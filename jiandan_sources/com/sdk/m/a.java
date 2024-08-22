package com.sdk.m;

import com.google.common.net.HttpHeaders;
import com.sdk.f.f;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

public class a {
    public static final String a = "com.sdk.m.a";
    public static final Boolean b = Boolean.valueOf(f.a);

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c A[Catch:{ all -> 0x0058 }] */
    @android.annotation.SuppressLint({"DefaultLocale", "NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7) {
        /*
            java.lang.String r0 = com.sdk.base.module.manager.SDKManager.userAgent
            java.lang.Boolean r1 = com.sdk.o.a.a(r0)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0065
            if (r7 == 0) goto L_0x0059
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0058 }
            r2 = 17
            if (r1 < r2) goto L_0x0019
            java.lang.String r7 = android.webkit.WebSettings.getDefaultUserAgent(r7)     // Catch:{ Exception -> 0x0019 }
            goto L_0x001f
        L_0x0019:
            java.lang.String r7 = "http.agent"
            java.lang.String r7 = java.lang.System.getProperty(r7)     // Catch:{ all -> 0x0058 }
        L_0x001f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r1.<init>()     // Catch:{ all -> 0x0058 }
            int r2 = r7.length()     // Catch:{ all -> 0x0058 }
            r3 = 0
            r4 = 0
        L_0x002a:
            if (r4 >= r2) goto L_0x0052
            char r5 = r7.charAt(r4)     // Catch:{ all -> 0x0058 }
            r6 = 31
            if (r5 <= r6) goto L_0x003d
            r6 = 127(0x7f, float:1.78E-43)
            if (r5 < r6) goto L_0x0039
            goto L_0x003d
        L_0x0039:
            r1.append(r5)     // Catch:{ all -> 0x0058 }
            goto L_0x004f
        L_0x003d:
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0058 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0058 }
            r6[r3] = r5     // Catch:{ all -> 0x0058 }
            java.lang.String r5 = "\\u%04x"
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ all -> 0x0058 }
            r1.append(r5)     // Catch:{ all -> 0x0058 }
        L_0x004f:
            int r4 = r4 + 1
            goto L_0x002a
        L_0x0052:
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0058 }
            r0 = r7
            goto L_0x0059
        L_0x0058:
        L_0x0059:
            java.lang.Boolean r7 = com.sdk.o.a.a(r0)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0065
            java.lang.String r0 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1"
        L_0x0065:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.m.a.a(android.content.Context):java.lang.String");
    }

    public static String a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                if (com.sdk.o.a.b(headerField).booleanValue()) {
                    String str = new String(headerField.getBytes("ISO-8859-1"), "GBK");
                    if (com.sdk.o.a.b(str).booleanValue()) {
                        return str.substring(str.indexOf(34) + 1, str.lastIndexOf("\""));
                    }
                }
            } catch (Throwable th2) {
                com.sdk.o.a.a(a, th2.getMessage(), b);
            }
        }
        return null;
    }

    public static boolean a(String str) {
        try {
            for (String str2 : new URL(str).getHost().split("\\.")) {
                for (int i2 = 0; i2 < str2.length(); i2++) {
                    if (!Character.isDigit(str2.charAt(i2))) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return false;
        }
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.ACCEPT_RANGES);
        if (com.sdk.o.a.b(headerField).booleanValue()) {
            return "bytes".equals(headerField);
        }
        if (com.sdk.o.a.b(httpURLConnection.getHeaderField("Content-Range")).booleanValue()) {
            return headerField.startsWith("bytes");
        }
        return false;
    }
}
