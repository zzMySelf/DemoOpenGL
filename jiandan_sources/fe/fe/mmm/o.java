package fe.fe.mmm;

import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.network.outback.manager.HttpManager;
import com.baidu.searchbox.network.outback.request.PostByteRequest;
import com.baidu.searchbox.network.outback.statistics.RequestCallException;
import com.baidu.searchbox.network.outback.support.request.HttpRequestCompat;
import com.baidu.searchbox.network.outback.support.request.PostBodyRequest;
import com.baidubce.util.Mimetypes;
import fe.fe.ddd.p001switch.p002if.uk;
import fe.fe.ddd.p001switch.p002if.yj;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class o extends de {

    /* renamed from: i  reason: collision with root package name */
    public HttpManager f2077i;

    /* renamed from: th  reason: collision with root package name */
    public CookieManager f2078th;

    /* renamed from: uk  reason: collision with root package name */
    public final boolean f2079uk = tt.pf().ad();

    /* renamed from: yj  reason: collision with root package name */
    public com.baidu.searchbox.network.outback.cookie.CookieManager f2080yj;

    public class ad extends RequestBody {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ InputStream f2081ad;
        public final /* synthetic */ Map qw;

        public ad(o oVar, Map map, InputStream inputStream) {
            this.qw = map;
            this.f2081ad = inputStream;
        }

        public long contentLength() throws IOException {
            if (this.qw.containsKey("Content-Length")) {
                try {
                    return Long.valueOf((String) this.qw.get("Content-Length")).longValue();
                } catch (Exception unused) {
                }
            }
            return super.contentLength();
        }

        public MediaType contentType() {
            return MediaType.parse(Mimetypes.MIMETYPE_OCTET_STREAM);
        }

        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Source source = null;
            try {
                source = Okio.source(this.f2081ad);
                bufferedSink.writeAll(source);
            } finally {
                if (source != null) {
                    source.close();
                }
            }
        }
    }

    public class de extends d {
        public final /* synthetic */ Response qw;

        public de(o oVar, Response response) {
            this.qw = response;
        }

        public String ad() throws IOException {
            return this.qw.body().string();
        }

        public int de() {
            return this.qw.code();
        }

        public String fe() {
            return this.qw.message();
        }

        public void qw() {
            this.qw.body().close();
        }

        public boolean rg() {
            return this.qw.isSuccessful();
        }
    }

    public class fe extends d {
        public final /* synthetic */ com.baidu.searchbox.network.outback.core.Response qw;

        public fe(o oVar, com.baidu.searchbox.network.outback.core.Response response) {
            this.qw = response;
        }

        public String ad() throws IOException {
            if (this.qw.body() != null) {
                return this.qw.body().string();
            }
            return null;
        }

        public int de() {
            return this.qw.code();
        }

        public String fe() {
            return this.qw.message();
        }

        public void qw() {
            if (this.qw.body() != null) {
                this.qw.body().close();
            }
        }

        public boolean rg() {
            return this.qw.isSuccessful();
        }
    }

    public class qw extends d {
        public final /* synthetic */ Response qw;

        public qw(o oVar, Response response) {
            this.qw = response;
        }

        public String ad() throws IOException {
            return this.qw.body().string();
        }

        public int de() {
            return this.qw.code();
        }

        public String fe() {
            return this.qw.message();
        }

        public void qw() {
            this.qw.body().close();
        }

        public boolean rg() {
            return this.qw.isSuccessful();
        }
    }

    public class rg extends com.baidu.searchbox.network.outback.core.RequestBody {
        public final /* synthetic */ InputStream qw;

        public rg(o oVar, Map map, InputStream inputStream) {
            this.qw = inputStream;
        }
    }

    public class th extends d {
        public final /* synthetic */ com.baidu.searchbox.network.outback.core.Response qw;

        public th(o oVar, com.baidu.searchbox.network.outback.core.Response response) {
            this.qw = response;
        }

        public String ad() throws IOException {
            if (this.qw.body() != null) {
                return this.qw.body().string();
            }
            return null;
        }

        public int de() {
            return this.qw.code();
        }

        public String fe() {
            return this.qw.message();
        }

        public void qw() {
            if (this.qw.body() != null) {
                this.qw.body().close();
            }
        }

        public boolean rg() {
            return this.qw.isSuccessful();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public d m132if(String str, byte[] bArr, Map<String, String> map) throws IOException {
        if (this.f2079uk) {
            return ppp(str, bArr, map);
        }
        uk.qw ggg = fe.fe.ddd.p001switch.de.mmm(fe.fe.ddd.i.qw.qw.qw()).ggg();
        ggg.th(3);
        ggg.uk(str);
        for (Map.Entry next : map.entrySet()) {
            ggg.qw((String) next.getKey(), (String) next.getValue());
        }
        ggg.de(this.f2078th);
        ggg.m85if(bArr);
        return new qw(this, ggg.ad().rg());
    }

    public d pf(String str, InputStream inputStream, Map<String, String> map) throws IOException {
        if (this.f2079uk) {
            return when(str, inputStream, map);
        }
        yj.qw ddd = fe.fe.ddd.p001switch.de.mmm(fe.fe.ddd.i.qw.qw.qw()).ddd();
        ddd.th(3);
        ddd.uk(str);
        for (Map.Entry next : map.entrySet()) {
            ddd.qw((String) next.getKey(), (String) next.getValue());
        }
        ddd.de(this.f2078th);
        ddd.i(new ad(this, map, inputStream));
        return new de(this, ddd.ad().rg());
    }

    public d ppp(String str, byte[] bArr, Map<String, String> map) {
        if (this.f2077i == null) {
            m133switch();
        }
        PostByteRequest.PostByteRequestBuilder postByteRequest = this.f2077i.postByteRequest();
        postByteRequest.requestFrom(3);
        postByteRequest.url(str);
        for (Map.Entry next : map.entrySet()) {
            postByteRequest.addHeader((String) next.getKey(), (String) next.getValue());
        }
        postByteRequest.cookieManager(this.f2080yj);
        try {
            return new fe(this, postByteRequest.content(bArr).build().executeSync());
        } catch (RequestCallException unused) {
            return null;
        }
    }

    public void rg() {
        this.f2078th = fe.fe.ddd.p001switch.de.mmm(fe.fe.ddd.i.qw.qw.qw()).th(true, true);
        if (this.f2079uk) {
            m133switch();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m133switch() {
        this.f2080yj = HttpManager.getDefault(fe.fe.ddd.i.qw.qw.qw()).getCookieManager(true, true);
        this.f2077i = HttpManager.newHttpManager(fe.fe.ddd.i.qw.qw.qw(), "CRONET");
    }

    public d when(String str, InputStream inputStream, Map<String, String> map) {
        if (this.f2077i == null) {
            m133switch();
        }
        PostBodyRequest.PostBodyRequestBuilder postRequest = new HttpRequestCompat(this.f2077i).postRequest();
        postRequest.requestFrom(3);
        postRequest.url(str);
        for (Map.Entry next : map.entrySet()) {
            postRequest.addHeader((String) next.getKey(), (String) next.getValue());
        }
        postRequest.cookieManager(this.f2080yj);
        postRequest.requestBody(new rg(this, map, inputStream));
        try {
            return new th(this, postRequest.build().executeSync());
        } catch (RequestCallException e) {
            e.printStackTrace();
            return null;
        }
    }
}
