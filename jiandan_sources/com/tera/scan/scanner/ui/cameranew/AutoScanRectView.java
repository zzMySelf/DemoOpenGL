package com.tera.scan.scanner.ui.cameranew;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.terascan.algo.Point;
import fe.mmm.qw.tt.rg.ad.th;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020#H\u0002J\u0006\u00105\u001a\u000203JH\u00106\u001a\u00020\r2\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u00109\u001a\u00020\t2\u0006\u00104\u001a\u00020#H\u0002J\u0010\u0010:\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010;\u001a\u0002032\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\u000e\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020\tJ\u0006\u0010@\u001a\u000203J\u0014\u0010A\u001a\u0002032\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\r0CJ$\u0010D\u001a\u0002032\u001a\u0010E\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eH\u0002R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0016R\"\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b \u0010\u0016R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000RL\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u001a\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\"\u00101\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/tera/scan/scanner/ui/cameranew/AutoScanRectView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animStartPoints", "Ljava/util/ArrayList;", "Lcom/terascan/algo/Point;", "Lkotlin/collections/ArrayList;", "animal", "Landroid/animation/ValueAnimator;", "argbEvaluator", "Landroid/animation/ArgbEvaluator;", "cameraHeight", "cornerExtension", "getCornerExtension", "()I", "cornerExtension$delegate", "Lkotlin/Lazy;", "cornerRadius", "getCornerRadius", "cornerRadius$delegate", "currentPoints", "paint", "Landroid/graphics/Paint;", "paintColor", "getPaintColor", "paintColor$delegate", "paintWidth", "", "getPaintWidth", "()F", "paintWidth$delegate", "path", "Landroid/graphics/Path;", "value", "points", "getPoints", "()Ljava/util/ArrayList;", "setPoints", "(Ljava/util/ArrayList;)V", "tempRectF", "Landroid/graphics/RectF;", "verifiedPoints", "calculateProgressPoints", "", "process", "clear", "getProgressPoint", "startPoints", "endPoints", "index", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setCameraHeight", "height", "show", "updatePoints", "list", "", "verifyPoints", "pointsArray", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("AutoScanRectView")
public final class AutoScanRectView extends View {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @Nullable
    public ArrayList<Point> animStartPoints;
    @Nullable
    public ValueAnimator animal;
    @NotNull
    public final ArgbEvaluator argbEvaluator;
    public int cameraHeight;
    @NotNull
    public final Lazy cornerExtension$delegate;
    @NotNull
    public final Lazy cornerRadius$delegate;
    @Nullable
    public ArrayList<Point> currentPoints;
    @NotNull
    public final Paint paint;
    @NotNull
    public final Lazy paintColor$delegate;
    @NotNull
    public final Lazy paintWidth$delegate;
    @NotNull
    public final Path path;
    @Nullable
    public ArrayList<Point> points;
    @NotNull
    public final RectF tempRectF;
    @Nullable
    public ArrayList<Point> verifiedPoints;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoScanRectView(@NotNull Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void calculateProgressPoints(float f) {
        ArrayList<Point> arrayList = this.animStartPoints;
        ArrayList<Point> arrayList2 = this.verifiedPoints;
        if ((arrayList == null || arrayList.isEmpty()) || arrayList.size() != 4) {
            this.currentPoints = arrayList2;
            return;
        }
        if ((arrayList2 == null || arrayList2.isEmpty()) || arrayList2.size() != 4) {
            this.currentPoints = null;
            return;
        }
        LoggerKt.d$default("process = " + f, (Object) null, 1, (Object) null);
        ArrayList<Point> arrayList3 = new ArrayList<>();
        arrayList3.add(getProgressPoint(arrayList, arrayList2, 0, f));
        arrayList3.add(getProgressPoint(arrayList, arrayList2, 1, f));
        arrayList3.add(getProgressPoint(arrayList, arrayList2, 2, f));
        arrayList3.add(getProgressPoint(arrayList, arrayList2, 3, f));
        this.currentPoints = arrayList3;
    }

    private final int getCornerExtension() {
        return ((Number) this.cornerExtension$delegate.getValue()).intValue();
    }

    private final int getCornerRadius() {
        return ((Number) this.cornerRadius$delegate.getValue()).intValue();
    }

    private final int getPaintColor() {
        return ((Number) this.paintColor$delegate.getValue()).intValue();
    }

    private final float getPaintWidth() {
        return ((Number) this.paintWidth$delegate.getValue()).floatValue();
    }

    private final Point getProgressPoint(ArrayList<Point> arrayList, ArrayList<Point> arrayList2, int i2, float f) {
        return new Point(arrayList.get(i2).getX() + ((arrayList2.get(i2).getX() - arrayList.get(i2).getX()) * f), arrayList.get(i2).getY() + ((arrayList2.get(i2).getY() - arrayList.get(i2).getY()) * f));
    }

    private final void init(Context context) {
        this.paint.setStrokeWidth(getPaintWidth());
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
    }

    /* renamed from: show$lambda-2$lambda-1  reason: not valid java name */
    public static final void m911show$lambda2$lambda1(AutoScanRectView autoScanRectView, boolean z, ValueAnimator valueAnimator) {
        int i2;
        Intrinsics.checkNotNullParameter(autoScanRectView, "this$0");
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            float floatValue = ((Float) animatedValue).floatValue();
            autoScanRectView.calculateProgressPoints(floatValue);
            if (z) {
                Paint paint2 = autoScanRectView.paint;
                Object evaluate = autoScanRectView.argbEvaluator.evaluate(floatValue, 0, Integer.valueOf(autoScanRectView.getPaintColor()));
                Integer num = evaluate instanceof Integer ? (Integer) evaluate : null;
                if (num != null) {
                    i2 = num.intValue();
                } else {
                    i2 = autoScanRectView.getPaintColor();
                }
                paint2.setColor(i2);
            }
            autoScanRectView.invalidate();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }

    private final void verifyPoints(ArrayList<Point> arrayList) {
        float paintWidth = getPaintWidth() / ((float) 2);
        if ((arrayList == null || arrayList.isEmpty()) || arrayList.size() != 4) {
            int i2 = this.cameraHeight;
            LoggerKt.d$default("模型返回坐标为空，框选全屏, cameraHeight = " + i2, (Object) null, 1, (Object) null);
            if (i2 > 0) {
                float f = 0.0f + paintWidth;
                float f2 = ((float) i2) - paintWidth;
                this.verifiedPoints = CollectionsKt__CollectionsKt.arrayListOf(new Point(f, f), new Point(((float) getWidth()) - paintWidth, f), new Point(((float) getWidth()) - paintWidth, f2), new Point(f, f2));
                return;
            }
            return;
        }
        float f3 = ((float) this.cameraHeight) - paintWidth;
        if (f3 < 0.0f) {
            f3 = Math.max(arrayList.get(2).getY(), arrayList.get(1).getY());
        }
        float width = ((float) getWidth()) - paintWidth;
        ArrayList<Point> arrayList2 = new ArrayList<>();
        arrayList2.add(new Point(Math.max(paintWidth, Math.min(arrayList.get(0).getX(), arrayList.get(1).getX())), Math.max(paintWidth, Math.min(arrayList.get(0).getY(), arrayList.get(3).getY()))));
        arrayList2.add(new Point(Math.min(width, Math.max(arrayList.get(3).getX(), arrayList.get(2).getX())), Math.max(paintWidth, Math.min(arrayList.get(0).getY(), arrayList.get(3).getY()))));
        arrayList2.add(new Point(Math.min(width, Math.max(arrayList.get(3).getX(), arrayList.get(2).getX())), Math.min(f3, Math.max(arrayList.get(2).getY(), arrayList.get(1).getY()))));
        arrayList2.add(new Point(Math.max(paintWidth, Math.min(arrayList.get(0).getX(), arrayList.get(1).getX())), Math.min(f3, Math.max(arrayList.get(2).getY(), arrayList.get(1).getY()))));
        this.verifiedPoints = arrayList2;
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

    public final void clear() {
        ValueAnimator valueAnimator = this.animal;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.currentPoints = null;
        this.verifiedPoints = null;
        invalidate();
    }

    @Nullable
    public final ArrayList<Point> getPoints() {
        return this.points;
    }

    public void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            ArrayList<Point> arrayList = this.currentPoints;
            if ((arrayList == null || arrayList.isEmpty()) || arrayList.size() != 4) {
                this.path.reset();
                this.path.close();
                canvas.drawPath(this.path, this.paint);
                setPoints((ArrayList<Point>) null);
                return;
            }
            this.path.reset();
            this.path.moveTo(arrayList.get(0).getX(), arrayList.get(0).getY() + ((float) getCornerExtension()) + ((float) getCornerRadius()));
            this.path.lineTo(arrayList.get(0).getX(), arrayList.get(0).getY() + ((float) getCornerRadius()));
            this.tempRectF.set(arrayList.get(0).getX(), arrayList.get(0).getY(), arrayList.get(0).getX() + ((float) (getCornerRadius() * 2)), arrayList.get(0).getY() + ((float) (getCornerRadius() * 2)));
            this.path.arcTo(this.tempRectF, 180.0f, 90.0f);
            this.path.lineTo(arrayList.get(0).getX() + ((float) getCornerExtension()) + ((float) getCornerRadius()), arrayList.get(0).getY());
            this.path.moveTo((arrayList.get(1).getX() - ((float) getCornerExtension())) - ((float) getCornerRadius()), arrayList.get(1).getY());
            this.path.lineTo(arrayList.get(1).getX() - ((float) getCornerRadius()), arrayList.get(1).getY());
            this.tempRectF.set(arrayList.get(1).getX() - ((float) (getCornerRadius() * 2)), arrayList.get(1).getY(), arrayList.get(1).getX(), arrayList.get(1).getY() + ((float) (getCornerRadius() * 2)));
            this.path.arcTo(this.tempRectF, 270.0f, 90.0f);
            this.path.lineTo(arrayList.get(1).getX(), arrayList.get(1).getY() + ((float) getCornerExtension()) + ((float) getCornerRadius()));
            this.path.moveTo(arrayList.get(2).getX(), (arrayList.get(2).getY() - ((float) getCornerRadius())) - ((float) getCornerExtension()));
            this.path.lineTo(arrayList.get(2).getX(), arrayList.get(2).getY() - ((float) getCornerRadius()));
            this.tempRectF.set(arrayList.get(2).getX() - ((float) (getCornerRadius() * 2)), arrayList.get(2).getY() - ((float) (getCornerRadius() * 2)), arrayList.get(2).getX(), arrayList.get(2).getY());
            this.path.arcTo(this.tempRectF, 0.0f, 90.0f);
            this.path.lineTo((arrayList.get(2).getX() - ((float) getCornerRadius())) - ((float) getCornerExtension()), arrayList.get(2).getY());
            this.path.moveTo(arrayList.get(3).getX() + ((float) getCornerExtension()) + ((float) getCornerRadius()), arrayList.get(3).getY());
            this.path.lineTo(arrayList.get(3).getX() + ((float) getCornerRadius()), arrayList.get(3).getY());
            this.tempRectF.set(arrayList.get(3).getX(), arrayList.get(3).getY() - ((float) (getCornerRadius() * 2)), arrayList.get(3).getX() + ((float) (getCornerRadius() * 2)), arrayList.get(3).getY());
            this.path.arcTo(this.tempRectF, 90.0f, 90.0f);
            this.path.lineTo(arrayList.get(3).getX(), (arrayList.get(3).getY() - ((float) getCornerRadius())) - ((float) getCornerExtension()));
            canvas.drawPath(this.path, this.paint);
        }
    }

    public final void setCameraHeight(int i2) {
        this.cameraHeight = i2;
    }

    public final void setPoints(@Nullable ArrayList<Point> arrayList) {
        verifyPoints(arrayList);
        this.points = arrayList;
    }

    public final void show() {
        ValueAnimator valueAnimator = this.animal;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ArrayList<Point> arrayList = this.currentPoints;
        this.animStartPoints = arrayList;
        boolean z = arrayList == null || arrayList.isEmpty();
        if (!z) {
            this.paint.setColor(getPaintColor());
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(280);
        ofFloat.setRepeatCount(0);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new th(this, z));
        this.animal = ofFloat;
        if (ofFloat != null) {
            ofFloat.start();
        }
    }

    public final void updatePoints(@NotNull List<Point> list) {
        Intrinsics.checkNotNullParameter(list, "list");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AutoScanRectView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoScanRectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.paint = new Paint();
        this.path = new Path();
        this.paintColor$delegate = LazyKt__LazyJVMKt.lazy(AutoScanRectView$paintColor$2.INSTANCE);
        this.cornerExtension$delegate = LazyKt__LazyJVMKt.lazy(new AutoScanRectView$cornerExtension$2(this));
        this.cornerRadius$delegate = LazyKt__LazyJVMKt.lazy(new AutoScanRectView$cornerRadius$2(this));
        this.paintWidth$delegate = LazyKt__LazyJVMKt.lazy(new AutoScanRectView$paintWidth$2(this));
        this.tempRectF = new RectF();
        this.argbEvaluator = new ArgbEvaluator();
        init(context);
    }
}
