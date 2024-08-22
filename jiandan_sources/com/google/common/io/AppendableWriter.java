package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
public class AppendableWriter extends Writer {
    public boolean closed;
    public final Appendable target;

    public AppendableWriter(Appendable appendable) {
        this.target = (Appendable) Preconditions.checkNotNull(appendable);
    }

    private void checkNotClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    public void close() throws IOException {
        this.closed = true;
        Appendable appendable = this.target;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    public void flush() throws IOException {
        checkNotClosed();
        Appendable appendable = this.target;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public void write(char[] cArr, int i2, int i3) throws IOException {
        checkNotClosed();
        this.target.append(new String(cArr, i2, i3));
    }

    public void write(int i2) throws IOException {
        checkNotClosed();
        this.target.append((char) i2);
    }

    public Writer append(char c) throws IOException {
        checkNotClosed();
        this.target.append(c);
        return this;
    }

    public void write(@NullableDecl String str) throws IOException {
        checkNotClosed();
        this.target.append(str);
    }

    public Writer append(@NullableDecl CharSequence charSequence) throws IOException {
        checkNotClosed();
        this.target.append(charSequence);
        return this;
    }

    public void write(@NullableDecl String str, int i2, int i3) throws IOException {
        checkNotClosed();
        this.target.append(str, i2, i3 + i2);
    }

    public Writer append(@NullableDecl CharSequence charSequence, int i2, int i3) throws IOException {
        checkNotClosed();
        this.target.append(charSequence, i2, i3);
        return this;
    }
}
