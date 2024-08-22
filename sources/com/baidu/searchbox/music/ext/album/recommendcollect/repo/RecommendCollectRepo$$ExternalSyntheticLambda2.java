package com.baidu.searchbox.music.ext.album.recommendcollect.repo;

import com.baidu.searchbox.music.ext.album.model.MusicAlbumList;
import rx.functions.Func1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RecommendCollectRepo$$ExternalSyntheticLambda2 implements Func1 {
    public final /* synthetic */ RecommendCollectRepo f$0;

    public /* synthetic */ RecommendCollectRepo$$ExternalSyntheticLambda2(RecommendCollectRepo recommendCollectRepo) {
        this.f$0 = recommendCollectRepo;
    }

    public final Object call(Object obj) {
        return RecommendCollectRepo.m891getMoreCustomOrCollectAlbums$lambda7(this.f$0, (MusicAlbumList) obj);
    }
}
