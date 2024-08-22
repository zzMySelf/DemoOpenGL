package com.baidu.searchbox.music.ext.mymusic.comp.song.adapter;

import android.widget.ImageView;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SongsAdapter$$ExternalSyntheticLambda3 implements Action1 {
    public final /* synthetic */ ImageView f$0;
    public final /* synthetic */ SongsAdapter f$1;

    public /* synthetic */ SongsAdapter$$ExternalSyntheticLambda3(ImageView imageView, SongsAdapter songsAdapter) {
        this.f$0 = imageView;
        this.f$1 = songsAdapter;
    }

    public final void call(Object obj) {
        SongsAdapter.m1125setFavorStatus$lambda8(this.f$0, this.f$1, (Throwable) obj);
    }
}
