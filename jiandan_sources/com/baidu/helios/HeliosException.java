package com.baidu.helios;

public class HeliosException extends Exception {
    public HeliosException() {
    }

    public HeliosException(String str) {
        super(str);
    }

    public HeliosException(String str, Throwable th2) {
        super(str, th2);
    }
}
