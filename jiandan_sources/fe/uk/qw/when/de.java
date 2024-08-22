package fe.uk.qw.when;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.util.Pools;
import fe.uk.qw.pf.fe.ppp;
import fe.uk.qw.pf.fe.th;
import fe.uk.qw.vvv.uk;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class de {

    /* renamed from: de  reason: collision with root package name */
    public static final ppp<?, ?, ?> f6060de = new ppp(Object.class, Object.class, Object.class, Collections.singletonList(new th(Object.class, Object.class, Object.class, Collections.emptyList(), new fe.uk.qw.pf.th.i.th(), (Pools.Pool<List<Throwable>>) null)), (Pools.Pool<List<Throwable>>) null);

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<uk> f6061ad = new AtomicReference<>();
    public final ArrayMap<uk, ppp<?, ?, ?>> qw = new ArrayMap<>();

    public final uk ad(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        uk andSet = this.f6061ad.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new uk();
        }
        andSet.qw(cls, cls2, cls3);
        return andSet;
    }

    public boolean de(@Nullable ppp<?, ?, ?> ppp) {
        return f6060de.equals(ppp);
    }

    public void fe(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable ppp<?, ?, ?> ppp) {
        synchronized (this.qw) {
            ArrayMap<uk, ppp<?, ?, ?>> arrayMap = this.qw;
            uk ukVar = new uk(cls, cls2, cls3);
            if (ppp == null) {
                ppp = f6060de;
            }
            arrayMap.put(ukVar, ppp);
        }
    }

    @Nullable
    public <Data, TResource, Transcode> ppp<Data, TResource, Transcode> qw(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ppp<Data, TResource, Transcode> ppp;
        uk ad2 = ad(cls, cls2, cls3);
        synchronized (this.qw) {
            ppp = this.qw.get(ad2);
        }
        this.f6061ad.set(ad2);
        return ppp;
    }
}
