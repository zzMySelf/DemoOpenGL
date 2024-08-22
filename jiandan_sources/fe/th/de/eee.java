package fe.th.de;

import com.baidu.apollon.statistics.a;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class eee {

    /* renamed from: ad  reason: collision with root package name */
    public static Class<?> f5151ad = null;

    /* renamed from: de  reason: collision with root package name */
    public static Method f5152de = null;
    public static volatile boolean qw = false;

    public static void ad(String str, List<String> list) {
        if (f5151ad == null || f5152de == null) {
            try {
                Class<?> cls = Class.forName(a.a);
                f5151ad = cls;
                f5152de = cls.getDeclaredMethod(a.d, new Class[]{String.class, Collection.class});
            } catch (Throwable unused) {
            }
        }
        Method method = f5152de;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{str, list});
            } catch (Exception unused2) {
            }
        }
    }

    public static void onEventWithValues(List<String> list) {
        ad(StatServiceEvent.NETWORK_STAT_HTTP2, list);
    }

    public static void qw(String str, ddd ddd, String str2, String str3) {
        if (qw) {
            try {
                ArrayList arrayList = new ArrayList();
                if (ddd == null || ddd.uk() == null || ddd.uk().d() == null) {
                    arrayList.add("");
                } else {
                    arrayList.add(ddd.uk().d().toString());
                }
                arrayList.add(str3);
                arrayList.add(str2);
                arrayList.add(str);
                onEventWithValues(arrayList);
            } catch (Exception unused) {
            }
        }
    }
}
