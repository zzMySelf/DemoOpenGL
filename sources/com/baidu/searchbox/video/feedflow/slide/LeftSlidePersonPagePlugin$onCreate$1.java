package com.baidu.searchbox.video.feedflow.slide;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "event", "Landroid/view/MotionEvent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlidePersonPagePlugin.kt */
final class LeftSlidePersonPagePlugin$onCreate$1 extends Lambda implements Function1<MotionEvent, Unit> {
    final /* synthetic */ LeftSlidePersonPagePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LeftSlidePersonPagePlugin$onCreate$1(LeftSlidePersonPagePlugin leftSlidePersonPagePlugin) {
        super(1);
        this.this$0 = leftSlidePersonPagePlugin;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((MotionEvent) p1);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(android.view.MotionEvent r8) {
        /*
            r7 = this;
            com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPagePlugin r0 = r7.this$0
            com.baidu.searchbox.video.feedflow.slide.LeftSlideToastHelper r0 = r0.getLeftSlideToastHelper()
            com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPagePlugin r1 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r1 = r1.getStore()
            r2 = 0
            if (r1 == 0) goto L_0x002f
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x001b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x001c
        L_0x001b:
            r4 = r2
        L_0x001c:
            if (r4 == 0) goto L_0x0025
            java.lang.Class<com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPageState> r5 = com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPageState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0026
        L_0x0025:
            r4 = r2
        L_0x0026:
            com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPageState r4 = (com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPageState) r4
            if (r4 == 0) goto L_0x002f
            java.lang.Boolean r1 = r4.getDisableHome()
            goto L_0x0030
        L_0x002f:
            r1 = r2
        L_0x0030:
            com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPagePlugin r3 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r3 = r3.getStore()
            if (r3 == 0) goto L_0x0057
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0044
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0045
        L_0x0044:
            r5 = r2
        L_0x0045:
            if (r5 == 0) goto L_0x004e
            java.lang.Class<com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPageState> r6 = com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPageState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x004f
        L_0x004e:
            r5 = r2
        L_0x004f:
            com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPageState r5 = (com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPageState) r5
            if (r5 == 0) goto L_0x0057
            java.lang.String r2 = r5.getDisableHomeToast()
        L_0x0057:
            r0.slideLeft(r8, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.slide.LeftSlidePersonPagePlugin$onCreate$1.invoke(android.view.MotionEvent):void");
    }
}
