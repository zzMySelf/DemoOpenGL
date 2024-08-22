package com.baidu.talos.core.render.views.modal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import com.facebook.infer.annotation.Assertions;

class ModalHostHelper {
    private static final Point MAX_POINT = new Point();
    private static final Point MIN_POINT = new Point();
    private static final Point SIZE_POINT = new Point();

    ModalHostHelper() {
    }

    public static Point getModalHostSize(Context context) {
        Display display = ((WindowManager) Assertions.assertNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
        Point point = MIN_POINT;
        Point point2 = MAX_POINT;
        display.getCurrentSizeRange(point, point2);
        Point point3 = SIZE_POINT;
        display.getSize(point3);
        boolean windowFullscreen = context.getTheme().obtainStyledAttributes(new int[]{16843277}).getBoolean(0, false);
        Resources resources = context.getResources();
        int statusBarId = resources.getIdentifier("status_bar_height", ResUtils.DIMEN, "android");
        int statusBarHeight = 0;
        if (windowFullscreen && statusBarId > 0) {
            statusBarHeight = (int) resources.getDimension(statusBarId);
        }
        if (point3.x < point3.y) {
            return new Point(point.x, point2.y + statusBarHeight);
        }
        return new Point(point2.x, point.y + statusBarHeight);
    }
}
