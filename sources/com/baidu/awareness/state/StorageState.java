package com.baidu.awareness.state;

import com.baidu.awareness.impl.BaseState;

public class StorageState extends BaseState {
    public long avaiableStorage;
    public long totalStorage;

    public long validityDuration() {
        return 300000;
    }

    /* access modifiers changed from: protected */
    public int getType() {
        return 10;
    }
}
