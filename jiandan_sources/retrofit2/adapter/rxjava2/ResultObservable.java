package retrofit2.adapter.rxjava2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Response;
import th.de.o.qw;
import th.de.rg;

public final class ResultObservable<T> extends rg<Result<T>> {
    public final rg<Response<T>> upstream;

    public static class ResultObserver<R> implements Observer<Response<R>> {
        public final Observer<? super Result<R>> observer;

        public ResultObserver(Observer<? super Result<R>> observer2) {
            this.observer = observer2;
        }

        public void onComplete() {
            this.observer.onComplete();
        }

        public void onError(Throwable th2) {
            try {
                this.observer.onNext(Result.error(th2));
                this.observer.onComplete();
            } catch (Throwable th3) {
                qw.ad(th3);
                th.de.ppp.qw.ddd(new CompositeException(th, th3));
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }

        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }
    }

    public ResultObservable(rg<Response<T>> rgVar) {
        this.upstream = rgVar;
    }

    public void subscribeActual(Observer<? super Result<T>> observer) {
        this.upstream.subscribe(new ResultObserver(observer));
    }
}
