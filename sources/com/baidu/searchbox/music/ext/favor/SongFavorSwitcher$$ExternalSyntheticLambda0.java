package com.baidu.searchbox.music.ext.favor;

import com.baidu.searchbox.music.ext.album.model.MusicAlbum;
import com.baidu.searchbox.music.ext.model.ISong;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SongFavorSwitcher$$ExternalSyntheticLambda0 implements Action1 {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ ISong f$1;
    public final /* synthetic */ SongFavorSwitcher f$2;

    public /* synthetic */ SongFavorSwitcher$$ExternalSyntheticLambda0(boolean z, ISong iSong, SongFavorSwitcher songFavorSwitcher) {
        this.f$0 = z;
        this.f$1 = iSong;
        this.f$2 = songFavorSwitcher;
    }

    public final void call(Object obj) {
        SongFavorSwitcher.m1045actionFavorSuccess$lambda6(this.f$0, this.f$1, this.f$2, (MusicAlbum) obj);
    }
}
