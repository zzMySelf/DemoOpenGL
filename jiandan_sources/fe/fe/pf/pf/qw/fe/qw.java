package fe.fe.pf.pf.qw.fe;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

public abstract class qw {
    public static int ad(ByteBuffer byteBuffer) {
        qw(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i2 = capacity - 22;
        int min = Math.min(i2, 65535);
        for (int i3 = 0; i3 < min; i3++) {
            int i4 = i2 - i3;
            if (byteBuffer.getInt(i4) == 101010256 && rg(byteBuffer, i4 + 20) == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static Pair<ByteBuffer, Long> de(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> fe2 = fe(randomAccessFile, 0);
        if (fe2 != null) {
            return fe2;
        }
        return fe(randomAccessFile, 65535);
    }

    public static Pair<ByteBuffer, Long> fe(RandomAccessFile randomAccessFile, int i2) throws IOException {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("maxCommentSize: " + i2);
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min((long) i2, length - 22)) + 22);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long capacity = length - ((long) allocate.capacity());
        randomAccessFile.seek(capacity);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        int ad2 = ad(allocate);
        if (ad2 == -1) {
            return null;
        }
        allocate.position(ad2);
        ByteBuffer slice = allocate.slice();
        slice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(slice, Long.valueOf(capacity + ((long) ad2)));
    }

    public static final boolean i(RandomAccessFile randomAccessFile, long j) throws IOException {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        if (randomAccessFile.readInt() == 1347094023) {
            return true;
        }
        return false;
    }

    public static void o(ByteBuffer byteBuffer, int i2, long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: " + j);
        }
        byteBuffer.putInt(byteBuffer.position() + i2, (int) j);
    }

    public static void pf(ByteBuffer byteBuffer, long j) {
        qw(byteBuffer);
        o(byteBuffer, byteBuffer.position() + 16, j);
    }

    public static void qw(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int rg(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getShort(i2) & UShort.MAX_VALUE;
    }

    public static long th(ByteBuffer byteBuffer, int i2) {
        return ((long) byteBuffer.getInt(i2)) & 4294967295L;
    }

    public static long uk(ByteBuffer byteBuffer) {
        qw(byteBuffer);
        return th(byteBuffer, byteBuffer.position() + 12);
    }

    public static long yj(ByteBuffer byteBuffer) {
        qw(byteBuffer);
        return th(byteBuffer, byteBuffer.position() + 16);
    }
}
