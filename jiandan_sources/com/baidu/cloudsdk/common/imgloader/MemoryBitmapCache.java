package com.baidu.cloudsdk.common.imgloader;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MemoryBitmapCache implements IBitmapCache {
    public IEvictPolicy mEvictPolicy;
    public Map<String, CacheEntry> mMap;
    public int mMaxSize;

    public static class CacheEntry {
        public int mHits;
        public Bitmap mImage;
        public long mTimeStamp;
    }

    public interface IEvictPolicy {
        public static final int LRU = 0;
        public static final int OLDEST = 1;

        String findItemToDelete(Map<String, CacheEntry> map);

        void updateCacheItem(CacheEntry cacheEntry);
    }

    public static class LRUPolicy implements IEvictPolicy {
        public long mRecentTimeRange;

        public LRUPolicy(long j) {
            this.mRecentTimeRange = j * 1000;
        }

        public String findItemToDelete(Map<String, CacheEntry> map) {
            String str = null;
            CacheEntry cacheEntry = null;
            boolean z = true;
            for (String next : map.keySet()) {
                CacheEntry cacheEntry2 = map.get(next);
                long currentTimeMillis = System.currentTimeMillis();
                long j = cacheEntry2.mTimeStamp;
                if (currentTimeMillis - j < this.mRecentTimeRange) {
                    if (z && (cacheEntry == null || cacheEntry2.mHits < cacheEntry.mHits)) {
                        str = next;
                        cacheEntry = cacheEntry2;
                    }
                } else if (cacheEntry == null || j < cacheEntry.mTimeStamp) {
                    str = next;
                    cacheEntry = cacheEntry2;
                    z = false;
                }
            }
            return str;
        }

        public void updateCacheItem(CacheEntry cacheEntry) {
            if (cacheEntry.mTimeStamp + this.mRecentTimeRange < System.currentTimeMillis()) {
                cacheEntry.mHits = 1;
            } else {
                cacheEntry.mHits++;
            }
            cacheEntry.mTimeStamp = System.currentTimeMillis();
        }
    }

    public static class OldestPolicy implements IEvictPolicy {
        public String findItemToDelete(Map<String, CacheEntry> map) {
            String str = null;
            CacheEntry cacheEntry = null;
            for (String next : map.keySet()) {
                CacheEntry cacheEntry2 = map.get(next);
                if (cacheEntry == null || cacheEntry2.mTimeStamp < cacheEntry.mTimeStamp) {
                    str = next;
                    cacheEntry = cacheEntry2;
                }
            }
            return str;
        }

        public void updateCacheItem(CacheEntry cacheEntry) {
            cacheEntry.mHits++;
            cacheEntry.mTimeStamp = System.currentTimeMillis();
        }
    }

    public MemoryBitmapCache(int i2) {
        this(i2, (IEvictPolicy) null);
    }

    public synchronized void clean() {
        Iterator<String> it = this.mMap.keySet().iterator();
        while (it.hasNext()) {
            CacheEntry cacheEntry = this.mMap.get(it.next());
            if (!(cacheEntry == null || cacheEntry.mImage == null || cacheEntry.mImage.isRecycled())) {
                cacheEntry.mImage.recycle();
            }
            it.remove();
        }
    }

    public synchronized void delete(String str) {
        CacheEntry remove = this.mMap.remove(str);
        if (!(remove == null || remove.mImage == null || remove.mImage.isRecycled())) {
            remove.mImage.recycle();
        }
    }

    public synchronized boolean exists(String str) {
        return this.mMap.get(str) != null;
    }

    public synchronized Bitmap get(String str) {
        CacheEntry cacheEntry = this.mMap.get(str);
        if (cacheEntry == null) {
            return null;
        }
        this.mEvictPolicy.updateCacheItem(cacheEntry);
        return cacheEntry.mImage;
    }

    public synchronized void put(String str, Bitmap bitmap) {
        if (!exists(str)) {
            if (this.mMap.size() >= this.mMaxSize) {
                delete(this.mEvictPolicy.findItemToDelete(this.mMap));
            }
            CacheEntry cacheEntry = new CacheEntry();
            cacheEntry.mHits = 1;
            cacheEntry.mTimeStamp = System.currentTimeMillis();
            cacheEntry.mImage = bitmap;
            this.mMap.put(str, cacheEntry);
        }
    }

    public MemoryBitmapCache setEvictPolicy(IEvictPolicy iEvictPolicy) {
        this.mEvictPolicy = iEvictPolicy;
        return this;
    }

    public MemoryBitmapCache setMaxSize(int i2) {
        this.mMaxSize = i2;
        return this;
    }

    public MemoryBitmapCache(int i2, IEvictPolicy iEvictPolicy) {
        this.mMap = new HashMap();
        this.mMaxSize = i2;
        this.mEvictPolicy = iEvictPolicy;
        if (iEvictPolicy == null) {
            this.mEvictPolicy = new OldestPolicy();
        }
    }
}
