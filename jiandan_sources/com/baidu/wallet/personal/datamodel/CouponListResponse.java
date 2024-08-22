package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.personal.datamodel.CouponList;
import java.io.Serializable;

public class CouponListResponse implements IBeanResponse, Serializable {
    public BannerList[] banner_list;
    public CodeCoupon code_equity;
    public CouponList.Coupon[] coupon_list;
    public int coupon_scene;
    public CouponSpinner[] coupon_sort_list;
    public CouponSpinner[] coupon_type_list;
    public int current_page;
    public CouponSpinner[] filter_status_new_list;
    public boolean is_return_unlock = false;
    public String limit_desc;
    public int remind_pic_max_count;
    public String remind_pic_url;
    public int total_count;

    public static class CodeCoupon implements NoProguard, Serializable {
        public String desc;
        public String url;
    }

    public static class CouponSpinner implements NoProguard, Serializable {
        public int spinner_show_type;
        public int spinner_type;
        public int spinner_type_count;
        public String spinner_type_name;
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
