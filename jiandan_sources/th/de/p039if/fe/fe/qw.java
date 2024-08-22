package th.de.p039if.fe.fe;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

/* renamed from: th.de.if.fe.fe.qw  reason: invalid package */
public final class qw {
    public static <T, R> boolean ad(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        MaybeSource maybeSource = null;
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = function.apply(call);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null MaybeSource");
                maybeSource = (MaybeSource) apply;
            }
            if (maybeSource == null) {
                EmptyDisposable.complete((Observer<?>) observer);
            } else {
                maybeSource.qw(MaybeToObservable.ad(observer));
            }
            return true;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
            return true;
        }
    }

    public static <T, R> boolean de(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        SingleSource singleSource = null;
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = function.apply(call);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null SingleSource");
                singleSource = (SingleSource) apply;
            }
            if (singleSource == null) {
                EmptyDisposable.complete((Observer<?>) observer);
            } else {
                singleSource.qw(SingleToObservable.ad(observer));
            }
            return true;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, (Observer<?>) observer);
            return true;
        }
    }

    public static <T> boolean qw(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        CompletableSource completableSource = null;
        try {
            Object call = ((Callable) obj).call();
            if (call != null) {
                Object apply = function.apply(call);
                th.de.p039if.ad.qw.rg(apply, "The mapper returned a null CompletableSource");
                completableSource = (CompletableSource) apply;
            }
            if (completableSource == null) {
                EmptyDisposable.complete(completableObserver);
            } else {
                completableSource.qw(completableObserver);
            }
            return true;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            EmptyDisposable.error(th2, completableObserver);
            return true;
        }
    }
}
