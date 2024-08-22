package retrofit2.adapter.rxjava2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Response;
import th.de.ppp.qw;
import th.de.rg;

public final class BodyObservable<T> extends rg<T> {
    public final rg<Response<T>> upstream;

    public static class BodyObserver<R> implements Observer<Response<R>> {
        public final Observer<? super R> observer;
        public boolean terminated;

        public BodyObserver(Observer<? super R> observer2) {
            this.observer = observer2;
        }

        public void onComplete() {
            if (!this.terminated) {
                this.observer.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (!this.terminated) {
                this.observer.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th2);
            qw.ddd(assertionError);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th2) {
                th.de.o.qw.ad(th2);
                qw.ddd(new CompositeException(httpException, th2));
            }
        }
    }

    public BodyObservable(rg<Response<T>> rgVar) {
        this.upstream = rgVar;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.upstream.subscribe(new BodyObserver(observer));
    }
}
