package com.baidu.apollon.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;

public class LoadingDialog extends Dialog {
    public static final String a = "LoadingDialog";
    public TextView b;
    public String c;
    public Context d = null;
    public ImageView e;

    public LoadingDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.d = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.d, "wallet_base_layout_loading_dialog"));
        this.b = (TextView) findViewById(ResUtils.id(this.d, "dialog_msg"));
        if (!TextUtils.isEmpty(this.c)) {
            this.b.setText(this.c);
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
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void setMessage(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public LoadingDialog(Context context, String str) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.c = str;
        this.d = context;
    }

    public LoadingDialog(Context context, int i2) {
        super(context, i2);
    }
}
