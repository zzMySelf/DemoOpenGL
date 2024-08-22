package com.baidu.swan.apps.impl.prefetch;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.cache.disk.DiskLruCache;
import com.baidu.swan.apps.core.prefetch.image.cache.CacheProvider;
import com.baidu.swan.apps.core.prefetch.image.cache.ICacheLoadFinishListener;
import com.baidu.swan.apps.core.prefetch.image.config.SwanHybridInterceptConfig;
import com.baidu.swan.apps.core.prefetch.image.config.key.ICacheKeyProvider;
import com.baidu.swan.apps.core.prefetch.image.debug.ISwanHybridDebug;
import com.baidu.swan.apps.util.SwanAppUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HybridCacheProvider implements CacheProvider, ISwanHybridDebug {
    private ICacheKeyProvider cacheKeyProvider = SwanHybridInterceptConfig.get().getCacheKeyProvider();
    private DiskLruCache diskLruCache;

    private HybridCacheProvider(Context context, File dir, long maxSize) throws IOException {
        PackageInfo pkgInfo = SwanAppUtils.getPackageInfo(context, context.getPackageName());
        this.diskLruCache = DiskLruCache.open(dir, pkgInfo == null ? 0 : pkgInfo.versionCode, 1, maxSize);
    }

    public static synchronized HybridCacheProvider open(Context context, File dir, long maxSize) throws IOException {
        HybridCacheProvider hybridCacheProvider;
        synchronized (HybridCacheProvider.class) {
            hybridCacheProvider = new HybridCacheProvider(context, dir, maxSize);
        }
        return hybridCacheProvider;
    }

    public InputStream get(String key) {
        if (this.diskLruCache == null || TextUtils.isEmpty(key)) {
            return null;
        }
        try {
            DiskLruCache.Snapshot snapshot = this.diskLruCache.get(this.cacheKeyProvider.buildCacheKey(key));
            if (snapshot != null) {
                return snapshot.getInputStream(0);
            }
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(ISwanHybridDebug.TAG, Log.getStackTraceString(e2));
            }
        }
        return null;
    }

    public void put(String key, File value, ICacheLoadFinishListener listener) {
        if (this.diskLruCache != null && value != null && !TextUtils.isEmpty(key)) {
            DiskLruCache.Editor editor = null;
            try {
                DiskLruCache.Editor editor2 = this.diskLruCache.edit(this.cacheKeyProvider.buildCacheKey(key));
                if (editor2 != null) {
                    if (writeCache(value, editor2.newOutputStream(0)) && listener != null) {
                        listener.onFinished();
                    }
                    editor2.commit();
                }
                this.diskLruCache.flush();
            } catch (IOException e2) {
                if (editor != null) {
                    try {
                        editor.abort();
                    } catch (IOException e1) {
                        if (DEBUG) {
                            Log.e(ISwanHybridDebug.TAG, Log.getStackTraceString(e1));
                        }
                    }
                }
            }
        }
    }

    public boolean isClosed() {
        try {
            DiskLruCache diskLruCache2 = this.diskLruCache;
            if (diskLruCache2 != null) {
                return diskLruCache2.isClosed();
            }
            return true;
        } catch (Exception e2) {
            if (!DEBUG) {
                return true;
            }
            Log.e(ISwanHybridDebug.TAG, Log.getStackTraceString(e2));
            return true;
        }
    }

    private boolean writeCache(File value, OutputStream outputStream) throws IOException {
        if (value == null || !value.exists() || outputStream == null) {
            return false;
        }
        byte[] data = new byte[4096];
        InputStream inputStream = new FileInputStream(value);
        while (true) {
            int read = inputStream.read(data);
            int length = read;
            if (read != -1) {
                outputStream.write(data, 0, length);
            } else {
                inputStream.close();
                outputStream.close();
                return true;
            }
        }
    }

    public void setCacheKeyProvider(ICacheKeyProvider cacheKeyProvider2) {
        this.cacheKeyProvider = cacheKeyProvider2;
    }

    public boolean isCacheExists(String key) {
        DiskLruCache.Snapshot snapshot = null;
        try {
            snapshot = this.diskLruCache.get(this.cacheKeyProvider.buildCacheKey(key));
        } catch (IOException e2) {
            if (DEBUG) {
                Log.e(ISwanHybridDebug.TAG, Log.getStackTraceString(e2));
            }
        }
        if (snapshot == null) {
            return false;
        }
        snapshot.close();
        return true;
    }

    public boolean clear() {
        try {
            DiskLruCache diskLruCache2 = this.diskLruCache;
            if (diskLruCache2 == null) {
                return false;
            }
            diskLruCache2.delete();
            return true;
        } catch (IOException e2) {
            if (!DEBUG) {
                return false;
            }
            Log.e(ISwanHybridDebug.TAG, Log.getStackTraceString(e2));
            return false;
        }
    }
}
