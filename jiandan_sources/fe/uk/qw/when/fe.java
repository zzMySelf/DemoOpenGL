package fe.uk.qw.when;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import fe.uk.qw.vvv.uk;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayMap<uk, List<Class<?>>> f6062ad = new ArrayMap<>();
    public final AtomicReference<uk> qw = new AtomicReference<>();

    public void ad(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f6062ad) {
            this.f6062ad.put(new uk(cls, cls2, cls3), list);
        }
    }

    @Nullable
    public List<Class<?>> qw(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        uk andSet = this.qw.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new uk(cls, cls2, cls3);
        } else {
            andSet.qw(cls, cls2, cls3);
        }
        synchronized (this.f6062ad) {
            list = this.f6062ad.get(andSet);
        }
        this.qw.set(andSet);
        return list;
    }
}
