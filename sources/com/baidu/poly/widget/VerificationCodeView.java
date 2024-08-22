package com.baidu.poly.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.poly.R;
import com.baidu.poly.util.i;
import java.lang.reflect.Field;

/* compiled from: SearchBox */
public class VerificationCodeView extends LinearLayout implements TextWatcher, View.OnKeyListener, View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f17250a;

    /* renamed from: b  reason: collision with root package name */
    private a f17251b;

    /* renamed from: c  reason: collision with root package name */
    private int f17252c;

    /* renamed from: d  reason: collision with root package name */
    private int f17253d;

    /* renamed from: e  reason: collision with root package name */
    private int f17254e;

    /* renamed from: f  reason: collision with root package name */
    private float f17255f;

    /* renamed from: g  reason: collision with root package name */
    private int f17256g;

    /* renamed from: h  reason: collision with root package name */
    private int f17257h;

    /* renamed from: i  reason: collision with root package name */
    private int f17258i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17259j;
    private boolean k;
    private int l;
    private int m;

    /* compiled from: SearchBox */
    public interface a {
        void a(View view2, String str);

        void b(View view2, String str);
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17250a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PolyVerificationCodeView);
        this.f17252c = obtainStyledAttributes.getInteger(R.styleable.PolyVerificationCodeView_vcv_et_number, 4);
        this.f17253d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PolyVerificationCodeView_vcv_et_width, 105);
        this.f17254e = obtainStyledAttributes.getColor(R.styleable.PolyVerificationCodeView_vcv_et_text_color, -16777216);
        this.f17255f = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.PolyVerificationCodeView_vcv_et_text_size, 16);
        this.f17256g = obtainStyledAttributes.getResourceId(R.styleable.PolyVerificationCodeView_vcv_et_bg, R.drawable.poly_sdk_verification_code_et_bg);
        this.l = obtainStyledAttributes.getResourceId(R.styleable.PolyVerificationCodeView_vcv_et_cursor, R.drawable.poly_sdk_verification_code_cursor_bg);
        this.k = obtainStyledAttributes.getBoolean(R.styleable.PolyVerificationCodeView_vcv_et_cursor_visible, true);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.PolyVerificationCodeView_vcv_et_spacing);
        this.f17259j = hasValue;
        if (hasValue) {
            this.f17257h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.PolyVerificationCodeView_vcv_et_spacing, 0);
        }
        c();
        obtainStyledAttributes.recycle();
    }

    private void a(EditText editText, int i2) {
        editText.setLayoutParams(a(i2));
        editText.setTextAlignment(4);
        editText.setGravity(17);
        editText.setId(i2);
        editText.setCursorVisible(false);
        editText.setMaxEms(1);
        editText.setTextColor(this.f17254e);
        editText.setTextSize(this.f17255f);
        editText.setCursorVisible(this.k);
        editText.setMaxLines(1);
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
        editText.setInputType(2);
        editText.setPadding(0, 0, 0, 0);
        editText.setOnKeyListener(this);
        editText.setBackgroundResource(this.f17256g);
        setEditTextCursorDrawable(editText);
        editText.addTextChangedListener(this);
        editText.setOnKeyListener(this);
        editText.setOnFocusChangeListener(this);
    }

    private void b() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            EditText editText = (EditText) getChildAt(i2);
            if (editText.getText().length() < 1) {
                if (this.k) {
                    editText.setCursorVisible(true);
                } else {
                    editText.setCursorVisible(false);
                }
                editText.requestFocus();
                return;
            }
            editText.setCursorVisible(false);
            if (i2 == childCount - 1) {
                editText.requestFocus();
            }
        }
    }

    private void c() {
        for (int i2 = 0; i2 < this.f17252c; i2++) {
            EditText editText = new EditText(this.f17250a);
            a(editText, i2);
            addView(editText);
            if (i2 == 0) {
                editText.setFocusable(true);
            }
        }
    }

    private void f() {
        for (int i2 = 0; i2 < this.f17252c; i2++) {
            ((EditText) getChildAt(i2)).setLayoutParams(a(i2));
        }
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f17252c; i2++) {
            sb.append(((EditText) getChildAt(i2)).getText());
        }
        return sb.toString();
    }

    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0) {
            b();
        }
        a aVar = this.f17251b;
        if (aVar != null) {
            aVar.a(this, getResult());
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= getChildCount()) {
                    z = true;
                    break;
                }
                EditText editText = (EditText) getChildAt(i2);
                if (editText != null && TextUtils.isEmpty(editText.getText().toString().trim())) {
                    break;
                }
                i2++;
            }
            if (z) {
                this.f17251b.b(this, getResult());
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void d() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((EditText) getChildAt(i2)).setBackgroundResource(R.drawable.poly_sdk_verification_code_et_error_bg);
        }
    }

    public void e() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            EditText editText = (EditText) getChildAt(i2);
            editText.setText("");
            editText.setBackgroundResource(R.drawable.poly_sdk_verification_code_et_bg);
        }
        EditText editText2 = (EditText) getChildAt(0);
        editText2.setCursorVisible(true);
        editText2.requestFocus();
        i.a(editText2);
    }

    public a getOnCodeFinishListener() {
        return this.f17251b;
    }

    public int getmCursorDrawable() {
        return this.l;
    }

    public int getmEtNumber() {
        return this.f17252c;
    }

    public int getmEtTextBg() {
        return this.f17256g;
    }

    public int getmEtTextColor() {
        return this.f17254e;
    }

    public float getmEtTextSize() {
        return this.f17255f;
    }

    public int getmEtWidth() {
        return this.f17253d;
    }

    public void onFocusChange(View view2, boolean z) {
        if (z) {
            b();
        }
    }

    public boolean onKey(View view2, int i2, KeyEvent keyEvent) {
        if (i2 != 67 || keyEvent.getAction() != 0) {
            return false;
        }
        a();
        return false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.m = getMeasuredWidth();
        f();
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    public void setEditTextCursorDrawable(EditText editText) {
        if (this.k) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(this.l));
            } catch (Exception e2) {
            }
        }
    }

    public void setEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setEnabled(z);
        }
    }

    public void setOnCodeFinishListener(a aVar) {
        this.f17251b = aVar;
    }

    public void setmCursorDrawable(int i2) {
        this.l = i2;
    }

    public void setmEtNumber(int i2) {
        this.f17252c = i2;
    }

    public void setmEtTextBg(int i2) {
        this.f17256g = i2;
    }

    public void setmEtTextColor(int i2) {
        this.f17254e = i2;
    }

    public void setmEtTextSize(float f2) {
        this.f17255f = f2;
    }

    public void setmEtWidth(int i2) {
        this.f17253d = i2;
    }

    public LinearLayout.LayoutParams a(int i2) {
        int i3 = this.f17253d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        if (!this.f17259j) {
            int i4 = this.m;
            int i5 = this.f17252c;
            int i6 = (i4 - (this.f17253d * i5)) / (i5 + 1);
            this.f17258i = i6;
            if (i2 == 0) {
                layoutParams.leftMargin = i6;
                layoutParams.rightMargin = i6 / 2;
            } else if (i2 == i5 - 1) {
                layoutParams.leftMargin = i6 / 2;
                layoutParams.rightMargin = i6;
            } else {
                int i7 = i6 / 2;
                layoutParams.leftMargin = i7;
                layoutParams.rightMargin = i7;
            }
        } else {
            int i8 = this.f17257h / 2;
            layoutParams.leftMargin = i8;
            layoutParams.rightMargin = i8;
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private void a() {
        for (int i2 = this.f17252c - 1; i2 >= 0; i2--) {
            EditText editText = (EditText) getChildAt(i2);
            if (editText.getText().length() >= 1) {
                editText.setText("");
                if (this.k) {
                    editText.setCursorVisible(true);
                } else {
                    editText.setCursorVisible(false);
                }
                editText.requestFocus();
                return;
            }
        }
    }
}
