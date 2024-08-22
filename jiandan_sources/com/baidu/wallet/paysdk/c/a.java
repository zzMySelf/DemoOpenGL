package com.baidu.wallet.paysdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.utils.realtimeevent.RealTimeEventHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
    public String a;
    public boolean b;
    public boolean c;
    public HashMap<String, DirectPayContentResponse> d;
    public HashMap<String, String> e;
    public HashMap<String, String> f;

    /* renamed from: com.baidu.wallet.paysdk.c.a$a  reason: collision with other inner class name */
    public static class C0163a {
        public static a a = new a();
    }

    public static a a() {
        return C0163a.a;
    }

    private void k() {
        HashMap<String, DirectPayContentResponse> hashMap = this.d;
        if (hashMap != null) {
            hashMap.clear();
            this.d = null;
        }
        HashMap<String, String> hashMap2 = this.e;
        if (hashMap2 != null) {
            hashMap2.clear();
            this.e = null;
        }
        HashMap<String, String> hashMap3 = this.f;
        if (hashMap3 != null) {
            hashMap3.clear();
            this.f = null;
        }
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public String d() {
        return this.a;
    }

    public DirectPayContentResponse e() {
        HashMap<String, DirectPayContentResponse> hashMap;
        if (TextUtils.isEmpty(this.a) || (hashMap = this.d) == null || hashMap.isEmpty()) {
            return null;
        }
        return this.d.get(this.a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r0.pay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String f() {
        /*
            r2 = this;
            com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r0 = r2.e()
            if (r0 == 0) goto L_0x0017
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r1 = r0.pay
            if (r1 == 0) goto L_0x0017
            java.lang.String r1 = r1.session_info
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0017
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r0.pay
            java.lang.String r0 = r0.session_info
            goto L_0x0019
        L_0x0017:
            java.lang.String r0 = ""
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.c.a.f():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String g() {
        /*
            r2 = this;
            java.lang.String r0 = r2.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001d
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r2.e
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001d
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r2.e
            java.lang.String r1 = r2.a
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x001f
        L_0x001d:
            java.lang.String r0 = ""
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.c.a.g():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String h() {
        /*
            r2 = this;
            java.lang.String r0 = r2.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x001d
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r2.f
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x001d
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r2.f
            java.lang.String r1 = r2.a
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x001f
        L_0x001d:
            java.lang.String r0 = ""
        L_0x001f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.c.a.h():java.lang.String");
    }

    public List<RestNameValuePair> i() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        Map<String, String> map;
        DirectPayContentResponse e2 = e();
        ArrayList arrayList = new ArrayList();
        if (!(e2 == null || (directPayPay = e2.pay) == null || (directPayBalance = directPayPay.licaibalance) == null || (map = directPayBalance.post_info) == null)) {
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(new RestNameValuePair((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    public void j() {
        this.b = false;
        this.c = false;
        this.a = "";
        k();
    }

    public a() {
        this.a = "";
        this.b = false;
        this.c = false;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = RealTimeEventHelper.getSinalParam(str, "repayment_trans_id");
            this.c = "1".equals(RealTimeEventHelper.getSinalParam(str, "need_fund_combine"));
            this.b = BannerBaseItemInfo.TYPE_LOGIN.equals(RealTimeEventHelper.getSinalParam(str, "pay_type"));
        }
    }

    public void a(Context context, DirectPayContentResponse directPayContentResponse, PayRequest payRequest) {
        if (payRequest == null) {
            PayCallBackManager.callBackLicaiBalance(context, 5, "", "", "");
        } else if (directPayContentResponse == null) {
            PayCallBackManager.callBackLicaiBalance(context, 5, payRequest.mOrderNo, "", "");
        } else {
            String insideTransOrder = PayDataCache.getInstance().getInsideTransOrder();
            if (!TextUtils.isEmpty(insideTransOrder)) {
                if (this.d == null) {
                    this.d = new HashMap<>();
                }
                this.d.put(insideTransOrder, directPayContentResponse);
                String sessionId = NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null);
                if (!TextUtils.isEmpty(sessionId)) {
                    if (this.e == null) {
                        this.e = new HashMap<>();
                    }
                    this.e.put(insideTransOrder, sessionId);
                }
                if (this.f == null) {
                    this.f = new HashMap<>();
                }
                this.f.put(insideTransOrder, payRequest.mOrderNo);
            }
            PayCallBackManager.callBackLicaiBalance(context, 4, payRequest.mOrderNo, "", insideTransOrder);
        }
    }
}
