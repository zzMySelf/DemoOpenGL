package fe.fe.qqq;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class fe {

    public static abstract class qw {
        public qw() {
            new ConcurrentHashMap();
        }

        public abstract List<String> ad(long j, long j2, String str, String str2);

        public abstract String qw();
    }

    public static List<String> ad(long j, long j2, String str, String str2) {
        qw qw2 = ad.qw();
        if (qw2 != null) {
            return qw2.ad(j, j2, str, str2);
        }
        return new ArrayList();
    }

    public static String qw() {
        qw qw2 = ad.qw();
        if (qw2 == null) {
            return "";
        }
        String qw3 = qw2.qw();
        return !TextUtils.isEmpty(qw3) ? qw3 : "";
    }
}
