package fe.th.de.rrr.pf;

import com.duxiaoman.okhttp3.internal.http.UnrepeatableRequestBody;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Pipe;

public final class rg extends fe implements UnrepeatableRequestBody {

    /* renamed from: rg  reason: collision with root package name */
    public final Pipe f5449rg;

    public rg(long j) {
        Pipe pipe = new Pipe(8192);
        this.f5449rg = pipe;
        uk(Okio.buffer(pipe.sink()), j);
    }

    public void yj(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        while (this.f5449rg.source().read(buffer, 8192) != -1) {
            bufferedSink.write(buffer, buffer.size());
        }
    }
}
