package p041if.o;

import rx.subjects.ReplaySubject$ReplayProducer;

/* renamed from: if.o.ad  reason: invalid package */
public interface ad<T> {
    void complete();

    void error(Throwable th2);

    void next(T t);

    void qw(ReplaySubject$ReplayProducer<T> replaySubject$ReplayProducer);
}
