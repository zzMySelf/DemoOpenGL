package fe.ad.qw.qw.qw;

import android.content.Context;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Route(path = "/arouter/service/interceptor")
public class ad implements InterceptorService {

    /* renamed from: ad  reason: collision with root package name */
    public static final Object f1203ad = new Object();
    public static boolean qw;

    /* renamed from: fe.ad.qw.qw.qw.ad$ad  reason: collision with other inner class name */
    public static class C0065ad implements InterceptorCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f1204ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ Postcard f1205de;
        public final /* synthetic */ fe.ad.qw.qw.de.qw qw;

        public C0065ad(fe.ad.qw.qw.de.qw qwVar, int i2, Postcard postcard) {
            this.qw = qwVar;
            this.f1204ad = i2;
            this.f1205de = postcard;
        }

        public void onContinue(Postcard postcard) {
            this.qw.countDown();
            ad.qw(this.f1204ad + 1, this.qw, postcard);
        }

        public void onInterrupt(Throwable th2) {
            Postcard postcard = this.f1205de;
            if (th2 == null) {
                th2 = new HandlerException("No message.");
            }
            postcard.setTag(th2);
            this.qw.qw();
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f1206ad;

        public de(ad adVar, Context context) {
            this.f1206ad = context;
        }

        public void run() {
            if (fe.ad.qw.qw.fe.de.ad(fe.f1214rg)) {
                for (Map.Entry<Integer, Class<? extends IInterceptor>> value : fe.f1214rg.entrySet()) {
                    Class cls = (Class) value.getValue();
                    try {
                        IInterceptor iInterceptor = (IInterceptor) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                        iInterceptor.init(this.f1206ad);
                        fe.f1215th.add(iInterceptor);
                    } catch (Exception e) {
                        throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + cls.getName() + "], reason = [" + e.getMessage() + "]");
                    }
                }
                boolean unused = ad.qw = true;
                fe.ad.qw.qw.ad.qw.f1186de.info(ILogger.defaultTag, "ARouter interceptors init over.");
                synchronized (ad.f1203ad) {
                    ad.f1203ad.notifyAll();
                }
            }
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Postcard f1207ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ InterceptorCallback f1208th;

        public qw(ad adVar, Postcard postcard, InterceptorCallback interceptorCallback) {
            this.f1207ad = postcard;
            this.f1208th = interceptorCallback;
        }

        public void run() {
            fe.ad.qw.qw.de.qw qwVar = new fe.ad.qw.qw.de.qw(fe.f1215th.size());
            try {
                ad.qw(0, qwVar, this.f1207ad);
                qwVar.await((long) this.f1207ad.getTimeout(), TimeUnit.SECONDS);
                if (qwVar.getCount() > 0) {
                    this.f1208th.onInterrupt(new HandlerException("The interceptor processing timed out."));
                } else if (this.f1207ad.getTag() != null) {
                    this.f1208th.onInterrupt((Throwable) this.f1207ad.getTag());
                } else {
                    this.f1208th.onContinue(this.f1207ad);
                }
            } catch (Exception e) {
                this.f1208th.onInterrupt(e);
            }
        }
    }

    public static void qw(int i2, fe.ad.qw.qw.de.qw qwVar, Postcard postcard) {
        if (i2 < fe.f1215th.size()) {
            fe.f1215th.get(i2).process(postcard, new C0065ad(qwVar, i2, postcard));
        }
    }

    public static void rg() {
        synchronized (f1203ad) {
            while (!qw) {
                try {
                    f1203ad.wait(10000);
                } catch (InterruptedException e) {
                    throw new HandlerException("ARouter::Interceptor init cost too much time error! reason = [" + e.getMessage() + "]");
                }
            }
        }
    }

    public void doInterceptions(Postcard postcard, InterceptorCallback interceptorCallback) {
        if (fe.ad.qw.qw.fe.de.ad(fe.f1214rg)) {
            rg();
            if (!qw) {
                interceptorCallback.onInterrupt(new HandlerException("Interceptors initialization takes too much time."));
            } else {
                de.f1209ad.execute(new qw(this, postcard, interceptorCallback));
            }
        } else {
            interceptorCallback.onContinue(postcard);
        }
    }

    public void init(Context context) {
        de.f1209ad.execute(new de(this, context));
    }
}
