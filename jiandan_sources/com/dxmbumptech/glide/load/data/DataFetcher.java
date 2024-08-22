package com.dxmbumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.Priority;
import com.dxmbumptech.glide.load.DataSource;

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
