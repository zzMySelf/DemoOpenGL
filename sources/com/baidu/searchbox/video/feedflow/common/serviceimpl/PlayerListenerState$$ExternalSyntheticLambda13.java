package com.baidu.searchbox.video.feedflow.common.serviceimpl;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.video.feedflow.detail.player.IPlayerComponentListener;
import kotlin.Unit;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PlayerListenerState$$ExternalSyntheticLambda13 implements Observer {
    public final /* synthetic */ IPlayerComponentListener f$0;

    public /* synthetic */ PlayerListenerState$$ExternalSyntheticLambda13(IPlayerComponentListener iPlayerComponentListener) {
        this.f$0 = iPlayerComponentListener;
    }

    public final void onChanged(Object obj) {
        PlayerListenerState.m5845observer$lambda3(this.f$0, (Unit) obj);
    }
}
