package com.google.protobuf;

import com.alipay.sdk.m.n.a;
import com.google.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    public static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    public boolean serializationDeterministic;
    public CodedOutputStreamWriter wrapper;

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        public final byte[] buffer;
        public final int limit;
        public int position;
        public int totalBytesWritten;

        public AbstractBufferedEncoder(int i2) {
            super();
            if (i2 >= 0) {
                byte[] bArr = new byte[Math.max(i2, 20)];
                this.buffer = bArr;
                this.limit = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        public final void buffer(byte b) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = b;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int i2) {
            byte[] bArr = this.buffer;
            int i3 = this.position;
            int i4 = i3 + 1;
            this.position = i4;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i4 + 1;
            this.position = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i5 + 1;
            this.position = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.position = i6 + 1;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            bArr[i2] = (byte) ((int) (j & 255));
            int i4 = i3 + 1;
            this.position = i4;
            bArr[i3] = (byte) ((int) ((j >> 8) & 255));
            int i5 = i4 + 1;
            this.position = i5;
            bArr[i4] = (byte) ((int) ((j >> 16) & 255));
            int i6 = i5 + 1;
            this.position = i6;
            bArr[i5] = (byte) ((int) (255 & (j >> 24)));
            int i7 = i6 + 1;
            this.position = i7;
            bArr[i6] = (byte) (((int) (j >> 32)) & 255);
            int i8 = i7 + 1;
            this.position = i8;
            bArr[i7] = (byte) (((int) (j >> 40)) & 255);
            int i9 = i8 + 1;
            this.position = i9;
            bArr[i8] = (byte) (((int) (j >> 48)) & 255);
            this.position = i9 + 1;
            bArr[i9] = (byte) (((int) (j >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int i2) {
            if (i2 >= 0) {
                bufferUInt32NoTag(i2);
            } else {
                bufferUInt64NoTag((long) i2);
            }
        }

        public final void bufferTag(int i2, int i3) {
            bufferUInt32NoTag(WireFormat.makeTag(i2, i3));
        }

        public final void bufferUInt32NoTag(int i2) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j = (long) this.position;
                while ((i2 & a.g) != 0) {
                    byte[] bArr = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    UnsafeUtil.putByte(bArr, (long) i3, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                UnsafeUtil.putByte(bArr2, (long) i4, (byte) i2);
                this.totalBytesWritten += (int) (((long) this.position) - j);
                return;
            }
            while ((i2 & a.g) != 0) {
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr3[i5] = (byte) ((i2 & 127) | 128);
                this.totalBytesWritten++;
                i2 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i6 = this.position;
            this.position = i6 + 1;
            bArr4[i6] = (byte) i2;
            this.totalBytesWritten++;
        }

        public final void bufferUInt64NoTag(long j) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j2 = (long) this.position;
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    UnsafeUtil.putByte(bArr, (long) i2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                UnsafeUtil.putByte(bArr2, (long) i3, (byte) ((int) j));
                this.totalBytesWritten += (int) (((long) this.position) - j2);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) ((((int) j) & 127) | 128);
                this.totalBytesWritten++;
                j >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr4[i5] = (byte) ((int) j);
            this.totalBytesWritten++;
        }

        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {
        public final byte[] buffer;
        public final int limit;
        public final int offset;
        public int position;

        public ArrayEncoder(byte[] bArr, int i2, int i3) {
            super();
            if (bArr != null) {
                int i4 = i2 + i3;
                if ((i2 | i3 | (bArr.length - i4)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i2;
                    this.position = i2;
                    this.limit = i4;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        public final int spaceLeft() {
            return this.limit - this.position;
        }

        public final void write(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void writeBool(int i2, boolean z) throws IOException {
            writeTag(i2, 0);
            write(z ? (byte) 1 : 0);
        }

        public final void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        public final void writeByteArrayNoTag(byte[] bArr, int i2, int i3) throws IOException {
            writeUInt32NoTag(i3);
            write(bArr, i2, i3);
        }

        public final void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public final void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public final void writeFixed32(int i2, int i3) throws IOException {
            writeTag(i2, 5);
            writeFixed32NoTag(i3);
        }

        public final void writeFixed32NoTag(int i2) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) (i2 & 255);
                byte[] bArr2 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr2[i4] = (byte) ((i2 >> 8) & 255);
                byte[] bArr3 = this.buffer;
                int i6 = i5 + 1;
                this.position = i6;
                bArr3[i5] = (byte) ((i2 >> 16) & 255);
                byte[] bArr4 = this.buffer;
                this.position = i6 + 1;
                bArr4[i6] = (byte) ((i2 >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void writeFixed64(int i2, long j) throws IOException {
            writeTag(i2, 1);
            writeFixed64NoTag(j);
        }

        public final void writeFixed64NoTag(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) (((int) j) & 255);
                byte[] bArr2 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr2[i3] = (byte) (((int) (j >> 8)) & 255);
                byte[] bArr3 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr3[i4] = (byte) (((int) (j >> 16)) & 255);
                byte[] bArr4 = this.buffer;
                int i6 = i5 + 1;
                this.position = i6;
                bArr4[i5] = (byte) (((int) (j >> 24)) & 255);
                byte[] bArr5 = this.buffer;
                int i7 = i6 + 1;
                this.position = i7;
                bArr5[i6] = (byte) (((int) (j >> 32)) & 255);
                byte[] bArr6 = this.buffer;
                int i8 = i7 + 1;
                this.position = i8;
                bArr6[i7] = (byte) (((int) (j >> 40)) & 255);
                byte[] bArr7 = this.buffer;
                int i9 = i8 + 1;
                this.position = i9;
                bArr7[i8] = (byte) (((int) (j >> 48)) & 255);
                byte[] bArr8 = this.buffer;
                this.position = i9 + 1;
                bArr8[i9] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void writeInt32(int i2, int i3) throws IOException {
            writeTag(i2, 0);
            writeInt32NoTag(i3);
        }

        public final void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag((long) i2);
            }
        }

        public final void writeLazy(byte[] bArr, int i2, int i3) throws IOException {
            write(bArr, i2, i3);
        }

        public final void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public final void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public final void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public final void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        public final void writeStringNoTag(String str) throws IOException {
            int i2 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i3 = i2 + computeUInt32SizeNoTag2;
                    this.position = i3;
                    int encode = Utf8.encode(str, this.buffer, i3, spaceLeft());
                    this.position = i2;
                    writeUInt32NoTag((encode - i2) - computeUInt32SizeNoTag2);
                    this.position = encode;
                    return;
                }
                writeUInt32NoTag(Utf8.encodedLength(str));
                this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
            } catch (Utf8.UnpairedSurrogateException e) {
                this.position = i2;
                inefficientWriteStringNoTag(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public final void writeTag(int i2, int i3) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i3));
        }

        public final void writeUInt32(int i2, int i3) throws IOException {
            writeTag(i2, 0);
            writeUInt32NoTag(i3);
        }

        public final void writeUInt32NoTag(int i2) throws IOException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || Android.isOnAndroidDevice() || spaceLeft() < 5) {
                while ((i2 & a.g) != 0) {
                    byte[] bArr = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr[i3] = (byte) ((i2 & 127) | 128);
                    i2 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr2[i4] = (byte) i2;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else if ((i2 & a.g) == 0) {
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                UnsafeUtil.putByte(bArr3, (long) i5, (byte) i2);
            } else {
                byte[] bArr4 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                UnsafeUtil.putByte(bArr4, (long) i6, (byte) (i2 | 128));
                int i7 = i2 >>> 7;
                if ((i7 & a.g) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i8 = this.position;
                    this.position = i8 + 1;
                    UnsafeUtil.putByte(bArr5, (long) i8, (byte) i7);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                UnsafeUtil.putByte(bArr6, (long) i9, (byte) (i7 | 128));
                int i10 = i7 >>> 7;
                if ((i10 & a.g) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i11 = this.position;
                    this.position = i11 + 1;
                    UnsafeUtil.putByte(bArr7, (long) i11, (byte) i10);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i12 = this.position;
                this.position = i12 + 1;
                UnsafeUtil.putByte(bArr8, (long) i12, (byte) (i10 | 128));
                int i13 = i10 >>> 7;
                if ((i13 & a.g) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i14 = this.position;
                    this.position = i14 + 1;
                    UnsafeUtil.putByte(bArr9, (long) i14, (byte) i13);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                UnsafeUtil.putByte(bArr10, (long) i15, (byte) (i13 | 128));
                byte[] bArr11 = this.buffer;
                int i16 = this.position;
                this.position = i16 + 1;
                UnsafeUtil.putByte(bArr11, (long) i16, (byte) (i13 >>> 7));
            }
        }

        public final void writeUInt64(int i2, long j) throws IOException {
            writeTag(i2, 0);
            writeUInt64NoTag(j);
        }

        public final void writeUInt64NoTag(long j) throws IOException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || spaceLeft() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    UnsafeUtil.putByte(bArr3, (long) i4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                UnsafeUtil.putByte(bArr4, (long) i5, (byte) ((int) j));
            }
        }

        public final void writeByteArray(int i2, byte[] bArr, int i3, int i4) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i3, i4);
        }

        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public final void writeMessage(int i2, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public final void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public final void write(byte[] bArr, int i2, int i3) throws IOException {
            try {
                System.arraycopy(bArr, i2, this.buffer, this.position, i3);
                this.position += i3;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i3)}), e);
            }
        }

        public final void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, remaining);
                this.position += remaining;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(remaining)}), e);
            }
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        public final ByteOutput out;

        public ByteOutputEncoder(ByteOutput byteOutput, int i2) {
            super(i2);
            if (byteOutput != null) {
                this.out = byteOutput;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i2) throws IOException {
            if (this.limit - this.position < i2) {
                doFlush();
            }
        }

        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        public void write(byte b) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b);
        }

        public void writeBool(int i2, boolean z) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i2, 0);
            buffer(z ? (byte) 1 : 0);
        }

        public void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i2, int i3) throws IOException {
            writeUInt32NoTag(i3);
            write(bArr, i2, i3);
        }

        public void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i2, int i3) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i2, 5);
            bufferFixed32NoTag(i3);
        }

        public void writeFixed32NoTag(int i2) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i2);
        }

        public void writeFixed64(int i2, long j) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i2, 1);
            bufferFixed64NoTag(j);
        }

        public void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        public void writeInt32(int i2, int i3) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferInt32NoTag(i3);
        }

        public void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag((long) i2);
            }
        }

        public void writeLazy(byte[] bArr, int i2, int i3) throws IOException {
            flush();
            this.out.writeLazy(bArr, i2, i3);
            this.totalBytesWritten += i3;
        }

        public void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i2 = computeUInt32SizeNoTag + length;
            int i3 = this.limit;
            if (i2 > i3) {
                byte[] bArr = new byte[length];
                int encode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(encode);
                writeLazy(bArr, 0, encode);
                return;
            }
            if (i2 > i3 - this.position) {
                doFlush();
            }
            int i4 = this.position;
            try {
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i5 = i4 + computeUInt32SizeNoTag2;
                    this.position = i5;
                    int encode2 = Utf8.encode(str, this.buffer, i5, this.limit - i5);
                    this.position = i4;
                    int i6 = (encode2 - i4) - computeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i6);
                    this.position = encode2;
                    this.totalBytesWritten += i6;
                    return;
                }
                int encodedLength = Utf8.encodedLength(str);
                bufferUInt32NoTag(encodedLength);
                this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                this.totalBytesWritten += encodedLength;
            } catch (Utf8.UnpairedSurrogateException e) {
                this.totalBytesWritten -= this.position - i4;
                this.position = i4;
                inefficientWriteStringNoTag(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void writeTag(int i2, int i3) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i3));
        }

        public void writeUInt32(int i2, int i3) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferUInt32NoTag(i3);
        }

        public void writeUInt32NoTag(int i2) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i2);
        }

        public void writeUInt64(int i2, long j) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferUInt64NoTag(j);
        }

        public void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        public void writeByteArray(int i2, byte[] bArr, int i3, int i4) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i3, i4);
        }

        public void writeMessage(int i2, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite, schema);
        }

        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            flush();
            this.out.write(bArr, i2, i3);
            this.totalBytesWritten += i3;
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += remaining;
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += remaining;
        }
    }

    public static final class HeapNioEncoder extends ArrayEncoder {
        public final ByteBuffer byteBuffer;
        public int initialPosition;

        public HeapNioEncoder(ByteBuffer byteBuffer2) {
            super(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), byteBuffer2.remaining());
            this.byteBuffer = byteBuffer2;
            this.initialPosition = byteBuffer2.position();
        }

        public void flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        public static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        public static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        public OutOfSpaceException(Throwable th2) {
            super(MESSAGE, th2);
        }

        public OutOfSpaceException(String str, Throwable th2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th2);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        public final OutputStream out;

        public OutputStreamEncoder(OutputStream outputStream, int i2) {
            super(i2);
            if (outputStream != null) {
                this.out = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i2) throws IOException {
            if (this.limit - this.position < i2) {
                doFlush();
            }
        }

        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        public void write(byte b) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b);
        }

        public void writeBool(int i2, boolean z) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i2, 0);
            buffer(z ? (byte) 1 : 0);
        }

        public void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i2, int i3) throws IOException {
            writeUInt32NoTag(i3);
            write(bArr, i2, i3);
        }

        public void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i2, int i3) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i2, 5);
            bufferFixed32NoTag(i3);
        }

        public void writeFixed32NoTag(int i2) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i2);
        }

        public void writeFixed64(int i2, long j) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i2, 1);
            bufferFixed64NoTag(j);
        }

        public void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        public void writeInt32(int i2, int i3) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferInt32NoTag(i3);
        }

        public void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag((long) i2);
            }
        }

        public void writeLazy(byte[] bArr, int i2, int i3) throws IOException {
            write(bArr, i2, i3);
        }

        public void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int i2;
            int i3;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i4 = computeUInt32SizeNoTag + length;
                if (i4 > this.limit) {
                    byte[] bArr = new byte[length];
                    int encode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(encode);
                    writeLazy(bArr, 0, encode);
                    return;
                }
                if (i4 > this.limit - this.position) {
                    doFlush();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                i2 = this.position;
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i5 = i2 + computeUInt32SizeNoTag2;
                    this.position = i5;
                    int encode2 = Utf8.encode(str, this.buffer, i5, this.limit - i5);
                    this.position = i2;
                    i3 = (encode2 - i2) - computeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i3);
                    this.position = encode2;
                } else {
                    i3 = Utf8.encodedLength(str);
                    bufferUInt32NoTag(i3);
                    this.position = Utf8.encode(str, this.buffer, this.position, i3);
                }
                this.totalBytesWritten += i3;
            } catch (Utf8.UnpairedSurrogateException e) {
                this.totalBytesWritten -= this.position - i2;
                this.position = i2;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            } catch (Utf8.UnpairedSurrogateException e3) {
                inefficientWriteStringNoTag(str, e3);
            }
        }

        public void writeTag(int i2, int i3) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i3));
        }

        public void writeUInt32(int i2, int i3) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferUInt32NoTag(i3);
        }

        public void writeUInt32NoTag(int i2) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i2);
        }

        public void writeUInt64(int i2, long j) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i2, 0);
            bufferUInt64NoTag(j);
        }

        public void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        public void writeByteArray(int i2, byte[] bArr, int i3, int i4) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i3, i4);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public void writeMessage(int i2, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite, schema);
        }

        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.limit;
            int i5 = this.position;
            if (i4 - i5 >= i3) {
                System.arraycopy(bArr, i2, this.buffer, i5, i3);
                this.position += i3;
                this.totalBytesWritten += i3;
                return;
            }
            int i6 = i4 - i5;
            System.arraycopy(bArr, i2, this.buffer, i5, i6);
            int i7 = i2 + i6;
            int i8 = i3 - i6;
            this.position = this.limit;
            this.totalBytesWritten += i6;
            doFlush();
            if (i8 <= this.limit) {
                System.arraycopy(bArr, i7, this.buffer, 0, i8);
                this.position = i8;
            } else {
                this.out.write(bArr, i7, i8);
            }
            this.totalBytesWritten += i8;
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i2 = this.limit;
            int i3 = this.position;
            if (i2 - i3 >= remaining) {
                byteBuffer.get(this.buffer, i3, remaining);
                this.position += remaining;
                this.totalBytesWritten += remaining;
                return;
            }
            int i4 = i2 - i3;
            byteBuffer.get(this.buffer, i3, i4);
            int i5 = remaining - i4;
            this.position = this.limit;
            this.totalBytesWritten += i4;
            doFlush();
            while (true) {
                int i6 = this.limit;
                if (i5 > i6) {
                    byteBuffer.get(this.buffer, 0, i6);
                    this.out.write(this.buffer, 0, this.limit);
                    int i7 = this.limit;
                    i5 -= i7;
                    this.totalBytesWritten += i7;
                } else {
                    byteBuffer.get(this.buffer, 0, i5);
                    this.position = i5;
                    this.totalBytesWritten += i5;
                    return;
                }
            }
        }
    }

    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        public final ByteBuffer buffer;
        public final int initialPosition;
        public final ByteBuffer originalBuffer;

        public SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) throws IOException {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void flush() {
            this.originalBuffer.position(this.buffer.position());
        }

        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        public int spaceLeft() {
            return this.buffer.remaining();
        }

        public void write(byte b) throws IOException {
            try {
                this.buffer.put(b);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeBool(int i2, boolean z) throws IOException {
            writeTag(i2, 0);
            write(z ? (byte) 1 : 0);
        }

        public void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i2, int i3) throws IOException {
            writeUInt32NoTag(i3);
            write(bArr, i2, i3);
        }

        public void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i2, int i3) throws IOException {
            writeTag(i2, 5);
            writeFixed32NoTag(i3);
        }

        public void writeFixed32NoTag(int i2) throws IOException {
            try {
                this.buffer.putInt(i2);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeFixed64(int i2, long j) throws IOException {
            writeTag(i2, 1);
            writeFixed64NoTag(j);
        }

        public void writeFixed64NoTag(long j) throws IOException {
            try {
                this.buffer.putLong(j);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeInt32(int i2, int i3) throws IOException {
            writeTag(i2, 0);
            writeInt32NoTag(i3);
        }

        public void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag((long) i2);
            }
        }

        public void writeLazy(byte[] bArr, int i2, int i3) throws IOException {
            write(bArr, i2, i3);
        }

        public void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int position = this.buffer.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.buffer.position() + computeUInt32SizeNoTag2;
                    this.buffer.position(position2);
                    encode(str);
                    int position3 = this.buffer.position();
                    this.buffer.position(position);
                    writeUInt32NoTag(position3 - position2);
                    this.buffer.position(position3);
                    return;
                }
                writeUInt32NoTag(Utf8.encodedLength(str));
                encode(str);
            } catch (Utf8.UnpairedSurrogateException e) {
                this.buffer.position(position);
                inefficientWriteStringNoTag(str, e);
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void writeTag(int i2, int i3) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i3));
        }

        public void writeUInt32(int i2, int i3) throws IOException {
            writeTag(i2, 0);
            writeUInt32NoTag(i3);
        }

        public void writeUInt32NoTag(int i2) throws IOException {
            while ((i2 & a.g) != 0) {
                this.buffer.put((byte) ((i2 & 127) | 128));
                i2 >>>= 7;
            }
            try {
                this.buffer.put((byte) i2);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeUInt64(int i2, long j) throws IOException {
            writeTag(i2, 0);
            writeUInt64NoTag(j);
        }

        public void writeUInt64NoTag(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.buffer.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.buffer.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }

        public void writeByteArray(int i2, byte[] bArr, int i3, int i4) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i3, i4);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            try {
                this.buffer.put(bArr, i2, i3);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            }
        }

        public void writeMessage(int i2, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite, schema);
        }

        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }
    }

    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        public final long address;
        public final ByteBuffer buffer;
        public final long initialPosition;
        public final long limit;
        public final long oneVarintLimit;
        public final ByteBuffer originalBuffer;
        public long position = this.initialPosition;

        public UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            this.initialPosition = addressOffset + ((long) byteBuffer.position());
            long limit2 = this.address + ((long) byteBuffer.limit());
            this.limit = limit2;
            this.oneVarintLimit = limit2 - 10;
        }

        private int bufferPos(long j) {
            return (int) (j - this.address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j) {
            this.buffer.position(bufferPos(j));
        }

        public void flush() {
            this.originalBuffer.position(bufferPos(this.position));
        }

        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        public void write(byte b) throws IOException {
            long j = this.position;
            if (j < this.limit) {
                this.position = 1 + j;
                UnsafeUtil.putByte(j, b);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        public void writeBool(int i2, boolean z) throws IOException {
            writeTag(i2, 0);
            write(z ? (byte) 1 : 0);
        }

        public void writeByteArray(int i2, byte[] bArr) throws IOException {
            writeByteArray(i2, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i2, int i3) throws IOException {
            writeUInt32NoTag(i3);
            write(bArr, i2, i3);
        }

        public void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException {
            writeTag(i2, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i2, ByteString byteString) throws IOException {
            writeTag(i2, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i2, int i3) throws IOException {
            writeTag(i2, 5);
            writeFixed32NoTag(i3);
        }

        public void writeFixed32NoTag(int i2) throws IOException {
            this.buffer.putInt(bufferPos(this.position), i2);
            this.position += 4;
        }

        public void writeFixed64(int i2, long j) throws IOException {
            writeTag(i2, 1);
            writeFixed64NoTag(j);
        }

        public void writeFixed64NoTag(long j) throws IOException {
            this.buffer.putLong(bufferPos(this.position), j);
            this.position += 8;
        }

        public void writeInt32(int i2, int i3) throws IOException {
            writeTag(i2, 0);
            writeInt32NoTag(i3);
        }

        public void writeInt32NoTag(int i2) throws IOException {
            if (i2 >= 0) {
                writeUInt32NoTag(i2);
            } else {
                writeUInt64NoTag((long) i2);
            }
        }

        public void writeLazy(byte[] bArr, int i2, int i3) throws IOException {
            write(bArr, i2, i3);
        }

        public void writeMessage(int i2, MessageLite messageLite) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.clear();
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i2);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i2, String str) throws IOException {
            writeTag(i2, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            long j = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int bufferPos = bufferPos(this.position) + computeUInt32SizeNoTag2;
                    this.buffer.position(bufferPos);
                    Utf8.encodeUtf8(str, this.buffer);
                    int position2 = this.buffer.position() - bufferPos;
                    writeUInt32NoTag(position2);
                    this.position += (long) position2;
                    return;
                }
                int encodedLength = Utf8.encodedLength(str);
                writeUInt32NoTag(encodedLength);
                repositionBuffer(this.position);
                Utf8.encodeUtf8(str, this.buffer);
                this.position += (long) encodedLength;
            } catch (Utf8.UnpairedSurrogateException e) {
                this.position = j;
                repositionBuffer(j);
                inefficientWriteStringNoTag(str, e);
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException((Throwable) e3);
            }
        }

        public void writeTag(int i2, int i3) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i2, i3));
        }

        public void writeUInt32(int i2, int i3) throws IOException {
            writeTag(i2, 0);
            writeUInt32NoTag(i3);
        }

        public void writeUInt32NoTag(int i2) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((i2 & a.g) != 0) {
                    long j = this.position;
                    this.position = j + 1;
                    UnsafeUtil.putByte(j, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
                long j2 = this.position;
                this.position = 1 + j2;
                UnsafeUtil.putByte(j2, (byte) i2);
                return;
            }
            while (true) {
                long j3 = this.position;
                if (j3 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
                } else if ((i2 & a.g) == 0) {
                    this.position = 1 + j3;
                    UnsafeUtil.putByte(j3, (byte) i2);
                    return;
                } else {
                    this.position = j3 + 1;
                    UnsafeUtil.putByte(j3, (byte) ((i2 & 127) | 128));
                    i2 >>>= 7;
                }
            }
        }

        public void writeUInt64(int i2, long j) throws IOException {
            writeTag(i2, 0);
            writeUInt64NoTag(j);
        }

        public void writeUInt64NoTag(long j) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((j & -128) != 0) {
                    long j2 = this.position;
                    this.position = j2 + 1;
                    UnsafeUtil.putByte(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.position;
                this.position = 1 + j3;
                UnsafeUtil.putByte(j3, (byte) ((int) j));
                return;
            }
            while (true) {
                long j4 = this.position;
                if (j4 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
                } else if ((j & -128) == 0) {
                    this.position = 1 + j4;
                    UnsafeUtil.putByte(j4, (byte) ((int) j));
                    return;
                } else {
                    this.position = j4 + 1;
                    UnsafeUtil.putByte(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        public void writeByteArray(int i2, byte[] bArr, int i3, int i4) throws IOException {
            writeTag(i2, 2);
            writeByteArrayNoTag(bArr, i3, i4);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public void writeMessage(int i2, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i2, 2);
            writeMessageNoTag(messageLite, schema);
        }

        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j = (long) i3;
                long j2 = this.position;
                if (this.limit - j >= j2) {
                    UnsafeUtil.copyMemory(bArr, (long) i2, j2, j);
                    this.position += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i3)}));
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int remaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += (long) remaining;
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException((Throwable) e);
            }
        }
    }

    public static int computeBoolSize(int i2, boolean z) {
        return computeTagSize(i2) + computeBoolSizeNoTag(z);
    }

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeByteArraySize(int i2, byte[] bArr) {
        return computeTagSize(i2) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i2, ByteBuffer byteBuffer) {
        return computeTagSize(i2) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i2, ByteString byteString) {
        return computeTagSize(i2) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i2, double d) {
        return computeTagSize(i2) + computeDoubleSizeNoTag(d);
    }

    public static int computeDoubleSizeNoTag(double d) {
        return 8;
    }

    public static int computeEnumSize(int i2, int i3) {
        return computeTagSize(i2) + computeEnumSizeNoTag(i3);
    }

    public static int computeEnumSizeNoTag(int i2) {
        return computeInt32SizeNoTag(i2);
    }

    public static int computeFixed32Size(int i2, int i3) {
        return computeTagSize(i2) + computeFixed32SizeNoTag(i3);
    }

    public static int computeFixed32SizeNoTag(int i2) {
        return 4;
    }

    public static int computeFixed64Size(int i2, long j) {
        return computeTagSize(i2) + computeFixed64SizeNoTag(j);
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i2, float f) {
        return computeTagSize(i2) + computeFloatSizeNoTag(f);
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i2, MessageLite messageLite) {
        return (computeTagSize(i2) * 2) + computeGroupSizeNoTag(messageLite);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i2, int i3) {
        return computeTagSize(i2) + computeInt32SizeNoTag(i3);
    }

    public static int computeInt32SizeNoTag(int i2) {
        if (i2 >= 0) {
            return computeUInt32SizeNoTag(i2);
        }
        return 10;
    }

    public static int computeInt64Size(int i2, long j) {
        return computeTagSize(i2) + computeInt64SizeNoTag(j);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i2, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i2, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i2) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int i2) {
        return computeUInt32SizeNoTag(i2) + i2;
    }

    public static int computeMessageSetExtensionSize(int i2, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i2, MessageLite messageLite) {
        return computeTagSize(i2) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    public static int computePreferredBufferSize(int i2) {
        if (i2 > 4096) {
            return 4096;
        }
        return i2;
    }

    public static int computeRawMessageSetExtensionSize(int i2, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i2) + computeBytesSize(3, byteString);
    }

    @Deprecated
    public static int computeRawVarint32Size(int i2) {
        return computeUInt32SizeNoTag(i2);
    }

    @Deprecated
    public static int computeRawVarint64Size(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeSFixed32Size(int i2, int i3) {
        return computeTagSize(i2) + computeSFixed32SizeNoTag(i3);
    }

    public static int computeSFixed32SizeNoTag(int i2) {
        return 4;
    }

    public static int computeSFixed64Size(int i2, long j) {
        return computeTagSize(i2) + computeSFixed64SizeNoTag(j);
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32Size(int i2, int i3) {
        return computeTagSize(i2) + computeSInt32SizeNoTag(i3);
    }

    public static int computeSInt32SizeNoTag(int i2) {
        return computeUInt32SizeNoTag(encodeZigZag32(i2));
    }

    public static int computeSInt64Size(int i2, long j) {
        return computeTagSize(i2) + computeSInt64SizeNoTag(j);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(encodeZigZag64(j));
    }

    public static int computeStringSize(int i2, String str) {
        return computeTagSize(i2) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int i2;
        try {
            i2 = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i2 = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(i2);
    }

    public static int computeTagSize(int i2) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i2, 0));
    }

    public static int computeUInt32Size(int i2, int i3) {
        return computeTagSize(i2) + computeUInt32SizeNoTag(i3);
    }

    public static int computeUInt32SizeNoTag(int i2) {
        if ((i2 & a.g) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i2, long j) {
        return computeTagSize(i2) + computeUInt64SizeNoTag(j);
    }

    public static int computeUInt64SizeNoTag(long j) {
        int i2;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i2 = 6;
            j >>>= 28;
        } else {
            i2 = 2;
        }
        if ((-2097152 & j) != 0) {
            i2 += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i2 + 1 : i2;
    }

    public static int encodeZigZag32(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException((Throwable) e);
        } catch (OutOfSpaceException e2) {
            throw e2;
        }
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    public abstract void write(byte b) throws IOException;

    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    public abstract void write(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void writeBool(int i2, boolean z) throws IOException;

    public final void writeBoolNoTag(boolean z) throws IOException {
        write(z ? (byte) 1 : 0);
    }

    public abstract void writeByteArray(int i2, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i2, byte[] bArr, int i3, int i4) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void writeByteBuffer(int i2, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i2, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i2, double d) throws IOException {
        writeFixed64(i2, Double.doubleToRawLongBits(d));
    }

    public final void writeDoubleNoTag(double d) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d));
    }

    public final void writeEnum(int i2, int i3) throws IOException {
        writeInt32(i2, i3);
    }

    public final void writeEnumNoTag(int i2) throws IOException {
        writeInt32NoTag(i2);
    }

    public abstract void writeFixed32(int i2, int i3) throws IOException;

    public abstract void writeFixed32NoTag(int i2) throws IOException;

    public abstract void writeFixed64(int i2, long j) throws IOException;

    public abstract void writeFixed64NoTag(long j) throws IOException;

    public final void writeFloat(int i2, float f) throws IOException {
        writeFixed32(i2, Float.floatToRawIntBits(f));
    }

    public final void writeFloatNoTag(float f) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f));
    }

    @Deprecated
    public final void writeGroup(int i2, MessageLite messageLite) throws IOException {
        writeTag(i2, 3);
        writeGroupNoTag(messageLite);
        writeTag(i2, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i2, int i3) throws IOException;

    public abstract void writeInt32NoTag(int i2) throws IOException;

    public final void writeInt64(int i2, long j) throws IOException {
        writeUInt64(i2, j);
    }

    public final void writeInt64NoTag(long j) throws IOException {
        writeUInt64NoTag(j);
    }

    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    public abstract void writeLazy(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void writeMessage(int i2, MessageLite messageLite) throws IOException;

    public abstract void writeMessage(int i2, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageSetExtension(int i2, MessageLite messageLite) throws IOException;

    public final void writeRawByte(byte b) throws IOException {
        write(b);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Deprecated
    public final void writeRawLittleEndian32(int i2) throws IOException {
        writeFixed32NoTag(i2);
    }

    @Deprecated
    public final void writeRawLittleEndian64(long j) throws IOException {
        writeFixed64NoTag(j);
    }

    public abstract void writeRawMessageSetExtension(int i2, ByteString byteString) throws IOException;

    @Deprecated
    public final void writeRawVarint32(int i2) throws IOException {
        writeUInt32NoTag(i2);
    }

    @Deprecated
    public final void writeRawVarint64(long j) throws IOException {
        writeUInt64NoTag(j);
    }

    public final void writeSFixed32(int i2, int i3) throws IOException {
        writeFixed32(i2, i3);
    }

    public final void writeSFixed32NoTag(int i2) throws IOException {
        writeFixed32NoTag(i2);
    }

    public final void writeSFixed64(int i2, long j) throws IOException {
        writeFixed64(i2, j);
    }

    public final void writeSFixed64NoTag(long j) throws IOException {
        writeFixed64NoTag(j);
    }

    public final void writeSInt32(int i2, int i3) throws IOException {
        writeUInt32(i2, encodeZigZag32(i3));
    }

    public final void writeSInt32NoTag(int i2) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i2));
    }

    public final void writeSInt64(int i2, long j) throws IOException {
        writeUInt64(i2, encodeZigZag64(j));
    }

    public final void writeSInt64NoTag(long j) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j));
    }

    public abstract void writeString(int i2, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i2, int i3) throws IOException;

    public abstract void writeUInt32(int i2, int i3) throws IOException;

    public abstract void writeUInt32NoTag(int i2) throws IOException;

    public abstract void writeUInt64(int i2, long j) throws IOException;

    public abstract void writeUInt64NoTag(long j) throws IOException;

    public CodedOutputStream() {
    }

    @Deprecated
    public static int computeGroupSize(int i2, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i2) * 2) + computeGroupSizeNoTag(messageLite, schema);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    public static int computeMessageSize(int i2, MessageLite messageLite, Schema schema) {
        return computeTagSize(i2) + computeMessageSizeNoTag(messageLite, schema);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i2) {
        return new OutputStreamEncoder(outputStream, i2);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, Schema schema) throws IOException {
        schema.writeTo(messageLite, this.wrapper);
    }

    public final void writeRawByte(int i2) throws IOException {
        write((byte) i2);
    }

    public final void writeRawBytes(byte[] bArr, int i2, int i3) throws IOException {
        write(bArr, i2, i3);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.writeTo((ByteOutput) this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i2, int i3) {
        return new ArrayEncoder(bArr, i2, i3);
    }

    @Deprecated
    public final void writeGroup(int i2, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(i2, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i2, 4);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (UnsafeDirectNioEncoder.isSupported()) {
            return newUnsafeInstance(byteBuffer);
        } else {
            return newSafeInstance(byteBuffer);
        }
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i2) {
        return newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(ByteOutput byteOutput, int i2) {
        if (i2 >= 0) {
            return new ByteOutputEncoder(byteOutput, i2);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }
}
