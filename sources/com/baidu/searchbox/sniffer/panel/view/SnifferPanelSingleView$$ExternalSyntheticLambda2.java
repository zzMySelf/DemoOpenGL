package com.baidu.searchbox.sniffer.panel.view;

import android.view.View;
import com.baidu.searchbox.sniffer.SnifferSourceInfo;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SnifferPanelSingleView$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ SnifferPanelSingleView f$0;
    public final /* synthetic */ SnifferSourceInfo f$1;

    public /* synthetic */ SnifferPanelSingleView$$ExternalSyntheticLambda2(SnifferPanelSingleView snifferPanelSingleView, SnifferSourceInfo snifferSourceInfo) {
        this.f$0 = snifferPanelSingleView;
        this.f$1 = snifferSourceInfo;
    }

    public final void onClick(View view2) {
        SnifferPanelSingleView.m3286onSnifferFileUpdated$lambda0(this.f$0, this.f$1, view2);
    }
}
