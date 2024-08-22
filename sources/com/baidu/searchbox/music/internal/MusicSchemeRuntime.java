package com.baidu.searchbox.music.internal;

import com.baidu.searchbox.music.scheme.MusicSchemeMediatorImpl_Factory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/internal/MusicSchemeRuntime;", "", "()V", "mediator", "Lcom/baidu/searchbox/music/internal/IMusicSchemeMediator;", "getMediator", "()Lcom/baidu/searchbox/music/internal/IMusicSchemeMediator;", "lib-music-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicSchemeRuntime.kt */
public final class MusicSchemeRuntime {
    public static final MusicSchemeRuntime INSTANCE = new MusicSchemeRuntime();

    private MusicSchemeRuntime() {
    }

    public final IMusicSchemeMediator getMediator() {
        return MusicSchemeMediatorImpl_Factory.get();
    }
}
