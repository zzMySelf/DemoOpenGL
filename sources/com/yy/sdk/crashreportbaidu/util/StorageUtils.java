package com.yy.sdk.crashreportbaidu.util;

import android.content.Context;
import com.yy.sdk.crashreportbaidu.Log;
import java.io.File;

public class StorageUtils {
    private static final String TAG = "StorageUtils";
    private static StorageUtils mInstance = new StorageUtils();

    private StorageUtils() {
    }

    public static StorageUtils instance() {
        return mInstance;
    }

    public File getCacheDir(Context context) {
        if (context == null) {
            Log.e(TAG, "Context is null, need setting Context!");
            return null;
        } else if (context.getExternalCacheDir() == null || !context.getExternalCacheDir().exists()) {
            return context.getCacheDir();
        } else {
            return context.getExternalCacheDir();
        }
    }
}
