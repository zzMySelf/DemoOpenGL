package com.baidu.searchbox.music.ext.album.recommendcollect.repo;

import com.baidu.searchbox.music.ext.album.model.AlbumSongList;
import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import rx.functions.Func1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RecommendCollectRepo$$ExternalSyntheticLambda4 implements Func1 {
    public final /* synthetic */ MusicAlbum f$0;

    public /* synthetic */ RecommendCollectRepo$$ExternalSyntheticLambda4(MusicAlbum musicAlbum) {
        this.f$0 = musicAlbum;
    }

    public final Object call(Object obj) {
        return RecommendCollectRepo.m885getCandidateSongs$lambda13(this.f$0, (AlbumSongList) obj);
    }
}
