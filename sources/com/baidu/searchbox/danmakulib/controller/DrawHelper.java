package com.baidu.searchbox.danmakulib.controller;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import androidx.core.internal.view.SupportMenu;

public class DrawHelper {
    public static Paint PAINT;
    public static Paint PAINT_FPS;
    public static RectF RECT = new RectF();
    private static boolean USE_DRAWCOLOR_MODE_CLEAR = true;
    private static boolean USE_DRAWCOLOR_TO_CLEAR_CANVAS = true;

    static {
        Paint paint = new Paint();
        PAINT = paint;
        paint.setColor(-1);
    }

    public static void useDrawColorToClearCanvas(boolean use, boolean useClearMode) {
        USE_DRAWCOLOR_TO_CLEAR_CANVAS = use;
        USE_DRAWCOLOR_MODE_CLEAR = useClearMode;
    }

    public static void drawFPS(Canvas canvas, String text) {
        if (PAINT_FPS == null) {
            Paint paint = new Paint();
            PAINT_FPS = paint;
            paint.setColor(SupportMenu.CATEGORY_MASK);
            PAINT_FPS.setTextSize(60.0f);
        }
        int top = canvas.getHeight() - 100;
        clearCanvas(canvas, 10.0f, (float) (top - 20), (float) ((int) (PAINT_FPS.measureText(text) + 20.0f)), (float) canvas.getHeight());
        canvas.drawText(text, 10.0f, (float) top, PAINT_FPS);
    }

    public static void clearCanvas(Canvas canvas) {
        if (!USE_DRAWCOLOR_TO_CLEAR_CANVAS) {
            RECT.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            clearCanvas(canvas, RECT);
        } else if (USE_DRAWCOLOR_MODE_CLEAR) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } else {
            canvas.drawColor(0);
        }
    }

    public static void fillTransparent(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public static void clearCanvas(Canvas canvas, float left, float top, float right, float bottom) {
        RECT.set(left, top, right, bottom);
        clearCanvas(canvas, RECT);
    }

    private static void clearCanvas(Canvas canvas, RectF rect) {
        if (rect.width() > 0.0f && rect.height() > 0.0f) {
            canvas.drawRect(rect, PAINT);
        }
    }
}
