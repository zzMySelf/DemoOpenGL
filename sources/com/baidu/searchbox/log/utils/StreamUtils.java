package com.baidu.searchbox.log.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public abstract class StreamUtils {
    public static final int BUFFER_SIZE = 4096;
    private static final byte[] EMPTY_CONTENT = new byte[0];

    public static byte[] copyToByteArray(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(4096);
        copy(in, (OutputStream) out);
        return out.toByteArray();
    }

    public static String copyToString(InputStream in, Charset charset) throws IOException {
        StringBuilder out = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(in, charset);
        char[] buffer = new char[4096];
        while (true) {
            int read = reader.read(buffer);
            int bytesRead = read;
            if (read == -1) {
                return out.toString();
            }
            out.append(buffer, 0, bytesRead);
        }
    }

    public static void copy(byte[] in, OutputStream out) throws IOException {
        out.write(in);
    }

    public static void copy(String in, Charset charset, OutputStream out) throws IOException {
        Writer writer = new OutputStreamWriter(out, charset);
        writer.write(in);
        writer.flush();
    }

    public static int copy(InputStream in, OutputStream out) throws IOException {
        int byteCount = 0;
        byte[] buffer = new byte[4096];
        while (true) {
            int read = in.read(buffer);
            int bytesRead = read;
            if (read != -1) {
                out.write(buffer, 0, bytesRead);
                byteCount += bytesRead;
            } else {
                out.flush();
                return byteCount;
            }
        }
    }

    public static int drain(InputStream in) throws IOException {
        byte[] buffer = new byte[4096];
        int byteCount = 0;
        while (true) {
            int read = in.read(buffer);
            int bytesRead = read;
            if (read == -1) {
                return byteCount;
            }
            byteCount += bytesRead;
        }
    }

    public static InputStream emptyInput() {
        return new ByteArrayInputStream(EMPTY_CONTENT);
    }

    public static InputStream nonClosing(InputStream in) {
        return new NonClosingInputStream(in);
    }

    public static OutputStream nonClosing(OutputStream out) {
        return new NonClosingOutputStream(out);
    }

    private static class NonClosingInputStream extends FilterInputStream {
        public NonClosingInputStream(InputStream in) {
            super(in);
        }

        public void close() throws IOException {
        }
    }

    private static class NonClosingOutputStream extends FilterOutputStream {
        public NonClosingOutputStream(OutputStream out) {
            super(out);
        }

        public void write(byte[] b2, int off, int let) throws IOException {
            this.out.write(b2, off, let);
        }

        public void close() throws IOException {
        }
    }
}
