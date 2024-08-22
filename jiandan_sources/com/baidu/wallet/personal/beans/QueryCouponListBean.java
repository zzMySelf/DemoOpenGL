package com.baidu.wallet.personal.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.wallet.core.beans.BaseBean;
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import java.util.ArrayList;
import java.util.List;

public class QueryCouponListBean extends BaseBean<CouponListResponse> {
    public String a;
    public String b = "0";
    public String c = "";
    public String d;
    public String e;
    public String f;
    public String g;

    public enum CouponStatus {
        UNUSE("1"),
        USED("2"),
        EXPIRED("3");
        
        public String val;

        /* access modifiers changed from: public */
        CouponStatus(String str) {
            this.val = str;
        }

        public String getVal() {
            return this.val;
        }
    }

    public QueryCouponListBean(Context context) {
        super(context);
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.a = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void execBean() {
        super.execBean(CouponListResponse.class);
    }

    public void f(String str) {
        this.g = str;
    }

    public List<RestNameValuePair> generateRequestParam() {
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RestNameValuePair("page_index", this.b));
        arrayList.add(new RestNameValuePair("page_size", "10"));
        arrayList.add(new RestNameValuePair("filter_status_new", this.a));
        arrayList.add(new RestNameValuePair("coupon_type", this.d));
        arrayList.add(new RestNameValuePair("coupon_sort", this.e));
        arrayList.add(new RestNameValuePair("coupon_scene", this.f));
        arrayList.add(new RestNameValuePair("first_enter", this.g));
        arrayList.add(new RestNameValuePair("is_return_unlock", String.valueOf(true)));
        return arrayList;
    }

    public int getBeanId() {
        return 515;
    }

    public int getHttpMethod() {
        return 0;
    }

    public String getUrl() {
        return DomainConfig.getInstance().getMyHost(this.tag) + "/jcardweb/getcouponlistv3";
    }
}
