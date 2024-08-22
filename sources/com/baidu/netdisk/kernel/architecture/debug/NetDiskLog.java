package com.baidu.netdisk.kernel.architecture.debug;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;
import com.baidu.searchbox.video.feedflow.detail.personalizedcontentinsert.PersonalizedContentConfigKt;

public class NetDiskLog {
    private static final boolean IS_DEBUGING = false;
    public static final boolean IS_OEM = false;
    private static final String TAG = "NetDiskLog";

    public static boolean isDebug() {
        return false;
    }

    public static void v(String tag, String msg) {
        v(tag, msg, (Throwable) null);
    }

    public static void v(String tag, String msg, Throwable error) {
        innerLog("V", tag, msg, error);
    }

    public static void d(String tag, String msg) {
        d(tag, msg, (Throwable) null);
    }

    public static void d(String msg) {
    }

    public static void i(String msg) {
    }

    private static String createLog(String log) {
        StackTraceElement logElement = Thread.currentThread().getStackTrace()[4];
        String fullClassName = logElement.getClassName();
        String threadName = Thread.currentThread().getName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
        String methodName = logElement.getMethodName();
        String fileName = logElement.getFileName();
        return "at [" + threadName + ":" + className + "." + methodName + FileViewerActivity.LEFT_BRACKET + fileName + ":" + logElement.getLineNumber() + ")] " + log;
    }

    public static void d(String tag, String msg, Throwable error) {
        innerLog(PersonalizedContentConfigKt.ACTION_REQUEST_NEXT, tag, msg, error);
    }

    public static void i(String tag, String msg) {
        d(tag, msg, (Throwable) null);
    }

    public static void i(String tag, String msg, Throwable error) {
        innerLog("I", tag, msg, error);
    }

    public static void w(String tag, String msg) {
        d(tag, msg, (Throwable) null);
    }

    public static void w(String tag, String msg, Throwable error) {
        innerLog(ExifInterface.LONGITUDE_WEST, tag, msg, error);
    }

    public static void e(String tag, String msg) {
        d(tag, msg, (Throwable) null);
    }

    public static void e(String tag, String msg, Throwable error) {
        innerLog(ExifInterface.LONGITUDE_WEST, tag, msg, error);
    }

    private static void innerLog(String level, String tag, String msg, Throwable error) {
    }
}
