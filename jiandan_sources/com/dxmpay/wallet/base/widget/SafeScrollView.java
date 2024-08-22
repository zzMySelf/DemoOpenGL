package com.dxmpay.wallet.base.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.utils.BdWalletUtils;

public class SafeScrollView extends ScrollView {
    public static final String HIDE_KEYBOARD_LISTENER = "hide_keyboard_listener";
    public static final String a = SafeScrollView.class.getSimpleName();
    public ScrollChangedListener b;
    public boolean c;
    public EventBus d;
    public int e;
    public Context f;
    public SafeKeyBoardEditText g;
    public SafeKeyBoardUtil h;

    /* renamed from: i  reason: collision with root package name */
    public onKeyBoardStatusChangeListener f4197i;
    public int j;
    public int k;
    public boolean l;

    public interface ScrollChangedListener {
        void onScrollChanged(int i2, int i3, int i4, int i5);
    }

    public interface onKeyBoardStatusChangeListener {
        void onKeyBoardStatusChange(boolean z, int i2);
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            SafeScrollView.this.h.init(SafeScrollView.this.f, SafeScrollView.this.g.getViewGroup(), SafeScrollView.this);
            SafeScrollView.this.h.showSoftKeyBoard(SafeScrollView.this.g, SafeScrollView.this.g.getVisibleView());
        }
    }

    public SafeScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        this.d = EventBus.getInstance();
        this.e = 0;
        this.h = new SafeKeyBoardUtil();
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.f = context;
        setSafeFlag(false);
    }

    private void setSafeFlag(boolean z) {
        if (!(getContext() instanceof Activity)) {
            return;
        }
        if (z) {
            BdWalletUtils.clearFlagsSecure((Activity) getContext());
        } else {
            BdWalletUtils.addFlagsSecure((Activity) getContext());
        }
    }

    public void clear() {
        this.d.unregister(this);
    }

    public void dismissKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText) {
        if (safeKeyBoardEditText.getUseSafeKeyBoard()) {
            onKeyBoardStatusChangeListener onkeyboardstatuschangelistener = this.f4197i;
            if (onkeyboardstatuschangelistener != null) {
                onkeyboardstatuschangelistener.onKeyBoardStatusChange(false, 0);
            }
            this.h.hideSoftKeyBoard();
            return;
        }
        GlobalUtils.hideInputMethod(this.f, safeKeyBoardEditText);
    }

    public SafeKeyBoardUtil getSafeKeyBoardUtil() {
        return this.h;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.mPopupWindow;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isPopupWindowShowing() {
        /*
            r1 = this;
            com.dxmpay.wallet.base.widget.SafeKeyBoardUtil r0 = r1.h
            if (r0 == 0) goto L_0x0010
            com.dxmpay.wallet.base.widget.SafeKeyBoardPopupWindow r0 = r0.mPopupWindow
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isShowing()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.wallet.base.widget.SafeScrollView.isPopupWindowShowing():boolean");
    }

    public boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int height = view.getHeight() + i3;
        int width = view.getWidth() + i2;
        if (motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i3) || motionEvent.getY() >= ((float) height)) {
            return true;
        }
        return false;
    }

    public void notifyShowKeyBoard(int i2) {
        if (this.f4197i != null) {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.h.mPopupWindow;
            if (safeKeyBoardPopupWindow != null) {
                safeKeyBoardPopupWindow.getHeight();
            }
            this.f4197i.onKeyBoardStatusChange(true, i2);
        }
    }

    public void onDetachedFromWindow() {
        clear();
        a();
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!this.l) {
            this.l = true;
            this.j = i5;
            this.k = i5;
            return;
        }
        int i6 = this.k;
        if (i6 != i5) {
            int i7 = this.j;
            if (i5 >= i7 || i6 >= i7) {
                this.k = i5;
            }
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "hide_keyboard_listener".equals(event.mEventKey)) {
            this.h.hideSoftKeyBoard();
        }
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        ScrollChangedListener scrollChangedListener = this.b;
        if (scrollChangedListener != null) {
            scrollChangedListener.onScrollChanged(i2, i3, i4, i5);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (z || this.c) {
            this.e = 0;
            a((View) this);
            if (this.e == 1 && (safeKeyBoardEditText = this.g) != null && safeKeyBoardEditText.isFocused() && this.g.getUseSafeKeyBoard()) {
                new Handler().postDelayed(new qw(), 100);
                return;
            }
            return;
        }
        this.h.hideSoftKeyBoard();
    }

    public void setAlwaysShowSoftKeyBoard(boolean z) {
        this.c = z;
        this.d.register((Object) this, "hide_keyboard_listener", 0, EventBus.ThreadMode.MainThread);
    }

    public void setKeyBoardStatusChangeListener(onKeyBoardStatusChangeListener onkeyboardstatuschangelistener) {
        this.f4197i = onkeyboardstatuschangelistener;
    }

    public void setSafeKeyBoardUtil(SafeKeyBoardUtil safeKeyBoardUtil) {
        this.h = safeKeyBoardUtil;
    }

    public void setScrollChangeListener(ScrollChangedListener scrollChangedListener) {
        this.b = scrollChangedListener;
    }

    public void showKeyBoard(ViewGroup viewGroup, SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        if (!safeKeyBoardEditText.getUseSafeKeyBoard() || view == null) {
            GlobalUtils.showInputMethod(this.f, safeKeyBoardEditText);
            return;
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.h.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            this.h.init(this.f, viewGroup, this);
        }
        this.h.showSoftKeyBoard(safeKeyBoardEditText, view);
    }

    private void a(View view) {
        if (view instanceof ViewGroup) {
            int i2 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 < viewGroup.getChildCount()) {
                    a(viewGroup.getChildAt(i2));
                    i2++;
                } else {
                    return;
                }
            }
        } else if ((view instanceof EditText) && view.hasWindowFocus() && view.getVisibility() == 0 && view.isShown() && view.isEnabled()) {
            int i3 = this.e + 1;
            this.e = i3;
            if (i3 == 1 && (view instanceof SafeKeyBoardEditText)) {
                this.g = (SafeKeyBoardEditText) view;
            }
        }
    }

    public void dismissKeyBoard() {
        this.h.hideSoftKeyBoard();
    }

    private void a() {
        this.b = null;
    }

    public SafeScrollView(Context context) {
        this(context, (AttributeSet) null);
        this.f = context;
        setSafeFlag(false);
    }
}
