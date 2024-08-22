package com.baidu.idl.authority;

public class IDLAuthorityException extends RuntimeException {
    public static final long serialVersionUID = 1;

    public IDLAuthorityException() {
    }

    public IDLAuthorityException(String str, Throwable th2) {
        super(str, th2);
    }

    public IDLAuthorityException(String str) {
        super(str);
    }

    public IDLAuthorityException(Throwable th2) {
        super(th2);
    }
}
