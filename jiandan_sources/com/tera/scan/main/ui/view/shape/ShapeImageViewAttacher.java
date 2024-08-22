package com.tera.scan.main.ui.view.shape;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.dlife.ctaccountapi.v;
import com.tera.scan.main.ui.view.shape.ShapeImageView;
import fe.mmm.qw.xxx.p032if.th.de.qw;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002JP\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0014H\u0016J\b\u0010$\u001a\u00020\u0019H\u0002J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\fJ\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0006H\u0002J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u000fJ\u0006\u0010+\u001a\u00020\u0019J\u0012\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006/"}, d2 = {"Lcom/tera/scan/main/ui/view/shape/ShapeImageViewAttacher;", "Landroid/view/View$OnLayoutChangeListener;", "mImageView", "Lcom/tera/scan/main/ui/view/shape/ShapeImageView;", "(Lcom/tera/scan/main/ui/view/shape/ShapeImageView;)V", "drawMatrix", "Landroid/graphics/Matrix;", "getDrawMatrix", "()Landroid/graphics/Matrix;", "imageMatrix", "getImageMatrix", "mAutoCropHeightWidthRatio", "", "mBaseMatrix", "<set-?>", "Lcom/tera/scan/main/ui/view/shape/ShapeImageView$ShapeScaleType;", "shapeScaleType", "getShapeScaleType", "()Lcom/tera/scan/main/ui/view/shape/ShapeImageView$ShapeScaleType;", "getImageViewHeight", "", "imageView", "Landroid/widget/ImageView;", "getImageViewWidth", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "resetMatrix", "setAutoCropHeightWidthRatio", "autoCropHeightWidthRatio", "setImageViewMatrix", "matrix", "setScaleType", "scaleType", "update", "updateBaseMatrix", "drawable", "Landroid/graphics/drawable/Drawable;", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShapeImageViewAttacher implements View.OnLayoutChangeListener {
    @NotNull
    public final Matrix imageMatrix = new Matrix();
    public float mAutoCropHeightWidthRatio;
    @NotNull
    public final Matrix mBaseMatrix = new Matrix();
    @NotNull
    public final ShapeImageView mImageView;
    @Nullable
    public ShapeImageView.ShapeScaleType shapeScaleType;

    public ShapeImageViewAttacher(@NotNull ShapeImageView shapeImageView) {
        Intrinsics.checkNotNullParameter(shapeImageView, "mImageView");
        this.mImageView = shapeImageView;
        this.mImageView.addOnLayoutChangeListener(this);
    }

    private final Matrix getDrawMatrix() {
        this.imageMatrix.set(this.mBaseMatrix);
        return this.imageMatrix;
    }

    private final int getImageViewHeight(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private final int getImageViewWidth(ImageView imageView) {
        return (imageView.getWidth() - qw.ad(imageView)) - qw.de(imageView);
    }

    private final void resetMatrix() {
        setImageViewMatrix(getDrawMatrix());
    }

    private final void setImageViewMatrix(Matrix matrix) {
        this.mImageView.setImageMatrix(matrix);
    }

    private final void updateBaseMatrix(Drawable drawable) {
        if (drawable != null) {
            float imageViewWidth = (float) getImageViewWidth(this.mImageView);
            float imageViewHeight = (float) getImageViewHeight(this.mImageView);
            float intrinsicWidth = (float) drawable.getIntrinsicWidth();
            float f = imageViewWidth / intrinsicWidth;
            float intrinsicHeight = (float) drawable.getIntrinsicHeight();
            float f2 = imageViewHeight / intrinsicHeight;
            ShapeImageView.ShapeScaleType shapeScaleType2 = this.shapeScaleType;
            if (shapeScaleType2 == ShapeImageView.ShapeScaleType.START_CROP) {
                this.mBaseMatrix.reset();
                float max = Math.max(f, f2);
                this.mBaseMatrix.postScale(max, max);
                this.mBaseMatrix.postTranslate(0.0f, 0.0f);
                resetMatrix();
            } else if (shapeScaleType2 == ShapeImageView.ShapeScaleType.END_CROP) {
                this.mBaseMatrix.reset();
                float max2 = Math.max(f, f2);
                this.mBaseMatrix.postScale(max2, max2);
                this.mBaseMatrix.postTranslate(imageViewWidth - (intrinsicWidth * max2), imageViewHeight - (intrinsicHeight * max2));
                resetMatrix();
            } else if (shapeScaleType2 == ShapeImageView.ShapeScaleType.AUTO_START_CENTER_CROP) {
                float f3 = ((1.0f * intrinsicHeight) / intrinsicWidth) / (imageViewHeight / imageViewWidth);
                this.mBaseMatrix.reset();
                float max3 = Math.max(f, f2);
                this.mBaseMatrix.postScale(max3, max3);
                if (f3 >= this.mAutoCropHeightWidthRatio) {
                    this.mBaseMatrix.postTranslate(0.0f, 0.0f);
                } else {
                    float f4 = imageViewWidth - (intrinsicWidth * max3);
                    float f5 = (float) 2;
                    this.mBaseMatrix.postTranslate(f4 / f5, (imageViewHeight - (intrinsicHeight * max3)) / f5);
                }
                resetMatrix();
            } else if (shapeScaleType2 == ShapeImageView.ShapeScaleType.AUTO_END_CENTER_CROP) {
                float f6 = ((1.0f * intrinsicHeight) / intrinsicWidth) / (imageViewHeight / imageViewWidth);
                this.mBaseMatrix.reset();
                float max4 = Math.max(f, f2);
                this.mBaseMatrix.postScale(max4, max4);
                if (f6 >= this.mAutoCropHeightWidthRatio) {
                    this.mBaseMatrix.postTranslate(imageViewWidth - (intrinsicWidth * max4), imageViewHeight - (intrinsicHeight * max4));
                } else {
                    float f7 = imageViewWidth - (intrinsicWidth * max4);
                    float f8 = (float) 2;
                    this.mBaseMatrix.postTranslate(f7 / f8, (imageViewHeight - (intrinsicHeight * max4)) / f8);
                }
                resetMatrix();
            } else {
                ShapeImageView.ShapeScaleType.qw qwVar = ShapeImageView.ShapeScaleType.Companion;
                Intrinsics.checkNotNull(shapeScaleType2);
                ImageView.ScaleType qw = qwVar.qw(shapeScaleType2);
                if (qw != null) {
                    this.mImageView.setScaleType(qw);
                }
            }
        }
    }

    @NotNull
    public final Matrix getImageMatrix() {
        return this.imageMatrix;
    }

    @Nullable
    public final ShapeImageView.ShapeScaleType getShapeScaleType() {
        return this.shapeScaleType;
    }

    public void onLayoutChange(@NotNull View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Intrinsics.checkNotNullParameter(view, v.d);
        if (i2 != i6 || i3 != i7 || i4 != i8 || i5 != i9) {
            update();
        }
    }

    public final void setAutoCropHeightWidthRatio(float f) {
        this.mAutoCropHeightWidthRatio = f;
    }

    public final void setScaleType(@NotNull ShapeImageView.ShapeScaleType shapeScaleType2) {
        Intrinsics.checkNotNullParameter(shapeScaleType2, "scaleType");
        if (shapeScaleType2 != this.shapeScaleType) {
            this.shapeScaleType = shapeScaleType2;
            update();
        }
    }

    public final void update() {
        updateBaseMatrix(this.mImageView.getDrawable());
    }
}
