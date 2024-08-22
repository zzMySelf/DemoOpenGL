package com.google.protobuf;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alipay.sdk.m.n.a;
import com.baidu.idl.authority.AuthorityState;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.Utf8;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public abstract class BinaryWriter extends ByteOutput implements Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    public static final int MAP_KEY_NUMBER = 1;
    public static final int MAP_VALUE_NUMBER = 2;
    public final BufferAllocator alloc;
    public final ArrayDeque<AllocatedBuffer> buffers;
    public final int chunkSize;
    public int totalDoneBytes;

    /* renamed from: com.google.protobuf.BinaryWriter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.WireFormat$FieldType[] r0 = com.google.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.google.protobuf.WireFormat$FieldType r1 = com.google.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.BinaryWriter.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class SafeDirectWriter extends BinaryWriter {
        public ByteBuffer buffer;
        public int limitMinusOne;
        public int pos;

        public SafeDirectWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, (AnonymousClass1) null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return this.pos + 1;
        }

        private void writeVarint32FiveBytes(int i2) {
            ByteBuffer byteBuffer = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            byteBuffer.put(i3, (byte) (i2 >>> 28));
            int i4 = this.pos - 4;
            this.pos = i4;
            this.buffer.putInt(i4 + 1, (i2 & 127) | 128 | ((((i2 >>> 21) & 127) | 128) << 24) | ((((i2 >>> 14) & 127) | 128) << 16) | ((((i2 >>> 7) & 127) | 128) << 8));
        }

        private void writeVarint32FourBytes(int i2) {
            int i3 = this.pos - 4;
            this.pos = i3;
            this.buffer.putInt(i3 + 1, (i2 & 127) | 128 | ((266338304 & i2) << 3) | (((2080768 & i2) | 2097152) << 2) | (((i2 & 16256) | 16384) << 1));
        }

        private void writeVarint32OneByte(int i2) {
            ByteBuffer byteBuffer = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            byteBuffer.put(i3, (byte) i2);
        }

        private void writeVarint32ThreeBytes(int i2) {
            int i3 = this.pos - 3;
            this.pos = i3;
            this.buffer.putInt(i3, (((i2 & 127) | 128) << 8) | ((2080768 & i2) << 10) | (((i2 & 16256) | 16384) << 9));
        }

        private void writeVarint32TwoBytes(int i2) {
            int i3 = this.pos - 2;
            this.pos = i3;
            this.buffer.putShort(i3 + 1, (short) ((i2 & 127) | 128 | ((i2 & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long j) {
            int i2 = this.pos - 8;
            this.pos = i2;
            this.buffer.putLong(i2 + 1, (j & 127) | 128 | ((71494644084506624L & j) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j) | 16384) << 1));
        }

        private void writeVarint64EightBytesWithSign(long j) {
            int i2 = this.pos - 8;
            this.pos = i2;
            this.buffer.putLong(i2 + 1, (j & 127) | 128 | (((71494644084506624L & j) | 72057594037927936L) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 2) | (((16256 & j) | 16384) << 1));
        }

        private void writeVarint64FiveBytes(long j) {
            int i2 = this.pos - 5;
            this.pos = i2;
            this.buffer.putLong(i2 - 2, (((j & 127) | 128) << 24) | ((34091302912L & j) << 28) | (((266338304 & j) | 268435456) << 27) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 26) | (((16256 & j) | 16384) << 25));
        }

        private void writeVarint64FourBytes(long j) {
            writeVarint32FourBytes((int) j);
        }

        private void writeVarint64NineBytes(long j) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, (byte) ((int) (j >>> 56)));
            writeVarint64EightBytesWithSign(j & 72057594037927935L);
        }

        private void writeVarint64OneByte(long j) {
            writeVarint32OneByte((int) j);
        }

        private void writeVarint64SevenBytes(long j) {
            int i2 = this.pos - 7;
            this.pos = i2;
            this.buffer.putLong(i2, (((j & 127) | 128) << 8) | ((558551906910208L & j) << 14) | (((4363686772736L & j) | 4398046511104L) << 13) | (((34091302912L & j) | 34359738368L) << 12) | (((266338304 & j) | 268435456) << 11) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 10) | (((16256 & j) | 16384) << 9));
        }

        private void writeVarint64SixBytes(long j) {
            int i2 = this.pos - 6;
            this.pos = i2;
            this.buffer.putLong(i2 - 1, (((j & 127) | 128) << 16) | ((4363686772736L & j) << 21) | (((34091302912L & j) | 34359738368L) << 20) | (((266338304 & j) | 268435456) << 19) | (((2080768 & j) | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) << 18) | (((16256 & j) | 16384) << 17));
        }

        private void writeVarint64TenBytes(long j) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, (byte) ((int) (j >>> 63)));
            ByteBuffer byteBuffer2 = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            byteBuffer2.put(i3, (byte) ((int) (((j >>> 56) & 127) | 128)));
            writeVarint64EightBytesWithSign(j & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long j) {
            writeVarint32ThreeBytes((int) j);
        }

        private void writeVarint64TwoBytes(long j) {
            writeVarint32TwoBytes((int) j);
        }

        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(this.pos + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        public void requireSpace(int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
        }

        public void write(byte b) {
            ByteBuffer byteBuffer = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            byteBuffer.put(i2, b);
        }

        public void writeBool(int i2, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : 0);
            writeTag(i2, 0);
        }

        public void writeBytes(int i2, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i2, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeEndGroup(int i2) {
            writeTag(i2, 4);
        }

        public void writeFixed32(int i2, int i3) {
            requireSpace(9);
            writeFixed32(i3);
            writeTag(i2, 5);
        }

        public void writeFixed64(int i2, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i2, 1);
        }

        public void writeGroup(int i2, Object obj) throws IOException {
            writeTag(i2, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i2, 3);
        }

        public void writeInt32(int i2, int i3) {
            requireSpace(15);
            writeInt32(i3);
            writeTag(i2, 0);
        }

        public void writeLazy(byte[] bArr, int i2, int i3) {
            if (spaceLeft() < i3) {
                this.totalDoneBytes += i3;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i2, i3));
                nextBuffer();
                return;
            }
            int i4 = this.pos - i3;
            this.pos = i4;
            this.buffer.position(i4 + 1);
            this.buffer.put(bArr, i2, i3);
        }

        public void writeMessage(int i2, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeSInt32(int i2, int i3) {
            requireSpace(10);
            writeSInt32(i3);
            writeTag(i2, 0);
        }

        public void writeSInt64(int i2, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i2, 0);
        }

        public void writeStartGroup(int i2) {
            writeTag(i2, 3);
        }

        public void writeString(int i2, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeTag(int i2, int i3) {
            writeVarint32(WireFormat.makeTag(i2, i3));
        }

        public void writeUInt32(int i2, int i3) {
            requireSpace(10);
            writeVarint32(i3);
            writeTag(i2, 0);
        }

        public void writeUInt64(int i2, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i2, 0);
        }

        public void writeVarint32(int i2) {
            if ((i2 & a.g) == 0) {
                writeVarint32OneByte(i2);
            } else if ((i2 & -16384) == 0) {
                writeVarint32TwoBytes(i2);
            } else if ((-2097152 & i2) == 0) {
                writeVarint32ThreeBytes(i2);
            } else if ((-268435456 & i2) == 0) {
                writeVarint32FourBytes(i2);
            } else {
                writeVarint32FiveBytes(i2);
            }
        }

        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    return;
                case 2:
                    writeVarint64TwoBytes(j);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j);
                    return;
                case 4:
                    writeVarint64FourBytes(j);
                    return;
                case 5:
                    writeVarint64FiveBytes(j);
                    return;
                case 6:
                    writeVarint64SixBytes(j);
                    return;
                case 7:
                    writeVarint64SevenBytes(j);
                    return;
                case 8:
                    writeVarint64EightBytes(j);
                    return;
                case 9:
                    writeVarint64NineBytes(j);
                    return;
                case 10:
                    writeVarint64TenBytes(j);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i2) {
            nextBuffer(newDirectBuffer(i2));
        }

        public void write(byte[] bArr, int i2, int i3) {
            if (spaceLeft() < i3) {
                nextBuffer(i3);
            }
            int i4 = this.pos - i3;
            this.pos = i4;
            this.buffer.position(i4 + 1);
            this.buffer.put(bArr, i2, i3);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    nioBuffer.limit(nioBuffer.capacity());
                    this.buffer.position(0);
                    this.buffer.order(ByteOrder.LITTLE_ENDIAN);
                    int limit = this.buffer.limit() - 1;
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        public void writeBool(boolean z) {
            write(z ? (byte) 1 : 0);
        }

        public void writeFixed32(int i2) {
            int i3 = this.pos - 4;
            this.pos = i3;
            this.buffer.putInt(i3 + 1, i2);
        }

        public void writeFixed64(long j) {
            int i2 = this.pos - 8;
            this.pos = i2;
            this.buffer.putLong(i2 + 1, j);
        }

        public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
            writeTag(i2, 4);
            schema.writeTo(obj, this);
            writeTag(i2, 3);
        }

        public void writeInt32(int i2) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64((long) i2);
            }
        }

        public void writeSInt32(int i2) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i2));
        }

        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i2 = this.pos - remaining;
            this.pos = i2;
            this.buffer.position(i2 + 1);
            this.buffer.put(byteBuffer);
        }

        public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeString(String str) {
            int i2;
            int i3;
            int i4;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer.put(this.pos + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i4 = this.pos) >= 0) {
                    ByteBuffer byteBuffer = this.buffer;
                    this.pos = i4 - 1;
                    byteBuffer.put(i4, (byte) charAt2);
                } else if (charAt2 < 2048 && (i3 = this.pos) > 0) {
                    ByteBuffer byteBuffer2 = this.buffer;
                    this.pos = i3 - 1;
                    byteBuffer2.put(i3, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.buffer;
                    int i5 = this.pos;
                    this.pos = i5 - 1;
                    byteBuffer3.put(i5, (byte) ((charAt2 >>> 6) | 960));
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i2 = this.pos) > 1) {
                    ByteBuffer byteBuffer4 = this.buffer;
                    this.pos = i2 - 1;
                    byteBuffer4.put(i2, (byte) ((charAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.buffer;
                    int i6 = this.pos;
                    this.pos = i6 - 1;
                    byteBuffer5.put(i6, (byte) (((charAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.buffer;
                    int i7 = this.pos;
                    this.pos = i7 - 1;
                    byteBuffer6.put(i7, (byte) ((charAt2 >>> 12) | 480));
                } else if (this.pos > 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            ByteBuffer byteBuffer7 = this.buffer;
                            int i8 = this.pos;
                            this.pos = i8 - 1;
                            byteBuffer7.put(i8, (byte) ((codePoint & 63) | 128));
                            ByteBuffer byteBuffer8 = this.buffer;
                            int i9 = this.pos;
                            this.pos = i9 - 1;
                            byteBuffer8.put(i9, (byte) (((codePoint >>> 6) & 63) | 128));
                            ByteBuffer byteBuffer9 = this.buffer;
                            int i10 = this.pos;
                            this.pos = i10 - 1;
                            byteBuffer9.put(i10, (byte) (((codePoint >>> 12) & 63) | 128));
                            ByteBuffer byteBuffer10 = this.buffer;
                            int i11 = this.pos;
                            this.pos = i11 - 1;
                            byteBuffer10.put(i11, (byte) ((codePoint >>> 18) | AuthorityState.STATE_ERROR_NETWORK));
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
                return;
            }
            int i2 = this.pos - remaining;
            this.pos = i2;
            this.buffer.position(i2 + 1);
            this.buffer.put(byteBuffer);
        }
    }

    public static final class SafeHeapWriter extends BinaryWriter {
        public AllocatedBuffer allocatedBuffer;
        public byte[] buffer;
        public int limit;
        public int limitMinusOne;
        public int offset;
        public int offsetMinusOne;
        public int pos;

        public SafeHeapWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, (AnonymousClass1) null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i2) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (i2 >>> 28);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) (((i2 >>> 21) & 127) | 128);
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) (((i2 >>> 14) & 127) | 128);
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) (((i2 >>> 7) & 127) | 128);
            this.pos = i7 - 1;
            bArr[i7] = (byte) ((i2 & 127) | 128);
        }

        private void writeVarint32FourBytes(int i2) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (i2 >>> 21);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) (((i2 >>> 14) & 127) | 128);
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) (((i2 >>> 7) & 127) | 128);
            this.pos = i6 - 1;
            bArr[i6] = (byte) ((i2 & 127) | 128);
        }

        private void writeVarint32OneByte(int i2) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            this.pos = i3 - 1;
            bArr[i3] = (byte) i2;
        }

        private void writeVarint32ThreeBytes(int i2) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (i2 >>> 14);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) (((i2 >>> 7) & 127) | 128);
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((i2 & 127) | 128);
        }

        private void writeVarint32TwoBytes(int i2) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (i2 >>> 7);
            this.pos = i4 - 1;
            bArr[i4] = (byte) ((i2 & 127) | 128);
        }

        private void writeVarint64EightBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (j >>> 49));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 42) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 35) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i9 - 1;
            bArr[i9] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (j >>> 28));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i6 - 1;
            bArr[i6] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64FourBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (j >>> 21));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i5 - 1;
            bArr[i5] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64NineBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (j >>> 56));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 49) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 42) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 35) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i10 = i9 - 1;
            this.pos = i10;
            bArr[i9] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i10 - 1;
            bArr[i10] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64OneByte(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = (byte) ((int) j);
        }

        private void writeVarint64SevenBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (j >>> 42));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 35) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i8 - 1;
            bArr[i8] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64SixBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (j >>> 35));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i7 - 1;
            bArr[i7] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64TenBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (j >>> 63));
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 56) & 127) | 128));
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((int) (((j >>> 49) & 127) | 128));
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((int) (((j >>> 42) & 127) | 128));
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) ((int) (((j >>> 35) & 127) | 128));
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) ((int) (((j >>> 28) & 127) | 128));
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) ((int) (((j >>> 21) & 127) | 128));
            int i10 = i9 - 1;
            this.pos = i10;
            bArr[i9] = (byte) ((int) (((j >>> 14) & 127) | 128));
            int i11 = i10 - 1;
            this.pos = i11;
            bArr[i10] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i11 - 1;
            bArr[i11] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) (((int) j) >>> 14);
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((int) (((j >>> 7) & 127) | 128));
            this.pos = i4 - 1;
            bArr[i4] = (byte) ((int) ((j & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) ((int) (j >>> 7));
            this.pos = i3 - 1;
            bArr[i3] = (byte) ((((int) j) & 127) | 128);
        }

        public int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.pos;
        }

        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer2 = this.allocatedBuffer;
                allocatedBuffer2.position((this.pos - allocatedBuffer2.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        public void requireSpace(int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
        }

        public int spaceLeft() {
            return this.pos - this.offsetMinusOne;
        }

        public void write(byte b) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            this.pos = i2 - 1;
            bArr[i2] = b;
        }

        public void writeBool(int i2, boolean z) throws IOException {
            requireSpace(6);
            write(z ? (byte) 1 : 0);
            writeTag(i2, 0);
        }

        public void writeBytes(int i2, ByteString byteString) throws IOException {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i2, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeEndGroup(int i2) {
            writeTag(i2, 4);
        }

        public void writeFixed32(int i2, int i3) throws IOException {
            requireSpace(9);
            writeFixed32(i3);
            writeTag(i2, 5);
        }

        public void writeFixed64(int i2, long j) throws IOException {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i2, 1);
        }

        public void writeGroup(int i2, Object obj) throws IOException {
            writeTag(i2, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i2, 3);
        }

        public void writeInt32(int i2, int i3) throws IOException {
            requireSpace(15);
            writeInt32(i3);
            writeTag(i2, 0);
        }

        public void writeLazy(byte[] bArr, int i2, int i3) {
            if (spaceLeft() < i3) {
                this.totalDoneBytes += i3;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i2, i3));
                nextBuffer();
                return;
            }
            int i4 = this.pos - i3;
            this.pos = i4;
            System.arraycopy(bArr, i2, this.buffer, i4 + 1, i3);
        }

        public void writeMessage(int i2, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeSInt32(int i2, int i3) throws IOException {
            requireSpace(10);
            writeSInt32(i3);
            writeTag(i2, 0);
        }

        public void writeSInt64(int i2, long j) throws IOException {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i2, 0);
        }

        public void writeStartGroup(int i2) {
            writeTag(i2, 3);
        }

        public void writeString(int i2, String str) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeTag(int i2, int i3) {
            writeVarint32(WireFormat.makeTag(i2, i3));
        }

        public void writeUInt32(int i2, int i3) throws IOException {
            requireSpace(10);
            writeVarint32(i3);
            writeTag(i2, 0);
        }

        public void writeUInt64(int i2, long j) throws IOException {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i2, 0);
        }

        public void writeVarint32(int i2) {
            if ((i2 & a.g) == 0) {
                writeVarint32OneByte(i2);
            } else if ((i2 & -16384) == 0) {
                writeVarint32TwoBytes(i2);
            } else if ((-2097152 & i2) == 0) {
                writeVarint32ThreeBytes(i2);
            } else if ((-268435456 & i2) == 0) {
                writeVarint32FourBytes(i2);
            } else {
                writeVarint32FiveBytes(i2);
            }
        }

        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    return;
                case 2:
                    writeVarint64TwoBytes(j);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j);
                    return;
                case 4:
                    writeVarint64FourBytes(j);
                    return;
                case 5:
                    writeVarint64FiveBytes(j);
                    return;
                case 6:
                    writeVarint64SixBytes(j);
                    return;
                case 7:
                    writeVarint64SevenBytes(j);
                    return;
                case 8:
                    writeVarint64EightBytes(j);
                    return;
                case 9:
                    writeVarint64NineBytes(j);
                    return;
                case 10:
                    writeVarint64TenBytes(j);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i2) {
            nextBuffer(newHeapBuffer(i2));
        }

        public void write(byte[] bArr, int i2, int i3) {
            if (spaceLeft() < i3) {
                nextBuffer(i3);
            }
            int i4 = this.pos - i3;
            this.pos = i4;
            System.arraycopy(bArr, i2, this.buffer, i4 + 1, i3);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer2) {
            if (allocatedBuffer2.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer2);
                this.allocatedBuffer = allocatedBuffer2;
                this.buffer = allocatedBuffer2.array();
                int arrayOffset = allocatedBuffer2.arrayOffset();
                this.limit = allocatedBuffer2.limit() + arrayOffset;
                int position = arrayOffset + allocatedBuffer2.position();
                this.offset = position;
                this.offsetMinusOne = position - 1;
                int i2 = this.limit - 1;
                this.limitMinusOne = i2;
                this.pos = i2;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        public void writeBool(boolean z) {
            write(z ? (byte) 1 : 0);
        }

        public void writeFixed32(int i2) {
            byte[] bArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) ((i2 >> 24) & 255);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) ((i2 >> 16) & 255);
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) ((i2 >> 8) & 255);
            this.pos = i6 - 1;
            bArr[i6] = (byte) (i2 & 255);
        }

        public void writeFixed64(long j) {
            byte[] bArr = this.buffer;
            int i2 = this.pos;
            int i3 = i2 - 1;
            this.pos = i3;
            bArr[i2] = (byte) (((int) (j >> 56)) & 255);
            int i4 = i3 - 1;
            this.pos = i4;
            bArr[i3] = (byte) (((int) (j >> 48)) & 255);
            int i5 = i4 - 1;
            this.pos = i5;
            bArr[i4] = (byte) (((int) (j >> 40)) & 255);
            int i6 = i5 - 1;
            this.pos = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i6 - 1;
            this.pos = i7;
            bArr[i6] = (byte) (((int) (j >> 24)) & 255);
            int i8 = i7 - 1;
            this.pos = i8;
            bArr[i7] = (byte) (((int) (j >> 16)) & 255);
            int i9 = i8 - 1;
            this.pos = i9;
            bArr[i8] = (byte) (((int) (j >> 8)) & 255);
            this.pos = i9 - 1;
            bArr[i9] = (byte) (((int) j) & 255);
        }

        public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
            writeTag(i2, 4);
            schema.writeTo(obj, this);
            writeTag(i2, 3);
        }

        public void writeInt32(int i2) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64((long) i2);
            }
        }

        public void writeSInt32(int i2) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i2));
        }

        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            int i2 = this.pos - remaining;
            this.pos = i2;
            byteBuffer.get(this.buffer, i2 + 1, remaining);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            int i2 = this.pos - remaining;
            this.pos = i2;
            byteBuffer.get(this.buffer, i2 + 1, remaining);
        }

        public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeString(String str) {
            int i2;
            int i3;
            int i4;
            char charAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.pos -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.buffer[this.pos + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.pos--;
                return;
            }
            this.pos += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i4 = this.pos) > this.offsetMinusOne) {
                    byte[] bArr = this.buffer;
                    this.pos = i4 - 1;
                    bArr[i4] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i3 = this.pos) > this.offset) {
                    byte[] bArr2 = this.buffer;
                    int i5 = i3 - 1;
                    this.pos = i5;
                    bArr2[i3] = (byte) ((charAt2 & '?') | 128);
                    this.pos = i5 - 1;
                    bArr2[i5] = (byte) ((charAt2 >>> 6) | 960);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i2 = this.pos) > this.offset + 1) {
                    byte[] bArr3 = this.buffer;
                    int i6 = i2 - 1;
                    this.pos = i6;
                    bArr3[i2] = (byte) ((charAt2 & '?') | 128);
                    int i7 = i6 - 1;
                    this.pos = i7;
                    bArr3[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.pos = i7 - 1;
                    bArr3[i7] = (byte) ((charAt2 >>> 12) | 480);
                } else if (this.pos > this.offset + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr4 = this.buffer;
                            int i8 = this.pos;
                            int i9 = i8 - 1;
                            this.pos = i9;
                            bArr4[i8] = (byte) ((codePoint & 63) | 128);
                            int i10 = i9 - 1;
                            this.pos = i10;
                            bArr4[i9] = (byte) (((codePoint >>> 6) & 63) | 128);
                            int i11 = i10 - 1;
                            this.pos = i11;
                            bArr4[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                            this.pos = i11 - 1;
                            bArr4[i11] = (byte) ((codePoint >>> 18) | AuthorityState.STATE_ERROR_NETWORK);
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }
    }

    public static final class UnsafeDirectWriter extends BinaryWriter {
        public ByteBuffer buffer;
        public long bufferOffset;
        public long limitMinusOne;
        public long pos;

        public UnsafeDirectWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, (AnonymousClass1) null);
            nextBuffer();
        }

        private int bufferPos() {
            return (int) (this.pos - this.bufferOffset);
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i2 >>> 28));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((i2 >>> 21) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((i2 >>> 14) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((i2 >>> 7) & 127) | 128));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i2 >>> 21));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((i2 >>> 14) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((i2 >>> 7) & 127) | 128));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32OneByte(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) i2);
        }

        private void writeVarint32ThreeBytes(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i2 >>> 14));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((i2 >>> 7) & 127) | 128));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) (i2 >>> 7));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 49)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64FiveBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 28)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64FourBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 21)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64NineBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 56)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 49) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64OneByte(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) j));
        }

        private void writeVarint64SevenBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 42)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64SixBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 35)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64TenBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 63)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 56) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) (((j >>> 49) & 127) | 128)));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) ((int) (((j >>> 42) & 127) | 128)));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) ((int) (((j >>> 35) & 127) | 128)));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) ((int) (((j >>> 28) & 127) | 128)));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) ((int) (((j >>> 21) & 127) | 128)));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) ((int) (((j >>> 14) & 127) | 128)));
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(j10, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(j11, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64ThreeBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((int) j) >>> 14));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((int) (((j >>> 7) & 127) | 128)));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64TwoBytes(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((int) (j >>> 7)));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((((int) j) & 127) | 128));
        }

        public void finishCurrentBuffer() {
            if (this.buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.buffer.position(bufferPos() + 1);
                this.buffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        public void requireSpace(int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
        }

        public void write(byte b) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, b);
        }

        public void writeBool(int i2, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : 0);
            writeTag(i2, 0);
        }

        public void writeBytes(int i2, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i2, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeEndGroup(int i2) {
            writeTag(i2, 4);
        }

        public void writeFixed32(int i2, int i3) {
            requireSpace(9);
            writeFixed32(i3);
            writeTag(i2, 5);
        }

        public void writeFixed64(int i2, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i2, 1);
        }

        public void writeGroup(int i2, Object obj) throws IOException {
            writeTag(i2, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i2, 3);
        }

        public void writeInt32(int i2, int i3) {
            requireSpace(15);
            writeInt32(i3);
            writeTag(i2, 0);
        }

        public void writeLazy(byte[] bArr, int i2, int i3) {
            if (spaceLeft() < i3) {
                this.totalDoneBytes += i3;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i2, i3));
                nextBuffer();
                return;
            }
            this.pos -= (long) i3;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, i2, i3);
        }

        public void writeMessage(int i2, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeSInt32(int i2, int i3) {
            requireSpace(10);
            writeSInt32(i3);
            writeTag(i2, 0);
        }

        public void writeSInt64(int i2, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i2, 0);
        }

        public void writeStartGroup(int i2) {
            writeTag(i2, 3);
        }

        public void writeString(int i2, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeTag(int i2, int i3) {
            writeVarint32(WireFormat.makeTag(i2, i3));
        }

        public void writeUInt32(int i2, int i3) {
            requireSpace(10);
            writeVarint32(i3);
            writeTag(i2, 0);
        }

        public void writeUInt64(int i2, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i2, 0);
        }

        public void writeVarint32(int i2) {
            if ((i2 & a.g) == 0) {
                writeVarint32OneByte(i2);
            } else if ((i2 & -16384) == 0) {
                writeVarint32TwoBytes(i2);
            } else if ((-2097152 & i2) == 0) {
                writeVarint32ThreeBytes(i2);
            } else if ((-268435456 & i2) == 0) {
                writeVarint32FourBytes(i2);
            } else {
                writeVarint32FiveBytes(i2);
            }
        }

        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    return;
                case 2:
                    writeVarint64TwoBytes(j);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j);
                    return;
                case 4:
                    writeVarint64FourBytes(j);
                    return;
                case 5:
                    writeVarint64FiveBytes(j);
                    return;
                case 6:
                    writeVarint64SixBytes(j);
                    return;
                case 7:
                    writeVarint64SevenBytes(j);
                    return;
                case 8:
                    writeVarint64EightBytes(j);
                    return;
                case 9:
                    writeVarint64NineBytes(j);
                    return;
                case 10:
                    writeVarint64TenBytes(j);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i2) {
            nextBuffer(newDirectBuffer(i2));
        }

        public void write(byte[] bArr, int i2, int i3) {
            if (spaceLeft() < i3) {
                nextBuffer(i3);
            }
            this.pos -= (long) i3;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(bArr, i2, i3);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer nioBuffer = allocatedBuffer.nioBuffer();
                if (nioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.buffers.addFirst(allocatedBuffer);
                    this.buffer = nioBuffer;
                    nioBuffer.limit(nioBuffer.capacity());
                    this.buffer.position(0);
                    long addressOffset = UnsafeUtil.addressOffset(this.buffer);
                    this.bufferOffset = addressOffset;
                    long limit = addressOffset + ((long) (this.buffer.limit() - 1));
                    this.limitMinusOne = limit;
                    this.pos = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        public void writeBool(boolean z) {
            write(z ? (byte) 1 : 0);
        }

        public void writeFixed32(int i2) {
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(j, (byte) ((i2 >> 24) & 255));
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) ((i2 >> 16) & 255));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) ((i2 >> 8) & 255));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (i2 & 255));
        }

        public void writeFixed64(long j) {
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(j2, (byte) (((int) (j >> 56)) & 255));
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(j3, (byte) (((int) (j >> 48)) & 255));
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(j4, (byte) (((int) (j >> 40)) & 255));
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(j5, (byte) (((int) (j >> 32)) & 255));
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(j6, (byte) (((int) (j >> 24)) & 255));
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(j7, (byte) (((int) (j >> 16)) & 255));
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(j8, (byte) (((int) (j >> 8)) & 255));
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(j9, (byte) (((int) j) & 255));
        }

        public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
            writeTag(i2, 4);
            schema.writeTo(obj, this);
            writeTag(i2, 3);
        }

        public void writeInt32(int i2) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64((long) i2);
            }
        }

        public void writeSInt32(int i2) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i2));
        }

        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                nextBuffer(remaining);
            }
            this.pos -= (long) remaining;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }

        public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    long j = this.pos;
                    this.pos = j - 1;
                    UnsafeUtil.putByte(j, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j2 = this.pos;
                        if (j2 >= this.bufferOffset) {
                            this.pos = j2 - 1;
                            UnsafeUtil.putByte(j2, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j3 = this.pos;
                        if (j3 > this.bufferOffset) {
                            this.pos = j3 - 1;
                            UnsafeUtil.putByte(j3, (byte) ((charAt2 & '?') | 128));
                            long j4 = this.pos;
                            this.pos = j4 - 1;
                            UnsafeUtil.putByte(j4, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j5 = this.pos;
                        if (j5 > this.bufferOffset + 1) {
                            this.pos = j5 - 1;
                            UnsafeUtil.putByte(j5, (byte) ((charAt2 & '?') | 128));
                            long j6 = this.pos;
                            this.pos = j6 - 1;
                            UnsafeUtil.putByte(j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                            long j7 = this.pos;
                            this.pos = j7 - 1;
                            UnsafeUtil.putByte(j7, (byte) ((charAt2 >>> 12) | 480));
                            length--;
                        }
                    }
                    if (this.pos > this.bufferOffset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                long j8 = this.pos;
                                this.pos = j8 - 1;
                                UnsafeUtil.putByte(j8, (byte) ((codePoint & 63) | 128));
                                long j9 = this.pos;
                                this.pos = j9 - 1;
                                UnsafeUtil.putByte(j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j10 = this.pos;
                                this.pos = j10 - 1;
                                UnsafeUtil.putByte(j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j11 = this.pos;
                                this.pos = j11 - 1;
                                UnsafeUtil.putByte(j11, (byte) ((codePoint >>> 18) | AuthorityState.STATE_ERROR_NETWORK));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                    length--;
                }
            }
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
                return;
            }
            this.pos -= (long) remaining;
            this.buffer.position(bufferPos() + 1);
            this.buffer.put(byteBuffer);
        }
    }

    public static final class UnsafeHeapWriter extends BinaryWriter {
        public AllocatedBuffer allocatedBuffer;
        public byte[] buffer;
        public long limit;
        public long limitMinusOne;
        public long offset;
        public long offsetMinusOne;
        public long pos;

        public UnsafeHeapWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, (AnonymousClass1) null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.pos;
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i2 >>> 28));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((i2 >>> 21) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) (((i2 >>> 14) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr5 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr5, j5, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32FourBytes(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i2 >>> 21));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((i2 >>> 14) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32OneByte(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) i2);
        }

        private void writeVarint32ThreeBytes(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i2 >>> 14));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) (((i2 >>> 7) & 127) | 128));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) (i2 >>> 7));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) ((i2 & 127) | 128));
        }

        private void writeVarint64EightBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 49)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 42) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 35) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64FiveBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 28)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64FourBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 21)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64NineBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 56)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 49) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 42) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 35) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr9 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr9, j10, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64OneByte(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) j));
        }

        private void writeVarint64SevenBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 42)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 35) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64SixBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 35)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64TenBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 63)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 56) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) (((j >>> 49) & 127) | 128)));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) ((int) (((j >>> 42) & 127) | 128)));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) ((int) (((j >>> 35) & 127) | 128)));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) ((int) (((j >>> 28) & 127) | 128)));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) ((int) (((j >>> 21) & 127) | 128)));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) ((int) (((j >>> 14) & 127) | 128)));
            byte[] bArr9 = this.buffer;
            long j10 = this.pos;
            this.pos = j10 - 1;
            UnsafeUtil.putByte(bArr9, j10, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr10 = this.buffer;
            long j11 = this.pos;
            this.pos = j11 - 1;
            UnsafeUtil.putByte(bArr10, j11, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64ThreeBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (((int) j) >>> 14));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((int) (((j >>> 7) & 127) | 128)));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) ((int) ((j & 127) | 128)));
        }

        private void writeVarint64TwoBytes(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) ((int) (j >>> 7)));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) ((((int) j) & 127) | 128));
        }

        public int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.pos);
        }

        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.pos = 0;
                this.limitMinusOne = 0;
            }
        }

        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        public void requireSpace(int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
        }

        public int spaceLeft() {
            return (int) (this.pos - this.offsetMinusOne);
        }

        public void write(byte b) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, b);
        }

        public void writeBool(int i2, boolean z) {
            requireSpace(6);
            write(z ? (byte) 1 : 0);
            writeTag(i2, 0);
        }

        public void writeBytes(int i2, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.size());
                writeTag(i2, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void writeEndGroup(int i2) {
            writeTag(i2, 4);
        }

        public void writeFixed32(int i2, int i3) {
            requireSpace(9);
            writeFixed32(i3);
            writeTag(i2, 5);
        }

        public void writeFixed64(int i2, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i2, 1);
        }

        public void writeGroup(int i2, Object obj) throws IOException {
            writeTag(i2, 4);
            Protobuf.getInstance().writeTo(obj, this);
            writeTag(i2, 3);
        }

        public void writeInt32(int i2, int i3) {
            requireSpace(15);
            writeInt32(i3);
            writeTag(i2, 0);
        }

        public void writeLazy(byte[] bArr, int i2, int i3) {
            if (i2 < 0 || i2 + i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            } else if (spaceLeft() < i3) {
                this.totalDoneBytes += i3;
                this.buffers.addFirst(AllocatedBuffer.wrap(bArr, i2, i3));
                nextBuffer();
            } else {
                this.pos -= (long) i3;
                System.arraycopy(bArr, i2, this.buffer, arrayPos() + 1, i3);
            }
        }

        public void writeMessage(int i2, Object obj) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeSInt32(int i2, int i3) {
            requireSpace(10);
            writeSInt32(i3);
            writeTag(i2, 0);
        }

        public void writeSInt64(int i2, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i2, 0);
        }

        public void writeStartGroup(int i2) {
            writeTag(i2, 3);
        }

        public void writeString(int i2, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeTag(int i2, int i3) {
            writeVarint32(WireFormat.makeTag(i2, i3));
        }

        public void writeUInt32(int i2, int i3) {
            requireSpace(10);
            writeVarint32(i3);
            writeTag(i2, 0);
        }

        public void writeUInt64(int i2, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i2, 0);
        }

        public void writeVarint32(int i2) {
            if ((i2 & a.g) == 0) {
                writeVarint32OneByte(i2);
            } else if ((i2 & -16384) == 0) {
                writeVarint32TwoBytes(i2);
            } else if ((-2097152 & i2) == 0) {
                writeVarint32ThreeBytes(i2);
            } else if ((-268435456 & i2) == 0) {
                writeVarint32FourBytes(i2);
            } else {
                writeVarint32FiveBytes(i2);
            }
        }

        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    return;
                case 2:
                    writeVarint64TwoBytes(j);
                    return;
                case 3:
                    writeVarint64ThreeBytes(j);
                    return;
                case 4:
                    writeVarint64FourBytes(j);
                    return;
                case 5:
                    writeVarint64FiveBytes(j);
                    return;
                case 6:
                    writeVarint64SixBytes(j);
                    return;
                case 7:
                    writeVarint64SevenBytes(j);
                    return;
                case 8:
                    writeVarint64EightBytes(j);
                    return;
                case 9:
                    writeVarint64NineBytes(j);
                    return;
                case 10:
                    writeVarint64TenBytes(j);
                    return;
                default:
                    return;
            }
        }

        private void nextBuffer(int i2) {
            nextBuffer(newHeapBuffer(i2));
        }

        public void write(byte[] bArr, int i2, int i3) {
            if (i2 < 0 || i2 + i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            }
            requireSpace(i3);
            this.pos -= (long) i3;
            System.arraycopy(bArr, i2, this.buffer, arrayPos() + 1, i3);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer2) {
            if (allocatedBuffer2.hasArray()) {
                finishCurrentBuffer();
                this.buffers.addFirst(allocatedBuffer2);
                this.allocatedBuffer = allocatedBuffer2;
                this.buffer = allocatedBuffer2.array();
                int arrayOffset = allocatedBuffer2.arrayOffset();
                this.limit = (long) (allocatedBuffer2.limit() + arrayOffset);
                long position = (long) (arrayOffset + allocatedBuffer2.position());
                this.offset = position;
                this.offsetMinusOne = position - 1;
                long j = this.limit - 1;
                this.limitMinusOne = j;
                this.pos = j;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        public void writeBool(boolean z) {
            write(z ? (byte) 1 : 0);
        }

        public void writeFixed32(int i2) {
            byte[] bArr = this.buffer;
            long j = this.pos;
            this.pos = j - 1;
            UnsafeUtil.putByte(bArr, j, (byte) ((i2 >> 24) & 255));
            byte[] bArr2 = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr2, j2, (byte) ((i2 >> 16) & 255));
            byte[] bArr3 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr3, j3, (byte) ((i2 >> 8) & 255));
            byte[] bArr4 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr4, j4, (byte) (i2 & 255));
        }

        public void writeFixed64(long j) {
            byte[] bArr = this.buffer;
            long j2 = this.pos;
            this.pos = j2 - 1;
            UnsafeUtil.putByte(bArr, j2, (byte) (((int) (j >> 56)) & 255));
            byte[] bArr2 = this.buffer;
            long j3 = this.pos;
            this.pos = j3 - 1;
            UnsafeUtil.putByte(bArr2, j3, (byte) (((int) (j >> 48)) & 255));
            byte[] bArr3 = this.buffer;
            long j4 = this.pos;
            this.pos = j4 - 1;
            UnsafeUtil.putByte(bArr3, j4, (byte) (((int) (j >> 40)) & 255));
            byte[] bArr4 = this.buffer;
            long j5 = this.pos;
            this.pos = j5 - 1;
            UnsafeUtil.putByte(bArr4, j5, (byte) (((int) (j >> 32)) & 255));
            byte[] bArr5 = this.buffer;
            long j6 = this.pos;
            this.pos = j6 - 1;
            UnsafeUtil.putByte(bArr5, j6, (byte) (((int) (j >> 24)) & 255));
            byte[] bArr6 = this.buffer;
            long j7 = this.pos;
            this.pos = j7 - 1;
            UnsafeUtil.putByte(bArr6, j7, (byte) (((int) (j >> 16)) & 255));
            byte[] bArr7 = this.buffer;
            long j8 = this.pos;
            this.pos = j8 - 1;
            UnsafeUtil.putByte(bArr7, j8, (byte) (((int) (j >> 8)) & 255));
            byte[] bArr8 = this.buffer;
            long j9 = this.pos;
            this.pos = j9 - 1;
            UnsafeUtil.putByte(bArr8, j9, (byte) (((int) j) & 255));
        }

        public void writeGroup(int i2, Object obj, Schema schema) throws IOException {
            writeTag(i2, 4);
            schema.writeTo(obj, this);
            writeTag(i2, 3);
        }

        public void writeInt32(int i2) {
            if (i2 >= 0) {
                writeVarint32(i2);
            } else {
                writeVarint64((long) i2);
            }
        }

        public void writeSInt32(int i2) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i2));
        }

        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        public void writeMessage(int i2, Object obj, Schema schema) throws IOException {
            int totalBytesWritten = getTotalBytesWritten();
            schema.writeTo(obj, this);
            requireSpace(10);
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }

        public void writeString(String str) {
            char charAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    byte[] bArr = this.buffer;
                    long j = this.pos;
                    this.pos = j - 1;
                    UnsafeUtil.putByte(bArr, j, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j2 = this.pos;
                        if (j2 > this.offsetMinusOne) {
                            byte[] bArr2 = this.buffer;
                            this.pos = j2 - 1;
                            UnsafeUtil.putByte(bArr2, j2, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j3 = this.pos;
                        if (j3 > this.offset) {
                            byte[] bArr3 = this.buffer;
                            this.pos = j3 - 1;
                            UnsafeUtil.putByte(bArr3, j3, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr4 = this.buffer;
                            long j4 = this.pos;
                            this.pos = j4 - 1;
                            UnsafeUtil.putByte(bArr4, j4, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j5 = this.pos;
                        if (j5 > this.offset + 1) {
                            byte[] bArr5 = this.buffer;
                            this.pos = j5 - 1;
                            UnsafeUtil.putByte(bArr5, j5, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr6 = this.buffer;
                            long j6 = this.pos;
                            this.pos = j6 - 1;
                            UnsafeUtil.putByte(bArr6, j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                            byte[] bArr7 = this.buffer;
                            long j7 = this.pos;
                            this.pos = j7 - 1;
                            UnsafeUtil.putByte(bArr7, j7, (byte) ((charAt2 >>> 12) | 480));
                            length--;
                        }
                    }
                    if (this.pos > this.offset + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                byte[] bArr8 = this.buffer;
                                long j8 = this.pos;
                                this.pos = j8 - 1;
                                UnsafeUtil.putByte(bArr8, j8, (byte) ((codePoint & 63) | 128));
                                byte[] bArr9 = this.buffer;
                                long j9 = this.pos;
                                this.pos = j9 - 1;
                                UnsafeUtil.putByte(bArr9, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                byte[] bArr10 = this.buffer;
                                long j10 = this.pos;
                                this.pos = j10 - 1;
                                UnsafeUtil.putByte(bArr10, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                byte[] bArr11 = this.buffer;
                                long j11 = this.pos;
                                this.pos = j11 - 1;
                                UnsafeUtil.putByte(bArr11, j11, (byte) ((codePoint >>> 18) | AuthorityState.STATE_ERROR_NETWORK));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                    length--;
                }
            }
        }

        public void write(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            requireSpace(remaining);
            this.pos -= (long) remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }

        public void writeLazy(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (spaceLeft() < remaining) {
                this.totalDoneBytes += remaining;
                this.buffers.addFirst(AllocatedBuffer.wrap(byteBuffer));
                nextBuffer();
            }
            this.pos -= (long) remaining;
            byteBuffer.get(this.buffer, arrayPos() + 1, remaining);
        }
    }

    public /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i2, AnonymousClass1 r3) {
        this(bufferAllocator, i2);
    }

    public static byte computeUInt64SizeNoTag(long j) {
        byte b;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            b = (byte) 6;
            j >>>= 28;
        } else {
            b = 2;
        }
        if ((-2097152 & j) != 0) {
            b = (byte) (b + 2);
            j >>>= 14;
        }
        return (j & -16384) != 0 ? (byte) (b + 1) : b;
    }

    public static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.isSupported();
    }

    public static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int i2) {
        return new SafeDirectWriter(bufferAllocator, i2);
    }

    public static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int i2) {
        return new SafeHeapWriter(bufferAllocator, i2);
    }

    public static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int i2) {
        if (isUnsafeDirectSupported()) {
            return new UnsafeDirectWriter(bufferAllocator, i2);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    public static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int i2) {
        if (isUnsafeHeapSupported()) {
            return new UnsafeHeapWriter(bufferAllocator, i2);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private final void writeBoolList_Internal(int i2, List<Boolean> list, boolean z) throws IOException {
        if (z) {
            requireSpace(list.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(list.get(size).booleanValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(i2, list.get(size2).booleanValue());
        }
    }

    private final void writeDoubleList_Internal(int i2, List<Double> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(list.get(size).doubleValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeDouble(i2, list.get(size2).doubleValue());
        }
    }

    private final void writeFixed32List_Internal(int i2, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i2, list.get(size2).intValue());
        }
    }

    private final void writeFixed64List_Internal(int i2, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i2, list.get(size2).longValue());
        }
    }

    private final void writeFloatList_Internal(int i2, List<Float> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(list.get(size).floatValue()));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFloat(i2, list.get(size2).floatValue());
        }
    }

    private final void writeInt32List_Internal(int i2, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(i2, list.get(size2).intValue());
        }
    }

    private void writeLazyString(int i2, Object obj) throws IOException {
        if (obj instanceof String) {
            writeString(i2, (String) obj);
        } else {
            writeBytes(i2, (ByteString) obj);
        }
    }

    public static final void writeMapEntryField(Writer writer, int i2, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                writer.writeBool(i2, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.writeFixed32(i2, ((Integer) obj).intValue());
                return;
            case 3:
                writer.writeFixed64(i2, ((Long) obj).longValue());
                return;
            case 4:
                writer.writeInt32(i2, ((Integer) obj).intValue());
                return;
            case 5:
                writer.writeInt64(i2, ((Long) obj).longValue());
                return;
            case 6:
                writer.writeSFixed32(i2, ((Integer) obj).intValue());
                return;
            case 7:
                writer.writeSFixed64(i2, ((Long) obj).longValue());
                return;
            case 8:
                writer.writeSInt32(i2, ((Integer) obj).intValue());
                return;
            case 9:
                writer.writeSInt64(i2, ((Long) obj).longValue());
                return;
            case 10:
                writer.writeString(i2, (String) obj);
                return;
            case 11:
                writer.writeUInt32(i2, ((Integer) obj).intValue());
                return;
            case 12:
                writer.writeUInt64(i2, ((Long) obj).longValue());
                return;
            case 13:
                writer.writeFloat(i2, ((Float) obj).floatValue());
                return;
            case 14:
                writer.writeDouble(i2, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.writeMessage(i2, obj);
                return;
            case 16:
                writer.writeBytes(i2, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    writer.writeEnum(i2, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else if (obj instanceof Integer) {
                    writer.writeEnum(i2, ((Integer) obj).intValue());
                    return;
                } else {
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private final void writeSInt32List_Internal(int i2, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i2, list.get(size2).intValue());
        }
    }

    private final void writeSInt64List_Internal(int i2, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i2, list.get(size2).longValue());
        }
    }

    private final void writeUInt32List_Internal(int i2, List<Integer> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint32(list.get(size).intValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i2, list.get(size2).intValue());
        }
    }

    private final void writeUInt64List_Internal(int i2, List<Long> list, boolean z) throws IOException {
        if (z) {
            requireSpace((list.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = list.size() - 1; size >= 0; size--) {
                writeVarint64(list.get(size).longValue());
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i2, list.get(size2).longValue());
        }
    }

    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.buffers;
    }

    public final Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.DESCENDING;
    }

    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    public final AllocatedBuffer newDirectBuffer() {
        return this.alloc.allocateDirectBuffer(this.chunkSize);
    }

    public final AllocatedBuffer newHeapBuffer() {
        return this.alloc.allocateHeapBuffer(this.chunkSize);
    }

    public abstract void requireSpace(int i2);

    public abstract void writeBool(boolean z);

    public final void writeBoolList(int i2, List<Boolean> list, boolean z) throws IOException {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(i2, (BooleanArrayList) list, z);
        } else {
            writeBoolList_Internal(i2, list, z);
        }
    }

    public final void writeBytesList(int i2, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i2, list.get(size));
        }
    }

    public final void writeDouble(int i2, double d) throws IOException {
        writeFixed64(i2, Double.doubleToRawLongBits(d));
    }

    public final void writeDoubleList(int i2, List<Double> list, boolean z) throws IOException {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(i2, (DoubleArrayList) list, z);
        } else {
            writeDoubleList_Internal(i2, list, z);
        }
    }

    public final void writeEnum(int i2, int i3) throws IOException {
        writeInt32(i2, i3);
    }

    public final void writeEnumList(int i2, List<Integer> list, boolean z) throws IOException {
        writeInt32List(i2, list, z);
    }

    public abstract void writeFixed32(int i2);

    public final void writeFixed32List(int i2, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(i2, (IntArrayList) list, z);
        } else {
            writeFixed32List_Internal(i2, list, z);
        }
    }

    public abstract void writeFixed64(long j);

    public final void writeFixed64List(int i2, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(i2, (LongArrayList) list, z);
        } else {
            writeFixed64List_Internal(i2, list, z);
        }
    }

    public final void writeFloat(int i2, float f) throws IOException {
        writeFixed32(i2, Float.floatToRawIntBits(f));
    }

    public final void writeFloatList(int i2, List<Float> list, boolean z) throws IOException {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(i2, (FloatArrayList) list, z);
        } else {
            writeFloatList_Internal(i2, list, z);
        }
    }

    public final void writeGroupList(int i2, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i2, list.get(size));
        }
    }

    public abstract void writeInt32(int i2);

    public final void writeInt32List(int i2, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(i2, (IntArrayList) list, z);
        } else {
            writeInt32List_Internal(i2, list, z);
        }
    }

    public final void writeInt64(int i2, long j) throws IOException {
        writeUInt64(i2, j);
    }

    public final void writeInt64List(int i2, List<Long> list, boolean z) throws IOException {
        writeUInt64List(i2, list, z);
    }

    public <K, V> void writeMap(int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, next.getValue());
            writeMapEntryField(this, 1, metadata.keyType, next.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
        }
    }

    public final void writeMessageList(int i2, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i2, list.get(size));
        }
    }

    public final void writeMessageSetItem(int i2, Object obj) throws IOException {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i2);
        writeTag(1, 3);
    }

    public final void writeSFixed32(int i2, int i3) throws IOException {
        writeFixed32(i2, i3);
    }

    public final void writeSFixed32List(int i2, List<Integer> list, boolean z) throws IOException {
        writeFixed32List(i2, list, z);
    }

    public final void writeSFixed64(int i2, long j) throws IOException {
        writeFixed64(i2, j);
    }

    public final void writeSFixed64List(int i2, List<Long> list, boolean z) throws IOException {
        writeFixed64List(i2, list, z);
    }

    public abstract void writeSInt32(int i2);

    public final void writeSInt32List(int i2, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(i2, (IntArrayList) list, z);
        } else {
            writeSInt32List_Internal(i2, list, z);
        }
    }

    public abstract void writeSInt64(long j);

    public final void writeSInt64List(int i2, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(i2, (LongArrayList) list, z);
        } else {
            writeSInt64List_Internal(i2, list, z);
        }
    }

    public abstract void writeString(String str);

    public final void writeStringList(int i2, List<String> list) throws IOException {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                writeLazyString(i2, lazyStringList.getRaw(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeString(i2, list.get(size2));
        }
    }

    public abstract void writeTag(int i2, int i3);

    public final void writeUInt32List(int i2, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(i2, (IntArrayList) list, z);
        } else {
            writeUInt32List_Internal(i2, list, z);
        }
    }

    public final void writeUInt64List(int i2, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(i2, (LongArrayList) list, z);
        } else {
            writeUInt64List_Internal(i2, list, z);
        }
    }

    public abstract void writeVarint32(int i2);

    public abstract void writeVarint64(long j);

    public BinaryWriter(BufferAllocator bufferAllocator, int i2) {
        this.buffers = new ArrayDeque<>(4);
        if (i2 > 0) {
            this.alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
            this.chunkSize = i2;
            return;
        }
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int i2) {
        if (isUnsafeDirectSupported()) {
            return newUnsafeDirectInstance(bufferAllocator, i2);
        }
        return newSafeDirectInstance(bufferAllocator, i2);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int i2) {
        if (isUnsafeHeapSupported()) {
            return newUnsafeHeapInstance(bufferAllocator, i2);
        }
        return newSafeHeapInstance(bufferAllocator, i2);
    }

    public final AllocatedBuffer newDirectBuffer(int i2) {
        return this.alloc.allocateDirectBuffer(Math.max(i2, this.chunkSize));
    }

    public final AllocatedBuffer newHeapBuffer(int i2) {
        return this.alloc.allocateHeapBuffer(Math.max(i2, this.chunkSize));
    }

    public final void writeGroupList(int i2, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i2, list.get(size), schema);
        }
    }

    public final void writeMessageList(int i2, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i2, list.get(size), schema);
        }
    }

    private final void writeBoolList_Internal(int i2, BooleanArrayList booleanArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(booleanArrayList.getBoolean(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i2, booleanArrayList.getBoolean(size2));
        }
    }

    private final void writeDoubleList_Internal(int i2, DoubleArrayList doubleArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i2, doubleArrayList.getDouble(size2));
        }
    }

    private final void writeFixed32List_Internal(int i2, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i2, intArrayList.getInt(size2));
        }
    }

    private final void writeFixed64List_Internal(int i2, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i2, longArrayList.getLong(size2));
        }
    }

    private final void writeFloatList_Internal(int i2, FloatArrayList floatArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i2, floatArrayList.getFloat(size2));
        }
    }

    private final void writeInt32List_Internal(int i2, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i2, intArrayList.getInt(size2));
        }
    }

    private final void writeSInt32List_Internal(int i2, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i2, intArrayList.getInt(size2));
        }
    }

    private final void writeSInt64List_Internal(int i2, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i2, longArrayList.getLong(size2));
        }
    }

    private final void writeUInt32List_Internal(int i2, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeVarint32(intArrayList.getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i2, intArrayList.getInt(size2));
        }
    }

    private final void writeUInt64List_Internal(int i2, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeVarint64(longArrayList.getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i2, longArrayList.getLong(size2));
        }
    }
}
