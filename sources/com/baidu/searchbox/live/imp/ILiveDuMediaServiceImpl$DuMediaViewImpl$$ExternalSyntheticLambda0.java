package com.baidu.searchbox.live.imp;

import com.baidu.cyberplayer.sdk.DuMediaPlayStatus;
import com.baidu.searchbox.live.imp.ILiveDuMediaServiceImpl;
import com.baidu.searchbox.live.interfaces.player.DuMediaView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ILiveDuMediaServiceImpl$DuMediaViewImpl$$ExternalSyntheticLambda0 implements DuMediaPlayStatus.OnPreparedListener {
    public final /* synthetic */ DuMediaView.OnPreparedListener f$0;

    public /* synthetic */ ILiveDuMediaServiceImpl$DuMediaViewImpl$$ExternalSyntheticLambda0(DuMediaView.OnPreparedListener onPreparedListener) {
        this.f$0 = onPreparedListener;
    }

    public final void onPrepared() {
        ILiveDuMediaServiceImpl.DuMediaViewImpl.m142setOnPreparedListener$lambda4(this.f$0);
    }
}
