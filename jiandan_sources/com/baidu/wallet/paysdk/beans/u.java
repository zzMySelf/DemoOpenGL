package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.OtherBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.List;

public class u extends OtherBean<String> {
    public u(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        return null;
    }

    public int getBeanId() {
        return 26;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_GET_ADDRESS_INFO;
    }

    public boolean needNonce() {
        return false;
    }
}
