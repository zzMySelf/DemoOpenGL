package com.baidu.searchbox.discovery.novel;

import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;

public final class NovelLog {
    private static final int CALLER_LOCATION = 4;
    private static final boolean IS_LOG_ENABLE = false;
    public static final String LOG_TAG = "#NovelLog";
    private static final int MIN_STACK_TRACE_LENGTH = 5;
    private static final String TAG = "novel[fenghuo]";
    public static final String TAG_READER_START = "ReaderStart";
    public static boolean isNovelDebug = NovelRuntime.DEBUG;
    private static boolean sDebug = (NovelRuntime.DEBUG & true);

    private enum LogLevel {
        DEBUG,
        ERROR,
        INFO,
        VERBOSE,
        WARN
    }

    private NovelLog() {
    }

    public static void setDebug(boolean aDebug) {
        sDebug = aDebug;
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static void d(String aTag, String aMessage) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, aTag, aMessage, (Throwable) null);
        }
    }

    public static void d(String aMessage) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, LOG_TAG, aMessage, (Throwable) null);
        }
    }

    public static void d(String aMessage, Throwable aThrow) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, LOG_TAG, aMessage, aThrow);
        }
    }

    public static void d(String aTag, String aMessage, Throwable aThrow) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, aTag, aMessage, aThrow);
        }
    }

    public static void p(String aMessage) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, LOG_TAG, aMessage, (Throwable) null);
        }
    }

    public static void p(String aTag, String aMessage) {
        if (sDebug) {
            doLog(LogLevel.DEBUG, aTag, aMessage, (Throwable) null);
        }
    }

    public static void e(String aTag, String aMessage) {
        if (sDebug) {
            doLog(LogLevel.ERROR, aTag, aMessage, (Throwable) null);
        }
    }

    public static void e(String aMessage) {
        if (sDebug) {
            doLog(LogLevel.ERROR, LOG_TAG, aMessage, (Throwable) null);
        }
    }

    public static void e(String aMessage, Throwable aThrow) {
        if (sDebug) {
            doLog(LogLevel.ERROR, LOG_TAG, aMessage, aThrow);
        }
    }

    public static void i(String aTag, String aMessage) {
        if (sDebug) {
            doLog(LogLevel.INFO, aTag, aMessage, (Throwable) null);
        }
    }

    public static void i(String aMessage) {
        if (sDebug) {
            doLog(LogLevel.INFO, LOG_TAG, aMessage, (Throwable) null);
        }
    }

    public static void i(String aMessage, Throwable aThrow) {
        if (sDebug) {
            doLog(LogLevel.INFO, LOG_TAG, aMessage, aThrow);
        }
    }

    public static void v(String aTAG, String aMessage) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, aTAG, aMessage, (Throwable) null);
        }
    }

    public static void v(String aMessage) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, LOG_TAG, aMessage, (Throwable) null);
        }
    }

    public static void v(String aMessage, Throwable aThrow) {
        if (sDebug) {
            doLog(LogLevel.VERBOSE, LOG_TAG, aMessage, aThrow);
        }
    }

    public static void w(String aMessage) {
        if (sDebug) {
            doLog(LogLevel.WARN, LOG_TAG, aMessage, (Throwable) null);
        }
    }

    public static void w(String aTag, String aMessage) {
        if (sDebug) {
            doLog(LogLevel.WARN, aTag, aMessage, (Throwable) null);
        }
    }

    public static void w(String aTag, String aMessage, Throwable aThrow) {
        if (sDebug) {
            doLog(LogLevel.WARN, aTag, aMessage, aThrow);
        }
    }

    public static void w(String aMessage, Throwable aThrow) {
        if (sDebug) {
            doLog(LogLevel.WARN, LOG_TAG, aMessage, aThrow);
        }
    }

    public static void printStackTrace(final Exception aException) {
        if (sDebug) {
            Thread currentThread = Thread.currentThread();
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    aException.printStackTrace();
                }
            }, "novellogtask", 3);
        }
    }

    public static void printStackTrace(final String tag) {
        if (sDebug) {
            final Thread thread = Thread.currentThread();
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
                        NovelLog.doLog(LogLevel.DEBUG, tag, stackTraceElement.toString(), (Throwable) null);
                    }
                }
            }, "novellogtask", 3);
        }
    }

    /* access modifiers changed from: private */
    public static void doLog(LogLevel aLevel, String aTag, String aMessage, Throwable aThrow) {
        if (aMessage == null) {
            aMessage = "";
        }
        String aTag2 = "#NovelLog:" + aTag;
        switch (AnonymousClass3.$SwitchMap$com$baidu$searchbox$discovery$novel$NovelLog$LogLevel[aLevel.ordinal()]) {
            case 1:
                if (aThrow == null) {
                    Log.d(aTag2, aMessage);
                    return;
                } else {
                    Log.d(aTag2, aMessage, aThrow);
                    return;
                }
            case 2:
                if (aThrow == null) {
                    Log.e(aTag2, aMessage);
                    return;
                } else {
                    Log.e(aTag2, aMessage, aThrow);
                    return;
                }
            case 3:
                if (aThrow == null) {
                    Log.i(aTag2, aMessage);
                    return;
                } else {
                    Log.i(aTag2, aMessage, aThrow);
                    return;
                }
            case 4:
                if (aThrow == null) {
                    Log.v(aTag2, aMessage);
                    return;
                } else {
                    Log.v(aTag2, aMessage, aThrow);
                    return;
                }
            case 5:
                if (aThrow == null) {
                    Log.w(aTag2, aMessage);
                    return;
                } else {
                    Log.w(aTag2, aMessage, aThrow);
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: com.baidu.searchbox.discovery.novel.NovelLog$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$discovery$novel$NovelLog$LogLevel;

        static {
            int[] iArr = new int[LogLevel.values().length];
            $SwitchMap$com$baidu$searchbox$discovery$novel$NovelLog$LogLevel = iArr;
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$discovery$novel$NovelLog$LogLevel[LogLevel.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$discovery$novel$NovelLog$LogLevel[LogLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$discovery$novel$NovelLog$LogLevel[LogLevel.VERBOSE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$discovery$novel$NovelLog$LogLevel[LogLevel.WARN.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static void f(String msg) {
    }

    private static String getCaller(String msg) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 5) {
            return msg;
        }
        StackTraceElement caller = stackTrace[4];
        StackTraceElement caller1 = stackTrace[1 + 4];
        StackTraceElement caller2 = stackTrace[2 + 4];
        StackTraceElement caller3 = stackTrace[3 + 4];
        return String.format("[%s]%s(%s:%d)->(%s:%d)->(%s:%d)->(%s:%d)", new Object[]{caller.getMethodName(), msg, caller.getFileName(), Integer.valueOf(caller.getLineNumber()), caller1.getFileName(), Integer.valueOf(caller1.getLineNumber()), caller2.getFileName(), Integer.valueOf(caller2.getLineNumber()), caller3.getFileName(), Integer.valueOf(caller3.getLineNumber())});
    }
}
