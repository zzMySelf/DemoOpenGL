package com.baidu.swan.apps.impl.so;

import com.baidu.swan.apps.adaptation.interfaces.ISwanAppSoManager;
import com.baidu.swan.apps.core.sailor.SwanSailorHelper;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.so.SoLoader;
import java.io.File;

public class SwanAppSoManager implements ISwanAppSoManager {
    private static final String[] V8_DEPENDENT_LIB_NAMES = {"c++_shared", "arcore_sdk_c", "arcore_sdk_jni"};

    public String getV8SoDependentFile() {
        if (!SwanAppRuntime.getSwanSailorRuntime().isSailorPreset()) {
            return SwanSailorHelper.V8_LIB_PATH + File.separator + "libcom.baidu.zeus.so";
        }
        return SoLoader.getV8SoDependentFilePath();
    }

    public boolean isNeedV8SoDependentFile() {
        return true;
    }

    public String[] getV8SoDependentLibNames() {
        return V8_DEPENDENT_LIB_NAMES;
    }
}
