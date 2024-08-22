package rx.exceptions;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.common.reflect.ClassPath;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import p041if.fe.qw;
import p041if.uk.th;

public final class OnErrorThrowable extends RuntimeException {
    public static final long serialVersionUID = -569558213262703934L;
    public final boolean hasValue;
    public final Object value;

    public static class OnNextValue extends RuntimeException {
        public static final long serialVersionUID = -3454462756050397899L;
        public final Object value;

        public static final class qw {
            public static final Set<Class<?>> qw = qw();

            public static Set<Class<?>> qw() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + renderValue(obj));
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th2) {
                    obj = th2.getMessage();
                }
            }
            this.value = obj;
        }

        public static String renderValue(Object obj) {
            if (obj == null) {
                return StringUtil.NULL_STRING;
            }
            if (qw.qw.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String ad2 = th.de().ad().ad(obj);
            if (ad2 != null) {
                return ad2;
            }
            return obj.getClass().getName() + ClassPath.CLASS_FILE_NAME_EXTENSION;
        }

        public Object getValue() {
            return this.value;
        }
    }

    public OnErrorThrowable(Throwable th2) {
        super(th2);
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable th2, Object obj) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        Throwable ad2 = qw.ad(th2);
        if ((ad2 instanceof OnNextValue) && ((OnNextValue) ad2).getValue() == obj) {
            return th2;
        }
        qw.qw(th2, new OnNextValue(obj));
        return th2;
    }

    public static OnErrorThrowable from(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        Throwable ad2 = qw.ad(th2);
        if (ad2 instanceof OnNextValue) {
            return new OnErrorThrowable(th2, ((OnNextValue) ad2).getValue());
        }
        return new OnErrorThrowable(th2);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }

    public OnErrorThrowable(Throwable th2, Object obj) {
        super(th2);
        this.hasValue = true;
        if (!(obj instanceof Serializable)) {
            try {
                obj = String.valueOf(obj);
            } catch (Throwable th3) {
                obj = th3.getMessage();
            }
        }
        this.value = obj;
    }
}
