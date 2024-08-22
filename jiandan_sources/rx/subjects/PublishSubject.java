package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p041if.de;
import p041if.o.fe;
import p041if.rg.qw.qw;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;

public final class PublishSubject<T> extends fe<T, T> {

    /* renamed from: th  reason: collision with root package name */
    public final PublishSubjectState<T> f11478th;

    public static final class PublishSubjectProducer<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        public static final long serialVersionUID = 6451806817170721536L;
        public final de<? super T> actual;
        public final PublishSubjectState<T> parent;
        public long produced;

        public PublishSubjectProducer(PublishSubjectState<T> publishSubjectState, de<? super T> deVar) {
            this.parent = publishSubjectState;
            this.actual = deVar;
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th2);
            }
        }

        public void onNext(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                long j2 = this.produced;
                if (j != j2) {
                    this.produced = j2 + 1;
                    this.actual.onNext(t);
                    return;
                }
                unsubscribe();
                this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        public void request(long j) {
            long j2;
            if (qw.uk(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE || compareAndSet(j2, qw.qw(j2, j))) {
                    }
                    j2 = get();
                    return;
                } while (compareAndSet(j2, qw.qw(j2, j)));
            }
        }

        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }
    }

    public static final class PublishSubjectState<T> extends AtomicReference<PublishSubjectProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        public static final PublishSubjectProducer[] EMPTY = new PublishSubjectProducer[0];
        public static final PublishSubjectProducer[] TERMINATED = new PublishSubjectProducer[0];
        public static final long serialVersionUID = -7568940796666027140L;
        public Throwable error;

        public PublishSubjectState() {
            lazySet(EMPTY);
        }

        public boolean add(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            do {
                publishSubjectProducerArr = (PublishSubjectProducer[]) get();
                if (publishSubjectProducerArr == TERMINATED) {
                    return false;
                }
                int length = publishSubjectProducerArr.length;
                publishSubjectProducerArr2 = new PublishSubjectProducer[(length + 1)];
                System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr2, 0, length);
                publishSubjectProducerArr2[length] = publishSubjectProducer;
            } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
            return true;
        }

        public void onCompleted() {
            for (PublishSubjectProducer onCompleted : (PublishSubjectProducer[]) getAndSet(TERMINATED)) {
                onCompleted.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            this.error = th2;
            ArrayList arrayList = null;
            for (PublishSubjectProducer onError : (PublishSubjectProducer[]) getAndSet(TERMINATED)) {
                try {
                    onError.onError(th2);
                } catch (Throwable th3) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th3);
                }
            }
            p041if.fe.qw.fe(arrayList);
        }

        public void onNext(T t) {
            for (PublishSubjectProducer onNext : (PublishSubjectProducer[]) get()) {
                onNext.onNext(t);
            }
        }

        public void remove(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer<T>[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            do {
                publishSubjectProducerArr = (PublishSubjectProducer[]) get();
                if (publishSubjectProducerArr != TERMINATED && publishSubjectProducerArr != EMPTY) {
                    int length = publishSubjectProducerArr.length;
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (publishSubjectProducerArr[i3] == publishSubjectProducer) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            publishSubjectProducerArr2 = EMPTY;
                        } else {
                            PublishSubjectProducer[] publishSubjectProducerArr3 = new PublishSubjectProducer[(length - 1)];
                            System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr3, 0, i2);
                            System.arraycopy(publishSubjectProducerArr, i2 + 1, publishSubjectProducerArr3, i2, (length - i2) - 1);
                            publishSubjectProducerArr2 = publishSubjectProducerArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
        }

        public void call(de<? super T> deVar) {
            PublishSubjectProducer publishSubjectProducer = new PublishSubjectProducer(this, deVar);
            deVar.add(publishSubjectProducer);
            deVar.setProducer(publishSubjectProducer);
            if (!add(publishSubjectProducer)) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    deVar.onError(th2);
                } else {
                    deVar.onCompleted();
                }
            } else if (publishSubjectProducer.isUnsubscribed()) {
                remove(publishSubjectProducer);
            }
        }
    }

    public PublishSubject(PublishSubjectState<T> publishSubjectState) {
        super(publishSubjectState);
        this.f11478th = publishSubjectState;
    }

    public static <T> PublishSubject<T> eee() {
        return new PublishSubject<>(new PublishSubjectState());
    }

    public void onCompleted() {
        this.f11478th.onCompleted();
    }

    public void onError(Throwable th2) {
        this.f11478th.onError(th2);
    }

    public void onNext(T t) {
        this.f11478th.onNext(t);
    }
}
