package fe.uk.qw.ppp;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.Option;
import com.dxmbumptech.glide.load.Transformation;
import com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.dxmbumptech.glide.util.CachedHashCodeArrayMap;
import fe.uk.qw.pf.ad;
import fe.uk.qw.pf.fe.yj;
import fe.uk.qw.pf.th.fe.i;
import fe.uk.qw.pf.th.fe.when;
import fe.uk.qw.ppp.qw;
import fe.uk.qw.vvv.o;
import java.util.Map;

public abstract class qw<T extends qw<T>> implements Cloneable {
    @NonNull
    public Map<Class<?>, Transformation<?>> aaa = new CachedHashCodeArrayMap();

    /* renamed from: ad  reason: collision with root package name */
    public int f6017ad;
    @Nullable
    public Drawable ddd;
    public boolean e;
    public boolean eee;
    public boolean f;
    public boolean g = true;
    @NonNull
    public Key ggg = fe.uk.qw.ggg.qw.de();
    public boolean h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public Drawable f6018i;

    /* renamed from: if  reason: not valid java name */
    public int f244if;
    @NonNull
    public ad mmm = new ad();
    public int nn;

    /* renamed from: o  reason: collision with root package name */
    public int f6019o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public Drawable f6020pf;
    public int ppp = -1;
    @NonNull
    public Class<?> qqq = Object.class;
    @Nullable
    public Resources.Theme rrr;

    /* renamed from: switch  reason: not valid java name */
    public boolean f245switch = true;

    /* renamed from: th  reason: collision with root package name */
    public float f6021th = 1.0f;
    public boolean tt;
    @NonNull

    /* renamed from: uk  reason: collision with root package name */
    public Priority f6022uk = Priority.NORMAL;
    public boolean vvv;
    public int when = -1;
    public boolean xxx = true;
    @NonNull

    /* renamed from: yj  reason: collision with root package name */
    public yj f6023yj = yj.f5892fe;

    public static boolean f(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    @CheckResult
    @NonNull
    public T A(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.tt) {
            return clone().A(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f6021th = f2;
        this.f6017ad |= 2;
        x();
        return this;
    }

    @CheckResult
    @NonNull
    public T B(boolean z) {
        if (this.tt) {
            return clone().B(true);
        }
        this.f245switch = !z;
        this.f6017ad |= 256;
        x();
        return this;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap>, com.dxmbumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T C(@androidx.annotation.NonNull com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 1
            fe.uk.qw.ppp.qw r2 = r1.D(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.qw.C(com.dxmbumptech.glide.load.Transformation):fe.uk.qw.ppp.qw");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap>, com.dxmbumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T D(@androidx.annotation.NonNull com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap> r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = r2.tt
            if (r0 == 0) goto L_0x000d
            fe.uk.qw.ppp.qw r0 = r2.clone()
            fe.uk.qw.ppp.qw r3 = r0.D(r3, r4)
            return r3
        L_0x000d:
            fe.uk.qw.pf.th.fe.if r0 = new fe.uk.qw.pf.th.fe.if
            r0.<init>(r3, r4)
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            r2.F(r1, r3, r4)
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            r2.F(r1, r0, r4)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r1 = android.graphics.drawable.BitmapDrawable.class
            r0.de()
            r2.F(r1, r0, r4)
            java.lang.Class<com.dxmbumptech.glide.load.resource.gif.GifDrawable> r0 = com.dxmbumptech.glide.load.resource.gif.GifDrawable.class
            fe.uk.qw.pf.th.uk.rg r1 = new fe.uk.qw.pf.th.uk.rg
            r1.<init>(r3)
            r2.F(r0, r1, r4)
            r2.x()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.qw.D(com.dxmbumptech.glide.load.Transformation, boolean):fe.uk.qw.ppp.qw");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap>, com.dxmbumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T E(@androidx.annotation.NonNull com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.tt
            if (r0 == 0) goto L_0x000d
            fe.uk.qw.ppp.qw r0 = r1.clone()
            fe.uk.qw.ppp.qw r2 = r0.E(r2, r3)
            return r2
        L_0x000d:
            r1.yj(r2)
            fe.uk.qw.ppp.qw r2 = r1.C(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.qw.E(com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy, com.dxmbumptech.glide.load.Transformation):fe.uk.qw.ppp.qw");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.dxmbumptech.glide.load.Transformation<Y>, java.lang.Object, com.dxmbumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T F(@androidx.annotation.NonNull java.lang.Class<Y> r2, @androidx.annotation.NonNull com.dxmbumptech.glide.load.Transformation<Y> r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = r1.tt
            if (r0 == 0) goto L_0x000d
            fe.uk.qw.ppp.qw r0 = r1.clone()
            fe.uk.qw.ppp.qw r2 = r0.F(r2, r3, r4)
            return r2
        L_0x000d:
            fe.uk.qw.vvv.i.fe(r2)
            fe.uk.qw.vvv.i.fe(r3)
            java.util.Map<java.lang.Class<?>, com.dxmbumptech.glide.load.Transformation<?>> r0 = r1.aaa
            r0.put(r2, r3)
            int r2 = r1.f6017ad
            r2 = r2 | 2048(0x800, float:2.87E-42)
            r1.f6017ad = r2
            r3 = 1
            r1.xxx = r3
            r0 = 65536(0x10000, float:9.18355E-41)
            r2 = r2 | r0
            r1.f6017ad = r2
            r0 = 0
            r1.g = r0
            if (r4 == 0) goto L_0x0032
            r4 = 131072(0x20000, float:1.83671E-40)
            r2 = r2 | r4
            r1.f6017ad = r2
            r1.vvv = r3
        L_0x0032:
            r1.x()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.qw.F(java.lang.Class, com.dxmbumptech.glide.load.Transformation, boolean):fe.uk.qw.ppp.qw");
    }

    @CheckResult
    @NonNull
    public T G(boolean z) {
        if (this.tt) {
            return clone().G(z);
        }
        this.h = z;
        this.f6017ad |= 1048576;
        x();
        return this;
    }

    public final boolean a() {
        return this.tt;
    }

    public final float aaa() {
        return this.f6021th;
    }

    @CheckResult
    @NonNull
    public T ad(@NonNull qw<?> qwVar) {
        if (this.tt) {
            return clone().ad(qwVar);
        }
        if (f(qwVar.f6017ad, 2)) {
            this.f6021th = qwVar.f6021th;
        }
        if (f(qwVar.f6017ad, 262144)) {
            this.e = qwVar.e;
        }
        if (f(qwVar.f6017ad, 1048576)) {
            this.h = qwVar.h;
        }
        if (f(qwVar.f6017ad, 4)) {
            this.f6023yj = qwVar.f6023yj;
        }
        if (f(qwVar.f6017ad, 8)) {
            this.f6022uk = qwVar.f6022uk;
        }
        if (f(qwVar.f6017ad, 16)) {
            this.f6018i = qwVar.f6018i;
            this.f6019o = 0;
            this.f6017ad &= -33;
        }
        if (f(qwVar.f6017ad, 32)) {
            this.f6019o = qwVar.f6019o;
            this.f6018i = null;
            this.f6017ad &= -17;
        }
        if (f(qwVar.f6017ad, 64)) {
            this.f6020pf = qwVar.f6020pf;
            this.f244if = 0;
            this.f6017ad &= -129;
        }
        if (f(qwVar.f6017ad, 128)) {
            this.f244if = qwVar.f244if;
            this.f6020pf = null;
            this.f6017ad &= -65;
        }
        if (f(qwVar.f6017ad, 256)) {
            this.f245switch = qwVar.f245switch;
        }
        if (f(qwVar.f6017ad, 512)) {
            this.ppp = qwVar.ppp;
            this.when = qwVar.when;
        }
        if (f(qwVar.f6017ad, 1024)) {
            this.ggg = qwVar.ggg;
        }
        if (f(qwVar.f6017ad, 4096)) {
            this.qqq = qwVar.qqq;
        }
        if (f(qwVar.f6017ad, 8192)) {
            this.ddd = qwVar.ddd;
            this.nn = 0;
            this.f6017ad &= -16385;
        }
        if (f(qwVar.f6017ad, 16384)) {
            this.nn = qwVar.nn;
            this.ddd = null;
            this.f6017ad &= -8193;
        }
        if (f(qwVar.f6017ad, 32768)) {
            this.rrr = qwVar.rrr;
        }
        if (f(qwVar.f6017ad, 65536)) {
            this.xxx = qwVar.xxx;
        }
        if (f(qwVar.f6017ad, 131072)) {
            this.vvv = qwVar.vvv;
        }
        if (f(qwVar.f6017ad, 2048)) {
            this.aaa.putAll(qwVar.aaa);
            this.g = qwVar.g;
        }
        if (f(qwVar.f6017ad, 524288)) {
            this.f = qwVar.f;
        }
        if (!this.xxx) {
            this.aaa.clear();
            int i2 = this.f6017ad & -2049;
            this.f6017ad = i2;
            this.vvv = false;
            this.f6017ad = i2 & -131073;
            this.g = true;
        }
        this.f6017ad |= qwVar.f6017ad;
        this.mmm.fe(qwVar.mmm);
        x();
        return this;
    }

    public final boolean b() {
        return this.f245switch;
    }

    public final boolean c() {
        return e(8);
    }

    public boolean d() {
        return this.g;
    }

    @NonNull
    public final Priority ddd() {
        return this.f6022uk;
    }

    @NonNull
    public T de() {
        if (!this.eee || this.tt) {
            this.tt = true;
            l();
            return this;
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public final boolean e(int i2) {
        return f(this.f6017ad, i2);
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> eee() {
        return this.aaa;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        if (Float.compare(qwVar.f6021th, this.f6021th) == 0 && this.f6019o == qwVar.f6019o && o.de(this.f6018i, qwVar.f6018i) && this.f244if == qwVar.f244if && o.de(this.f6020pf, qwVar.f6020pf) && this.nn == qwVar.nn && o.de(this.ddd, qwVar.ddd) && this.f245switch == qwVar.f245switch && this.when == qwVar.when && this.ppp == qwVar.ppp && this.vvv == qwVar.vvv && this.xxx == qwVar.xxx && this.e == qwVar.e && this.f == qwVar.f && this.f6023yj.equals(qwVar.f6023yj) && this.f6022uk == qwVar.f6022uk && this.mmm.equals(qwVar.mmm) && this.aaa.equals(qwVar.aaa) && this.qqq.equals(qwVar.qqq) && o.de(this.ggg, qwVar.ggg) && o.de(this.rrr, qwVar.rrr)) {
            return true;
        }
        return false;
    }

    @CheckResult
    /* renamed from: fe */
    public T clone() {
        try {
            T t = (qw) super.clone();
            ad adVar = new ad();
            t.mmm = adVar;
            adVar.fe(this.mmm);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.aaa = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.aaa);
            t.eee = false;
            t.tt = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final boolean g() {
        return this.xxx;
    }

    public final int ggg() {
        return this.ppp;
    }

    public final boolean h() {
        return this.vvv;
    }

    public int hashCode() {
        return o.when(this.rrr, o.when(this.ggg, o.when(this.qqq, o.when(this.aaa, o.when(this.mmm, o.when(this.f6022uk, o.when(this.f6023yj, o.ppp(this.f, o.ppp(this.e, o.ppp(this.xxx, o.ppp(this.vvv, o.m391switch(this.ppp, o.m391switch(this.when, o.ppp(this.f245switch, o.when(this.ddd, o.m391switch(this.nn, o.when(this.f6020pf, o.m391switch(this.f244if, o.when(this.f6018i, o.m391switch(this.f6019o, o.pf(this.f6021th)))))))))))))))))))));
    }

    public final int i() {
        return this.f6019o;
    }

    /* renamed from: if  reason: not valid java name */
    public final int m386if() {
        return this.nn;
    }

    public final boolean j() {
        return e(2048);
    }

    public final boolean k() {
        return o.ddd(this.ppp, this.when);
    }

    @NonNull
    public T l() {
        this.eee = true;
        w();
        return this;
    }

    @CheckResult
    @NonNull
    public T m() {
        return r(DownsampleStrategy.f3883de, new i());
    }

    @NonNull
    public final Key mmm() {
        return this.ggg;
    }

    @CheckResult
    @NonNull
    public T n() {
        return q(DownsampleStrategy.f3882ad, new fe.uk.qw.pf.th.fe.o());
    }

    @NonNull
    public final Class<?> nn() {
        return this.qqq;
    }

    @Nullable
    public final Drawable o() {
        return this.f6018i;
    }

    @CheckResult
    @NonNull
    public T p() {
        return q(DownsampleStrategy.qw, new when());
    }

    @Nullable
    public final Drawable pf() {
        return this.ddd;
    }

    public final int ppp() {
        return this.when;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap>, com.dxmbumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T q(@androidx.annotation.NonNull com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 0
            fe.uk.qw.ppp.qw r2 = r1.v(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.qw.q(com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy, com.dxmbumptech.glide.load.Transformation):fe.uk.qw.ppp.qw");
    }

    @Nullable
    public final Resources.Theme qqq() {
        return this.rrr;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap>, com.dxmbumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T r(@androidx.annotation.NonNull com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.tt
            if (r0 == 0) goto L_0x000d
            fe.uk.qw.ppp.qw r0 = r1.clone()
            fe.uk.qw.ppp.qw r2 = r0.r(r2, r3)
            return r2
        L_0x000d:
            r1.yj(r2)
            r2 = 0
            fe.uk.qw.ppp.qw r2 = r1.D(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.qw.r(com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy, com.dxmbumptech.glide.load.Transformation):fe.uk.qw.ppp.qw");
    }

    @CheckResult
    @NonNull
    public T rg(@NonNull Class<?> cls) {
        if (this.tt) {
            return clone().rg(cls);
        }
        fe.uk.qw.vvv.i.fe(cls);
        this.qqq = cls;
        this.f6017ad |= 4096;
        x();
        return this;
    }

    public final boolean rrr() {
        return this.h;
    }

    @CheckResult
    @NonNull
    public T s(int i2, int i3) {
        if (this.tt) {
            return clone().s(i2, i3);
        }
        this.ppp = i2;
        this.when = i3;
        this.f6017ad |= 512;
        x();
        return this;
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m387switch() {
        return this.f;
    }

    @CheckResult
    @NonNull
    public T t(@DrawableRes int i2) {
        if (this.tt) {
            return clone().t(i2);
        }
        this.f244if = i2;
        int i3 = this.f6017ad | 128;
        this.f6017ad = i3;
        this.f6020pf = null;
        this.f6017ad = i3 & -65;
        x();
        return this;
    }

    @CheckResult
    @NonNull
    public T th(@NonNull yj yjVar) {
        if (this.tt) {
            return clone().th(yjVar);
        }
        fe.uk.qw.vvv.i.fe(yjVar);
        this.f6023yj = yjVar;
        this.f6017ad |= 4;
        x();
        return this;
    }

    public final boolean tt() {
        return this.e;
    }

    @CheckResult
    @NonNull
    public T u(@NonNull Priority priority) {
        if (this.tt) {
            return clone().u(priority);
        }
        fe.uk.qw.vvv.i.fe(priority);
        this.f6022uk = priority;
        this.f6017ad |= 8;
        x();
        return this;
    }

    @NonNull
    public final yj uk() {
        return this.f6023yj;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap>, com.dxmbumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T v(@androidx.annotation.NonNull com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy r1, @androidx.annotation.NonNull com.dxmbumptech.glide.load.Transformation<android.graphics.Bitmap> r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x0007
            fe.uk.qw.ppp.qw r1 = r0.E(r1, r2)
            goto L_0x000b
        L_0x0007:
            fe.uk.qw.ppp.qw r1 = r0.r(r1, r2)
        L_0x000b:
            r2 = 1
            r1.g = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.qw.v(com.dxmbumptech.glide.load.resource.bitmap.DownsampleStrategy, com.dxmbumptech.glide.load.Transformation, boolean):fe.uk.qw.ppp.qw");
    }

    @Nullable
    public final Drawable vvv() {
        return this.f6020pf;
    }

    public final T w() {
        return this;
    }

    @NonNull
    public final ad when() {
        return this.mmm;
    }

    @NonNull
    public final T x() {
        if (!this.eee) {
            w();
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final int xxx() {
        return this.f244if;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.dxmbumptech.glide.load.Option, com.dxmbumptech.glide.load.Option<Y>, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T y(@androidx.annotation.NonNull com.dxmbumptech.glide.load.Option<Y> r2, @androidx.annotation.NonNull Y r3) {
        /*
            r1 = this;
            boolean r0 = r1.tt
            if (r0 == 0) goto L_0x000d
            fe.uk.qw.ppp.qw r0 = r1.clone()
            fe.uk.qw.ppp.qw r2 = r0.y(r2, r3)
            return r2
        L_0x000d:
            fe.uk.qw.vvv.i.fe(r2)
            fe.uk.qw.vvv.i.fe(r3)
            fe.uk.qw.pf.ad r0 = r1.mmm
            r0.rg(r2, r3)
            r1.x()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.ppp.qw.y(com.dxmbumptech.glide.load.Option, java.lang.Object):fe.uk.qw.ppp.qw");
    }

    @CheckResult
    @NonNull
    public T yj(@NonNull DownsampleStrategy downsampleStrategy) {
        Option option = DownsampleStrategy.f3886th;
        fe.uk.qw.vvv.i.fe(downsampleStrategy);
        return y(option, downsampleStrategy);
    }

    @CheckResult
    @NonNull
    public T z(@NonNull Key key) {
        if (this.tt) {
            return clone().z(key);
        }
        fe.uk.qw.vvv.i.fe(key);
        this.ggg = key;
        this.f6017ad |= 1024;
        x();
        return this;
    }
}
