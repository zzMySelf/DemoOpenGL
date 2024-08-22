package com.google.protobuf;

public class ServiceException extends Exception {
    public static final long serialVersionUID = -1219262335729891920L;

    public ServiceException(String str) {
        super(str);
    }

    public ServiceException(Throwable th2) {
        super(th2);
    }

    public ServiceException(String str, Throwable th2) {
        super(str, th2);
    }
}
