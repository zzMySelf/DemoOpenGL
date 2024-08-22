package retrofit2.adapter.rxjava2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Call;
import retrofit2.Response;
import th.de.o.qw;
import th.de.rg;

public final class CallExecuteObservable<T> extends rg<Response<T>> {
    public final Call<T> originalCall;

    public static final class CallDisposable implements Disposable {
        public final Call<?> call;

        public CallDisposable(Call<?> call2) {
            this.call = call2;
        }

        public void dispose() {
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.call.isCanceled();
        }
    }

    public CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    public void subscribeActual(Observer<? super Response<T>> observer) {
        boolean z;
        Call<T> clone = this.originalCall.clone();
        observer.onSubscribe(new CallDisposable(clone));
        try {
            Response<T> execute = clone.execute();
            if (!clone.isCanceled()) {
                observer.onNext(execute);
            }
            if (!clone.isCanceled()) {
                try {
                    observer.onComplete();
                } catch (Throwable th2) {
                    th = th2;
                    z = true;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            qw.ad(th);
            if (z) {
                th.de.ppp.qw.ddd(th);
            } else if (!clone.isCanceled()) {
                try {
                    observer.onError(th);
                } catch (Throwable th4) {
                    qw.ad(th4);
                    th.de.ppp.qw.ddd(new CompositeException(th, th4));
                }
            }
        }
    }
}
