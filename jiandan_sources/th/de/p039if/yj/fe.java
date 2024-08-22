package th.de.p039if.yj;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import th.de.ppp.qw;

/* renamed from: th.de.if.yj.fe  reason: invalid package */
public final class fe {
    public static void ad(Class<?> cls) {
        qw.ddd(new ProtocolViolationException(qw(cls.getName())));
    }

    public static boolean de(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        th.de.p039if.ad.qw.rg(disposable, "next is null");
        if (atomicReference.compareAndSet((Object) null, disposable)) {
            return true;
        }
        disposable.dispose();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        ad(cls);
        return false;
    }

    public static boolean fe(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> cls) {
        th.de.p039if.ad.qw.rg(subscription, "next is null");
        if (atomicReference.compareAndSet((Object) null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
            return false;
        }
        ad(cls);
        return false;
    }

    public static String qw(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static boolean rg(Disposable disposable, Disposable disposable2, Class<?> cls) {
        th.de.p039if.ad.qw.rg(disposable2, "next is null");
        if (disposable == null) {
            return true;
        }
        disposable2.dispose();
        if (disposable == DisposableHelper.DISPOSED) {
            return false;
        }
        ad(cls);
        return false;
    }
}
