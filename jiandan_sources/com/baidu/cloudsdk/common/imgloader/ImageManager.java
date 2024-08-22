package com.baidu.cloudsdk.common.imgloader;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.MemoryBitmapCache;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.common.util.Validator;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;

public class ImageManager {
    public static final int DEFAULT_HIT_COUNT_REQUIRED = 1;
    public static final int DEFAULT_MAX_MEMCACHE_SIZE = 20;
    public static ImageManager sImageManager;
    public FSBitmapCache mFSCache;
    public int mMaxNumOfPixels = 19656;
    public MemoryBitmapCache mMemCache = new MemoryBitmapCache(20);

    public ImageManager() {
        try {
            this.mFSCache = new FSBitmapCache(Environment.getExternalStorageDirectory().getPath() + "/baidu/.imagecache/", 1, this.mMaxNumOfPixels, this.mMemCache);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void clean() {
        ImageManager imageManager = sImageManager;
        if (imageManager != null) {
            imageManager.mMemCache.clean();
            sImageManager = null;
        }
    }

    public static ImageManager getInstance() {
        if (sImageManager == null) {
            sImageManager = new ImageManager();
        }
        return sImageManager;
    }

    public void addCache(String str, Bitmap bitmap) {
        sImageManager.mMemCache.put(str, bitmap);
        sImageManager.mFSCache.put(str, bitmap);
    }

    public String getCachedFilePath(Uri uri) {
        Validator.notNull(uri, "uri");
        return this.mFSCache.getFilePath(Utils.md5(uri.toString()));
    }

    @TargetApi(3)
    public void loadImage(Context context, final Uri uri, final AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener) {
        Validator.notNull(context, "context");
        Validator.notNull(uri, "uri");
        Validator.notNull(iAsyncImageLoaderListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        final String md5 = Utils.md5(uri.toString());
        Bitmap bitmap = this.mMemCache.get(md5);
        if (bitmap != null) {
            iAsyncImageLoaderListener.onComplete(bitmap);
        } else if (Utils.isUrl(uri)) {
            final AsyncImageLoader.IAsyncImageLoaderListener iAsyncImageLoaderListener2 = iAsyncImageLoaderListener;
            final Context context2 = context;
            final Uri uri2 = uri;
            new AsyncTask<String, Integer, Bitmap>() {
                public Bitmap doInBackground(String... strArr) {
                    return ImageManager.this.mFSCache.get(md5);
                }

                public void onPostExecute(Bitmap bitmap) {
                    super.onPostExecute(bitmap);
                    if (bitmap != null) {
                        iAsyncImageLoaderListener2.onComplete(bitmap);
                        return;
                    }
                    new AsyncImageLoader(context2, ImageManager.this.mMaxNumOfPixels, new AsyncImageLoader.IAsyncImageLoaderListener() {
                        public void onComplete(Bitmap bitmap) {
                            if (bitmap != null) {
                                if (Utils.isUrl(uri2)) {
                                    ImageManager.this.mFSCache.put(md5, bitmap);
                                } else {
                                    ImageManager.this.mMemCache.put(md5, bitmap);
                                }
                            }
                            iAsyncImageLoaderListener2.onComplete(bitmap);
                        }
                    }).execute(new Uri[]{uri2});
                }
            }.execute(new String[0]);
        } else {
            new AsyncImageLoader(context, this.mMaxNumOfPixels, new AsyncImageLoader.IAsyncImageLoaderListener() {
                public void onComplete(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (Utils.isUrl(uri)) {
                            ImageManager.this.mFSCache.put(md5, bitmap);
                        } else {
                            ImageManager.this.mMemCache.put(md5, bitmap);
                        }
                    }
                    iAsyncImageLoaderListener.onComplete(bitmap);
                }
            }).execute(new Uri[]{uri});
        }
    }

    public ImageManager setHitCountRequired(int i2) {
        this.mFSCache.setHitCountRequired(i2);
        return this;
    }

    public ImageManager setMaxMemCacheSize(int i2) {
        this.mMemCache.setMaxSize(i2);
        return this;
    }

    public ImageManager setMaxNumOfPixels(int i2) {
        this.mMaxNumOfPixels = i2;
        this.mFSCache.setMaxNumOfPixels(i2);
        return this;
    }

    public ImageManager setMemCacheEvictPolicy(MemoryBitmapCache.IEvictPolicy iEvictPolicy) {
        this.mMemCache.setEvictPolicy(iEvictPolicy);
        return this;
    }

    public ImageManager setStorageDir(String str) {
        this.mFSCache.setStorageDir(str);
        return this;
    }
}
