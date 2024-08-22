package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class SafeKeyBoardUtil {

    /* renamed from: ad  reason: collision with root package name */
    public SafeKeyBoardEditText f4183ad;

    /* renamed from: de  reason: collision with root package name */
    public ViewGroup f4184de;

    /* renamed from: fe  reason: collision with root package name */
    public SafeScrollView f4185fe;

    /* renamed from: i  reason: collision with root package name */
    public int f4186i;
    public SafeKeyBoardPopupWindow mPopupWindow;

    /* renamed from: o  reason: collision with root package name */
    public SafeKeyBoardState f4187o;

    /* renamed from: pf  reason: collision with root package name */
    public OnPopupWindowStateChangeListener f4188pf;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public View f4189rg;

    /* renamed from: th  reason: collision with root package name */
    public int f4190th;

    /* renamed from: uk  reason: collision with root package name */
    public int f4191uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f4192yj;

    public interface OnPopupWindowStateChangeListener {
        void onPopupWindowDismiss();

        void onPopupWindowShow();
    }

    public enum SafeKeyBoardState {
        NORMAL_STATE,
        CONFRIM_STATE
    }

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f4193ad;

        public ad(int i2) {
            this.f4193ad = i2;
        }

        public void run() {
            int[] iArr = new int[2];
            SafeKeyBoardUtil.this.f4189rg.getLocationOnScreen(iArr);
            SafeKeyBoardUtil safeKeyBoardUtil = SafeKeyBoardUtil.this;
            int unused = safeKeyBoardUtil.f4191uk = ((iArr[1] + safeKeyBoardUtil.f4189rg.getHeight()) - (SafeKeyBoardUtil.this.f4190th - SafeKeyBoardUtil.this.f4186i)) + SafeKeyBoardUtil.this.f4183ad.getGap() + this.f4193ad;
            if (SafeKeyBoardUtil.this.f4191uk > 0) {
                SafeKeyBoardUtil.this.f4185fe.smoothScrollBy(0, SafeKeyBoardUtil.this.f4191uk);
            }
            SafeKeyBoardUtil.this.f4185fe.notifyShowKeyBoard(SafeKeyBoardUtil.this.f4186i);
        }
    }

    public class qw implements Runnable {

        /* renamed from: com.dxmpay.wallet.base.widget.SafeKeyBoardUtil$qw$qw  reason: collision with other inner class name */
        public class C0183qw implements Runnable {
            public C0183qw() {
            }

            public void run() {
                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = SafeKeyBoardUtil.this.mPopupWindow;
                if (safeKeyBoardPopupWindow != null && safeKeyBoardPopupWindow.isShowing() && SafeKeyBoardUtil.this.f4185fe.hasWindowFocus()) {
                    SafeKeyBoardUtil.this.fe();
                }
            }
        }

        public qw() {
        }

        public void run() {
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = SafeKeyBoardUtil.this.mPopupWindow;
            if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing() || !SafeKeyBoardUtil.this.f4185fe.hasWindowFocus()) {
                new Handler().postDelayed(new C0183qw(), 150);
            } else {
                SafeKeyBoardUtil.this.fe();
            }
        }
    }

    public final View ad(View view) {
        while (view instanceof View) {
            if (16908290 == view.getId()) {
                return view;
            }
            view = (View) view.getParent();
        }
        return null;
    }

    public final void fe() {
        if (this.mPopupWindow != null && this.f4185fe != null && this.f4189rg != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.qw.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.f4190th = displayMetrics.heightPixels;
            this.f4186i = this.mPopupWindow.getPopupWindowHeight();
            int[] iArr = new int[2];
            this.f4185fe.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            int i3 = 0;
            View ad2 = ad(this.f4185fe);
            if (ad2 != null) {
                i3 = this.f4190th - ad2.getHeight();
            }
            int i4 = ((this.f4190th - this.f4186i) - i2) - i3;
            if (i4 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f4185fe.getLayoutParams();
                layoutParams.height = i4;
                this.f4185fe.setLayoutParams(layoutParams);
                this.f4185fe.post(new ad(i3));
            }
        }
    }

    public void hideSoftInputMethod(EditText editText) {
        ((InputMethodManager) this.qw.getSystemService("input_method")).hideSoftInputFromWindow(this.f4183ad.getWindowToken(), 0);
        if (Build.VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        Class<EditText> cls = EditText.class;
        try {
            Method method = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(true);
            method.invoke(editText, new Object[]{Boolean.FALSE});
        } catch (NoSuchMethodException e) {
            e.getMessage();
            Class<EditText> cls2 = EditText.class;
            try {
                Method method2 = cls2.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(true);
                method2.invoke(editText, new Object[]{Boolean.FALSE});
            } catch (NoSuchMethodException e2) {
                e2.getMessage();
                editText.setInputType(0);
            } catch (Exception e3) {
                e3.getMessage();
                editText.setInputType(0);
            }
        } catch (IllegalAccessException e4) {
            e4.getMessage();
        } catch (IllegalArgumentException e5) {
            e5.getMessage();
        } catch (InvocationTargetException e6) {
            e6.getMessage();
        } catch (Exception e7) {
            e7.getMessage();
        }
    }

    public void hideSoftKeyBoard() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow != null && safeKeyBoardPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
            rg();
            OnPopupWindowStateChangeListener onPopupWindowStateChangeListener = this.f4188pf;
            if (onPopupWindowStateChangeListener != null) {
                onPopupWindowStateChangeListener.onPopupWindowDismiss();
            }
        }
    }

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        this.qw = context;
        this.f4184de = viewGroup;
        this.f4185fe = safeScrollView;
        if (this.mPopupWindow == null) {
            if (this.f4187o == SafeKeyBoardState.CONFRIM_STATE) {
                this.mPopupWindow = new SafeKeyBoardPopUpWindowNew(context);
            } else {
                this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
            }
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            SafeScrollView safeScrollView2 = this.f4185fe;
            if (safeScrollView2 != null) {
                this.f4192yj = safeScrollView2.getLayoutParams().height;
            } else {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
            }
        }
    }

    public final void rg() {
        ViewGroup.LayoutParams layoutParams = this.f4185fe.getLayoutParams();
        layoutParams.height = this.f4192yj;
        this.f4185fe.setLayoutParams(layoutParams);
    }

    public void setOnPopupWindowStateChangeListener(OnPopupWindowStateChangeListener onPopupWindowStateChangeListener) {
        this.f4188pf = onPopupWindowStateChangeListener;
    }

    public void setState(SafeKeyBoardState safeKeyBoardState) {
        this.f4187o = safeKeyBoardState;
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        this.f4183ad = safeKeyBoardEditText;
        this.f4189rg = view;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || safeKeyBoardEditText == null || view == null || this.f4185fe == null || this.f4184de == null) {
            LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
            return;
        }
        safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
        this.mPopupWindow.setScrollView(this.f4185fe);
        hideSoftInputMethod(this.f4183ad);
        if (this.f4185fe.hasWindowFocus() && this.f4183ad.isEnabled()) {
            if (this.mPopupWindow != null && this.f4185fe.hasWindowFocus()) {
                this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                try {
                    this.mPopupWindow.showAtLocation(this.f4184de, 80, 0, 0);
                    if (Build.VERSION.SDK_INT <= 23) {
                        this.mPopupWindow.update();
                    }
                    if (this.f4188pf != null) {
                        this.f4188pf.onPopupWindowShow();
                    }
                } catch (Exception unused) {
                    this.mPopupWindow = null;
                    return;
                }
            }
            new Handler().postDelayed(new qw(), 150);
        }
    }
}
