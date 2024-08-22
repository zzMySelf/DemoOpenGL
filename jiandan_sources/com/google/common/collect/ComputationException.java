package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public class ComputationException extends RuntimeException {
    public static final long serialVersionUID = 0;

    public ComputationException(@NullableDecl Throwable th2) {
        super(th2);
    }
}
