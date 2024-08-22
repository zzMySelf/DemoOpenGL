package com.otaliastudios.cameraview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class CameraLogger {

    /* renamed from: ad  reason: collision with root package name */
    public static int f6670ad;

    /* renamed from: de  reason: collision with root package name */
    public static Set<Logger> f6671de = new CopyOnWriteArraySet();
    @VisibleForTesting

    /* renamed from: fe  reason: collision with root package name */
    public static Logger f6672fe = new qw();
    @NonNull
    public String qw;

    public interface Logger {
        void qw(int i2, @NonNull String str, @NonNull String str2, @Nullable Throwable th2);
    }

    public class qw implements Logger {
        public void qw(int i2, @NonNull String str, @NonNull String str2, @Nullable Throwable th2) {
        }
    }

    static {
        th(3);
        f6671de.add(f6672fe);
    }

    public CameraLogger(@NonNull String str) {
        this.qw = str;
    }

    public static CameraLogger qw(@NonNull String str) {
        return new CameraLogger(str);
    }

    public static void rg(@NonNull Logger logger) {
        f6671de.add(logger);
    }

    public static void th(int i2) {
        f6670ad = i2;
    }

    @Nullable
    public String ad(@NonNull Object... objArr) {
        return fe(3, objArr);
    }

    @Nullable
    public String de(@NonNull Object... objArr) {
        return fe(1, objArr);
    }

    @Nullable
    public final String fe(int i2, @NonNull Object... objArr) {
        Throwable th2 = null;
        if (!yj(i2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Throwable th3 : objArr) {
            if (th3 instanceof Throwable) {
                th2 = th3;
            }
            sb.append(String.valueOf(th3));
            sb.append(" ");
        }
        String trim = sb.toString().trim();
        for (Logger qw2 : f6671de) {
            qw2.qw(i2, this.qw, trim, th2);
        }
        return trim;
    }

    @Nullable
    public String i(@NonNull Object... objArr) {
        return fe(2, objArr);
    }

    @Nullable
    public String uk(@NonNull Object... objArr) {
        return fe(0, objArr);
    }

    public final boolean yj(int i2) {
        return f6670ad <= i2 && f6671de.size() > 0;
    }
}
