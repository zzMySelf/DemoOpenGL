package com.baidu.talos.core.runtime;

public interface RuntimeCacheHolder {
    void destroyOrCacheRuntime(String str);

    void recordRuntimeCreate(String str);

    void removeRuntime(String str);
}
