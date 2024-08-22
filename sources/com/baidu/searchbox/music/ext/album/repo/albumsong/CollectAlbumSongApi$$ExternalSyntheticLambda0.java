package com.baidu.searchbox.music.ext.album.repo.albumsong;

import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import rx.Single;
import rx.SingleSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectAlbumSongApi$$ExternalSyntheticLambda0 implements Single.OnSubscribe {
    public final /* synthetic */ CollectAlbumSongApi f$0;
    public final /* synthetic */ MusicAlbum f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ CollectAlbumSongApi$$ExternalSyntheticLambda0(CollectAlbumSongApi collectAlbumSongApi, MusicAlbum musicAlbum, int i2, boolean z, String str) {
        this.f$0 = collectAlbumSongApi;
        this.f$1 = musicAlbum;
        this.f$2 = i2;
        this.f$3 = z;
        this.f$4 = str;
    }

    public final void call(Object obj) {
        CollectAlbumSongApi.m959getSongList$lambda1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (SingleSubscriber) obj);
    }
}
