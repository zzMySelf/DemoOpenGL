package com.baidu.wallet.core.utils;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import java.util.regex.Pattern;

public class CommonUtils {
    public static boolean isContainZhCN(String str) {
        if (!TextUtils.isEmpty(str) && Pattern.compile("[一-龥]").matcher(str).find()) {
            return true;
        }
        return false;
    }

    public static void setPressedAlpha(View view) {
        if (view != null) {
            setPressedAlpha(view, 0.5f);
        }
    }

    public static void setPressedAlpha(View view, final float f) {
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0 || action == 2) {
                        view.setAlpha(f);
                        return false;
                    }
                    view.setAlpha(1.0f);
                    return false;
                }
            });
        }
    }
}
