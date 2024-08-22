package com.baidu.searchbox.video.feedflow.detail.report;

import androidx.lifecycle.Observer;
import kotlin.Unit;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReportPlugin$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ ReportState f$0;
    public final /* synthetic */ ReportPlugin f$1;

    public /* synthetic */ ReportPlugin$$ExternalSyntheticLambda0(ReportState reportState, ReportPlugin reportPlugin) {
        this.f$0 = reportState;
        this.f$1 = reportPlugin;
    }

    public final void onChanged(Object obj) {
        ReportPlugin.m13319onAttachToManager$lambda2$lambda1(this.f$0, this.f$1, (Unit) obj);
    }
}
