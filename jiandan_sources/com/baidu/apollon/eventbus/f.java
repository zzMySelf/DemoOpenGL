package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class f {
    public static final int a = 1032;
    public static Map<Class<?>, Method> b = new HashMap();

    public static void a() {
        synchronized (b) {
            b.clear();
        }
    }

    public Method a(Class<?> cls) {
        Method method;
        synchronized (b) {
            method = b.get(cls);
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
                    if ((modifiers & 1) != 0 && (modifiers & a) == 0) {
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
            synchronized (b) {
                b.put(cls, method);
            }
            return method;
        }
        throw new EventBusException("Subscriber " + cls + " has no public methods called " + "onModuleEvent");
    }
}
