package com.baidu.searchbox.userassetsaggr.container;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.skin.NightModeHelper;

public class UserAssetsAggrUtils {
    public static boolean isSpecialCharacters(String keyword) {
        if (!TextUtils.isEmpty(keyword) && keyword.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
            return false;
        }
        return true;
    }

    public static void setImageSrc(Context context, TextView view2, int resId, int txtColorId) {
        if (view2 != null && context != null) {
            view2.setTextColor(context.getResources().getColor(txtColorId));
            Drawable drawable = resId != 0 ? context.getResources().getDrawable(resId) : null;
            if (!(drawable == null || (drawable = FontSizeHelper.getScaledDrawable(0, drawable)) == null)) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            view2.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            view2.setSelected(false);
        }
    }

    public static void setImageSrc(Context context, TextView view2, int resId) {
        if (view2 != null && context != null) {
            view2.setText("");
            Drawable drawable = resId != 0 ? context.getResources().getDrawable(resId) : null;
            if (!(drawable == null || (drawable = FontSizeHelper.getScaledDrawable(0, drawable)) == null)) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            view2.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            view2.setSelected(false);
        }
    }

    public static void setImageSrc(Context context, TextView view2, int resId, ColorStateList colorStateList) {
        if (view2 != null && context != null) {
            view2.setTextColor(colorStateList);
            Drawable drawable = resId != 0 ? context.getResources().getDrawable(resId) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            view2.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            view2.setSelected(false);
        }
    }

    public static void setRightImageSrc(Context context, TextView view2, int resId, int txtColorId) {
        if (view2 != null && context != null) {
            view2.setTextColor(context.getResources().getColor(txtColorId));
            Drawable drawable = resId != 0 ? context.getResources().getDrawable(resId) : null;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            view2.setCompoundDrawables((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            view2.setSelected(false);
        }
    }

    public static boolean showInputMethod(Context context, View view2) {
        InputMethodManager imm;
        if (context == null || view2 == null || (imm = (InputMethodManager) context.getApplicationContext().getSystemService(InputMethodController.BUTTON_INPUT_METHOD)) == null) {
            return false;
        }
        return imm.showSoftInput(view2, 0);
    }

    public static boolean hideInputMethod(Context context, View view2) {
        InputMethodManager imm;
        if (context == null || view2 == null || (imm = (InputMethodManager) context.getApplicationContext().getSystemService(InputMethodController.BUTTON_INPUT_METHOD)) == null) {
            return false;
        }
        return imm.hideSoftInputFromWindow(view2.getWindowToken(), 0);
    }

    public static void setViewEnable(View view2, boolean enable) {
        float f2;
        if (view2 != null) {
            view2.setEnabled(enable);
            if (enable) {
                view2.setAlpha(1.0f);
                return;
            }
            if (NightModeHelper.getNightModeSwitcherState()) {
                f2 = 0.5f;
            } else {
                f2 = 0.2f;
            }
            view2.setAlpha(f2);
        }
    }

    public static String getHttpHostUrl(String url) {
        try {
            if (TextUtils.isEmpty(url)) {
                return "";
            }
            int seperatorCount = 0;
            String domainUrl = "";
            for (int i2 = 0; i2 < url.length(); i2++) {
                if (url.charAt(i2) == '/') {
                    seperatorCount++;
                }
                if (seperatorCount == 3) {
                    return url.substring(0, i2);
                }
            }
            return domainUrl;
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return "";
        }
    }
}
