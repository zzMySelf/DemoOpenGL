package com.baidu.android.util.devices;

import android.app.ActivityManager;
import android.os.Debug;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.util.io.Closeables;
import fe.fe.ddd.i.qw.qw;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MemoryUtils {
    public static final int BUFFER_SIZE = 8192;
    public static final boolean DEBUG = false;
    public static final String FDSIZE = "FDSize";
    public static final String TAG = "MemoryUtils";
    public static final String THREADS = "Threads";
    public static final String VMPEAK = "VmPeak";
    public static final String VMSIZE = "VmSize";
    public static HashSet<String> mVssKeys = new HashSet<String>() {
        {
            add(MemoryUtils.VMPEAK);
            add(MemoryUtils.VMSIZE);
            add(MemoryUtils.THREADS);
            add(MemoryUtils.FDSIZE);
        }
    };
    public static long sJavaMaxMemory;
    public static long sTotalMemory;

    public static ActivityManager.MemoryInfo getAMSMemoryInfo() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) qw.qw().getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static Debug.MemoryInfo getDebugMemoryInfo() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static long getFreeMemory() {
        return getAMSMemoryInfo().availMem / 1024;
    }

    public static long getJavaFreeMemory() {
        return Runtime.getRuntime().freeMemory() / 1024;
    }

    public static long getJavaMaxMemory() {
        if (sJavaMaxMemory == 0) {
            sJavaMaxMemory = Runtime.getRuntime().maxMemory() / 1024;
        }
        return sJavaMaxMemory;
    }

    public static long getJavaTotalMemory() {
        return Runtime.getRuntime().totalMemory() / 1024;
    }

    public static long getJavaUsedMemory() {
        return getJavaTotalMemory() - getJavaFreeMemory();
    }

    public static long getNativeFreeMemory() {
        return Debug.getNativeHeapFreeSize() / 1024;
    }

    public static long getNativeTotalMemory() {
        return Debug.getNativeHeapSize() / 1024;
    }

    public static long getNativeUsedMemory() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    public static long getTotalMemory() {
        if (sTotalMemory == 0) {
            sTotalMemory = getAMSMemoryInfo().totalMem / 1024;
        }
        return sTotalMemory;
    }

    public static Map<String, String> parseProcStatus() {
        FileReader fileReader;
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/self/status");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null || hashMap.size() >= mVssKeys.size()) {
                            Closeables.closeSafely((Closeable) bufferedReader2);
                        } else {
                            String[] split = readLine.split("\\s+");
                            if (split != null) {
                                if (split.length > 1) {
                                    if (split[0] != null) {
                                        if (split[1] != null) {
                                            String replace = split[0].replace(":", "");
                                            if (mVssKeys.contains(replace)) {
                                                hashMap.put(replace, split[1]);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        Closeables.closeSafely((Closeable) bufferedReader);
                        Closeables.closeSafely((Closeable) fileReader);
                        return hashMap;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        Closeables.closeSafely((Closeable) bufferedReader);
                        Closeables.closeSafely((Closeable) fileReader);
                        throw th;
                    }
                }
                Closeables.closeSafely((Closeable) bufferedReader2);
            } catch (IOException unused2) {
                Closeables.closeSafely((Closeable) bufferedReader);
                Closeables.closeSafely((Closeable) fileReader);
                return hashMap;
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely((Closeable) bufferedReader);
                Closeables.closeSafely((Closeable) fileReader);
                throw th;
            }
        } catch (IOException unused3) {
            fileReader = null;
            Closeables.closeSafely((Closeable) bufferedReader);
            Closeables.closeSafely((Closeable) fileReader);
            return hashMap;
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            Closeables.closeSafely((Closeable) bufferedReader);
            Closeables.closeSafely((Closeable) fileReader);
            throw th;
        }
        Closeables.closeSafely((Closeable) fileReader);
        return hashMap;
    }
}
