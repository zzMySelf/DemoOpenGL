package fe.vvv.ad.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "BuffersJvmKt")
public final class qw {
    @NotNull
    public static final FloatBuffer ad(int i2) {
        FloatBuffer asFloatBuffer = qw(i2 * 4).asFloatBuffer();
        Intrinsics.checkNotNullExpressionValue(asFloatBuffer, "byteBuffer(size * Egloo.…OF_FLOAT).asFloatBuffer()");
        return asFloatBuffer;
    }

    @NotNull
    public static final ByteBuffer qw(int i2) {
        ByteBuffer order = ByteBuffer.allocateDirect(i2 * 1).order(ByteOrder.nativeOrder());
        order.limit(order.capacity());
        Intrinsics.checkNotNullExpressionValue(order, "ByteBuffer\n        .allo…it.limit(it.capacity()) }");
        return order;
    }
}
