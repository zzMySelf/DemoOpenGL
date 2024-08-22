package com.baidu.searchbox.fileviewer.pop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;

public class BdViewUtils {
    public static final int DEFAULT_STATUS_BAR_HEIGHT = 24;

    private static boolean isLandscape(Context aContext) {
        return aContext.getResources().getConfiguration().orientation == 2;
    }

    public static int getScreenHeight(Context aContext) {
        DisplayMetrics dm = aContext.getResources().getDisplayMetrics();
        if (isLandscape(aContext)) {
            return Math.min(dm.widthPixels, dm.heightPixels);
        }
        return Math.max(dm.widthPixels, dm.heightPixels);
    }

    public static int getScreenWidth(Context aContext) {
        DisplayMetrics dm = aContext.getResources().getDisplayMetrics();
        if (isLandscape(aContext)) {
            return Math.max(dm.widthPixels, dm.heightPixels);
        }
        return Math.min(dm.widthPixels, dm.heightPixels);
    }

    public static int getStatusbarHeight(Activity aActivity) {
        try {
            Rect frame = new Rect();
            aActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
            return frame.top;
        } catch (Exception e2) {
            return (int) (aActivity.getResources().getDisplayMetrics().density * 24.0f);
        }
    }

    public static float calcYWhenTextAlignCenter(int aCanvasHeight, Paint aPaint) {
        if (aPaint == null) {
            return 0.0f;
        }
        return ((((float) aCanvasHeight) - (aPaint.getFontMetrics().bottom - aPaint.getFontMetrics().top)) / 2.0f) - aPaint.getFontMetrics().top;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static boolean showInputMethod(Context context, View view2) {
        InputMethodManager imm;
        if (view2 == null || (imm = (InputMethodManager) context.getSystemService(InputMethodController.BUTTON_INPUT_METHOD)) == null) {
            return false;
        }
        return imm.showSoftInput(view2, 0);
    }
}
