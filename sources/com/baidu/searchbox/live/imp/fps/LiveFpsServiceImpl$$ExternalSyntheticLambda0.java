package com.baidu.searchbox.live.imp.fps;

import android.content.Context;
import com.baidu.searchbox.fluency.tracer.live.FpsCalculateCallback;
import com.baidu.searchbox.fluency.tracer.live.LiveFpsReportBean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LiveFpsServiceImpl$$ExternalSyntheticLambda0 implements FpsCalculateCallback {
    public final /* synthetic */ LiveFpsServiceImpl f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ LiveFpsServiceImpl$$ExternalSyntheticLambda0(LiveFpsServiceImpl liveFpsServiceImpl, Context context, String str) {
        this.f$0 = liveFpsServiceImpl;
        this.f$1 = context;
        this.f$2 = str;
    }

    public final void onFpsCalculateComplete(LiveFpsReportBean liveFpsReportBean) {
        LiveFpsServiceImpl.m172beginFpsCollect$lambda0(this.f$0, this.f$1, this.f$2, liveFpsReportBean);
    }
}
