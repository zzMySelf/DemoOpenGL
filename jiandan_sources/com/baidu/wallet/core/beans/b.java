package com.baidu.wallet.core.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.domain.DomainConfig;
import java.util.List;

public class b extends OtherBean<String> {
    public b(Context context) {
        super(context);
    }

    public boolean a() {
        return this.mRetCode == 0;
    }

    public void execBean() {
        super.execBean(String.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        return null;
    }

    public int getBeanId() {
        return 0;
    }

    public int getHttpMethod() {
        return 1;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppHost(this.tag) + "/odp/wireless/sdk/getuserfinancialinfobysdk";
    }

    public boolean needNonce() {
        return false;
    }
}
