package th.de.p039if.fe.rg;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.ExceptionHelper;
import th.de.p039if.ad.qw;
import th.de.p039if.yj.ad;
import th.de.p039if.yj.de;

/* renamed from: th.de.if.fe.rg.i  reason: invalid package */
public final class i {
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void ad(io.reactivex.ObservableSource<? extends T> r4, io.reactivex.Observer<? super T> r5) {
        /*
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
            io.reactivex.internal.observers.BlockingObserver r1 = new io.reactivex.internal.observers.BlockingObserver
            r1.<init>(r0)
            r5.onSubscribe(r1)
            r4.subscribe(r1)
        L_0x0010:
            boolean r2 = r1.isDisposed()
            if (r2 == 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            java.lang.Object r2 = r0.poll()
            if (r2 != 0) goto L_0x002a
            java.lang.Object r2 = r0.take()     // Catch:{ InterruptedException -> 0x0022 }
            goto L_0x002a
        L_0x0022:
            r4 = move-exception
            r1.dispose()
            r5.onError(r4)
            return
        L_0x002a:
            boolean r3 = r1.isDisposed()
            if (r3 != 0) goto L_0x003a
            java.lang.Object r3 = io.reactivex.internal.observers.BlockingObserver.TERMINATED
            if (r4 == r3) goto L_0x003a
            boolean r2 = io.reactivex.internal.util.NotificationLite.acceptFull((java.lang.Object) r2, r5)
            if (r2 == 0) goto L_0x0010
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: th.de.p039if.fe.rg.i.ad(io.reactivex.ObservableSource, io.reactivex.Observer):void");
    }

    public static <T> void de(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        qw.rg(consumer, "onNext is null");
        qw.rg(consumer2, "onError is null");
        qw.rg(action, "onComplete is null");
        ad(observableSource, new LambdaObserver(consumer, consumer2, action, Functions.yj()));
    }

    public static <T> void qw(ObservableSource<? extends T> observableSource) {
        de deVar = new de();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.yj(), deVar, deVar, Functions.yj());
        observableSource.subscribe(lambdaObserver);
        ad.qw(deVar, lambdaObserver);
        Throwable th2 = deVar.f10989ad;
        if (th2 != null) {
            throw ExceptionHelper.fe(th2);
        }
    }
}
