package com.baidu.wallet.personal.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.NoProguard;
import java.io.Serializable;

public class CouponList implements NoProguard, Serializable {
    public static final long serialVersionUID = -3899635839202556799L;
    public int count;
    public Coupon[] coupons;
    public String desc;

    public static class Coupon implements NoProguard, Serializable {
        public static final int TEMPLATE_BFB_NORMAL = 4;
        public static final int TEMPLATE_BFB_SPECIAL = 44;
        public static final int TEMPLATE_CASH_NORMAL = 5;
        public static final int TEMPLATE_CASH_SPECIAL = 55;
        public static final int TEMPLATE_COMMON = 100;
        public static final int TEMPLATE_CREDIT_NORMAL = 1;
        public static final int TEMPLATE_CREDIT_SPECIAL = 11;
        public static final int TEMPLATE_DARK_COMMON = 8;
        public static final int TEMPLATE_FINANCE_NORMAL = 2;
        public static final int TEMPLATE_FINANCE_SPECIAL = 22;
        public static final int TEMPLATE_GIFT_NORMAL = 6;
        public static final int TEMPLATE_GIFT_SPECIAL = 66;
        public static final int TEMPLATE_INSURANCE_NORMAL = 3;
        public static final int TEMPLATE_INSURANCE_SPECIAL = 33;
        public static final int TEMPLATE_LIGHT_COMMON = 7;
        public static final int TEMPLATE_SAVE_MONEY = 9;
        public static final long serialVersionUID = -3899635839289305699L;
        public AppSceneService app_scene_service;
        public BannerList[] bannerLists;
        public int card_type;
        public String coupon_color;
        public String coupon_color_bg;
        public int coupon_list_show_formwork;
        public String coupon_name;
        public String coupon_num;
        public int coupon_receive_timestamp;
        public String coupon_title_desc;
        public String coupon_title_head;
        public int coupon_type;
        public String date_message;
        public String groupDesc;
        public String icon_url;
        public String is_blink = "1";
        public int is_global_top;
        public String is_show_event = "1";
        public String list_scene_service_label;
        public String list_scene_service_label_URL;
        public int local_view_type;
        public String marketing_label;
        public String marketing_label_bgpic;
        public int need_unlock;
        public String need_unlock_label;
        public String need_unlock_url;
        public int status;
        public String sub_title;
        public String sub_title2;
        public String template_num;
        public String top_copy;
        public String use_limit;

        public static class AppSceneService implements NoProguard, Serializable {

            /* renamed from: android  reason: collision with root package name */
            public int f3644android;
            public String url;
        }

        public boolean isUnlockCoupon() {
            return this.need_unlock == 1 && TextUtils.isEmpty(this.need_unlock_url);
        }
    }
}
