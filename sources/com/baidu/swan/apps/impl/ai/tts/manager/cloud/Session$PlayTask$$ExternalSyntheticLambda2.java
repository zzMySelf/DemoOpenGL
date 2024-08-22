package com.baidu.swan.apps.impl.ai.tts.manager.cloud;

import android.media.MediaPlayer;
import com.baidu.swan.apps.impl.ai.tts.manager.cloud.Session;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Session$PlayTask$$ExternalSyntheticLambda2 implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ Session.PlayTask f$0;

    public /* synthetic */ Session$PlayTask$$ExternalSyntheticLambda2(Session.PlayTask playTask) {
        this.f$0 = playTask;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return Session.PlayTask.m7966player$lambda9$lambda7$lambda6(this.f$0, mediaPlayer, i2, i3);
    }
}
