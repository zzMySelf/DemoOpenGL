package com.tera.scan.component.base.ui.widget.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.i.qw;

public class FixedRatioImageView extends AppCompatImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.5f;
    public static final String TAG = "FixedRatioImageView";
    public float mRatio;

    public FixedRatioImageView(Context context) {
        super(context);
        this.mRatio = 0.5f;
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec((int) (((float) ((View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight())) * this.mRatio), View.MeasureSpec.getMode(i3)));
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public FixedRatioImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixedRatioImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mRatio = 0.5f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FixedRatioImageView, i2, 0);
        this.mRatio = obtainStyledAttributes.getFloat(0, -1.0f);
        qw.ad("FixedRatioImageView", "mRatio:" + this.mRatio);
        if (this.mRatio < 0.0f) {
            this.mRatio = 0.5f;
        }
        obtainStyledAttributes.recycle();
    }
}
