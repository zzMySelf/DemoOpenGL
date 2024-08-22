package fe.rg.qw.o.th.yj;

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
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import fe.rg.qw.ad;
import fe.rg.qw.ggg.uk;
import java.nio.ByteBuffer;

public class de extends Drawable implements GifFrameLoader.FrameCallback, Animatable {

    /* renamed from: ad  reason: collision with root package name */
    public final qw f4993ad;

    /* renamed from: i  reason: collision with root package name */
    public boolean f4994i;

    /* renamed from: if  reason: not valid java name */
    public boolean f188if;

    /* renamed from: o  reason: collision with root package name */
    public int f4995o;

    /* renamed from: pf  reason: collision with root package name */
    public int f4996pf;

    /* renamed from: switch  reason: not valid java name */
    public Paint f189switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f4997th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f4998uk;
    public Rect when;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f4999yj;

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
            return new de(this);
        }
    }

    public de(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(new qw(new GifFrameLoader(ad.de(context), gifDecoder, i2, i3, transformation, bitmap)));
    }

    public ByteBuffer ad() {
        return this.f4993ad.qw.ad();
    }

    public final Rect de() {
        if (this.when == null) {
            this.when = new Rect();
        }
        return this.when;
    }

    public void draw(@NonNull Canvas canvas) {
        if (!this.f4998uk) {
            if (this.f188if) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), de());
                this.f188if = false;
            }
            canvas.drawBitmap(this.f4993ad.qw.de(), (Rect) null, de(), yj());
        }
    }

    public Bitmap fe() {
        return this.f4993ad.qw.rg();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f4993ad;
    }

    public int getIntrinsicHeight() {
        return this.f4993ad.qw.i();
    }

    public int getIntrinsicWidth() {
        return this.f4993ad.qw.m251if();
    }

    public int getOpacity() {
        return -2;
    }

    public void i() {
        this.f4998uk = true;
        this.f4993ad.qw.qw();
    }

    /* renamed from: if  reason: not valid java name */
    public final void m314if() {
        uk.qw(!this.f4998uk, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f4993ad.qw.th() == 1) {
            invalidateSelf();
        } else if (!this.f4997th) {
            this.f4997th = true;
            this.f4993ad.qw.ddd(this);
            invalidateSelf();
        }
    }

    public boolean isRunning() {
        return this.f4997th;
    }

    public final void o() {
        this.f4995o = 0;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f188if = true;
    }

    public void onFrameReady() {
        if (qw() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (th() == rg() - 1) {
            this.f4995o++;
        }
        int i2 = this.f4996pf;
        if (i2 != -1 && this.f4995o >= i2) {
            stop();
        }
    }

    public void pf(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f4993ad.qw.ggg(transformation, bitmap);
    }

    public final Drawable.Callback qw() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public int rg() {
        return this.f4993ad.qw.th();
    }

    public void setAlpha(int i2) {
        yj().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        yj().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        uk.qw(!this.f4998uk, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f4994i = z;
        if (!z) {
            m315switch();
        } else if (this.f4999yj) {
            m314if();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f4999yj = true;
        o();
        if (this.f4994i) {
            m314if();
        }
    }

    public void stop() {
        this.f4999yj = false;
        m315switch();
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m315switch() {
        this.f4997th = false;
        this.f4993ad.qw.nn(this);
    }

    public int th() {
        return this.f4993ad.qw.fe();
    }

    public int uk() {
        return this.f4993ad.qw.pf();
    }

    public final Paint yj() {
        if (this.f189switch == null) {
            this.f189switch = new Paint(2);
        }
        return this.f189switch;
    }

    public de(qw qwVar) {
        this.f4994i = true;
        this.f4996pf = -1;
        uk.fe(qwVar);
        this.f4993ad = qwVar;
    }
}
