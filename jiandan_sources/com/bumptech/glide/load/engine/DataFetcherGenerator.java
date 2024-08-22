package com.bumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

public interface DataFetcherGenerator {

    public interface FetcherReadyCallback {
        void ad();

        void th(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource);

        void uk(Key key, @Nullable Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2);
    }

    void cancel();

    boolean qw();
}
