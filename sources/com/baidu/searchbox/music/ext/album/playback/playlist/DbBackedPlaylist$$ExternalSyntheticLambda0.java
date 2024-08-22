package com.baidu.searchbox.music.ext.album.playback.playlist;

import kotlin.jvm.functions.Function0;
import rx.SingleSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DbBackedPlaylist$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SingleSubscriber f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ DbBackedPlaylist$$ExternalSyntheticLambda0(SingleSubscriber singleSubscriber, Function0 function0) {
        this.f$0 = singleSubscriber;
        this.f$1 = function0;
    }

    public final void run() {
        DbBackedPlaylist.m829runRxSerial$lambda11$lambda10(this.f$0, this.f$1);
    }
}
