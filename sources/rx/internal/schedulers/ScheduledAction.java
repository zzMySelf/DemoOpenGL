package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    private static final long serialVersionUID = -3962399486978279857L;
    final Action0 action;
    final SubscriptionList cancel;

    public ScheduledAction(Action0 action2) {
        this.action = action2;
        this.cancel = new SubscriptionList();
    }

    public ScheduledAction(Action0 action2, CompositeSubscription parent) {
        this.action = action2;
        this.cancel = new SubscriptionList((Subscription) new Remover(this, parent));
    }

    public ScheduledAction(Action0 action2, SubscriptionList parent) {
        this.action = action2;
        this.cancel = new SubscriptionList((Subscription) new Remover2(this, parent));
    }

    public void run() {
        try {
            lazySet(Thread.currentThread());
            this.action.call();
        } catch (OnErrorNotImplementedException e2) {
            signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e2));
        } catch (Throwable th2) {
            unsubscribe();
            throw th2;
        }
        unsubscribe();
    }

    /* access modifiers changed from: package-private */
    public void signalError(Throwable ie) {
        RxJavaHooks.onError(ie);
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, ie);
    }

    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }

    public void add(Subscription s) {
        this.cancel.add(s);
    }

    public void add(Future<?> f2) {
        this.cancel.add(new FutureCompleter(f2));
    }

    public void addParent(CompositeSubscription parent) {
        this.cancel.add(new Remover(this, parent));
    }

    public void addParent(SubscriptionList parent) {
        this.cancel.add(new Remover2(this, parent));
    }

    final class FutureCompleter implements Subscription {

        /* renamed from: f  reason: collision with root package name */
        private final Future<?> f7803f;

        FutureCompleter(Future<?> f2) {
            this.f7803f = f2;
        }

        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f7803f.cancel(true);
            } else {
                this.f7803f.cancel(false);
            }
        }

        public boolean isUnsubscribed() {
            return this.f7803f.isCancelled();
        }
    }

    static final class Remover extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        final CompositeSubscription parent;
        final ScheduledAction s;

        public Remover(ScheduledAction s2, CompositeSubscription parent2) {
            this.s = s2;
            this.parent = parent2;
        }

        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this.s);
            }
        }
    }

    static final class Remover2 extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        final SubscriptionList parent;
        final ScheduledAction s;

        public Remover2(ScheduledAction s2, SubscriptionList parent2) {
            this.s = s2;
            this.parent = parent2;
        }

        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this.s);
            }
        }
    }
}
