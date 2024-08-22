package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.ubc.UBCManager;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.OfflinePayQueryResponse;
import com.baidu.wallet.paysdk.datamodel.PayQueryRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;

public class y extends BaseBean<OfflinePayQueryResponse> {
    public <T> y(Context context) {
        super(context);
    }

    private String a(String str, String str2) {
        return Md5Utils.toMD5("order_no=" + str + "&name=" + "get_order_trans_state" + "&source=" + "offline_pay" + "&sp_no=" + str2 + "&key=" + PayQueryRequest.SIGN_KEY);
    }

    public void execBean() {
        super.execBean(OfflinePayQueryResponse.class, ErrorContentResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("name", "get_order_trans_state"));
        arrayList.add(new RestNameValuePair(UBCManager.CONTENT_KEY_SOURCE, "offline_pay"));
        if (payRequest != null) {
            String str = payRequest.mOrderNo;
            String str2 = payRequest.mSpNO;
            arrayList.add(new RestNameValuePair("order_no", str));
            arrayList.add(new RestNameValuePair(StatHelper.SP_NO, str2));
            arrayList.add(new RestNameValuePair("sign", a(str, str2)));
        }
        return arrayList;
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_QUERY_OFFLINE_PAY;
    }

    public int getHttpMethod() {
        return 0;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + "/cashdesk/wireless/transstate";
    }
}
