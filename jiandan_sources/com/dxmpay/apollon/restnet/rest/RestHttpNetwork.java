package com.dxmpay.apollon.restnet.rest;

import fe.i.qw.th.de.fe;

public class RestHttpNetwork implements c {

    /* renamed from: ad  reason: collision with root package name */
    public final fe f4029ad = new fe(3, 1000);
    public final c qw;

    public RestHttpNetwork(c cVar) {
        this.qw = cVar;
    }

    public void close() {
        this.qw.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cc A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.dxmpay.apollon.restnet.rest.e performRequest(com.dxmpay.apollon.restnet.rest.d r12) throws java.lang.Exception {
        /*
            r11 = this;
            java.lang.String r0 = r12.f()
            com.dxmpay.apollon.restnet.a$a r1 = com.dxmpay.apollon.restnet.a.qw()
            r2 = 0
            r3 = 1
            r4 = 0
            r5 = 1
            r6 = 0
        L_0x000d:
            if (r5 == 0) goto L_0x00f8
            if (r6 <= 0) goto L_0x0029
            if (r4 == 0) goto L_0x0018
            java.lang.String r4 = r4.toString()
            goto L_0x001a
        L_0x0018:
            java.lang.String r4 = ""
        L_0x001a:
            com.dxmpay.wallet.statistics.NetStepStatManager r5 = com.dxmpay.wallet.statistics.NetStepStatManager.getInstance()
            java.lang.String r7 = r12.h()
            long r8 = r12.g()
            r5.increaseRetryCount(r7, r8, r4)
        L_0x0029:
            com.dxmpay.apollon.restnet.rest.c r4 = r11.qw     // Catch:{ UnknownHostException -> 0x009d, NullPointerException -> 0x0076, TimeoutException -> 0x0052, IOException -> 0x0047 }
            com.dxmpay.apollon.restnet.rest.e r4 = r4.performRequest(r12)     // Catch:{ UnknownHostException -> 0x009d, NullPointerException -> 0x0076, TimeoutException -> 0x0052, IOException -> 0x0047 }
            if (r4 == 0) goto L_0x0046
            com.dxmpay.apollon.restnet.http.HttpStatus r5 = r4.d()     // Catch:{ UnknownHostException -> 0x009d, NullPointerException -> 0x0076, TimeoutException -> 0x0052, IOException -> 0x0047 }
            com.dxmpay.apollon.restnet.http.HttpStatus r7 = com.dxmpay.apollon.restnet.http.HttpStatus.OK     // Catch:{ UnknownHostException -> 0x009d, NullPointerException -> 0x0076, TimeoutException -> 0x0052, IOException -> 0x0047 }
            if (r5 != r7) goto L_0x0046
            if (r1 == 0) goto L_0x0046
            java.lang.String r5 = r12.f()     // Catch:{ UnknownHostException -> 0x009d, NullPointerException -> 0x0076, TimeoutException -> 0x0052, IOException -> 0x0047 }
            java.lang.String r7 = r12.b()     // Catch:{ UnknownHostException -> 0x009d, NullPointerException -> 0x0076, TimeoutException -> 0x0052, IOException -> 0x0047 }
            r1.a(r5, r7)     // Catch:{ UnknownHostException -> 0x009d, NullPointerException -> 0x0076, TimeoutException -> 0x0052, IOException -> 0x0047 }
        L_0x0046:
            return r4
        L_0x0047:
            r4 = move-exception
            fe.i.qw.th.de.fe r5 = r11.f4029ad
            int r6 = r6 + 1
            boolean r5 = r5.qw(r4, r6)
            goto L_0x00c8
        L_0x0052:
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
            fe.i.qw.th.de.fe r7 = r11.f4029ad
            int r6 = r6 + 1
            boolean r4 = r7.qw(r4, r6)
            goto L_0x0099
        L_0x0076:
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
            fe.i.qw.th.de.fe r4 = r11.f4029ad
            int r6 = r6 + 1
            boolean r4 = r4.qw(r5, r6)
        L_0x0099:
            r10 = r5
            r5 = r4
            r4 = r10
            goto L_0x00c8
        L_0x009d:
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
            if (r6 <= 0) goto L_0x00c6
            fe.i.qw.th.de.fe r7 = r11.f4029ad
            int r6 = r6 + 1
            boolean r4 = r7.qw(r4, r6)
            if (r4 == 0) goto L_0x00c6
            r4 = 1
            goto L_0x0099
        L_0x00c6:
            r4 = 0
            goto L_0x0099
        L_0x00c8:
            if (r5 == 0) goto L_0x00cc
            goto L_0x000d
        L_0x00cc:
            if (r1 == 0) goto L_0x00f8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "RestHttpNetwork performRequest retry count:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = " failure, url:"
            r1.append(r2)
            java.lang.String r12 = r12.b()
            r1.append(r12)
            java.lang.String r12 = ", origUrl:"
            r1.append(r12)
            r1.append(r0)
            java.lang.String r12 = r1.toString()
            java.lang.String r0 = "RestHttpNetwork"
            com.dxmpay.apollon.utils.LogUtil.errord(r0, r12)
        L_0x00f8:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.restnet.rest.RestHttpNetwork.performRequest(com.dxmpay.apollon.restnet.rest.d):com.dxmpay.apollon.restnet.rest.e");
    }
}
