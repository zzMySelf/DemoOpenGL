package com.baidu.searchbox.video.feedflow.detail.barrage;

import com.baidu.searchbox.danmakulib.danmaku.model.AbsDanmakuSync;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/barrage/BarrageViewController$danmakuSync$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/barrage/BarrageViewController$danmakuSync$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageViewController.kt */
final class BarrageViewController$danmakuSync$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ BarrageViewController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BarrageViewController$danmakuSync$2(BarrageViewController barrageViewController) {
        super(0);
        this.this$0 = barrageViewController;
    }

    public final AnonymousClass1 invoke() {
        final BarrageViewController barrageViewController = this.this$0;
        return new AbsDanmakuSync() {
            public long getUptimeMillis() {
                Integer num;
                Function0 access$getGetPlayerPositionMs$p = barrageViewController.getPlayerPositionMs;
                if (access$getGetPlayerPositionMs$p == null || (num = (Integer) access$getGetPlayerPositionMs$p.invoke()) == null) {
                    return 0;
                }
                return (long) num.intValue();
            }

            public int getSyncState() {
                return 2;
            }

            public boolean isSyncPlayingState() {
                return true;
            }
        };
    }
}
