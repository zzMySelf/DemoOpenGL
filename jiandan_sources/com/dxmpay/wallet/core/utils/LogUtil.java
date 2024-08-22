package com.dxmpay.wallet.core.utils;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.io.File;

public final class LogUtil {
    public static final boolean DEBUG = false;

    public static void d(String str) {
    }

    public static void d(String str, String str2) {
    }

    public static void e(String str, String str2, Throwable th2) {
    }

    public static void errord(String str) {
    }

    public static void errord(String str, String str2) {
    }

    public static String getTAG() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                StackTraceElement stackTraceElement = stackTrace[4];
                sb.append(stackTraceElement.getFileName().subSequence(0, stackTraceElement.getFileName().length() - 5) + IStringUtil.CURRENT_PATH + stackTraceElement.getMethodName() + Bank.HOT_BANK_LETTER + stackTraceElement.getLineNumber());
            }
            return sb.toString();
        } catch (NullPointerException unused) {
            return "PROGUARDED";
        }
    }

    public static void i(String str, String str2) {
    }

    public static void logd(String str) {
    }

    public static void logd(String str, String str2) {
    }

    public static void mark() {
    }

    public static void mark(String str) {
    }

    public static void methodTrace(String str) {
    }

    public static void saveLog(File file, String str) {
    }

    public static void traces() {
    }

    public static void v(String str, String str2) {
    }

    public static void w(String str, String str2) {
    }
}
