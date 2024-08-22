package com.baidu.searchbox.logsystem.javacrash;

import java.lang.Thread;

public interface ProcessExceptionListener {
    void onProcessExceptionFail(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th2, Throwable th3);

    void onProcessExceptionStart(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th2);

    void onProcessExceptionSuccess(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th2);

    void onProxyProcessExceptionFail(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th2, Throwable th3);

    void onProxyProcessExceptionStart(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th2);

    void onProxyProcessExceptionSuccess(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Throwable th2);
}
