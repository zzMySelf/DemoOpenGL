package com.dxmbumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.Resource;
import fe.uk.qw.pf.ad;

public interface ResourceTranscoder<Z, R> {
    @Nullable
    Resource<R> qw(@NonNull Resource<Z> resource, @NonNull ad adVar);
}
