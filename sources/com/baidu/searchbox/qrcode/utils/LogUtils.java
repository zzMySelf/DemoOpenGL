package com.baidu.searchbox.qrcode.utils;

import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.swan.apps.util.SwanAppDateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class LogUtils {
    private LogUtils() {
    }

    public static String getClassFileLineMethod(String className) {
        StackTraceElement traceElement = new Exception().getStackTrace()[1];
        StringBuilder toStringBuffer = new StringBuilder();
        if (className != null && className.length() > 0) {
            toStringBuffer.append(className).append(": ");
        }
        toStringBuffer.append(RhetoricalTagUtilKt.TAG_START_SYMBOL).append(traceElement.getFileName()).append(" | ").append(traceElement.getLineNumber()).append(" | ").append(traceElement.getMethodName()).append("()").append(RhetoricalTagUtilKt.TAG_END_SYMBOL);
        return toStringBuffer.toString();
    }

    public static String getFileLineMethod() {
        return getClassFileLineMethod("");
    }

    public static String _FILE_() {
        return new Exception().getStackTrace()[1].getFileName();
    }

    public static String _FUNC_() {
        return new Exception().getStackTrace()[1].getMethodName();
    }

    public static int _LINE_() {
        return new Exception().getStackTrace()[1].getLineNumber();
    }

    public static String _TIME_() {
        return new SimpleDateFormat(SwanAppDateTimeUtil.TIME_MS_FORMAT).format(new Date());
    }
}
