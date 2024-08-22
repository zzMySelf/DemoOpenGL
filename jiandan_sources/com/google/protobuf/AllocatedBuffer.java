package com.google.protobuf;

import java.nio.ByteBuffer;

public abstract class AllocatedBuffer {
    public static AllocatedBuffer wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    public static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i2, final int i3) {
        return new AllocatedBuffer() {
            public int position;

            public byte[] array() {
                return bArr;
            }

            public int arrayOffset() {
                return i2;
            }

            public boolean hasArray() {
                return true;
            }

            public boolean hasNioBuffer() {
                return false;
            }

            public int limit() {
                return i3;
            }

            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            public int position() {
                return this.position;
            }

            public int remaining() {
                return i3 - this.position;
            }

            public AllocatedBuffer position(int i2) {
                if (i2 < 0 || i2 > i3) {
                    throw new IllegalArgumentException("Invalid position: " + i2);
                }
                this.position = i2;
                return this;
            }
        };
    }

    public abstract byte[] array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    public abstract int limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    public abstract AllocatedBuffer position(int i2);

    public abstract int remaining();

    public static AllocatedBuffer wrap(byte[] bArr, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length) {
            return wrapNoCheck(bArr, i2, i3);
        }
        throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    public static AllocatedBuffer wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() {
            public byte[] array() {
                return byteBuffer.array();
            }

            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            public boolean hasNioBuffer() {
                return true;
            }

            public int limit() {
                return byteBuffer.limit();
            }

            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            public int position() {
                return byteBuffer.position();
            }

            public int remaining() {
                return byteBuffer.remaining();
            }

            public AllocatedBuffer position(int i2) {
                byteBuffer.position(i2);
                return this;
            }
        };
    }
}
