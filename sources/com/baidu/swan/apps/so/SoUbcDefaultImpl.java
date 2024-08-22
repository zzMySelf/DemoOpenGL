package com.baidu.swan.apps.so;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.SwanNative;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.swan.apps.statistic.SwanAppBusinessUbc;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;

public class SoUbcDefaultImpl implements SoUtils.SoUbcLoggable {
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    private static final String NAME_V8_ENGINE = "v8.engine";
    private static final String NAME_ZEUS_V8 = "zeusv8";
    private static final String SO_INFO_FORMAT = "[%s:%s,size:%d]";
    private static final String TAG = "SoUbcDefaultImpl";

    public void onEvent(String eventId, String content) {
        if (!TextUtils.isEmpty(content)) {
            String ubcInfo = Arrays.toString(new String[]{Build.CPU_ABI, Build.CPU_ABI2}) + "\n" + SwanNative.getVersion() + "\n" + collectSoInfo(NAME_V8_ENGINE) + "\n" + collectSoInfo(NAME_ZEUS_V8) + "\n" + content;
            if (DEBUG) {
                Log.d(TAG, "reportSoLoadInfo: " + ubcInfo);
            }
            new SwanAppBusinessUbc.Builder(10007).buildPage(eventId).buildInfo(ubcInfo).buildAppId(SwanApp.getSwanAppId()).report();
        }
    }

    private String collectSoInfo(String soName) {
        File soFile = SoLoader.findSoFilesInLibrary(SwanAppRuntime.getAppContext(), soName);
        return String.format(Locale.CHINA, SO_INFO_FORMAT, new Object[]{soName, soFile == null ? null : soFile.getAbsolutePath(), Long.valueOf(soFile == null ? 0 : soFile.length())});
    }
}
