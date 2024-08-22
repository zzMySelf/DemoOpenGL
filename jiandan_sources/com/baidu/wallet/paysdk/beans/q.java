package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.OtherBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;

public class q extends OtherBean<String> {
    public String a;

    public q(Context context) {
        super(context);
    }

    public void a(String str) {
        this.a = str;
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair(PayUtils.KEY_PROVINCE_ID, this.a));
        return arrayList;
    }

    public int getBeanId() {
        return 27;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_GET_ADDRESS_INFO;
    }

    public boolean needNonce() {
        return false;
    }

    public String a() {
        return this.a;
    }
}
