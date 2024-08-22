package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;

public abstract class BaseDialog extends Dialog {
    public static final String a = "BaseDialog";
    public TextView b;
    public LinearLayout c;
    public Button d;
    public Button e;
    public ImageButton f;
    public View g;
    public LinearLayout.LayoutParams h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f1137i;
    public View.OnClickListener j = new View.OnClickListener() {
        public void onClick(View view) {
            BaseDialog.this.dismiss();
        }
    };
    public Context mContext;

    public BaseDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.mContext = context;
    }

    public void addContentView(View view) {
        this.c.removeAllViews();
        this.c.addView(view, this.h);
    }

    public Button getNegativeBtn() {
        return this.e;
    }

    public void hideButtons() {
        findViewById(ResUtils.id(this.mContext, "dialog_btns")).setVisibility(8);
    }

    public void hideNegativeButton() {
        Button button = this.e;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.g;
        if (view != null) {
            view.setVisibility(8);
        }
        this.d.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_dialog_btn_selector"));
    }

    public void hidePositiveButton() {
        Button button = this.d;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.g;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTitle() {
        this.b.setVisibility(8);
    }

    public void hideTitleLine() {
        findViewById(ResUtils.id(this.mContext, "dialog_title_line")).setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_layout_dialog_base"));
        this.b = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_title"));
        this.d = (Button) findViewById(ResUtils.id(this.mContext, "positive_btn"));
        this.e = (Button) findViewById(ResUtils.id(this.mContext, "negative_btn"));
        this.f = (ImageButton) findViewById(ResUtils.id(this.mContext, "dialog_title_close"));
        this.g = findViewById(ResUtils.id(this.mContext, "btn_line"));
        this.d.setOnClickListener(this.j);
        this.e.setOnClickListener(this.j);
        this.f.setOnClickListener(this.j);
        this.c = (LinearLayout) findViewById(ResUtils.id(this.mContext, "dialog_content_layout"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.h = layoutParams;
        layoutParams.gravity = 17;
        this.f1137i = LayoutInflater.from(this.mContext);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Button button = this.e;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Button button = this.d;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveButtonEnable(boolean z) {
        Button button = this.d;
        if (button != null) {
            button.setTextColor(ResUtils.getColor(this.mContext, z ? "wallet_base_mainColor" : "bd_wallet_pwdpay_light_gray"));
            this.d.setEnabled(z);
        }
    }

    public void setTitleText(int i2) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void setTitleTextBackgroud(int i2) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setBackgroundColor(i2);
        }
    }

    public void showCloseBtn(boolean z) {
        ImageButton imageButton = this.f;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 4);
        }
    }

    public void addContentView(View view, LinearLayout.LayoutParams layoutParams) {
        this.c.removeAllViews();
        this.c.addView(view, layoutParams);
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        Button button = this.e;
        if (button != null) {
            button.setText(i2);
            Button button2 = this.e;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        Button button = this.d;
        if (button != null) {
            button.setText(i2);
            Button button2 = this.d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public BaseDialog(Context context, int i2) {
        super(context, i2);
        this.mContext = context;
    }

    public void addContentView(int i2) {
        this.c.removeAllViews();
        this.c.addView(this.f1137i.inflate(i2, (ViewGroup) null), this.h);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        if (this.e != null) {
            if (!TextUtils.isEmpty(str)) {
                this.e.setText(str);
            }
            Button button = this.e;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Button button = this.d;
        if (button != null) {
            button.setText(spannableString);
            Button button2 = this.d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void addContentView(int i2, LinearLayout.LayoutParams layoutParams) {
        this.c.removeAllViews();
        this.c.addView(this.f1137i.inflate(i2, (ViewGroup) null), layoutParams);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        if (this.d != null) {
            if (!TextUtils.isEmpty(str)) {
                this.d.setText(str);
            }
            Button button = this.d;
            if (onClickListener == null) {
                onClickListener = this.j;
            }
            button.setOnClickListener(onClickListener);
        }
    }
}
