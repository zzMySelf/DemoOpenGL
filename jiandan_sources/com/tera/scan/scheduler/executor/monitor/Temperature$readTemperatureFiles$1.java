package com.tera.scan.scheduler.executor.monitor;

import com.mars.kotlin.extension.LoggerKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Temperature$readTemperatureFiles$1 extends Lambda implements Function1<String, Boolean> {
    public final /* synthetic */ boolean $isCpu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Temperature$readTemperatureFiles$1(boolean z) {
        super(1);
        this.$isCpu = z;
    }

    @NotNull
    public final Boolean invoke(@NotNull String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "it");
        try {
            Boolean valueOf = Boolean.valueOf(new File(str).exists());
            StringBuilder sb = new StringBuilder();
            sb.append(this.$isCpu ? "CPU" : "GPU");
            sb.append("温度文件是否存在");
            z = ((Boolean) LoggerKt.d(valueOf, sb.toString())).booleanValue();
        } catch (Exception unused) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
