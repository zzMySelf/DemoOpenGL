package com.baidu.searchbox.rewardsystem.newtimer.utils;

import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0003\u001a\u00020\u0004\u001a \u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"CLICK_INTERVAL", "", "lastClickTime", "isFastClick", "", "isTouchPointInTimeWidgetArea", "view", "Landroid/view/View;", "x", "", "y", "setTextViewBold", "", "textView", "Landroid/widget/TextView;", "lib_bdptask_operation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtilsKt {
    private static final long CLICK_INTERVAL = 500;
    private static long lastClickTime;

    public static final void setTextViewBold(TextView textView) {
        if (textView != null) {
            TextView it = textView;
            it.getPaint().setStrokeWidth(1.0f);
            it.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }

    public static final boolean isTouchPointInTimeWidgetArea(View view2, int x, int y) {
        if (view2 == null) {
            return false;
        }
        int[] location = new int[2];
        view2.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = view2.getMeasuredWidth() + left;
        if (!(top <= y && y <= view2.getMeasuredHeight() + top)) {
            return false;
        }
        if (left <= x && x <= right) {
            return true;
        }
        return false;
    }

    public static final boolean isFastClick() {
        long currentTime = System.currentTimeMillis();
        boolean isFastClick = Math.abs(currentTime - lastClickTime) < 500;
        if (!isFastClick) {
            lastClickTime = currentTime;
        }
        return isFastClick;
    }
}
