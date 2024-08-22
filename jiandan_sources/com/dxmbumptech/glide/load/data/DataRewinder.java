package com.dxmbumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

public interface DataRewinder<T> {

    public interface Factory<T> {
        @NonNull
        DataRewinder<T> ad(@NonNull T t);

        @NonNull
        Class<T> qw();
    }

    void ad();

    @NonNull
    T qw() throws IOException;
}
