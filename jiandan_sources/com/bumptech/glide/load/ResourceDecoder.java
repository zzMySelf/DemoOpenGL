package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import fe.rg.qw.o.ad;
import java.io.IOException;

public interface ResourceDecoder<T, Z> {
    @Nullable
    Resource<Z> ad(@NonNull T t, int i2, int i3, @NonNull ad adVar) throws IOException;

    boolean qw(@NonNull T t, @NonNull ad adVar) throws IOException;
}
