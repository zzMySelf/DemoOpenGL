package com.baidu.helios;

public class HeliosException extends Exception {
    public HeliosException() {
    }

    public HeliosException(String message) {
        super(message);
    }

    public HeliosException(String message, Throwable cause) {
        super(message, cause);
    }
}
