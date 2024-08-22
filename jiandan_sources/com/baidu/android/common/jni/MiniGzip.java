package com.baidu.android.common.jni;

import android.os.SystemClock;
import fe.fe.aaa.qw;
import java.io.File;

public final class MiniGzip {
    public static final String a = "MiniGzip";

    static {
        System.loadLibrary("minigzip_v1");
    }

    public static void unGzipFile(String str, String str2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (str == null || str2 == null || str.equals("") || str2.equals("")) {
            String str3 = a;
            qw.qw(str3, "parameters invalid : srcFile=" + str + "//destFile=" + str2);
        } else if (!new File(str).exists()) {
            String str4 = a;
            qw.qw(str4, str + "  not exists.");
        } else if (new fe.fe.qw.qw.qw(new File(str)).qw()) {
            uncompressFile(str, str2);
            String str5 = a;
            qw.qw(str5, "native ungzip use time : " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    public static native void uncompressFile(String str, String str2);
}
