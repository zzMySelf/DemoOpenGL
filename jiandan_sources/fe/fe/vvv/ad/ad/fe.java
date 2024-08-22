package fe.fe.vvv.ad.ad;

import com.baidu.pyramid.runtime.service.ServiceFetcher;
import fe.fe.ddd.ddd.ad.fe.ad;
import fe.fe.mmm.g;
import fe.mmm.qw.k.i.de.qw;
import fe.mmm.qw.k.rg.de;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import java.util.concurrent.ConcurrentHashMap;

public class fe {
    public static final ConcurrentHashMap<de, ServiceFetcher<?>> qw = new ConcurrentHashMap<>();

    static {
        fe();
    }

    public static <T> void ad(de deVar, ServiceFetcher<T> serviceFetcher) {
        qw.put(deVar, serviceFetcher);
    }

    public static <T> void de(String str, String str2, Class<? extends ServiceFetcher<T>> cls) {
        try {
            ad(new de(str, str2), (ServiceFetcher) cls.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    public static void fe() {
        de("FetchJob", "report", ad.class);
        de("logsystem", "exceptionhandler", fe.fe.ddd.when.ad.qw.ad.class);
        de("mars.pay", "config", qw.class);
        de("mars.trade", "config", de.class);
        de(ImagePickerPlugin.METHOD_CALL_RETRIEVE, "upload", fe.fe.ddd.ddd.ad.fe.fe.class);
        de("ubc", "UBC", g.class);
        de("yaLog", "yaLogConfig", fe.fe.qqq.pf.qw.class);
    }

    public static <T> T qw(de deVar) {
        ServiceFetcher serviceFetcher = qw.get(deVar);
        if (serviceFetcher != null) {
            return serviceFetcher.getService();
        }
        return null;
    }
}
