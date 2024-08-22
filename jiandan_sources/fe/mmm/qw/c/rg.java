package fe.mmm.qw.c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;

public class rg implements Executor {

    /* renamed from: ad  reason: collision with root package name */
    public final BlockingQueue<Runnable> f7673ad = new LinkedBlockingDeque();

    public void execute(Runnable runnable) {
        this.f7673ad.offer(runnable);
    }

    public Runnable qw() throws InterruptedException {
        return this.f7673ad.take();
    }
}
