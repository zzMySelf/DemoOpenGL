package com.mars.united.core.debug;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/mars/united/core/debug/DevelopException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "throwable", "", "(Ljava/lang/Throwable;)V", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DevelopException extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevelopException(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DevelopException(@NotNull Throwable th2) {
        super(th2);
        Intrinsics.checkNotNullParameter(th2, "throwable");
    }
}
