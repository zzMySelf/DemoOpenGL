package com.baidu.swan.apps.storage.swankv;

import android.content.Context;
import android.os.Parcelable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.storage.swankv.SharedPreferenceImpl;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.sailor.SwanSailorSoUtils;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.apps.util.SwanAppUtils;
import com.baidu.swan.utils.ISwanSharedPrefs;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SwanKVImpl extends SharedPreferenceImpl implements ISwanSharedPrefs {
    private static final String LIBS = "libs";
    private static final String SO_NAME_SHARED_SHORT = "c++_shared";
    private static final String SWAN_KV_PREFS = "swan_prefs";
    private static final String TAG = "SwanKVImpl";
    public static final String V8_LIB_PATH = (AppRuntime.getAppContext().getFilesDir() + File.separator + "zeus" + File.separator + "libs");
    private static final String ZEUS = "zeus";

    static {
        initializeSwanKV();
    }

    public SwanKVImpl(Context context, String name, int mode) {
        super(context, name, mode, getKVRootDirPath());
    }

    public SwanKVImpl(Context context, String name) {
        super(context, name, 2, getKVRootDirPath());
    }

    public SwanKVImpl(String name) {
        super(AppRuntime.getAppContext(), name, 2, getKVRootDirPath());
    }

    public SwanKVImpl(String name, int mode, String rootPath) {
        super(AppRuntime.getAppContext(), name, mode, rootPath);
    }

    public long getContentSize() {
        return super.contentSize();
    }

    public File getFile() {
        return super.getFile();
    }

    public boolean supportMultiProcess() {
        return super.getMode() == 2;
    }

    public Set<String> keySets() {
        return new HashSet(Arrays.asList(super.getAllKeys()));
    }

    public boolean putParcel(String key, Parcelable value) {
        return writeParcel(key, value);
    }

    public boolean putByteArray(String key, byte[] value) {
        return writeBytes(key, value);
    }

    public byte[] getByteArray(String key) {
        return getBytes(key);
    }

    public static void initializeSwanKV() {
        try {
            SwanKV.initialize(SwanAppRuntime.getAppContext(), new SwanKV.SoLoader() {
                public void loadLibrary(String libName) {
                    if (SwanAppUtils.isBaiduBoxApp() || !SwanKVImpl.SO_NAME_SHARED_SHORT.equals(libName)) {
                        SoLoader.load(SwanAppRuntime.getAppContext(), libName);
                        return;
                    }
                    SwanSailorSoUtils.initNativeDirectory(AppRuntime.getAppContext(), SwanKVImpl.V8_LIB_PATH);
                    SwanSailorSoUtils.load(SwanKVImpl.SO_NAME_SHARED_SHORT, SwanKVImpl.V8_LIB_PATH, false);
                }
            }, false);
        } catch (NoClassDefFoundError e2) {
            SwanAppLog.e(TAG, "initializeSwanKV", e2);
        }
    }

    public static String getKVRootDirPath() {
        return AppRuntime.getAppContext().getFilesDir() + File.separator + "swan_prefs";
    }
}
