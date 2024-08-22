package com.baidu.searchbox.video.feedflow.common.downgrade;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DowngradeModel.kt */
final class DynamicDowngradeModel$available$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ DynamicDowngradeModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DynamicDowngradeModel$available$2(DynamicDowngradeModel dynamicDowngradeModel) {
        super(0);
        this.this$0 = dynamicDowngradeModel;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.this$0.getEnable() && this.this$0.getInspectionTime() > 0 && this.this$0.getPerformanceThreshold() > 0 && this.this$0.getTriggerThreshold() > 0);
    }
}
