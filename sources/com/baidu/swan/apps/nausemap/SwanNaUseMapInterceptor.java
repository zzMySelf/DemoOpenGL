package com.baidu.swan.apps.nausemap;

interface SwanNaUseMapInterceptor<K, V> {
    void intercept(K k, V v);

    boolean shouldIntercept(K k);
}
