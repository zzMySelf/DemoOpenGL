package com.meizu.x;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f5373a = Logger.getLogger(g.class.getName());

    class a implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f5374a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ OutputStream f5375b;

        a(n nVar, OutputStream outputStream) {
            this.f5374a = nVar;
            this.f5375b = outputStream;
        }

        public void a(b bVar, long j2) throws IOException {
            o.a(bVar.f5365b, 0, j2);
            while (j2 > 0) {
                this.f5374a.a();
                j jVar = bVar.f5364a;
                int min = (int) Math.min(j2, (long) (jVar.f5387c - jVar.f5386b));
                this.f5375b.write(jVar.f5385a, jVar.f5386b, min);
                int i2 = jVar.f5386b + min;
                jVar.f5386b = i2;
                long j3 = (long) min;
                j2 -= j3;
                bVar.f5365b -= j3;
                if (i2 == jVar.f5387c) {
                    bVar.f5364a = jVar.b();
                    k.a(jVar);
                }
            }
        }

        public void close() throws IOException {
            this.f5375b.close();
        }

        public void flush() throws IOException {
            this.f5375b.flush();
        }

        public String toString() {
            return "sink(" + this.f5375b + ")";
        }
    }

    class b implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n f5376a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ InputStream f5377b;

        b(n nVar, InputStream inputStream) {
            this.f5376a = nVar;
            this.f5377b = inputStream;
        }

        public long b(b bVar, long j2) throws IOException {
            int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (i2 == 0) {
                return 0;
            } else {
                this.f5376a.a();
                j a2 = bVar.a(1);
                int read = this.f5377b.read(a2.f5385a, a2.f5387c, (int) Math.min(j2, (long) (2048 - a2.f5387c)));
                if (read == -1) {
                    return -1;
                }
                a2.f5387c += read;
                long j3 = (long) read;
                bVar.f5365b += j3;
                return j3;
            }
        }

        public void close() throws IOException {
            this.f5377b.close();
        }

        public String toString() {
            return "source(" + this.f5377b + ")";
        }
    }

    private g() {
    }

    public static c a(l lVar) {
        if (lVar != null) {
            return new h(lVar);
        }
        throw new IllegalArgumentException("sink == null");
    }

    public static d a(m mVar) {
        if (mVar != null) {
            return new i(mVar);
        }
        throw new IllegalArgumentException("source == null");
    }

    public static l a(OutputStream outputStream) {
        return a(outputStream, new n());
    }

    private static l a(OutputStream outputStream, n nVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (nVar != null) {
            return new a(nVar, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static m a(File file) throws FileNotFoundException {
        if (file != null) {
            return a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static m a(InputStream inputStream) {
        return a(inputStream, new n());
    }

    private static m a(InputStream inputStream, n nVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (nVar != null) {
            return new b(nVar, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }
}
