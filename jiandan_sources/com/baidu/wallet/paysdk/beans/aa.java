package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.QueryPayResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class aa extends BaseBean<QueryPayResponse> {
    public List<RestNameValuePair> a;

    public <T> aa(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(QueryPayResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        List<RestNameValuePair> list = this.a;
        if (list != null) {
            return list;
        }
        PayQueryRequest payQueryRequest = (PayQueryRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY_QUERY);
        if (payQueryRequest == null || !payQueryRequest.checkRequestValidity()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("name", payQueryRequest.mName));
        arrayList.add(new RestNameValuePair("order_no", payQueryRequest.mOrderNo));
        if (!TextUtils.isEmpty(payQueryRequest.mBankNo)) {
            arrayList.add(new RestNameValuePair("bank_no", payQueryRequest.mBankNo));
        }
        arrayList.add(new RestNameValuePair("sign", payQueryRequest.getMd5Sign()));
        this.a = arrayList;
        return arrayList;
    }

    public int getBeanId() {
        return 12;
    }

    public int getHttpMethod() {
        return 0;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/transstate";
    }
}
