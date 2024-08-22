package com.baidu.swan.apps.core.master.isolation;

import com.baidu.swan.apps.core.master.isolation.data.HitResult;

public interface ISelectCallback<T> {
    void onSelect(HitResult hitResult, T t);
}
