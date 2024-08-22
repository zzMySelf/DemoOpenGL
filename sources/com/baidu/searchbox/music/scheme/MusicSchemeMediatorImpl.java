package com.baidu.searchbox.music.scheme;

import com.baidu.searchbox.music.internal.IMusicPlayerInterceptor;
import com.baidu.searchbox.music.internal.IMusicSchemeMediator;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/scheme/MusicSchemeMediatorImpl;", "Lcom/baidu/searchbox/music/internal/IMusicSchemeMediator;", "()V", "buildMusicScheme", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeBaseDispatcher;", "interceptor", "Lcom/baidu/searchbox/music/internal/IMusicPlayerInterceptor;", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicSchemeMediatorImpl.kt */
public final class MusicSchemeMediatorImpl implements IMusicSchemeMediator {
    public UnitedSchemeBaseDispatcher buildMusicScheme(IMusicPlayerInterceptor interceptor) {
        SearchMusicSchemeDispatcher searchMusicSchemeDispatcher = new SearchMusicSchemeDispatcher();
        SearchMusicSchemeDispatcher $this$buildMusicScheme_u24lambda_u2d1 = searchMusicSchemeDispatcher;
        if (interceptor != null) {
            $this$buildMusicScheme_u24lambda_u2d1.setMusicSchemeInterceptor(interceptor);
        }
        return searchMusicSchemeDispatcher;
    }
}
