package com.baidu.searchbox.mall.utils;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;
import com.baidu.searchbox.mall.debug.DebugsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/mall/utils/KeyboardUtils;", "", "()V", "hideKeyboard", "", "context", "Landroid/content/Context;", "windowToken", "Landroid/os/IBinder;", "showKeyboard", "view", "Landroid/view/View;", "lib-search-mall_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: KeyboardUtils.kt */
public final class KeyboardUtils {
    public static final KeyboardUtils INSTANCE = new KeyboardUtils();

    private KeyboardUtils() {
    }

    public final void hideKeyboard(Context context, IBinder windowToken) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Object systemService = context.getSystemService(InputMethodController.BUTTON_INPUT_METHOD);
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            }
        } catch (Throwable e2) {
            if (DebugsKt.getDEBUG()) {
                Log.d("KeyboardUtils", "--->>>hideKeyboard failed:" + e2.getMessage());
            }
        }
    }

    public final void showKeyboard(Context context, View view2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view2, "view");
        try {
            Object systemService = context.getSystemService(InputMethodController.BUTTON_INPUT_METHOD);
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view2, 0);
            }
        } catch (Throwable e2) {
            if (DebugsKt.getDEBUG()) {
                Log.d("KeyboardUtils", "--->>>showKeyboard failed:" + e2.getMessage());
            }
        }
    }
}
