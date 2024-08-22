package com.baidu.webkit.internal.utils;

import android.content.Context;
import com.baidu.webkit.engine.ZeusEngineInfo;
import com.baidu.webkit.engine.ZeusEnvironment;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.internal.INoProGuard;
import java.io.File;

@Deprecated
public class UtilsBlink implements INoProGuard {
    private static final String DEX_FILE_SUBFIX = ".dex";
    private static final String TAG = "UtilsBlink";
    private static final byte VER_TYPE_SEPARATOR = 45;

    public static boolean createDownloadLibPath(Context context) {
        getDataPath(context).length();
        File file = new File(getDownloadLibPath(context));
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    public static String getDownloadLibPath(Context context) {
        if (ZeusEnvironment.isRunning()) {
            ZeusEngineInfo currentEngine = ZeusEnvironment.currentEngine();
            if (currentEngine == null) {
                return "";
            }
            String str = currentEngine.installPath;
            if (!str.endsWith(File.separator)) {
                return str + File.separator;
            }
            return str;
        }
        String filesPath = getFilesPath(context);
        if (filesPath != null) {
            return filesPath + GlobalConstants.ZEUS_LIB_LOCAL_RELATIVE_PATH;
        }
        return null;
    }

    public static String getFilesPath(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getAbsolutePath();
        }
        return "/data/data/" + context.getPackageName() + "/files/";
    }

    private static String getDataPath(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir.getParent();
        }
        return "/data/data/" + context.getPackageName() + "/";
    }
}
