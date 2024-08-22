package io.reactivex.internal.schedulers;

import th.de.ppp.qw;

public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    public static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    public /* bridge */ /* synthetic */ Runnable getWrappedRunnable() {
        return super.getWrappedRunnable();
    }

    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th2) {
            this.runner = null;
            lazySet(AbstractDirectTask.FINISHED);
            qw.ddd(th2);
        }
    }
}
