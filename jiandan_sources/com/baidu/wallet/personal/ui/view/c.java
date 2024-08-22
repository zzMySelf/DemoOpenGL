package com.baidu.wallet.personal.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.personal.b.b;
import com.baidu.wallet.personal.datamodel.CouponList;

public class c extends f {
    public void a(int i2, CouponList.Coupon coupon) {
        float f;
        Context context;
        NinePatchDrawable ninePatchDrawable;
        RelativeLayout relativeLayout;
        Context context2;
        String str;
        int i3;
        RelativeLayout relativeLayout2;
        String str2;
        int i4;
        Context context3;
        super.a(i2, coupon);
        if (i2 >= 0 && coupon != null) {
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
            if (this.u.getVisibility() == 0) {
                this.u.setTextColor(ResUtils.getColor(this.d.getContext(), "ebpay_white"));
            }
            int i5 = coupon.coupon_list_show_formwork;
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
            this.l.setTextColor(b.a(this.d.getContext(), i5));
            if (TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
                this.f3648i.setBackground(b.a(this.d.getContext(), b.b(this.d.getContext(), i5), 0));
            }
            if (i5 != 1) {
                if (i5 == 3) {
                    if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b) {
                        if (!this.c) {
                            relativeLayout = this.j.a;
                            context2 = this.d.getContext();
                            i3 = this.j.a.getLayoutParams().height;
                            str = "wallet_personal_coupon_base_formwork_3";
                            ninePatchDrawable = b.a(context2, str, i3);
                            relativeLayout.setBackgroundDrawable(ninePatchDrawable);
                        }
                        relativeLayout = this.j.a;
                        ninePatchDrawable = b.a(this.d.getContext(), "wallet_personal_coupon_gray_common_bg", this.j.a.getLayoutParams().height);
                        relativeLayout.setBackgroundDrawable(ninePatchDrawable);
                    }
                    g();
                } else if (i5 != 6) {
                    if (i5 == 8) {
                        if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b) {
                            if (this.c) {
                                relativeLayout2 = this.j.a;
                                context3 = this.d.getContext();
                                i4 = this.j.a.getLayoutParams().height;
                                str2 = "wallet_personal_coupon_common_dark_gray";
                            } else {
                                relativeLayout2 = this.j.a;
                                context3 = this.d.getContext();
                                i4 = this.j.a.getLayoutParams().height;
                                str2 = "wallet_personal_coupon_base_formwork_8";
                            }
                            relativeLayout2.setBackgroundDrawable(b.a(context3, str2, i4));
                        }
                        this.k.setTextColor(-1);
                        if (!coupon.date_message.contains("后过期") && !coupon.date_message.contains("前使用")) {
                            this.f3649o.setTextColor(-1);
                        }
                        this.m.setTextColor(-1);
                        this.p.setTextColor(-1);
                        this.q.setTextColor(-1);
                        this.u.setTextColor(-1);
                    } else if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b) {
                        if (!this.c) {
                            relativeLayout = this.j.a;
                            context2 = this.d.getContext();
                            i3 = this.j.a.getLayoutParams().height;
                            str = "wallet_personal_coupon_base_formwork_2_4_7";
                            ninePatchDrawable = b.a(context2, str, i3);
                            relativeLayout.setBackgroundDrawable(ninePatchDrawable);
                        }
                        relativeLayout = this.j.a;
                        ninePatchDrawable = b.a(this.d.getContext(), "wallet_personal_coupon_gray_common_bg", this.j.a.getLayoutParams().height);
                        relativeLayout.setBackgroundDrawable(ninePatchDrawable);
                    }
                    g();
                }
            }
            if (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b) {
                if (!this.c) {
                    relativeLayout = this.j.a;
                    context2 = this.d.getContext();
                    i3 = this.j.a.getLayoutParams().height;
                    str = "wallet_personal_coupon_base_formwork_1_6";
                    ninePatchDrawable = b.a(context2, str, i3);
                    relativeLayout.setBackgroundDrawable(ninePatchDrawable);
                }
                relativeLayout = this.j.a;
                ninePatchDrawable = b.a(this.d.getContext(), "wallet_personal_coupon_gray_common_bg", this.j.a.getLayoutParams().height);
                relativeLayout.setBackgroundDrawable(ninePatchDrawable);
            }
            g();
        }
    }
}
