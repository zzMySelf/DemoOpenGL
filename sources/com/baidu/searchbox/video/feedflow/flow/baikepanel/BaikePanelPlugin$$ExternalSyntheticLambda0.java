package com.baidu.searchbox.video.feedflow.flow.baikepanel;

import androidx.lifecycle.Observer;
import kotlin.Unit;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaikePanelPlugin$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ BaikePanelPlugin f$0;
    public final /* synthetic */ BaikePanelState f$1;

    public /* synthetic */ BaikePanelPlugin$$ExternalSyntheticLambda0(BaikePanelPlugin baikePanelPlugin, BaikePanelState baikePanelState) {
        this.f$0 = baikePanelPlugin;
        this.f$1 = baikePanelState;
    }

    public final void onChanged(Object obj) {
        BaikePanelPlugin.m6028onAttachToManager$lambda8$lambda1(this.f$0, this.f$1, (Unit) obj);
    }
}
