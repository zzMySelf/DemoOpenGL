package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import fe.rg.qw.o.fe.aaa.de;
import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: ad  reason: collision with root package name */
    public final CacheDirectoryGetter f3688ad;
    public final long qw;

    public interface CacheDirectoryGetter {
        File qw();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.qw = j;
        this.f3688ad = cacheDirectoryGetter;
    }

    public DiskCache build() {
        File qw2 = this.f3688ad.qw();
        if (qw2 == null) {
            return null;
        }
        if (qw2.mkdirs() || (qw2.exists() && qw2.isDirectory())) {
            return de.de(qw2, this.qw);
        }
        return null;
    }
}
