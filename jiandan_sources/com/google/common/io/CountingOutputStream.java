package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@GwtIncompatible
@Beta
public final class CountingOutputStream extends FilterOutputStream {
    public long count;

    public CountingOutputStream(OutputStream outputStream) {
        super((OutputStream) Preconditions.checkNotNull(outputStream));
    }

    public void close() throws IOException {
        this.out.close();
    }

    public long getCount() {
        return this.count;
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.out.write(bArr, i2, i3);
        this.count += (long) i3;
    }

    public void write(int i2) throws IOException {
        this.out.write(i2);
        this.count++;
    }
}
