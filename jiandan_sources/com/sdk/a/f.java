package com.sdk.a;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.sdk.base.module.manager.SDKManager;
import java.util.UUID;

public class f<T> {
    public static final String a = "f";
    public static boolean b = com.sdk.f.f.a;
    public static final String c = UUID.randomUUID().toString();
    public Context d;
    public g<T> e;

    public enum a {
        a(ShareTarget.METHOD_GET),
        POST("POST"),
        PUT("PUT"),
        HEAD("HEAD"),
        MOVE("MOVE"),
        COPY("COPY"),
        DELETE("DELETE"),
        OPTIONS("OPTIONS"),
        TRACE("TRACE"),
        CONNECT("CONNECT");
        
        public final String l;

        /* access modifiers changed from: public */
        a(String str) {
            this.l = str;
        }

        public String toString() {
            return this.l;
        }
    }

    public f(Context context, g<T> gVar) {
        this.d = context;
        this.e = gVar;
    }

    /* JADX WARNING: type inference failed for: r8v20, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088 A[Catch:{ Exception -> 0x0147 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089 A[Catch:{ Exception -> 0x0147 }] */
    @android.annotation.SuppressLint({"DefaultLocale"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection a(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            com.sdk.p.f$a r1 = com.sdk.p.f.a.UNKNOW
            r1.a()
            java.lang.Boolean r1 = com.sdk.o.a.b(r8)     // Catch:{ Exception -> 0x0147 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0147 }
            r2 = 0
            if (r1 == 0) goto L_0x0146
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0147 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x0147 }
            android.content.Context r3 = r7.d     // Catch:{ Exception -> 0x0147 }
            com.sdk.p.f$a r3 = com.sdk.p.f.a(r3, r2)     // Catch:{ Exception -> 0x0147 }
            int r3 = r3.a()     // Catch:{ Exception -> 0x0147 }
            java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0147 }
            boolean r8 = r7.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0147 }
            if (r8 == 0) goto L_0x008a
            com.sdk.p.f$a r8 = com.sdk.p.f.a.NET     // Catch:{ Exception -> 0x0147 }
            int r4 = r8.a()     // Catch:{ Exception -> 0x0147 }
            if (r3 == r4) goto L_0x008a
            int r4 = com.sdk.j.a.a()     // Catch:{ Exception -> 0x0147 }
            r5 = 23
            if (r4 >= r5) goto L_0x007b
            com.sdk.a.g<T> r3 = r7.e     // Catch:{ Exception -> 0x0147 }
            java.lang.String r3 = r3.d     // Catch:{ Exception -> 0x0147 }
            boolean r5 = r7.a((java.lang.String) r3)     // Catch:{ Exception -> 0x0147 }
            if (r5 == 0) goto L_0x005d
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x0147 }
            r5.<init>()     // Catch:{ Exception -> 0x0147 }
            java.lang.Boolean r6 = com.sdk.o.a.b(r3)     // Catch:{ Exception -> 0x0147 }
            boolean r6 = r6.booleanValue()     // Catch:{ Exception -> 0x0147 }
            if (r6 == 0) goto L_0x0056
            r5.add(r3)     // Catch:{ Exception -> 0x0147 }
        L_0x0056:
            android.content.Context r3 = r7.d     // Catch:{ Exception -> 0x0147 }
            com.sdk.p.f$a r3 = com.sdk.p.f.a(r3, r5)     // Catch:{ Exception -> 0x0147 }
            goto L_0x0063
        L_0x005d:
            android.content.Context r3 = r7.d     // Catch:{ Exception -> 0x0147 }
            com.sdk.p.f$a r3 = com.sdk.p.f.a(r3, r2)     // Catch:{ Exception -> 0x0147 }
        L_0x0063:
            int r3 = r3.a()     // Catch:{ Exception -> 0x0147 }
            r5 = 21
            if (r4 <= r5) goto L_0x0079
            int r8 = r8.a()     // Catch:{ Exception -> 0x0147 }
            if (r3 == r8) goto L_0x0079
            com.sdk.a.b r8 = new com.sdk.a.b     // Catch:{ Exception -> 0x0147 }
            android.content.Context r4 = r7.d     // Catch:{ Exception -> 0x0147 }
            r8.<init>(r4, r1)     // Catch:{ Exception -> 0x0147 }
            goto L_0x0082
        L_0x0079:
            r8 = r2
            goto L_0x0086
        L_0x007b:
            com.sdk.a.b r8 = new com.sdk.a.b     // Catch:{ Exception -> 0x0147 }
            android.content.Context r4 = r7.d     // Catch:{ Exception -> 0x0147 }
            r8.<init>(r4, r1)     // Catch:{ Exception -> 0x0147 }
        L_0x0082:
            java.net.HttpURLConnection r8 = r8.a()     // Catch:{ Exception -> 0x0147 }
        L_0x0086:
            if (r8 != 0) goto L_0x0089
            return r2
        L_0x0089:
            r2 = r8
        L_0x008a:
            if (r2 != 0) goto L_0x0094
            java.net.URLConnection r8 = r1.openConnection()     // Catch:{ Exception -> 0x0147 }
            r2 = r8
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x0147 }
            goto L_0x009d
        L_0x0094:
            com.sdk.p.f$a r8 = com.sdk.p.f.a.WIFI     // Catch:{ Exception -> 0x0147 }
            int r8 = r8.a()     // Catch:{ Exception -> 0x0147 }
            if (r3 != r8) goto L_0x009d
            r3 = 2
        L_0x009d:
            java.lang.String r8 = r1.getProtocol()     // Catch:{ Exception -> 0x0147 }
            java.lang.Boolean r1 = com.sdk.o.a.b(r8)     // Catch:{ Exception -> 0x0147 }
            boolean r1 = r1.booleanValue()     // Catch:{ Exception -> 0x0147 }
            if (r1 == 0) goto L_0x00c3
            if (r9 == 0) goto L_0x00c3
            boolean r9 = com.sdk.base.module.manager.SDKManager.smartTrust     // Catch:{ Exception -> 0x0147 }
            if (r9 == 0) goto L_0x00c3
            java.lang.String r9 = "https"
            java.util.Locale r1 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x0147 }
            java.lang.String r8 = r8.toLowerCase(r1)     // Catch:{ Exception -> 0x0147 }
            boolean r8 = r9.equals(r8)     // Catch:{ Exception -> 0x0147 }
            if (r8 == 0) goto L_0x00c3
            javax.net.ssl.HttpsURLConnection r2 = (javax.net.ssl.HttpsURLConnection) r2     // Catch:{ Exception -> 0x0147 }
        L_0x00c3:
            r8 = 1
            r2.setDoOutput(r8)     // Catch:{ Exception -> 0x0147 }
            r8 = 30000(0x7530, float:4.2039E-41)
            r2.setConnectTimeout(r8)     // Catch:{ Exception -> 0x0147 }
            r2.setReadTimeout(r8)     // Catch:{ Exception -> 0x0147 }
            r8 = 0
            r2.setInstanceFollowRedirects(r8)     // Catch:{ Exception -> 0x0147 }
            android.content.Context r8 = r7.d     // Catch:{ Exception -> 0x0147 }
            java.lang.String r8 = com.sdk.m.a.a((android.content.Context) r8)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r9 = "user-agent"
            r2.setRequestProperty(r9, r8)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r8 = "netType"
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0147 }
            r9.<init>()     // Catch:{ Exception -> 0x0147 }
            r9.append(r3)     // Catch:{ Exception -> 0x0147 }
            r9.append(r0)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0147 }
            r2.setRequestProperty(r8, r9)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r8 = "os"
            java.lang.String r9 = "android"
            r2.setRequestProperty(r8, r9)     // Catch:{ Exception -> 0x0147 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0147 }
            r8.<init>()     // Catch:{ Exception -> 0x0147 }
            java.lang.String r9 = "connection==: "
            r8.append(r9)     // Catch:{ Exception -> 0x0147 }
            r8.append(r2)     // Catch:{ Exception -> 0x0147 }
            r8.toString()     // Catch:{ Exception -> 0x0147 }
            com.sdk.a.g<T> r8 = r7.e     // Catch:{ Exception -> 0x0147 }
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r8.h     // Catch:{ Exception -> 0x0147 }
            if (r8 == 0) goto L_0x0146
            int r9 = r8.size()     // Catch:{ Exception -> 0x0147 }
            if (r9 <= 0) goto L_0x0146
            java.util.Set r8 = r8.entrySet()     // Catch:{ Exception -> 0x0147 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0147 }
        L_0x011d:
            boolean r9 = r8.hasNext()     // Catch:{ Exception -> 0x0147 }
            if (r9 == 0) goto L_0x0146
            java.lang.Object r9 = r8.next()     // Catch:{ Exception -> 0x0147 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ Exception -> 0x0147 }
            java.lang.Object r1 = r9.getKey()     // Catch:{ Exception -> 0x0147 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0147 }
            java.lang.Object r9 = r9.getValue()     // Catch:{ Exception -> 0x0147 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0147 }
            r3.<init>()     // Catch:{ Exception -> 0x0147 }
            r3.append(r9)     // Catch:{ Exception -> 0x0147 }
            r3.append(r0)     // Catch:{ Exception -> 0x0147 }
            java.lang.String r9 = r3.toString()     // Catch:{ Exception -> 0x0147 }
            r2.setRequestProperty(r1, r9)     // Catch:{ Exception -> 0x0147 }
            goto L_0x011d
        L_0x0146:
            return r2
        L_0x0147:
            r8 = move-exception
            java.lang.String r9 = r8.toString()
            com.sdk.o.b.c(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = a
            r9.append(r0)
            java.lang.String r0 = "HttpRequst 248"
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = r8.toString()
            boolean r1 = b
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            com.sdk.o.a.a(r9, r0, r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.a.f.a(java.lang.String, boolean):java.net.HttpURLConnection");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection a(java.net.HttpURLConnection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "--"
            java.lang.String r1 = "\r\n"
            if (r12 == 0) goto L_0x01b4
            com.sdk.a.g<T> r2 = r11.e
            java.lang.String r3 = "Content-Type"
            r4 = 0
            if (r2 == 0) goto L_0x0031
            java.util.ArrayList<java.io.File> r2 = r2.g
            if (r2 == 0) goto L_0x001a
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r2 = 1
            goto L_0x001b
        L_0x001a:
            r2 = 0
        L_0x001b:
            if (r2 == 0) goto L_0x0031
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "multipart/form-data; boundary="
            r2.append(r5)
            java.lang.String r5 = c
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            goto L_0x0033
        L_0x0031:
            java.lang.String r2 = "application/x-www-form-urlencoded"
        L_0x0033:
            r12.setRequestProperty(r3, r2)
            java.lang.String r2 = "Charset"
            java.lang.String r3 = "UTF-8"
            r12.setRequestProperty(r2, r3)
            java.lang.String r2 = "connection"
            java.lang.String r3 = "keep-alive"
            r12.setRequestProperty(r2, r3)
            com.sdk.a.g<T> r2 = r11.e
            if (r2 == 0) goto L_0x01b4
            com.sdk.a.f$a r2 = com.sdk.a.f.a.POST
            java.lang.String r2 = r2.l
            com.sdk.a.g<T> r3 = r11.e
            java.lang.String r3 = r3.c
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x01a9
            java.lang.String r2 = "POST"
            r12.setRequestMethod(r2)
            r12.getRequestMethod()
            r12.connect()
            com.sdk.a.g<T> r2 = r11.e
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>()
            if (r2 == 0) goto L_0x019d
            com.sdk.a.g<T> r5 = r11.e     // Catch:{ Exception -> 0x0175 }
            java.util.TreeMap<java.lang.String, java.lang.Object> r5 = r5.f     // Catch:{ Exception -> 0x0175 }
            java.lang.String r5 = r2.a((java.util.TreeMap<java.lang.String, java.lang.Object>) r5)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r6 = r2.d     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = "/dro/log/v1.0/log"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0175 }
            if (r6 == 0) goto L_0x0084
            java.util.TreeMap<java.lang.String, java.lang.Object> r5 = r2.f     // Catch:{ Exception -> 0x0175 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0175 }
        L_0x0084:
            java.util.ArrayList<java.io.File> r2 = r2.g     // Catch:{ Exception -> 0x0175 }
            java.lang.String r6 = "utf-8"
            if (r2 == 0) goto L_0x016d
            int r7 = r2.size()     // Catch:{ Exception -> 0x0175 }
            if (r7 <= 0) goto L_0x016d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0175 }
            r7.<init>()     // Catch:{ Exception -> 0x0175 }
            r7.append(r0)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r8 = c     // Catch:{ Exception -> 0x0175 }
            r7.append(r8)     // Catch:{ Exception -> 0x0175 }
            r7.append(r1)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0175 }
            byte[] r7 = r7.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = "Content-Disposition: form-data; name=\"params\""
            byte[] r7 = r7.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = "\r\n\r\n"
            byte[] r7 = r7.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r7)     // Catch:{ Exception -> 0x0175 }
            byte[] r5 = r5.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r5)     // Catch:{ Exception -> 0x0175 }
            byte[] r5 = r1.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r5)     // Catch:{ Exception -> 0x0175 }
            r5 = 0
        L_0x00cc:
            int r7 = r2.size()     // Catch:{ Exception -> 0x0175 }
            if (r5 >= r7) goto L_0x019d
            java.lang.Object r7 = r2.get(r5)     // Catch:{ Exception -> 0x0175 }
            java.io.File r7 = (java.io.File) r7     // Catch:{ Exception -> 0x0175 }
            if (r7 == 0) goto L_0x0169
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0175 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = r7.getName()     // Catch:{ Exception -> 0x0175 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0175 }
            r9.<init>()     // Catch:{ Exception -> 0x0175 }
            r9.append(r0)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r10 = c     // Catch:{ Exception -> 0x0175 }
            r9.append(r10)     // Catch:{ Exception -> 0x0175 }
            r9.append(r1)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0175 }
            byte[] r9 = r9.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r9)     // Catch:{ Exception -> 0x0175 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0175 }
            r9.<init>()     // Catch:{ Exception -> 0x0175 }
            java.lang.String r10 = "Content-Disposition: form-data; name=\""
            r9.append(r10)     // Catch:{ Exception -> 0x0175 }
            r9.append(r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r10 = "\"; filename=\""
            r9.append(r10)     // Catch:{ Exception -> 0x0175 }
            r9.append(r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = "\"\r\n"
            r9.append(r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = r9.toString()     // Catch:{ Exception -> 0x0175 }
            byte[] r7 = r7.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = "Content-Type: application/octet-stream\r\n"
            byte[] r7 = r7.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r7)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = "Content-Transfer-Encoding: binary\r\n\r\n"
            byte[] r7 = r7.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r7)     // Catch:{ Exception -> 0x0175 }
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x0175 }
        L_0x0139:
            int r9 = r8.read(r7)     // Catch:{ Exception -> 0x0175 }
            r10 = -1
            if (r9 == r10) goto L_0x0144
            r3.write(r7, r4, r9)     // Catch:{ Exception -> 0x0175 }
            goto L_0x0139
        L_0x0144:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0175 }
            r7.<init>()     // Catch:{ Exception -> 0x0175 }
            java.lang.String r9 = "\r\n--"
            r7.append(r9)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r9 = c     // Catch:{ Exception -> 0x0175 }
            r7.append(r9)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r9 = "--\r\n"
            r7.append(r9)     // Catch:{ Exception -> 0x0175 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0175 }
            byte[] r7 = r7.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r7)     // Catch:{ Exception -> 0x0175 }
            r3.flush()     // Catch:{ Exception -> 0x0175 }
            r8.close()     // Catch:{ Exception -> 0x0175 }
        L_0x0169:
            int r5 = r5 + 1
            goto L_0x00cc
        L_0x016d:
            byte[] r0 = r5.getBytes(r6)     // Catch:{ Exception -> 0x0175 }
            r3.write(r0)     // Catch:{ Exception -> 0x0175 }
            goto L_0x019d
        L_0x0175:
            r0 = move-exception
            java.lang.String r1 = r0.toString()
            com.sdk.o.b.c(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = a
            r1.append(r2)
            java.lang.String r2 = "HttpRequst558"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.toString()
            boolean r2 = b
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            com.sdk.o.a.a(r1, r0, r2)
        L_0x019d:
            java.io.OutputStream r0 = r12.getOutputStream()
            byte[] r1 = r3.toByteArray()
            r0.write(r1)
            goto L_0x01b4
        L_0x01a9:
            java.lang.String r0 = "GET"
            r12.setRequestMethod(r0)
            r12.getRequestMethod()
            r12.connect()
        L_0x01b4:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.a.f.a(java.net.HttpURLConnection):java.net.HttpURLConnection");
    }

    public String a() {
        StringBuilder sb;
        try {
            g<T> gVar = this.e;
            if (gVar == null) {
                return null;
            }
            String str = gVar.c;
            String str2 = gVar.d;
            if (str.equals(a.a.l)) {
                g<T> gVar2 = this.e;
                String a2 = gVar2.a(gVar2.f);
                if (!com.sdk.o.a.b(a2).booleanValue()) {
                    return str2;
                }
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("?");
                sb.append(a2);
            } else {
                String str3 = this.e.e;
                if (!com.sdk.o.a.b(str3).booleanValue()) {
                    return str2;
                }
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("?unikey=");
                sb.append(str3);
            }
            return sb.toString();
        } catch (Exception e2) {
            com.sdk.o.a.a(a, e2.getMessage(), Boolean.valueOf(b));
            return null;
        }
    }

    public final boolean a(String str) {
        if (!SDKManager.isStrong || str.contains("/api/netm/v1.0/qhbt") || str.contains("/api/netm/v1.0/qhbv") || str.contains("/st/api/v1.0/ses")) {
            return false;
        }
        return true;
    }
}
