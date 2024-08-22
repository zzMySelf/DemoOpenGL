package com.baidu.searchbox.music.lyric.business.comp;

import com.baidu.searchbox.music.lyric.business.tools.PlayerEvent;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SearchMusicLyricViewModel$$ExternalSyntheticLambda0 implements Action1 {
    public final /* synthetic */ SearchMusicLyricViewModel f$0;

    public /* synthetic */ SearchMusicLyricViewModel$$ExternalSyntheticLambda0(SearchMusicLyricViewModel searchMusicLyricViewModel) {
        this.f$0 = searchMusicLyricViewModel;
    }

    public final void call(Object obj) {
        SearchMusicLyricViewModel.m1200registerDataSource$lambda0(this.f$0, (PlayerEvent) obj);
    }
}
