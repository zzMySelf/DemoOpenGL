package com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LeftSlideGuideComponent.kt */
final class LeftSlideGuideComponent$registerGuide$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ LeftSlideGuideComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LeftSlideGuideComponent$registerGuide$2(LeftSlideGuideComponent leftSlideGuideComponent) {
        super(0);
        this.this$0 = leftSlideGuideComponent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r6.getHasShown() == true) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke() {
        /*
            r7 = this;
            com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide.LeftSlideGuideComponent r0 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x002b
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r0.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r6 = 0
            if (r5 == 0) goto L_0x0017
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0018
        L_0x0017:
            r4 = r6
        L_0x0018:
            if (r4 == 0) goto L_0x0020
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide.LeftSlideGuideState> r5 = com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide.LeftSlideGuideState.class
            java.lang.Object r6 = r4.select(r5)
        L_0x0020:
            com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide.LeftSlideGuideState r6 = (com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide.LeftSlideGuideState) r6
            if (r6 == 0) goto L_0x002b
            boolean r0 = r6.getHasShown()
            if (r0 != r1) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.slideguide.leftslideguide.LeftSlideGuideComponent$registerGuide$2.invoke():java.lang.Boolean");
    }
}
