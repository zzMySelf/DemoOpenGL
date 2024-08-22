package fe.ad.qw.qw.fe;

import android.text.TextUtils;
import com.alibaba.android.arouter.facade.template.ILogger;

public class ad implements ILogger {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f1195ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f1196de = false;

    /* renamed from: fe  reason: collision with root package name */
    public static boolean f1197fe = false;
    public String qw = "ARouter";

    public ad(String str) {
        this.qw = str;
    }

    public static String qw(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder("[");
        if (f1196de) {
            String name = Thread.currentThread().getName();
            String fileName = stackTraceElement.getFileName();
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            long id = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            sb.append("ThreadId=");
            sb.append(id);
            sb.append(" & ");
            sb.append("ThreadName=");
            sb.append(name);
            sb.append(" & ");
            sb.append("FileName=");
            sb.append(fileName);
            sb.append(" & ");
            sb.append("ClassName=");
            sb.append(className);
            sb.append(" & ");
            sb.append("MethodName=");
            sb.append(methodName);
            sb.append(" & ");
            sb.append("LineNumber=");
            sb.append(lineNumber);
        }
        sb.append(" ] ");
        return sb.toString();
    }

    public void debug(String str, String str2) {
        if (f1195ad) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            str2 + qw(stackTraceElement);
        }
    }

    public void error(String str, String str2) {
        if (f1195ad) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            str2 + qw(stackTraceElement);
        }
    }

    public String getDefaultTag() {
        return this.qw;
    }

    public void info(String str, String str2) {
        if (f1195ad) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            str2 + qw(stackTraceElement);
        }
    }

    public boolean isMonitorMode() {
        return f1197fe;
    }

    public void monitor(String str) {
        if (f1195ad && isMonitorMode()) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            this.qw + "::monitor";
            str + qw(stackTraceElement);
        }
    }

    public void showLog(boolean z) {
        f1195ad = z;
    }

    public void showStackTrace(boolean z) {
        f1196de = z;
    }

    public void warning(String str, String str2) {
        if (f1195ad) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            str2 + qw(stackTraceElement);
        }
    }

    public void error(String str, String str2, Throwable th2) {
        if (f1195ad && TextUtils.isEmpty(str)) {
            getDefaultTag();
        }
    }
}
