package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.personal.b.b;
import com.baidu.wallet.personal.datamodel.CouponList;

public class h extends f {
    public void a(int i2, CouponList.Coupon coupon) {
        float f;
        Context context;
        Context context2;
        TextView textView;
        String str;
        String str2;
        int i3;
        Context context3;
        RelativeLayout relativeLayout;
        super.a(i2, coupon);
        if (this.f3649o.getVisibility() == 0) {
            if ((this.c || !coupon.date_message.contains("后过期")) && !coupon.date_message.contains("前使用")) {
                this.f3649o.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_black_394259"));
            } else {
                this.f3649o.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_red_f73f31"));
                this.f3649o.setTypeface(Typeface.SANS_SERIF, 1);
            }
        }
        if (this.p.getVisibility() == 0) {
            this.p.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_black_cc394259"));
        }
        if (this.q.getVisibility() == 0) {
            this.q.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_black_cc394259"));
        }
        int i4 = coupon.coupon_list_show_formwork;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.topMargin = DisplayUtils.dip2px(this.d.getContext(), 17.0f);
        if (TextUtils.isEmpty(coupon.sub_title) || TextUtils.isEmpty(coupon.sub_title2)) {
            this.j.a.getLayoutParams().height = DisplayUtils.dip2px(this.d.getContext(), 139.0f);
            context = this.d.getContext();
            f = 29.0f;
        } else {
            this.j.a.getLayoutParams().height = DisplayUtils.dip2px(this.d.getContext(), 155.0f);
            context = this.d.getContext();
            f = 28.0f;
        }
        layoutParams.bottomMargin = DisplayUtils.dip2px(context, f);
        this.h.setLayoutParams(layoutParams);
        this.l.setTextColor(b.a(this.d.getContext(), i4));
        this.m.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_black_000014"));
        if ((TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b) && Build.VERSION.SDK_INT >= 16) {
            if (this.c) {
                relativeLayout = this.j.a;
                context3 = this.d.getContext();
                i3 = this.j.a.getLayoutParams().height;
                str2 = "wallet_personal_coupon_gray_special_bg";
            } else {
                relativeLayout = this.j.a;
                context3 = this.d.getContext();
                i3 = this.j.a.getLayoutParams().height;
                str2 = "wallet_personal_coupon_base_formwork_11_22_33_44_66";
            }
            relativeLayout.setBackground(b.a(context3, str2, i3));
        }
        if (TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
            this.f3648i.setBackground(b.a(this.d.getContext(), b.b(this.d.getContext(), i4), 0));
        }
        if (this.c) {
            textView = this.u;
            context2 = this.d.getContext();
            str = "coupon_base_gray_e1e2e6";
        } else {
            textView = this.u;
            context2 = this.d.getContext();
            str = "coupon_base_yellow_eec19a";
        }
        textView.setTextColor(ResUtils.getColor(context2, str));
        g();
    }
}
