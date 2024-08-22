package com.baidu.searchbox.music.ext.comment.comp.songcard;

import androidx.lifecycle.Observer;
import kotlin.Pair;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SongCardComp$$ExternalSyntheticLambda5 implements Observer {
    public final /* synthetic */ SongCardComp f$0;

    public /* synthetic */ SongCardComp$$ExternalSyntheticLambda5(SongCardComp songCardComp) {
        this.f$0 = songCardComp;
    }

    public final void onChanged(Object obj) {
        SongCardComp.m1006bindCommentSongPosition$lambda15(this.f$0, (Pair) obj);
    }
}
