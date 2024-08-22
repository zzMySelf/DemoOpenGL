package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
public class UncheckedTimeoutException extends RuntimeException {
    public static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@NullableDecl String str) {
        super(str);
    }

    public UncheckedTimeoutException(@NullableDecl Throwable th2) {
        super(th2);
    }

    public UncheckedTimeoutException(@NullableDecl String str, @NullableDecl Throwable th2) {
        super(str, th2);
    }
}
