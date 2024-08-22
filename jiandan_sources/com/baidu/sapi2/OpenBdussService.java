package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.wallet.core.beans.BeanConstants;
import java.util.ArrayList;

public class OpenBdussService extends AbstractService implements NoProguard {
    public Context context;

    public OpenBdussService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
        this.context = sapiConfiguration.context;
    }

    public int getBdussState() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String cookieBduss = SapiUtils.getCookieBduss();
        if (currentAccount == null && TextUtils.isEmpty(cookieBduss)) {
            return 1;
        }
        if (currentAccount == null && !TextUtils.isEmpty(cookieBduss)) {
            return 2;
        }
        if (currentAccount == null || !TextUtils.isEmpty(cookieBduss)) {
            return (currentAccount == null || cookieBduss.equals(currentAccount.bduss)) ? 0 : 4;
        }
        return 3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00dd A[LOOP:1: B:30:0x00d5->B:32:0x00dd, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getOpenBduss(com.baidu.sapi2.dto.GetOpenBdussDTO r15, com.baidu.sapi2.callback.GetOpenBdussCallback r16) {
        /*
            r14 = this;
            r5 = r15
            r3 = r16
            java.lang.String r0 = "GetOpenBdussCallback can't be null"
            com.baidu.sapi2.utils.SapiUtils.notNull(r3, r0)
            java.lang.String r0 = "GetOpenBdussDTO can't be null"
            com.baidu.sapi2.utils.SapiUtils.notNull(r15, r0)
            java.lang.String r0 = r5.clientId
            java.lang.String r1 = "GetOpenBdussDTO.clientId can't empty"
            com.baidu.sapi2.utils.SapiUtils.notEmpty(r0, r1)
            com.baidu.sapi2.SapiContext r0 = com.baidu.sapi2.SapiContext.getInstance()
            com.baidu.sapi2.SapiAccount r4 = r0.getCurrentAccount()
            if (r4 != 0) goto L_0x002c
            com.baidu.sapi2.result.OpenBdussResult r0 = new com.baidu.sapi2.result.OpenBdussResult
            r0.<init>()
            r1 = -901(0xfffffffffffffc7b, float:NaN)
            r0.setResultCode(r1)
            r3.onFailure(r0)
            return
        L_0x002c:
            com.baidu.sapi2.SapiContext r0 = com.baidu.sapi2.SapiContext.getInstance()
            java.lang.String r1 = "open_bduss_info"
            java.lang.String r0 = r0.getDecryptStr(r1)
            com.baidu.sapi2.result.OpenBdussResult r6 = com.baidu.sapi2.result.OpenBdussResult.fromJson(r0)
            java.lang.String r0 = ""
            r2 = 1
            r7 = 0
            if (r6 == 0) goto L_0x008e
            int r8 = r6.getResultCode()
            if (r8 != 0) goto L_0x008e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r4.bduss
            r8.append(r9)
            java.lang.String r9 = r5.clientId
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            byte[] r8 = r8.getBytes()
            java.lang.String r8 = fe.fe.ppp.ad.ad.rg(r8, r7)
            java.lang.String r9 = r6.flag
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x008e
            java.util.List<java.lang.String> r1 = r5.targetTplList
            java.util.Iterator r1 = r1.iterator()
        L_0x006f:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x0085
            java.lang.Object r8 = r1.next()
            java.lang.String r8 = (java.lang.String) r8
            java.util.Map<java.lang.String, java.lang.String> r9 = r6.tplStokenMap
            boolean r8 = r9.containsKey(r8)
            if (r8 != 0) goto L_0x006f
            r1 = 0
            goto L_0x0086
        L_0x0085:
            r1 = 1
        L_0x0086:
            if (r1 == 0) goto L_0x009e
            r6.flag = r0
            r3.onSuccess(r6)
            return
        L_0x008e:
            com.baidu.sapi2.SapiContext r8 = com.baidu.sapi2.SapiContext.getInstance()
            r8.putEncryptStr(r1, r0)
            if (r6 == 0) goto L_0x009e
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.tplStokenMap
            if (r0 == 0) goto L_0x009e
            r0.clear()
        L_0x009e:
            com.baidu.sapi2.httpwrap.HttpHashMapWrap r10 = new com.baidu.sapi2.httpwrap.HttpHashMapWrap
            r10.<init>()
            java.lang.String r0 = r5.clientId
            java.lang.String r1 = "client_id"
            r10.put(r1, r0)
            java.lang.String r0 = r4.bduss
            java.lang.String r1 = "bduss"
            r10.put(r1, r0)
            java.lang.String r0 = r4.ptoken
            java.lang.String r1 = "ptoken"
            r10.put(r1, r0)
            java.lang.String r0 = "/v3/login/api/authopenbduss"
            java.lang.String r0 = com.baidu.sapi2.utils.SapiDeviceInfo.getDeviceInfo(r0)
            java.lang.String r1 = "di"
            r10.put(r1, r0)
            java.util.List<java.lang.String> r0 = r5.targetTplList
            if (r0 == 0) goto L_0x0101
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0101
            java.util.List<java.lang.String> r0 = r5.targetTplList
            java.lang.Object r0 = r0.get(r7)
            java.lang.String r0 = (java.lang.String) r0
        L_0x00d5:
            java.util.List<java.lang.String> r1 = r5.targetTplList
            int r1 = r1.size()
            if (r2 >= r1) goto L_0x00fc
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "|"
            r1.append(r0)
            java.util.List<java.lang.String> r0 = r5.targetTplList
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            int r2 = r2 + 1
            goto L_0x00d5
        L_0x00fc:
            java.lang.String r1 = "tpl_list"
            r10.put(r1, r0)
        L_0x0101:
            com.baidu.sapi2.httpwrap.HttpClientWrap r8 = new com.baidu.sapi2.httpwrap.HttpClientWrap
            r8.<init>()
            r11 = 0
            java.lang.String r12 = r14.getUaInfo()
            com.baidu.sapi2.OpenBdussService$1 r13 = new com.baidu.sapi2.OpenBdussService$1
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r0 = r13
            r1 = r14
            r3 = r16
            r5 = r15
            r0.<init>(r2, r3, r4, r5, r6)
            java.lang.String r9 = "/v3/login/api/authopenbduss"
            r8.post(r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.OpenBdussService.getOpenBduss(com.baidu.sapi2.dto.GetOpenBdussDTO, com.baidu.sapi2.callback.GetOpenBdussCallback):void");
    }

    public void logout() {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() {
            public void run() {
                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
                try {
                    ArrayList arrayList = new ArrayList();
                    for (String next : SapiContext.getInstance().getOpenBdussDomains()) {
                        arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + next, SapiUtils.buildBDUSSCookie(next, BeanConstants.COOKIE_OPENBDUSS, "")));
                    }
                    SapiUtils.syncCookies(OpenBdussService.this.context, arrayList);
                } catch (Throwable th2) {
                    Log.e(th2);
                }
            }
        }));
    }
}
