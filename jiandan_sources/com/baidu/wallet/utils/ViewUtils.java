package com.baidu.wallet.utils;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

public class ViewUtils {
    public static void goneView(View... viewArr) {
        for (View view : viewArr) {
            if (!(view == null || view.getVisibility() == 8)) {
                view.setVisibility(8);
            }
        }
    }

    public static void inVisibleView(View... viewArr) {
        for (View view : viewArr) {
            if (!(view == null || view.getVisibility() == 4)) {
                view.setVisibility(4);
            }
        }
    }

    public static int parseColor(String str, int i2) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return i2;
        }
    }

    public static void setText(TextView textView, CharSequence charSequence) {
        if (textView != null && charSequence != null) {
            textView.setText(charSequence);
        }
    }

    public static void setTextColor(int i2, TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null) {
                textView.setTextColor(textView.getContext().getResources().getColor(i2));
            }
        }
    }

    public static void setVisibility(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public static void visibleView(View... viewArr) {
        for (View view : viewArr) {
            if (!(view == null || view.getVisibility() == 0)) {
                view.setVisibility(0);
            }
        }
    }
}
