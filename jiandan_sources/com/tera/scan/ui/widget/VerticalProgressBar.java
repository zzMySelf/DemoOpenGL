package com.tera.scan.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewParent;
import android.widget.RemoteViews;
import com.tera.scan.app.R$styleable;

@RemoteViews.RemoteView
public class VerticalProgressBar extends View {
    public static final int MAX_LEVEL = 10000;
    public boolean mInDrawing;
    public int mMax;
    public int mMaxHeight;
    public int mMaxWidth;
    public int mMinHeight;
    public int mMinWidth;
    public boolean mNoInvalidate;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public ViewParent mParent;
    public int mProgress;
    public Drawable mProgressDrawable;
    public ad mRefreshProgressRunnable;
    public Bitmap mSampleTile;
    public int mScrollX;
    public int mScrollY;
    public int mSecondaryProgress;
    public long mUiThreadId;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new qw();
        public int progress;
        public int secondaryProgress;

        public class qw implements Parcelable.Creator<SavedState> {
            /* renamed from: ad */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* renamed from: qw */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.progress);
            parcel.writeInt(this.secondaryProgress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.progress = parcel.readInt();
            this.secondaryProgress = parcel.readInt();
        }
    }

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public int f7408ad;

        /* renamed from: th  reason: collision with root package name */
        public int f7409th;

        /* renamed from: yj  reason: collision with root package name */
        public boolean f7411yj;

        public ad(int i2, int i3, boolean z) {
            this.f7408ad = i2;
            this.f7409th = i3;
            this.f7411yj = z;
        }

        public void qw(int i2, int i3, boolean z) {
            this.f7408ad = i2;
            this.f7409th = i3;
            this.f7411yj = z;
        }

        public void run() {
            VerticalProgressBar.this.doRefreshProgress(this.f7408ad, this.f7409th, this.f7411yj);
            synchronized (VerticalProgressBar.this) {
                ad unused = VerticalProgressBar.this.mRefreshProgressRunnable = this;
            }
        }
    }

    public VerticalProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public synchronized void doRefreshProgress(int i2, int i3, boolean z) {
        float f = this.mMax > 0 ? ((float) i3) / ((float) this.mMax) : 0.0f;
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            Drawable drawable2 = null;
            if (drawable instanceof LayerDrawable) {
                drawable2 = ((LayerDrawable) drawable).findDrawableByLayerId(i2);
            }
            int i4 = (int) (10000.0f * f);
            if (drawable2 != null) {
                drawable = drawable2;
            }
            drawable.setLevel(i4);
        } else {
            invalidate();
        }
        if (i2 == 16908301) {
            onProgressRefresh(f, z);
        }
    }

    private synchronized void initProgressBar() {
        this.mMax = 100;
        this.mProgress = 0;
        this.mSecondaryProgress = 0;
        this.mMinWidth = 24;
        this.mMaxWidth = 48;
        this.mMinHeight = 24;
        this.mMaxHeight = 48;
    }

    private synchronized void refreshProgress(int i2, int i3, boolean z) {
        ad adVar;
        if (this.mUiThreadId == Thread.currentThread().getId()) {
            doRefreshProgress(i2, i3, z);
        } else {
            if (this.mRefreshProgressRunnable != null) {
                adVar = this.mRefreshProgressRunnable;
                this.mRefreshProgressRunnable = null;
                adVar.qw(i2, i3, z);
            } else {
                adVar = new ad(i2, i3, z);
            }
            post(adVar);
        }
    }

    private Drawable tileify(Drawable drawable, boolean z) {
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                drawableArr[i2] = tileify(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                layerDrawable2.setId(i3, layerDrawable.getId(i3));
            }
            return layerDrawable2;
        } else if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            return new StateListDrawable();
        } else if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        } else {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (this.mSampleTile == null) {
                this.mSampleTile = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null && drawable.isStateful()) {
            this.mProgressDrawable.setState(drawableState);
        }
    }

    public Drawable getCurrentDrawable() {
        return this.mProgressDrawable;
    }

    public Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, (RectF) null, (float[]) null);
    }

    @ViewDebug.ExportedProperty
    public synchronized int getMax() {
        return this.mMax;
    }

    @ViewDebug.ExportedProperty
    public synchronized int getProgress() {
        return this.mProgress;
    }

    public Drawable getProgressDrawable() {
        return this.mProgressDrawable;
    }

    @ViewDebug.ExportedProperty
    public synchronized int getSecondaryProgress() {
        return this.mSecondaryProgress;
    }

    public final synchronized void incrementProgressBy(int i2) {
        setProgress(this.mProgress + i2);
    }

    public final synchronized void incrementSecondaryProgressBy(int i2) {
        setSecondaryProgress(this.mSecondaryProgress + i2);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mInDrawing) {
            return;
        }
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int i2 = this.mScrollX + this.mPaddingLeft;
            int i3 = this.mScrollY + this.mPaddingTop;
            invalidate(bounds.left + i2, bounds.top + i3, bounds.right + i2, bounds.bottom + i3);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    public synchronized void onDraw(Canvas canvas) {
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            canvas.save();
            canvas.translate((float) this.mPaddingLeft, (float) this.mPaddingTop);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        Drawable drawable = this.mProgressDrawable;
        int i5 = 0;
        if (drawable != null) {
            i5 = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, drawable.getIntrinsicWidth()));
            i4 = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, drawable.getIntrinsicHeight()));
        } else {
            i4 = 0;
        }
        setMeasuredDimension(View.resolveSize(i5 + this.mPaddingLeft + this.mPaddingRight, i2), View.resolveSize(i4 + this.mPaddingTop + this.mPaddingBottom, i3));
    }

    public void onProgressRefresh(float f, boolean z) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setProgress(savedState.progress);
        setSecondaryProgress(savedState.secondaryProgress);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        synchronized (this) {
            savedState.progress = this.mProgress;
            savedState.secondaryProgress = this.mSecondaryProgress;
        }
        return savedState;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int i6 = (i2 - this.mPaddingRight) - this.mPaddingLeft;
        int i7 = (i3 - this.mPaddingBottom) - this.mPaddingTop;
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, i6, i7);
        }
    }

    public void postInvalidate() {
        if (!this.mNoInvalidate) {
            super.postInvalidate();
        }
    }

    public synchronized void setMax(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 != this.mMax) {
            this.mMax = i2;
            postInvalidate();
            if (this.mProgress > i2) {
                this.mProgress = i2;
                refreshProgress(16908301, i2, false);
            }
        }
    }

    public synchronized void setProgress(int i2) {
        setProgress(i2, false);
    }

    public void setProgressDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            int minimumWidth = drawable.getMinimumWidth();
            if (this.mMaxWidth < minimumWidth) {
                this.mMaxWidth = minimumWidth;
                requestLayout();
            }
        }
        this.mProgressDrawable = drawable;
        postInvalidate();
    }

    public synchronized void setSecondaryProgress(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.mMax) {
            i2 = this.mMax;
        }
        if (i2 != this.mSecondaryProgress) {
            this.mSecondaryProgress = i2;
            refreshProgress(16908303, i2, false);
        }
    }

    public void setVisibility(int i2) {
        if (getVisibility() != i2) {
            super.setVisibility(i2);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return drawable == this.mProgressDrawable || super.verifyDrawable(drawable);
    }

    public VerticalProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842871);
    }

    public VerticalProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mUiThreadId = Thread.currentThread().getId();
        initProgressBar();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ProgressBar, i2, 0);
        this.mNoInvalidate = true;
        Drawable drawable = obtainStyledAttributes.getDrawable(5);
        if (drawable != null) {
            setProgressDrawable(tileify(drawable, false));
        }
        this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(6, this.mMinWidth);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(0, this.mMaxWidth);
        this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(7, this.mMinHeight);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(1, this.mMaxHeight);
        setMax(obtainStyledAttributes.getInt(2, this.mMax));
        setProgress(obtainStyledAttributes.getInt(3, this.mProgress));
        setSecondaryProgress(obtainStyledAttributes.getInt(4, this.mSecondaryProgress));
        this.mNoInvalidate = false;
        obtainStyledAttributes.recycle();
    }

    public synchronized void setProgress(int i2, boolean z) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > this.mMax) {
            i2 = this.mMax;
        }
        if (i2 != this.mProgress) {
            this.mProgress = i2;
            refreshProgress(16908301, i2, z);
        }
    }
}
