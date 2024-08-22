package com.baidu.searchbox.sport.page.chatroom.comp;

import android.media.MediaPlayer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ChatPlayerManager$$ExternalSyntheticLambda5 implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ ChatPlayerManager f$0;

    public /* synthetic */ ChatPlayerManager$$ExternalSyntheticLambda5(ChatPlayerManager chatPlayerManager) {
        this.f$0 = chatPlayerManager;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        return ChatPlayerManager.m3628createMediaPlayer$lambda5$lambda4(this.f$0, mediaPlayer, i2, i3);
    }
}
