package com.baidu.searchbox.music.player;

import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/music/player/MusicExternalHandler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewMusicPlayer.kt */
final class NewMusicPlayer$playerHandler$2 extends Lambda implements Function0<MusicExternalHandler> {
    public static final NewMusicPlayer$playerHandler$2 INSTANCE = new NewMusicPlayer$playerHandler$2();

    NewMusicPlayer$playerHandler$2() {
        super(0);
    }

    public final MusicExternalHandler invoke() {
        return new MusicExternalHandler(AppRuntime.getAppContext());
    }
}
