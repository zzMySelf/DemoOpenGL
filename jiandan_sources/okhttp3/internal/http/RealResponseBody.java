package okhttp3.internal.http;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    public final long contentLength;
    public final String contentTypeString;
    public final BufferedSource source;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = bufferedSource;
    }

    public long contentLength() {
        return this.contentLength;
    }

    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public BufferedSource source() {
        return this.source;
    }
}
