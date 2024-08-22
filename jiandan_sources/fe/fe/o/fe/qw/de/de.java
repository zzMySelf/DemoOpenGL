package fe.fe.o.fe.qw.de;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

public class de implements HttpResponseInterceptor {
    public de(qw qwVar) {
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        Header contentEncoding;
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
            for (HeaderElement name : contentEncoding.getElements()) {
                if (name.getName().equalsIgnoreCase("gzip")) {
                    httpResponse.setEntity(new fe(httpResponse.getEntity()));
                    return;
                }
            }
        }
    }
}
