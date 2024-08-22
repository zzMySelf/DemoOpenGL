package fe.rg.qw.p018switch;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.util.Pools;
import fe.rg.qw.ggg.yj;
import fe.rg.qw.o.fe.ppp;
import fe.rg.qw.o.fe.th;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: fe.rg.qw.switch.de  reason: invalid package */
public class de {

    /* renamed from: de  reason: collision with root package name */
    public static final ppp<?, ?, ?> f5030de = new ppp(Object.class, Object.class, Object.class, Collections.singletonList(new th(Object.class, Object.class, Object.class, Collections.emptyList(), new fe.rg.qw.o.th.uk.th(), (Pools.Pool<List<Throwable>>) null)), (Pools.Pool<List<Throwable>>) null);

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicReference<yj> f5031ad = new AtomicReference<>();
    public final ArrayMap<yj, ppp<?, ?, ?>> qw = new ArrayMap<>();

    public final yj ad(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        yj andSet = this.f5031ad.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new yj();
        }
        andSet.ad(cls, cls2, cls3);
        return andSet;
    }

    public boolean de(@Nullable ppp<?, ?, ?> ppp) {
        return f5030de.equals(ppp);
    }

    public void fe(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable ppp<?, ?, ?> ppp) {
        synchronized (this.qw) {
            ArrayMap<yj, ppp<?, ?, ?>> arrayMap = this.qw;
            yj yjVar = new yj(cls, cls2, cls3);
            if (ppp == null) {
                ppp = f5030de;
            }
            arrayMap.put(yjVar, ppp);
        }
    }

    @Nullable
    public <Data, TResource, Transcode> ppp<Data, TResource, Transcode> qw(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ppp<Data, TResource, Transcode> ppp;
        yj ad2 = ad(cls, cls2, cls3);
        synchronized (this.qw) {
            ppp = this.qw.get(ad2);
        }
        this.f5031ad.set(ad2);
        return ppp;
    }
}
