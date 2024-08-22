package com.baidu.apollon.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.apollon.ApollonConstants;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public final class LogUtil {
    public static final boolean DEBUG;
    public static final String a = "apollon_rest";
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    public static final boolean f;

    static {
        boolean z = ApollonConstants.DEBUG;
        DEBUG = z;
        b = z;
        c = z;
        d = z;
        e = z;
        f = z;
    }

    public static void d(String str, String str2) {
        if (c) {
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean isEmpty2 = TextUtils.isEmpty(str);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (f) {
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean isEmpty2 = TextUtils.isEmpty(str);
        }
    }

    public static void errord(String str) {
        if (ApollonConstants.DEBUG) {
            getTAG() + "---" + str;
        }
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
        if (d) {
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean isEmpty2 = TextUtils.isEmpty(str);
        }
    }

    public static void logd(String str) {
        if (ApollonConstants.DEBUG) {
            getTAG() + "---" + str + "#pid=" + Process.myPid();
        }
    }

    public static void mark() {
        if (ApollonConstants.DEBUG) {
            getTAG();
        }
    }

    public static void saveLog(Context context, String str) {
        String str2;
        if (c) {
            String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS    ", Locale.ENGLISH).format(new Date()) + str + StringUtils.LF;
            try {
                File externalFilesDir = context.getExternalFilesDir((String) null);
                if (externalFilesDir != null) {
                    str2 = externalFilesDir.getAbsolutePath();
                } else {
                    str2 = context.getFilesDir().getAbsolutePath();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2 + "/wallet.log"), true);
                fileOutputStream.write(str3.getBytes());
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void traces() {
        if (ApollonConstants.DEBUG) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                StackTraceElement stackTraceElement = stackTrace[3];
                sb.append(stackTraceElement.getClassName() + IStringUtil.CURRENT_PATH + stackTraceElement.getMethodName() + "#line=" + stackTraceElement.getLineNumber() + "的调用：\n");
                int i2 = 4;
                while (i2 < stackTrace.length && i2 < 15) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2];
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i2 - 4);
                    sb2.append("--");
                    sb2.append(stackTraceElement2.getClassName());
                    sb2.append(IStringUtil.CURRENT_PATH);
                    sb2.append(stackTraceElement2.getMethodName());
                    sb2.append("(...)#line:");
                    sb2.append(stackTraceElement2.getLineNumber());
                    sb2.append(StringUtils.LF);
                    sb.append(sb2.toString());
                    i2++;
                }
            }
            getTAG() + "--" + sb.toString();
        }
    }

    public static void v(String str, String str2) {
        if (b) {
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean isEmpty2 = TextUtils.isEmpty(str);
        }
    }

    public static void w(String str, String str2) {
        if (e) {
            boolean isEmpty = TextUtils.isEmpty(str2);
            boolean isEmpty2 = TextUtils.isEmpty(str);
        }
    }

    public static void errord(String str, String str2) {
        if (ApollonConstants.DEBUG) {
            getTAG() + "---" + str2;
        }
    }

    public static void logd(String str, String str2) {
        if (ApollonConstants.DEBUG) {
            getTAG() + "---" + str2;
        }
    }

    public static void mark(String str) {
        if (ApollonConstants.DEBUG) {
            getTAG() + "---" + str;
        }
    }

    public static void d(String str) {
        d("apollon_rest", str);
    }
}
