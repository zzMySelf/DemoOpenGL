package com.baidu.wallet.personal.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.personal.b.b;
import com.baidu.wallet.personal.datamodel.CouponList;

public class g extends f {
    public void a(int i2, final CouponList.Coupon coupon) {
        float f;
        Context context;
        Context context2;
        RelativeLayout relativeLayout;
        String str;
        int i3;
        ScanningRoundView scanningRoundView;
        int i4;
        int i5;
        super.a(i2, coupon);
        if (!this.c && TextUtils.equals(coupon.is_blink, "1")) {
            if (TextUtils.isEmpty(coupon.sub_title) || TextUtils.isEmpty(coupon.sub_title2)) {
                scanningRoundView = this.A;
                i5 = DisplayUtils.dip2px(this.d.getContext(), 50.0f);
                i4 = DisplayUtils.dip2px(this.d.getContext(), 139.0f);
            } else {
                scanningRoundView = this.A;
                i5 = DisplayUtils.dip2px(this.d.getContext(), 50.0f);
                i4 = DisplayUtils.dip2px(this.d.getContext(), 155.0f);
            }
            scanningRoundView.a(i5, i4);
            this.A.setVisibility(0);
            this.A.setBlinkRepeatCount(0);
            this.A.setBlinkStartDelay(1000);
            this.A.setAnimatorDuration(1500);
            a((AnimatorListenerAdapter) new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    g.this.A.setVisibility(8);
                    coupon.is_blink = "0";
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    g.this.A.setVisibility(0);
                }
            });
        }
        if (!TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
            this.f3648i.setBackground(b.a(this.d.getContext(), b.a(this.d.getContext(), coupon.coupon_color, "coupon_base_blue_06116f"), 0));
        }
        this.k.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_red_7a3f00"));
        this.m.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_red_f73f31"));
        this.f3649o.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_red_7a3f00"));
        this.p.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_red_7a3f00"));
        this.q.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_red_7a3f00"));
        this.u.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_orange_f0c78b"));
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
        if ((TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b) && Build.VERSION.SDK_INT >= 16 && (TextUtils.isEmpty(coupon.coupon_color_bg) || !this.j.b)) {
            if (this.c) {
                relativeLayout = this.j.a;
                context2 = this.d.getContext();
                i3 = this.j.a.getLayoutParams().height;
                str = "wallet_personal_coupon_gray_common_bg";
            } else {
                relativeLayout = this.j.a;
                context2 = this.d.getContext();
                i3 = this.j.a.getLayoutParams().height;
                str = "wallet_personal_coupon_base_formwork_2_4_7";
            }
            relativeLayout.setBackground(b.a(context2, str, i3));
        }
        g();
    }
}
