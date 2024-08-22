package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import com.baidu.apollon.beans.IBeanResponse;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;

public class CouponDetailResponse implements IBeanResponse, Serializable {
    public AppSceneService app_scene_service;
    public int card_type;
    public String coupon_detail_bgpic;
    public String coupon_detail_bgpic_down;
    public String coupon_detail_bgpic_up;
    public String coupon_detail_btn_bg;
    public int coupon_list_show_formwork;
    public String coupon_name;
    public String coupon_num;
    public String coupon_title_desc;
    public String coupon_title_head;
    public String date_message;
    public Detail[] detail;
    public String display_coupon_num;
    public String marketing_label;
    public String marketing_label_bgpic;
    public String scene_service;
    public String scene_service_label;
    public int status = 0;
    public String sub_title;
    public String sub_title2;
    public int template_coupon_type;
    public String template_num;

    public static class AppSceneService implements NoProguard, Serializable {

        /* renamed from: android  reason: collision with root package name */
        public int f3643android;
        public String url;
    }

    public static class Detail implements NoProguard, Serializable {
        public static final long serialVersionUID = -7483625839289305699L;
        public String name;
        public String value;
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public void storeResponse(Context context) {
    }
}
