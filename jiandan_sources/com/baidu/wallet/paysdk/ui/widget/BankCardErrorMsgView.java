package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;

public class BankCardErrorMsgView extends LinearLayout {
    public TextView a;
    public TextView b;

    public BankCardErrorMsgView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_cashdesk_bindcard_errormsg_view"), this);
        this.a = (TextView) inflate.findViewById(ResUtils.id(context, "wallet_bindcard_errormsg_tip_name"));
        this.b = (TextView) inflate.findViewById(ResUtils.id(context, "wallet_bindcard_errormsg_tip_value"));
    }

    public void showErrorLayout(CharSequence charSequence, CharSequence charSequence2) {
        TextView textView = this.a;
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        textView.setVisibility(8);
        this.a.setText(charSequence);
        this.b.setVisibility(TextUtils.isEmpty(charSequence2) ? 4 : 0);
        this.b.setText(charSequence2);
    }

    public BankCardErrorMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
