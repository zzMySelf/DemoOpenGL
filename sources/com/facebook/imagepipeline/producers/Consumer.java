package com.facebook.imagepipeline.producers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;

public interface Consumer<T> {
    public static final int DO_NOT_CACHE_ENCODED = 2;
    public static final int IS_LAST = 1;
    public static final int IS_PARTIAL_RESULT = 8;
    public static final int IS_PLACEHOLDER = 4;
    public static final int IS_RESIZING_DONE = 16;
    public static final int NO_FLAGS = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    void onCancellation();

    void onFailure(Throwable th2);

    void onNewResult(@Nullable T t, int i2);

    void onProgressUpdate(float f2);
}
