package com.baidu.yalog.impl.mmap;

import java.util.List;

public class YaNativeLogger {
    public static native void createLogSnapShot(long j, long j2, String str, String str2, boolean z, boolean z2, String str3, List<String> list);

    public static native void flush(String str, boolean z);

    public static native void log(String str, String str2, String str3, String str4, String str5);

    public static native void queryLogFiles(long j, long j2, String str, String str2, List<String> list);

    public static native void requestCleanOverQuotaLog();

    public static native void setBaseDir(String str);

    public static native void setDefaultLogIdEnable(boolean z);

    public static native void setDefaultLogIdMaxSize(long j);

    public static native void setDefaultMaxAliveTimeForSpace(long j);

    public static native void setDefaultSpaceEnable(boolean z);

    public static native void setDefaultSpaceMaxSize(long j);

    public static native void setLogIdEnable(String str, boolean z);

    public static native void setLogIdMaxSize(String str, long j);

    public static native void setMainController(boolean z);

    public static native void setMaxAliveTimeForSpace(String str, long j);

    public static native void setMaxSizeAllLogFile(long j);

    public static native void setMaxSizePerLogFile(long j);

    public static native void setProcessName(String str);

    public static native void setSpaceEnable(String str, boolean z);

    public static native void setSpaceMaxSize(String str, long j);

    public static native void start();

    public static native void stop();
}
