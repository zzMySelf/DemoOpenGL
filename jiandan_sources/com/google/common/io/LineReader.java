package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
@Beta
public final class LineReader {
    public final char[] buf;
    public final CharBuffer cbuf;
    public final LineBuffer lineBuf = new LineBuffer() {
        public void handleLine(String str, String str2) {
            LineReader.this.lines.add(str);
        }
    };
    public final Queue<String> lines = new LinkedList();
    public final Readable readable;
    @NullableDecl
    public final Reader reader;

    public LineReader(Readable readable2) {
        CharBuffer createBuffer = CharStreams.createBuffer();
        this.cbuf = createBuffer;
        this.buf = createBuffer.array();
        this.readable = (Readable) Preconditions.checkNotNull(readable2);
        this.reader = readable2 instanceof Reader ? (Reader) readable2 : null;
    }

    @CanIgnoreReturnValue
    public String readLine() throws IOException {
        int i2;
        while (true) {
            if (this.lines.peek() != null) {
                break;
            }
            this.cbuf.clear();
            Reader reader2 = this.reader;
            if (reader2 != null) {
                char[] cArr = this.buf;
                i2 = reader2.read(cArr, 0, cArr.length);
            } else {
                i2 = this.readable.read(this.cbuf);
            }
            if (i2 == -1) {
                this.lineBuf.finish();
                break;
            }
            this.lineBuf.add(this.buf, 0, i2);
        }
        return this.lines.poll();
    }
}
