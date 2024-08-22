package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.OtherBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.List;

public class s extends OtherBean<String> {
    public s(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        return null;
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_GET_JOB;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_GET_JOB_INFO;
    }

    public boolean needNonce() {
        return false;
    }
}
