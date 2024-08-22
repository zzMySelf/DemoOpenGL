package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.WalletGlobalUtils;

public class LoadingDialog extends Dialog {
    public static final String c = "LoadingDialog";
    public TextView a;
    public String b;
    public Context d = null;
    public ImageView e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.d = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.d, "wallet_base_layout_loading"));
        this.a = (TextView) findViewById(ResUtils.id(this.d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.b)) {
            this.a.setText(this.b);
        }
        if (!TextUtils.isEmpty(WalletGlobalUtils.showStr)) {
            this.a.setText(WalletGlobalUtils.showStr);
        }
        ImageView imageView = (ImageView) findViewById(ResUtils.id(this.d, "img_anim"));
        this.e = imageView;
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
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
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.b = str;
        this.d = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
    }
}
