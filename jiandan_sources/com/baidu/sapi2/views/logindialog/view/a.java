package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

public class a extends ViewGroup {
    public static final String k = "number";
    public static final String l = "text";
    public static final String m = "password";
    public static final String n = "phone";
    public Context a;
    public int b;
    public int c = 0;
    public int d = 0;
    public String e = "number";
    public Drawable f = null;
    public Drawable g = null;
    public int h = Color.parseColor("#1F1F1F");

    /* renamed from: i  reason: collision with root package name */
    public d f989i;
    public List<EditText> j = new ArrayList();

    /* renamed from: com.baidu.sapi2.views.logindialog.view.a$a  reason: collision with other inner class name */
    public class C0048a implements View.OnClickListener {
        public C0048a() {
        }

        public void onClick(View view) {
            EditText unused = a.this.h();
        }
    }

    public class b implements TextWatcher {
        public final /* synthetic */ EditText a;

        public b(EditText editText) {
            this.a = editText;
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() != 0) {
                EditText unused = a.this.h();
            }
            if (a.this.e()) {
                a.this.f();
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() > 1) {
                String obj = this.a.getText().toString();
                int i5 = i2 + 1;
                this.a.setText(obj.substring(0, i5));
                EditText a2 = a.this.h();
                if (a2 != null && TextUtils.isEmpty(a2.getText().toString())) {
                    a2.setText(i4 > 0 ? obj.substring(i5, i2 + i4) : "");
                }
            }
        }
    }

    public class c implements View.OnKeyListener {
        public c() {
        }

        public synchronized boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 == 67) {
                a.this.d();
            }
            return false;
        }
    }

    public interface d {
        void a(String str);
    }

    public a(Context context) {
        super(context);
        this.a = context;
    }

    /* access modifiers changed from: private */
    public boolean e() {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (((EditText) getChildAt(i2)).getText().toString().length() == 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void f() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.b; i2++) {
            sb.append(((EditText) getChildAt(i2)).getText().toString());
        }
        d dVar = this.f989i;
        if (dVar != null) {
            dVar.a(sb.toString());
        }
    }

    private void g() {
        EditText editText = (EditText) getChildAt(0);
        if (editText != null) {
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
        }
    }

    private int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    /* access modifiers changed from: private */
    public EditText h() {
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            EditText editText = (EditText) getChildAt(i2);
            if ((editText.getText().length() >= 1 || i2 >= childCount - 1) && i2 != childCount - 1) {
                i2++;
            } else {
                editText.requestFocusFromTouch();
                editText.setSelection(editText.getText().length());
                return editText;
            }
        }
        return null;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LinearLayout.LayoutParams(getContext(), attributeSet);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            childAt.setVisibility(0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i7 = this.c;
            int i8 = i7 + ((measuredWidth + i7) * i6);
            int i9 = this.d;
            childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth == -1) {
            measuredWidth = getScreenWidth();
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            measureChild(getChildAt(i4), i2, i3);
        }
        if (childCount > 0) {
            View childAt = getChildAt(0);
            int measuredWidth2 = childAt.getMeasuredWidth();
            if (measuredWidth != -2) {
                this.c = (measuredWidth - (measuredWidth2 * childCount)) / (childCount + 1);
            }
            setMeasuredDimension(ViewGroup.resolveSize((measuredWidth2 * childCount) + (this.c * (childCount + 1)), i2), ViewGroup.resolveSize(childAt.getMeasuredHeight() + (this.d * 2), i3));
        }
    }

    public void setBox(int i2) {
        this.b = i2;
    }

    public void setBoxErrorBg(Drawable drawable) {
        this.g = drawable;
    }

    public void setBoxNormalBg(Drawable drawable) {
        this.f = drawable;
    }

    public void setEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setEnabled(z);
        }
    }

    public void setInputType(String str) {
        this.e = str;
    }

    public void setListener(d dVar) {
        this.f989i = dVar;
    }

    public void setOnCompleteListener(d dVar) {
        this.f989i = dVar;
    }

    public void setTextColor(int i2) {
        this.h = i2;
    }

    /* access modifiers changed from: private */
    public void d() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            EditText editText = (EditText) getChildAt(childCount);
            if (editText.getText().length() == 1) {
                editText.requestFocus();
                editText.setSelection(1);
                return;
            }
        }
    }

    public void a() {
        for (EditText background : this.j) {
            background.setBackground(this.g);
        }
    }

    public void b() {
        this.j.clear();
        for (int i2 = 0; i2 < this.b; i2++) {
            EditText editText = new EditText(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dp2px(this.a, 38.0f), ViewUtils.dp2px(this.a, 38.0f));
            int i3 = this.d;
            layoutParams.bottomMargin = i3;
            layoutParams.topMargin = i3;
            int i4 = this.c;
            layoutParams.leftMargin = i4;
            layoutParams.rightMargin = i4;
            layoutParams.gravity = 17;
            editText.setBackground(this.f);
            editText.setTextColor(this.h);
            editText.setLayoutParams(layoutParams);
            editText.setGravity(17);
            editText.setPadding(0, ViewUtils.dp2px(this.a, 1.0f), 0, 0);
            if ("number".equals(this.e)) {
                editText.setInputType(2);
            } else if ("password".equals(this.e)) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else if ("text".equals(this.e)) {
                editText.setInputType(1);
            } else if ("phone".equals(this.e)) {
                editText.setInputType(3);
            }
            editText.setId(i2);
            editText.setTag(Integer.valueOf(i2));
            editText.setImeOptions(268435456);
            editText.setClickable(true);
            editText.setFocusableInTouchMode(false);
            editText.setOnClickListener(new C0048a());
            editText.addTextChangedListener(new b(editText));
            editText.setOnKeyListener(new c());
            addView(editText, i2);
            this.j.add(editText);
        }
        g();
    }

    public void c() {
        for (EditText next : this.j) {
            next.setBackground(this.f);
            next.setText("");
        }
        EditText editText = this.j.get(0);
        if (editText != null) {
            editText.requestFocus();
        }
    }
}
