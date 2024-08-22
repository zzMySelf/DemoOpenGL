package com.dxmbumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.Key;
import java.io.File;

public interface DiskCache {

    public interface Factory {
        @Nullable
        DiskCache build();
    }

    public interface Writer {
        boolean qw(@NonNull File file);
    }

    @Nullable
    File ad(Key key);

    void qw(Key key, Writer writer);
}
