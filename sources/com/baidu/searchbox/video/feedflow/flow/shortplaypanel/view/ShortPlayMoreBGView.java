package com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J(\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/ShortPlayMoreBGView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bGColor", "centerRadius", "", "coreEffect", "Landroid/graphics/CornerPathEffect;", "cornerColor", "inSideRadius", "outSideRadius", "overAllHeight", "overAllWidth", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "initParams", "", "color", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayMoreBGView.kt */
public final class ShortPlayMoreBGView extends View {
    private int bGColor;
    private float centerRadius;
    private CornerPathEffect coreEffect;
    private int cornerColor;
    private float inSideRadius;
    private float outSideRadius;
    private float overAllHeight;
    private float overAllWidth;
    private final Paint paint;
    private Path path;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShortPlayMoreBGView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShortPlayMoreBGView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShortPlayMoreBGView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortPlayMoreBGView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint();
        this.path = new Path();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float circleX = this.overAllWidth / ((float) 2);
        float circleY = this.overAllHeight / ((float) 3);
        this.paint.setAntiAlias(false);
        this.paint.setColor(this.cornerColor);
        this.paint.setStrokeWidth(1.0f);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(circleX, circleY, this.outSideRadius, this.paint);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(circleX, circleY, this.inSideRadius, this.paint);
        this.paint.setColor(-1);
        canvas.drawCircle(circleX, circleY, this.centerRadius, this.paint);
        float f2 = this.centerRadius;
        float f3 = (float) 4;
        canvas.drawCircle((f2 * f3) + circleX, circleY, f2, this.paint);
        float f4 = this.centerRadius;
        canvas.drawCircle(circleX - (f3 * f4), circleY, f4, this.paint);
        this.path.reset();
        this.paint.setColor(this.bGColor);
        this.paint.setPathEffect(this.coreEffect);
        this.path.moveTo(0.0f, 0.0f);
        this.path.lineTo(this.overAllWidth, 0.0f);
        this.path.lineTo(this.overAllWidth, this.overAllHeight);
        this.path.lineTo(0.0f, this.overAllHeight);
        this.path.lineTo(0.0f, 0.0f);
        this.path.lineTo(this.overAllWidth, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h2, int oldw, int oldh) {
        super.onSizeChanged(w, h2, oldw, oldh);
        this.overAllHeight = (float) h2;
        this.overAllWidth = (float) w;
    }

    public final void initParams(float outSideRadius2, float inSideRadius2, float centerRadius2, String color, int bGColor2) {
        int i2;
        Intrinsics.checkNotNullParameter(color, "color");
        this.outSideRadius = outSideRadius2;
        this.inSideRadius = inSideRadius2;
        this.centerRadius = centerRadius2;
        try {
            i2 = Color.parseColor(color);
        } catch (Exception e2) {
            i2 = -1;
        }
        this.cornerColor = i2;
        this.bGColor = bGColor2;
        this.coreEffect = new CornerPathEffect(DIFactory.INSTANCE.getAppContext().getResources().getDimension(R.dimen.video_flow_dimens_7dp));
    }
}
