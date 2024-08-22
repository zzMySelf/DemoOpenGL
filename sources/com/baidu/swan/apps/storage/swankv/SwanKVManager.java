package com.baidu.swan.apps.storage.swankv;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.util.Pair;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.env.PurgerUtils;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.statistic.SwanAppBusinessUbc;
import com.baidu.swan.apps.util.SwanAppExecutorUtils;
import com.baidu.swan.config.utils.ActionRunnable;
import com.baidu.swan.utils.ISwanSharedPrefs;
import com.baidu.swan.utils.SwanAppFileUtils;
import com.baidu.swan.utils.SwanDefaultSharedPrefsImpl;
import java.io.File;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;

public class SwanKVManager {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final long FLAG_IMPORT_FINISH = 1;
    private static final String TAG = "SwanExtensionApiImpl";
    public static final int TYPE_INIT_FAIL = 1;
    private static final int TYPE_PUT_FAIL = 2;
    private static final int TYPE_RETRY_SUCCESS = 3;
    public static final int TYPE_SO_FAILED = 4;
    /* access modifiers changed from: private */
    public static Set<String> sLoadedList = new CopyOnWriteArraySet();
    /* access modifiers changed from: private */
    public static int sSoLoadFailCount = 0;

    private SwanKVManager() {
    }

    public static SwanKVManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public ISwanSharedPrefs getSharedPrefsImpl(Context context, String name, boolean isMultiProcessMode) {
        try {
            SwanKVImpl swanKV = new SwanKVImpl(context, name, isMultiProcessMode ? 2 : 1);
            sLoadedList.add(name);
            importFromSharedPreferences(context, name, swanKV);
            if (sSoLoadFailCount > 0) {
                exceptionReport(3, name);
            }
            return swanKV;
        } catch (NoClassDefFoundError | UnsatisfiedLinkError e2) {
            if (DEBUG) {
                Log.e(TAG, "getSharedPrefsImpl", e2);
            }
            sSoLoadFailCount++;
            exceptionReport(2, name);
            return createBackupSP(name);
        }
    }

    public static void exceptionReport(final int type, final String kvName) {
        SwanAppExecutorUtils.getComputationExecutor().execute(new Runnable() {
            public void run() {
                new SwanAppBusinessUbc.Builder(10010).buildValue(String.valueOf(SwanKVManager.sSoLoadFailCount)).buildSource(kvName).buildPage(String.valueOf(type)).buildAppId(SwanApp.getSwanAppId()).report();
                if (type == 3) {
                    int unused = SwanKVManager.sSoLoadFailCount = 0;
                }
            }
        });
    }

    private ISwanSharedPrefs createBackupSP(String name) {
        return new SwanDefaultSharedPrefsImpl(name);
    }

    public void deleteSharedPrefFiles(String prefix, Set<String> appIds, boolean isIgnore) {
        deleteSpFiles(prefix, appIds, isIgnore);
        PurgerUtils.deleteSharedPrefFiles(new File(SwanKVImpl.getKVRootDirPath()), prefix, ".kv", appIds, isIgnore, new ActionRunnable<Pair<String, File>>() {
            public void run(Pair<String, File> stringFilePair) {
                if (SwanKVManager.sLoadedList != null && stringFilePair.first != null && SwanKVManager.sLoadedList.contains(stringFilePair.first)) {
                    new SwanKVImpl(SwanAppRuntime.getAppContext(), (String) stringFilePair.first).clearAll();
                } else if (stringFilePair.second != null) {
                    SwanAppFileUtils.safeDeleteFile((File) stringFilePair.second);
                }
            }
        });
    }

    public void deleteSpFiles(String prefix, Set<String> appIds, boolean isIgnore) {
        PurgerUtils.deleteSharedPrefFiles(new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "shared_prefs/"), prefix, ".xml", appIds, isIgnore);
    }

    private void importFromSharedPreferences(Context context, String name, SwanKVImpl swanKV) {
        long customMeta = swanKV.getCustomMeta();
        if ((customMeta & 1) != 1) {
            final SwanKVImpl swanKVImpl = swanKV;
            final long j2 = customMeta;
            final Context context2 = context;
            final String str = name;
            swanKV.importFromSharedPreferences(new Callable<SharedPreferences>() {
                public SharedPreferences call() throws Exception {
                    if (!swanKVImpl.setCustomMeta(j2 | 1)) {
                        return null;
                    }
                    String spName = SwanKVManager.this.getTargetSPName(context2, str);
                    if (SwanKVManager.DEBUG) {
                        Log.i(SwanKVManager.TAG, String.format("customMeta=%d, name=%s, spName=%s", new Object[]{Long.valueOf(j2), str, spName}));
                    }
                    if (spName == null) {
                        return null;
                    }
                    return context2.getSharedPreferences(spName, 0);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public String getTargetSPName(Context context, String name) {
        if (name == null) {
            name = context.getPackageName() + "_preferences";
        }
        if ("default".equals(name)) {
            if (SwanDefaultSharedPrefsImpl.getSharedPreferencesFile(context, name).exists()) {
                return name;
            }
            name = context.getPackageName() + "_preferences";
        }
        if (SwanDefaultSharedPrefsImpl.getSharedPreferencesFile(context, name).exists()) {
            return name;
        }
        return null;
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final SwanKVManager INSTANCE = new SwanKVManager();

        private SingletonHolder() {
        }
    }
}
