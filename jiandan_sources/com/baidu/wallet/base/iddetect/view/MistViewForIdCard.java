package com.baidu.wallet.base.iddetect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.baidu.wallet.base.widget.MistView;

public class MistViewForIdCard extends MistView {
    public int mBackgroundColor = MistView.MASK_COLOR_DEFAULT_TRANSPARENT;
    public int mCornerSize = 40;
    public int mRoundCornerColor = -1;
    public int mRoundCornerWidth = 4;

    public MistViewForIdCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {
        Rect focusFrame = getFocusFrame();
        if (focusFrame.width() != 0) {
            Paint paint = new Paint();
            Path path = new Path();
            paint.setColor(this.mBackgroundColor);
            path.addRect(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), Path.Direction.CW);
            path.close();
            canvas.drawPath(path, paint);
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.FILL);
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            paint2.setFlags(1);
            Path path2 = new Path();
            RectF rectF = new RectF((float) focusFrame.left, (float) focusFrame.top, (float) focusFrame.right, (float) focusFrame.bottom);
            int i2 = this.mCornerSize;
            path2.addRoundRect(rectF, (float) i2, (float) i2, Path.Direction.CW);
            path2.close();
            canvas.drawPath(path2, paint2);
            Paint paint3 = new Paint();
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth((float) this.mRoundCornerWidth);
            paint3.setColor(this.mRoundCornerColor);
            paint3.setFlags(1);
            int i3 = this.mCornerSize;
            canvas.drawRoundRect(rectF, (float) i3, (float) i3, paint3);
        }
    }

    public void setBackgroundColor(int i2) {
        this.mBackgroundColor = i2;
    }

    public void setCornerSize(int i2) {
        this.mCornerSize = i2;
    }
}
