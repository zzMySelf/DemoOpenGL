package com.baidu.searchbox.video.feedflow.flow.lagfluency;

import com.baidu.searchbox.fluency.tracer.video.FpsCalculateCallback;
import com.baidu.searchbox.fluency.tracer.video.FpsReportBean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FpsPlugin$onScrollListener$1$$ExternalSyntheticLambda0 implements FpsCalculateCallback {
    public final /* synthetic */ FpsPlugin f$0;

    public /* synthetic */ FpsPlugin$onScrollListener$1$$ExternalSyntheticLambda0(FpsPlugin fpsPlugin) {
        this.f$0 = fpsPlugin;
    }

    public final void onFpsCalculateComplete(FpsReportBean fpsReportBean) {
        FpsPlugin$onScrollListener$1.m6447onScrollStateChanged$lambda0(this.f$0, fpsReportBean);
    }
}
