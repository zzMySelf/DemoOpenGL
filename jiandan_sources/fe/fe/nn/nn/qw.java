package fe.fe.nn.nn;

import android.content.Context;
import java.lang.reflect.Method;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public Class<?> f2249ad;

    /* renamed from: de  reason: collision with root package name */
    public Method f2250de;
    public Object qw;

    public final String qw(Context context, Method method) {
        Object obj = this.qw;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, new Object[]{context});
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
