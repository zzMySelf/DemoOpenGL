package com.baidu.searchbox.video.feedflow.detail.barrage;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.barrage.BarrageOperation;
import com.baidu.searchbox.player.barrage.VulcanBarrageInfo;
import com.baidu.searchbox.video.feedflow.detail.player.SimplePlayerComponentListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/barrage/BarrageComponent$playerListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/barrage/BarrageComponent$playerListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageComponent.kt */
final class BarrageComponent$playerListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ BarrageComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BarrageComponent$playerListener$2(BarrageComponent barrageComponent) {
        super(0);
        this.this$0 = barrageComponent;
    }

    public final AnonymousClass1 invoke() {
        final BarrageComponent barrageComponent = this.this$0;
        return new SimplePlayerComponentListener() {
            public void onUpdateProgressMs(int progress, int max) {
                VulcanBarrageInfo barrageInfo = barrageComponent.getBarrageController().getBarrageInfo();
                boolean z = true;
                if (barrageInfo == null || !barrageInfo.getEnable()) {
                    z = false;
                }
                if (z && barrageComponent.isBarrageLocalSwitchOpen()) {
                    int preStartTime = (((progress / 1000) + 10) / barrageComponent.REAL_REQUEST_INTERVAL) * barrageComponent.REAL_REQUEST_INTERVAL;
                    if (preStartTime != barrageComponent.requestingStartTime && !barrageComponent.getBarrageController().getDanmakuManager().isSegmentPlayatContains(preStartTime)) {
                        barrageComponent.requestingStartTime = preStartTime;
                        barrageComponent.getBarrageController().loadBarrageData(preStartTime, preStartTime + 60, barrageComponent.getBarrageController().getBarrageInfo(), barrageComponent.getBarrageController().getBarrageManager().getCommentTag());
                    }
                    if (barrageComponent.positionMs > progress || progress - barrageComponent.positionMs >= barrageComponent.progressForwardInterval) {
                        barrageComponent.getBarrageController().getBarrageManager().getDanmakuConfig().mGlobalFlagValues.updateAll();
                        barrageComponent.controlBarrage(new BarrageOperation.Start((long) (progress / 1000)));
                    }
                }
                barrageComponent.positionMs = progress;
            }

            public void onComplete() {
            }

            public void onFirstFrame() {
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onPause() {
                /*
                    r5 = this;
                    com.baidu.searchbox.video.feedflow.detail.barrage.BarrageComponent r0 = r1
                    com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
                    r1 = 0
                    if (r0 == 0) goto L_0x0020
                    r2 = 0
                    com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
                    boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
                    if (r4 == 0) goto L_0x0015
                    com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
                    goto L_0x0016
                L_0x0015:
                    r3 = r1
                L_0x0016:
                    if (r3 == 0) goto L_0x001e
                    java.lang.Class<com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState> r1 = com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState.class
                    java.lang.Object r1 = r3.select(r1)
                L_0x001e:
                    com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState r1 = (com.baidu.searchbox.video.feedflow.detail.barrage.BarrageState) r1
                L_0x0020:
                    if (r1 != 0) goto L_0x0023
                    goto L_0x0027
                L_0x0023:
                    r0 = 1
                    r1.setPause(r0)
                L_0x0027:
                    com.baidu.searchbox.video.feedflow.detail.barrage.BarrageComponent r0 = r1
                    com.baidu.searchbox.video.feedflow.detail.barrage.BarrageViewController r0 = r0.getBarrageController()
                    com.baidu.searchbox.player.barrage.BarrageOperation$Pause r1 = com.baidu.searchbox.player.barrage.BarrageOperation.Pause.INSTANCE
                    com.baidu.searchbox.player.barrage.BarrageOperation r1 = (com.baidu.searchbox.player.barrage.BarrageOperation) r1
                    r0.controlBarrage(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.barrage.BarrageComponent$playerListener$2.AnonymousClass1.onPause():void");
            }

            public void onResume() {
                Store $this$select$iv = barrageComponent.getStore();
                if ($this$select$iv != null) {
                    State state = $this$select$iv.getState();
                    Object obj = null;
                    CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
                    if (commonState != null) {
                        obj = commonState.select(BarrageState.class);
                    }
                    BarrageState barrageState = (BarrageState) obj;
                    if (barrageState != null) {
                        BarrageComponent barrageComponent = barrageComponent;
                        BarrageState state2 = barrageState;
                        if (Intrinsics.areEqual((Object) state2.isShow().getValue(), (Object) true) && state2.isPause()) {
                            state2.setPause(false);
                            barrageComponent.getBarrageController().controlBarrage(BarrageOperation.Resume.INSTANCE);
                        }
                    }
                }
            }

            public void onStop() {
            }
        };
    }
}
