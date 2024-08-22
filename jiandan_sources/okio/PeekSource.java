package okio;

import java.io.IOException;

public final class PeekSource implements Source {
    public final Buffer buffer;
    public boolean closed;
    public int expectedPos;
    public Segment expectedSegment;
    public long pos;
    public final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        Buffer buffer2 = bufferedSource.buffer();
        this.buffer = buffer2;
        Segment segment = buffer2.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    public void close() throws IOException {
        this.closed = true;
    }

    public long read(Buffer buffer2, long j) throws IOException {
        Segment segment;
        Segment segment2;
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (!this.closed) {
            Segment segment3 = this.expectedSegment;
            if (segment3 != null && (segment3 != (segment2 = this.buffer.head) || this.expectedPos != segment2.pos)) {
                throw new IllegalStateException("Peek source is invalid because upstream source was used");
            } else if (i2 == 0) {
                return 0;
            } else {
                if (!this.upstream.request(this.pos + 1)) {
                    return -1;
                }
                if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
                    this.expectedSegment = segment;
                    this.expectedPos = segment.pos;
                }
                long min = Math.min(j, this.buffer.size - this.pos);
                this.buffer.copyTo(buffer2, this.pos, min);
                this.pos += min;
                return min;
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
