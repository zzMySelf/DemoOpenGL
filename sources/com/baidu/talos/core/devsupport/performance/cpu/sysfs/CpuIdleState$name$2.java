package com.baidu.talos.core.devsupport.performance.cpu.sysfs;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CpuIdleState.kt */
final class CpuIdleState$name$2 extends Lambda implements Function0<String> {
    final /* synthetic */ CpuIdleState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CpuIdleState$name$2(CpuIdleState cpuIdleState) {
        super(0);
        this.this$0 = cpuIdleState;
    }

    public final String invoke() {
        return FilesKt.readText$default(new File(this.this$0.getPseudoPath(), "name"), (Charset) null, 1, (Object) null);
    }
}
