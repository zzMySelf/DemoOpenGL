package com.baidu.searchbox.video.feedflow.detail.barrage;

import com.baidu.searchbox.danmakulib.DanmakuManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/danmakulib/DanmakuManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageViewController.kt */
final class BarrageViewController$barrageManager$2 extends Lambda implements Function0<DanmakuManager> {
    final /* synthetic */ BarrageViewController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BarrageViewController$barrageManager$2(BarrageViewController barrageViewController) {
        super(0);
        this.this$0 = barrageViewController;
    }

    public final DanmakuManager invoke() {
        DanmakuManager danmakuManager = new DanmakuManager(true, true);
        BarrageViewController barrageViewController = this.this$0;
        DanmakuManager $this$invoke_u24lambda_u2d0 = danmakuManager;
        $this$invoke_u24lambda_u2d0.setUserDrawCallback(barrageViewController);
        $this$invoke_u24lambda_u2d0.setBarrageType(1);
        $this$invoke_u24lambda_u2d0.danmakuUpdateBarrageView = barrageViewController.barrageView;
        return danmakuManager;
    }
}
