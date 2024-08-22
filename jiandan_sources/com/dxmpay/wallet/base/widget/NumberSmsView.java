package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;

public class NumberSmsView extends LinearLayout implements TextWatcher {
    public static final int SMS_LEN = 6;
    public EditText a;
    public TextView[] b;
    public View[] c;
    public View[] d;
    public OnSmsChangedListener e;
    public Animation f = null;
    public int g;
    public Context h;

    /* renamed from: i  reason: collision with root package name */
    public int f4170i;
    public View j;
    public LinearLayout k;

    public interface OnSmsChangedListener {
        void onSmsChanged(int i2);
    }

    public NumberSmsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = context;
        View inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "dxm_wallet_base_new_view_sms"), this);
        this.j = inflate;
        this.a = (EditText) inflate.findViewById(ResUtils.id(context, "sms_input"));
        this.k = (LinearLayout) this.j.findViewById(ResUtils.id(context, "six_circle"));
        this.a.addTextChangedListener(this);
    }

    private void a() {
        int length = this.a.getText().length();
        for (int i2 = 0; i2 < this.f4170i; i2++) {
            if (i2 < length) {
                this.b[i2].setVisibility(0);
            } else {
                this.b[i2].setVisibility(8);
            }
        }
    }

    private void b() {
        int i2 = this.f4170i;
        this.b = new TextView[i2];
        this.c = new View[i2];
        this.d = new View[i2];
        for (int i3 = 0; i3 < this.f4170i; i3++) {
            View inflate = LayoutInflater.from(this.h).inflate(R.layout.dxm_wallet_base_new_view_sms_item, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.lin_sms);
            this.b[i3] = (TextView) inflate.findViewById(ResUtils.id(this.h, "pwd_iv"));
            this.c[i3] = inflate.findViewById(ResUtils.id(this.h, "pwd_iv_line"));
            this.d[i3] = inflate.findViewById(ResUtils.id(this.h, "pwd_iv_line_view"));
            View findViewById = inflate.findViewById(R.id.view_sms_blank);
            if (i3 == this.f4170i - 1) {
                findViewById.setVisibility(4);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                inflate.setLayoutParams(layoutParams);
            }
            this.k.addView(inflate);
        }
    }

    private void c() {
        this.b = new TextView[6];
        this.c = new View[6];
        this.d = new View[6];
        for (int i2 = 0; i2 < 6; i2++) {
            View inflate = LayoutInflater.from(this.h).inflate(R.layout.dxm_wallet_base_new_view_sms_item, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.lin_sms);
            this.b[i2] = (TextView) inflate.findViewById(ResUtils.id(this.h, "pwd_iv"));
            this.c[i2] = inflate.findViewById(ResUtils.id(this.h, "pwd_iv_line"));
            this.d[i2] = inflate.findViewById(ResUtils.id(this.h, "pwd_iv_line_view"));
            View findViewById = inflate.findViewById(R.id.view_sms_blank);
            if (i2 == 5) {
                findViewById.setVisibility(4);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
                inflate.setLayoutParams(layoutParams);
            }
            this.k.addView(inflate);
            if (i2 >= this.f4170i) {
                inflate.setVisibility(4);
            } else {
                inflate.setVisibility(0);
            }
        }
    }

    public void addNumberSmsChangedListenter(OnSmsChangedListener onSmsChangedListener) {
        this.e = onSmsChangedListener;
    }

    public void afterTextChanged(Editable editable) {
        a();
        a(editable.length() - 1);
        OnSmsChangedListener onSmsChangedListener = this.e;
        if (onSmsChangedListener != null) {
            onSmsChangedListener.onSmsChanged(editable.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public String getSms() {
        return this.a.getText() != null ? this.a.getText().toString() : "";
    }

    public void initView(int i2) {
        if (i2 < 1) {
            i2 = 6;
        }
        this.f4170i = i2;
        this.a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.f4170i)});
        this.k.removeAllViews();
        if (this.f4170i >= 6) {
            b();
        } else {
            c();
        }
        Context context = this.h;
        this.f = AnimationUtils.loadAnimation(context, ResUtils.anim(context, "dxm_wallet_base_new_six_number_pwd_view_line"));
        this.g = ResUtils.getColor(this.h, "dxm_ebpay_new_six_number_pwd_line_d0d3d9");
        a();
        a(-1);
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
    }

    public void resetSms() {
        this.a.setText("");
    }

    public void setShowInputMethod(boolean z) {
        ((SafeKeyBoardEditText) this.a).setShowInputMethod(z);
    }

    public void smsError() {
        for (int i2 = 0; i2 < this.f4170i; i2++) {
            this.d[i2].setBackgroundColor(ResUtils.getColor(this.h, "wallet_cashdesk_new_bind_card_5050"));
            this.c[i2].setBackgroundColor(ResUtils.getColor(this.h, "wallet_cashdesk_new_bind_card_5050"));
            this.c[i2].setVisibility(0);
        }
    }

    public void smsNomal() {
        for (int i2 = 0; i2 < this.f4170i; i2++) {
            this.d[i2].setBackgroundColor(this.g);
            this.c[i2].setBackgroundColor(ResUtils.getColor(this.h, "dxm_ebpay_new_six_number_pwd_line_54576a"));
            this.c[i2].setVisibility(8);
        }
        this.c[0].startAnimation(this.f);
        this.c[0].setVisibility(0);
    }

    private void a(int i2) {
        if (i2 <= this.f4170i - 1) {
            String obj = this.a.getText().toString();
            for (int i3 = 0; i3 < this.f4170i; i3++) {
                this.d[i3].setBackgroundColor(this.g);
                this.c[i3].setBackgroundColor(ResUtils.getColor(this.h, "dxm_ebpay_new_six_number_pwd_line_54576a"));
                if (i3 == i2) {
                    this.b[i3].setText(obj.substring(i2));
                    this.c[i3].setVisibility(0);
                    this.c[i3].startAnimation(this.f);
                } else {
                    this.c[i3].setVisibility(8);
                }
            }
            if (i2 == -1) {
                this.c[0].setVisibility(0);
                this.c[0].startAnimation(this.f);
            }
        }
    }
}
