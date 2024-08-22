package com.baidu.swan.apps.impl.inlinewidget.video.widget;

import com.baidu.rtc.nps.plugin.impl.callback.ILoadCallback;
import com.baidu.swan.apps.inlinewidget.IInlineWidget;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SwanInlineRtcLiveWidget$$ExternalSyntheticLambda4 implements ILoadCallback {
    public final /* synthetic */ SwanInlineRtcLiveWidget f$0;
    public final /* synthetic */ IInlineWidget.IWidgetInitListener f$1;

    public /* synthetic */ SwanInlineRtcLiveWidget$$ExternalSyntheticLambda4(SwanInlineRtcLiveWidget swanInlineRtcLiveWidget, IInlineWidget.IWidgetInitListener iWidgetInitListener) {
        this.f$0 = swanInlineRtcLiveWidget;
        this.f$1 = iWidgetInitListener;
    }

    public final void onResult(int i2, int i3, String str) {
        this.f$0.m8008lambda$tryInstallBrtcSdkAsync$3$combaiduswanappsimplinlinewidgetvideowidgetSwanInlineRtcLiveWidget(this.f$1, i2, i3, str);
    }
}
