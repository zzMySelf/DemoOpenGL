package com.baidu.disasterrecovery.jnicrash;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.NoProGuard;
import java.io.File;

public class NativeCrashCapture implements NoProGuard {
    public static final boolean DEBUG = fe.fe.ddd.when.yj.ad.qw;
    public static final String SO_INIT_FLAG_FILE = "jnicrash_so_init_fail_flag";
    public static final String SO_LOAD_FLAG_FILE = "jnicrash_so_load_fail_flag";
    public static final String STATISTIC_UBC_INIT_FAILED_TAG = "SO_INIT_FAILED";
    public static final String STATISTIC_UBC_LOAD_CRASH_TAG = "SO_LOAD_CRASH";
    public static final String STATISTIC_UBC_LOAD_EXP_TAG = "SO_LOAD_EXCEPTION";
    public static final String TAG = "NativeCrashCapture";
    public static Context sContext = null;
    public static boolean sInit = false;
    public static fe.fe.i.qw.ad sNativeCrashHandler = null;

    public static class ad extends Thread {
        public static void qw() {
        }
    }

    public static class qw extends Thread {
        public static void qw() {
        }
    }

    public static void beginNativeCrash() {
        if (Build.VERSION.SDK_INT > 19) {
            fe.fe.i.qw.ad adVar = sNativeCrashHandler;
            if (adVar != null) {
                adVar.rg();
                return;
            }
            return;
        }
        boolean z = DEBUG;
        fe.fe.i.qw.ad adVar2 = sNativeCrashHandler;
        if (adVar2 != null) {
            adVar2.rg();
        }
    }

    public static void init(@NonNull Context context, @NonNull fe.fe.i.qw.ad adVar, boolean z) {
        if (!sInit && adVar != null && context != null) {
            sContext = context;
            sNativeCrashHandler = adVar;
            loadNativeCrashLib();
            if (sInit) {
                File file = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    nativeInit(Build.VERSION.SDK_INT);
                    if (z) {
                        fe.fe.i.qw.qw.qw();
                    }
                    file.delete();
                    boolean z2 = DEBUG;
                } catch (Throwable th2) {
                    if (DEBUG) {
                        th2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void loadNativeCrashLib() {
        File file = new File(sContext.getFilesDir() + "/" + SO_LOAD_FLAG_FILE);
        File file2 = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
        if (file.exists()) {
            sNativeCrashHandler.yj(STATISTIC_UBC_LOAD_CRASH_TAG, "Native load crash");
        }
        if (file2.exists()) {
            sNativeCrashHandler.yj(STATISTIC_UBC_INIT_FAILED_TAG, "Native init failed");
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            SoLoader.load(sContext, "native-crash");
            if (SoLoader.isSoLoadedSucc("native-crash")) {
                sInit = true;
                file.delete();
                if (DEBUG) {
                    "load native-crash.so success, arch is: " + System.getProperty("os.arch").toLowerCase();
                }
            }
        } catch (Throwable th2) {
            sInit = false;
            th2.printStackTrace();
            sNativeCrashHandler.yj(STATISTIC_UBC_LOAD_EXP_TAG, Log.getStackTraceString(th2));
        }
    }

    public static void makeCrash() {
        if (sInit) {
            nativeCrash();
        }
    }

    public static native int nativeCrash();

    public static native int nativeInit(int i2);

    public static void preloadKIKKAT() {
        if (Build.VERSION.SDK_INT <= 19) {
            qw.qw();
            ad.qw();
        }
    }

    public static void uncaughtNativeCrash(String str, int i2, int i3) {
        if (Build.VERSION.SDK_INT > 19) {
            fe.fe.i.qw.ad adVar = sNativeCrashHandler;
            if (adVar != null) {
                adVar.o(str, i2, i3);
                return;
            }
            return;
        }
        boolean z = DEBUG;
        fe.fe.i.qw.ad adVar2 = sNativeCrashHandler;
        if (adVar2 != null) {
            adVar2.o(str, i2, i3);
        }
    }
}
