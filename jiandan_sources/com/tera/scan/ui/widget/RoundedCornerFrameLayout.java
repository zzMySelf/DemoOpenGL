package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tera.scan.app.R$styleable;

public class RoundedCornerFrameLayout extends FrameLayout {
    public int cornerRadius = 0;

    public RoundedCornerFrameLayout(@NonNull Context context) {
        super(context);
        init(context, (AttributeSet) null, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i2) {
        setLayerType(1, (Paint) null);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.RoundedCornerFrameLayout);
        if (obtainStyledAttributes.hasValue(0)) {
            this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(0, this.cornerRadius);
        }
        obtainStyledAttributes.recycle();
    }

    public void dispatchDraw(Canvas canvas) {
        Path path = new Path();
        RectF rectF = new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        int i2 = this.cornerRadius;
        path.addRoundRect(rectF, (float) i2, (float) i2, Path.Direction.CW);
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
    }

    public RoundedCornerFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public RoundedCornerFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet, i2);
    }
}
