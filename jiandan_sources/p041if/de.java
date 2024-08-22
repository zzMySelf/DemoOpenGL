package p041if;

import p041if.rg.fe.yj;
import rx.Observer;
import rx.Producer;
import rx.Subscription;

/* renamed from: if.de  reason: invalid package */
public abstract class de<T> implements Observer<T>, Subscription {
    public static final long NOT_SET = Long.MIN_VALUE;
    public Producer producer;
    public long requested;
    public final de<?> subscriber;
    public final yj subscriptions;

    public de() {
        this((de<?>) null, false);
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j3;
        }
    }

    public final void add(Subscription subscription) {
        this.subscriptions.qw(subscription);
    }

    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    public final void request(long j) {
        if (j >= 0) {
            synchronized (this) {
                if (this.producer != null) {
                    Producer producer2 = this.producer;
                    producer2.request(j);
                    return;
                }
                addToRequested(j);
                return;
            }
        }
        throw new IllegalArgumentException("number requested cannot be negative: " + j);
    }

    public void setProducer(Producer producer2) {
        long j;
        boolean z;
        synchronized (this) {
            j = this.requested;
            this.producer = producer2;
            z = this.subscriber != null && j == Long.MIN_VALUE;
        }
        if (z) {
            this.subscriber.setProducer(this.producer);
        } else if (j == Long.MIN_VALUE) {
            this.producer.request(Long.MAX_VALUE);
        } else {
            this.producer.request(j);
        }
    }

    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public de(de<?> deVar) {
        this(deVar, true);
    }

    public de(de<?> deVar, boolean z) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = deVar;
        this.subscriptions = (!z || deVar == null) ? new yj() : deVar.subscriptions;
    }
}
