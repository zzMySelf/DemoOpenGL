package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import p041if.de;
import p041if.th.qw;
import p041if.yj.fe;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements Observable.OnSubscribe<T> {
    public final Action1<? super Subscription> connection;
    public final int numberOfSubscribers;
    public final qw<? extends T> source;

    public OnSubscribeAutoConnect(qw<? extends T> qwVar, int i2, Action1<? super Subscription> action1) {
        if (i2 > 0) {
            this.source = qwVar;
            this.numberOfSubscribers = i2;
            this.connection = action1;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(de<? super T> deVar) {
        this.source.aaa(fe.de(deVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.qqq(this.connection);
        }
    }
}
