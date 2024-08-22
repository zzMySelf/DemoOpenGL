package com.baidu.searchbox.base.widget.card;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.baidu.searchbox.base.widget.card.RoundRectDrawableWithShadow;

public class CardViewJellybeanMr1 extends CardViewGingerbread {
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper() {
            public void drawRoundRect(Canvas canvas, RectF bounds, float cornerRadius, Paint paint) {
                canvas.drawRoundRect(bounds, cornerRadius, cornerRadius, paint);
            }
        };
    }
}
