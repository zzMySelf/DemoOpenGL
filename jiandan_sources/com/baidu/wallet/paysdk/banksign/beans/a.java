package com.baidu.wallet.paysdk.banksign.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.banksign.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseBean<BindCardResponse> {
    public a(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(BindCardResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("session_id", NetworkBean.SessionCache.getInstance().getSessionId((NetworkBean.BizType) null)));
        String encryptProxy = SecurePay.getInstance().encryptProxy(com.baidu.wallet.paysdk.banksign.a.a.a().m());
        String str = SecurePay.getInstance().getpwProxy();
        arrayList.add(new RestNameValuePair("agreement_trans_id", encryptProxy));
        arrayList.add(new RestNameValuePair("key", str));
        return arrayList;
    }

    public int getBeanId() {
        return BankSignFactory.BEAN_ID_BIND_CARD;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_BANKSING_BIND_CARD;
    }
}
