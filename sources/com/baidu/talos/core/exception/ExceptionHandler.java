package com.baidu.talos.core.exception;

import com.baidu.talos.core.data.ParamArray;

public interface ExceptionHandler {
    void handleCppException(String str);

    void handleJavaException(int i2, String str, Throwable th2);

    void handleJavaException(String str, Throwable th2);

    void handleJsException(int i2, String str, ParamArray paramArray, int i3);
}
