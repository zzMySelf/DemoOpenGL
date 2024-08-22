package com.baidu.searchbox.download.center.clearcache.manualclean;

import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.clearcache.impl.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clearcache.BaseClearCache;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InteractClearCache extends BaseClearCache {
    private static final String CALCULATE_TASK_NAME = "getInteractCacheSize";
    private static final String CLEAR_TASK_NAME = "clearInteractCache";
    private static final String EXT_KEY = "interact";

    public void clearCache(BaseClearCache.CacheClearCallback cacheClearCallback) {
        ExecutorUtilsExt.postOnElastic(new InteractClearCache$$ExternalSyntheticLambda0(this, cacheClearCallback), CLEAR_TASK_NAME, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$clearCache$0$com-baidu-searchbox-download-center-clearcache-manualclean-InteractClearCache  reason: not valid java name */
    public /* synthetic */ void m17120lambda$clearCache$0$combaidusearchboxdownloadcenterclearcachemanualcleanInteractClearCache(BaseClearCache.CacheClearCallback cacheClearCallback) {
        try {
            if (AppConfig.isDebug()) {
                Log.d(InteractClearCache.class.getSimpleName(), "clearCache");
            }
            for (File file : getClearCacheFile()) {
                FileUtils.deleteFile(file);
            }
        } catch (Throwable e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        cacheClearCallback.onClearCacheResult(true);
    }

    public void calculateCacheSize(BaseClearCache.CacheSizeCallback cacheSizeCallback) {
        ExecutorUtilsExt.postOnElastic(new InteractClearCache$$ExternalSyntheticLambda1(this, cacheSizeCallback), CALCULATE_TASK_NAME, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$calculateCacheSize$1$com-baidu-searchbox-download-center-clearcache-manualclean-InteractClearCache  reason: not valid java name */
    public /* synthetic */ void m17119lambda$calculateCacheSize$1$combaidusearchboxdownloadcenterclearcachemanualcleanInteractClearCache(BaseClearCache.CacheSizeCallback cacheSizeCallback) {
        try {
            if (AppConfig.isDebug()) {
                Log.d(InteractClearCache.class.getSimpleName(), "calculateCacheSize");
            }
            long total = 0;
            for (File file : getClearCacheFile()) {
                total += FileUtils.getDirectorySize(file);
            }
            if (cacheSizeCallback != null) {
                cacheSizeCallback.onCacheSizeResult(total);
            }
        } catch (Throwable e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            cacheSizeCallback.onCacheSizeResult(0);
        }
    }

    private List<File> getClearCacheFile() {
        List<File> fileList = new ArrayList<>();
        File imagesFile = new File(AppRuntime.getAppContext().getExternalFilesDir((String) null), "Images");
        if (imagesFile.exists()) {
            fileList.add(imagesFile);
        }
        return fileList;
    }

    public static void clearInteractDeprecationDirs() {
        if (AppConfig.isDebug()) {
            Log.d(InteractClearCache.class.getSimpleName(), "clearInteractDeprecationDirs");
        }
        String baseDir = AppRuntime.getAppContext().getFilesDir().getAbsolutePath();
        try {
            File praiseRootDir = new File(baseDir, "praise_root");
            if (praiseRootDir.exists()) {
                FileUtils.deleteFile(praiseRootDir);
            }
        } catch (Throwable e2) {
            e2.printStackTrace();
        }
        try {
            File emotionRootDir = new File(baseDir, "emotion_root");
            if (emotionRootDir.exists()) {
                FileUtils.deleteFile(emotionRootDir);
            }
        } catch (Throwable e3) {
            e3.printStackTrace();
        }
    }

    public String getCacheName() {
        return AppRuntime.getAppContext().getString(R.string.clear_interact_data);
    }

    public String getCacheDesc() {
        return "";
    }

    public String getUBCExtKey() {
        return "interact";
    }

    public boolean isDefaultSelected() {
        return true;
    }

    public boolean isCalculateCacheSize() {
        return true;
    }
}
