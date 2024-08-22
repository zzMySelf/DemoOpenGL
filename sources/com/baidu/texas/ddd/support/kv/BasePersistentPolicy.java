package com.baidu.texas.ddd.support.kv;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class BasePersistentPolicy {
    private final ConcurrentMap<String, KVPersistent> mNamePersistentMap = new ConcurrentHashMap();

    /* access modifiers changed from: protected */
    public abstract KVPersistent createPersistent(String str);

    public KVPersistent persistentFor(String name) {
        KVPersistent persistent = (KVPersistent) this.mNamePersistentMap.get(name);
        if (persistent != null) {
            return persistent;
        }
        KVPersistent created = createPersistent(name);
        KVPersistent persistent2 = this.mNamePersistentMap.putIfAbsent(name, created);
        if (persistent2 == null) {
            return created;
        }
        return persistent2;
    }
}
