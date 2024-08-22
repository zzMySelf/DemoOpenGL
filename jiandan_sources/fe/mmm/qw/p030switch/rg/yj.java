package fe.mmm.qw.p030switch.rg;

import java.nio.ByteBuffer;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.switch.rg.yj  reason: invalid package */
public final class yj {
    @NotNull
    public static final String qw() {
        String str;
        try {
            Result.Companion companion = Result.Companion;
            str = Result.m1155constructorimpl(UUID.nameUUIDFromBytes(ByteBuffer.allocate(8).putLong(System.currentTimeMillis()).array()).toString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            str = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        if (Result.m1161isFailureimpl(str)) {
            str = uuid;
        }
        return (String) str;
    }
}
