package com.dxmbumptech.glide.load.model;

import androidx.annotation.NonNull;
import fe.uk.qw.pf.rg.i;

public interface ModelLoaderFactory<T, Y> {
    @NonNull
    ModelLoader<T, Y> ad(@NonNull i iVar);
}
