package fe.rg.qw.p018switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import fe.rg.qw.ggg.yj;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: fe.rg.qw.switch.fe  reason: invalid package */
public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayMap<yj, List<Class<?>>> f5032ad = new ArrayMap<>();
    public final AtomicReference<yj> qw = new AtomicReference<>();

    public void ad(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull List<Class<?>> list) {
        synchronized (this.f5032ad) {
            this.f5032ad.put(new yj(cls, cls2), list);
        }
    }

    @Nullable
    public List<Class<?>> qw(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
        List<Class<?>> list;
        yj andSet = this.qw.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new yj(cls, cls2);
        } else {
            andSet.qw(cls, cls2);
        }
        synchronized (this.f5032ad) {
            list = this.f5032ad.get(andSet);
        }
        this.qw.set(andSet);
        return list;
    }
}
