package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;

@SuppressLint({"InlinedApi", "NewApi"})
public final class GlobalUtils {
    public static final int IMG_ABOVE = 2;
    public static final int IMG_BELOW = 4;
    public static final int IMG_LEFT = 1;
    public static final int IMG_RIGHT = 3;
    public static LayoutInflater a = null;
    public static WeakReference<Toast> b = null;
    public static String showStr = "";

    public static String getProperties(String str, String str2) {
        Class<String> cls = String.class;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, str2});
        } catch (Exception unused) {
            return str2;
        }
    }

    public static boolean hideInputMethod(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return false;
        }
        return inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideKeyboard(Activity activity) {
        View currentFocus;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null && (currentFocus = activity.getCurrentFocus()) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static boolean showInputMethod(final Context context, final View view) {
        if (context == null || view == null) {
            return false;
        }
        view.requestFocusFromTouch();
        view.postDelayed(new Runnable() {
            public void run() {
                ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 0);
            }
        }, 100);
        return true;
    }

    public static void toast(Context context, CharSequence charSequence) {
        toast(context, charSequence, 0);
    }

    public static void toast(Context context, CharSequence charSequence, int i2) {
        try {
            toast(context, charSequence, -1, i2);
        } catch (Exception unused) {
            LogUtil.errord("Exception in Toast!");
        }
    }

    public static void toast(Context context, CharSequence charSequence, int i2, int i3) {
        TextView textView;
        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(context);
        if (!TextUtils.isEmpty(charSequence)) {
            WeakReference<Toast> weakReference = b;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((Toast) b.get()).cancel();
            }
            if (a == null) {
                a = LayoutInflater.from(applicationContext);
            }
            View inflate = a.inflate(ResUtils.layout(applicationContext, "wallet_base_toast"), (ViewGroup) null);
            if (inflate != null && (textView = (TextView) inflate.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_message"))) != null) {
                textView.setText(charSequence);
                ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_icon"));
                if (imageView != null && i2 > 0) {
                    imageView.setImageResource(i2);
                    imageView.setVisibility(0);
                }
                Toast toast = new Toast(applicationContext);
                toast.setDuration(i3);
                toast.setGravity(17, 0, 0);
                toast.setView(inflate);
                b = new WeakReference<>(toast);
                toast.show();
            }
        }
    }

    public static void toast(Context context, CharSequence charSequence, int i2, int i3, int i4) {
        toast(context, charSequence, i2, i3, i4, 0);
    }

    public static void toast(Context context, CharSequence charSequence, int i2, int i3, int i4, int i5) {
        TextView textView;
        Context applicationContext = DxmApplicationContextImpl.getApplicationContext(context);
        if (!TextUtils.isEmpty(charSequence)) {
            WeakReference<Toast> weakReference = b;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((Toast) b.get()).cancel();
            }
            if (a == null) {
                a = LayoutInflater.from(applicationContext);
            }
            View inflate = a.inflate(ResUtils.layout(applicationContext, "wallet_base_orientation_toast"), (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(ResUtils.id(applicationContext, "wallet_toast_container"));
            if (linearLayout != null && (textView = (TextView) linearLayout.findViewById(ResUtils.id(applicationContext, "wallet_base_toast_message"))) != null) {
                textView.setText(charSequence);
                ImageView imageView = new ImageView(applicationContext);
                if (i2 > 0) {
                    imageView.setImageResource(i2);
                    imageView.setVisibility(0);
                    if (i5 < 0) {
                        i5 = 0;
                    }
                    if (i4 == 2) {
                        linearLayout.setOrientation(1);
                        linearLayout.addView(imageView, 0);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                        if (marginLayoutParams != null) {
                            marginLayoutParams.bottomMargin = DisplayUtils.dip2px(applicationContext, (float) i5);
                            imageView.setLayoutParams(marginLayoutParams);
                        }
                    } else if (i4 == 3) {
                        linearLayout.setOrientation(0);
                        linearLayout.addView(imageView);
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                        if (marginLayoutParams2 != null) {
                            marginLayoutParams2.leftMargin = DisplayUtils.dip2px(applicationContext, (float) i5);
                            imageView.setLayoutParams(marginLayoutParams2);
                        }
                    } else if (i4 == 4) {
                        linearLayout.setOrientation(1);
                        linearLayout.addView(imageView);
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                        if (marginLayoutParams3 != null) {
                            marginLayoutParams3.topMargin = DisplayUtils.dip2px(applicationContext, (float) i5);
                            imageView.setLayoutParams(marginLayoutParams3);
                        }
                    } else {
                        linearLayout.setOrientation(0);
                        linearLayout.addView(imageView, 0);
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                        if (marginLayoutParams4 != null) {
                            marginLayoutParams4.rightMargin = DisplayUtils.dip2px(applicationContext, (float) i5);
                            imageView.setLayoutParams(marginLayoutParams4);
                        }
                    }
                    Toast toast = new Toast(applicationContext);
                    toast.setDuration(i3);
                    toast.setGravity(17, 0, 0);
                    toast.setView(inflate);
                    b = new WeakReference<>(toast);
                    toast.show();
                }
            }
        }
    }
}
