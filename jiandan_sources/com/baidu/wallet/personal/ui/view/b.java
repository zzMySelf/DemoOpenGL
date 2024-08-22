package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.personal.datamodel.CouponList;

public class b extends f {
    public void a(int i2, CouponList.Coupon coupon) {
        String str;
        TextView textView;
        TextView textView2;
        String str2;
        Context context;
        super.a(i2, coupon);
        int i3 = coupon.coupon_list_show_formwork;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.topMargin = DisplayUtils.dip2px(this.d.getContext(), 17.0f);
        this.j.a.getLayoutParams().height = DisplayUtils.dip2px(this.d.getContext(), 139.0f);
        layoutParams.bottomMargin = DisplayUtils.dip2px(this.d.getContext(), 28.5f);
        this.h.setLayoutParams(layoutParams);
        if (coupon.coupon_name.length() > 5) {
            textView = this.k;
            str = coupon.coupon_name.substring(0, 5);
        } else {
            textView = this.k;
            str = coupon.coupon_name;
        }
        textView.setText(str);
        this.k.getLayoutParams().width = DisplayUtils.dip2px(this.d.getContext(), 60.0f);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.a.getLayoutParams();
        layoutParams2.leftMargin = DisplayUtils.dip2px(this.d.getContext(), 12.5f);
        if (!this.n.b) {
            layoutParams2.height = DisplayUtils.dip2px(this.d.getContext(), 14.0f);
            this.n.a.setBackgroundDrawable(ResUtils.getDrawable(this.d.getContext(), "wallet_personal_coupon_market_label_cash"));
        }
        this.n.a.setLayoutParams(layoutParams2);
        if (this.c) {
            str2 = "ebpay_white";
            this.l.setTextColor(ResUtils.getColor(this.d.getContext(), str2));
            this.m.setTextColor(ResUtils.getColor(this.d.getContext(), str2));
            if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b) {
                this.j.a.setBackgroundDrawable(ResUtils.getDrawable(this.d.getContext(), "wallet_personal_coupon_cash_gray_bg"));
            }
            this.n.a.setTextColor(ResUtils.getColor(this.d.getContext(), str2));
            this.f3649o.setTextColor(ResUtils.getColor(this.d.getContext(), str2));
            this.u.setTextColor(ResUtils.getColor(this.d.getContext(), str2));
            textView2 = this.p;
            context = this.d.getContext();
        } else {
            this.l.setTextColor(com.baidu.wallet.personal.b.b.a(this.d.getContext(), i3));
            this.l.setTypeface(Typeface.DEFAULT);
            this.m.setTextColor(com.baidu.wallet.personal.b.b.a(this.d.getContext(), i3));
            if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b) {
                this.j.a.setBackgroundDrawable(ResUtils.getDrawable(this.d.getContext(), "wallet_personal_coupon_base_formwork_5_55"));
            }
            this.n.a.setTextColor(com.baidu.wallet.personal.b.b.a(this.d.getContext(), i3));
            this.f3649o.setTextColor(com.baidu.wallet.personal.b.b.a(this.d.getContext(), i3));
            this.u.setTextColor(com.baidu.wallet.personal.b.b.a(this.d.getContext(), i3));
            textView2 = this.p;
            context = this.d.getContext();
            str2 = "coupon_base_orage_ccf7d1af";
        }
        textView2.setTextColor(ResUtils.getColor(context, str2));
        this.q.setVisibility(8);
        if (TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
            this.f3648i.setBackground(com.baidu.wallet.personal.b.b.a(this.d.getContext(), com.baidu.wallet.personal.b.b.b(this.d.getContext(), coupon.coupon_list_show_formwork), 0));
        }
        g();
    }
}
