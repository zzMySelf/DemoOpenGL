package fe.uk.qw.pf.th;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.vvv.i;

public class ad<T> implements Resource<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final T f5945ad;

    public ad(@NonNull T t) {
        i.fe(t);
        this.f5945ad = t;
    }

    @NonNull
    public Class<T> ad() {
        return this.f5945ad.getClass();
    }

    @NonNull
    public final T get() {
        return this.f5945ad;
    }

    public final int qw() {
        return 1;
    }

    public void recycle() {
    }
}
