package com.baidu.wallet.lightapp.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;

public class LoadingDialogForLightApp extends Dialog {
    public TextView a;
    public ProgressBar b;
    public String c;
    public Context d = null;

    public LoadingDialogForLightApp(Context context) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.d = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.d, "wallet_base_loading_dialog_for_light_app"));
        this.a = (TextView) findViewById(ResUtils.id(this.d, "dialog_msg"));
        this.b = (ProgressBar) findViewById(ResUtils.id(this.d, "progress_bar"));
        if (!TextUtils.isEmpty(this.c)) {
            this.a.setText(this.c);
        }
        if (!TextUtils.isEmpty(GlobalUtils.showStr)) {
            this.a.setText(GlobalUtils.showStr);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(true);
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

    public LoadingDialogForLightApp(Context context, String str) {
        super(context, ResUtils.style(context, "LoadingDialog"));
        this.c = str;
        this.d = context;
    }

    public LoadingDialogForLightApp(Context context, int i2) {
        super(context, i2);
    }
}
