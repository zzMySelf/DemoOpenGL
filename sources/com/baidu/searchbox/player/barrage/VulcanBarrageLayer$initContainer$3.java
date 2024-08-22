package com.baidu.searchbox.player.barrage;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanBarrageLayer.kt */
final class VulcanBarrageLayer$initContainer$3 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ VulcanBarrageLayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VulcanBarrageLayer$initContainer$3(VulcanBarrageLayer vulcanBarrageLayer) {
        super(0);
        this.this$0 = vulcanBarrageLayer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r3 == com.baidu.searchbox.player.constants.PlayerStatus.PLAYING) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke() {
        /*
            r5 = this;
            com.baidu.searchbox.player.barrage.VulcanBarrageLayer r0 = r5.this$0
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r0 = r0.getBindPlayer()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isForeground()
            if (r0 != r1) goto L_0x0012
            r0 = r1
            goto L_0x0013
        L_0x0012:
            r0 = r2
        L_0x0013:
            if (r0 == 0) goto L_0x0039
            com.baidu.searchbox.player.barrage.VulcanBarrageLayer r0 = r5.this$0
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r0 = r0.getBindPlayer()
            r3 = 0
            if (r0 == 0) goto L_0x0023
            com.baidu.searchbox.player.constants.PlayerStatus r0 = r0.getStatus()
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            com.baidu.searchbox.player.constants.PlayerStatus r4 = com.baidu.searchbox.player.constants.PlayerStatus.PAUSE
            if (r0 == r4) goto L_0x003a
            com.baidu.searchbox.player.barrage.VulcanBarrageLayer r0 = r5.this$0
            com.baidu.searchbox.player.BaseVulcanVideoPlayer r0 = r0.getBindPlayer()
            if (r0 == 0) goto L_0x0034
            com.baidu.searchbox.player.constants.PlayerStatus r3 = r0.getStatus()
        L_0x0034:
            com.baidu.searchbox.player.constants.PlayerStatus r0 = com.baidu.searchbox.player.constants.PlayerStatus.PLAYING
            if (r3 != r0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r1 = r2
        L_0x003a:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.barrage.VulcanBarrageLayer$initContainer$3.invoke():java.lang.Boolean");
    }
}
