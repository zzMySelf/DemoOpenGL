package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import th.de.th;

public final class FlowableSampleTimed$SampleTimedEmitLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    public static final long serialVersionUID = -7139995637533111443L;
    public final AtomicInteger wip = new AtomicInteger(1);

    public FlowableSampleTimed$SampleTimedEmitLast(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th thVar) {
        super(subscriber, j, timeUnit, thVar);
    }

    public void complete() {
        emit();
        if (this.wip.decrementAndGet() == 0) {
            this.downstream.onComplete();
        }
    }

    public void run() {
        if (this.wip.incrementAndGet() == 2) {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }
    }
}
