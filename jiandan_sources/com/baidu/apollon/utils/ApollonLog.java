package com.baidu.apollon.utils;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.common.others.IStringUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ApollonLog {
    public static boolean DEBUG = Log.isLoggable("Apollon", 2);
    public static String TAG = "Apollon";
    public static final String a = ApollonLog.class.getName();

    public static class MarkerLog {
        public static final boolean ENABLED = ApollonLog.DEBUG;
        public static final long a = 0;
        public final List<a> b = new ArrayList();
        public boolean c = false;

        public static class a {
            public final String a;
            public final long b;
            public final long c;

            public a(String str, long j, long j2) {
                this.a = str;
                this.b = j;
                this.c = j2;
            }
        }

        private long a() {
            if (this.b.size() == 0) {
                return 0;
            }
            long j = this.b.get(0).c;
            List<a> list = this.b;
            return list.get(list.size() - 1).c - j;
        }

        public synchronized void add(String str, long j) {
            if (!this.c) {
                this.b.add(new a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public void finalize() throws Throwable {
            if (!this.c) {
                finish("Request on the loose");
                ApollonLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }

        public synchronized void finish(String str) {
            this.c = true;
            long a2 = a();
            if (a2 > 0) {
                long j = this.b.get(0).c;
                ApollonLog.d("(%-4d ms) %s", Long.valueOf(a2), str);
                for (a next : this.b) {
                    long j2 = next.c;
                    ApollonLog.d("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(next.b), next.a);
                    j = j2;
                }
            }
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClassName().equals(a)) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + IStringUtil.CURRENT_PATH + stackTrace[i2].getMethodName();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    public static void d(String str, Object... objArr) {
        a(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        a(str, objArr);
    }

    public static void setTag(String str) {
        d("Changing log tag to %s", str);
        TAG = str;
        DEBUG = Log.isLoggable(str, 2);
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG) {
            a(str, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr));
    }

    public static void e(Throwable th2, String str, Object... objArr) {
        a(str, objArr);
    }

    public static void wtf(Throwable th2, String str, Object... objArr) {
        Log.wtf(TAG, a(str, objArr), th2);
    }
}
