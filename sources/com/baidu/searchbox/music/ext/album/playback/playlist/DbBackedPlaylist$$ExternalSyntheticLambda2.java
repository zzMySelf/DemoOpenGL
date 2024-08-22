package com.baidu.searchbox.music.ext.album.playback.playlist;

import kotlin.jvm.functions.Function0;
import rx.Single;
import rx.SingleSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DbBackedPlaylist$$ExternalSyntheticLambda2 implements Single.OnSubscribe {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ DbBackedPlaylist$$ExternalSyntheticLambda2(String str, Function0 function0) {
        this.f$0 = str;
        this.f$1 = function0;
    }

    public final void call(Object obj) {
        DbBackedPlaylist.m828runRxSerial$lambda11(this.f$0, this.f$1, (SingleSubscriber) obj);
    }
}
