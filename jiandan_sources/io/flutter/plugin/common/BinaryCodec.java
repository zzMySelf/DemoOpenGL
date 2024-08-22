package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

public final class BinaryCodec implements MessageCodec<ByteBuffer> {
    public static final BinaryCodec INSTANCE = new BinaryCodec();
    public static final BinaryCodec INSTANCE_DIRECT = new BinaryCodec(true);
    public final boolean returnsDirectByteBufferFromDecoding;

    public BinaryCodec() {
        this.returnsDirectByteBufferFromDecoding = false;
    }

    public ByteBuffer encodeMessage(@Nullable ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public ByteBuffer decodeMessage(@Nullable ByteBuffer byteBuffer) {
        if (byteBuffer == null || this.returnsDirectByteBufferFromDecoding) {
            return byteBuffer;
        }
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
        allocate.put(byteBuffer);
        allocate.rewind();
        return allocate;
    }

    public BinaryCodec(boolean z) {
        this.returnsDirectByteBufferFromDecoding = z;
    }
}
