package com.dxmbumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.uk.qw.vvv.i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser implements ImageHeaderParser {

    /* renamed from: ad  reason: collision with root package name */
    public static final int[] f3881ad = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    public static final byte[] qw = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    public interface Reader {

        public static final class EndOfFileException extends IOException {
            public static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int ad(byte[] bArr, int i2) throws IOException;

        short de() throws IOException;

        int qw() throws IOException;

        long skip(long j) throws IOException;
    }

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

    public static final class de implements Reader {
        public final InputStream qw;

        public de(InputStream inputStream) {
            this.qw = inputStream;
        }

        public int ad(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.qw.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 != 0 || i4 != -1) {
                return i3;
            }
            throw new Reader.EndOfFileException();
        }

        public short de() throws IOException {
            int read = this.qw.read();
            if (read != -1) {
                return (short) read;
            }
            throw new Reader.EndOfFileException();
        }

        public int qw() throws IOException {
            return (de() << 8) | de();
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

    public static final class qw implements Reader {
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

        public short de() throws Reader.EndOfFileException {
            if (this.qw.remaining() >= 1) {
                return (short) (this.qw.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        public int qw() throws Reader.EndOfFileException {
            return (de() << 8) | de();
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
                        int i3 = ad3 + f3881ad[qw5];
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
        i.fe(inputStream);
        return th(new de(inputStream));
    }

    public int de(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        i.fe(inputStream);
        de deVar = new de(inputStream);
        i.fe(arrayPool);
        return rg(deVar, arrayPool);
    }

    public final int i(Reader reader) throws IOException {
        short de2;
        int qw2;
        long j;
        long skip;
        do {
            short de3 = reader.de();
            if (de3 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    "Unknown segmentId=" + de3;
                }
                return -1;
            }
            de2 = reader.de();
            if (de2 == 218) {
                return -1;
            }
            if (de2 == 217) {
                boolean isLoggable = Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            qw2 = reader.qw() - 2;
            if (de2 == 225) {
                return qw2;
            }
            j = (long) qw2;
            skip = reader.skip(j);
        } while (skip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            "Unable to skip enough data, type: " + de2 + ", wanted to skip: " + qw2 + ", but actually skipped: " + skip;
        }
        return -1;
    }

    public final int pf(Reader reader, byte[] bArr, int i2) throws IOException {
        int ad2 = reader.ad(bArr, i2);
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
        i.fe(byteBuffer);
        return th(new qw(byteBuffer));
    }

    public final int rg(Reader reader, ArrayPool arrayPool) throws IOException {
        byte[] bArr;
        try {
            int qw2 = reader.qw();
            if (!yj(qw2)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    "Parser doesn't handle magic number: " + qw2;
                }
                return -1;
            }
            int i2 = i(reader);
            if (i2 == -1) {
                boolean isLoggable = Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            bArr = (byte[]) arrayPool.de(i2, byte[].class);
            int pf2 = pf(reader, bArr, i2);
            arrayPool.put(bArr);
            return pf2;
        } catch (Reader.EndOfFileException unused) {
            return -1;
        } catch (Throwable th2) {
            arrayPool.put(bArr);
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.dxmbumptech.glide.load.ImageHeaderParser.ImageType th(com.dxmbumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader r6) throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r6.qw()     // Catch:{ EndOfFileException -> 0x00a0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r6.de()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r6.de()     // Catch:{ EndOfFileException -> 0x00a0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.de()     // Catch:{ EndOfFileException -> 0x0039 }
            r0 = 3
            if (r6 < r0) goto L_0x0036
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ EndOfFileException -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x0039 }
        L_0x0038:
            return r6
        L_0x0039:
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0044
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0044:
            r0 = 4
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r6.qw()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.qw()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x005c
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x005c:
            int r2 = r6.qw()     // Catch:{ EndOfFileException -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r6.qw()     // Catch:{ EndOfFileException -> 0x00a0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x0071
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x0071:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0088
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.de()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 16
            if (r6 == 0) goto L_0x0085
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x0087
        L_0x0085:
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x0087:
            return r6
        L_0x0088:
            r3 = 76
            if (r2 != r3) goto L_0x009d
            r6.skip(r0)     // Catch:{ EndOfFileException -> 0x00a0 }
            short r6 = r6.de()     // Catch:{ EndOfFileException -> 0x00a0 }
            r6 = r6 & 8
            if (r6 == 0) goto L_0x009a
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ EndOfFileException -> 0x00a0 }
            goto L_0x009c
        L_0x009a:
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
        L_0x009c:
            return r6
        L_0x009d:
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ EndOfFileException -> 0x00a0 }
            return r6
        L_0x00a0:
            com.dxmbumptech.glide.load.ImageHeaderParser$ImageType r6 = com.dxmbumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmbumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.th(com.dxmbumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader):com.dxmbumptech.glide.load.ImageHeaderParser$ImageType");
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
