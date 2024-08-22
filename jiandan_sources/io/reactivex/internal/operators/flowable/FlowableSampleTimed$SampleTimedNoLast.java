package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import th.de.th;

public final class FlowableSampleTimed$SampleTimedNoLast<T> extends FlowableSampleTimed$SampleTimedSubscriber<T> {
    public static final long serialVersionUID = -7139995637533111443L;

    public FlowableSampleTimed$SampleTimedNoLast(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, th thVar) {
        super(subscriber, j, timeUnit, thVar);
    }

    public void complete() {
        this.downstream.onComplete();
    }

    public void run() {
        emit();
    }
}
