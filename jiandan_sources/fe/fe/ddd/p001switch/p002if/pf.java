package fe.fe.ddd.p001switch.p002if;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.interceptor.LogInterceptor;
import com.baidu.searchbox.http.multipath.IMultiPath;
import com.baidu.searchbox.http.request.IAsyncRequestParamsHandler;
import com.baidu.searchbox.http.response.StatusCodeException;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.searchbox.requestpriority.IRequestCall;
import fe.fe.ddd.p001switch.fe;
import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: fe.fe.ddd.switch.if.pf  reason: invalid package */
public class pf implements Cancelable, IRequestCall {

    /* renamed from: ad  reason: collision with root package name */
    public OkHttpClient f1593ad;

    /* renamed from: de  reason: collision with root package name */
    public Call f1594de;

    /* renamed from: fe  reason: collision with root package name */
    public RequestHandler f1595fe;
    public fe qw;

    /* renamed from: fe.fe.ddd.switch.if.pf$ad */
    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Object f1596ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ fe.fe.ddd.p001switch.rg.qw f1597th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Response f1599yj;

        public ad(Object obj, fe.fe.ddd.p001switch.rg.qw qwVar, Response response) {
            this.f1596ad = obj;
            this.f1597th = qwVar;
            this.f1599yj = response;
        }

        public void run() {
            Object obj = this.f1596ad;
            if (obj != null) {
                this.f1597th.ad(obj, this.f1599yj.code());
            } else {
                this.f1597th.qw(new IOException("parse response return null"));
            }
            pf.this.xxx();
        }
    }

    /* renamed from: fe.fe.ddd.switch.if.pf$de */
    public class de implements Callback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.fe.ddd.p001switch.rg.qw f1600ad;
        public final /* synthetic */ Handler qw;

        public de(Handler handler, fe.fe.ddd.p001switch.rg.qw qwVar) {
            this.qw = handler;
            this.f1600ad = qwVar;
        }

        public void onFailure(Call call, IOException iOException) {
            pf.this.mmm(this.qw, this.f1600ad, iOException);
        }

        public void onResponse(Call call, Response response) {
            pf.this.aaa(this.qw, this.f1600ad, response);
        }
    }

    /* renamed from: fe.fe.ddd.switch.if.pf$qw */
    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.fe.ddd.p001switch.rg.qw f1602ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Exception f1603th;

        public qw(pf pfVar, fe.fe.ddd.p001switch.rg.qw qwVar, Exception exc) {
            this.f1602ad = qwVar;
            this.f1603th = exc;
        }

        public void run() {
            this.f1602ad.qw(this.f1603th);
        }
    }

    public pf(fe feVar) {
        this.qw = feVar;
        this.f1593ad = feVar.f1585fe;
        Handler handler = feVar.f1590th;
        this.f1595fe = feVar.f1589rg;
        o();
    }

    public final <T> void aaa(Handler handler, fe.fe.ddd.p001switch.rg.qw<T> qwVar, Response response) {
        try {
            eee(response);
            if (this.qw.aaa != null) {
                this.qw.aaa.rg(this.qw.f34switch, System.currentTimeMillis());
            }
            if (response != null) {
                nn(this.qw.f34switch, response.code(), response.message());
            }
            if (qwVar != null) {
                T de2 = qwVar.de(response, response.code());
                if (handler != null) {
                    handler.post(new ad(de2, qwVar, response));
                } else {
                    if (de2 != null) {
                        qwVar.ad(de2, response.code());
                    } else {
                        qwVar.qw(new IOException("parse response return null"));
                    }
                    xxx();
                }
            }
            this.qw.f = true;
            fe.fe.ddd.xxx.de.pf(this);
        } catch (Exception e) {
            mmm(handler, qwVar, e);
        }
    }

    public void ad(Object obj, Object obj2) {
        Handler handler = obj instanceof Handler ? (Handler) obj : null;
        if (obj2 instanceof fe.fe.ddd.p001switch.rg.qw) {
            m83if(handler, (fe.fe.ddd.p001switch.rg.qw) obj2);
        } else {
            m83if(handler, (fe.fe.ddd.p001switch.rg.qw) null);
        }
    }

    /* renamed from: ddd */
    public Response fe() throws IOException {
        return m84switch();
    }

    public int de() {
        return this.qw.m81switch();
    }

    public final void eee(Response response) {
        IMultiPath iMultiPath;
        if (TextUtils.equals(response.header("bd-frame-bind4gstatus"), "1") && (iMultiPath = fe.fe.ddd.p001switch.o.qw.qw) != null) {
            iMultiPath.de(String.valueOf(this.qw.tt), String.valueOf(this.qw.a));
        }
    }

    public final void ggg() throws IOException {
        pf();
        RequestHandler requestHandler = this.f1595fe;
        if (requestHandler != null) {
            requestHandler.qw();
        }
    }

    public final void i() {
        long currentTimeMillis = System.currentTimeMillis();
        fe feVar = this.qw;
        NetworkStat<Request> networkStat = feVar.aaa;
        if (networkStat != null) {
            networkStat.qw(feVar.f34switch, currentTimeMillis);
            fe feVar2 = this.qw;
            feVar2.aaa.ad(feVar2.f34switch, 2);
        }
        fe feVar3 = this.qw;
        fe.fe.ddd.p001switch.when.qw qwVar = feVar3.qqq;
        if (qwVar != null) {
            qwVar.qw = currentTimeMillis;
            qwVar.s = 2;
            qwVar.t = feVar3.tt;
            qwVar.w = feVar3.th();
            fe feVar4 = this.qw;
            feVar4.qqq.v = feVar4.i();
        }
    }

    /* renamed from: if  reason: not valid java name */
    public <T> void m83if(Handler handler, fe.fe.ddd.p001switch.rg.qw<T> qwVar) {
        this.f1594de.enqueue(new de(handler, qwVar));
    }

    public final void mmm(Handler handler, fe.fe.ddd.p001switch.rg.qw qwVar, Exception exc) {
        Exception exc2;
        if (this.qw.when.when()) {
            exc2 = exc;
        } else {
            exc2 = fe.fe.ddd.p001switch.p003switch.qw.qw(exc);
        }
        if (this.qw.aaa != null) {
            long currentTimeMillis = System.currentTimeMillis();
            fe feVar = this.qw;
            feVar.aaa.fe(feVar.f34switch, exc);
            fe feVar2 = this.qw;
            feVar2.aaa.rg(feVar2.f34switch, currentTimeMillis);
        }
        if (qwVar != null) {
            if (handler != null) {
                handler.post(new qw(this, qwVar, exc2));
            } else {
                qwVar.qw(exc2);
            }
        }
        this.qw.f = true;
        fe.fe.ddd.xxx.de.pf(this);
    }

    public final void nn(Request request, int i2, String str) {
        if (request != null && StatusCodeException.isStatusCodeMatched(i2)) {
            StatusCodeException statusCodeException = new StatusCodeException(String.format(StatusCodeException.ERROR_MSG_FORMATED, new Object[]{Integer.valueOf(i2), str}));
            try {
                if (this.qw.aaa != null) {
                    this.qw.aaa.fe(request, statusCodeException);
                }
                if (this.qw.qqq != null) {
                    this.qw.qqq.nn = statusCodeException;
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.qw.qqq.a = this.qw.when.i();
                this.qw.qqq.f1658i = System.currentTimeMillis() - currentTimeMillis;
            } catch (Throwable unused) {
            }
        }
    }

    public final void o() {
        Request o2 = this.qw.o();
        if (qqq()) {
            OkHttpClient.Builder newBuilder = this.f1593ad.newBuilder();
            fe feVar = this.qw;
            if (!((feVar.aaa == null && feVar.qqq == null) || fe.qw() == null)) {
                IHttpDns iHttpDns = fe.qw().m42switch(this.qw);
                if (fe.qw().ppp(this.qw)) {
                    iHttpDns.qw(true);
                    newBuilder.connectionPool(this.qw.when.uk());
                }
                if (iHttpDns != null && (iHttpDns instanceof Dns) && this.qw.uk() == null) {
                    newBuilder.dns((Dns) iHttpDns);
                }
            }
            if (this.qw.uk() != null) {
                newBuilder.dns(this.qw.uk());
            }
            int i2 = this.qw.f1592yj;
            if (i2 > 0) {
                newBuilder.connectTimeout((long) i2, TimeUnit.MILLISECONDS);
            }
            int i3 = this.qw.f1591uk;
            if (i3 > 0) {
                newBuilder.readTimeout((long) i3, TimeUnit.MILLISECONDS);
            }
            int i4 = this.qw.f1586i;
            if (i4 > 0) {
                newBuilder.writeTimeout((long) i4, TimeUnit.MILLISECONDS);
            }
            IAsyncRequestParamsHandler iAsyncRequestParamsHandler = this.qw.f1588pf;
            if (iAsyncRequestParamsHandler != null) {
                newBuilder.addInterceptor(new fe.fe.ddd.p001switch.uk.ad(iAsyncRequestParamsHandler));
            }
            if (!this.qw.f1587o) {
                newBuilder.retryOnConnectionFailure(false);
            }
            if (!TextUtils.isEmpty(this.qw.xxx)) {
                fe feVar2 = this.qw;
                newBuilder.addNetworkInterceptor(new LogInterceptor(feVar2.xxx, feVar2.ddd));
            }
            fe.fe.ddd.p001switch.uk.qw qwVar = null;
            if (this.qw.ggg()) {
                qwVar = new fe.fe.ddd.p001switch.uk.qw();
                newBuilder.addInterceptor(qwVar);
            } else {
                Request request = this.qw.f34switch;
                if (request != null && !TextUtils.isEmpty(request.headers().get("no-turbonet"))) {
                    fe feVar3 = this.qw;
                    feVar3.f34switch = feVar3.f34switch.newBuilder().removeHeader("no-turbonet").build();
                }
            }
            if (this.qw.mmm != null) {
                newBuilder.cookieJar(new fe.fe.ddd.p001switch.th.qw(this.qw.mmm));
                fe.fe.ddd.p001switch.when.qw qwVar2 = this.qw.m80if();
                if (qwVar2 != null) {
                    qwVar2.T = true;
                }
            }
            Proxy proxy = this.qw.ppp;
            if (proxy != null) {
                newBuilder.proxy(proxy);
            }
            fe feVar4 = this.qw;
            if (!feVar4.ggg || !feVar4.vvv) {
                newBuilder.followRedirects(this.qw.vvv).followSslRedirects(this.qw.ggg);
            }
            int i5 = this.qw.e;
            if (i5 > 0) {
                newBuilder.pingInterval((long) i5, TimeUnit.MILLISECONDS);
            }
            OkHttpClient build = newBuilder.build();
            if (qwVar != null) {
                qwVar.o(build);
            }
            this.f1594de = build.newCall(o2);
            return;
        }
        this.f1594de = this.f1593ad.newCall(o2);
    }

    public final void pf() throws IOException {
        fe feVar = this.qw;
        if (feVar.nn && !feVar.when.ppp()) {
            throw new IOException(" only allow wifi connected");
        }
    }

    public <T> Cancelable ppp(Handler handler, fe.fe.ddd.p001switch.rg.qw<T> qwVar) {
        i();
        try {
            ggg();
            if (fe.fe.ddd.xxx.de.i()) {
                fe.fe.ddd.xxx.de.th(this, handler, qwVar);
            } else {
                m83if(handler, qwVar);
            }
            return this;
        } catch (IOException e) {
            mmm(handler, qwVar, e);
            return this;
        }
    }

    public final boolean qqq() {
        fe feVar = this.qw;
        if (feVar.aaa == null && feVar.qqq == null && feVar.f1592yj <= 0 && feVar.f1586i <= 0 && feVar.f1591uk <= 0 && feVar.f1588pf == null && feVar.f1587o && TextUtils.isEmpty(feVar.xxx)) {
            fe feVar2 = this.qw;
            return feVar2.mmm != null || feVar2.ppp != null || !feVar2.vvv || !feVar2.ggg || feVar2.uk() != null || this.qw.e > 0;
        }
    }

    public boolean qw() {
        return this.qw.f;
    }

    public int rg() {
        return this.qw.pf();
    }

    /* renamed from: switch  reason: not valid java name */
    public final Response m84switch() throws IOException {
        IOException iOException;
        i();
        try {
            ggg();
            Response execute = this.f1594de.execute();
            if (execute != null) {
                nn(this.qw.f34switch, execute.code(), execute.message());
            }
            long currentTimeMillis = System.currentTimeMillis();
            fe feVar = this.qw;
            NetworkStat<Request> networkStat = feVar.aaa;
            if (networkStat != null) {
                networkStat.rg(feVar.f34switch, currentTimeMillis);
            }
            fe feVar2 = this.qw;
            fe.fe.ddd.p001switch.when.qw qwVar = feVar2.qqq;
            if (qwVar != null) {
                qwVar.f1663uk = currentTimeMillis;
                qwVar.a = feVar2.when.i();
                this.qw.qqq.f1658i = System.currentTimeMillis() - currentTimeMillis;
            }
            this.qw.f = true;
            fe.fe.ddd.xxx.de.pf(this);
            return execute;
        } catch (IOException e) {
            if (this.qw.when.when()) {
                iOException = e;
            } else {
                iOException = fe.fe.ddd.p001switch.p003switch.qw.qw(e);
            }
            if (this.qw.aaa != null) {
                this.qw.aaa.fe(this.qw.f34switch, e);
            }
            if (this.qw.qqq != null) {
                this.qw.qqq.nn = iOException;
            }
            throw iOException;
        } catch (NullPointerException e2) {
            if (this.qw.aaa != null) {
                this.qw.aaa.fe(this.qw.f34switch, e2);
            }
            if (this.qw.qqq != null) {
                this.qw.qqq.nn = e2;
            }
            throw e2;
        } catch (Throwable th2) {
            long currentTimeMillis2 = System.currentTimeMillis();
            fe feVar3 = this.qw;
            NetworkStat<Request> networkStat2 = feVar3.aaa;
            if (networkStat2 != null) {
                networkStat2.rg(feVar3.f34switch, currentTimeMillis2);
            }
            fe feVar4 = this.qw;
            fe.fe.ddd.p001switch.when.qw qwVar2 = feVar4.qqq;
            if (qwVar2 != null) {
                qwVar2.f1663uk = currentTimeMillis2;
                qwVar2.a = feVar4.when.i();
                this.qw.qqq.f1658i = System.currentTimeMillis() - currentTimeMillis2;
            }
            this.qw.f = true;
            fe.fe.ddd.xxx.de.pf(this);
            throw th2;
        }
    }

    public Response vvv() throws IOException {
        if (!fe.fe.ddd.xxx.de.i()) {
            return m84switch();
        }
        try {
            Object yj2 = fe.fe.ddd.xxx.de.yj(this);
            if (yj2 instanceof Response) {
                return (Response) yj2;
            }
            return null;
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    public <T> Cancelable when(fe.fe.ddd.p001switch.rg.qw<T> qwVar) {
        ppp((Handler) null, qwVar);
        return this;
    }

    public final void xxx() {
        fe.fe.ddd.p001switch.when.qw qwVar = this.qw.m80if();
        fe feVar = this.qw;
        NetworkStat<Request> networkStat = feVar.aaa;
        if (networkStat != null && qwVar != null && qwVar.s == 3) {
            networkStat.de(feVar.f34switch, feVar.yj());
        }
    }
}
