package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: th.de.if.fe.rg.de  reason: invalid package */
public final class de<T> implements Iterable<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final ObservableSource<T> f10582ad;

    /* renamed from: th  reason: collision with root package name */
    public final T f10583th;

    /* renamed from: th.de.if.fe.rg.de$qw */
    public static final class qw<T> extends th.de.when.qw<T> {

        /* renamed from: th  reason: collision with root package name */
        public volatile Object f10584th;

        /* renamed from: th.de.if.fe.rg.de$qw$qw  reason: collision with other inner class name */
        public final class C0337qw implements Iterator<T> {

            /* renamed from: ad  reason: collision with root package name */
            public Object f10585ad;

            public C0337qw() {
            }

            public boolean hasNext() {
                Object obj = qw.this.f10584th;
                this.f10585ad = obj;
                return !NotificationLite.isComplete(obj);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.f10585ad == null) {
                        obj = qw.this.f10584th;
                    }
                    if (NotificationLite.isComplete(this.f10585ad)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.f10585ad)) {
                        T value = NotificationLite.getValue(this.f10585ad);
                        this.f10585ad = obj;
                        return value;
                    } else {
                        throw ExceptionHelper.fe(NotificationLite.getError(this.f10585ad));
                    }
                } finally {
                    this.f10585ad = obj;
                }
            }

            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public qw(T t) {
            this.f10584th = NotificationLite.next(t);
        }

        public qw<T>.defpackage.qw ad() {
            return new C0337qw();
        }

        public void onComplete() {
            this.f10584th = NotificationLite.complete();
        }

        public void onError(Throwable th2) {
            this.f10584th = NotificationLite.error(th2);
        }

        public void onNext(T t) {
            this.f10584th = NotificationLite.next(t);
        }
    }

    public de(ObservableSource<T> observableSource, T t) {
        this.f10582ad = observableSource;
        this.f10583th = t;
    }

    public Iterator<T> iterator() {
        qw qwVar = new qw(this.f10583th);
        this.f10582ad.subscribe(qwVar);
        return qwVar.ad();
    }
}
