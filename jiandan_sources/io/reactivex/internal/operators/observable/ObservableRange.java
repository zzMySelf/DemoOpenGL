package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import th.de.rg;

public final class ObservableRange extends rg<Integer> {

    /* renamed from: ad  reason: collision with root package name */
    public final int f10172ad;

    /* renamed from: th  reason: collision with root package name */
    public final long f10173th;

    public static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        public static final long serialVersionUID = 396518478098735504L;
        public final Observer<? super Integer> downstream;
        public final long end;
        public boolean fused;
        public long index;

        public RangeDisposable(Observer<? super Integer> observer, long j, long j2) {
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
                Observer<? super Integer> observer = this.downstream;
                long j = this.end;
                for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                    observer.onNext(Integer.valueOf((int) j2));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        public Integer poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRange(int i2, int i3) {
        this.f10172ad = i2;
        this.f10173th = ((long) i2) + ((long) i3);
    }

    public void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, (long) this.f10172ad, this.f10173th);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
