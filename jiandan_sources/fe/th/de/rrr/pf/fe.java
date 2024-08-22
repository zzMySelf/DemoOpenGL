package fe.th.de.rrr.pf;

import fe.th.de.ddd;
import fe.th.de.nn;
import fe.th.de.when;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okio.BufferedSink;
import okio.Timeout;

public abstract class fe extends nn {

    /* renamed from: ad  reason: collision with root package name */
    public long f5440ad;

    /* renamed from: de  reason: collision with root package name */
    public OutputStream f5441de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f5442fe;
    public Timeout qw;

    public class qw extends OutputStream {

        /* renamed from: ad  reason: collision with root package name */
        public long f5443ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f5444th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ BufferedSink f5446yj;

        public qw(long j, BufferedSink bufferedSink) {
            this.f5444th = j;
            this.f5446yj = bufferedSink;
        }

        public void close() throws IOException {
            fe.this.f5442fe = true;
            long j = this.f5444th;
            if (j == -1 || this.f5443ad >= j) {
                this.f5446yj.close();
                return;
            }
            throw new ProtocolException("expected " + this.f5444th + " bytes but received " + this.f5443ad);
        }

        public void flush() throws IOException {
            if (!fe.this.f5442fe) {
                this.f5446yj.flush();
            }
        }

        public void write(int i2) throws IOException {
            write(new byte[]{(byte) i2}, 0, 1);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (!fe.this.f5442fe) {
                long j = this.f5444th;
                if (j == -1 || this.f5443ad + ((long) i3) <= j) {
                    this.f5443ad += (long) i3;
                    try {
                        this.f5446yj.write(bArr, i2, i3);
                    } catch (InterruptedIOException e) {
                        throw new SocketTimeoutException(e.getMessage());
                    }
                } else {
                    throw new ProtocolException("expected " + this.f5444th + " bytes but received " + this.f5443ad + i3);
                }
            } else {
                throw new IOException("closed");
            }
        }
    }

    public final when ad() {
        return null;
    }

    public final boolean i() {
        return this.f5442fe;
    }

    /* renamed from: if  reason: not valid java name */
    public final Timeout m358if() {
        return this.qw;
    }

    public final OutputStream o() {
        return this.f5441de;
    }

    public ddd pf(ddd ddd) throws IOException {
        return ddd;
    }

    public long qw() throws IOException {
        return this.f5440ad;
    }

    public void uk(BufferedSink bufferedSink, long j) {
        this.qw = bufferedSink.timeout();
        this.f5440ad = j;
        this.f5441de = new qw(j, bufferedSink);
    }
}
