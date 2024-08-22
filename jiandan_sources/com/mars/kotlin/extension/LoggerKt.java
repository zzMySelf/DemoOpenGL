package com.mars.kotlin.extension;

import com.baidu.android.common.others.lang.StringUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0005\u001a!\u0010\u0006\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007\u001a!\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007\u001a!\u0010\t\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007\u001a!\u0010\n\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007\u001a!\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u0002H\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007¨\u0006\f"}, d2 = {"content", "", "T", "prefix", "", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;", "d", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "e", "i", "v", "w", "logger_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class LoggerKt {
    public static final <T> String content(T t, Object obj) {
        String obj2;
        String str = StringUtil.NULL_STRING;
        if (!(t == null || (obj2 = t.toString()) == null)) {
            str = obj2;
        }
        if (obj == null) {
            return str;
        }
        String str2 = obj + ':' + str;
        return str2 == null ? str : str2;
    }

    public static /* synthetic */ String content$default(Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj2 = null;
        }
        return content(obj, obj2);
    }

    public static final <T> T d(T t, @Nullable Object obj) {
        if (Logger.INSTANCE.getEnable()) {
            Logger.INSTANCE.tag$logger_release();
            content(t, obj);
        }
        return t;
    }

    public static /* synthetic */ Object d$default(Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj2 = null;
        }
        return d(obj, obj2);
    }

    public static final <T> T e(T t, @Nullable Object obj) {
        if (Logger.INSTANCE.getEnable()) {
            Logger.INSTANCE.tag$logger_release();
            content(t, obj);
            if (t instanceof Throwable) {
                Throwable th2 = (Throwable) t;
            }
        }
        return t;
    }

    public static /* synthetic */ Object e$default(Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj2 = null;
        }
        return e(obj, obj2);
    }

    public static final <T> T i(T t, @Nullable Object obj) {
        if (Logger.INSTANCE.getEnable()) {
            Logger.INSTANCE.tag$logger_release();
            content(t, obj);
        }
        return t;
    }

    public static /* synthetic */ Object i$default(Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj2 = null;
        }
        return i(obj, obj2);
    }

    public static final <T> T v(T t, @Nullable Object obj) {
        if (Logger.INSTANCE.getEnable()) {
            Logger.INSTANCE.tag$logger_release();
            content(t, obj);
        }
        return t;
    }

    public static /* synthetic */ Object v$default(Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj2 = null;
        }
        return v(obj, obj2);
    }

    public static final <T> T w(T t, @Nullable Object obj) {
        if (Logger.INSTANCE.getEnable()) {
            Logger.INSTANCE.tag$logger_release();
            content(t, obj);
            if (t instanceof Throwable) {
                Throwable th2 = (Throwable) t;
            }
        }
        return t;
    }

    public static /* synthetic */ Object w$default(Object obj, Object obj2, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj2 = null;
        }
        return w(obj, obj2);
    }
}
