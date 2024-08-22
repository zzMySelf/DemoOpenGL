package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

public class TestScheduler extends Scheduler {
    static long counter;
    final Queue<TimedAction> queue = new PriorityQueue(11, new CompareActionsByTime());
    long time;

    static final class TimedAction {
        final Action0 action;
        /* access modifiers changed from: private */
        public final long count;
        final Scheduler.Worker scheduler;
        final long time;

        TimedAction(Scheduler.Worker scheduler2, long time2, Action0 action2) {
            long j2 = TestScheduler.counter;
            TestScheduler.counter = 1 + j2;
            this.count = j2;
            this.time = time2;
            this.action = action2;
            this.scheduler = scheduler2;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", new Object[]{Long.valueOf(this.time), this.action.toString()});
        }
    }

    static final class CompareActionsByTime implements Comparator<TimedAction> {
        CompareActionsByTime() {
        }

        public int compare(TimedAction action1, TimedAction action2) {
            if (action1.time == action2.time) {
                if (action1.count < action2.count) {
                    return -1;
                }
                if (action1.count > action2.count) {
                    return 1;
                }
                return 0;
            } else if (action1.time < action2.time) {
                return -1;
            } else {
                if (action1.time > action2.time) {
                    return 1;
                }
                return 0;
            }
        }
    }

    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.time);
    }

    public void advanceTimeBy(long delayTime, TimeUnit unit) {
        advanceTimeTo(this.time + unit.toNanos(delayTime), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long delayTime, TimeUnit unit) {
        triggerActions(unit.toNanos(delayTime));
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long targetTimeInNanos) {
        while (!this.queue.isEmpty()) {
            TimedAction current = this.queue.peek();
            if (current.time > targetTimeInNanos) {
                break;
            }
            this.time = current.time == 0 ? this.time : current.time;
            this.queue.remove();
            if (!current.scheduler.isUnsubscribed()) {
                current.action.call();
            }
        }
        this.time = targetTimeInNanos;
    }

    public Scheduler.Worker createWorker() {
        return new InnerTestScheduler();
    }

    final class InnerTestScheduler extends Scheduler.Worker {
        private final BooleanSubscription s = new BooleanSubscription();

        InnerTestScheduler() {
        }

        public void unsubscribe() {
            this.s.unsubscribe();
        }

        public boolean isUnsubscribed() {
            return this.s.isUnsubscribed();
        }

        public Subscription schedule(Action0 action, long delayTime, TimeUnit unit) {
            final TimedAction timedAction = new TimedAction(this, TestScheduler.this.time + unit.toNanos(delayTime), action);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() {
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }

        public Subscription schedule(Action0 action) {
            final TimedAction timedAction = new TimedAction(this, 0, action);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() {
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }

        public long now() {
            return TestScheduler.this.now();
        }
    }
}
