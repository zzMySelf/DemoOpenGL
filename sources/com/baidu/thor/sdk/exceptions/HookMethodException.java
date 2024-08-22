package com.baidu.thor.sdk.exceptions;

public class HookMethodException extends Exception {
    public HookMethodException() {
    }

    public HookMethodException(String str) {
        super(str);
    }

    public HookMethodException(String str, Throwable th2) {
        super(str, th2);
    }
}
