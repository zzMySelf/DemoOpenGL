package org.apache.commons.codec.binary4util.bdapp;

import android.annotation.SuppressLint;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64;

@SuppressLint({"BDThrowableCheck"})
@Deprecated
public class Base64InputStream extends FilterInputStream {
    public static final int BUFFER_SIZE = 2048;
    public static byte[] EMPTY = new byte[0];
    public final Base64.Coder coder;
    public boolean eof;
    public byte[] inputBuffer;
    public int outputEnd;
    public int outputStart;

    public Base64InputStream(InputStream inputStream, int i2) {
        this(inputStream, i2, false);
    }

    private void refill() throws IOException {
        boolean z;
        if (!this.eof) {
            int read = this.in.read(this.inputBuffer);
            if (read == -1) {
                this.eof = true;
                z = this.coder.process(EMPTY, 0, 0, true);
            } else {
                z = this.coder.process(this.inputBuffer, 0, read, false);
            }
            if (z) {
                this.outputEnd = this.coder.op;
                this.outputStart = 0;
                return;
            }
            throw new IOException("bad base-64");
        }
    }

    public int available() {
        return this.outputEnd - this.outputStart;
    }

    public void close() throws IOException {
        this.in.close();
        this.inputBuffer = null;
    }

    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        if (this.outputStart >= this.outputEnd) {
            refill();
        }
        int i2 = this.outputStart;
        if (i2 >= this.outputEnd) {
            return -1;
        }
        byte[] bArr = this.coder.output;
        this.outputStart = i2 + 1;
        return bArr[i2] & 255;
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) throws IOException {
        if (this.outputStart >= this.outputEnd) {
            refill();
        }
        int i2 = this.outputStart;
        int i3 = this.outputEnd;
        if (i2 >= i3) {
            return 0;
        }
        long min = Math.min(j, (long) (i3 - i2));
        this.outputStart = (int) (((long) this.outputStart) + min);
        return min;
    }

    public Base64InputStream(InputStream inputStream, int i2, boolean z) {
        super(inputStream);
        this.eof = false;
        this.inputBuffer = new byte[2048];
        if (z) {
            this.coder = new Base64.Encoder(i2, (byte[]) null);
        } else {
            this.coder = new Base64.Decoder(i2, (byte[]) null);
        }
        Base64.Coder coder2 = this.coder;
        coder2.output = new byte[coder2.maxOutputSize(2048)];
        this.outputStart = 0;
        this.outputEnd = 0;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.outputStart >= this.outputEnd) {
            refill();
        }
        int i4 = this.outputStart;
        int i5 = this.outputEnd;
        if (i4 >= i5) {
            return -1;
        }
        int min = Math.min(i3, i5 - i4);
        System.arraycopy(this.coder.output, this.outputStart, bArr, i2, min);
        this.outputStart += min;
        return min;
    }
}
