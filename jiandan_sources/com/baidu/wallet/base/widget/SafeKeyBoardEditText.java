package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.apollon.utils.GlobalUtils;

public class SafeKeyBoardEditText extends PluginEditText implements View.OnTouchListener {
    public SafeKeyBoardState a;
    public Context b;
    public ViewGroup c;
    public SafeScrollView d;
    public View e;
    public boolean f;
    public boolean g;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public int f1152i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public OnMyFocusChangeListener n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f1153o;
    public boolean p;
    public View.OnClickListener q;
    public CheckFunc r;

    public interface CheckFunc {
        boolean check(String str);
    }

    public interface OnMyFocusChangeListener {
        void onMyFocusChange(View view, boolean z);
    }

    public enum SafeKeyBoardState {
        NORMAL_STATE,
        CONFRIM_STATE
    }

    public SafeKeyBoardEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public void dismissKeyBorad() {
        this.d.dismissKeyBoard(this);
    }

    public CheckFunc getCheckFunc() {
        return this.r;
    }

    public int getCloseBtnVisibility() {
        return this.h;
    }

    public int getGap() {
        if (this.m == 0) {
            this.m = 8;
        }
        return this.m;
    }

    public int getHeadLayoutVisibility() {
        return this.f1152i;
    }

    public SafeKeyBoardState getKeyBoardState() {
        return this.a;
    }

    public View.OnClickListener getOnConfirmListener() {
        return this.q;
    }

    public boolean getUseKeyDot() {
        return this.f;
    }

    public boolean getUseKeyX() {
        return this.g;
    }

    public boolean getUseRandKey() {
        return this.k;
    }

    public boolean getUseSafeKeyBoard() {
        return this.l;
    }

    public ViewGroup getViewGroup() {
        return this.c;
    }

    public View getVisibleView() {
        return this.e;
    }

    public void initSafeKeyBoardParams(ViewGroup viewGroup, SafeScrollView safeScrollView, View view, boolean z) {
        this.c = viewGroup;
        this.d = safeScrollView;
        this.e = view;
        if (z) {
            safeScrollView.showKeyBoard(viewGroup, this, view);
        }
    }

    public boolean isShowLogoLockAnim() {
        return this.j;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.setShowSystemMethodFlag(this.f1153o);
        super.onTouch(view, motionEvent);
        int action = motionEvent.getAction();
        Layout layout = getLayout();
        if (action != 0) {
            return true;
        }
        requestFocus();
        this.off = layout.getOffsetForHorizontal(layout.getLineForVertical(getScrollY() + ((int) motionEvent.getY())), (float) ((int) motionEvent.getX()));
        if (!hasFocus()) {
            return true;
        }
        SafeScrollView safeScrollView = this.d;
        if (safeScrollView == null) {
            GlobalUtils.showInputMethod(this.b, this);
            return true;
        } else if (safeScrollView.isPopupWindowShowing()) {
            return true;
        } else {
            this.d.showKeyBoard(this.c, this, this.e);
            return true;
        }
    }

    public void setCheckFunc(CheckFunc checkFunc) {
        this.r = checkFunc;
    }

    public void setCloseBtnVisibility(int i2) {
        this.h = i2;
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setDisablePast(boolean z) {
        this.p = z;
    }

    public void setGap(int i2) {
        this.m = i2;
    }

    public void setHeadLayoutVisibility(int i2) {
        this.f1152i = i2;
    }

    public void setOnConfirmListener(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setOnMyFocusChangeListener(OnMyFocusChangeListener onMyFocusChangeListener) {
        this.n = onMyFocusChangeListener;
    }

    public void setShowLogoLockAnim(boolean z) {
        this.j = z;
    }

    public void setShowSystemKeyBoard(boolean z) {
        this.f1153o = z;
    }

    public void setUseKeyDot(boolean z) {
        this.f = z;
    }

    public void setUseKeyX(boolean z) {
        this.g = z;
    }

    public void setUseRandKey(boolean z) {
        this.k = z;
    }

    public void setUseSafeKeyBoard(boolean z) {
        this.l = z;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f = false;
        this.g = false;
        this.h = 0;
        this.f1152i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.f1153o = false;
        this.p = false;
    }

    public SafeKeyBoardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = false;
        this.g = false;
        this.h = 0;
        this.f1152i = 0;
        this.j = true;
        this.l = true;
        this.m = 0;
        this.f1153o = false;
        this.p = false;
        this.b = context;
        setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (!SafeKeyBoardEditText.this.p) {
                    return false;
                }
                SafeKeyBoardEditText.this.requestFocusFromTouch();
                return true;
            }
        });
        setOnTouchListener(this);
        setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    SafeKeyBoardEditText safeKeyBoardEditText = SafeKeyBoardEditText.this;
                    if (!safeKeyBoardEditText.isAlwaysShow) {
                        if (safeKeyBoardEditText.d != null) {
                            SafeKeyBoardEditText.this.d.dismissKeyBoard(SafeKeyBoardEditText.this);
                        } else {
                            GlobalUtils.hideInputMethod(SafeKeyBoardEditText.this.b, SafeKeyBoardEditText.this);
                        }
                    }
                } else if (SafeKeyBoardEditText.this.l) {
                    GlobalUtils.hideInputMethod(SafeKeyBoardEditText.this.b, SafeKeyBoardEditText.this);
                    if (SafeKeyBoardEditText.this.d != null && SafeKeyBoardEditText.this.d.hasWindowFocus() && !SafeKeyBoardEditText.this.d.isPopupWindowShowing()) {
                        SafeScrollView b = SafeKeyBoardEditText.this.d;
                        ViewGroup e = SafeKeyBoardEditText.this.c;
                        SafeKeyBoardEditText safeKeyBoardEditText2 = SafeKeyBoardEditText.this;
                        b.showKeyBoard(e, safeKeyBoardEditText2, safeKeyBoardEditText2.e);
                    }
                }
                if (SafeKeyBoardEditText.this.n != null) {
                    SafeKeyBoardEditText.this.n.onMyFocusChange(view, z);
                }
            }
        });
    }
}
