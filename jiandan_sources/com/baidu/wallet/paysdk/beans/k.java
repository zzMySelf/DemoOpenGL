package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.FindPwdCardCheckResponse;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.List;

public class k extends BaseBean<k> {
    public <T> k(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(FindPwdCardCheckResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        return null;
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_FIND_MOBILE_PWD_BY_OLDCARD_GET_CARD_LIST;
    }

    public String getEncode() {
        return BeanConstants.ENCODE_GB_18030;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_FIND_PASS_FROM_OLD_CARD_GET_CARD_LIST;
    }
}
