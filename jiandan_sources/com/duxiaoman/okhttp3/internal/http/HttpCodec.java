package com.duxiaoman.okhttp3.internal.http;

import fe.th.de.aaa;
import fe.th.de.ddd;
import fe.th.de.mmm;
import java.io.IOException;
import okio.Sink;

public interface HttpCodec {
    void ad(ddd ddd) throws IOException;

    void cancel();

    Sink de(ddd ddd, long j);

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    aaa qw(mmm mmm) throws IOException;

    mmm.qw readResponseHeaders(boolean z) throws IOException;
}
