package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.VerifyCodeResponse;
import com.baidu.wallet.paysdk.datamodel.b;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;

public class af extends BaseBean<VerifyCodeResponse> {
    public b a = ((b) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_VERIFY_CODE));

    public af(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(VerifyCodeResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("mobile", this.a.a));
        arrayList.add(new RestNameValuePair(StatHelper.SP_NO, this.a.b));
        arrayList.add(new RestNameValuePair("order_no", this.a.c));
        arrayList.add(new RestNameValuePair("pay_type", this.a.d));
        if (!TextUtils.isEmpty(PayDataCache.getInstance().getPaySessionInfo())) {
            arrayList.add(new RestNameValuePair("session_info", PayDataCache.getInstance().getPaySessionInfo()));
        }
        return arrayList;
    }

    public int getBeanId() {
        return 9;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_REQUEST_SMS_CODE;
    }
}
