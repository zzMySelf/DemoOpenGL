package com.baidu.swan.game.guide.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.game.guide.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001AB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002J\b\u00104\u001a\u00020/H\u0002J\u0010\u00105\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0014J(\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\t2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0014J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014H\u0002J\u000e\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u00020\tJ\u000e\u0010?\u001a\u00020/2\u0006\u0010<\u001a\u00020\u0014J\u0006\u0010@\u001a\u00020/R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/baidu/swan/game/guide/view/GameGuideProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPaint", "Landroid/graphics/Paint;", "clipPath", "Landroid/graphics/Path;", "getClipPath", "()Landroid/graphics/Path;", "clipPath$delegate", "Lkotlin/Lazy;", "currentProgress", "", "gradientBitmap", "Landroid/graphics/Bitmap;", "gradientImgWidth", "imgPaint", "isProgressStopped", "", "originImgRect", "Landroid/graphics/Rect;", "progressColor", "progressHeight", "progressListener", "Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "getProgressListener", "()Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "setProgressListener", "(Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;)V", "progressPaint", "roundCorner", "strokeColor", "strokePaint", "strokeWidth", "valueAnim", "Landroid/animation/ValueAnimator;", "viewHeight", "viewWidth", "drawGradientImg", "", "canvas", "Landroid/graphics/Canvas;", "drawProcess", "drawStroke", "init", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "reviseProcess", "process", "setProgressColor", "color", "startProcess", "stopProcess", "OnGameTimeProgressListener", "lib-swan-game-guide_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameGuideProgressView.kt */
public final class GameGuideProgressView extends View {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Paint clipPaint;
    private final Lazy clipPath$delegate;
    private float currentProgress;
    private Bitmap gradientBitmap;
    private float gradientImgWidth;
    private Paint imgPaint;
    private boolean isProgressStopped;
    private Rect originImgRect;
    private int progressColor;
    private float progressHeight;
    private OnGameTimeProgressListener progressListener;
    private Paint progressPaint;
    private float roundCorner;
    private int strokeColor;
    private Paint strokePaint;
    private float strokeWidth;
    private ValueAnimator valueAnim;
    private int viewHeight;
    private int viewWidth;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "", "onProcessStop", "", "onProgressEnd", "onProgressStart", "currentProgress", "", "onProgressing", "lib-swan-game-guide_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameGuideProgressView.kt */
    public interface OnGameTimeProgressListener {
        void onProcessStop();

        void onProgressEnd();

        void onProgressStart(float f2);

        void onProgressing(float f2);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final OnGameTimeProgressListener getProgressListener() {
        return this.progressListener;
    }

    public final void setProgressListener(OnGameTimeProgressListener onGameTimeProgressListener) {
        this.progressListener = onGameTimeProgressListener;
    }

    private final Path getClipPath() {
        return (Path) this.clipPath$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.strokeWidth = SwanAppUIUtils.dp2pxf(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.strokeColor = parseColor;
        this.progressColor = parseColor;
        this.gradientImgWidth = SwanAppUIUtils.dp2pxf(20.0f);
        float dp2pxf = SwanAppUIUtils.dp2pxf(6.0f);
        this.progressHeight = dp2pxf;
        this.roundCorner = dp2pxf / 2.0f;
        this.clipPath$delegate = LazyKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.strokeWidth = SwanAppUIUtils.dp2pxf(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.strokeColor = parseColor;
        this.progressColor = parseColor;
        this.gradientImgWidth = SwanAppUIUtils.dp2pxf(20.0f);
        float dp2pxf = SwanAppUIUtils.dp2pxf(6.0f);
        this.progressHeight = dp2pxf;
        this.roundCorner = dp2pxf / 2.0f;
        this.clipPath$delegate = LazyKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GameGuideProgressView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        this.strokeWidth = SwanAppUIUtils.dp2pxf(1.0f);
        int parseColor = Color.parseColor("#FFCD5D");
        this.strokeColor = parseColor;
        this.progressColor = parseColor;
        this.gradientImgWidth = SwanAppUIUtils.dp2pxf(20.0f);
        float dp2pxf = SwanAppUIUtils.dp2pxf(6.0f);
        this.progressHeight = dp2pxf;
        this.roundCorner = dp2pxf / 2.0f;
        this.clipPath$delegate = LazyKt.lazy(GameGuideProgressView$clipPath$2.INSTANCE);
        init();
    }

    private final void init() {
        Paint paint = new Paint(1);
        this.strokePaint = paint;
        paint.setStrokeWidth(this.strokeWidth);
        Paint paint2 = this.strokePaint;
        Bitmap bitmap = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            paint2 = null;
        }
        paint2.setColor(this.strokeColor);
        Paint paint3 = this.strokePaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            paint3 = null;
        }
        paint3.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.progressPaint = paint4;
        paint4.setColor(this.progressColor);
        Paint paint5 = this.progressPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
            paint5 = null;
        }
        paint5.setStyle(Paint.Style.FILL);
        Paint paint6 = new Paint(1);
        this.imgPaint = paint6;
        paint6.setFilterBitmap(true);
        Paint paint7 = this.imgPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imgPaint");
            paint7 = null;
        }
        paint7.setDither(true);
        Paint paint8 = new Paint(1);
        this.clipPaint = paint8;
        paint8.setStyle(Paint.Style.FILL);
        Drawable drawable = AppRuntime.getAppContext().getResources().getDrawable(R.drawable.aiapps_game_guide_progress_view_gradient_bg);
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable != null) {
            bitmap = bitmapDrawable.getBitmap();
        }
        this.gradientBitmap = bitmap;
        if (bitmap != null) {
            Bitmap $this$init_u24lambda_u2d0 = bitmap;
            this.originImgRect = new Rect(0, 0, $this$init_u24lambda_u2d0.getWidth(), $this$init_u24lambda_u2d0.getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        this.viewWidth = w;
        this.viewHeight = h2;
        if (((float) w) > this.gradientImgWidth) {
            return;
        }
        if (!SwanAppLibConfig.DEBUG) {
            this.gradientImgWidth = (float) this.viewWidth;
            return;
        }
        throw new RuntimeException("进度条宽度异常");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawStroke(canvas);
        drawProcess(canvas);
        drawGradientImg(canvas);
    }

    private final void drawStroke(Canvas canvas) {
        float f2 = this.strokeWidth;
        float f3 = (float) 2;
        float r = ((float) this.viewWidth) - (f2 / f3);
        int i2 = this.viewHeight;
        float f4 = this.progressHeight;
        RectF rectF = new RectF((f2 / f3) + 0.0f, (((float) i2) / 2.0f) - (f4 / 2.0f), r, (((float) i2) / 2.0f) + (f4 / 2.0f));
        float f5 = this.roundCorner;
        Paint paint = this.strokePaint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            paint = null;
        }
        canvas.drawRoundRect(rectF, f5, f5, paint);
    }

    private final void drawProcess(Canvas canvas) {
        float f2 = this.currentProgress;
        if (!(f2 == 0.0f)) {
            float reviseProcess = reviseProcess(f2);
            this.currentProgress = reviseProcess;
            float f3 = this.strokeWidth;
            float f4 = (float) 2;
            int i2 = this.viewHeight;
            float f5 = this.progressHeight;
            RectF rectF = new RectF((f3 / f4) + 0.0f, (((float) i2) / 2.0f) - (f5 / 2.0f), (reviseProcess * ((float) this.viewWidth)) - (f3 / f4), (((float) i2) / 2.0f) + (f5 / 2.0f));
            float f6 = this.roundCorner;
            Paint paint = this.progressPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
                paint = null;
            }
            canvas.drawRoundRect(rectF, f6, f6, paint);
        }
    }

    private final void drawGradientImg(Canvas canvas) {
        Rect rect;
        int l;
        Canvas canvas2 = canvas;
        Bitmap it = this.gradientBitmap;
        if (it != null && (rect = this.originImgRect) != null && it != null) {
            float f2 = this.currentProgress;
            int i2 = this.viewWidth;
            float f3 = this.gradientImgWidth;
            if (((float) i2) * f2 <= f3) {
                if (rect != null) {
                    rect.left = (int) (f3 - (f2 * ((float) i2)));
                }
                l = 0;
            } else {
                if (rect != null) {
                    rect.left = 0;
                }
                l = (int) ((this.currentProgress * ((float) this.viewWidth)) - this.gradientImgWidth);
            }
            Rect destRect = new Rect(l, 0, (int) (this.currentProgress * ((float) this.viewWidth)), this.viewHeight);
            Rect rect2 = this.originImgRect;
            Paint paint = this.imgPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imgPaint");
                paint = null;
            }
            canvas2.drawBitmap(it, rect2, destRect, paint);
            if (l == 0) {
                getClipPath().reset();
                int i3 = this.viewHeight;
                float f4 = this.progressHeight;
                float f5 = (float) 2;
                float f6 = this.strokeWidth;
                RectF rectF = new RectF(0.0f, ((((float) i3) / 2.0f) - (f4 / f5)) - (f6 / f5), (float) this.viewWidth, (((float) i3) / 2.0f) + (f4 / f5) + (f6 / f5));
                float f7 = this.roundCorner;
                Bitmap bitmap = it;
                getClipPath().addRoundRect(rectF, new float[]{f7, f7, f7, f7, f7, f7, f7, f7}, Path.Direction.CW);
                if (Build.VERSION.SDK_INT <= 27) {
                    Paint paint2 = this.clipPaint;
                    if (paint2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                        paint2 = null;
                    }
                    int i4 = l;
                    paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    Path clipPath = getClipPath();
                    Paint paint3 = this.clipPaint;
                    if (paint3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                        paint3 = null;
                    }
                    canvas2.drawPath(clipPath, paint3);
                    return;
                }
                Paint paint4 = this.clipPaint;
                if (paint4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                    paint4 = null;
                }
                paint4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                Path path = new Path();
                path.addRect(-1.0f, -1.0f, (float) this.viewWidth, (float) this.viewHeight, Path.Direction.CW);
                path.op(getClipPath(), Path.Op.DIFFERENCE);
                Paint paint5 = this.clipPaint;
                if (paint5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clipPaint");
                    paint5 = null;
                }
                canvas2.drawPath(path, paint5);
                return;
            }
            int i5 = l;
        }
    }

    private final float reviseProcess(float process) {
        if (process < 0.0f) {
            return 0.0f;
        }
        if (process > 1.0f) {
            return 1.0f;
        }
        return process;
    }

    public final void startProcess(float process) {
        float reviseProcess = reviseProcess(process);
        this.currentProgress = reviseProcess;
        if (reviseProcess == 1.0f) {
            if (SwanAppLibConfig.DEBUG) {
                Log.d("GameTimeProgressView", "当前进度为1，不处理");
            }
            invalidate();
            return;
        }
        long duration = (long) (((float) 30000) * (1.0f - reviseProcess));
        if (duration == 0) {
            duration = 30000;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{reviseProcess, 1.0f});
        this.valueAnim = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(duration);
        }
        ValueAnimator valueAnimator = this.valueAnim;
        if (valueAnimator != null) {
            valueAnimator.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator2 = this.valueAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new GameGuideProgressView$$ExternalSyntheticLambda0(this));
        }
        ValueAnimator valueAnimator3 = this.valueAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(new GameGuideProgressView$startProcess$2(this));
        }
        this.isProgressStopped = false;
        OnGameTimeProgressListener onGameTimeProgressListener = this.progressListener;
        if (onGameTimeProgressListener != null) {
            onGameTimeProgressListener.onProgressStart(this.currentProgress);
        }
        ValueAnimator valueAnimator4 = this.valueAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startProcess$lambda-3  reason: not valid java name */
    public static final void m8086startProcess$lambda3(GameGuideProgressView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Float fl = animatedValue instanceof Float ? (Float) animatedValue : null;
        if (fl != null) {
            float floatValue = fl.floatValue();
            float reviseProcess = this$0.reviseProcess(fl.floatValue());
            this$0.currentProgress = reviseProcess;
            OnGameTimeProgressListener onGameTimeProgressListener = this$0.progressListener;
            if (onGameTimeProgressListener != null) {
                onGameTimeProgressListener.onProgressing(reviseProcess);
            }
            this$0.invalidate();
        }
    }

    public final void stopProcess() {
        this.isProgressStopped = true;
        ValueAnimator valueAnimator = this.valueAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        OnGameTimeProgressListener onGameTimeProgressListener = this.progressListener;
        if (onGameTimeProgressListener != null) {
            onGameTimeProgressListener.onProcessStop();
        }
    }

    public final void setProgressColor(int color) {
        Paint paint = this.strokePaint;
        Paint paint2 = null;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            paint = null;
        }
        paint.setColor(color);
        Paint paint3 = this.progressPaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressPaint");
        } else {
            paint2 = paint3;
        }
        paint2.setColor(color);
    }
}
