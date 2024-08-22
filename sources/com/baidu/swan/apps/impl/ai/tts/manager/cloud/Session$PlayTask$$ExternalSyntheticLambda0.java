package com.baidu.swan.apps.impl.ai.tts.manager.cloud;

import android.media.MediaPlayer;
import com.baidu.swan.apps.impl.ai.tts.manager.cloud.Session;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Session$PlayTask$$ExternalSyntheticLambda0 implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ MediaPlayer f$0;
    public final /* synthetic */ Session.PlayTask f$1;

    public /* synthetic */ Session$PlayTask$$ExternalSyntheticLambda0(MediaPlayer mediaPlayer, Session.PlayTask playTask) {
        this.f$0 = mediaPlayer;
        this.f$1 = playTask;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        Session.PlayTask.m7964player$lambda9$lambda7$lambda4(this.f$0, this.f$1, mediaPlayer);
    }
}
