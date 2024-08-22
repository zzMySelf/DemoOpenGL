package com.baidu.swan.apps.impl.inlinewidget.video.widget;

import com.baidu.swan.apps.impl.inlinewidget.video.widget.SwanInlineBaseVideoWidget;
import com.baidu.swan.apps.impl.inlinewidget.video.widget.SwanInlineLiveWidgetWrapper;
import java.util.concurrent.CountDownLatch;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SwanInlineLiveWidgetWrapper$$ExternalSyntheticLambda1 implements SwanInlineBaseVideoWidget.IKernelInstallListener {
    public final /* synthetic */ SwanInlineLiveWidgetWrapper f$0;
    public final /* synthetic */ SwanInlineLiveWidgetWrapper.Stopwatch f$1;
    public final /* synthetic */ CountDownLatch f$2;

    public /* synthetic */ SwanInlineLiveWidgetWrapper$$ExternalSyntheticLambda1(SwanInlineLiveWidgetWrapper swanInlineLiveWidgetWrapper, SwanInlineLiveWidgetWrapper.Stopwatch stopwatch, CountDownLatch countDownLatch) {
        this.f$0 = swanInlineLiveWidgetWrapper;
        this.f$1 = stopwatch;
        this.f$2 = countDownLatch;
    }

    public final void onFinished(boolean z) {
        this.f$0.m8003lambda$tryInstallPlayerKernelAsync$3$combaiduswanappsimplinlinewidgetvideowidgetSwanInlineLiveWidgetWrapper(this.f$1, this.f$2, z);
    }
}
