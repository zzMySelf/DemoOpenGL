package io.reactivex.internal.schedulers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import th.de.th;

public class SchedulerWhen extends th implements Disposable {

    /* renamed from: th  reason: collision with root package name */
    public static final Disposable f10315th = new ad();

    /* renamed from: yj  reason: collision with root package name */
    public static final Disposable f10316yj = th.de.i.ad.qw();

    public static class DelayedAction extends ScheduledAction {
        public final Runnable action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(Runnable runnable, long j, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        public Disposable callActual(th.de deVar, CompletableObserver completableObserver) {
            return deVar.de(new qw(this.action, completableObserver), this.delayTime, this.unit);
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        public final Runnable action;

        public ImmediateAction(Runnable runnable) {
            this.action = runnable;
        }

        public Disposable callActual(th.de deVar, CompletableObserver completableObserver) {
            return deVar.ad(new qw(this.action, completableObserver));
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        public ScheduledAction() {
            super(SchedulerWhen.f10315th);
        }

        public void call(th.de deVar, CompletableObserver completableObserver) {
            Disposable disposable = (Disposable) get();
            if (disposable != SchedulerWhen.f10316yj && disposable == SchedulerWhen.f10315th) {
                Disposable callActual = callActual(deVar, completableObserver);
                if (!compareAndSet(SchedulerWhen.f10315th, callActual)) {
                    callActual.dispose();
                }
            }
        }

        public abstract Disposable callActual(th.de deVar, CompletableObserver completableObserver);

        public void dispose() {
            Disposable disposable;
            Disposable disposable2 = SchedulerWhen.f10316yj;
            do {
                disposable = (Disposable) get();
                if (disposable == SchedulerWhen.f10316yj) {
                    return;
                }
            } while (!compareAndSet(disposable, disposable2));
            if (disposable != SchedulerWhen.f10315th) {
                disposable.dispose();
            }
        }

        public boolean isDisposed() {
            return ((Disposable) get()).isDisposed();
        }
    }

    public static final class ad implements Disposable {
        public void dispose() {
        }

        public boolean isDisposed() {
            return false;
        }
    }

    public static class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final CompletableObserver f10317ad;

        /* renamed from: th  reason: collision with root package name */
        public final Runnable f10318th;

        public qw(Runnable runnable, CompletableObserver completableObserver) {
            this.f10318th = runnable;
            this.f10317ad = completableObserver;
        }

        public void run() {
            try {
                this.f10318th.run();
            } finally {
                this.f10317ad.onComplete();
            }
        }
    }
}
