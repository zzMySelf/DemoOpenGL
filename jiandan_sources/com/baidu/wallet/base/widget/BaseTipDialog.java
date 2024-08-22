package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;

public class BaseTipDialog extends Dialog {
    public LinearLayout a;
    public TextView b;
    public LinearLayout.LayoutParams c;
    public Context mContext;
    public LayoutInflater mInflater;

    public BaseTipDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.mContext = context;
    }

    public void addContentView(View view) {
        this.a.removeAllViews();
        this.a.addView(view, this.c);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_dialog_notitle"));
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(this.mContext);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.c = layoutParams;
        layoutParams.gravity = 17;
        this.a = (LinearLayout) findViewById(ResUtils.id(this.mContext, "ebpay_dialog_content_layout"));
        this.b = (TextView) findViewById(ResUtils.id(this.mContext, "ebpay_dialog_title"));
        findViewById(ResUtils.id(this.mContext, "ebpay_dialog_title_close")).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseTipDialog.this.dismiss();
            }
        });
        findViewById(ResUtils.id(this.mContext, "i_konw_btn")).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BaseTipDialog.this.dismiss();
            }
        });
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public void setTitleMessage(int i2) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void showCloseBtn(boolean z) {
        View findViewById = findViewById(ResUtils.id(this.mContext, "ebpay_dialog_title_close"));
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 4);
        }
    }

    public BaseTipDialog(Context context, int i2) {
        super(context, i2);
        this.mContext = context;
    }

    public void setTitleMessage(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
