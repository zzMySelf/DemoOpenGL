package th.de.p039if.yj;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NonBlockingThread;
import java.util.concurrent.CountDownLatch;
import th.de.ppp.qw;

/* renamed from: th.de.if.yj.ad  reason: invalid package */
public final class ad {
    public static void ad() {
        if (!qw.o()) {
            return;
        }
        if ((Thread.currentThread() instanceof NonBlockingThread) || qw.vvv()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }

    public static void qw(CountDownLatch countDownLatch, Disposable disposable) {
        if (countDownLatch.getCount() != 0) {
            try {
                ad();
                countDownLatch.await();
            } catch (InterruptedException e) {
                disposable.dispose();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e);
            }
        }
    }
}
