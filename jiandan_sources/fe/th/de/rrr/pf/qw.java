package fe.th.de.rrr.pf;

import fe.th.de.ddd;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;

public final class qw extends fe {

    /* renamed from: rg  reason: collision with root package name */
    public final Buffer f5447rg;

    /* renamed from: th  reason: collision with root package name */
    public long f5448th = -1;

    public qw(long j) {
        Buffer buffer = new Buffer();
        this.f5447rg = buffer;
        uk(buffer, j);
    }

    public ddd pf(ddd ddd) throws IOException {
        if (ddd.de("Content-Length") != null) {
            return ddd;
        }
        o().close();
        this.f5448th = this.f5447rg.size();
        ddd.qw yj2 = ddd.yj();
        yj2.th("Transfer-Encoding");
        yj2.de("Content-Length", Long.toString(this.f5447rg.size()));
        return yj2.ad();
    }

    public long qw() throws IOException {
        return this.f5448th;
    }

    public void yj(BufferedSink bufferedSink) throws IOException {
        this.f5447rg.copyTo(bufferedSink.buffer(), 0, this.f5447rg.size());
    }
}
