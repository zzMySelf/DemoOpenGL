package com.baidu.swan.apps.impl.ai.summary;

import com.baidu.searchbox.pinchsummary.guide.AbsPinchSummaryGuideView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/pinchsummary/guide/AbsPinchSummaryGuideView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanPinchSummaryController.kt */
final class SwanPinchSummaryController$showPinchSummaryGuideViewIfNeeded$guideView$1 extends Lambda implements Function1<AbsPinchSummaryGuideView, Unit> {
    public static final SwanPinchSummaryController$showPinchSummaryGuideViewIfNeeded$guideView$1 INSTANCE = new SwanPinchSummaryController$showPinchSummaryGuideViewIfNeeded$guideView$1();

    SwanPinchSummaryController$showPinchSummaryGuideViewIfNeeded$guideView$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((AbsPinchSummaryGuideView) p1);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.baidu.swan.apps.framework.ISwanAppActivityCallback} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.baidu.searchbox.pinchsummary.guide.AbsPinchSummaryGuideView r4) {
        /*
            r3 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.view.ViewParent r0 = r4.getParent()
            boolean r1 = r0 instanceof android.view.ViewGroup
            r2 = 0
            if (r1 == 0) goto L_0x0011
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0012
        L_0x0011:
            r0 = r2
        L_0x0012:
            if (r0 == 0) goto L_0x001a
            r1 = r4
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
        L_0x001a:
            java.lang.Object r0 = r4.getTag()
            boolean r1 = r0 instanceof com.baidu.swan.apps.framework.ISwanAppActivityCallback
            if (r1 == 0) goto L_0x0025
            r2 = r0
            com.baidu.swan.apps.framework.ISwanAppActivityCallback r2 = (com.baidu.swan.apps.framework.ISwanAppActivityCallback) r2
        L_0x0025:
            if (r2 == 0) goto L_0x003c
            r0 = r2
            r1 = 0
            com.baidu.swan.apps.runtime.Swan r2 = com.baidu.swan.apps.runtime.Swan.get()
            com.baidu.swan.apps.runtime.SwanApp r2 = r2.getApp()
            com.baidu.swan.apps.framework.ISwanFrameContainer r2 = r2.getSwanFrameContainer()
            if (r2 == 0) goto L_0x003a
            r2.unregisterCallback(r0)
        L_0x003a:
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.ai.summary.SwanPinchSummaryController$showPinchSummaryGuideViewIfNeeded$guideView$1.invoke(com.baidu.searchbox.pinchsummary.guide.AbsPinchSummaryGuideView):void");
    }
}
