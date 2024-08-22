package com.baidu.wallet.base.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class SafeKeyBoardUtil {
    public String a;
    public Context b;
    public SafeKeyBoardEditText c;
    public ViewGroup d;
    public SafeScrollView e;
    public View f;
    public int g;
    public int h;

    /* renamed from: i  reason: collision with root package name */
    public int f1155i;
    public int j;
    public SafeKeyBoardState k;
    public SafeKeyBoardPopupWindow mPopupWindow;

    public enum SafeKeyBoardState {
        NORMAL_STATE,
        CONFRIM_STATE
    }

    public void hideSoftInputMethod(EditText editText) {
        ((InputMethodManager) this.b.getSystemService("input_method")).hideSoftInputFromWindow(this.c.getWindowToken(), 0);
        if (Build.VERSION.SDK_INT < 11) {
            editText.setInputType(0);
            return;
        }
        Class<EditText> cls = EditText.class;
        try {
            Method method = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
            method.setAccessible(true);
            method.invoke(editText, new Object[]{Boolean.FALSE});
        } catch (NoSuchMethodException e2) {
            LogUtil.d(e2.getMessage());
            Class<EditText> cls2 = EditText.class;
            try {
                Method method2 = cls2.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                method2.setAccessible(true);
                method2.invoke(editText, new Object[]{Boolean.FALSE});
            } catch (NoSuchMethodException e3) {
                LogUtil.d(e3.getMessage());
                editText.setInputType(0);
            } catch (Exception e4) {
                LogUtil.d(e4.getMessage());
                editText.setInputType(0);
            }
        } catch (IllegalAccessException e5) {
            LogUtil.d(e5.getMessage());
        } catch (IllegalArgumentException e6) {
            LogUtil.d(e6.getMessage());
        } catch (InvocationTargetException e7) {
            LogUtil.d(e7.getMessage());
        } catch (Exception e8) {
            LogUtil.d(e8.getMessage());
        }
    }

    public void hideSoftKeyBoard() {
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow != null && safeKeyBoardPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
            b();
        }
    }

    public void init(Context context, ViewGroup viewGroup, SafeScrollView safeScrollView) {
        this.b = context;
        this.d = viewGroup;
        this.e = safeScrollView;
        if (this.mPopupWindow == null) {
            if (this.k == SafeKeyBoardState.CONFRIM_STATE) {
                this.mPopupWindow = new SafeKeyBoardPopUpWindowNew(context);
            } else {
                this.mPopupWindow = new SafeKeyBoardPopupWindow(context);
            }
        }
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing()) {
            SafeScrollView safeScrollView2 = this.e;
            if (safeScrollView2 != null) {
                this.h = safeScrollView2.getLayoutParams().height;
            } else {
                LogUtil.errord("gaolou", "SafeKeyBoardUtil.init ++ mScrollView == null");
            }
        }
    }

    public void setState(SafeKeyBoardState safeKeyBoardState) {
        this.k = safeKeyBoardState;
    }

    public void showSoftKeyBoard(SafeKeyBoardEditText safeKeyBoardEditText, View view) {
        this.c = safeKeyBoardEditText;
        this.f = view;
        SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = this.mPopupWindow;
        if (safeKeyBoardPopupWindow == null || safeKeyBoardEditText == null || view == null || this.e == null || this.d == null) {
            LogUtil.errord("gaolou", "SafeKeyBoardUtil.showSoftKeyBoard ++ View == null");
            return;
        }
        safeKeyBoardPopupWindow.setSafeEditTet(safeKeyBoardEditText);
        this.mPopupWindow.setScrollView(this.e);
        hideSoftInputMethod(this.c);
        if (this.e.hasWindowFocus() && this.c.isEnabled()) {
            if (this.mPopupWindow != null && this.e.hasWindowFocus()) {
                this.mPopupWindow.initKeyNum(safeKeyBoardEditText.getUseRandKey());
                try {
                    this.mPopupWindow.showAtLocation(this.d, 80, 0, 0);
                    if (Build.VERSION.SDK_INT <= 23) {
                        this.mPopupWindow.update();
                    }
                } catch (Exception unused) {
                    this.mPopupWindow = null;
                    return;
                }
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = SafeKeyBoardUtil.this.mPopupWindow;
                    if (safeKeyBoardPopupWindow == null || !safeKeyBoardPopupWindow.isShowing() || !SafeKeyBoardUtil.this.e.hasWindowFocus()) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = SafeKeyBoardUtil.this.mPopupWindow;
                                if (safeKeyBoardPopupWindow != null && safeKeyBoardPopupWindow.isShowing() && SafeKeyBoardUtil.this.e.hasWindowFocus()) {
                                    SafeKeyBoardUtil.this.a();
                                }
                            }
                        }, 150);
                    } else {
                        SafeKeyBoardUtil.this.a();
                    }
                }
            }, 150);
        }
    }

    private void b() {
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.height = this.h;
        this.e.setLayoutParams(layoutParams);
    }

    private View a(View view) {
        while (view instanceof View) {
            if (16908290 == view.getId()) {
                return view;
            }
            view = (View) view.getParent();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.mPopupWindow != null && this.e != null && this.f != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.b.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.g = displayMetrics.heightPixels;
            this.j = this.mPopupWindow.getPopupWindowHeight();
            int[] iArr = new int[2];
            this.e.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            final int i3 = 0;
            View a2 = a((View) this.e);
            if (a2 != null) {
                i3 = this.g - a2.getHeight();
            }
            int i4 = ((this.g - this.j) - i2) - i3;
            if (i4 > 0) {
                ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
                layoutParams.height = i4;
                this.e.setLayoutParams(layoutParams);
                this.e.post(new Runnable() {
                    public void run() {
                        int[] iArr = new int[2];
                        SafeKeyBoardUtil.this.f.getLocationOnScreen(iArr);
                        SafeKeyBoardUtil safeKeyBoardUtil = SafeKeyBoardUtil.this;
                        int unused = safeKeyBoardUtil.f1155i = ((iArr[1] + safeKeyBoardUtil.f.getHeight()) - (SafeKeyBoardUtil.this.g - SafeKeyBoardUtil.this.j)) + SafeKeyBoardUtil.this.c.getGap() + i3;
                        if (SafeKeyBoardUtil.this.f1155i > 0) {
                            SafeKeyBoardUtil.this.e.smoothScrollBy(0, SafeKeyBoardUtil.this.f1155i);
                        }
                        SafeKeyBoardUtil.this.e.notifyShowKeyBoard(SafeKeyBoardUtil.this.j);
                    }
                });
            }
        }
    }
}
