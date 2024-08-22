package fe.rg.qw.o.fe.mmm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class i implements BitmapPool {

    /* renamed from: o  reason: collision with root package name */
    public static final Bitmap.Config f4802o = Bitmap.Config.ARGB_8888;

    /* renamed from: ad  reason: collision with root package name */
    public final Set<Bitmap.Config> f4803ad;

    /* renamed from: de  reason: collision with root package name */
    public final qw f4804de;

    /* renamed from: fe  reason: collision with root package name */
    public long f4805fe;

    /* renamed from: i  reason: collision with root package name */
    public int f4806i;
    public final o qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f4807rg;

    /* renamed from: th  reason: collision with root package name */
    public int f4808th;

    /* renamed from: uk  reason: collision with root package name */
    public int f4809uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f4810yj;

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
        this.f4805fe = j;
        this.qw = oVar;
        this.f4803ad = set;
        this.f4804de = new ad();
    }

    public static void ggg(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        ppp(bitmap);
    }

    /* renamed from: if  reason: not valid java name */
    public static o m307if() {
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
            config = f4802o;
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
                    if (bitmap.isMutable() && ((long) this.qw.rg(bitmap)) <= this.f4805fe) {
                        if (this.f4803ad.contains(bitmap.getConfig())) {
                            int rg2 = this.qw.rg(bitmap);
                            this.qw.de(bitmap);
                            this.f4804de.ad(bitmap);
                            this.f4809uk++;
                            this.f4807rg += (long) rg2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                "Put bitmap in pool=" + this.qw.qw(bitmap);
                            }
                            uk();
                            o();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        "Reject bitmap from pool, bitmap: " + this.qw.qw(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f4803ad.contains(bitmap.getConfig());
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
        Bitmap bitmap = m308switch(i2, i3, config);
        if (bitmap == null) {
            return yj(i2, i3, config);
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    public final void i() {
        "Hits=" + this.f4808th + ", misses=" + this.f4810yj + ", puts=" + this.f4809uk + ", evictions=" + this.f4806i + ", currentSize=" + this.f4807rg + ", maxSize=" + this.f4805fe + "\nStrategy=" + this.qw;
    }

    public final void o() {
        vvv(this.f4805fe);
    }

    @SuppressLint({"InlinedApi"})
    public void qw(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            "trimMemory, level=" + i2;
        }
        if (i2 >= 40) {
            ad();
        } else if (i2 >= 20 || i2 == 15) {
            vvv(when() / 2);
        }
    }

    @NonNull
    public Bitmap rg(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmap = m308switch(i2, i3, config);
        return bitmap == null ? yj(i2, i3, config) : bitmap;
    }

    @Nullable
    /* renamed from: switch  reason: not valid java name */
    public final synchronized Bitmap m308switch(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap fe2;
        th(config);
        fe2 = this.qw.fe(i2, i3, config != null ? config : f4802o);
        if (fe2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                "Missing bitmap=" + this.qw.ad(i2, i3, config);
            }
            this.f4810yj++;
        } else {
            this.f4808th++;
            this.f4807rg -= (long) this.qw.rg(fe2);
            this.f4804de.qw(fe2);
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
        while (this.f4807rg > j) {
            Bitmap removeLast = this.qw.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    i();
                }
                this.f4807rg = 0;
                return;
            }
            this.f4804de.qw(removeLast);
            this.f4807rg -= (long) this.qw.rg(removeLast);
            this.f4806i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                "Evicting bitmap=" + this.qw.qw(removeLast);
            }
            uk();
            removeLast.recycle();
        }
    }

    public long when() {
        return this.f4805fe;
    }

    public i(long j) {
        this(j, m307if(), pf());
    }
}
