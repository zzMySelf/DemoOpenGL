package com.baidu.searchbox.music.ext.services;

import com.baidu.searchbox.nacomp.util.UniqueId;

public interface IServiceManager {
    <S> S get(UniqueId uniqueId, String str);

    <S> void register(UniqueId uniqueId, String str, S s);

    void unregister(UniqueId uniqueId, String str);
}
