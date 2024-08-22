package com.dxmbumptech.glide.load.engine;

import androidx.annotation.NonNull;

public interface Resource<Z> {
    @NonNull
    Class<Z> ad();

    @NonNull
    Z get();

    int qw();

    void recycle();
}
