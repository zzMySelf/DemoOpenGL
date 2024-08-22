package com.baidu.searchbox.live.storage.di;

import com.baidu.pyramid.annotation.component.DefaultHolder;
import com.baidu.pyramid.annotation.component.Holder;

public class LiveStorageThreadExecutorComponent {
    public Holder<LiveStorageThreadExecutorInterface> executor;

    public void initexecutor() {
        DefaultHolder create = DefaultHolder.create();
        this.executor = create;
        create.set(new LiveStorageThreadExecutorInterface_LiveStorageThreadExecutorComponent_Provider());
    }

    public LiveStorageThreadExecutorComponent() {
        initexecutor();
    }
}
