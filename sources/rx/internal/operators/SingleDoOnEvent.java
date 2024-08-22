package rx.internal.operators;

import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action1;

public final class SingleDoOnEvent<T> implements Single.OnSubscribe<T> {
    final Action1<Throwable> onError;
    final Action1<? super T> onSuccess;
    final Single<T> source;

    public SingleDoOnEvent(Single<T> source2, Action1<? super T> onSuccess2, Action1<Throwable> onError2) {
        this.source = source2;
        this.onSuccess = onSuccess2;
        this.onError = onError2;
    }

    public void call(SingleSubscriber<? super T> actual) {
        SingleDoOnEventSubscriber<T> parent = new SingleDoOnEventSubscriber<>(actual, this.onSuccess, this.onError);
        actual.add(parent);
        this.source.subscribe(parent);
    }

    static final class SingleDoOnEventSubscriber<T> extends SingleSubscriber<T> {
        final SingleSubscriber<? super T> actual;
        final Action1<Throwable> onError;
        final Action1<? super T> onSuccess;

        SingleDoOnEventSubscriber(SingleSubscriber<? super T> actual2, Action1<? super T> onSuccess2, Action1<Throwable> onError2) {
            this.actual = actual2;
            this.onSuccess = onSuccess2;
            this.onError = onError2;
        }

        public void onSuccess(T value) {
            try {
                this.onSuccess.call(value);
                this.actual.onSuccess(value);
            } catch (Throwable e2) {
                Exceptions.throwOrReport(e2, (SingleSubscriber<?>) this, (Object) value);
            }
        }

        public void onError(Throwable error) {
            try {
                this.onError.call(error);
                this.actual.onError(error);
            } catch (Throwable e2) {
                Exceptions.throwIfFatal(e2);
                this.actual.onError(new CompositeException(error, e2));
            }
        }
    }
}
