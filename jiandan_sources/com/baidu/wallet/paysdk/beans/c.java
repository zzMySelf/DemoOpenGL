package com.baidu.wallet.paysdk.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.BindCardProtocolPreviewResponse;
import com.baidu.wallet.paysdk.ui.BindCardProtocolActivity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.wallet.core.beans.BaseBean;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.paysdk.PayUtils;
import java.util.ArrayList;
import java.util.List;

public class c extends BaseBean<BindCardProtocolPreviewResponse> {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public c(Context context) {
        super(context);
    }

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void e(String str) {
        this.e = str;
    }

    public void execBean() {
        super.execBean(BindCardProtocolPreviewResponse.class);
    }

    public void f(String str) {
        this.f = str;
    }

    public void g(String str) {
        this.g = str;
    }

    public List<RestNameValuePair> generateRequestParam() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair(BindCardProtocolActivity.PROTOCOL_SNAPSHOT_ID, this.a));
        arrayList.add(new RestNameValuePair("protocolType", this.b));
        arrayList.add(new RestNameValuePair("templateCode", this.c));
        if (!TextUtils.isEmpty(this.d)) {
            arrayList.add(new RestNameValuePair("true_name", this.d));
        }
        if (!TextUtils.isEmpty(this.f)) {
            arrayList.add(new RestNameValuePair("identity_code", PayUtils.encrypt("identity_code", this.f)));
        }
        if (!TextUtils.isEmpty(this.e)) {
            arrayList.add(new RestNameValuePair(BindCardProtocolActivity.IDENTITY_TYPE, this.e));
        }
        if (!TextUtils.isEmpty(this.g)) {
            arrayList.add(new RestNameValuePair("card_no", PayUtils.encrypt("card_no", this.g)));
        }
        if (!TextUtils.isEmpty(this.h)) {
            arrayList.add(new RestNameValuePair("mobile", PayUtils.encrypt("phone_number", this.h)));
        }
        return arrayList;
    }

    public int getBeanId() {
        return 605;
    }

    public String getEncode() {
        return "UTF-8";
    }

    public String getUrl() {
        return DomainConfig.getInstance().getAppPayHost() + DxmPayBeanConstants.API_BIND_CARD_PROTOCOL;
    }

    public void h(String str) {
        this.h = str;
    }

    public boolean needNonce() {
        return true;
    }
}
