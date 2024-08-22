package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public final class ByteBufferWriter {
    public static final ThreadLocal<SoftReference<byte[]>> BUFFER = new ThreadLocal<>();
    public static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    public static final long CHANNEL_FIELD_OFFSET;
    public static final Class<?> FILE_OUTPUT_STREAM_CLASS;
    public static final int MAX_CACHED_BUFFER_SIZE = 16384;
    public static final int MIN_CACHED_BUFFER_SIZE = 1024;

    static {
        Class<?> safeGetClass = safeGetClass("java.io.FileOutputStream");
        FILE_OUTPUT_STREAM_CLASS = safeGetClass;
        CHANNEL_FIELD_OFFSET = getChannelFieldOffset(safeGetClass);
    }

    public static void clearCachedBuffer() {
        BUFFER.set((Object) null);
    }

    public static byte[] getBuffer() {
        SoftReference softReference = BUFFER.get();
        if (softReference == null) {
            return null;
        }
        return (byte[]) softReference.get();
    }

    public static long getChannelFieldOffset(Class<?> cls) {
        if (cls == null) {
            return -1;
        }
        try {
            if (UnsafeUtil.hasUnsafeArrayOperations()) {
                return UnsafeUtil.objectFieldOffset(cls.getDeclaredField("channel"));
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static byte[] getOrCreateBuffer(int i2) {
        int max = Math.max(i2, 1024);
        byte[] buffer = getBuffer();
        if (buffer == null || needToReallocate(max, buffer.length)) {
            buffer = new byte[max];
            if (max <= 16384) {
                setBuffer(buffer);
            }
        }
        return buffer;
    }

    public static boolean needToReallocate(int i2, int i3) {
        return i3 < i2 && ((float) i3) < ((float) i2) * 0.5f;
    }

    public static Class<?> safeGetClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static void setBuffer(byte[] bArr) {
        BUFFER.set(new SoftReference(bArr));
    }

    public static void write(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        int position = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            } else if (!writeToChannel(byteBuffer, outputStream)) {
                byte[] orCreateBuffer = getOrCreateBuffer(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), orCreateBuffer.length);
                    byteBuffer.get(orCreateBuffer, 0, min);
                    outputStream.write(orCreateBuffer, 0, min);
                }
            }
        } finally {
            byteBuffer.position(position);
        }
    }

    public static boolean writeToChannel(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        if (CHANNEL_FIELD_OFFSET < 0 || !FILE_OUTPUT_STREAM_CLASS.isInstance(outputStream)) {
            return false;
        }
        WritableByteChannel writableByteChannel = null;
        try {
            writableByteChannel = (WritableByteChannel) UnsafeUtil.getObject((Object) outputStream, CHANNEL_FIELD_OFFSET);
        } catch (ClassCastException unused) {
        }
        if (writableByteChannel == null) {
            return false;
        }
        writableByteChannel.write(byteBuffer);
        return true;
    }
}
