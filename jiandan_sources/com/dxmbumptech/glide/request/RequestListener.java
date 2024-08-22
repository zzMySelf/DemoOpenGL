package com.dxmbumptech.glide.request;

import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.engine.GlideException;
import com.dxmbumptech.glide.request.target.Target;

public interface RequestListener<R> {
    boolean ad(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z);

    boolean qw(R r, Object obj, Target<R> target, DataSource dataSource, boolean z);
}
