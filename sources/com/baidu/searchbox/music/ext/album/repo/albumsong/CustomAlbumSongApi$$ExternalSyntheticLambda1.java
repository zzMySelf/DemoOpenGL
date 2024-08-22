package com.baidu.searchbox.music.ext.album.repo.albumsong;

import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import java.util.List;
import rx.Single;
import rx.SingleSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CustomAlbumSongApi$$ExternalSyntheticLambda1 implements Single.OnSubscribe {
    public final /* synthetic */ CustomAlbumSongApi f$0;
    public final /* synthetic */ MusicAlbum f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ CustomAlbumSongApi$$ExternalSyntheticLambda1(CustomAlbumSongApi customAlbumSongApi, MusicAlbum musicAlbum, List list) {
        this.f$0 = customAlbumSongApi;
        this.f$1 = musicAlbum;
        this.f$2 = list;
    }

    public final void call(Object obj) {
        CustomAlbumSongApi.m964clearSongs$lambda6(this.f$0, this.f$1, this.f$2, (SingleSubscriber) obj);
    }
}
