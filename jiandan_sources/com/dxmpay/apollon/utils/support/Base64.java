package com.dxmpay.apollon.utils.support;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public class Base64 {
    public static final int DECODE = 0;
    public static final int DONT_GUNZIP = 4;
    public static final int DO_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;

    /* renamed from: ad  reason: collision with root package name */
    public static final byte[] f4093ad = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, ExifInterface.WEBP_VP8L_SIGNATURE, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: de  reason: collision with root package name */
    public static final byte[] f4094de = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: fe  reason: collision with root package name */
    public static final byte[] f4095fe = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, 63, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 35, 36, 37, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, ExifInterface.WEBP_VP8L_SIGNATURE, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    public static final byte[] qw = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, ExifInterface.WEBP_VP8L_SIGNATURE};

    /* renamed from: rg  reason: collision with root package name */
    public static final byte[] f4096rg = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: th  reason: collision with root package name */
    public static final byte[] f4097th = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, ExifInterface.START_CODE, 43, 44, 45, 46, ExifInterface.WEBP_VP8L_SIGNATURE, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: yj  reason: collision with root package name */
    public static final /* synthetic */ boolean f4098yj = (!Base64.class.desiredAssertionStatus());

    public static class InputStream extends FilterInputStream {

        /* renamed from: ad  reason: collision with root package name */
        public final boolean f4099ad;

        /* renamed from: i  reason: collision with root package name */
        public final int f4100i;

        /* renamed from: if  reason: not valid java name */
        public int f156if;

        /* renamed from: o  reason: collision with root package name */
        public final byte[] f4101o;

        /* renamed from: pf  reason: collision with root package name */
        public int f4102pf;

        /* renamed from: switch  reason: not valid java name */
        public int f157switch;

        /* renamed from: th  reason: collision with root package name */
        public final byte[] f4103th;

        /* renamed from: uk  reason: collision with root package name */
        public final boolean f4104uk;

        /* renamed from: yj  reason: collision with root package name */
        public final int f4105yj;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[LOOP:1: B:13:0x0036->B:19:0x004c, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0052 A[EDGE_INSN: B:49:0x0052->B:20:0x0052 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int read() throws java.io.IOException {
            /*
                r10 = this;
                int r0 = r10.f4102pf
                r1 = -1
                r2 = 0
                if (r0 >= 0) goto L_0x006c
                boolean r0 = r10.f4099ad
                r3 = 4
                if (r0 == 0) goto L_0x0033
                r0 = 3
                byte[] r4 = new byte[r0]
                r5 = 0
                r6 = 0
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
                byte[] r7 = r10.f4103th
                r8 = 0
                int r9 = r10.f4100i
                byte[] unused = com.dxmpay.apollon.utils.support.Base64.yj(r4, r5, r6, r7, r8, r9)
                r10.f4102pf = r2
                r10.f156if = r3
                goto L_0x006c
            L_0x0032:
                return r1
            L_0x0033:
                byte[] r0 = new byte[r3]
                r4 = 0
            L_0x0036:
                if (r4 >= r3) goto L_0x0052
            L_0x0038:
                java.io.InputStream r5 = r10.in
                int r5 = r5.read()
                if (r5 < 0) goto L_0x0049
                byte[] r6 = r10.f4101o
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
                byte[] r3 = r10.f4103th
                int r4 = r10.f4100i
                int r0 = com.dxmpay.apollon.utils.support.Base64.rg(r0, r2, r3, r2, r4)
                r10.f156if = r0
                r10.f4102pf = r2
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
                int r0 = r10.f4102pf
                if (r0 < 0) goto L_0x00a1
                int r3 = r10.f156if
                if (r0 < r3) goto L_0x0075
                return r1
            L_0x0075:
                boolean r0 = r10.f4099ad
                if (r0 == 0) goto L_0x0088
                boolean r0 = r10.f4104uk
                if (r0 == 0) goto L_0x0088
                int r0 = r10.f157switch
                r3 = 76
                if (r0 < r3) goto L_0x0088
                r10.f157switch = r2
                r0 = 10
                return r0
            L_0x0088:
                int r0 = r10.f157switch
                int r0 = r0 + 1
                r10.f157switch = r0
                byte[] r0 = r10.f4103th
                int r2 = r10.f4102pf
                int r3 = r2 + 1
                r10.f4102pf = r3
                byte r0 = r0[r2]
                int r2 = r10.f4105yj
                if (r3 < r2) goto L_0x009e
                r10.f4102pf = r1
            L_0x009e:
                r0 = r0 & 255(0xff, float:3.57E-43)
                return r0
            L_0x00a1:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Error in Base64 code reading stream."
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.support.Base64.InputStream.read():int");
        }

        public InputStream(java.io.InputStream inputStream, int i2) {
            super(inputStream);
            this.f4100i = i2;
            boolean z = true;
            this.f4104uk = (i2 & 8) > 0;
            z = (i2 & 1) <= 0 ? false : z;
            this.f4099ad = z;
            int i3 = z ? 4 : 3;
            this.f4105yj = i3;
            this.f4103th = new byte[i3];
            this.f4102pf = -1;
            this.f157switch = 0;
            this.f4101o = Base64.i(i2);
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

        /* renamed from: ad  reason: collision with root package name */
        public final boolean f4106ad;

        /* renamed from: i  reason: collision with root package name */
        public final int f4107i;

        /* renamed from: if  reason: not valid java name */
        public byte[] f158if;

        /* renamed from: o  reason: collision with root package name */
        public final byte[] f4108o;

        /* renamed from: pf  reason: collision with root package name */
        public int f4109pf;

        /* renamed from: switch  reason: not valid java name */
        public int f159switch;

        /* renamed from: th  reason: collision with root package name */
        public final int f4110th;

        /* renamed from: uk  reason: collision with root package name */
        public final byte[] f4111uk;
        public boolean when;

        /* renamed from: yj  reason: collision with root package name */
        public final boolean f4112yj;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public void close() throws IOException {
            flushBase64();
            super.close();
            this.f158if = null;
            this.out = null;
        }

        public void flushBase64() throws IOException {
            int i2 = this.f4109pf;
            if (i2 <= 0) {
                return;
            }
            if (this.f4106ad) {
                java.io.OutputStream outputStream = this.out;
                byte[] bArr = this.f4111uk;
                byte[] unused = Base64.uk(bArr, this.f158if, i2, this.f4107i);
                outputStream.write(bArr);
                this.f4109pf = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void resumeEncoding() {
            this.when = false;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.when = true;
        }

        public void write(int i2) throws IOException {
            if (this.when) {
                this.out.write(i2);
            } else if (this.f4106ad) {
                byte[] bArr = this.f158if;
                int i3 = this.f4109pf;
                int i4 = i3 + 1;
                this.f4109pf = i4;
                bArr[i3] = (byte) i2;
                int i5 = this.f4110th;
                if (i4 >= i5) {
                    java.io.OutputStream outputStream = this.out;
                    byte[] bArr2 = this.f4111uk;
                    byte[] unused = Base64.uk(bArr2, bArr, i5, this.f4107i);
                    outputStream.write(bArr2);
                    int i6 = this.f159switch + 4;
                    this.f159switch = i6;
                    if (this.f4112yj && i6 >= 76) {
                        this.out.write(10);
                        this.f159switch = 0;
                    }
                    this.f4109pf = 0;
                }
            } else {
                byte[] bArr3 = this.f4108o;
                int i7 = i2 & 127;
                if (bArr3[i7] > -5) {
                    byte[] bArr4 = this.f158if;
                    int i8 = this.f4109pf;
                    int i9 = i8 + 1;
                    this.f4109pf = i9;
                    bArr4[i8] = (byte) i2;
                    if (i9 >= this.f4110th) {
                        this.out.write(this.f4111uk, 0, Base64.rg(bArr4, 0, this.f4111uk, 0, this.f4107i));
                        this.f4109pf = 0;
                    }
                } else if (bArr3[i7] != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public OutputStream(java.io.OutputStream outputStream, int i2) {
            super(outputStream);
            boolean z = true;
            this.f4112yj = (i2 & 8) != 0;
            z = (i2 & 1) == 0 ? false : z;
            this.f4106ad = z;
            int i3 = z ? 3 : 4;
            this.f4110th = i3;
            this.f158if = new byte[i3];
            this.f4109pf = 0;
            this.f159switch = 0;
            this.when = false;
            this.f4111uk = new byte[4];
            this.f4107i = i2;
            this.f4108o = Base64.i(i2);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.when) {
                this.out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }
    }

    public static class qw extends ObjectInputStream {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ ClassLoader f4113ad;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public qw(java.io.InputStream inputStream, ClassLoader classLoader) {
            super(inputStream);
            this.f4113ad = classLoader;
        }

        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, this.f4113ad);
            return cls == null ? super.resolveClass(objectStreamClass) : cls;
        }
    }

    public static byte[] decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length, 0);
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
                } catch (Exception unused) {
                }
            } catch (IOException e) {
                e = e;
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
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
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
                    } catch (IOException e) {
                        e = e;
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
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, 0, bArr2, 0, i2);
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                return bArr2;
            }
            throw new IOException("File is too big for this convenience method (" + file.length() + " bytes).");
        } catch (IOException e2) {
            e = e2;
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
                } catch (Exception unused) {
                }
            } catch (IOException e) {
                e = e;
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
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            throw e;
        }
    }

    public static Object decodeToObject(String str) throws IOException, ClassNotFoundException {
        return decodeToObject(str, 0, (ClassLoader) null);
    }

    public static void encode(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            uk(bArr2, bArr, min, 0);
            byteBuffer2.put(bArr2);
        }
    }

    public static String encodeBytes(byte[] bArr) {
        String str;
        try {
            str = encodeBytes(bArr, 0, bArr.length, 0);
        } catch (IOException e) {
            if (f4098yj) {
                str = null;
            } else {
                throw new AssertionError(e.getMessage());
            }
        }
        if (f4098yj || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static byte[] encodeBytesToBytes(byte[] bArr) {
        try {
            return encodeBytesToBytes(bArr, 0, bArr.length, 0);
        } catch (IOException e) {
            if (f4098yj) {
                return null;
            }
            throw new AssertionError("IOExceptions only come from GZipping, which is turned off: " + e.getMessage());
        }
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
                } catch (Exception unused) {
                }
            } catch (IOException e) {
                e = e;
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
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
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
                } catch (IOException e) {
                    e = e;
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
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            }
            String str2 = new String(bArr, 0, i2, "US-ASCII");
            try {
                inputStream2.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (IOException e2) {
            e = e2;
            throw e;
        }
    }

    public static String encodeObject(Serializable serializable) throws IOException {
        return encodeObject(serializable, 0);
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
                    } catch (Exception unused) {
                    }
                } catch (IOException e) {
                    e = e;
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
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                throw e;
            }
        } else {
            throw new NullPointerException("Data to encode was null.");
        }
    }

    public static final byte[] i(int i2) {
        if ((i2 & 16) == 16) {
            return f4095fe;
        }
        if ((i2 & 32) == 32) {
            return f4097th;
        }
        return f4093ad;
    }

    public static int rg(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
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
            byte[] i7 = i(i4);
            int i8 = i2 + 2;
            if (bArr[i8] == 61) {
                bArr2[i3] = (byte) ((((i7[bArr[i2 + 1]] & 255) << 12) | ((i7[bArr[i2]] & 255) << Ascii.DC2)) >>> 16);
                return 1;
            } else if (bArr[i5] == 61) {
                int i9 = (i7[bArr[i2]] & 255) << Ascii.DC2;
                int i10 = ((i7[bArr[i8]] & 255) << 6) | ((i7[bArr[i2 + 1]] & 255) << 12) | i9;
                bArr2[i3] = (byte) (i10 >>> 16);
                bArr2[i3 + 1] = (byte) (i10 >>> 8);
                return 2;
            } else {
                int i11 = (i7[bArr[i2]] & 255) << Ascii.DC2;
                byte b = (i7[bArr[i5]] & 255) | ((i7[bArr[i2 + 1]] & 255) << 12) | i11 | ((i7[bArr[i8]] & 255) << 6);
                bArr2[i3] = (byte) (b >> Ascii.DLE);
                bArr2[i3 + 1] = (byte) (b >> 8);
                bArr2[i6] = (byte) b;
                return 3;
            }
        }
    }

    public static final byte[] th(int i2) {
        if ((i2 & 16) == 16) {
            return f4094de;
        }
        if ((i2 & 32) == 32) {
            return f4096rg;
        }
        return qw;
    }

    public static byte[] uk(byte[] bArr, byte[] bArr2, int i2, int i3) {
        yj(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    public static byte[] yj(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] th2 = th(i5);
        int i6 = 0;
        int i7 = (i3 > 0 ? (bArr[i2] << Ascii.CAN) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << Ascii.CAN) >>> 16 : 0);
        if (i3 > 2) {
            i6 = (bArr[i2 + 2] << Ascii.CAN) >>> 24;
        }
        int i8 = i7 | i6;
        if (i3 == 1) {
            bArr2[i4] = th2[i8 >>> 18];
            bArr2[i4 + 1] = th2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = 61;
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 == 2) {
            bArr2[i4] = th2[i8 >>> 18];
            bArr2[i4 + 1] = th2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = th2[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = 61;
            return bArr2;
        } else if (i3 != 3) {
            return bArr2;
        } else {
            bArr2[i4] = th2[i8 >>> 18];
            bArr2[i4 + 1] = th2[(i8 >>> 12) & 63];
            bArr2[i4 + 2] = th2[(i8 >>> 6) & 63];
            bArr2[i4 + 3] = th2[i8 & 63];
            return bArr2;
        }
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
                byte[] i6 = i(i4);
                byte[] bArr2 = new byte[((i3 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i7 = 0;
                int i8 = 0;
                while (i2 < i5) {
                    byte b = i6[bArr[i2] & 255];
                    if (b >= -5) {
                        if (b >= -1) {
                            int i9 = i7 + 1;
                            bArr3[i7] = bArr[i2];
                            if (i9 > 3) {
                                i8 += rg(bArr3, 0, bArr2, i8, i4);
                                if (bArr[i2] == 61) {
                                    break;
                                }
                                i7 = 0;
                            } else {
                                i7 = i9;
                            }
                        }
                        i2++;
                    } else {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[]{Integer.valueOf(bArr[i2] & 255), Integer.valueOf(i2)}));
                    }
                }
                byte[] bArr4 = new byte[i8];
                System.arraycopy(bArr2, 0, bArr4, 0, i8);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i3);
        }
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.ObjectInputStream] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:14|15|30|31|32|33|34) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|(2:4|5)(1:6)|7|8|9|10|11|12) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x003c */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object decodeToObject(java.lang.String r1, int r2, java.lang.ClassLoader r3) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            byte[] r1 = decode(r1, r2)
            r2 = 0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0035, ClassNotFoundException -> 0x0032, all -> 0x002f }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0035, ClassNotFoundException -> 0x0032, all -> 0x002f }
            if (r3 != 0) goto L_0x0012
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
            goto L_0x0017
        L_0x0012:
            com.dxmpay.apollon.utils.support.Base64$qw r1 = new com.dxmpay.apollon.utils.support.Base64$qw     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
            r1.<init>(r0, r3)     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
        L_0x0017:
            r2 = r1
            java.lang.Object r1 = r2.readObject()     // Catch:{ IOException -> 0x002b, ClassNotFoundException -> 0x0027, all -> 0x0023 }
            r0.close()     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            r2.close()     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            return r1
        L_0x0023:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0039
        L_0x0027:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0034
        L_0x002b:
            r1 = move-exception
            r3 = r2
            r2 = r0
            goto L_0x0037
        L_0x002f:
            r1 = move-exception
            r3 = r2
            goto L_0x0039
        L_0x0032:
            r1 = move-exception
            r3 = r2
        L_0x0034:
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x0035:
            r1 = move-exception
            r3 = r2
        L_0x0037:
            throw r1     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r1 = move-exception
        L_0x0039:
            r2.close()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            r3.close()     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.support.Base64.decodeToObject(java.lang.String, int, java.lang.ClassLoader):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.io.ObjectOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:13|51|52|53|54|55|56|57|58|59) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:4|5|6|(5:8|9|10|11|12)(3:16|17|18)|19|20|21|22|23|24|25|26|27|28|29|30|31) */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:2|3|4|5|6|(5:8|9|10|11|12)(3:16|17|18)|19|20|21|22|23|24|25|26|27|28|29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0053, code lost:
        return new java.lang.String(r1.toByteArray());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0038 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x007d */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String encodeObject(java.io.Serializable r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0081
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r1.<init>()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            com.dxmpay.apollon.utils.support.Base64$OutputStream r2 = new com.dxmpay.apollon.utils.support.Base64$OutputStream     // Catch:{ IOException -> 0x0060, all -> 0x005c }
            r3 = r6 | 1
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x0060, all -> 0x005c }
            r6 = r6 & 2
            if (r6 == 0) goto L_0x0027
            java.util.zip.GZIPOutputStream r6 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            java.io.ObjectOutputStream r3 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r3.<init>(r6)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0 = r3
            goto L_0x002f
        L_0x001f:
            r5 = move-exception
            goto L_0x0074
        L_0x0022:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x006f
        L_0x0027:
            java.io.ObjectOutputStream r6 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x0057, all -> 0x0054 }
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x002f:
            r0.writeObject(r5)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r0.close()     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            r6.close()     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            r2.close()     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            r1.close()     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            java.lang.String r5 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x004a }
            byte[] r6 = r1.toByteArray()     // Catch:{ UnsupportedEncodingException -> 0x004a }
            java.lang.String r0 = "US-ASCII"
            r5.<init>(r6, r0)     // Catch:{ UnsupportedEncodingException -> 0x004a }
            return r5
        L_0x004a:
            java.lang.String r5 = new java.lang.String
            byte[] r6 = r1.toByteArray()
            r5.<init>(r6)
            return r5
        L_0x0054:
            r5 = move-exception
            r6 = r0
            goto L_0x0074
        L_0x0057:
            r5 = move-exception
            r6 = r0
            r0 = r1
            r1 = r6
            goto L_0x006f
        L_0x005c:
            r5 = move-exception
            r6 = r0
            r2 = r6
            goto L_0x0074
        L_0x0060:
            r5 = move-exception
            r6 = r0
            r2 = r6
            r0 = r1
            r1 = r2
            goto L_0x006f
        L_0x0066:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
            goto L_0x0074
        L_0x006b:
            r5 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
        L_0x006f:
            throw r5     // Catch:{ all -> 0x0070 }
        L_0x0070:
            r5 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0074:
            r0.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r6.close()     // Catch:{ Exception -> 0x007a }
        L_0x007a:
            r2.close()     // Catch:{ Exception -> 0x007d }
        L_0x007d:
            r1.close()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            throw r5
        L_0x0081:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Cannot serialize a null object."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.support.Base64.encodeObject(java.io.Serializable, int):java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v21 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:31|32|45|46|47|48|49|50|51) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x005b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x005e */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] encodeBytesToBytes(byte[] r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            r0 = r18
            r7 = r19
            r8 = r20
            if (r0 == 0) goto L_0x0121
            if (r7 < 0) goto L_0x010a
            if (r8 < 0) goto L_0x00f3
            int r1 = r7 + r8
            int r2 = r0.length
            r9 = 1
            if (r1 > r2) goto L_0x00cf
            r1 = r21 & 2
            if (r1 == 0) goto L_0x0062
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0051, all -> 0x004d }
            r2.<init>()     // Catch:{ IOException -> 0x0051, all -> 0x004d }
            com.dxmpay.apollon.utils.support.Base64$OutputStream r3 = new com.dxmpay.apollon.utils.support.Base64$OutputStream     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            r4 = r21 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0042, all -> 0x0040 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0042, all -> 0x0040 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            r3.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r2.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x003c:
            r0 = move-exception
            goto L_0x0057
        L_0x003e:
            r0 = move-exception
            goto L_0x004b
        L_0x0040:
            r0 = move-exception
            goto L_0x0058
        L_0x0042:
            r0 = move-exception
            r4 = r1
            goto L_0x004b
        L_0x0045:
            r0 = move-exception
            r3 = r1
            goto L_0x0058
        L_0x0048:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x004b:
            r1 = r2
            goto L_0x0054
        L_0x004d:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x0058
        L_0x0051:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x0054:
            throw r0     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
            r2 = r1
        L_0x0057:
            r1 = r4
        L_0x0058:
            r1.close()     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            r3.close()     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            r2.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            throw r0
        L_0x0062:
            r1 = r21 & 8
            if (r1 == 0) goto L_0x0068
            r11 = 1
            goto L_0x0069
        L_0x0068:
            r11 = 0
        L_0x0069:
            int r1 = r8 / 3
            r12 = 4
            int r1 = r1 * 4
            int r2 = r8 % 3
            if (r2 <= 0) goto L_0x0074
            r2 = 4
            goto L_0x0075
        L_0x0074:
            r2 = 0
        L_0x0075:
            int r1 = r1 + r2
            if (r11 == 0) goto L_0x007b
            int r2 = r1 / 76
            int r1 = r1 + r2
        L_0x007b:
            r13 = r1
            byte[] r14 = new byte[r13]
            int r15 = r8 + -2
            r6 = 0
            r16 = 0
            r17 = 0
        L_0x0085:
            if (r6 >= r15) goto L_0x00af
            int r2 = r6 + r7
            r3 = 3
            r1 = r18
            r4 = r14
            r5 = r16
            r10 = r6
            r6 = r21
            yj(r1, r2, r3, r4, r5, r6)
            int r1 = r17 + 4
            if (r11 == 0) goto L_0x00a8
            r2 = 76
            if (r1 < r2) goto L_0x00a8
            int r1 = r16 + 4
            r2 = 10
            r14[r1] = r2
            int r16 = r16 + 1
            r17 = 0
            goto L_0x00aa
        L_0x00a8:
            r17 = r1
        L_0x00aa:
            int r6 = r10 + 3
            int r16 = r16 + 4
            goto L_0x0085
        L_0x00af:
            r10 = r6
            if (r10 >= r8) goto L_0x00c2
            int r2 = r10 + r7
            int r3 = r8 - r10
            r1 = r18
            r4 = r14
            r5 = r16
            r6 = r21
            yj(r1, r2, r3, r4, r5, r6)
            int r16 = r16 + 4
        L_0x00c2:
            r0 = r16
            int r13 = r13 - r9
            if (r0 > r13) goto L_0x00ce
            byte[] r1 = new byte[r0]
            r2 = 0
            java.lang.System.arraycopy(r14, r2, r1, r2, r0)
            return r1
        L_0x00ce:
            return r14
        L_0x00cf:
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
        L_0x00f3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have length offset: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x010a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have negative offset: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0121:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Cannot serialize a null array."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.support.Base64.encodeBytesToBytes(byte[], int, int, int):byte[]");
    }

    public static String encodeBytes(byte[] bArr, int i2) throws IOException {
        return encodeBytes(bArr, 0, bArr.length, i2);
    }

    public static void encode(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        byte[] bArr = new byte[3];
        byte[] bArr2 = new byte[4];
        while (byteBuffer.hasRemaining()) {
            int min = Math.min(3, byteBuffer.remaining());
            byteBuffer.get(bArr, 0, min);
            uk(bArr2, bArr, min, 0);
            for (int i2 = 0; i2 < 4; i2++) {
                charBuffer.put((char) (bArr2[i2] & 255));
            }
        }
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3) {
        String str;
        try {
            str = encodeBytes(bArr, i2, i3, 0);
        } catch (IOException e) {
            if (f4098yj) {
                str = null;
            } else {
                throw new AssertionError(e.getMessage());
            }
        }
        if (f4098yj || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3, int i4) throws IOException {
        byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i2, i3, i4);
        try {
            return new String(encodeBytesToBytes, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(encodeBytesToBytes);
        }
    }

    public static byte[] decode(String str) throws IOException {
        return decode(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:16|17|18|19|20|(6:21|22|(3:23|24|(1:26)(1:68))|27|28|29)|30|31|32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:55|56|57|58|59|60|61|62) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x008c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x008f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] decode(java.lang.String r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0094
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0009 }
            goto L_0x000d
        L_0x0009:
            byte[] r5 = r5.getBytes()
        L_0x000d:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = decode(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L_0x001a
            r6 = 1
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            if (r5 == 0) goto L_0x0093
            int r3 = r5.length
            if (r3 < r0) goto L_0x0093
            if (r6 != 0) goto L_0x0093
            byte r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L_0x0093
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            r2.<init>()     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x006f, all -> 0x006a }
            r3.<init>(r5)     // Catch:{ IOException -> 0x006f, all -> 0x006a }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        L_0x0048:
            int r0 = r4.read(r6)     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            if (r0 < 0) goto L_0x0052
            r2.write(r6, r1, r0)     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            goto L_0x0048
        L_0x0052:
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            r2.close()     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            r4.close()     // Catch:{ Exception -> 0x005c }
        L_0x005c:
            r3.close()     // Catch:{ Exception -> 0x0093 }
            goto L_0x0093
        L_0x0060:
            r5 = move-exception
            goto L_0x006d
        L_0x0062:
            r6 = move-exception
            goto L_0x0072
        L_0x0064:
            r5 = move-exception
            r4 = r0
            goto L_0x006d
        L_0x0067:
            r6 = move-exception
            r4 = r0
            goto L_0x0072
        L_0x006a:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L_0x006d:
            r0 = r2
            goto L_0x0089
        L_0x006f:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x0072:
            r0 = r2
            goto L_0x007b
        L_0x0074:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x0089
        L_0x0078:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x007b:
            java.lang.String r1 = "Base64"
            java.lang.String r2 = r6.getMessage()     // Catch:{ all -> 0x0088 }
            com.dxmpay.wallet.core.utils.LogUtil.e(r1, r2, r6)     // Catch:{ all -> 0x0088 }
            r0.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x0059
        L_0x0088:
            r5 = move-exception
        L_0x0089:
            r0.close()     // Catch:{ Exception -> 0x008c }
        L_0x008c:
            r4.close()     // Catch:{ Exception -> 0x008f }
        L_0x008f:
            r3.close()     // Catch:{ Exception -> 0x0092 }
        L_0x0092:
            throw r5
        L_0x0093:
            return r5
        L_0x0094:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.support.Base64.decode(java.lang.String, int):byte[]");
    }
}
