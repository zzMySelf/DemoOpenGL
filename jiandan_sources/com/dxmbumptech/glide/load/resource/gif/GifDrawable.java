package com.dxmbumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.gifdecoder.GifDecoder;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dxmbumptech.glide.load.resource.gif.GifFrameLoader;
import fe.uk.qw.vvv.i;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable, Animatable2Compat {
    public static final int LOOP_FOREVER = -1;
    public static final int LOOP_INTRINSIC = 0;

    /* renamed from: ad  reason: collision with root package name */
    public final qw f3910ad;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3911i;

    /* renamed from: if  reason: not valid java name */
    public boolean f149if;

    /* renamed from: o  reason: collision with root package name */
    public int f3912o;

    /* renamed from: pf  reason: collision with root package name */
    public int f3913pf;
    public List<Animatable2Compat.AnimationCallback> ppp;

    /* renamed from: switch  reason: not valid java name */
    public Paint f150switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f3914th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f3915uk;
    public Rect when;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f3916yj;

    public static final class qw extends Drawable.ConstantState {
        @VisibleForTesting
        public final GifFrameLoader qw;

        public qw(GifFrameLoader gifFrameLoader) {
            this.qw = gifFrameLoader;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @NonNull
        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    @Deprecated
    public GifDrawable(Context context, GifDecoder gifDecoder, BitmapPool bitmapPool, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(context, gifDecoder, transformation, i2, i3, bitmap);
    }

    public final Rect ad() {
        if (this.when == null) {
            this.when = new Rect();
        }
        return this.when;
    }

    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.ppp;
        if (list != null) {
            list.clear();
        }
    }

    public final Paint de() {
        if (this.f150switch == null) {
            this.f150switch = new Paint(2);
        }
        return this.f150switch;
    }

    public void draw(@NonNull Canvas canvas) {
        if (!this.f3915uk) {
            if (this.f149if) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), ad());
                this.f149if = false;
            }
            canvas.drawBitmap(this.f3910ad.qw.de(), (Rect) null, ad(), de());
        }
    }

    public final void fe() {
        List<Animatable2Compat.AnimationCallback> list = this.ppp;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.ppp.get(i2).onAnimationEnd(this);
            }
        }
    }

    public ByteBuffer getBuffer() {
        return this.f3910ad.qw.ad();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f3910ad;
    }

    public Bitmap getFirstFrame() {
        return this.f3910ad.qw.rg();
    }

    public int getFrameCount() {
        return this.f3910ad.qw.th();
    }

    public int getFrameIndex() {
        return this.f3910ad.qw.fe();
    }

    public Transformation<Bitmap> getFrameTransformation() {
        return this.f3910ad.qw.uk();
    }

    public int getIntrinsicHeight() {
        return this.f3910ad.qw.i();
    }

    public int getIntrinsicWidth() {
        return this.f3910ad.qw.m266switch();
    }

    public int getOpacity() {
        return -2;
    }

    public int getSize() {
        return this.f3910ad.qw.m265if();
    }

    public boolean isRunning() {
        return this.f3914th;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f149if = true;
    }

    public void onFrameReady() {
        if (qw() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (getFrameIndex() == getFrameCount() - 1) {
            this.f3912o++;
        }
        int i2 = this.f3913pf;
        if (i2 != -1 && this.f3912o >= i2) {
            fe();
            stop();
        }
    }

    public final Drawable.Callback qw() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public void recycle() {
        this.f3915uk = true;
        this.f3910ad.qw.qw();
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback != null) {
            if (this.ppp == null) {
                this.ppp = new ArrayList();
            }
            this.ppp.add(animationCallback);
        }
    }

    public final void rg() {
        this.f3912o = 0;
    }

    public void setAlpha(int i2) {
        de().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        de().setColorFilter(colorFilter);
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f3910ad.qw.vvv(transformation, bitmap);
    }

    public void setLoopCount(int i2) {
        int i3 = -1;
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i2 == 0) {
            int o2 = this.f3910ad.qw.o();
            if (o2 != 0) {
                i3 = o2;
            }
            this.f3913pf = i3;
        } else {
            this.f3913pf = i2;
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        i.qw(!this.f3915uk, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f3911i = z;
        if (!z) {
            yj();
        } else if (this.f3916yj) {
            th();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f3916yj = true;
        rg();
        if (this.f3911i) {
            th();
        }
    }

    public void startFromFirstFrame() {
        i.qw(!this.f3914th, "You cannot restart a currently running animation.");
        this.f3910ad.qw.xxx();
        start();
    }

    public void stop() {
        this.f3916yj = false;
        yj();
    }

    public final void th() {
        i.qw(!this.f3915uk, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f3910ad.qw.th() == 1) {
            invalidateSelf();
        } else if (!this.f3914th) {
            this.f3914th = true;
            this.f3910ad.qw.mmm(this);
            invalidateSelf();
        }
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.ppp;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public final void yj() {
        this.f3914th = false;
        this.f3910ad.qw.aaa(this);
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(new qw(new GifFrameLoader(Glide.de(context), gifDecoder, i2, i3, transformation, bitmap)));
    }

    public GifDrawable(qw qwVar) {
        this.f3911i = true;
        this.f3913pf = -1;
        i.fe(qwVar);
        this.f3910ad = qwVar;
    }
}
