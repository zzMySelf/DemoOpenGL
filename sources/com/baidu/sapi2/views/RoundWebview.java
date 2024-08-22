package com.baidu.sapi2.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import com.baidu.passport.sapi2.R;
import com.baidu.sapi2.SapiWebView;

public class RoundWebview extends SapiWebView {

    /* renamed from: a  reason: collision with root package name */
    private float f18312a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f18313b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f18314c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f18315d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f18316e;

    /* renamed from: f  reason: collision with root package name */
    private int f18317f;

    /* renamed from: g  reason: collision with root package name */
    private int f18318g;

    /* renamed from: h  reason: collision with root package name */
    private int f18319h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f18320i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f18321j;
    private float[] k = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    public RoundWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.f18320i = paint;
        paint.setColor(-1);
        this.f18320i.setAntiAlias(true);
        this.f18320i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f18321j = paint2;
        paint2.setXfermode((Xfermode) null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sapi_sdk_RoundWebview);
        this.f18312a = obtainStyledAttributes.getDimension(R.styleable.sapi_sdk_RoundWebview_sapi_sdk_top_left, 0.0f);
        this.f18313b = obtainStyledAttributes.getDimension(R.styleable.sapi_sdk_RoundWebview_sapi_sdk_top_right, 0.0f);
        this.f18314c = obtainStyledAttributes.getDimension(R.styleable.sapi_sdk_RoundWebview_sapi_sdk_bottom_left, 0.0f);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.sapi_sdk_RoundWebview_sapi_sdk_bottom_right, 0.0f);
        this.f18315d = dimension;
        a(this.f18312a, this.f18313b, dimension, this.f18314c);
    }

    public void onDraw(Canvas canvas) {
        this.f18318g = getScrollX();
        this.f18319h = getScrollY();
        Path path = new Path();
        int i2 = this.f18319h;
        path.addRoundRect(new RectF(0.0f, (float) i2, (float) (this.f18318g + this.f18316e), (float) (i2 + this.f18317f)), this.k, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f18316e = getMeasuredWidth();
        this.f18317f = getMeasuredHeight();
    }

    public RoundWebview(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.k;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f4;
        fArr[6] = f5;
        fArr[7] = f5;
    }
}
