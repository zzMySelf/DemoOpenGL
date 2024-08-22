package com.baidu.talos.core.archivers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

public class FixedLengthBlockOutputStream extends OutputStream implements WritableByteChannel {
    private final int blockSize;
    private final ByteBuffer buffer;
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final WritableByteChannel out;

    public FixedLengthBlockOutputStream(OutputStream os, int blockSize2) {
        if (os instanceof FileOutputStream) {
            this.out = ((FileOutputStream) os).getChannel();
            this.buffer = ByteBuffer.allocateDirect(blockSize2);
        } else {
            this.out = new BufferAtATimeOutputChannel(os);
            this.buffer = ByteBuffer.allocate(blockSize2);
        }
        this.blockSize = blockSize2;
    }

    public FixedLengthBlockOutputStream(WritableByteChannel out2, int blockSize2) {
        this.out = out2;
        this.blockSize = blockSize2;
        this.buffer = ByteBuffer.allocateDirect(blockSize2);
    }

    private void maybeFlush() throws IOException {
        if (!this.buffer.hasRemaining()) {
            writeBlock();
        }
    }

    private void writeBlock() throws IOException {
        this.buffer.flip();
        int i2 = this.out.write(this.buffer);
        boolean hasRemaining = this.buffer.hasRemaining();
        int i3 = this.blockSize;
        if (i2 != i3 || hasRemaining) {
            throw new IOException(String.format("Failed to write %,d bytes atomically. Only wrote  %,d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)}));
        } else {
            this.buffer.clear();
        }
    }

    public void write(int b2) throws IOException {
        if (isOpen()) {
            this.buffer.put((byte) b2);
            maybeFlush();
            return;
        }
        throw new ClosedChannelException();
    }

    public void write(byte[] b2, int offset, int length) throws IOException {
        if (isOpen()) {
            int off = offset;
            int len = length;
            while (len > 0) {
                int n = Math.min(len, this.buffer.remaining());
                this.buffer.put(b2, off, n);
                maybeFlush();
                len -= n;
                off += n;
            }
            return;
        }
        throw new ClosedChannelException();
    }

    public int write(ByteBuffer src) throws IOException {
        if (isOpen()) {
            int srcRemaining = src.remaining();
            if (srcRemaining < this.buffer.remaining()) {
                this.buffer.put(src);
            } else {
                int srcLeft = srcRemaining;
                int savedLimit = src.limit();
                if (this.buffer.position() != 0) {
                    int n = this.buffer.remaining();
                    src.limit(src.position() + n);
                    this.buffer.put(src);
                    writeBlock();
                    srcLeft -= n;
                }
                while (srcLeft >= this.blockSize) {
                    src.limit(src.position() + this.blockSize);
                    this.out.write(src);
                    srcLeft -= this.blockSize;
                }
                src.limit(savedLimit);
                this.buffer.put(src);
            }
            return srcRemaining;
        }
        throw new ClosedChannelException();
    }

    public boolean isOpen() {
        if (!this.out.isOpen()) {
            this.closed.set(true);
        }
        return !this.closed.get();
    }

    public void flushBlock() throws IOException {
        if (this.buffer.position() != 0) {
            padBlock();
            writeBlock();
        }
    }

    public void close() throws IOException {
        if (this.closed.compareAndSet(false, true)) {
            try {
                flushBlock();
            } finally {
                this.out.close();
            }
        }
    }

    private void padBlock() {
        this.buffer.order(ByteOrder.nativeOrder());
        int bytesToWrite = this.buffer.remaining();
        if (bytesToWrite > 8) {
            int align = this.buffer.position() & 7;
            if (align != 0) {
                int limit = 8 - align;
                for (int i2 = 0; i2 < limit; i2++) {
                    this.buffer.put((byte) 0);
                }
                bytesToWrite -= limit;
            }
            while (bytesToWrite >= 8) {
                this.buffer.putLong(0);
                bytesToWrite -= 8;
            }
        }
        while (this.buffer.hasRemaining()) {
            this.buffer.put((byte) 0);
        }
    }

    private static class BufferAtATimeOutputChannel implements WritableByteChannel {
        private final AtomicBoolean closed;
        private final OutputStream out;

        private BufferAtATimeOutputChannel(OutputStream out2) {
            this.closed = new AtomicBoolean(false);
            this.out = out2;
        }

        public int write(ByteBuffer buffer) throws IOException {
            if (!isOpen()) {
                throw new ClosedChannelException();
            } else if (buffer.hasArray()) {
                try {
                    int pos = buffer.position();
                    int len = buffer.limit() - pos;
                    this.out.write(buffer.array(), buffer.arrayOffset() + pos, len);
                    buffer.position(buffer.limit());
                    return len;
                } catch (IOException e2) {
                    try {
                        close();
                    } catch (IOException e3) {
                    }
                    throw e2;
                }
            } else {
                throw new IllegalArgumentException("direct buffer somehow written to BufferAtATimeOutputChannel");
            }
        }

        public boolean isOpen() {
            return !this.closed.get();
        }

        public void close() throws IOException {
            if (this.closed.compareAndSet(false, true)) {
                this.out.close();
            }
        }
    }
}
