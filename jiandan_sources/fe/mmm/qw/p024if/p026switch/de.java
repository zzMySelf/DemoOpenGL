package fe.mmm.qw.p024if.p026switch;

import android.content.Context;
import com.tera.scan.flutter.route.IPageHandler;
import java.util.HashMap;
import java.util.Map;

/* renamed from: fe.mmm.qw.if.switch.de  reason: invalid package */
public class de {

    /* renamed from: ad  reason: collision with root package name */
    public static de f7955ad;
    public HashMap<String, IPageHandler> qw = new HashMap<>();

    public static de qw() {
        if (f7955ad == null) {
            synchronized (de.class) {
                if (f7955ad == null) {
                    f7955ad = new de();
                }
            }
        }
        return f7955ad;
    }

    public boolean ad(Context context, String str, Map map, int i2) {
        String str2 = str.split("\\?")[0];
        try {
            for (IPageHandler qw2 : this.qw.values()) {
                if (qw2.qw(context, str2, map, i2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void de(String str, IPageHandler iPageHandler) {
        this.qw.put(str, iPageHandler);
    }
}
