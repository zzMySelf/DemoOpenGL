package com.baidu.searchbox.music.ext.album.recommendcollect.common;

import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.music.ext.album.recommendcollect.common.event.SongCollectEvent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SongsCollectViewModel$$ExternalSyntheticLambda0 implements Action {
    public final /* synthetic */ SongsCollectViewModel f$0;

    public /* synthetic */ SongsCollectViewModel$$ExternalSyntheticLambda0(SongsCollectViewModel songsCollectViewModel) {
        this.f$0 = songsCollectViewModel;
    }

    public final void call(Object obj) {
        SongsCollectViewModel.m871registerSongCollectChange$lambda9(this.f$0, (SongCollectEvent) obj);
    }
}
