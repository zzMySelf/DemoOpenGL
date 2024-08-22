package androidx.tracing;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {
    public static final String TAG = "Trace";
    public static Method sAsyncTraceBeginMethod;
    public static Method sAsyncTraceEndMethod;
    public static Method sIsTagEnabledMethod;
    public static Method sTraceCounterMethod;
    public static long sTraceTagApp;

    @SuppressLint({"NewApi"})
    public static void beginAsyncSection(@NonNull String str, int i2) {
        try {
            if (sAsyncTraceBeginMethod == null) {
                TraceApi29Impl.beginAsyncSection(str, i2);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        beginAsyncSectionFallback(str, i2);
    }

    public static void beginAsyncSectionFallback(@NonNull String str, int i2) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (sAsyncTraceBeginMethod == null) {
                    sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                }
                sAsyncTraceBeginMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2)});
            } catch (Exception e) {
                handleException("asyncTraceBegin", e);
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceApi18Impl.beginSection(str);
        }
    }

    @SuppressLint({"NewApi"})
    public static void endAsyncSection(@NonNull String str, int i2) {
        try {
            if (sAsyncTraceEndMethod == null) {
                TraceApi29Impl.endAsyncSection(str, i2);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        endAsyncSectionFallback(str, i2);
    }

    public static void endAsyncSectionFallback(@NonNull String str, int i2) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (sAsyncTraceEndMethod == null) {
                    sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                }
                sAsyncTraceEndMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2)});
            } catch (Exception e) {
                handleException("asyncTraceEnd", e);
            }
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceApi18Impl.endSection();
        }
    }

    public static void handleException(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        "Unable to call " + str + " via reflection";
    }

    @SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        try {
            if (sIsTagEnabledMethod == null) {
                return android.os.Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return isEnabledFallback();
    }

    public static boolean isEnabledFallback() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (sIsTagEnabledMethod == null) {
                    sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                    sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
                }
                return ((Boolean) sIsTagEnabledMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
            } catch (Exception e) {
                handleException("isTagEnabled", e);
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static void setCounter(@NonNull String str, int i2) {
        try {
            if (sTraceCounterMethod == null) {
                TraceApi29Impl.setCounter(str, i2);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        setCounterFallback(str, i2);
    }

    public static void setCounterFallback(@NonNull String str, int i2) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (sTraceCounterMethod == null) {
                    sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                }
                sTraceCounterMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i2)});
            } catch (Exception e) {
                handleException("traceCounter", e);
            }
        }
    }
}
