package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.LogUtil;

public class SixNumberPwdView extends LinearLayout implements TextWatcher {
    public static final int PWD_LEN = 6;
    public EditText a;
    public ImageView[] b = new ImageView[6];
    public View[] c = new View[6];
    public View[] d = new View[6];
    public OnPwdChangedListener e;
    public boolean f = true;
    public Animation g = null;
    public Animation h = null;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f1157i = null;
    public Drawable j = null;
    public int k;

    public interface OnPwdChangedListener {
        void onPwdChanged(int i2);
    }

    public SixNumberPwdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = (EditText) LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_base_new_view_six_pwd"), this).findViewById(ResUtils.id(context, "pwd_input"));
        this.b[0] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_1"));
        this.c[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line"));
        this.d[0] = findViewById(ResUtils.id(context, "pwd_iv_1_line_view"));
        this.b[1] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_2"));
        this.c[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line"));
        this.d[1] = findViewById(ResUtils.id(context, "pwd_iv_2_line_view"));
        this.b[2] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_3"));
        this.c[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line"));
        this.d[2] = findViewById(ResUtils.id(context, "pwd_iv_3_line_view"));
        this.b[3] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_4"));
        this.c[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line"));
        this.d[3] = findViewById(ResUtils.id(context, "pwd_iv_4_line_view"));
        this.b[4] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_5"));
        this.c[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line"));
        this.d[4] = findViewById(ResUtils.id(context, "pwd_iv_5_line_view"));
        this.b[5] = (ImageView) findViewById(ResUtils.id(context, "pwd_iv_6"));
        this.c[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line"));
        this.d[5] = findViewById(ResUtils.id(context, "pwd_iv_6_line_view"));
        this.a.addTextChangedListener(this);
        this.g = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "wallet_base_six_number_pwd_view_circle"));
        this.h = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "wallet_base_new_six_number_pwd_view_line"));
        this.f1157i = ResUtils.getDrawable(context, "wallet_base_new_six_number_pwd_view_circle");
        this.j = ResUtils.getDrawable(context, "wallet_base_safekeyboard_six_number_circle_black");
        this.k = ResUtils.getColor(context, "ebpay_new_six_number_pwd_line_d0d3d9");
        a();
        a(-1);
    }

    private void a() {
        int length = this.a.getText().length();
        for (int i2 = 0; i2 < 6; i2++) {
            if (i2 < length) {
                this.b[i2].setVisibility(0);
                if (i2 == length - 1) {
                    this.b[i2].setImageDrawable(this.f1157i);
                    if (this.f) {
                        this.b[i2].startAnimation(this.g);
                    }
                } else {
                    this.b[i2].setImageDrawable(this.j);
                }
            } else {
                this.b[i2].setVisibility(8);
            }
        }
    }

    public void addSixNumberPwdChangedListenter(OnPwdChangedListener onPwdChangedListener) {
        this.e = onPwdChangedListener;
    }

    public void afterTextChanged(Editable editable) {
        a();
        a(editable.length() - 1);
        OnPwdChangedListener onPwdChangedListener = this.e;
        if (onPwdChangedListener != null) {
            onPwdChangedListener.onPwdChanged(editable.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public String getPwd() {
        if (TextUtils.isEmpty(this.a.getText().toString())) {
            return "";
        }
        return SafePay.getInstance().localEncrypt1(this.a.getText().toString());
    }

    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode2 == 1073741824 || i2 == Integer.MIN_VALUE) {
            size = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec((size - (DisplayUtils.dip2px(getContext(), 0.5f) * 5)) / 6, 1073741824);
        } else if (mode == 1073741824) {
            size = View.MeasureSpec.makeMeasureSpec((size2 * 6) + (DisplayUtils.dip2px(getContext(), 0.5f) * 5), 1073741824);
        } else {
            i3 = size2;
        }
        super.onMeasure(size, i3);
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (i4 < i3) {
            this.f = false;
        } else {
            this.f = true;
        }
    }

    public void resetPwd() {
        LogUtil.logd("resetPwd");
        this.a.setText("");
    }

    public void setShowInputMethod(boolean z) {
        ((SafeKeyBoardEditText) this.a).setShowInputMethod(z);
    }

    private void a(int i2) {
        if (i2 <= 5) {
            for (int i3 = 0; i3 < 6; i3++) {
                this.d[i3].setBackgroundColor(this.k);
                if (i3 == i2) {
                    this.c[i3].setVisibility(0);
                    this.c[i3].startAnimation(this.h);
                } else {
                    this.c[i3].setVisibility(8);
                }
            }
        }
    }
}
