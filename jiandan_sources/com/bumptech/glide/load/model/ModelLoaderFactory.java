package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import fe.rg.qw.o.rg.i;

public interface ModelLoaderFactory<T, Y> {
    @NonNull
    ModelLoader<T, Y> ad(@NonNull i iVar);
}
