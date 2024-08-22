package com.baidu.searchbox.video.feedflow.ad.enhancement;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/ad/enhancement/NadEnhanceComponent$groupControlListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/ad/enhancement/NadEnhanceComponent$groupControlListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadEnhanceComponent.kt */
final class NadEnhanceComponent$groupControlListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ NadEnhanceComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NadEnhanceComponent$groupControlListener$2(NadEnhanceComponent nadEnhanceComponent) {
        super(0);
        this.this$0 = nadEnhanceComponent;
    }

    public final AnonymousClass1 invoke() {
        final NadEnhanceComponent nadEnhanceComponent = this.this$0;
        return new IGroupControlListener() {
            public void tryShowGroup(GroupControlArea group) {
                Store $this$select$iv;
                Intrinsics.checkNotNullParameter(group, "group");
                if (nadEnhanceComponent.curVisibleStatus && ($this$select$iv = nadEnhanceComponent.getStore()) != null) {
                    State state = $this$select$iv.getState();
                    Object obj = null;
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    if (commonState != null) {
                        obj = commonState.select(NadEnhanceState.class);
                    }
                    NadEnhanceState nadEnhanceState = (NadEnhanceState) obj;
                    if (nadEnhanceState != null) {
                        nadEnhanceState.changeVisible(true, true);
                    }
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
            /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void tryHideGroup(com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = "group"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceComponent r0 = r1
                    com.baidu.searchbox.feed.detail.frame.Store r1 = r0.getStore()
                    r2 = 0
                    if (r1 == 0) goto L_0x0032
                    r3 = 0
                    com.baidu.searchbox.feed.detail.frame.State r4 = r1.getState()
                    boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
                    if (r5 == 0) goto L_0x001a
                    com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
                    goto L_0x001b
                L_0x001a:
                    r4 = r2
                L_0x001b:
                    if (r4 == 0) goto L_0x0024
                    java.lang.Class<com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceState> r5 = com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceState.class
                    java.lang.Object r4 = r4.select(r5)
                    goto L_0x0025
                L_0x0024:
                    r4 = r2
                L_0x0025:
                    com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceState r4 = (com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceState) r4
                    if (r4 == 0) goto L_0x0032
                    boolean r1 = r4.getVisibleState()
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                    goto L_0x0033
                L_0x0032:
                    r1 = r2
                L_0x0033:
                    boolean r1 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r1)
                    r0.curVisibleStatus = r1
                    com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceComponent r0 = r1
                    boolean r0 = r0.curVisibleStatus
                    if (r0 == 0) goto L_0x0068
                    com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceComponent r0 = r1
                    com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
                    if (r0 == 0) goto L_0x0068
                    r1 = 0
                    com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
                    boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
                    if (r4 == 0) goto L_0x0056
                    com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
                    goto L_0x0057
                L_0x0056:
                    r3 = r2
                L_0x0057:
                    if (r3 == 0) goto L_0x005f
                    java.lang.Class<com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceState> r2 = com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceState.class
                    java.lang.Object r2 = r3.select(r2)
                L_0x005f:
                    com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceState r2 = (com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceState) r2
                    if (r2 == 0) goto L_0x0068
                    r0 = 0
                    r1 = 1
                    r2.changeVisible(r0, r1)
                L_0x0068:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.enhancement.NadEnhanceComponent$groupControlListener$2.AnonymousClass1.tryHideGroup(com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea):void");
            }
        };
    }
}
