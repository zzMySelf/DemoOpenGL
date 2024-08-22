package fe.fe.ddd.p001switch.uk;

import com.baidu.searchbox.http.request.IAsyncRequestParamsHandler;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: fe.fe.ddd.switch.uk.ad  reason: invalid package */
public class ad implements Interceptor {
    public IAsyncRequestParamsHandler qw;

    public ad(IAsyncRequestParamsHandler iAsyncRequestParamsHandler) {
        this.qw = iAsyncRequestParamsHandler;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (this.qw != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.qw.qw(linkedHashMap);
            if (!linkedHashMap.isEmpty()) {
                HttpUrl.Builder newBuilder = request.url().newBuilder();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    newBuilder.setQueryParameter((String) entry.getKey(), (String) entry.getValue());
                }
                request = request.newBuilder().url(newBuilder.build()).build();
            }
        }
        return chain.proceed(request);
    }
}
