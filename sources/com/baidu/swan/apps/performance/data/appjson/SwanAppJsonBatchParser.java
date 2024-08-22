package com.baidu.swan.apps.performance.data.appjson;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.install.SwanAppBundleHelper;
import com.baidu.swan.apps.launch.cache.SwanAppCacheAPIManager;
import com.baidu.swan.apps.pullrefresh.ISwanPerformance;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.SwanAppBusinessUbc;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class SwanAppJsonBatchParser implements ISwanPerformance {
    private static final Set<String> ALLOW_APP_KEY_LIST = new HashSet();
    private ConcurrentHashMap<String, SwanAppConfigData> mConfigDataMap;
    private final AtomicBoolean mIsParsed;
    private boolean markStartParser;

    private static class Holder {
        static final SwanAppJsonBatchParser sInstance = new SwanAppJsonBatchParser();

        private Holder() {
        }
    }

    private SwanAppJsonBatchParser() {
        this.mConfigDataMap = new ConcurrentHashMap<>();
        this.markStartParser = false;
        this.mIsParsed = new AtomicBoolean(false);
        setUpAllowList();
    }

    public static SwanAppJsonBatchParser get() {
        return Holder.sInstance;
    }

    private void setUpAllowList() {
        Set<String> set = ALLOW_APP_KEY_LIST;
        set.add("eot71qyZ0ino8W34o3XG6aQ9YdAn4R1m");
        set.add("AZQtr4jkpf90T3X9QMWVLF1bkeV4LXxD");
        set.add("AukeaxXFpdt1qCe7lE35VCvH27x6ayWI");
        set.add("flFqXclepWs7RdugAszy9eERL7G5dS0I");
        set.add("oFx3nbdDN6GWF3Vb0Wh7EDBMBxRTTcfe");
    }

    public void startBatchParseAppJson() {
        if (this.mIsParsed.compareAndSet(false, true)) {
            long start = BUILD_DEBUG ? System.currentTimeMillis() : 0;
            try {
                doBatchParseAppJson();
            } catch (Throwable e2) {
                SwanAppLog.logToFile(ISwanPerformance.TAG, "#startBatchParseAppJson error", e2);
            }
            if (BUILD_DEBUG) {
                Log.d(ISwanPerformance.TAG, "#startBatchParseAppJson cost=" + (System.currentTimeMillis() - start) + "ms");
            }
        }
    }

    public void startAsyncBatchParseAppJson() {
        if (!this.markStartParser) {
            this.markStartParser = true;
            try {
                SwanAppExecutorUtils.postOnIO(new Runnable() {
                    public void run() {
                        long start = System.currentTimeMillis();
                        SwanAppJsonBatchParser.this.doBatchParseAppJson();
                        long end = System.currentTimeMillis();
                        if (ISwanPerformance.DEBUG) {
                            Log.d(ISwanPerformance.TAG, "async batch parse app.json cost = " + (end - start) + "ms");
                        }
                    }
                }, "startAsyncBatchParseAppJson");
            } catch (Throwable throwable) {
                if (DEBUG) {
                    Log.e(ISwanPerformance.TAG, "batch parse app.json exception");
                    throwable.printStackTrace();
                }
            }
        } else if (DEBUG) {
            Log.d(ISwanPerformance.TAG, "has batch parse app.json, size = " + this.mConfigDataMap.size());
        }
    }

    /* access modifiers changed from: private */
    public void doBatchParseAppJson() {
        File[] appKeyArray;
        File baseFolder = SwanAppBundleHelper.getBundleBaseFolder();
        if (baseFolder.exists() && (appKeyArray = baseFolder.listFiles()) != null && appKeyArray.length != 0) {
            for (String allowAppKey : ALLOW_APP_KEY_LIST) {
                cacheAppJson(new File(baseFolder, allowAppKey));
            }
        }
    }

    private void cacheAppJson(File appKeyFile) {
        File latestAppKeyFile;
        SwanAppConfigData data;
        if (appKeyFile != null && appKeyFile.exists() && appKeyFile.isDirectory() && (latestAppKeyFile = findLatestVersion(appKeyFile)) != null && (data = SwanAppCacheAPIManager.buildAppJsonConfig(latestAppKeyFile, latestAppKeyFile)) != null) {
            this.mConfigDataMap.put(latestAppKeyFile.getAbsolutePath(), data);
        }
    }

    private File findLatestVersion(File appKeyFile) {
        if (appKeyFile == null || appKeyFile.isFile()) {
            return null;
        }
        File[] versions = appKeyFile.listFiles();
        if (versions == null || versions.length <= 0) {
            new SwanAppBusinessUbc.Builder(10012).buildAppId(appKeyFile.getAbsolutePath()).buildSource("async parse swanApp").report();
            if (DEBUG) {
                Log.d(ISwanPerformance.TAG, appKeyFile.getAbsolutePath() + " is an empty folder");
            }
            return null;
        }
        if (versions.length > 1) {
            Arrays.sort(versions, new ComparatorByLastModified());
        }
        return versions[0];
    }

    public SwanAppConfigData tryObtainAppJson(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        String filePath = file.getAbsolutePath();
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        SwanAppConfigData data = this.mConfigDataMap.get(filePath);
        if (DEBUG) {
            Log.d(ISwanPerformance.TAG, "try obtain config data success = " + (data != null));
        }
        return data;
    }

    public void releaseCache() {
        ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap = this.mConfigDataMap;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            this.mConfigDataMap.clear();
        }
        this.markStartParser = false;
        this.mIsParsed.set(false);
        if (DEBUG) {
            Log.d(ISwanPerformance.TAG, "release app.json batch cache");
        }
    }

    public void releaseCache(String appId) {
        ConcurrentHashMap<String, SwanAppConfigData> concurrentHashMap;
        if (!TextUtils.isEmpty(appId) && (concurrentHashMap = this.mConfigDataMap) != null && !concurrentHashMap.isEmpty()) {
            Iterator<Map.Entry<String, SwanAppConfigData>> it = this.mConfigDataMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, SwanAppConfigData> entry = it.next();
                    if (entry != null) {
                        String appJsonPath = entry.getKey();
                        if (!TextUtils.isEmpty(appJsonPath) && appJsonPath.contains(appId)) {
                            this.mConfigDataMap.remove(appJsonPath);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (DEBUG) {
                Log.d(ISwanPerformance.TAG, "release app.json appId = " + appId);
            }
        }
    }

    private class ComparatorByLastModified implements Comparator<File> {
        private ComparatorByLastModified() {
        }

        public int compare(File f1, File f2) {
            if (f1 == null) {
                return 1;
            }
            if (f2 == null) {
                return -1;
            }
            return (int) (-1 * (getFileCreatedTime(f1) - getFileCreatedTime(f2)));
        }

        private long getFileCreatedTime(File file) {
            return file.lastModified();
        }
    }
}
