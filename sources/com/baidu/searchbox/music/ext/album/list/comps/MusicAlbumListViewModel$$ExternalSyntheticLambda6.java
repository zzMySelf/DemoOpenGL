package com.baidu.searchbox.music.ext.album.list.comps;

import com.baidu.searchbox.music.ext.album.playback.PlaybackState;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MusicAlbumListViewModel$$ExternalSyntheticLambda6 implements Action1 {
    public final /* synthetic */ MusicAlbumListViewModel f$0;

    public /* synthetic */ MusicAlbumListViewModel$$ExternalSyntheticLambda6(MusicAlbumListViewModel musicAlbumListViewModel) {
        this.f$0 = musicAlbumListViewModel;
    }

    public final void call(Object obj) {
        MusicAlbumListViewModel.m803subscribePlayStateChanged$lambda16(this.f$0, (PlaybackState) obj);
    }
}
