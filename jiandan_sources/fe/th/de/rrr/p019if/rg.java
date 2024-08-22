package fe.th.de.rrr.p019if;

import com.duxiaoman.okhttp3.Protocol;
import fe.th.de.rrr.fe;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: fe.th.de.rrr.if.rg  reason: invalid package */
public class rg extends yj {

    /* renamed from: de  reason: collision with root package name */
    public final Method f5299de;

    /* renamed from: fe  reason: collision with root package name */
    public final Method f5300fe;

    /* renamed from: rg  reason: collision with root package name */
    public final Method f5301rg;

    /* renamed from: th  reason: collision with root package name */
    public final Class<?> f5302th;

    /* renamed from: yj  reason: collision with root package name */
    public final Class<?> f5303yj;

    /* renamed from: fe.th.de.rrr.if.rg$qw */
    public static class qw implements InvocationHandler {

        /* renamed from: ad  reason: collision with root package name */
        public final List<String> f5304ad;

        /* renamed from: th  reason: collision with root package name */
        public boolean f5305th;

        /* renamed from: yj  reason: collision with root package name */
        public String f5306yj;

        public qw(List<String> list) {
            this.f5304ad = list;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = fe.f5254ad;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f5305th = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.f5304ad;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f5304ad.contains(list.get(i2))) {
                            String str = (String) list.get(i2);
                            this.f5306yj = str;
                            return str;
                        }
                    }
                    String str2 = this.f5304ad.get(0);
                    this.f5306yj = str2;
                    return str2;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.f5306yj = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    public rg(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f5299de = method;
        this.f5300fe = method2;
        this.f5301rg = method3;
        this.f5302th = cls;
        this.f5303yj = cls2;
    }

    public static yj rrr() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider");
            Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider");
            Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider");
            Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
            return new rg(method, cls.getMethod("get", new Class[]{SSLSocket.class}), cls.getMethod("remove", new Class[]{SSLSocket.class}), cls3, cls4);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    public String ggg(SSLSocket sSLSocket) {
        try {
            qw qwVar = (qw) Proxy.getInvocationHandler(this.f5300fe.invoke((Object) null, new Object[]{sSLSocket}));
            if (!qwVar.f5305th && qwVar.f5306yj == null) {
                yj.m350switch().mmm(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", (Throwable) null);
                return null;
            } else if (qwVar.f5305th) {
                return null;
            } else {
                return qwVar.f5306yj;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fe.ad("unable to get selected protocol", e);
        }
    }

    public void qw(SSLSocket sSLSocket) {
        try {
            this.f5301rg.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fe.ad("unable to remove alpn", e);
        }
    }

    public void uk(SSLSocket sSLSocket, String str, List<Protocol> list) {
        List<String> ad2 = yj.ad(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(yj.class.getClassLoader(), new Class[]{this.f5302th, this.f5303yj}, new qw(ad2));
            this.f5299de.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fe.ad("unable to set alpn", e);
        }
    }
}
