package com.dxmbumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.Resource;

public interface MemoryCache {

    public interface ResourceRemovedListener {
        void de(@NonNull Resource<?> resource);
    }

    void ad();

    @Nullable
    Resource<?> de(@NonNull Key key, @Nullable Resource<?> resource);

    void fe(@NonNull ResourceRemovedListener resourceRemovedListener);

    void qw(int i2);

    @Nullable
    Resource<?> rg(@NonNull Key key);
}
