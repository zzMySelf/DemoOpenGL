package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {
    public static final Throwable qw = new Termination();

    public static final class Termination extends Throwable {
        public static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public static <T> Throwable ad(AtomicReference<Throwable> atomicReference) {
        Throwable th2 = atomicReference.get();
        Throwable th3 = qw;
        return th2 != th3 ? atomicReference.getAndSet(th3) : th2;
    }

    public static String de(long j, TimeUnit timeUnit) {
        return "The source did not signal an event for " + j + " " + timeUnit.toString().toLowerCase() + " and has been terminated.";
    }

    public static RuntimeException fe(Throwable th2) {
        if (th2 instanceof Error) {
            throw ((Error) th2);
        } else if (th2 instanceof RuntimeException) {
            return (RuntimeException) th2;
        } else {
            return new RuntimeException(th2);
        }
    }

    public static <T> boolean qw(AtomicReference<Throwable> atomicReference, Throwable th2) {
        Throwable th3;
        Throwable th4;
        do {
            th3 = atomicReference.get();
            if (th3 == qw) {
                return false;
            }
            if (th3 == null) {
                th4 = th2;
            } else {
                th4 = new CompositeException(th3, th2);
            }
        } while (!atomicReference.compareAndSet(th3, th4));
        return true;
    }
}
