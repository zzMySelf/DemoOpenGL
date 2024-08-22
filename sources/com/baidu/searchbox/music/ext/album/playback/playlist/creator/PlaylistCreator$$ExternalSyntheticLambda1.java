package com.baidu.searchbox.music.ext.album.playback.playlist.creator;

import com.baidu.searchbox.music.ext.model.ISong;
import java.util.List;
import rx.SingleSubscriber;
import rx.functions.Action1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PlaylistCreator$$ExternalSyntheticLambda1 implements Action1 {
    public final /* synthetic */ ISong f$0;
    public final /* synthetic */ SingleSubscriber f$1;
    public final /* synthetic */ PlaylistCreatorParams f$2;

    public /* synthetic */ PlaylistCreator$$ExternalSyntheticLambda1(ISong iSong, SingleSubscriber singleSubscriber, PlaylistCreatorParams playlistCreatorParams) {
        this.f$0 = iSong;
        this.f$1 = singleSubscriber;
        this.f$2 = playlistCreatorParams;
    }

    public final void call(Object obj) {
        PlaylistCreator.m843createByInsert$lambda7$lambda5(this.f$0, this.f$1, this.f$2, (List) obj);
    }
}
