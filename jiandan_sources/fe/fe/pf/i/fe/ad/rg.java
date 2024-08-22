package fe.fe.pf.i.fe.ad;

import android.content.Context;
import com.baidu.helios.ids.oid.brand.g;
import java.lang.reflect.Method;

public class rg {
    public static String qw(Context context, g.a aVar) {
        if (context == null) {
            aVar.qw(false, (String) null);
            return null;
        }
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            if (cls != null) {
                Object newInstance = cls.newInstance();
                Method method = cls.getMethod("getOAID", new Class[]{Context.class});
                method.setAccessible(true);
                if (!(newInstance == null || method == null)) {
                    String str = (String) method.invoke(newInstance, new Object[]{context});
                    aVar.qw(true, str);
                    return str;
                }
            }
        } catch (Throwable unused) {
            aVar.qw(false, (String) null);
        }
        return null;
    }
}
