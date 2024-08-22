package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.baidu.common.operation.CommonOperationModel;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;
import com.baidu.sapi2.views.logindialog.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VerificationCodeInput */
public class a extends ViewGroup {
    private static final String k = "number";
    private static final String l = "text";
    private static final String m = "password";
    private static final String n = "phone";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f18580a;

    /* renamed from: b  reason: collision with root package name */
    private int f18581b;

    /* renamed from: c  reason: collision with root package name */
    private int f18582c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f18583d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f18584e = "number";

    /* renamed from: f  reason: collision with root package name */
    private Drawable f18585f = null;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f18586g = null;

    /* renamed from: h  reason: collision with root package name */
    private int f18587h = Color.parseColor(CommonOperationModel.BOTTOM_BAR_TEXT_DEFAULT_DAY_COLOR);

    /* renamed from: i  reason: collision with root package name */
    private e f18588i;

    /* renamed from: j  reason: collision with root package name */
    private List<EditText> f18589j = new ArrayList();

    /* renamed from: com.baidu.sapi2.views.logindialog.view.a$a  reason: collision with other inner class name */
    /* compiled from: VerificationCodeInput */
    class C0296a implements View.OnClickListener {
        C0296a() {
        }

        public void onClick(View view2) {
            EditText a2 = a.this.h();
            if (a2 != null) {
                a.this.a(a2);
            }
        }
    }

    /* compiled from: VerificationCodeInput */
    class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f18591a;

        b(EditText editText) {
            this.f18591a = editText;
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
                String obj = this.f18591a.getText().toString();
                int i5 = i2 + 1;
                this.f18591a.setText(obj.substring(0, i5));
                EditText a2 = a.this.h();
                if (a2 != null && TextUtils.isEmpty(a2.getText().toString())) {
                    a2.setText(i4 > 0 ? obj.substring(i5, i2 + i4) : "");
                }
            }
        }
    }

    /* compiled from: VerificationCodeInput */
    class c implements View.OnKeyListener {
        c() {
        }

        public synchronized boolean onKey(View view2, int i2, KeyEvent keyEvent) {
            if (i2 == 67) {
                a.this.d();
            }
            return false;
        }
    }

    /* compiled from: VerificationCodeInput */
    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f18594a;

        d(EditText editText) {
            this.f18594a = editText;
        }

        public void run() {
            EditText editText;
            InputMethodManager inputMethodManager = (InputMethodManager) a.this.f18580a.getSystemService(InputMethodController.BUTTON_INPUT_METHOD);
            if (inputMethodManager != null && (editText = this.f18594a) != null) {
                inputMethodManager.showSoftInput(editText, 0);
            }
        }
    }

    /* compiled from: VerificationCodeInput */
    public interface e {
        void a(String str);
    }

    public a(Context context) {
        super(context);
        this.f18580a = context;
    }

    /* access modifiers changed from: private */
    public void f() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.f18581b; i2++) {
            sb.append(((EditText) getChildAt(i2)).getText().toString());
        }
        e eVar = this.f18588i;
        if (eVar != null) {
            eVar.a(sb.toString());
        }
    }

    private void g() {
        EditText editText = (EditText) getChildAt(0);
        if (editText != null) {
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            a(editText);
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

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            childAt.setVisibility(0);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i7 = this.f18582c;
            int i8 = i7 + ((measuredWidth + i7) * i6);
            int i9 = this.f18583d;
            childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
        }
    }

    /* access modifiers changed from: protected */
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
                this.f18582c = (measuredWidth - (measuredWidth2 * childCount)) / (childCount + 1);
            }
            setMeasuredDimension(ViewGroup.resolveSize((measuredWidth2 * childCount) + (this.f18582c * (childCount + 1)), i2), ViewGroup.resolveSize(childAt.getMeasuredHeight() + (this.f18583d * 2), i3));
        }
    }

    public void setBox(int i2) {
        this.f18581b = i2;
    }

    public void setBoxErrorBg(Drawable drawable) {
        this.f18586g = drawable;
    }

    public void setBoxNormalBg(Drawable drawable) {
        this.f18585f = drawable;
    }

    public void setEnabled(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setEnabled(z);
        }
    }

    public void setInputType(String str) {
        this.f18584e = str;
    }

    public void setListener(e eVar) {
        this.f18588i = eVar;
    }

    public void setOnCompleteListener(e eVar) {
        this.f18588i = eVar;
    }

    public void setTextColor(int i2) {
        this.f18587h = i2;
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

    /* access modifiers changed from: private */
    public boolean e() {
        for (int i2 = 0; i2 < this.f18581b; i2++) {
            if (((EditText) getChildAt(i2)).getText().toString().length() == 0) {
                return false;
            }
        }
        return true;
    }

    public void b() {
        this.f18589j.clear();
        for (int i2 = 0; i2 < this.f18581b; i2++) {
            EditText editText = new EditText(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dp2px(this.f18580a, 38.0f), ViewUtils.dp2px(this.f18580a, 38.0f));
            int i3 = this.f18583d;
            layoutParams.bottomMargin = i3;
            layoutParams.topMargin = i3;
            int i4 = this.f18582c;
            layoutParams.leftMargin = i4;
            layoutParams.rightMargin = i4;
            layoutParams.gravity = 17;
            editText.setBackground(this.f18585f);
            editText.setTextColor(this.f18587h);
            editText.setLayoutParams(layoutParams);
            editText.setGravity(17);
            editText.setPadding(0, ViewUtils.dp2px(this.f18580a, 1.0f), 0, 0);
            if ("number".equals(this.f18584e)) {
                editText.setInputType(2);
            } else if ("password".equals(this.f18584e)) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else if ("text".equals(this.f18584e)) {
                editText.setInputType(1);
            } else if ("phone".equals(this.f18584e)) {
                editText.setInputType(3);
            }
            editText.setId(i2);
            editText.setTag(Integer.valueOf(i2));
            editText.setImeOptions(268435456);
            editText.setClickable(true);
            editText.setFocusableInTouchMode(false);
            editText.setOnClickListener(new C0296a());
            editText.addTextChangedListener(new b(editText));
            editText.setOnKeyListener(new c());
            addView(editText, i2);
            this.f18589j.add(editText);
        }
        g();
    }

    public void c() {
        for (EditText next : this.f18589j) {
            next.setBackground(this.f18585f);
            next.setText("");
        }
        EditText editText = this.f18589j.get(0);
        if (editText != null) {
            editText.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    public void a(EditText editText) {
        new Handler().postDelayed(new d(editText), 100);
    }

    public void a() {
        for (EditText background : this.f18589j) {
            background.setBackground(this.f18586g);
        }
    }
}
