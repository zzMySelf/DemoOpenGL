package okio;

import java.util.concurrent.TimeUnit;

public final class PushableTimeout extends Timeout {
    public long originalDeadlineNanoTime;
    public boolean originalHasDeadline;
    public long originalTimeoutNanos;
    public Timeout pushed;

    public void pop() {
        this.pushed.timeout(this.originalTimeoutNanos, TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline) {
            this.pushed.deadlineNanoTime(this.originalDeadlineNanoTime);
        } else {
            this.pushed.clearDeadline();
        }
    }

    public void push(Timeout timeout) {
        this.pushed = timeout;
        boolean hasDeadline = timeout.hasDeadline();
        this.originalHasDeadline = hasDeadline;
        this.originalDeadlineNanoTime = hasDeadline ? timeout.deadlineNanoTime() : -1;
        long timeoutNanos = timeout.timeoutNanos();
        this.originalTimeoutNanos = timeoutNanos;
        timeout.timeout(Timeout.minTimeout(timeoutNanos, timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline && hasDeadline()) {
            timeout.deadlineNanoTime(Math.min(deadlineNanoTime(), this.originalDeadlineNanoTime));
        } else if (hasDeadline()) {
            timeout.deadlineNanoTime(deadlineNanoTime());
        }
    }
}
