package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void de(@NonNull Exception exc);

        void rg(@Nullable T t);
    }

    void ad();

    void cancel();

    @NonNull
    DataSource fe();

    @NonNull
    Class<T> qw();

    void th(@NonNull Priority priority, @NonNull DataCallback<? super T> dataCallback);
}
