package com.baidu.searchbox.process.ipc.util;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.multiprocess.AppProcessManager;
import com.baidu.searchbox.process.ipc.IPCLibConfig;

public final class ProcessUtils {
    private static final boolean DEBUG;
    private static final String TAG = "ProcessUtils";
    private static boolean sIsMainProcess;
    private static String sMainProcessName = IPCLibConfig.sAppContext.getApplicationInfo().processName;
    private static String sProcessName;

    static {
        boolean z = IPCLibConfig.DEBUG;
        DEBUG = z;
        String processName = AppProcessManager.getProcessName();
        sProcessName = processName;
        sIsMainProcess = checkIsMainProcess(processName);
        if (z) {
            Log.d(TAG, "main process name: " + sMainProcessName);
            Log.d(TAG, "current process name: " + sProcessName);
        }
    }

    public static boolean isMainProcess() {
        return sIsMainProcess;
    }

    public static String getCurProcessName() {
        return sProcessName;
    }

    public static boolean checkIsMainProcess(String processName) {
        if (TextUtils.equals(processName, sMainProcessName)) {
            return true;
        }
        if (!processName.startsWith(sMainProcessName) || processName.contains(":")) {
            return false;
        }
        return true;
    }

    public static boolean is64Bit() {
        boolean is64BitRunning = false;
        if (Build.VERSION.SDK_INT >= 23) {
            is64BitRunning = Process.is64Bit();
        } else if (Build.VERSION.SDK_INT >= 21) {
            String[] supported64BitAbis = Build.SUPPORTED_64_BIT_ABIS;
            if (supported64BitAbis.length > 0) {
                is64BitRunning = Build.CPU_ABI.equals(supported64BitAbis[0]);
            }
        }
        if (DEBUG) {
            if (is64BitRunning) {
                Log.d(TAG, "current process is a  64-bit runtime");
            } else {
                Log.d(TAG, "current process is a  32-bit runtime");
            }
        }
        return is64BitRunning;
    }
}
