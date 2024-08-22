package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p041if.pf.fe;
import p041if.qw;
import rx.CompletableSubscriber;
import rx.Subscription;
import rx.functions.Action0;

public class SchedulerWhen extends p041if.qw implements Subscription {

    /* renamed from: ad  reason: collision with root package name */
    public static final Subscription f11448ad = new qw();

    /* renamed from: th  reason: collision with root package name */
    public static final Subscription f11449th = fe.ad();

    public static class DelayedAction extends ScheduledAction {
        public final Action0 action;
        public final long delayTime;
        public final TimeUnit unit;

        public DelayedAction(Action0 action0, long j, TimeUnit timeUnit) {
            this.action = action0;
            this.delayTime = j;
            this.unit = timeUnit;
        }

        public Subscription callActual(qw.C0349qw qwVar, CompletableSubscriber completableSubscriber) {
            return qwVar.fe(new ad(this.action, completableSubscriber), this.delayTime, this.unit);
        }
    }

    public static class ImmediateAction extends ScheduledAction {
        public final Action0 action;

        public ImmediateAction(Action0 action0) {
            this.action = action0;
        }

        public Subscription callActual(qw.C0349qw qwVar, CompletableSubscriber completableSubscriber) {
            return qwVar.de(new ad(this.action, completableSubscriber));
        }
    }

    public static abstract class ScheduledAction extends AtomicReference<Subscription> implements Subscription {
        public ScheduledAction() {
            super(SchedulerWhen.f11448ad);
        }

        /* access modifiers changed from: private */
        public void call(qw.C0349qw qwVar, CompletableSubscriber completableSubscriber) {
            Subscription subscription = (Subscription) get();
            if (subscription != SchedulerWhen.f11449th && subscription == SchedulerWhen.f11448ad) {
                Subscription callActual = callActual(qwVar, completableSubscriber);
                if (!compareAndSet(SchedulerWhen.f11448ad, callActual)) {
                    callActual.unsubscribe();
                }
            }
        }

        public abstract Subscription callActual(qw.C0349qw qwVar, CompletableSubscriber completableSubscriber);

        public boolean isUnsubscribed() {
            return ((Subscription) get()).isUnsubscribed();
        }

        public void unsubscribe() {
            Subscription subscription;
            Subscription subscription2 = SchedulerWhen.f11449th;
            do {
                subscription = (Subscription) get();
                if (subscription == SchedulerWhen.f11449th) {
                    return;
                }
            } while (!compareAndSet(subscription, subscription2));
            if (subscription != SchedulerWhen.f11448ad) {
                subscription.unsubscribe();
            }
        }
    }

    public static class ad implements Action0 {

        /* renamed from: ad  reason: collision with root package name */
        public CompletableSubscriber f11450ad;

        /* renamed from: th  reason: collision with root package name */
        public Action0 f11451th;

        public ad(Action0 action0, CompletableSubscriber completableSubscriber) {
            this.f11451th = action0;
            this.f11450ad = completableSubscriber;
        }

        public void call() {
            try {
                this.f11451th.call();
            } finally {
                this.f11450ad.onCompleted();
            }
        }
    }

    public static class qw implements Subscription {
        public boolean isUnsubscribed() {
            return false;
        }

        public void unsubscribe() {
        }
    }
}
