package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import p041if.de;
import p041if.rg.qw.ad;
import rx.Observable;

public final class CachedObservable$CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
    public static final long serialVersionUID = -2817751667698696782L;
    public final ad<T> state;

    public CachedObservable$CachedSubscribe(ad<T> adVar) {
        this.state = adVar;
    }

    public void call(de<? super T> deVar) {
        CachedObservable$ReplayProducer cachedObservable$ReplayProducer = new CachedObservable$ReplayProducer(deVar, this.state);
        this.state.de(cachedObservable$ReplayProducer);
        deVar.add(cachedObservable$ReplayProducer);
        deVar.setProducer(cachedObservable$ReplayProducer);
        if (!get() && compareAndSet(false, true)) {
            this.state.fe();
        }
    }
}
