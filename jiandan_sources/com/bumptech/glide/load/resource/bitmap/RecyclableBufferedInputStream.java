package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {

    /* renamed from: ad  reason: collision with root package name */
    public volatile byte[] f3726ad;

    /* renamed from: i  reason: collision with root package name */
    public int f3727i;

    /* renamed from: o  reason: collision with root package name */
    public final ArrayPool f3728o;

    /* renamed from: th  reason: collision with root package name */
    public int f3729th;

    /* renamed from: uk  reason: collision with root package name */
    public int f3730uk;

    /* renamed from: yj  reason: collision with root package name */
    public int f3731yj;

    public static class InvalidMarkException extends IOException {
        public static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) {
        this(inputStream, arrayPool, 65536);
    }

    public static IOException fe() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f3726ad == null || inputStream == null) {
            fe();
            throw null;
        }
        return (this.f3729th - this.f3727i) + inputStream.available();
    }

    public void close() throws IOException {
        if (this.f3726ad != null) {
            this.f3728o.put(this.f3726ad);
            this.f3726ad = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void de() {
        this.f3731yj = this.f3726ad.length;
    }

    public synchronized void mark(int i2) {
        this.f3731yj = Math.max(this.f3731yj, i2);
        this.f3730uk = this.f3727i;
    }

    public boolean markSupported() {
        return true;
    }

    public final int qw(InputStream inputStream, byte[] bArr) throws IOException {
        int i2;
        int i3 = this.f3730uk;
        if (i3 == -1 || this.f3727i - i3 >= (i2 = this.f3731yj)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.f3730uk = -1;
                this.f3727i = 0;
                this.f3729th = read;
            }
            return read;
        }
        if (i3 == 0 && i2 > bArr.length && this.f3729th == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i2) {
                i2 = length;
            }
            byte[] bArr2 = (byte[]) this.f3728o.de(i2, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f3726ad = bArr2;
            this.f3728o.put(bArr);
            bArr = bArr2;
        } else {
            int i4 = this.f3730uk;
            if (i4 > 0) {
                System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
            }
        }
        int i5 = this.f3727i - this.f3730uk;
        this.f3727i = i5;
        this.f3730uk = 0;
        this.f3729th = 0;
        int read2 = inputStream.read(bArr, i5, bArr.length - i5);
        int i6 = this.f3727i;
        if (read2 > 0) {
            i6 += read2;
        }
        this.f3729th = i6;
        return read2;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0026=Splitter:B:19:0x0026, B:11:0x0019=Splitter:B:11:0x0019, B:28:0x003b=Splitter:B:28:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f3726ad     // Catch:{ all -> 0x003f }
            java.io.InputStream r1 = r6.in     // Catch:{ all -> 0x003f }
            r2 = 0
            if (r0 == 0) goto L_0x003b
            if (r1 == 0) goto L_0x003b
            int r3 = r6.f3727i     // Catch:{ all -> 0x003f }
            int r4 = r6.f3729th     // Catch:{ all -> 0x003f }
            r5 = -1
            if (r3 < r4) goto L_0x0019
            int r1 = r6.qw(r1, r0)     // Catch:{ all -> 0x003f }
            if (r1 != r5) goto L_0x0019
            monitor-exit(r6)
            return r5
        L_0x0019:
            byte[] r1 = r6.f3726ad     // Catch:{ all -> 0x003f }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r6.f3726ad     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            fe()     // Catch:{ all -> 0x003f }
            throw r2
        L_0x0026:
            int r1 = r6.f3729th     // Catch:{ all -> 0x003f }
            int r2 = r6.f3727i     // Catch:{ all -> 0x003f }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0039
            int r1 = r6.f3727i     // Catch:{ all -> 0x003f }
            int r2 = r1 + 1
            r6.f3727i = r2     // Catch:{ all -> 0x003f }
            byte r0 = r0[r1]     // Catch:{ all -> 0x003f }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r6)
            return r0
        L_0x0039:
            monitor-exit(r6)
            return r5
        L_0x003b:
            fe()     // Catch:{ all -> 0x003f }
            throw r2
        L_0x003f:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read():int");
    }

    public synchronized void release() {
        if (this.f3726ad != null) {
            this.f3728o.put(this.f3726ad);
            this.f3726ad = null;
        }
    }

    public synchronized void reset() throws IOException {
        if (this.f3726ad == null) {
            throw new IOException("Stream is closed");
        } else if (-1 != this.f3730uk) {
            this.f3727i = this.f3730uk;
        } else {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f3727i + " markLimit: " + this.f3731yj);
        }
    }

    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0;
        }
        byte[] bArr = this.f3726ad;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                fe();
                throw null;
            } else if (((long) (this.f3729th - this.f3727i)) >= j) {
                this.f3727i = (int) (((long) this.f3727i) + j);
                return j;
            } else {
                long j2 = ((long) this.f3729th) - ((long) this.f3727i);
                this.f3727i = this.f3729th;
                if (this.f3730uk == -1 || j > ((long) this.f3731yj)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (qw(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    if (((long) (this.f3729th - this.f3727i)) >= j - j2) {
                        this.f3727i = (int) ((((long) this.f3727i) + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + ((long) this.f3729th)) - ((long) this.f3727i);
                    this.f3727i = this.f3729th;
                    return j3;
                }
            }
        } else {
            fe();
            throw null;
        }
    }

    @VisibleForTesting
    public RecyclableBufferedInputStream(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool, int i2) {
        super(inputStream);
        this.f3730uk = -1;
        this.f3728o = arrayPool;
        this.f3726ad = (byte[]) arrayPool.de(i2, byte[].class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0051, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x005e, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(@androidx.annotation.NonNull byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f3726ad     // Catch:{ all -> 0x009c }
            r1 = 0
            if (r0 == 0) goto L_0x0098
            if (r9 != 0) goto L_0x000b
            r7 = 0
            monitor-exit(r6)
            return r7
        L_0x000b:
            java.io.InputStream r2 = r6.in     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x0094
            int r3 = r6.f3727i     // Catch:{ all -> 0x009c }
            int r4 = r6.f3729th     // Catch:{ all -> 0x009c }
            if (r3 >= r4) goto L_0x003c
            int r3 = r6.f3729th     // Catch:{ all -> 0x009c }
            int r4 = r6.f3727i     // Catch:{ all -> 0x009c }
            int r3 = r3 - r4
            if (r3 < r9) goto L_0x001e
            r3 = r9
            goto L_0x0023
        L_0x001e:
            int r3 = r6.f3729th     // Catch:{ all -> 0x009c }
            int r4 = r6.f3727i     // Catch:{ all -> 0x009c }
            int r3 = r3 - r4
        L_0x0023:
            int r4 = r6.f3727i     // Catch:{ all -> 0x009c }
            java.lang.System.arraycopy(r0, r4, r7, r8, r3)     // Catch:{ all -> 0x009c }
            int r4 = r6.f3727i     // Catch:{ all -> 0x009c }
            int r4 = r4 + r3
            r6.f3727i = r4     // Catch:{ all -> 0x009c }
            if (r3 == r9) goto L_0x003a
            int r4 = r2.available()     // Catch:{ all -> 0x009c }
            if (r4 != 0) goto L_0x0036
            goto L_0x003a
        L_0x0036:
            int r8 = r8 + r3
            int r3 = r9 - r3
            goto L_0x003d
        L_0x003a:
            monitor-exit(r6)
            return r3
        L_0x003c:
            r3 = r9
        L_0x003d:
            int r4 = r6.f3730uk     // Catch:{ all -> 0x009c }
            r5 = -1
            if (r4 != r5) goto L_0x0052
            int r4 = r0.length     // Catch:{ all -> 0x009c }
            if (r3 < r4) goto L_0x0052
            int r4 = r2.read(r7, r8, r3)     // Catch:{ all -> 0x009c }
            if (r4 != r5) goto L_0x0084
            if (r3 != r9) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            int r5 = r9 - r3
        L_0x0050:
            monitor-exit(r6)
            return r5
        L_0x0052:
            int r4 = r6.qw(r2, r0)     // Catch:{ all -> 0x009c }
            if (r4 != r5) goto L_0x005f
            if (r3 != r9) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            int r5 = r9 - r3
        L_0x005d:
            monitor-exit(r6)
            return r5
        L_0x005f:
            byte[] r4 = r6.f3726ad     // Catch:{ all -> 0x009c }
            if (r0 == r4) goto L_0x006c
            byte[] r0 = r6.f3726ad     // Catch:{ all -> 0x009c }
            if (r0 == 0) goto L_0x0068
            goto L_0x006c
        L_0x0068:
            fe()     // Catch:{ all -> 0x009c }
            throw r1
        L_0x006c:
            int r4 = r6.f3729th     // Catch:{ all -> 0x009c }
            int r5 = r6.f3727i     // Catch:{ all -> 0x009c }
            int r4 = r4 - r5
            if (r4 < r3) goto L_0x0075
            r4 = r3
            goto L_0x007a
        L_0x0075:
            int r4 = r6.f3729th     // Catch:{ all -> 0x009c }
            int r5 = r6.f3727i     // Catch:{ all -> 0x009c }
            int r4 = r4 - r5
        L_0x007a:
            int r5 = r6.f3727i     // Catch:{ all -> 0x009c }
            java.lang.System.arraycopy(r0, r5, r7, r8, r4)     // Catch:{ all -> 0x009c }
            int r5 = r6.f3727i     // Catch:{ all -> 0x009c }
            int r5 = r5 + r4
            r6.f3727i = r5     // Catch:{ all -> 0x009c }
        L_0x0084:
            int r3 = r3 - r4
            if (r3 != 0) goto L_0x0089
            monitor-exit(r6)
            return r9
        L_0x0089:
            int r5 = r2.available()     // Catch:{ all -> 0x009c }
            if (r5 != 0) goto L_0x0092
            int r9 = r9 - r3
            monitor-exit(r6)
            return r9
        L_0x0092:
            int r8 = r8 + r4
            goto L_0x003d
        L_0x0094:
            fe()     // Catch:{ all -> 0x009c }
            throw r1
        L_0x0098:
            fe()     // Catch:{ all -> 0x009c }
            throw r1
        L_0x009c:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read(byte[], int, int):int");
    }
}
