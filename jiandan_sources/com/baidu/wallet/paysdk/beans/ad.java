package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.SignChannelResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;

public class ad extends BaseBean<SignChannelResponse> {
    public <T> ad(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(SignChannelResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("query_name", "query_bank_list"));
        if (b.a()) {
            arrayList.add(new RestNameValuePair("source_flag", "8"));
        } else {
            arrayList.add(new RestNameValuePair("source_flag", "3"));
        }
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache((PayRequestCache.getInstance().isPaying() ? PayRequestCache.BindCategory.Other : PayRequestCache.BindCategory.Initiative).name());
        if (bindFastRequest != null) {
            arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
            arrayList.add(new RestNameValuePair("service_type", bindFastRequest.getServiceType()));
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            String str = payRequest.mSpNO;
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new RestNameValuePair(StatHelper.SP_NO, str));
            }
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        String sellerUserId = PayDataCache.getInstance().getSellerUserId();
        if (!TextUtils.isEmpty(sellerUserId)) {
            arrayList.add(new RestNameValuePair("seller_user_id", sellerUserId));
        }
        if (!(payResponse == null || (directPayPay = payResponse.pay) == null || (easyPay = directPayPay.easypay) == null)) {
            String buyerUserId = easyPay.getBuyerUserId();
            if (!TextUtils.isEmpty(buyerUserId)) {
                arrayList.add(new RestNameValuePair("buyer_user_id", buyerUserId));
            }
            String amount = payResponse.pay.easypay.getAmount();
            if (!TextUtils.isEmpty(amount)) {
                arrayList.add(new RestNameValuePair("total_amount", amount));
            }
            if (b.a()) {
                arrayList.add(new RestNameValuePair("trans_need_to_pay", String.valueOf(!b.b())));
            } else {
                String insideTransOrder = PayDataCache.getInstance().getInsideTransOrder();
                if (!TextUtils.isEmpty(insideTransOrder)) {
                    arrayList.add(new RestNameValuePair("trans_need_to_pay", insideTransOrder));
                }
            }
            String service = payResponse.pay.easypay.getService();
            if (!TextUtils.isEmpty(service)) {
                arrayList.add(new RestNameValuePair("service", service));
            }
        }
        if (bindFastRequest != null && bindFastRequest.getmBindFrom() == 1 && !TextUtils.isEmpty(bindFastRequest.getSp_no())) {
            arrayList.add(new RestNameValuePair(StatHelper.SP_NO, bindFastRequest.getSp_no()));
        }
        return arrayList;
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_SIGN_CHANNEL_LIST;
    }

    public int getHttpMethod() {
        return 0;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_SIGN_CHANNEL_QUERY;
    }
}
