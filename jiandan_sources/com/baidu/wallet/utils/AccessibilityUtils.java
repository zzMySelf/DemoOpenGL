package com.baidu.wallet.utils;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;

public class AccessibilityUtils {
    public static void requestAccessibilityFocuse(final View view) {
        view.postDelayed(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 14) {
                    view.sendAccessibilityEvent(128);
                }
            }
        }, 100);
    }

    public static void setAccessibilityFocusable(View view, boolean z) {
        if (Build.VERSION.SDK_INT < 16) {
            return;
        }
        if (z) {
            ViewCompat.setImportantForAccessibility(view, 1);
        } else {
            ViewCompat.setImportantForAccessibility(view, 2);
        }
    }

    public static void setContentDescription(View view, CharSequence charSequence) {
        if (view != null) {
            view.setContentDescription(charSequence);
        }
    }
}
