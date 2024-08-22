package com.baidu.android.util.soloader;

import android.annotation.SuppressLint;
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
    public static final String EXT = ".so";
    public static final boolean LOGFLAG = true;
    public static final String PRE = "lib";
    public static final String TAG = "SoUtils";
    public static SoUbcLoggable sUbcImpl;
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

    public static long copyStream(InputStream inputStream, OutputStream outputStream, int i2) {
        if (!(inputStream == null || outputStream == null)) {
            try {
                byte[] bArr = new byte[(i2 * 1024)];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        j += (long) read;
                    } else {
                        outputStream.flush();
                        return j;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static String getFullName(String str) {
        String str2;
        if (!str.startsWith(PRE)) {
            str2 = PRE + str;
        } else {
            str2 = str;
        }
        if (str.endsWith(EXT)) {
            return str2;
        }
        return str2 + EXT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        r0 = r3.split("\\.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSimpleName(java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x002a
            java.lang.String r0 = "lib"
            boolean r0 = r3.startsWith(r0)
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = ".so"
            boolean r0 = r3.endsWith(r0)
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = "\\."
            java.lang.String[] r0 = r3.split(r0)
            if (r0 == 0) goto L_0x002a
            int r1 = r0.length
            r2 = 2
            if (r1 != r2) goto L_0x002a
            r3 = 0
            r3 = r0[r3]
            r0 = 3
            java.lang.String r3 = r3.substring(r0)
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.soloader.SoUtils.getSimpleName(java.lang.String):java.lang.String");
    }

    public static String getUriName(String str, int i2) {
        return uris[i2] + File.separator + str;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @Deprecated
    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static void init(SoUbcLoggable soUbcLoggable) {
        sUbcImpl = soUbcLoggable;
    }

    public static boolean is64Bit() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return Process.is64Bit();
        }
        if (i2 < 21) {
            return false;
        }
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        if (strArr.length > 0) {
            return Build.CPU_ABI.equals(strArr[0]);
        }
        return false;
    }

    public static void onEvent(String str, String str2) {
        SoUbcLoggable soUbcLoggable = sUbcImpl;
        if (soUbcLoggable != null) {
            soUbcLoggable.onEvent(str, str2);
        }
    }

    public static void saveLog(HashMap<String, String> hashMap, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(str, str2);
        }
    }

    public static void sendLog(String str) {
        if (!TextUtils.isEmpty(str)) {
            onEvent("24", str);
        }
    }
}
