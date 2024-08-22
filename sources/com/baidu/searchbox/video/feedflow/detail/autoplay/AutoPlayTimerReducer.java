package com.baidu.searchbox.video.feedflow.detail.autoplay;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/autoplay/AutoPlayTimerReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "reduce", "state", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoPlayTimerReducer.kt */
public final class AutoPlayTimerReducer implements Reducer<CommonState> {
    /* JADX WARNING: type inference failed for: r1v13, types: [com.baidu.searchbox.live.host2live.video.LiveType] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.feed.detail.arch.ext.CommonState reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState r6, com.baidu.searchbox.feed.detail.frame.Action r7) {
        /*
            r5 = this;
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.autoplay.StartAutoPlayCountDownAction
            r1 = 0
            if (r0 == 0) goto L_0x0043
            boolean r0 = com.baidu.searchbox.video.feedflow.detail.autoplay.AutoplayConfigKt.findAutoplaySwitch((com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6)
            if (r0 == 0) goto L_0x00be
            r2 = r6
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.livereal.LiveRealContainerState> r4 = com.baidu.searchbox.video.feedflow.detail.livereal.LiveRealContainerState.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.feedflow.detail.livereal.LiveRealContainerState r2 = (com.baidu.searchbox.video.feedflow.detail.livereal.LiveRealContainerState) r2
            if (r2 == 0) goto L_0x0027
            com.baidu.searchbox.live.host2live.video.LiveType r1 = r2.getLiveType()
        L_0x0027:
            com.baidu.searchbox.live.host2live.video.LiveType r2 = com.baidu.searchbox.live.host2live.video.LiveType.MEDIA
            if (r1 == r2) goto L_0x00be
            r1 = r6
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState> r3 = com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState.class
            java.lang.Object r1 = r1.select(r3)
            com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState r1 = (com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState) r1
            if (r1 == 0) goto L_0x00be
            r2 = r7
            com.baidu.searchbox.video.feedflow.detail.autoplay.StartAutoPlayCountDownAction r2 = (com.baidu.searchbox.video.feedflow.detail.autoplay.StartAutoPlayCountDownAction) r2
            long r2 = r2.getCountDownMills()
            r1.start(r2)
            goto L_0x00be
        L_0x0043:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.autoplay.DisableAutoPlayCountDownAction
            if (r0 == 0) goto L_0x0058
            r0 = r6
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState> r2 = com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState r0 = (com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState) r0
            if (r0 == 0) goto L_0x00be
            r0.disableCountDown()
            goto L_0x00be
        L_0x0058:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.autoplay.CancelAutoPlayCountDownAction
            if (r0 == 0) goto L_0x006c
            r0 = r6
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState> r2 = com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState r0 = (com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState) r0
            if (r0 == 0) goto L_0x00be
            r0.cancel()
            goto L_0x00be
        L_0x006c:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.autoplay.PauseAutoPlayCountDownAction
            if (r0 == 0) goto L_0x0089
            r0 = r6
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState> r3 = com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState r0 = (com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState) r0
            if (r0 == 0) goto L_0x0080
            androidx.lifecycle.MutableLiveData r1 = r0.getPauseTimer()
        L_0x0080:
            if (r1 != 0) goto L_0x0083
            goto L_0x00be
        L_0x0083:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.setValue(r0)
            goto L_0x00be
        L_0x0089:
            boolean r0 = r7 instanceof com.baidu.searchbox.video.feedflow.detail.autoplay.ResumeAutoPlayCountDownAction
            if (r0 == 0) goto L_0x00a6
            r0 = r6
            r2 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState> r3 = com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState.class
            java.lang.Object r0 = r0.select(r3)
            com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState r0 = (com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState) r0
            if (r0 == 0) goto L_0x009d
            androidx.lifecycle.MutableLiveData r1 = r0.getResumeTimer()
        L_0x009d:
            if (r1 != 0) goto L_0x00a0
            goto L_0x00be
        L_0x00a0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1.setValue(r0)
            goto L_0x00be
        L_0x00a6:
            boolean r0 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.NestedAction.OnDetachFromScreen
            if (r0 == 0) goto L_0x00be
            r0 = r6
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState> r2 = com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState.class
            java.lang.Object r0 = r0.select(r2)
            com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState r0 = (com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerState) r0
            if (r0 == 0) goto L_0x00be
            r1 = 0
            r0.reset()
            r0.cancel()
        L_0x00be:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.autoplay.AutoPlayTimerReducer.reduce(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.feed.detail.frame.Action):com.baidu.searchbox.feed.detail.arch.ext.CommonState");
    }
}
