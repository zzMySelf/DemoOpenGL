package com.baidu.pyramid.runtime.multiprocess;

public class WrongProcessException extends IllegalStateException {
    public WrongProcessException() {
    }

    public WrongProcessException(String str) {
        super(str);
    }
}
