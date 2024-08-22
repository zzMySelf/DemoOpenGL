package com.baidu.wallet.lightapp.business.a;

import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.lightapp.business.datamodel.LangBridgeCfg;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseBean {
    public String a;

    public void execBean() {
        super.execBean(LangBridgeCfg.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("cate[lbconfig]", this.a));
        return arrayList;
    }

    public int getBeanId() {
        return FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppHost(this.tag) + "/odp/wireless/config/common";
    }
}
