package com.baidu.swan.apps.core.prefetch.image.interceptor;

import com.baidu.swan.utils.SwanAppFileUtils;
import java.io.IOException;
import java.io.InputStream;

final class WebResInputStreamWrapper extends InputStream {
    private InputStream srcInputStream;
    private TempFileWriter tempFileWriter;

    WebResInputStreamWrapper(InputStream srcInputStream2, TempFileWriter tempFileWriter2) {
        this.srcInputStream = srcInputStream2;
        this.tempFileWriter = tempFileWriter2;
    }

    public int available() throws IOException {
        return this.srcInputStream.available();
    }

    public void close() throws IOException {
        super.close();
        this.tempFileWriter.write(this.srcInputStream);
        this.tempFileWriter.close();
        SwanAppFileUtils.closeSafely(this.srcInputStream);
    }

    public void mark(int readLimit) {
        super.mark(readLimit);
        this.srcInputStream.mark(readLimit);
    }

    public boolean markSupported() {
        return this.srcInputStream.markSupported();
    }

    public int read(byte[] buffer) throws IOException {
        int count = this.srcInputStream.read(buffer);
        this.tempFileWriter.write(buffer, 0, count);
        return count;
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int count = this.srcInputStream.read(buffer, byteOffset, byteCount);
        this.tempFileWriter.write(buffer, byteOffset, count);
        return count;
    }

    public int read() throws IOException {
        return this.srcInputStream.read();
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.srcInputStream.reset();
    }

    public long skip(long byteCount) throws IOException {
        this.srcInputStream.skip(byteCount);
        return super.skip(byteCount);
    }
}
