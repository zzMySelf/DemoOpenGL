package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

public final class AtomicThrowable extends AtomicReference<Throwable> {
    public static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th2) {
        return ExceptionHelper.qw(this, th2);
    }

    public boolean isTerminated() {
        return get() == ExceptionHelper.qw;
    }

    public Throwable terminate() {
        return ExceptionHelper.ad(this);
    }
}
