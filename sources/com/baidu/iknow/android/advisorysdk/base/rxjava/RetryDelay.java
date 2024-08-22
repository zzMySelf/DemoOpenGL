package com.baidu.iknow.android.advisorysdk.base.rxjava;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public class RetryDelay implements Func1<Observable<? extends Throwable>, Observable<?>> {
    /* access modifiers changed from: private */
    public CheckListener checkListener;
    /* access modifiers changed from: private */
    public final int maxRetries;
    private int retryCount;
    /* access modifiers changed from: private */
    public final int retryDelayMillis;

    public interface CheckListener {
        boolean check(Throwable th2);
    }

    static /* synthetic */ int access$104(RetryDelay x0) {
        int i2 = x0.retryCount + 1;
        x0.retryCount = i2;
        return i2;
    }

    public RetryDelay(int maxRetries2, int retryDelayMillis2, CheckListener checkListener2) {
        this.maxRetries = maxRetries2;
        this.retryDelayMillis = retryDelayMillis2;
        this.checkListener = checkListener2;
    }

    public Observable<?> call(Observable<? extends Throwable> attempts) {
        return attempts.flatMap(new Func1<Throwable, Observable<?>>() {
            public Observable<?> call(Throwable throwable) {
                if (RetryDelay.this.checkListener == null || !RetryDelay.this.checkListener.check(throwable) || RetryDelay.access$104(RetryDelay.this) > RetryDelay.this.maxRetries) {
                    return Observable.error(throwable);
                }
                return Observable.timer((long) RetryDelay.this.retryDelayMillis, TimeUnit.MILLISECONDS);
            }
        });
    }
}
