package com.baidu.searchbox.live.storage.di;

import com.baidu.pyramid.annotation.Provider;
import com.baidu.searchbox.live.cleaner.LiveStorageAppInfoImpl;

public class LiveStorageAppInfoInterface_LiveStorageAppInfoComponent_Provider implements Provider {
    public Object get() {
        return new LiveStorageAppInfoImpl();
    }
}
