package fe.ad.qw.qw.ad;

import android.app.Application;
import android.content.Context;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;

public final class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile boolean f1185ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static ILogger f1186de;
    public static volatile qw qw;

    public static boolean ad() {
        return ad.uk();
    }

    public static qw de() {
        if (f1185ad) {
            if (qw == null) {
                synchronized (qw.class) {
                    if (qw == null) {
                        qw = new qw();
                    }
                }
            }
            return qw;
        }
        throw new InitException("ARouter::Init::Invoke init(context) first!");
    }

    public static void fe(Application application) {
        if (!f1185ad) {
            ILogger iLogger = ad.qw;
            f1186de = iLogger;
            iLogger.info(ILogger.defaultTag, "ARouter init start.");
            f1185ad = ad.pf(application);
            if (f1185ad) {
                ad.rg();
            }
            ad.qw.info(ILogger.defaultTag, "ARouter init over.");
        }
    }

    public static synchronized void i() {
        synchronized (qw.class) {
            ad.ggg();
        }
    }

    public static synchronized void uk() {
        synchronized (qw.class) {
            ad.ppp();
        }
    }

    public Postcard qw(String str) {
        return ad.o().th(str);
    }

    public void rg(Object obj) {
        ad.m53if(obj);
    }

    public Object th(Context context, Postcard postcard, int i2, NavigationCallback navigationCallback) {
        return ad.o().m54switch(context, postcard, i2, navigationCallback);
    }

    public <T> T yj(Class<? extends T> cls) {
        return ad.o().when(cls);
    }
}
