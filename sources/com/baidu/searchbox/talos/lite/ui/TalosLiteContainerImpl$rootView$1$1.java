package com.baidu.searchbox.talos.lite.ui;

import android.view.ViewTreeObserver;
import com.baidu.searchbox.talos.lite.monitor.TalosLiteMonitorEventKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/talos/lite/ui/TalosLiteContainerImpl$rootView$1$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "lib-talos-lite-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosContainerImpl.kt */
public final class TalosLiteContainerImpl$rootView$1$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ TalosLiteRootView $this_apply;
    final /* synthetic */ TalosLiteContainerImpl this$0;

    TalosLiteContainerImpl$rootView$1$1(TalosLiteContainerImpl $receiver, TalosLiteRootView $receiver2) {
        this.this$0 = $receiver;
        this.$this_apply = $receiver2;
    }

    public boolean onPreDraw() {
        TalosLiteRootView talosLiteRootView = this.$this_apply;
        try {
            Result.Companion companion = Result.Companion;
            talosLiteRootView.getViewTreeObserver().removeOnPreDrawListener(this);
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        this.this$0.getMonitor().addEvent(TalosLiteMonitorEventKt.EVENT_S4);
        return true;
    }
}
