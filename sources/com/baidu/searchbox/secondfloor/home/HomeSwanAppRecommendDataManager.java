package com.baidu.searchbox.secondfloor.home;

import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.secondfloor.home.model.SwanAppRecommendData;
import com.baidu.searchbox.secondfloor.home.net.SwanAppRecommendRequest;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class HomeSwanAppRecommendDataManager {
    private static final String CACHE_FILE_PATH = ("home_secondfloor" + File.separator + "ai_app_recommend_data");
    private static final boolean DEBUG = SecondFloorRuntime.DEBUG;
    private static volatile HomeSwanAppRecommendDataManager sInstance;
    /* access modifiers changed from: private */
    public SwanAppRecommendData mSwanAppRecommendData;

    public static HomeSwanAppRecommendDataManager getInstance() {
        if (sInstance == null) {
            synchronized (HomeSwanAppRecommendDataManager.class) {
                if (sInstance == null) {
                    sInstance = new HomeSwanAppRecommendDataManager();
                }
            }
        }
        return sInstance;
    }

    private HomeSwanAppRecommendDataManager() {
        File cacheFile = new File(SecondFloorRuntime.getAppContext().getFilesDir(), CACHE_FILE_PATH);
        if (cacheFile.exists()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(cacheFile));
                this.mSwanAppRecommendData = (SwanAppRecommendData) ois.readObject();
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Throwable th2) {
                Closeables.closeSafely((Closeable) ois);
                throw th2;
            }
            Closeables.closeSafely((Closeable) ois);
        }
    }

    /* access modifiers changed from: private */
    public void cacheAiAppRecommendData(SwanAppRecommendData data) {
        File cacheFile = new File(SecondFloorRuntime.getAppContext().getFilesDir(), CACHE_FILE_PATH);
        ObjectOutputStream oos = null;
        if (cacheFile.getParentFile().exists() || cacheFile.mkdirs()) {
            try {
                if (cacheFile.exists() && !cacheFile.delete()) {
                    Closeables.closeSafely((Closeable) null);
                } else if (!cacheFile.createNewFile()) {
                    Closeables.closeSafely((Closeable) null);
                } else {
                    if (data != null) {
                        oos = new ObjectOutputStream(new FileOutputStream(cacheFile));
                        oos.writeObject(data);
                    }
                    Closeables.closeSafely((Closeable) oos);
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            } catch (Throwable th2) {
                Closeables.closeSafely((Closeable) oos);
                throw th2;
            }
        } else {
            Closeables.closeSafely((Closeable) null);
        }
    }

    public SwanAppRecommendData getSwanAppRecommendData() {
        return this.mSwanAppRecommendData;
    }

    public void fetchData(final SwanAppRecommendRequest.Callback outerCallback, String fetchFrom) {
        new SwanAppRecommendRequest().fetchRecommendData(new SwanAppRecommendRequest.Callback() {
            public void onSuccess(SwanAppRecommendData recommendData) {
                SwanAppRecommendData unused = HomeSwanAppRecommendDataManager.this.mSwanAppRecommendData = recommendData;
                SwanAppRecommendRequest.Callback callback = outerCallback;
                if (callback != null) {
                    callback.onSuccess(recommendData);
                }
                HomeSwanAppRecommendDataManager.this.setRecommendDataCache(recommendData);
            }

            public void onFailure() {
                SwanAppRecommendRequest.Callback callback = outerCallback;
                if (callback != null) {
                    callback.onFailure();
                }
            }
        }, fetchFrom);
    }

    public void setRecommendDataCache(final SwanAppRecommendData recommendData) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                HomeSwanAppRecommendDataManager.this.cacheAiAppRecommendData(recommendData);
            }
        }, "secondFloorCacheData", 1);
    }
}
