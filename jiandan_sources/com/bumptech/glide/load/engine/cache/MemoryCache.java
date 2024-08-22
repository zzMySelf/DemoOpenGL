package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface MemoryCache {

    public interface ResourceRemovedListener {
        void qw(@NonNull Resource<?> resource);
    }

    void ad();

    @Nullable
    Resource<?> de(@NonNull Key key, @Nullable Resource<?> resource);

    @Nullable
    Resource<?> fe(@NonNull Key key);

    void qw(int i2);

    void rg(@NonNull ResourceRemovedListener resourceRemovedListener);
}
