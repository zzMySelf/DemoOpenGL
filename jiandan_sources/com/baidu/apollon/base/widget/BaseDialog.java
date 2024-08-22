package com.baidu.apollon.base.widget;

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
    public TextView a;
    public LinearLayout b;
    public Button c;
    public Button d;
    public ImageButton e;
    public View f;
    public LinearLayout.LayoutParams g;
    public LayoutInflater h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f691i = new View.OnClickListener() {
        public void onClick(View view) {
            BaseDialog.this.dismiss();
        }
    };
    public Context mContext;

    public BaseDialog(Context context) {
        super(context, ResUtils.style(context, "ApollonPromptDialog"));
        this.mContext = context;
    }

    public void addContentView(View view) {
        this.b.removeAllViews();
        this.b.addView(view, this.g);
    }

    public void hideButtons() {
        findViewById(ResUtils.id(this.mContext, "dialog_btns")).setVisibility(8);
    }

    public void hideNegativeButton() {
        Button button = this.d;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f;
        if (view != null) {
            view.setVisibility(8);
        }
        this.c.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_dialog_btn_selector"));
    }

    public void hidePositiveButton() {
        Button button = this.c;
        if (button != null) {
            button.setVisibility(8);
        }
        View view = this.f;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTitle() {
        this.a.setVisibility(8);
    }

    public void hideTitleLine() {
        findViewById(ResUtils.id(this.mContext, "dialog_title_line")).setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(ResUtils.layout(this.mContext, "wallet_base_layout_dialog_base"));
        this.a = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_title"));
        this.c = (Button) findViewById(ResUtils.id(this.mContext, "positive_btn"));
        this.d = (Button) findViewById(ResUtils.id(this.mContext, "negative_btn"));
        this.e = (ImageButton) findViewById(ResUtils.id(this.mContext, "dialog_title_close"));
        this.f = findViewById(ResUtils.id(this.mContext, "btn_line"));
        this.c.setOnClickListener(this.f691i);
        this.d.setOnClickListener(this.f691i);
        this.e.setOnClickListener(this.f691i);
        this.b = (LinearLayout) findViewById(ResUtils.id(this.mContext, "dialog_content_layout"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.g = layoutParams;
        layoutParams.gravity = 17;
        this.h = LayoutInflater.from(this.mContext);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Button button = this.d;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.f691i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Button button = this.c;
        if (button != null) {
            if (onClickListener == null) {
                onClickListener = this.f691i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(int i2) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void setTitleTextBackgroud(int i2) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setBackgroundColor(i2);
        }
    }

    public void showCloseBtn(boolean z) {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            imageButton.setVisibility(z ? 0 : 4);
        }
    }

    public void addContentView(View view, LinearLayout.LayoutParams layoutParams) {
        this.b.removeAllViews();
        this.b.addView(view, layoutParams);
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        Button button = this.d;
        if (button != null) {
            button.setText(i2);
            Button button2 = this.d;
            if (onClickListener == null) {
                onClickListener = this.f691i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        Button button = this.c;
        if (button != null) {
            button.setText(i2);
            Button button2 = this.c;
            if (onClickListener == null) {
                onClickListener = this.f691i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void setTitleText(String str) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public BaseDialog(Context context, int i2) {
        super(context, i2);
        this.mContext = context;
    }

    public void addContentView(int i2) {
        this.b.removeAllViews();
        this.b.addView(this.h.inflate(i2, (ViewGroup) null), this.g);
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        if (this.d != null) {
            if (!TextUtils.isEmpty(str)) {
                this.d.setText(str);
            }
            Button button = this.d;
            if (onClickListener == null) {
                onClickListener = this.f691i;
            }
            button.setOnClickListener(onClickListener);
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Button button = this.c;
        if (button != null) {
            button.setText(spannableString);
            Button button2 = this.c;
            if (onClickListener == null) {
                onClickListener = this.f691i;
            }
            button2.setOnClickListener(onClickListener);
        }
    }

    public void addContentView(int i2, LinearLayout.LayoutParams layoutParams) {
        this.b.removeAllViews();
        this.b.addView(this.h.inflate(i2, (ViewGroup) null), layoutParams);
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        if (this.c != null) {
            if (!TextUtils.isEmpty(str)) {
                this.c.setText(str);
            }
            Button button = this.c;
            if (onClickListener == null) {
                onClickListener = this.f691i;
            }
            button.setOnClickListener(onClickListener);
        }
    }
}
