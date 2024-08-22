package com.itextpdf.text.io;

import java.io.IOException;

public interface RandomAccessSource {
    int ad(long j) throws IOException;

    void close() throws IOException;

    long length();

    int qw(long j, byte[] bArr, int i2, int i3) throws IOException;
}
