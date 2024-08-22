package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;

public class ag extends BaseBean<Object> {
    public BindFastRequest a;
    public PayRequest b = ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY));
    public boolean c = false;

    public <T> ag(Context context) {
        super(context);
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void execBean() {
        super.execBean((Class) null);
    }

    public List<RestNameValuePair> generateRequestParam() {
        CardData.BondCard bondCard;
        if (this.a != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new RestNameValuePair("phone_number", PayUtils.encrypt("phone_number", this.a.getmPhone())));
            arrayList.add(new RestNameValuePair("vcode", this.a.mSmsVCode));
            if (!this.c) {
                arrayList.add(new RestNameValuePair("source_flag", "3"));
                BindFastRequest bindFastRequest = this.a;
                if (bindFastRequest != null) {
                    arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
                }
                arrayList.add(new RestNameValuePair("service_type", this.a.getServiceType()));
            }
            arrayList.add(new RestNameValuePair("bind_without_pay", this.a.getWithoutPay()));
            if (!TextUtils.isEmpty(this.a.getSubBankCode())) {
                arrayList.add(new RestNameValuePair("sub_bank_code", this.a.getSubBankCode()));
            }
            PayRequest payRequest = this.b;
            if (payRequest != null) {
                arrayList.add(new RestNameValuePair("order_no", payRequest.mOrderNo));
                arrayList.add(new RestNameValuePair(StatHelper.SP_NO, this.b.mSpNO));
                arrayList.add(new RestNameValuePair("total_amount", this.b.getOrderPrice()));
            }
            PayRequest payRequest2 = this.b;
            if (!(payRequest2 == null || (bondCard = payRequest2.mBondCard) == null || TextUtils.isEmpty(bondCard.account_no))) {
                arrayList.add(new RestNameValuePair("card_no", SecurePay.getInstance().encryptProxy(this.b.mBondCard.account_no)));
            }
            arrayList.add(new RestNameValuePair("session_id", this.a.getSessionId()));
            return arrayList;
        }
        throw new IllegalStateException("not call setBindRequest(req) method or param(req) null");
    }

    public int getBeanId() {
        return 11;
    }

    public String getUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append(DomainConfig.getInstance().getAppPayHost());
        sb.append(this.c ? DxmPayBeanConstants.API_SIGN_CONTRACT_VERIFY_SMS : DxmPayBeanConstants.API_VERIFY_SMS);
        return sb.toString();
    }

    public void a(BindFastRequest bindFastRequest) {
        this.a = bindFastRequest;
    }
}
