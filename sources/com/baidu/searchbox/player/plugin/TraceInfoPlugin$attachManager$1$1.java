package com.baidu.searchbox.player.plugin;

import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.interfaces.INeuron;
import com.baidu.searchbox.player.interfaces.IVideoEventInterceptor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/player/plugin/TraceInfoPlugin$attachManager$1$1", "Lcom/baidu/searchbox/player/interfaces/IVideoEventInterceptor;", "getInterceptorLayer", "Lcom/baidu/searchbox/player/interfaces/INeuron;", "onInterceptorEvent", "", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TraceInfoPlugin.kt */
public final class TraceInfoPlugin$attachManager$1$1 implements IVideoEventInterceptor {
    final /* synthetic */ BDVideoPlayer $this_run;
    final /* synthetic */ TraceInfoPlugin this$0;

    TraceInfoPlugin$attachManager$1$1(BDVideoPlayer $receiver, TraceInfoPlugin $receiver2) {
        this.$this_run = $receiver;
        this.this$0 = $receiver2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a1, code lost:
        if (r4 != false) goto L_0x00a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptorEvent(com.baidu.searchbox.player.event.VideoEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = r7.getAction()
            int r1 = r0.hashCode()
            java.lang.String r2 = ""
            java.lang.String r3 = "createSessionId()"
            r4 = 1
            r5 = 0
            switch(r1) {
                case -882902390: goto L_0x006c;
                case 1370689931: goto L_0x0049;
                case 1939755256: goto L_0x0018;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x00c0
        L_0x0018:
            java.lang.String r1 = "layer_event_change_clarity"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0021
            goto L_0x0016
        L_0x0021:
            com.baidu.searchbox.player.plugin.TraceInfoPlugin r0 = r6.this$0
            com.baidu.searchbox.player.BDVideoPlayer r1 = r6.$this_run
            java.lang.String r1 = r1.createSessionId()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r0.lastSessionId = r1
            com.baidu.searchbox.player.BDVideoPlayer r0 = r6.$this_run
            com.baidu.searchbox.player.model.BasicVideoSeries r0 = r0.getVideoSeries()
            com.baidu.searchbox.player.plugin.TraceInfoPlugin r1 = r6.this$0
            java.lang.String r1 = r1.lastSessionId
            com.baidu.searchbox.player.utils.TraceUtil.setSessionId(r0, r1)
            com.baidu.searchbox.player.BDVideoPlayer r0 = r6.$this_run
            com.baidu.searchbox.player.model.BasicVideoSeries r0 = r0.getVideoSeries()
            com.baidu.searchbox.player.utils.TraceUtil.setLogId(r0, r2)
            goto L_0x00c0
        L_0x0049:
            java.lang.String r1 = "player_event_on_info"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0053
            goto L_0x0016
        L_0x0053:
            int r0 = r7.getIntExtra(r4)
            r1 = 11008(0x2b00, float:1.5425E-41)
            if (r0 != r1) goto L_0x00c0
            com.baidu.searchbox.player.BDVideoPlayer r0 = r6.$this_run
            com.baidu.searchbox.player.model.BasicVideoSeries r0 = r0.getVideoSeries()
            if (r0 == 0) goto L_0x00c0
            r1 = 3
            java.lang.String r1 = r7.getStringExtra(r1)
            com.baidu.searchbox.player.utils.TraceUtil.setLogId(r0, r1)
            goto L_0x00c0
        L_0x006c:
            java.lang.String r1 = "player_event_set_data"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0076
            goto L_0x0016
        L_0x0076:
            com.baidu.searchbox.player.BDVideoPlayer r0 = r6.$this_run
            com.baidu.searchbox.player.model.BasicVideoSeries r0 = r0.getVideoSeries()
            if (r0 == 0) goto L_0x0083
            boolean r0 = r0.isNeedPrepare()
            goto L_0x0084
        L_0x0083:
            r0 = r5
        L_0x0084:
            if (r0 == 0) goto L_0x008f
            com.baidu.searchbox.player.BDVideoPlayer r1 = r6.$this_run
            com.baidu.searchbox.player.model.BasicVideoSeries r1 = r1.getVideoSeries()
            com.baidu.searchbox.player.utils.TraceUtil.setLogId(r1, r2)
        L_0x008f:
            if (r0 != 0) goto L_0x00a3
            com.baidu.searchbox.player.plugin.TraceInfoPlugin r1 = r6.this$0
            java.lang.String r1 = r1.lastSessionId
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r4 = r5
        L_0x00a1:
            if (r4 == 0) goto L_0x00b1
        L_0x00a3:
            com.baidu.searchbox.player.plugin.TraceInfoPlugin r1 = r6.this$0
            com.baidu.searchbox.player.BDVideoPlayer r2 = r6.$this_run
            java.lang.String r2 = r2.createSessionId()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.lastSessionId = r2
        L_0x00b1:
            com.baidu.searchbox.player.BDVideoPlayer r1 = r6.$this_run
            com.baidu.searchbox.player.model.BasicVideoSeries r1 = r1.getVideoSeries()
            com.baidu.searchbox.player.plugin.TraceInfoPlugin r2 = r6.this$0
            java.lang.String r2 = r2.lastSessionId
            com.baidu.searchbox.player.utils.TraceUtil.setSessionId(r1, r2)
        L_0x00c0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.plugin.TraceInfoPlugin$attachManager$1$1.onInterceptorEvent(com.baidu.searchbox.player.event.VideoEvent):boolean");
    }

    public INeuron getInterceptorLayer() {
        return this.this$0;
    }
}
