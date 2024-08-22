package io.reactivex.processors;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;
import th.de.ggg.qw;

public final class AsyncProcessor<T> extends qw<T> {

    public static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        public static final long serialVersionUID = 5629876084736248016L;
        public final AsyncProcessor<T> parent;

        public AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.parent = asyncProcessor;
        }

        public void cancel() {
            if (super.tryCancel()) {
                this.parent.uk(this);
            }
        }

        public void onComplete() {
            if (!isCancelled()) {
                this.downstream.onComplete();
            }
        }

        public void onError(Throwable th2) {
            if (isCancelled()) {
                th.de.ppp.qw.ddd(th2);
            } else {
                this.downstream.onError(th2);
            }
        }
    }

    public abstract void uk(AsyncSubscription<T> asyncSubscription);
}
