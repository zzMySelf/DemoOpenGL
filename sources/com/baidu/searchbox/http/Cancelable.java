package com.baidu.searchbox.http;

public interface Cancelable {
    void cancel();

    boolean isCanceled();
}
