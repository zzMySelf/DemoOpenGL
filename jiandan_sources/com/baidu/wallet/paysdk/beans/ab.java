package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.QueryBankBinResponse;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;

public class ab extends BaseBean<QueryBankBinResponse> {
    public String a = "";

    public <T> ab(Context context) {
        super(context);
    }

    public void a(String str) {
        this.a = str;
    }

    public void execBean() {
        super.execBean(QueryBankBinResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(this.a)) {
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.a)));
        }
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        arrayList.add(new RestNameValuePair("source_flag", "3"));
        if (bindFastRequest != null) {
            arrayList.add(new RestNameValuePair("request_type", bindFastRequest.getCardRequestType()));
            arrayList.add(new RestNameValuePair("service_type", bindFastRequest.getServiceType()));
        }
        return arrayList;
    }

    public int getBeanId() {
        return 7;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_QUERY_BANK_INFO;
    }
}
