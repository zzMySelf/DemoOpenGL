package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import th.de.rg;

public final class ObservableRangeLong extends rg<Long> {

    /* renamed from: ad  reason: collision with root package name */
    public final long f10174ad;

    /* renamed from: th  reason: collision with root package name */
    public final long f10175th;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        public static final long serialVersionUID = 396518478098735504L;
        public final Observer<? super Long> downstream;
        public final long end;
        public boolean fused;
        public long index;

        public RangeDisposable(Observer<? super Long> observer, long j, long j2) {
            this.downstream = observer;
            this.index = j;
            this.end = j2;
        }

        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        public void dispose() {
            set(1);
        }

        public boolean isDisposed() {
            return get() != 0;
        }

        public boolean isEmpty() {
            return this.index == this.end;
        }

        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        public void run() {
            if (!this.fused) {
                Observer<? super Long> observer = this.downstream;
                long j = this.end;
                for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                    observer.onNext(Long.valueOf(j2));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        public Long poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Long.valueOf(j);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRangeLong(long j, long j2) {
        this.f10174ad = j;
        this.f10175th = j2;
    }

    public void subscribeActual(Observer<? super Long> observer) {
        long j = this.f10174ad;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j, j + this.f10175th);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
