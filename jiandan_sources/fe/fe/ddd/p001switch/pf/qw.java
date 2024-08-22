package fe.fe.ddd.p001switch.pf;

import java.io.IOException;
import okhttp3.Request;
import okio.Buffer;
import okio.BufferedSink;

/* renamed from: fe.fe.ddd.switch.pf.qw  reason: invalid package */
public final class qw extends th {

    /* renamed from: th  reason: collision with root package name */
    public final Buffer f1615th;

    /* renamed from: yj  reason: collision with root package name */
    public long f1616yj = -1;

    public qw(long j) {
        Buffer buffer = new Buffer();
        this.f1615th = buffer;
        qw(buffer, j);
    }

    public long contentLength() throws IOException {
        return this.f1616yj;
    }

    public Request fe(Request request) throws IOException {
        if (request.header("Content-Length") != null) {
            return request;
        }
        de().close();
        this.f1616yj = this.f1615th.size();
        return request.newBuilder().removeHeader("Transfer-Encoding").header("Content-Length", Long.toString(this.f1615th.size())).build();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.f1615th.copyTo(bufferedSink.buffer(), 0, this.f1615th.size());
    }
}
