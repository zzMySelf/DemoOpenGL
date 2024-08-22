package com.baidu.talos.core.render;

import com.baidu.talos.core.exception.JSApplicationCausedNativeException;

public class IllegalViewOperationException extends JSApplicationCausedNativeException {
    public IllegalViewOperationException(String msg) {
        super(msg);
    }
}
