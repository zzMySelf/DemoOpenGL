package com.baidu.android.util.soloader;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class SoUtils implements NoProGuard {
    public static final boolean DEBUG = false;
    private static final String EXT = ".so";
    private static final boolean LOGFLAG = true;
    private static final String PRE = "lib";
    private static final String TAG = "SoUtils";
    private static SoUbcLoggable sUbcImpl;
    public static String[] uris = {"lib/arm64-v8a", "lib/armeabi", "lib/x86", "lib/mips"};

    public static final class SOLOG {
        public static final String SO_LOAD_LIBRARY = "SO_LOAD_LIBRARY";
        public static final String SO_LOAD_TAG = "SO_LOAD_TAG";
        public static final String SO_NATIVE_LIB_LOAD = "SO_NATIVE_LIB_LOAD";
        public static final String SO_RELEASE_EXECUTE_LOAD = "SO_RELEASE_EXECUTE_LOAD";
        public static final String SO_RELEASE_LIB_LOAD = "SO_RELEASE_LIB_LOAD";
    }

    public interface SoUbcLoggable {
        void onEvent(String str, String str2);
    }

    private SoUtils() {
    }

    public static void init(SoUbcLoggable loggable) {
        sUbcImpl = loggable;
    }

    public static void onEvent(String eventId, String content) {
        SoUbcLoggable impl = sUbcImpl;
        if (impl != null) {
            impl.onEvent(eventId, content);
        }
    }

    public static String getFullName(String soName) {
        String execSoName = soName;
        if (!soName.startsWith("lib")) {
            execSoName = "lib" + execSoName;
        }
        if (!soName.endsWith(".so")) {
            return execSoName + ".so";
        }
        return execSoName;
    }

    public static String getSimpleName(String soName) {
        String[] params;
        String name = soName;
        if (TextUtils.isEmpty(soName) || !soName.startsWith("lib") || !soName.endsWith(".so") || (params = soName.split("\\.")) == null || params.length != 2) {
            return name;
        }
        return params[0].substring(3);
    }

    public static void sendLog(String log) {
        if (!TextUtils.isEmpty(log)) {
            onEvent("24", log);
        }
    }

    public static void saveLog(HashMap<String, String> stepLogMap, String step, String content) {
        if (!TextUtils.isEmpty(content)) {
            stepLogMap.put(step, content);
        }
    }

    public static long copyStream(InputStream is, OutputStream os, int sizeOnce) {
        if (is == null || os == null) {
            return 0;
        }
        try {
            byte[] buf = new byte[(sizeOnce * 1024)];
            long size = 0;
            while (true) {
                int read = is.read(buf);
                int len = read;
                if (read > 0) {
                    os.write(buf, 0, len);
                    size += (long) len;
                } else {
                    os.flush();
                    return size;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Deprecated
    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static String getUriName(String name, int count) {
        return uris[count] + File.separator + name;
    }

    public static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        String[] supported64BitAbis = Build.SUPPORTED_64_BIT_ABIS;
        if (supported64BitAbis.length > 0) {
            return Build.CPU_ABI.equals(supported64BitAbis[0]);
        }
        return false;
    }
}
