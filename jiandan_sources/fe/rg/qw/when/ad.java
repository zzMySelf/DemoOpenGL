package fe.rg.qw.when;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import fe.rg.qw.ggg.i;
import fe.rg.qw.ggg.uk;
import fe.rg.qw.o.fe.yj;
import fe.rg.qw.o.th.de.Cswitch;
import fe.rg.qw.o.th.de.pf;
import fe.rg.qw.o.th.yj.de;
import fe.rg.qw.o.th.yj.th;
import java.util.Map;

public class ad implements Cloneable {
    @NonNull
    public Map<Class<?>, Transformation<?>> aaa = new CachedHashCodeArrayMap();

    /* renamed from: ad  reason: collision with root package name */
    public int f5073ad;
    @Nullable
    public Drawable ddd;
    public boolean e;
    public boolean eee;
    public boolean f;
    public boolean g = true;
    @NonNull
    public Key ggg = fe.rg.qw.ppp.ad.de();
    public boolean h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public Drawable f5074i;

    /* renamed from: if  reason: not valid java name */
    public int f196if;
    @NonNull
    public fe.rg.qw.o.ad mmm = new fe.rg.qw.o.ad();
    public int nn;

    /* renamed from: o  reason: collision with root package name */
    public int f5075o;
    @Nullable

    /* renamed from: pf  reason: collision with root package name */
    public Drawable f5076pf;
    public int ppp = -1;
    @NonNull
    public Class<?> qqq = Object.class;
    @Nullable
    public Resources.Theme rrr;

    /* renamed from: switch  reason: not valid java name */
    public boolean f197switch = true;

    /* renamed from: th  reason: collision with root package name */
    public float f5077th = 1.0f;
    public boolean tt;
    @NonNull

    /* renamed from: uk  reason: collision with root package name */
    public Priority f5078uk = Priority.NORMAL;
    public boolean vvv;
    public int when = -1;
    public boolean xxx = true;
    @NonNull

    /* renamed from: yj  reason: collision with root package name */
    public yj f5079yj = yj.f4915de;

    @CheckResult
    @NonNull
    public static ad C(@NonNull Key key) {
        return new ad().B(key);
    }

    public static boolean j(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    @CheckResult
    @NonNull
    public static ad th(@NonNull Class<?> cls) {
        return new ad().rg(cls);
    }

    @CheckResult
    @NonNull
    public static ad uk(@NonNull yj yjVar) {
        return new ad().yj(yjVar);
    }

    @CheckResult
    @NonNull
    public <T> ad A(@NonNull Option<T> option, @NonNull T t) {
        if (this.tt) {
            return clone().A(option, t);
        }
        uk.fe(option);
        uk.fe(t);
        this.mmm.rg(option, t);
        z();
        return this;
    }

    @CheckResult
    @NonNull
    public ad B(@NonNull Key key) {
        if (this.tt) {
            return clone().B(key);
        }
        uk.fe(key);
        this.ggg = key;
        this.f5073ad |= 1024;
        z();
        return this;
    }

    @CheckResult
    @NonNull
    public ad D(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.tt) {
            return clone().D(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f5077th = f2;
        this.f5073ad |= 2;
        z();
        return this;
    }

    @CheckResult
    @NonNull
    public ad E(boolean z) {
        if (this.tt) {
            return clone().E(true);
        }
        this.f197switch = !z;
        this.f5073ad |= 256;
        z();
        return this;
    }

    @CheckResult
    @NonNull
    public ad F(@NonNull Transformation<Bitmap> transformation) {
        return G(transformation, true);
    }

    @NonNull
    public final ad G(@NonNull Transformation<Bitmap> transformation, boolean z) {
        if (this.tt) {
            return clone().G(transformation, z);
        }
        pf pfVar = new pf(transformation, z);
        I(Bitmap.class, transformation, z);
        I(Drawable.class, pfVar, z);
        pfVar.de();
        I(BitmapDrawable.class, pfVar, z);
        I(de.class, new th(transformation), z);
        z();
        return this;
    }

    @CheckResult
    @NonNull
    public final ad H(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.tt) {
            return clone().H(downsampleStrategy, transformation);
        }
        i(downsampleStrategy);
        return F(transformation);
    }

    @NonNull
    public final <T> ad I(@NonNull Class<T> cls, @NonNull Transformation<T> transformation, boolean z) {
        if (this.tt) {
            return clone().I(cls, transformation, z);
        }
        uk.fe(cls);
        uk.fe(transformation);
        this.aaa.put(cls, transformation);
        int i2 = this.f5073ad | 2048;
        this.f5073ad = i2;
        this.xxx = true;
        int i3 = i2 | 65536;
        this.f5073ad = i3;
        this.g = false;
        if (z) {
            this.f5073ad = i3 | 131072;
            this.vvv = true;
        }
        z();
        return this;
    }

    @CheckResult
    @NonNull
    public ad J(boolean z) {
        if (this.tt) {
            return clone().J(z);
        }
        this.h = z;
        this.f5073ad |= 1048576;
        z();
        return this;
    }

    @Nullable
    public final Resources.Theme a() {
        return this.rrr;
    }

    public final int aaa() {
        return this.f196if;
    }

    @CheckResult
    @NonNull
    public ad ad(@NonNull ad adVar) {
        if (this.tt) {
            return clone().ad(adVar);
        }
        if (j(adVar.f5073ad, 2)) {
            this.f5077th = adVar.f5077th;
        }
        if (j(adVar.f5073ad, 262144)) {
            this.e = adVar.e;
        }
        if (j(adVar.f5073ad, 1048576)) {
            this.h = adVar.h;
        }
        if (j(adVar.f5073ad, 4)) {
            this.f5079yj = adVar.f5079yj;
        }
        if (j(adVar.f5073ad, 8)) {
            this.f5078uk = adVar.f5078uk;
        }
        if (j(adVar.f5073ad, 16)) {
            this.f5074i = adVar.f5074i;
            this.f5075o = 0;
            this.f5073ad &= -33;
        }
        if (j(adVar.f5073ad, 32)) {
            this.f5075o = adVar.f5075o;
            this.f5074i = null;
            this.f5073ad &= -17;
        }
        if (j(adVar.f5073ad, 64)) {
            this.f5076pf = adVar.f5076pf;
            this.f196if = 0;
            this.f5073ad &= -129;
        }
        if (j(adVar.f5073ad, 128)) {
            this.f196if = adVar.f196if;
            this.f5076pf = null;
            this.f5073ad &= -65;
        }
        if (j(adVar.f5073ad, 256)) {
            this.f197switch = adVar.f197switch;
        }
        if (j(adVar.f5073ad, 512)) {
            this.ppp = adVar.ppp;
            this.when = adVar.when;
        }
        if (j(adVar.f5073ad, 1024)) {
            this.ggg = adVar.ggg;
        }
        if (j(adVar.f5073ad, 4096)) {
            this.qqq = adVar.qqq;
        }
        if (j(adVar.f5073ad, 8192)) {
            this.ddd = adVar.ddd;
            this.nn = 0;
            this.f5073ad &= -16385;
        }
        if (j(adVar.f5073ad, 16384)) {
            this.nn = adVar.nn;
            this.ddd = null;
            this.f5073ad &= -8193;
        }
        if (j(adVar.f5073ad, 32768)) {
            this.rrr = adVar.rrr;
        }
        if (j(adVar.f5073ad, 65536)) {
            this.xxx = adVar.xxx;
        }
        if (j(adVar.f5073ad, 131072)) {
            this.vvv = adVar.vvv;
        }
        if (j(adVar.f5073ad, 2048)) {
            this.aaa.putAll(adVar.aaa);
            this.g = adVar.g;
        }
        if (j(adVar.f5073ad, 524288)) {
            this.f = adVar.f;
        }
        if (!this.xxx) {
            this.aaa.clear();
            int i2 = this.f5073ad & -2049;
            this.f5073ad = i2;
            this.vvv = false;
            this.f5073ad = i2 & -131073;
            this.g = true;
        }
        this.f5073ad |= adVar.f5073ad;
        this.mmm.fe(adVar.mmm);
        z();
        return this;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> b() {
        return this.aaa;
    }

    public final boolean c() {
        return this.h;
    }

    public final boolean d() {
        return this.e;
    }

    public final int ddd() {
        return this.when;
    }

    @NonNull
    public ad de() {
        if (!this.eee || this.tt) {
            this.tt = true;
            p();
            return this;
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public final boolean e() {
        return this.f197switch;
    }

    @NonNull
    public final Class<?> eee() {
        return this.qqq;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        if (Float.compare(adVar.f5077th, this.f5077th) == 0 && this.f5075o == adVar.f5075o && i.de(this.f5074i, adVar.f5074i) && this.f196if == adVar.f196if && i.de(this.f5076pf, adVar.f5076pf) && this.nn == adVar.nn && i.de(this.ddd, adVar.ddd) && this.f197switch == adVar.f197switch && this.when == adVar.when && this.ppp == adVar.ppp && this.vvv == adVar.vvv && this.xxx == adVar.xxx && this.e == adVar.e && this.f == adVar.f && this.f5079yj.equals(adVar.f5079yj) && this.f5078uk == adVar.f5078uk && this.mmm.equals(adVar.mmm) && this.aaa.equals(adVar.aaa) && this.qqq.equals(adVar.qqq) && i.de(this.ggg, adVar.ggg) && i.de(this.rrr, adVar.rrr)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return h(8);
    }

    @CheckResult
    /* renamed from: fe */
    public ad clone() {
        try {
            ad adVar = (ad) super.clone();
            fe.rg.qw.o.ad adVar2 = new fe.rg.qw.o.ad();
            adVar.mmm = adVar2;
            adVar2.fe(this.mmm);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            adVar.aaa = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.aaa);
            adVar.eee = false;
            adVar.tt = false;
            return adVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean g() {
        return this.g;
    }

    public final int ggg() {
        return this.nn;
    }

    public final boolean h(int i2) {
        return j(this.f5073ad, i2);
    }

    public int hashCode() {
        return i.m298switch(this.rrr, i.m298switch(this.ggg, i.m298switch(this.qqq, i.m298switch(this.aaa, i.m298switch(this.mmm, i.m298switch(this.f5078uk, i.m298switch(this.f5079yj, i.when(this.f, i.when(this.e, i.when(this.xxx, i.when(this.vvv, i.m297if(this.ppp, i.m297if(this.when, i.when(this.f197switch, i.m298switch(this.ddd, i.m297if(this.nn, i.m298switch(this.f5076pf, i.m297if(this.f196if, i.m298switch(this.f5074i, i.m297if(this.f5075o, i.o(this.f5077th)))))))))))))))))))));
    }

    @CheckResult
    @NonNull
    public ad i(@NonNull DownsampleStrategy downsampleStrategy) {
        Option<DownsampleStrategy> option = DownsampleStrategy.f3715th;
        uk.fe(downsampleStrategy);
        return A(option, downsampleStrategy);
    }

    @NonNull
    /* renamed from: if  reason: not valid java name */
    public final yj m323if() {
        return this.f5079yj;
    }

    public final boolean k() {
        return this.xxx;
    }

    public final boolean l() {
        return this.vvv;
    }

    public final boolean m() {
        return h(2048);
    }

    @Nullable
    public final Drawable mmm() {
        return this.f5076pf;
    }

    public final boolean n() {
        return i.xxx(this.ppp, this.when);
    }

    public final int nn() {
        return this.ppp;
    }

    @CheckResult
    @NonNull
    public ad o(@DrawableRes int i2) {
        if (this.tt) {
            return clone().o(i2);
        }
        this.f5075o = i2;
        int i3 = this.f5073ad | 32;
        this.f5073ad = i3;
        this.f5074i = null;
        this.f5073ad = i3 & -17;
        z();
        return this;
    }

    @NonNull
    public ad p() {
        this.eee = true;
        return this;
    }

    @CheckResult
    @NonNull
    public ad pf(@DrawableRes int i2) {
        if (this.tt) {
            return clone().pf(i2);
        }
        this.nn = i2;
        int i3 = this.f5073ad | 16384;
        this.f5073ad = i3;
        this.ddd = null;
        this.f5073ad = i3 & -8193;
        z();
        return this;
    }

    @Nullable
    public final Drawable ppp() {
        return this.ddd;
    }

    @CheckResult
    @NonNull
    public ad q() {
        return u(DownsampleStrategy.f3711ad, new fe.rg.qw.o.th.de.yj());
    }

    @NonNull
    public final Priority qqq() {
        return this.f5078uk;
    }

    @CheckResult
    @NonNull
    public ad r() {
        return t(DownsampleStrategy.f3712de, new fe.rg.qw.o.th.de.uk());
    }

    @CheckResult
    @NonNull
    public ad rg(@NonNull Class<?> cls) {
        if (this.tt) {
            return clone().rg(cls);
        }
        uk.fe(cls);
        this.qqq = cls;
        this.f5073ad |= 4096;
        z();
        return this;
    }

    @NonNull
    public final Key rrr() {
        return this.ggg;
    }

    @CheckResult
    @NonNull
    public ad s() {
        return t(DownsampleStrategy.qw, new Cswitch());
    }

    /* renamed from: switch  reason: not valid java name */
    public final int m324switch() {
        return this.f5075o;
    }

    @NonNull
    public final ad t(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        return y(downsampleStrategy, transformation, false);
    }

    public final float tt() {
        return this.f5077th;
    }

    @NonNull
    public final ad u(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation) {
        if (this.tt) {
            return clone().u(downsampleStrategy, transformation);
        }
        i(downsampleStrategy);
        return G(transformation, false);
    }

    @CheckResult
    @NonNull
    public ad v(int i2, int i3) {
        if (this.tt) {
            return clone().v(i2, i3);
        }
        this.ppp = i2;
        this.when = i3;
        this.f5073ad |= 512;
        z();
        return this;
    }

    public final boolean vvv() {
        return this.f;
    }

    @CheckResult
    @NonNull
    public ad w(@DrawableRes int i2) {
        if (this.tt) {
            return clone().w(i2);
        }
        this.f196if = i2;
        int i3 = this.f5073ad | 128;
        this.f5073ad = i3;
        this.f5076pf = null;
        this.f5073ad = i3 & -65;
        z();
        return this;
    }

    @Nullable
    public final Drawable when() {
        return this.f5074i;
    }

    @CheckResult
    @NonNull
    public ad x(@NonNull Priority priority) {
        if (this.tt) {
            return clone().x(priority);
        }
        uk.fe(priority);
        this.f5078uk = priority;
        this.f5073ad |= 8;
        z();
        return this;
    }

    @NonNull
    public final fe.rg.qw.o.ad xxx() {
        return this.mmm;
    }

    @NonNull
    public final ad y(@NonNull DownsampleStrategy downsampleStrategy, @NonNull Transformation<Bitmap> transformation, boolean z) {
        ad H = z ? H(downsampleStrategy, transformation) : u(downsampleStrategy, transformation);
        H.g = true;
        return H;
    }

    @CheckResult
    @NonNull
    public ad yj(@NonNull yj yjVar) {
        if (this.tt) {
            return clone().yj(yjVar);
        }
        uk.fe(yjVar);
        this.f5079yj = yjVar;
        this.f5073ad |= 4;
        z();
        return this;
    }

    @NonNull
    public final ad z() {
        if (!this.eee) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }
}
