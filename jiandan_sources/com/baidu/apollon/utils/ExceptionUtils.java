package com.baidu.apollon.utils;

import org.apache.commons.lang3.StringUtils;

public class ExceptionUtils {
    public static String createStackTrackMessage(Exception exc) {
        StringBuffer stringBuffer = new StringBuffer();
        if (exc != null) {
            stringBuffer.append(exc.getClass());
            stringBuffer.append(": ");
            stringBuffer.append(exc.getMessage());
            stringBuffer.append(StringUtils.LF);
            for (StackTraceElement stackTraceElement : exc.getStackTrace()) {
                stringBuffer.append("\t");
                stringBuffer.append(stackTraceElement.toString());
                stringBuffer.append(StringUtils.LF);
            }
        }
        return stringBuffer.toString();
    }
}
