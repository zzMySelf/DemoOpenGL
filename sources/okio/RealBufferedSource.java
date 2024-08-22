package okio;

import com.baidu.searchbox.video.feedflow.FlowComponentConstantManifestKt;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "jvm"}, k = 1, mv = {1, 1, 11})
/* compiled from: RealBufferedSource.kt */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField = new Buffer();
    public boolean closed;
    public final Source source;

    public static /* synthetic */ void buffer$annotations() {
    }

    public RealBufferedSource(Source source2) {
        Intrinsics.checkParameterIsNotNull(source2, "source");
        this.source = source2;
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, FlowComponentConstantManifestKt.SEARCH_MARK_VIEW_STYLE_SINK);
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        } else if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        } else {
            return this.bufferField.read(sink, Math.min(byteCount, this.bufferField.size()));
        }
    }

    public boolean exhausted() {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (!this.bufferField.exhausted() || this.source.read(this.bufferField, (long) 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public void require(long byteCount) {
        if (!request(byteCount)) {
            throw new EOFException();
        }
    }

    public boolean request(long byteCount) {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        } else if (!this.closed) {
            while (this.bufferField.size() < byteCount) {
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public byte readByte() {
        require(1);
        return this.bufferField.readByte();
    }

    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    public ByteString readByteString(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteString(byteCount);
    }

    public int select(Options options) {
        Intrinsics.checkParameterIsNotNull(options, "options");
        if (!this.closed) {
            do {
                int index = this.bufferField.selectPrefix$jvm(options, true);
                switch (index) {
                    case -2:
                        break;
                    case -1:
                        return -1;
                    default:
                        this.bufferField.skip((long) options.getByteStrings$jvm()[index].size());
                        return index;
                }
            } while (this.source.read(this.bufferField, (long) 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    public byte[] readByteArray(long byteCount) {
        require(byteCount);
        return this.bufferField.readByteArray(byteCount);
    }

    public int read(byte[] sink) {
        Intrinsics.checkParameterIsNotNull(sink, FlowComponentConstantManifestKt.SEARCH_MARK_VIEW_STYLE_SINK);
        return read(sink, 0, sink.length);
    }

    public void readFully(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, FlowComponentConstantManifestKt.SEARCH_MARK_VIEW_STYLE_SINK);
        try {
            require((long) bArr.length);
            this.bufferField.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int read = buffer.read(bArr, i2, (int) buffer.size());
                if (read != -1) {
                    i2 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e2;
        }
    }

    public int read(byte[] bArr, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(bArr, FlowComponentConstantManifestKt.SEARCH_MARK_VIEW_STYLE_SINK);
        long j2 = (long) i3;
        Util.checkOffsetAndCount((long) bArr.length, (long) i2, j2);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(bArr, i2, (int) Math.min(j2, this.bufferField.size()));
    }

    public int read(ByteBuffer sink) {
        Intrinsics.checkParameterIsNotNull(sink, FlowComponentConstantManifestKt.SEARCH_MARK_VIEW_STYLE_SINK);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    public void readFully(Buffer sink, long byteCount) {
        Intrinsics.checkParameterIsNotNull(sink, FlowComponentConstantManifestKt.SEARCH_MARK_VIEW_STYLE_SINK);
        try {
            require(byteCount);
            this.bufferField.readFully(sink, byteCount);
        } catch (EOFException e2) {
            sink.writeAll(this.bufferField);
            throw e2;
        }
    }

    public long readAll(Sink sink) {
        Intrinsics.checkParameterIsNotNull(sink, FlowComponentConstantManifestKt.SEARCH_MARK_VIEW_STYLE_SINK);
        long totalBytesWritten = 0;
        while (this.source.read(this.bufferField, (long) 8192) != -1) {
            long emitByteCount = this.bufferField.completeSegmentByteCount();
            if (emitByteCount > 0) {
                totalBytesWritten += emitByteCount;
                sink.write(this.bufferField, emitByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return totalBytesWritten;
        }
        long totalBytesWritten2 = totalBytesWritten + this.bufferField.size();
        sink.write(this.bufferField, this.bufferField.size());
        return totalBytesWritten2;
    }

    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    public String readUtf8(long byteCount) {
        require(byteCount);
        return this.bufferField.readUtf8(byteCount);
    }

    public String readString(Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    public String readString(long byteCount, Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        require(byteCount);
        return this.bufferField.readString(byteCount, charset);
    }

    public String readUtf8Line() {
        long newline = indexOf((byte) 10);
        if (newline != -1) {
            return this.bufferField.readUtf8Line$jvm(newline);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    public String readUtf8LineStrict() {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public String readUtf8LineStrict(long j2) {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            byte b2 = (byte) 10;
            long indexOf = indexOf(b2, 0, j3);
            if (indexOf != -1) {
                return this.bufferField.readUtf8Line$jvm(indexOf);
            }
            if (j3 < Long.MAX_VALUE && request(j3) && this.bufferField.getByte(j3 - 1) == ((byte) 13) && request(1 + j3) && this.bufferField.getByte(j3) == b2) {
                return this.bufferField.readUtf8Line$jvm(j3);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.bufferField;
            buffer2.copyTo(buffer, 0, Math.min((long) 32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j2) + " content=" + buffer.readByteString().hex() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    public int readUtf8CodePoint() {
        require(1);
        int b0 = this.bufferField.getByte(0);
        if ((b0 & 224) == 192) {
            require(2);
        } else if ((b0 & 240) == 224) {
            require(3);
        } else if ((b0 & 248) == 240) {
            require(4);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    public short readShort() {
        require(2);
        return this.bufferField.readShort();
    }

    public short readShortLe() {
        require(2);
        return this.bufferField.readShortLe();
    }

    public int readInt() {
        require(4);
        return this.bufferField.readInt();
    }

    public int readIntLe() {
        require(4);
        return this.bufferField.readIntLe();
    }

    public long readLong() {
        require(8);
        return this.bufferField.readLong();
    }

    public long readLongLe() {
        require(8);
        return this.bufferField.readLongLe();
    }

    public long readDecimalLong() {
        int i2;
        require(1);
        long j2 = 0;
        while (true) {
            long j3 = j2 + 1;
            if (!request(j3)) {
                break;
            }
            byte b2 = this.bufferField.getByte(j2);
            if ((b2 >= ((byte) 48) && b2 <= ((byte) 57)) || (j2 == 0 && b2 == ((byte) 45))) {
                j2 = j3;
            } else if (i2 == 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Expected leading [0-9] or '-' character but was %#x", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                throw new NumberFormatException(format);
            }
        }
        return this.bufferField.readDecimalLong();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long readHexadecimalUnsignedLong() {
        /*
            r6 = this;
            r0 = 1
            r6.require(r0)
            r0 = 0
            r1 = r0
        L_0x0007:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.request(r3)
            if (r3 == 0) goto L_0x0063
            okio.Buffer r3 = r6.bufferField
            long r4 = (long) r1
            byte r3 = r3.getByte(r4)
            r4 = 48
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x0025
            r4 = 57
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x003a
        L_0x0025:
            r4 = 97
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x002f
            r4 = 102(0x66, float:1.43E-43)
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x003a
        L_0x002f:
            r4 = 65
            byte r4 = (byte) r4
            if (r3 < r4) goto L_0x003d
            r4 = 70
            byte r4 = (byte) r4
            if (r3 <= r4) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            r1 = r2
            goto L_0x0007
        L_0x003d:
            if (r1 == 0) goto L_0x0040
            goto L_0x0063
        L_0x0040:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r4[r0] = r3
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r4, r2)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r2, r0)
            java.lang.String r2 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0063:
            okio.Buffer r0 = r6.bufferField
            long r0 = r0.readHexadecimalUnsignedLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readHexadecimalUnsignedLong():long");
    }

    public void skip(long byteCount) {
        long byteCount2 = byteCount;
        if (!this.closed) {
            while (byteCount2 > 0) {
                if (this.bufferField.size() == 0 && this.source.read(this.bufferField, (long) 8192) == -1) {
                    throw new EOFException();
                }
                long toSkip = Math.min(byteCount2, this.bufferField.size());
                this.bufferField.skip(toSkip);
                byteCount2 -= toSkip;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public long indexOf(byte b2) {
        return indexOf(b2, 0, Long.MAX_VALUE);
    }

    public long indexOf(byte b2, long fromIndex) {
        return indexOf(b2, fromIndex, Long.MAX_VALUE);
    }

    public long indexOf(byte b2, long fromIndex, long toIndex) {
        RealBufferedSource realBufferedSource = this;
        long j2 = toIndex;
        long fromIndex2 = fromIndex;
        boolean z = true;
        boolean z2 = false;
        if (!realBufferedSource.closed) {
            if (0 > fromIndex2 || j2 < fromIndex2) {
                z = false;
            }
            if (z) {
                long fromIndex3 = fromIndex2;
                boolean z3 = false;
                while (fromIndex3 < j2) {
                    boolean z4 = z2;
                    long result = this.bufferField.indexOf(b2, fromIndex3, toIndex);
                    if (result != -1) {
                        return result;
                    }
                    boolean z5 = z3;
                    long lastBufferSize = this.bufferField.size();
                    if (lastBufferSize < j2) {
                        z3 = z5;
                        long j3 = result;
                        if (realBufferedSource.source.read(this.bufferField, (long) 8192) != -1) {
                            fromIndex3 = Math.max(fromIndex3, lastBufferSize);
                            realBufferedSource = this;
                            z2 = z4;
                        }
                    } else {
                        long j4 = result;
                    }
                    return -1;
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + fromIndex2 + " toIndex=" + j2).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public long indexOf(ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return indexOf(bytes, 0);
    }

    public long indexOf(ByteString bytes, long fromIndex) {
        ByteString byteString = bytes;
        Intrinsics.checkParameterIsNotNull(byteString, "bytes");
        long fromIndex2 = fromIndex;
        if (!this.closed) {
            while (true) {
                long result = this.bufferField.indexOf(byteString, fromIndex2);
                if (result != -1) {
                    return result;
                }
                long lastBufferSize = this.bufferField.size();
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                fromIndex2 = Math.max(fromIndex2, (lastBufferSize - ((long) bytes.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public long indexOfElement(ByteString targetBytes) {
        Intrinsics.checkParameterIsNotNull(targetBytes, "targetBytes");
        return indexOfElement(targetBytes, 0);
    }

    public long indexOfElement(ByteString targetBytes, long fromIndex) {
        ByteString byteString = targetBytes;
        Intrinsics.checkParameterIsNotNull(byteString, "targetBytes");
        long fromIndex2 = fromIndex;
        if (!this.closed) {
            while (true) {
                long result = this.bufferField.indexOfElement(byteString, fromIndex2);
                if (result != -1) {
                    return result;
                }
                long lastBufferSize = this.bufferField.size();
                if (this.source.read(this.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                fromIndex2 = Math.max(fromIndex2, lastBufferSize);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public boolean rangeEquals(long offset, ByteString bytes) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        return rangeEquals(offset, bytes, 0, bytes.size());
    }

    public boolean rangeEquals(long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkParameterIsNotNull(bytes, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (offset < 0 || bytesOffset < 0 || byteCount < 0 || bytes.size() - bytesOffset < byteCount) {
            return false;
        } else {
            for (int i2 = 0; i2 < byteCount; i2++) {
                long bufferOffset = ((long) i2) + offset;
                if (!request(1 + bufferOffset) || this.bufferField.getByte(bufferOffset) != bytes.getByte(bytesOffset + i2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public BufferedSource peek() {
        return Okio.buffer((Source) new PeekSource(this));
    }

    public InputStream inputStream() {
        return new RealBufferedSource$inputStream$1(this);
    }

    public boolean isOpen() {
        return !this.closed;
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.bufferField.clear();
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }
}
