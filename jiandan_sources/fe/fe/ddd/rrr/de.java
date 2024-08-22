package fe.fe.ddd.rrr;

import com.baidu.searchbox.widget.OnTranslucentListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class de implements InvocationHandler {

    /* renamed from: ad  reason: collision with root package name */
    public OnTranslucentListener f1570ad;

    public de(OnTranslucentListener onTranslucentListener) {
        this.f1570ad = onTranslucentListener;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (this.f1570ad == null) {
            return null;
        }
        try {
            this.f1570ad.onTranslucent(objArr[0].booleanValue());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            this.f1570ad.onTranslucent(false);
            return null;
        }
    }
}
