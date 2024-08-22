package com.baidu.talos.core.runtime;

public interface RuntimeEventHandler {
    void attachPage(String str);

    void detachPage(String str);
}
