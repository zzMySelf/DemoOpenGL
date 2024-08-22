package com.otaliastudios.cameraview.overlay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.dlife.ctaccountapi.x;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.tera.scan.app.R$styleable;

@SuppressLint({"CustomViewStyleable"})
public class OverlayLayout extends FrameLayout implements Overlay {
    public static final CameraLogger LOG;
    public static final String TAG;
    @VisibleForTesting
    public Overlay.Target currentTarget = Overlay.Target.PREVIEW;

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.otaliastudios.cameraview.overlay.Overlay$Target[] r0 = com.otaliastudios.cameraview.overlay.Overlay.Target.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.otaliastudios.cameraview.overlay.Overlay$Target r1 = com.otaliastudios.cameraview.overlay.Overlay.Target.PREVIEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.otaliastudios.cameraview.overlay.Overlay$Target r1 = com.otaliastudios.cameraview.overlay.Overlay.Target.VIDEO_SNAPSHOT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.otaliastudios.cameraview.overlay.Overlay$Target r1 = com.otaliastudios.cameraview.overlay.Overlay.Target.PICTURE_SNAPSHOT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.overlay.OverlayLayout.qw.<clinit>():void");
        }
    }

    static {
        String simpleName = OverlayLayout.class.getSimpleName();
        TAG = simpleName;
        LOG = CameraLogger.qw(simpleName);
    }

    public OverlayLayout(@NonNull Context context) {
        super(context);
        setWillNotDraw(false);
    }

    @VisibleForTesting
    public boolean doDrawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        LOG.de("normal draw called.");
        if (drawsOn(Overlay.Target.PREVIEW)) {
            drawOn(Overlay.Target.PREVIEW, canvas);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.drawsOn(this.currentTarget)) {
            LOG.uk("Performing drawing for view:", view.getClass().getSimpleName(), "target:", this.currentTarget, "params:", layoutParams);
            return doDrawChild(canvas, view, j);
        }
        LOG.uk("Skipping drawing for view:", view.getClass().getSimpleName(), "target:", this.currentTarget, "params:", layoutParams);
        return false;
    }

    public void drawOn(@NonNull Overlay.Target target, @NonNull Canvas canvas) {
        synchronized (this) {
            this.currentTarget = target;
            int i2 = qw.qw[target.ordinal()];
            if (i2 == 1) {
                super.draw(canvas);
            } else if (i2 == 2 || i2 == 3) {
                canvas.save();
                float width = ((float) canvas.getWidth()) / ((float) getWidth());
                float height = ((float) canvas.getHeight()) / ((float) getHeight());
                CameraLogger cameraLogger = LOG;
                cameraLogger.uk("draw", "target:", target, "canvas:", canvas.getWidth() + x.a + canvas.getHeight(), "view:", getWidth() + x.a + getHeight(), "widthScale:", Float.valueOf(width), "heightScale:", Float.valueOf(height));
                canvas.scale(width, height);
                dispatchDraw(canvas);
                canvas.restore();
            }
        }
    }

    public boolean drawsOn(@NonNull Overlay.Target target) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).drawsOn(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOverlay(@Nullable AttributeSet attributeSet) {
        boolean z = false;
        if (attributeSet == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.CameraView_Layout);
        if (obtainStyledAttributes.hasValue(1) || obtainStyledAttributes.hasValue(0) || obtainStyledAttributes.hasValue(2)) {
            z = true;
        }
        obtainStyledAttributes.recycle();
        return z;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public boolean drawOnPictureSnapshot = false;
        public boolean drawOnPreview = false;
        public boolean drawOnVideoSnapshot = false;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        @VisibleForTesting
        public boolean drawsOn(@NonNull Overlay.Target target) {
            return (target == Overlay.Target.PREVIEW && this.drawOnPreview) || (target == Overlay.Target.VIDEO_SNAPSHOT && this.drawOnVideoSnapshot) || (target == Overlay.Target.PICTURE_SNAPSHOT && this.drawOnPictureSnapshot);
        }

        @NonNull
        public String toString() {
            return LayoutParams.class.getName() + "[drawOnPreview:" + this.drawOnPreview + ",drawOnPictureSnapshot:" + this.drawOnPictureSnapshot + ",drawOnVideoSnapshot:" + this.drawOnVideoSnapshot + "]";
        }

        public LayoutParams(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CameraView_Layout);
            try {
                this.drawOnPreview = obtainStyledAttributes.getBoolean(1, false);
                this.drawOnPictureSnapshot = obtainStyledAttributes.getBoolean(0, false);
                this.drawOnVideoSnapshot = obtainStyledAttributes.getBoolean(2, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public boolean isOverlay(@NonNull ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }
}
