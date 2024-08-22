package com.baidu.searchbox.pinchsummary;

import com.baidu.searchbox.pinchsummary.model.PinchSummaryDataSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PinchSummaryGlobalManager.kt */
final class PinchSummaryGlobalManager$pinchSummaryDataSource$1 extends Lambda implements Function0<String> {
    final /* synthetic */ PinchSummaryDataSource $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PinchSummaryGlobalManager$pinchSummaryDataSource$1(PinchSummaryDataSource pinchSummaryDataSource) {
        super(0);
        this.$value = pinchSummaryDataSource;
    }

    public final String invoke() {
        return "set pinchSummaryDataSource to " + this.$value;
    }
}
