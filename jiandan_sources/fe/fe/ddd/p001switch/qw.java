package fe.fe.ddd.p001switch;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.IClientIPProvider;
import com.baidu.searchbox.http.IHttpContext;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.searchbox.http.RequestHandler;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.google.android.material.timepicker.TimeModel;
import fe.fe.ddd.p001switch.i.ad;
import fe.fe.ddd.p001switch.p002if.i;
import fe.fe.ddd.p001switch.p002if.o;
import fe.fe.ddd.p001switch.p002if.uk;
import fe.fe.ddd.p001switch.p002if.yj;
import fe.fe.ddd.p001switch.pf.rg;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.ProxySelector;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.PreConnectParams;

/* renamed from: fe.fe.ddd.switch.qw  reason: invalid package */
public abstract class qw {

    /* renamed from: i  reason: collision with root package name */
    public static List<Class<? extends Interceptor>> f1629i = null;

    /* renamed from: if  reason: not valid java name */
    public static String f37if = null;

    /* renamed from: o  reason: collision with root package name */
    public static List<Class<? extends Interceptor>> f1630o = null;

    /* renamed from: pf  reason: collision with root package name */
    public static volatile boolean f1631pf = false;

    /* renamed from: uk  reason: collision with root package name */
    public static ProxySelector f1632uk;

    /* renamed from: ad  reason: collision with root package name */
    public Handler f1633ad;

    /* renamed from: de  reason: collision with root package name */
    public RequestHandler f1634de;

    /* renamed from: fe  reason: collision with root package name */
    public Context f1635fe;
    public OkHttpClient qw;

    /* renamed from: rg  reason: collision with root package name */
    public NetworkStat<Request> f1636rg;

    /* renamed from: th  reason: collision with root package name */
    public IHttpDns f1637th;

    /* renamed from: yj  reason: collision with root package name */
    public ConnectionPool f1638yj;

    /* renamed from: fe.fe.ddd.switch.qw$qw  reason: collision with other inner class name */
    public class C0086qw implements Authenticator {
        public C0086qw(qw qwVar) {
        }

        public Request authenticate(Route route, Response response) throws IOException {
            String host = response.request().url().host();
            if (!fe.qw().th(host)) {
                return null;
            }
            return response.request().newBuilder().header("X-T5-Auth", String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(qw.fe(host) & Integer.MAX_VALUE)})).build();
        }
    }

    public qw(Context context) {
        if (fe.qw() != null) {
            fe.qw().m41if();
            this.f1637th = fe.qw().yj();
        }
        this.f1635fe = context.getApplicationContext();
        this.f1633ad = new Handler(Looper.getMainLooper());
        this.f1634de = new RequestHandler.qw();
        if (fe.qw().rg()) {
            try {
                if (!f1631pf) {
                    synchronized (qw.class) {
                        if (!f1631pf) {
                            Field declaredField = URL.class.getDeclaredField("factory");
                            declaredField.setAccessible(true);
                            if (declaredField.get((Object) null) == null) {
                                URL.setURLStreamHandlerFactory(new rg(m87switch()));
                            }
                            declaredField.setAccessible(false);
                            f1631pf = true;
                        }
                    }
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        this.qw = m87switch();
    }

    public static int fe(String str) {
        if (str == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            i2 = (i2 * 1318293) + str.charAt(i3);
        }
        return i2;
    }

    public static String rg() {
        IClientIPProvider de2;
        if (fe.qw() == null || (de2 = fe.qw().de()) == null) {
            return f37if;
        }
        return de2.qw();
    }

    public final void ad(OkHttpClient.Builder builder) {
        ProxySelector proxySelector = f1632uk;
        if (proxySelector != null) {
            builder.proxySelector(proxySelector);
        }
    }

    public yj.qw ddd() {
        return new yj.qw(this);
    }

    public final void de(OkHttpClient.Builder builder) {
        List<Class<? extends Interceptor>> list = f1629i;
        if (list != null) {
            try {
                for (Class<? extends Interceptor> constructor : list) {
                    builder.addNetworkInterceptor((Interceptor) constructor.getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List<Class<? extends Interceptor>> list2 = f1630o;
        if (list2 != null) {
            try {
                for (Class<? extends Interceptor> constructor2 : list2) {
                    builder.addInterceptor((Interceptor) constructor2.getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public uk.qw ggg() {
        return new uk.qw(this);
    }

    public String i() {
        return ConnectManager.qw(this.f1635fe);
    }

    /* renamed from: if  reason: not valid java name */
    public RequestHandler m86if() {
        return this.f1634de;
    }

    public void nn(NetworkStat<Request> networkStat) {
        this.f1636rg = networkStat;
    }

    public NetworkStat<Request> o() {
        return this.f1636rg;
    }

    public OkHttpClient pf() {
        return this.qw;
    }

    public boolean ppp() {
        return ConnectManager.de(this.f1635fe);
    }

    /* renamed from: switch  reason: not valid java name */
    public OkHttpClient m87switch() {
        ad ad2;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            builder.connectTimeout(30000, TimeUnit.MILLISECONDS).readTimeout(30000, TimeUnit.MILLISECONDS).writeTimeout(30000, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(10, 5, TimeUnit.MINUTES));
            IHttpContext qw2 = fe.qw();
            if (!(qw2 == null || (ad2 = qw2.ad()) == null || !ad2.rg())) {
                builder.preConnect(new PreConnectParams.Builder().setPreConnectEnabled(ad2.rg()).setPreConnectUrlsAllowlist(ad2.uk()).setMaxPreConnectNum(ad2.qw()).setMaxSingleHostPreConnectNum(ad2.ad()).setPreConnectDelayTimeMs(ad2.de()).setPreConnectPeriodTimeMs(ad2.yj()).setPreConnectDelayUrlsWithNum(ad2.fe()).setPreConnectNoDelayUrlsWithNum(ad2.th()).build());
            }
            if (this.f1637th != null && (this.f1637th instanceof Dns)) {
                builder.dns((Dns) this.f1637th);
            }
            de(builder);
            ad(builder);
            if (qw2 != null && qw2.pf() > 0) {
                builder.fallbackConnectDelayMs(fe.qw().pf());
            }
            if (!(qw2 == null || qw2.when() == null)) {
                builder.eventListener(qw2.when());
            }
            builder.proxyAuthenticator(new C0086qw(this));
        } catch (IllegalArgumentException unused) {
        }
        return builder.build();
    }

    public CookieManager th(boolean z, boolean z2) {
        return fe.qw().i(z, z2);
    }

    public ConnectionPool uk() {
        if (this.f1638yj == null) {
            synchronized (qw.class) {
                if (this.f1638yj == null) {
                    this.f1638yj = new ConnectionPool(10, 5, TimeUnit.MINUTES);
                }
            }
        }
        return this.f1638yj;
    }

    public i.qw vvv() {
        return new i.qw(this);
    }

    public boolean when() {
        return ConnectManager.ad(this.f1635fe);
    }

    public o.qw xxx() {
        return new o.qw(this);
    }

    public Handler yj() {
        return this.f1633ad;
    }
}
