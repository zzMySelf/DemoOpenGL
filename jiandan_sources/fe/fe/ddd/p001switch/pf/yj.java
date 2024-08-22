package fe.fe.ddd.p001switch.pf;

import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

/* renamed from: fe.fe.ddd.switch.pf.yj  reason: invalid package */
public final class yj extends th implements UnrepeatableRequestBody {

    /* renamed from: th  reason: collision with root package name */
    public final Pipe f1628th;

    public yj(long j) {
        Pipe pipe = new Pipe(8192);
        this.f1628th = pipe;
        qw(Okio.buffer(pipe.sink()), j);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        while (this.f1628th.source().read(buffer, 8192) != -1) {
            bufferedSink.write(buffer, buffer.size());
            if (this.f1623rg) {
                bufferedSink.flush();
                this.f1623rg = false;
            }
        }
    }
}
