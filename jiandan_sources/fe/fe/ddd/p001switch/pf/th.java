package fe.fe.ddd.p001switch.pf;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Timeout;

/* renamed from: fe.fe.ddd.switch.pf.th  reason: invalid package */
public abstract class th extends RequestBody {

    /* renamed from: ad  reason: collision with root package name */
    public long f1620ad;

    /* renamed from: de  reason: collision with root package name */
    public OutputStream f1621de;

    /* renamed from: fe  reason: collision with root package name */
    public boolean f1622fe;
    public Timeout qw;

    /* renamed from: rg  reason: collision with root package name */
    public volatile boolean f1623rg = false;

    /* renamed from: fe.fe.ddd.switch.pf.th$qw */
    public class qw extends OutputStream {

        /* renamed from: ad  reason: collision with root package name */
        public long f1624ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ long f1625th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ BufferedSink f1627yj;

        public qw(long j, BufferedSink bufferedSink) {
            this.f1625th = j;
            this.f1627yj = bufferedSink;
        }

        public void close() throws IOException {
            th.this.f1622fe = true;
            long j = this.f1625th;
            if (j == -1 || this.f1624ad >= j) {
                this.f1627yj.close();
                return;
            }
            throw new ProtocolException("expected " + this.f1625th + " bytes but received " + this.f1624ad);
        }

        public void flush() throws IOException {
            if (!th.this.f1622fe) {
                this.f1627yj.flush();
                th.this.f1623rg = true;
            }
        }

        public void write(int i2) throws IOException {
            write(new byte[]{(byte) i2}, 0, 1);
        }

        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (!th.this.f1622fe) {
                long j = this.f1625th;
                if (j == -1 || this.f1624ad + ((long) i3) <= j) {
                    this.f1624ad += (long) i3;
                    try {
                        this.f1627yj.write(bArr, i2, i3);
                    } catch (InterruptedIOException e) {
                        throw new SocketTimeoutException(e.getMessage());
                    }
                } else {
                    throw new ProtocolException("expected " + this.f1625th + " bytes but received " + this.f1624ad + i3);
                }
            } else {
                throw new IOException("closed");
            }
        }
    }

    public final boolean ad() {
        return this.f1622fe;
    }

    public long contentLength() throws IOException {
        return this.f1620ad;
    }

    public final MediaType contentType() {
        return null;
    }

    public final OutputStream de() {
        return this.f1621de;
    }

    public Request fe(Request request) throws IOException {
        return request;
    }

    public void qw(BufferedSink bufferedSink, long j) {
        this.qw = bufferedSink.timeout();
        this.f1620ad = j;
        this.f1621de = new qw(j, bufferedSink);
    }

    public final Timeout rg() {
        return this.qw;
    }
}
