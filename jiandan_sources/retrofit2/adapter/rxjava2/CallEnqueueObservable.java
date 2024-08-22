package retrofit2.adapter.rxjava2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.de.o.qw;
import th.de.rg;

public final class CallEnqueueObservable<T> extends rg<Response<T>> {
    public final Call<T> originalCall;

    public static final class CallCallback<T> implements Disposable, Callback<T> {
        public final Call<?> call;
        public final Observer<? super Response<T>> observer;
        public boolean terminated = false;

        public CallCallback(Call<?> call2, Observer<? super Response<T>> observer2) {
            this.call = call2;
            this.observer = observer2;
        }

        public void dispose() {
            this.call.cancel();
        }

        public boolean isDisposed() {
            return this.call.isCanceled();
        }

        public void onFailure(Call<T> call2, Throwable th2) {
            if (!call2.isCanceled()) {
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    qw.ad(th3);
                    th.de.ppp.qw.ddd(new CompositeException(th2, th3));
                }
            }
        }

        public void onResponse(Call<T> call2, Response<T> response) {
            if (!call2.isCanceled()) {
                try {
                    this.observer.onNext(response);
                    if (!call2.isCanceled()) {
                        this.terminated = true;
                        this.observer.onComplete();
                    }
                } catch (Throwable th2) {
                    qw.ad(th2);
                    th.de.ppp.qw.ddd(new CompositeException(th, th2));
                }
            }
        }
    }

    public CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    public void subscribeActual(Observer<? super Response<T>> observer) {
        Call<T> clone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(clone, observer);
        observer.onSubscribe(callCallback);
        clone.enqueue(callCallback);
    }
}
