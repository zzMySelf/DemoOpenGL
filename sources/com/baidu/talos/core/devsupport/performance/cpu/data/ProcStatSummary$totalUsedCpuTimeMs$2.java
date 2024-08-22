package com.baidu.talos.core.devsupport.performance.cpu.data;

import com.baidu.talos.core.devsupport.performance.cpu.util.CpuPseudoUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProcStatSummary.kt */
final class ProcStatSummary$totalUsedCpuTimeMs$2 extends Lambda implements Function0<Long> {
    final /* synthetic */ ProcStatSummary this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProcStatSummary$totalUsedCpuTimeMs$2(ProcStatSummary procStatSummary) {
        super(0);
        this.this$0 = procStatSummary;
    }

    public final Long invoke() {
        return Long.valueOf(this.this$0.getTotalUsedCpuTime() * CpuPseudoUtil.Companion.getMillSecondsPerTicks());
    }
}
