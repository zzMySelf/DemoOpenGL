package org.chromium.support_lib_boundary.util;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;

public class BoundaryInterfaceReflectionUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    @RequiresApi(19)
    public static class InvocationHandlerWithDelegateGetter implements InvocationHandler {
        public final Object mDelegate;

        public InvocationHandlerWithDelegateGetter(@NonNull Object obj) {
            this.mDelegate = obj;
        }

        @NonNull
        public Object getDelegate() {
            return this.mDelegate;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return BoundaryInterfaceReflectionUtil.dupeMethod(method, this.mDelegate.getClass().getClassLoader()).invoke(this.mDelegate, objArr);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            } catch (ReflectiveOperationException e2) {
                throw new RuntimeException("Reflection failed for method " + method, e2);
            }
        }
    }

    @Nullable
    public static <T> T castToSuppLibClass(@NonNull Class<T> cls, @Nullable InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static boolean containsFeature(Collection<String> collection, String str) {
        if (!collection.contains(str)) {
            if (isDebuggable()) {
                if (collection.contains(str + Features.DEV_SUFFIX)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @RequiresApi(19)
    @Nullable
    public static InvocationHandler createInvocationHandlerFor(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return new InvocationHandlerWithDelegateGetter(obj);
    }

    @RequiresApi(19)
    @Nullable
    public static InvocationHandler[] createInvocationHandlersForArray(@Nullable Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[length];
        for (int i2 = 0; i2 < length; i2++) {
            invocationHandlerArr[i2] = createInvocationHandlerFor(objArr[i2]);
        }
        return invocationHandlerArr;
    }

    public static Method dupeMethod(Method method, ClassLoader classLoader) throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

    @Nullable
    public static Object getDelegateFromInvocationHandler(@Nullable InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return ((InvocationHandlerWithDelegateGetter) invocationHandler).getDelegate();
    }

    public static boolean instanceOfInOwnClassLoader(Object obj, String str) {
        try {
            return Class.forName(str, false, obj.getClass().getClassLoader()).isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isDebuggable() {
        return "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
    }

    public static boolean containsFeature(String[] strArr, String str) {
        return containsFeature((Collection<String>) Arrays.asList(strArr), str);
    }
}
