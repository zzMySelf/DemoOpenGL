package com.dxmbumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.dxmbumptech.glide.Glide;
import com.dxmbumptech.glide.gifdecoder.GifDecoder;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.dxmbumptech.glide.request.transition.Transition;
import fe.uk.qw.th;
import fe.uk.qw.vvv.i;
import fe.uk.qw.vvv.o;
import fe.uk.qw.yj;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class GifFrameLoader {

    /* renamed from: ad  reason: collision with root package name */
    public final Handler f3917ad;
    public int ddd;

    /* renamed from: de  reason: collision with root package name */
    public final List<FrameCallback> f3918de;

    /* renamed from: fe  reason: collision with root package name */
    public final yj f3919fe;
    @Nullable
    public de ggg;

    /* renamed from: i  reason: collision with root package name */
    public th<Bitmap> f3920i;

    /* renamed from: if  reason: not valid java name */
    public qw f151if;

    /* renamed from: o  reason: collision with root package name */
    public qw f3921o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f3922pf;
    public qw ppp;
    public final GifDecoder qw;

    /* renamed from: rg  reason: collision with root package name */
    public final BitmapPool f3923rg;

    /* renamed from: switch  reason: not valid java name */
    public Bitmap f152switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f3924th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f3925uk;
    public int vvv;
    public Transformation<Bitmap> when;
    public int xxx;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f3926yj;

    public interface FrameCallback {
        void onFrameReady();
    }

    public class ad implements Handler.Callback {
        public ad() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                GifFrameLoader.this.ppp((qw) message.obj);
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                GifFrameLoader.this.f3919fe.pf((qw) message.obj);
                return false;
            }
        }
    }

    @VisibleForTesting
    public interface de {
        void onFrameReady();
    }

    @VisibleForTesting
    public static class qw extends fe.uk.qw.ppp.rg.de<Bitmap> {

        /* renamed from: i  reason: collision with root package name */
        public final int f3927i;

        /* renamed from: o  reason: collision with root package name */
        public final long f3928o;

        /* renamed from: pf  reason: collision with root package name */
        public Bitmap f3929pf;

        /* renamed from: uk  reason: collision with root package name */
        public final Handler f3930uk;

        public qw(Handler handler, int i2, long j) {
            this.f3930uk = handler;
            this.f3927i = i2;
            this.f3928o = j;
        }

        public void ad(@Nullable Drawable drawable) {
            this.f3929pf = null;
        }

        /* renamed from: i */
        public void fe(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            this.f3929pf = bitmap;
            this.f3930uk.sendMessageAtTime(this.f3930uk.obtainMessage(1, this), this.f3928o);
        }

        public Bitmap uk() {
            return this.f3929pf;
        }
    }

    public GifFrameLoader(Glide glide, GifDecoder gifDecoder, int i2, int i3, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(glide.th(), Glide.nn(glide.uk()), gifDecoder, (Handler) null, pf(Glide.nn(glide.uk()), i2, i3), transformation, bitmap);
    }

    public static th<Bitmap> pf(yj yjVar, int i2, int i3) {
        return yjVar.i().ad(((fe.uk.qw.ppp.de) ((fe.uk.qw.ppp.de) fe.uk.qw.ppp.de.I(fe.uk.qw.pf.fe.yj.qw).G(true)).B(true)).s(i2, i3));
    }

    public static Key yj() {
        return new fe.uk.qw.ggg.ad(Double.valueOf(Math.random()));
    }

    public void aaa(FrameCallback frameCallback) {
        this.f3918de.remove(frameCallback);
        if (this.f3918de.isEmpty()) {
            nn();
        }
    }

    public ByteBuffer ad() {
        return this.qw.getData().asReadOnlyBuffer();
    }

    public final void ddd() {
        if (!this.f3924th) {
            this.f3924th = true;
            this.f3922pf = false;
            when();
        }
    }

    public Bitmap de() {
        qw qwVar = this.f3921o;
        return qwVar != null ? qwVar.uk() : this.f152switch;
    }

    public int fe() {
        qw qwVar = this.f3921o;
        if (qwVar != null) {
            return qwVar.f3927i;
        }
        return -1;
    }

    public final void ggg() {
        Bitmap bitmap = this.f152switch;
        if (bitmap != null) {
            this.f3923rg.de(bitmap);
            this.f152switch = null;
        }
    }

    public int i() {
        return this.ddd;
    }

    /* renamed from: if  reason: not valid java name */
    public int m265if() {
        return this.qw.uk() + this.vvv;
    }

    public void mmm(FrameCallback frameCallback) {
        if (this.f3922pf) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f3918de.contains(frameCallback)) {
            boolean isEmpty = this.f3918de.isEmpty();
            this.f3918de.add(frameCallback);
            if (isEmpty) {
                ddd();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    public final void nn() {
        this.f3924th = false;
    }

    public int o() {
        return this.qw.i();
    }

    @VisibleForTesting
    public void ppp(qw qwVar) {
        de deVar = this.ggg;
        if (deVar != null) {
            deVar.onFrameReady();
        }
        this.f3926yj = false;
        if (this.f3922pf) {
            this.f3917ad.obtainMessage(2, qwVar).sendToTarget();
        } else if (this.f3924th) {
            if (qwVar.uk() != null) {
                ggg();
                qw qwVar2 = this.f3921o;
                this.f3921o = qwVar;
                for (int size = this.f3918de.size() - 1; size >= 0; size--) {
                    this.f3918de.get(size).onFrameReady();
                }
                if (qwVar2 != null) {
                    this.f3917ad.obtainMessage(2, qwVar2).sendToTarget();
                }
            }
            when();
        } else if (this.f3925uk) {
            this.f3917ad.obtainMessage(2, qwVar).sendToTarget();
        } else {
            this.ppp = qwVar;
        }
    }

    public void qw() {
        this.f3918de.clear();
        ggg();
        nn();
        qw qwVar = this.f3921o;
        if (qwVar != null) {
            this.f3919fe.pf(qwVar);
            this.f3921o = null;
        }
        qw qwVar2 = this.f151if;
        if (qwVar2 != null) {
            this.f3919fe.pf(qwVar2);
            this.f151if = null;
        }
        qw qwVar3 = this.ppp;
        if (qwVar3 != null) {
            this.f3919fe.pf(qwVar3);
            this.ppp = null;
        }
        this.qw.clear();
        this.f3922pf = true;
    }

    public Bitmap rg() {
        return this.f152switch;
    }

    /* renamed from: switch  reason: not valid java name */
    public int m266switch() {
        return this.xxx;
    }

    public int th() {
        return this.qw.de();
    }

    public Transformation<Bitmap> uk() {
        return this.when;
    }

    public void vvv(Transformation<Bitmap> transformation, Bitmap bitmap) {
        i.fe(transformation);
        this.when = transformation;
        i.fe(bitmap);
        this.f152switch = bitmap;
        this.f3920i = this.f3920i.ad(new fe.uk.qw.ppp.de().C(transformation));
        this.vvv = o.yj(bitmap);
        this.xxx = bitmap.getWidth();
        this.ddd = bitmap.getHeight();
    }

    public final void when() {
        if (this.f3924th && !this.f3926yj) {
            if (this.f3925uk) {
                i.qw(this.ppp == null, "Pending target must be null when starting from the first frame");
                this.qw.th();
                this.f3925uk = false;
            }
            qw qwVar = this.ppp;
            if (qwVar != null) {
                this.ppp = null;
                ppp(qwVar);
                return;
            }
            this.f3926yj = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.qw.rg());
            this.qw.ad();
            this.f151if = new qw(this.f3917ad, this.qw.yj(), uptimeMillis);
            this.f3920i.ad(fe.uk.qw.ppp.de.J(yj())).V(this.qw).P(this.f151if);
        }
    }

    public void xxx() {
        i.qw(!this.f3924th, "Can't restart a running animation");
        this.f3925uk = true;
        qw qwVar = this.ppp;
        if (qwVar != null) {
            this.f3919fe.pf(qwVar);
            this.ppp = null;
        }
    }

    public GifFrameLoader(BitmapPool bitmapPool, yj yjVar, GifDecoder gifDecoder, Handler handler, th<Bitmap> thVar, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f3918de = new ArrayList();
        this.f3919fe = yjVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new ad()) : handler;
        this.f3923rg = bitmapPool;
        this.f3917ad = handler;
        this.f3920i = thVar;
        this.qw = gifDecoder;
        vvv(transformation, bitmap);
    }
}
