package com.baidu.searchbox.video.feedflow.detail.audit;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuditItemLayoutManager.kt */
final class AuditItemLayoutManager$initManager$3$6$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AuditItemLayoutManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuditItemLayoutManager$initManager$3$6$1(AuditItemLayoutManager auditItemLayoutManager) {
        super(0);
        this.this$0 = auditItemLayoutManager;
    }

    public final void invoke() {
        this.this$0.getViewLayoutDetector().clear();
        this.this$0.updateCenterContainerPosition();
    }
}
