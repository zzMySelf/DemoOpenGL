package fe.i.qw.ad;

import com.baidu.apollon.eventbus.f;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.eventbus.EventBusException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class th {
    public static Map<Class<?>, Method> qw = new HashMap();

    public Method qw(Class<?> cls) {
        Method method;
        synchronized (qw) {
            method = qw.get(cls);
        }
        if (method != null) {
            return method;
        }
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name = cls2.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                break;
            }
            Method[] methods = cls2.getMethods();
            int length = methods.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Method method2 = methods[i2];
                if (method2.getName().equals("onModuleEvent")) {
                    int modifiers = method2.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & f.a) == 0) {
                        Class<EventBus.Event>[] parameterTypes = method2.getParameterTypes();
                        if (parameterTypes.length == 1 && parameterTypes[0] == EventBus.Event.class) {
                            method = method2;
                            break;
                        }
                    }
                }
                i2++;
            }
        }
        if (method != null) {
            synchronized (qw) {
                qw.put(cls, method);
            }
            return method;
        }
        throw new EventBusException("Subscriber " + cls + " has no public methods called " + "onModuleEvent");
    }
}
