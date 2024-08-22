package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public final class Platform {
    public static boolean isInstanceOfThrowableClass(@NullableDecl Throwable th2, Class<? extends Throwable> cls) {
        return cls.isInstance(th2);
    }
}
