package com.baidu.searchbox.video.feedflow.common.serviceimpl;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.video.feedflow.detail.player.IPlayerComponentListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PlayerListenerState$$ExternalSyntheticLambda11 implements Observer {
    public final /* synthetic */ IPlayerComponentListener f$0;

    public /* synthetic */ PlayerListenerState$$ExternalSyntheticLambda11(IPlayerComponentListener iPlayerComponentListener) {
        this.f$0 = iPlayerComponentListener;
    }

    public final void onChanged(Object obj) {
        PlayerListenerState.m5838observer$lambda1(this.f$0, (UpdateProgressParams) obj);
    }
}
