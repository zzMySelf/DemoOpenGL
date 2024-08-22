package com.dxmbumptech.glide.load.engine.cache;

import com.dxmbumptech.glide.load.engine.cache.DiskCache;
import fe.uk.qw.pf.fe.aaa.de;
import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: ad  reason: collision with root package name */
    public final CacheDirectoryGetter f3853ad;
    public final long qw;

    public interface CacheDirectoryGetter {
        File qw();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j) {
        this.qw = j;
        this.f3853ad = cacheDirectoryGetter;
    }

    public DiskCache build() {
        File qw2 = this.f3853ad.qw();
        if (qw2 == null) {
            return null;
        }
        if (qw2.isDirectory() || qw2.mkdirs()) {
            return de.de(qw2, this.qw);
        }
        return null;
    }
}
