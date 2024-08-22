package com.dxmpay.apollon.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;

@SuppressLint({"InlinedApi", "NewApi"})
public final class GlobalUtils {

    /* renamed from: ad  reason: collision with root package name */
    public static WeakReference<Toast> f4079ad = null;
    public static LayoutInflater qw = null;
    public static String showStr = "";

    public static class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f4080ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ View f4081th;

        public qw(Context context, View view) {
            this.f4080ad = context;
            this.f4081th = view;
        }

        public void run() {
            ((InputMethodManager) this.f4080ad.getSystemService("input_method")).showSoftInput(this.f4081th, 0);
        }
    }

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

    public static boolean showInputMethod(Context context, View view) {
        if (context == null || view == null) {
            return false;
        }
        view.requestFocusFromTouch();
        view.postDelayed(new qw(context, view), 100);
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
        Context applicationContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(charSequence)) {
            WeakReference<Toast> weakReference = f4079ad;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((Toast) f4079ad.get()).cancel();
            }
            if (qw == null) {
                qw = LayoutInflater.from(applicationContext);
            }
            View inflate = qw.inflate(ResUtils.layout(applicationContext, "dxm_wallet_base_toast"), (ViewGroup) null);
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
                f4079ad = new WeakReference<>(toast);
                toast.show();
            }
        }
    }
}
