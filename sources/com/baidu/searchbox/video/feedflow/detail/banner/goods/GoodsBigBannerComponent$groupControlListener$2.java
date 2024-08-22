package com.baidu.searchbox.video.feedflow.detail.banner.goods;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlListener;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBigBannerComponent$groupControlListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/banner/goods/GoodsBigBannerComponent$groupControlListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoodsBigBannerComponent.kt */
final class GoodsBigBannerComponent$groupControlListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ GoodsBigBannerComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GoodsBigBannerComponent$groupControlListener$2(GoodsBigBannerComponent goodsBigBannerComponent) {
        super(0);
        this.this$0 = goodsBigBannerComponent;
    }

    public final AnonymousClass1 invoke() {
        final GoodsBigBannerComponent goodsBigBannerComponent = this.this$0;
        return new IGroupControlListener() {
            /* JADX WARNING: type inference failed for: r0v9, types: [com.baidu.searchbox.feed.detail.frame.State] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void tryShowGroup(com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = "group"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    com.baidu.searchbox.video.feedflow.detail.banner.goods.GoodsBigBannerComponent r0 = r1
                    com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
                    r1 = 0
                    if (r0 == 0) goto L_0x0015
                    com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
                    com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
                    goto L_0x0016
                L_0x0015:
                    r0 = r1
                L_0x0016:
                    boolean r0 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r0)
                    if (r0 != 0) goto L_0x0051
                    com.baidu.searchbox.video.feedflow.detail.banner.goods.GoodsBigBannerComponent r0 = r1
                    com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
                    if (r0 == 0) goto L_0x0051
                    r2 = 0
                    com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
                    boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
                    if (r4 == 0) goto L_0x0030
                    com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
                    goto L_0x0031
                L_0x0030:
                    r3 = r1
                L_0x0031:
                    if (r3 == 0) goto L_0x003a
                    java.lang.Class<com.baidu.searchbox.video.feedflow.detail.banner.goods.GoodsBigBannerState> r4 = com.baidu.searchbox.video.feedflow.detail.banner.goods.GoodsBigBannerState.class
                    java.lang.Object r3 = r3.select(r4)
                    goto L_0x003b
                L_0x003a:
                    r3 = r1
                L_0x003b:
                    com.baidu.searchbox.video.feedflow.detail.banner.goods.GoodsBigBannerState r3 = (com.baidu.searchbox.video.feedflow.detail.banner.goods.GoodsBigBannerState) r3
                    if (r3 == 0) goto L_0x0051
                    com.baidu.searchbox.video.feedflow.detail.banner.goods.GoodsBigBannerComponent r0 = r1
                    com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
                    if (r0 == 0) goto L_0x004e
                    com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
                    r1 = r0
                    com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
                L_0x004e:
                    r3.showPassive(r1)
                L_0x0051:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.banner.goods.GoodsBigBannerComponent$groupControlListener$2.AnonymousClass1.tryShowGroup(com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea):void");
            }

            public void tryHideGroup(GroupControlArea group) {
                Store $this$select$iv;
                Intrinsics.checkNotNullParameter(group, "group");
                Store access$getStore = goodsBigBannerComponent.getStore();
                Object obj = null;
                if (!LandscapeFlowSwitchKt.isLandscapeFlowMode(access$getStore != null ? (AbsState) access$getStore.getState() : null) && ($this$select$iv = goodsBigBannerComponent.getStore()) != null) {
                    State state = $this$select$iv.getState();
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    if (commonState != null) {
                        obj = commonState.select(GoodsBigBannerState.class);
                    }
                    GoodsBigBannerState goodsBigBannerState = (GoodsBigBannerState) obj;
                    if (goodsBigBannerState != null) {
                        goodsBigBannerState.hide(false);
                    }
                }
            }
        };
    }
}
