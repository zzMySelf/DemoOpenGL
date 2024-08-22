package fe.i.ad.yj;

import java.util.concurrent.ConcurrentHashMap;

public final class qw {
    public ConcurrentHashMap<String, Object> qw;

    public static class ad {
        public static qw qw = new qw();
    }

    public static Object ad(String str) {
        if (str == null) {
            return null;
        }
        return qw().qw.get(str);
    }

    public static void de(String str, Object obj) {
        if (str != null) {
            qw qw2 = qw();
            if (obj == null) {
                qw2.qw.remove(str);
            } else {
                qw2.qw.put(str, obj);
            }
        }
    }

    public static qw qw() {
        return ad.qw;
    }

    public qw() {
        this.qw = new ConcurrentHashMap<>();
    }
}
