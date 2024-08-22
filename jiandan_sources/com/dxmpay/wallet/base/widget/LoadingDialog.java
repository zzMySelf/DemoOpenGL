package com.dxmpay.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;

public class LoadingDialog extends Dialog {
    public TextView a;
    public String b;
    public Context c = null;
    public ImageView d;
    public String e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        this.c = context;
    }

    public void onCreate(Bundle bundle) {
        ImageView imageView;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.c, "dxm_wallet_base_layout_loading"));
        this.a = (TextView) findViewById(ResUtils.id(this.c, "dialog_msg"));
        if (!TextUtils.isEmpty(this.b)) {
            this.a.setText(this.b);
        }
        if (!TextUtils.isEmpty(WalletGlobalUtils.showStr)) {
            this.a.setText(WalletGlobalUtils.showStr);
        }
        if (!TextUtils.isEmpty(this.e) && (imageView = (ImageView) findViewById(ResUtils.id(this.c, "img_logo"))) != null) {
            imageView.setImageResource(ResUtils.drawable(this.c, this.e));
        }
        ImageView imageView2 = (ImageView) findViewById(ResUtils.id(this.c, "img_anim"));
        this.d = imageView2;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView2.getDrawable();
        animationDrawable.stop();
        animationDrawable.start();
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setMessage(int i2) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void setMessage(String str) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        this.b = str;
        this.c = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
    }

    public LoadingDialog(Context context, String str, String str2) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        this.b = str;
        this.c = context;
        this.e = str2;
    }
}
