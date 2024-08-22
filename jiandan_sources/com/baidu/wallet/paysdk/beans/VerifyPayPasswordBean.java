package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.VerifyPayPasswordResponse;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class VerifyPayPasswordBean extends BaseBean<VerifyPayPasswordResponse> implements NoProguard {
    public VerifyPayPasswordBean(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(VerifyPayPasswordResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("source_flag", String.valueOf(3)));
        return arrayList;
    }

    public int getBeanId() {
        return 600;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_USER_HAS_PAY_PASSWORD;
    }
}
