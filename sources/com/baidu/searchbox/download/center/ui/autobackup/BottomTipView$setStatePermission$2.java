package com.baidu.searchbox.download.center.ui.autobackup;

import com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomTipView.kt */
final class BottomTipView$setStatePermission$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BottomTipView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomTipView$setStatePermission$2(BottomTipView bottomTipView) {
        super(0);
        this.this$0 = bottomTipView;
    }

    public final void invoke() {
        BottomTipView.recordTipCloseTime$default(this.this$0, (String) null, 1, (Object) null);
        BottomTipView.recordTipCloseClickCount$default(this.this$0, false, (String) null, 2, (Object) null);
        DownloadCenterStatistic.INSTANCE.ubcPermissionTipClickClose();
    }
}
