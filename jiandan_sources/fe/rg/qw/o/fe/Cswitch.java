package fe.rg.qw.o.fe;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.uk;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

/* renamed from: fe.rg.qw.o.fe.switch  reason: invalid class name */
public class Cswitch<Z> implements Resource<Z> {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f4869ad;

    /* renamed from: i  reason: collision with root package name */
    public int f4870i;

    /* renamed from: o  reason: collision with root package name */
    public boolean f4871o;

    /* renamed from: pf  reason: collision with root package name */
    public final Resource<Z> f4872pf;

    /* renamed from: th  reason: collision with root package name */
    public final boolean f4873th;

    /* renamed from: uk  reason: collision with root package name */
    public Key f4874uk;

    /* renamed from: yj  reason: collision with root package name */
    public qw f4875yj;

    /* renamed from: fe.rg.qw.o.fe.switch$qw */
    public interface qw {
        void fe(Key key, Cswitch<?> switchR);
    }

    public Cswitch(Resource<Z> resource, boolean z, boolean z2) {
        uk.fe(resource);
        this.f4872pf = resource;
        this.f4869ad = z;
        this.f4873th = z2;
    }

    @NonNull
    public Class<Z> ad() {
        return this.f4872pf.ad();
    }

    public void de() {
        if (this.f4871o) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.f4870i++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    public Resource<Z> fe() {
        return this.f4872pf;
    }

    @NonNull
    public Z get() {
        return this.f4872pf.get();
    }

    public int qw() {
        return this.f4872pf.qw();
    }

    public void recycle() {
        if (this.f4870i > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f4871o) {
            this.f4871o = true;
            if (this.f4873th) {
                this.f4872pf.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public boolean rg() {
        return this.f4869ad;
    }

    public void th() {
        if (this.f4870i <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i2 = this.f4870i - 1;
            this.f4870i = i2;
            if (i2 == 0) {
                this.f4875yj.fe(this.f4874uk, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    public String toString() {
        return "EngineResource{isCacheable=" + this.f4869ad + ", listener=" + this.f4875yj + ", key=" + this.f4874uk + ", acquired=" + this.f4870i + ", isRecycled=" + this.f4871o + ", resource=" + this.f4872pf + ExtendedMessageFormat.END_FE;
    }

    public void yj(Key key, qw qwVar) {
        this.f4874uk = key;
        this.f4875yj = qwVar;
    }
}
