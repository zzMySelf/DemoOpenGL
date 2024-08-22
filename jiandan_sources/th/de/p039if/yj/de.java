package th.de.p039if.yj;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

/* renamed from: th.de.if.yj.de  reason: invalid package */
public final class de extends CountDownLatch implements Consumer<Throwable>, Action {

    /* renamed from: ad  reason: collision with root package name */
    public Throwable f10989ad;

    public de() {
        super(1);
    }

    /* renamed from: qw */
    public void accept(Throwable th2) {
        this.f10989ad = th2;
        countDown();
    }

    public void run() {
        countDown();
    }
}
