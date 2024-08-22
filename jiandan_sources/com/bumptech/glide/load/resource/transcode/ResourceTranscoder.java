package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.o.ad;

public interface ResourceTranscoder<Z, R> {
    @Nullable
    Resource<R> qw(@NonNull Resource<Z> resource, @NonNull ad adVar);
}
