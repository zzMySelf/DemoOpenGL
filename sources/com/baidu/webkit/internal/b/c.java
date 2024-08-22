package com.baidu.webkit.internal.b;

/* compiled from: AndroidSystemUrlHandler */
public final class c extends g {
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "wtai://"
            boolean r1 = r8.startsWith(r1)
            java.lang.String r2 = "android.intent.action.DIAL"
            java.lang.String r3 = "tel:"
            r4 = 1
            if (r1 == 0) goto L_0x0039
            int r1 = r8.length()
            r5 = 13
            if (r1 <= r5) goto L_0x0037
            java.lang.String r8 = r8.substring(r5)
            if (r7 == 0) goto L_0x0036
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r8 = r3.concat(r8)
            android.content.Intent r0 = new android.content.Intent
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r0.<init>(r2, r8)
            a((android.content.Context) r7, (android.content.Intent) r0)
        L_0x0036:
            return r4
        L_0x0037:
            goto L_0x00b2
        L_0x0039:
            boolean r1 = r8.startsWith(r3)
            if (r1 == 0) goto L_0x0051
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x004c }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x004c }
            r0.<init>(r2, r8)     // Catch:{ Exception -> 0x004c }
            r7.startActivity(r0)     // Catch:{ Exception -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0050:
            return r4
        L_0x0051:
            java.lang.String r1 = "sms:"
            boolean r2 = r8.startsWith(r1)
            if (r2 == 0) goto L_0x00b2
            r0 = 0
            java.lang.String r2 = "?"
            int r2 = r8.indexOf(r2)     // Catch:{ Exception -> 0x008c }
            r3 = -1
            r5 = 4
            if (r2 != r3) goto L_0x006c
            java.lang.String r8 = r8.substring(r5)     // Catch:{ Exception -> 0x008c }
            goto L_0x0092
        L_0x006c:
            java.lang.String r2 = r8.substring(r5, r2)     // Catch:{ Exception -> 0x008c }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ Exception -> 0x008a }
            java.lang.String r8 = r8.getQuery()     // Catch:{ Exception -> 0x008a }
            if (r8 == 0) goto L_0x0088
            java.lang.String r3 = "body="
            boolean r3 = r8.startsWith(r3)     // Catch:{ Exception -> 0x008a }
            if (r3 == 0) goto L_0x0088
            r3 = 5
            java.lang.String r8 = r8.substring(r3)     // Catch:{ Exception -> 0x008a }
            r0 = r8
        L_0x0088:
            r8 = r2
            goto L_0x0092
        L_0x008a:
            r8 = move-exception
            goto L_0x008e
        L_0x008c:
            r8 = move-exception
            r2 = r0
        L_0x008e:
            r8.printStackTrace()
            r8 = r2
        L_0x0092:
            if (r7 == 0) goto L_0x00b1
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r8 = r1.concat(r8)
            android.net.Uri r8 = android.net.Uri.parse(r8)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r2 = "android.intent.action.VIEW"
            r1.<init>(r2, r8)
            java.lang.String r8 = "sms_body"
            r1.putExtra(r8, r0)
            a((android.content.Context) r7, (android.content.Intent) r1)
        L_0x00b1:
            return r4
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.internal.b.c.a(android.content.Context, java.lang.String):boolean");
    }
}
