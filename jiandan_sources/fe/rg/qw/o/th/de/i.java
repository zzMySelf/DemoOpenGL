package fe.rg.qw.o.th.de;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.rg.qw.ggg.uk;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class i implements ImageHeaderParser {

    /* renamed from: ad  reason: collision with root package name */
    public static final int[] f4962ad = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    public static final byte[] qw = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    public static final class ad {
        public final ByteBuffer qw;

        public ad(byte[] bArr, int i2) {
            this.qw = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        public int ad(int i2) {
            if (de(i2, 4)) {
                return this.qw.getInt(i2);
            }
            return -1;
        }

        public final boolean de(int i2, int i3) {
            return this.qw.remaining() - i2 >= i3;
        }

        public int fe() {
            return this.qw.remaining();
        }

        public short qw(int i2) {
            if (de(i2, 2)) {
                return this.qw.getShort(i2);
            }
            return -1;
        }

        public void rg(ByteOrder byteOrder) {
            this.qw.order(byteOrder);
        }
    }

    public interface de {
        int ad(byte[] bArr, int i2) throws IOException;

        short de() throws IOException;

        int fe() throws IOException;

        int qw() throws IOException;

        long skip(long j) throws IOException;
    }

    public static final class fe implements de {
        public final InputStream qw;

        public fe(InputStream inputStream) {
            this.qw = inputStream;
        }

        public int ad(byte[] bArr, int i2) throws IOException {
            int i3 = i2;
            while (i3 > 0) {
                int read = this.qw.read(bArr, i2 - i3, i3);
                if (read == -1) {
                    break;
                }
                i3 -= read;
            }
            return i2 - i3;
        }

        public short de() throws IOException {
            return (short) (this.qw.read() & 255);
        }

        public int fe() throws IOException {
            return this.qw.read();
        }

        public int qw() throws IOException {
            return ((this.qw.read() << 8) & 65280) | (this.qw.read() & 255);
        }

        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.qw.skip(j2);
                if (skip <= 0) {
                    if (this.qw.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    public static final class qw implements de {
        public final ByteBuffer qw;

        public qw(ByteBuffer byteBuffer) {
            this.qw = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int ad(byte[] bArr, int i2) {
            int min = Math.min(i2, this.qw.remaining());
            if (min == 0) {
                return -1;
            }
            this.qw.get(bArr, 0, min);
            return min;
        }

        public short de() {
            return (short) (fe() & 255);
        }

        public int fe() {
            if (this.qw.remaining() < 1) {
                return -1;
            }
            return this.qw.get();
        }

        public int qw() {
            return ((fe() << 8) & 65280) | (fe() & 255);
        }

        public long skip(long j) {
            int min = (int) Math.min((long) this.qw.remaining(), j);
            ByteBuffer byteBuffer = this.qw;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    public static int fe(int i2, int i3) {
        return i2 + 2 + (i3 * 12);
    }

    public static int o(ad adVar) {
        ByteOrder byteOrder;
        short qw2 = adVar.qw(6);
        if (qw2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (qw2 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                "Unknown endianness = " + qw2;
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        adVar.rg(byteOrder);
        int ad2 = adVar.ad(10) + 6;
        short qw3 = adVar.qw(ad2);
        for (int i2 = 0; i2 < qw3; i2++) {
            int fe2 = fe(ad2, i2);
            short qw4 = adVar.qw(fe2);
            if (qw4 == 274) {
                short qw5 = adVar.qw(fe2 + 2);
                if (qw5 >= 1 && qw5 <= 12) {
                    int ad3 = adVar.ad(fe2 + 4);
                    if (ad3 < 0) {
                        boolean isLoggable = Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            "Got tagIndex=" + i2 + " tagType=" + qw4 + " formatCode=" + qw5 + " componentCount=" + ad3;
                        }
                        int i3 = ad3 + f4962ad[qw5];
                        if (i3 <= 4) {
                            int i4 = fe2 + 8;
                            if (i4 < 0 || i4 > adVar.fe()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    "Illegal tagValueOffset=" + i4 + " tagType=" + qw4;
                                }
                            } else if (i3 >= 0 && i3 + i4 <= adVar.fe()) {
                                return adVar.qw(i4);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    "Illegal number of bytes for TI tag data tagType=" + qw4;
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            "Got byte count > 4, not orientation, continuing, formatCode=" + qw5;
                        }
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    "Got invalid format code = " + qw5;
                }
            }
        }
        return -1;
    }

    public static boolean yj(int i2) {
        return (i2 & 65496) == 65496 || i2 == 19789 || i2 == 18761;
    }

    @NonNull
    public ImageHeaderParser.ImageType ad(@NonNull InputStream inputStream) throws IOException {
        uk.fe(inputStream);
        return th(new fe(inputStream));
    }

    public int de(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        uk.fe(inputStream);
        fe feVar = new fe(inputStream);
        uk.fe(arrayPool);
        return rg(feVar, arrayPool);
    }

    public final int i(de deVar) throws IOException {
        short de2;
        int qw2;
        long j;
        long skip;
        do {
            short de3 = deVar.de();
            if (de3 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    "Unknown segmentId=" + de3;
                }
                return -1;
            }
            de2 = deVar.de();
            if (de2 == 218) {
                return -1;
            }
            if (de2 == 217) {
                boolean isLoggable = Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            qw2 = deVar.qw() - 2;
            if (de2 == 225) {
                return qw2;
            }
            j = (long) qw2;
            skip = deVar.skip(j);
        } while (skip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            "Unable to skip enough data, type: " + de2 + ", wanted to skip: " + qw2 + ", but actually skipped: " + skip;
        }
        return -1;
    }

    public final int pf(de deVar, byte[] bArr, int i2) throws IOException {
        int ad2 = deVar.ad(bArr, i2);
        if (ad2 != i2) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                "Unable to read exif segment data, length: " + i2 + ", actually read: " + ad2;
            }
            return -1;
        } else if (uk(bArr, i2)) {
            return o(new ad(bArr, i2));
        } else {
            boolean isLoggable = Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
    }

    @NonNull
    public ImageHeaderParser.ImageType qw(@NonNull ByteBuffer byteBuffer) throws IOException {
        uk.fe(byteBuffer);
        return th(new qw(byteBuffer));
    }

    public final int rg(de deVar, ArrayPool arrayPool) throws IOException {
        int qw2 = deVar.qw();
        if (!yj(qw2)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                "Parser doesn't handle magic number: " + qw2;
            }
            return -1;
        }
        int i2 = i(deVar);
        if (i2 == -1) {
            boolean isLoggable = Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        byte[] bArr = (byte[]) arrayPool.de(i2, byte[].class);
        try {
            return pf(deVar, bArr, i2);
        } finally {
            arrayPool.put(bArr);
        }
    }

    @NonNull
    public final ImageHeaderParser.ImageType th(de deVar) throws IOException {
        int qw2 = deVar.qw();
        if (qw2 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int qw3 = ((qw2 << 16) & SupportMenu.CATEGORY_MASK) | (deVar.qw() & 65535);
        if (qw3 == -1991225785) {
            deVar.skip(21);
            return deVar.fe() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((qw3 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (qw3 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            deVar.skip(4);
            if ((((deVar.qw() << 16) & SupportMenu.CATEGORY_MASK) | (deVar.qw() & 65535)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int qw4 = ((deVar.qw() << 16) & SupportMenu.CATEGORY_MASK) | (deVar.qw() & 65535);
            if ((qw4 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i2 = qw4 & 255;
            if (i2 == 88) {
                deVar.skip(4);
                return (deVar.fe() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i2 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            } else {
                deVar.skip(4);
                return (deVar.fe() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    public final boolean uk(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > qw.length;
        if (z) {
            int i3 = 0;
            while (true) {
                byte[] bArr2 = qw;
                if (i3 >= bArr2.length) {
                    break;
                } else if (bArr[i3] != bArr2[i3]) {
                    return false;
                } else {
                    i3++;
                }
            }
        }
        return z;
    }
}
