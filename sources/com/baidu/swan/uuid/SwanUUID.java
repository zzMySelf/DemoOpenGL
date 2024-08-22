package com.baidu.swan.uuid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.swan.uuid.cache.DiskCache;
import com.baidu.swan.uuid.cache.MemCache;
import com.baidu.swan.uuid.cache.PartnerDataCache;
import com.baidu.swan.uuid.cache.PrivateDataCache;
import com.baidu.swan.uuid.cache.ProducerCache;
import com.baidu.swan.uuid.cache.SettingsCache;

public class SwanUUID {
    private static final boolean DEBUG = false;
    public static final String HTTP_HEADER_KEY = "x-u-id";
    private static final String TAG = "SwanUUID";
    private static volatile SwanUUID sInstance;
    private final CacheHelper<String> mCacheHelper;
    private String mUUID;

    private SwanUUID(Context context) {
        CacheHelper<String> cacheHelper = new CacheHelper<>();
        this.mCacheHelper = cacheHelper;
        if (context != null) {
            cacheHelper.addCache(new MemCache(context));
            cacheHelper.addCache(new PrivateDataCache(context));
            cacheHelper.addCache(new PartnerDataCache(context));
            cacheHelper.addCache(new SettingsCache(context));
            cacheHelper.addCache(new DiskCache(context));
            cacheHelper.addCache(new ProducerCache(context));
        }
    }

    public static SwanUUID of(Context context) {
        if (sInstance == null) {
            synchronized (SwanUUID.class) {
                if (sInstance == null) {
                    sInstance = new SwanUUID(context);
                }
            }
        }
        return sInstance;
    }

    public String getUUID() {
        if (TextUtils.isEmpty(this.mUUID)) {
            synchronized (this) {
                if (TextUtils.isEmpty(this.mUUID)) {
                    String fromCache = this.mCacheHelper.getFromCache();
                    this.mUUID = fromCache;
                    this.mCacheHelper.recoverLost(fromCache);
                }
            }
        }
        return this.mUUID;
    }
}
