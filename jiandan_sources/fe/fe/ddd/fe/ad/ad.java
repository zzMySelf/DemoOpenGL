package fe.fe.ddd.fe.ad;

import org.apache.commons.lang3.StringUtils;

public class ad {
    public static String ad(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length >= 1) {
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString() + "\r\n");
                    }
                }
            } catch (Exception unused) {
            }
        }
        return sb.toString();
    }

    public static String qw(Thread thread) {
        StringBuilder sb = new StringBuilder();
        if (thread != null) {
            try {
                sb.append("threadId： ");
                sb.append(thread.getId());
                sb.append(StringUtils.LF);
                if (thread.getName() != null) {
                    sb.append("name: ");
                    sb.append(thread.getName());
                    sb.append(StringUtils.LF);
                }
                sb.append("priority: ");
                sb.append(thread.getPriority());
                sb.append(StringUtils.LF);
                sb.append("state: ");
                sb.append(thread.getState());
                sb.append(StringUtils.LF);
                sb.append("stacktrace: \n");
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length >= 1) {
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        String methodName = stackTraceElement.getMethodName();
                        String str = "unknown";
                        if (methodName == null) {
                            methodName = str;
                        }
                        sb.append("\tat ");
                        sb.append(methodName);
                        sb.append("(");
                        String fileName = stackTraceElement.getFileName();
                        if (fileName != null) {
                            str = fileName;
                        }
                        sb.append(str);
                        sb.append(":");
                        sb.append(stackTraceElement.getLineNumber());
                        sb.append(")\n");
                    }
                }
            } catch (Exception unused) {
            }
        }
        return sb.toString();
    }
}
