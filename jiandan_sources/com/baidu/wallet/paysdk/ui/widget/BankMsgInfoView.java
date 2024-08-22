package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BorderTipTextView;

@SuppressLint({"NewApi"})
public class BankMsgInfoView extends LinearLayout {
    public NetImageView a;
    public TextView b;
    public BorderTipTextView c;
    public ViewGroup d;

    public BankMsgInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_bankinfo_view"), this);
        this.d = (ViewGroup) findViewById(ResUtils.id(getContext(), "layout_entity"));
        this.a = (NetImageView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_logo"));
        this.b = (TextView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_txt"));
        this.c = (BorderTipTextView) findViewById(ResUtils.id(getContext(), "bindcard_bankinfo_coupon_txt"));
    }

    public void hideCouponView() {
        this.c.setVisibility(8);
    }

    public void setBankInfo(String str, CharSequence charSequence) {
        if (!TextUtils.isEmpty(str)) {
            this.a.setImageResource(ResUtils.drawable(getContext(), "wallet_base_banklogo_defult"));
            this.a.setImageUrl(str);
            this.a.setVisibility(0);
        }
        this.b.setText(charSequence);
    }

    public void setCouponDesc(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.c.setVisibility(0);
            this.c.setText(charSequence, true);
            return;
        }
        this.c.setVisibility(8);
    }

    public void setVisibility(int i2) {
        if (i2 == 0) {
            super.setVisibility(0);
            this.d.setVisibility(0);
            return;
        }
        this.d.setVisibility(4);
    }

    public BankMsgInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BankMsgInfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
