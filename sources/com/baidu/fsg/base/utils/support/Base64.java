package com.baidu.fsg.base.utils.support;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.lockscreen.helper.SwipeGestureHelper;
import com.baidu.talos.core.archivers.tar.TarConstants;
import com.yy.transvod.player.core.NetStatManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.zip.GZIPInputStream;
import okio.Utf8;

public class Base64 {
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f11857a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final int f11858b = 76;

    /* renamed from: c  reason: collision with root package name */
    private static final byte f11859c = 61;

    /* renamed from: d  reason: collision with root package name */
    private static final byte f11860d = 10;

    /* renamed from: e  reason: collision with root package name */
    private static final String f11861e = "US-ASCII";

    /* renamed from: f  reason: collision with root package name */
    private static final byte f11862f = -5;

    /* renamed from: g  reason: collision with root package name */
    private static final byte f11863g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f11864h = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, SwipeGestureHelper.BOTTOM_SWIPE, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, SwipeGestureHelper.LEFT_SWIPE, 109, 110, 111, 112, 113, SwipeGestureHelper.RIGHT_SWIPE, 115, SwipeGestureHelper.TOP_SWIPE, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 43, 47};

    /* renamed from: i  reason: collision with root package name */
    private static final byte[] f11865i = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f11862f, f11862f, -9, -9, f11862f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f11862f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, f11859c, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, NetStatManager.ISPType.MOB, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f11866j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, SwipeGestureHelper.BOTTOM_SWIPE, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, SwipeGestureHelper.LEFT_SWIPE, 109, 110, 111, 112, 113, SwipeGestureHelper.RIGHT_SWIPE, 115, SwipeGestureHelper.TOP_SWIPE, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 45, 95};
    private static final byte[] k = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f11862f, f11862f, -9, -9, f11862f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f11862f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, f11859c, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, 26, 27, 28, 29, 30, 31, NetStatManager.ISPType.MOB, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] l = {45, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 95, 97, SwipeGestureHelper.BOTTOM_SWIPE, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, SwipeGestureHelper.LEFT_SWIPE, 109, 110, 111, 112, 113, SwipeGestureHelper.RIGHT_SWIPE, 115, SwipeGestureHelper.TOP_SWIPE, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122};
    private static final byte[] m = {-9, -9, -9, -9, -9, -9, -9, -9, -9, f11862f, f11862f, -9, -9, f11862f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, f11862f, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, Constants.GZIP_CAST_TYPE, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, NetStatManager.ISPType.MOB, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, f11859c, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static class InputStream extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f11868a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f11869b;

        /* renamed from: c  reason: collision with root package name */
        private final int f11870c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f11871d;

        /* renamed from: e  reason: collision with root package name */
        private final int f11872e;

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f11873f;

        /* renamed from: g  reason: collision with root package name */
        private int f11874g;

        /* renamed from: h  reason: collision with root package name */
        private int f11875h;

        /* renamed from: i  reason: collision with root package name */
        private int f11876i;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        public InputStream(java.io.InputStream inputStream, int i2) {
            super(inputStream);
            this.f11872e = i2;
            boolean z = true;
            this.f11871d = (i2 & 8) > 0;
            z = (i2 & 1) <= 0 ? false : z;
            this.f11868a = z;
            int i3 = z ? 4 : 3;
            this.f11870c = i3;
            this.f11869b = new byte[i3];
            this.f11874g = -1;
            this.f11876i = 0;
            this.f11873f = Base64.c(i2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[LOOP:1: B:13:0x0036->B:19:0x004c, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0052 A[EDGE_INSN: B:49:0x0052->B:20:0x0052 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r10 = this;
                int r0 = r10.f11874g
                r1 = -1
                r2 = 0
                if (r0 >= 0) goto L_0x006c
                boolean r0 = r10.f11868a
                r3 = 4
                if (r0 == 0) goto L_0x0033
                r0 = 3
                byte[] r4 = new byte[r0]
                r5 = r2
                r6 = r5
            L_0x0010:
                if (r5 >= r0) goto L_0x0022
                java.io.InputStream r7 = r10.in
                int r7 = r7.read()
                if (r7 < 0) goto L_0x0022
                byte r7 = (byte) r7
                r4[r5] = r7
                int r6 = r6 + 1
                int r5 = r5 + 1
                goto L_0x0010
            L_0x0022:
                if (r6 <= 0) goto L_0x0032
                r5 = 0
                byte[] r7 = r10.f11869b
                r8 = 0
                int r9 = r10.f11872e
                byte[] unused = com.baidu.fsg.base.utils.support.Base64.b(r4, r5, r6, r7, r8, r9)
                r10.f11874g = r2
                r10.f11875h = r3
                goto L_0x006c
            L_0x0032:
                return r1
            L_0x0033:
                byte[] r0 = new byte[r3]
                r4 = r2
            L_0x0036:
                if (r4 >= r3) goto L_0x0052
            L_0x0038:
                java.io.InputStream r5 = r10.in
                int r5 = r5.read()
                if (r5 < 0) goto L_0x0049
                byte[] r6 = r10.f11873f
                r7 = r5 & 127(0x7f, float:1.78E-43)
                byte r6 = r6[r7]
                r7 = -5
                if (r6 <= r7) goto L_0x0038
            L_0x0049:
                if (r5 >= 0) goto L_0x004c
                goto L_0x0052
            L_0x004c:
                byte r5 = (byte) r5
                r0[r4] = r5
                int r4 = r4 + 1
                goto L_0x0036
            L_0x0052:
                if (r4 != r3) goto L_0x0061
                byte[] r3 = r10.f11869b
                int r4 = r10.f11872e
                int r0 = com.baidu.fsg.base.utils.support.Base64.b(r0, r2, r3, r2, r4)
                r10.f11875h = r0
                r10.f11874g = r2
                goto L_0x006c
            L_0x0061:
                if (r4 != 0) goto L_0x0064
                return r1
            L_0x0064:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Improperly padded Base64 input."
                r0.<init>(r1)
                throw r0
            L_0x006c:
                int r0 = r10.f11874g
                if (r0 < 0) goto L_0x009f
                int r3 = r10.f11875h
                if (r0 < r3) goto L_0x0075
                return r1
            L_0x0075:
                boolean r3 = r10.f11868a
                if (r3 == 0) goto L_0x0088
                boolean r3 = r10.f11871d
                if (r3 == 0) goto L_0x0088
                int r3 = r10.f11876i
                r4 = 76
                if (r3 < r4) goto L_0x0088
                r10.f11876i = r2
                r0 = 10
                return r0
            L_0x0088:
                int r2 = r10.f11876i
                int r2 = r2 + 1
                r10.f11876i = r2
                byte[] r2 = r10.f11869b
                int r3 = r0 + 1
                r10.f11874g = r3
                byte r0 = r2[r0]
                int r2 = r10.f11870c
                if (r3 < r2) goto L_0x009c
                r10.f11874g = r1
            L_0x009c:
                r0 = r0 & 255(0xff, float:3.57E-43)
                return r0
            L_0x009f:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Error in Base64 code reading stream."
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.fsg.base.utils.support.Base64.InputStream.read():int");
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i2 + i4] = (byte) read;
                    i4++;
                } else if (i4 == 0) {
                    return -1;
                }
            }
            return i4;
        }
    }

    public static class OutputStream extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f11877a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11878b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f11879c;

        /* renamed from: d  reason: collision with root package name */
        private final byte[] f11880d;

        /* renamed from: e  reason: collision with root package name */
        private final int f11881e;

        /* renamed from: f  reason: collision with root package name */
        private final byte[] f11882f;

        /* renamed from: g  reason: collision with root package name */
        private int f11883g;

        /* renamed from: h  reason: collision with root package name */
        private byte[] f11884h;

        /* renamed from: i  reason: collision with root package name */
        private int f11885i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f11886j;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public OutputStream(java.io.OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.f11879c = (i2 & 8) != 0;
            z = (i2 & 1) == 0 ? false : z;
            this.f11877a = z;
            int i3 = z ? 3 : 4;
            this.f11878b = i3;
            this.f11884h = new byte[i3];
            this.f11883g = 0;
            this.f11885i = 0;
            this.f11886j = false;
            this.f11880d = new byte[4];
            this.f11881e = i2;
            this.f11882f = Base64.c(i2);
        }

        public void close() throws IOException {
            flushBase64();
            super.close();
            this.f11884h = null;
            this.out = null;
        }

        public void flushBase64() throws IOException {
            if (this.f11883g <= 0) {
                return;
            }
            if (this.f11877a) {
                this.out.write(Base64.b(this.f11880d, this.f11884h, this.f11883g, this.f11881e));
                this.f11883g = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void resumeEncoding() {
            this.f11886j = false;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.f11886j = true;
        }

        public void write(int i2) throws IOException {
            if (this.f11886j) {
                this.out.write(i2);
                return;
            }
            if (this.f11877a) {
                byte[] bArr = this.f11884h;
                int i3 = this.f11883g;
                int i4 = i3 + 1;
                this.f11883g = i4;
                bArr[i3] = (byte) i2;
                if (i4 >= this.f11878b) {
                    this.out.write(Base64.b(this.f11880d, this.f11884h, this.f11878b, this.f11881e));
                    int i5 = this.f11885i + 4;
                    this.f11885i = i5;
                    if (this.f11879c && i5 >= 76) {
                        this.out.write(10);
                        this.f11885i = 0;
                    }
                } else {
                    return;
                }
            } else {
                byte b2 = this.f11882f[i2 & 127];
                if (b2 > -5) {
                    byte[] bArr2 = this.f11884h;
                    int i6 = this.f11883g;
                    int i7 = i6 + 1;
                    this.f11883g = i7;
                    bArr2[i6] = (byte) i2;
                    if (i7 >= this.f11878b) {
                        this.out.write(this.f11880d, 0, Base64.b(bArr2, 0, this.f11880d, 0, this.f11881e));
                    } else {
                        return;
                    }
                } else if (b2 != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                } else {
                    return;
                }
            }
            this.f11883g = 0;
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.f11886j) {
                this.out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }

    private Base64() {
    }

    /* access modifiers changed from: private */
    public static int b(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int i6;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        } else if (i2 < 0 || (i5 = i2 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2)}));
        } else if (i3 < 0 || (i6 = i3 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i3)}));
        } else {
            byte[] c2 = c(i4);
            byte b2 = bArr[i2 + 2];
            if (b2 == 61) {
                bArr2[i3] = (byte) ((((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18)) >>> 16);
                return 1;
            }
            byte b3 = bArr[i5];
            if (b3 == 61) {
                int i7 = ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18) | ((c2[b2] & 255) << 6);
                bArr2[i3] = (byte) (i7 >>> 16);
                bArr2[i3 + 1] = (byte) (i7 >>> 8);
                return 2;
            }
            byte b4 = ((c2[bArr[i2 + 1]] & 255) << 12) | ((c2[bArr[i2]] & 255) << 18) | ((c2[b2] & 255) << 6) | (c2[b3] & 255);
            bArr2[i3] = (byte) (b4 >> 16);
            bArr2[i3 + 1] = (byte) (b4 >> 8);
            bArr2[i6] = (byte) b4;
            return 3;
        }
    }

    private static final byte[] b(int i2) {
        return (i2 & 16) == 16 ? f11866j : (i2 & 32) == 32 ? l : f11864h;
    }

    /* access modifiers changed from: private */
    public static byte[] b(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] b2 = b(i5);
        int i6 = 0;
        int i7 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0);
        if (i3 > 2) {
            i6 = (bArr[i2 + 2] << 24) >>> 24;
        }
        int i8 = i7 | i6;
        switch (i3) {
            case 1:
                bArr2[i4] = b2[i8 >>> 18];
                bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = f11859c;
                bArr2[i4 + 3] = f11859c;
                return bArr2;
            case 2:
                bArr2[i4] = b2[i8 >>> 18];
                bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = b2[(i8 >>> 6) & 63];
                bArr2[i4 + 3] = f11859c;
                return bArr2;
            case 3:
                bArr2[i4] = b2[i8 >>> 18];
                bArr2[i4 + 1] = b2[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = b2[(i8 >>> 6) & 63];
                bArr2[i4 + 3] = b2[i8 & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    /* access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        b(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    /* access modifiers changed from: private */
    public static final byte[] c(int i2) {
        return (i2 & 16) == 16 ? k : (i2 & 32) == 32 ? m : f11865i;
    }

    public static byte[] decode(String str) throws IOException {
        return decode(str, 0);
    }

    public static byte[] decode(String str, int i2) throws IOException {
        byte[] bArr;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        if (str != null) {
            try {
                bArr = str.getBytes("US-ASCII");
            } catch (UnsupportedEncodingException e2) {
                bArr = str.getBytes();
            }
            byte[] decode = decode(bArr, 0, bArr.length, i2);
            boolean z = (i2 & 4) != 0;
            if (decode != null && decode.length >= 4 && !z && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & 65280))) {
                byte[] bArr2 = new byte[2048];
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(decode);
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        try {
                            e.printStackTrace();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e4) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e5) {
                            }
                            byteArrayInputStream.close();
                            return decode;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e6) {
                            }
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e7) {
                            }
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception e8) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        throw th;
                    }
                    try {
                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                        while (true) {
                            try {
                                int read = gZIPInputStream.read(bArr2);
                                if (read < 0) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, read);
                            } catch (IOException e9) {
                                e = e9;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                e.printStackTrace();
                                byteArrayOutputStream.close();
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                return decode;
                            } catch (Throwable th4) {
                                th = th4;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                byteArrayOutputStream.close();
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                throw th;
                            }
                        }
                        decode = byteArrayOutputStream2.toByteArray();
                        try {
                            byteArrayOutputStream2.close();
                        } catch (Exception e10) {
                        }
                        try {
                            gZIPInputStream.close();
                        } catch (Exception e11) {
                        }
                    } catch (IOException e12) {
                        e = e12;
                        gZIPInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        e.printStackTrace();
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return decode;
                    } catch (Throwable th5) {
                        th = th5;
                        gZIPInputStream = null;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        throw th;
                    }
                } catch (IOException e13) {
                    e = e13;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                    e.printStackTrace();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return decode;
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    throw th;
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception e14) {
                }
            }
            return decode;
        }
        throw new NullPointerException("Input string was null.");
    }

    public static byte[] decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length, 0);
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) throws IOException {
        int i5;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        } else if (i2 < 0 || (i5 = i2 + i3) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        } else if (i3 == 0) {
            return new byte[0];
        } else {
            if (i3 >= 4) {
                byte[] c2 = c(i4);
                byte[] bArr2 = new byte[((i3 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i6 = 0;
                int i7 = 0;
                while (i2 < i5) {
                    byte b2 = bArr[i2];
                    byte b3 = c2[b2 & 255];
                    if (b3 >= -5) {
                        if (b3 >= -1) {
                            int i8 = i6 + 1;
                            bArr3[i6] = b2;
                            if (i8 > 3) {
                                i7 += b(bArr3, 0, bArr2, i7, i4);
                                if (bArr[i2] == 61) {
                                    break;
                                }
                                i6 = 0;
                            } else {
                                i6 = i8;
                            }
                        }
                        i2++;
                    } else {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[]{Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)}));
                    }
                }
                byte[] bArr4 = new byte[i7];
                System.arraycopy(bArr2, 0, bArr4, 0, i7);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
    }

    public static void decodeFileToFile(String str, String str2) throws IOException {
        byte[] decodeFromFile = decodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(decodeFromFile);
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            throw e;
        }
    }

    public static byte[] decodeFromFile(String str) throws IOException {
        InputStream inputStream = null;
        try {
            File file = new File(str);
            if (file.length() <= 2147483647L) {
                byte[] bArr = new byte[((int) file.length())];
                InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
                int i2 = 0;
                while (true) {
                    try {
                        int read = inputStream2.read(bArr, i2, 4096);
                        if (read < 0) {
                            break;
                        }
                        i2 += read;
                    } catch (IOException e2) {
                        e = e2;
                        inputStream = inputStream2;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = inputStream2;
                        try {
                            inputStream.close();
                        } catch (Exception e3) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    inputStream2.close();
                } catch (Exception e4) {
                }
                return bArr2;
            }
            throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
        } catch (IOException e5) {
            e = e5;
            throw e;
        }
    }

    public static void decodeToFile(String str, String str2) throws IOException {
        OutputStream outputStream = null;
        try {
            OutputStream outputStream2 = new OutputStream(new FileOutputStream(str2), 0);
            try {
                outputStream2.write(str.getBytes("US-ASCII"));
                try {
                    outputStream2.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                e = e3;
                outputStream = outputStream2;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                try {
                    outputStream.close();
                } catch (Exception e4) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            throw e;
        }
    }

    public static Object decodeToObject(String str) throws IOException, ClassNotFoundException {
        return decodeToObject(str, 0, (ClassLoader) null);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.ObjectInputStream] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object decodeToObject(java.lang.String r1, int r2, final java.lang.ClassLoader r3) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            byte[] r1 = decode(r1, r2)
            r2 = 0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0039, ClassNotFoundException -> 0x0036, all -> 0x0033 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0039, ClassNotFoundException -> 0x0036, all -> 0x0033 }
            if (r3 != 0) goto L_0x0012
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002b, all -> 0x0027 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002b, all -> 0x0027 }
            goto L_0x0017
        L_0x0012:
            com.baidu.fsg.base.utils.support.Base64$1 r1 = new com.baidu.fsg.base.utils.support.Base64$1     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002b, all -> 0x0027 }
            r1.<init>(r0, r3)     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002b, all -> 0x0027 }
        L_0x0017:
            r2 = r1
            java.lang.Object r1 = r2.readObject()     // Catch:{ IOException -> 0x002f, ClassNotFoundException -> 0x002b, all -> 0x0027 }
            r0.close()     // Catch:{ Exception -> 0x0020 }
            goto L_0x0021
        L_0x0020:
            r3 = move-exception
        L_0x0021:
            r2.close()     // Catch:{ Exception -> 0x0025 }
            goto L_0x0026
        L_0x0025:
            r2 = move-exception
        L_0x0026:
            return r1
        L_0x0027:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x003d
        L_0x002b:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0038
        L_0x002f:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x003b
        L_0x0033:
            r1 = move-exception
            r3 = r2
            goto L_0x003d
        L_0x0036:
            r1 = move-exception
            r3 = r2
        L_0x0038:
            throw r1     // Catch:{ all -> 0x003c }
        L_0x0039:
            r1 = move-exception
            r3 = r2
        L_0x003b:
            throw r1     // Catch:{ all -> 0x003c }
        L_0x003c:
            r1 = move-exception
        L_0x003d:
            r2.close()     // Catch:{ Exception -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r2 = move-exception
        L_0x0042:
            r3.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x0047
        L_0x0046:
            r2 = move-exception
        L_0x0047:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.fsg.base.utils.support.Base64.decodeToObject(java.lang.String, int, java.lang.ClassLoader):java.lang.Object");
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            b(bArr2, bArr, min, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & 255));
            }
        }
    }

    public static String encodeBytes(byte[] bArr) {
        String str;
        try {
            str = encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (f11857a) {
                str = null;
            } else {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (f11857a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String encodeBytes(byte[] bArr, int i2) throws IOException {
        return encodeBytes(bArr, 0, bArr.length, i2);
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3) {
        String str;
        try {
            str = encodeBytes(bArr, i2, i3, 0);
        } catch (IOException e2) {
            if (f11857a) {
                str = null;
            } else {
                throw new AssertionError(e2.getMessage());
            }
        }
        if (f11857a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i2, i3, i4);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            return new String(encodeBytesToBytes);
        }
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        try {
            return encodeBytesToBytes(bArr, 0, bArr.length, 0);
        } catch (IOException e2) {
            if (f11857a) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e2.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] encodeBytesToBytes(byte[] r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            r0 = r18
            r7 = r19
            r8 = r20
            if (r0 == 0) goto L_0x0133
            if (r7 < 0) goto L_0x011a
            if (r8 < 0) goto L_0x0101
            int r1 = r7 + r8
            int r2 = r0.length
            r9 = 1
            if (r1 > r2) goto L_0x00dd
            r1 = r21 & 2
            if (r1 == 0) goto L_0x0071
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0059, all -> 0x0054 }
            r2.<init>()     // Catch:{ IOException -> 0x0059, all -> 0x0054 }
            com.baidu.fsg.base.utils.support.Base64$OutputStream r3 = new com.baidu.fsg.base.utils.support.Base64$OutputStream     // Catch:{ IOException -> 0x004f, all -> 0x004b }
            r4 = r21 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x004f, all -> 0x004b }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
            r4.close()     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
            r4.close()     // Catch:{ Exception -> 0x0032 }
            goto L_0x0033
        L_0x0032:
            r0 = move-exception
        L_0x0033:
            r3.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x0038
        L_0x0037:
            r0 = move-exception
        L_0x0038:
            r2.close()     // Catch:{ Exception -> 0x003c }
            goto L_0x003d
        L_0x003c:
            r0 = move-exception
        L_0x003d:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x0042:
            r0 = move-exception
            goto L_0x005f
        L_0x0044:
            r0 = move-exception
            goto L_0x0052
        L_0x0046:
            r0 = move-exception
            goto L_0x0060
        L_0x0048:
            r0 = move-exception
            r4 = r1
            goto L_0x0052
        L_0x004b:
            r0 = move-exception
            r4 = r0
            r3 = r1
            goto L_0x0061
        L_0x004f:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x0052:
            r1 = r2
            goto L_0x005c
        L_0x0054:
            r0 = move-exception
            r4 = r0
            r2 = r1
            r3 = r2
            goto L_0x0061
        L_0x0059:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x005c:
            throw r0     // Catch:{ all -> 0x005d }
        L_0x005d:
            r0 = move-exception
            r2 = r1
        L_0x005f:
            r1 = r4
        L_0x0060:
            r4 = r0
        L_0x0061:
            r1.close()     // Catch:{ Exception -> 0x0065 }
            goto L_0x0066
        L_0x0065:
            r0 = move-exception
        L_0x0066:
            r3.close()     // Catch:{ Exception -> 0x006a }
            goto L_0x006b
        L_0x006a:
            r0 = move-exception
        L_0x006b:
            r2.close()     // Catch:{ Exception -> 0x006f }
            goto L_0x0070
        L_0x006f:
            r0 = move-exception
        L_0x0070:
            throw r4
        L_0x0071:
            r1 = r21 & 8
            if (r1 == 0) goto L_0x0077
            r11 = r9
            goto L_0x0078
        L_0x0077:
            r11 = 0
        L_0x0078:
            int r1 = r8 / 3
            r12 = 4
            int r1 = r1 * r12
            int r2 = r8 % 3
            if (r2 <= 0) goto L_0x0082
            r2 = r12
            goto L_0x0083
        L_0x0082:
            r2 = 0
        L_0x0083:
            int r1 = r1 + r2
            if (r11 == 0) goto L_0x0089
            int r2 = r1 / 76
            int r1 = r1 + r2
        L_0x0089:
            r13 = r1
            byte[] r14 = new byte[r13]
            int r15 = r8 + -2
            r6 = 0
            r16 = 0
            r17 = 0
        L_0x0093:
            if (r6 >= r15) goto L_0x00bd
            int r2 = r6 + r7
            r3 = 3
            r1 = r18
            r4 = r14
            r5 = r16
            r10 = r6
            r6 = r21
            b(r1, r2, r3, r4, r5, r6)
            int r1 = r17 + 4
            if (r11 == 0) goto L_0x00b6
            r2 = 76
            if (r1 < r2) goto L_0x00b6
            int r1 = r16 + 4
            r2 = 10
            r14[r1] = r2
            int r16 = r16 + 1
            r17 = 0
            goto L_0x00b8
        L_0x00b6:
            r17 = r1
        L_0x00b8:
            int r6 = r10 + 3
            int r16 = r16 + 4
            goto L_0x0093
        L_0x00bd:
            r10 = r6
            if (r10 >= r8) goto L_0x00d0
            int r2 = r10 + r7
            int r3 = r8 - r10
            r1 = r18
            r4 = r14
            r5 = r16
            r6 = r21
            b(r1, r2, r3, r4, r5, r6)
            int r16 = r16 + 4
        L_0x00d0:
            r0 = r16
            int r13 = r13 - r9
            if (r0 > r13) goto L_0x00dc
            byte[] r1 = new byte[r0]
            r2 = 0
            java.lang.System.arraycopy(r14, r2, r1, r2, r0)
            return r1
        L_0x00dc:
            return r14
        L_0x00dd:
            r2 = 0
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            r3[r2] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r3[r9] = r2
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 2
            r3[r2] = r0
            java.lang.String r0 = "Cannot have offset of %d and length of %d with array of length %d"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r1.<init>(r0)
            throw r1
        L_0x0101:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have length offset: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x011a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have negative offset: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0133:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Cannot serialize a null array."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.fsg.base.utils.support.Base64.encodeBytesToBytes(byte[], int, int, int):byte[]");
    }

    public static void encodeFileToFile(String str, String str2) throws IOException {
        String encodeFromFile = encodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str2));
            try {
                bufferedOutputStream2.write(encodeFromFile.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            throw e;
        }
    }

    public static String encodeFromFile(String str) throws IOException {
        InputStream inputStream = null;
        try {
            File file = new File(str);
            byte[] bArr = new byte[Math.max((int) ((((double) file.length()) * 1.4d) + 1.0d), 40)];
            InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
            int i2 = 0;
            while (true) {
                try {
                    int read = inputStream2.read(bArr, i2, 4096);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                } catch (IOException e2) {
                    e = e2;
                    inputStream = inputStream2;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i2, "US-ASCII");
            try {
                inputStream2.close();
            } catch (Exception e4) {
            }
            return str2;
        } catch (IOException e5) {
            e = e5;
            throw e;
        }
    }

    public static String encodeObject(Serializable serializable) throws IOException {
        return encodeObject(serializable, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.io.ObjectOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encodeObject(java.io.Serializable r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0093
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0075, all -> 0x0070 }
            r1.<init>()     // Catch:{ IOException -> 0x0075, all -> 0x0070 }
            com.baidu.fsg.base.utils.support.Base64$OutputStream r2 = new com.baidu.fsg.base.utils.support.Base64$OutputStream     // Catch:{ IOException -> 0x006a, all -> 0x0066 }
            r3 = r6 | 1
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x006a, all -> 0x0066 }
            r6 = r6 & 2
            if (r6 == 0) goto L_0x0028
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0 = r3
            goto L_0x0030
        L_0x001f:
            r5 = move-exception
            goto L_0x007e
        L_0x0022:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0079
        L_0x0028:
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x0030:
            r0.writeObject(r5)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0.close()     // Catch:{ Exception -> 0x0037 }
            goto L_0x0038
        L_0x0037:
            r5 = move-exception
        L_0x0038:
            r6.close()     // Catch:{ Exception -> 0x003c }
            goto L_0x003d
        L_0x003c:
            r5 = move-exception
        L_0x003d:
            r2.close()     // Catch:{ Exception -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r5 = move-exception
        L_0x0042:
            r1.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x0047
        L_0x0046:
            r5 = move-exception
        L_0x0047:
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0053 }
            byte[] r6 = r1.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x0053 }
            java.lang.String r0 = "US-ASCII"
            r5.<init>(r6, r0)     // Catch:{ UnsupportedEncodingException -> 0x0053 }
            return r5
        L_0x0053:
            r5 = move-exception
            java.lang.String r5 = new java.lang.String
            byte[] r6 = r1.toByteArray()
            r5.<init>(r6)
            return r5
        L_0x005e:
            r5 = move-exception
            r6 = r0
            goto L_0x007e
        L_0x0061:
            r5 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x0079
        L_0x0066:
            r5 = move-exception
            r6 = r0
            r2 = r6
            goto L_0x007e
        L_0x006a:
            r5 = move-exception
            r6 = r0
            r2 = r6
            r0 = r1
            r1 = r2
            goto L_0x0079
        L_0x0070:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
            goto L_0x007e
        L_0x0075:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
        L_0x0079:
            throw r5     // Catch:{ all -> 0x007a }
        L_0x007a:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x007e:
            r0.close()     // Catch:{ Exception -> 0x0082 }
            goto L_0x0083
        L_0x0082:
            r0 = move-exception
        L_0x0083:
            r6.close()     // Catch:{ Exception -> 0x0087 }
            goto L_0x0088
        L_0x0087:
            r6 = move-exception
        L_0x0088:
            r2.close()     // Catch:{ Exception -> 0x008c }
            goto L_0x008d
        L_0x008c:
            r6 = move-exception
        L_0x008d:
            r1.close()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0092
        L_0x0091:
            r6 = move-exception
        L_0x0092:
            throw r5
        L_0x0093:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Cannot serialize a null object."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.fsg.base.utils.support.Base64.encodeObject(java.io.Serializable, int):java.lang.String");
    }

    public static void encodeToFile(byte[] bArr, String str) throws IOException {
        if (bArr != null) {
            OutputStream outputStream = null;
            try {
                OutputStream outputStream2 = new OutputStream(new FileOutputStream(str), 1);
                try {
                    outputStream2.write(bArr);
                    try {
                        outputStream2.close();
                    } catch (Exception e2) {
                    }
                } catch (IOException e3) {
                    e = e3;
                    outputStream = outputStream2;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = outputStream2;
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                throw e;
            }
        } else {
            throw new NullPointerException("Data to encode was null.");
        }
    }
}
