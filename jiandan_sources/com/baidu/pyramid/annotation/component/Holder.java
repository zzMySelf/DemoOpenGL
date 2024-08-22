package com.baidu.pyramid.annotation.component;

import com.baidu.pyramid.annotation.Provider;

public interface Holder<T> {
    T get();

    void qw(Provider<T> provider);
}
