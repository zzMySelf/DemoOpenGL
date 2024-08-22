package org.apache.commons.codec.binary4util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary4util.BaseNCodec;

public class BaseNCodecOutputStream extends FilterOutputStream {
    private final BaseNCodec baseNCodec;
    private final BaseNCodec.Context context = new BaseNCodec.Context();
    private final boolean doEncode;
    private final byte[] singleByte = new byte[1];

    public BaseNCodecOutputStream(OutputStream out, BaseNCodec basedCodec, boolean doEncode2) {
        super(out);
        this.baseNCodec = basedCodec;
        this.doEncode = doEncode2;
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.singleByte;
        bArr[0] = (byte) i2;
        write(bArr, 0, 1);
    }

    public void write(byte[] b2, int offset, int len) throws IOException {
        if (b2 == null) {
            throw new NullPointerException();
        } else if (offset < 0 || len < 0) {
            throw new IndexOutOfBoundsException();
        } else if (offset > b2.length || offset + len > b2.length) {
            throw new IndexOutOfBoundsException();
        } else if (len > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(b2, offset, len, this.context);
            } else {
                this.baseNCodec.decode(b2, offset, len, this.context);
            }
            flush(false);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = new byte[r0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void flush(boolean r6) throws java.io.IOException {
        /*
            r5 = this;
            org.apache.commons.codec.binary4util.BaseNCodec r0 = r5.baseNCodec
            org.apache.commons.codec.binary4util.BaseNCodec$Context r1 = r5.context
            int r0 = r0.available(r1)
            if (r0 <= 0) goto L_0x001c
            byte[] r1 = new byte[r0]
            org.apache.commons.codec.binary4util.BaseNCodec r2 = r5.baseNCodec
            org.apache.commons.codec.binary4util.BaseNCodec$Context r3 = r5.context
            r4 = 0
            int r2 = r2.readResults(r1, r4, r0, r3)
            if (r2 <= 0) goto L_0x001c
            java.io.OutputStream r3 = r5.out
            r3.write(r1, r4, r2)
        L_0x001c:
            if (r6 == 0) goto L_0x0023
            java.io.OutputStream r1 = r5.out
            r1.flush()
        L_0x0023:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary4util.BaseNCodecOutputStream.flush(boolean):void");
    }

    public void flush() throws IOException {
        flush(true);
    }

    public void close() throws IOException {
        eof();
        flush();
        this.out.close();
    }

    public void eof() throws IOException {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
        }
    }
}
