package com.baidu.searchbox.music.ext.album.detail.comp.songlist.album;

import com.baidu.searchbox.music.bean.PlayerDurationStatInfo;
import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import java.util.List;
import rx.functions.Action0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AlbumSongListViewModel$$ExternalSyntheticLambda1 implements Action0 {
    public final /* synthetic */ AlbumSongListViewModel f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ FetchFirstNAActionAfter f$2;
    public final /* synthetic */ MusicAlbum f$3;
    public final /* synthetic */ PlayerDurationStatInfo f$4;

    public /* synthetic */ AlbumSongListViewModel$$ExternalSyntheticLambda1(AlbumSongListViewModel albumSongListViewModel, List list, FetchFirstNAActionAfter fetchFirstNAActionAfter, MusicAlbum musicAlbum, PlayerDurationStatInfo playerDurationStatInfo) {
        this.f$0 = albumSongListViewModel;
        this.f$1 = list;
        this.f$2 = fetchFirstNAActionAfter;
        this.f$3 = musicAlbum;
        this.f$4 = playerDurationStatInfo;
    }

    public final void call() {
        AlbumSongListViewModel.m748onH5SongPlayed$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
