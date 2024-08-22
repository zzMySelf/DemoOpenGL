package org.apache.commons.codec.binary4util.bdapp;

import android.annotation.SuppressLint;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64;

@SuppressLint({"BDThrowableCheck"})
@Deprecated
public class Base64OutputStream extends FilterOutputStream {
    public static byte[] EMPTY = new byte[0];
    public int bpos;
    public byte[] buffer;
    public final Base64.Coder coder;
    public final int flags;

    public Base64OutputStream(OutputStream outputStream, int i2) {
        this(outputStream, i2, true);
    }

    private byte[] embiggen(byte[] bArr, int i2) {
        if (bArr == null || bArr.length < i2) {
            return new byte[i2];
        }
        return bArr;
    }

    private void flushBuffer() throws IOException {
        int i2 = this.bpos;
        if (i2 > 0) {
            internalWrite(this.buffer, 0, i2, false);
            this.bpos = 0;
        }
    }

    private void internalWrite(byte[] bArr, int i2, int i3, boolean z) throws IOException {
        Base64.Coder coder2 = this.coder;
        coder2.output = embiggen(coder2.output, coder2.maxOutputSize(i3));
        if (this.coder.process(bArr, i2, i3, z)) {
            OutputStream outputStream = this.out;
            Base64.Coder coder3 = this.coder;
            outputStream.write(coder3.output, 0, coder3.op);
            return;
        }
        throw new IOException("bad base-64");
    }

    public void close() throws IOException {
        try {
            flushBuffer();
            internalWrite(EMPTY, 0, 0, true);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        try {
            if ((this.flags & 16) == 0) {
                this.out.close();
            } else {
                this.out.flush();
            }
        } catch (IOException e2) {
            if (e != null) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public void write(int i2) throws IOException {
        if (this.buffer == null) {
            this.buffer = new byte[1024];
        }
        int i3 = this.bpos;
        byte[] bArr = this.buffer;
        if (i3 >= bArr.length) {
            internalWrite(bArr, 0, i3, false);
            this.bpos = 0;
        }
        byte[] bArr2 = this.buffer;
        int i4 = this.bpos;
        this.bpos = i4 + 1;
        bArr2[i4] = (byte) i2;
    }

    public Base64OutputStream(OutputStream outputStream, int i2, boolean z) {
        super(outputStream);
        this.buffer = null;
        this.bpos = 0;
        this.flags = i2;
        if (z) {
            this.coder = new Base64.Encoder(i2, (byte[]) null);
        } else {
            this.coder = new Base64.Decoder(i2, (byte[]) null);
        }
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 > 0) {
            flushBuffer();
            internalWrite(bArr, i2, i3, false);
        }
    }
}
