package fe.th.de.rrr.uk;

import com.duxiaoman.okhttp3.Call;
import com.duxiaoman.okhttp3.Connection;
import com.duxiaoman.okhttp3.EventListener;
import com.duxiaoman.okhttp3.Interceptor;
import com.duxiaoman.okhttp3.internal.http.HttpCodec;
import fe.th.de.ddd;
import fe.th.de.mmm;
import fe.th.de.rrr.yj.de;
import java.io.IOException;
import java.util.List;

public final class th implements Interceptor.Chain {

    /* renamed from: ad  reason: collision with root package name */
    public final fe.th.de.rrr.yj.th f5477ad;

    /* renamed from: de  reason: collision with root package name */
    public final HttpCodec f5478de;

    /* renamed from: fe  reason: collision with root package name */
    public final de f5479fe;

    /* renamed from: i  reason: collision with root package name */
    public final int f5480i;

    /* renamed from: if  reason: not valid java name */
    public int f217if;

    /* renamed from: o  reason: collision with root package name */
    public final int f5481o;

    /* renamed from: pf  reason: collision with root package name */
    public final int f5482pf;
    public final List<Interceptor> qw;

    /* renamed from: rg  reason: collision with root package name */
    public final int f5483rg;

    /* renamed from: th  reason: collision with root package name */
    public final ddd f5484th;

    /* renamed from: uk  reason: collision with root package name */
    public final EventListener f5485uk;

    /* renamed from: yj  reason: collision with root package name */
    public final Call f5486yj;

    public th(List<Interceptor> list, fe.th.de.rrr.yj.th thVar, HttpCodec httpCodec, de deVar, int i2, ddd ddd, Call call, EventListener eventListener, int i3, int i4, int i5) {
        this.qw = list;
        this.f5479fe = deVar;
        this.f5477ad = thVar;
        this.f5478de = httpCodec;
        this.f5483rg = i2;
        this.f5484th = ddd;
        this.f5486yj = call;
        this.f5485uk = eventListener;
        this.f5480i = i3;
        this.f5481o = i4;
        this.f5482pf = i5;
    }

    public Call ad() {
        return this.f5486yj;
    }

    public int connectTimeoutMillis() {
        return this.f5480i;
    }

    public Connection connection() {
        return this.f5479fe;
    }

    public EventListener de() {
        return this.f5485uk;
    }

    public HttpCodec fe() {
        return this.f5478de;
    }

    public mmm qw(ddd ddd) throws IOException {
        return rg(ddd, this.f5477ad, this.f5478de, this.f5479fe);
    }

    public int readTimeoutMillis() {
        return this.f5481o;
    }

    public ddd request() {
        return this.f5484th;
    }

    public mmm rg(ddd ddd, fe.th.de.rrr.yj.th thVar, HttpCodec httpCodec, de deVar) throws IOException {
        if (this.f5483rg < this.qw.size()) {
            this.f217if++;
            if (this.f5478de != null && !this.f5479fe.vvv(ddd.uk())) {
                throw new IllegalStateException("network interceptor " + this.qw.get(this.f5483rg - 1) + " must retain the same host and port");
            } else if (this.f5478de == null || this.f217if <= 1) {
                th thVar2 = new th(this.qw, thVar, httpCodec, deVar, this.f5483rg + 1, ddd, this.f5486yj, this.f5485uk, this.f5480i, this.f5481o, this.f5482pf);
                Interceptor interceptor = this.qw.get(this.f5483rg);
                mmm intercept = interceptor.intercept(thVar2);
                if (httpCodec != null && this.f5483rg + 1 < this.qw.size() && thVar2.f217if != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (intercept.qw() != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.qw.get(this.f5483rg - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    public fe.th.de.rrr.yj.th th() {
        return this.f5477ad;
    }

    public int writeTimeoutMillis() {
        return this.f5482pf;
    }
}
