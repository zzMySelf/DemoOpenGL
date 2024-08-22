package com.cmic.sso.sdk.c.a;

import com.baidu.android.common.others.IStringUtil;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.c.c;
import java.io.Closeable;
import java.io.IOException;

public class a implements b {
    public static c a;

    /* JADX WARNING: Removed duplicated region for block: B:103:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0064 A[Catch:{ Exception -> 0x01ea, all -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x016a A[EDGE_INSN: B:134:0x016a->B:53:0x016a ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0074 A[Catch:{ Exception -> 0x01ea, all -> 0x01e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0085 A[Catch:{ Exception -> 0x01dc, all -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb A[Catch:{ Exception -> 0x01d5, all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f7 A[Catch:{ Exception -> 0x01d5, all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0123 A[Catch:{ Exception -> 0x01d5, all -> 0x01d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0136 A[SYNTHETIC, Splitter:B:39:0x0136] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0149 A[Catch:{ Exception -> 0x01d1, all -> 0x01cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015c A[Catch:{ Exception -> 0x01c6 }, LOOP:1: B:50:0x0156->B:52:0x015c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0219 A[Catch:{ all -> 0x0298 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0220 A[Catch:{ all -> 0x0298 }] */
    @android.annotation.TargetApi(21)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.cmic.sso.sdk.c.c.c r20, com.cmic.sso.sdk.c.d.c r21, com.cmic.sso.sdk.a r22) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r22
            java.lang.String r5 = "remote_ip"
            java.lang.String r6 = ""
            java.lang.String r7 = "responseResult: "
            java.lang.String r8 = "responseCode: "
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r9 = "请求地址: "
            r0.append(r9)
            java.lang.String r9 = r20.a()
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r9 = "ConnectionInterceptor"
            com.cmic.sso.sdk.e.c.b(r9, r0)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = r20.a()     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            java.net.URL r15 = new java.net.URL     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            r15.<init>(r0)     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            java.lang.String r14 = r15.getHost()     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            com.cmic.sso.sdk.c.b.g r11 = r20.j()     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            boolean r12 = r11 instanceof com.cmic.sso.sdk.c.b.h     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            if (r12 != 0) goto L_0x0048
            boolean r12 = r11 instanceof com.cmic.sso.sdk.c.b.e     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            if (r12 == 0) goto L_0x005d
        L_0x0048:
            java.lang.String r12 = r4.b(r5)     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            boolean r16 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            if (r16 != 0) goto L_0x005d
            java.net.URL r15 = new java.net.URL     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            java.lang.String r0 = r0.replaceFirst(r14, r12)     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            r15.<init>(r0)     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            r0 = 1
            goto L_0x005e
        L_0x005d:
            r0 = 0
        L_0x005e:
            android.net.Network r12 = r20.g()     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            if (r12 == 0) goto L_0x0074
            java.lang.String r12 = "开始wifi下取号"
            com.cmic.sso.sdk.e.c.b(r9, r12)     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            android.net.Network r12 = r20.g()     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            java.net.URLConnection r12 = r12.openConnection(r15)     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            goto L_0x007f
        L_0x0074:
            java.lang.String r12 = "使用当前网络环境发送请求"
            com.cmic.sso.sdk.e.c.b(r9, r12)     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            java.net.URLConnection r12 = r15.openConnection()     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ Exception -> 0x01ea, all -> 0x01e1 }
        L_0x007f:
            java.util.Map r15 = r20.c()     // Catch:{ Exception -> 0x01dc, all -> 0x01d7 }
            if (r15 == 0) goto L_0x00ab
            java.util.Set r16 = r15.keySet()     // Catch:{ Exception -> 0x01dc, all -> 0x01d7 }
            java.util.Iterator r16 = r16.iterator()     // Catch:{ Exception -> 0x01dc, all -> 0x01d7 }
        L_0x008d:
            boolean r17 = r16.hasNext()     // Catch:{ Exception -> 0x01dc, all -> 0x01d7 }
            if (r17 == 0) goto L_0x00ab
            java.lang.Object r17 = r16.next()     // Catch:{ Exception -> 0x01dc, all -> 0x01d7 }
            r13 = r17
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ Exception -> 0x01dc, all -> 0x01d7 }
            java.lang.Object r17 = r15.get(r13)     // Catch:{ Exception -> 0x01dc, all -> 0x01d7 }
            r18 = r6
            r6 = r17
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r12.addRequestProperty(r13, r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r6 = r18
            goto L_0x008d
        L_0x00ab:
            r18 = r6
            boolean r6 = r12 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            if (r6 == 0) goto L_0x0101
            boolean r6 = r11 instanceof com.cmic.sso.sdk.c.b.h     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            if (r6 != 0) goto L_0x00b9
            boolean r6 = r11 instanceof com.cmic.sso.sdk.c.b.e     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            if (r6 == 0) goto L_0x0101
        L_0x00b9:
            if (r0 == 0) goto L_0x00f7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r0.<init>()     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            java.lang.String r6 = "host = "
            r0.append(r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r0.append(r14)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            com.cmic.sso.sdk.e.c.b(r9, r0)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            java.lang.String r0 = "Host"
            r12.setRequestProperty(r0, r14)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            java.lang.String r0 = "need sni handle"
            com.cmic.sso.sdk.e.c.b(r9, r0)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r0 = r12
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            com.cmic.sso.sdk.c.d r6 = new com.cmic.sso.sdk.c.d     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r11 = r12
            javax.net.ssl.HttpsURLConnection r11 = (javax.net.ssl.HttpsURLConnection) r11     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            android.net.Network r13 = r20.g()     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r6.<init>(r11, r13, r4)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r0.setSSLSocketFactory(r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r0 = r12
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            com.cmic.sso.sdk.c.a.a$1 r6 = new com.cmic.sso.sdk.c.a.a$1     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r6.<init>(r14)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r0.setHostnameVerifier(r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            goto L_0x0101
        L_0x00f7:
            r0 = r12
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            javax.net.ssl.SSLSocketFactory r6 = r1.a(r11, r4)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r0.setSSLSocketFactory(r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
        L_0x0101:
            r0 = 1
            r12.setDoInput(r0)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r0 = 0
            r12.setInstanceFollowRedirects(r0)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r6 = 5000(0x1388, float:7.006E-42)
            r12.setConnectTimeout(r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r12.setReadTimeout(r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r12.setDefaultUseCaches(r0)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            java.lang.String r0 = r20.e()     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r12.setRequestMethod(r0)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r6 = 1
            r12.setDoOutput(r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            boolean r6 = r2 instanceof com.cmic.sso.sdk.c.c.b     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            if (r6 == 0) goto L_0x012c
            r12.connect()     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r6 = r2
            com.cmic.sso.sdk.c.c.b r6 = (com.cmic.sso.sdk.c.c.b) r6     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            r6.a(r4)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
        L_0x012c:
            java.lang.String r6 = "POST"
            boolean r0 = r0.endsWith(r6)     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            java.lang.String r6 = "utf-8"
            if (r0 == 0) goto L_0x0149
            java.io.OutputStream r11 = r12.getOutputStream()     // Catch:{ Exception -> 0x01d5, all -> 0x01d3 }
            java.lang.String r0 = r20.d()     // Catch:{ Exception -> 0x01d1, all -> 0x01cf }
            byte[] r0 = r0.getBytes(r6)     // Catch:{ Exception -> 0x01d1, all -> 0x01cf }
            r11.write(r0)     // Catch:{ Exception -> 0x01d1, all -> 0x01cf }
            r11.flush()     // Catch:{ Exception -> 0x01d1, all -> 0x01cf }
            goto L_0x014a
        L_0x0149:
            r11 = 0
        L_0x014a:
            int r15 = r12.getResponseCode()     // Catch:{ Exception -> 0x01d1, all -> 0x01cf }
            java.io.InputStream r13 = r12.getInputStream()     // Catch:{ Exception -> 0x01cc, all -> 0x01c8 }
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x01c6 }
        L_0x0156:
            int r14 = r13.read(r0)     // Catch:{ Exception -> 0x01c6 }
            if (r14 <= 0) goto L_0x016a
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x01c6 }
            r4 = 0
            r2.<init>(r0, r4, r14, r6)     // Catch:{ Exception -> 0x01c6 }
            r10.append(r2)     // Catch:{ Exception -> 0x01c6 }
            r2 = r20
            r4 = r22
            goto L_0x0156
        L_0x016a:
            com.cmic.sso.sdk.c.d.b r0 = new com.cmic.sso.sdk.c.d.b     // Catch:{ Exception -> 0x01c6 }
            java.util.Map r2 = r12.getHeaderFields()     // Catch:{ Exception -> 0x01c6 }
            java.lang.String r4 = r10.toString()     // Catch:{ Exception -> 0x01c6 }
            r0.<init>(r15, r2, r4)     // Catch:{ Exception -> 0x01c6 }
            r1.a(r11)
            r1.a(r13)
            if (r12 == 0) goto L_0x0182
            r12.disconnect()
        L_0x0182:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            com.cmic.sso.sdk.e.c.b(r9, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            boolean r4 = android.text.TextUtils.isEmpty(r10)
            if (r4 == 0) goto L_0x01a5
            r6 = r18
            goto L_0x01a9
        L_0x01a5:
            java.lang.String r6 = r10.toString()
        L_0x01a9:
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.cmic.sso.sdk.e.c.b(r9, r2)
            r2 = 200(0xc8, float:2.8E-43)
            if (r15 == r2) goto L_0x01c1
            r2 = 301(0x12d, float:4.22E-43)
            if (r15 == r2) goto L_0x01c1
            r2 = 302(0x12e, float:4.23E-43)
            if (r15 == r2) goto L_0x01c1
            goto L_0x028b
        L_0x01c1:
            r3.a((com.cmic.sso.sdk.c.d.b) r0)
            goto L_0x0297
        L_0x01c6:
            r0 = move-exception
            goto L_0x01f1
        L_0x01c8:
            r0 = move-exception
            r13 = 0
            goto L_0x0299
        L_0x01cc:
            r0 = move-exception
            r13 = 0
            goto L_0x01f1
        L_0x01cf:
            r0 = move-exception
            goto L_0x01e6
        L_0x01d1:
            r0 = move-exception
            goto L_0x01ef
        L_0x01d3:
            r0 = move-exception
            goto L_0x01da
        L_0x01d5:
            r0 = move-exception
            goto L_0x01df
        L_0x01d7:
            r0 = move-exception
            r18 = r6
        L_0x01da:
            r11 = 0
            goto L_0x01e6
        L_0x01dc:
            r0 = move-exception
            r18 = r6
        L_0x01df:
            r11 = 0
            goto L_0x01ef
        L_0x01e1:
            r0 = move-exception
            r18 = r6
            r11 = 0
            r12 = 0
        L_0x01e6:
            r13 = 0
            r15 = -1
            goto L_0x0299
        L_0x01ea:
            r0 = move-exception
            r18 = r6
            r11 = 0
            r12 = 0
        L_0x01ef:
            r13 = 0
            r15 = -1
        L_0x01f1:
            r0.printStackTrace()     // Catch:{ all -> 0x0298 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0298 }
            r2.<init>()     // Catch:{ all -> 0x0298 }
            java.lang.String r4 = "请求失败: "
            r2.append(r4)     // Catch:{ all -> 0x0298 }
            java.lang.String r4 = r20.a()     // Catch:{ all -> 0x0298 }
            r2.append(r4)     // Catch:{ all -> 0x0298 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0298 }
            com.cmic.sso.sdk.e.c.a(r9, r2)     // Catch:{ all -> 0x0298 }
            com.cmic.sso.sdk.d.a r2 = r22.a()     // Catch:{ all -> 0x0298 }
            java.util.concurrent.CopyOnWriteArrayList<java.lang.Throwable> r2 = r2.a     // Catch:{ all -> 0x0298 }
            r2.add(r0)     // Catch:{ all -> 0x0298 }
            boolean r2 = r0 instanceof java.io.EOFException     // Catch:{ all -> 0x0298 }
            if (r2 == 0) goto L_0x0220
            r2 = 200050(0x30d72, float:2.8033E-40)
            r15 = 200050(0x30d72, float:2.8033E-40)
            goto L_0x0226
        L_0x0220:
            r2 = 102102(0x18ed6, float:1.43075E-40)
            r15 = 102102(0x18ed6, float:1.43075E-40)
        L_0x0226:
            boolean r0 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x0298 }
            if (r0 == 0) goto L_0x0243
            com.cmic.sso.sdk.c.b.g r0 = r20.j()     // Catch:{ all -> 0x0298 }
            boolean r0 = r0 instanceof com.cmic.sso.sdk.c.b.h     // Catch:{ all -> 0x0298 }
            if (r0 != 0) goto L_0x023a
            com.cmic.sso.sdk.c.b.g r0 = r20.j()     // Catch:{ all -> 0x0298 }
            boolean r0 = r0 instanceof com.cmic.sso.sdk.c.b.e     // Catch:{ all -> 0x0298 }
            if (r0 == 0) goto L_0x0243
        L_0x023a:
            java.lang.String r0 = r19.a()     // Catch:{ all -> 0x0298 }
            r2 = r22
            r2.a((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ all -> 0x0298 }
        L_0x0243:
            r1.a(r11)
            r1.a(r13)
            if (r12 == 0) goto L_0x024e
            r12.disconnect()
        L_0x024e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            r0.append(r15)
            java.lang.String r0 = r0.toString()
            com.cmic.sso.sdk.e.c.b(r9, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r10)
            if (r2 == 0) goto L_0x0271
            r6 = r18
            goto L_0x0275
        L_0x0271:
            java.lang.String r6 = r10.toString()
        L_0x0275:
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            com.cmic.sso.sdk.e.c.b(r9, r0)
            r2 = 200(0xc8, float:2.8E-43)
            if (r15 == r2) goto L_0x0293
            r2 = 301(0x12d, float:4.22E-43)
            if (r15 == r2) goto L_0x0293
            r2 = 302(0x12e, float:4.23E-43)
            if (r15 == r2) goto L_0x0293
        L_0x028b:
            com.cmic.sso.sdk.c.d.a r0 = com.cmic.sso.sdk.c.d.a.a(r15)
            r3.a((com.cmic.sso.sdk.c.d.a) r0)
            goto L_0x0297
        L_0x0293:
            r2 = 0
            r3.a((com.cmic.sso.sdk.c.d.b) r2)
        L_0x0297:
            return
        L_0x0298:
            r0 = move-exception
        L_0x0299:
            r1.a(r11)
            r1.a(r13)
            if (r12 == 0) goto L_0x02a4
            r12.disconnect()
        L_0x02a4:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            com.cmic.sso.sdk.e.c.b(r9, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            boolean r4 = android.text.TextUtils.isEmpty(r10)
            if (r4 == 0) goto L_0x02c7
            r6 = r18
            goto L_0x02cb
        L_0x02c7:
            java.lang.String r6 = r10.toString()
        L_0x02cb:
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.cmic.sso.sdk.e.c.b(r9, r2)
            r2 = 200(0xc8, float:2.8E-43)
            if (r15 == r2) goto L_0x02e9
            r2 = 301(0x12d, float:4.22E-43)
            if (r15 == r2) goto L_0x02e9
            r2 = 302(0x12e, float:4.23E-43)
            if (r15 == r2) goto L_0x02e9
            com.cmic.sso.sdk.c.d.a r2 = com.cmic.sso.sdk.c.d.a.a(r15)
            r3.a((com.cmic.sso.sdk.c.d.a) r2)
            goto L_0x02ed
        L_0x02e9:
            r2 = 0
            r3.a((com.cmic.sso.sdk.c.d.b) r2)
        L_0x02ed:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.c.a.a.a(com.cmic.sso.sdk.c.c.c, com.cmic.sso.sdk.c.d.c, com.cmic.sso.sdk.a):void");
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String a() {
        return b.a[0] + IStringUtil.CURRENT_PATH + b.a[2] + IStringUtil.CURRENT_PATH + b.a[4] + IStringUtil.CURRENT_PATH + b.a[6];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.net.ssl.SSLSocketFactory a(com.cmic.sso.sdk.c.b.g r2, com.cmic.sso.sdk.a r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r2 = r2 instanceof com.cmic.sso.sdk.c.b.e     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0016
            com.cmic.sso.sdk.c.c r2 = new com.cmic.sso.sdk.c.c     // Catch:{ all -> 0x0029 }
            javax.net.ssl.SSLSocketFactory r0 = javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory()     // Catch:{ all -> 0x0029 }
            r2.<init>(r0, r3)     // Catch:{ all -> 0x0029 }
            com.cmic.sso.sdk.c.c r3 = a     // Catch:{ all -> 0x0029 }
            if (r3 != 0) goto L_0x0014
            a = r2     // Catch:{ all -> 0x0029 }
        L_0x0014:
            monitor-exit(r1)
            return r2
        L_0x0016:
            com.cmic.sso.sdk.c.c r2 = a     // Catch:{ all -> 0x0029 }
            if (r2 != 0) goto L_0x0025
            com.cmic.sso.sdk.c.c r2 = new com.cmic.sso.sdk.c.c     // Catch:{ all -> 0x0029 }
            javax.net.ssl.SSLSocketFactory r0 = javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory()     // Catch:{ all -> 0x0029 }
            r2.<init>(r0, r3)     // Catch:{ all -> 0x0029 }
            a = r2     // Catch:{ all -> 0x0029 }
        L_0x0025:
            com.cmic.sso.sdk.c.c r2 = a     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)
            return r2
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.c.a.a.a(com.cmic.sso.sdk.c.b.g, com.cmic.sso.sdk.a):javax.net.ssl.SSLSocketFactory");
    }
}
