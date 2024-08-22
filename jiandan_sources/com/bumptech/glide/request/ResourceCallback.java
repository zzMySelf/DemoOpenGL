package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

public interface ResourceCallback {
    void qw(GlideException glideException);

    void rg(Resource<?> resource, DataSource dataSource);
}
