package io.reactivex.processors;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ReplayProcessor<T> extends th.de.ggg.qw<T> {

    /* renamed from: th  reason: collision with root package name */
    public final qw<T> f10332th;

    public static final class Node<T> extends AtomicReference<Node<T>> {
        public static final long serialVersionUID = 6404226426336033100L;
        public final T value;

        public Node(T t) {
            this.value = t;
        }
    }

    public static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        public static final long serialVersionUID = 466549804534799122L;
        public volatile boolean cancelled;
        public final Subscriber<? super T> downstream;
        public long emitted;
        public Object index;
        public final AtomicLong requested = new AtomicLong();
        public final ReplayProcessor<T> state;

        public ReplaySubscription(Subscriber<? super T> subscriber, ReplayProcessor<T> replayProcessor) {
            this.downstream = subscriber;
            this.state = replayProcessor;
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.uk(this);
            }
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                th.de.p039if.yj.qw.qw(this.requested, j);
                this.state.f10332th.qw(this);
            }
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        public static final long serialVersionUID = 6404226426336033100L;
        public final long time;
        public final T value;

        public TimedNode(T t, long j) {
            this.value = t;
            this.time = j;
        }
    }

    public interface qw<T> {
        void qw(ReplaySubscription<T> replaySubscription);
    }

    public abstract void uk(ReplaySubscription<T> replaySubscription);
}
