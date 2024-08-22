package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;
import th.de.fe;
import th.de.ppp.qw;

public final class FlowableMaterialize$MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, fe<T>> {
    public static final long serialVersionUID = -3740826063558713822L;

    public FlowableMaterialize$MaterializeSubscriber(Subscriber<? super fe<T>> subscriber) {
        super(subscriber);
    }

    public void onComplete() {
        complete(fe.qw());
    }

    public void onError(Throwable th2) {
        complete(fe.ad(th2));
    }

    public void onNext(T t) {
        this.produced++;
        this.downstream.onNext(fe.de(t));
    }

    public void onDrop(fe<T> feVar) {
        if (feVar.yj()) {
            qw.ddd(feVar.fe());
        }
    }
}
