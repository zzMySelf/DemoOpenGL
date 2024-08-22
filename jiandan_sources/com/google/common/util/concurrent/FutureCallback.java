package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public interface FutureCallback<V> {
    void onFailure(Throwable th2);

    void onSuccess(@NullableDecl V v);
}
