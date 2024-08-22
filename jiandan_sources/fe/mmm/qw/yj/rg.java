package fe.mmm.qw.yj;

import fe.mmm.qw.i.qw;
import java.util.concurrent.ConcurrentHashMap;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile rg f8722ad;
    public ConcurrentHashMap<String, Object> qw = new ConcurrentHashMap<>();

    public static rg ad() {
        if (f8722ad == null) {
            synchronized (de.class) {
                if (f8722ad == null) {
                    f8722ad = new rg();
                }
            }
        }
        return f8722ad;
    }

    public <T> T qw(String str, T t) {
        ConcurrentHashMap<String, Object> concurrentHashMap = this.qw;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return t;
        }
        try {
            return this.qw.get(str);
        } catch (ClassCastException e) {
            if (!qw.o()) {
                return t;
            }
            throw e;
        }
    }
}
