package com.baidu.searchbox.feed.tts.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    /* access modifiers changed from: private */
    public final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public StrictLineReader(InputStream in2, Charset charset2) {
        this(in2, 8192, charset2);
    }

    public StrictLineReader(InputStream in2, int capacity, Charset charset2) {
        if (in2 == null || charset2 == null) {
            throw new NullPointerException();
        } else if (capacity < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset2.equals(Util.US_ASCII)) {
            this.in = in2;
            this.charset = charset2;
            this.buf = new byte[capacity];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 8 */
    public String readLine() throws IOException {
        int i2;
        byte[] bArr;
        synchronized (this.in) {
            if (this.buf != null) {
                if (this.pos >= this.end) {
                    fillBuf();
                }
                int i3 = this.pos;
                while (i3 != this.end) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i3] == 10) {
                        int lineEnd = (i3 == this.pos || bArr2[i3 + -1] != 13) ? i3 : i3 - 1;
                        byte[] bArr3 = this.buf;
                        int i4 = this.pos;
                        String res = new String(bArr3, i4, lineEnd - i4, this.charset.name());
                        this.pos = i3 + 1;
                        return res;
                    }
                    i3++;
                }
                ByteArrayOutputStream out = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                    public String toString() {
                        try {
                            return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, StrictLineReader.this.charset.name());
                        } catch (UnsupportedEncodingException e2) {
                            throw new AssertionError(e2);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr4 = this.buf;
                    int i5 = this.pos;
                    out.write(bArr4, i5, this.end - i5);
                    this.end = -1;
                    fillBuf();
                    i2 = this.pos;
                    while (i2 != this.end) {
                        bArr = this.buf;
                        if (bArr[i2] == 10) {
                            break loop1;
                        }
                        i2++;
                    }
                }
                int i6 = this.pos;
                if (i2 != i6) {
                    out.write(bArr, i6, i2 - i6);
                }
                this.pos = i2 + 1;
                String byteArrayOutputStream = out.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    private void fillBuf() throws IOException {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int result = inputStream.read(bArr, 0, bArr.length);
        if (result != -1) {
            this.pos = 0;
            this.end = result;
            return;
        }
        throw new EOFException();
    }
}
