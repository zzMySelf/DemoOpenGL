package com.baidu.searchbox.logsystem.javacrash;

import androidx.annotation.NonNull;
import java.lang.Thread;

public interface ProcessExceptionListener {
    void ad(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th2, @NonNull Throwable th3);

    void de(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th2);

    void fe(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th2);

    void qw(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th2);

    void rg(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th2, @NonNull Throwable th3);

    void th(@NonNull Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Throwable th2);
}
