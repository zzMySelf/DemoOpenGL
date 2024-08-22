package fe.qw.qw;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.LottieListener;
import fe.qw.qw.ggg.fe;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class uk<T> {

    /* renamed from: rg  reason: collision with root package name */
    public static Executor f3516rg = Executors.newCachedThreadPool();

    /* renamed from: ad  reason: collision with root package name */
    public final Set<LottieListener<Throwable>> f3517ad;

    /* renamed from: de  reason: collision with root package name */
    public final Handler f3518de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public volatile yj<T> f3519fe;
    public final Set<LottieListener<T>> qw;

    public class ad extends FutureTask<yj<T>> {
        public ad(Callable<yj<T>> callable) {
            super(callable);
        }

        public void done() {
            if (!isCancelled()) {
                try {
                    uk.this.m244if((yj) get());
                } catch (InterruptedException | ExecutionException e) {
                    uk.this.m244if(new yj(e));
                }
            }
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            if (uk.this.f3519fe != null) {
                yj qw = uk.this.f3519fe;
                if (qw.ad() != null) {
                    uk.this.i(qw.ad());
                } else {
                    uk.this.yj(qw.qw());
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public uk(Callable<yj<T>> callable) {
        this(callable, false);
    }

    public final synchronized void i(T t) {
        for (LottieListener onResult : new ArrayList(this.qw)) {
            onResult.onResult(t);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m244if(@Nullable yj<T> yjVar) {
        if (this.f3519fe == null) {
            this.f3519fe = yjVar;
            uk();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized uk<T> o(LottieListener<Throwable> lottieListener) {
        this.f3517ad.remove(lottieListener);
        return this;
    }

    public synchronized uk<T> pf(LottieListener<T> lottieListener) {
        this.qw.remove(lottieListener);
        return this;
    }

    public synchronized uk<T> rg(LottieListener<Throwable> lottieListener) {
        if (!(this.f3519fe == null || this.f3519fe.qw() == null)) {
            lottieListener.onResult(this.f3519fe.qw());
        }
        this.f3517ad.add(lottieListener);
        return this;
    }

    public synchronized uk<T> th(LottieListener<T> lottieListener) {
        if (!(this.f3519fe == null || this.f3519fe.ad() == null)) {
            lottieListener.onResult(this.f3519fe.ad());
        }
        this.qw.add(lottieListener);
        return this;
    }

    public final void uk() {
        this.f3518de.post(new qw());
    }

    public final synchronized void yj(Throwable th2) {
        ArrayList<LottieListener> arrayList = new ArrayList<>(this.f3517ad);
        if (arrayList.isEmpty()) {
            fe.fe("Lottie encountered an error but no failure listener was added:", th2);
            return;
        }
        for (LottieListener onResult : arrayList) {
            onResult.onResult(th2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public uk(Callable<yj<T>> callable, boolean z) {
        this.qw = new LinkedHashSet(1);
        this.f3517ad = new LinkedHashSet(1);
        this.f3518de = new Handler(Looper.getMainLooper());
        this.f3519fe = null;
        if (z) {
            try {
                m244if(callable.call());
            } catch (Throwable th2) {
                m244if(new yj(th2));
            }
        } else {
            f3516rg.execute(new ad(callable));
        }
    }
}
