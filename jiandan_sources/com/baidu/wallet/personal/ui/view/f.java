package com.baidu.wallet.personal.ui.view;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.imagemanager.ImageLoader;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.personal.a.a;
import com.baidu.wallet.personal.datamodel.CouponList;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class f implements a.b<CouponList.Coupon> {
    public ScanningRoundView A;
    public boolean B = false;
    public View.OnClickListener C = new View.OnClickListener() {
        public void onClick(View view) {
            GlobalUtils.toast(f.this.A.getContext(), "2222");
        }
    };
    public View.OnClickListener D = new View.OnClickListener() {
        public void onClick(View view) {
            GlobalUtils.toast(f.this.A.getContext(), "11111");
        }
    };
    public CouponList.Coupon a;
    public boolean b = false;
    public boolean c = false;
    public ViewGroup d;
    public TextView e;
    public View f;
    public LinearLayout g;
    public RelativeLayout h;

    /* renamed from: i  reason: collision with root package name */
    public View f3648i;
    public a j = new a();
    public TextView k;
    public TextView l;
    public TextView m;
    public b n = new b();

    /* renamed from: o  reason: collision with root package name */
    public TextView f3649o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public NetImageView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public RelativeLayout y;
    public FrameLayout z;

    public class a {
        public RelativeLayout a;
        public boolean b = false;

        public a() {
        }
    }

    public class b {
        public TextView a;
        public boolean b = false;

        public b() {
        }
    }

    public void a() {
        this.z.setBackground((Drawable) null);
        if (!TextUtils.isEmpty(this.a.coupon_color_bg)) {
            ImageLoader.getInstance(this.d.getContext()).getBitmap(this.a.coupon_color_bg, new ImageLoader.OnGetBitmapListener() {
                public boolean needCancel(String str, Object obj) {
                    return false;
                }

                public void onError(String str, Object obj) {
                    f.this.j.b = false;
                }

                public void onGetBitmap(String str, Object obj, final Bitmap bitmap) {
                    if (bitmap != null) {
                        f.this.j.a.post(new Runnable() {
                            public void run() {
                                f.this.j.a.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                f.this.j.b = true;
                            }
                        });
                    }
                }
            }, (Object) null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
        }
    }

    public void a(int i2, final CouponList.Coupon coupon) {
        String str;
        TextView textView;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3;
        int i4;
        ViewGroup.MarginLayoutParams marginLayoutParams2;
        String str2;
        TextView textView2;
        this.a = coupon;
        if (i2 >= 0 && coupon != null) {
            if (TextUtils.equals(coupon.is_show_event, "1")) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("coupon_name", coupon.coupon_name);
                    jSONObject.put("template_num", coupon.template_num);
                    jSONObject.put("coupon_num", coupon.coupon_num);
                    jSONObject.put(StatHelper.CARD_TYPE, coupon.card_type);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                String[] strArr = new String[4];
                strArr[0] = jSONObject.toString();
                int i5 = 1;
                strArr[1] = coupon.coupon_type + "";
                strArr[2] = coupon.status + "";
                if (!coupon.isUnlockCoupon()) {
                    i5 = 2;
                }
                strArr[3] = String.valueOf(i5);
                DXMSdkSAUtils.onEventWithValues("CouponItemShow", Arrays.asList(strArr));
                coupon.is_show_event = "0";
            }
            if (!this.B || TextUtils.isEmpty(coupon.groupDesc)) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.e.setText(coupon.groupDesc);
                this.e.setOnClickListener(this.C);
            }
            a();
            if (!TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
                this.f3648i.setBackground(com.baidu.wallet.personal.b.b.a(this.d.getContext(), com.baidu.wallet.personal.b.b.a(this.d.getContext(), coupon.coupon_color, "coupon_base_red_f75348"), 0));
            }
            if (!TextUtils.isEmpty(coupon.coupon_name)) {
                if (coupon.coupon_name.length() > 7) {
                    textView2 = this.k;
                    str2 = coupon.coupon_name.substring(0, 7);
                } else {
                    textView2 = this.k;
                    str2 = coupon.coupon_name;
                }
                textView2.setText(str2);
            }
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.a.getLayoutParams();
            layoutParams.height = DisplayUtils.dip2px(this.d.getContext(), 14.0f);
            this.n.a.setLayoutParams(layoutParams);
            if (!TextUtils.isEmpty(coupon.marketing_label)) {
                int dip2px = DisplayUtils.dip2px(this.d.getContext(), 2.0f);
                this.n.a.setPadding(dip2px, 0, dip2px, 0);
                this.n.a.setText(coupon.marketing_label.length() > 6 ? coupon.marketing_label.substring(0, 6) : coupon.marketing_label);
                this.n.a.setVisibility(0);
            }
            if (!TextUtils.isEmpty(coupon.marketing_label_bgpic)) {
                ImageLoader.getInstance(this.d.getContext()).getBitmap(coupon.marketing_label_bgpic, new ImageLoader.OnGetBitmapListener() {
                    public boolean needCancel(String str, Object obj) {
                        return false;
                    }

                    public void onError(String str, Object obj) {
                        f.this.n.b = false;
                    }

                    public void onGetBitmap(String str, Object obj, final Bitmap bitmap) {
                        if (bitmap == null) {
                            return;
                        }
                        if (TextUtils.isEmpty(coupon.marketing_label)) {
                            f.this.d.post(new Runnable() {
                                public void run() {
                                    AnonymousClass1 r0 = AnonymousClass1.this;
                                    f fVar = f.this;
                                    fVar.n.b = true;
                                    layoutParams.width = DisplayUtils.dip2px(fVar.d.getContext(), 57.0f);
                                    AnonymousClass1 r02 = AnonymousClass1.this;
                                    layoutParams.height = DisplayUtils.dip2px(f.this.d.getContext(), 14.0f);
                                    AnonymousClass1 r03 = AnonymousClass1.this;
                                    f.this.n.a.setLayoutParams(layoutParams);
                                    f.this.n.a.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                    f.this.n.a.setVisibility(0);
                                }
                            });
                            return;
                        }
                        com.baidu.wallet.personal.b.a aVar = new com.baidu.wallet.personal.b.a(f.this.d.getResources(), bitmap);
                        aVar.a(bitmap.getWidth() / 2, 1).b(bitmap.getHeight() / 2, 1);
                        final NinePatchDrawable c2 = aVar.c();
                        if (c2 != null) {
                            f.this.d.post(new Runnable() {
                                public void run() {
                                    b bVar = f.this.n;
                                    bVar.b = true;
                                    bVar.a.setBackgroundDrawable(c2);
                                    if (f.this.n.a.getVisibility() == 8) {
                                        f.this.n.a.setVisibility(0);
                                    }
                                }
                            });
                        }
                    }
                }, (Object) null, MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);
            }
            if (!TextUtils.isEmpty(coupon.date_message)) {
                this.f3649o.setVisibility(0);
                this.f3649o.setText(coupon.date_message);
            } else {
                this.f3649o.setVisibility(8);
            }
            if (!TextUtils.isEmpty(coupon.sub_title)) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
                layoutParams2.topMargin = DisplayUtils.dip2px(this.d.getContext(), 8.5f);
                this.p.setLayoutParams(layoutParams2);
                this.p.setText(coupon.sub_title);
                this.p.setVisibility(0);
            } else {
                this.p.setVisibility(8);
            }
            if (!TextUtils.isEmpty(coupon.sub_title2)) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                layoutParams3.topMargin = DisplayUtils.dip2px(this.d.getContext(), 7.0f);
                this.q.setLayoutParams(layoutParams3);
                this.q.setText(coupon.sub_title2);
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            if (!TextUtils.isEmpty(coupon.list_scene_service_label)) {
                textView = this.u;
                str = coupon.list_scene_service_label;
            } else {
                textView = this.u;
                str = ResUtils.getString(this.d.getContext(), "去使用");
            }
            textView.setText(str);
            d();
            b();
            if (TextUtils.isEmpty(coupon.use_limit) || this.c) {
                this.r.setVisibility(8);
            } else {
                this.h.bringToFront();
                this.t.setText(coupon.use_limit);
                if (!TextUtils.isEmpty(coupon.icon_url)) {
                    this.s.setImageUrl(coupon.icon_url);
                }
                this.r.setVisibility(0);
                this.r.setOnClickListener(this.D);
            }
            c();
            if (coupon.app_scene_service != null || !TextUtils.isEmpty(coupon.list_scene_service_label)) {
                this.u.setText(coupon.list_scene_service_label);
            }
            f();
            if (i2 == 0 && (this.w.getVisibility() == 0 || this.v.getVisibility() == 0)) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
                i3 = DisplayUtils.dip2px(this.d.getContext(), 7.0f);
            } else {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
                i3 = DisplayUtils.dip2px(this.d.getContext(), 0.0f);
            }
            marginLayoutParams.topMargin = i3;
            e();
            if (this.x.getVisibility() == 0) {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                i4 = DisplayUtils.dip2px(this.d.getContext(), 0.0f);
            } else {
                marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                i4 = DisplayUtils.dip2px(this.d.getContext(), 65.0f);
            }
            marginLayoutParams2.rightMargin = i4;
        }
    }

    public void a(AnimatorListenerAdapter animatorListenerAdapter) {
        ScanningRoundView scanningRoundView = this.A;
        if (scanningRoundView != null && scanningRoundView.getVisibility() == 0) {
            this.A.a(animatorListenerAdapter);
        }
    }

    public void a(View view) {
        if (this.d == null) {
            ViewGroup viewGroup = (ViewGroup) view;
            this.d = viewGroup;
            this.g = (LinearLayout) viewGroup.findViewById(ResUtils.id(viewGroup.getContext(), "ll_card_content"));
            ViewGroup viewGroup2 = this.d;
            this.h = (RelativeLayout) viewGroup2.findViewById(ResUtils.id(viewGroup2.getContext(), "coupon_item_title_layout"));
            a aVar = this.j;
            ViewGroup viewGroup3 = this.d;
            aVar.a = (RelativeLayout) viewGroup3.findViewById(ResUtils.id(viewGroup3.getContext(), "coupon_item_layout"));
            ViewGroup viewGroup4 = this.d;
            this.z = (FrameLayout) viewGroup4.findViewById(ResUtils.id(viewGroup4.getContext(), "fl_coupon_bg"));
            ViewGroup viewGroup5 = this.d;
            this.f = viewGroup5.findViewById(ResUtils.id(viewGroup5.getContext(), "mist_view"));
            ViewGroup viewGroup6 = this.d;
            this.e = (TextView) viewGroup6.findViewById(ResUtils.id(viewGroup6.getContext(), "group_title"));
            ViewGroup viewGroup7 = this.d;
            this.f3648i = viewGroup7.findViewById(ResUtils.id(viewGroup7.getContext(), "icon"));
            ViewGroup viewGroup8 = this.d;
            this.k = (TextView) viewGroup8.findViewById(ResUtils.id(viewGroup8.getContext(), "coupon_name"));
            b bVar = this.n;
            ViewGroup viewGroup9 = this.d;
            bVar.a = (TextView) viewGroup9.findViewById(ResUtils.id(viewGroup9.getContext(), "market_label"));
            ViewGroup viewGroup10 = this.d;
            this.f3649o = (TextView) viewGroup10.findViewById(ResUtils.id(viewGroup10.getContext(), "date_msg"));
            ViewGroup viewGroup11 = this.d;
            this.l = (TextView) viewGroup11.findViewById(ResUtils.id(viewGroup11.getContext(), "coupon_title_head"));
            ViewGroup viewGroup12 = this.d;
            this.m = (TextView) viewGroup12.findViewById(ResUtils.id(viewGroup12.getContext(), "coupon_title_desc"));
            ViewGroup viewGroup13 = this.d;
            this.p = (TextView) viewGroup13.findViewById(ResUtils.id(viewGroup13.getContext(), "sub_title"));
            ViewGroup viewGroup14 = this.d;
            this.q = (TextView) viewGroup14.findViewById(ResUtils.id(viewGroup14.getContext(), "sub_title2"));
            ViewGroup viewGroup15 = this.d;
            this.u = (TextView) viewGroup15.findViewById(ResUtils.id(viewGroup15.getContext(), "scene_service_label"));
            ViewGroup viewGroup16 = this.d;
            this.v = (TextView) viewGroup16.findViewById(ResUtils.id(viewGroup16.getContext(), "coupn_new"));
            ViewGroup viewGroup17 = this.d;
            this.r = (LinearLayout) viewGroup17.findViewById(ResUtils.id(viewGroup17.getContext(), "use_limit_layout"));
            ViewGroup viewGroup18 = this.d;
            this.s = (NetImageView) viewGroup18.findViewById(ResUtils.id(viewGroup18.getContext(), "use_limit_icon"));
            ViewGroup viewGroup19 = this.d;
            this.t = (TextView) viewGroup19.findViewById(ResUtils.id(viewGroup19.getContext(), "use_limit"));
            ViewGroup viewGroup20 = this.d;
            this.w = (TextView) viewGroup20.findViewById(ResUtils.id(viewGroup20.getContext(), "top_copy"));
            ViewGroup viewGroup21 = this.d;
            this.A = (ScanningRoundView) viewGroup21.findViewById(ResUtils.id(viewGroup21.getContext(), "srv_blink_image"));
            ViewGroup viewGroup22 = this.d;
            this.x = (TextView) viewGroup22.findViewById(ResUtils.id(viewGroup22.getContext(), "tv_claim_coupon"));
            ViewGroup viewGroup23 = this.d;
            this.y = (RelativeLayout) viewGroup23.findViewById(ResUtils.id(viewGroup23.getContext(), "rl_coupon_content"));
        }
    }

    public void a(boolean z2) {
        this.B = z2;
    }

    public void b() {
        ((ViewGroup.MarginLayoutParams) this.h.getLayoutParams()).rightMargin = DisplayUtils.dip2px(this.d.getContext(), 65.0f);
    }

    public void b(boolean z2) {
        this.b = z2;
    }

    public void c() {
        if (!TextUtils.isEmpty(this.a.coupon_title_head)) {
            this.l.setVisibility(0);
            this.l.setMaxLines(1);
            this.l.setEllipsize(TextUtils.TruncateAt.END);
            this.l.setTextColor(Color.parseColor("#F73F31"));
            this.l.setText(this.a.coupon_title_head);
        } else {
            this.l.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.a.coupon_title_desc)) {
            this.m.setVisibility(0);
            this.m.setTextColor(Color.parseColor("#000014"));
            this.m.setText(this.a.coupon_title_desc);
            return;
        }
        this.m.setVisibility(8);
    }

    public void c(boolean z2) {
        this.c = z2;
    }

    public void d() {
        this.u.setVisibility(0);
    }

    public void e() {
        this.x.setVisibility(8);
        this.j.a.setOnClickListener((View.OnClickListener) null);
        this.j.a.setClickable(false);
    }

    public void f() {
        if (!TextUtils.isEmpty(this.a.top_copy)) {
            this.w.setVisibility(0);
            this.w.setBackgroundResource(R.drawable.wallet_personal_coupon_need_unlock_normal_hint_bg);
            this.w.setText(this.a.top_copy);
        } else {
            this.w.setVisibility(8);
            if (this.b) {
                this.w.setBackgroundResource(R.drawable.wallet_personal_coupon_need_unlock_normal_hint_bg);
                this.v.setVisibility(0);
                return;
            }
        }
        this.v.setVisibility(8);
    }

    public void g() {
        if (this.c) {
            this.d.setAlpha(0.4f);
        }
    }
}
