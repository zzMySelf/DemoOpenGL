package com.dxmbumptech.glide.request;

import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.engine.GlideException;
import com.dxmbumptech.glide.load.engine.Resource;

public interface ResourceCallback {
    Object fe();

    void rg(GlideException glideException);

    void th(Resource<?> resource, DataSource dataSource, boolean z);
}
