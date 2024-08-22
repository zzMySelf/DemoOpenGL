package com.tera.scan.ui.view.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tera.scan.app.R$styleable;
import com.tera.scan.ui.view.widget.UIImageView;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 V2\u00020\u0001:\u0001VB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\n\u0010:\u001a\u0004\u0018\u000101H\u0002J\b\u0010;\u001a\u00020\u0013H\u0016J\"\u0010<\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u00010\t2\u0006\u0010>\u001a\u00020?2\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\u0010\u00106\u001a\u00020@2\u0006\u0010=\u001a\u00020\tH\u0002J\b\u0010A\u001a\u00020BH\u0016J\u0006\u0010C\u001a\u00020BJ\u0006\u0010D\u001a\u00020BJ\b\u0010E\u001a\u00020BH\u0014J\b\u0010F\u001a\u00020BH\u0014J(\u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\rH\u0014J\u0006\u0010L\u001a\u00020BJ\u0010\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020\u0013H\u0016J&\u0010\u0016\u001a\u00020B2\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u0013J\u0006\u0010S\u001a\u00020BJ\u0006\u0010T\u001a\u00020BJ\u0006\u0010U\u001a\u00020BR\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00138F@FX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\r8F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0002038BX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u000e\u00108\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/tera/scan/ui/view/layout/UIBlurLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activityView", "Landroid/view/View;", "getActivityView", "()Landroid/view/View;", "blurRadius", "", "getBlurRadius", "()I", "setBlurRadius", "(I)V", "cornerRadius", "", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "downscaleFactor", "getDownscaleFactor", "setDownscaleFactor", "fps", "fPS", "getFPS", "setFPS", "invalidationLoop", "Landroid/view/Choreographer$FrameCallback;", "mActivityView", "Ljava/lang/ref/WeakReference;", "mAlpha", "mAttachedToWindow", "", "mBlurRadius", "mCornerRadius", "mCornerRadiusBottomLeft", "mCornerRadiusBottomRight", "mCornerRadiusTopLeft", "mCornerRadiusTopRight", "mDownscaleFactor", "mFPS", "mImageView", "Lcom/tera/scan/ui/view/widget/UIImageView;", "mLockedBitmap", "Landroid/graphics/Bitmap;", "mLockedPoint", "Landroid/graphics/Point;", "mRunning", "positionInScreen", "getPositionInScreen", "()Landroid/graphics/Point;", "positionLocked", "viewLocked", "blur", "getAlpha", "getDownscaledBitmapForView", "view", "crop", "Landroid/graphics/Rect;", "Landroid/graphics/PointF;", "invalidate", "", "lockPosition", "lockView", "onAttachedToWindow", "onDetachedFromWindow", "onSizeChanged", "w", "h", "oldw", "oldh", "pauseBlur", "setAlpha", "alpha", "topLeft", "topRight", "bottomLeft", "bottomRight", "startBlur", "unlockPosition", "unlockView", "Companion", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIBlurLayout extends FrameLayout {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    public static final float DEFAULT_ALPHA = Float.NaN;
    public static final int DEFAULT_BLUR_RADIUS = 12;
    public static final float DEFAULT_CORNER_RADIUS = 0.0f;
    public static final float DEFAULT_DOWNSCALE_FACTOR = 0.12f;
    public static final int DEFAULT_FPS = 30;
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    public final Choreographer.FrameCallback invalidationLoop;
    @Nullable
    public WeakReference<View> mActivityView;
    public float mAlpha;
    public boolean mAttachedToWindow;
    public int mBlurRadius;
    public float mCornerRadius;
    public float mCornerRadiusBottomLeft;
    public float mCornerRadiusBottomRight;
    public float mCornerRadiusTopLeft;
    public float mCornerRadiusTopRight;
    public float mDownscaleFactor;
    public int mFPS;
    @NotNull
    public UIImageView mImageView;
    @Nullable
    public Bitmap mLockedBitmap;
    @Nullable
    public Point mLockedPoint;
    public boolean mRunning;
    public boolean positionLocked;
    public boolean viewLocked;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public UIBlurLayout(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if (r0.get() == null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.graphics.Bitmap blur() {
        /*
            r15 = this;
            android.content.Context r0 = r15.getContext()
            r1 = 0
            if (r0 == 0) goto L_0x0145
            boolean r0 = r15.isInEditMode()
            if (r0 != 0) goto L_0x0145
            int r0 = r15.getVisibility()
            if (r0 == 0) goto L_0x0015
            goto L_0x0145
        L_0x0015:
            java.lang.ref.WeakReference<android.view.View> r0 = r15.mActivityView
            if (r0 == 0) goto L_0x0022
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0037
        L_0x0022:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            android.view.View r2 = r15.getActivityView()
            r0.<init>(r2)
            r15.mActivityView = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0037
            return r1
        L_0x0037:
            boolean r0 = r15.positionLocked
            if (r0 == 0) goto L_0x0048
            android.graphics.Point r0 = r15.mLockedPoint
            if (r0 != 0) goto L_0x0045
            android.graphics.Point r0 = r15.getPositionInScreen()
            r15.mLockedPoint = r0
        L_0x0045:
            android.graphics.Point r0 = r15.mLockedPoint
            goto L_0x004c
        L_0x0048:
            android.graphics.Point r0 = r15.getPositionInScreen()
        L_0x004c:
            r2 = 4
            r15.setVisibility(r2)
            java.lang.ref.WeakReference<android.view.View> r2 = r15.mActivityView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.Object r2 = r2.get()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            android.view.View r2 = (android.view.View) r2
            int r2 = r2.getWidth()
            java.lang.ref.WeakReference<android.view.View> r3 = r15.mActivityView
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.lang.Object r3 = r3.get()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            android.view.View r3 = (android.view.View) r3
            int r3 = r3.getHeight()
            int r4 = r15.getWidth()
            float r4 = (float) r4
            float r5 = r15.mDownscaleFactor
            float r4 = r4 * r5
            int r4 = (int) r4
            int r5 = r15.getHeight()
            float r5 = (float) r5
            float r6 = r15.mDownscaleFactor
            float r5 = r5 * r6
            int r5 = (int) r5
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r6 = r0.x
            float r6 = (float) r6
            float r7 = r15.mDownscaleFactor
            float r6 = r6 * r7
            int r6 = (int) r6
            int r8 = r0.y
            float r8 = (float) r8
            float r8 = r8 * r7
            int r7 = (int) r8
            int r8 = r15.getWidth()
            int r8 = r8 / 8
            int r9 = r15.getHeight()
            int r9 = r9 / 8
            int r10 = -r8
            int r11 = r6 + r10
            r12 = 0
            if (r11 < 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r10 = 0
        L_0x00ad:
            int r11 = r6 + r2
            int r11 = r11 - r8
            if (r11 > r2) goto L_0x00b3
            goto L_0x00b6
        L_0x00b3:
            int r2 = r2 + r2
            int r8 = r2 - r6
        L_0x00b6:
            int r2 = -r9
            int r11 = r7 + r2
            if (r11 < 0) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            r2 = 0
        L_0x00bd:
            int r11 = r15.getHeight()
            int r11 = r11 + r7
            int r11 = r11 + r9
            if (r11 > r3) goto L_0x00c6
            goto L_0x00c7
        L_0x00c6:
            r9 = 0
        L_0x00c7:
            boolean r3 = r15.viewLocked
            if (r3 == 0) goto L_0x00e4
            android.graphics.Bitmap r0 = r15.mLockedBitmap
            if (r0 != 0) goto L_0x00d2
            r15.lockView()
        L_0x00d2:
            android.graphics.Bitmap r0 = r15.mLockedBitmap
            if (r4 == 0) goto L_0x00e0
            if (r5 == 0) goto L_0x00e0
            if (r0 != 0) goto L_0x00db
            goto L_0x00e0
        L_0x00db:
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r6, r7, r4, r5)
            return r0
        L_0x00e0:
            r15.setVisibility(r12)
            return r1
        L_0x00e4:
            java.lang.ref.WeakReference<android.view.View> r3 = r15.mActivityView     // Catch:{ all -> 0x0142 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x0142 }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x0142 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0142 }
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ all -> 0x0142 }
            int r7 = r0.x     // Catch:{ all -> 0x0142 }
            int r7 = r7 + r10
            int r11 = r0.y     // Catch:{ all -> 0x0142 }
            int r11 = r11 + r2
            int r13 = r0.x     // Catch:{ all -> 0x0142 }
            int r14 = r15.getWidth()     // Catch:{ all -> 0x0142 }
            int r13 = r13 + r14
            int r14 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0142 }
            int r13 = r13 + r14
            int r13 = r13 + r8
            int r0 = r0.y     // Catch:{ all -> 0x0142 }
            int r8 = r15.getHeight()     // Catch:{ all -> 0x0142 }
            int r0 = r0 + r8
            int r8 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x0142 }
            int r0 = r0 + r8
            int r0 = r0 + r9
            r6.<init>(r7, r11, r13, r0)     // Catch:{ all -> 0x0142 }
            float r0 = r15.mDownscaleFactor     // Catch:{ all -> 0x0142 }
            android.graphics.Bitmap r0 = r15.getDownscaledBitmapForView(r3, r6, r0)     // Catch:{ all -> 0x0142 }
            boolean r1 = r15.viewLocked
            if (r1 != 0) goto L_0x013e
            fe.mmm.qw.f.ad.ad.qw r1 = fe.mmm.qw.f.ad.ad.qw.qw
            int r3 = r15.mBlurRadius
            float r3 = (float) r3
            r1.qw(r0, r3)
            int r1 = java.lang.Math.abs(r10)
            float r1 = (float) r1
            float r3 = r15.mDownscaleFactor
            float r1 = r1 * r3
            int r1 = (int) r1
            int r2 = java.lang.Math.abs(r2)
            float r2 = (float) r2
            float r3 = r15.mDownscaleFactor
            float r2 = r2 * r3
            int r2 = (int) r2
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r4, r5)
        L_0x013e:
            r15.setVisibility(r12)
            return r0
        L_0x0142:
            r15.setVisibility(r12)
        L_0x0145:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.layout.UIBlurLayout.blur():android.graphics.Bitmap");
    }

    private final View getActivityView() {
        try {
            Context context = getContext();
            if (context != null) {
                return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private final Bitmap getDownscaledBitmapForView(View view, Rect rect, float f) throws IllegalStateException {
        Intrinsics.checkNotNull(view);
        View rootView = view.getRootView();
        int width = (int) (((float) rect.width()) * f);
        int height = (int) (((float) rect.height()) * f);
        if (rootView.getWidth() > 0 && rootView.getHeight() > 0 && width > 0 && height > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Matrix matrix = new Matrix();
            matrix.preScale(f, f);
            matrix.postTranslate(((float) (-rect.left)) * f, ((float) (-rect.top)) * f);
            canvas.setMatrix(matrix);
            rootView.draw(canvas);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "bitmap");
            return createBitmap;
        }
        throw new IllegalStateException("No screen available (width or height = 0)".toString());
    }

    private final Point getPositionInScreen() {
        PointF positionInScreen = getPositionInScreen(this);
        return new Point((int) positionInScreen.x, (int) positionInScreen.y);
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

    public float getAlpha() {
        return this.mAlpha;
    }

    public final int getBlurRadius() {
        return this.mBlurRadius;
    }

    public final float getCornerRadius() {
        return this.mCornerRadius;
    }

    public final float getDownscaleFactor() {
        return this.mDownscaleFactor;
    }

    public final int getFPS() {
        return this.mFPS;
    }

    public void invalidate() {
        super.invalidate();
        Bitmap blur = blur();
        if (blur != null) {
            this.mImageView.setImageBitmap(blur);
        }
    }

    public final void lockPosition() {
        this.positionLocked = true;
        this.mLockedPoint = getPositionInScreen();
    }

    public final void lockView() {
        this.viewLocked = true;
        WeakReference<View> weakReference = this.mActivityView;
        if (weakReference != null) {
            Intrinsics.checkNotNull(weakReference);
            if (weakReference.get() != null) {
                WeakReference<View> weakReference2 = this.mActivityView;
                Intrinsics.checkNotNull(weakReference2);
                Object obj = weakReference2.get();
                Intrinsics.checkNotNull(obj);
                View rootView = ((View) obj).getRootView();
                try {
                    super.setAlpha(0.0f);
                    this.mLockedBitmap = getDownscaledBitmapForView(rootView, new Rect(0, 0, rootView.getWidth(), rootView.getHeight()), this.mDownscaleFactor);
                    if (Float.isNaN(this.mAlpha)) {
                        super.setAlpha(1.0f);
                    } else {
                        super.setAlpha(this.mAlpha);
                    }
                    fe.mmm.qw.f.ad.ad.qw qwVar = fe.mmm.qw.f.ad.ad.qw.qw;
                    Bitmap bitmap = this.mLockedBitmap;
                    Intrinsics.checkNotNull(bitmap);
                    qwVar.qw(bitmap, (float) this.mBlurRadius);
                    this.mLockedBitmap = bitmap;
                } catch (Exception unused) {
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        startBlur();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        pauseBlur();
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        invalidate();
    }

    public final void pauseBlur() {
        if (this.mRunning) {
            this.mRunning = false;
            Choreographer.getInstance().removeFrameCallback(this.invalidationLoop);
        }
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
        if (!this.viewLocked) {
            super.setAlpha(f);
        }
    }

    public final void setBlurRadius(int i2) {
        this.mBlurRadius = i2;
        this.mLockedBitmap = null;
        invalidate();
    }

    public final void setCornerRadius(float f) {
        this.mCornerRadius = f;
        this.mImageView.setCorner(f);
        invalidate();
    }

    public final void setDownscaleFactor(float f) {
        this.mDownscaleFactor = f;
        this.mLockedBitmap = null;
        invalidate();
    }

    public final void setFPS(int i2) {
        if (this.mRunning) {
            pauseBlur();
        }
        this.mFPS = i2;
        if (this.mAttachedToWindow) {
            startBlur();
        }
    }

    public final void startBlur() {
        if (!this.mRunning && this.mFPS > 0) {
            this.mRunning = true;
            Choreographer.getInstance().postFrameCallback(this.invalidationLoop);
        }
    }

    public final void unlockPosition() {
        this.positionLocked = false;
        this.mLockedPoint = null;
    }

    public final void unlockView() {
        this.viewLocked = false;
        this.mLockedBitmap = null;
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UIBlurLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.invalidationLoop = new UIBlurLayout$invalidationLoop$1(this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.UIBlurLayout, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.theme.obtainStyl…ut,\n                0, 0)");
        try {
            this.mDownscaleFactor = obtainStyledAttributes.getFloat(3, 0.12f);
            this.mBlurRadius = obtainStyledAttributes.getInteger(2, 12);
            this.mFPS = obtainStyledAttributes.getInteger(1, 30);
            float dimension = obtainStyledAttributes.getDimension(4, 0.0f);
            this.mCornerRadius = dimension;
            this.mCornerRadiusTopLeft = obtainStyledAttributes.getDimension(7, dimension);
            this.mCornerRadiusTopRight = obtainStyledAttributes.getDimension(8, this.mCornerRadius);
            this.mCornerRadiusBottomLeft = obtainStyledAttributes.getDimension(5, this.mCornerRadius);
            this.mCornerRadiusBottomRight = obtainStyledAttributes.getDimension(6, this.mCornerRadius);
            this.mAlpha = obtainStyledAttributes.getFloat(0, DEFAULT_ALPHA);
            obtainStyledAttributes.recycle();
            UIImageView uIImageView = new UIImageView(context);
            this.mImageView = uIImageView;
            uIImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(this.mImageView);
            setCornerRadius(this.mCornerRadiusTopLeft, this.mCornerRadiusTopRight, this.mCornerRadiusBottomLeft, this.mCornerRadiusBottomRight);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    private final PointF getPositionInScreen(View view) {
        if (getParent() == null) {
            return new PointF();
        }
        try {
            ViewParent parent = view.getParent();
            if (parent != null) {
                PointF positionInScreen = getPositionInScreen((ViewGroup) parent);
                positionInScreen.offset(view.getX(), view.getY());
                return positionInScreen;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        } catch (Exception unused) {
            return new PointF();
        }
    }

    public final void setCornerRadius(float f, float f2, float f3, float f4) {
        this.mImageView.setCorner(f, f2, f3, f4);
        invalidate();
    }
}
