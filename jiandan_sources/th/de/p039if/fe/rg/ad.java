package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import th.de.fe;
import th.de.rg;

/* renamed from: th.de.if.fe.rg.ad  reason: invalid package */
public final class ad<T> implements Iterable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10524ad;

    /* renamed from: th.de.if.fe.rg.ad$qw */
    public static final class qw<T> extends th.de.when.ad<fe<T>> implements Iterator<T> {

        /* renamed from: th  reason: collision with root package name */
        public fe<T> f10525th;

        /* renamed from: uk  reason: collision with root package name */
        public final AtomicReference<fe<T>> f10526uk = new AtomicReference<>();

        /* renamed from: yj  reason: collision with root package name */
        public final Semaphore f10527yj = new Semaphore(0);

        /* renamed from: ad */
        public void onNext(fe<T> feVar) {
            if (this.f10526uk.getAndSet(feVar) == null) {
                this.f10527yj.release();
            }
        }

        public boolean hasNext() {
            fe<T> feVar = this.f10525th;
            if (feVar == null || !feVar.yj()) {
                if (this.f10525th == null) {
                    try {
                        th.de.p039if.yj.ad.ad();
                        this.f10527yj.acquire();
                        fe<T> andSet = this.f10526uk.getAndSet((Object) null);
                        this.f10525th = andSet;
                        if (andSet.yj()) {
                            throw ExceptionHelper.fe(andSet.fe());
                        }
                    } catch (InterruptedException e) {
                        dispose();
                        this.f10525th = fe.ad(e);
                        throw ExceptionHelper.fe(e);
                    }
                }
                return this.f10525th.uk();
            }
            throw ExceptionHelper.fe(this.f10525th.fe());
        }

        public T next() {
            if (hasNext()) {
                T rg2 = this.f10525th.rg();
                this.f10525th = null;
                return rg2;
            }
            throw new NoSuchElementException();
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            th.de.ppp.qw.ddd(th2);
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public ad(ObservableSource<T> observableSource) {
        this.f10524ad = observableSource;
    }

    public Iterator<T> iterator() {
        qw qwVar = new qw();
        rg.wrap(this.f10524ad).materialize().subscribe(qwVar);
        return qwVar;
    }
}
