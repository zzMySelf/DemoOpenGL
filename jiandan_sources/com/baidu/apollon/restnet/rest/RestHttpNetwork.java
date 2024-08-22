package com.baidu.apollon.restnet.rest;

public class RestHttpNetwork implements c {
    public static final int a = 30000;
    public static final int b = 30000;
    public static final int c = 10;
    public static final int d = 10;
    public static final int e = 8192;
    public static final int f = 1;
    public static final int g = 1000;
    public static final String h = "RestHttpNetwork";

    /* renamed from: i  reason: collision with root package name */
    public final c f710i;
    public final g j = new g(1, 1000);

    public RestHttpNetwork(c cVar) {
        this.f710i = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.apollon.restnet.rest.e a(com.baidu.apollon.restnet.rest.d r11) throws java.lang.Exception {
        /*
            r10 = this;
            java.lang.String r0 = r11.h()
            com.baidu.apollon.restnet.c$a r1 = com.baidu.apollon.restnet.c.a()
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 1
            r6 = 0
        L_0x000d:
            if (r5 == 0) goto L_0x00de
            com.baidu.apollon.restnet.rest.c r4 = r10.f710i     // Catch:{ UnknownHostException -> 0x0083, NullPointerException -> 0x005c, TimeoutException -> 0x0038, IOException -> 0x002d }
            com.baidu.apollon.restnet.rest.e r4 = r4.a(r11)     // Catch:{ UnknownHostException -> 0x0083, NullPointerException -> 0x005c, TimeoutException -> 0x0038, IOException -> 0x002d }
            if (r4 == 0) goto L_0x002c
            com.baidu.apollon.restnet.http.HttpStatus r5 = r4.e()     // Catch:{ UnknownHostException -> 0x0083, NullPointerException -> 0x005c, TimeoutException -> 0x0038, IOException -> 0x002d }
            com.baidu.apollon.restnet.http.HttpStatus r7 = com.baidu.apollon.restnet.http.HttpStatus.OK     // Catch:{ UnknownHostException -> 0x0083, NullPointerException -> 0x005c, TimeoutException -> 0x0038, IOException -> 0x002d }
            if (r5 != r7) goto L_0x002c
            if (r1 == 0) goto L_0x002c
            java.lang.String r5 = r11.h()     // Catch:{ UnknownHostException -> 0x0083, NullPointerException -> 0x005c, TimeoutException -> 0x0038, IOException -> 0x002d }
            java.lang.String r7 = r11.c()     // Catch:{ UnknownHostException -> 0x0083, NullPointerException -> 0x005c, TimeoutException -> 0x0038, IOException -> 0x002d }
            r1.a(r5, r7)     // Catch:{ UnknownHostException -> 0x0083, NullPointerException -> 0x005c, TimeoutException -> 0x0038, IOException -> 0x002d }
        L_0x002c:
            return r4
        L_0x002d:
            r4 = move-exception
            com.baidu.apollon.restnet.rest.g r5 = r10.j
            int r6 = r6 + 1
            boolean r5 = r5.a((java.lang.Exception) r4, (int) r6)
            goto L_0x00ae
        L_0x0038:
            r4 = move-exception
            java.util.concurrent.TimeoutException r5 = new java.util.concurrent.TimeoutException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "TimeoutException exception: "
            r7.append(r8)
            java.lang.String r8 = r4.getMessage()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.<init>(r7)
            com.baidu.apollon.restnet.rest.g r7 = r10.j
            int r6 = r6 + 1
            boolean r4 = r7.a((java.lang.Exception) r4, (int) r6)
            goto L_0x007f
        L_0x005c:
            r4 = move-exception
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "NPE in HttpClient: "
            r7.append(r8)
            java.lang.String r4 = r4.getMessage()
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r5.<init>(r4)
            com.baidu.apollon.restnet.rest.g r4 = r10.j
            int r6 = r6 + 1
            boolean r4 = r4.a((java.lang.Exception) r5, (int) r6)
        L_0x007f:
            r9 = r5
            r5 = r4
            r4 = r9
            goto L_0x00ae
        L_0x0083:
            r4 = move-exception
            java.net.UnknownHostException r5 = new java.net.UnknownHostException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "UnknownHostException exception: "
            r7.append(r8)
            java.lang.String r8 = r4.getMessage()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.<init>(r7)
            if (r6 <= 0) goto L_0x00ac
            com.baidu.apollon.restnet.rest.g r7 = r10.j
            int r6 = r6 + 1
            boolean r4 = r7.a((java.lang.Exception) r4, (int) r6)
            if (r4 == 0) goto L_0x00ac
            r4 = 1
            goto L_0x007f
        L_0x00ac:
            r4 = 0
            goto L_0x007f
        L_0x00ae:
            if (r5 == 0) goto L_0x00b2
            goto L_0x000d
        L_0x00b2:
            if (r1 == 0) goto L_0x00de
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RestHttpNetwork performRequest retry count:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " failure, url:"
            r1.append(r2)
            java.lang.String r11 = r11.c()
            r1.append(r11)
            java.lang.String r11 = ", origUrl:"
            r1.append(r11)
            r1.append(r0)
            java.lang.String r11 = r1.toString()
            java.lang.String r0 = "RestHttpNetwork"
            com.baidu.apollon.utils.LogUtil.errord(r0, r11)
        L_0x00de:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.restnet.rest.RestHttpNetwork.a(com.baidu.apollon.restnet.rest.d):com.baidu.apollon.restnet.rest.e");
    }

    public void a() {
        this.f710i.a();
    }
}
