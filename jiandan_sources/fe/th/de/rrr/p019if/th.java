package fe.th.de.rrr.p019if;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: fe.th.de.rrr.if.th  reason: invalid package */
public class th<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final String f5307ad;

    /* renamed from: de  reason: collision with root package name */
    public final Class[] f5308de;
    public final Class<?> qw;

    public th(Class<?> cls, String str, Class... clsArr) {
        this.qw = cls;
        this.f5307ad = str;
        this.f5308de = clsArr;
    }

    public static Method ad(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object de(T t, Object... objArr) throws InvocationTargetException {
        Method qw2 = qw(t.getClass());
        if (qw2 != null) {
            try {
                return qw2.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + qw2);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f5307ad + " not supported for object " + t);
        }
    }

    public Object fe(T t, Object... objArr) throws InvocationTargetException {
        Method qw2 = qw(t.getClass());
        if (qw2 == null) {
            return null;
        }
        try {
            return qw2.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public final Method qw(Class<?> cls) {
        Class<?> cls2;
        String str = this.f5307ad;
        if (str == null) {
            return null;
        }
        Method ad2 = ad(cls, str, this.f5308de);
        if (ad2 == null || (cls2 = this.qw) == null || cls2.isAssignableFrom(ad2.getReturnType())) {
            return ad2;
        }
        return null;
    }

    public Object rg(T t, Object... objArr) {
        try {
            return fe(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object th(T t, Object... objArr) {
        try {
            return de(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public boolean yj(T t) {
        return qw(t.getClass()) != null;
    }
}
