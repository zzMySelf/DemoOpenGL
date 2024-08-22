package fe.rg.qw.o.th;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.ggg.uk;

public class qw<T> implements Resource<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final T f4985ad;

    public qw(@NonNull T t) {
        uk.fe(t);
        this.f4985ad = t;
    }

    @NonNull
    public Class<T> ad() {
        return this.f4985ad.getClass();
    }

    @NonNull
    public final T get() {
        return this.f4985ad;
    }

    public final int qw() {
        return 1;
    }

    public void recycle() {
    }
}
