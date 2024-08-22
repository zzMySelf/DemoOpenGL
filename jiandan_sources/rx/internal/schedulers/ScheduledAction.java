package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p041if.pf.ad;
import p041if.rg.fe.yj;
import p041if.uk.de;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;

public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    public static final long serialVersionUID = -3962399486978279857L;
    public final Action0 action;
    public final yj cancel;

    public static final class Remover extends AtomicBoolean implements Subscription {
        public static final long serialVersionUID = 247232374289553518L;
        public final ad parent;
        public final ScheduledAction s;

        public Remover(ScheduledAction scheduledAction, ad adVar) {
            this.s = scheduledAction;
            this.parent = adVar;
        }

        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.ad(this.s);
            }
        }
    }

    public static final class Remover2 extends AtomicBoolean implements Subscription {
        public static final long serialVersionUID = 247232374289553518L;
        public final yj parent;
        public final ScheduledAction s;

        public Remover2(ScheduledAction scheduledAction, yj yjVar) {
            this.s = scheduledAction;
            this.parent = yjVar;
        }

        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.ad(this.s);
            }
        }
    }

    public final class qw implements Subscription {

        /* renamed from: ad  reason: collision with root package name */
        public final Future<?> f11446ad;

        public qw(Future<?> future) {
            this.f11446ad = future;
        }

        public boolean isUnsubscribed() {
            return this.f11446ad.isCancelled();
        }

        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f11446ad.cancel(true);
            } else {
                this.f11446ad.cancel(false);
            }
        }
    }

    public ScheduledAction(Action0 action0) {
        this.action = action0;
        this.cancel = new yj();
    }

    public void add(Subscription subscription) {
        this.cancel.qw(subscription);
    }

    public void addParent(ad adVar) {
        this.cancel.qw(new Remover(this, adVar));
    }

    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    public void run() {
        try {
            lazySet(Thread.currentThread());
            this.action.call();
        } catch (OnErrorNotImplementedException e) {
            signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
        } catch (Throwable th2) {
            unsubscribe();
            throw th2;
        }
        unsubscribe();
    }

    public void signalError(Throwable th2) {
        de.i(th2);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }

    public void add(Future<?> future) {
        this.cancel.qw(new qw(future));
    }

    public void addParent(yj yjVar) {
        this.cancel.qw(new Remover2(this, yjVar));
    }

    public ScheduledAction(Action0 action0, ad adVar) {
        this.action = action0;
        this.cancel = new yj((Subscription) new Remover(this, adVar));
    }

    public ScheduledAction(Action0 action0, yj yjVar) {
        this.action = action0;
        this.cancel = new yj((Subscription) new Remover2(this, yjVar));
    }
}
