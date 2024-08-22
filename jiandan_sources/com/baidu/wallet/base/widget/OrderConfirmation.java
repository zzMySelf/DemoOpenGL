package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.ResUtils;

public class OrderConfirmation extends LinearLayout {
    public NetImageView a;
    public NetImageView b;
    public View c = null;
    public TextView d = null;
    public ImageView e = null;
    public View f = null;
    public TextView g = null;
    public View h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f1148i;
    public View j = null;
    public TextView k = null;
    public TextView l = null;
    public ImageView m = null;
    public View n = null;

    /* renamed from: o  reason: collision with root package name */
    public TextView f1149o = null;

    public OrderConfirmation(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_orderconfirmation"), this);
        this.a = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_back"));
        this.b = (NetImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_title"));
        this.b.setImageResource(ResUtils.drawable(getContext(), "wallet_cashdesk_logo"));
        TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_pay_title"));
        this.n = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_pay_price"));
        this.f1149o = textView2;
        if (textView2 != null) {
            textView2.setText("");
        }
        this.c = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_layout"));
        this.e = (ImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account_icon"));
        this.d = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_ebpay_account"));
        this.f = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account"));
        this.g = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_account_value"));
        this.h = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_sp_name"));
        this.f1148i = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_spname_value"));
        View findViewById = findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods"));
        this.j = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        TextView textView3 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods_discount_type"));
        this.k = textView3;
        if (textView3 != null) {
            textView3.setText("");
        }
        TextView textView4 = (TextView) findViewById(ResUtils.id(getContext(), "bd_wallet_id_base_order_goods_discount"));
        this.l = textView4;
        if (textView4 != null) {
            textView4.setText("");
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "bd_wallet_account_arrow_icon"));
        this.m = imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void b() {
        if (this.n != null) {
            View view = this.c;
            int i2 = (view == null || view.getVisibility() != 0) ? 0 : 1;
            if (this.c != null && this.f.getVisibility() == 0) {
                i2++;
            }
            if (this.c != null && this.j.getVisibility() == 0) {
                i2++;
            }
            if (i2 >= 3) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
            }
        }
    }

    public View getBackButton() {
        return this.a;
    }

    public View getCouponInfoView() {
        return this.j;
    }

    public void setAccountInfo(String str, View.OnClickListener onClickListener) {
        if (this.c == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.c.setVisibility(0);
            if (onClickListener != null) {
                this.c.setOnClickListener(onClickListener);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(4);
            }
            this.d.setText(str);
            b();
            return;
        }
        this.c.setVisibility(8);
    }

    public void setCouponInfo(CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
        View view = this.j;
        if (view != null && view.getVisibility() != 8) {
            if (onClickListener != null) {
                this.j.setOnClickListener(onClickListener);
            }
            if (this.k != null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.j.setVisibility(0);
                    this.k.setText(charSequence);
                } else {
                    this.j.setVisibility(8);
                    return;
                }
            }
            if (this.l == null) {
                return;
            }
            if (!TextUtils.isEmpty(charSequence2)) {
                this.l.setVisibility(0);
                this.l.setVisibility(0);
                this.l.setText(charSequence2);
                this.m.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            this.m.setVisibility(4);
            this.j.setOnClickListener((View.OnClickListener) null);
        }
    }

    public void setDiscountInfoVisiable(boolean z) {
        View view = this.j;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setOrderInfo(CharSequence charSequence) {
        View view = this.f;
        if (view != null) {
            if (this.g == null) {
                view.setVisibility(8);
            } else if (!TextUtils.isEmpty(charSequence)) {
                this.f.setVisibility(0);
                this.g.setText(charSequence);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public void setOrderPrice(CharSequence charSequence, CharSequence charSequence2) {
        TextView textView;
        if (this.n != null && !TextUtils.isEmpty(charSequence) && (textView = this.f1149o) != null) {
            textView.setText(charSequence);
            this.n.setVisibility(0);
        }
    }

    public void setSpNameValue(CharSequence charSequence) {
        View view = this.h;
        if (view != null) {
            if (this.f1148i == null) {
                view.setVisibility(8);
            } else if (!TextUtils.isEmpty(charSequence)) {
                this.h.setVisibility(0);
                this.f1148i.setText(charSequence);
            } else {
                this.h.setVisibility(8);
            }
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.setImageUrl(str);
        }
    }

    public OrderConfirmation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}
