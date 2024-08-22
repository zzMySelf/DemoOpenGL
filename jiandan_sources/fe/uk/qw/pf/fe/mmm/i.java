package fe.uk.qw.pf.fe.mmm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class i implements BitmapPool {

    /* renamed from: o  reason: collision with root package name */
    public static final Bitmap.Config f5775o = Bitmap.Config.ARGB_8888;

    /* renamed from: ad  reason: collision with root package name */
    public final Set<Bitmap.Config> f5776ad;

    /* renamed from: de  reason: collision with root package name */
    public final qw f5777de;

    /* renamed from: fe  reason: collision with root package name */
    public long f5778fe;

    /* renamed from: i  reason: collision with root package name */
    public int f5779i;
    public final o qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f5780rg;

    /* renamed from: th  reason: collision with root package name */
    public int f5781th;

    /* renamed from: uk  reason: collision with root package name */
    public int f5782uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f5783yj;

    public static final class ad implements qw {
        public void ad(Bitmap bitmap) {
        }

        public void qw(Bitmap bitmap) {
        }
    }

    public interface qw {
        void ad(Bitmap bitmap);

        void qw(Bitmap bitmap);
    }

    public i(long j, o oVar, Set<Bitmap.Config> set) {
        this.f5778fe = j;
        this.qw = oVar;
        this.f5776ad = set;
        this.f5777de = new ad();
    }

    public static void ggg(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        ppp(bitmap);
    }

    /* renamed from: if  reason: not valid java name */
    public static o m375if() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new Cif();
        }
        return new ad();
    }

    @TargetApi(26)
    public static Set<Bitmap.Config> pf() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add((Object) null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @TargetApi(19)
    public static void ppp(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    @TargetApi(26)
    public static void th(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    public static Bitmap yj(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f5775o;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    public void ad() {
        boolean isLoggable = Log.isLoggable("LruBitmapPool", 3);
        vvv(0);
    }

    public synchronized void de(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.qw.rg(bitmap)) <= this.f5778fe) {
                        if (this.f5776ad.contains(bitmap.getConfig())) {
                            int rg2 = this.qw.rg(bitmap);
                            this.qw.de(bitmap);
                            this.f5777de.ad(bitmap);
                            this.f5782uk++;
                            this.f5780rg += (long) rg2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                "Put bitmap in pool=" + this.qw.qw(bitmap);
                            }
                            uk();
                            o();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        "Reject bitmap from pool, bitmap: " + this.qw.qw(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f5776ad.contains(bitmap.getConfig());
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    @NonNull
    public Bitmap fe(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmap = m376switch(i2, i3, config);
        if (bitmap == null) {
            return yj(i2, i3, config);
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    public final void i() {
        "Hits=" + this.f5781th + ", misses=" + this.f5783yj + ", puts=" + this.f5782uk + ", evictions=" + this.f5779i + ", currentSize=" + this.f5780rg + ", maxSize=" + this.f5778fe + "\nStrategy=" + this.qw;
    }

    public final void o() {
        vvv(this.f5778fe);
    }

    @SuppressLint({"InlinedApi"})
    public void qw(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            "trimMemory, level=" + i2;
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            ad();
        } else if (i2 >= 20 || i2 == 15) {
            vvv(when() / 2);
        }
    }

    @NonNull
    public Bitmap rg(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmap = m376switch(i2, i3, config);
        return bitmap == null ? yj(i2, i3, config) : bitmap;
    }

    @Nullable
    /* renamed from: switch  reason: not valid java name */
    public final synchronized Bitmap m376switch(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap fe2;
        th(config);
        fe2 = this.qw.fe(i2, i3, config != null ? config : f5775o);
        if (fe2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                "Missing bitmap=" + this.qw.ad(i2, i3, config);
            }
            this.f5783yj++;
        } else {
            this.f5781th++;
            this.f5780rg -= (long) this.qw.rg(fe2);
            this.f5777de.qw(fe2);
            ggg(fe2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            "Get bitmap=" + this.qw.ad(i2, i3, config);
        }
        uk();
        return fe2;
    }

    public final void uk() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    public final synchronized void vvv(long j) {
        while (this.f5780rg > j) {
            Bitmap removeLast = this.qw.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    i();
                }
                this.f5780rg = 0;
                return;
            }
            this.f5777de.qw(removeLast);
            this.f5780rg -= (long) this.qw.rg(removeLast);
            this.f5779i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                "Evicting bitmap=" + this.qw.qw(removeLast);
            }
            uk();
            removeLast.recycle();
        }
    }

    public long when() {
        return this.f5778fe;
    }

    public i(long j) {
        this(j, m375if(), pf());
    }
}
