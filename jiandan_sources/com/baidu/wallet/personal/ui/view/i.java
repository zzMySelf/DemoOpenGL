package com.baidu.wallet.personal.ui.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.widget.SDKJumpManager;
import com.baidu.wallet.personal.b.b;
import com.baidu.wallet.personal.beans.a;
import com.baidu.wallet.personal.datamodel.CouponList;
import com.baidu.wallet.personal.ui.CouponUnlockLoadingActivity;
import com.baidu.wallet.personal.ui.UnuseCouponListFragment;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class i extends f {
    /* access modifiers changed from: private */
    public void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, CouponUnlockLoadingActivity.class);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                activity.startActivity(intent);
                activity.overridePendingTransition(0, 0);
                return;
            }
            intent.addFlags(268435456);
            Context applicationContext = DxmApplicationContextImpl.getApplicationContext(context);
            if (applicationContext != null) {
                applicationContext.startActivity(intent);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("coupon_name", this.a.coupon_name);
            jSONObject.put("template_num", this.a.template_num);
            jSONObject.put("coupon_num", this.a.coupon_num);
            jSONObject.put(StatHelper.CARD_TYPE, this.a.card_type);
            jSONObject.put("coupon_list_clicktime", System.currentTimeMillis() - UnuseCouponListFragment.mCreateTime);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] strArr = new String[5];
        strArr[0] = jSONObject.toString();
        int i2 = 1;
        strArr[1] = str;
        strArr[2] = this.a.coupon_type + "";
        strArr[3] = this.a.status + "";
        if (!this.a.isUnlockCoupon()) {
            i2 = 2;
        }
        strArr[4] = String.valueOf(i2);
        DXMSdkSAUtils.onEventWithValues("CouponListToUseBtnClick", Arrays.asList(strArr));
    }

    /* access modifiers changed from: private */
    public void h() {
        EventBus instance = EventBus.getInstance();
        Objects.requireNonNull(instance);
        EventBus.getInstance().post(new EventBus.Event("wallet_coupon_refresh", Boolean.TRUE));
    }

    /* access modifiers changed from: private */
    public void i() {
        CouponUnlockLoadingActivity.exitLoading();
    }

    public void a() {
        this.j.a.setBackground((Drawable) null);
        this.z.setBackgroundResource(R.drawable.wallet_personal_coupon_need_unlock_special_bg);
    }

    public void a(int i2, CouponList.Coupon coupon) {
        super.a(i2, coupon);
        if (i2 >= 0 && coupon != null) {
            this.f3649o.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_black_394259"));
            if (this.p.getVisibility() == 0) {
                this.p.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_black_cc394259"));
            }
            if (this.q.getVisibility() == 0) {
                this.q.setTextColor(ResUtils.getColor(this.d.getContext(), "coupon_base_black_cc394259"));
            }
            int i3 = coupon.coupon_list_show_formwork;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams.topMargin = DisplayUtils.dip2px(this.d.getContext(), 17.0f);
            this.h.setLayoutParams(layoutParams);
            this.l.setTextColor(b.a(this.d.getContext(), i3));
            if (TextUtils.isEmpty(coupon.coupon_color) && Build.VERSION.SDK_INT >= 16) {
                this.f3648i.setBackground(b.a(this.d.getContext(), b.b(this.d.getContext(), i3), 0));
            }
            layoutParams.bottomMargin = DisplayUtils.dip2px(this.d.getContext(), 28.0f);
            this.h.setLayoutParams(layoutParams);
            g();
        }
    }

    public void b() {
        ((ViewGroup.MarginLayoutParams) this.h.getLayoutParams()).rightMargin = DisplayUtils.dip2px(this.d.getContext(), 35.0f);
    }

    public void c() {
        this.l.setTextColor(Color.parseColor("#BF5F0D"));
        this.l.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(this.a.coupon_title_head)) {
            spannableStringBuilder.append(this.a.coupon_title_head);
        }
        if (!TextUtils.isEmpty(this.a.coupon_title_desc)) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#000014"));
            int length = spannableStringBuilder.length();
            int length2 = spannableStringBuilder.length() + this.a.coupon_title_desc.length();
            spannableStringBuilder.append(this.a.coupon_title_desc);
            spannableStringBuilder.setSpan(foregroundColorSpan, length, length2, 34);
        }
        this.l.setSingleLine(false);
        this.l.setMaxLines(2);
        this.l.setText(spannableStringBuilder);
        this.m.setVisibility(8);
    }

    public void d() {
        this.u.setVisibility(8);
    }

    public void e() {
        String str;
        TextView textView;
        View.OnClickListener onClickListener;
        RelativeLayout relativeLayout;
        this.x.setTextColor(Color.parseColor("#EEC19A"));
        this.x.setBackgroundResource(R.drawable.wallet_personal_coupon_list_btn_shape_special);
        if (!TextUtils.isEmpty(this.a.need_unlock_label)) {
            textView = this.x;
            str = this.a.need_unlock_label;
        } else {
            textView = this.x;
            str = "立即领取";
        }
        textView.setText(str);
        this.x.setVisibility(0);
        if (TextUtils.isEmpty(this.a.need_unlock_url)) {
            relativeLayout = this.j.a;
            onClickListener = new View.OnClickListener() {
                public void onClick(View view) {
                    i iVar = i.this;
                    if (!iVar.c) {
                        iVar.a(iVar.x.getContext());
                        try {
                            a aVar = new a(i.this.x.getContext());
                            aVar.a(i.this.a.coupon_num);
                            aVar.setResponseCallback(new IBeanResponseCallback() {
                                public void onBeanExecFailure(int i2, final int i3, String str) {
                                    i.this.x.post(new Runnable() {
                                        public void run() {
                                            i.this.i();
                                            i.this.x.post(new Runnable() {
                                                public void run() {
                                                    Context context;
                                                    String str;
                                                    AnonymousClass2 r0 = AnonymousClass2.this;
                                                    int i2 = i3;
                                                    if (i2 == 5003) {
                                                        context = i.this.x.getContext();
                                                        str = "未登录";
                                                    } else {
                                                        TextView textView = i.this.x;
                                                        if (i2 == 5057) {
                                                            context = textView.getContext();
                                                            str = "抱歉，领取资格已过期";
                                                        } else {
                                                            GlobalUtils.toast(textView.getContext(), "领取失败", R.drawable.wallet_personal_coupon_unlock_fail, 0, 2, 0);
                                                            i.this.h();
                                                            i.this.a("失败");
                                                        }
                                                    }
                                                    GlobalUtils.toast(context, str, 0);
                                                    i.this.h();
                                                    i.this.a("失败");
                                                }
                                            });
                                        }
                                    });
                                }

                                public void onBeanExecSuccess(int i2, Object obj, String str) {
                                    i.this.x.post(new Runnable() {
                                        public void run() {
                                            i.this.i();
                                            i.this.x.post(new Runnable() {
                                                public void run() {
                                                    GlobalUtils.toast(i.this.x.getContext(), "领取成功", R.drawable.wallet_personal_coupon_unlock_success, 0, 2, 10);
                                                    i.this.h();
                                                    i.this.a("成功");
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                            aVar.execBean();
                        } catch (Exception unused) {
                            i.this.i();
                        }
                    }
                }
            };
        } else {
            relativeLayout = this.j.a;
            onClickListener = new View.OnClickListener() {
                public void onClick(View view) {
                    if (!i.this.c) {
                        SDKJumpManager.getInstance().doSDKJump(i.this.x.getContext(), "", "1", i.this.a.need_unlock_url, true, (SDKJumpManager.OnJumpListener) null);
                        i.this.a("");
                    }
                }
            };
        }
        relativeLayout.setOnClickListener(onClickListener);
    }

    public void f() {
        if (!TextUtils.isEmpty(this.a.top_copy)) {
            this.w.setVisibility(0);
            this.w.setBackgroundResource(R.drawable.wallet_personal_coupon_need_unlock_special_hint_bg);
            this.w.setText(this.a.top_copy);
        } else {
            this.w.setVisibility(8);
            if (this.b) {
                this.w.setBackgroundResource(R.drawable.wallet_personal_coupon_need_unlock_special_hint_bg);
                this.v.setVisibility(0);
                return;
            }
        }
        this.v.setVisibility(8);
    }

    public void g() {
        if (this.c) {
            this.d.setAlpha(0.4f);
            this.j.a.setBackground((Drawable) null);
            this.z.setBackgroundResource(R.drawable.wallet_personal_coupon_need_unlock_special_invalid_bg);
        }
    }
}
