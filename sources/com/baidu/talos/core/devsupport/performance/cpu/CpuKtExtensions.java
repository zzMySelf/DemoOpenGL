package com.baidu.talos.core.devsupport.performance.cpu;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/talos/core/devsupport/performance/cpu/CpuKtExtensions;", "", "()V", "readLong", "", "Ljava/io/File;", "lib-talos-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CpuKtExtensions.kt */
public final class CpuKtExtensions {
    public static final CpuKtExtensions INSTANCE = new CpuKtExtensions();

    private CpuKtExtensions() {
    }

    public final long readLong(File $this$readLong) {
        Intrinsics.checkNotNullParameter($this$readLong, "<this>");
        return Long.parseLong(StringsKt.trim((CharSequence) FilesKt.readText$default($this$readLong, (Charset) null, 1, (Object) null)).toString());
    }
}
