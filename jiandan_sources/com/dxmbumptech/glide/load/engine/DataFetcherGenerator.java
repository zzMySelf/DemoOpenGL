package com.dxmbumptech.glide.load.engine;

import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.data.DataFetcher;

public interface DataFetcherGenerator {

    public interface FetcherReadyCallback {
        void ad();

        void rg(Key key, @Nullable Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2);

        void th(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource);
    }

    void cancel();

    boolean qw();
}
