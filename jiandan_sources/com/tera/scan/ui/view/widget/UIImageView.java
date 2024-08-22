package com.tera.scan.ui.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.f.ad.fe.qw;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\u0010J\u0006\u0010!\u001a\u00020\u0010J\u0006\u0010\"\u001a\u00020\u0010J\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0010J\"\u0010&\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rJ\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\u001dH\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\nJ\u000e\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\nJ\u000e\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0010J&\u00102\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010J\u000e\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u0010J\u000e\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u0010J\u000e\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u0010J\u000e\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u0010J\u0012\u0010@\u001a\u00020\u001d2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0012\u0010C\u001a\u00020\u001d2\b\u0010D\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010E\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\nH\u0016J\u0010\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u001bH\u0016J\u001c\u0010I\u001a\u00020\u001d2\b\u0010D\u001a\u0004\u0018\u00010\u00172\b\u0010H\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010J\u001a\u00020\u001dH\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/tera/scan/ui/view/widget/UIImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "attr", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mAutoState", "", "mBorderColor", "mBorderWidth", "", "mCorner", "mCornerBottomLeft", "mCornerBottomRight", "mCornerTopLeft", "mCornerTopRight", "mDrawable", "Landroid/graphics/drawable/Drawable;", "mIsCircle", "mResource", "mScaleType", "Landroid/widget/ImageView$ScaleType;", "drawEmptyBitmap", "", "drawableStateChanged", "getBorderColor", "getBorderWidth", "getCorner", "getCornerBottomLeft", "getCornerBottomRight", "getCornerTopLeft", "getCornerTopRight", "init", "isCircle", "onDraw", "canvas", "Landroid/graphics/Canvas;", "refreshDrawableState", "refreshState", "resolveResource", "setBorderColor", "borderColor", "setBorderWidth", "borderWidth", "setCorner", "corner", "topLeft", "topRight", "bottomRight", "bottomLeft", "setCornerBottomLeft", "cornerBottomLeft", "setCornerBottomRight", "cornerBottomRight", "setCornerTopLeft", "cornerTopLeft", "setCornerTopRight", "cornerTopRight", "setImageBitmap", "bm", "Landroid/graphics/Bitmap;", "setImageDrawable", "drawable", "setImageResource", "resId", "setScaleType", "scaleType", "updateAttrs", "updateDrawableAttrs", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class UIImageView extends AppCompatImageView {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public boolean mAutoState;
    public int mBorderColor;
    public float mBorderWidth;
    public float mCorner;
    public float mCornerBottomLeft;
    public float mCornerBottomRight;
    public float mCornerTopLeft;
    public float mCornerTopRight;
    @Nullable
    public Drawable mDrawable;
    public boolean mIsCircle;
    public int mResource;
    @Nullable
    public ImageView.ScaleType mScaleType;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UIImageView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void drawEmptyBitmap() {
        if (this.mDrawable == null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                Drawable background = getBackground();
                if (background != null) {
                    background.setBounds(0, 0, measuredWidth, measuredHeight);
                    setImageDrawable(background);
                    return;
                }
                setImageBitmap(Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ALPHA_8));
            }
        }
    }

    private final void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UIImageView, i2, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…ageView, defStyleAttr, 0)");
        this.mIsCircle = obtainStyledAttributes.getBoolean(8, false);
        this.mAutoState = obtainStyledAttributes.getBoolean(0, false);
        this.mCorner = (float) obtainStyledAttributes.getDimensionPixelSize(3, -1);
        this.mCornerTopLeft = (float) obtainStyledAttributes.getDimensionPixelSize(6, 0);
        this.mCornerTopRight = (float) obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.mCornerBottomLeft = (float) obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.mCornerBottomRight = (float) obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.mBorderWidth = (float) obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.mBorderColor = obtainStyledAttributes.getColor(1, -16777216);
        obtainStyledAttributes.recycle();
        updateDrawableAttrs();
    }

    private final void refreshState() {
        float f;
        if (this.mAutoState) {
            if (!isEnabled()) {
                f = 0.4f;
            } else {
                f = (!isPressed() || !isClickable()) ? 1.0f : 0.6f;
            }
            setAlpha(f);
        }
    }

    private final Drawable resolveResource() {
        Drawable drawable;
        if (this.mResource != 0) {
            try {
                qw qwVar = qw.qw;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                drawable = qwVar.ad(context, this.mResource);
            } catch (Exception unused) {
                this.mResource = 0;
            }
            return fe.mmm.qw.f.de.qw.qw.rrr.de(drawable);
        }
        drawable = null;
        return fe.mmm.qw.f.de.qw.qw.rrr.de(drawable);
    }

    private final void updateAttrs(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable != null) {
            if (drawable instanceof fe.mmm.qw.f.de.qw.qw) {
                ((fe.mmm.qw.f.de.qw.qw) drawable).ad(scaleType, this.mBorderWidth, this.mBorderColor, this.mIsCircle, this.mCorner, this.mCornerTopLeft, this.mCornerTopRight, this.mCornerBottomLeft, this.mCornerBottomRight);
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    updateAttrs(layerDrawable.getDrawable(i2), scaleType);
                }
            }
        }
    }

    private final void updateDrawableAttrs() {
        updateAttrs(this.mDrawable, this.mScaleType);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public final int getBorderColor() {
        return this.mBorderColor;
    }

    public final float getBorderWidth() {
        return this.mBorderWidth;
    }

    public final float getCorner() {
        return this.mCorner;
    }

    public final float getCornerBottomLeft() {
        return this.mCornerBottomLeft;
    }

    public final float getCornerBottomRight() {
        return this.mCornerBottomRight;
    }

    public final float getCornerTopLeft() {
        return this.mCornerTopLeft;
    }

    public final float getCornerTopRight() {
        return this.mCornerTopRight;
    }

    @NotNull
    public final UIImageView isCircle(boolean z) {
        this.mIsCircle = z;
        updateDrawableAttrs();
        return this;
    }

    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        drawEmptyBitmap();
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        refreshState();
    }

    public final void setBorderColor(int i2) {
        this.mBorderColor = i2;
        updateDrawableAttrs();
    }

    public final void setBorderWidth(int i2) {
        this.mBorderWidth = (float) i2;
        updateDrawableAttrs();
    }

    public final void setCorner(float f) {
        this.mCorner = f;
        updateDrawableAttrs();
    }

    public final void setCornerBottomLeft(float f) {
        this.mCorner = -1.0f;
        this.mCornerBottomLeft = f;
        updateDrawableAttrs();
    }

    public final void setCornerBottomRight(float f) {
        this.mCorner = -1.0f;
        this.mCornerBottomRight = f;
        updateDrawableAttrs();
    }

    public final void setCornerTopLeft(float f) {
        this.mCorner = -1.0f;
        this.mCornerTopLeft = f;
        updateDrawableAttrs();
    }

    public final void setCornerTopRight(float f) {
        this.mCorner = -1.0f;
        this.mCornerTopRight = f;
        updateDrawableAttrs();
    }

    public void setImageBitmap(@Nullable Bitmap bitmap) {
        this.mResource = 0;
        this.mDrawable = fe.mmm.qw.f.de.qw.qw.rrr.ad(bitmap);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        this.mResource = 0;
        this.mDrawable = fe.mmm.qw.f.de.qw.qw.rrr.de(drawable);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    public void setImageResource(int i2) {
        if (this.mResource != i2) {
            this.mResource = i2;
            this.mDrawable = resolveResource();
            updateDrawableAttrs();
            super.setImageDrawable(this.mDrawable);
        }
    }

    public void setScaleType(@NotNull ImageView.ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        super.setScaleType(scaleType);
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            updateDrawableAttrs();
            invalidate();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UIImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UIImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mCorner = -1.0f;
        this.mBorderColor = -16777216;
        init(context, attributeSet, i2);
    }

    public final void setCorner(float f, float f2, float f3, float f4) {
        this.mCorner = -1.0f;
        this.mCornerTopLeft = f;
        this.mCornerTopRight = f2;
        this.mCornerBottomRight = f3;
        this.mCornerBottomLeft = f4;
        updateDrawableAttrs();
    }
}
