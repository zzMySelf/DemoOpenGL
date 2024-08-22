package fe.mmm.qw.f.de.qw;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import com.baidu.apollon.utils.ResUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw extends Drawable {
    @NotNull
    public static final C0278qw rrr = new C0278qw((DefaultConstructorMarker) null);
    public float aaa;

    /* renamed from: ad  reason: collision with root package name */
    public int f7792ad;
    public float ddd;

    /* renamed from: de  reason: collision with root package name */
    public int f7793de;
    public boolean eee = true;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final RectF f7794fe = new RectF();
    public float ggg = -1.0f;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final Path f7795i = new Path();
    @NotNull

    /* renamed from: if  reason: not valid java name */
    public final RectF f331if = new RectF();
    @NotNull
    public final float[] mmm = new float[8];
    public float nn;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public RectF f7796o = new RectF();
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final RectF f7797pf = new RectF();
    @NotNull
    public ImageView.ScaleType ppp = ImageView.ScaleType.FIT_CENTER;
    public int qqq = -16777216;
    @NotNull
    public Bitmap qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public Paint f7798rg;

    /* renamed from: switch  reason: not valid java name */
    public boolean f332switch = true;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public Paint f7799th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final RectF f7800uk = new RectF();
    public float vvv;
    @NotNull
    public final Matrix when = new Matrix();
    public float xxx;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final RectF f7801yj = new RectF();

    public /* synthetic */ class ad {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 1;
            iArr[ImageView.ScaleType.CENTER.ordinal()] = 2;
            iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 3;
            iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            iArr[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            iArr[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: fe.mmm.qw.f.de.qw.qw$qw  reason: collision with other inner class name */
    public static final class C0278qw {
        public C0278qw() {
        }

        public /* synthetic */ C0278qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final qw ad(@Nullable Bitmap bitmap) {
            if (bitmap != null) {
                return new qw(bitmap);
            }
            return null;
        }

        @Nullable
        public final Drawable de(@Nullable Drawable drawable) {
            if (drawable == null || (drawable instanceof qw)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                Drawable.ConstantState constantState = ((LayerDrawable) drawable).mutate().getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), de(layerDrawable.getDrawable(i2)));
                }
                return layerDrawable;
            }
            Bitmap qw = qw(drawable);
            return qw != null ? new qw(qw) : drawable;
        }

        @Nullable
        public final Bitmap qw(@NotNull Drawable drawable) {
            Intrinsics.checkNotNullParameter(drawable, ResUtils.e);
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
                if (createBitmap == null) {
                    return createBitmap;
                }
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return createBitmap;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
    }

    public qw(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.qw = bitmap;
        this.f7792ad = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f7793de = height;
        this.f7794fe.set(0.0f, 0.0f, (float) this.f7792ad, (float) height);
        Paint paint = new Paint(1);
        this.f7798rg = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f7798rg.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f7799th = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f7799th.setAntiAlias(true);
        de();
    }

    public final void ad(@Nullable ImageView.ScaleType scaleType, float f, int i2, boolean z, float f2, float f3, float f4, float f5, float f6) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.ppp != scaleType) {
            this.ppp = scaleType;
        }
        this.aaa = f;
        this.qqq = i2;
        de();
        this.eee = z;
        this.ggg = f2;
        this.vvv = f3;
        this.xxx = f4;
        this.ddd = f5;
        this.nn = f6;
        rg();
        yj();
        invalidateSelf();
    }

    public final void de() {
        this.f7799th.setColor(this.qqq);
        this.f7799th.setStrokeWidth(this.aaa);
    }

    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.f332switch) {
            Bitmap bitmap = this.qw;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(this.when);
            this.f7798rg.setShader(bitmapShader);
            this.f332switch = false;
        }
        if (this.eee) {
            RectF rectF = this.f7800uk;
            float width = (this.f7800uk.width() / 2.0f) + rectF.left;
            RectF rectF2 = this.f7800uk;
            canvas.drawCircle(width, (rectF.height() / 2.0f) + rectF2.top, Math.min((float) Math.min(this.f7793de, this.f7792ad), Math.min(rectF2.width() / 2.0f, this.f7800uk.height() / 2.0f)), this.f7798rg);
            if (this.aaa > 0.0f) {
                RectF rectF3 = this.f7801yj;
                float width2 = (this.f7801yj.width() / 2.0f) + rectF3.left;
                RectF rectF4 = this.f7801yj;
                canvas.drawCircle(width2, (rectF3.height() / 2.0f) + rectF4.top, Math.min((float) Math.min(this.f7793de, this.f7792ad), Math.min(rectF4.width() / 2.0f, this.f7801yj.height() / 2.0f)), this.f7799th);
                return;
            }
            return;
        }
        th();
        canvas.drawPath(this.f7795i, this.f7798rg);
        if (this.aaa > 0.0f) {
            fe();
            canvas.drawPath(this.f7795i, this.f7799th);
        }
    }

    public final void fe() {
        this.f7795i.reset();
        this.f7795i.addRoundRect(this.f7801yj, this.mmm, Path.Direction.CCW);
    }

    public int getOpacity() {
        return -3;
    }

    public void onBoundsChange(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "bounds");
        super.onBoundsChange(rect);
        this.f331if.set(rect);
        yj();
        rg();
    }

    public final Matrix.ScaleToFit qw(ImageView.ScaleType scaleType) {
        int i2 = ad.$EnumSwitchMapping$0[scaleType.ordinal()];
        if (i2 == 4) {
            return Matrix.ScaleToFit.CENTER;
        }
        if (i2 == 5) {
            return Matrix.ScaleToFit.END;
        }
        if (i2 == 6) {
            return Matrix.ScaleToFit.START;
        }
        if (i2 != 7) {
            return Matrix.ScaleToFit.CENTER;
        }
        return Matrix.ScaleToFit.FILL;
    }

    public final void rg() {
        float f = this.ggg;
        if (f >= 0.0f) {
            int length = this.mmm.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mmm[i2] = this.ggg;
            }
        } else if (f < 0.0f) {
            float[] fArr = this.mmm;
            float f2 = this.vvv;
            fArr[0] = f2;
            fArr[1] = f2;
            float f3 = this.xxx;
            fArr[2] = f3;
            fArr[3] = f3;
            float f4 = this.nn;
            fArr[4] = f4;
            fArr[5] = f4;
            float f5 = this.ddd;
            fArr[6] = f5;
            fArr[7] = f5;
        }
    }

    public void setAlpha(int i2) {
        this.f7798rg.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f7798rg.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void th() {
        this.f7795i.reset();
        this.f7795i.addRoundRect(this.f7800uk, this.mmm, Path.Direction.CCW);
    }

    public final void yj() {
        float f;
        float f2;
        float f3;
        int i2;
        float f4;
        float f5;
        float f6;
        float f7 = this.aaa / 2.0f;
        this.f7797pf.set(this.f331if);
        float f8 = 0.0f;
        switch (ad.$EnumSwitchMapping$0[this.ppp.ordinal()]) {
            case 1:
                if (((float) this.f7792ad) > this.f7797pf.width() || ((float) this.f7793de) > this.f7797pf.height()) {
                    f3 = Math.min(this.f7797pf.width() / ((float) this.f7792ad), this.f7797pf.height() / ((float) this.f7793de));
                    if (this.f7797pf.height() < this.f7797pf.width()) {
                        f2 = this.f7797pf.height();
                        i2 = this.f7792ad;
                    } else if (this.f7797pf.height() > this.f7797pf.width()) {
                        f2 = ((float) this.f7793de) * f3;
                        f = this.f7797pf.width();
                    } else {
                        f2 = ((float) this.f7793de) * f3;
                        i2 = this.f7792ad;
                    }
                    f = ((float) i2) * f3;
                } else {
                    f3 = 1.0f;
                    f2 = (float) this.f7793de;
                    f = (float) this.f7792ad;
                }
                float width = ((this.f7797pf.width() - (((float) this.f7792ad) * f3)) * 0.5f) + 0.5f;
                float height = ((this.f7797pf.height() - (((float) this.f7793de) * f3)) * 0.5f) + 0.5f;
                RectF rectF = new RectF(width, height, f + width, f2 + height);
                this.f7796o = rectF;
                rectF.inset(this.eee ? this.aaa : f7, this.eee ? this.aaa : f7);
                this.when.reset();
                this.when.setScale(f3, f3);
                this.when.postTranslate(width, height);
                break;
            case 2:
                float min = Math.min(this.f7797pf.height(), this.f7794fe.height());
                float min2 = Math.min(this.f7797pf.width(), this.f7794fe.width());
                float height2 = (this.f7797pf.height() - this.f7794fe.height()) / 2.0f;
                float width2 = (this.f7797pf.width() - this.f7794fe.width()) / 2.0f;
                float f9 = height2 > 0.0f ? height2 : 0.0f;
                if (width2 > 0.0f) {
                    f8 = width2;
                }
                RectF rectF2 = new RectF(f8, f9, min2 + f8, min + f9);
                this.f7796o = rectF2;
                rectF2.inset(this.eee ? this.aaa : f7, this.eee ? this.aaa : f7);
                this.when.reset();
                this.when.postTranslate(((float) ((int) (width2 + 0.5f))) + f7, ((float) ((int) (height2 + 0.5f))) + f7);
                break;
            case 3:
                this.f7796o.set(this.f7797pf);
                this.f7796o.inset(this.eee ? this.aaa : f7, this.eee ? this.aaa : f7);
                if (((float) this.f7792ad) * this.f7796o.height() > this.f7796o.width() * ((float) this.f7793de)) {
                    f5 = this.f7796o.height() / ((float) this.f7793de);
                    f8 = (this.f7796o.width() - (((float) this.f7792ad) * f5)) * 0.5f;
                    f4 = 0.0f;
                } else {
                    f5 = this.f7796o.width() / ((float) this.f7792ad);
                    f4 = (this.f7796o.height() - (((float) this.f7793de) * f5)) * 0.5f;
                }
                this.when.reset();
                this.when.setScale(f5, f5);
                this.when.postTranslate(((float) ((int) (f8 + 0.5f))) + f7, ((float) ((int) (f4 + 0.5f))) + f7);
                break;
            case 4:
            case 5:
            case 6:
                this.f7797pf.inset(this.eee ? this.aaa : f7, this.eee ? this.aaa : f7);
                this.f7796o.set(this.f7794fe);
                this.when.setRectToRect(this.f7794fe, this.f7797pf, qw(this.ppp));
                this.when.mapRect(this.f7796o);
                this.when.setRectToRect(this.f7794fe, this.f7796o, Matrix.ScaleToFit.FILL);
                break;
            case 7:
                this.f7797pf.inset(this.eee ? this.aaa : f7, this.eee ? this.aaa : f7);
                this.f7796o.set(this.f7797pf);
                this.when.reset();
                this.when.setRectToRect(this.f7794fe, this.f7796o, Matrix.ScaleToFit.FILL);
                break;
            default:
                RectF rectF3 = this.f7797pf;
                if (this.eee) {
                    f6 = this.aaa;
                } else {
                    f6 = f7;
                }
                rectF3.inset(f6, this.eee ? this.aaa : f7);
                this.f7796o.set(this.f7794fe);
                this.when.setRectToRect(this.f7794fe, this.f7797pf, qw(this.ppp));
                this.when.mapRect(this.f7796o);
                this.when.setRectToRect(this.f7794fe, this.f7796o, Matrix.ScaleToFit.FILL);
                break;
        }
        if (this.eee) {
            RectF rectF4 = this.f7801yj;
            RectF rectF5 = this.f7796o;
            rectF4.set(rectF5.left - f7, rectF5.top - f7, rectF5.right + f7, rectF5.bottom + f7);
        } else {
            this.f7801yj.set(this.f331if);
            this.f7801yj.inset(f7, f7);
        }
        this.f7800uk.set(this.f7796o);
        this.f332switch = true;
    }
}
