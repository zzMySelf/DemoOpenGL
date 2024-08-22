package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.transition.Transition;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.fe.yj;
import fe.rg.qw.rg;
import fe.rg.qw.th;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class GifFrameLoader {

    /* renamed from: ad  reason: collision with root package name */
    public final Handler f3732ad;

    /* renamed from: de  reason: collision with root package name */
    public final List<FrameCallback> f3733de;

    /* renamed from: fe  reason: collision with root package name */
    public final th f3734fe;

    /* renamed from: i  reason: collision with root package name */
    public rg<Bitmap> f3735i;

    /* renamed from: if  reason: not valid java name */
    public qw f137if;

    /* renamed from: o  reason: collision with root package name */
    public qw f3736o;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f3737pf;
    @Nullable
    public de ppp;
    public final GifDecoder qw;

    /* renamed from: rg  reason: collision with root package name */
    public final BitmapPool f3738rg;

    /* renamed from: switch  reason: not valid java name */
    public Bitmap f138switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f3739th;

    /* renamed from: uk  reason: collision with root package name */
    public boolean f3740uk;
    public qw when;

    /* renamed from: yj  reason: collision with root package name */
    public boolean f3741yj;

    public interface FrameCallback {
        void onFrameReady();
    }

    public class ad implements Handler.Callback {
        public ad() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                GifFrameLoader.this.when((qw) message.obj);
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                GifFrameLoader.this.f3734fe.pf((qw) message.obj);
                return false;
            }
        }
    }

    @VisibleForTesting
    public interface de {
        void onFrameReady();
    }

    @VisibleForTesting
    public static class qw extends fe.rg.qw.when.fe.th<Bitmap> {

        /* renamed from: i  reason: collision with root package name */
        public final int f3742i;

        /* renamed from: o  reason: collision with root package name */
        public final long f3743o;

        /* renamed from: pf  reason: collision with root package name */
        public Bitmap f3744pf;

        /* renamed from: uk  reason: collision with root package name */
        public final Handler f3745uk;

        public qw(Handler handler, int i2, long j) {
            this.f3745uk = handler;
            this.f3742i = i2;
            this.f3743o = j;
        }

        /* renamed from: i */
        public void rg(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            this.f3744pf = bitmap;
            this.f3745uk.sendMessageAtTime(this.f3745uk.obtainMessage(1, this), this.f3743o);
        }

        public Bitmap uk() {
            return this.f3744pf;
        }
    }

    public GifFrameLoader(fe.rg.qw.ad adVar, GifDecoder gifDecoder, int i2, int i3, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this(adVar.th(), fe.rg.qw.ad.mmm(adVar.uk()), gifDecoder, (Handler) null, o(fe.rg.qw.ad.mmm(adVar.uk()), i2, i3), transformation, bitmap);
    }

    public static rg<Bitmap> o(th thVar, int i2, int i3) {
        rg<Bitmap> i4 = thVar.i();
        i4.de(fe.rg.qw.when.ad.uk(yj.qw).J(true).E(true).v(i2, i3));
        return i4;
    }

    public static Key yj() {
        return new fe.rg.qw.ppp.de(Double.valueOf(Math.random()));
    }

    public ByteBuffer ad() {
        return this.qw.getData().asReadOnlyBuffer();
    }

    public void ddd(FrameCallback frameCallback) {
        if (this.f3737pf) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f3733de.contains(frameCallback)) {
            boolean isEmpty = this.f3733de.isEmpty();
            this.f3733de.add(frameCallback);
            if (isEmpty) {
                vvv();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    public Bitmap de() {
        qw qwVar = this.f3736o;
        return qwVar != null ? qwVar.uk() : this.f138switch;
    }

    public int fe() {
        qw qwVar = this.f3736o;
        if (qwVar != null) {
            return qwVar.f3742i;
        }
        return -1;
    }

    public void ggg(Transformation<Bitmap> transformation, Bitmap bitmap) {
        uk.fe(transformation);
        Transformation transformation2 = transformation;
        uk.fe(bitmap);
        this.f138switch = bitmap;
        rg<Bitmap> rgVar = this.f3735i;
        rgVar.de(new fe.rg.qw.when.ad().F(transformation));
        this.f3735i = rgVar;
    }

    public int i() {
        return de().getHeight();
    }

    /* renamed from: if  reason: not valid java name */
    public int m251if() {
        return de().getWidth();
    }

    public void nn(FrameCallback frameCallback) {
        this.f3733de.remove(frameCallback);
        if (this.f3733de.isEmpty()) {
            xxx();
        }
    }

    public int pf() {
        return this.qw.uk() + uk();
    }

    public final void ppp() {
        Bitmap bitmap = this.f138switch;
        if (bitmap != null) {
            this.f3738rg.de(bitmap);
            this.f138switch = null;
        }
    }

    public void qw() {
        this.f3733de.clear();
        ppp();
        xxx();
        qw qwVar = this.f3736o;
        if (qwVar != null) {
            this.f3734fe.pf(qwVar);
            this.f3736o = null;
        }
        qw qwVar2 = this.f137if;
        if (qwVar2 != null) {
            this.f3734fe.pf(qwVar2);
            this.f137if = null;
        }
        qw qwVar3 = this.when;
        if (qwVar3 != null) {
            this.f3734fe.pf(qwVar3);
            this.when = null;
        }
        this.qw.clear();
        this.f3737pf = true;
    }

    public Bitmap rg() {
        return this.f138switch;
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m252switch() {
        if (this.f3739th && !this.f3741yj) {
            if (this.f3740uk) {
                uk.qw(this.when == null, "Pending target must be null when starting from the first frame");
                this.qw.th();
                this.f3740uk = false;
            }
            qw qwVar = this.when;
            if (qwVar != null) {
                this.when = null;
                when(qwVar);
                return;
            }
            this.f3741yj = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.qw.rg());
            this.qw.ad();
            this.f137if = new qw(this.f3732ad, this.qw.yj(), uptimeMillis);
            rg<Bitmap> rgVar = this.f3735i;
            rgVar.de(fe.rg.qw.when.ad.C(yj()));
            rgVar.ddd(this.qw);
            rgVar.o(this.f137if);
        }
    }

    public int th() {
        return this.qw.de();
    }

    public final int uk() {
        return i.th(de().getWidth(), de().getHeight(), de().getConfig());
    }

    public final void vvv() {
        if (!this.f3739th) {
            this.f3739th = true;
            this.f3737pf = false;
            m252switch();
        }
    }

    @VisibleForTesting
    public void when(qw qwVar) {
        de deVar = this.ppp;
        if (deVar != null) {
            deVar.onFrameReady();
        }
        this.f3741yj = false;
        if (this.f3737pf) {
            this.f3732ad.obtainMessage(2, qwVar).sendToTarget();
        } else if (!this.f3739th) {
            this.when = qwVar;
        } else {
            if (qwVar.uk() != null) {
                ppp();
                qw qwVar2 = this.f3736o;
                this.f3736o = qwVar;
                for (int size = this.f3733de.size() - 1; size >= 0; size--) {
                    this.f3733de.get(size).onFrameReady();
                }
                if (qwVar2 != null) {
                    this.f3732ad.obtainMessage(2, qwVar2).sendToTarget();
                }
            }
            m252switch();
        }
    }

    public final void xxx() {
        this.f3739th = false;
    }

    public GifFrameLoader(BitmapPool bitmapPool, th thVar, GifDecoder gifDecoder, Handler handler, rg<Bitmap> rgVar, Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f3733de = new ArrayList();
        this.f3734fe = thVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new ad()) : handler;
        this.f3738rg = bitmapPool;
        this.f3732ad = handler;
        this.f3735i = rgVar;
        this.qw = gifDecoder;
        ggg(transformation, bitmap);
    }
}
