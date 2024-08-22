package com.baidu.searchbox.video.feedflow.detail.container;

import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BottomContainer$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ BottomContainer f$0;
    public final /* synthetic */ ComponentArchManager f$1;

    public /* synthetic */ BottomContainer$$ExternalSyntheticLambda1(BottomContainer bottomContainer, ComponentArchManager componentArchManager) {
        this.f$0 = bottomContainer;
        this.f$1 = componentArchManager;
    }

    public final void onChanged(Object obj) {
        BottomContainer.m11119subscribe$lambda1(this.f$0, this.f$1, (Boolean) obj);
    }
}
