package com.baidu.searchbox.music.ext.related;

import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RelatedTabViewModel$$ExternalSyntheticLambda6 implements Action1 {
    public final /* synthetic */ RelatedTabViewModel f$0;

    public /* synthetic */ RelatedTabViewModel$$ExternalSyntheticLambda6(RelatedTabViewModel relatedTabViewModel) {
        this.f$0 = relatedTabViewModel;
    }

    public final void call(Object obj) {
        RelatedTabViewModel.m1147subscribePlayingAlbumChanged$lambda8(this.f$0, (MusicAlbum) obj);
    }
}
