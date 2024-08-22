package com.baidu.wallet.personal.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import com.baidu.wallet.personal.datamodel.CouponUnlockResponse;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseBean<CouponUnlockResponse> {
    public String a;

    public a(Context context) {
        super(context);
    }

    public void a(String str) {
        this.a = str;
    }

    public boolean checkSignSame(String str) {
        return true;
    }

    public void execBean() {
        super.execBean(CouponListResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("coupon_num", this.a));
        return arrayList;
    }

    public int getBeanId() {
        return PayBeanFactory.BEAN_ID_SIGN_CHANNEL_LIST;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getMyHost(this.tag) + "/jcardweb/unlock";
    }
}
