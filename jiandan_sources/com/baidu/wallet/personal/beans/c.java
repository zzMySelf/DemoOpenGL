package com.baidu.wallet.personal.beans;

import android.content.Context;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.personal.datamodel.CouponDetailResponse;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.List;

public class c extends BaseBean<CouponDetailResponse> {
    public int a;
    public String b;
    public String c;

    public c(Context context) {
        super(context);
    }

    public void a(int i2) {
        this.a = i2;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void execBean() {
        super.execBean(CouponDetailResponse.class);
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair(StatHelper.CARD_TYPE, "" + this.a));
        arrayList.add(new RestNameValuePair("coupon_num", this.b));
        arrayList.add(new RestNameValuePair("template_num", this.c));
        arrayList.add(new RestNameValuePair("is_new_type", "1"));
        return arrayList;
    }

    public int getBeanId() {
        return 516;
    }

    public int getHttpMethod() {
        return 0;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getMyHost(this.tag) + "/jcardweb/getcoupondetailv2";
    }
}
