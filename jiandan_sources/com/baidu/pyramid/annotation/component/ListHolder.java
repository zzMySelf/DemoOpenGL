package com.baidu.pyramid.annotation.component;

import com.baidu.pyramid.annotation.Provider;
import java.util.List;

public interface ListHolder<T> {
    void ad(Provider<List<T>> provider);

    List<T> qw();
}
