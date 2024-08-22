package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

@GwtIncompatible
public final class CharSequenceReader extends Reader {
    public int mark;
    public int pos;
    public CharSequence seq;

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() throws IOException {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean hasRemaining() {
        return remaining() > 0;
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    public synchronized void close() throws IOException {
        this.seq = null;
    }

    public synchronized void mark(int i2) throws IOException {
        Preconditions.checkArgument(i2 >= 0, "readAheadLimit (%s) may not be negative", i2);
        checkOpen();
        this.mark = this.pos;
    }

    public boolean markSupported() {
        return true;
    }

    public synchronized int read(CharBuffer charBuffer) throws IOException {
        Preconditions.checkNotNull(charBuffer);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), remaining());
        for (int i2 = 0; i2 < min; i2++) {
            CharSequence charSequence = this.seq;
            int i3 = this.pos;
            this.pos = i3 + 1;
            charBuffer.put(charSequence.charAt(i3));
        }
        return min;
    }

    public synchronized boolean ready() throws IOException {
        checkOpen();
        return true;
    }

    public synchronized void reset() throws IOException {
        checkOpen();
        this.pos = this.mark;
    }

    public synchronized long skip(long j) throws IOException {
        int min;
        Preconditions.checkArgument(j >= 0, "n (%s) may not be negative", j);
        checkOpen();
        min = (int) Math.min((long) remaining(), j);
        this.pos += min;
        return (long) min;
    }

    public synchronized int read() throws IOException {
        char c;
        checkOpen();
        if (hasRemaining()) {
            CharSequence charSequence = this.seq;
            int i2 = this.pos;
            this.pos = i2 + 1;
            c = charSequence.charAt(i2);
        } else {
            c = 65535;
        }
        return c;
    }

    public synchronized int read(char[] cArr, int i2, int i3) throws IOException {
        Preconditions.checkPositionIndexes(i2, i2 + i3, cArr.length);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(i3, remaining());
        for (int i4 = 0; i4 < min; i4++) {
            CharSequence charSequence = this.seq;
            int i5 = this.pos;
            this.pos = i5 + 1;
            cArr[i2 + i4] = charSequence.charAt(i5);
        }
        return min;
    }
}
