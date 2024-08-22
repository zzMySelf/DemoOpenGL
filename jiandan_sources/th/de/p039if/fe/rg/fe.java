package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: th.de.if.fe.rg.fe  reason: invalid package */
public final class fe<T> implements Iterable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10607ad;

    /* renamed from: th.de.if.fe.rg.fe$ad */
    public static final class ad<T> extends th.de.when.ad<th.de.fe<T>> {

        /* renamed from: th  reason: collision with root package name */
        public final BlockingQueue<th.de.fe<T>> f10608th = new ArrayBlockingQueue(1);

        /* renamed from: yj  reason: collision with root package name */
        public final AtomicInteger f10609yj = new AtomicInteger();

        /* renamed from: ad */
        public void onNext(th.de.fe<T> feVar) {
            if (this.f10609yj.getAndSet(0) == 1 || !feVar.uk()) {
                while (!this.f10608th.offer(feVar)) {
                    th.de.fe<T> feVar2 = (th.de.fe) this.f10608th.poll();
                    if (feVar2 != null && !feVar2.uk()) {
                        feVar = feVar2;
                    }
                }
            }
        }

        public void de() {
            this.f10609yj.set(1);
        }

        public th.de.fe<T> fe() throws InterruptedException {
            de();
            th.de.p039if.yj.ad.ad();
            return this.f10608th.take();
        }

        public void onComplete() {
        }

        public void onError(Throwable th2) {
            th.de.ppp.qw.ddd(th2);
        }
    }

    /* renamed from: th.de.if.fe.rg.fe$qw */
    public static final class qw<T> implements Iterator<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final ad<T> f10610ad;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10611i = true;

        /* renamed from: o  reason: collision with root package name */
        public Throwable f10612o;

        /* renamed from: pf  reason: collision with root package name */
        public boolean f10613pf;

        /* renamed from: th  reason: collision with root package name */
        public final ObservableSource<T> f10614th;

        /* renamed from: uk  reason: collision with root package name */
        public boolean f10615uk = true;

        /* renamed from: yj  reason: collision with root package name */
        public T f10616yj;

        public qw(ObservableSource<T> observableSource, ad<T> adVar) {
            this.f10614th = observableSource;
            this.f10610ad = adVar;
        }

        public boolean hasNext() {
            Throwable th2 = this.f10612o;
            if (th2 != null) {
                throw ExceptionHelper.fe(th2);
            } else if (!this.f10615uk) {
                return false;
            } else {
                if (!this.f10611i || qw()) {
                    return true;
                }
                return false;
            }
        }

        public T next() {
            Throwable th2 = this.f10612o;
            if (th2 != null) {
                throw ExceptionHelper.fe(th2);
            } else if (hasNext()) {
                this.f10611i = true;
                return this.f10616yj;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public final boolean qw() {
            if (!this.f10613pf) {
                this.f10613pf = true;
                this.f10610ad.de();
                new a0(this.f10614th).subscribe(this.f10610ad);
            }
            try {
                th.de.fe<T> fe2 = this.f10610ad.fe();
                if (fe2.uk()) {
                    this.f10611i = false;
                    this.f10616yj = fe2.rg();
                    return true;
                }
                this.f10615uk = false;
                if (fe2.th()) {
                    return false;
                }
                Throwable fe3 = fe2.fe();
                this.f10612o = fe3;
                throw ExceptionHelper.fe(fe3);
            } catch (InterruptedException e) {
                this.f10610ad.dispose();
                this.f10612o = e;
                throw ExceptionHelper.fe(e);
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public fe(ObservableSource<T> observableSource) {
        this.f10607ad = observableSource;
    }

    public Iterator<T> iterator() {
        return new qw(this.f10607ad, new ad());
    }
}
