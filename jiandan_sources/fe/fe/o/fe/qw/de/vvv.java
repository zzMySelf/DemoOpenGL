package fe.fe.o.fe.qw.de;

import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import fe.fe.o.th.qw.qw;
import java.io.IOException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class vvv extends i implements HttpRequestRetryHandler {
    public vvv(long[] jArr) {
        super(jArr);
    }

    public boolean ad(IOException iOException, int i2, HttpContext httpContext, String str) {
        boolean z;
        int statusCode;
        Boolean bool = (Boolean) httpContext.getAttribute("http.request_sent");
        boolean z2 = false;
        if (bool == null || !bool.booleanValue()) {
        }
        if (i2 < 1 || i2 > this.qw.length || qw(i.f2527de, iOException)) {
            z = false;
        } else {
            boolean qw = qw(i.f2526ad, iOException);
            z = true;
        }
        if ((iOException instanceof HttpResponseException) && ((statusCode = ((HttpResponseException) iOException).getStatusCode()) == 416 || statusCode == 412)) {
            return false;
        }
        if (z) {
            HttpUriRequest httpUriRequest = (HttpUriRequest) httpContext.getAttribute("http.request");
            if (httpUriRequest != null) {
                z2 = !"POST".equals(httpUriRequest.getMethod());
            }
        } else {
            z2 = z;
        }
        if (z2) {
            try {
                long j = this.qw[i2 - 1];
                if (j > 0) {
                    if (qw.ad().qw && !TextUtils.isEmpty(str) && !qw.ad().de(str, CoroutineLiveDataKt.DEFAULT_TIMEOUT)) {
                        while (true) {
                            long j2 = j - CoroutineLiveDataKt.DEFAULT_TIMEOUT;
                            if (j2 <= 0) {
                                break;
                            }
                            Thread.sleep(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                            if (qw.ad().de(str, CoroutineLiveDataKt.DEFAULT_TIMEOUT)) {
                                return z2;
                            }
                            j = j2;
                        }
                    }
                    Thread.sleep(j);
                }
            } catch (InterruptedException unused) {
            }
        } else {
            iOException.printStackTrace();
        }
        return z2;
    }

    public boolean retryRequest(IOException iOException, int i2, HttpContext httpContext) {
        return ad(iOException, i2, httpContext, (String) null);
    }
}
