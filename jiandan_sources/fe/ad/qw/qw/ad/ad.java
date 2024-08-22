package fe.ad.qw.qw.ad;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import fe.ad.qw.qw.fe.rg;
import java.util.concurrent.ThreadPoolExecutor;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile boolean f1168ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static volatile ad f1169de = null;

    /* renamed from: fe  reason: collision with root package name */
    public static volatile boolean f1170fe = false;
    public static ILogger qw = new fe.ad.qw.qw.fe.ad(ILogger.defaultTag);

    /* renamed from: rg  reason: collision with root package name */
    public static volatile ThreadPoolExecutor f1171rg = fe.ad.qw.qw.de.ad.qw();

    /* renamed from: th  reason: collision with root package name */
    public static Handler f1172th;

    /* renamed from: uk  reason: collision with root package name */
    public static InterceptorService f1173uk;

    /* renamed from: yj  reason: collision with root package name */
    public static Context f1174yj;

    /* renamed from: fe.ad.qw.qw.ad.ad$ad  reason: collision with other inner class name */
    public class C0063ad implements InterceptorCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ NavigationCallback f1175ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ Postcard f1176de;
        public final /* synthetic */ int qw;

        public C0063ad(int i2, NavigationCallback navigationCallback, Postcard postcard) {
            this.qw = i2;
            this.f1175ad = navigationCallback;
            this.f1176de = postcard;
        }

        public void onContinue(Postcard postcard) {
            Object unused = ad.this.qw(postcard, this.qw, this.f1175ad);
        }

        public void onInterrupt(Throwable th2) {
            NavigationCallback navigationCallback = this.f1175ad;
            if (navigationCallback != null) {
                navigationCallback.onInterrupt(this.f1176de);
            }
            ILogger iLogger = ad.qw;
            iLogger.info(ILogger.defaultTag, "Navigation failed, termination by interceptor : " + th2.getMessage());
        }
    }

    public class de implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f1178ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ NavigationCallback f1179i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Context f1181th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ Postcard f1182uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Intent f1183yj;

        public de(int i2, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
            this.f1178ad = i2;
            this.f1181th = context;
            this.f1183yj = intent;
            this.f1182uk = postcard;
            this.f1179i = navigationCallback;
        }

        public void run() {
            ad.this.xxx(this.f1178ad, this.f1181th, this.f1183yj, this.f1182uk, this.f1179i);
        }
    }

    public static /* synthetic */ class fe {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.alibaba.android.arouter.facade.enums.RouteType[] r0 = com.alibaba.android.arouter.facade.enums.RouteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.BOARDCAST     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.CONTENT_PROVIDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x003e }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.FRAGMENT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.METHOD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.SERVICE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.ad.qw.qw.ad.ad.fe.<clinit>():void");
        }
    }

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Postcard f1184ad;

        public qw(ad adVar, Postcard postcard) {
            this.f1184ad = postcard;
        }

        public void run() {
            Context ad2 = ad.f1174yj;
            Toast.makeText(ad2, "There's no route matched!\n Path = [" + this.f1184ad.getPath() + "]\n Group = [" + this.f1184ad.getGroup() + "]", 1).show();
        }
    }

    public static synchronized void ggg() {
        synchronized (ad.class) {
            qw.showLog(true);
            qw.info(ILogger.defaultTag, "ARouter openLog");
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static void m53if(Object obj) {
        AutowiredService autowiredService = (AutowiredService) qw.de().qw("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public static ad o() {
        if (f1170fe) {
            if (f1169de == null) {
                synchronized (ad.class) {
                    if (f1169de == null) {
                        f1169de = new ad();
                    }
                }
            }
            return f1169de;
        }
        throw new InitException("ARouterCore::Init::Invoke init(context) first!");
    }

    public static synchronized boolean pf(Application application) {
        synchronized (ad.class) {
            f1174yj = application;
            fe.ad.qw.qw.qw.de.fe(application, f1171rg);
            qw.info(ILogger.defaultTag, "ARouter init success!");
            f1170fe = true;
            f1172th = new Handler(Looper.getMainLooper());
        }
        return true;
    }

    public static synchronized void ppp() {
        synchronized (ad.class) {
            f1168ad = true;
            qw.info(ILogger.defaultTag, "ARouter openDebug");
        }
    }

    public static void rg() {
        f1173uk = (InterceptorService) qw.de().qw("/arouter/service/interceptor").navigation();
    }

    public static boolean uk() {
        return f1168ad;
    }

    public final String i(String str) {
        if (rg.ad(str) || !str.startsWith("/")) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String substring = str.substring(1, str.indexOf("/", 1));
            if (!rg.ad(substring)) {
                return substring;
            }
            throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
        } catch (Exception e) {
            ILogger iLogger = qw;
            iLogger.warning(ILogger.defaultTag, "Failed to extract default group! " + e.getMessage());
            return null;
        }
    }

    public final Object qw(Postcard postcard, int i2, NavigationCallback navigationCallback) {
        Context context = postcard.getContext();
        int i3 = fe.qw[postcard.getType().ordinal()];
        if (i3 == 1) {
            Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (flags != 0) {
                intent.setFlags(flags);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            String action = postcard.getAction();
            if (!rg.ad(action)) {
                intent.setAction(action);
            }
            vvv(new de(i2, context, intent, postcard, navigationCallback));
            return null;
        } else if (i3 == 2) {
            return postcard.getProvider();
        } else {
            if (i3 == 3 || i3 == 4 || i3 == 5) {
                try {
                    Object newInstance = postcard.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newInstance instanceof Fragment) {
                        ((Fragment) newInstance).setArguments(postcard.getExtras());
                    } else if (newInstance instanceof androidx.fragment.app.Fragment) {
                        ((androidx.fragment.app.Fragment) newInstance).setArguments(postcard.getExtras());
                    }
                    return newInstance;
                } catch (Exception e) {
                    ILogger iLogger = qw;
                    iLogger.error(ILogger.defaultTag, "Fetch fragment instance error, " + rg.qw(e.getStackTrace()));
                }
            }
            return null;
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public Object m54switch(Context context, Postcard postcard, int i2, NavigationCallback navigationCallback) {
        PretreatmentService pretreatmentService = (PretreatmentService) qw.de().yj(PretreatmentService.class);
        if (pretreatmentService != null && !pretreatmentService.onPretreatment(context, postcard)) {
            return null;
        }
        postcard.setContext(context == null ? f1174yj : context);
        try {
            fe.ad.qw.qw.qw.de.de(postcard);
            if (navigationCallback != null) {
                navigationCallback.onFound(postcard);
            }
            if (postcard.isGreenChannel()) {
                return qw(postcard, i2, navigationCallback);
            }
            f1173uk.doInterceptions(postcard, new C0063ad(i2, navigationCallback, postcard));
            return null;
        } catch (NoRouteFoundException e) {
            qw.warning(ILogger.defaultTag, e.getMessage());
            if (uk()) {
                vvv(new qw(this, postcard));
            }
            if (navigationCallback != null) {
                navigationCallback.onLost(postcard);
            } else {
                DegradeService degradeService = (DegradeService) qw.de().yj(DegradeService.class);
                if (degradeService != null) {
                    degradeService.onLost(context, postcard);
                }
            }
            return null;
        }
    }

    public Postcard th(String str) {
        if (!rg.ad(str)) {
            PathReplaceService pathReplaceService = (PathReplaceService) qw.de().yj(PathReplaceService.class);
            if (pathReplaceService != null) {
                str = pathReplaceService.forString(str);
            }
            return yj(str, i(str), Boolean.TRUE);
        }
        throw new HandlerException("ARouter::Parameter is invalid!");
    }

    public final void vvv(Runnable runnable) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            f1172th.post(runnable);
        } else {
            runnable.run();
        }
    }

    public <T> T when(Class<? extends T> cls) {
        try {
            Postcard ad2 = fe.ad.qw.qw.qw.de.ad(cls.getName());
            if (ad2 == null) {
                ad2 = fe.ad.qw.qw.qw.de.ad(cls.getSimpleName());
            }
            if (ad2 == null) {
                return null;
            }
            ad2.setContext(f1174yj);
            fe.ad.qw.qw.qw.de.de(ad2);
            return ad2.getProvider();
        } catch (NoRouteFoundException e) {
            qw.warning(ILogger.defaultTag, e.getMessage());
            return null;
        }
    }

    public final void xxx(int i2, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        if (i2 < 0) {
            ContextCompat.startActivity(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            ActivityCompat.startActivityForResult((Activity) context, intent, i2, postcard.getOptionsBundle());
        } else {
            qw.warning(ILogger.defaultTag, "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (!(-1 == postcard.getEnterAnim() || -1 == postcard.getExitAnim() || !(context instanceof Activity))) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }

    public Postcard yj(String str, String str2, Boolean bool) {
        PathReplaceService pathReplaceService;
        if (rg.ad(str) || rg.ad(str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        if (!bool.booleanValue() && (pathReplaceService = (PathReplaceService) qw.de().yj(PathReplaceService.class)) != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }
}
