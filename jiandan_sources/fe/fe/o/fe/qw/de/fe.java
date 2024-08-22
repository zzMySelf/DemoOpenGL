package fe.fe.o.fe.qw.de;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class fe extends HttpEntityWrapper {
    public fe(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public InputStream getContent() {
        return new GZIPInputStream(this.wrappedEntity.getContent());
    }

    public long getContentLength() {
        return -1;
    }
}
