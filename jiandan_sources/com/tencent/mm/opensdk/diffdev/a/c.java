package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

public class c extends AsyncTask<Void, Void, a> {
    public String a;
    public String b;
    public OAuthListener c;
    public int d;

    public static class a {
        public OAuthErrCode a;
        public String b;
        public int c;
    }

    public c(String str, OAuthListener oAuthListener) {
        this.a = str;
        this.c = oAuthListener;
        this.b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", new Object[]{str});
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0168 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doInBackground(java.lang.Object[] r14) {
        /*
            r13 = this;
            java.lang.Void[] r14 = (java.lang.Void[]) r14
            java.lang.Thread r14 = java.lang.Thread.currentThread()
            java.lang.String r0 = "OpenSdkNoopingTask"
            r14.setName(r0)
            java.lang.String r14 = r13.a
            java.lang.String r0 = "MicroMsg.SDK.NoopingTask"
            if (r14 == 0) goto L_0x018f
            int r14 = r14.length()
            if (r14 != 0) goto L_0x0019
            goto L_0x018f
        L_0x0019:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = "doInBackground start "
            r14.append(r1)
            boolean r1 = r13.isCancelled()
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            com.tencent.mm.opensdk.utils.Log.i(r0, r14)
        L_0x0031:
            boolean r14 = r13.isCancelled()
            if (r14 != 0) goto L_0x0182
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r1 = r13.b
            r14.append(r1)
            int r1 = r13.d
            if (r1 != 0) goto L_0x0048
            java.lang.String r1 = ""
            goto L_0x005b
        L_0x0048:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "&last="
            r1.append(r2)
            int r2 = r13.d
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x005b:
            r14.append(r1)
            java.lang.String r14 = r14.toString()
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 60000(0xea60, float:8.4078E-41)
            byte[] r3 = com.tencent.mm.opensdk.channel.a.a.a((java.lang.String) r14, (int) r3)
            long r4 = java.lang.System.currentTimeMillis()
            com.tencent.mm.opensdk.diffdev.a.c$a r6 = new com.tencent.mm.opensdk.diffdev.a.c$a
            r6.<init>()
            java.lang.String r7 = "MicroMsg.SDK.NoopingResult"
            java.lang.String r8 = "star parse NoopingResult"
            com.tencent.mm.opensdk.utils.Log.d(r7, r8)
            r8 = 1
            r9 = 0
            if (r3 == 0) goto L_0x00f9
            int r10 = r3.length
            if (r10 != 0) goto L_0x0086
            goto L_0x00f9
        L_0x0086:
            java.lang.String r10 = new java.lang.String     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r11 = "utf-8"
            r10.<init>(r3, r11)     // Catch:{ Exception -> 0x00e4 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00d4 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r10 = "wx_errcode"
            int r10 = r3.getInt(r10)     // Catch:{ Exception -> 0x00d4 }
            r6.c = r10     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r11 = "nooping uuidStatusCode = %d"
            java.lang.Object[] r12 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x00d4 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00d4 }
            r12[r9] = r10     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r10 = java.lang.String.format(r11, r12)     // Catch:{ Exception -> 0x00d4 }
            com.tencent.mm.opensdk.utils.Log.d(r7, r10)     // Catch:{ Exception -> 0x00d4 }
            int r10 = r6.c     // Catch:{ Exception -> 0x00d4 }
            r11 = 408(0x198, float:5.72E-43)
            if (r10 == r11) goto L_0x00cf
            r11 = 500(0x1f4, float:7.0E-43)
            if (r10 == r11) goto L_0x00cc
            switch(r10) {
                case 402: goto L_0x00c9;
                case 403: goto L_0x00c6;
                case 404: goto L_0x00cf;
                case 405: goto L_0x00b9;
                default: goto L_0x00b8;
            }     // Catch:{ Exception -> 0x00d4 }
        L_0x00b8:
            goto L_0x00cc
        L_0x00b9:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r10 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK     // Catch:{ Exception -> 0x00d4 }
            r6.a = r10     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r10 = "wx_code"
            java.lang.String r3 = r3.getString(r10)     // Catch:{ Exception -> 0x00d4 }
            r6.b = r3     // Catch:{ Exception -> 0x00d4 }
            goto L_0x0102
        L_0x00c6:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Cancel     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d1
        L_0x00c9:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Timeout     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d1
        L_0x00cc:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d1
        L_0x00cf:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK     // Catch:{ Exception -> 0x00d4 }
        L_0x00d1:
            r6.a = r3     // Catch:{ Exception -> 0x00d4 }
            goto L_0x0102
        L_0x00d4:
            r3 = move-exception
            java.lang.Object[] r10 = new java.lang.Object[r8]
            java.lang.String r3 = r3.getMessage()
            r10[r9] = r3
            java.lang.String r3 = "parse json fail, ex = %s"
            java.lang.String r3 = java.lang.String.format(r3, r10)
            goto L_0x00f3
        L_0x00e4:
            r3 = move-exception
            java.lang.Object[] r10 = new java.lang.Object[r8]
            java.lang.String r3 = r3.getMessage()
            r10[r9] = r3
            java.lang.String r3 = "parse fail, build String fail, ex = %s"
            java.lang.String r3 = java.lang.String.format(r3, r10)
        L_0x00f3:
            com.tencent.mm.opensdk.utils.Log.e(r7, r3)
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr
            goto L_0x0100
        L_0x00f9:
            java.lang.String r3 = "parse fail, buf is null"
            com.tencent.mm.opensdk.utils.Log.e(r7, r3)
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r3 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NetworkErr
        L_0x0100:
            r6.a = r3
        L_0x0102:
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r9] = r14
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r14 = r6.a
            java.lang.String r14 = r14.toString()
            r3[r8] = r14
            int r14 = r6.c
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r7 = 2
            r3[r7] = r14
            long r4 = r4 - r1
            java.lang.Long r14 = java.lang.Long.valueOf(r4)
            r1 = 3
            r3[r1] = r14
            java.lang.String r14 = "nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)"
            java.lang.String r14 = java.lang.String.format(r14, r3)
            com.tencent.mm.opensdk.utils.Log.d(r0, r14)
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r14 = r6.a
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r1 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_OK
            if (r14 != r1) goto L_0x0168
            int r14 = r6.c
            r13.d = r14
            com.tencent.mm.opensdk.diffdev.a.d r1 = com.tencent.mm.opensdk.diffdev.a.d.UUID_SCANED
            int r1 = r1.a()
            if (r14 != r1) goto L_0x0142
            com.tencent.mm.opensdk.diffdev.OAuthListener r14 = r13.c
            r14.onQrcodeScanned()
            goto L_0x0031
        L_0x0142:
            int r14 = r6.c
            com.tencent.mm.opensdk.diffdev.a.d r1 = com.tencent.mm.opensdk.diffdev.a.d.UUID_KEEP_CONNECT
            int r1 = r1.a()
            if (r14 != r1) goto L_0x014e
            goto L_0x0031
        L_0x014e:
            int r14 = r6.c
            com.tencent.mm.opensdk.diffdev.a.d r1 = com.tencent.mm.opensdk.diffdev.a.d.UUID_CONFIRM
            int r1 = r1.a()
            if (r14 != r1) goto L_0x0031
            java.lang.String r14 = r6.b
            if (r14 == 0) goto L_0x0162
            int r14 = r14.length()
            if (r14 != 0) goto L_0x019d
        L_0x0162:
            java.lang.String r14 = "nooping fail, confirm with an empty code!!!"
            com.tencent.mm.opensdk.utils.Log.e(r0, r14)
            goto L_0x0199
        L_0x0168:
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.String r14 = r14.toString()
            r1[r9] = r14
            int r14 = r6.c
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r1[r8] = r14
            java.lang.String r14 = "nooping fail, errCode = %s, uuidStatusCode = %d"
            java.lang.String r14 = java.lang.String.format(r14, r1)
            com.tencent.mm.opensdk.utils.Log.e(r0, r14)
            goto L_0x019d
        L_0x0182:
            java.lang.String r14 = "IDiffDevOAuth.stopAuth / detach invoked"
            com.tencent.mm.opensdk.utils.Log.i(r0, r14)
            com.tencent.mm.opensdk.diffdev.a.c$a r6 = new com.tencent.mm.opensdk.diffdev.a.c$a
            r6.<init>()
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r14 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_Auth_Stopped
            goto L_0x019b
        L_0x018f:
            java.lang.String r14 = "run fail, uuid is null"
            com.tencent.mm.opensdk.utils.Log.e(r0, r14)
            com.tencent.mm.opensdk.diffdev.a.c$a r6 = new com.tencent.mm.opensdk.diffdev.a.c$a
            r6.<init>()
        L_0x0199:
            com.tencent.mm.opensdk.diffdev.OAuthErrCode r14 = com.tencent.mm.opensdk.diffdev.OAuthErrCode.WechatAuth_Err_NormalErr
        L_0x019b:
            r6.a = r14
        L_0x019d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    public void onPostExecute(Object obj) {
        a aVar = (a) obj;
        this.c.onAuthFinish(aVar.a, aVar.b);
    }
}
