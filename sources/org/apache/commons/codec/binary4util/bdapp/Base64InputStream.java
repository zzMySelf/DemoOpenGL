package org.apache.commons.codec.binary4util.bdapp;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import org.apache.commons.codec.binary4util.bdapp.Base64;

@Deprecated
public class Base64InputStream extends FilterInputStream {
    private static final int BUFFER_SIZE = 2048;
    private static byte[] EMPTY = new byte[0];
    private final Base64.Coder coder;
    private boolean eof;
    private byte[] inputBuffer;
    private int outputEnd;
    private int outputStart;

    public Base64InputStream(InputStream in, int flags) {
        this(in, flags, false);
    }

    public Base64InputStream(InputStream in, int flags, boolean encode) {
        super(in);
        this.eof = false;
        this.inputBuffer = new byte[2048];
        if (encode) {
            this.coder = new Base64.Encoder(flags, (byte[]) null);
        } else {
            this.coder = new Base64.Decoder(flags, (byte[]) null);
        }
        Base64.Coder coder2 = this.coder;
        coder2.output = new byte[coder2.maxOutputSize(2048)];
        this.outputStart = 0;
        this.outputEnd = 0;
    }

    public boolean markSupported() {
        return false;
    }

    public void mark(int readlimit) {
        throw new UnsupportedOperationException();
    }

    public void reset() {
        throw new UnsupportedOperationException();
    }

    public void close() throws IOException {
        this.in.close();
        this.inputBuffer = null;
    }

    public int available() {
        return this.outputEnd - this.outputStart;
    }

    public long skip(long n) throws IOException {
        if (this.outputStart >= this.outputEnd) {
            refill();
        }
        int i2 = this.outputStart;
        int i3 = this.outputEnd;
        if (i2 >= i3) {
            return 0;
        }
        long bytes = Math.min(n, (long) (i3 - i2));
        this.outputStart = (int) (((long) this.outputStart) + bytes);
        return bytes;
    }

    public int read() throws IOException {
        if (this.outputStart >= this.outputEnd) {
            refill();
        }
        if (this.outputStart >= this.outputEnd) {
            return -1;
        }
        byte[] bArr = this.coder.output;
        int i2 = this.outputStart;
        this.outputStart = i2 + 1;
        return bArr[i2] & UByte.MAX_VALUE;
    }

    public int read(byte[] b2, int off, int len) throws IOException {
        if (this.outputStart >= this.outputEnd) {
            refill();
        }
        int i2 = this.outputStart;
        int i3 = this.outputEnd;
        if (i2 >= i3) {
            return -1;
        }
        int bytes = Math.min(len, i3 - i2);
        System.arraycopy(this.coder.output, this.outputStart, b2, off, bytes);
        this.outputStart += bytes;
        return bytes;
    }

    private void refill() throws IOException {
        boolean success;
        if (!this.eof) {
            int bytesRead = this.in.read(this.inputBuffer);
            if (bytesRead == -1) {
                this.eof = true;
                success = this.coder.process(EMPTY, 0, 0, true);
            } else {
                success = this.coder.process(this.inputBuffer, 0, bytesRead, false);
            }
            if (success) {
                this.outputEnd = this.coder.op;
                this.outputStart = 0;
                return;
            }
            throw new IOException("bad base-64");
        }
    }
}
