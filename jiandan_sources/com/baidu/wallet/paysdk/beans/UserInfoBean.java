package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import com.baidu.wallet.paysdk.datamodel.UserInfoContentResponse;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import java.util.ArrayList;
import java.util.List;

public class UserInfoBean extends BaseBean<UserInfoContentResponse> implements NoProguard {
    public <T> UserInfoBean(Context context) {
        super(context);
    }

    public void execBean() {
        super.execBean(UserInfoContentResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("source_flag", "3"));
        return arrayList;
    }

    public int getBeanId() {
        return 6;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_USER_INFO;
    }
}
