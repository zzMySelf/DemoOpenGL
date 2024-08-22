package com.baidu.searchbox.feed.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.ui.BdBaseImageView;

public class FeedRoundImageView extends BdBaseImageView {
    private float[] radii;

    public FeedRoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FeedRoundImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedRoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.radii = null;
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FeedRoundImageView);
            float radius = ta.getDimension(R.styleable.FeedRoundImageView_cornerRadius, 0.0f);
            if (radius > 0.0f) {
                buildRadii(radius);
            }
            ta.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.radii != null) {
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.radii, Path.Direction.CW);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }

    public void setCornerRadius(float radius) {
        if (radius > 0.0f) {
            buildRadii(radius);
        } else {
            this.radii = null;
        }
        invalidate();
    }

    private void buildRadii(float radius) {
        this.radii = new float[8];
        int i2 = 0;
        while (true) {
            float[] fArr = this.radii;
            if (i2 < fArr.length) {
                fArr[i2] = radius;
                i2++;
            } else {
                return;
            }
        }
    }
}
