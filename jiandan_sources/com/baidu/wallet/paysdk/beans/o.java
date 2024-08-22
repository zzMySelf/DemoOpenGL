package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import java.util.ArrayList;
import java.util.List;

public class o extends p {
    public <T> o(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r1 = (r1 = r1.pay).easypay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x0016
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r1 = r1.pay
            if (r1 == 0) goto L_0x0016
            com.baidu.wallet.base.datamodel.PayData$EasyPay r1 = r1.easypay
            if (r1 == 0) goto L_0x0016
            java.lang.String r1 = r1.getService()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0016
            r1 = 1
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.beans.o.a(com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse):boolean");
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("request_type", "15"));
        if (b.a()) {
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            if (a(payResponse)) {
                arrayList.add(new RestNameValuePair("service", payResponse.pay.easypay.getService()));
            } else {
                if (b.c()) {
                    arrayList.add(new RestNameValuePair("service", LBSPayAli.ALI_AUTH_PAY));
                }
                if (b.b()) {
                    arrayList.add(new RestNameValuePair("service", "authorize_pure"));
                }
            }
        }
        CardData.BondCard bondCard = ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY)).mBondCard;
        if (bondCard != null) {
            arrayList.add(new RestNameValuePair("card_no_bind", bondCard.account_no));
            arrayList.add(new RestNameValuePair("sub_bank_code", bondCard.bank_code));
        }
        return arrayList;
    }

    public int getBeanId() {
        return 15;
    }
}
