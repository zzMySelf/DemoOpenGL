package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public class UncheckedExecutionException extends RuntimeException {
    public static final long serialVersionUID = 0;

    public UncheckedExecutionException() {
    }

    public UncheckedExecutionException(@NullableDecl String str) {
        super(str);
    }

    public UncheckedExecutionException(@NullableDecl String str, @NullableDecl Throwable th2) {
        super(str, th2);
    }

    public UncheckedExecutionException(@NullableDecl Throwable th2) {
        super(th2);
    }
}
